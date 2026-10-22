package com.bytedance.crash;

import android.app.Application;
import android.content.Context;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.IoUtil;
import com.bytedance.crash.util.JSONUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TagService {
    private static final String IMPORT_TAG_DIR = "tags";
    private static final int MAX_COUNT = 5;
    private static final String TAG_DIR = "custom_tags";
    private static final Map<String, String> cacheImportMap = null;
    private static volatile File importTagsFile;
    private static ITagCacheService tagCacheService;
    private static volatile String tagPath;

    static {
        cacheImportMap = new ConcurrentHashMap();
    }

    public TagService() {
    }

    static /* synthetic */ void access$000() {
        initTagFile();
    }

    static /* synthetic */ String access$100() {
        return tagPath;
    }

    static /* synthetic */ ITagCacheService access$200() {
        return tagCacheService;
    }

    static /* synthetic */ void access$300(Map r2) {
        save((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"));
    }

    public static void addImportTag(String r1, String r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r2 != null) goto L7;
        removeImportTag(r1);
        return;
    L7:
        Map<String, String> r0 = cacheImportMap;
        r0.put(r1, r2);
        if (NpthCore.isInit() == true) goto L10;
        return;
    L10:
        final HashMap r3 = new HashMap(r0);
        DefaultWorkThread.post(new AnonymousClass4(r3));
    }

    public static void addImportTags(Map<? extends String, ? extends String> r2) {
        Map<? extends String, ? extends String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        return;
    L6:
        if (NpthCore.isInit() == true) goto L9;
        cacheImportMap.putAll(r3);
        return;
    L9:
        Map<String, String> r0 = cacheImportMap;
        r0.putAll(r3);
        final HashMap r4 = new HashMap(r0);
        DefaultWorkThread.post(new AnonymousClass6(r4));
    }

    public static void addTag(String r1, String r2, UserDataCenter r3) {
        if (tagCacheService == null) goto L5;
        saveTag(r1, r2);
        return;
    L5:
        r3.addCustomTag(r1, r2);
    }

    public static void addTags(Map<? extends String, ? extends String> r2, UserDataCenter r3) {
        Map<? extends String, ? extends String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L15;
        if (r4.isEmpty() == false) goto L7;
    L12:
        return;
    L7:
        if (tagCacheService == null) goto L9;
        saveTagsToFile(r4);     // Catch: Throwable -> L11
        goto L12
    L9:
        r3.addCustomTags(r4);     // Catch: Throwable -> L11
    L16:
        return;
    }

    public static void clean(File r7) {
        File[] r8 = r7.listFiles();
        if (r8 != null) goto L5;
        return;
    L5:
        int r0 = r8.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L21;
        File r3 = r8[r2];
        if (r3.isFile() == true) goto L19;
        File[] r4 = r3.listFiles();
        if (r4 == null) goto L20;
        if (r4.length <= 5) goto L27;
        Arrays.sort(r4);
        int r5 = 0;
    L17:
        if (r5 >= (r4.length - 5)) goto L20;
        FileUtils.deleteFile(r4[r5]);
        r5 = r5 + 1;
        goto L17
    L27:
        return;
    L20:
        r2 = r2 + 1;
        goto L6
    L19:
        FileUtils.deleteFile(r3);
        goto L20
    }

    public static void cleanTags() {
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) != null) goto L5;
        return;
    L5:
        clean(new File(Global.getRootDirectory(), TAG_DIR));
        clean(new File(Global.getRootDirectory(), IMPORT_TAG_DIR));
    }

    public static void dumpImportTags(JSONObject r4, final long r5, String r7) {
        if (App.isMainProcess((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r7) == false) goto L5;
        String r8 = "main";
    L6:
        File[] r6 = new File(new File(Global.getRootDirectory(), IMPORT_TAG_DIR), r8).listFiles(new AnonymousClass7(r5));
        if (r6 != null) goto L9;
        return;
    L9:
        if (r6.length < 1) goto L27;
        ObjectInputStream r9 = null;
        ObjectInputStream r10 = new ObjectInputStream(new FileInputStream(r6[0]));     // Catch: Throwable -> L20
        Map r11 = (Map) ZeusTransformUtils.preCheckCast(r10.readObject(), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r11 == null) goto L16;
        JSONUtils.jsonPutAll(r4, r11);     // Catch: Throwable -> L17
    L16:
        IoUtil.close(r10);
        return;
    L17:
        r9 = r10;
    L18:
        IoUtil.close(r9);
        return;
    L27:
        return;
    L5:
        r8 = r7.replaceAll(ParameterizedMessage.ERROR_MSG_SEPARATOR, "@");
        goto L6
    }

    public static Map<String, String> getImportTagMap() {
        return cacheImportMap;
    }

    public static ITagCacheService getTagCacheService() {
        return tagCacheService;
    }

    public static Map<String, String> getTags() {
        return tagCacheService.getAll(tagPath);
    }

    private static void initTagFile() {
        if (tagPath == null) goto L5;
        return;
    L5:
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
        return;
    L8:
        File r1 = new File(Global.getRootDirectory(), TAG_DIR);
        if (r1.exists() == true) goto L12;
        r1.mkdirs();
    L12:
        if (App.isMainProcess(r0) == false) goto L14;
        String r2 = "main";
    L15:
        File r3 = new File(r1, r2);
        if (r3.exists() == true) goto L18;
        r3.mkdirs();
    L18:
        File r4 = new File(r3, "tag_" + Global.getAppStartTime());
        if (r4.exists() == true) goto L21;
        r4.mkdirs();
    L21:
        tagPath = r4.getAbsolutePath();
        return;
    L14:
        r2 = App.getCurProcessName().replaceAll(ParameterizedMessage.ERROR_MSG_SEPARATOR, "@");
        goto L15
    }

    public static void packTags(JSONObject r6) {
        final long r1 = r6.optLong("app_start_time");     // Catch: Throwable -> L18
        String r3 = r6.optString("process_name");     // Catch: Throwable -> L18
        JSONObject r7 = r6.optJSONObject("filters");     // Catch: Throwable -> L18
        if (App.isMainProcess((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3) == false) goto L6;
        String r0 = "main";
    L7:
        File[] r2 = new File(new File(Global.getRootDirectory(), TAG_DIR), r0).listFiles(new AnonymousClass3(r1));     // Catch: Throwable -> L18
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.length < 1) goto L22;
        ITagCacheService r4 = tagCacheService;     // Catch: Throwable -> L18
        if (r4 == null) goto L23;
        Map<String, String> r5 = r4.getAll(r2[0].getAbsolutePath());     // Catch: Throwable -> L18
        if (r5 == null) goto L24;
        JSONUtils.jsonPutAll(r7, r5);     // Catch: Throwable -> L18
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L6:
        r0 = r3.replaceAll(ParameterizedMessage.ERROR_MSG_SEPARATOR, "@");     // Catch: Throwable -> L18
    }

    public static void remove(String r1, UserDataCenter r2) {
        if (tagCacheService == null) goto L5;
        saveTag(r1, null);
        return;
    L5:
        r2.removeCustomTag(r1);
    }

    public static void removeImportTag(String r2) {
        Map<String, String> r0 = cacheImportMap;
        if (r0.containsKey(r2) == true) goto L5;
        return;
    L5:
        r0.remove(r2);
        if (NpthCore.isInit() == true) goto L8;
        return;
    L8:
        final HashMap r3 = new HashMap(r0);
        DefaultWorkThread.post(new AnonymousClass5(r3));
    }

    public static void save() {
        Map<String, String> r0 = cacheImportMap;
        if (r0.isEmpty() == true) goto L6;
        save(r0);
        return;
    }

    private static void save(Map<String, String> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        ObjectOutputStream r0 = null;
        if (importTagsFile != null) goto L21;
        Application r1 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        if (r1 != null) goto L9;
        IoUtil.close(null);
        return;
    L9:
        File r2 = new File(Global.getRootDirectory(), IMPORT_TAG_DIR);     // Catch: Throwable -> L30
        if (r2.exists() == true) goto L13;
        r2.mkdirs();     // Catch: Throwable -> L30
    L13:
        if (App.isMainProcess(r1) == false) goto L15;
        String r3 = "main";
    L16:
        File r4 = new File(r2, r3);     // Catch: Throwable -> L30
        if (r4.exists() == true) goto L19;
        r4.mkdirs();     // Catch: Throwable -> L30
    L19:
        importTagsFile = new File(r4, "import_tag_" + NpthBus.getAppStartTime() + ".txt");     // Catch: Throwable -> L30
        goto L21
    L15:
        r3 = App.getCurProcessName().replaceAll(ParameterizedMessage.ERROR_MSG_SEPARATOR, "@");     // Catch: Throwable -> L30
    L21:
        if (importTagsFile != null) goto L24;
        IoUtil.close(null);
        return;
    L24:
        ObjectOutputStream r5 = new ObjectOutputStream(new FileOutputStream(importTagsFile));     // Catch: Throwable -> L30
        r5.writeObject(r7);     // Catch: Throwable -> L27
        IoUtil.close(r5);
        return;
    L27:
        r0 = r5;
    L28:
        IoUtil.close(r0);
    }

    private static void saveTag(final String r1, final String r2) {
        if (tagCacheService == null) goto L6;
        DefaultWorkThread.post(new AnonymousClass1(r2, r1));
        return;
    }

    private static void saveTagsToFile(Map<? extends String, ? extends String> r2) {
        final Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        if (tagCacheService == null) goto L6;
        DefaultWorkThread.post(new AnonymousClass2(r3));
        return;
    }

    public static void setTagCacheService(ITagCacheService r2) {
        tagCacheService = (ITagCacheService) ZeusTransformUtils.wrapperContextForParams(r2, ITagCacheService.class, "com.obric.memorydata.plugin");
    }

    public void clearImportTagsFile() {
        if (importTagsFile == null) goto L9;
        importTagsFile.delete();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }
}

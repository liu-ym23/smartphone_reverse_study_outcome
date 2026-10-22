package com.bytedance.crash;

import android.app.Application;
import android.content.Context;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.IoUtil;
import com.bytedance.crash.util.JSONUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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

    static /* synthetic */ void access$300(Map r10) {
        save(r10);
    }

    public static void addImportTag(String r10, String r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r11 != null) goto L7;
        removeImportTag(r10);
        return;
    L7:
        Map<String, String> r12 = cacheImportMap;
        r12.put(r10, r11);
        if (NpthCore.isInit() == true) goto L10;
        return;
    L10:
        final HashMap r13 = new HashMap(r12);
        DefaultWorkThread.post(new AnonymousClass4(r13));
    }

    public static void addImportTags(Map<? extends String, ? extends String> r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (NpthCore.isInit() == true) goto L8;
        cacheImportMap.putAll(r10);
        return;
    L8:
        Map<String, String> r11 = cacheImportMap;
        r11.putAll(r10);
        final HashMap r12 = new HashMap(r11);
        DefaultWorkThread.post(new AnonymousClass6(r12));
    }

    public static void addTag(String r10, String r11, UserDataCenter r12) {
        if (tagCacheService == null) goto L5;
        saveTag(r10, r11);
        return;
    L5:
        r12.addCustomTag(r10, r11);
    }

    public static void addTags(Map<? extends String, ? extends String> r10, UserDataCenter r11) {
        if (r10 == null) goto L14;
        if (r10.isEmpty() == false) goto L6;
    L11:
        return;
    L6:
        if (tagCacheService == null) goto L8;
        saveTagsToFile(r10);     // Catch: Throwable -> L10
        goto L11
    L8:
        r11.addCustomTags(r10);     // Catch: Throwable -> L10
    L15:
        return;
    }

    public static void clean(File r10) {
        File[] r11 = r10.listFiles();
        if (r11 != null) goto L5;
        return;
    L5:
        int r12 = r11.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L21;
        File r14 = r11[r13];
        if (r14.isFile() == true) goto L19;
        File[] r15 = r14.listFiles();
        if (r15 == null) goto L20;
        if (r15.length <= 5) goto L27;
        Arrays.sort(r15);
        int r16 = 0;
    L17:
        if (r16 >= (r15.length - 5)) goto L20;
        FileUtils.deleteFile(r15[r16]);
        r16 = r16 + 1;
        goto L17
    L27:
        return;
    L20:
        r13 = r13 + 1;
        goto L6
    L19:
        FileUtils.deleteFile(r14);
        goto L20
    }

    public static void cleanTags() {
        if (Global.getContext() != null) goto L5;
        return;
    L5:
        clean(new File(Global.getRootDirectory(), TAG_DIR));
        clean(new File(Global.getRootDirectory(), IMPORT_TAG_DIR));
    }

    public static void dumpImportTags(JSONObject r10, final long r11, String r12) {
        if (App.isMainProcess(Global.getContext(), r12) == false) goto L5;
        String r13 = "main";
    L6:
        File[] r14 = new File(new File(Global.getRootDirectory(), IMPORT_TAG_DIR), r13).listFiles(new AnonymousClass7(r11));
        if (r14 != null) goto L9;
        return;
    L9:
        if (r14.length < 1) goto L27;
        ObjectInputStream r15 = null;
        ObjectInputStream r16 = new ObjectInputStream(new FileInputStream(r14[0]));     // Catch: Throwable -> L20
        Map r17 = (Map) r16.readObject();     // Catch: Throwable -> L17
        if (r17 == null) goto L16;
        JSONUtils.jsonPutAll(r10, r17);     // Catch: Throwable -> L17
    L16:
        IoUtil.close(r16);
        return;
    L17:
        r15 = r16;
    L18:
        IoUtil.close(r15);
        return;
    L27:
        return;
    L5:
        r13 = r12.replaceAll(":", "@");
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
        Context r10 = Global.getContext();
        if (r10 != null) goto L8;
        return;
    L8:
        File r11 = new File(Global.getRootDirectory(), TAG_DIR);
        if (r11.exists() == true) goto L12;
        r11.mkdirs();
    L12:
        if (App.isMainProcess(r10) == false) goto L14;
        String r12 = "main";
    L15:
        File r13 = new File(r11, r12);
        if (r13.exists() == true) goto L18;
        r13.mkdirs();
    L18:
        File r14 = new File(r13, "tag_" + Global.getAppStartTime());
        if (r14.exists() == true) goto L21;
        r14.mkdirs();
    L21:
        tagPath = r14.getAbsolutePath();
        return;
    L14:
        r12 = App.getCurProcessName().replaceAll(":", "@");
        goto L15
    }

    public static void packTags(JSONObject r10) {
        final long r11 = r10.optLong("app_start_time");     // Catch: Throwable -> L17
        String r12 = r10.optString("process_name");     // Catch: Throwable -> L17
        JSONObject r13 = r10.optJSONObject("filters");     // Catch: Throwable -> L17
        if (App.isMainProcess(Global.getContext(), r12) == false) goto L5;
        String r14 = "main";
    L6:
        File[] r15 = new File(new File(Global.getRootDirectory(), TAG_DIR), r14).listFiles(new AnonymousClass3(r11));     // Catch: Throwable -> L17
        if (r15 != null) goto L9;
        return;
    L9:
        if (r15.length < 1) goto L21;
        ITagCacheService r16 = tagCacheService;     // Catch: Throwable -> L17
        if (r16 == null) goto L22;
        Map<String, String> r17 = r16.getAll(r15[0].getAbsolutePath());     // Catch: Throwable -> L17
        if (r17 == null) goto L23;
        JSONUtils.jsonPutAll(r13, r17);     // Catch: Throwable -> L17
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L5:
        r14 = r12.replaceAll(":", "@");     // Catch: Throwable -> L17
    }

    public static void remove(String r10, UserDataCenter r11) {
        if (tagCacheService == null) goto L5;
        saveTag(r10, null);
        return;
    L5:
        r11.removeCustomTag(r10);
    }

    public static void removeImportTag(String r10) {
        Map<String, String> r11 = cacheImportMap;
        if (r11.containsKey(r10) == true) goto L5;
        return;
    L5:
        r11.remove(r10);
        if (NpthCore.isInit() == true) goto L8;
        return;
    L8:
        final HashMap r12 = new HashMap(r11);
        DefaultWorkThread.post(new AnonymousClass5(r12));
    }

    public static void save() {
        Map<String, String> r10 = cacheImportMap;
        if (r10.isEmpty() == true) goto L6;
        save(r10);
        return;
    }

    private static void save(Map<String, String> r10) {
        ObjectOutputStream r11 = null;
        if (importTagsFile != null) goto L21;
        Application r12 = Global.getApplication();     // Catch: Throwable -> L30
        if (r12 != null) goto L9;
        IoUtil.close(null);
        return;
    L9:
        File r13 = new File(Global.getRootDirectory(), IMPORT_TAG_DIR);     // Catch: Throwable -> L30
        if (r13.exists() == true) goto L13;
        r13.mkdirs();     // Catch: Throwable -> L30
    L13:
        if (App.isMainProcess(r12) == false) goto L15;
        String r14 = "main";
    L16:
        File r15 = new File(r13, r14);     // Catch: Throwable -> L30
        if (r15.exists() == true) goto L19;
        r15.mkdirs();     // Catch: Throwable -> L30
    L19:
        importTagsFile = new File(r15, "import_tag_" + NpthBus.getAppStartTime() + ".txt");     // Catch: Throwable -> L30
        goto L21
    L15:
        r14 = App.getCurProcessName().replaceAll(":", "@");     // Catch: Throwable -> L30
    L21:
        if (importTagsFile != null) goto L24;
        IoUtil.close(null);
        return;
    L24:
        ObjectOutputStream r16 = new ObjectOutputStream(new FileOutputStream(importTagsFile));     // Catch: Throwable -> L30
        r16.writeObject(r10);     // Catch: Throwable -> L27
        IoUtil.close(r16);
        return;
    L27:
        r11 = r16;
    L28:
        IoUtil.close(r11);
    }

    private static void saveTag(final String r10, final String r11) {
        if (tagCacheService == null) goto L6;
        DefaultWorkThread.post(new AnonymousClass1(r11, r10));
        return;
    }

    private static void saveTagsToFile(final Map<? extends String, ? extends String> r10) {
        if (tagCacheService == null) goto L6;
        DefaultWorkThread.post(new AnonymousClass2(r10));
        return;
    }

    public static void setTagCacheService(ITagCacheService r10) {
        tagCacheService = r10;
    }

    public void clearImportTagsFile() {
        if (importTagsFile == null) goto L9;
        importTagsFile.delete();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }
}

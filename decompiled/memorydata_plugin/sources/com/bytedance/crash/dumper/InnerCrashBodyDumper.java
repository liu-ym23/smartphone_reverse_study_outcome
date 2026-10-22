package com.bytedance.crash.dumper;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.dumper.tools.JsonDumper;
import com.bytedance.crash.service.ICrashBodyExtensionDumper;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class InnerCrashBodyDumper implements ICrashBodyExtensionDumper {
    public static final String BYTEST_FILE = "bytest.json";
    public static final String PATCH_INFO = "patch_info";
    private final String PATCH_FILE_NAME;
    private ICommonParams params;

    public InnerCrashBodyDumper(ICommonParams r3) {
        ICommonParams r4 = (ICommonParams) ZeusTransformUtils.wrapperContextForParams(r3, ICommonParams.class, "com.obric.memorydata.plugin");
        this.PATCH_FILE_NAME = "patch_info.json";
        this.params = r4;
    }

    private void dumpPatchInfo(File r5) {
        List<String> r4 = this.params.getPatchInfo();     // Catch: Throwable -> L14
        if (r4 != null) goto L5;
        return;
    L5:
        JsonDumper r0 = new JsonDumper(new File(r5, "patch_info.json").getAbsolutePath());     // Catch: Throwable -> L14
        r0.arrayBegin();     // Catch: Throwable -> L14
        boolean r6 = false;
        Iterator<String> r7 = r4.iterator();     // Catch: Throwable -> L14
    L7:
        if (r7.hasNext() == false) goto L12;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r6 == false) goto L11;
        r0.next();     // Catch: Throwable -> L14
    L11:
        r0.append(r1);     // Catch: Throwable -> L14
        r6 = true;
        goto L7
    L12:
        r0.arrayEnd();     // Catch: Throwable -> L14
        r0.release();     // Catch: Throwable -> L14
        return;
    }

    private void loadPatchInfo(JSONObject r5) {
        ICommonParams r4 = this.params;     // Catch: Throwable -> L16
        if (r4 != null) goto L5;
        return;
    L5:
        List<String> r6 = r4.getPatchInfo();     // Catch: Throwable -> L16
        if (r6 != null) goto L8;
        return;
    L8:
        if (r6.isEmpty() == true) goto L21;
        JSONArray r0 = new JSONArray();     // Catch: Throwable -> L16
        Iterator<String> r7 = r6.iterator();     // Catch: Throwable -> L16
    L12:
        if (r7.hasNext() == false) goto L14;
        r0.put((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L16
        goto L12
    L14:
        r5.put(PATCH_INFO, r0);     // Catch: Throwable -> L16
        return;
    L21:
        return;
    }

    private void loadPatchInfo(JSONObject r2, File r3) {
        String r1 = FileSystemUtils.readUtf8File(new File(r3, "patch_info.json"));     // Catch: Exception -> L6
        if (r1 == null) goto L11;
        JSONUtils.put(r2, PATCH_INFO, new JSONArray(r1));     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        NpthLog.i(e);
    }

    @Override // com.bytedance.crash.service.ICrashBodyExtensionDumper
    public void dump(File r2) {
        dumpPatchInfo(r2);     // Catch: Exception -> L4
        BytestConfig.dump(new File(r2, BYTEST_FILE));     // Catch: Exception -> L4
        return;
    }

    @Override // com.bytedance.crash.service.ICrashBodyExtensionDumper
    public JSONObject load(CrashType r2) {
        if (r2 != CrashType.ENSURE) goto L6;
        JSONObject r3 = new JSONObject();
        loadPatchInfo(r3);
        JSONObject r1 = new JSONObject();
        BytestConfig.expandFilters(r1);
        JSONUtils.put(r3, "filters", r1);
        return r3;
    L6:
        return null;
    }

    @Override // com.bytedance.crash.service.ICrashBodyExtensionDumper
    public void load(JSONObject r2, JSONObject r3, File r4) {
        loadPatchInfo(r2, r4);
        JSONObject r1 = BytestConfig.expandFilters(new File(r4, BYTEST_FILE), r2);
        JSONObject r5 = r2.optJSONObject("header");
        if (r5 != null) goto L5;
        BytestConfig.load(r1, r3);
        return;
    L5:
        BytestConfig.load(r1, r5);
    }
}

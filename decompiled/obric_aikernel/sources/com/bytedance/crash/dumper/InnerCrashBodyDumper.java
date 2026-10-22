package com.bytedance.crash.dumper;

import androidx.annotation.NonNull;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.dumper.tools.JsonDumper;
import com.bytedance.crash.service.ICrashBodyExtensionDumper;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class InnerCrashBodyDumper implements ICrashBodyExtensionDumper {
    public static final String BYTEST_FILE = "bytest.json";
    public static final String PATCH_INFO = "patch_info";
    private final String PATCH_FILE_NAME;
    private ICommonParams params;

    public InnerCrashBodyDumper(ICommonParams r10) {
        this.PATCH_FILE_NAME = "patch_info.json";
        this.params = r10;
    }

    private void dumpPatchInfo(File r10) {
        List<String> r11 = this.params.getPatchInfo();     // Catch: Throwable -> L14
        if (r11 != null) goto L5;
        return;
    L5:
        JsonDumper r12 = new JsonDumper(new File(r10, "patch_info.json").getAbsolutePath());     // Catch: Throwable -> L14
        r12.arrayBegin();     // Catch: Throwable -> L14
        boolean r13 = false;
        Iterator<String> r14 = r11.iterator();     // Catch: Throwable -> L14
    L7:
        if (r14.hasNext() == false) goto L12;
        String r15 = r14.next();     // Catch: Throwable -> L14
        if (r13 == false) goto L11;
        r12.next();     // Catch: Throwable -> L14
    L11:
        r12.append(r15);     // Catch: Throwable -> L14
        r13 = true;
        goto L7
    L12:
        r12.arrayEnd();     // Catch: Throwable -> L14
        r12.release();     // Catch: Throwable -> L14
        return;
    }

    private void loadPatchInfo(JSONObject r10) {
        ICommonParams r11 = this.params;     // Catch: Throwable -> L16
        if (r11 != null) goto L5;
        return;
    L5:
        List<String> r12 = r11.getPatchInfo();     // Catch: Throwable -> L16
        if (r12 != null) goto L8;
        return;
    L8:
        if (r12.isEmpty() == true) goto L21;
        JSONArray r13 = new JSONArray();     // Catch: Throwable -> L16
        Iterator<String> r14 = r12.iterator();     // Catch: Throwable -> L16
    L12:
        if (r14.hasNext() == false) goto L14;
        r13.put(r14.next());     // Catch: Throwable -> L16
        goto L12
    L14:
        r10.put(PATCH_INFO, r13);     // Catch: Throwable -> L16
        return;
    L21:
        return;
    }

    private void loadPatchInfo(JSONObject r10, File r11) {
        String r12 = FileSystemUtils.readUtf8File(new File(r11, "patch_info.json"));     // Catch: Exception -> L6
        if (r12 == null) goto L11;
        JSONUtils.put(r10, PATCH_INFO, new JSONArray(r12));     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        NpthLog.i(e);
    }

    @Override // com.bytedance.crash.service.ICrashBodyExtensionDumper
    public void dump(@NonNull File r10) {
        dumpPatchInfo(r10);     // Catch: Exception -> L4
        BytestConfig.dump(new File(r10, BYTEST_FILE));     // Catch: Exception -> L4
        return;
    }

    @Override // com.bytedance.crash.service.ICrashBodyExtensionDumper
    public JSONObject load(CrashType r10) {
        if (r10 != CrashType.ENSURE) goto L6;
        JSONObject r11 = new JSONObject();
        loadPatchInfo(r11);
        JSONObject r12 = new JSONObject();
        BytestConfig.expandFilters(r12);
        JSONUtils.put(r11, "filters", r12);
        return r11;
    L6:
        return null;
    }

    @Override // com.bytedance.crash.service.ICrashBodyExtensionDumper
    public void load(@NonNull JSONObject r10, @NonNull JSONObject r11, @NonNull File r12) {
        loadPatchInfo(r10, r12);
        JSONObject r13 = BytestConfig.expandFilters(new File(r12, BYTEST_FILE), r10);
        JSONObject r14 = r10.optJSONObject("header");
        if (r14 != null) goto L5;
        BytestConfig.load(r13, r11);
        return;
    L5:
        BytestConfig.load(r13, r14);
    }
}

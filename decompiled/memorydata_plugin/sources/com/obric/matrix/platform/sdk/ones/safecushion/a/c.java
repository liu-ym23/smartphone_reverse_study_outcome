package com.obric.matrix.platform.sdk.ones.safecushion.a;

import android.content.Context;
import com.bytedance.crash.entity.Header;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0004J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u0004J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\u0004J \u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0017J\"\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0017J\b\u0010\u001e\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u001f\u001a\u00020\u000eJ*\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u00042\b\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/util/SafeCushionFileUtils;", "", "()V", "TAG", "", "createOrUpdateFile", "", "currentFile", "Ljava/io/File;", "updateFile", "createOrUpdateSafeCushionFile", "fileNamePrefix", "updateFileName", "deleteDir", "", "dir", "dirPath", "getCrashInfo", "Lorg/json/JSONObject;", "getExistCrashInfoDir", "getExistNormalInfoDir", "getNormalFile", "getNormalFileCount", "", "getSafeCushionFile", "getSafeCushionSpiltFileName", XSDatatype.FACET_LENGTH, "spiltIndex", "getSpiltFileName", "file", "getTempCrashInfoFile", "isRepairNotFinish", "saveCrashInfo", "crashType", "crashMsg", "threadName", "crashCount", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f8128a = null;

    static {
        f8128a = new c();
    }

    private c() {
    }

    public final File a() {
        File r0 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.matrix.platform.sdk.ones.safecushion.c.f8131a.a().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "safeCushionCrashInfo");
        if (r0.isDirectory() == true) goto L6;
        a(r0);
    L6:
        if (r0.exists() == true) goto L8;
        r0.mkdir();
    L8:
        return r0;
    }

    public final File a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "fileNamePrefix");
        File r2 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.matrix.platform.sdk.ones.safecushion.c.f8131a.a().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "safeCushionCrashInfo");     // Catch: Exception -> L24
        if (r2.exists() == true) goto L6;
    L26:
        return null;
    L6:
        if (r2.isDirectory() == false) goto L26;
        File[] r3 = r2.listFiles();     // Catch: Exception -> L24
        boolean r4 = true;
        if (r3 != null) goto L10;
    L16:
        if (r4 == true) goto L26;
        Intrinsics.checkNotNullExpressionValue(r3, "crashFiles");     // Catch: Exception -> L24
        int r5 = r3.length;     // Catch: Exception -> L24
        int r6 = 0;
    L18:
        if (r6 >= r5) goto L26;
        File r7 = r3[r6];     // Catch: Exception -> L24
        String r8 = r7.getName();     // Catch: Exception -> L24
        Intrinsics.checkNotNullExpressionValue(r8, "it.name");     // Catch: Exception -> L24
        if (StringsKt.startsWith$default(r8, r10, false, 2, null) == true) goto L21;
        r6 = r6 + 1;
        goto L18
    L21:
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("SafeCushionFileUtils", "getSafeModeFile: " + r7.getName(), null, 4, null);     // Catch: Exception -> L24
        return r7;
    L10:
        if (r3.length != 0) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == true) goto L16;
        r4 = false;
        goto L16
    L12:
        r9 = false;
    L24:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.d("SafeCushionFileUtils", "getSafeCushion: error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L26
    }

    public final String a(File r9, int r10, int r11) {
        if (r9 != null) goto L5;
    L10:
        return null;
    L5:
        if (r9.exists() == false) goto L10;
        String r12 = r9.getName();
        Intrinsics.checkNotNullExpressionValue(r12, "file.name");
        List r13 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"-"}, false, 0, 6, null);
        if (r13.size() != r10) goto L10;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.get(r11), String.class, "com.obric.memorydata.plugin");
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("SafeCushionFileUtils", "getSpiltFileName: " + r14, null, 4, null);
        return r14;
    }

    public final String a(String r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "fileNamePrefix");
        return a(a(r2), r3, r4);
    L5:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.d("SafeCushionFileUtils", "getSafeCushionSpiltFileName: " + e, null, 4, null);
        return null;
    }

    public final void a(File r2, File r3) {
        Intrinsics.checkNotNullParameter(r2, "currentFile");
        Intrinsics.checkNotNullParameter(r3, "updateFile");
        if (r2.renameTo(r3) == true) goto L6;
        a(r2);
        r3.createNewFile();
        return;
    }

    public final void a(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "fileNamePrefix");
        Intrinsics.checkNotNullParameter(r6, "updateFileName");
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("SafeCushionFileUtils", "createOrUpdateSafeCushionFile fileNamePrefix:" + r5 + ",updateFileName:" + r6, null, 4, null);     // Catch: Exception -> L8
        File r7 = a(r5);     // Catch: Exception -> L8
        File r1 = new File(a(), r6);     // Catch: Exception -> L8
        if (r7 == null) goto L6;
        a(r7, r1);     // Catch: Exception -> L8
    L11:
        return;
    L6:
        r1.createNewFile();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.d("SafeCushionFileUtils", "createOrUpdateSafeCushionFile: error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final void a(String r3, String r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "crashType");
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L7
        r0.put(Header.KEY_CRASH_TYPE, r3);     // Catch: Exception -> L7
        r0.put("crash_msg", r4);     // Catch: Exception -> L7
        r0.put("crash_count", r6);     // Catch: Exception -> L7
        r0.put("thread", r5);     // Catch: Exception -> L7
        r0.put("timestamp", String.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L7
        File r2 = a("crashInfo");     // Catch: Exception -> L7
        if (r2 == null) goto L12;
        String r7 = r0.toString();     // Catch: Exception -> L7
        Intrinsics.checkNotNullExpressionValue(r7, "jsonObject.toString()");     // Catch: Exception -> L7
        FilesKt.writeText$default(r2, r7, null, 2, null);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.d("SafeCushionFileUtils", "saveCrashInfo:error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final boolean a(File r7) {
        Intrinsics.checkNotNullParameter(r7, "dir");
        if (r7.isDirectory() == false) goto L15;
        String[] r0 = r7.list();
        if (r0 == null) goto L7;
        int r1 = r0.length;
        int r3 = 0;
    L9:
        if (r3 >= r1) goto L15;
        if (a(new File(r7, r0[r3])) == false) goto L12;
        r3 = r3 + 1;
        goto L9
    L12:
        return false;
    L7:
        return r7.delete();
    L15:
        return r7.delete();
    }
}

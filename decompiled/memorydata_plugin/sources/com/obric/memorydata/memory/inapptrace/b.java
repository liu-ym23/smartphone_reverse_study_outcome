package com.obric.memorydata.memory.inapptrace;

import android.content.Context;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.cc;
import com.obric.memorydata.memory.ui.settings.l;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0005J.\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005J\u0016\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0005J \u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\"\u0010 \u001a\u0004\u0018\u00010\u001e2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0005H\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010%\u001a\u00020\u001e2\b\b\u0002\u0010&\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/memorydata/memory/inapptrace/InAppEvidenceArchiveStore;", "", "<init>", "()V", "TAG", "", "ROOT_DIR_NAME", "TRACE_DIR_NAME", "METADATA_FILE_NAME", "TRACE_INDEX_FILE_NAME", "isEnabled", "", "setEnabled", "", "enabled", "rootPath", "clearLocalEvidence", "archiveObservation", "observationId", "", "screenshotTimestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "screenshotPath", "viewTreePath", "archiveTrace", "row", "Lcom/obric/memorydata/database/entity/InAppTraceUploadEntity;", "summary", "updateTraceIndex", "observationDir", "Ljava/io/File;", "destination", "copyEvidenceFile", "sourcePath", "destinationDir", "destinationBaseName", "findObservationDir", "rootDir", "create", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f10159a = null;

    static {
        f10159a = new b();
    }

    private b() {
    }

    private final File a(long r9) {
        String r10 = "observation_" + r9 + '_';
        File[] r2 = a(this, false, 1, null).listFiles();
        if (r2 == null) goto L19;
        int r3 = r2.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L15;
        File r5 = r2[r4];
        if (r5.isDirectory() == false) goto L11;
        String r6 = r5.getName();
        Intrinsics.checkNotNullExpressionValue(r6, "getName(...)");
        if (StringsKt.startsWith$default(r6, r10, false, 2, null) == false) goto L11;
        boolean r7 = true;
    L12:
        if (r7 == true) goto L16;
        r4 = r4 + 1;
    L16:
        if (r5 == null) goto L19;
        return r5;
    L11:
        r7 = false;
        goto L12
    L15:
        r5 = null;
    L19:
        return new File(a(this, false, 1, null), r10 + "unknown");
    }

    private final File a(long r5, long r7) {
        return new File(a(this, false, 1, null), "observation_" + r5 + '_' + r7);
    }

    static /* synthetic */ File a(b r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = true;
    L6:
        return r0.a(r1);
    }

    private final File a(String r9, File r10, String r11) {
        String r1 = null;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L6;
        r9 = null;
    L6:
        if (r9 == null) goto L23;
        File r8 = new File(r9);
        if (r8.isFile() == false) goto L10;
        File r2 = r8;
    L11:
        if (r2 == null) goto L23;
        String r12 = FilesKt.getExtension(r2);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L17;
        r12 = null;
    L17:
        if (r12 == null) goto L19;
        r1 = '.' + r12;
    L19:
        if (r1 != null) goto L21;
        r1 = "";
    L21:
        File r13 = new File(r10, r11 + r1);
        FilesKt.copyTo$default(r2, r13, true, 0, 4, null);
        return r13;
    L10:
        r2 = null;
    L23:
        return null;
    }

    private final File a(boolean r3) {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        File r0 = r2.getExternalFilesDir(null);
        if (r0 != null) goto L5;
        r0 = r2.getFilesDir();
    L5:
        File r4 = new File(r0, "in_app_evidence");
        if (r3 == false) goto L8;
        r4.mkdirs();
    L8:
        return r4;
    }

    private final void a(File r11, cc r12, File r13) {
        File r1 = new File(r11, "trace_index.json");
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L5
        b r10 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r15 = Result.m1421constructorimpl(new JSONArray(FilesKt.readText(r1, Charsets.UTF_8)));     // Catch: Throwable -> L5
    L7:
        JSONArray r16 = new JSONArray();
        if (Result.m1427isFailureimpl(r15) == false) goto L10;
        r15 = r16;
    L10:
        JSONArray r17 = (JSONArray) ZeusTransformUtils.preCheckCast(r15, JSONArray.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r17.length()), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r18, Collection.class) == true) goto L13;
    L15:
        Iterator r19 = r18.iterator();
    L17:
        if (r19.hasNext() == false) goto L26;
        JSONObject r3 = r17.optJSONObject(((IntIterator) ZeusTransformUtils.preCheckCast(r19, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());
        if (r3 != null) goto L21;
    L23:
        boolean r4 = false;
    L24:
        if (r4 == false) goto L17;
        r2 = true;
        goto L26
    L21:
        if (r3.optLong("trace_row_id") != r12.a()) goto L23;
        r4 = true;
    L26:
        if (r2 == true) goto L36;
        r17.put(new JSONObject().put("trace_row_id", r12.a()).put("file", "traces/" + r13.getName()).put("start_timestamp", r12.e()).put("end_timestamp", r12.f()).put("event_count", r12.g()).put("zip_size", r12.h()).put("sha256", r12.i()));
        String r110 = r17.toString(2);
        Intrinsics.checkNotNullExpressionValue(r110, "toString(...)");
        FilesKt.writeText(r1, r110, Charsets.UTF_8);
        return;
    L36:
        return;
    L13:
        if (((Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L15;
    L5:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void a(long r7, long r9, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r12, "screenshotPath");
        Intrinsics.checkNotNullParameter(r13, "viewTreePath");
        if (a() == true) goto L5;
        return;
    L5:
        if (r7 <= 0) goto L45;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L35
        b r6 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        File r2 = r6.a(r7, r9);     // Catch: Throwable -> L35
        r2.mkdirs();     // Catch: Throwable -> L35
        File r14 = r6.a(r12, r2, "screenshot");     // Catch: Throwable -> L35
        File r8 = r6.a(r13, r2, "viewtree");     // Catch: Throwable -> L35
        JSONObject r10 = new JSONObject().put("observation_id", r7).put("screenshot_timestamp", r9).put("package_name", r11);     // Catch: Throwable -> L35
        String r15 = null;
        if (r14 == null) goto L11;
        String r3 = r14.getName();     // Catch: Throwable -> L35
    L12:
        String r4 = "";
        if (r3 != null) goto L15;
        r3 = "";
    L15:
        JSONObject r16 = r10.put("screenshot_file", r3);     // Catch: Throwable -> L35
        if (r8 == null) goto L18;
        String r5 = r8.getName();     // Catch: Throwable -> L35
    L19:
        if (r5 != null) goto L21;
        r5 = "";
    L21:
        JSONObject r17 = r16.put("viewtree_file", r5).put("archived_at", System.currentTimeMillis());     // Catch: Throwable -> L35
        File r18 = new File(r2, "metadata.json");     // Catch: Throwable -> L35
        String r19 = r17.toString(2);     // Catch: Throwable -> L35
        Intrinsics.checkNotNullExpressionValue(r19, "toString(...)");     // Catch: Throwable -> L35
        FilesKt.writeText(r18, r19, Charsets.UTF_8);     // Catch: Throwable -> L35
        RunLog r20 = RunLog.INSTANCE;     // Catch: Throwable -> L35
        StringBuilder r110 = new StringBuilder().append("observation archived id=").append(r7).append(" pkg=").append(r11).append(" screenshot=");     // Catch: Throwable -> L35
        if (r14 == null) goto L24;
        String r111 = r14.getName();     // Catch: Throwable -> L35
    L25:
        if (r111 != null) goto L27;
        r111 = "";
    L27:
        StringBuilder r112 = r110.append(r111).append(" viewtree=");     // Catch: Throwable -> L35
        if (r8 == null) goto L30;
        r15 = r8.getName();     // Catch: Throwable -> L35
    L30:
        if (r15 == null) goto L33;
        r4 = r15;
    L33:
        r20.info("InAppEvidenceArchive", r112.append(r4).append(" dir=").append(r2.getAbsolutePath()).toString(), true);     // Catch: Throwable -> L35
        Object r21 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L35
    L37:
        Throwable r22 = Result.m1424exceptionOrNullimpl(r21);
        if (r22 == null) goto L44;
        RunLog.INSTANCE.error("InAppEvidenceArchive", "archive observation failed id=" + r7, r22);
        return;
    L44:
        return;
    L24:
        r111 = null;
        goto L25
    L18:
        r5 = null;
        goto L19
    L11:
        r3 = null;
    L35:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r21 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L37
    }

    public final void a(long r11, cc r13) {
        Intrinsics.checkNotNullParameter(r13, "row");
        if (a() == true) goto L5;
        return;
    L5:
        if (r11 <= 0) goto L27;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L18
        b r10 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        File r4 = new File(r13.d());     // Catch: Throwable -> L18
        if (r4.isFile() == true) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppEvidenceArchive", "trace archive skipped, source missing row=" + r13.a() + " path=" + r13.d(), null, 4, null);     // Catch: Throwable -> L18
        return;
    L11:
        File r2 = r10.a(r11);     // Catch: Throwable -> L18
        r2.mkdirs();     // Catch: Throwable -> L18
        File r5 = new File(r2, "traces");     // Catch: Throwable -> L18
        r5.mkdirs();     // Catch: Throwable -> L18
        File r9 = new File(r5, "trace_" + r13.a() + '_' + r4.getName());     // Catch: Throwable -> L18
        if (r9.isFile() == true) goto L14;
    L15:
        FilesKt.copyTo$default(r4, r9, true, 0, 4, null);     // Catch: Throwable -> L18
    L16:
        r10.a(r2, r13, r9);     // Catch: Throwable -> L18
        RunLog.INSTANCE.info("InAppEvidenceArchive", "trace archived observationId=" + r11 + " row=" + r13.a() + " file=" + r9.getAbsolutePath(), true);     // Catch: Throwable -> L18
        Object r12 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Throwable r14 = Result.m1424exceptionOrNullimpl(r12);
        if (r14 == null) goto L26;
        RunLog.INSTANCE.error("InAppEvidenceArchive", "archive trace failed observationId=" + r11 + " row=" + r13.a(), r14);
        return;
    L26:
        return;
    L14:
        if (r9.length() == r4.length()) goto L16;
    L18:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L20
    }

    public final boolean a() {
        if (AppContext.INSTANCE.isDebug() == true) goto L5;
    L7:
        return false;
    L5:
        if (l.f11479a.a().D() == false) goto L7;
        return true;
    }
}

package com.obric.memorydata.personalcontext.realcontext;

import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.capabilitykit.entity.enums.FileTypeEnum;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0014\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/personalcontext/realcontext/RCRecordingSearchUtils;", "", "<init>", "()V", "TAG", "", "RECORDER_PROVIDER_AUTHORITY", "RECORDING_STATUS_URI", "Landroid/net/Uri;", "COLUMN_ID", "COLUMN_STATUS", "COLUMN_DURATION", "COLUMN_TYPE", "COLUMN_CREATE_TIME", "KEY_STATUS", "KEY_RECORD_TYPE", "assistantQueryRecordingAudios", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "isRecorderProcessRunning", "", "queryRecordingStatusFromProvider", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12260a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Uri f12261b = null;

    static {
        f12260a = new b();
        Uri r0 = Uri.parse("content://com.obric.recorder.provider/recorderentry/recording_status");
        Intrinsics.checkNotNullExpressionValue(r0, "parse(...)");
        f12261b = r0;
    }

    private b() {
    }

    private final boolean b() {
        Object r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("activity");
        if (ZeusTransformUtils.instanceOf(r9, ActivityManager.class) == false) goto L5;
        ActivityManager r10 = (ActivityManager) ZeusTransformUtils.preCheckCast(r9, ActivityManager.class, "com.obric.memorydata.plugin");
    L7:
        if (r10 != null) goto L9;
        return false;
    L9:
        String r3 = AppInfo.Recorder.getPackageName();
        List<ActivityManager.RunningAppProcessInfo> r11 = r10.getRunningAppProcesses();
        if (r11 == null) goto L43;
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, Collection.class) == true) goto L14;
    L16:
        Iterator r13 = r12.iterator();
    L18:
        if (r13.hasNext() == false) goto L15;
        ActivityManager.RunningAppProcessInfo r5 = (ActivityManager.RunningAppProcessInfo) ZeusTransformUtils.preCheckCast(r13.next(), ActivityManager.RunningAppProcessInfo.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r5.processName, r3) == true) goto L32;
        String r6 = r5.processName;
        Intrinsics.checkNotNullExpressionValue(r6, "processName");
        if (StringsKt.startsWith$default(r6, r3 + ':', false, 2, null) == true) goto L32;
        String[] r7 = r5.pkgList;
        if (r7 != null) goto L26;
    L28:
        boolean r8 = false;
    L29:
        if (r8 == true) goto L32;
        boolean r14 = false;
    L33:
        if (r14 == false) goto L18;
        boolean r15 = true;
    L35:
        if (r15 == true) goto L37;
        return false;
    L37:
        return true;
    L26:
        if (ArraysKt.contains(r7, r3) != true) goto L28;
        r8 = true;
    L32:
        r14 = true;
    L15:
        r15 = false;
        goto L35
    L14:
        if (((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L16;
    L43:
        return false;
    L5:
        r10 = null;
        goto L7
    }

    private final IntentResult<AppEntity[]> c() {
        Cursor r0 = ZeusProviderTransform.query(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), f12261b, null, null, null, null, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L17;
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(r0, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r4 = (Cursor) ZeusTransformUtils.preCheckCast(r3, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
    L7:
        if (r4.moveToNext() == false) goto L9;
        String r7 = r4.getString(r4.getColumnIndexOrThrow(OaidModel.KEY_ID));     // Catch: Throwable -> L11
        String r5 = r4.getString(r4.getColumnIndexOrThrow("status"));     // Catch: Throwable -> L11
        int r14 = r4.getInt(r4.getColumnIndexOrThrow("duration"));     // Catch: Throwable -> L11
        String r15 = r4.getString(r4.getColumnIndexOrThrow("type"));     // Catch: Throwable -> L11
        long r10 = r4.getLong(r4.getColumnIndexOrThrow("create_time"));     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L11
        Uri r6 = Uri.EMPTY;     // Catch: Throwable -> L11
        Intrinsics.checkNotNullExpressionValue(r6, "EMPTY");     // Catch: Throwable -> L11
        RecordingEntity r13 = new RecordingEntity(r7, r10, r10, "", new FileEntity("", 0, 0, "", 0, r6, FileTypeEnum.FILE, null), r14);     // Catch: Throwable -> L11
        r13.set_packageName(AppInfo.Recorder.getPackageName());     // Catch: Throwable -> L11
        r13.setSummary("");     // Catch: Throwable -> L11
        r13.setRecordStatus(r5);     // Catch: Throwable -> L11
        r13.setRecordType(r15);     // Catch: Throwable -> L11
        r2.add(r13);     // Catch: Throwable -> L11
        goto L7
    L9:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r3, null);
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    L17:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RCRecordingSearchUtils", "assistantQueryRecordingAudios success, result size = " + r2.size(), false, 4, null);
        return new IntentResult(0, ((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).toArray(new AppEntity[0]), null, null, false, false, 256, null, null, null, 956, null);
    }

    private static final IntentResult d() {
        return f12260a.c();
    }

    /* JADX INFO: renamed from: lambda$1Hrb_4VzoehX5vpp2w_pifC-Q2Q, reason: not valid java name */
    public static /* synthetic */ IntentResult m1086lambda$1Hrb_4VzoehX5vpp2w_pifCQ2Q() {
        return d();
    }

    public final IntentResult<AppEntity[]> a() {
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RCRecordingSearchUtils", "assistantQueryRecordingAudios, doubao user not agree privacy", false, 4, null);
        return new IntentResult(0, new AppEntity[0], null, null, false, false, 256, null, null, null, 956, null);
    L7:
        if (com.obric.memorydata.utils.c.f13193a.a(AppInfo.Recorder.getPackageName()) == true) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RCRecordingSearchUtils", "assistantQueryRecordingAudios, recorder app not installed", false, 4, null);
        return new IntentResult(0, new AppEntity[0], null, null, false, false, 256, null, null, null, 956, null);
    L11:
        if (b() == true) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RCRecordingSearchUtils", "assistantQueryRecordingAudios, recorder process not running", false, 4, null);
        return new IntentResult(0, new AppEntity[0], null, null, false, false, 256, null, null, null, 956, null);
    L14:
        IntentResult<AppEntity[]> r0 = (IntentResult) ZeusTransformUtils.preCheckCast(y.a(null, $$Lambda$b$1Hrb_4VzoehX5vpp2w_pifCQ2Q.INSTANCE, 1, null), IntentResult.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L17;
        return r0;
    L17:
        return new IntentResult(0, new AppEntity[0], null, null, false, false, 256, null, null, null, 956, null);
    }
}

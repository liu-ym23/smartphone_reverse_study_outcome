package com.obric.memorydata.memory.c;

import android.app.BroadcastOptions;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.ak;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005J\u001f\u0010\u0017\u001a\u0002H\u0018\"\u0004\b\u0000\u0010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a¢\u0006\u0002\u0010\u001bJ\u0014\u0010\u0014\u001a\u00020\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001dJ\u0018\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0005J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0005H\u0002J\u0006\u0010'\u001a\u00020%J\u0010\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020#H\u0002J\u0010\u0010*\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/memorydata/memory/image/ImageMemoryStatusNotifier;", "", "<init>", "()V", "TAG", "", "batchLock", "batchSuccessHashes", "", "ACTION_IMAGE_MEMORY_STATUS_CHANGED", "ACTION_MEMORY_ACCOUNT_CHANGED", "EXTRA_IMAGE_HASH_LIST", "EXTRA_REASON", "EXTRA_TIMESTAMP", "EXTRA_USER_ID", "REASON_MEMORY_SUCCESS", "REASON_ACCOUNT_LOGIN", "REASON_ACCOUNT_LOGOUT", "targetPackages", "", "notifyImageMemorySuccess", "", "sourceImageHash", "collectBatchImageMemorySuccess", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "sourceImageHashes", "", "notifyAccountChanged", InfoRequestQPSOptTraceLogger.REASON, "userId", "sendToTrustedTargets", "baseIntent", "Landroid/content/Intent;", "isPackageInstalled", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "isShareIdentityEnabled", "sendBroadcast", MemorySourceLinkType.INTENT, "isTrustedTarget", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10081a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f10082b = null;
    private static volatile List<String> c;
    private static final Set<String> d = null;

    static {
        f10081a = new a();
        f10082b = new Object();
        d = SetsKt.setOf(new String[]{AppInfo.Gallery.getPackageName(), "com.android.camera", "com.obric.camera2"});
    }

    private a() {
    }

    private final void a(Intent r26) {
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder().append("sendToTrustedTargets begin, action=").append(r26.getAction()).append(", reason=");
        String r5 = r26.getStringExtra("com.aiassistant.memorydata.EXTRA_REASON");
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        StringBuilder r1 = r0.append(r5).append(", hashCount=");
        ArrayList<String> r6 = r26.getStringArrayListExtra("com.aiassistant.memorydata.EXTRA_IMAGE_HASH_LIST");
        if (r6 == null) goto L8;
        int r7 = r6.size();
    L9:
        StringBuilder r2 = r1.append(r7).append(", targets=");
        Set<String> r15 = d;
        IRunLog.a.a(r4, "ImageMemoryStatusNotifier", r2.append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, null, 63, null)).toString(), false, 4, null);
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r8.hasNext() == false) goto L32;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        a r3 = f10081a;
        if (r3.b(r9) == false) goto L14;
        if (r3.c(r9) == false) goto L17;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L27
        Intent r11 = new Intent(r26).setPackage(r9);     // Catch: Throwable -> L27
        Intrinsics.checkNotNullExpressionValue(r11, "setPackage(...)");     // Catch: Throwable -> L27
        r3.b(r11);     // Catch: Throwable -> L27
        IRunLog r16 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        StringBuilder r12 = new StringBuilder().append("send broadcast requested, action=").append(r26.getAction()).append(", reason=");     // Catch: Throwable -> L27
        String r13 = r26.getStringExtra("com.aiassistant.memorydata.EXTRA_REASON");     // Catch: Throwable -> L27
        if (r13 != null) goto L21;
        r13 = "";
    L21:
        StringBuilder r14 = r12.append(r13).append(", packageName=").append(r9).append(", hashCount=");     // Catch: Throwable -> L27
        ArrayList<String> r17 = r26.getStringArrayListExtra("com.aiassistant.memorydata.EXTRA_IMAGE_HASH_LIST");     // Catch: Throwable -> L27
        if (r17 == null) goto L24;
        int r18 = r17.size();     // Catch: Throwable -> L27
    L25:
        IRunLog.a.a(r16, "ImageMemoryStatusNotifier", r14.append(r18).append(", shareIdentity=").append(r3.a()).toString(), false, 4, null);     // Catch: Throwable -> L27
        Object r19 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        Throwable r20 = Result.m1424exceptionOrNullimpl(r19);
        if (r20 == null) goto L11;
        RunLog.INSTANCE.error("ImageMemoryStatusNotifier", "send broadcast request failed, action=" + r26.getAction() + ", packageName=" + r9, r20);
        goto L11
    L24:
        r18 = 0;
    L27:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r19 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L29
    L17:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ImageMemoryStatusNotifier", "skip untrusted broadcast target, action=" + r26.getAction() + ", packageName=" + r9, null, 4, null);
        goto L11
    L14:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ImageMemoryStatusNotifier", "skip unavailable broadcast target, action=" + r26.getAction() + ", packageName=" + r9, false, 4, null);
        goto L11
    L32:
        return;
    L8:
        r7 = 0;
        goto L9
    }

    private final void b(Intent r4) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (a() == false) goto L5;
        Bundle r3 = BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle();
        Intrinsics.checkNotNullExpressionValue(r3, "toBundle(...)");
        r0.sendBroadcast(r4, null, r3);
        return;
    L5:
        r0.sendBroadcast(r4);
    }

    private final boolean b(String r9) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        a r8 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getPackageInfo(r9, 0);     // Catch: Throwable -> L5
        Object r10 = Result.m1421constructorimpl(true);     // Catch: Throwable -> L5
    L7:
        Throwable r3 = Result.m1424exceptionOrNullimpl(r10);
        if (r3 == null) goto L16;
        if (ZeusTransformUtils.instanceOf(r3, PackageManager.NameNotFoundException.class) == false) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ImageMemoryStatusNotifier", "broadcast target not installed, packageName=" + r9, false, 4, null);
    L14:
        r10 = false;
        goto L16
    L13:
        RunLog.INSTANCE.warn("ImageMemoryStatusNotifier", "check broadcast target installed failed, packageName=" + r9, r3);
    L16:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final boolean c(String r13) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        a r12 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        boolean r14 = ak.f13164a.b(r13);     // Catch: Throwable -> L12
        boolean r3 = ak.f13164a.c(r13);     // Catch: Throwable -> L12
        boolean r4 = ak.f13164a.d(r13);     // Catch: Throwable -> L12
        if (r14 == true) goto L9;
        if (r3 == true) goto L9;
        if (r4 == true) goto L9;
        boolean r5 = false;
    L10:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ImageMemoryStatusNotifier", "check trusted target, packageName=" + r13 + ", isSelf=" + r14 + ", isPlatformSigned=" + r3 + ", isSystemApp=" + r4 + ", trusted=" + r5, false, 4, null);     // Catch: Throwable -> L12
        Object r15 = Result.m1421constructorimpl(Boolean.valueOf(r5));     // Catch: Throwable -> L12
    L14:
        Throwable r6 = Result.m1424exceptionOrNullimpl(r15);
        if (r6 == null) goto L18;
        RunLog.INSTANCE.warn("ImageMemoryStatusNotifier", "check trusted target failed, packageName=" + r13, r6);
    L18:
        if (Result.m1427isFailureimpl(r15) == false) goto L21;
        r15 = false;
    L21:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L9:
        r5 = true;
    L12:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public final <T> T a(Function0<? extends T> r10) {
        Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "block");
        Object r0 = f10082b;
        monitor-enter(r0);
    L51:
        th = move-exception;
        throw th;
    L5:
        if (c != null) goto L8;
        c = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L51
        boolean r1 = true;
    L9:
        monitor-exit(r0);
        if (r1 == true) goto L58;
        return (T) r11.invoke();
    L58:
        T r12 = (T) r11.invoke();
        monitor-enter(r0);
        List<String> r3 = c;     // Catch: Throwable -> L29
        if (r3 != null) goto L19;
        r3 = CollectionsKt.emptyList();     // Catch: Throwable -> L29
    L19:
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        Iterator<T> r6 = r4.iterator();     // Catch: Throwable -> L29
    L21:
        if (r6.hasNext() == false) goto L25;
        T r7 = r6.next();     // Catch: Throwable -> L29
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L21;
        r5.add(r7);     // Catch: Throwable -> L29
        goto L21
    L25:
        List<String> r2 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L29
        c = null;     // Catch: Throwable -> L29
        monitor-exit(r0);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ImageMemoryStatusNotifier", "publish batch image memory success, hashCount=" + r2.size(), false, 4, null);
        a(r2);
        return r12;
    L29:
        th = move-exception;
        throw th;
    L32:
        th = move-exception;
        monitor-enter(f10082b);
        List<String> r8 = c;     // Catch: Throwable -> L48
        if (r8 != null) goto L38;
        r8 = CollectionsKt.emptyList();     // Catch: Throwable -> L48
    L38:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L48
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L48
        Iterator<T> r14 = r9.iterator();     // Catch: Throwable -> L48
    L40:
        if (r14.hasNext() == false) goto L44;
        T r15 = r14.next();     // Catch: Throwable -> L48
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L40;
        r13.add(r15);     // Catch: Throwable -> L48
        goto L40
    L44:
        List<String> r16 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L48
        c = null;     // Catch: Throwable -> L48
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ImageMemoryStatusNotifier", "publish batch image memory success, hashCount=" + r16.size(), false, 4, null);
        a(r16);
        throw th;
    L48:
        th = move-exception;
        throw th;
    L8:
        r1 = false;
        goto L9
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sourceImageHash");
        a(CollectionsKt.listOf(r2));
    }

    public final void a(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, InfoRequestQPSOptTraceLogger.REASON);
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder().append("notifyAccountChanged, reason=").append(r8).append(", userId=");
        if (r9 != null) goto L5;
        String r2 = "";
    L6:
        IRunLog.a.a(r1, "ImageMemoryStatusNotifier", r0.append(r2).toString(), false, 4, null);
        Intent r3 = new Intent("com.aiassistant.memorydata.action.MEMORY_ACCOUNT_CHANGED");
        r3.putExtra("com.aiassistant.memorydata.EXTRA_REASON", r8);
        r3.putExtra("com.aiassistant.memorydata.EXTRA_TIMESTAMP", System.currentTimeMillis());
        if (r9 == null) goto L9;
        r3.putExtra("com.aiassistant.memorydata.EXTRA_USER_ID", r9);
    L9:
        a(r3);
        return;
    L5:
        r2 = r9;
        goto L6
    }

    public final void a(List<String> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "sourceImageHashes");
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r1 = r12.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        List r13 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r13.isEmpty() == false) goto L12;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ImageMemoryStatusNotifier", "notifyImageMemorySuccess skipped, empty hash list", null, 4, null);
        return;
    L12:
        Object r2 = f10082b;
        monitor-enter(r2);
        List<String> r3 = c;     // Catch: Throwable -> L28
        if (r3 == null) goto L22;
        r3.addAll((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L28
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        StringBuilder r8 = new StringBuilder().append("collect batch image memory success, hashCount=").append(r13.size()).append(", total=").append(r3.size()).append(", firstHash=");     // Catch: Throwable -> L28
        String r14 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r13), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        if (r14 != null) goto L19;
        r14 = "";
    L19:
        IRunLog.a.a(r4, "ImageMemoryStatusNotifier", r8.append(r14).toString(), false, 4, null);     // Catch: Throwable -> L28
        monitor-exit(r2);
        return;
    L22:
        monitor-exit(r2);
        IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r6 = new StringBuilder().append("notifyImageMemorySuccess, hashCount=").append(r13.size()).append(", firstHash=");
        String r7 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r13), String.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L26;
        r7 = "";
    L26:
        IRunLog.a.a(r5, "ImageMemoryStatusNotifier", r6.append(r7).toString(), false, 4, null);
        Intent r15 = new Intent("com.aiassistant.memorydata.action.IMAGE_MEMORY_STATUS_CHANGED");
        r15.putStringArrayListExtra("com.aiassistant.memorydata.EXTRA_IMAGE_HASH_LIST", new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")));
        r15.putExtra("com.aiassistant.memorydata.EXTRA_REASON", "memory_success");
        r15.putExtra("com.aiassistant.memorydata.EXTRA_TIMESTAMP", System.currentTimeMillis());
        a(r15);
        return;
    L28:
        th = move-exception;
        throw th;
    }

    public final boolean a() {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        return true;
    L5:
        return false;
    }
}

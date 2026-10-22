package com.obric.aikernel.res.task;

import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.res.update.MetadataRequestException;
import com.obric.aikernel.res.update.MetadataRequestFailureKind;
import com.obric.aikernel.res.update.PackageUpdater;
import com.obric.aikernel.res.update.UpdateResult;
import com.obric.aikernel.res.update.a;
import com.obric.aikernel.res.update.m;
import com.obric.aikernel.runtime.utils.d;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class UpdateDaemon {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PrmContext f5108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l0 f5109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PackageUpdater f5110c;

    public UpdateDaemon(PrmContext r10, l0 r11, PackageUpdater r12) {
        Intrinsics.checkNotNullParameter(r10, "ctx");
        Intrinsics.checkNotNullParameter(r11, "scope");
        Intrinsics.checkNotNullParameter(r12, "updater");
        this.f5108a = r10;
        this.f5109b = r11;
        this.f5110c = r12;
    }

    public static final /* synthetic */ Object a(UpdateDaemon r10, boolean r11, String r12, String r13, Continuation r14) {
        return r10.d(r11, r12, r13, r14);
    }

    public static final /* synthetic */ PrmContext b(UpdateDaemon r10) {
        return r10.f5108a;
    }

    public static final /* synthetic */ l0 c(UpdateDaemon r10) {
        return r10.f5109b;
    }

    private final Object d(boolean r26, String r27, String r28, Continuation<? super Unit> r29) {
        UpdateDaemon r10 = this;
        if ((r29 instanceof UpdateDaemon$forceUpdateAll$1) == false) goto L7;
        UpdateDaemon$forceUpdateAll$1 r11 = (UpdateDaemon$forceUpdateAll$1) r29;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        UpdateDaemon$forceUpdateAll$1 r13 = r11;
        Object r14 = r13.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r13.label;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        boolean r17 = r13.Z$0;
        String r18 = (String) r13.L$2;
        String r19 = (String) r13.L$1;
        UpdateDaemon r20 = (UpdateDaemon) r13.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
        boolean r21 = r17;
        String r110 = r18;
        String r111 = r19;
        r10 = r20;
    L82:
        m r22 = (m) r14;     // Catch: Throwable -> L54
        Collection<UpdateResult> r112 = r22.c().values();     // Catch: Throwable -> L54
        d.f5417a.i(PackageResourceManager.TAG, "UpdateDaemon: autoupdate result: " + CollectionsKt.joinToString$default(r112, null, null, null, 0, null, UpdateDaemon$forceUpdateAll$attemptResult$1$1$1.INSTANCE, 31, null));     // Catch: Throwable -> L54
        com.obric.aikernel.res.update.d r23 = r22.b();     // Catch: Throwable -> L54
        if (r23 == null) goto L34;
        boolean r24 = r23.d();     // Catch: Throwable -> L54
    L45:
        if (r23 == null) goto L47;
        MetadataRequestFailureKind r25 = r23.c();     // Catch: Throwable -> L54
    L48:
        int r30 = r22.a();     // Catch: Throwable -> L54
        if (r24 == false) goto L51;
        boolean r31 = true;
    L52:
        Object r32 = Result.m32constructorimpl(new a(r111, r21, r31, r25, r110, r30));     // Catch: Throwable -> L54
    L65:
        boolean r33 = r21;
        String r34 = r110;
        String r35 = r111;
        Throwable r36 = Result.m35exceptionOrNullimpl(r32);
        if (r36 == null) goto L77;
        d.f5417a.f(PackageResourceManager.TAG, "UpdateDaemon: autoupdate failed " + ExceptionsKt.stackTraceToString(r36));
        if ((r36 instanceof MetadataRequestException) == false) goto L71;
        MetadataRequestException r113 = (MetadataRequestException) r36;
    L72:
        if (r113 == null) goto L75;
        MetadataRequestFailureKind r37 = r113.getKind();
        if (r37 == null) goto L75;
    L76:
        r32 = new a(r35, r33, false, r37, r34, 0);
    L75:
        r37 = MetadataRequestFailureKind.UNKNOWN_TRANSPORT;
        goto L76
    L71:
        r113 = null;
    L77:
        a r38 = (a) r32;
        PackageResourceManager.PresmConfig.e r39 = r10.f5108a.getConfig().getUpdateListener();
        if (r39 == null) goto L81;
        r39.a(r38);
    L81:
        return Unit.INSTANCE;
    L51:
        r31 = false;
        goto L52
    L47:
        r25 = null;
        goto L48
    L34:
        Collection<UpdateResult> r40 = r22.c().values();     // Catch: Throwable -> L54
        if ((r40 instanceof Collection) == true) goto L37;
    L39:
        Iterator<T> r41 = r40.iterator();     // Catch: Throwable -> L54
    L41:
        if (r41.hasNext() == false) goto L38;
        if (((UpdateResult) r41.next()).getSuccess() == true) goto L41;
        r24 = false;
    L38:
        r24 = true;
        goto L45
    L37:
        if (r40.isEmpty() == false) goto L39;
    L54:
        th = th;
    L64:
        Result.Companion r42 = Result.Companion;
        r32 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L14:
        th = th;
        r21 = r17;
        r110 = r18;
        r111 = r19;
        r10 = r20;
        goto L64
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L60
        PackageUpdater r44 = r10.f5110c;     // Catch: Throwable -> L60
        List<String> r45 = r10.f5108a.getMetadataCtrl$resource_manager_release().o();     // Catch: Throwable -> L60
        int r114 = 0;
        boolean r115 = true;
        boolean r116 = true;
        boolean r210 = false;
        if (r26 == false) goto L22;
        boolean r211 = true;
    L23:
        PackageUpdater.b r46 = new PackageUpdater.b(r27, r114, r115, r116, r210, r211, false, 82, null);     // Catch: Throwable -> L60
        r13.L$0 = r10;     // Catch: Throwable -> L60
        r111 = r27;
        r13.L$1 = r111;     // Catch: Throwable -> L58
        r110 = r28;
        r13.L$2 = r110;     // Catch: Throwable -> L56
        r13.Z$0 = r26;     // Catch: Throwable -> L56
        r13.label = 1;     // Catch: Throwable -> L56
        r14 = PackageUpdater.B(r44, r45, r46, null, r13, 4, null);     // Catch: Throwable -> L56
        if (r14 != r15) goto L30;
        return r15;
    L30:
        r21 = r26;
    L56:
        th = th;
    L63:
        r21 = r26;
    L58:
        th = th;
    L62:
        r110 = r28;
        goto L63
    L22:
        r211 = false;
    L60:
        th = th;
        r111 = r27;
    L7:
        r11 = new UpdateDaemon$forceUpdateAll$1(r10, r29);
        goto L8
    }

    static /* synthetic */ Object e(UpdateDaemon r10, boolean r11, String r12, String r13, Continuation r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = ":autoupdate";
    L6:
        return r10.d(r11, r12, r13, r14);
    }

    public final void f() {
        h.d(this.f5109b, null, null, new UpdateDaemon$init$1(this, null), 3, null);
    }
}

package com.larus.drive.biz.impl.view.space;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceEnterContext;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.drive.biz.api.DriveEnterContext;
import com.larus.drive.biz.impl.databinding.LarusFragmentDriveOfficeSpaceHostBinding;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.biz.impl.view.space.DriveOfficeSpaceHostFragment$loadOfficeSpaceFragment$1", f = "DriveOfficeSpaceHostFragment.kt", i = {0}, l = {326}, m = "invokeSuspend", n = {"officeSdkService"}, s = {"L$0"})
public final class DriveOfficeSpaceHostFragment$loadOfficeSpaceFragment$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $forceReload;
    final /* synthetic */ long $forceReloadClickStartMs;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    final /* synthetic */ DriveOfficeSpaceHostFragment this$0;

    public DriveOfficeSpaceHostFragment$loadOfficeSpaceFragment$1(DriveOfficeSpaceHostFragment r1, boolean r2, long r3, Continuation<? super DriveOfficeSpaceHostFragment$loadOfficeSpaceFragment$1> r5) {
        this.this$0 = r1;
        this.$forceReload = r2;
        this.$forceReloadClickStartMs = r3;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        DriveOfficeSpaceHostFragment$loadOfficeSpaceFragment$1 r6 = new DriveOfficeSpaceHostFragment$loadOfficeSpaceFragment$1(this.this$0, this.$forceReload, this.$forceReloadClickStartMs, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r110) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        String r4 = null;
        if (r3 == 0) goto L10;
        if (r3 != 1) goto L9;
        long r5 = this.J$0;
        boolean r7 = this.Z$0;
        DriveOfficeSpaceHostFragment r8 = (DriveOfficeSpaceHostFragment) this.L$1;
        IOfficeSdkServiceV2 r9 = (IOfficeSdkServiceV2) this.L$0;
        ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L33
        long r10 = r5;
        Object r6 = r110;
    L18:
        ik5.a r11 = (ik5.a) r6;     // Catch: Throwable -> L33
        if (r11 == null) goto L32;
        FLogger r12 = FLogger.a;     // Catch: Throwable -> L33
        r12.i("DriveOfficeSpaceHost", "Office sdk ready: " + r11);     // Catch: Throwable -> L33
        gk5.e r0 = r9.q0();     // Catch: Throwable -> L33
        if (r0 == null) goto L30;
        com.bytedance.ee.bear.office.export.space.a r1 = r0.e7();     // Catch: Throwable -> L33
        if (r1 == null) goto L30;
        WeakReference<DriveOfficeSpaceHostFragment> r13 = DriveOfficeSpaceHostFragment.w;     // Catch: Throwable -> L33
        r8.getClass();     // Catch: Throwable -> L33
        r8.p = new q(r8);     // Catch: Throwable -> L33
        if (r7 == false) goto L27;
    L26:
        long r14 = r10;
        r12.i("DriveOfficeSpaceHost", "office_upload_recovery_trace flow_create_office_space_fragment begin");     // Catch: Throwable -> L33
        int r15 = g.a;     // Catch: Throwable -> L33
        Object r16 = Result.constructor-impl(r1.c(g.a(r8.aa0()), r8.p, new OfficeSpaceEnterContext(((DriveEnterContext) r8.u.getValue()).getEnterTraceId(), r14, ((DriveEnterContext) r8.u.getValue()).getEnterFrom(), ((DriveEnterContext) r8.u.getValue()).getPreloadRequestKeyHash())));     // Catch: Throwable -> L33
    L35:
        DriveOfficeSpaceHostFragment r17 = this.this$0;
        if (Result.isSuccess-impl(r16) == false) goto L61;
        Fragment r18 = (Fragment) r16;
        if (r17.isAdded() == false) goto L61;
        if (r17.j == null) goto L61;
        FLogger r20 = FLogger.a;
        r20.i("DriveOfficeSpaceHost", "office_upload_recovery_trace flow_create_office_space_fragment success fragment=".concat(r18.getClass().getName()));
        Fragment r21 = r17.getChildFragmentManager().findFragmentByTag("drive_office_space_child");
        if (r21 == null) goto L46;
        if (r21 != r18) goto L46;
        r20.i("DriveOfficeSpaceHost", "office_upload_recovery_trace flow_attach_content_skip reason=same_fragment");
        r17.m = true;
    L60:
        r17.ga0(DriveOfficeSpaceHostFragment.OfficeSpaceLoadState.SUCCESS);
    L46:
        r17.m = true;
        StringBuilder r22 = new StringBuilder("office_upload_recovery_trace flow_attach_content replace existing=");
        if (r21 == null) goto L49;
        r4 = r21.getClass().getName();
    L49:
        r22.append(r4);
        r22.append(" new=");
        r22.append(r18.getClass().getName());
        r20.i("DriveOfficeSpaceHost", r22.toString());
        FragmentTransaction r23 = r17.getChildFragmentManager().beginTransaction();
        if (r21 == null) goto L52;
        r23.remove(r21);
    L52:
        LarusFragmentDriveOfficeSpaceHostBinding r24 = r17.j;
        Intrinsics.checkNotNull(r24);
        int r25 = r24.b.getId();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r23, r18, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "drive_office_space_child", r25) == true) goto L57;
        r23.replace(r25, r18, "drive_office_space_child");
    L57:
        if (r17.getChildFragmentManager().isStateSaved() == false) goto L59;
        r23.commitAllowingStateLoss();
        goto L60
    L59:
        r23.commitNowAllowingStateLoss();
    L61:
        DriveOfficeSpaceHostFragment r26 = this.this$0;
        Throwable r27 = Result.exceptionOrNull-impl(r16);
        if (r27 == null) goto L72;
        if ((r27 instanceof CancellationException) == true) goto L72;
        FLogger.a.e("DriveOfficeSpaceHost", "loadOfficeSpaceFragment failed", r27);
        if (r26.isAdded() == false) goto L72;
        if (r26.j == null) goto L72;
        r26.ga0(DriveOfficeSpaceHostFragment.OfficeSpaceLoadState.FAILED);
    L72:
        return Unit.INSTANCE;
    L27:
        r10 = ((DriveEnterContext) r8.u.getValue()).getClickStartMs();     // Catch: Throwable -> L33
    L30:
        throw new IllegalStateException("office space sdk unavailable".toString());     // Catch: Throwable -> L33
    L32:
        throw new IllegalStateException("office docs sdk not ready".toString());     // Catch: Throwable -> L33
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r110);
        CoroutineScope r28 = (CoroutineScope) this.L$0;
        r9 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        r8 = this.this$0;
        r7 = this.$forceReload;
        r10 = this.$forceReloadClickStartMs;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L33
        if (r9 == null) goto L14;
        IOfficeSdkServiceV2.a.b(r9, false, null, 7);     // Catch: Throwable -> L33
    L14:
        if (r9 == null) goto L32;
        this.L$0 = r9;     // Catch: Throwable -> L33
        this.L$1 = r8;     // Catch: Throwable -> L33
        this.Z$0 = r7;     // Catch: Throwable -> L33
        this.J$0 = r10;     // Catch: Throwable -> L33
        this.label = 1;     // Catch: Throwable -> L33
        r6 = r9.o0(DoraObricDeviceHomeViewModel.SCAN_TIMEOUT_MS, this);     // Catch: Throwable -> L33
        if (r6 != r2) goto L18;
        return r2;
    L33:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    }
}

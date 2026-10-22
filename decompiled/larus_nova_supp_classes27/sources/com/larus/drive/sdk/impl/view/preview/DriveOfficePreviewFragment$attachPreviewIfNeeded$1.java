package com.larus.drive.sdk.impl.view.preview;

import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.drive.preview.DrivePreviewOpenRequest;
import com.larus.drive.sdk.impl.databinding.LarusFragmentDriveOfficePreviewBinding;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.view.preview.DriveOfficePreviewFragment$attachPreviewIfNeeded$1", f = "DriveOfficePreviewFragment.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
final class DriveOfficePreviewFragment$attachPreviewIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DrivePreviewOpenRequest $request;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DriveOfficePreviewFragment this$0;

    public DriveOfficePreviewFragment$attachPreviewIfNeeded$1(DriveOfficePreviewFragment r1, DrivePreviewOpenRequest r2, Continuation<? super DriveOfficePreviewFragment$attachPreviewIfNeeded$1> r3) {
        this.this$0 = r1;
        this.$request = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        DriveOfficePreviewFragment$attachPreviewIfNeeded$1 r0 = new DriveOfficePreviewFragment$attachPreviewIfNeeded$1(this.this$0, this.$request, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L15
    L13:
        Object r7 = Result.constructor-impl((Fragment) r6);     // Catch: Throwable -> L15
    L17:
        final DriveOfficePreviewFragment r2 = this.this$0;
        if (Result.isSuccess-impl(r7) == false) goto L30;
        Fragment r3 = (Fragment) r7;
        LarusFragmentDriveOfficePreviewBinding r4 = r2.d;
        if (r4 == null) goto L30;
        FrameLayout r5 = r4.b;
        if (r5 == null) goto L30;
        if (r2.isAdded() == false) goto L30;
        FragmentTransaction r8 = INVOKEVIRTUAL_com_larus_drive_sdk_impl_view_preview_DriveOfficePreviewFragment$attachPreviewIfNeeded$1_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(r2.getChildFragmentManager().beginTransaction(), r5.getId(), r3, "drive_office_preview_content");
        if (r2.getChildFragmentManager().isStateSaved() == false) goto L29;
        Boxing.boxInt(r8.runOnCommit(new d(r2)).commitAllowingStateLoss());
        goto L30
    L29:
        r8.commitNowAllowingStateLoss();
        r2.U90();
    L30:
        DriveOfficePreviewFragment r9 = this.this$0;
        Throwable r10 = Result.exceptionOrNull-impl(r7);
        if (r10 == null) goto L36;
        if ((r10 instanceof CancellationException) == true) goto L36;
        FLogger.a.e("DriveOfficePreview", "attach preview failed", r10);
        int r11 = DriveOfficePreviewFragment.l;
        r9.T90();
    L36:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
        CoroutineScope r12 = (CoroutineScope) this.L$0;
        DriveOfficePreviewFragment r13 = this.this$0;
        DrivePreviewOpenRequest r14 = this.$request;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r6 = DriveOfficePreviewFragment.S90(r13, r14, this);     // Catch: Throwable -> L15
        if (r6 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_larus_drive_sdk_impl_view_preview_DriveOfficePreviewFragment$attachPreviewIfNeeded$1_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r1, int r2, Fragment r3, String r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r4, r2) == false) goto L6;
        return r1;
    L6:
        return r1.replace(r2, r3, r4);
    }
}

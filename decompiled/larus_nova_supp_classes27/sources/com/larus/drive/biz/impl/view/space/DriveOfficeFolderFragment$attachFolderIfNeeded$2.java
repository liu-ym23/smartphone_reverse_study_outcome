package com.larus.drive.biz.impl.view.space;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.office.export.space.OfficeFolderPageRequest;
import com.larus.drive.biz.impl.databinding.LarusFragmentDriveOfficeFolderBinding;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
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
@DebugMetadata(c = "com.larus.drive.biz.impl.view.space.DriveOfficeFolderFragment$attachFolderIfNeeded$2", f = "DriveOfficeFolderFragment.kt", i = {}, l = {507}, m = "invokeSuspend", n = {}, s = {})
final class DriveOfficeFolderFragment$attachFolderIfNeeded$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OfficeFolderPageRequest $request;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DriveOfficeFolderFragment this$0;

    public DriveOfficeFolderFragment$attachFolderIfNeeded$2(DriveOfficeFolderFragment r1, OfficeFolderPageRequest r2, Continuation<? super DriveOfficeFolderFragment$attachFolderIfNeeded$2> r3) {
        this.this$0 = r1;
        this.$request = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        DriveOfficeFolderFragment$attachFolderIfNeeded$2 r0 = new DriveOfficeFolderFragment$attachFolderIfNeeded$2(this.this$0, this.$request, r5);
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
        DriveOfficeFolderFragment r2 = this.this$0;
        if (Result.isSuccess-impl(r7) == false) goto L40;
        Fragment r3 = (Fragment) r7;
        LarusFragmentDriveOfficeFolderBinding r4 = r2.d;
        if (r4 == null) goto L40;
        FrameLayout r5 = r4.b;
        if (r5 == null) goto L40;
        ViewGroup.LayoutParams r8 = r5.getLayoutParams();
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L27;
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8;
    L28:
        if (r9 == null) goto L35;
        FragmentActivity r10 = r2.getActivity();
        if (r10 == null) goto L32;
        int r11 = u.c(r10);
    L33:
        r9.topMargin = r11;
        r5.setLayoutParams(r9);
        goto L35
    L32:
        r11 = 0;
    L35:
        if (r2.isAdded() == false) goto L40;
        FragmentTransaction r12 = INVOKEVIRTUAL_com_larus_drive_biz_impl_view_space_DriveOfficeFolderFragment$attachFolderIfNeeded$2_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(r2.getChildFragmentManager().beginTransaction(), r5.getId(), r3, "drive_office_folder_content");
        if (r2.getChildFragmentManager().isStateSaved() == false) goto L39;
        Boxing.boxInt(r12.commitAllowingStateLoss());
        goto L40
    L39:
        r12.commitNowAllowingStateLoss();
        goto L40
    L27:
        r9 = null;
    L40:
        Throwable r13 = Result.exceptionOrNull-impl(r7);
        if (r13 == null) goto L46;
        if ((r13 instanceof CancellationException) == true) goto L46;
        FLogger.a.e("DriveOfficeFolder", "attach office folder failed", r13);
    L46:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        DriveOfficeFolderFragment r15 = this.this$0;
        OfficeFolderPageRequest r16 = this.$request;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r6 = DriveOfficeFolderFragment.S90(r15, r16, this);     // Catch: Throwable -> L15
        if (r6 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_larus_drive_biz_impl_view_space_DriveOfficeFolderFragment$attachFolderIfNeeded$2_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r1, int r2, Fragment r3, String r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r4, r2) == false) goto L6;
        return r1;
    L6:
        return r1.replace(r2, r3, r4);
    }
}

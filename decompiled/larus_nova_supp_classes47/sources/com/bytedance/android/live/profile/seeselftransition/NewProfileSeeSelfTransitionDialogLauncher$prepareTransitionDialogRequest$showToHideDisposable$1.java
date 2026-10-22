package com.bytedance.android.live.profile.seeselftransition;

import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.profile.p000enum.ProfileMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/bytedance/android/live/profile/enum/ProfileMode;", "p1", "Lcom/bytedance/android/live/profile/seeselftransition/b;", "p2", "Landroidx/fragment/app/FragmentManager;", "p3", "", "invoke", "(Lcom/bytedance/android/live/profile/enum/ProfileMode;Lcom/bytedance/android/live/profile/seeselftransition/b;Landroidx/fragment/app/FragmentManager;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class NewProfileSeeSelfTransitionDialogLauncher$prepareTransitionDialogRequest$showToHideDisposable$1 extends FunctionReferenceImpl implements Function3<ProfileMode, b, FragmentManager, Unit> {
    public NewProfileSeeSelfTransitionDialogLauncher$prepareTransitionDialogRequest$showToHideDisposable$1(NewProfileSeeSelfTransitionDialogLauncher r8) {
        super(3, r8, NewProfileSeeSelfTransitionDialogLauncher.class, "onDelegateDialogShow", "onDelegateDialogShow(Lcom/bytedance/android/live/profile/enum/ProfileMode;Lcom/bytedance/android/live/profile/seeselftransition/ITransitionDialogFragment;Landroidx/fragment/app/FragmentManager;)V", 0);
    }

    public final void invoke(ProfileMode r2, b r3, FragmentManager r4) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        NewProfileSeeSelfTransitionDialogLauncher.a((NewProfileSeeSelfTransitionDialogLauncher) ((CallableReference) this).receiver, r2, r3, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((ProfileMode) r1, (b) r2, (FragmentManager) r3);
        return Unit.INSTANCE;
    }
}

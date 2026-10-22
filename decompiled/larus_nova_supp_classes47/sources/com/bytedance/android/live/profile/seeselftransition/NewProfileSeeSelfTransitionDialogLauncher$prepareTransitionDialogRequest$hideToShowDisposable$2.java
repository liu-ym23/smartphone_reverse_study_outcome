package com.bytedance.android.live.profile.seeselftransition;

import com.bytedance.android.live.profile.p000enum.ProfileMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/live/profile/enum/ProfileMode;", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class NewProfileSeeSelfTransitionDialogLauncher$prepareTransitionDialogRequest$hideToShowDisposable$2 extends FunctionReferenceImpl implements Function1<ProfileMode, Unit> {
    public NewProfileSeeSelfTransitionDialogLauncher$prepareTransitionDialogRequest$hideToShowDisposable$2(NewProfileSeeSelfTransitionDialogLauncher r8) {
        super(1, r8, NewProfileSeeSelfTransitionDialogLauncher.class, "onRequestError", "onRequestError(Lcom/bytedance/android/live/profile/enum/ProfileMode;)V", 0);
    }

    public final void invoke(ProfileMode r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        NewProfileSeeSelfTransitionDialogLauncher.b((NewProfileSeeSelfTransitionDialogLauncher) ((CallableReference) this).receiver, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ProfileMode) r1);
        return Unit.INSTANCE;
    }
}

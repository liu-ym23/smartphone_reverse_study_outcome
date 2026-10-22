package com.larus.profile.impl.info;

import com.larus.home.api.block.BlockUserViewModel;
import com.larus.home.api.block.BottomConfirmDialog;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.profile.impl.databinding.LarusPageTabProfileInfoBinding;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public /* synthetic */ class ProfileInfoFragment$updateAICreationAppletMenuActions$1 extends AdaptedFunctionReference implements Function0<Unit> {
    public ProfileInfoFragment$updateAICreationAppletMenuActions$1(Object r8) {
        super(0, r8, ProfileInfoFragment.class, "handleBlockActionFromAICreationAppletMenu", "handleBlockActionFromAICreationAppletMenu()Lkotlin/Unit;", 8);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m49invoke() {
        final ProfileInfoFragment r0 = (ProfileInfoFragment) ((AdaptedFunctionReference) this).receiver;
        LarusPageTabProfileInfoBinding r1 = r0.e;
        if (r1 == null) goto L23;
        int r2 = r0.X90().getBlockListType();
        if (r2 != 0) goto L7;
    L16:
        BottomConfirmDialog r3 = new BottomConfirmDialog();
        LarkSocialExp.a.getClass();
        if (LarkSocialExp.f() == false) goto L19;
        int r4 = 2131898095;
    L20:
        r3.S90(r0.getString(r4), r0.getString(2131900953), new t(r0));
        ProfileInfoFragment.U90(r3, r0.getParentFragmentManager());
    L21:
        Unit r5 = Unit.INSTANCE;
        return;
    L19:
        r4 = 2131911147;
        goto L20
    L7:
        if (r2 != 1) goto L9;
        r1.c.a.setVisibility(8);
        BlockUserViewModel r6 = r0.W90();
        r38.b r7 = r0.X90().getUserInfo();
        if (r7 == null) goto L14;
        String r8 = r7.f();
    L15:
        r6.unblockUser(r8);
        goto L21
    L14:
        r8 = null;
        goto L15
    L9:
        if (r2 == 2) goto L16;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m49invoke();
        return Unit.INSTANCE;
    }
}

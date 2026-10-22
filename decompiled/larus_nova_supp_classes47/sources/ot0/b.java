package ot0;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.profile.ui.base.h;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements com.bytedance.android.live.profile.ui.component.base.a<st0.b> {
    public final Fragment a;
    public final com.bytedance.android.live.profile.a b;

    public b(Fragment r2, NewProfileInfoViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "mNewProfileInfoViewModel");
        this.a = r2;
        this.b = r3;
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.a
    public final void a(View r4, NewProfileUser r5, st0.b r6) {
        st0.b r7 = r6;
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "user");
        Intrinsics.checkNotNullParameter(r7, Constants.Keys.DATA);
        com.bytedance.android.live.profile.a r1 = null;
        switch(r7.getType()) {
            case 2: goto L46;
            case 3: goto L45;
            case 4: goto L44;
            case 5: goto L41;
            case 6: goto L40;
            case 7: goto L47;
            case 8: goto L37;
            case 9: goto L34;
            case 10: goto L28;
            case 11: goto L21;
            case 12: goto L21;
            case 13: goto L14;
            case 14: goto L12;
            case 15: goto L9;
            case 16: goto L6;
            case 17: goto L5;
            default: goto L47;
        };
    L5:
        this.b.goToSquareUserLiveRoom(this.a.getActivity());
        Map<String, String> r8 = this.b.getSquareJumpTrackParams();
    L48:
        com.bytedance.android.live.profile.a r9 = this.b;
        if ((r9 instanceof h) == false) goto L52;
        r1 = r9;
    L52:
        h r2 = (h) r1;
        if (r2 == null) goto L58;
        String r10 = st0.c.a(r7);
        if (r10 == null) goto L59;
        r2.recordBusinessClick(r10, r8);
        return;
    L59:
        return;
    L58:
        return;
    L6:
        Context r12 = this.a.getContext();
        if (r12 == null) goto L47;
        this.b.clickFansGroupManage(r12);
        goto L47
    L9:
        Context r13 = this.a.getContext();
        if (r13 == null) goto L47;
        this.b.clickFansGroupCreate(r13);
        goto L47
    L12:
        this.b.openIM(this.a);
        goto L47
    L34:
        Context r14 = this.a.getContext();
        if (r14 == null) goto L47;
        this.b.kickOut(r14);
        goto L47
    L37:
        Context r15 = this.a.getContext();
        if (r15 == null) goto L47;
        this.b.showFlashShop(r15);
        goto L47
    L40:
        this.b.goUserLiveRoom(this.a.getActivity());
        goto L47
    L41:
        Context r16 = this.a.getContext();
        if (r16 == null) goto L47;
        this.b.showAnonymousUserSilentDialog(r16);
        goto L47
    L44:
        this.b.manage(this.a.getActivity());
        goto L47
    L45:
        this.b.report(this.a.getActivity());
        goto L47
    L46:
        this.b.atUser(this.a.getContext());
    L47:
        r8 = null;
        goto L48
    L14:
        if (this.a.getContext() == null) goto L47;
        com.bytedance.android.live.profile.a r17 = this.b;
        Fragment r18 = this.a;
        if (r18 == null) goto L19;
        r17.goStartLive((DialogFragment) r18);
        goto L47
    L19:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.DialogFragment");
    L21:
        if (this.a.getContext() == null) goto L47;
        com.bytedance.android.live.profile.a r19 = this.b;
        Fragment r3 = this.a;
        if (r3 == null) goto L26;
        r19.clickOwnerCenter((DialogFragment) r3, r5);
        goto L47
    L26:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.DialogFragment");
    L28:
        if (this.a.getContext() == null) goto L47;
        com.bytedance.android.live.profile.a r20 = this.b;
        Fragment r22 = this.a;
        if (r22 == null) goto L33;
        r20.clickEcomSet((DialogFragment) r22, r5);
        goto L47
    L33:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.DialogFragment");
    }
}

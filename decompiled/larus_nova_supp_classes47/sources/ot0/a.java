package ot0;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.SubscribeInfo;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements com.bytedance.android.live.profile.ui.component.base.a<st0.e> {
    public final Fragment a;
    public final com.bytedance.android.live.profile.a b;

    public a(Fragment r2, NewProfileInfoViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "mNewProfileInfoViewModel");
        this.a = r2;
        this.b = r3;
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.a
    public final void a(View r4, NewProfileUser r5, st0.e r6) {
        st0.e r7 = r6;
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "user");
        Intrinsics.checkNotNullParameter(r7, Constants.Keys.DATA);
        if (r7.c == false) goto L65;
        int r8 = r7.getType();
        if (r8 == 0) goto L51;
        boolean r9 = true;
        if (r8 != 1) goto L10;
        o r10 = os0.b.a();
        if (r10 == null) goto L39;
        m r12 = r10.getRoom();
        if (r12 == null) goto L39;
        IRoom r13 = (IRoom) r12.getValue();
        if (r13 == null) goto L39;
        String r14 = r13.getOwnerUserIdString();
    L40:
        boolean r15 = Intrinsics.areEqual(r14, r5.baseProfileInfo.getIdStr());
        FragmentActivity r0 = this.a.getActivity();
        if (r0 == null) goto L62;
        com.bytedance.android.live.profile.a r1 = this.b;
        SubscribeInfo r16 = r5.subscribeInfo;
        if (r16 == null) goto L45;
        boolean r17 = r16.isMember;
    L46:
        if (r17 == false) goto L49;
        if (r15 == true) goto L49;
    L50:
        r1.showFansClub(r0, "mini_card", r9);
        return;
    L49:
        r9 = false;
        goto L50
    L45:
        r17 = false;
        goto L46
    L62:
        return;
    L39:
        r14 = null;
        goto L40
    L10:
        if (r8 != 2) goto L12;
        Context r18 = this.a.getContext();
        if (r18 == null) goto L60;
        this.b.clickGiftExhibitionCard(r18, r5.giftExhibitionInfo);
        return;
    L60:
        return;
    L12:
        if (r8 != 4) goto L14;
        FragmentActivity r19 = this.a.getActivity();
        if (r19 == null) goto L58;
        this.b.showSubscribePanel(r19, true);
        return;
    L58:
        return;
    L14:
        if (r8 != 5) goto L16;
        DialogFragment r20 = this.a;
        com.bytedance.android.live.profile.a r22 = this.b;
        if (r20 == null) goto L25;
        r22.showDressUpCenter(r20);
        return;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.DialogFragment");
    L16:
        if (r8 != 8) goto L66;
        FragmentActivity r23 = this.a.getActivity();
        if (r23 == null) goto L55;
        this.b.showKtvPanel(r23);
        return;
    L55:
        return;
    L66:
        return;
    L51:
        Context r24 = this.a.getContext();
        if (r24 == null) goto L64;
        this.b.showGradePage(r24, r5.grade.getSchema());
        return;
    L64:
        return;
    }
}

package com.bytedance.android.livesdk.interactivity.textmessage.model;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.api.report.ReportObject;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.interactivity.api.entity.SpannableType;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdkapi.depend.live.MessageSceneType;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.SuffixText;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class v extends com.bytedance.android.livesdk.interactivity.api.entity.f<va> implements o {
    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final void C() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final Spannable f() {
        switch(((int) this.b.getAction())) {
            case 1: goto L17;
            case 2: goto L4;
            case 3: goto L16;
            case 4: goto L16;
            case 5: goto L16;
            case 6: goto L16;
            case 7: goto L4;
            case 8: goto L6;
            case 9: goto L16;
            case 10: goto L16;
            case 11: goto L16;
            default: goto L4;
        };
    L4:
        SpannableType r1 = SpannableType.GAME;
        return i0.d(this.b.getUser(), this.b.getActionContent(), L(false), K(r1, false, false), null);
    L6:
        String r0 = "Top" + this.b.a0();
        String r4 = this.b.getActionContent();
        if (RTLUtil.isAppRTL(s1.getContext()) == false) goto L9;
        r0 = this.b.a0() + "Top";
        r4 = new StringBuffer(r4).reverse().toString();
    L9:
        String[] r2 = r4.split(r0);
        if (r2[0].length() == this.b.getActionContent().length()) goto L12;
        SpannableString r5 = new SpannableString(this.b.getActionContent());
        int r3 = K(SpannableType.GAME, false, true);
        ForegroundColorSpan r6 = new ForegroundColorSpan(r3);
        ForegroundColorSpan r7 = new ForegroundColorSpan(r3);
        ForegroundColorSpan r8 = new ForegroundColorSpan(r3);
        r5.setSpan(r6, 0, r2[0].length(), 18);
        r5.setSpan(r7, r2[0].length(), r2[0].length() + r0.length(), 18);
        r5.setSpan(r8, r2[0].length() + r0.length(), this.b.getActionContent().length(), 18);
        return r5;
    L12:
        return sb2.a.a;
    L17:
        SuffixText r9 = this.b.getOrInitPublicAreaCommon().getSuffixText();
        if (r9 != null) goto L20;
    L30:
        String r10 = BuildConfig.FLAVOR;
    L32:
        if (r10.isEmpty() == false) goto L34;
        String r11 = this.b.getActionContent();
    L35:
        SpannableType r13 = SpannableType.GAME;
        int r14 = L(true);
        if (r10.isEmpty() == true) goto L38;
        int r15 = K(SpannableType.MINI_CARD, true, false);
    L40:
        return i0.d(this.b.getUser(), r11, r14, r15, null);
    L38:
        r15 = K(r13, true, false);
        goto L40
    L34:
        r11 = this.b.getActionContent() + r10;
        goto L35
    L20:
        if (r9.getTags() == null) goto L30;
        if (r9.getTags().contains("launch_game") == true) goto L26;
        if (r9.getTags().contains("pay_game") == false) goto L30;
    L26:
        if (r9.getText() == null) goto L30;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        com.bytedance.android.livesdk.interactivity.service.textrender.core.x r16 = com.bytedance.android.livesdk.interactivity.service.textrender.core.r.b;
        a5 r17 = r9.getText();
        yb2.a r18 = j();
        Intrinsics.checkNotNullParameter(r17, "text");
        List<tb2.c> r19 = com.bytedance.android.livesdk.interactivity.service.textrender.core.r.a(r17, r18).a;
        if (r19.isEmpty() == true) goto L30;
        r10 = ((tb2.c) ListProtector.get(r19, 0)).getText();
        goto L32
    L16:
        return i0.b(this.b.getActionContent(), K(SpannableType.GAME, false, true));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public int k() {
        return K(SpannableType.DISPLAY_TEXT, false, false);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public int r() {
        SpannableType r0 = SpannableType.NORMAL;
        return L(false);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IPublicAreaCommon v() {
        va r0 = this.b;
        if (r0 == null) goto L7;
        return r0.getOrInitPublicAreaCommon();
    L7:
        return super.v();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IBaseUser x() {
        return this.b.getUser();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final boolean E(g52.c r3) {
        if (x() != null) goto L5;
        return false;
    L5:
        b(x(), ReportObject.User, false);
        return true;
    }

    public final int L(boolean r2) {
        if (r2 == false) goto L6;
        int r3 = com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a;
        com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a(this.i);
        return i0.a(2131107646);
    L6:
        int r4 = com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a;
        com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a(this.i);
        return i0.a(2131107646);
    }

    public v(va r1, MessageSceneType r2) {
        super(r1, r2);
    }

    public static int K(SpannableType r1, boolean r2, boolean r3) {
        if (r1 == SpannableType.MINI_CARD) goto L5;
        if (r2 == true) goto L8;
        if (r3 == false) goto L12;
        int r4 = com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a;
        return i0.a(2131107841);
    L12:
        int r5 = com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a;
        return i0.a(2131107651);
    L8:
        return i0.a(2131107098);
    L5:
        return i0.a(2131107886);
    }

    @Override // com.bytedance.android.livesdk.interactivity.textmessage.model.o
    public final boolean b(IBaseUser r5, ReportObject r6, boolean r7) {
        if (r7 == false) goto L4;
        J("text_user");
    L5:
        UserProfileEvent r8 = new UserProfileEvent(r5);
        r8.setClickUserPosition("personal_profile");
        r8.setExtraFollowParams(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.PROFILE_PUBLIC_SCREEN));
        if (this.b.getAction() != 1) goto L8;
        r8.setReportType("data_card_incomeinfo");
    L8:
        xs2.b.a().post(r8);
        return true;
    L4:
        J("default_user");
        goto L5
    }
}

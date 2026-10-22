package com.bytedance.android.livesdk.interactivity.textmessage.model;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.bytedance.android.live.base.model.message.b4;
import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.live.base.model.message.d4;
import com.bytedance.android.live.base.model.message.h4;
import com.bytedance.android.live.base.model.message.k0;
import com.bytedance.android.live.base.model.message.l0;
import com.bytedance.android.live.base.model.message.l4;
import com.bytedance.android.live.base.model.message.n0;
import com.bytedance.android.live.base.model.message.q0;
import com.bytedance.android.live.base.model.message.r2;
import com.bytedance.android.live.base.model.message.s3;
import com.bytedance.android.live.base.model.message.w0;
import com.bytedance.android.live.base.model.message.w3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.message.model.ac;
import com.bytedance.android.livesdk.message.model.h7;
import com.bytedance.android.livesdk.message.model.i7;
import com.bytedance.android.livesdk.message.model.l8;
import com.bytedance.android.livesdk.message.model.na;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.message.model.qa;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.android.livesdk.message.model.w8;
import com.bytedance.android.livesdkapi.depend.live.MessageSceneType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i0 {
    public static int a(int r1) {
        return s1.getContext().getResources().getColor(r1);
    }

    public static Spannable b(String r3, int r4) {
        SpannableString r0 = new SpannableString(r3);
        r0.setSpan(new ForegroundColorSpan(r4), 0, r0.length(), 18);
        return r0;
    }

    public static com.bytedance.android.livesdk.interactivity.api.entity.f e(com.bytedance.android.live.base.model.message.t r0, MessageSceneType r1, IRoom r2) {
        return f(r0, r1, r2);
    L4:
        e = move-exception;
        SafetyGuard.a("TextMessageHelper error", e, null);
        return null;
    }

    public static com.bytedance.android.livesdk.interactivity.api.entity.f f(com.bytedance.android.live.base.model.message.t r11, MessageSceneType r13, IRoom r14) {
        String r0 = r11.getMessageMethod();
        if ("WebcastChatMessage".equals(r0) == false) goto L7;
        d r15 = new d((k0) r11, r13);
        r15.d = 31000;
        return r15;
    L7:
        if ("WebcastAudioChatMessage".equals(r0) == false) goto L11;
        AudioChatTextMessage r16 = new AudioChatTextMessage((com.bytedance.android.live.base.model.message.r) r11, r13);
        r16.d = 31000;
        return r16;
    L11:
        if ("WebcastGiftMessage".equals(r0) == false) goto L15;
        m r17 = new m((o7) r11, r13);
        r17.d = 21000;
        return r17;
    L15:
        if ("WebcastExhibitionChatMessage".equals(r0) == false) goto L19;
        return new k((w0) r11);
    L19:
        if ("GiftGroupMessage".equals(r0) == false) goto L23;
        l r18 = new l((kc2.b) r11, r13);
        r18.d = 21000;
        return r18;
    L23:
        if ("WebcastLikeMessage".equals(r0) == false) goto L27;
        h r19 = new h((q0) r11, r13);
        r19.d = 42000;
        return r19;
    L27:
        if ("WebcastMemberMessage".equals(r0) == false) goto L35;
        va r110 = (va) r11;
        if (r110.getAction() != 1) goto L32;
        u r111 = new u(r110, r13);
        r111.d = 42000;
        return r111;
    L32:
        v r112 = new v(r110, r13);
        r112.d = 42000;
        return r112;
    L35:
        if ("WebcastRoomMessage".equals(r0) == false) goto L39;
        d0 r113 = new d0((c4) r11, r13);
        r113.d = 11000;
        return r113;
    L39:
        if ("WebcastAnchorBoostMessage".equals(r0) == false) goto L43;
        a r114 = new a((com.bytedance.android.live.base.model.message.o) r11, r13);
        r114.d = 11000;
        return r114;
    L43:
        if ("WebcastSocialMessage".equals(r0) == false) goto L46;
        h0 r115 = new h0((l4) r11, r13);
        r115.d = 41000;
        return r115;
    L46:
        boolean r8 = true;
        if ("WebcastControlMessage".equals(r0) == false) goto L57;
        n0 r116 = (n0) r11;
        if (r14 != null) goto L51;
    L53:
        r8 = false;
    L54:
        f r117 = new f(r116, r8);
        r117.d = 11000;
        return r117;
    L51:
        if (r14.isMediaRoom() == false) goto L53;
    L57:
        if ("WebcastScreenChatMessage".equals(r0) == false) goto L60;
        g0 r118 = new g0((h4) r11, r13);
        r118.d = 11000;
        return r118;
    L60:
        com.bytedance.android.livesdk.interactivity.api.entity.f r10 = null;
        if ("WebcastLuckyBoxMessage".equals(r0) == false) goto L72;
        if ((r11 instanceof qa) == false) goto L68;
        qa r119 = (qa) r11;
        if (r119.getTextMessageParams() == null) goto L67;
        r10 = new t(r119);
        goto L68
    L67:
        r10 = new s(r119);
    L68:
        if (r10 == null) goto L70;
        r10.d = 22000;
    L70:
        return r10;
    L72:
        if ("WebcastLotteryEventNewMessage".equals(r0) == false) goto L76;
        r r120 = new r((na) r11);
        r120.d = 22000;
        return r120;
    L76:
        if ("WebcastFansclubMessage".equals(r0) == false) goto L80;
        i r121 = new i((h7) r11, r13);
        r121.d = 31000;
        return r121;
    L80:
        if ("WebcastLinkMicSendEmojiMessage".equals(r0) == false) goto L84;
        return new q((w8) r11);
    L84:
        if ("WebcastRoomIntroMessage".equals(r0) == false) goto L109;
        b4 r122 = (b4) r11;
        Intrinsics.checkNotNullParameter(r122, "$this$tryUseLabelInRoom");
        if (r14 == null) goto L107;
        py.r r123 = r14.getRoomIntroLabel();
        if (r123 == null) goto L107;
        Iterator r124 = r122.G1().iterator();
        int r1 = 0;
    L91:
        if (r124.hasNext() == false) goto L99;
        if (((py.r) r124.next()).getType() != 1) goto L95;
        boolean r2 = true;
    L96:
        if (r2 == true) goto L100;
        r1 = r1 + 1;
    L100:
        if (r1 >= 0) goto L102;
    L105:
        ListProtector.add(r122.G1(), 0, r123);
        goto L107
    L102:
        if (r1 >= r122.G1().size()) goto L105;
        ListProtector.set(r122.G1(), r1, r123);
        goto L107
    L95:
        r2 = false;
        goto L96
    L99:
        r1 = -1;
    L107:
        return new b0(r122);
    L109:
        if ("WebcastMediaRoomNoticeMessage".equals(r0) == false) goto L113;
        return new c0((d4) r11);
    L113:
        if ("WebcastKtvMessage".equals(r0) == false) goto L117;
        return new p((l8) r11);
    L117:
        if ("WebcastNoticeMessage".equals(r0) == false) goto L121;
        return new a0((w3) r11);
    L121:
        if ("WebcastLinkMessage".equals(r0) == false) goto L137;
        if ((r11 instanceof r2) == false) goto L135;
        r2 r125 = (r2) r11;
        ALogger.d("TextMessageHelper", "receive LinkerMessage, type is " + r125.getType());
        if (r125.getType() != 29) goto L135;
        if (r125.getGuestInviteContent() != null) goto L129;
    L131:
        r8 = false;
    L132:
        if (r8 == false) goto L135;
        n r126 = new n(r125);
        r126.d = 42000;
        return r126;
    L129:
        if (r125.getGuestInviteContent().a() == null) goto L131;
    L135:
        return null;
    L137:
        if ("WebcastCommonTextMessage".equals(r0) == false) goto L141;
        return new e((l0) r11);
    L141:
        if ("WebcastTopAggregateChatMessage".equals(r0) == false) goto L145;
        return new j0((ac) r11);
    L145:
        if ("WebcastPrivilegeScreenChatMessage".equals(r0) == false) goto L149;
        return new y((s3) r11, r13);
    L149:
        if ("WebcastNobleUpgradeMessage".equals(r0) == false) goto L153;
        return new g(r11);
    L153:
        if ("WebcastFeaturedAIMessage".equals(r0) == false) goto L157;
        return new j((i7) r11);
    L157:
        return new g(r11);
    }

    public static Spannable d(IBaseUser r2, String r3, int r4, int r5, String r6) {
        if (r2 == null) goto L18;
        if (TextUtils.isEmpty(gm2.q.b(r2)) == true) goto L18;
        if (TextUtils.isEmpty(r3) == true) goto L18;
        if (TextUtils.isEmpty(r6) == false) goto L12;
        r6 = gm2.q.b(r2);
    L12:
        if (TextUtils.isEmpty(r6) == true) goto L14;
        ForegroundColorSpan r7 = new ForegroundColorSpan(r4);
        ForegroundColorSpan r8 = new ForegroundColorSpan(r5);
        SpannableString r9 = new SpannableString(r6 + tb2.c.DEFAULT_TEXT + r3);
        r9.setSpan(r7, 0, r6.length(), 33);
        r9.setSpan(r8, r6.length(), r9.length(), 18);
        return r9;
    L14:
        return sb2.a.a;
    L18:
        return sb2.a.a;
    }

    public static Spannable c(IBaseUser r1, String r2, String r3, int r4, int r5, String r6) {
        SpannableStringBuilder r0 = new SpannableStringBuilder(r3);
        if (r1 == null) goto L15;
        if (TextUtils.isEmpty(r0) == true) goto L15;
        if (TextUtils.isEmpty(r6) == false) goto L11;
        r6 = gm2.q.b(r1);
    L11:
        if (TextUtils.isEmpty(r6) == true) goto L16;
        ForegroundColorSpan r7 = new ForegroundColorSpan(r4);
        ForegroundColorSpan r8 = new ForegroundColorSpan(r5);
        SpannableString r9 = new SpannableString(r6 + r2 + r0);
        r9.setSpan(r7, 0, r6.length() + 1, 33);
        r9.setSpan(r8, r6.length() + 1, r9.length(), 18);
        return r9;
    L16:
        return sb2.a.a;
    L15:
        return sb2.a.a;
    }
}

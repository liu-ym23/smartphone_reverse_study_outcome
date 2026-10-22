package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Pin;
import com.ss.android.lark.chat.entity.message.UniversalPinExtra;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.team.TeamUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessagePinInfoBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {
    public final IMMessageKeys$Blocks g;
    public final jdb.g h;

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.g;
    }

    public MessagePinInfoBlock(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys$Blocks.PIN_INFO;
        this.h = com.ss.android.lark.chat.chatwindow.chat.v2.push.w.a(this.c).C();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r2, com.ss.android.lark.blueprint.q<y6b.a<?>> r3) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        com.ss.android.lark.blueprint.i.a.a(r2, r3);
        g(r3, this.g, IMMessageKeys$Slots.BOTTOM);
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.a<?>> r22, com.ss.android.lark.blueprint.q<y6b.a<?>> r23, y6b.a<?> r24) {
        Intrinsics.checkNotNullParameter(r22, "cell");
        Intrinsics.checkNotNullParameter(r23, "layout");
        Intrinsics.checkNotNullParameter(r24, Keys.API_RETURN_KEY_DATA);
        y6b.c r2 = (y6b.c) r24;
        boolean r4 = true;
        if (r2.j() == false) goto L5;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == true) goto L14;
    L128:
        g(r23, this.g, IMMessageKeys$Slots.BOTTOM);
        return;
    L14:
        if (com.ss.android.lark.chat.utils.i.a(r2, com.ss.android.lark.chat.chatwindow.chat.v2.push.w.a(this.c).C(), this.c.getChat()) == false) goto L128;
        IMMessageKeys$Blocks r5 = this.g;
        IMMessageKeys$Slots r6 = IMMessageKeys$Slots.BOTTOM;
        com.ss.android.lark.blueprint.k r7 = r23.c(r5, r6, new MessagePinInfoBlock$update$blockView$1(this));
        r7.getView().setMovementMethod(LinkMovementMethod.getInstance());
        ChatThemeInfo r8 = this.c.r8();
        if (r8 == null) goto L19;
        ChatThemeInfo.Scene r9 = r8.getComponentScene();
    L21:
        if (com.ss.android.lark.chat.utils.p.g(r9) == false) goto L23;
        int r10 = 2131102338;
    L24:
        jdb.g r11 = this.h;
        Chat r12 = this.c.getChat();
        int r13 = l2b.b.a;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r11, "fgService");
        Intrinsics.checkNotNullParameter(r11, "fgService");
        if (r12 != null) goto L28;
    L36:
        boolean r14 = false;
    L38:
        if (r14 == true) goto L40;
    L42:
        boolean r15 = false;
    L43:
        if (r15 == true) goto L45;
    L49:
        boolean r16 = false;
    L51:
        if (r16 == false) goto L69;
        UniversalPinExtra r17 = r2.v2;
        if (r17 == null) goto L100;
        m2b.a r18 = this.c;
        Function1<Chatter, Unit> r19 = new MessagePinInfoBlock$update$text$1(this);
        Intrinsics.checkNotNullParameter(r17, "<this>");
        Intrinsics.checkNotNullParameter(r18, "chatContext");
        ChatChatter r20 = r17.getPinChatter();
        if (r20 == null) goto L100;
        SpannableStringBuilder r110 = new SpannableStringBuilder();
        String r111 = com.ss.android.lark.chat.utils.m.b(r20, ChatterNameDisplayRule.ALIAS_NICKNAME_NAME, true);
        if (r18.isGroup() == true) goto L64;
        if (r18.B8() == false) goto L64;
        r110.append(UIUtils.getString(r18.getContext(), 2131891354));
    L68:
        CharSequence r21 = new SpannedString(r110);
    L101:
        if (r21 != null) goto L103;
    L126:
        g(r23, this.g, r6);
        return;
    L103:
        if (TextUtils.isEmpty(r21) == true) goto L126;
        r7.getView().setText(r21);
        ChatThemeInfo r1 = this.c.r8();
        if (r1 == null) goto L107;
        ChatThemeInfo.Scene r25 = r1.getComponentScene();
    L108:
        boolean r26 = com.ss.android.lark.chat.utils.p.g(r25);
        if (r26 == false) goto L117;
        ChatThemeInfo r27 = this.c.r8();
        if (r27 == null) goto L113;
        ChatThemeInfo.Scene r28 = r27.getComponentScene();
    L115:
        if (com.ss.android.lark.chat.utils.p.f(r28) == false) goto L117;
    L118:
        int r29 = zz7.b.g(getContext(), 12);
        Drawable r30 = UIUtils.getDrawable(getContext(), 2131237568);
        r30.setBounds(0, 0, r29, r29);
        if (r26 == true) goto L121;
    L124:
        int r31 = UIUtils.getColor(getContext(), 2131102452);
        r7.getView().setTextColor(r31);
        r30.setTint(r31);
    L125:
        r7.getView().setCompoundDrawables(r30, null, null, null);
        return;
    L121:
        if (h18.f.a(getContext()) == true) goto L123;
        if (r4 == false) goto L124;
    L123:
        Context r32 = getContext();
        Intrinsics.checkNotNullParameter(r32, "context");
        int r33 = UIUtils.getColor(r32, 2131102338);
        r7.getView().setTextColor(r33);
        r30.setTint(r33);
        goto L125
    L113:
        r28 = null;
    L117:
        r4 = false;
        goto L118
    L107:
        r25 = null;
    L64:
        if (r18.isGroup() == false) goto L66;
        String r112 = UIUtils.getString(r18.getContext(), 2131891352);
    L67:
        String r113 = r112;
        String r114 = ICUUtils.icuFormat(r113, IPortraitService.NAME, r111);
        Intrinsics.checkNotNull(r113);
        int r115 = StringsKt.indexOf$default(r113, "{name}", 0, false, 6, null);
        r110.append(r114);
        r110.setSpan(new l2b.a(r10, r19, r20, r18.getContext()), r115, r111.length() + r115, 33);
        goto L68
    L66:
        r112 = UIUtils.getString(r18.getContext(), 2131891353);
    L100:
        r21 = null;
        goto L101
    L69:
        jdb.g r34 = this.h;
        Chat r116 = this.c.getChat();
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r34, "fgService");
        Intrinsics.checkNotNullParameter(r34, "fgService");
        if (r116 != null) goto L73;
    L81:
        boolean r117 = false;
    L82:
        if (r117 == true) goto L84;
    L86:
        boolean r35 = false;
    L87:
        if (r35 == false) goto L90;
    L92:
        boolean r36 = false;
    L93:
        if (r36 == false) goto L100;
        Pin r37 = r2.v;
        if (r37 == null) goto L100;
        m2b.a r38 = this.c;
        Intrinsics.checkNotNullParameter(r37, "<this>");
        Intrinsics.checkNotNullParameter(r38, "chatContext");
        if (r38.isGroup() == false) goto L99;
        r21 = UIHelper.mustacheFormat(2131892515, "user", r37.getOperatorDisplayName());
        goto L101
    L99:
        r21 = UIHelper.mustacheFormat(2131892516, "user", r37.getOperatorDisplayName());
        goto L101
    L90:
        if (r2.v == null) goto L92;
        r36 = true;
        goto L93
    L84:
        if (r34.isEnable("im.chat.pinned.msg") == false) goto L86;
        r35 = true;
        goto L87
    L73:
        if (r116.isSecret() == true) goto L81;
        TeamUtils.b(r116);
        if (r34.isEnable("im.chat.pinned.url") == false) goto L81;
        if (r116.isThread() == true) goto L81;
        if (r116.isOnCall() == true) goto L81;
        r117 = true;
        goto L82
    L45:
        if (r2.v2 == null) goto L49;
        if (r2.j() == true) goto L49;
        r16 = true;
        goto L51
    L40:
        if (r11.isEnable("im.chat.pinned.msg") == false) goto L42;
        r15 = true;
        goto L43
    L28:
        if (r12.isSecret() == true) goto L36;
        TeamUtils.b(r12);
        if (r11.isEnable("im.chat.pinned.url") == false) goto L36;
        if (r12.isThread() == true) goto L36;
        if (r12.isOnCall() == true) goto L36;
        r14 = true;
        goto L38
    L23:
        r10 = 2131102452;
        goto L24
    L19:
        r9 = null;
        goto L21
    L5:
        if (r2.Y == true) goto L11;
        if (r2.y == true) goto L11;
        if (r2.z == true) goto L11;
        r3 = true;
        goto L12
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r1, com.ss.android.lark.blueprint.q<y6b.a<?>> r2, y6b.a<?> r3) {
        update2(r1, r2, r3);
    }
}

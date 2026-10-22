package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.recall;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.base.view.vo.ThreadMessageVO;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.p;
import com.ss.android.lark.dto.chat.ProfileSource;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.o;
import com.ss.android.lark.widget.linked_emojicon.widget.LinkEmojiTextView;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;
import w4b.b0;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class RecalledSystemContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<v5b.a<?>>, Object> {
    public final IMMessageKeys$Blocks g;
    public boolean h;
    public SpannableStringBuilder i;

    public static final class a {
    }

    public static final class b implements k<View> {
        public final View a;
        public final LinkEmojiTextView b;

        public final View getView() {
            return this.a;
        }

        public b(View r3) {
            Intrinsics.checkNotNullParameter(r3, "view");
            this.a = r3;
            LinkEmojiTextView r4 = r3.findViewById(2131383849);
            this.b = r4;
            r4.setHighlightColor(d.c(r4.getContext(), 2131101106));
            r4.setTextSize(0, zz7.b.h(r4.getContext(), 14));
        }
    }

    public static final class c implements LinkEmojiTextView.f {
        public final /* synthetic */ RecalledSystemContentBlock a;
        public final /* synthetic */ y6b.a<v5b.a<?>> b;

        public final boolean c(View r1, String r2, String r3) {
            return false;
        }

        public c(RecalledSystemContentBlock r1, y6b.a<v5b.a<?>> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void d(View r2, String r3, String r4) {
            b0 r5 = ChatCoreModule.a().getProfileDependency();
            Context r6 = this.a.getContext();
            ProfileSource.a r0 = new ProfileSource.a();
            r0.e = r4;
            r0.d = this.b.getChatId();
            r0.b = 2;
            r0.c = com.ss.android.lark.chat.utils.k.a(this.a.c.getChat());
            r5.e(r6, r0.a());
        }
    }

    static {
    }

    public final j getKey() {
        return this.g;
    }

    public RecalledSystemContentBlock(g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys$Blocks.RECALLED_SYSTEM_CONTENT;
        this.i = new SpannableStringBuilder();
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(m<y6b.a<v5b.a<?>>> r13, q<y6b.a<v5b.a<?>>> r14, y6b.a<v5b.a<?>> r15) {
        Intrinsics.checkNotNullParameter(r13, "cell");
        Intrinsics.checkNotNullParameter(r14, "layout");
        Intrinsics.checkNotNullParameter(r15, Keys.API_RETURN_KEY_DATA);
        LinkEmojiTextView r16 = ((b) r14.c(this.g, IMMessageKeys$Slots.CONTENT, RecalledSystemContentBlock$update$blockView$1.INSTANCE)).b;
        ChatThemeInfo r17 = this.c.r8();
        if (r17 != null) goto L5;
    L7:
        boolean r18 = false;
    L8:
        v5b.a<?> r2 = r15.b();
        y6b.b r3 = r15.D();
        y6b.b r4 = r15.a();
        String r5 = BuildConfig.FLAVOR;
        if (r3 == null) goto L11;
        String r6 = o.b(r3.a, r3.b);
    L12:
        if (r4 == null) goto L15;
        r5 = o.b(r4.a, r4.b);
    L15:
        if (this.c.Y() == true) goto L17;
    L30:
        boolean r7 = false;
    L32:
        if (r15.R() == true) goto L34;
    L40:
        boolean r8 = false;
    L41:
        this.h = r8;
        if (r4 != null) goto L44;
    L50:
        if (r3 == null) goto L63;
        if (r4 == null) goto L63;
        if ((r15 instanceof y6b.c) == true) goto L57;
        if ((r15 instanceof ThreadMessageVO) == false) goto L63;
    L57:
        if (r15.S() == false) goto L63;
        if (r15.h() == false) goto L61;
        String r0 = d.i(getContext(), 2131891139);
        ICUUtils.FormatArgsBuilder r9 = new ICUUtils.FormatArgsBuilder();
        r9.b("admin", r6);
        String r1 = ICUUtils.icuFormat(r0, r9.a);
    L62:
        Intrinsics.checkNotNull(r1);
    L98:
        String r10 = r1;
    L99:
        r16.T(null, r10, false);
        if (this.h == false) goto L102;
        r16.setText(this.i);
    L102:
        r16.setAtStringClickListner(new c(this, r15));
        if (r18 == true) goto L106;
        return;
    L106:
        if (TextUtils.isEmpty(r10) == true) goto L108;
        r16.setBackground(d.e(getContext(), 2131232172));
        r16.setTextColor(p.c(getContext()));
        return;
    L108:
        Context r19 = getContext();
        int r110 = p.a;
        Intrinsics.checkNotNullParameter(r19, "context");
        r16.setBackgroundColor(UIUtils.getColor(r19, 2131106784));
        r16.setTextColor(p.e(getContext()));
        return;
    L61:
        String r11 = d.i(getContext(), 2131891140);
        ICUUtils.FormatArgsBuilder r12 = new ICUUtils.FormatArgsBuilder();
        r12.b("admin", r6);
        r12.b(IPortraitService.NAME, r5);
        r1 = ICUUtils.icuFormat(r11, r12.a);
    L63:
        if (r3 == null) goto L77;
        if (r4 == null) goto L77;
        if ((r15 instanceof y6b.c) == true) goto L70;
        if ((r15 instanceof ThreadMessageVO) == true) goto L70;
    L72:
        if (r15.h() == false) goto L74;
        String r20 = d.i(getContext(), 2131891141);
        ICUUtils.FormatArgsBuilder r21 = new ICUUtils.FormatArgsBuilder();
        r21.b("owner", r6);
        r1 = ICUUtils.icuFormat(r20, r21.a);
    L75:
        Intrinsics.checkNotNull(r1);
        goto L98
    L74:
        String r22 = d.i(getContext(), 2131891142);
        ICUUtils.FormatArgsBuilder r23 = new ICUUtils.FormatArgsBuilder();
        r23.b("owner", r6);
        r23.b(IPortraitService.NAME, r5);
        r1 = ICUUtils.icuFormat(r22, r23.a);
    L70:
        if (r15.S() == false) goto L72;
    L77:
        if (r4 == null) goto L84;
        if (r15.h() == true) goto L84;
        if (r15.E() != Message.RecallerIdentity.UNKNOWN_IDENTITY) goto L84;
        String r24 = d.i(getContext(), 2131891295);
        ICUUtils.FormatArgsBuilder r25 = new ICUUtils.FormatArgsBuilder();
        r25.b("noun", "other");
        r25.b(IPortraitService.NAME, r5);
        r1 = ICUUtils.icuFormat(r24, r25.a);
        Intrinsics.checkNotNull(r1);
    L84:
        if (this.h == false) goto L92;
        String r26 = d.i(getContext(), 2131891295);
        ICUUtils.FormatArgsBuilder r27 = new ICUUtils.FormatArgsBuilder();
        r27.b("noun", "you");
        r10 = ICUUtils.icuFormat(r26, r27.a);
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.recall.c r28 = new com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.recall.c(this, r2, r15, getContext());
        if (r18 == false) goto L88;
        r28.a = 2131106607;
    L88:
        SpannableStringBuilder r29 = new SpannableStringBuilder().append(r10);
        this.i = r29;
        int r30 = r29.length();
        this.i.append(" ");
        this.i.append(d.i(getContext(), 2131891451));
        int r31 = this.i.length();
        if (r31 > r30) goto L91;
        Log.i("RecalledSystemContentBlock", "append content invalid start or end ...");
        Intrinsics.checkNotNull(r10);
        goto L99
    L91:
        this.i.setSpan(r28, r30, r31, 33);
        this.i.setSpan(new ForegroundColorSpan(d.c(getContext(), 2131106616)), r30 + 1, r31, 33);
        Intrinsics.checkNotNull(r10);
        goto L99
    L92:
        if (r3 != null) goto L97;
        if (r4 == null) goto L97;
        if (r15.E() != Message.RecallerIdentity.UNKNOWN_IDENTITY) goto L97;
        String r32 = d.i(getContext(), 2131891295);
        ICUUtils.FormatArgsBuilder r33 = new ICUUtils.FormatArgsBuilder();
        r33.b("noun", "you");
        r1 = ICUUtils.icuFormat(r32, r33.a);
        Intrinsics.checkNotNull(r1);
    L97:
        r1 = d.i(getContext(), 2131891918);
        Intrinsics.checkNotNull(r1);
        goto L98
    L44:
        if (r15.E() != Message.RecallerIdentity.ENTERPRISE_ADMINISTRATOR) goto L50;
        if (r15.h() == false) goto L48;
        r1 = d.i(getContext(), 2131891245);
    L49:
        Intrinsics.checkNotNull(r1);
        goto L98
    L48:
        String r34 = d.i(getContext(), 2131891246);
        ICUUtils.FormatArgsBuilder r35 = new ICUUtils.FormatArgsBuilder();
        r35.b(IPortraitService.NAME, r5);
        r1 = ICUUtils.icuFormat(r34, r35.a);
        goto L49
    L34:
        if (r15.h() == false) goto L40;
        if (r3 != null) goto L40;
        if (this.d == null) goto L40;
        if (r7 == true) goto L40;
        r8 = true;
        goto L41
    L17:
        if (this.c.e0() == true) goto L30;
        boolean r36 = r15 instanceof y6b.c;
        if (r36 == false) goto L30;
        if (r36 == false) goto L22;
        y6b.c r37 = (y6b.c) r15;
    L23:
        if (r37 != null) goto L25;
    L27:
        boolean r38 = false;
    L28:
        if (r38 == false) goto L30;
        r7 = true;
        goto L32
    L25:
        if (r37.Y() != true) goto L27;
        r38 = true;
        goto L28
    L22:
        r37 = null;
        goto L23
    L11:
        r6 = BuildConfig.FLAVOR;
        goto L12
    L5:
        if (p.g(r17.getComponentScene()) == false) goto L7;
        r18 = true;
        goto L8
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(m<y6b.a<v5b.a<?>>> r1, q<y6b.a<v5b.a<?>>> r2, y6b.a<v5b.a<?>> r3) {
        update2(r1, r2, r3);
    }
}

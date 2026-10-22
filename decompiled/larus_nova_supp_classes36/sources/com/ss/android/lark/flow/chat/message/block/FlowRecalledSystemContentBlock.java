package com.ss.android.lark.flow.chat.message.block;

import android.content.Context;
import android.text.TextUtils;
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
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import com.ss.android.lark.chat.utils.p;
import com.ss.android.lark.dto.chat.ProfileSource;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.o;
import com.ss.android.lark.widget.linked_emojicon.widget.LinkEmojiTextView;
import kotlin.jvm.internal.Intrinsics;
import w4b.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowRecalledSystemContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<v5b.a<?>>, Object> {
    public final IMMessageKeys.Blocks g;

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
            r4.setHighlightColor(y9c.d.c(r4.getContext(), 2131101106));
            r4.setTextSize(0, itb.d.a.a((itb.d) LarkContext.spiByDwarf(itb.d.class), UIUtils.dp2px(r4.getContext(), 14.0f)));
        }
    }

    public static final class c implements LinkEmojiTextView.f {
        public final /* synthetic */ FlowRecalledSystemContentBlock a;
        public final /* synthetic */ y6b.a<v5b.a<?>> b;

        public final boolean c(View r1, String r2, String r3) {
            return false;
        }

        public c(FlowRecalledSystemContentBlock r1, y6b.a<v5b.a<?>> r2) {
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
            r0.c = com.ss.android.lark.chat.utils.k.a(((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this.a).c.getChat());
            r5.e(r6, r0.a());
        }
    }

    static {
    }

    public final j getKey() {
        return this.g;
    }

    public FlowRecalledSystemContentBlock(g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys.Blocks.RECALLED_SYSTEM_CONTENT;
    }

    public void update(m<y6b.a<v5b.a<?>>> r11, q<y6b.a<v5b.a<?>>> r12, y6b.a<v5b.a<?>> r13) {
        Intrinsics.checkNotNullParameter(r11, "cell");
        Intrinsics.checkNotNullParameter(r12, "layout");
        Intrinsics.checkNotNullParameter(r13, "data");
        LinkEmojiTextView r14 = ((b) r12.c(this.g, IMMessageKeys.Slots.CONTENT, FlowRecalledSystemContentBlock$update$blockView$1.INSTANCE)).b;
        i3b.c.b(r14, ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).a, 12.0f);
        ChatThemeInfo r15 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.r8();
        boolean r0 = true;
        if (r15 != null) goto L5;
    L7:
        boolean r16 = false;
    L8:
        r13.b();
        y6b.b r2 = r13.D();
        y6b.b r3 = r13.a();
        String r4 = "";
        if (r2 == null) goto L11;
        String r5 = o.b(r2.a, r2.e);
    L12:
        if (r3 == null) goto L14;
        r4 = o.b(r3.a, r3.e);
    L14:
        StringBuilder r6 = new StringBuilder("getTvContent, recallChatter: ");
        if (r2 != null) goto L17;
        boolean r7 = true;
    L18:
        r6.append(r7);
        r6.append(", recalledChatter: ");
        if (r3 == null) goto L22;
        r0 = false;
    L22:
        r6.append(r0);
        r6.append(", recallerIdentity: ");
        r6.append(r13.E());
        Log.i("FlowRecalledSystemContentBlock", r6.toString());
        if (r3 != null) goto L25;
    L38:
        if (r3 != null) goto L40;
    L46:
        if (r2 == null) goto L62;
        if (r3 == null) goto L62;
        if ((r13 instanceof y6b.c) == true) goto L53;
        if ((r13 instanceof ThreadMessageVO) == false) goto L62;
    L53:
        if (r13.S() == false) goto L62;
        if (r3.j != Chatter.ChatterType.DOUBAO) goto L58;
        String r8 = y9c.d.i(getContext(), 2131891140);
        ICUUtils.FormatArgsBuilder r9 = new ICUUtils.FormatArgsBuilder();
        r9.b("admin", r5);
        r9.b("name", r3.e);
        String r10 = ICUUtils.icuFormat(r8, r9.a);
    L61:
        Intrinsics.checkNotNull(r10);
    L91:
        r14.T(null, r10, false);
        r14.setAtStringClickListner(new c(this, r13));
        if (r16 == true) goto L95;
        return;
    L95:
        if (TextUtils.isEmpty(r10) == true) goto L97;
        r14.setBackground(y9c.d.e(getContext(), 2131232172));
        r14.setTextColor(p.c(getContext()));
        return;
    L97:
        Context r17 = getContext();
        int r18 = p.a;
        Intrinsics.checkNotNullParameter(r17, "context");
        r14.setBackgroundColor(UIUtils.getColor(r17, 2131106784));
        r14.setTextColor(p.e(getContext()));
        return;
    L58:
        if (r13.h() == false) goto L60;
        String r19 = y9c.d.i(getContext(), 2131891139);
        ICUUtils.FormatArgsBuilder r20 = new ICUUtils.FormatArgsBuilder();
        r20.b("admin", r5);
        r10 = ICUUtils.icuFormat(r19, r20.a);
        goto L61
    L60:
        String r21 = y9c.d.i(getContext(), 2131891140);
        ICUUtils.FormatArgsBuilder r22 = new ICUUtils.FormatArgsBuilder();
        r22.b("admin", r5);
        r22.b("name", r4);
        r10 = ICUUtils.icuFormat(r21, r22.a);
    L62:
        if (r2 == null) goto L79;
        if (r3 == null) goto L79;
        if ((r13 instanceof y6b.c) == true) goto L69;
        if ((r13 instanceof ThreadMessageVO) == true) goto L69;
    L71:
        if (r3.j != Chatter.ChatterType.DOUBAO) goto L74;
        String r23 = y9c.d.i(getContext(), 2131891142);
        ICUUtils.FormatArgsBuilder r24 = new ICUUtils.FormatArgsBuilder();
        r24.b("owner", r5);
        r24.b("name", r3.e);
        r10 = ICUUtils.icuFormat(r23, r24.a);
    L77:
        Intrinsics.checkNotNull(r10);
        goto L91
    L74:
        if (r13.h() == false) goto L76;
        String r25 = y9c.d.i(getContext(), 2131891141);
        ICUUtils.FormatArgsBuilder r26 = new ICUUtils.FormatArgsBuilder();
        r26.b("owner", r5);
        r10 = ICUUtils.icuFormat(r25, r26.a);
        goto L77
    L76:
        String r27 = y9c.d.i(getContext(), 2131891142);
        ICUUtils.FormatArgsBuilder r28 = new ICUUtils.FormatArgsBuilder();
        r28.b("owner", r5);
        r28.b("name", r4);
        r10 = ICUUtils.icuFormat(r27, r28.a);
    L69:
        if (r13.S() == false) goto L71;
    L79:
        if (r3 != null) goto L81;
    L85:
        if (r2 != null) goto L90;
        if (r3 == null) goto L90;
        if (r13.E() != Message.RecallerIdentity.UNKNOWN_IDENTITY) goto L90;
        String r29 = y9c.d.i(getContext(), 2131891295);
        ICUUtils.FormatArgsBuilder r30 = new ICUUtils.FormatArgsBuilder();
        r30.b("noun", "you");
        r10 = ICUUtils.icuFormat(r29, r30.a);
        Intrinsics.checkNotNull(r10);
    L90:
        r10 = y9c.d.i(getContext(), 2131891918);
        Intrinsics.checkNotNull(r10);
        goto L91
    L81:
        if (r13.h() == true) goto L85;
        if (r13.E() != Message.RecallerIdentity.UNKNOWN_IDENTITY) goto L85;
        String r31 = y9c.d.i(getContext(), 2131891295);
        ICUUtils.FormatArgsBuilder r32 = new ICUUtils.FormatArgsBuilder();
        r32.b("noun", INotificationHitPoint.NoticeType.OTHER);
        r32.b("name", r4);
        r10 = ICUUtils.icuFormat(r31, r32.a);
        Intrinsics.checkNotNull(r10);
        goto L91
    L40:
        if (r13.E() != Message.RecallerIdentity.ENTERPRISE_ADMINISTRATOR) goto L46;
        if (r13.h() == false) goto L44;
        r10 = y9c.d.i(getContext(), 2131891245);
    L45:
        Intrinsics.checkNotNull(r10);
        goto L91
    L44:
        String r33 = y9c.d.i(getContext(), 2131891246);
        ICUUtils.FormatArgsBuilder r34 = new ICUUtils.FormatArgsBuilder();
        r34.b("name", r4);
        r10 = ICUUtils.icuFormat(r33, r34.a);
        goto L45
    L25:
        if (r13.E() != Message.RecallerIdentity.DOUBAO_QUERY_OWNER) goto L38;
        if (r2 == null) goto L28;
        String r35 = r2.a;
    L29:
        y6b.b r36 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.K8();
        if (r36 == null) goto L32;
        String r37 = r36.a;
    L34:
        if (Intrinsics.areEqual(r35, r37) == false) goto L36;
        String r38 = y9c.d.i(getContext(), 2131890168);
        ICUUtils.FormatArgsBuilder r39 = new ICUUtils.FormatArgsBuilder();
        r39.b("brandName", r3.e);
        r10 = ICUUtils.icuFormat(r38, r39.a);
    L37:
        Intrinsics.checkNotNull(r10);
        goto L91
    L36:
        String r40 = y9c.d.i(getContext(), 2131890167);
        ICUUtils.FormatArgsBuilder r41 = new ICUUtils.FormatArgsBuilder();
        r41.b("name", r5);
        r41.b("brandName", r3.e);
        r10 = ICUUtils.icuFormat(r40, r41.a);
        goto L37
    L32:
        r37 = null;
        goto L34
    L28:
        r35 = null;
        goto L29
    L17:
        r7 = false;
        goto L18
    L11:
        r5 = "";
        goto L12
    L5:
        if (p.g(r15.getComponentScene()) == false) goto L7;
        r16 = true;
        goto L8
    }

    public /* bridge */ /* synthetic */ void update(m r1, q r2, Object r3) {
        update(r1, r2, (y6b.a) r3);
    }
}

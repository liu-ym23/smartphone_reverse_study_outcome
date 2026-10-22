package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.bytedance.lark.pb.basic.v1.File;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text.BaseTextContentRender;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text.TextClickListenerProviderV2;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatTnsInfo;
import com.ss.android.lark.chat.entity.chat.ChatTnsOpKind;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.c1;
import com.ss.android.lark.chatbase.view.TextChatView2;
import com.ss.android.lark.chatwindow.view.widget.TouchInterceptionLayout;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class TextContentBlock implements com.ss.android.lark.blueprint.i<y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>, com.ss.android.lark.chat.base.view.vo.message.e>, e6b.a {
    public static final e6b.c j = null;
    public static final int k = 0;
    public final com.ss.android.lark.blueprint.g a;
    public final IMMessageKeys$Blocks b;
    public final Context c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final List<com.ss.android.lark.blueprint.j> h;
    public final Lazy i;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.blueprint.k<View> {
        public final View a;
        public TextChatView2 b;
        public TouchInterceptionLayout c;

        public final TextChatView2 a() {
            TextChatView2 r0 = this.b;
            if (r0 == null) goto L5;
            return r0;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("textChatView");
            return null;
        }

        public final View getView() {
            return this.a;
        }

        public b(TouchInterceptionLayout r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a = r2;
        }
    }

    public static final class c implements com.ss.android.lark.blueprint.k<View>, e9c.a, com.ss.android.lark.blueprint.t {
        public final View a;
        public final TextChatView2 b;
        public final TextView c;
        public final ImageView d;
        public final Group e;
        public final a f;

        public static final class a implements StackSlot.a, StackSlot.b {
            public final /* synthetic */ StackSlot.a.C0045a.C0046a b;
            public final StackSlot.b.a c;

            @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot.b
            public final /* synthetic */ void a() {
            }

            @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot.a
            public final void c() {
                this.b.getClass();
            }

            @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot.b
            public final /* synthetic */ void f() {
            }

            @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot.b
            public final /* synthetic */ void g() {
            }

            public a() {
                StackSlot.a.a.getClass();
                this.b = StackSlot.a.C0045a.b;
                this.c = new StackSlot.b.a(0);
            }

            @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot.b
            public final StackSlot.b.a b() {
                return this.c;
            }
        }

        public final com.ss.android.lark.blueprint.s a() {
            return this.f;
        }

        public final TextView d() {
            return this.c;
        }

        public final ImageView e() {
            return this.d;
        }

        public final View getView() {
            return this.a;
        }

        public c(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a = r2;
            this.b = (TextChatView2) r2.findViewById(2131389339);
            this.c = (TextView) r2.findViewById(2131389354);
            this.d = (ImageView) r2.findViewById(2131389346);
            this.e = r2.findViewById(2131369224);
            this.f = new a();
        }
    }

    public final Class<com.ss.android.lark.chat.base.view.vo.message.e> b() {
        return null;
    }

    static {
        j = new e6b.c(null);
        k = View.generateViewId();
    }

    public final b3b.f f() {
        return (b3b.f) this.e.getValue();
    }

    public final m2b.a g() {
        return (m2b.a) this.d.getValue();
    }

    public final Context getContext() {
        return this.c;
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.b;
    }

    public TextContentBlock(com.ss.android.lark.blueprint.g r3) {
        Intrinsics.checkNotNullParameter(r3, "ctx");
        this.a = r3;
        IMMessageKeys$Blocks r0 = IMMessageKeys$Blocks.TEXT_CONTENT;
        this.b = r0;
        this.c = r3.getContext();
        this.d = LazyKt.lazy(new TextContentBlock$chatContext$2(this));
        this.e = LazyKt.lazy(new TextContentBlock$callbackHub$2(this));
        this.f = LazyKt.lazy(new TextContentBlock$messageCellConfig$2(this));
        this.g = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, TextContentBlock$mPhoneDependency$2.INSTANCE);
        this.h = CollectionsKt.listOf(new com.ss.android.lark.blueprint.j[]{r0, j});
        this.i = LazyKt.lazy(new TextContentBlock$spanClickListener$2(this));
    }

    @Override // e6b.a
    public final e6b.a.C0216a e(com.ss.android.lark.blueprint.j r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        return new e6b.a.C0216a(this.h.indexOf(r3), this.h.size());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void d(TextContentBlock r1, TextChatView2 r2) {
        r1.getClass();
        r2.setTextSize(zz7.b.h(r2.getContext(), 17));
        r2.setShowMoreTextSize(zz7.b.h(r2.getContext(), 14));
    }

    public final void a(com.ss.android.lark.blueprint.m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>> r2, com.ss.android.lark.blueprint.q<y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>> r3) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        com.ss.android.lark.blueprint.i.a.a(r2, r3);
        com.ss.android.lark.blueprint.k r4 = r3.f(this.b, IMMessageKeys$Slots.CONTENT);
        TextChatView2 r5 = null;
        if (r4 == null) goto L5;
        View r6 = r4.getView();
    L7:
        if ((r6 instanceof TextChatView2) == false) goto L9;
        r5 = (TextChatView2) r6;
    L9:
        if (r5 == null) goto L14;
        LKUILightTextView r7 = r5.getLightTextView();
        if (r7 == null) goto L15;
        r7.w();
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r6 = null;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r3v38, types: [android.view.ViewGroup, com.ss.android.lark.chatbase.view.TextChatView2] */
    public void update(final com.ss.android.lark.blueprint.m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>> r26, com.ss.android.lark.blueprint.q<y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>> r27, final y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r28) {
        Intrinsics.checkNotNullParameter(r26, "cell");
        Intrinsics.checkNotNullParameter(r27, "layout");
        Intrinsics.checkNotNullParameter(r28, Keys.API_RETURN_KEY_DATA);
        if ((!r28.b().f().isEmpty()) == false) goto L5;
        boolean r3 = false;
    L6:
        e6b.c r11 = j;
        if (r3 == false) goto L15;
        IMMessageKeys$Blocks r1 = IMMessageKeys$Blocks.TEXT_CONTENT;
        IMMessageKeys$Slots r4 = IMMessageKeys$Slots.CONTENT;
        com.ss.android.lark.blueprint.k r2 = r27.f(r1, r4);
        if (r2 == null) goto L11;
        r2.getView().setVisibility(8);
    L11:
        com.ss.android.lark.blueprint.k r5 = r27.f(r11, r4);
        if (r5 == null) goto L167;
        r5.getView().setVisibility(8);
        return;
    L167:
        return;
    L15:
        m2b.a r6 = g();
        com.ss.android.lark.chat.base.view.vo.message.e r7 = r28.b();
        Intrinsics.checkNotNullParameter(r6, "<this>");
        if ((r6.k() & 16) <= 0) goto L18;
        boolean r8 = true;
    L20:
        if (h7b.l.d(r7) == true) goto L23;
        if (r8 == false) goto L23;
        boolean r9 = true;
    L25:
        if (r7.f != 3) goto L27;
        boolean r10 = true;
    L28:
        if (r9 == false) goto L32;
        if (r10 == true) goto L32;
        boolean r12 = false;
    L34:
        if (r9 == false) goto L37;
        if (r10 == false) goto L37;
        char r13 = 2;
    L41:
        if (r13 == 0) goto L47;
        if (r13 == 2) goto L47;
        com.ss.android.lark.blueprint.k r14 = r27.f(IMMessageKeys$Blocks.TEXT_CONTENT, IMMessageKeys$Slots.CONTENT);
        if (r14 == null) goto L46;
        r14.getView().setVisibility(8);
    L46:
        String r21 = "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.message.callbacks.BaseTextMessageCellCallback";
        char r15 = r13;
        e6b.c r23 = r11;
        String r24 = "item";
        y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r16 = r28;
        boolean r17 = true;
        int r18 = 8;
    L134:
        if (r15 != r17) goto L136;
    L140:
        c r19 = (c) r27.c(r23, IMMessageKeys$Slots.CONTENT, new TextContentBlock$renderTranslationText$blockView$1(this));
        r19.a.setVisibility(0);
        r19.d.setVisibility(0);
        Group r20 = r19.e;
        if (r15 != 2) goto L143;
        int r110 = 0;
    L144:
        r20.setVisibility(r110);
        if (e9c.b.a(r19, r16, g()) == true) goto L148;
        com.ss.android.lark.blueprint.m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>> r22 = r26;
    L165:
        m2b.a r25 = g();
        TextChatView2 r29 = r19.b;
        BaseTextContentRender.c r30 = (BaseTextContentRender.c) this.i.getValue();
        TextClickListenerProviderV2 r31 = new TextClickListenerProviderV2(g(), r19.b, new k0(false, this, r22));
        b3b.f r111 = f();
        Intrinsics.checkNotNull(r111, r21);
        new com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text.e(r25, r28, r29, r30, r31, r111).g();
        return;
    L148:
        if (g().q8() == false) goto L152;
        if (g().e0() == true) goto L152;
    L157:
        UIUtils.disableAllParentClipChild(r19.c);
        TextView r32 = r19.c;
        b3b.f r33 = f();
        m2b.a r34 = g();
        Intrinsics.checkNotNullParameter(r16, r24);
        if (r32 == null) goto L160;
        r32.setOnClickListener(new e9c.c(r33, r16, r34));
    L160:
        TextView r35 = r19.c;
        if (r35 == null) goto L163;
        y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r36 = r16;
        r22 = r26;
        r35.setOnLongClickListener(new l0(r22, this, r36));
    L164:
        e9c.b.c(r19.d, f(), r36, g());
        goto L165
    L163:
        r36 = r16;
        r22 = r26;
    L152:
        if (e9c.b.a == false) goto L157;
        TextView r37 = r19.c;
        if (r37 == null) goto L156;
        r37.setVisibility(r18);
    L156:
        r19.d.setVisibility(r18);
        goto L157
    L143:
        r110 = 8;
        goto L144
    L136:
        if (r15 == 2) goto L140;
        com.ss.android.lark.blueprint.k r38 = r27.f(r23, IMMessageKeys$Slots.CONTENT);
        if (r38 == null) goto L168;
        r38.getView().setVisibility(r18);
        return;
    L168:
        return;
    L47:
        b r39 = (b) r27.c(IMMessageKeys$Blocks.TEXT_CONTENT, IMMessageKeys$Slots.CONTENT, new TextContentBlock$renderOriginText$view$1(this));
        r39.a.setVisibility(0);
        com.ss.android.lark.biz.im.api.message.params.y r40 = g().d0(com.ss.android.lark.biz.im.api.message.params.y.class);
        if (r40 == null) goto L60;
        Integer r41 = r40.e;
        if (r41 == null) goto L60;
        int r42 = r41.intValue();
        TextChatView2 r43 = (TextChatView2) r39.a.findViewById(k);
        if (r43 == null) goto L56;
        LKUILightTextView r44 = r43.getLightTextView();
        if (r44 == null) goto L56;
        r44.setGravity(r42);
    L56:
        if (r43 == null) goto L60;
        LKUILightTextView r45 = r43.getLightTextView();
        if (r45 == null) goto L60;
        r45.setMinimumHeight(UIUtils.dp2px(this.c, 24.0f));
    L60:
        if (r40 == null) goto L85;
        com.ss.android.lark.biz.im.api.message.params.a0 r46 = r40.f;
        if (r46 == null) goto L85;
        if ((r28 instanceof y6b.c) == false) goto L85;
        Chat r47 = g().getChat();
        if (r47 == null) goto L70;
        ChatTnsInfo r48 = r47.getChatTnsInfo();
        if (r48 == null) goto L70;
        ChatTnsOpKind r49 = r48.getTnsOpKind();
    L72:
        if (r49 != ChatTnsOpKind.TNS_OP_BANNED) goto L74;
        boolean r50 = true;
    L75:
        TextChatView2 r51 = r39.a();
        y6b.c r112 = (y6b.c) r28;
        if (r112.K2 == true) goto L78;
    L81:
        boolean r52 = false;
    L82:
        int r113 = r46.a;
        float r114 = r46.b;
        float r53 = r46.c;
        LKUILightTextView r54 = r51.a;
        if (r54 == null) goto L85;
        r54.setEnableUnderline(r52);
        r54.setUnderlineOffsetY(r53);
        r54.setUnderlineColor(r113);
        r54.setUnderlineWidth(r114);
        goto L85
    L78:
        if (r112.i == false) goto L81;
        if (r50 == true) goto L81;
        r52 = true;
        goto L82
    L74:
        r50 = false;
    L70:
        r49 = null;
    L85:
        if (r40 == null) goto L91;
        Integer r55 = r40.i;
        if (r55 == null) goto L91;
        int r56 = r55.intValue();
        LKUILightTextView r57 = r39.a().getLightTextView();
        if (r57 == null) goto L91;
        r57.setSelectedColor(UIUtils.getColor(this.c, r56));
    L91:
        m2b.a r58 = g();
        TextChatView2 r59 = r39.a();
        BaseTextContentRender.c r115 = (BaseTextContentRender.c) this.i.getValue();
        m2b.a r116 = g();
        char r117 = r13;
        TextChatView2 r60 = r39.a();
        if (r40 == null) goto L94;
        boolean r61 = r40.h;
    L95:
        TextClickListenerProviderV2 r62 = new TextClickListenerProviderV2(r116, r60, new k0(r61, this, r26));
        b3b.f r118 = f();
        Intrinsics.checkNotNull(r118, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.message.callbacks.BaseTextMessageCellCallback");
        TouchInterceptionLayout r63 = r39.c;
        if (r63 == null) goto L98;
        TouchInterceptionLayout r119 = r63;
    L99:
        r21 = "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.message.callbacks.BaseTextMessageCellCallback";
        new com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text.d(r58, r28, r59, r115, r62, r118, r119).g();
        ArrayList<File> r64 = r28.b().f();
        if ((!r64.isEmpty()) == false) goto L117;
        ?? r65 = r39.a();
        if (r65.h != null) goto L104;
        View r66 = View.inflate(r65.getContext(), 2131559284, null);
        r65.g = r66;
        r65.f.addView(r66, new LinearLayout.LayoutParams(-2, -2));
        r65.h = (LinearLayout) r65.g.findViewById(2131363346);
    L104:
        LinearLayout r67 = r65.h;
        String r68 = r28.getId();
        Chat r69 = g().getChat();
        int r70 = r28.A();
        boolean r71 = r28.isPreMessage();
        Function1<View, Boolean> r72 = new TextContentBlock$renderOriginText$4(r26, this, r28);
        if (r28.isPreMessage() == true) goto L107;
    L109:
        boolean r120 = false;
    L110:
        m2b.a r121 = g();
        v4b.d r73 = (v4b.d) this.f.getValue();
        if (r73 == null) goto L115;
        MessageInfo r74 = r73.f;
        if (r74 == null) goto L115;
        Message r122 = r74.getMessage();
    L116:
        v4b.d r75 = (v4b.d) this.f.getValue();
        v4b.d r76 = (v4b.d) this.f.getValue();
        char r210 = r117;
        r23 = r11;
        r24 = "item";
        r16 = r28;
        com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text.d.b(r67, r64, r68, r69, r70, r71, r72, r120, null, r28, r121, r122, 256);
        r18 = 8;
    L124:
        v4b.d r77 = (v4b.d) this.f.getValue();
        if (r77 == null) goto L129;
        r17 = true;
        if (r77.i != true) goto L130;
        boolean r123 = true;
    L131:
        if (r123 == false) goto L133;
        r39.a().setDisableTouchEvent(r17);
    L133:
        r15 = r210;
    L130:
        r123 = false;
        goto L131
    L129:
        r17 = true;
    L115:
        r122 = null;
        goto L116
    L107:
        if (r28.G() != SendStatus.FAIL) goto L109;
        r120 = true;
        goto L110
    L117:
        r210 = r117;
        r24 = "item";
        r16 = r28;
        r23 = r11;
        TextChatView2 r78 = r39.a();
        LinearLayout r79 = r78.h;
        if (r79 == null) goto L120;
        r79.removeAllViews();
        r18 = 8;
        r78.h.setVisibility(8);
    L121:
        View r80 = r78.g;
        if (r80 == null) goto L124;
        r80.setVisibility(r18);
        goto L124
    L120:
        r18 = 8;
        goto L121
    L98:
        Intrinsics.throwUninitializedPropertyAccessException("container");
        r119 = null;
        goto L99
    L94:
        r61 = false;
    L37:
        if (r12 == false) goto L39;
        r13 = 0;
        goto L41
    L39:
        r13 = 1;
    L32:
        r12 = true;
        goto L34
    L27:
        r10 = false;
    L23:
        r9 = false;
        goto L25
    L18:
        r8 = false;
        goto L20
    L5:
        m2b.a r81 = g();
        v4b.d r82 = (v4b.d) this.f.getValue();
        int r83 = c1.a;
        Intrinsics.checkNotNullParameter(r28, "item");
        Intrinsics.checkNotNullParameter(r81, "chatContext");
        r3 = ChatCoreModule.a().isHideRichTextView(r28, r81, r82);
        goto L6
    }

    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m r1, com.ss.android.lark.blueprint.q r2, Object r3) {
        update(r1, r2, (y6b.a) r3);
    }

    public final void c(BlueprintCell r1, com.ss.android.lark.blueprint.q r2, Object r3, Object r4) {
        com.ss.android.lark.blueprint.i.a.b(this, r1, r2, (y6b.a) r3, (com.ss.android.lark.chat.base.view.vo.message.e) r4);
    }
}

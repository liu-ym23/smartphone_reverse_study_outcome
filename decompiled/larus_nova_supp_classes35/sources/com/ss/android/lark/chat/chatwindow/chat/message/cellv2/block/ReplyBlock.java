package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.coremd.utils.MessageStyleHelper;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.chat.ChatHitPoint;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ReplyBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {
    public final IMMessageKeys$Blocks g;
    public final Lazy h;

    public static final class a implements com.ss.android.lark.blueprint.k<View>, com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.b {
        public final View a;
        public final View b;
        public final TextView c;
        public final EllipsizedEmojiconTextView d;
        public final EllipsizedEmojiconTextView e;
        public final ImageView f;
        public final LKUIRoundableLayout g;
        public final View h;

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.b
        public final EllipsizedEmojiconTextView a() {
            return this.e;
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.b
        public final ImageView b() {
            return this.f;
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.b
        public final LKUIRoundableLayout c() {
            return this.g;
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.b
        public final EllipsizedEmojiconTextView d() {
            return this.d;
        }

        public final View getView() {
            return this.a;
        }

        public a(View r5) {
            Intrinsics.checkNotNullParameter(r5, "view");
            this.a = r5;
            this.b = r5.findViewById(2131384341);
            TextView r0 = (TextView) r5.findViewById(2131384360);
            this.c = r0;
            EllipsizedEmojiconTextView r1 = r5.findViewById(2131384346);
            this.d = r1;
            this.e = r5.findViewById(2131384347);
            this.f = (ImageView) r5.findViewById(2131384345);
            LKUIRoundableLayout r2 = r5.findViewById(2131384354);
            this.g = r2;
            this.h = r5.findViewById(2131384358);
            r2.setRadius(4.0f);
            r2.setBorderWidth(1.0f);
            Context r6 = r5.getContext();
            LarkFont r3 = LarkFont.BODY1;
            zz7.a.d(r0, r3);
            zz7.a.d(r1, r3);
            r1.setEmojiconSize(zz7.b.g(r6, 16));
            r1.setEmojiconTextSize((int) zz7.b.i(r6, r3));
        }
    }

    public static final class b implements com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.c.a {
        public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<?>> a;
        public final /* synthetic */ ReplyBlock b;
        public final /* synthetic */ y6b.a<?> c;

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.c.a
        public final boolean a(com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.b r2, y6b.c<?> r3) {
            Intrinsics.checkNotNullParameter(r2, "holder");
            Intrinsics.checkNotNullParameter(r3, "item");
            e6b.b r4 = this.a;
            if ((r4 instanceof e6b.b) == false) goto L5;
            e6b.b r5 = r4;
        L6:
            if (r5 != null) goto L10;
            return false;
        L10:
            return r5.e(this.b, this.c);
        L5:
            r5 = null;
            goto L6
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.c.a
        public final void b(com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.b r2, y6b.c<?> r3) {
            Intrinsics.checkNotNullParameter(r2, "holder");
            Intrinsics.checkNotNullParameter(r3, "item");
            ReplyBlock.h(this.b, (y6b.c) this.c);
        }

        public b(com.ss.android.lark.blueprint.m<y6b.a<?>> r1, ReplyBlock r2, y6b.a<?> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ReplyBlock a;
        public final /* synthetic */ y6b.a<?> b;

        public c(ReplyBlock r1, y6b.a<?> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ReplyBlock.h(this.a, (y6b.c) this.b);
        }
    }

    public static final class d implements View.OnLongClickListener {
        public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<?>> a;
        public final /* synthetic */ ReplyBlock b;
        public final /* synthetic */ y6b.a<?> c;

        public d(com.ss.android.lark.blueprint.m<y6b.a<?>> r1, ReplyBlock r2, y6b.a<?> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r3) {
            e6b.b r4 = this.a;
            if ((r4 instanceof e6b.b) == false) goto L5;
            e6b.b r5 = r4;
        L6:
            if (r5 != null) goto L10;
            return false;
        L10:
            return r5.e(this.b, this.c);
        L5:
            r5 = null;
            goto L6
        }
    }

    public com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.h i() {
        return (com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.h) this.h.getValue();
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.g;
    }

    public ReplyBlock(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys$Blocks.REPLY;
        this.h = LazyKt.lazy(new ReplyBlock$replyBlockRender$2(this));
    }

    public static final void h(ReplyBlock r3, y6b.c r4) {
        if (r3.c.e0() == true) goto L12;
        Fragment r0 = r3.c.R();
        if (r0 == null) goto L9;
        Lazy r1 = ForsetiConfig.a;
        if (ForsetiConfig.a(r3.c.getContext()) == false) goto L9;
        ChatCoreModule.a().getChatDependency().u(r3.c.getContext(), r4.c, z5c.u0.d.b, r0);
    L10:
        ChatHitPoint.a("parentMessage");
        return;
    L9:
        ChatCoreModule.a().getChatDependency().h(r3.c.getContext(), r4.c, z5c.u0.d.b);
        goto L10
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.a<?>> r18, com.ss.android.lark.blueprint.q<y6b.a<?>> r19, y6b.a<?> r20) {
        Intrinsics.checkNotNullParameter(r18, "cell");
        Intrinsics.checkNotNullParameter(r19, "layout");
        Intrinsics.checkNotNullParameter(r20, Keys.API_RETURN_KEY_DATA);
        y6b.b r5 = null;
        if ((r20 instanceof y6b.c) == false) goto L5;
        y6b.c r4 = (y6b.c) r20;
    L6:
        if (r4 != null) goto L8;
        return;
    L8:
        a r2 = (a) r19.c(this.g, IMMessageKeys$Slots.HEADER, new ReplyBlock$update$blockView$1(this));
        boolean r6 = MessageStyleHelper.b(r20);
        com.ss.android.lark.biz.im.api.message.params.v r7 = this.c.d0(com.ss.android.lark.biz.im.api.message.params.v.class);
        int r8 = 0;
        if (r7 == null) goto L72;
        Context r9 = r2.a.getContext();
        Float r10 = r7.d;
        if (r10 == null) goto L14;
        float r11 = r10.floatValue();
    L15:
        float r12 = RangesKt.coerceIn(r11, 0.0f, 1.0f);
        Float r13 = r7.c;
        if (r13 == null) goto L18;
        float r14 = r13.floatValue();
    L19:
        float r15 = RangesKt.coerceIn(r14, 0.0f, 1.0f);
        r2.c.setAlpha(r12);
        r2.d.setAlpha(r12);
        r2.e.setAlpha(r12);
        r2.b.setAlpha(r15);
        com.ss.android.lark.biz.im.api.message.params.o r16 = r7.a;
        if (r16 == null) goto L25;
        if (r6 == false) goto L23;
        int r17 = r16.a;
    L24:
        Intrinsics.checkNotNull(r9);
        int r21 = UDColorUtils.getColor(r9, r17);
        r2.c.setTextColor(r21);
        r2.d.setTextColor(r21);
        r2.e.setTextColor(r21);
        goto L25
    L23:
        r17 = r16.b;
    L25:
        com.ss.android.lark.biz.im.api.message.params.o r22 = r7.b;
        if (r22 == null) goto L34;
        if (r6 == false) goto L29;
        int r23 = r22.a;
    L30:
        Intrinsics.checkNotNull(r9);
        int r24 = UDColorUtils.getColor(r9, r23);
        Drawable r25 = r2.b.getBackground();
        if (r25 == null) goto L72;
        Drawable r26 = DrawableCompat.wrap(r25).mutate();
        DrawableCompat.setTint(r26, r24);
        r2.b.setBackground(r26);
        goto L34
    L29:
        r23 = r22.b;
    L34:
        Float r27 = r7.e;
        if (r27 == null) goto L37;
        float r28 = r27.floatValue();
        ViewGroup.LayoutParams r29 = r2.f.getLayoutParams();
        int r30 = UIUtils.dp2px(getContext(), r28);
        r29.width = r30;
        r29.height = r30;
        r2.f.setLayoutParams(r29);
    L37:
        Boolean r31 = r7.f;
        if (r31 != null) goto L40;
    L66:
        Boolean r32 = r7.f;
        if (r32 == null) goto L72;
        if (r32.booleanValue() == false) goto L71;
        r2.f.setScaleType(ImageView.ScaleType.CENTER_CROP);
        goto L72
    L71:
        r2.f.setScaleType(ImageView.ScaleType.FIT_CENTER);
        goto L72
    L40:
        if (r31.booleanValue() == false) goto L54;
        ViewGroup.LayoutParams r33 = r2.f.getLayoutParams();
        if ((r33 instanceof FrameLayout.LayoutParams) == false) goto L44;
        FrameLayout.LayoutParams r34 = (FrameLayout.LayoutParams) r33;
    L46:
        if (r34 == null) goto L48;
        r34.gravity = 16;
    L48:
        ViewGroup.LayoutParams r35 = r2.h.getLayoutParams();
        if ((r35 instanceof FrameLayout.LayoutParams) == false) goto L51;
        FrameLayout.LayoutParams r36 = (FrameLayout.LayoutParams) r35;
    L52:
        if (r36 == null) goto L66;
        r36.gravity = 16;
        goto L66
    L51:
        r36 = null;
        goto L52
    L44:
        r34 = null;
        goto L46
    L54:
        ViewGroup.LayoutParams r37 = r2.f.getLayoutParams();
        if ((r37 instanceof FrameLayout.LayoutParams) == false) goto L57;
        FrameLayout.LayoutParams r38 = (FrameLayout.LayoutParams) r37;
    L58:
        if (r38 == null) goto L60;
        r38.gravity = 0;
    L60:
        ViewGroup.LayoutParams r39 = r2.h.getLayoutParams();
        if ((r39 instanceof FrameLayout.LayoutParams) == false) goto L63;
        FrameLayout.LayoutParams r40 = (FrameLayout.LayoutParams) r39;
    L64:
        if (r40 == null) goto L66;
        r40.gravity = 0;
        goto L66
    L63:
        r40 = null;
        goto L64
    L57:
        r38 = null;
        goto L58
    L18:
        r14 = 1.0f;
        goto L19
    L14:
        r11 = 1.0f;
    L72:
        com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.h r41 = i();
        y6b.c r42 = (y6b.c) r20;
        boolean r43 = MessageStyleHelper.b(r20);
        int r44 = p3b.a.W;
        if (r43 == false) goto L75;
        int r45 = v4b.a.i;
    L76:
        if (r43 == false) goto L78;
        int r46 = v4b.a.x;
    L79:
        Drawable r47 = UIHelper.getDrawable(r46);
        u5b.b r110 = u5b.b.e;
        r110.a = r45;
        r110.b = r45;
        r110.c = r47;
        r110.d = new int[]{0, 0, 0, 0};
        b r48 = new b(r18, this, r20);
        r41.getClass();
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r42, "item");
        Intrinsics.checkNotNullParameter(r110, "replyStyle");
        r41.b.a(r48);
        r2.getClass();
        if (TextUtils.isEmpty(r42.R) == false) goto L85;
        View r49 = r2.a;
        if (r49 == null) goto L84;
        r49.setVisibility(8);
    L84:
        r2.b.setVisibility(8);
    L135:
        r2.a.setOnClickListener(new c(this, r20));
        r2.a.setOnLongClickListener(new d(r18, this, r20));
        return;
    L85:
        Chat r50 = r41.a.getChat();
        boolean r111 = true;
        if (r50 != null) goto L89;
    L117:
        boolean r51 = false;
    L118:
        if (r51 == false) goto L134;
        r2.a.setVisibility(0);
        int[] r52 = r110.d;
        r2.a.setPadding(r52[0], r52[1], r52[2], r52[3]);
        r2.b.setVisibility(0);
        r2.b.setBackground(r110.c);
        r2.c.setTextColor(r110.a);
        r2.d.setTextColor(r110.b);
        r2.e.setTextColor(r110.b);
        r2.c.setVisibility(0);
        y6b.c<T> r53 = r42.v1;
        if (r53 == 0) goto L122;
        r5 = r53.t;
    L122:
        if (r5 == null) goto L124;
        TextView r54 = r2.c;
        StringCompanionObject r112 = StringCompanionObject.INSTANCE;
        r54.setText(String.format("%s: ", Arrays.copyOf(new Object[]{r41.b.b(r5)}, 1)));
    L124:
        TextView r55 = r2.c;
        if (r5 != null) goto L128;
        r111 = false;
    L128:
        if (r111 == true) goto L131;
        r8 = 8;
    L131:
        r55.setVisibility(r8);
        y6b.c r56 = r42.v1;
        if (r56 == null) goto L135;
        r41.b.c(r56, r42, r2);
        goto L135
    L134:
        r2.a.setVisibility(8);
        goto L135
    L89:
        if (r42.n < (r50.getFirstMessagePosition() + 1)) goto L91;
    L95:
        boolean r57 = false;
    L97:
        if (r57 == false) goto L100;
        Log.w("ReplyBlockRender", "reply message is preMsg, skip bind");
    L100:
        if (r41.a.Y() == true) goto L102;
    L104:
        y6b.c<T> r113 = r42.v1;
        if (r113 != 0) goto L107;
        Log.w("ReplyBlockRender", "reply message vo is null,  skip bind");
    L110:
        y6b.c<T> r114 = r42.v1;
        if (r114 == 0) goto L113;
        boolean r115 = r114.k;
    L114:
        if (r115 == false) goto L117;
        if (r57 == true) goto L117;
        r51 = true;
        goto L118
    L113:
        r115 = false;
        goto L114
    L107:
        if (r113.k == true) goto L110;
        Log.w("ReplyBlockRender", "reply message is invisible, id is" + r113.c + ", skip bind");
        goto L110
    L102:
        if (r42.getType() == Message.Type.DOUBAO) goto L104;
    L91:
        if (r41.a.e0() == true) goto L95;
        if (r41.a.Y() == true) goto L95;
        r57 = true;
        goto L97
    L78:
        r46 = v4b.a.T;
        goto L79
    L75:
        r45 = v4b.a.H;
        goto L76
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r1, com.ss.android.lark.blueprint.q<y6b.a<?>> r2, y6b.a<?> r3) {
        update2(r1, r2, r3);
    }
}

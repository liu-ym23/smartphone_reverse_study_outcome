package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.lark.pb.basic.v1.Thread;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.base.view.vo.ThreadMessageVO;
import com.ss.android.lark.chat.base.view.vo.message.ThreadForwardContentVOV2;
import com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.ThreadReplyExposureView;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chatter.ChatterInfo;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ThreadForwardContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<ThreadForwardContentVOV2>, ThreadForwardContentVOV2> {
    public static final /* synthetic */ int w = 0;
    public final IMMessageKeys$Blocks g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public int o;
    public boolean p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.blueprint.k<View> {
        public final View a;
        public final FrameLayout b;
        public final View c;
        public final LKUIRoundedImageView2 d;
        public final TextView e;
        public final View f;
        public final TextView g;
        public final View h;
        public final TextView i;
        public final ThreadReplyExposureView j;
        public final View k;
        public final TextView l;
        public final View m;
        public final TextView n;

        public final View getView() {
            return this.a;
        }

        public b(View r7) {
            Intrinsics.checkNotNullParameter(r7, "view");
            this.a = r7;
            this.b = (FrameLayout) r7.findViewById(2131384835);
            this.c = r7.findViewById(2131389177);
            LKUIRoundedImageView2 r0 = r7.findViewById(2131388581);
            this.d = r0;
            TextView r1 = (TextView) r7.findViewById(2131388582);
            this.e = r1;
            this.f = r7.findViewById(2131369255);
            TextView r2 = (TextView) r7.findViewById(2131382828);
            this.g = r2;
            this.h = r7.findViewById(2131388589);
            TextView r3 = (TextView) r7.findViewById(2131388594);
            this.i = r3;
            this.j = (ThreadReplyExposureView) r7.findViewById(2131388588);
            this.k = r7.findViewById(2131388585);
            TextView r4 = (TextView) r7.findViewById(2131372078);
            this.l = r4;
            this.m = r7.findViewById(2131364527);
            this.n = (TextView) r7.findViewById(2131387018);
            zz7.a.c(r1, 17);
            zz7.a.a(r0, 20);
            zz7.a.c(r2, 14);
            zz7.a.c(r4, 17);
            zz7.a.c(r3, 12);
        }
    }

    static {
    }

    public final int h() {
        return ((Number) this.i.getValue()).intValue();
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.g;
    }

    public ThreadForwardContentBlock(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys$Blocks.THREAD_FORWARD_CONTENT;
        this.h = LazyKt.lazy(new ThreadForwardContentBlock$creatorAvatarSize$2(this));
        this.i = LazyKt.lazy(new ThreadForwardContentBlock$chatAvatarSize$2(this));
        this.j = LazyKt.lazy(new ThreadForwardContentBlock$chatDescTextSize$2(this));
        this.k = LazyKt.lazy(ThreadForwardContentBlock$minRenderWidth$2.INSTANCE);
        this.l = LazyKt.lazy(ThreadForwardContentBlock$horizontalPadding$2.INSTANCE);
        this.m = LazyKt.lazy(ThreadForwardContentBlock$needHandleItalicType$2.INSTANCE);
        this.n = LazyKt.lazy(ThreadForwardContentBlock$italicPadding$2.INSTANCE);
        this.o = PluginList.LEVEL_NOT_SET;
        this.q = LazyKt.lazy(ThreadForwardContentBlock$maxHeightFactor$2.INSTANCE);
        this.r = LazyKt.lazy(new ThreadForwardContentBlock$messageCellParams$2(this));
        this.s = LazyKt.lazy(new ThreadForwardContentBlock$groupAvatarPlaceholder$2(this));
        this.t = LazyKt.lazy(ThreadForwardContentBlock$boldSpan$2.INSTANCE);
        this.u = LazyKt.lazy(new ThreadForwardContentBlock$replyInThreadCallback$2(this));
        this.v = LazyKt.lazy(new ThreadForwardContentBlock$threadCallback$2(this));
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.a<ThreadForwardContentVOV2>> r21, com.ss.android.lark.blueprint.q<y6b.a<ThreadForwardContentVOV2>> r22, y6b.a<ThreadForwardContentVOV2> r23) {
        Intrinsics.checkNotNullParameter(r21, "cell");
        Intrinsics.checkNotNullParameter(r22, "layout");
        Intrinsics.checkNotNullParameter(r23, Keys.API_RETURN_KEY_DATA);
        b r2 = (b) r22.c(this.g, IMMessageKeys$Slots.CONTENT, ThreadForwardContentBlock$update$blockView$1.INSTANCE);
        ThreadForwardContentVOV2 r4 = r23.b();
        ChatterInfo r5 = r4.i;
        com.ss.android.lark.chat.utils.g.e(getContext(), r2.d, r5.getAvatarKey(), r5.getId(), ((Number) this.h.getValue()).intValue(), ((Number) this.h.getValue()).intValue(), Scene.Chat);
        r2.e.setText(r5.getName());
        if (r4.j.length() != 0) goto L5;
        boolean r6 = true;
    L6:
        String r8 = BuildConfig.FLAVOR;
        if (r6 == false) goto L9;
    L19:
        r2.g.setText(UIHelper.getString(2131891124));
    L20:
        String r7 = null;
        r2.j.f(null, r4.o);
        int r9 = r2.j.getShowingReplyCount();
        if (r4.n > r9) goto L23;
        r2.i.setVisibility(8);
    L24:
        View r10 = r2.h;
        if (r9 < 1) goto L27;
        boolean r11 = true;
    L28:
        if (r11 == false) goto L30;
        int r12 = 0;
    L31:
        r10.setVisibility(r12);
        String r13 = r23.getId();
        ThreadForwardContentVOV2 r14 = r23.b();
        Thread r15 = ((MergeForwardContent) r14.a).getThread();
        if (r15 == null) goto L37;
        String r16 = r15.id;
        if (r16 == null) goto L37;
        r8 = r16;
    L37:
        r2.k.setOnClickListener(new t0(r14, this, r8, r13));
        r2.k.setOnLongClickListener(new u0(r21, this, r23));
        if (this.c.r() == false) goto L40;
    L41:
        r2.a.setBackgroundResource(2131244036);
    L42:
        v4b.d r1 = this.e;
        if (r1 == null) goto L45;
        int r3 = r1.d;
    L116:
        int r17 = r3 - (((Number) this.l.getValue()).intValue() * 2);
        r2.a.getLayoutParams().width = r3;
        if (r17 >= ((Number) this.k.getValue()).intValue()) goto L119;
        boolean r18 = true;
    L120:
        FrameLayout r19 = r2.b;
        if ((!r18) == false) goto L123;
        int r110 = 0;
    L124:
        r19.setVisibility(r110);
        TextView r20 = r2.l;
        if (r18 == false) goto L127;
        int r111 = 0;
    L128:
        r20.setVisibility(r111);
        if (r18 == true) goto L163;
        Message r24 = r4.h;
        MessageInfo r25 = new MessageInfo(r24, null);
        FrameLayout r26 = r2.b;
        if (((List) this.m.getValue()).contains(r24.getType()) == false) goto L133;
        int r112 = ((Number) this.n.getValue()).intValue();
    L134:
        int r27 = r17 - r112;
        Log.i("ThreadForwardMessageCellV2", "bind root message, last width = " + this.o + ", new width = " + r27);
        if (r24.isRecalled() == false) goto L137;
    L146:
        boolean r113 = true;
    L147:
        v4b.d.a r28 = new v4b.d.a();
        r28.b = r27;
        r28.a = false;
        ArrayList r114 = new ArrayList();
        Intrinsics.checkNotNullParameter(r114, "cardDown2TextList");
        r28.c = r114;
        r28.e = true;
        v4b.d r115 = new v4b.d(r28);
        if (r26.getChildCount() == 1) goto L150;
    L154:
        r26.removeAllViews();
        ((Map) this.r.getValue()).put(com.ss.android.lark.biz.im.api.message.params.d.class, new com.ss.android.lark.biz.im.api.message.params.d(new com.ss.android.lark.biz.im.api.message.params.d.a()));
        Map r29 = (Map) this.r.getValue();
        View r30 = ChatCoreModule.a().getChatDependency().c(r26, r25);
        if (r30 != null) goto L158;
    L165:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("message.message_sending_source") == true) goto L167;
        r2.n.setVisibility(8);
        return;
    L167:
        boolean r31 = r23 instanceof ThreadMessageVO;
        if (r31 == false) goto L175;
        if (r31 == false) goto L171;
        ThreadMessageVO r32 = (ThreadMessageVO) r23;
    L172:
        if (r32 == null) goto L184;
        Intrinsics.checkNotNull(null);
    L184:
        if (r7 != null) goto L187;
        r2.n.setVisibility(8);
        return;
    L187:
        if (r7.length() != 0) goto L189;
        boolean r33 = true;
    L190:
        if (r33 == false) goto L192;
        String r34 = UIUtils.getString(r2.a.getContext(), 2131891379);
    L193:
        r2.n.setVisibility(0);
        zz7.a.d(r2.n, LarkFont.CAPTION0);
        r2.n.setText(r34);
        return;
    L192:
        String r35 = y9c.d.i(r2.a.getContext(), 2131891378);
        ICUUtils.FormatArgsBuilder r36 = new ICUUtils.FormatArgsBuilder();
        r36.b("appName", r7);
        r34 = ICUUtils.icuFormat(r35, r36.a);
        goto L193
    L189:
        r33 = false;
        goto L190
    L171:
        r32 = null;
        goto L172
    L175:
        if ((r23 instanceof y6b.c) == false) goto L177;
        y6b.c r37 = (y6b.c) r23;
    L178:
        if (r37 == null) goto L184;
        ThreadForwardContentVOV2 r38 = (ThreadForwardContentVOV2) r37.o;
        if (r38 == null) goto L184;
        Message r39 = r38.h;
        if (r39 == null) goto L184;
        r7 = r39.getAppInfoItemName();
        goto L184
    L177:
        r37 = null;
        goto L178
    L158:
        if (r24.getType() == Message.Type.IMAGE) goto L160;
    L162:
        r26.addView(r30);
        r24.getId();
        this.o = r27;
        this.p = r113;
        goto L165
    L160:
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("im.message.thread_reply_bubble_optimize") == false) goto L162;
        r30.findViewById(2131367794).setRadius(4.0f);
        goto L162
    L150:
        if (this.p != r113) goto L154;
        if (ChatCoreModule.a().getChatDependency().p(r26.getChildAt(0), r25, r115) == false) goto L154;
    L137:
        if (r24.isBurned() == true) goto L146;
        if (r24.isRemoved() == true) goto L146;
        if (r24.isSetGrey() == true) goto L143;
    L145:
        r113 = false;
        goto L147
    L143:
        if (r24.isCleaned() == true) goto L145;
    L133:
        r112 = 0;
        goto L134
    L163:
        Log.i("ThreadForwardMessageCellV2", "display fallback tip, message id = " + r23.getId() + ", cardRenderWidth = " + r3 + ", rootMessageWidth = " + r17);
        goto L165
    L127:
        r111 = 8;
        goto L128
    L123:
        r110 = 8;
        goto L124
    L119:
        r18 = false;
        goto L120
    L45:
        boolean r40 = this.c.s8();
        if (this.c.Y() == false) goto L74;
        boolean r41 = r23 instanceof y6b.c;
        if (r41 == true) goto L50;
    L52:
        boolean r42 = false;
    L53:
        if (r41 == true) goto L55;
    L57:
        boolean r43 = false;
    L58:
        if (r42 == false) goto L65;
        int r44 = u2b.j.a;
        Context r45 = getContext();
        Integer r116 = f3b.b.a(this.c);
        Intrinsics.checkNotNullParameter(r45, "context");
        int r46 = u2b.j.n(r45, r116) - (u2b.j.g * 2);
        if (r40 == false) goto L62;
        int r47 = u2b.j.o;
    L63:
        if (r43 == false) goto L71;
        int r48 = u2b.j.p;
    L72:
        int r49 = (r46 - r47) - r48;
        int r50 = 0;
    L76:
        int r51 = r49 - r50;
    L77:
        r3 = r51;
    L71:
        r48 = 0;
        goto L72
    L62:
        r47 = 0;
        goto L63
    L65:
        int r52 = u2b.j.a;
        Context r53 = getContext();
        Integer r117 = f3b.b.a(this.c);
        Intrinsics.checkNotNullParameter(r53, "context");
        r46 = ((u2b.j.n(r53, r117) - (u2b.j.g * 2)) - zz7.b.g(r53, 36)) - u2b.j.k;
        if (r40 == false) goto L68;
        r47 = u2b.j.o;
    L69:
        if (r43 == false) goto L71;
        r48 = u2b.j.p;
        goto L72
    L68:
        r47 = 0;
        goto L69
    L55:
        if (((y6b.c) r23).V1 == false) goto L57;
        r43 = true;
        goto L58
    L50:
        if (((y6b.c) r23).Y() == false) goto L52;
        r42 = true;
        goto L53
    L74:
        if (this.c.m() == false) goto L79;
        int r54 = u2b.j.a;
        Context r55 = getContext();
        Integer r56 = f3b.b.a(this.c);
        Intrinsics.checkNotNullParameter(r55, "context");
        int r57 = u2b.j.n(r55, r56) - (u2b.j.f * 2);
        r50 = 0;
        r49 = r57 + 0;
        goto L76
    L79:
        if (this.c.q() == false) goto L96;
        if ((r23 instanceof y6b.c) == true) goto L83;
    L85:
        boolean r58 = false;
    L86:
        if (r58 == false) goto L90;
        int r59 = u2b.j.a;
        Context r60 = getContext();
        Integer r61 = f3b.b.a(this.c);
        Intrinsics.checkNotNullParameter(r60, "context");
        int r62 = u2b.j.n(r60, r61) - (u2b.j.g * 2);
        if (r40 == false) goto L93;
        int r63 = u2b.j.o;
    L94:
        r3 = r62 - r63;
    L93:
        r63 = 0;
        goto L94
    L90:
        int r64 = u2b.j.a;
        Context r65 = getContext();
        Integer r66 = f3b.b.a(this.c);
        Intrinsics.checkNotNullParameter(r65, "context");
        r62 = (u2b.j.n(r65, r66) - zz7.b.g(r65, 48)) - u2b.j.g;
        if (r40 == false) goto L93;
        r63 = u2b.j.o;
        goto L94
    L83:
        if (((y6b.c) r23).Z() == false) goto L85;
        r58 = true;
        goto L86
    L96:
        if (this.c.r() == false) goto L99;
        int r67 = u2b.j.a;
        Context r68 = getContext();
        Integer r69 = f3b.b.a(this.c);
        Intrinsics.checkNotNullParameter(r68, "context");
        r3 = u2b.j.n(r68, r69);
        int r70 = u2b.j.g;
    L111:
        r3 = r3 - (r70 * 2);
        goto L116
    L99:
        if (r23.d() == true) goto L101;
    L105:
        boolean r71 = false;
    L106:
        if (r40 == false) goto L112;
        int r72 = u2b.j.a;
        Context r73 = getContext();
        Integer r74 = f3b.b.a(this.c);
        Intrinsics.checkNotNullParameter(r73, "context");
        r3 = (((u2b.j.n(r73, r74) - zz7.b.g(r73, 56)) - u2b.j.d) - zz7.b.g(r73, u2b.j.b)) - u2b.j.c;
        if (r71 == false) goto L116;
        r70 = u2b.j.e;
        goto L111
    L112:
        Context r75 = getContext();
        Integer r76 = f3b.b.a(this.c);
        int r118 = u2b.j.a;
        Intrinsics.checkNotNullParameter(r75, "context");
        r51 = (((u2b.j.n(r75, r76) - (u2b.j.a + (zz7.b.g(r75, 32) - UIHelper.dp2px(32.0f)))) - u2b.j.d) - zz7.b.g(r75, u2b.j.b)) - u2b.j.c;
        if (r71 == false) goto L77;
        r51 = r51 - (u2b.j.e * 2);
        goto L77
    L101:
        if (this.c.q8() == false) goto L103;
    L104:
        r71 = true;
        goto L106
    L103:
        if (this.c.e0() == false) goto L105;
    L40:
        if (this.c.q() == false) goto L42;
    L30:
        r12 = 8;
        goto L31
    L27:
        r11 = false;
        goto L28
    L23:
        r2.i.setVisibility(0);
        r2.i.setText(UIHelper.getQuantityString(2131755067, r4.n - r9));
        goto L24
    L9:
        if (r4.f() == false) goto L19;
        String r119 = UIUtils.getString(getContext(), 2131891126);
        StringBuilder r77 = new StringBuilder();
        if (r4.m == false) goto L14;
        String r78 = "group_avatar ";
    L15:
        r77.append(r78);
        r77.append(r4.j);
        String r79 = r77.toString();
        String r80 = ICUUtils.icuFormat(r119, "chatName", r79);
        getContext();
        CharSequence r120 = new ncc.g(r80);
        Intrinsics.checkNotNull(r119);
        int r81 = StringsKt.indexOf$default(r119, "{chatName}", 0, false, 6, null);
        r120.setSpan((StyleSpan) this.t.getValue(), r81, r79.length() + r81, 33);
        if (r4.m == false) goto L18;
        r120.setSpan(new com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.b(getContext(), (Drawable) this.s.getValue(), new v0(r2), (int) ((Number) this.j.getValue()).floatValue(), h(), r4.l, r4.k), r81, r81 + 12, 33);
    L18:
        r2.g.setText(r120);
        goto L20
    L14:
        r78 = BuildConfig.FLAVOR;
        goto L15
    L5:
        r6 = false;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<ThreadForwardContentVOV2>> r1, com.ss.android.lark.blueprint.q<y6b.a<ThreadForwardContentVOV2>> r2, y6b.a<ThreadForwardContentVOV2> r3) {
        update2(r1, r2, r3);
    }
}

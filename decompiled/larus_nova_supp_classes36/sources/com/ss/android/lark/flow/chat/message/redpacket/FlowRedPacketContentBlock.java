package com.ss.android.lark.flow.chat.message.redpacket;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.entity.chatter.ChatterInfo;
import com.ss.android.lark.chat.entity.message.content.RedPacketContent;
import com.ss.android.lark.chat.entity.redpacket.RedPacketCover;
import com.ss.android.lark.chat.entity.redpacket.RedPacketDisplayName;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.flow.chat.databinding.FlowChatMessageV2BlockRedPacketContentBinding;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.PassThroughImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowRedPacketContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<com.ss.android.lark.flow.chat.message.redpacket.c>, Object> {
    public final IMMessageKeys.Blocks g;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RedPacketContent.Type.values().length];
            r0[RedPacketContent.Type.DESIGNATED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[RedPacketContent.Type.GROUP_RANDOM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ FlowRedPacketContentBlock a;
        public final /* synthetic */ y6b.a<com.ss.android.lark.flow.chat.message.redpacket.c> b;

        public c(FlowRedPacketContentBlock r1, y6b.a<com.ss.android.lark.flow.chat.message.redpacket.c> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            String r6 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this.a).c.getChatId();
            if (r6 != null) goto L6;
            Log.w("FlowRedPacketContentBlock", "onRedPacketClick, chatId is null, skip jump");
            return;
        L6:
            Log.i("FlowRedPacketContentBlock", "onRedPacketClick, jump to feishu chat, position: " + this.b.A());
            int r0 = FlowChatModule.d;
            FlowChatModule.a.a().a().getBrowserDependency().openUrl(this.a.getContext(), "https://applink.feishu.cn/client/chat/open?chatId=" + r6 + "&position=" + this.b.A());
        }
    }

    static {
    }

    public final j getKey() {
        return this.g;
    }

    public FlowRedPacketContentBlock(g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys.Blocks.FLOW_RED_PACKET_CONTENT;
    }

    public void update(m<y6b.a<com.ss.android.lark.flow.chat.message.redpacket.c>> r13, q<y6b.a<com.ss.android.lark.flow.chat.message.redpacket.c>> r14, y6b.a<com.ss.android.lark.flow.chat.message.redpacket.c> r15) {
        Intrinsics.checkNotNullParameter(r13, "cell");
        Intrinsics.checkNotNullParameter(r14, "layout");
        Intrinsics.checkNotNullParameter(r15, "data");
        FlowChatMessageV2BlockRedPacketContentBinding r16 = (FlowChatMessageV2BlockRedPacketContentBinding) r14.c(this.g, IMMessageKeys.Slots.CONTENT, FlowRedPacketContentBlock$update$blockView$1.INSTANCE).a;
        RedPacketContent r0 = ((v5b.a) ((com.ss.android.lark.flow.chat.message.redpacket.c) r15.b())).a;
        boolean r1 = r15.h();
        if (r1 == true) goto L5;
    L7:
        RedPacketContent.Type r3 = r0.getType();
        RedPacketContent.Type r4 = RedPacketContent.Type.DESIGNATED;
        if (r3 != r4) goto L15;
        if (r0.getCanGrab() == true) goto L15;
        if (r0.isExpired() == false) goto L15;
        Pair r2 = TuplesKt.to(Boolean.FALSE, UIUtils.getString(getContext(), 2131891834));
    L39:
        boolean r5 = ((Boolean) r2.component1()).booleanValue();
        String r6 = (String) r2.component2();
        Intrinsics.checkNotNull(r6);
        Intrinsics.checkNotNullParameter(r6, "statusText");
        r16.a.setClipToOutline(true);
        if (r15.l() == false) goto L42;
    L47:
        float r7 = 8.0f;
    L48:
        Iterator r8 = CollectionsKt.listOf(new LKUIRoundedImageView2[]{r16.m, r16.k, r16.i, r16.j}).iterator();
    L50:
        if (r8.hasNext() == false) goto L52;
        ((LKUIRoundedImageView2) r8.next()).setRadiusInDp(r7);
        goto L50
    L52:
        r16.n.setText(r0.getSubject());
        TextView r9 = r16.n;
        RedPacketContent.Type r10 = r0.getType();
        RedPacketContent.Type r11 = RedPacketContent.Type.DESIGNATED;
        if (r10 != r11) goto L55;
        int r12 = 1;
    L56:
        r9.setMaxLines(r12);
        if (r0.getType() != RedPacketContent.Type.B2C_RANDOM) goto L59;
    L68:
        RedPacketCover r17 = r0.getCover();
        if (r17 == null) goto L71;
        String r18 = r17.getName();
    L72:
        if (r18 != null) goto L74;
    L77:
        boolean r19 = true;
    L78:
        if (r19 == false) goto L80;
        r16.l.setText(2131892475);
    L82:
        if (r5 == true) goto L84;
        r16.h.setAlpha(0.5f);
        r16.f.setEnabled(false);
        r16.m.setVisibility(0);
        r16.m.setBackgroundColor(UIUtils.getColor(getContext(), 2131100548));
    L85:
        r16.g.setText(r6);
        TextView r20 = r16.g;
        if (r6.length() <= 0) goto L88;
        boolean r21 = true;
    L89:
        if (r21 == false) goto L91;
        int r22 = 0;
    L92:
        r20.setVisibility(r22);
        RedPacketCover r23 = r0.getCover();
        if (r23 == null) goto L95;
        PassThroughImage r24 = r23.getMessageCover();
    L97:
        if (r24 != null) goto L103;
        r16.k.setImageResource(2131235349);
        TextView r25 = r16.n;
        ViewGroup.LayoutParams r110 = r25.getLayoutParams();
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r110;
        Context r26 = getContext();
        if (r0.getType() != r11) goto L101;
        float r112 = 24.0f;
    L102:
        r111.topMargin = UIUtils.dp2px(r26, r112);
        r25.setLayoutParams(r111);
        r16.c.setVisibility(8);
    L104:
        LKUIRoundedImageView2 r27 = r16.i;
        if (r24 == null) goto L107;
    L112:
        boolean r28 = true;
    L113:
        if (r28 == false) goto L115;
        int r29 = 0;
    L116:
        r27.setVisibility(r29);
        LKUIRoundedImageView2 r30 = r16.i;
        ViewGroup.LayoutParams r31 = r30.getLayoutParams();
        Context r32 = getContext();
        if (r0.getType() != r11) goto L119;
        float r113 = 176.0f;
    L120:
        r31.height = UIUtils.dp2px(r32, r113);
        r30.setLayoutParams(r31);
        RedPacketCover r33 = r0.getCover();
        if (r33 == null) goto L125;
        RedPacketDisplayName r34 = r33.getDisplayName();
        if (r34 == null) goto L125;
        String r35 = r34.getDisplayName();
    L126:
        RedPacketCover r36 = r0.getCover();
        if (r36 == null) goto L129;
        String r37 = r36.getCompanyName();
    L131:
        if (r0.getType().isB2C() == false) goto L133;
        r35 = r37;
    L133:
        TextView r38 = r16.c;
        if (r35 != null) goto L136;
    L139:
        boolean r39 = true;
    L140:
        if (r39 == false) goto L142;
        int r40 = 8;
    L143:
        r38.setVisibility(r40);
        r16.c.setText(r35);
        RedPacketCover r41 = r0.getCover();
        if (r41 == null) goto L148;
        RedPacketDisplayName r42 = r41.getDisplayName();
        if (r42 == null) goto L148;
        PassThroughImage r43 = r42.getBackgroundImage();
    L149:
        if (r43 == null) goto L151;
        ImageLoader.with(getContext()).load(r43).into(new com.ss.android.lark.flow.chat.message.redpacket.b(this, r16));
    L151:
        RedPacketCover r44 = r0.getCover();
        if (r44 == null) goto L154;
        PassThroughImage r45 = r44.getCompanyLogo();
    L155:
        if (r45 != null) goto L157;
        r16.b.setImageDrawable(null);
    L162:
        if (r0.getType() == r11) goto L165;
        r16.d.setVisibility(8);
        r16.e.setVisibility(8);
    L178:
        r16.a.setOnClickListener(new c(this, r15));
        f(r16.a, r13, r15);
        return;
    L165:
        if (r0.getTotalNum() == 1) goto L167;
    L169:
        String r46 = UIHelper.mustacheFormat(2131890634, "num", String.valueOf(r0.getTotalNum()));
    L170:
        TextView r47 = r16.e;
        if ((true ^ r0.getPreviewUsers().isEmpty()) == false) goto L173;
        int r48 = 0;
    L174:
        r47.setVisibility(r48);
        r16.e.setText(r46);
        if (r0.getPreviewUsers().isEmpty() == false) goto L177;
        r16.d.setVisibility(8);
        goto L178
    L177:
        r16.d.setVisibility(0);
        r16.d.setAdapter(new com.ss.android.lark.flow.chat.message.redpacket.a(UIUtils.dp2px(getContext(), 24.0f), r0.getPreviewUsers()));
        r16.d.setOverlapWidth(new UDDimension.Dp(6.0f));
        goto L178
    L173:
        r48 = 8;
        goto L174
    L167:
        if (CollectionsKt.firstOrNull(r0.getPreviewUsers()) == null) goto L169;
        r46 = UIHelper.mustacheFormat(2131890633, "name", ((ChatterInfo) CollectionsKt.first(r0.getPreviewUsers())).getName());
        goto L170
    L157:
        ImageLoader.with(getContext()).load(r45).into(r16.b);
        if (r0.getType().isB2C() == false) goto L160;
        r16.b.setOval(true);
        r16.b.setBackgroundColor(UDColorUtils.getColor(getContext(), 2131106521));
        goto L162
    L160:
        r16.b.setOval(false);
        r16.b.setBackground(null);
        goto L162
    L154:
        r45 = null;
    L148:
        r43 = null;
        goto L149
    L142:
        r40 = 0;
        goto L143
    L136:
        if (r35.length() == 0) goto L139;
        r39 = false;
        goto L140
    L129:
        r37 = null;
    L125:
        r35 = null;
        goto L126
    L119:
        r113 = 108.0f;
        goto L120
    L115:
        r29 = 8;
        goto L116
    L107:
        if (r0.getType() == r11) goto L112;
        if (r0.getType().isB2C() == true) goto L112;
        r28 = false;
        goto L113
    L101:
        r112 = 36.0f;
        goto L102
    L103:
        ImageLoader.with(getContext()).load(r24).placeholder(2131235349).dontAnimate(!r5).into(r16.k);
        TextView r49 = r16.n;
        ViewGroup.LayoutParams r114 = r49.getLayoutParams();
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r114;
        r115.topMargin = UIUtils.dp2px(getContext(), 24.0f);
        r49.setLayoutParams(r115);
        goto L104
    L95:
        r24 = null;
        goto L97
    L91:
        r22 = 8;
        goto L92
    L88:
        r21 = false;
        goto L89
    L84:
        r16.h.setAlpha(1.0f);
        r16.f.setEnabled(true);
        r16.m.setVisibility(8);
        goto L85
    L80:
        r16.l.setText(r18);
        goto L82
    L74:
        if (r18.length() == 0) goto L77;
        r19 = false;
        goto L78
    L71:
        r18 = null;
        goto L72
    L59:
        if (r0.getType() == RedPacketContent.Type.B2C_FIX) goto L68;
        TextView r50 = r16.l;
        int r51 = b.a[r0.getType().ordinal()];
        if (r51 == 1) goto L66;
        if (r51 == 2) goto L65;
        int r52 = 2131892029;
    L67:
        r50.setText(r52);
        goto L82
    L65:
        r52 = 2131892114;
        goto L67
    L66:
        r52 = 2131890632;
        goto L67
    L55:
        r12 = 2;
        goto L56
    L42:
        if (r15.d() == true) goto L47;
        if (((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.Y() == true) goto L47;
        r7 = 0.0f;
    L15:
        if (r0.getType() != r4) goto L22;
        if (r0.getCanGrab() == true) goto L22;
        if (r0.isGrabbedFinish() == false) goto L22;
        r2 = TuplesKt.to(Boolean.FALSE, "");
    L22:
        if (r0.isGrabbed() == false) goto L25;
        r2 = TuplesKt.to(Boolean.FALSE, UIUtils.getString(getContext(), 2131891836));
        goto L39
    L25:
        if (r0.isGrabbedFinish() == false) goto L28;
        r2 = TuplesKt.to(Boolean.FALSE, UIUtils.getString(getContext(), 2131891835));
        goto L39
    L28:
        if (r0.isExpired() == false) goto L31;
        r2 = TuplesKt.to(Boolean.FALSE, UIUtils.getString(getContext(), 2131891834));
        goto L39
    L31:
        if (r0.getType() == r4) goto L33;
    L38:
        r2 = TuplesKt.to(Boolean.TRUE, "");
        goto L39
    L33:
        if (r0.getCanGrab() == true) goto L38;
        if (r1 == true) goto L38;
        if (r0.isClicked() == false) goto L38;
        r2 = TuplesKt.to(Boolean.FALSE, "");
        goto L39
    L5:
        if (r0.isGrabbedFinish() == false) goto L7;
        r2 = TuplesKt.to(Boolean.FALSE, UIUtils.getString(getContext(), 2131891835));
        goto L39
    }

    public /* bridge */ /* synthetic */ void update(m r1, q r2, Object r3) {
        update(r1, r2, (y6b.a) r3);
    }
}

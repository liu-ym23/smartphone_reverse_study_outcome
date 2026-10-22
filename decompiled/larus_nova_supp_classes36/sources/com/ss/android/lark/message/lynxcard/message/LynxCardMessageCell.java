package com.ss.android.lark.message.lynxcard.message;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.lark.pb.basic.v1.MessageLocalDataInfo;
import com.larksuite.component.card.cardcontainer.CardImpl;
import com.larksuite.component.card.cardcontainer.UniversalCardLynxRender;
import com.larksuite.component.card.component.header.CardHeaderView;
import com.larksuite.component.card.navigation.UniversalCardLargeScreenAdapt;
import com.larksuite.component.card.protocol.CardConfig;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.protocol.CardRenderData;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.lynx.tasm.base.TraceEvent;
import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.chat.export.ui.message.style.BubbleStyle;
import com.ss.android.lark.chat.utils.f0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.message.lynxcard.entity.LynxCardContentVO;
import com.ss.android.lark.message.lynxcard.entity.SummaryHolder;
import com.ss.android.lark.message.lynxcard.settings.CardMessageUserLynxRenderSettings;
import com.ss.android.lark.message.universalcard.datachannel.MessageCardRenderUtils;
import com.ss.android.lark.message.universalcard.datachannel.MessageCardStreamingManager;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.EllipsizeFrameLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class LynxCardMessageCell implements r5b.d<LynxCardContentVO>, u5b.a<LynxCardContentVO>, e6b.e<LynxCardContentVO>, com.ss.android.lark.message.lynxcard.message.a, com.ss.android.lark.message.lynxcard.message.b, com.ss.android.lark.message.lynxcard.message.c {
    public final r5b.a a;
    public final r5b.b<LynxCardContentVO> b;
    public OPTrace c;
    public final boolean d;
    public final Lazy e;

    public static final class a {
    }

    public static final class b extends Drawable {
        public final float a;
        public final Paint b;
        public final RectF c;

        @Override // android.graphics.drawable.Drawable
        public final int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas r4) {
            Intrinsics.checkNotNullParameter(r4, "canvas");
            this.c.set(getBounds());
            RectF r0 = this.c;
            float r1 = this.a;
            r4.drawRoundRect(r0, r1, r1, this.b);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int r2) {
            this.b.setAlpha(r2);
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter r2) {
            this.b.setColorFilter(r2);
            invalidateSelf();
        }

        public b(int r2, float r3) {
            this.a = r3;
            Paint r4 = new Paint(1);
            r4.setColor(r2);
            this.b = r4;
            this.c = new RectF();
        }
    }

    public static final class c implements View.OnLongClickListener {
        public final /* synthetic */ LynxCardContentVO a;
        public final /* synthetic */ LynxCardMessageCell b;
        public final /* synthetic */ LynxCardViewHolder c;
        public final /* synthetic */ v5b.c<LynxCardContentVO> d;

        public c(LynxCardContentVO r1, LynxCardMessageCell r2, LynxCardViewHolder r3, v5b.c<LynxCardContentVO> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r3) {
            int r4 = MessageCardRenderUtils.a;
            if (MessageCardRenderUtils.a(this.a) == false) goto L6;
            return true;
        L6:
            LynxCardMessageCell r5 = this.b;
            LynxCardViewHolder r0 = this.c;
            Intrinsics.checkNotNull(r0);
            return LynxCardMessageCell.l(r5, r0, this.d);
        }
    }

    static {
    }

    public final MessageCardStreamingManager n() {
        return (MessageCardStreamingManager) this.e.getValue();
    }

    public final Class<LynxCardContentVO> c() {
        return LynxCardContentVO.class;
    }

    public static Drawable m(int r4) {
        float r0 = UIHelper.dp2px(50.0f);
        GradientDrawable r1 = new GradientDrawable();     // Catch: RuntimeException -> L5
        r1.setColor(r4);     // Catch: RuntimeException -> L5
        r1.setCornerRadius(r0);     // Catch: RuntimeException -> L5
        return r1;
    L5:
        e = move-exception;
        Log.e("LynxCardMessageCell", "create reply gradient drawable failed", e);
        return new b(r4, r0);
    }

    @Override // com.ss.android.lark.message.lynxcard.message.a
    public final void b(LynxCardViewHolder r4) {
        Intrinsics.checkNotNullParameter(r4, "viewHolder");
        Log.i("LynxCardMessageCell", "onViewAttachedToWindow " + hashCode());
        MessageCardStreamingManager r1 = n();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "viewHolder");
        v5b.c<LynxCardContentVO> r0 = r4.k;
        if (r0 == null) goto L11;
        LynxCardContentVO r2 = r0.b();
        if (r2 != null) goto L8;
        return;
    L8:
        if (MessageCardRenderUtils.a(r2) == false) goto L12;
        r1.b().b(r2.h(), ((v5b.a) r2).a.getUniversalCardID(), r4.l);
        return;
    L12:
        return;
    }

    public final void f(View r7) {
        Intrinsics.checkNotNullParameter(r7, "itemView");
        LKUIRoundLinearLayout r0 = (LynxCardRoundLinearLayout) r7.findViewById(2131384813);
        LynxCardViewHolder r8 = LynxCardViewHolder.V3(r7);
        if (r8 != null) goto L7;
        if (r0 == null) goto L6;
        r8 = LynxCardViewHolder.V3(r0);
        goto L7
    L6:
        r8 = null;
    L7:
        if (r8 == null) goto L22;
        r8.b++;
        LKUIRoundLinearLayout r1 = r8.a;
        if (r1 != null) goto L11;
    L16:
        r8.a = null;
        r8.U3();
        v5b.c<LynxCardContentVO> r9 = r8.k;
        if (r9 == null) goto L23;
        String r10 = r9.getId();
        if (r10 == null) goto L24;
        SummaryHolder.Companion.getClass();
        Intrinsics.checkNotNullParameter(r10, "id");
        SummaryHolder.access$getDataMap$cp().remove(r10);
        Log.i(SummaryHolder.TAG, "remove " + r10 + ' ' + SummaryHolder.access$getDataMap$cp().size());
        return;
    L24:
        return;
    L23:
        return;
    L11:
        if ((r1 instanceof LKUIRoundLinearLayout) == false) goto L14;
        r1.setBorderWidth(0.0f);
        goto L16
    L14:
        if ((r1 instanceof LKUIRoundableLayout) == false) goto L16;
        ((LKUIRoundableLayout) r1).setBorderWidth(0.0f);
        goto L16
    }

    public final u5b.c i(v5b.c<LynxCardContentVO> r13) {
        Intrinsics.checkNotNullParameter(r13, "messageVO");
        int r0 = UIHelper.dp2px(12.0f);
        CardContent.CardHeader r1 = (CardContent.CardHeader) r13.b().s.getValue();
        if (r1 == null) goto L42;
        if (com.ss.android.lark.message.card.utils.a.a(r1) == true) goto L42;
        String r9 = r1.getTheme();
        HashMap<String, com.ss.android.lark.message.card.style.a.C0182a> r10 = com.ss.android.lark.message.card.style.a.a;
        if (r10.containsKey(r9) == false) goto L13;
        com.ss.android.lark.message.card.style.a.C0182a r11 = r10.get(r9);
        if (r11 == null) goto L13;
        int r14 = UIHelper.getColor(r11.c);
        Drawable r2 = m(r14);
        u5b.c r3 = u5b.c.e;
        return u5b.c.a.a(r14, r14, r2, new int[]{0, r0, 0, 0});
    L13:
        if (TextUtils.isEmpty(r9) == true) goto L15;
        Log.i("LynxCardMessageCell", "msg card reply style find unsupported theme=" + r9);
    L15:
        Map r4 = r1.getStyle();
        if (r4 == null) goto L32;
        if (r4.containsKey("startColor") == false) goto L32;
        if (r4.containsKey("endColor") == false) goto L32;
        if (r13.h() == false) goto L24;
        int r5 = v4b.a.s;
    L25:
        Drawable r6 = m(r5);
        u5b.c r12 = u5b.c.e;
        if (r13.h() == false) goto L28;
        int r15 = v4b.a.q;
    L29:
        u5b.c r16 = u5b.c.a.a(r15, r15, r6, null);
        int[] r7 = {0, r0, 0, 0};
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r16.d = r7;
        return r16;
    L28:
        r15 = v4b.a.O;
        goto L29
    L24:
        r5 = v4b.a.Q;
    L32:
        if (r13.h() == false) goto L34;
        int r8 = v4b.a.r;
    L35:
        Drawable r17 = m(r8);
        u5b.c r18 = u5b.c.e;
        if (r13.h() == false) goto L38;
        int r19 = v4b.a.p;
    L40:
        return u5b.c.a.a(r19, r19, r17, null);
    L38:
        r19 = v4b.a.N;
        goto L40
    L34:
        r8 = v4b.a.P;
    L42:
        if (r13.h() == false) goto L44;
        int r20 = v4b.a.r;
    L45:
        Drawable r21 = m(r20);
        u5b.c r22 = u5b.c.e;
        if (r13.h() == false) goto L48;
        int r110 = v4b.a.p;
    L49:
        u5b.c r111 = u5b.c.a.a(r110, r110, r21, null);
        int[] r23 = {0, r0, 0, 0};
        Intrinsics.checkNotNullParameter(r23, "<set-?>");
        r111.d = r23;
        return r111;
    L48:
        r110 = v4b.a.N;
        goto L49
    L44:
        r20 = v4b.a.P;
        goto L45
    }

    @Override // com.ss.android.lark.message.lynxcard.message.a
    public final void j(LynxCardViewHolder r4) {
        Intrinsics.checkNotNullParameter(r4, "viewHolder");
        Log.i("LynxCardMessageCell", "onViewDetachedFromWindow " + hashCode());
        MessageCardStreamingManager r1 = n();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "viewHolder");
        v5b.c<LynxCardContentVO> r0 = r4.k;
        if (r0 == null) goto L9;
        LynxCardContentVO r2 = r0.b();
        if (r2 == null) goto L10;
        r1.b().e(r2.h(), ((v5b.a) r2).a.getUniversalCardID(), r4.l);
        return;
    L10:
        return;
    }

    public final boolean o(v5b.c<LynxCardContentVO> r1) {
        if (r.a(r1.i()) == true) goto L5;
    L11:
        return false;
    L5:
        if (this.a.m() == true) goto L11;
        if (this.a.Y() == true) goto L11;
        if (this.a.q() == true) goto L11;
        return true;
    }

    public LynxCardMessageCell(r5b.a r2, p2b.b r3) {
        Intrinsics.checkNotNullParameter(r2, "chatContext");
        Intrinsics.checkNotNullParameter(r3, "mCellCallback");
        this.a = r2;
        this.b = r3;
        this.d = true;
        this.e = LazyKt.lazy(new LynxCardMessageCell$streamingManager$2(this));
    }

    public final View a(LayoutInflater r14, ViewGroup r15) {
        Intrinsics.checkNotNullParameter(r14, "inflater");
        Intrinsics.checkNotNullParameter(r15, "container");
        Log.i("LynxCardMessageCell", "onCreateView " + hashCode());
        this.c = gyb.a.a().subTrace();
        long r0 = System.currentTimeMillis();
        int r2 = com.ss.android.lark.message.lynxcard.monitor.e.a;
        OPTrace r3 = this.c;
        if (r3 == null) goto L6;
        fyb.e r4 = com.ss.android.lark.message.lynxcard.monitor.b.a;
        com.ss.android.lark.message.lynxcard.monitor.b.c.a(ncb.c.b).tracing(r3).flush();
    L6:
        if (idb.f.a().isEnable("messagecard.view_holder.lifecycle.leak.fix") == false) goto L12;
        Fragment r5 = this.a.R();
        if (r5 == null) goto L11;
        Lifecycle r6 = r5.getLifecycle();
        if (r6 == null) goto L11;
    L14:
        if (this.a.r() == false) goto L16;
    L19:
        boolean r7 = true;
    L20:
        boolean r8 = this.a.q();
        boolean r9 = this.a.m();
        int r10 = LynxCardViewHolder.n;
        View r16 = r14.inflate(2131563606, r15, false);
        int r11 = lrb.a.c(r7, r8, false, r9, false, null);
        bz7.b r12 = new bz7.b();
        int r13 = com.ss.android.lark.message.universalcard.a.a;
        CardConfig r17 = new CardConfig(Integer.valueOf(r11), null, null, null, 14, null);
        Intrinsics.checkNotNullParameter(r17, "cardConfig");
        r12.b = r17;
        r12.a = r6;
        CardImpl r18 = r12.a();
        final LynxCardViewHolder r19 = new LynxCardViewHolder(r16, r18);
        View r110 = r18.d(r14.getContext());     // Catch: Exception -> L23
    L25:
        r19.contentLayout.addView(r110, new FrameLayout.LayoutParams(-1, -2));
        r19.l = new p(this, r19);
        r16.addOnAttachStateChangeListener(new q(this));
        r19.contentLayout.setOnSizeChangeListener(new o(this, r19));
        r16.setTag(2131379270, r19);
        r6.addObserver(r19);
        View r111 = ((RecyclerView.ViewHolder) r19).itemView;
        int r112 = com.ss.android.lark.message.lynxcard.monitor.e.a;
        long r20 = System.currentTimeMillis() - r0;
        OPTrace r113 = this.c;
        fyb.e r1 = com.ss.android.lark.message.lynxcard.monitor.b.a;
        com.ss.android.lark.message.lynxcard.monitor.b.c.a(ncb.c.f).tracing(r113).setDuration(r20).flush();
        return r111;
    L23:
        e = move-exception;
        Log.e("LynxCardViewHolder", e);
        r110 = null;
        goto L25
    L16:
        if (this.a.Y() == true) goto L19;
        r7 = false;
    L11:
        r6 = this.a.getContext().getLifecycle();
        goto L14
    L12:
        r6 = this.a.getContext().getLifecycle();
        Intrinsics.checkNotNull(r6);
        goto L14
    }

    /* JADX WARN: Type inference failed for: r12v1, types: [android.view.View, com.ss.android.lark.message.lynxcard.message.LynxCardRoundLinearLayout] */
    public final BubbleStyle d(v5b.c<LynxCardContentVO> r15, View r16) {
        Intrinsics.checkNotNullParameter(r15, "messageVO");
        Intrinsics.checkNotNullParameter(r16, "contentView");
        LynxCardContentVO r2 = r15.b();
        String r3 = lrb.a.b(r2);
        if (r3.equals("renderOriginalWithTranslation") == false) goto L5;
    L30:
        int r4 = prb.a.a;
        BubbleStyle r6 = prb.a.b(r16.getContext(), r15, this.a);
    L31:
        BubbleStyle r11 = r6;
        Lazy r5 = UniversalCardLargeScreenAdapt.a;
        boolean r7 = UniversalCardLargeScreenAdapt.d(this.a.getContext(), ((v5b.a) r2).a.getWidthMode());
        if ((r15 instanceof y6b.c) == true) goto L34;
    L36:
        r11.g = r7;
        r11.b();
        Intrinsics.checkNotNull(r3);
        ?? r12 = (LynxCardRoundLinearLayout) r16.findViewById(2131384813);
        if (r12 == 0) goto L69;
        LynxCardViewHolder r8 = LynxCardViewHolder.V3(r12);
        if (r8 == null) goto L69;
        r8.b++;
        LKUIRoundLinearLayout r1 = r8.a;
        if (r1 != null) goto L45;
    L50:
        r8.a = null;
        if (idb.f.a().isEnable("lynxcard.border.fix.disable") == true) goto L69;
        String r9 = r15.getId();
        float[] r10 = f0.a(r15, 10.0f, 2.0f);
        if (this.a.r() == false) goto L56;
    L58:
        boolean r13 = false;
    L59:
        long r14 = r8.b;
        ArrayList r17 = new ArrayList();
        Object r0 = r12.getParent();
    L61:
        if ((r0 instanceof View) == false) goto L68;
        if ((r0 instanceof LKUIRoundLinearLayout) == false) goto L65;
    L66:
        r17.add(TuplesKt.to(r0, ((View) r0).getBackground()));
    L67:
        r0 = ((View) r0).getParent();
        goto L61
    L65:
        if ((r0 instanceof LKUIRoundableLayout) == false) goto L67;
    L68:
        OneShotPreDrawListener.add(r12, new l(r12, r8, r9, r14, r17, this, r10, r13));
        goto L69
    L56:
        if (Intrinsics.areEqual(r3, "renderOriginal") == false) goto L58;
        r13 = true;
        goto L59
    L45:
        if ((r1 instanceof LKUIRoundLinearLayout) == false) goto L48;
        r1.setBorderWidth(0.0f);
        goto L50
    L48:
        if ((r1 instanceof LKUIRoundableLayout) == false) goto L50;
        ((LKUIRoundableLayout) r1).setBorderWidth(0.0f);
    L69:
        return r11;
    L34:
        if (((y6b.c) r15).U == false) goto L36;
        r11.f = 2131102464;
        goto L36
    L5:
        if (r3.equals("renderTranslation") == true) goto L30;
        if (o(r15) == false) goto L29;
        CardHeaderView r18 = r16.findViewById(2131374285);
        int r19 = prb.a.a;
        prb.a.a(r16.getContext(), r18);
        r6 = BubbleStyle.h;
        if ((r18 instanceof CardHeaderView) == false) goto L31;
        CardHeaderView r20 = r18;
        CardHeaderView.a r21 = r20.getConfig();
        if (r21 == null) goto L31;
        String r22 = r21.a;
        if (r.a(r22) == false) goto L20;
        HashMap<String, com.ss.android.lark.message.card.style.a.C0182a> r23 = com.ss.android.lark.message.card.style.a.a;
        if (r23.containsKey(r22) == false) goto L20;
        com.ss.android.lark.message.card.style.a.C0182a r24 = r23.get(r22);
        if (r24 == null) goto L31;
        r6.e = r24.a;
        r20.setBackground(null);
    L20:
        Integer r25 = r21.b;
        if (r25 != null) goto L23;
    L28:
        Log.e("LynxCardMessageCell", "setStyle Error");
        goto L31
    L23:
        if (r21.c == null) goto L28;
        r6.e = 13;
        int r26 = r25.intValue();
        Integer r27 = r21.c;
        if (r27 == null) goto L27;
        int r28 = r27.intValue();
        r6.c = r26;
        r6.d = r28;
    L27:
        r20.setBackground(null);
        goto L31
    L29:
        int r29 = prb.a.a;
        prb.a.a(r16.getContext(), null);
        r6 = BubbleStyle.h;
        goto L31
    }

    @Override // com.ss.android.lark.message.lynxcard.message.b
    public final void h(LynxCardViewHolder r24, CardRenderData r25) {
        Intrinsics.checkNotNullParameter(r24, "viewHolder");
        Intrinsics.checkNotNullParameter(r25, "cardRenderData");
        MessageCardStreamingManager r4 = n();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r24, "viewHolder");
        Intrinsics.checkNotNullParameter(r25, "cardRenderData");
        y6b.c r2 = r24.k;
        if (r2 == null) goto L33;
        LynxCardContentVO r5 = r2.b();
        if (r5 == null) goto L33;
        String r15 = r5.h();
        Log.i("MessageCardStreamingManager", "onRenderDataUpdate, messageId=" + r15 + ", updateMessageId=" + r25.getBizID() + ", cardID=" + r25.getCardData().getUniversalCardID() + ", cardVersion=" + r25.getCardData().getUniversalCardVersion());
        if (Intrinsics.areEqual(r15, r25.getBizID()) == true) goto L10;
        Log.i("MessageCardStreamingManager", "onRenderDataUpdate messageID not match, ignore");
        return;
    L10:
        CardData r3 = r25.component3();
        CardContext r14 = r25.component4();
        CardConfig r1 = r25.component5();
        String r7 = lrb.a.d(r4.a);
        String r6 = r5.g();
        if (r6 == null) goto L13;
        boolean r10 = StringsKt.contains$default(r6, "cardLinkUrl", false, 2, null);
    L14:
        CardContent.ExtraInfo r8 = (CardContent.ExtraInfo) r5.j.getValue();
        if (r8 != null) goto L17;
    L19:
        String r9 = gyb.a.a().subTrace().getTracingID();
    L20:
        String r12 = lrb.a.b(r5);
        if ((r2 instanceof y6b.c) == false) goto L23;
        boolean r11 = r2.U;
    L24:
        OPTrace r13 = new OPTrace(r9).subTrace();
        r14.setRenderTrace(r13);
        int r16 = com.ss.android.lark.message.lynxcard.monitor.e.a;
        Intrinsics.checkNotNull(r7);
        boolean r17 = r5.j();
        r5b.a r18 = r4.a;
        if (r18 == null) goto L27;
        boolean r19 = r18.e0();
    L28:
        Intrinsics.checkNotNull(r12);
        OPTrace r20 = r4.d;
        String r110 = ((v5b.a) r5).a.getSendCardBotId();
        String r111 = ((v5b.a) r5).a.getSendAppId();
        boolean r112 = MessageCardRenderUtils.a(r5);
        String r21 = r5.g();
        if (r21 == null) goto L31;
        int r22 = r21.length();
    L32:
        com.ss.android.lark.message.lynxcard.monitor.e.a(r15, r7, r11, r17, r10, r19, r12, r20, r13, true, r110, r111, r112, r22, r5.f(), ((v5b.a) r5).a.getDataSource());
        MessageCardStreamingManager.c(r24.m, r15, r3, r14, r1, true);
        com.larksuite.component.card.monitor.a.d(INotificationHitPoint.NoticeType.MESSAGE, r15, String.valueOf(r5.f()), MessageCardRenderUtils.a(r5));
        return;
    L31:
        r22 = 0;
        goto L32
    L27:
        r19 = false;
        goto L28
    L23:
        r11 = false;
        goto L24
    L17:
        if (TextUtils.isEmpty(r8.getParseTraceId()) == true) goto L19;
        r9 = r8.getParseTraceId();
        goto L20
    L13:
        r10 = false;
    L33:
        Log.e("MessageCardStreamingManager", "onRenderDataUpdate cardContentVO is null");
    }

    public static final boolean l(LynxCardMessageCell r1, LynxCardViewHolder r2, v5b.c r3) {
        r1.getClass();
        int r0 = d.g;
        d.a.a(((RecyclerView.ViewHolder) r2).itemView, r3);
        return r1.b.d(((RecyclerView.ViewHolder) r2).itemView, r3);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void e(View r45, int r46, final v5b.c<LynxCardContentVO> r47) {
        Intrinsics.checkNotNullParameter(r45, "itemView");
        Intrinsics.checkNotNullParameter(r47, INotificationHitPoint.NoticeType.MESSAGE);
        TraceEvent.beginSection("LynxCardMessageCell.startBindView");
        final LynxCardViewHolder r13 = LynxCardViewHolder.V3(r45);
        LynxCardContentVO r12 = (LynxCardContentVO) r47.b();
        int r0 = MessageCardRenderUtils.a;
        v5b.c<LynxCardContentVO> r1 = r13.k;
        if (r1 == null) goto L5;
        LynxCardContentVO r2 = (LynxCardContentVO) r1.b();
    L6:
        Intrinsics.checkNotNullParameter(r12, "newContentVO");
        String r3 = r12.i();
        if (r3 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == true) goto L38;
        if (r2 == null) goto L16;
        String r5 = r2.i();
    L17:
        if (r5 != null) goto L19;
    L22:
        boolean r6 = true;
    L23:
        if (r6 == true) goto L38;
        String r7 = r12.i();
        if (r2 == null) goto L27;
        String r8 = r2.i();
    L29:
        if (Intrinsics.areEqual(r7, r8) == false) goto L38;
        String r9 = r12.h();
        if (r2 == null) goto L33;
        String r10 = r2.h();
    L35:
        if (Intrinsics.areEqual(r9, r10) == false) goto L38;
        boolean r11 = false;
    L40:
        if (MessageCardRenderUtils.a(r12) == false) goto L48;
        if (r2 != null) goto L43;
    L45:
        boolean r14 = false;
    L46:
        if (r14 == true) goto L48;
        boolean r15 = true;
    L49:
        if (r11 == true) goto L53;
        if (r15 == true) goto L53;
        MessageCardRenderUtils.StreamingBindViewMethod r16 = MessageCardRenderUtils.StreamingBindViewMethod.UPDATE_ONLY;
    L54:
        MessageCardRenderUtils.StreamingBindViewMethod r17 = r16;
        r13.k = r47;
        Log.i("LynxCardMessageCell", "onBindView, msgID=" + r47.getId() + ", contentVersion:" + r12.f() + ", cardVersion:" + ((String) r12.u.getValue()) + ", dataSource=" + ((CardContent.DataSource) r12.v.getValue()));
        CardContent.ExtraInfo r18 = (CardContent.ExtraInfo) r12.j.getValue();
        if (r18 != null) goto L57;
    L59:
        String r19 = gyb.a.a().subTrace().getTracingID();
    L60:
        boolean r33 = r12.j();
        boolean r20 = r47 instanceof y6b.c;
        if (r20 == false) goto L63;
        boolean r34 = ((y6b.c) r47).U;
    L64:
        String r21 = lrb.a.b(r12);
        Intrinsics.checkNotNull(r21);
        Intrinsics.checkNotNullParameter(r21, "renderType");
        if (((com.ss.android.lark.chat.base.view.vo.message.f) r47.b()).g == null) goto L67;
        com.ss.android.lark.chat.base.view.vo.message.f r22 = ((com.ss.android.lark.chat.base.view.vo.message.f) r47.b()).g;
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type com.ss.android.lark.message.lynxcard.entity.LynxCardContentVO");
        LynxCardContentVO r23 = (LynxCardContentVO) r22;
        String r24 = r23.g();
        CardContent.JsonAttachment r110 = (CardContent.JsonAttachment) r23.o.getValue();
        ((v5b.a) r23).a.getActionSelectValue();
        String r35 = r24;
    L68:
        OPTrace r36 = new OPTrace(r19).subTrace();
        String r25 = r12.g();
        if (r25 == null) goto L71;
        boolean r26 = StringsKt.contains$default(r25, "cardLinkUrl", false, 2, null);
    L72:
        String r37 = lrb.a.d(this.a);
        boolean r111 = MessageCardRenderUtils.a(r12);
        Intrinsics.checkNotNull(r13);
        boolean r27 = p(r47, r12, r111);
        if (r27 == true) goto L77;
        r13.U3();
    L75:
        Object r42 = "renderOriginalWithTranslation";
        String r39 = r21;
        boolean r41 = r20;
        Object r40 = null;
    L115:
        if (r111 == true) goto L117;
    L118:
        int r28 = com.ss.android.lark.message.lynxcard.monitor.e.a;
        String r112 = r47.getId();
        Intrinsics.checkNotNull(r37);
        boolean r29 = this.a.e0();
        OPTrace r30 = this.c;
        boolean r31 = this.d;
        String r210 = ((v5b.a) r12).a.getSendCardBotId();
        String r211 = ((v5b.a) r12).a.getSendAppId();
        boolean r212 = MessageCardRenderUtils.a(r12);
        String r32 = r12.g();
        if (r32 == null) goto L121;
        int r38 = r32.length();
    L122:
        com.ss.android.lark.message.lynxcard.monitor.e.a(r112, r37, r34, r33, r26, r29, r39, r30, r36, r31, r210, r211, r212, r38, r12.f(), ((v5b.a) r12).a.getDataSource());
    L123:
        int r43 = com.ss.android.lark.message.lynxcard.monitor.e.a;
        String r44 = r47.getId();
        String r48 = ((v5b.a) r12).a.getUniversalCardID();
        if (r44 != null) goto L126;
    L129:
        boolean r49 = true;
    L130:
        if (r49 == true) goto L140;
        if (r48 != null) goto L133;
    L136:
        boolean r50 = true;
    L137:
        if (r50 == true) goto L140;
        ((com.ss.android.lark.message.lynxcard.monitor.a) e0c.k.a(LarkContext.getApplication(), com.ss.android.lark.message.lynxcard.monitor.a.class)).z6(r44, r48);
        goto L140
    L133:
        if (r48.length() == 0) goto L136;
        r50 = false;
    L140:
        boolean r51 = o(r47);
        String r52 = r39;
        if (Intrinsics.areEqual(r52, "renderOriginal") == false) goto L143;
        r13.T3(r45.getContext(), false);
    L147:
        if (this.a.r() == false) goto L158;
        LKUIRoundLinearLayout r53 = r13.mRootLayout;
        if (Intrinsics.areEqual(r42, r52) == false) goto L152;
        if (r53 == null) goto L154;
        r53.setBackgroundColor(UDColorUtils.getColor(r53.getContext(), 2131102440));
    L154:
        if (r53 == null) goto L156;
        r53.setRadius(10.0f);
    L156:
        if (r53 == null) goto L158;
        r53.setBorderWidth(1.0f);
        goto L158
    L152:
        if (r53 == null) goto L154;
        r53.setBackgroundColor(UDColorUtils.getColor(r53.getContext(), 2131100557));
    L158:
        d r310 = new d(r45, r47, this.b, ((v5b.a) r47.b()).a, this.a, n());
        if (r47.d() == false) goto L163;
        int r54 = prb.a.a;
        if (prb.a.c(this.a) == false) goto L163;
        boolean r113 = true;
    L164:
        TraceEvent.beginSection("LynxCardMessageCell.prepareData");
        if (this.d == false) goto L237;
        String r55 = r12.h();
        if (r55 != null) goto L170;
        r55 = "";
    L170:
        if (r113 == false) goto L173;
        if (r35 == null) goto L173;
        boolean r114 = false;
    L175:
        if (TextUtils.equals("renderOriginal", r52) == true) goto L178;
        r51 = false;
    L178:
        int r56 = com.ss.android.lark.message.universalcard.a.a;
        CardContent r115 = ((v5b.a) r12).a;
        com.ss.android.lark.chat.base.view.vo.message.f r116 = ((com.ss.android.lark.chat.base.view.vo.message.f) r12).g;
        String r117 = String.valueOf(r12.f());
        int r118 = MessageLocalDataInfo.BusinessKey.OPEN_PLATFORM_MESSAGE_CARD.getValue();
        Log.i("LynxCardMessageCell", "modelparseMessage Data result contentversion" + r117);
        HashMap r57 = r47.k();
        if (r57 == null) goto L181;
        String r119 = (String) r57.get(Integer.valueOf(r118));
    L182:
        if (r33 == false) goto L184;
    L186:
        boolean r213 = false;
    L187:
        CardData r58 = com.ss.android.lark.message.universalcard.a.d(r115, r116, r119, r213, this.a.e0(), r52);
        if (r41 == true) goto L190;
    L192:
        boolean r120 = false;
    L194:
        if (this.a.r() == false) goto L196;
    L199:
        boolean r121 = true;
    L200:
        boolean r122 = this.a.q();
        boolean r214 = this.a.m();
        boolean r215 = r47.d();
        lya.a r59 = this.a.l();
        if (r59 == null) goto L203;
        Integer r216 = r59.a();
    L204:
        int r60 = lrb.a.c(r121, r122, r120, r214, r215, r216);
        Lazy r61 = UniversalCardLargeScreenAdapt.a;
        int r62 = UniversalCardLargeScreenAdapt.a(this.a.getContext(), r60, ((v5b.a) r12).a.getWidthMode());
        r13.mRootLayout.setWidthMode(((v5b.a) r12).a.getWidthMode());
        boolean r123 = UniversalCardLargeScreenAdapt.c(this.a.getContext(), r62);
        String r217 = r47.getChatId();
        boolean r218 = this.a.isGroup();
        FragmentActivity r219 = this.a.getContext();
        Fragment r220 = this.a.R();
        Intrinsics.checkNotNull(r37);
        String r221 = ((v5b.a) r12).a.getSendCardBotId();
        String r222 = ((v5b.a) r12).a.getSendAppId();
        String r311 = r47.g();
        y6b.b r63 = r47.a();
        if (r63 == null) goto L207;
        String r312 = r63.w;
    L208:
        CardContext r64 = com.ss.android.lark.message.universalcard.a.a(r123, r51, r114, r217, r218, r219, r220, r36, r55, r34, r37, r221, r222, r311, r312, r310);
        r13.m.a().setOnLongClickListener(new c(r12, this, r13, r47));
        CardConfig r65 = new CardConfig(Integer.valueOf(r62), null, null, null, 14, null);
        MessageCardStreamingManager r124 = n();
        OPTrace r66 = this.c;
        r124.getClass();
        Intrinsics.checkNotNullParameter(r13, "lynxCardViewHolder");
        Intrinsics.checkNotNullParameter(r12, "lynxCardContentVO");
        Intrinsics.checkNotNullParameter(r17, "streamingBindViewMethod");
        Intrinsics.checkNotNullParameter(r55, "messageId");
        Intrinsics.checkNotNullParameter(r58, "cardData");
        Intrinsics.checkNotNullParameter(r64, "cardContext");
        Intrinsics.checkNotNullParameter(r65, "cardConfig");
        r124.d = r66;
        if (MessageCardRenderUtils.a(r12) == true) goto L211;
        MessageCardStreamingManager r223 = r124;
    L225:
        if (((RecyclerView.ViewHolder) r13).itemView.isAttachedToWindow() == true) goto L227;
    L230:
        TraceEvent.endSection("LynxCardMessageCell.prepareData");
        if (r111 == true) goto L233;
        r13.m.c(r58, r64, r65);
    L233:
        if (r111 == true) goto L235;
    L236:
        com.larksuite.component.card.monitor.a.d(INotificationHitPoint.NoticeType.MESSAGE, r55, String.valueOf(r12.f()), r111);
        goto L237
    L235:
        if (r17 != MessageCardRenderUtils.StreamingBindViewMethod.UPDATE_AND_RENDER) goto L237;
    L227:
        if (MessageCardRenderUtils.a(r12) == false) goto L229;
        r223.b().b(r12.h(), ((v5b.a) r12).a.getUniversalCardID(), r13.l);
        goto L230
    L229:
        r223.b().e(r12.h(), ((v5b.a) r12).a.getUniversalCardID(), r13.l);
        goto L230
    L211:
        if (r17 != MessageCardRenderUtils.StreamingBindViewMethod.UPDATE_AND_RENDER) goto L222;
        Log.i("MessageCardStreamingManager", "onBindView: streaming update, UPDATE_AND_RENDER: " + r58.getUniversalCardID());
        r124.b().c(r55, r58, r64, r65, false);
        CardRenderData r67 = r124.b().d(r12.i());
        if (r67 == null) goto L215;
        CardData r125 = r67.getCardData();
        CardContext r126 = r67.getCardContext();
        CardData r127 = r125;
    L216:
        bz7.a r68 = r13.m;
        v5b.c<LynxCardContentVO> r128 = r13.k;
        if (r128 == null) goto L220;
        String r129 = r128.getId();
        if (r129 == null) goto L220;
    L221:
        r223 = r124;
        MessageCardStreamingManager.c(r68, r129, r127, r126, r65, false);
    L220:
        r129 = "";
        goto L221
    L215:
        r126 = r64;
        r127 = r58;
        goto L216
    L222:
        r223 = r124;
        Log.i("MessageCardStreamingManager", "onBindView: streaming update, UPDATE_ONLY: " + r58.getUniversalCardID());
        r223.b().c(r55, r58, r64, r65, true);
        goto L225
    L207:
        r312 = null;
        goto L208
    L203:
        r216 = null;
        goto L204
    L196:
        if (this.a.Y() == true) goto L199;
        r121 = false;
        goto L200
    L190:
        if (((y6b.c) r47).W2 == (-1)) goto L192;
        r120 = true;
        goto L194
    L184:
        if (this.a.e0() == true) goto L186;
        r213 = true;
        goto L187
    L181:
        r119 = null;
    L173:
        r114 = true;
    L237:
        TraceEvent.endSection("LynxCardMessageCell.startBindView");
        return;
    L163:
        r113 = false;
        goto L164
    L143:
        r13.T3(r45.getContext(), true);
        r13.h.setOnClickListener(new g(this, r47));
        r13.h.setOnLongClickListener(new h(this, r13, r47));
        AppCompatImageView r69 = r13.i;
        if (r69 == null) goto L147;
        r69.setOnClickListener(new e(this, r47, r13));
        r13.i.setOnLongClickListener(new f(this, r13, r47));
        goto L147
    L126:
        if (r44.length() == 0) goto L129;
        r49 = false;
        goto L130
    L121:
        r38 = 0;
        goto L122
    L117:
        if (r17 != MessageCardRenderUtils.StreamingBindViewMethod.UPDATE_AND_RENDER) goto L123;
    L77:
        if (r13.mFoldContainer != null) goto L79;
    L87:
        boolean r70 = false;
    L88:
        if (r70 == true) goto L90;
        r13.U3();
        goto L75
    L90:
        EllipsizeFrameLayout r71 = r13.mEllipsizeLayout;
        final View r72 = r13.mShowMoreView;
        final TextView r130 = r13.mShowMoreText;
        FragmentActivity r73 = this.a.getContext();
        String r74 = lrb.a.b(r12);
        if (Intrinsics.areEqual(r74, "renderOriginalWithTranslation") == true) goto L96;
        Object r224 = "renderOriginalWithTranslation";
        if (Intrinsics.areEqual(r74, "renderTranslation") == true) goto L97;
        boolean r75 = false;
    L98:
        if (r75 == true) goto L100;
        int r76 = UDColorUtils.getColor(r73, 2131100557);
        boolean r225 = r20;
    L108:
        if (r13.mShowMoreView == null) goto L114;
        int[] r77 = {r76, UIUtils.getAlphaColor(r76, 0.0d)};
        GradientDrawable r78 = r13.c;
        if (r78 != null) goto L113;
        GradientDrawable r79 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, r77);
        r13.c = r79;
        float r80 = UIUtils.dp2px(r13.mShowMoreView.getContext(), 10.0f);
        r79.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, r80, r80, r80, r80});
        r13.mShowMoreView.setBackground(r13.c);
        goto L114
    L113:
        r78.setColors(r77);
    L114:
        r13.d = false;
        r13.mRootLayout.setOnCardTapListener(null);
        r13.mRootLayout.setOnCardTapObserver(new LynxCardMessageCell$setupEllipsize$1(r13, r47));
        r72.setVisibility(8);
        r130.setVisibility(8);
        r130.setText(2131891581);
        r130.setOnClickListener(new i(r13, r47, this));
        r130.setOnLongClickListener(new j(this, r13, r47));
        r71.setShouldEllipsizeListener(new k(r13, r47, this));
        r40 = null;
        r39 = r21;
        r42 = r224;
        r41 = r225;
        r71.setEllipsizeListener(new LynxCardMessageCell$setupEllipsize$5(r13, r47, this, r72, r130));
        r71.setMaxHeightFactor(r12.m);
        r71.setEnableEllipsize(r27);
        goto L115
    L100:
        int r81 = prb.a.a;
        int r82 = prb.a.b(r73, r47, this.a).e;
        if (r82 == 0) goto L106;
        r225 = r20;
        if (r82 == 1) goto L105;
        r76 = UDColorUtils.getColor(r73, 2131100557);
        goto L108
    L105:
        r76 = v4b.a.z;
        goto L108
    L106:
        r225 = r20;
        r76 = v4b.a.a;
    L97:
        r75 = true;
        goto L98
    L96:
        r224 = "renderOriginalWithTranslation";
        goto L97
    L79:
        if (r13.mEllipsizeLayout == null) goto L87;
        if (r13.contentLayout == null) goto L87;
        if (r13.mShowMoreView == null) goto L87;
        if (r13.mShowMoreText == null) goto L87;
        r70 = true;
        goto L88
    L71:
        r26 = false;
        goto L72
    L67:
        r35 = null;
        goto L68
    L63:
        r34 = false;
        goto L64
    L57:
        if (TextUtils.isEmpty(r18.getParseTraceId()) == true) goto L59;
        r19 = r18.getParseTraceId();
    L53:
        r16 = MessageCardRenderUtils.StreamingBindViewMethod.UPDATE_AND_RENDER;
        goto L54
    L43:
        if (MessageCardRenderUtils.a(r2) != true) goto L45;
        r14 = true;
    L48:
        r15 = false;
        goto L49
    L33:
        r10 = null;
        goto L35
    L27:
        r8 = null;
        goto L29
    L19:
        if (r5.length() == 0) goto L22;
        r6 = false;
        goto L23
    L16:
        r5 = null;
    L38:
        r11 = true;
        goto L40
    L9:
        if (r3.length() == 0) goto L12;
        r4 = false;
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    public final View g(View r4, FrameLayout r5, y6b.a<LynxCardContentVO> r6) {
        Intrinsics.checkNotNullParameter(r6, "messageVO");
        if ((r6 instanceof y6b.c) == true) goto L5;
    L20:
        return null;
    L5:
        if (r4.getContext() == null) goto L20;
        y6b.c r7 = (y6b.c) r6;
        int r8 = r7.R2;
        if (r7.U == false) goto L20;
        if (r8 == 0) goto L11;
        if (r8 != 1) goto L20;
    L11:
        LynxCardViewHolder r9 = LynxCardViewHolder.V3(r4);
        if (r9 != null) goto L16;
        Log.e("LynxCardMessageCell", "card viewHolder from itemView failed, check create: msgId: " + r7.c, new Throwable(), true);
        return null;
    L16:
        if (r9.j != null) goto L18;
        r9.j = new TextView(r4.getContext());
        FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(-2, -2);
        r10.bottomMargin = orb.a.a;
        r9.j.setLayoutParams(r10);
    L18:
        r9.j.setText(2131891711);
        r9.j.setTextColor(UIHelper.getResources().getColor(2131106622));
        zz7.a.c(r9.j, 12);
        r9.j.setCompoundDrawablePadding(UIHelper.dp2px(3.0f));
        Drawable r11 = UDIconUtils.getIconDrawable(r4.getContext(), 2131232524, UDColorUtils.getColor(r4.getContext(), 2131102418));
        r11.setBounds(0, 0, zz7.b.g(r4.getContext(), 16), zz7.b.g(r4.getContext(), 16));
        r9.j.setCompoundDrawables(r11, null, null, null);
        return r9.j;
    }

    public final boolean p(v5b.c<LynxCardContentVO> r3, LynxCardContentVO r4, boolean r5) {
        CardMessageUserLynxRenderSettings r0 = lrb.a.a;
        if (com.ss.android.lark.message.card.b.a().getFgValue("im.message_card.auto_fold") == true) goto L5;
        return false;
    L5:
        if (r4.l == false) goto L30;
        if (r5 == false) goto L8;
        return false;
    L8:
        if (this.a.m() == false) goto L10;
        return false;
    L10:
        if ((r3 instanceof y6b.c) == false) goto L12;
        y6b.c r6 = (y6b.c) r3;
    L14:
        if (r6 != null) goto L17;
    L25:
        boolean r7 = false;
    L26:
        if (r7 == true) goto L33;
        return true;
    L33:
        return false;
    L17:
        if (this.a.q() == false) goto L21;
        if (r6.Z() == false) goto L21;
    L24:
        r7 = true;
    L21:
        if (this.a.Y() == false) goto L25;
        if (r6.Y() == false) goto L25;
    L12:
        r6 = null;
        goto L14
    L30:
        return false;
    }

    @Override // com.ss.android.lark.message.lynxcard.message.c
    public final void k(LynxCardViewHolder r5, final int r6, int r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r5, "viewHolder");
        Log.i("LynxCardMessageCell", "onSizeChanged new:" + r6 + 'x' + r7 + ", old:" + r8 + 'x' + r9);
        MessageCardStreamingManager r10 = n();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, "viewHolder");
        boolean r0 = true;
        if (r9 == 0) goto L25;
        r5b.b<LynxCardContentVO> r11 = r10.b;
        if (r11 == null) goto L25;
        v5b.c<LynxCardContentVO> r12 = r5.k;
        if (r12 == null) goto L13;
        LynxCardContentVO r13 = r12.b();
        if (r13 == null) goto L13;
        boolean r14 = MessageCardRenderUtils.a(r13);
    L14:
        v5b.c<LynxCardContentVO> r3 = r5.k;
        if (r3 == null) goto L17;
        String r4 = r3.getId();
    L18:
        if (r14 == false) goto L25;
        if (((RecyclerView.ViewHolder) r5).itemView.isAttachedToWindow() == false) goto L25;
        if (r4 == null) goto L25;
        if (r11.c(r4) == false) goto L25;
        r11.e(150, true);
        goto L25
    L17:
        r4 = null;
    L13:
        r14 = false;
    L25:
        v5b.c<LynxCardContentVO> r15 = r5.k;
        if (r15 == null) goto L45;
        LynxCardContentVO r16 = (LynxCardContentVO) r15.b();
        Intrinsics.checkNotNull(r16);
        if (p(r15, r16, MessageCardRenderUtils.a(r16)) == false) goto L45;
        View r17 = r5.mShowMoreView;
        if (r17 != null) goto L34;
    L36:
        r0 = false;
    L37:
        if (r0 == false) goto L45;
        String r18 = r15.getId();
        if (((RecyclerView.ViewHolder) r5).itemView.isAttachedToWindow() == false) goto L45;
        if (this.b.c(r18) == false) goto L45;
        this.b.e(0, false);
        goto L45
    L34:
        if (r17.getVisibility() != 0) goto L36;
    L45:
        if (UniversalCardLargeScreenAdapt.b() == false) goto L54;
        Integer r19 = r5.m.b().f;
        if (r19 == null) goto L55;
        if (r6 <= 0) goto L56;
        if (r8 <= 0) goto L57;
        boolean r20 = UniversalCardLargeScreenAdapt.c(this.a.getContext(), r19.intValue());
        final boolean r21 = UniversalCardLargeScreenAdapt.c(this.a.getContext(), r6);
        if (r20 == r21) goto L58;
        Log.i("LynxCardMessageCell", "card wide mode change, old: " + r20 + ", new: " + r21);
        r5.m.b().b(new UniversalCardLynxRender.c(new LynxCardMessageCell$onSizeChanged$1(r21), new LynxCardMessageCell$onSizeChanged$2(r6)));
        return;
    L58:
        return;
    L57:
        return;
    L56:
        return;
    L55:
        return;
    }
}

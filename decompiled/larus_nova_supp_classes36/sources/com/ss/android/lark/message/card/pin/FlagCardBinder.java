package com.ss.android.lark.message.card.pin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.android.YogaLayout;
import com.larksuite.component.card.cardcontainer.CardImpl;
import com.larksuite.component.card.protocol.CardConfig;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import com.ss.android.lark.message.card.view.h;
import com.ss.android.lark.message.card.view.i;
import com.ss.android.lark.message.card.view.richtext.NodeParams;
import com.ss.android.lark.message.card.view.richtext.c0;
import com.ss.android.lark.message.lynxcard.monitor.e;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import com.ss.android.lark.utils.UIHelper;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(singleton = false, value = iya.a.class)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/message/card/pin/FlagCardBinder;", "Lcom/ss/android/lark/biz/im/api/flag/FlagMessagePinContentBinder;", "Lcom/ss/android/lark/message/card/pin/CardPinContentViewHolder;", "<init>", "()V", "contentBinder", "Lcom/ss/android/lark/message/card/pin/CardPinContentBinder;", "getContentBinder", "()Lcom/ss/android/lark/message/card/pin/CardPinContentBinder;", "contentBinder$delegate", "Lkotlin/Lazy;", "lynxCardPinContentBinder", "Lcom/ss/android/lark/message/lynxcard/pin/LynxCardPinContentBinder;", "getLynxCardPinContentBinder", "()Lcom/ss/android/lark/message/lynxcard/pin/LynxCardPinContentBinder;", "lynxCardPinContentBinder$delegate", "flagMessageType", "Lcom/ss/android/lark/biz/im/api/flag/FlagMessageType;", "getFlagMessageType", "()Lcom/ss/android/lark/biz/im/api/flag/FlagMessageType;", "onInflateContent", "parent", "Landroid/view/ViewGroup;", "onBindContent", "", "viewHolder", INotificationHitPoint.NoticeType.MESSAGE, "Lcom/ss/android/lark/chat/entity/message/Message;", "onClick", "Landroid/view/View$OnClickListener;", "message-card_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlagCardBinder implements iya.a<d> {
    private final Lazy contentBinder$delegate;
    private final Lazy lynxCardPinContentBinder$delegate;

    private final a getContentBinder() {
        return (a) this.contentBinder$delegate.getValue();
    }

    private final nrb.a getLynxCardPinContentBinder() {
        return (nrb.a) this.lynxCardPinContentBinder$delegate.getValue();
    }

    public FlagCardBinder() {
        this.contentBinder$delegate = LazyKt.lazy(FlagCardBinder$contentBinder$2.INSTANCE);
        this.lynxCardPinContentBinder$delegate = LazyKt.lazy(FlagCardBinder$lynxCardPinContentBinder$2.INSTANCE);
    }

    public iya.c getFlagMessageType() {
        return iya.c.a.a;
    }

    public d onInflateContent(ViewGroup r11) {
        Intrinsics.checkNotNullParameter(r11, "parent");
        srb.a.a();
        bz7.b r1 = new bz7.b();
        CardConfig r9 = new CardConfig(null, null, null, null, 15, null);
        Intrinsics.checkNotNullParameter(r9, "cardConfig");
        r1.b = r9;
        CardImpl r2 = r1.a();
        View r3 = r2.d(r11.getContext());
        int r4 = d.i;
        Intrinsics.checkNotNullParameter(r11, "parent");
        View r12 = LayoutInflater.from(r11.getContext()).inflate(2131564982, r11, true);
        Intrinsics.checkNotNull(r12);
        d r0 = new d(r12, r2);
        r0.h.addView(r3, new FrameLayout.LayoutParams(-1, -1));
        return r0;
    }

    /* JADX INFO: renamed from: onInflateContent, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ iya.b m1428onInflateContent(ViewGroup r1) {
        return onInflateContent(r1);
    }

    public void onBindContent(d r39, Message r40, View.OnClickListener r41) {
        Intrinsics.checkNotNullParameter(r39, "viewHolder");
        Intrinsics.checkNotNullParameter(r40, INotificationHitPoint.NoticeType.MESSAGE);
        Intrinsics.checkNotNullParameter(r41, "onClick");
        String r8 = null;
        if (lrb.a.a(r40.getContent(), r40.getCreateTime()) == false) goto L21;
        getLynxCardPinContentBinder().getClass();
        Intrinsics.checkNotNullParameter(r39, "viewHolder");
        Intrinsics.checkNotNullParameter(r40, INotificationHitPoint.NoticeType.MESSAGE);
        CardContent r3 = r40.getContent();
        r39.c.setRadius(10.0f, 10.0f, 10.0f, 10.0f);
        r39.c.setBorderWidth(0.5f);
        ViewGroup.LayoutParams r4 = r39.d.getLayoutParams();
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
    L8:
        if (r5 == null) goto L10;
        r5.setMargins(0, 0, 0, 0);
    L10:
        r39.d.getViewTreeObserver().addOnGlobalLayoutListener(new nrb.b(r39));
        r39.d.setOnTouchListener(new nrb.c(r41));
        r39.e.setVisibility(8);
        r39.f.setVisibility(8);
        r39.h.setVisibility(0);
        String r2 = r3.getDslJsonString();
        if (r2 == null) goto L13;
        boolean r16 = StringsKt.contains$default(r2, "cardLinkUrl", false, 2, null);
    L14:
        OPTrace r29 = gyb.a.a().subTrace();
        int r6 = e.a;
        String r12 = r40.getId();
        boolean r15 = r3.isForward();
        String r22 = r3.getSendCardBotId();
        String r23 = r3.getSendAppId();
        String r1 = r3.getDslJsonString();
        if (r1 == null) goto L17;
        int r25 = r1.length();
    L18:
        e.a(r12, "pin", false, r15, r16, false, "renderOriginal", r29, r29, true, r22, r23, false, r25, r3.getContentVersion(), r3.getDataSource());
        com.ss.android.lark.message.lynxcard.message.d r37 = new com.ss.android.lark.message.lynxcard.message.d(r39.c, null, null, r3, null, null);
        CardData r7 = com.ss.android.lark.message.universalcard.a.d(r3, null, null, true, false, "renderOriginal");
        CardContext r9 = com.ss.android.lark.message.universalcard.a.a(false, false, false, LocationHitPoint$ResultType.DEFAULT, false, r39.c.getContext(), null, r29, LocationHitPoint$ResultType.DEFAULT, false, "pin", r3.getSendCardBotId(), r3.getSendAppId(), null, null, r37);
        bz7.a r0 = r39.b;
        if (r0 == null) goto L47;
        r0.c(r7, r9, new CardConfig(null, null, null, null, 14, null));
        return;
    L47:
        return;
    L17:
        r25 = 0;
        goto L18
    L13:
        r16 = false;
        goto L14
    L7:
        r5 = null;
        goto L8
    L21:
        getContentBinder().getClass();
        Intrinsics.checkNotNullParameter(r39, "viewHolder");
        Intrinsics.checkNotNullParameter(r40, INotificationHitPoint.NoticeType.MESSAGE);
        CardContent r10 = r40.getContent();
        r39.c.setRadius(10.0f, 10.0f, 10.0f, 10.0f);
        r39.c.setBorderWidth(0.5f);
        ViewGroup.LayoutParams r11 = r39.d.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L24;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r11;
    L25:
        if (r13 == null) goto L27;
        int r14 = UIHelper.dp2px(12.0f);
        r13.setMargins(r14, r14, r14, r14);
    L27:
        r39.d.getViewTreeObserver().addOnGlobalLayoutListener(new b(r39));
        r39.d.setOnTouchListener(new c(r41));
        r39.e.setVisibility(0);
        r39.f.setVisibility(0);
        r39.h.setVisibility(8);
        r39.f.removeAllViews();
        r39.e.removeAllViews();
        Context r17 = r39.a.getContext();
        NodeParams r18 = com.ss.android.lark.message.card.view.richtext.b.o(null, r10.getRichText(), r10.getCardVersion());
        h.a(r17, r10.getCardHeader(), r39.e, null);
        Intrinsics.checkNotNull(r17);
        FrameLayout r19 = r39.f;
        Intrinsics.checkNotNull(r18);
        int r20 = r10.getCardVersion();
        YogaLayout r21 = new YogaLayout(r17);
        YogaNode r24 = r21.getYogaNode();
        r24.reset();
        r24.setFlexDirection(YogaFlexDirection.COLUMN);
        r24.setJustifyContent(YogaJustify.CENTER);
        r24.setWidthPercent(100.0f);
        r19.addView(r21);
        new c0(r17, null, null, r20).x(r21, r18, new i());
        CardContent.CardHeader r26 = r10.getCardHeader();
        LKUIRoundableLayout r27 = r39.c;
        if (com.ss.android.lark.message.card.utils.a.a(r26) == true) goto L51;
        if (r26 == null) goto L32;
        r8 = r26.getTheme();
    L32:
        HashMap<String, com.ss.android.lark.message.card.style.a.C0182a> r28 = com.ss.android.lark.message.card.style.a.a;
        if (r28.containsKey(r8) == false) goto L35;
        com.ss.android.lark.message.card.style.a.C0182a r30 = r28.get(r8);
        Intrinsics.checkNotNull(r30);
        int r31 = UIHelper.getColor(r30.b);
        com.ss.android.lark.message.card.b.a().setBgForCustomHeader(r27, r27.findViewById(2131374285), new int[]{r31, r31});
        return;
    L35:
        if (r26 == null) goto L50;
        Map r32 = r26.getStyle();
        if (r32 != null) goto L40;
        return;
    L40:
        if (r32.containsKey("startColor") == true) goto L43;
        return;
    L43:
        if (r32.containsKey("endColor") == false) goto L54;
        r27.setBorderWidth(0.0f);
        com.ss.android.lark.message.card.b.a().setBgForCustomHeader(r27, r27.findViewById(2131374285), new int[]{ColorProtector.parseColor((String) r32.get("startColor")), ColorProtector.parseColor((String) r32.get("endColor"))});
        return;
    L54:
        return;
    L50:
        return;
    L51:
        return;
    L24:
        r13 = null;
        goto L25
    }

    public /* bridge */ /* synthetic */ void onBindContent(iya.b r1, Message r2, View.OnClickListener r3) {
        onBindContent((d) r1, r2, r3);
    }
}

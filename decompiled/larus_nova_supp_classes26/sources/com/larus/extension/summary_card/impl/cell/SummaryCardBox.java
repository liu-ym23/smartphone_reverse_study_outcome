package com.larus.extension.summary_card.impl.cell;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.MaxHeightRelativeLayout;
import com.larus.bmhome.chat.require.MainBotServiceDelegate;
import com.larus.bmhome.chat.search.SourceFrom;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.extension.summary_card.api.model.SummaryCardItemType;
import com.larus.extension.summary_card.api.model.SummaryCardMessageContent;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.ItemSourceApp;
import com.larus.platform.api.r2;
import com.larus.platform.model.video.business.EnterVideoMethod;
import com.larus.platform.model.video.business.VideoFeedProviderDelegate;
import com.larus.platform.uimodel.ArticleParam;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.platform.uimodel.VideoParam;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import gw8.c$b;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class SummaryCardBox extends com.larus.bmhome.chat.layout.item.i {
    public static final /* synthetic */ int F = 0;
    public String A;
    public SummaryCardMessageContent B;
    public com.larus.extension.summary_card.impl.component.a C;
    public final r2 D;
    public int E;
    public final int p;
    public final SimpleDraweeView q;
    public final TextView r;
    public final TextView s;
    public final View t;
    public final MaxHeightRelativeLayout u;
    public final View v;
    public CustomMarkdownTextView w;
    public final View x;
    public final TextView y;
    public final ConstraintLayout z;

    public static final class a {
    }

    static {
    }

    public final String getItemId() {
        SummaryCardMessageContent r0 = this.B;
        if (r0 == null) goto L6;
        String r1 = r0.getItemId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final void t() {
        SummaryCardMessageContent r0 = this.B;
        if (r0 == null) goto L10;
        String r1 = r0.getItemId();
        if (r1 == null) goto L11;
        ArrayList r2 = new ArrayList();
        r2.add(new pr9.a(r1, false, 14));
        qr9.c r3 = VideoFeedProviderDelegate.b.b();
        if (r3 == null) goto L12;
        r3.b(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    public int getBoxType() {
        return this.E;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10, types: [android.view.View, android.widget.TextView, com.larus.bmhome.view.textview.impl.CustomMarkdownTextView, com.larus.bmhome.view.textview.impl.CustomUnderlineTextView] */
    public SummaryCardBox(Context r14) {
        Intrinsics.checkNotNullParameter(r14, "context");
        super(r14);
        int r0 = i5.e();
        this.p = r0;
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r1 == null) goto L5;
        r2 r2 = r1.A0();
    L6:
        this.D = r2;
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(-1, -2);
        View r15 = LayoutInflater.from(r14).inflate(2131562905, null);
        r3.setMargins(getResources().getDimensionPixelSize(2131167763), getResources().getDimensionPixelSize(2131167764), getResources().getDimensionPixelSize(2131167763), getResources().getDimensionPixelSize(2131167764));
        this.q = r15.findViewById(2131376720);
        this.r = (TextView) r15.findViewById(2131391691);
        this.s = (TextView) r15.findViewById(2131391684);
        this.t = r15.findViewById(2131392161);
        ConstraintLayout r4 = r15.findViewById(2131384727);
        MaxHeightRelativeLayout r5 = (MaxHeightRelativeLayout) r15.findViewById(2131384726);
        this.u = r5;
        this.v = r15.findViewById(2131392150);
        View r6 = r15.findViewById(2131378741);
        this.x = r6;
        TextView r7 = (TextView) r15.findViewById(2131390583);
        if (r7 == null) goto L9;
        we8.a.b(r7, i5.o(), false, null, null, 12);
    L10:
        this.y = r7;
        this.z = r15.findViewById(2131384725);
        ?? r8 = new CustomMarkdownTextView(getContext(), null, 6, 0);
        r8.setMarkdownWidth(getMaxWidth());
        r8.setBottomLineWeight(i5.x0(2131165973));
        r8.setLineColor(1207959551);
        m(r8);
        r8.setLineSpacing(0.0f, 1.1f);
        if (r5 == 0) goto L14;
        LinearLayout.LayoutParams r9 = new LinearLayout.LayoutParams(-2, -2);
        r9.gravity = 8388661;
        Unit r10 = Unit.INSTANCE;
        r5.addView(r8, r9);
    L14:
        if (getImmerseBgColor() == null) goto L16;
        r8.setTextColor(ContextCompat.getColor(getContext(), 2131103298));
    L17:
        AppCompatTextView r11 = this.w;
        if (r11 == null) goto L20;
        r11.setVisibility(8);
    L20:
        this.w = r8;
        if (r8.isAttachedToWindow() == false) goto L24;
        r8.addOnAttachStateChangeListener(new u(r8));
    L24:
        if (r6 == null) goto L26;
        r6.setVisibility(0);
    L26:
        if (r5 == 0) goto L28;
        r5.setMaxHeight(r0);
    L28:
        addView(r15, r3);
        return;
    L16:
        r8.setTextColor(ContextCompat.getColor(getContext(), 2131103681));
        goto L17
    L9:
        r7 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final void m(TextView r4) {
        if (getImmerseBgColor() == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        float r1 = we8.a.a(i5.o(), true);
    L9:
        r4.setTextSize(0, r1);
        return;
    L8:
        r1 = we8.a.a(i5.t(), false);
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    public final com.larus.extension.summary_card.impl.component.g q(Message r2) {
        com.larus.extension.summary_card.impl.component.a r0 = this.C;
        if (r0 == null) goto L6;
        com.larus.extension.summary_card.impl.component.g r1 = r0.TY(r2);
        if (r1 == null) goto L6;
        return r1;
    L6:
        int r3 = com.larus.extension.summary_card.impl.component.g.h;
        return com.larus.extension.summary_card.impl.component.g.a.a(r2);
    }

    public void setBoxType(int r1) {
        this.E = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void s(Message r57, BotModel r58) {
        SummaryCardMessageContent r1 = this.B;
        if (r1 != null) goto L5;
        return;
    L5:
        String r2 = r58.getBotId();
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        if (o0.d(r1.getSchema()) == false) goto L14;
        r2 r3 = this.D;
        if (r3 == null) goto L60;
        r3.a(getContext(), UriProtector.parse(r1.getSchema()));
        return;
    L60:
        return;
    L14:
        Integer r4 = r1.getItemType();
        int r5 = SummaryCardItemType.VIDEO.getValue();
        if (r4 != null) goto L18;
    L50:
        int r6 = SummaryCardItemType.ARTICLE.getValue();
        if (r4 != null) goto L54;
    L58:
        FLogger.a.e("SummaryCardBox", "SummaryCardBox onSummaryItemClick unknown item type");
        return;
    L54:
        if (r4.intValue() != r6) goto L58;
        String r18 = r2;
        ArticleParam r7 = new ArticleParam(r1.getItemId(), r1.getScene(), null, null, null, null, null, null, null, null, null, null, r57.getMessageId(), r18, r57.getSectionId(), null, null, null, 233468, null);
        r2 r8 = this.D;
        if (r8 == null) goto L63;
        r8.e(getContext(), r7, r1.getItemSourceApp());
        return;
    L63:
        return;
    L18:
        if (r4.intValue() != r5) goto L50;
        MediaEntity[] r9 = new MediaEntity[1];
        String r25 = r1.getAuthorId();
        String r26 = r1.getAuthorName();
        String r27 = r1.getAuthorAvatar();
        String r14 = r1.getItemCover();
        String r10 = r1.getItemId();
        long r22 = r1.getDuration();
        String r29 = r1.getScene();
        Integer r11 = r1.getItemSourceApp();
        int r12 = ItemSourceApp.DOUYIN.getValue();
        if (r11 != null) goto L23;
    L26:
        int r13 = ItemSourceApp.TOUTIAO.getValue();
        if (r11 != null) goto L30;
    L32:
        int r15 = SourceFrom.Unknown.value;
    L33:
        r9[0] = new MediaEntity(null, r10, null, null, null, null, null, r14, null, null, null, null, Integer.valueOf(r15), null, null, Long.valueOf(r22), 0, null, r25, r26, r27, 0, r29, null, 8613757, null);
        ArrayList r16 = CollectionsKt.arrayListOf(r9);
        MediaEntityContainer r17 = new MediaEntityContainer(null, r16, null, null, false, 0, 0, null, 253, null);
        String r19 = r57.getMessageId();
        if (r19 != null) goto L36;
        String r20 = "";
    L37:
        String r110 = r57.getConversationId();
        String r21 = r1.getItemCover();
        if (r21 != null) goto L40;
        String r111 = "";
    L41:
        String r112 = EnterVideoMethod.SEARCH_VIDEO_PAGE.getValue();
        Pair[] r23 = new Pair[5];
        r23[0] = TuplesKt.to("enter_method", "click_video_card");
        r23[1] = TuplesKt.to("previous_page", "chat");
        r23[2] = TuplesKt.to("bot_id", r2);
        String r24 = r57.getMessageId();
        if (r24 != null) goto L44;
        r24 = "";
    L44:
        r23[3] = TuplesKt.to(MusicAppletPage.KEY_MESSAGE_ID, r24);
        String r28 = r57.getConversationId();
        if (r28 != null) goto L47;
        r28 = "";
    L47:
        r23[4] = TuplesKt.to(MusicAppletPage.KEY_CONVERSATION_ID, r28);
        Map r113 = MapsKt.mutableMapOf(r23);
        String r114 = MainBotServiceDelegate.b.a();
        String r210 = r57.getReplyId();
        String r30 = r2;
        VideoParam r31 = new VideoParam(r16, r17, -1, r30, r20, r110, null, 0, r112, r111, r114, r113, null, 0, 0, null, false, r57.getSectionId(), null, null, null, false, null, null, r210, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 0, null, null, -16936832, 131071);
        r2 r32 = this.D;
        if (r32 == null) goto L61;
        r32.p(getContext(), "", r31);
        return;
    L61:
        return;
    L40:
        r111 = r21;
        goto L41
    L36:
        r20 = r19;
        goto L37
    L30:
        if (r11.intValue() != r13) goto L32;
        r15 = SourceFrom.Toutiao.value;
        goto L33
    L23:
        if (r11.intValue() != r12) goto L26;
        r15 = SourceFrom.DouYin.value;
        goto L33
    }

    public final void r(Message r16, BotModel r17, String r18, Function2<? super String, ? super Boolean, Unit> r19) {
        String r1 = r16.getMessageId();
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new SummaryCardBox$handleVideoSummaryExpand$1(this, r16, r17, null), 2, null);
    L11:
        com.larus.extension.summary_card.impl.component.g r3 = q(r16);
        if (Intrinsics.areEqual(r3.b, com.larus.extension.summary_card.impl.component.f.d.a) == false) goto L14;
        com.larus.extension.summary_card.impl.component.f r4 = com.larus.extension.summary_card.impl.component.f.b.a;
    L15:
        com.larus.extension.summary_card.impl.component.a r9 = this.C;
        if (r9 == null) goto L25;
        String r5 = r16.getLocalMessageId();
        if (r5 != null) goto L20;
        r5 = "";
    L20:
        String r10 = r5;
        MaxHeightRelativeLayout r6 = this.u;
        if (r6 == null) goto L23;
        int r7 = r6.getHeight();
    L24:
        r9.u80(r10, com.larus.extension.summary_card.impl.component.g.a(r3, r16, r4, false, r7, false, 92));
        goto L25
    L23:
        r7 = 0;
    L25:
        com.larus.extension.summary_card.impl.component.a r8 = this.C;
        if (r8 == null) goto L28;
        r8.r90(r16);
    L28:
        r19.invoke(r18, Boolean.TRUE);
        return;
    L14:
        r4 = new com.larus.extension.summary_card.impl.component.f.c(o0.d(r16.getMessageId()));
        goto L15
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o(String r36, boolean r37, final BotModel r38, final Message r39, boolean r40, String r41, final Function3<? super Message, ? super BotModel, ? super CustomMarkdownTextView, Unit> r42, final Function2<? super Message, ? super CustomMarkdownTextView, Unit> r43, final Function2<? super String, ? super Boolean, Unit> r44) {
        AppCompatTextView r3 = this.w;
        boolean r4 = false;
        if (r3 == null) goto L5;
        r3.setVisibility(0);
    L5:
        AppCompatTextView r5 = this.w;
        if (r5 == null) goto L10;
        float r6 = we8.a.a(i5.q(), r37);
        int r14 = we8.e.a(r37) + 14;
        int r18 = we8.e.a(r37);
        lw8.d r7 = new lw8.d(0, null, r5.getContext().getString(2131907401), false, null, r14, null, r6, null, r18, 0, null, null, null, null, null, null, null, null, null, null, null, new mw8.b(r6, ContextCompat.getColor(getContext(), 2131103681)), null, -5289, 30);
        gw8.c.a.getClass();
        gw8.c r8 = gw8.c.a.b();
        if (r8 == null) goto L10;
        lw8.l r9 = c$b.b(r8, r5, r36, true, r7);
    L11:
        if (r40 == false) goto L13;
    L25:
        AppCompatTextView r10 = this.w;
        if (r10 == null) goto L28;
        r10.setOnLongClickListener(new j(r42, r39, r38, this));
    L28:
        AppCompatTextView r1 = this.w;
        if (r1 == null) goto L31;
        r1.setOnClickListener(new k(r43, r39, this));
    L31:
        CustomMarkdownTextView r2 = this.w;
        if (r2 == null) goto L35;
        r2.setMarkdown(r9);
        return;
    L35:
        return;
    L13:
        if (o0.d(r39.getMessageId()) == true) goto L25;
        if (Intrinsics.areEqual(r41, TriggerSendLoading.NO_LOADING) == false) goto L24;
        String r11 = r39.getMessageId();
        if (r11 != null) goto L20;
    L21:
        r4 = true;
    L22:
        if (r4 == false) goto L24;
        e1.d(this.w, new l());
        goto L31
    L20:
        if (r11.length() != 0) goto L22;
    L24:
        e1.d(this.w, new m(this, r39, r38, r44));
    L10:
        r9 = null;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n(boolean r19, final Message r20, final BotModel r21, String r22, String r23, boolean r24, Function3<? super Message, ? super BotModel, ? super CustomMarkdownTextView, Unit> r25, Function2<? super Message, ? super CustomMarkdownTextView, Unit> r26, final Function2<? super String, ? super Boolean, Unit> r27, final Function0<Unit> r28) {
        com.larus.extension.summary_card.impl.component.g r15 = q(r20);
        if (r19 == false) goto L44;
        View r0 = this.x;
        if (r0 == null) goto L7;
        e1.o(r0);
    L7:
        o(r22, r24, r21, r20, true, r23, r25, r26, r27);
        com.larus.extension.summary_card.impl.component.f r1 = r15.b;
        if ((r1 instanceof com.larus.extension.summary_card.impl.component.f.c) == false) goto L31;
        final boolean r2 = ((com.larus.extension.summary_card.impl.component.f.c) r1).a;
        MaxHeightRelativeLayout r3 = this.u;
        if (r3 == null) goto L12;
        r3.a();
    L12:
        MaxHeightRelativeLayout r4 = this.u;
        if (r4 == null) goto L15;
        r4.measure(View.MeasureSpec.makeMeasureSpec(getMaxWidth(), Integer.MIN_VALUE), 0);
    L15:
        final int r5 = q(r20).f;
        ConstraintLayout r6 = this.z;
        if (r6 == null) goto L22;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 == null) goto L21;
        r7.height = r5;
        getParent().requestLayout();
        r6.setLayoutParams(r7);
        goto L22
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L22:
        ConstraintLayout r8 = this.z;
        if (r8 == null) goto L25;
        r8.post(new b(this, r5, r2));
    L25:
        com.larus.extension.summary_card.impl.component.a r9 = this.C;
        if (r9 == null) goto L197;
        String r10 = r20.getLocalMessageId();
        if (r10 != null) goto L30;
        r10 = "";
    L30:
        r9.u80(r10, com.larus.extension.summary_card.impl.component.g.a(q(r20), r20, com.larus.extension.summary_card.impl.component.f.b.a, false, 0, false, 124));
        return;
    L197:
        return;
    L31:
        MaxHeightRelativeLayout r11 = this.u;
        if (r11 == null) goto L34;
        r11.a();
    L34:
        MaxHeightRelativeLayout r12 = this.u;
        if (r12 == null) goto L37;
        r12.measure(View.MeasureSpec.makeMeasureSpec(getMaxWidth(), Integer.MIN_VALUE), 0);
    L37:
        TextView r13 = this.y;
        if (r13 == null) goto L40;
        e1.o(r13);
    L40:
        View r14 = this.v;
        if (r14 == null) goto L199;
        e1.o(r14);
        return;
    L199:
        return;
    L44:
        if (Intrinsics.areEqual(r23, TriggerSendLoading.NO_LOADING) == false) goto L66;
        String r16 = r20.getMessageId();
        if (r16 != null) goto L48;
    L51:
        boolean r17 = true;
    L52:
        if (r17 == false) goto L66;
        o(r22, r24, r21, r20, false, r23, r25, r26, r27);
        if (r15.g == false) goto L56;
        ValueAnimator r18 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(240);
        r18.addUpdateListener(new n(this));
        r18.addListener(new p(this));
        r18.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        r18.start();
        return;
    L56:
        View r29 = this.x;
        if (r29 == null) goto L59;
        e1.o(r29);
    L59:
        View r30 = this.v;
        if (r30 == null) goto L62;
        e1.o(r30);
    L62:
        TextView r31 = this.y;
        if (r31 == null) goto L202;
        e1.o(r31);
        return;
    L202:
        return;
    L48:
        if (r16.length() == 0) goto L51;
        r17 = false;
    L66:
        if (r15.g == false) goto L144;
        o(r22, r24, r21, r20, false, r23, r25, r26, r27);
        if (Intrinsics.areEqual(r15.b, com.larus.extension.summary_card.impl.component.f.d.a) == false) goto L103;
        TextView r32 = this.y;
        if (r32 == null) goto L72;
        e1.o(r32);
    L72:
        View r33 = this.v;
        if (r33 == null) goto L75;
        e1.o(r33);
    L75:
        MaxHeightRelativeLayout r34 = this.u;
        if (r34 == null) goto L78;
        r34.a();
    L78:
        MaxHeightRelativeLayout r35 = this.u;
        if (r35 == null) goto L81;
        int r36 = 0;
        r35.measure(View.MeasureSpec.makeMeasureSpec(getMaxWidth(), Integer.MIN_VALUE), 0);
    L82:
        TextView r37 = this.y;
        if (r37 == null) goto L85;
        r37.measure(View.MeasureSpec.makeMeasureSpec(getMaxWidth(), Integer.MIN_VALUE), r36);
    L85:
        View r38 = this.x;
        if (r38 == null) goto L88;
        final int r39 = r38.getMeasuredHeight();
    L89:
        MaxHeightRelativeLayout r40 = this.u;
        if (r40 == null) goto L92;
        int r110 = r40.getMeasuredHeight();
    L93:
        final int r41 = r110 + 0;
        FLogger.a.i("SummaryCardBox", "loadingDisappear OfSummaryContent ToNonCollapsed loadingHeight = " + r39 + " targetHeight = " + r41);
        if (1 > r39) goto L97;
        if (r39 >= r41) goto L97;
        boolean r42 = true;
    L98:
        if (r42 == false) goto L100;
        ValueAnimator r43 = ValueAnimator.ofInt(new int[]{r39, r41}).setDuration(240);
        r43.addUpdateListener(new i(r41, r39, this, r28));
        r43.addListener(new t(this));
        r43.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        r43.start();
        return;
    L100:
        View r44 = this.x;
        if (r44 == null) goto L205;
        e1.o(r44);
        return;
    L205:
        return;
    L97:
        r42 = false;
        goto L98
    L92:
        r110 = 0;
        goto L93
    L88:
        r39 = 0;
        goto L89
    L81:
        r36 = 0;
        goto L82
    L103:
        MaxHeightRelativeLayout r45 = this.u;
        if (r45 == null) goto L106;
        r45.setMaxHeight(this.p);
    L106:
        MaxHeightRelativeLayout r46 = this.u;
        if (r46 == null) goto L109;
        int r47 = 0;
        r46.measure(View.MeasureSpec.makeMeasureSpec(getMaxWidth(), Integer.MIN_VALUE), 0);
    L110:
        TextView r48 = this.y;
        if (r48 == null) goto L113;
        r48.measure(View.MeasureSpec.makeMeasureSpec(getMaxWidth(), Integer.MIN_VALUE), r47);
    L113:
        View r49 = this.x;
        if (r49 == null) goto L116;
        final int r50 = r49.getMeasuredHeight();
    L117:
        MaxHeightRelativeLayout r51 = this.u;
        if (r51 == null) goto L120;
        int r52 = r51.getMeasuredHeight();
    L121:
        TextView r53 = this.y;
        if (r53 == null) goto L124;
        int r54 = r53.getMeasuredHeight();
    L125:
        final int r55 = r52 + r54;
        FLogger.a.i("SummaryCardBox", "loadingDisappear OfSummaryContent loadingHeight = " + r50 + " targetHeight = " + r55);
        if (1 > r50) goto L129;
        if (r50 >= r55) goto L129;
        boolean r56 = true;
    L130:
        if (r56 == false) goto L132;
        ValueAnimator r57 = ValueAnimator.ofInt(new int[]{r50, r55}).setDuration(240);
        r57.addUpdateListener(new c(r55, r50, this, r28));
        r57.addListener(new s(this, r20, r21, r27));
        r57.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        r57.start();
        return;
    L132:
        View r58 = this.x;
        if (r58 == null) goto L135;
        e1.o(r58);
    L135:
        TextView r59 = this.y;
        if (r59 == null) goto L138;
        e1.x(r59);
    L138:
        TextView r60 = this.y;
        if (r60 == null) goto L141;
        e1.d(r60, new d(this, r20, r21, r27));
    L141:
        View r61 = this.v;
        if (r61 == null) goto L208;
        e1.x(r61);
        return;
    L208:
        return;
    L129:
        r56 = false;
        goto L130
    L124:
        r54 = 0;
        goto L125
    L120:
        r52 = 0;
        goto L121
    L116:
        r50 = 0;
        goto L117
    L109:
        r47 = 0;
        goto L110
    L144:
        View r62 = this.x;
        if (r62 == null) goto L147;
        e1.o(r62);
    L147:
        TextView r63 = this.y;
        if (r63 == null) goto L150;
        e1.d(r63, new h(this, r20, r21, r27));
    L150:
        o(r22, r24, r21, r20, false, r23, r25, r26, r27);
        if (Intrinsics.areEqual(r15.b, com.larus.extension.summary_card.impl.component.f.d.a) == false) goto L168;
        MaxHeightRelativeLayout r64 = this.u;
        if (r64 == null) goto L155;
        r64.a();
    L155:
        MaxHeightRelativeLayout r65 = this.u;
        if (r65 == null) goto L158;
        int r66 = 0;
        r65.measure(View.MeasureSpec.makeMeasureSpec(getMaxWidth(), Integer.MIN_VALUE), 0);
    L159:
        TextView r67 = this.y;
        if (r67 == null) goto L162;
        r67.measure(View.MeasureSpec.makeMeasureSpec(getMaxWidth(), Integer.MIN_VALUE), r66);
    L162:
        TextView r68 = this.y;
        if (r68 == null) goto L165;
        e1.o(r68);
    L165:
        View r69 = this.v;
        if (r69 == null) goto L210;
        e1.o(r69);
        return;
    L210:
        return;
    L158:
        r66 = 0;
        goto L159
    L168:
        MaxHeightRelativeLayout r70 = this.u;
        if (r70 == null) goto L171;
        r70.setMaxHeight(this.p);
    L171:
        MaxHeightRelativeLayout r71 = this.u;
        if (r71 == null) goto L174;
        int r72 = 0;
        r71.measure(View.MeasureSpec.makeMeasureSpec(getMaxWidth(), Integer.MIN_VALUE), 0);
    L175:
        TextView r73 = this.y;
        if (r73 == null) goto L178;
        r73.measure(View.MeasureSpec.makeMeasureSpec(getMaxWidth(), Integer.MIN_VALUE), r72);
    L178:
        MaxHeightRelativeLayout r74 = this.u;
        if (r74 == null) goto L181;
        int r75 = r74.getMeasuredHeight();
    L183:
        if (r75 < this.p) goto L190;
        TextView r76 = this.y;
        if (r76 == null) goto L187;
        e1.x(r76);
    L187:
        View r77 = this.v;
        if (r77 == null) goto L212;
        e1.x(r77);
        return;
    L212:
        return;
    L190:
        TextView r78 = this.y;
        if (r78 == null) goto L193;
        e1.o(r78);
    L193:
        View r79 = this.v;
        if (r79 == null) goto L214;
        e1.o(r79);
        return;
    L214:
        return;
    L181:
        r75 = 0;
        goto L183
    L174:
        r72 = 0;
        goto L175
    }
}

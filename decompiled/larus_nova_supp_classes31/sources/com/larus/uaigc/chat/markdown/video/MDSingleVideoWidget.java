package com.larus.uaigc.chat.markdown.video;

import android.content.Context;
import android.text.Spanned;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.chat.layout.holder.video.bean.CoverImageEntity;
import com.larus.bmhome.chat.layout.holder.video.bean.CoverItem;
import com.larus.bmhome.creative.messagecard.bean.CreationAsset;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.bmhome.creative.messagecard.bean.LoadingInfo;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.f3$a;
import com.larus.platform.service.e2;
import com.larus.uaigc.chat.markdown.image.MDImageScrollWidget;
import com.larus.uaigc.chat.markdown.video.statemanager.VideoFailedState;
import com.larus.uaigc.chat.markdown.video.statemanager.VideoLoadingState;
import com.larus.uaigc.chat.markdown.video.statemanager.VideoQueuingState;
import com.larus.uaigc.chat.markdown.video.statemanager.n;
import com.larus.uaigc.impl.databinding.LarusWidgetMarkdownCreationSingleVideoBinding;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u00102\u001a\u000203J\u008b\u0001\u00104\u001a\u00020\t2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u00105\u001a\u00020'2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010%\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u00106J2\u00107\u001a\u0002032\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00105\u001a\u00020'H\u0002J2\u00108\u001a\u0002032\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00105\u001a\u00020'H\u0002J\u0010\u00109\u001a\u0002032\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010:\u001a\u00020'2\u0006\u00105\u001a\u00020'H\u0002J\u0010\u0010;\u001a\u00020'2\u0006\u00105\u001a\u00020'H\u0002R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0004\n\u0002\u0010(R\u0014\u0010)\u001a\u00020'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b.\u0010/¨\u0006<"}, d2 = {"Lcom/larus/uaigc/chat/markdown/video/MDSingleVideoWidget;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "spanSize", "Landroid/util/Size;", "binding", "Lcom/larus/uaigc/impl/databinding/LarusWidgetMarkdownCreationSingleVideoBinding;", "message", "Lcom/larus/im/bean/message/Message;", "creationContentData", "Lcom/larus/bmhome/creative/messagecard/bean/CreationMsgContentData;", "botId", "", "isCollectMode", "", "Ljava/lang/Boolean;", "currentPage", "previousPage", "modelProvider", "Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;", "chatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "textView", "Landroid/widget/TextView;", "text", "Landroid/text/Spanned;", "span", "Lio/noties/markwon/html/customdata/ICustomDataSpan;", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "task", "Lcom/larus/bmhome/creative/messagecard/bean/CreationTask;", "isLongPicShare", "lastMaxWidth", "", "Ljava/lang/Integer;", "defaultMaxWidth", "getDefaultMaxWidth", "()I", "videoViewBinder", "Lcom/larus/uaigc/chat/markdown/video/MDSingleVideoViewBinder;", "getVideoViewBinder", "()Lcom/larus/uaigc/chat/markdown/video/MDSingleVideoViewBinder;", "videoViewBinder$delegate", "Lkotlin/Lazy;", "onRecycle", "", "bindData", "maxWidth", "(Lkotlinx/coroutines/CoroutineScope;Lcom/larus/bmhome/creative/messagecard/bean/CreationTask;Landroid/widget/TextView;Landroid/text/Spanned;Lio/noties/markwon/html/customdata/ICustomDataSpan;Lcom/larus/im/bean/message/Message;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;ZLcom/larus/bmhome/chat/bean/ChatPageContext;)Landroid/util/Size;", "refreshViewState", "updateSizeInfo", "initView", "maxImageHeight", "maxImageWidth", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MDSingleVideoWidget extends ConstraintLayout {
    public static final /* synthetic */ int q = 0;
    public Size a;
    public LarusWidgetMarkdownCreationSingleVideoBinding b;
    public Message c;
    public String d;
    public Boolean e;
    public String f;
    public String g;
    public q0.a h;
    public ChatPageContext i;
    public TextView j;
    public usc.e k;
    public CoroutineScope l;
    public CreationTask m;
    public boolean n;
    public Integer o;
    public final Lazy p;

    private final int getDefaultMaxWidth() {
        if (((Boolean) MDImageScrollWidget.y.getValue()).booleanValue() == false) goto L8;
        e2 r0 = e2.a;
        if (r0.g() == r0.f()) goto L8;
        return (int) (f3$a.a() / 3.3f);
    L8:
        return i5.a0();
    }

    private final j getVideoViewBinder() {
        return (j) this.p.getValue();
    }

    public final void f() {
        getVideoViewBinder().g.a.g(null);
    }

    public MDSingleVideoWidget(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public MDSingleVideoWidget(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = new Size(0, 0);
        this.e = Boolean.FALSE;
        this.p = LazyKt.lazy(LazyThreadSafetyMode.NONE, new k(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(LifecycleCoroutineScope r2, CreationTask r3, final TextView r4, Spanned r5, usc.e r6, Message r7, int r8, String r9, String r10, String r11, Boolean r12, q0.a r13, boolean r14, ChatPageContext r15) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleScope");
        Intrinsics.checkNotNullParameter(r4, "textView");
        Intrinsics.checkNotNullParameter(r5, "text");
        Intrinsics.checkNotNullParameter(r6, "span");
        this.c = r7;
        if (r7 == null) goto L5;
        dp8.e.c(r7);
    L5:
        this.d = r9;
        this.f = r10;
        this.g = r11;
        this.e = r12;
        this.h = r13;
        this.i = r15;
        this.j = r4;
        this.k = r6;
        this.l = r2;
        this.m = r3;
        this.n = r14;
        if (this.b != null) goto L8;
        LayoutInflater.from(getContext()).inflate(2131563257, this);
        LarusWidgetMarkdownCreationSingleVideoBinding r16 = LarusWidgetMarkdownCreationSingleVideoBinding.a(this);
        this.b = r16;
        r16.a.setOnLongClickListener(new l(r4));
        Unit r17 = Unit.INSTANCE;
    L8:
        Integer r18 = this.o;
        int r19 = 0;
        if (r18 != null) goto L12;
    L18:
        this.o = Integer.valueOf(r8);
        int r20 = gw8.e.a(r5, r5.getSpanStart(r6)) + r4.getPaddingStart();
        int r21 = r4.getPaddingEnd();
        int r22 = (r8 - r20) - r21;
        LoadingInfo r23 = r3.loadingInfo;
        CreationAsset r24 = r3.asset;
        if (r24 == null) goto L29;
        ep8.a r25 = r24.videoContent;
        if (r25 == null) goto L29;
        AiGenVideoContentData r26 = r25.videoInfo;
        if (r26 == null) goto L29;
        CoverItem r27 = r26.getVideoCover();
        if (r27 == null) goto L29;
        CoverImageEntity r28 = r27.getPreviewImage();
        if (r28 == null) goto L29;
        long r110 = r28.getWidth();
    L30:
        CreationAsset r29 = r3.asset;
        if (r29 == null) goto L41;
        ep8.a r30 = r29.videoContent;
        if (r30 == null) goto L41;
        AiGenVideoContentData r31 = r30.videoInfo;
        if (r31 == null) goto L41;
        CoverItem r32 = r31.getVideoCover();
        if (r32 == null) goto L41;
        CoverImageEntity r33 = r32.getPreviewImage();
        if (r33 == null) goto L41;
        long r111 = r33.getHeight();
    L43:
        if (r110 > 0) goto L45;
    L46:
        if (r23 == null) goto L50;
        Long r34 = r23.width;
        if (r34 == null) goto L50;
        r110 = r34.longValue();
    L51:
        if (r23 == null) goto L55;
        Long r35 = r23.height;
        if (r35 == null) goto L55;
        r111 = r35.longValue();
    L57:
        if (r111 > 0) goto L59;
    L81:
        this.a = new Size(0, 0);
    L82:
        j r36 = getVideoViewBinder();
        int r37 = r36.g.a.getLevel();
        Integer r38 = r3.status;
        if (r38 == null) goto L94;
        int r39 = r38.intValue();
        if (r39 == 1) goto L93;
        if (r39 == 3) goto L92;
        if (r39 == 4) goto L91;
        if (r39 == 5) goto L90;
        r19 = -1;
        goto L94
    L90:
        r19 = 4;
        goto L94
    L91:
        r19 = 3;
        goto L94
    L92:
        r19 = 1;
        goto L94
    L93:
        r19 = 2;
    L94:
        if (r37 > r19) goto L126;
        Integer r40 = r3.status;
        if (r40 != null) goto L100;
    L102:
        if (r40 != null) goto L105;
    L107:
        if (r40 != null) goto L110;
    L112:
        if (r40 != null) goto L115;
    L117:
        n r41 = r36.g;
        String r42 = r3.id;
        Message r43 = r36.a.c;
        if (Intrinsics.areEqual(r41.b, r41.a) == true) goto L123;
        ez9.c r44 = r41.b;
        if (r44 == null) goto L122;
        r44.g(r41.a);
    L122:
        r41.a.e(r42, r43);
    L124:
        r41.b = null;
        return;
    L123:
        r41.a.e(r42, r43);
        goto L124
    L115:
        if (r40.intValue() != 3) goto L117;
        r36.g.a((VideoQueuingState) r36.c.getValue());
        goto L117
    L110:
        if (r40.intValue() != 5) goto L112;
        r36.g.a((VideoFailedState) r36.e.getValue());
        goto L117
    L105:
        if (r40.intValue() != 4) goto L107;
        r36.g.a((com.larus.uaigc.chat.markdown.video.statemanager.i) r36.f.getValue());
        goto L117
    L100:
        if (r40.intValue() != 1) goto L102;
        r36.g.a((VideoLoadingState) r36.d.getValue());
        goto L117
    L126:
        return;
    L59:
        if (r110 <= 0) goto L81;
        float r45 = r111 / r110;
        int r46 = RangesKt.coerceAtMost(r22, getDefaultMaxWidth());
        int r47 = RangesKt.coerceAtMost(r22, getDefaultMaxWidth());
        if (r45 <= 1.0f) goto L65;
        int r112 = (int) (r47 / r45);
        if (r112 >= r46) goto L65;
        r46 = r112;
    L66:
        LarusWidgetMarkdownCreationSingleVideoBinding r48 = this.b;
        if (r48 == null) goto L75;
        VideoPlayView r49 = r48.i;
        if (r49 == null) goto L75;
        ViewGroup.LayoutParams r113 = r49.getLayoutParams();
        if (r113 == null) goto L74;
        r113.height = r47;
        r113.width = r46;
        r49.setLayoutParams(r113);
        goto L75
    L74:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L75:
        LarusWidgetMarkdownCreationSingleVideoBinding r50 = this.b;
        if (r50 == null) goto L80;
        View r51 = r50.a;
        if (r51 == null) goto L80;
        int r52 = i5.Y();
        int r114 = i5.Y();
        FLogger.a.i("updatePaddingRelative", "view:" + r51.getClass().getSimpleName() + ",source:,start:" + r20 + ",top:" + r52 + ",end:" + r21 + ",bottom:" + r114);
        r51.setPaddingRelative(r20, r52, r21, r114);
    L80:
        this.a = new Size(r8, r47 + i5.r0());
    L65:
        r47 = (int) (r46 * r45);
    L55:
        r111 = 0;
    L50:
        r110 = 0;
        goto L51
    L45:
        if (r111 > 0) goto L57;
    L41:
        r111 = 0;
    L29:
        r110 = 0;
        goto L30
    L12:
        if (r18.intValue() != r8) goto L18;
        if (this.a.getWidth() <= 0) goto L18;
        if (this.a.getHeight() <= 0) goto L18;
        goto L18
    }
}

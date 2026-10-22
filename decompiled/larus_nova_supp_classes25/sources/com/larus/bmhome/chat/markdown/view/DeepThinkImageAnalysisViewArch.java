package com.larus.bmhome.chat.markdown.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.monitor.IMessageImageLoaderService;
import com.larus.bmhome.chat.monitor.MessageImageLoader;
import com.larus.bmhome.chat.monitor.MessageImageType;
import com.larus.common_ui.widget.shimmer.ShimmerMaskView;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.VLMImage;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusDtImageAnalysisViewBinding;
import com.larus.utils.e1;
import fh8.f;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sh8.c;
import sh8.g;
import sh8.h;
import sh8.i;
import sh8.j;
import sh8.m;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\u00020\u0001:\u00010B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fJ \u0010\u0019\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J \u0010\u001a\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J%\u0010\u001b\u001a\u00020\u00122\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010\u001eJ!\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u000f2\b\u0010\"\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010#J\u001a\u0010$\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00142\b\u0010(\u001a\u0004\u0018\u00010\u0015H\u0002J\"\u0010)\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010-\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010.\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010/\u001a\u00020\u0012R\u001b\u0010\b\u001a\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/larus/bmhome/chat/markdown/view/DeepThinkImageAnalysisViewArch;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusDtImageAnalysisViewBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusDtImageAnalysisViewBinding;", "binding$delegate", "Lkotlin/Lazy;", "analysisImageMaxWidth", "", "analysisImageMaxHeight", "bindData", "", "imageList", "", "Lcom/larus/im/bean/message/VLMImage;", "markdownCommonInputData", "Lcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;", "maxWidth", "loadAnalysisImage", "loadBackgroundImage", "setImageLayoutParams", "imageWidth", "imageHeight", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "adjustImageRatio", "", "widthParams", "heightParams", "(Ljava/lang/Integer;Ljava/lang/Integer;)F", "openBigImage", "analysisImage", "getBigImageInfoList", "Lcom/larus/bmhome/bigimg/BigImageInfo;", "image", "mobCardShow", "view", "Landroid/view/View;", "imageCard", "realMobCardShow", "mobCardClick", "onViewRecycled", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DeepThinkImageAnalysisViewArch extends FrameLayout {
    public static final /* synthetic */ int d = 0;
    public final Lazy a;
    public int b;
    public final int c;

    public static final class a {
    }

    static {
    }

    public final LarusDtImageAnalysisViewBinding getBinding() {
        return (LarusDtImageAnalysisViewBinding) this.a.getValue();
    }

    public DeepThinkImageAnalysisViewArch(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public DeepThinkImageAnalysisViewArch(final Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = LazyKt.lazy(new c(r2, this));
        this.c = c7.b(Integer.valueOf(DoraCallStateCode.DOUBAO_STOP_SI_BY_GUI));
    }

    public final void a(List<VLMImage> r23, final f r24, int r25) {
        Intrinsics.checkNotNullParameter(r24, "markdownCommonInputData");
        this.b = r25 - c7.b(16);
        String r2 = null;
        if (r23 == null) goto L38;
        Iterator<T> r3 = r23.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        Object r4 = r3.next();
        if ((!Intrinsics.areEqual(((VLMImage) r4).isBlurBackground(), Boolean.TRUE)) == false) goto L6;
    L11:
        final VLMImage r5 = (VLMImage) r4;
        if (r5 == null) goto L38;
        Integer r6 = r5.getWidth();
        Integer r7 = r5.getHeight();
        int r8 = 0;
        if (r6 == null) goto L17;
        int r9 = r6.intValue();
    L18:
        if (r7 == null) goto L20;
        r8 = r7.intValue();
    L20:
        if (r9 <= 0) goto L24;
        if (r8 <= 0) goto L24;
        float r10 = Math.max(0.4f, Math.min(2.5f, r9 / r8));
    L25:
        int r11 = this.c;
        float r12 = r11 * r10;
        float r13 = this.b;
        if (r12 <= r13) goto L28;
        r11 = (int) (r13 / r10);
        r12 = r13;
    L28:
        SimpleDraweeView r14 = getBinding().b;
        int r15 = (int) r12;
        FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(r15, r11);
        r16.gravity = 17;
        r14.setLayoutParams(r16);
        ShimmerMaskView r17 = getBinding().d;
        FrameLayout.LayoutParams r18 = new FrameLayout.LayoutParams(r15, r11);
        r18.gravity = 17;
        r17.setLayoutParams(r18);
        MessageImageLoader r19 = MessageImageLoader.a;
        Message r20 = r24.b;
        if (r20 == null) goto L31;
        String r110 = r20.getMessageId();
    L32:
        MessageImageType r111 = MessageImageType.IMAGE;
        SimpleDraweeView r112 = getBinding().b;
        String r21 = r5.getThumbUrl();
        if (r21 != null) goto L35;
        r21 = "";
    L35:
        IMessageImageLoaderService.a.b(r19, r110, r111, r112, r21, "DeepThinkImageAnalysisView", null, null, new g(this), new h(this), new i(this), false, 1120);
        e1.d(getBinding().b, new j(this, r5, r24));
        SimpleDraweeView r22 = getBinding().b;
        if (r22 == null) goto L38;
        ExposeXTrackerExtKt.b(r22, new m(r5, this, r24));
        goto L38
    L31:
        r110 = null;
    L24:
        r10 = 1.0f;
        goto L25
    L17:
        r9 = 0;
        goto L18
    L10:
        r4 = null;
    L38:
        if (r23 == null) goto L47;
        Iterator<T> r26 = r23.iterator();
    L41:
        if (r26.hasNext() == false) goto L45;
        Object r27 = r26.next();
        if (Intrinsics.areEqual(((VLMImage) r27).isBlurBackground(), Boolean.TRUE) == false) goto L41;
    L46:
        VLMImage r28 = (VLMImage) r27;
    L48:
        SimpleDraweeView r29 = getBinding().c;
        if (r28 == null) goto L51;
        String r30 = r28.getThumbUrl();
    L52:
        ImageLoaderKt.u(r29, r30, "DeepThinkImageAnalysisView");
        MessageImageLoader r31 = MessageImageLoader.a;
        Message r1 = r24.b;
        if (r1 == null) goto L55;
        String r32 = r1.getMessageId();
    L56:
        MessageImageType r33 = MessageImageType.IMAGE;
        SimpleDraweeView r113 = getBinding().c;
        if (r28 == null) goto L59;
        r2 = r28.getThumbUrl();
    L59:
        IMessageImageLoaderService.a.a(r31, r32, r33, r113, r2, "DeepThinkImageAnalysisView", new sh8.f(this), 32);
        return;
    L55:
        r32 = null;
        goto L56
    L51:
        r30 = null;
        goto L52
    L45:
        r27 = null;
        goto L46
    L47:
        r28 = null;
        goto L48
    }
}

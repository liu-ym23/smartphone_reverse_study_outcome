package com.larus.uaigc.chat.block.correction;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.bmhome.chat.monitor.IMessageImageLoaderService;
import com.larus.bmhome.chat.monitor.MessageImageLoader;
import com.larus.bmhome.chat.monitor.MessageImageType;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.ImagePlaceHolder;
import com.larus.im.bean.message.Message;
import com.larus.utils.e1;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 32\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u00013B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0004H\u0016J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0003H\u0002J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0003H\u0002J\u0018\u0010'\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0004H\u0002J\b\u0010(\u001a\u00020\u001fH\u0002J)\u0010)\u001a\u00020\u001b2\b\u0010*\u001a\u0004\u0018\u00010\u001d2\b\u0010+\u001a\u0004\u0018\u00010\u001d2\u0006\u0010,\u001a\u00020\u001dH\u0002¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020&2\u0006\u0010+\u001a\u00020\u001dH\u0002J\b\u0010/\u001a\u00020\u001fH\u0002J\b\u00100\u001a\u00020\u001fH\u0002J\b\u00101\u001a\u00020\u001fH\u0014J\b\u00102\u001a\u00020\u001fH\u0014R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/larus/uaigc/chat/block/correction/CorrectionImageView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/uaigc/chat/block/correction/CorrectionImageViewInput;", "Lcom/larus/uaigc/chat/block/correction/CorrectionImageViewOutput;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "retryContainer", "Landroid/widget/FrameLayout;", "failedContainer", "loadingContainer", "loadingImageCover", "Landroid/view/View;", "shimmerLoadingText", "Lcom/larus/bmhome/chat/layout/widget/ShimmerTextView;", "retryImageView", "Landroid/widget/ImageView;", "loadingImageView", "currentInput", "currentOutput", "latestSize", "Landroid/util/Size;", "latestStatus", "", "setupViews", "", "bindData", "input", "output", "showLoadingState", "showFailedState", "waitForImageLoadComplete", "", "showNormalState", "fromLoadingToCompleteInDelay", "calculateSize", "width", "height", "maxContentWidth", "(Ljava/lang/Integer;Ljava/lang/Integer;I)Landroid/util/Size;", "shouldHideImageForSmallHeight", "startShimmerAnimation", "stopShimmerAnimation", "onAttachedToWindow", "onDetachedFromWindow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CorrectionImageView extends ConstraintLayout {
    public static final /* synthetic */ int k = 0;
    public SimpleDraweeView a;
    public FrameLayout b;
    public FrameLayout c;
    public ConstraintLayout d;
    public View e;
    public ShimmerTextView f;
    public ImageView g;
    public ImageView h;
    public int i;
    public boolean j;

    public static final class a {
    }

    public static final class b implements ControllerListener<Object> {
        public final /* synthetic */ CorrectionImageView a;
        public final /* synthetic */ Size b;
        public final /* synthetic */ m c;

        public final void onIntermediateImageFailed(String r1, Throwable r2) {
        }

        public final void onIntermediateImageSet(String r1, Object r2) {
        }

        public final void onRelease(String r1) {
        }

        public final void onSubmit(String r1, Object r2) {
        }

        public final void onFailure(String r4, Throwable r5) {
            final CorrectionImageView r6 = this.a;
            final FrameLayout r7 = r6.b;
            if (r7 == null) goto L17;
            Size r0 = this.b;
            final m r1 = this.c;
            ConstraintLayout r2 = r6.d;
            if (r2 == null) goto L7;
            e1.q(r2);
        L7:
            e1.x(r7);
            if (r6.S5(r0.getHeight()) == false) goto L12;
            ImageView r3 = r6.g;
            if (r3 == null) goto L15;
            e1.o(r3);
        L15:
            e1.d(r7, new k(r6, r1, r7));
            return;
        L12:
            ImageView r8 = r6.g;
            if (r8 == null) goto L15;
            e1.x(r8);
            goto L15
        }

        public b(CorrectionImageView r1, Size r2, m r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            if (r2 == null) goto L7;
            View r4 = this.a.e;
            if (r4 == null) goto L8;
            e1.x(r4);
            return;
        L8:
            return;
        }
    }

    public static final class c implements ControllerListener<Object> {
        public final /* synthetic */ CorrectionImageView a;
        public final /* synthetic */ Size b;
        public final /* synthetic */ m c;
        public final /* synthetic */ n d;

        public final void onIntermediateImageFailed(String r1, Throwable r2) {
        }

        public final void onIntermediateImageSet(String r1, Object r2) {
        }

        public final void onRelease(String r1) {
        }

        public final void onSubmit(String r1, Object r2) {
        }

        /* JADX WARN: Type inference failed for: r5v1, types: [android.view.ViewGroup, com.larus.uaigc.chat.block.correction.CorrectionImageView] */
        public final void onFailure(String r5, Throwable r6) {
            ?? r7 = this.a;
            if (r7.j == false) goto L5;
            r7.post(new j(r7));
        L5:
            final CorrectionImageView r8 = this.a;
            r8.j = false;
            final FrameLayout r9 = r8.b;
            if (r9 == null) goto L20;
            Size r0 = this.b;
            final m r1 = this.c;
            final n r2 = this.d;
            SimpleDraweeView r3 = r8.a;
            if (r3 == null) goto L10;
            e1.q(r3);
        L10:
            e1.x(r9);
            if (r8.S5(r0.getHeight()) == false) goto L15;
            ImageView r4 = r8.g;
            if (r4 == null) goto L18;
            e1.o(r4);
        L18:
            e1.d(r9, new l(r8, r1, r2, r9));
            return;
        L15:
            ImageView r10 = r8.g;
            if (r10 == null) goto L18;
            e1.x(r10);
            goto L18
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [android.view.ViewGroup, com.larus.uaigc.chat.block.correction.CorrectionImageView] */
        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            ?? r4 = this.a;
            if (r4.j == false) goto L5;
            r4.post(new j(r4));
        L5:
            this.a.j = false;
        }

        public c(CorrectionImageView r1, Size r2, m r3, n r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        if (this.i != 1) goto L5;
    L6:
        ShimmerTextView r0 = this.f;
        if (r0 == null) goto L11;
        int r1 = ShimmerTextView.h;
        r0.z(false);
        return;
    L11:
        return;
    L5:
        if (this.j == true) goto L6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        ShimmerTextView r0 = this.f;
        if (r0 == null) goto L6;
        r0.x();
        return;
    }

    public CorrectionImageView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean S5(int r5) {
        if (r5 >= getContext().getResources().getDimensionPixelSize(v19.c.b(2130971522, getContext(), 2131167413))) goto L5;
        return true;
    L5:
        return false;
    }

    public final void T5(final m r12) {
        SimpleDraweeView r0 = this.a;
        if (r0 == null) goto L5;
        e1.o(r0);
    L5:
        FrameLayout r1 = this.c;
        if (r1 == null) goto L8;
        e1.o(r1);
    L8:
        ConstraintLayout r2 = this.d;
        if (r2 == null) goto L11;
        e1.x(r2);
    L11:
        ImagePlaceHolder r3 = r12.f;
        if (r3 == null) goto L46;
        Long r4 = r3.width;
        GenericDraweeView r5 = null;
        if (r4 == null) goto L16;
        Integer r6 = Integer.valueOf((int) r4.longValue());
    L17:
        Long r7 = r3.height;
        if (r7 == null) goto L20;
        Integer r8 = Integer.valueOf((int) r7.longValue());
    L21:
        final Size r9 = R5(r6, r8, r12.g);
        ConstraintLayout r10 = this.d;
        if (r10 == null) goto L25;
        r10.setLayoutParams(new ConstraintLayout.LayoutParams(r9.getWidth(), r9.getHeight()));
    L25:
        if (S5(r9.getHeight()) == false) goto L29;
        ImageView r11 = this.h;
        if (r11 == null) goto L32;
        e1.o(r11);
    L32:
        ImageObj r13 = r12.d;
        if (r13 == null) goto L42;
        String r14 = r13.url;
        MessageImageLoader r15 = MessageImageLoader.a;
        Message r16 = r12.a;
        if (r16 == null) goto L37;
        String r17 = r16.getMessageId();
    L38:
        MessageImageType r18 = MessageImageType.IMAGE;
        ConstraintLayout r19 = this.d;
        if (r19 == null) goto L41;
        r5 = (GenericDraweeView) r19.findViewById(2131377246);
    L41:
        IMessageImageLoaderService.a.a(r15, r17, r18, r5, r14, "CorrectionImageView", new g(this, r9, r12), 32);
        goto L42
    L37:
        r17 = null;
    L42:
        ShimmerTextView r110 = this.f;
        if (r110 == null) goto L47;
        int r20 = ShimmerTextView.h;
        r110.z(false);
        return;
    L47:
        return;
    L29:
        ImageView r21 = this.h;
        if (r21 == null) goto L32;
        e1.x(r21);
        goto L32
    L20:
        r8 = null;
        goto L21
    L16:
        r6 = null;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CorrectionImageView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        new Size(0, 0);
        LayoutInflater.from(getContext()).inflate(2131561985, this, true);
        this.a = findViewById(2131377243);
        this.b = (FrameLayout) findViewById(2131377249);
        this.c = (FrameLayout) findViewById(2131377242);
        this.d = findViewById(2131377244);
        this.e = findViewById(2131377247);
        ShimmerTextView r4 = findViewById(2131377248);
        if (r4 == null) goto L5;
        ShimmerTextView.y(r4, ContextCompat.getColor(r4.getContext(), 2131103298));
    L6:
        this.f = r4;
        this.g = (ImageView) findViewById(2131377250);
        this.h = (ImageView) findViewById(2131377245);
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void U5(final m r11, final n r12) {
        if (this.i != 1) goto L5;
        boolean r0 = true;
    L6:
        SimpleDraweeView r2 = this.a;
        if (r2 == null) goto L9;
        e1.x(r2);
    L9:
        FrameLayout r3 = this.c;
        if (r3 == null) goto L12;
        e1.o(r3);
    L12:
        if (r0 == false) goto L18;
        SimpleDraweeView r1 = this.a;
        if (r1 == null) goto L16;
        r1.setAlpha(0.0f);
    L16:
        this.j = true;
    L25:
        ImageObj r4 = r11.d;
        if (r4 != null) goto L28;
        return;
    L28:
        final Size r5 = R5(Integer.valueOf(r4.width), Integer.valueOf(r4.height), r11.g);
        String r6 = r4.url;
        MessageImageLoader r7 = MessageImageLoader.a;
        Message r8 = r11.a;
        if (r8 == null) goto L31;
        String r9 = r8.getMessageId();
    L32:
        IMessageImageLoaderService.a.a(r7, r9, MessageImageType.IMAGE, this.a, r6, "CorrectionImageView", new h(this, r5, r11, r12), 32);
        int r10 = r5.getWidth();
        int r13 = r5.getHeight();
        SimpleDraweeView r14 = this.a;
        if (r14 == null) goto L35;
        r14.setLayoutParams(new ConstraintLayout.LayoutParams(r10, r13));
    L35:
        SimpleDraweeView r15 = this.a;
        if (r15 == null) goto L38;
        e1.d(r15, new i(r12, this, r11));
    L38:
        SimpleDraweeView r16 = this.a;
        if (r16 == null) goto L42;
        r12.b(r16);
        return;
    L42:
        return;
    L31:
        r9 = null;
        goto L32
    L18:
        if (this.j == true) goto L25;
        ShimmerTextView r17 = this.f;
        if (r17 == null) goto L22;
        r17.x();
    L22:
        ConstraintLayout r18 = this.d;
        if (r18 == null) goto L25;
        e1.o(r18);
        goto L25
    L5:
        r0 = false;
        goto L6
    }

    public static Size R5(Integer r2, Integer r3, int r4) {
        boolean r0 = false;
        if (r2 == null) goto L17;
        if (r3 == null) goto L17;
        float r5 = r2.intValue() / r3.intValue();
        if (r5 <= 1.0f) goto L10;
        return new Size(r4, (int) (r4 / r5));
    L10:
        if (r5 != 1.0f) goto L12;
        r0 = true;
    L12:
        if (r0 == false) goto L15;
        return new Size(r4, r4);
    L15:
        return new Size((int) (r4 * r5), r4);
    L17:
        return new Size(0, 0);
    }
}

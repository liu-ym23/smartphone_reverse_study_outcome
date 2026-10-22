package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.roundlayout.CircleFrameLayout;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.uaigc.impl.databinding.LarusLayoutInstrutionImageSelectorBinding;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\u0018\u0000 L2\u00020\u0001:\u0003JKLB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010*\u001a\u00020+2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010,\u001a\u00020+2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010-\u001a\u00020\u001aJ\u000e\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020\u001dJ\u0006\u00100\u001a\u00020+J\u0018\u00101\u001a\u00020+2\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0014J\u0010\u00104\u001a\u00020+2\u0006\u0010/\u001a\u000205H\u0002J\u0010\u00106\u001a\u00020+2\u0006\u0010/\u001a\u000207H\u0002J\u0010\u00108\u001a\u00020+2\u0006\u0010/\u001a\u000209H\u0002J\u0010\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u0007H\u0002J\u0018\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0002J\u0010\u0010?\u001a\u00020+2\u0006\u0010/\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u00020+2\u0006\u0010'\u001a\u00020\u001aH\u0002J\b\u0010B\u001a\u00020\u001aH\u0002J:\u0010C\u001a\u00020+2\b\u0010D\u001a\u0004\u0018\u00010#2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00072\u0016\b\u0002\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010FH\u0002J\u0018\u0010G\u001a\u00020H2\u0006\u0010;\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R$\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\"\u001a\u0004\u0018\u00010#8F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006M"}, d2 = {"Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/ImageSelectorView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusLayoutInstrutionImageSelectorBinding;", "config", "Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/ImageSelectorView$Config;", "screenWidth", "getScreenWidth", "()I", "screenWidth$delegate", "Lkotlin/Lazy;", "lastHeight", "lastWidth", "prevMaxWidth", "prevMaxHeight", "lastAdjustTime", "", "enableShowReselectLayout", "", "_curState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/imageselector/UIState;", "curState", "Lkotlinx/coroutines/flow/StateFlow;", "getCurState", "()Lkotlinx/coroutines/flow/StateFlow;", "value", "Landroid/graphics/Bitmap;", "curBitmap", "getCurBitmap", "()Landroid/graphics/Bitmap;", "showFull", "getShowFull", "()Z", "initConfig", "", "setEnableShowReselectIcon", "isEnableShowReselectIcon", "refreshUIState", "state", "clearImageForDestroy", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "showFilled", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/imageselector/UIState$Filled;", "showFailed", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/imageselector/UIState$Failed;", "showUploading", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/imageselector/UIState$Uploading;", "getMaxWidth", "width", "adjustEmptyContainerSize", "maxWidth", "maxHeight", "showEmpty", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/imageselector/UIState$Empty;", "adjustSize", "adjustTimeCheck", "adjustImageViewSize", "bitmap", "size", "Lkotlin/Pair;", "getDisplayRatio", "", "height", "Config", "ActionListener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ImageSelectorView extends ConstraintLayout {
    public static final /* synthetic */ int l = 0;
    public final LarusLayoutInstrutionImageSelectorBinding a;
    public c b;
    public final Lazy c;
    public int d;
    public int e;
    public int f;
    public int g;
    public long h;
    public boolean i;
    public final StateFlowImpl j;
    public final kotlinx.coroutines.flow.b1 k;

    public interface a {
        void a();

        void b();

        void c(boolean r1);
    }

    public static final class b {
    }

    public static final class c {
        public static final /* synthetic */ int e = 0;
        public final String a;
        public final String b;
        public final int c;
        public final a d;

        public static final class a {
            public static c a(Context r4) {
                Intrinsics.checkNotNullParameter(r4, "context");
                return new c("", r4.getString(2131908727), c7.b(144), null);
            }
        }

        static {
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31;
            a r1 = this.d;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "Config(emptyIconUrl=" + this.a + ", emptyDisplayText=" + this.b + ", extraHorizontalPaddingWhenImeShow=" + this.c + ", listener=" + this.d + ')';
        }

        public c(String r2, String r3, int r4, p0 r5) {
            Intrinsics.checkNotNullParameter(r2, "emptyIconUrl");
            Intrinsics.checkNotNullParameter(r3, "emptyDisplayText");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
    }

    public ImageSelectorView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ImageSelectorView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final int getScreenWidth() {
        return ((Number) this.c.getValue()).intValue();
    }

    private final boolean getShowFull() {
        sy9.b r0 = (sy9.b) this.k.getValue();
        Boolean r2 = null;
        if ((r0 instanceof sy9.b.C0075b) == false) goto L11;
        Object r1 = this.k.getValue();
        if ((r1 instanceof sy9.b.C0075b) == false) goto L7;
        sy9.b.C0075b r3 = (sy9.b.C0075b) r1;
    L8:
        if (r3 == null) goto L27;
        r2 = Boolean.valueOf(r3.b);
    L27:
        if (r2 != null) goto L31;
        return true;
    L31:
        return r2.booleanValue();
    L7:
        r3 = null;
        goto L8
    L11:
        if ((r0 instanceof sy9.b.c) == false) goto L19;
        Object r4 = this.k.getValue();
        if ((r4 instanceof sy9.b.c) == false) goto L15;
        sy9.b.c r5 = (sy9.b.c) r4;
    L16:
        if (r5 == null) goto L27;
        r2 = Boolean.valueOf(r5.b);
        goto L27
    L15:
        r5 = null;
        goto L16
    L19:
        if ((r0 instanceof sy9.b.e) == false) goto L26;
        Object r6 = this.k.getValue();
        if ((r6 instanceof sy9.b.e) == false) goto L23;
        sy9.b.e r7 = (sy9.b.e) r6;
    L24:
        if (r7 == null) goto L27;
        r2 = Boolean.valueOf(r7.b);
        goto L27
    L23:
        r7 = null;
        goto L24
    L26:
        r2 = Boolean.TRUE;
        goto L27
    }

    public final Bitmap getCurBitmap() {
        sy9.b r0 = (sy9.b) this.k.getValue();
        if ((r0 instanceof sy9.b.C0075b) == false) goto L11;
        Object r1 = this.k.getValue();
        if ((r1 instanceof sy9.b.C0075b) == false) goto L7;
        sy9.b.C0075b r2 = (sy9.b.C0075b) r1;
    L8:
        if (r2 != null) goto L28;
        return null;
    L28:
        return r2.a;
    L7:
        r2 = null;
        goto L8
    L11:
        if ((r0 instanceof sy9.b.c) == false) goto L19;
        Object r3 = this.k.getValue();
        if ((r3 instanceof sy9.b.c) == false) goto L15;
        sy9.b.c r4 = (sy9.b.c) r3;
    L16:
        if (r4 != null) goto L30;
        return null;
    L30:
        return r4.a;
    L15:
        r4 = null;
        goto L16
    L19:
        if ((r0 instanceof sy9.b.e) == false) goto L31;
        Object r5 = this.k.getValue();
        if ((r5 instanceof sy9.b.e) == false) goto L23;
        sy9.b.e r6 = (sy9.b.e) r5;
    L24:
        if (r6 != null) goto L26;
        return null;
    L26:
        return r6.a;
    L23:
        r6 = null;
        goto L24
    L31:
        return null;
    }

    public final kotlinx.coroutines.flow.i1<sy9.b> getCurState() {
        return this.k;
    }

    public final void S5(boolean r5) {
        if (r5 == false) goto L25;
        FrameLayout r6 = this.a.f;
        ViewGroup.LayoutParams r2 = r6.getLayoutParams();
        if (r2 == null) goto L24;
        int r3 = c7.b(40);
        r2.width = r3;
        r2.height = r3;
        r6.setLayoutParams(r2);
        CircleFrameLayout r7 = this.a.e;
        ViewGroup.LayoutParams r4 = r7.getLayoutParams();
        if (r4 == null) goto L22;
        int r0 = c7.b(28);
        r4.width = r0;
        r4.height = r0;
        r7.setLayoutParams(r4);
        ImageView r8 = this.a.g;
        ViewGroup.LayoutParams r1 = r8.getLayoutParams();
        if (r1 == null) goto L20;
        int r9 = c7.b(16);
        r1.width = r9;
        r1.height = r9;
        r8.setLayoutParams(r1);
        SimpleDraweeView r10 = this.a.b;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L18;
        int r12 = c7.b(32);
        r11.width = r12;
        r11.height = r12;
        r10.setLayoutParams(r11);
        ProgressBar r13 = this.a.k;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L16;
        int r15 = c7.b(32);
        r14.width = r15;
        r14.height = r15;
        r13.setLayoutParams(r14);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L22:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L25:
        FrameLayout r16 = this.a.f;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if (r17 == null) goto L46;
        int r18 = c7.b(36);
        r17.width = r18;
        r17.height = r18;
        r16.setLayoutParams(r17);
        CircleFrameLayout r19 = this.a.e;
        ViewGroup.LayoutParams r20 = r19.getLayoutParams();
        if (r20 == null) goto L44;
        int r21 = c7.b(24);
        r20.width = r21;
        r20.height = r21;
        r19.setLayoutParams(r20);
        ImageView r22 = this.a.g;
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
        if (r23 == null) goto L42;
        int r24 = c7.b(14);
        r23.width = r24;
        r23.height = r24;
        r22.setLayoutParams(r23);
        SimpleDraweeView r25 = this.a.b;
        ViewGroup.LayoutParams r26 = r25.getLayoutParams();
        if (r26 == null) goto L40;
        int r27 = c7.b(28);
        r26.width = r27;
        r26.height = r27;
        r25.setLayoutParams(r26);
        ProgressBar r28 = this.a.k;
        ViewGroup.LayoutParams r29 = r28.getLayoutParams();
        if (r29 == null) goto L38;
        int r30 = c7.b(28);
        r29.width = r30;
        r29.height = r30;
        r28.setLayoutParams(r29);
        return;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L40:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L42:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L44:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L46:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final int U5(int r6) {
        if (getShowFull() == true) goto L30;
        Bitmap r0 = getCurBitmap();
        sy9.b.e r2 = null;
        if (r0 == null) goto L7;
        int r1 = r0.getWidth();
    L16:
        Bitmap r3 = getCurBitmap();
        if (r3 == null) goto L19;
        int r4 = r3.getHeight();
    L27:
        if (r1 > r4) goto L29;
        return r6;
    L29:
        return RangesKt.coerceAtMost(r6, RangesKt.coerceAtLeast(0, getScreenWidth() - this.b.c));
    L19:
        Object r5 = this.k.getValue();
        if ((r5 instanceof sy9.b.e) == false) goto L22;
        r2 = (sy9.b.e) r5;
    L22:
        if (r2 == null) goto L26;
        Pair<Integer, Integer> r7 = r2.c;
        if (r7 == null) goto L26;
        r4 = ((Number) r7.getSecond()).intValue();
    L26:
        r4 = 0;
        goto L27
    L7:
        Object r8 = this.k.getValue();
        if ((r8 instanceof sy9.b.e) == false) goto L10;
        sy9.b.e r9 = (sy9.b.e) r8;
    L11:
        if (r9 == null) goto L15;
        Pair<Integer, Integer> r10 = r9.c;
        if (r10 == null) goto L15;
        r1 = ((Number) r10.getFirst()).intValue();
    L15:
        r1 = 0;
        goto L16
    L10:
        r9 = null;
        goto L11
    L30:
        return r6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V5(sy9.b r11) {
        Intrinsics.checkNotNullParameter(r11, "state");
        if (Intrinsics.areEqual(this.k.getValue(), r11) == false) goto L5;
        return;
    L5:
        this.j.setValue(r11);
        int r1 = 0;
        Drawable r2 = null;
        int r3 = 8;
        boolean r4 = true;
        if ((r11 instanceof sy9.b.a) == false) goto L21;
        sy9.b.a r12 = (sy9.b.a) r11;
        com.larus.utils.e1.x(this.a.h);
        this.a.i.setImageDrawable(null);
        this.a.i.setClickable(false);
        R5(null, (getWidth() - getPaddingStart()) - getPaddingEnd(), (getHeight() - getPaddingTop()) - getPaddingBottom(), null);
        com.larus.utils.e1.q(this.a.i);
        ImageView r0 = this.a.i;
        ViewGroup.LayoutParams r5 = r0.getLayoutParams();
        if (r5 == null) goto L19;
        r5.height = -1;
        r5.width = -1;
        r0.setLayoutParams(r5);
        com.larus.utils.e1.x(this.a.j);
        this.a.j.setClickable(false);
        this.a.j.setBackground(null);
        com.larus.utils.e1.o(this.a.k);
        com.larus.utils.e1.x(this.a.c);
        this.a.b.setImageDrawable(null);
        if ((!StringsKt.isBlank(this.b.a)) == false) goto L12;
        ImageLoaderKt.u(this.a.b, this.b.a, "instruction_image_selector_icon");
    L13:
        this.a.d.setText(this.b.b);
        this.a.d.setTextColor(ContextCompat.getColor(getContext(), v19.c.b(2130972123, getContext(), 2131103203)));
        TextView r6 = this.a.d;
        if (r12.a == true) goto L17;
        r1 = 8;
    L17:
        r6.setVisibility(r1);
        com.larus.utils.e1.o(this.a.f);
        S5(r12.a);
        return;
    L12:
        this.a.b.setImageResource(2131241449);
        goto L13
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L21:
        if ((r11 instanceof sy9.b.C0075b) == false) goto L31;
        sy9.b.C0075b r13 = (sy9.b.C0075b) r11;
        com.larus.utils.e1.x(this.a.i);
        this.a.i.setImageBitmap(r13.a);
        this.a.i.setClickable(false);
        R5(r13.a, U5((getWidth() - getPaddingStart()) - getPaddingEnd()), (getHeight() - getPaddingTop()) - getPaddingBottom(), null);
        this.a.j.setBackgroundColor(ColorProtector.parseColor("#80000000"));
        com.larus.utils.e1.q(this.a.h);
        com.larus.utils.e1.x(this.a.j);
        this.a.j.setClickable(true);
        com.larus.utils.e1.o(this.a.k);
        com.larus.utils.e1.x(this.a.c);
        SimpleDraweeView r7 = this.a.b;
        Drawable r8 = ContextCompat.getDrawable(getContext(), v19.c.b(2130972005, getContext(), 2131242849));
        if (r8 == null) goto L25;
        r8.setTint(ContextCompat.getColor(getContext(), 2131103298));
        r2 = r8;
    L25:
        r7.setImageDrawable(r2);
        this.a.d.setText(getContext().getString(2131899639));
        this.a.d.setTextColor(ContextCompat.getColor(getContext(), 2131103298));
        TextView r9 = this.a.d;
        if (r13.b == true) goto L29;
        r1 = 8;
    L29:
        r9.setVisibility(r1);
        com.larus.utils.e1.x(this.a.f);
        S5(r13.b);
        return;
    L31:
        if ((r11 instanceof sy9.b.c) == false) goto L48;
        sy9.b.c r14 = (sy9.b.c) r11;
        com.larus.utils.e1.x(this.a.i);
        this.a.i.setImageBitmap(r14.a);
        R5(r14.a, U5((getWidth() - getPaddingStart()) - getPaddingEnd()), (getHeight() - getPaddingTop()) - getPaddingBottom(), null);
        this.a.j.setClickable(false);
        this.a.i.setClickable(true);
        com.larus.utils.e1.q(this.a.h);
        com.larus.utils.e1.o(this.a.j);
        com.larus.utils.e1.x(this.a.f);
        if (this.i == false) goto L45;
        com.larus.utils.e1.x(this.a.j);
        this.a.j.setBackgroundColor(ContextCompat.getColor(getContext(), 2131103293));
        com.larus.utils.e1.x(this.a.c);
        SimpleDraweeView r10 = this.a.b;
        Drawable r15 = ContextCompat.getDrawable(getContext(), 2131238498);
        if (r15 == null) goto L37;
        r15.setTint(ContextCompat.getColor(getContext(), 2131103298));
        r2 = r15;
    L37:
        r10.setImageDrawable(r2);
        if (r14.b == false) goto L40;
        this.a.d.setText(getContext().getString(2131910629));
        this.a.d.setTextColor(ContextCompat.getColor(getContext(), 2131103298));
    L40:
        TextView r16 = this.a.d;
        if (r14.b == true) goto L44;
        r1 = 8;
    L44:
        r16.setVisibility(r1);
    L46:
        S5(r14.b);
        return;
    L45:
        com.larus.utils.e1.o(this.a.c);
        goto L46
    L48:
        if ((r11 instanceof sy9.b.e) == false) goto L68;
        sy9.b.e r17 = (sy9.b.e) r11;
        com.larus.utils.e1.x(this.a.i);
        this.a.i.setImageBitmap(r17.a);
        this.a.i.setClickable(false);
        R5(r17.a, U5((getWidth() - getPaddingStart()) - getPaddingEnd()), (getHeight() - getPaddingTop()) - getPaddingBottom(), r17.c);
        com.larus.utils.e1.q(this.a.h);
        boolean r18 = r17.d;
        ConstraintLayout r19 = this.a.j;
        if (r18 == false) goto L52;
    L56:
        r4 = false;
    L57:
        if (r4 == false) goto L59;
        r3 = 0;
    L59:
        r19.setVisibility(r3);
        this.a.j.setClickable(false);
        this.a.j.setBackgroundColor(ColorProtector.parseColor("#80000000"));
        if (r18 == false) goto L62;
        com.larus.utils.e1.o(this.a.k);
    L63:
        com.larus.utils.e1.o(this.a.c);
        com.larus.utils.e1.x(this.a.f);
        S5(r17.b);
        return;
    L62:
        com.larus.utils.e1.x(this.a.k);
        goto L63
    L52:
        if (r17.a == null) goto L57;
        com.larus.uaigc.helper.f.a.getClass();
        if (Intrinsics.areEqual(com.larus.uaigc.helper.f.c().d(), Boolean.TRUE) == true) goto L56;
    }

    public final void setEnableShowReselectIcon(boolean r1) {
        this.i = r1;
    }

    public static double T5(int r3, int r4) {
        double r0 = ((double) r3) / ((double) r4);
        if (r0 >= 1.0d) goto L6;
        return RangesKt.coerceAtLeast(r0, 0.3333333333333333d);
    L6:
        return RangesKt.coerceAtMost(r0, 3.0d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r7, int r8) {
        Bitmap r0 = getCurBitmap();
        int r1 = U5((View.MeasureSpec.getSize(r7) - getPaddingStart()) - getPaddingEnd());
        int r2 = (View.MeasureSpec.getSize(r8) - getPaddingTop()) - getPaddingBottom();
        Object r3 = this.k.getValue();
        Pair<Integer, Integer> r5 = null;
        if ((r3 instanceof sy9.b.e) == false) goto L5;
        sy9.b.e r4 = (sy9.b.e) r3;
    L6:
        if (r4 == null) goto L8;
        r5 = r4.c;
    L8:
        R5(r0, r1, r2, r5);
        super.onMeasure(r7, r8);
        return;
    L5:
        r4 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImageSelectorView(final Context r19, AttributeSet r20, int r21) {
        Intrinsics.checkNotNullParameter(r19, "context");
        super(r19, r20, r21);
        LayoutInflater.from(r19).inflate(2131562840, this);
        int r0 = 2131365416;
        SimpleDraweeView r2 = ViewBindings.findChildViewById(this, 2131365416);
        if (r2 == null) goto L25;
        r0 = 2131365419;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(this, 2131365419);
        if (r3 == null) goto L25;
        r0 = 2131365424;
        TextView r4 = (TextView) ViewBindings.findChildViewById(this, 2131365424);
        if (r4 == null) goto L25;
        r0 = 2131368783;
        CircleFrameLayout r5 = ViewBindings.findChildViewById(this, 2131368783);
        if (r5 == null) goto L25;
        r0 = 2131368785;
        FrameLayout r14 = (FrameLayout) ViewBindings.findChildViewById(this, 2131368785);
        if (r14 == null) goto L25;
        r0 = 2131368790;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(this, 2131368790);
        if (r7 == null) goto L25;
        r0 = 2131371571;
        View r15 = ViewBindings.findChildViewById(this, 2131371571);
        if (r15 == null) goto L25;
        r0 = 2131374931;
        ImageView r11 = (ImageView) ViewBindings.findChildViewById(this, 2131374931);
        if (r11 == null) goto L25;
        r0 = 2131377402;
        ConstraintLayout r10 = ViewBindings.findChildViewById(this, 2131377402);
        if (r10 == null) goto L25;
        r0 = 2131378977;
        ProgressBar r16 = (ProgressBar) ViewBindings.findChildViewById(this, 2131378977);
        if (r16 == null) goto L25;
        this.a = new LarusLayoutInstrutionImageSelectorBinding(this, r2, r3, r4, r5, r14, r7, r15, r11, r10, r16);
        int r1 = c.e;
        this.b = c.a.a(r19);
        this.c = LazyKt.lazy(LazyThreadSafetyMode.NONE, new f1(r19));
        this.d = Integer.MAX_VALUE;
        this.e = getScreenWidth();
        StateFlowImpl r6 = kotlinx.coroutines.flow.j1.a(sy9.b.d.a);
        this.j = r6;
        this.k = kotlinx.coroutines.flow.e.b(r6);
        com.larus.utils.w0.e(r11, c7.b(8));
        com.larus.utils.w0.e(r15, c7.b(8));
        com.larus.utils.w0.e(r10, c7.b(8));
        com.larus.utils.e1.d(r15, new g1(this));
        com.larus.utils.e1.d(r11, new h1(this));
        com.larus.utils.e1.d(r10, new i1(this));
        com.larus.utils.e1.d(r14, new j1(this));
        return;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r0)));
    }

    public /* synthetic */ ImageSelectorView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void R5(Bitmap r17, int r18, int r19, Pair<Integer, Integer> r20) {
        int r1 = r18;
        int r2 = r19;
        if (r1 <= 0) goto L76;
        if (r2 > 0) goto L6;
        return;
    L6:
        if (this.f == r1) goto L8;
    L10:
        this.f = r1;
        this.g = r2;
        boolean r4 = true;
        if (getShowFull() == true) goto L20;
        long r8 = System.currentTimeMillis();
        if ((r8 - this.h) <= 100) goto L15;
        boolean r3 = true;
    L16:
        this.h = r8;
        if (r3 == true) goto L20;
        r2 = RangesKt.coerceAtMost(r2, this.d);
        this.d = r2;
    L22:
        if (getShowFull() == true) goto L31;
        long r9 = System.currentTimeMillis();
        if ((r9 - this.h) > 100) goto L27;
        r4 = false;
    L27:
        this.h = r9;
        if (r4 == true) goto L31;
        r1 = RangesKt.coerceAtMost(r1, this.e);
        this.e = r1;
    L32:
        View r5 = this.a.h;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L75;
        r6.height = r2;
        double r10 = r2;
        double r12 = r10 * 0.75d;
        double r14 = r1;
        if (r12 <= r14) goto L37;
        r6.width = r1;
        r6.height = (int) (r14 / 0.75d);
    L38:
        r5.setLayoutParams(r6);
        if (r17 == null) goto L41;
        int r7 = r17.getWidth();
    L44:
        if (r17 == null) goto L46;
        int r11 = r17.getHeight();
    L49:
        if (r17 != null) goto L57;
        if (r20 != null) goto L57;
        ImageView r13 = this.a.i;
        ViewGroup.LayoutParams r15 = r13.getLayoutParams();
        if (r15 == null) goto L55;
        r15.height = 0;
        r15.width = 0;
        r13.setLayoutParams(r15);
        ConstraintSet r16 = new ConstraintSet();
        r16.clone(this);
        r16.connect(2131374931, 3, 2131371571, 3);
        r16.connect(2131374931, 4, 2131371571, 4);
        r16.connect(2131374931, 6, 2131371571, 6);
        r16.connect(2131374931, 7, 2131371571, 7);
        r16.applyTo(this);
        return;
    L55:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L57:
        if (r7 > r11) goto L59;
    L60:
        if (r7 <= r11) goto L62;
    L68:
        ImageView r21 = this.a.i;
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
        if (r22 == null) goto L73;
        r22.height = r2;
        r22.width = RangesKt.coerceAtLeast((int) (r10 * T5(r7, r11)), c7.b(40));
        r21.setLayoutParams(r22);
        return;
    L73:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L62:
        if ((T5(r7, r11) * r10) <= r14) goto L68;
    L63:
        ImageView r23 = this.a.i;
        ViewGroup.LayoutParams r24 = r23.getLayoutParams();
        if (r24 == null) goto L67;
        r24.width = r1;
        r24.height = RangesKt.coerceAtLeast((int) (r14 / T5(r7, r11)), c7.b(40));
        r23.setLayoutParams(r24);
        return;
    L67:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L59:
        if ((r14 / T5(r7, r11)) <= r10) goto L63;
    L46:
        if (r20 == null) goto L48;
        r11 = ((Number) r20.getSecond()).intValue();
        goto L49
    L48:
        r11 = 0;
        goto L49
    L41:
        if (r20 == null) goto L43;
        r7 = ((Number) r20.getFirst()).intValue();
        goto L44
    L43:
        r7 = 0;
        goto L44
    L37:
        r6.width = (int) r12;
        goto L38
    L75:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L31:
        this.e = r1;
        goto L32
    L15:
        r3 = false;
    L20:
        this.d = r2;
        goto L22
    L8:
        if (this.g != r2) goto L10;
        return;
    }
}

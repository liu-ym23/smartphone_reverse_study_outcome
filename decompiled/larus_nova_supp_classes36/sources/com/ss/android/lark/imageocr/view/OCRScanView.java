package com.ss.android.lark.imageocr.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.imagewidget.ImageWidgetFG;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 $2\u00020\u0001:\u0002$%B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\u0018\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\nH\u0014J\b\u0010\"\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020\u001dH\u0002R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0019\u0010\u001a¨\u0006&"}, d2 = {"Lcom/ss/android/lark/imageocr/view/OCRScanView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "scanLine", "Landroid/widget/ImageView;", "getScanLine", "()Landroid/widget/ImageView;", "scanLine$delegate", "Lkotlin/Lazy;", "animHandler", "Landroid/os/Handler;", "getAnimHandler", "()Landroid/os/Handler;", "animHandler$delegate", "animRunnable", "Lcom/ss/android/lark/imageocr/view/OCRScanView$AnimRunnable;", "getAnimRunnable", "()Lcom/ss/android/lark/imageocr/view/OCRScanView$AnimRunnable;", "animRunnable$delegate", "start", "", "cancel", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "startScanAnim", "updateTranslationY", "Companion", "AnimRunnable", "imageocr_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class OCRScanView extends FrameLayout {
    public static final /* synthetic */ int d = 0;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;

    public static final class a implements Runnable {
        public final View a;
        public final Function0<Unit> b;
        public final float c;
        public float d;
        public int e;

        @Override // java.lang.Runnable
        public final void run() {
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        L3:
            if (ImageWidgetFG.a() == false) goto L5;
            float r0 = this.d;     // Catch: Throwable -> L8
        L6:
            this.a.setTranslationY(r0 * this.e);     // Catch: Throwable -> L8
            this.b.invoke();     // Catch: Throwable -> L8
            return;
        L5:
            r0 = this.c;     // Catch: Throwable -> L8
            goto L6
        }

        public a(View r3, Function0<Unit> r4) {
            Intrinsics.checkNotNullParameter(r3, "scanLine");
            Intrinsics.checkNotNullParameter(r4, "next");
            this.a = r3;
            this.b = r4;
            this.c = (UIUtils.getScreenHeight(LarkContext.getApplication()) - r3.getHeight()) / 100;
            this.e = 1;
        }
    }

    public static final class b {
    }

    static {
    }

    private final Handler getAnimHandler() {
        return (Handler) this.b.getValue();
    }

    private final a getAnimRunnable() {
        return (a) this.c.getValue();
    }

    private final ImageView getScanLine() {
        return (ImageView) this.a.getValue();
    }

    public final void b() {
        Log.i("OCRScanView", "cancel");
        setVisibility(8);
        getAnimHandler().removeCallbacksAndMessages(null);
        getScanLine().setTranslationY(0.0f);
    }

    public final void c() {
        getAnimHandler().removeCallbacksAndMessages(null);
        if (getAnimRunnable().e >= 100) goto L5;
        getAnimRunnable().e++;
    L6:
        getAnimHandler().postDelayed(getAnimRunnable(), 20);
        return;
    L5:
        getAnimRunnable().e = 1;
        goto L6
    }

    public OCRScanView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static final /* synthetic */ ImageView a(OCRScanView r0) {
        return r0.getScanLine();
    }

    public OCRScanView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r4, int r5) {
        super.onMeasure(r4, r5);
        a r6 = getAnimRunnable();
        int r7 = getMeasuredHeight();
        r6.d = (r7 - r6.a.getHeight()) / 100;
        Log.i("OCRScanView", "setMaxHeight, maxHeight: " + r7 + ", stepYCompat: " + r6.d);
    }

    public OCRScanView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new OCRScanView$scanLine$2(this));
        this.b = LazyKt.lazy(OCRScanView$animHandler$2.INSTANCE);
        this.c = LazyKt.lazy(new OCRScanView$animRunnable$2(this));
        setVisibility(8);
        setClickable(true);
    }
}

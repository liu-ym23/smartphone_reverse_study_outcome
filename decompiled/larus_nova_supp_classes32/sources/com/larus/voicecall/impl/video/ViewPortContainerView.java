package com.larus.voicecall.impl.video;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewKt;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 62\u00020\u0001:\u00016B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0013H\u0014J \u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0082@¢\u0006\u0002\u0010#J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0017J\u0016\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020%J\u0016\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020!J\u0010\u00101\u001a\u00020\u00132\b\u00102\u001a\u0004\u0018\u000103J\u0006\u00104\u001a\u00020\u0013J\u0006\u00105\u001a\u00020\u0013R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/larus/voicecall/impl/video/ViewPortContainerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgView", "Landroid/view/View;", "contentContainer", "Landroid/view/ViewGroup;", "maskView", "dragDelegate", "Lcom/larus/voicecall/impl/video/DragFloatingEffect;", "updateLimitCallBack", "Lkotlin/Function0;", NameKeys.UnloadStrategy_No_Strategy, "getUpdateLimitCallBack", "()Lkotlin/jvm/functions/Function0;", "setUpdateLimitCallBack", "(Lkotlin/jvm/functions/Function0;)V", "onScreenChangeTask", "Ljava/lang/Runnable;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDetachedFromWindow", "getContentBitmap", "Landroid/graphics/Bitmap;", "bitmapWidth", NameKeys.UnloadStrategy_No_Strategy, "bitmapHeight", "(FFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onTouchEvent", NameKeys.UnloadStrategy_No_Strategy, "event", "Landroid/view/MotionEvent;", "addContentView", "view", LynxResourceModule.PARAMS_KEY, "Landroid/widget/FrameLayout$LayoutParams;", "enableDrag", "enable", "setDragLimit", "topLimit", "bottomLimit", "setDragListener", "listener", "Lcom/larus/voicecall/impl/video/DragFloatingListener;", "showBg", "hideBg", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ViewPortContainerView extends FrameLayout {
    public static final /* synthetic */ int g = 0;
    public final View a;
    public final ViewGroup b;
    public final View c;
    public final e d;
    public Function0<Unit> e;
    public final u f;

    public static final class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r10, Outline r11) {
            Intrinsics.checkNotNullParameter(r10, "view");
            Intrinsics.checkNotNullParameter(r11, "outline");
            FLogger.a.d("ViewPortContainerView", "width: " + r10.getWidth() + ", height: " + r10.getHeight());
            r11.setRoundRect(0, 0, r10.getWidth(), r10.getHeight(), ((float) i5.r0()) / r10.getScaleX());
        }
    }

    public static final class b {
    }

    static {
    }

    public ViewPortContainerView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ViewPortContainerView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f);
    }

    public final Function0<Unit> getUpdateLimitCallBack() {
        return this.e;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
        boolean r0 = false;
        if (r5 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L14;
        if (r5 != null) goto L11;
    L13:
        if (r0 == true) goto L14;
        return;
    L11:
        if (r5.orientation != 1) goto L13;
        r0 = true;
    L14:
        postDelayed(this.f, 100);
        return;
    L5:
        if (r5.orientation != 2) goto L7;
        r2 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.voicecall.impl.video.d, java.lang.Runnable] */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r17) {
        if (r17 != null) goto L5;
        return false;
    L5:
        final e r3 = this.d;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r17, "event");
        if (r3.j == false) goto L8;
        float r4 = r17.getRawX();
        float r6 = r17.getRawY();
        int r0 = r17.getAction();
        if (r0 != 0) goto L15;
        r3.d = r4;
        r3.e = r6;
        r3.l = r4;
        r3.m = r6;
        ?? r1 = new d(r3);
        r3.h = r1;
        r3.a.postDelayed(r1, 500);
    L66:
        return true;
    L15:
        if (r0 != 1) goto L17;
        r3.a.removeCallbacks(r3.h);
        if (r3.i == false) goto L59;
        r3.b(true);
        boolean r2 = false;
    L64:
        r3.i = r2;
        r3.h = null;
        goto L66
    L59:
        if (r3.k == false) goto L61;
        r2 = false;
        r3.b(false);
        goto L64
    L61:
        r2 = false;
        f r5 = r3.f;
        if (r5 == null) goto L64;
        r5.onClick();
        goto L64
    L17:
        if (r0 == 2) goto L26;
        if (r0 != 3) goto L66;
        if (r3.i == false) goto L24;
        r3.b(true);
    L24:
        r3.i = false;
        r3.h = null;
        goto L66
    L26:
        if (r3.i == false) goto L48;
        float r7 = r4 - r3.d;
        float r8 = r6 - r3.e;
        float r9 = r3.a.getX();
        float r10 = r3.a.getY();
        float r11 = r9 + r7;
        float r12 = r10 + r8;
        float r13 = Math.max(r3.o, Math.min(r12, r3.p - (r3.a.getHeight() * r3.a.getScaleY())));
        r3.a.setX(r11);
        r3.a.setY(r13);
        FLogger.a.d("DragFloatingEffect", "updateViewLocation() called with: dx = " + r7 + ", dy = " + r8 + ", oldX = " + r9 + ", oldY = " + r10 + ", newX = " + r11 + ", newY = " + r12 + ", width: " + r3.a.getWidth() + ", height = " + r3.a.getHeight() + ", scaleX: " + r3.a.getScaleX() + ", scaleY: " + r3.a.getScaleY() + ", transX: " + r3.a.getTranslationX() + ", transY: " + r3.a.getTranslationY() + ", limitY = " + r13);
        float r14 = r3.a.getX() + ((((float) r3.a.getWidth()) * r3.a.getScaleX()) / ((float) 2));
        if (r14 > 0.0f) goto L30;
    L33:
        boolean r15 = true;
    L34:
        if (r15 == false) goto L42;
        if (r3.k == true) goto L47;
        r3.k = true;
        g r16 = r3.g;
        if (r16 == null) goto L47;
        r16.a();
    L47:
        r3.d = r4;
        r3.e = r6;
        goto L66
    L42:
        if (r3.k == false) goto L47;
        r3.k = false;
        g r18 = r3.g;
        if (r18 == null) goto L47;
        r18.b();
        goto L47
    L30:
        if (r14 >= r3.a()) goto L33;
        r15 = false;
        goto L34
    L48:
        float r19 = r3.l;
        float r20 = r3.m;
        if (Math.abs(r4 - r19) <= r3.n) goto L51;
    L52:
        r3.a.removeCallbacks(r3.h);
        d r21 = r3.h;
        if (r21 == null) goto L66;
        r21.run();
        goto L66
    L51:
        if (Math.abs(r6 - r20) <= r3.n) goto L66;
    L8:
        if (r17.getAction() != 1) goto L66;
        f r22 = r3.f;
        if (r22 == null) goto L66;
        r22.onClick();
        goto L66
    }

    public final void setDragListener(f r2) {
        this.d.f = r2;
    }

    public final void setUpdateLimitCallBack(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [com.larus.voicecall.impl.video.u] */
    public ViewPortContainerView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        e r5 = new e(this);
        this.d = r5;
        this.e = new t();
        this.f = new u(this);
        View r6 = LayoutInflater.from(r2).inflate(2131562879, this);
        this.a = r6.findViewById(2131392445);
        this.b = (ViewGroup) r6.findViewById(2131392446);
        this.c = r6.findViewById(2131392447);
        setBackgroundColor(ContextCompat.getColor(r2, R.color.transparent));
        setClipToOutline(true);
        setOutlineProvider(new a());
        r5.g = new AnonymousClass3(this, r2);
    }

    public /* synthetic */ ViewPortContainerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static final Object a(ViewPortContainerView r5, float r6, float r7, Continuation r8) {
        r5.getClass();
        if ((r8 instanceof ViewPortContainerView$getContentBitmap$1) == false) goto L7;
        ViewPortContainerView$getContentBitmap$1 r0 = (ViewPortContainerView$getContentBitmap$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L36:
        return (Bitmap) r9;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        if (r5.b.getChildCount() <= 0) goto L17;
        View r10 = r5.b.getChildAt(0);
    L19:
        if ((r10 instanceof TextureView) == false) goto L22;
        return ((TextureView) r10).getBitmap((int) r6, (int) r7);
    L22:
        if ((r10 instanceof SurfaceView) == false) goto L31;
        SurfaceHolder r11 = ((SurfaceView) r10).getHolder();
        final Bitmap r12 = Bitmap.createBitmap((int) r6, (int) r7, Bitmap.Config.ARGB_8888);
        Surface r13 = r11.getSurface();
        final CompletableDeferred r14 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        if (Build.VERSION.SDK_INT < 24) goto L26;
        PixelCopy.request(r13, r12, new s(r14, r12), new Handler(Looper.getMainLooper()));
    L27:
        r0.label = 1;
        r9 = r14.await(r0);
        if (r9 != r2) goto L36;
        return r2;
    L26:
        Boxing.boxBoolean(r14.complete(null));
        goto L27
    L31:
        if (r10 == null) goto L34;
        Bitmap r15 = ViewKt.drawToBitmap$default(r10, null, 1, null);
        Bitmap r16 = Bitmap.createScaledBitmap(r15, (int) r6, (int) r7, true);
        r15.recycle();
        return r16;
    L34:
        return null;
    L17:
        r10 = null;
    L7:
        r0 = new ViewPortContainerView$getContentBitmap$1(r5, r8);
        goto L8
    }
}

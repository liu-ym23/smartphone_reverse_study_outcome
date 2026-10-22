package com.ss.android.lark.image.compose.android_platform;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.compose.common.CachePolicy;
import com.ss.android.lark.image.compose.common.avatar.c;
import com.ss.android.lark.image.compose.common.avatar.d;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002BG\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010=\u001a\u00020>2\u0006\u0010\u0019\u001a\u00020\u0018H\u0014J\u0012\u0010?\u001a\u00020>2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0014J\f\u0010@\u001a\u00020A*\u00020BH\u0014J\b\u0010C\u001a\u00020AH\u0016J\b\u0010D\u001a\u00020AH\u0016J\b\u0010E\u001a\u00020AH\u0016J\u000e\u0010F\u001a\u00020A2\u0006\u00100\u001a\u00020/R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0011\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R+\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00188B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR/\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u001f8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0017\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R \u0010+\u001a\b\u0012\u0004\u0012\u00020\b0&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020/0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020/01¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0016\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\u00020:8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<¨\u0006G"}, d2 = {"Lcom/ss/android/lark/image/compose/android_platform/GlidePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/runtime/RememberObserver;", "context", "Landroid/content/Context;", "imageSource", "Lcom/ss/android/lark/image/compose/android_platform/ImageSource;", "imageOption", "Lcom/ss/android/lark/image/compose/common/ImageOptions;", "diskCachePolicy", "Lcom/ss/android/lark/image/compose/common/CachePolicy;", "memoryCachePolicy", "placeholder", "error", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/image/compose/android_platform/ImageSource;Lcom/ss/android/lark/image/compose/common/ImageOptions;Lcom/ss/android/lark/image/compose/common/CachePolicy;Lcom/ss/android/lark/image/compose/common/CachePolicy;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;)V", "<set-?>", "painter", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "painter$delegate", "Landroidx/compose/runtime/MutableState;", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "alpha$delegate", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "colorFilter$delegate", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getImageSource", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "setImageSource", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "imageOptions", "getImageOptions", "setImageOptions", "_state", "Lcom/ss/android/lark/image/compose/common/avatar/State;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "target", "Lcom/bumptech/glide/request/target/CustomTarget;", "Landroid/graphics/drawable/Drawable;", "requestManager", "Lcom/bumptech/glide/RequestManager;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "applyAlpha", "", "applyColorFilter", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "onAbandoned", "onForgotten", "onRemembered", "updateState", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class GlidePainter extends Painter implements RememberObserver {
    public final Context a;
    public final CachePolicy b;
    public final CachePolicy c;
    public final Painter d;
    public final Painter e;
    public final MutableState f;
    public final MutableState g;
    public final MutableState h;
    public final StateFlowImpl i;
    public final StateFlowImpl j;
    public final StateFlowImpl k;
    public final b1 l;
    public b m;
    public RequestManager n;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CachePolicy.values().length];
            r0[CachePolicy.Enabled.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CachePolicy.Disabled.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class b extends CustomTarget<Drawable> {
        public final /* synthetic */ GlidePainter a;

        public b(GlidePainter r1) {
            this.a = r1;
        }

        public final void onLoadCleared(Drawable r2) {
            this.a.a(c.a.a);
        }

        public final void onLoadFailed(Drawable r3) {
            GlidePainter r0 = this.a;
            Painter r1 = r0.e;
            if (r1 != null) goto L7;
            if (r3 == null) goto L6;
            r1 = new DrawablePainter(r3);
            goto L7
        L6:
            r1 = null;
        L7:
            com.ss.android.lark.image.compose.common.avatar.b r4 = com.ss.android.lark.image.compose.common.avatar.b.a;
            r0.a(new c.b(r1));
        }

        public final void onLoadStarted(Drawable r3) {
            GlidePainter r0 = this.a;
            Painter r1 = r0.d;
            if (r1 != null) goto L7;
            if (r3 == null) goto L6;
            r1 = new DrawablePainter(r3);
            goto L7
        L6:
            r1 = null;
        L7:
            r0.a(new c.C0092c(r1));
        }

        public final void onResourceReady(Object r3, Transition r4) {
            Drawable r5 = (Drawable) r3;
            Intrinsics.checkNotNullParameter(r5, "resource");
            GlidePainter r6 = this.a;
            DrawablePainter r1 = new DrawablePainter(r5);
            d r7 = d.a;
            r6.a(new c.d(r1));
        }
    }

    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public final long m757getIntrinsicSizeNHjbRc() {
        Painter r0 = (Painter) this.f.getValue();
        if (r0 == null) goto L6;
        return r0.getIntrinsicSize-NH-jbRc();
    L6:
        return Size.Companion.getUnspecified-NH-jbRc();
    }

    public final void onAbandoned() {
        RememberObserver r0 = (Painter) this.f.getValue();
        if ((r0 instanceof RememberObserver) == false) goto L5;
        RememberObserver r1 = r0;
    L6:
        if (r1 == null) goto L8;
        r1.onAbandoned();
    L8:
        RequestManager r2 = this.n;
        if (r2 == null) goto L11;
        r2.clear(this.m);
    L11:
        this.m = null;
        this.n = null;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onForgotten() {
        RememberObserver r0 = (Painter) this.f.getValue();
        if ((r0 instanceof RememberObserver) == false) goto L5;
        RememberObserver r1 = r0;
    L6:
        if (r1 == null) goto L8;
        r1.onForgotten();
    L8:
        RequestManager r2 = this.n;
        if (r2 == null) goto L11;
        r2.clear(this.m);
    L11:
        this.m = null;
        this.n = null;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onRemembered() {
        RememberObserver r0 = (Painter) this.f.getValue();
        if ((r0 instanceof RememberObserver) == false) goto L5;
        RememberObserver r1 = r0;
    L6:
        if (r1 == null) goto L8;
        r1.onRemembered();
    L8:
        RequestManager r2 = this.n;
        if (r2 != null) goto L11;
        r2 = Glide.with(this.a);
        this.n = r2;
    L11:
        b r3 = new b(this);
        RequestBuilder r4 = r2.asDrawable();
        com.ss.android.lark.image.compose.android_platform.a r5 = (com.ss.android.lark.image.compose.android_platform.a) this.i.getValue();
        Handler r6 = BaseImageComponentKt.a;
        if ((r5 instanceof com.ss.android.lark.image.compose.android_platform.a.d) == false) goto L15;
        Object r7 = ((com.ss.android.lark.image.compose.android_platform.a.d) r5).a;
    L23:
        RequestBuilder r8 = r4.load(r7);
        CachePolicy r9 = this.c;
        int[] r10 = a.a;
        int r11 = r10[r9.ordinal()];
        if (r11 == 1) goto L29;
        if (r11 != 2) goto L28;
        RequestBuilder r12 = r8.skipMemoryCache(true);
    L30:
        int r13 = r10[this.b.ordinal()];
        if (r13 == 1) goto L36;
        if (r13 != 2) goto L35;
        RequestBuilder r14 = r8.diskCacheStrategy(DiskCacheStrategy.NONE);
    L37:
        long r15 = ((tkb.b) this.j.getValue()).a;
        if (Size.equals-impl0(r15, Size.Companion.getUnspecified-NH-jbRc()) == true) goto L40;
        r8.override(MathKt.roundToInt(Float.intBitsToFloat((int) (r15 >> 32))), MathKt.roundToInt(Float.intBitsToFloat((int) (r15 & 4294967295L))));
    L40:
        r8.into(r3);
        this.m = r3;
        return;
    L35:
        throw new IllegalStateException(("Glide does not support an equivalent disk cache policy: " + this.b + " (only Enabled/Disabled are supported).").toString());
    L36:
        RequestBuilder r16 = r8.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
        goto L37
    L28:
        throw new IllegalStateException(("Glide does not support an equivalent memory cache policy: " + this.c + " (only Enabled/Disabled are supported).").toString());
    L29:
        RequestBuilder r17 = r8.skipMemoryCache(false);
        goto L30
    L15:
        if ((r5 instanceof com.ss.android.lark.image.compose.android_platform.a.b) == false) goto L18;
        ((com.ss.android.lark.image.compose.android_platform.a.b) r5).getClass();
        r7 = new PolarisFileWrapper(null);
        goto L23
    L18:
        if ((r5 instanceof com.ss.android.lark.image.compose.android_platform.a.c) == false) goto L21;
        ((com.ss.android.lark.image.compose.android_platform.a.c) r5).getClass();
        r7 = 0;
        goto L23
    L21:
        if ((r5 instanceof com.ss.android.lark.image.compose.android_platform.a.C0091a) == false) goto L43;
        r7 = ((com.ss.android.lark.image.compose.android_platform.a.C0091a) r5).a;
        goto L23
    L43:
        throw new NoWhenBranchMatchedException();
    L5:
        r1 = null;
        goto L6
    }

    public final void a(c r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.k.setValue(r2);
        Painter r3 = r2.a();
        this.f.setValue(r3);
    }

    public final boolean applyAlpha(float r2) {
        this.g.setValue(Float.valueOf(r2));
        return true;
    }

    public final boolean applyColorFilter(ColorFilter r2) {
        this.h.setValue(r2);
        return true;
    }

    public final void onDraw(DrawScope r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Painter r1 = (Painter) this.f.getValue();
        if (r1 == null) goto L6;
        r1.draw-x_KDEd0(r8, r8.getSize-NH-jbRc(), ((Number) this.g.getValue()).floatValue(), (ColorFilter) this.h.getValue());
        return;
    }

    public GlidePainter(Context r2, com.ss.android.lark.image.compose.android_platform.a r3, tkb.b r4, CachePolicy r5, CachePolicy r6, Painter r7, Painter r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "imageSource");
        Intrinsics.checkNotNullParameter(r4, "imageOption");
        Intrinsics.checkNotNullParameter(r5, "diskCachePolicy");
        Intrinsics.checkNotNullParameter(r6, "memoryCachePolicy");
        this.a = r2;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = SnapshotStateKt.mutableStateOf$default(r7, null, 2, null);
        this.g = SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), null, 2, null);
        this.h = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.i = j1.a(r3);
        this.j = j1.a(r4);
        StateFlowImpl r9 = j1.a(new c.C0092c(r7));
        this.k = r9;
        this.l = e.b(r9);
    }
}

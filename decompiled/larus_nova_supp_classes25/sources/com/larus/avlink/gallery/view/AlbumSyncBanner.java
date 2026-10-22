package com.larus.avlink.gallery.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RotateDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.avlink.gallery.banner.GalleryState;
import com.larus.avlink.gallery.thumbnail.ThumbnailManager;
import com.larus.avlink.gallery.view.mob.GalleryMobHelper;
import com.larus.avlink.impl.databinding.LarusPageAlbumSyncBannerBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.model.FlowDoraGlassOpenState;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b*\u0001&\b\u0007\u0018\u0000 Y2\u00020\u0001:\u0002YZB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020)H\u0002J\u0010\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\u0007H\u0002J\u0012\u0010.\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u000e\u00101\u001a\u00020)2\u0006\u00102\u001a\u00020\u0007J\u0006\u00103\u001a\u00020)J\u000e\u00104\u001a\u00020)2\u0006\u00105\u001a\u00020\u000fJ\u0006\u00106\u001a\u000207J\u0006\u00108\u001a\u000207J\u0006\u00109\u001a\u00020)J\u000e\u0010:\u001a\u00020)2\u0006\u0010;\u001a\u00020<J\u001c\u0010=\u001a\u00020)2\u0006\u0010>\u001a\u00020\u00182\n\b\u0002\u0010;\u001a\u0004\u0018\u00010<H\u0002J/\u0010?\u001a\u00020)2\b\b\u0001\u0010@\u001a\u00020\u00072\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010CJ^\u0010D\u001a\u00020)2\b\b\u0002\u0010E\u001a\u0002002\b\b\u0002\u0010F\u001a\u0002002\b\b\u0002\u0010G\u001a\u00020\u00072\b\b\u0002\u0010H\u001a\u00020\u00072\b\b\u0002\u0010I\u001a\u00020\u00072\b\b\u0002\u0010J\u001a\u0002072\b\b\u0002\u0010K\u001a\u0002072\u000e\b\u0002\u0010L\u001a\b\u0012\u0004\u0012\u00020)0MH\u0002J\b\u0010N\u001a\u00020)H\u0002J\b\u0010O\u001a\u00020)H\u0002J\b\u0010P\u001a\u000207H\u0002J\b\u0010Q\u001a\u00020)H\u0002J\u0010\u0010R\u001a\u00020)2\u0006\u0010>\u001a\u00020SH\u0002J\b\u0010T\u001a\u00020)H\u0014J\b\u0010U\u001a\u00020)H\u0014J\u000e\u0010V\u001a\u00020)2\u0006\u0010W\u001a\u00020\u0007J\u000e\u0010X\u001a\u00020)2\u0006\u0010W\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u0012\u0010!\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u0012\u0010\"\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0004\n\u0002\u0010'¨\u0006["}, d2 = {"Lcom/larus/avlink/gallery/view/AlbumSyncBanner;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/avlink/impl/databinding/LarusPageAlbumSyncBannerBinding;", "bannerStateManager", "Lcom/larus/avlink/gallery/banner/BannerStateManager;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "syncActionHandler", "Lcom/larus/avlink/gallery/view/AlbumSyncBanner$SyncActionHandler;", "getSyncActionHandler", "()Lcom/larus/avlink/gallery/view/AlbumSyncBanner$SyncActionHandler;", "setSyncActionHandler", "(Lcom/larus/avlink/gallery/view/AlbumSyncBanner$SyncActionHandler;)V", "bannerStateMachine", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/avlink/model/BannerStateMachineState;", "rotateAnimator", "Landroid/animation/ValueAnimator;", "rotateDrawable", "Landroid/graphics/drawable/RotateDrawable;", "originalSyncDrawable", "Landroid/graphics/drawable/Drawable;", "overrideBgDrawable", "Ljava/lang/Integer;", "overrideTextColor", "overrideIconTintColor", "wifiStateListener", "Lcom/larus/dora/api/wrapper/FlowDoraWifiStateListener;", "albumCountChangeListener", "com/larus/avlink/gallery/view/AlbumSyncBanner$albumCountChangeListener$1", "Lcom/larus/avlink/gallery/view/AlbumSyncBanner$albumCountChangeListener$1;", "initRotateDrawable", "", "startRotationAnimation", "stopRotationAnimation", "setStaticDrawable", "drawableRes", "wifiStateChange", "reason", "", "updateProgress", "progress", "hideProgress", "setLifecycleOwner", "owner", "inErrorState", "", "inNetworkErrorState", "eraseError", "handleEvent", "event", "Lcom/larus/avlink/model/BannerEvent;", "updateUIForState", "state", "showByState", "type", "first", "second", "(ILjava/lang/Integer;Ljava/lang/Integer;)V", "show", "title", "buttonText", "bgDrawable", "titleDrawable", "btnColor", "showCloseBtn", "showRotate", "onButtonClick", "Lkotlin/Function0;", "idle", "hide", "showMediaDiff", "observeStateChanges", "updateUi", "Lcom/larus/avlink/gallery/view/BannerState;", "onAttachedToWindow", "onDetachedFromWindow", "setOverrideBackground", "resId", "setOverrideTextColor", "Companion", "SyncActionHandler", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class AlbumSyncBanner extends ConstraintLayout {
    public static final /* synthetic */ int n = 0;
    public final LarusPageAlbumSyncBannerBinding a;
    public final q98.a b;
    public LifecycleOwner c;
    public b d;
    public final StateFlowImpl e;
    public ValueAnimator f;
    public RotateDrawable g;
    public Drawable h;
    public Integer i;
    public Integer j;
    public Integer k;
    public h49.i l;
    public final c m;

    public static final class a {
    }

    public interface b {
        void TF();

        void bj(Function1<? super Boolean, Unit> r1);

        void ib();
    }

    public static final class c implements com.larus.avlink.gallery.thumbnail.a {
        public final /* synthetic */ AlbumSyncBanner a;

        public c(AlbumSyncBanner r1) {
            this.a = r1;
        }

        @Override // com.larus.avlink.gallery.thumbnail.a
        public final void a(int r6, int r7) {
            FLogger r0 = FLogger.a;
            r0.i("AlbumSyncBanner", "AlbumCountChanged: photo=" + r6 + " video=" + r7);
            z98.b r1 = (z98.b) this.a.e.getValue();
            if ((r1 instanceof z98.b.j) == false) goto L5;
        L19:
            r0.i("AlbumSyncBanner", "Ignoring album count change during transfer: photo=" + r6 + ", video=" + r7 + ", state=" + r1.getClass().getSimpleName());
            return;
        L5:
            if ((r1 instanceof z98.b.k) == true) goto L19;
            if (r6 != 0) goto L14;
            if (r7 != 0) goto L14;
            r0.i("AlbumSyncBanner", "AlbumCount trigger: Idle");
            if (Intrinsics.areEqual(r1, z98.b.g.b) == true) goto L21;
            this.a.n6(z98.b.e.b, null);
            return;
        L21:
            return;
        L14:
            if (this.a.V5() == false) goto L17;
            r0.i("AlbumSyncBanner", "AlbumCount ignored in error state: ".concat(this.a.e.getValue().getClass().getSimpleName()));
            return;
        L17:
            this.a.T5(new z98.a.h(r6, r7));
        }
    }

    public static final class d implements h49.i {
        public final /* synthetic */ AlbumSyncBanner a;

        public final void c() {
        }

        public d(AlbumSyncBanner r1) {
            this.a = r1;
        }

        public final void a(FlowDoraGlassOpenState r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
        }

        @Deprecated(message = "使用ThumbnailManager")
        public final void b(b49.e r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
        }

        public final void d(b49.f r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
        }

        public final void e(FlowDoraGlassOpenState r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }

        public final void f(int r4, int r5, final String r6) {
            FLogger.a.i("AlbumSyncBanner", "wifi changed: old=" + r4 + " new=" + r5 + " reason=" + r6);
            z98.b r7 = (z98.b) this.a.e.getValue();
            if (r5 == 2) goto L9;
            if (r5 == 0) goto L6;
            return;
        L6:
            if (Intrinsics.areEqual(r7, z98.b.k.b) == true) goto L11;
            final AlbumSyncBanner r8 = this.a;
            r8.getClass();
            com.larus.utils.y.c(new j(r6, r8));
            return;
        L11:
            return;
        }
    }

    static {
    }

    public AlbumSyncBanner(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AlbumSyncBanner(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void U5() {
        com.larus.utils.t0.e(new s(this));
    }

    public final boolean V5() {
        z98.b r0 = (z98.b) this.e.getValue();
        if ((r0 instanceof z98.b.C0099b) == false) goto L5;
    L18:
        return true;
    L5:
        if ((r0 instanceof z98.b.n) == true) goto L18;
        if ((r0 instanceof z98.b.c) == true) goto L18;
        if ((r0 instanceof z98.b.l) == true) goto L18;
        if ((r0 instanceof z98.b.a) == true) goto L18;
        if ((r0 instanceof z98.b.f) == true) goto L18;
        if ((r0 instanceof z98.b.h) == true) goto L18;
        return false;
    }

    public final boolean b6() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L7;
        VisionService r1 = r0.V();
        if (r1 == null) goto L7;
        Pair r2 = r1.l();
    L9:
        if (r2 != null) goto L11;
    L13:
        boolean r3 = false;
    L14:
        if (r3 == true) goto L16;
    L17:
        if (r2 == null) goto L20;
        FLogger.a.i("AlbumSyncBanner", "DiffMedia: images=" + ((Number) r2.getFirst()).intValue() + ", videos=" + ((Number) r2.getSecond()).intValue());
        T5(new z98.a.h(((Number) r2.getFirst()).intValue(), ((Number) r2.getSecond()).intValue()));
        return true;
    L20:
        return false;
    L16:
        if (((Number) r2.getFirst()).intValue() == 0) goto L20;
    L11:
        if (((Number) r2.getSecond()).intValue() != 0) goto L13;
        r3 = true;
    L7:
        r2 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c6() {
        ValueAnimator r0 = this.f;
        boolean r1 = false;
        if (r0 == null) goto L8;
        if (r0.isRunning() != true) goto L8;
        r1 = true;
    L8:
        if (r1 == false) goto L11;
        FLogger.a.d("AlbumSyncBanner", "Rotation animation already running, skipping restart");
        return;
    L11:
        i6();
        Integer r2 = this.k;
        if (r2 == null) goto L18;
        int r3 = r2.intValue();
        Drawable r4 = this.h;
        if (r4 == null) goto L16;
        r4.setTint(ContextCompat.getColor(getContext(), r3));
        Unit r5 = Unit.INSTANCE;
    L17:
        if (r5 == null) goto L18;
    L21:
        final RotateDrawable r6 = this.g;
        if (r6 == null) goto L25;
        this.a.f.setCompoundDrawablesWithIntrinsicBounds(r6, null, null, null);
        ValueAnimator r7 = ValueAnimator.ofInt(new int[]{0, 10000});
        r7.setDuration(1000);
        r7.setRepeatCount(-1);
        r7.setInterpolator(new LinearInterpolator());
        r7.addUpdateListener(new i(r6));
        this.f = r7;
        r7.start();
        FLogger.a.d("AlbumSyncBanner", "Started rotation animation");
        return;
    L25:
        return;
    L16:
        r5 = null;
    L18:
        Drawable r8 = this.h;
        if (r8 == null) goto L21;
        r8.setTintList(null);
        Unit r9 = Unit.INSTANCE;
        goto L21
    }

    public final void i6() {
        ValueAnimator r0 = this.f;
        if (r0 != null) goto L5;
    L7:
        this.f = null;
        RotateDrawable r1 = this.g;
        if (r1 == null) goto L11;
        r1.setLevel(0);
        return;
    L11:
        return;
    L5:
        if (r0.isRunning() == false) goto L7;
        r0.cancel();
        FLogger.a.d("AlbumSyncBanner", "Stopped rotation animation");
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        if (this.l != null) goto L9;
        d r0 = new d(this);
        this.l = r0;
        IDoraService r1 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r1 == null) goto L9;
        IDoraService.j r2 = r1.S();
        if (r2 == null) goto L9;
        r2.e(r0);
    L9:
        ThumbnailManager r3 = ThumbnailManager.a;
        ThumbnailManager.g(this.m);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        h49.i r0 = this.l;
        if (r0 == null) goto L9;
        IDoraService r1 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r1 == null) goto L9;
        IDoraService.j r2 = r1.S();
        if (r2 == null) goto L9;
        r2.c(r0);
    L9:
        this.l = null;
        ThumbnailManager r3 = ThumbnailManager.a;
        ThumbnailManager.p(this.m);
    }

    public final b getSyncActionHandler() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setStaticDrawable(int r4) {
        i6();
        Drawable r5 = ContextCompat.getDrawable(getContext(), r4);
        if (r5 == null) goto L5;
        Drawable r6 = r5.mutate();
    L6:
        Integer r1 = this.k;
        if (r1 == null) goto L11;
        int r2 = r1.intValue();
        if (r6 == null) goto L11;
        r6.setTint(ContextCompat.getColor(getContext(), r2));
    L11:
        this.a.f.setCompoundDrawablesWithIntrinsicBounds(r6, null, null, null);
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void T5(z98.a r11) {
        Intrinsics.checkNotNullParameter(r11, "event");
        z98.b r0 = (z98.b) this.e.getValue();
        String r1 = r11.a;
        FLogger r2 = FLogger.a;
        r2.i("AlbumSyncBanner", "handle event:" + r1);
        if ((r0 instanceof z98.b.e) == false) goto L29;
        if ((r11 instanceof z98.a.f) == false) goto L8;
        z98.b r3 = z98.b.g.b;
    L335:
        if (Intrinsics.areEqual(r3, r0) == true) goto L337;
    L340:
        this.e.setValue(r3);
        r2.i("AlbumSyncBanner", "State transition: " + r0.a + " --" + r1 + "--> " + r3.a);
        LifecycleOwner r4 = this.c;
        if (r4 == null) goto L347;
        LifecycleCoroutineScope r5 = LifecycleOwnerKt.getLifecycleScope(r4);
        if (r5 == null) goto L348;
        BuildersKt.launch$default(r5, Dispatchers.getMain(), null, new AlbumSyncBanner$handleEvent$1(this, r3, r11, null), 2, null);
        return;
    L348:
        return;
    L347:
        return;
    L337:
        if (Intrinsics.areEqual(r3, z98.b.i.b) == true) goto L340;
        r2.i("AlbumSyncBanner", "No transition: " + r0.a + " --" + r1 + "--> " + r3.a);
        return;
    L8:
        if ((r11 instanceof z98.a.m) == false) goto L11;
        r3 = z98.b.n.b;
        goto L335
    L11:
        if ((r11 instanceof z98.a.e) == false) goto L14;
        r3 = z98.b.f.b;
        goto L335
    L14:
        if ((r11 instanceof z98.a.g) == false) goto L17;
        r3 = z98.b.h.b;
        goto L335
    L17:
        if ((r11 instanceof z98.a.b) == false) goto L20;
        r3 = z98.b.c.b;
        goto L335
    L20:
        if ((r11 instanceof z98.a.k) == false) goto L23;
        r3 = z98.b.l.b;
        goto L335
    L23:
        if ((r11 instanceof z98.a.C0098a) == false) goto L26;
        r3 = z98.b.a.b;
        goto L335
    L26:
        if ((r11 instanceof z98.a.h) == false) goto L333;
        r3 = z98.b.i.b;
    L333:
        r3 = r0;
        goto L335
    L29:
        if ((r0 instanceof z98.b.i) == false) goto L61;
        if ((r11 instanceof z98.a.m) == false) goto L34;
        r3 = z98.b.n.b;
        goto L335
    L34:
        if ((r11 instanceof z98.a.b) == false) goto L37;
        r3 = z98.b.c.b;
        goto L335
    L37:
        if ((r11 instanceof z98.a.k) == false) goto L40;
        r3 = z98.b.l.b;
        goto L335
    L40:
        if ((r11 instanceof z98.a.e) == false) goto L43;
        r3 = z98.b.f.b;
        goto L335
    L43:
        if ((r11 instanceof z98.a.g) == false) goto L46;
        r3 = z98.b.h.b;
        goto L335
    L46:
        if ((r11 instanceof z98.a.C0098a) == false) goto L49;
        r3 = z98.b.a.b;
        goto L335
    L49:
        if ((r11 instanceof z98.a.l) == false) goto L52;
        r3 = z98.b.m.b;
        goto L335
    L52:
        if ((r11 instanceof z98.a.c) == false) goto L55;
        r3 = z98.b.d.b;
        goto L335
    L55:
        if ((r11 instanceof z98.a.d) == false) goto L58;
        r3 = z98.b.e.b;
        goto L335
    L58:
        if ((r11 instanceof z98.a.j) == false) goto L333;
        r3 = z98.b.k.b;
        goto L335
    L61:
        if ((r0 instanceof z98.b.m) == false) goto L90;
        if ((r11 instanceof z98.a.m) == false) goto L66;
        r3 = z98.b.n.b;
        goto L335
    L66:
        if ((r11 instanceof z98.a.b) == false) goto L69;
        r3 = z98.b.c.b;
        goto L335
    L69:
        if ((r11 instanceof z98.a.e) == false) goto L72;
        r3 = z98.b.f.b;
        goto L335
    L72:
        if ((r11 instanceof z98.a.g) == false) goto L75;
        r3 = z98.b.h.b;
        goto L335
    L75:
        if ((r11 instanceof z98.a.k) == false) goto L78;
        r3 = z98.b.l.b;
        goto L335
    L78:
        if ((r11 instanceof z98.a.C0098a) == false) goto L81;
        r3 = z98.b.a.b;
        goto L335
    L81:
        if ((r11 instanceof z98.a.j) == false) goto L84;
        r3 = z98.b.k.b;
        goto L335
    L84:
        if ((r11 instanceof z98.a.d) == false) goto L87;
        r3 = z98.b.e.b;
        goto L335
    L87:
        if ((r11 instanceof z98.a.n) == false) goto L333;
        r3 = z98.b.C0099b.b;
        goto L335
    L90:
        if ((r0 instanceof z98.b.k) == false) goto L119;
        if ((r11 instanceof z98.a.i) == false) goto L95;
        r3 = z98.b.j.b;
        goto L335
    L95:
        if ((r11 instanceof z98.a.k) == false) goto L98;
        r3 = z98.b.l.b;
        goto L335
    L98:
        if ((r11 instanceof z98.a.C0098a) == false) goto L101;
        r3 = z98.b.a.b;
        goto L335
    L101:
        if ((r11 instanceof z98.a.e) == false) goto L104;
        r3 = z98.b.f.b;
        goto L335
    L104:
        if ((r11 instanceof z98.a.g) == false) goto L107;
        r3 = z98.b.h.b;
        goto L335
    L107:
        if ((r11 instanceof z98.a.l) == false) goto L110;
        r3 = z98.b.m.b;
        goto L335
    L110:
        if ((r11 instanceof z98.a.d) == false) goto L113;
        r3 = z98.b.e.b;
        goto L335
    L113:
        if ((r11 instanceof z98.a.n) == false) goto L116;
        r3 = z98.b.C0099b.b;
        goto L335
    L116:
        if ((r11 instanceof z98.a.m) == false) goto L333;
        r3 = z98.b.n.b;
        goto L335
    L119:
        if ((r0 instanceof z98.b.l) == false) goto L142;
        if ((r11 instanceof z98.a.h) == false) goto L124;
        r3 = z98.b.i.b;
        goto L335
    L124:
        if ((r11 instanceof z98.a.m) == false) goto L127;
        r3 = z98.b.n.b;
        goto L335
    L127:
        if ((r11 instanceof z98.a.C0098a) == false) goto L130;
        r3 = z98.b.a.b;
        goto L335
    L130:
        if ((r11 instanceof z98.a.e) == false) goto L133;
        r3 = z98.b.f.b;
        goto L335
    L133:
        if ((r11 instanceof z98.a.b) == false) goto L136;
        r3 = z98.b.c.b;
        goto L335
    L136:
        if ((r11 instanceof z98.a.d) == false) goto L139;
        r3 = z98.b.e.b;
        goto L335
    L139:
        if ((r11 instanceof z98.a.c) == false) goto L333;
        r3 = z98.b.d.b;
        goto L335
    L142:
        if ((r0 instanceof z98.b.a) == false) goto L165;
        if ((r11 instanceof z98.a.h) == false) goto L147;
        r3 = z98.b.i.b;
        goto L335
    L147:
        if ((r11 instanceof z98.a.m) == false) goto L150;
        r3 = z98.b.n.b;
        goto L335
    L150:
        if ((r11 instanceof z98.a.e) == false) goto L153;
        r3 = z98.b.f.b;
        goto L335
    L153:
        if ((r11 instanceof z98.a.k) == false) goto L156;
        r3 = z98.b.l.b;
        goto L335
    L156:
        if ((r11 instanceof z98.a.b) == false) goto L159;
        r3 = z98.b.c.b;
        goto L335
    L159:
        if ((r11 instanceof z98.a.d) == false) goto L162;
        r3 = z98.b.e.b;
        goto L335
    L162:
        if ((r11 instanceof z98.a.c) == false) goto L333;
        r3 = z98.b.d.b;
        goto L335
    L165:
        if ((r0 instanceof z98.b.n) == false) goto L188;
        if ((r11 instanceof z98.a.h) == false) goto L170;
        r3 = z98.b.i.b;
        goto L335
    L170:
        if ((r11 instanceof z98.a.b) == false) goto L173;
        r3 = z98.b.c.b;
        goto L335
    L173:
        if ((r11 instanceof z98.a.e) == false) goto L176;
        r3 = z98.b.f.b;
        goto L335
    L176:
        if ((r11 instanceof z98.a.k) == false) goto L179;
        r3 = z98.b.l.b;
        goto L335
    L179:
        if ((r11 instanceof z98.a.C0098a) == false) goto L182;
        r3 = z98.b.a.b;
        goto L335
    L182:
        if ((r11 instanceof z98.a.d) == false) goto L185;
        r3 = z98.b.e.b;
        goto L335
    L185:
        if ((r11 instanceof z98.a.c) == false) goto L333;
        r3 = z98.b.d.b;
        goto L335
    L188:
        if ((r0 instanceof z98.b.f) == false) goto L211;
        if ((r11 instanceof z98.a.h) == false) goto L193;
        r3 = z98.b.i.b;
        goto L335
    L193:
        if ((r11 instanceof z98.a.b) == false) goto L196;
        r3 = z98.b.c.b;
        goto L335
    L196:
        if ((r11 instanceof z98.a.m) == false) goto L199;
        r3 = z98.b.n.b;
        goto L335
    L199:
        if ((r11 instanceof z98.a.k) == false) goto L202;
        r3 = z98.b.l.b;
        goto L335
    L202:
        if ((r11 instanceof z98.a.C0098a) == false) goto L205;
        r3 = z98.b.a.b;
        goto L335
    L205:
        if ((r11 instanceof z98.a.d) == false) goto L208;
        r3 = z98.b.e.b;
        goto L335
    L208:
        if ((r11 instanceof z98.a.c) == false) goto L333;
        r3 = z98.b.d.b;
        goto L335
    L211:
        if ((r0 instanceof z98.b.h) == false) goto L234;
        if ((r11 instanceof z98.a.h) == false) goto L216;
        r3 = z98.b.i.b;
        goto L335
    L216:
        if ((r11 instanceof z98.a.b) == false) goto L219;
        r3 = z98.b.c.b;
        goto L335
    L219:
        if ((r11 instanceof z98.a.m) == false) goto L222;
        r3 = z98.b.n.b;
        goto L335
    L222:
        if ((r11 instanceof z98.a.k) == false) goto L225;
        r3 = z98.b.l.b;
        goto L335
    L225:
        if ((r11 instanceof z98.a.C0098a) == false) goto L228;
        r3 = z98.b.a.b;
        goto L335
    L228:
        if ((r11 instanceof z98.a.d) == false) goto L231;
        r3 = z98.b.e.b;
        goto L335
    L231:
        if ((r11 instanceof z98.a.c) == false) goto L333;
        r3 = z98.b.d.b;
        goto L335
    L234:
        if ((r0 instanceof z98.b.c) == false) goto L257;
        if ((r11 instanceof z98.a.h) == false) goto L239;
        r3 = z98.b.i.b;
        goto L335
    L239:
        if ((r11 instanceof z98.a.m) == false) goto L242;
        r3 = z98.b.n.b;
        goto L335
    L242:
        if ((r11 instanceof z98.a.e) == false) goto L245;
        r3 = z98.b.f.b;
        goto L335
    L245:
        if ((r11 instanceof z98.a.k) == false) goto L248;
        r3 = z98.b.l.b;
        goto L335
    L248:
        if ((r11 instanceof z98.a.C0098a) == false) goto L251;
        r3 = z98.b.a.b;
        goto L335
    L251:
        if ((r11 instanceof z98.a.d) == false) goto L254;
        r3 = z98.b.e.b;
        goto L335
    L254:
        if ((r11 instanceof z98.a.c) == false) goto L333;
        r3 = z98.b.d.b;
        goto L335
    L257:
        if ((r0 instanceof z98.b.C0099b) == false) goto L283;
        if ((r11 instanceof z98.a.m) == false) goto L262;
        r3 = z98.b.n.b;
        goto L335
    L262:
        if ((r11 instanceof z98.a.b) == false) goto L265;
        r3 = z98.b.c.b;
        goto L335
    L265:
        if ((r11 instanceof z98.a.k) == false) goto L268;
        r3 = z98.b.l.b;
        goto L335
    L268:
        if ((r11 instanceof z98.a.C0098a) == false) goto L271;
        r3 = z98.b.a.b;
        goto L335
    L271:
        if ((r11 instanceof z98.a.l) == false) goto L274;
        r3 = z98.b.m.b;
        goto L335
    L274:
        if ((r11 instanceof z98.a.h) == false) goto L277;
        r3 = z98.b.i.b;
        goto L335
    L277:
        if ((r11 instanceof z98.a.c) == false) goto L280;
        r3 = z98.b.d.b;
        goto L335
    L280:
        if ((r11 instanceof z98.a.d) == false) goto L333;
        r3 = z98.b.e.b;
        goto L335
    L283:
        if ((r0 instanceof z98.b.j) == false) goto L300;
        if ((r11 instanceof z98.a.f) == false) goto L288;
        r3 = z98.b.g.b;
        goto L335
    L288:
        if ((r11 instanceof z98.a.c) == false) goto L291;
        r3 = z98.b.d.b;
        goto L335
    L291:
        if ((r11 instanceof z98.a.i) == false) goto L294;
        r3 = z98.b.e.b;
        goto L335
    L294:
        if ((r11 instanceof z98.a.h) == false) goto L297;
        r3 = z98.b.i.b;
        goto L335
    L297:
        if ((r11 instanceof z98.a.d) == false) goto L333;
        r3 = z98.b.e.b;
        goto L335
    L300:
        if ((r0 instanceof z98.b.g) == false) goto L311;
        if ((r11 instanceof z98.a.h) == false) goto L305;
        r3 = z98.b.i.b;
        goto L335
    L305:
        if ((r11 instanceof z98.a.c) == false) goto L308;
        r3 = z98.b.d.b;
        goto L335
    L308:
        if ((r11 instanceof z98.a.d) == false) goto L333;
        r3 = z98.b.e.b;
        goto L335
    L311:
        if ((r0 instanceof z98.b.d) == false) goto L333;
        if ((r11 instanceof z98.a.h) == false) goto L316;
        r3 = z98.b.i.b;
        goto L335
    L316:
        if ((r11 instanceof z98.a.m) == false) goto L319;
        r3 = z98.b.n.b;
        goto L335
    L319:
        if ((r11 instanceof z98.a.e) == false) goto L322;
        r3 = z98.b.f.b;
        goto L335
    L322:
        if ((r11 instanceof z98.a.b) == false) goto L325;
        r3 = z98.b.c.b;
        goto L335
    L325:
        if ((r11 instanceof z98.a.k) == false) goto L328;
        r3 = z98.b.l.b;
        goto L335
    L328:
        if ((r11 instanceof z98.a.C0098a) == false) goto L331;
        r3 = z98.b.a.b;
        goto L335
    L331:
        if ((r11 instanceof z98.a.d) == false) goto L333;
        r3 = z98.b.e.b;
        goto L335
    }

    public final void k6(final int r2) {
        com.larus.utils.t0.e(new r(this, r2));
    }

    public final void setLifecycleOwner(LifecycleOwner r8) {
        Intrinsics.checkNotNullParameter(r8, "owner");
        this.c = r8;
        if (r8 == null) goto L7;
        LifecycleCoroutineScope r1 = LifecycleOwnerKt.getLifecycleScope(r8);
        if (r1 == null) goto L7;
        BuildersKt.launch$default(r1, null, null, new AlbumSyncBanner$observeStateChanges$1(this, null), 3, null);
    L7:
        r8.getLifecycle().addObserver(new AnonymousClass1(this));
    }

    public final void setOverrideBackground(final int r2) {
        this.i = Integer.valueOf(r2);
        com.larus.utils.t0.e(new m(this, r2));
    }

    public final void setOverrideTextColor(final int r2) {
        this.j = Integer.valueOf(r2);
        this.k = Integer.valueOf(r2);
        com.larus.utils.t0.e(new g(this, r2));
    }

    public final void setSyncActionHandler(b r1) {
        this.d = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void R5(AlbumSyncBanner r2, int r3) {
        r2.a.f.setTextColor(ContextCompat.getColor(r2.getContext(), r3));
        y r4 = (y) r2.b.b.getValue();
        if (r4.h == true) goto L5;
    L7:
        r2.setStaticDrawable(r4.c);
        return;
    L5:
        if (r4.c != 2131240821) goto L7;
        r2.c6();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void S5(final AlbumSyncBanner r5, final y r6) {
        r5.getClass();
        int r1 = 8;
        boolean r2 = false;
        if (r6.a == false) goto L5;
        int r0 = 0;
    L6:
        r5.setVisibility(r0);
        r5.a.f.setText(r6.b);
        TextView r3 = r5.a.f;
        Context r4 = r5.getContext();
        Integer r7 = r5.j;
        if (r7 == null) goto L9;
        int r8 = r7.intValue();
    L10:
        r3.setTextColor(ContextCompat.getColor(r4, r8));
        if (r6.h == true) goto L13;
    L15:
        r5.setStaticDrawable(r6.c);
    L16:
        ConstraintLayout r9 = r5.a.a;
        Integer r10 = r5.i;
        if (r10 == null) goto L19;
        int r11 = r10.intValue();
    L20:
        r9.setBackgroundResource(r11);
        if (r6.g == false) goto L23;
        com.larus.utils.e1.x(r5.a.c);
    L24:
        com.larus.utils.e1.d(r5.a.c, new k(r5));
        TextView r12 = r5.a.b;
        r12.setText(r6.f);
        if (r6.f.length() <= 0) goto L27;
        boolean r13 = true;
    L28:
        if (r13 == false) goto L30;
        r1 = 0;
    L30:
        r12.setVisibility(r1);
        r12.setOnClickListener(null);
        if (r6.f.length() <= 0) goto L33;
        r2 = true;
    L33:
        if (r2 == false) goto L36;
        com.larus.utils.e1.d(r12, new l(r6));
        return;
    L36:
        return;
    L27:
        r13 = false;
        goto L28
    L23:
        com.larus.utils.e1.o(r5.a.c);
        goto L24
    L19:
        r11 = r6.d;
        goto L20
    L13:
        if (r6.c != 2131240821) goto L15;
        r5.c6();
        goto L16
    L9:
        r8 = r6.e;
        goto L10
    L5:
        r0 = 8;
        goto L6
    }

    public final void n6(z98.b r3, z98.a r4) {
        if ((r3 instanceof z98.b.e) == false) goto L6;
        com.larus.utils.t0.e(new q(this));
        return;
    L6:
        if ((r3 instanceof z98.b.i) == false) goto L11;
        if ((r4 instanceof z98.a.h) == false) goto L51;
        z98.a.h r5 = (z98.a.h) r4;
        Z5(0, Integer.valueOf(r5.b), Integer.valueOf(r5.c));
        return;
    L51:
        return;
    L11:
        if ((r3 instanceof z98.b.n) == false) goto L14;
        Z5(5, 0, 0);
        return;
    L14:
        if ((r3 instanceof z98.b.c) == false) goto L17;
        Z5(8, 0, 0);
        return;
    L17:
        if ((r3 instanceof z98.b.l) == false) goto L20;
        Z5(4, 0, 0);
        return;
    L20:
        if ((r3 instanceof z98.b.a) == false) goto L23;
        Z5(9, 0, 0);
        return;
    L23:
        if ((r3 instanceof z98.b.m) == false) goto L26;
        Z5(1, 0, 0);
        return;
    L26:
        if ((r3 instanceof z98.b.k) == false) goto L29;
        Z5(2, 0, 0);
        return;
    L29:
        if ((r3 instanceof z98.b.f) == false) goto L32;
        Z5(10, 0, 0);
        return;
    L32:
        if ((r3 instanceof z98.b.h) == false) goto L35;
        Z5(11, 0, 0);
        return;
    L35:
        if ((r3 instanceof z98.b.j) == false) goto L38;
        Z5(3, 0, 0);
        return;
    L38:
        if ((r3 instanceof z98.b.g) == false) goto L41;
        Z5(7, 0, 0);
        return;
    L41:
        if ((r3 instanceof z98.b.C0099b) == false) goto L44;
        Z5(6, 0, 0);
        return;
    L44:
        if ((r3 instanceof z98.b.d) == true) goto L46;
        FLogger.a.w("AlbumSyncBanner", "Unhandled state: " + r3);
        return;
    L46:
        if (b6() == true) goto L64;
        i6();
        this.b.a();
        com.larus.utils.e1.o(this.a.e);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AlbumSyncBanner(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10);
        ConstraintLayout r11 = LayoutInflater.from(r8).inflate(2131562995, this, false);
        int r12 = 2131362484;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r11, 2131362484);
        if (r2 == null) goto L23;
        r12 = 2131363923;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r11, 2131363923);
        if (r3 == null) goto L23;
        r12 = 2131363938;
        View r4 = ViewBindings.findChildViewById(r11, 2131363938);
        if (r4 == null) goto L23;
        r12 = 2131383297;
        ProgressBar r5 = (ProgressBar) ViewBindings.findChildViewById(r11, 2131383297);
        if (r5 == null) goto L23;
        r12 = 2131388915;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r11, 2131388915);
        if (r6 == null) goto L23;
        ConstraintLayout r13 = r11;
        this.a = new LarusPageAlbumSyncBannerBinding(r13, r2, r3, r4, r5, r6);
        this.b = new q98.a();
        this.e = kotlinx.coroutines.flow.j1.a(z98.b.e.b);
        this.m = new c(this);
        addView(r13);
        LifecycleOwner r14 = this.c;
        Drawable r15 = null;
        if (r14 == null) goto L17;
        LifecycleCoroutineScope r0 = LifecycleOwnerKt.getLifecycleScope(r14);
        if (r0 == null) goto L17;
        BuildersKt.launch$default(r0, null, null, new AlbumSyncBanner$observeStateChanges$1(this, null), 3, null);
    L17:
        Drawable r16 = ContextCompat.getDrawable(getContext(), 2131240821);
        if (r16 == null) goto L20;
        r15 = r16.mutate();
    L20:
        this.h = r15;
        RotateDrawable r17 = new RotateDrawable();
        r17.setDrawable(this.h);
        r17.setFromDegrees(0.0f);
        r17.setToDegrees(360.0f);
        r17.setPivotXRelative(true);
        r17.setPivotYRelative(true);
        r17.setPivotX(0.5f);
        r17.setPivotY(0.5f);
        this.g = r17;
        return;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z5(@GalleryState int r11, Integer r12, Integer r13) {
        switch(r11) {
            case -1: goto L54;
            case 0: goto L16;
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            case 11: goto L5;
            default: goto L70;
        };
    L5:
        GalleryMobHelper.e(GalleryMobHelper.a, 6);
        U5();
        Y5(this, getContext().getString(2131902919), "", 0, 0, 0, true, false, null, 220);
        return;
    L6:
        GalleryMobHelper.e(GalleryMobHelper.a, 5);
        U5();
        Y5(this, getContext().getString(2131902116), "", 0, 0, 0, true, false, null, 220);
        return;
    L7:
        U5();
        GalleryMobHelper.e(GalleryMobHelper.a, 6);
        Y5(this, getContext().getString(2131902087), "", 0, 0, 0, true, false, null, 220);
        return;
    L8:
        GalleryMobHelper.e(GalleryMobHelper.a, 3);
        U5();
        Y5(this, getContext().getString(2131902113), "", 0, 0, 0, true, false, null, 220);
        return;
    L9:
        U5();
        Y5(this, getContext().getString(2131902153), getContext().getString(2131902111), 0, 0, 0, false, false, new p(this), 124);
        return;
    L10:
        GalleryMobHelper.e(GalleryMobHelper.a, 4);
        U5();
        Y5(this, getContext().getString(2131902093), "", 0, 0, 0, true, false, null, 220);
        return;
    L11:
        U5();
        GalleryMobHelper.e(GalleryMobHelper.a, 1);
        Y5(this, getContext().getString(2131902107), getContext().getString(2131902084), 0, 0, 0, true, false, new o(this), 92);
        return;
    L12:
        U5();
        GalleryMobHelper.e(GalleryMobHelper.a, 2);
        Y5(this, getContext().getString(2131902089), "", 0, 0, 0, true, false, null, 220);
        return;
    L13:
        FLogger.a.i("zhstest", "trans complete");
        k6(100);
        Y5(this, getContext().getString(2131902160), "", 2131102529, 2131240823, 2131103146, false, false, null, 224);
        return;
    L14:
        Y5(this, getContext().getString(2131902161), "", 2131102529, 2131240821, 2131103146, false, true, null, 160);
        return;
    L15:
        FLogger.a.i("AlbumSyncBanner", "change text: WIFI_CONNECTING");
        Y5(this, getContext().getString(2131902092), "", 2131102529, 2131240821, 2131103146, false, true, null, 160);
        return;
    L16:
        U5();
        int r0 = 0;
        if (r12 != null) goto L20;
    L31:
        if (r13 != null) goto L34;
    L44:
        Context r3 = getContext();
        Object[] r1 = new Object[2];
        if (r12 == null) goto L47;
        int r4 = r12.intValue();
    L48:
        r1[0] = Integer.valueOf(r4);
        if (r13 == null) goto L51;
        r0 = r13.intValue();
    L51:
        r1[1] = Integer.valueOf(r0);
        String r2 = r3.getString(2131902151, r1);
    L30:
        String r5 = r2;
        Intrinsics.checkNotNull(r5);
        Y5(this, r5, getContext().getString(2131902156), 2131102529, 2131240821, 2131103146, false, false, new n(this), 96);
        return;
    L47:
        r4 = 0;
        goto L48
    L34:
        if (r13.intValue() != 0) goto L44;
        if (r12 != null) goto L38;
    L39:
        Context r6 = getContext();
        Object[] r7 = new Object[1];
        if (r12 == null) goto L42;
        int r8 = r12.intValue();
    L43:
        r7[0] = Integer.valueOf(r8);
        r2 = r6.getString(2131902152, r7);
        goto L30
    L42:
        r8 = 0;
        goto L43
    L38:
        if (r12.intValue() == 0) goto L44;
    L20:
        if (r12.intValue() != 0) goto L31;
        if (r13 != null) goto L24;
    L25:
        Context r9 = getContext();
        Object[] r10 = new Object[1];
        if (r13 == null) goto L28;
        int r14 = r13.intValue();
    L29:
        r10[0] = Integer.valueOf(r14);
        r2 = r9.getString(2131902154, r10);
        goto L30
    L28:
        r14 = 0;
        goto L29
    L24:
        if (r13.intValue() == 0) goto L31;
    L70:
        return;
    L54:
        if (b6() == true) goto L69;
        i6();
        this.b.a();
        com.larus.utils.e1.o(this.a.e);
        return;
    }

    public /* synthetic */ AlbumSyncBanner(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void Y5(AlbumSyncBanner r12, String r13, String r14, int r15, int r16, int r17, boolean r18, boolean r19, Function0 r20, int r21) {
        if ((r21 & 1) == 0) goto L5;
        String r1 = r12.getContext().getString(2131902153);
    L7:
        if ((r21 & 2) == 0) goto L9;
        String r2 = r12.getContext().getString(2131902156);
    L11:
        if ((r21 & 4) == 0) goto L13;
        int r3 = 2131102512;
    L15:
        if ((r21 & 8) == 0) goto L17;
        int r4 = 2131240824;
    L19:
        if ((r21 & 16) == 0) goto L21;
        int r5 = 2131102502;
    L22:
        boolean r7 = false;
        if ((r21 & 32) == 0) goto L25;
        boolean r6 = false;
    L27:
        if ((r21 & 64) != 0) goto L31;
        r7 = r19;
    L31:
        if ((r21 & 128) == 0) goto L33;
        Function0 r0 = new h();
    L34:
        q98.a r8 = r12.b;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r1, "title");
        Intrinsics.checkNotNullParameter(r2, "buttonText");
        Intrinsics.checkNotNullParameter(r0, "onButtonClick");
        StateFlowImpl r9 = r8.a;
    L35:
        Object r10 = r9.getValue();
        ((y) r10).getClass();
        if (r9.compareAndSet(r10, y.a(true, r1, r4, r3, r5, r2, r6, r7, r0)) == false) goto L35;
        return;
    L33:
        r0 = r20;
        goto L34
    L25:
        r6 = r18;
        goto L27
    L21:
        r5 = r17;
        goto L22
    L17:
        r4 = r16;
        goto L19
    L13:
        r3 = r15;
        goto L15
    L9:
        r2 = r14;
        goto L11
    L5:
        r1 = r13;
        goto L7
    }
}

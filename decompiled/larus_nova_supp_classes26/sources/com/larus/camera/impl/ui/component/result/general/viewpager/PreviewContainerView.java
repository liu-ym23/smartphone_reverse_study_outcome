package com.larus.camera.impl.ui.component.result.general.viewpager;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.view.markableview.MarkableImageView;
import com.larus.camera.api.params.ImageParam;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.impl.databinding.LarusLayoutPreviewContainerBinding;
import com.larus.camera.impl.ui.fragment.CameraResultFragment;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.camera.impl.ui.viewmodel.o0;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.h1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 b2\u00020\u0001:\u0001bB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u00100\u001a\u00020\u0013H\u0002JF\u00101\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00152\u0018\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f0\u001d2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0!J\b\u00104\u001a\u00020\u001fH\u0002J\u0010\u00105\u001a\u00020\u00132\u0006\u00106\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020\u00132\u0006\u00106\u001a\u000207H\u0016J\u0010\u00109\u001a\u00020\u00132\u0006\u00106\u001a\u000207H\u0016J\u0010\u0010:\u001a\u00020\u001f2\u0006\u00106\u001a\u000207H\u0002J\u0018\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020%H\u0002J\u0010\u0010>\u001a\u00020\u001f2\u0006\u00106\u001a\u000207H\u0002J\b\u0010?\u001a\u00020\u0013H\u0002J\b\u0010@\u001a\u00020\u0013H\u0002J\b\u0010A\u001a\u00020\u001fH\u0002J\b\u0010B\u001a\u00020\u001fH\u0002J\u0006\u0010E\u001a\u00020\u001fJ\u0006\u0010F\u001a\u00020\u001fJ\u000e\u0010G\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020\u0013J\u0010\u0010I\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\u0007H\u0002J\b\u0010J\u001a\u00020\u001fH\u0002J\b\u0010K\u001a\u00020\u0013H\u0002J\u000e\u0010L\u001a\u00020\u001f2\u0006\u00106\u001a\u000207J\u0016\u0010M\u001a\u00020\u001f2\u0006\u0010N\u001a\u00020\u00182\u0006\u0010O\u001a\u00020\u0013J\u0010\u0010P\u001a\u00020\u001f2\b\u0010Q\u001a\u0004\u0018\u00010RJ\u001a\u0010S\u001a\u00020\u001f2\b\u0010T\u001a\u0004\u0018\u00010\u001e2\u0006\u0010O\u001a\u00020\u0013H\u0002J\u0018\u0010U\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\u00132\u0006\u0010N\u001a\u00020\u0018H\u0002J\u0010\u0010V\u001a\u00020\u001f2\u0006\u0010W\u001a\u00020XH\u0002J\u001d\u0010Y\u001a\u00020\u001f2\u0006\u0010Z\u001a\u00020\u00072\b\u0010[\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\\J\u0006\u0010]\u001a\u00020\u001fJ+\u0010^\u001a\u00020\u001f2\u0006\u0010_\u001a\u00020\u00072\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010aR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\"\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/larus/camera/impl/ui/component/result/general/viewpager/PreviewContainerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewModel", "Lcom/larus/camera/impl/ui/viewmodel/CameraResultViewModel;", "previewFragmentAdapter", "Lcom/larus/camera/impl/ui/component/result/general/viewpager/ResultPreviewFragmentAdapter;", "previewViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "binding", "Lcom/larus/camera/impl/databinding/LarusLayoutPreviewContainerBinding;", "supportRecord", "", "viewScope", "Lkotlinx/coroutines/CoroutineScope;", "hasInit", "pendingData", "Lcom/larus/camera/impl/ui/viewmodel/PreviewBitmapState;", "unifiedPreviewEnabled", "pendingProgrammaticPage", "Ljava/lang/Integer;", "onUserPageSelected", "Lkotlin/Function2;", "Lcom/larus/camera/api/params/OutputParam;", "", "onMediaClick", "Lkotlin/Function0;", "inputActive", "inputActiveWhenTapStarted", "zoomScale", "", "lastPanX", "lastPanY", "unifiedGestureActive", "lastScaleEventTime", "", "lastScaleEventAction", "scaleGestureDetector", "Landroid/view/ScaleGestureDetector;", "tapGestureDetector", "Landroid/view/GestureDetector;", "isEduScene", "init", "bottomHeight", "scope", "initImage", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "onTouchEvent", "feedScaleGestureDetector", "updateZoomPivot", "focusX", "focusY", "updatePanAnchorFromRemainingPointer", "canUseUnifiedZoom", "canUseUnifiedInteraction", "clampZoomTranslation", "resetUnifiedZoom", "legacyPagerLayout", "Landroid/widget/FrameLayout$LayoutParams;", "applyUnifiedMediaCanvas", "restoreLegacyMediaCanvas", "setUnifiedPreviewEnabled", "enabled", "initViewPager", "updatePreviewPagerInputEnabled", "canUsePreviewPagerInput", "intercept", "initData", "previewBitmapState", "supportMarkable", "setRawBitmap", "bitmap", "Landroid/graphics/Bitmap;", "setupViewPager", "previewParam", "setupImageView", "showGifPreview", MusicAppletPage.KEY_PATH, "", "onPreviewChangedBefore", "lastPosition", "deletePosition", "(ILjava/lang/Integer;)V", "updatePreviewListFromMultiResult", "onPreviewChanged", "position", "newSelectedBeforeRealDelete", "(ILjava/lang/Integer;Ljava/lang/Integer;)V", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreviewContainerView extends FrameLayout {
    public static final /* synthetic */ int x = 0;
    public CameraResultViewModel a;
    public ResultPreviewFragmentAdapter b;
    public ViewPager2 c;
    public final LarusLayoutPreviewContainerBinding d;
    public final boolean e;
    public CoroutineScope f;
    public boolean g;
    public o0 h;
    public boolean i;
    public Integer j;
    public Function2<? super OutputParam, ? super Integer, Unit> k;
    public Function0<Unit> l;
    public boolean m;
    public boolean n;
    public float o;
    public float p;
    public float q;
    public boolean r;
    public long s;
    public int t;
    public final ScaleGestureDetector u;
    public final GestureDetector v;
    public FrameLayout.LayoutParams w;

    public static final class a {
    }

    public static final class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public final /* synthetic */ PreviewContainerView a;

        public b(PreviewContainerView r1) {
            this.a = r1;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector r4) {
            Intrinsics.checkNotNullParameter(r4, "detector");
            PreviewContainerView r0 = this.a;
            int r1 = PreviewContainerView.x;
            if (r0.d() == true) goto L6;
            return false;
        L6:
            PreviewContainerView.a(this.a, r4.getFocusX(), r4.getFocusY());
            PreviewContainerView r2 = this.a;
            r2.o = RangesKt.coerceIn(r2.o * r4.getScaleFactor(), 1.0f, 3.0f);
            PreviewContainerView r5 = this.a;
            LarusLayoutPreviewContainerBinding r3 = r5.d;
            if (r3 == null) goto L11;
            FrameLayout r6 = r3.d;
            if (r6 == null) goto L11;
            r6.setScaleX(r5.o);
            r6.setScaleY(r5.o);
        L11:
            this.a.e();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector r4) {
            Intrinsics.checkNotNullParameter(r4, "detector");
            PreviewContainerView r0 = this.a;
            int r1 = PreviewContainerView.x;
            if (r0.d() == true) goto L6;
            return false;
        L6:
            PreviewContainerView.a(this.a, r4.getFocusX(), r4.getFocusY());
            PreviewContainerView r2 = this.a;
            r2.p = r4.getFocusX();
            PreviewContainerView r3 = this.a;
            r3.q = r4.getFocusY();
            return true;
        }
    }

    public static final class c extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ PreviewContainerView a;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            return true;
        }

        public c(PreviewContainerView r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            PreviewContainerView r3 = this.a;
            if (r3.n == false) goto L5;
            return false;
        L5:
            if (r3.d() == false) goto L11;
            this.a.j();
            return true;
        L11:
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            PreviewContainerView r3 = this.a;
            if (r3.n == false) goto L5;
            return false;
        L5:
            if (r3.c() == false) goto L15;
            Function0<Unit> r4 = this.a.l;
            if (r4 == null) goto L14;
            r4.invoke();
            return true;
        L14:
            return true;
        L15:
            return false;
        }
    }

    static {
    }

    public PreviewContainerView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PreviewContainerView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final boolean b() {
        CameraResultViewModel r0 = this.a;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (this.i == true) goto L8;
        return false;
    L8:
        if (r0.shouldEnableMark() == false) goto L10;
        return false;
    L10:
        if (((Boolean) r0.isInCropMode().getValue()).booleanValue() == true) goto L15;
        return true;
    L15:
        return false;
    }

    public final boolean c() {
        CameraResultViewModel r0 = this.a;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (this.i == true) goto L8;
        return false;
    L8:
        if (CameraResultViewModel.shouldUseUnifiedPreviewFramework$default(r0, null, 1, null) == true) goto L10;
        return false;
    L10:
        if (((Boolean) r0.isInMarkSelectMode().getValue()).booleanValue() == false) goto L12;
        return false;
    L12:
        if (((Boolean) r0.isInCropMode().getValue()).booleanValue() == true) goto L18;
        return true;
    L18:
        return false;
    }

    public final boolean d() {
        CameraResultViewModel r0 = this.a;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (c() == true) goto L8;
        return false;
    L8:
        if (r0.currentPreviewIsVideo() == false) goto L10;
        return false;
    L10:
        if (r0.currentPreviewIsGif() == true) goto L15;
        return true;
    L15:
        return false;
    }

    public final void e() {
        LarusLayoutPreviewContainerBinding r0 = this.d;
        if (r0 == null) goto L9;
        FrameLayout r1 = r0.d;
        if (r1 == null) goto L10;
        float r2 = this.o - 1.0f;
        float r3 = -r2;
        float r4 = (r1.getWidth() - r1.getPivotX()) * r3;
        float r5 = r1.getPivotX() * r2;
        float r6 = r3 * (r1.getHeight() - r1.getPivotY());
        float r7 = r2 * r1.getPivotY();
        r1.setTranslationX(RangesKt.coerceIn(r1.getTranslationX(), r4, r5));
        r1.setTranslationY(RangesKt.coerceIn(r1.getTranslationY(), r6, r7));
        return;
    L10:
        return;
    }

    public final boolean i() {
        CameraResultViewModel r0 = this.a;
        if (r0 == null) goto L7;
        i1<nx8.m> r1 = r0.getEduImageAbility();
        if (r1 == null) goto L7;
        nx8.m r2 = (nx8.m) r1.getValue();
    L8:
        if (r2 == null) goto L10;
        return true;
    L10:
        return false;
    L7:
        r2 = null;
        goto L8
    }

    public final void j() {
        this.o = 1.0f;
        LarusLayoutPreviewContainerBinding r1 = this.d;
        if (r1 == null) goto L8;
        FrameLayout r2 = r1.d;
        if (r2 == null) goto L9;
        r2.setScaleX(1.0f);
        r2.setScaleY(1.0f);
        r2.setTranslationX(0.0f);
        r2.setTranslationY(0.0f);
        return;
    L9:
        return;
    }

    public final void k() {
        if (this.c != null) goto L5;
        return;
    L5:
        com.larus.camera.impl.ui.viewmodel.t r0 = com.larus.camera.impl.ui.viewmodel.t.a;
        List r1 = com.larus.camera.impl.ui.viewmodel.t.f();
        ResultPreviewFragmentAdapter r2 = this.b;
        if (r2 == null) goto L9;
        List<ResultDisplayParam> r3 = r2.b;
        if (r3 == null) goto L9;
    L10:
        FLogger.a.i("PreviewContainerView", "[updatePreviewListFromMultiResult] list:" + r1.size() + " currentDisplayList:" + r3.size());
        ArrayList r4 = new ArrayList();
        Iterator r5 = r1.iterator();
    L11:
        int r6 = 0;
        if (r5.hasNext() == false) goto L24;
        Object r7 = r5.next();
        OutputParam r8 = (OutputParam) r7;
        Iterator<T> r9 = r3.iterator();
    L15:
        if (r9.hasNext() == false) goto L19;
        Object r10 = r9.next();
        String r11 = ((ResultDisplayParam) r10).getOutputKey();
        com.larus.camera.impl.ui.viewmodel.t r12 = com.larus.camera.impl.ui.viewmodel.t.a;
        if (Intrinsics.areEqual(r11, com.larus.camera.impl.ui.viewmodel.t.g(r8)) == false) goto L15;
    L20:
        if (r10 != null) goto L22;
        r6 = 1;
    L22:
        if (r6 == 0) goto L11;
        r4.add(r7);
        goto L11
    L19:
        r10 = null;
        goto L20
    L24:
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r14 = r4.iterator();
    L26:
        if (r14.hasNext() == false) goto L31;
        Object r15 = r14.next();
        int r16 = r6 + 1;
        if (r6 >= 0) goto L30;
        CollectionsKt.throwIndexOverflow();
    L30:
        OutputParam r17 = (OutputParam) r15;
        String r18 = r17.getPath();
        OutputParam.ResultType r19 = r17.getResultType();
        com.larus.camera.impl.ui.viewmodel.t r20 = com.larus.camera.impl.ui.viewmodel.t.a;
        r13.add(new ResultDisplayParam(r18, r19, com.larus.camera.impl.ui.viewmodel.t.g(r17), r6));
        r6 = r16;
        goto L26
    L31:
        FLogger.a.i("PreviewContainerView", "[updatePreviewListFromMultiResult] finalList:" + r13);
        ResultPreviewFragmentAdapter r21 = this.b;
        if (r21 == null) goto L51;
        Intrinsics.checkNotNullParameter(r13, "addList");
        Iterator r22 = r13.iterator();
    L35:
        if (r22.hasNext() == false) goto L37;
        ResultDisplayParam r23 = (ResultDisplayParam) r22.next();
        ((ArrayList) r21.c).add(r21.z2(r23));
        goto L35
    L37:
        r21.b.addAll(r13);
        r21.notifyItemRangeInserted(r21.b.size() - r13.size(), r13.size());
        return;
    L51:
        return;
    L9:
        r3 = CollectionsKt.emptyList();
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (r2.getActionMasked() != 0) goto L5;
        this.n = this.m;
    L5:
        this.v.onTouchEvent(r2);
        return super.dispatchTouchEvent(r2);
    }

    public final void f(MotionEvent r7) {
        int r0 = r7.getActionMasked();
        if (this.s == r7.getEventTime()) goto L5;
    L7:
        this.s = r7.getEventTime();
        this.t = r0;
        this.u.onTouchEvent(r7);
        return;
    L5:
        if (this.t != r0) goto L7;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        boolean r1 = true;
        if (d() == false) goto L5;
        f(r5);
        int r0 = r5.getActionMasked();
        if (r0 != 0) goto L15;
        this.p = r5.getX();
        this.q = r5.getY();
        if (this.o > 1.0f) goto L26;
        r1 = false;
    L26:
        this.r = r1;
    L28:
        return this.r;
    L15:
        if (r0 != 2) goto L28;
        if (this.u.isInProgress() == false) goto L20;
    L21:
        this.r = true;
        goto L28
    L20:
        if (this.o <= 1.0f) goto L28;
    L5:
        if (this.o == 1.0f) goto L8;
        r1 = false;
    L8:
        if (r1 == true) goto L10;
        j();
    L10:
        this.r = false;
        return false;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        if (d() == false) goto L5;
        f(r7);
        int r0 = r7.getActionMasked();
        if (r0 == 0) goto L39;
        int r2 = 0;
        if (r0 == 1) goto L36;
        if (r0 == 2) goto L25;
        if (r0 == 3) goto L36;
        if (r0 == 6) goto L18;
    L40:
        return true;
    L18:
        if (r7.getPointerCount() < 2) goto L40;
        if (r7.getActionIndex() != 0) goto L23;
        r2 = 1;
    L23:
        this.p = r7.getX(r2);
        this.q = r7.getY(r2);
        goto L40
    L25:
        if (this.u.isInProgress() == true) goto L40;
        if (this.o <= 1.0f) goto L40;
        LarusLayoutPreviewContainerBinding r1 = this.d;
        if (r1 == null) goto L33;
        FrameLayout r3 = r1.d;
        if (r3 == null) goto L33;
        r3.setTranslationX(r3.getTranslationX() + (r7.getX() - this.p));
        r3.setTranslationY(r3.getTranslationY() + (r7.getY() - this.q));
    L33:
        this.p = r7.getX();
        this.q = r7.getY();
        e();
        return true;
    L36:
        if (this.o > 1.0f) goto L38;
        j();
    L38:
        this.r = false;
        goto L40
    L39:
        this.p = r7.getX();
        this.q = r7.getY();
        goto L40
    L5:
        return super.onTouchEvent(r7);
    }

    public final void setRawBitmap(Bitmap r5) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[setRawBitmap] bitmap:");
        Integer r2 = null;
        if (r5 == null) goto L5;
        Integer r3 = Integer.valueOf(r5.getWidth());
    L6:
        r1.append(r3);
        r1.append('x');
        if (r5 == null) goto L9;
        r2 = Integer.valueOf(r5.getHeight());
    L9:
        r1.append(r2);
        r0.i("PreviewContainerView", r1.toString());
        LarusLayoutPreviewContainerBinding r4 = this.d;
        if (r4 == null) goto L15;
        MarkableImageView r6 = r4.b;
        if (r6 == null) goto L16;
        r6.setRawBitmap(r5);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void setUnifiedPreviewEnabled(boolean r3) {
        this.i = r3;
        boolean r0 = !r3;
        setClipChildren(r0);
        setClipToPadding(r0);
        LarusLayoutPreviewContainerBinding r1 = this.d;
        if (r1 == null) goto L7;
        FrameLayout r2 = r1.d;
        if (r2 == null) goto L7;
        r2.setClipChildren(r0);
        r2.setClipToPadding(r0);
    L7:
        ViewPager2 r4 = this.c;
        if (r4 == null) goto L10;
        r4.setUserInputEnabled(b());
    L10:
        if (r3 == true) goto L13;
        j();
        return;
    }

    public final void h(o0 r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r14, "previewBitmapState");
        FLogger r0 = FLogger.a;
        r0.i("PreviewContainerView", "[initData] supportMarkable:" + r15 + " viewPager:" + this.c + " hasInit:" + this.g);
        if (this.g == true) goto L6;
        this.h = r14;
        return;
    L6:
        Fragment r4 = null;
        if (this.c == null) goto L95;
        OutputParam r16 = r14.b;
        CameraResultViewModel r1 = this.a;
        if (r1 == null) goto L11;
        Fragment r2 = r1.requireFragment();
    L13:
        if ((r2 instanceof CameraResultFragment) == false) goto L15;
        CameraResultFragment r3 = (CameraResultFragment) r2;
    L16:
        if (r3 != null) goto L21;
        StringBuilder r17 = new StringBuilder("[setupViewPager] fragment is null ");
        CameraResultViewModel r18 = this.a;
        if (r18 == null) goto L20;
        r4 = r18.requireFragment();
    L20:
        r17.append(r4);
        r17.append(" viewModel:");
        r17.append(this.a);
        r0.e("PreviewContainerView", r17.toString());
        return;
    L21:
        com.larus.camera.impl.ui.viewmodel.t r5 = com.larus.camera.impl.ui.viewmodel.t.a;
        List r6 = com.larus.camera.impl.ui.viewmodel.t.f();
        r0.i("PreviewContainerView", "[setupViewPager] size :" + r6.size());
        ArrayList r7 = new ArrayList();
        Iterator r8 = r6.iterator();
    L22:
        boolean r9 = true;
        if (r8.hasNext() == false) goto L34;
        Object r10 = r8.next();
        OutputParam r11 = (OutputParam) r10;
        if (r11.isVideo() == false) goto L27;
    L32:
        if (r9 == false) goto L22;
        r7.add(r10);
        goto L22
    L27:
        if (u.a(r11) == true) goto L32;
        com.larus.camera.impl.ui.viewmodel.t r12 = com.larus.camera.impl.ui.viewmodel.t.a;
        if (com.larus.camera.impl.ui.viewmodel.t.c(r11) != null) goto L32;
        r9 = false;
        goto L32
    L34:
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r19 = r7.iterator();
        int r20 = 0;
    L36:
        if (r19.hasNext() == false) goto L41;
        Object r21 = r19.next();
        int r22 = r20 + 1;
        if (r20 >= 0) goto L40;
        CollectionsKt.throwIndexOverflow();
    L40:
        OutputParam r23 = (OutputParam) r21;
        String r110 = r23.getPath();
        OutputParam.ResultType r111 = r23.getResultType();
        com.larus.camera.impl.ui.viewmodel.t r112 = com.larus.camera.impl.ui.viewmodel.t.a;
        r13.add(new ResultDisplayParam(r110, r111, com.larus.camera.impl.ui.viewmodel.t.g(r23), r20));
        r20 = r22;
        goto L36
    L41:
        List r24 = CollectionsKt.toMutableList(r13);
        if (r24.size() != 0) goto L56;
        if (r16 == null) goto L45;
        String r25 = r16.getPath();
    L46:
        com.larus.camera.impl.ui.viewmodel.t r26 = com.larus.camera.impl.ui.viewmodel.t.a;
        if (r16 != null) goto L49;
        OutputParam r27 = new OutputParam();
    L50:
        String r28 = com.larus.camera.impl.ui.viewmodel.t.g(r27);
        if (r16 == null) goto L54;
        OutputParam.ResultType r113 = r16.getResultType();
        if (r113 == null) goto L54;
    L55:
        r24.add(new ResultDisplayParam(r25, r113, r28, 0));
    L54:
        r113 = OutputParam.ResultType.PHOTO;
        goto L55
    L49:
        r27 = r16;
        goto L50
    L45:
        r25 = null;
    L56:
        ResultPreviewFragmentAdapter r114 = new ResultPreviewFragmentAdapter(r3, r15, r24);
        this.b = r114;
        ViewPager2 r115 = this.c;
        if (r115 == null) goto L59;
        r115.setAdapter(r114);
    L59:
        ViewPager2 r116 = this.c;
        if (r116 == null) goto L63;
        r116.registerOnPageChangeCallback(new PreviewContainerView$setupViewPager$1(this));
    L63:
        if ((!r24.isEmpty()) == false) goto L209;
        CameraResultViewModel r117 = this.a;
        if (r117 == null) goto L69;
        OutputParam r118 = r117.getInitialCaptureOutputParam();
        if (r118 == null) goto L69;
        com.larus.camera.impl.ui.viewmodel.t r119 = com.larus.camera.impl.ui.viewmodel.t.a;
        String r120 = com.larus.camera.impl.ui.viewmodel.t.g(r118);
    L70:
        if (r120 == null) goto L88;
        Iterator r121 = r24.iterator();
        int r29 = 0;
    L73:
        if (r121.hasNext() == false) goto L78;
        if (Intrinsics.areEqual(((ResultDisplayParam) r121.next()).getOutputKey(), r120) == true) goto L79;
        r29 = r29 + 1;
    L79:
        Integer r122 = Integer.valueOf(r29);
        if (r122.intValue() >= 0) goto L83;
        r9 = false;
    L83:
        if (r9 == true) goto L86;
        r122 = null;
    L86:
        if (r122 == null) goto L88;
        int r123 = r122.intValue();
    L89:
        ViewPager2 r124 = this.c;
        if (r124 != null) goto L92;
        return;
    L92:
        if (r124.getCurrentItem() == r123) goto L94;
        this.j = Integer.valueOf(r123);
        r124.setCurrentItem(r123, false);
        return;
    L94:
        this.j = null;
        return;
    L78:
        r29 = -1;
    L88:
        r123 = CollectionsKt.getLastIndex(r24);
    L69:
        r120 = null;
        goto L70
    L209:
        return;
    L15:
        r3 = null;
        goto L16
    L11:
        r2 = null;
        goto L13
    L95:
        r0.i("PreviewContainerView", "[setupImageView] supportMarkable:" + r15 + " previewBitmap:" + r14.a);
        CameraResultViewModel r30 = this.a;
        if (r30 == null) goto L217;
        CoroutineScope r31 = this.f;
        if (r31 == null) goto L218;
        OutputParam r32 = r14.b;
        Bitmap r125 = r14.a;
        if (u.a(r32) == false) goto L129;
        if (r32 == null) goto L213;
        String r126 = r32.getPath();
        if (r126 == null) goto L214;
        LarusLayoutPreviewContainerBinding r127 = this.d;
        if (r127 == null) goto L111;
        SimpleDraweeView r128 = r127.c;
        if (r128 == null) goto L111;
        e1.x(r128);
    L111:
        LarusLayoutPreviewContainerBinding r129 = this.d;
        if (r129 == null) goto L116;
        AppCompatImageView r130 = r129.b;
        if (r130 == null) goto L116;
        e1.o(r130);
    L116:
        LarusLayoutPreviewContainerBinding r131 = this.d;
        if (r131 == null) goto L128;
        final SimpleDraweeView r132 = r131.c;
        if (r132 == null) goto L128;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L122
        Object r133 = Result.constructor-impl(Uri.fromFile(new PolarisFileWrapper(r126)));     // Catch: Throwable -> L122
    L125:
        if (Result.isFailure-impl(r133) == false) goto L127;
        r133 = null;
    L127:
        final Uri r34 = (Uri) r133;
        ImageLoaderKt.x(r132, r34, null, null, new q(r132, r34), 6);
        r132.post(new r(this, r132));
    L122:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r133 = Result.constructor-impl(ResultKt.createFailure(th));
    L128:
        r30.setIsPhotoEditable(false);
        r30.setRedoEnabled(false);
        r30.setUndoEnabled(false);
        r30.setInDrawingMode(false);
        r30.setInCropMode(false);
        r30.setMarkedImageGetter(null);
        return;
    L214:
        return;
    L213:
        return;
    L129:
        if (r125 == null) goto L219;
        if (r15 == false) goto L174;
        LarusLayoutPreviewContainerBinding r134 = this.d;
        if (r134 == null) goto L137;
        SimpleDraweeView r135 = r134.c;
        if (r135 == null) goto L137;
        e1.o(r135);
    L137:
        LarusLayoutPreviewContainerBinding r136 = this.d;
        if (r136 == null) goto L142;
        SimpleDraweeView r137 = r136.c;
        if (r137 == null) goto L142;
        ImageLoaderKt.b(r137);
    L142:
        LarusLayoutPreviewContainerBinding r138 = this.d;
        if (r138 == null) goto L148;
        AppCompatImageView r139 = r138.b;
        if (r139 == null) goto L148;
        e1.x(r139);
    L148:
        if (i() == false) goto L150;
    L151:
        LarusLayoutPreviewContainerBinding r140 = this.d;
        if (r140 == null) goto L156;
        MarkableImageView r141 = r140.b;
        if (r141 == null) goto L156;
        r141.setMarkEnabled(false);
    L156:
        LarusLayoutPreviewContainerBinding r142 = this.d;
        if (r142 == null) goto L162;
        MarkableImageView r143 = r142.b;
        if (r143 == null) goto L162;
        r143.setImageBitmap(r125);
    L162:
        if (r30.shouldUseMarkSelectMode() == false) goto L173;
        LarusLayoutPreviewContainerBinding r144 = this.d;
        if (r144 == null) goto L173;
        MarkableImageView r145 = r144.b;
        if (r145 == null) goto L173;
        if (r32 == null) goto L171;
        ImageParam r146 = r32.getImageParam();
        if (r146 == null) goto L171;
        Bitmap r147 = r146.getMarkedMaskBitmap();
    L172:
        r145.setPathBitmap(r147);
    L171:
        r147 = null;
    L173:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r30.isImageCropped(), new PreviewContainerView$setupImageView$3(r30, this, null)), r31);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r30.getCurrentBitmap(), new PreviewContainerView$setupImageView$4(this, r30, null)), r31);
        r30.setMarkedImageGetter(new m(this));
        r30.setRawMarkedImageGetter(new n(this));
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r30.getRawBaseBitmap(), new PreviewContainerView$setupImageView$7(this, null)), r31);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r30.isInMarkSelectMode(), new PreviewContainerView$setupImageView$8(this, r30, null)), r31);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r30.getClearMarkSelectDrawing(), new PreviewContainerView$setupImageView$9(this, null)), r31);
        final a1 r148 = com.larus.camera.impl.utils.eventbus.c.b;
        Flow<Object> r149 = new PreviewContainerView$setupImageView$$inlined$subscribe$1(r148);
        g1.a.getClass();
        h1 r36 = g1.a.b;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(kotlinx.coroutines.flow.e.D(r149, r31, r36, 0), new PreviewContainerView$setupImageView$$inlined$subscribe$2(null, r30, this)), r31);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(kotlinx.coroutines.flow.e.D(new PreviewContainerView$setupImageView$$inlined$subscribe$3(r148), r31, r36, 0), new PreviewContainerView$setupImageView$$inlined$subscribe$4(null, r30, this)), r31);
        return;
    L150:
        if (r30.shouldEnableMark() == true) goto L156;
    L174:
        LarusLayoutPreviewContainerBinding r150 = this.d;
        if (r150 == null) goto L179;
        AppCompatImageView r151 = r150.b;
        if (r151 == null) goto L179;
        e1.o(r151);
    L179:
        LarusLayoutPreviewContainerBinding r152 = this.d;
        if (r152 == null) goto L184;
        SimpleDraweeView r153 = r152.c;
        if (r153 == null) goto L184;
        e1.x(r153);
    L184:
        LarusLayoutPreviewContainerBinding r154 = this.d;
        if (r154 == null) goto L189;
        SimpleDraweeView r155 = r154.c;
        if (r155 == null) goto L189;
        ImageLoaderKt.b(r155);
    L189:
        LarusLayoutPreviewContainerBinding r156 = this.d;
        if (r156 == null) goto L194;
        SimpleDraweeView r157 = r156.c;
        if (r157 == null) goto L194;
        r157.setImageBitmap(r125);
    L194:
        BuildersKt.launch$default(r31, null, null, new PreviewContainerView$setupImageView$12(r30, this, r125, null), 3, null);
        return;
    L219:
        return;
    L218:
        return;
    }

    public PreviewContainerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.e = zx8.b.b();
        this.o = 1.0f;
        this.s = Long.MIN_VALUE;
        this.t = -1;
        this.u = new ScaleGestureDetector(r2, new b(this));
        this.v = new GestureDetector(r2, new c(this));
        LayoutInflater.from(r2).inflate(2131562863, this);
        int r5 = 2131379545;
        MarkableImageView r6 = (MarkableImageView) ViewBindings.findChildViewById(this, 2131379545);
        if (r6 == null) goto L11;
        r5 = 2131382921;
        SimpleDraweeView r7 = ViewBindings.findChildViewById(this, 2131382921);
        if (r7 == null) goto L11;
        r5 = 2131382994;
        FrameLayout r0 = (FrameLayout) ViewBindings.findChildViewById(this, 2131382994);
        if (r0 == null) goto L11;
        this.d = new LarusLayoutPreviewContainerBinding(this, r6, r7, r0);
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }

    public static final void a(PreviewContainerView r5, float r6, float r7) {
        LarusLayoutPreviewContainerBinding r0 = r5.d;
        if (r0 == null) goto L12;
        FrameLayout r1 = r0.d;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r5.o <= 1.0f) goto L10;
        r1.setTranslationX(r1.getTranslationX() + ((r5.o - 1.0f) * (r6 - r1.getPivotX())));
        r1.setTranslationY(r1.getTranslationY() + ((r5.o - 1.0f) * (r7 - r1.getPivotY())));
    L10:
        r1.setPivotX(r6);
        r1.setPivotY(r7);
        r5.e();
        return;
    }

    public /* synthetic */ PreviewContainerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Type inference failed for: r13v10, types: [android.view.View, android.widget.ImageView, com.larus.bmhome.view.markableview.MarkableImageView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void g(CameraResultViewModel r9, int r10, CoroutineScope r11, Function2<? super OutputParam, ? super Integer, Unit> r12, Function0<Unit> r13) {
        Intrinsics.checkNotNullParameter(r9, "viewModel");
        Intrinsics.checkNotNullParameter(r11, "scope");
        Intrinsics.checkNotNullParameter(r12, "onUserPageSelected");
        Intrinsics.checkNotNullParameter(r13, "onMediaClick");
        FLogger r0 = FLogger.a;
        r0.i("PreviewContainerView", "[init] bottomHeight:" + r10 + ", supportVideo:" + this.e);
        this.g = true;
        this.a = r9;
        this.f = r11;
        this.k = r12;
        this.l = r13;
        final a1 r14 = com.larus.camera.impl.utils.eventbus.c.b;
        Flow<Object> r15 = new PreviewContainerView$init$$inlined$subscribe$1(r14);
        g1.a.getClass();
        h1 r3 = g1.a.b;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(kotlinx.coroutines.flow.e.D(r15, r11, r3, 0), new PreviewContainerView$init$$inlined$subscribe$2(null, this)), r11);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(kotlinx.coroutines.flow.e.D(new PreviewContainerView$init$$inlined$subscribe$3(r14), r11, r3, 0), new PreviewContainerView$init$$inlined$subscribe$4(null, this)), r11);
        if (this.e == false) goto L5;
    L12:
        boolean r16 = true;
    L13:
        if (r16 == false) goto L61;
        LarusLayoutPreviewContainerBinding r17 = this.d;
        if (r17 == null) goto L19;
        SimpleDraweeView r18 = r17.c;
        if (r18 == null) goto L19;
        e1.o(r18);
    L19:
        LarusLayoutPreviewContainerBinding r19 = this.d;
        if (r19 == null) goto L24;
        SimpleDraweeView r110 = r19.c;
        if (r110 == null) goto L24;
        ImageLoaderKt.b(r110);
    L24:
        LarusLayoutPreviewContainerBinding r111 = this.d;
        if (r111 == null) goto L29;
        AppCompatImageView r112 = r111.b;
        if (r112 == null) goto L29;
        e1.o(r112);
    L29:
        int r113 = m0.a;
        int r114 = m0.b(getContext());
        int r115 = m0.a(getContext());
        i0.a.getClass();
        int r116 = ((r115 - i0.g()) - r10) - getContext().getResources().getDimensionPixelSize(2131166622);
        int r117 = (r114 * 4) / 3;
        r0.i("PreviewContainerView", "[initViewPager] originWidth:" + r114 + ", originHeight:" + r116 + ", targetHeight:" + r117);
        if (r117 > r116) goto L32;
        r116 = r117;
    L33:
        r0.i("PreviewContainerView", "[initViewPager] width:" + r114 + ", height:" + r116);
        FrameLayout.LayoutParams r118 = new FrameLayout.LayoutParams(r114, r116, 17);
        CameraResultViewModel r119 = this.a;
        if (r119 != null) goto L36;
    L38:
        boolean r120 = false;
    L39:
        if (r120 == false) goto L41;
        this.w = new FrameLayout.LayoutParams(r118);
    L41:
        ViewPager2 r121 = new ViewPager2(getContext());
        if (r120 == false) goto L44;
        r118 = new FrameLayout.LayoutParams(-1, -1, 17);
    L44:
        r121.setLayoutParams(r118);
        r121.setUserInputEnabled(b());
        r121.setOffscreenPageLimit(1);
        r121.setOrientation(0);
        Field r122 = ViewPager2.class.getDeclaredField("mRecyclerView");     // Catch: Exception -> L54
        r122.setAccessible(true);     // Catch: Exception -> L54
        Object r123 = r122.get(r121);     // Catch: Exception -> L54
        if ((r123 instanceof RecyclerView) == false) goto L48;
        RecyclerView r124 = (RecyclerView) r123;     // Catch: Exception -> L54
    L49:
        if (r124 == null) goto L51;
        r124.setItemAnimator(null);     // Catch: Exception -> L54
    L51:
        if (r124 == null) goto L56;
        r124.setOverScrollMode(2);     // Catch: Exception -> L54
    L56:
        this.c = r121;
        LarusLayoutPreviewContainerBinding r125 = this.d;
        if (r125 == null) goto L108;
        FrameLayout r126 = r125.d;
        if (r126 == null) goto L108;
        r126.addView(r121);
    L108:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(new v0(r9.isInMarkSelectMode(), r9.isInCropMode(), new PreviewContainerView$init$3(null)), new PreviewContainerView$init$4(this, null)), r11);
        o0 r127 = this.h;
        if (r127 == null) goto L114;
        h(r127, r9.resultSupportMark());
        this.h = null;
        return;
    L114:
        return;
    L48:
        r124 = null;
    L54:
        e = move-exception;
        FLogger.a.e("PreviewContainerView", "Failed to disable ViewPager2 animations: " + e.getMessage());
        goto L56
    L36:
        if (r119.shouldUseUnifiedMediaCanvas() != true) goto L38;
        r120 = true;
        goto L39
    L32:
        r114 = (r116 * 3) / 4;
        goto L33
    L61:
        final CameraResultViewModel r128 = this.a;
        if (r128 == null) goto L108;
        CoroutineScope r129 = this.f;
        if (r129 == null) goto L108;
        if (r128.resultSupportMark() == false) goto L93;
        LarusLayoutPreviewContainerBinding r130 = this.d;
        if (r130 == null) goto L74;
        SimpleDraweeView r131 = r130.c;
        if (r131 == null) goto L74;
        e1.o(r131);
    L74:
        LarusLayoutPreviewContainerBinding r132 = this.d;
        if (r132 == null) goto L79;
        SimpleDraweeView r133 = r132.c;
        if (r133 == null) goto L79;
        ImageLoaderKt.b(r133);
    L79:
        LarusLayoutPreviewContainerBinding r134 = this.d;
        if (r134 == null) goto L108;
        final ?? r135 = r134.b;
        if (r135 == 0) goto L108;
        e1.x(r135);
        r135.post(new o(r128, r135));
        r135.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r135.setPenColor(ContextCompat.getColor(r135.getContext(), 2131102526));
        r135.setMarkEnabled(r128.shouldEnableMark());
        b1 r1 = r135.o;
        if (r1 == null) goto L86;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r1, new PreviewContainerView$initImage$1$2(r128, null)), r129);
    L86:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r128.isInMarkSelectMode(), new PreviewContainerView$initImage$1$3(this, r135, r128, null)), r129);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r128.getResultDetectionStatus(), new PreviewContainerView$initImage$1$4(r135, r128, null)), r129);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r128.getClearMarkSelectDrawing(), new PreviewContainerView$initImage$1$5(r135, null)), r129);
        i1<Boolean> r2 = r135.getRedoEnabled();
        if (r2 == null) goto L89;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r2, new PreviewContainerView$initImage$1$6(r128, null)), r129);
    L89:
        i1<Boolean> r4 = r135.getUndoEnabled();
        if (r4 == null) goto L92;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r4, new PreviewContainerView$initImage$1$7(r128, null)), r129);
    L92:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r128.getUndoPaint(), new PreviewContainerView$initImage$1$8(r135, null)), r129);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r128.getRedoPaint(), new PreviewContainerView$initImage$1$9(r135, null)), r129);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r128.isInCropMode(), new PreviewContainerView$initImage$1$10(this, null)), r129);
        r135.setOnUserMarkedListener(new s(r128, r135));
        goto L108
    L93:
        LarusLayoutPreviewContainerBinding r136 = this.d;
        if (r136 == null) goto L98;
        SimpleDraweeView r137 = r136.c;
        if (r137 == null) goto L98;
        e1.x(r137);
    L98:
        LarusLayoutPreviewContainerBinding r138 = this.d;
        if (r138 == null) goto L103;
        final SimpleDraweeView r139 = r138.c;
        if (r139 == null) goto L103;
        r139.post(new p(r128, r139));
    L103:
        LarusLayoutPreviewContainerBinding r140 = this.d;
        if (r140 == null) goto L108;
        AppCompatImageView r141 = r140.b;
        if (r141 == null) goto L108;
        e1.o(r141);
        goto L108
    L5:
        if (this.i == true) goto L7;
    L11:
        r16 = false;
        goto L13
    L7:
        if (r9.isMultiCaptureEnabled() == true) goto L12;
        if (r9.isMultiResultFromCamera() == false) goto L11;
        goto L11
    }
}

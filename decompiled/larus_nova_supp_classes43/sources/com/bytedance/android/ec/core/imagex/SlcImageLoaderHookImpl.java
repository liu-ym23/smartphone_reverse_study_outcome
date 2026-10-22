package com.bytedance.android.ec.core.imagex;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bytedance.android.ec.core.imagex.common.ProxyRequestListener;
import com.bytedance.android.ec.core.imagex.common.TaskMergeManager;
import com.bytedance.android.ec.core.imagex.opt.DomainPreConnect;
import com.bytedance.android.ec.core.imagex.opt.ECImageMultiSizeReuseOpt;
import com.bytedance.android.ec.core.imagex.opt.ECImageRequestBuilderCacheForSlc;
import com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.SlcImageFetchManager;
import com.bytedance.android.ecom.arch.slice.render.widget.fresco.SlcPipelineDraweeControllerBuilder;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.DefaultDrawableFactory;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class SlcImageLoaderHookImpl extends p {
    public static DrawableFactory a;
    public static WeakReference<Drawable> b;
    public static final Lazy c = null;
    public static final SlcImageLoaderHookImpl d = null;

    public static final class a extends BaseControllerListener<ImageInfo> {
        public ImageRequest a;
        public final com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.a b;
        public final Object c;

        public a(com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.a r10, r r11) {
            Intrinsics.checkNotNullParameter(r10, "callback");
            this.b = r10;
            this.c = r11;
        }

        public final void onFailure(String r1, Throwable r10) {
            this.b.onFailure(r10);
        }

        public final void onFinalImageSet(String r10, Object r11, Animatable r12, ImageRequest r13, Map r14) {
            ImageInfo r15 = (ImageInfo) r11;
            ImageRequest r16 = null;
            if (r14 == null) goto L5;
            Object r17 = r14.get("image");
        L7:
            if ((r17 instanceof CloseableReference) == true) goto L9;
            r17 = null;
        L9:
            CloseableReference r18 = (CloseableReference) r17;
            if (r18 != null) goto L12;
            nq.a.c(null, SlcImageLoaderHookImpl$SlcControllerListener$onFinalImageSet$1.INSTANCE, 1);
            return;
        L12:
            com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.a r0 = this.b;
            boolean r1 = r12 instanceof Drawable;
            Object r19 = r12;
            if (r1 == true) goto L15;
            r19 = null;
        L15:
            r0.d(r18, (Drawable) r19);
            int r20 = d0.a;
            if (r13 != null) goto L22;
            Object r21 = this.c;
            if ((r21 instanceof u) == true) goto L20;
        L23:
            d0.a(r15, r16, this.c);
            return;
        L20:
            if (((u) r21).F == true) goto L23;
            r13 = this.a;
        L22:
            r16 = r13;
            goto L23
        L5:
            r17 = null;
            goto L7
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ r a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ q c;
        public final /* synthetic */ com.bytedance.android.ecom.arch.slice.render.widget.fresco.e d;
        public final /* synthetic */ ImageRequest e;
        public final /* synthetic */ a f;

        public b(r r1, Ref.ObjectRef r10, q r11, com.bytedance.android.ecom.arch.slice.render.widget.fresco.e r12, ImageRequest r13, a r14) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
        }

        public final void a() {
            this.b.element = (ImageRequest[]) ImageExtensionsKt.J(this.a, (ImageRequest[]) this.b.element, null).component1();
            r r1 = this.a;
            if ((r1 instanceof u) == true) goto L5;
            r1 = null;
        L5:
            u r10 = (u) r1;
            if (r10 == null) goto L8;
            r10.x = System.nanoTime();
        L8:
            SlcPipelineDraweeControllerBuilder r11 = this.c.b();
            com.bytedance.android.ecom.arch.slice.render.widget.fresco.h r12 = this.c.getController();
            r11.b();
            r11.g = this.c.a();
            r11.h = r12;
            com.bytedance.android.ecom.arch.slice.render.widget.fresco.e r13 = this.d;
            boolean r14 = nq.a.a;
            if (r13 == null) goto L11;
            boolean r15 = true;
        L12:
            nq.a.d(r15, null, null);
            r11.i = r13;
            r11.b = this.a;
            ImageRequest[] r16 = (ImageRequest[]) this.b.element;
            if (r16.length <= 1) goto L15;
            r11.e = r16;
        L16:
            ImageRequest r17 = this.e;
            if (r17 == null) goto L19;
            r11.d = r17;
        L19:
            r11.f = this.f;
            this.c.c(r11.a());
            r r18 = this.a;
            if ((r18 instanceof u) == true) goto L22;
            r18 = null;
        L22:
            u r19 = (u) r18;
            if (r19 == null) goto L46;
            long r20 = System.nanoTime();
            long r21 = r19.w;
            long r110 = r19.x;
            if (r21 <= r110) goto L28;
        L44:
            r19.t = -1;
            r19.u = -1;
            r19.v = -1;
            r19.w = -1;
            r19.x = -1;
            return;
        L28:
            if (r20 < r110) goto L44;
            long r111 = r19.v;
            if (r21 < r111) goto L44;
            long r112 = r19.u;
            if (r111 < r112) goto L44;
            long r22 = r19.t;
            if (r112 < r22) goto L44;
            Long r23 = Long.valueOf(((r20 - r110) + (r21 - r111)) + (r112 - r22));
            if (r23.longValue() <= 0) goto L38;
            boolean r24 = true;
        L39:
            if (r24 == true) goto L42;
            r23 = null;
        L42:
            if (r23 == null) goto L44;
            r19.f("ec_slice_local_duration", Double.valueOf(r23.longValue() / ((double) 1000000.0f)));
            goto L44
        L38:
            r24 = false;
            goto L39
        L46:
            return;
        L15:
            r11.c = (ImageRequest) ArraysKt.firstOrNull(r16);
            goto L16
        L11:
            r15 = false;
            goto L12
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ Drawable a;
        public final /* synthetic */ com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.a b;
        public final /* synthetic */ CloseableReference c;
        public final /* synthetic */ ImageRequest d;
        public final /* synthetic */ Object e;

        public c(Drawable r1, com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.a r10, CloseableReference r11, ImageRequest r12, Object r13) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
        }

        public final void a() {
            Object r0 = this.a;
            boolean r1 = com.bytedance.android.ecom.arch.slice.render.util.e.a;
            if ((r0 instanceof Animatable) == false) goto L5;
            Animatable r10 = (Animatable) r0;
        L6:
            DrawableFactory r11 = SlcImageLoaderHookImpl.a;
            SlcImageLoaderHookImpl.b = new WeakReference(this.a);
            this.b.d(this.c, this.a);
            if (r10 == null) goto L9;
            r10.start();
        L9:
            int r12 = d0.a;
            d0.a(this.c.get(), this.d, this.e);
            return;
        L5:
            r10 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        d = new SlcImageLoaderHookImpl();
        c = LazyKt.lazy(SlcImageLoaderHookImpl$taskMergeManager$2.INSTANCE);
    }

    public SlcImageLoaderHookImpl() {
    }

    public static void g(Runnable r10) {
        boolean r0 = com.bytedance.android.ecom.arch.slice.render.util.e.a;
        if (ThreadMethodProxy.currentThread().getName().equals("slice-image-request-thread") == false) goto L7;
        r10.run();
        return;
    L7:
        if (((Boolean) TaskMergeManager.e.getValue()).booleanValue() == false) goto L9;
        ((TaskMergeManager) c.getValue()).a(r10);
        return;
    L9:
        com.bytedance.android.ecom.arch.slice.render.util.e.h(r10);
    }

    public static boolean f(CloseableReference r10, ImageRequest r11, Object r12, com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.a r13) {
        DrawableFactory r0 = a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("defaultDrawableFactory");
    L5:
        WeakReference<Drawable> r1 = b;
        if (r1 == null) goto L8;
        Drawable r14 = r1.get();
    L9:
        Drawable r15 = com.bytedance.android.ecom.arch.slice.render.util.e.a(r10, r0, r14);
        if (r15 == null) goto L13;
        c r16 = new c(r15, r13, r10, r11, r12);
        UiThreadImmediateExecutorService.getInstance().execute(r16);
        return true;
    L13:
        return false;
    L8:
        r14 = null;
        goto L9
    }

    @Override // com.bytedance.android.ec.core.imagex.p
    public final boolean d(Uri r18, SlcImageFetchManager r19, com.bytedance.android.ecom.arch.slice.render.widget.fresco.e r20, Object r21, SlcImageFetchManager.a r22, Function1 r23) {
        Intrinsics.checkNotNullParameter(r18, "uri");
        Intrinsics.checkNotNullParameter(r19, "imageManager");
        Intrinsics.checkNotNullParameter(r20, "imageFetchCancelTag");
        Intrinsics.checkNotNullParameter(r22, "callback");
        ImageExperiments.G.getClass();
        if (((Boolean) ImageExperiments.i.getValue()).booleanValue() == true) goto L5;
        return false;
    L5:
        Context r10 = r19.getContext();
        if (a != null) goto L9;
        a = new DefaultDrawableFactory(th.a.e(r10, true).getResources(), Fresco.getImagePipelineFactory().getAnimatedDrawableFactory(th.a.e(r10, true)));
    L9:
        if ((r21 instanceof r) == true) goto L11;
        Object r11 = null;
    L12:
        r r12 = (r) r11;
        KProperty[] r13 = ImageExtensionsKt.a;
        Intrinsics.checkNotNullParameter(r19, "imageFetchManager");
        if (r12 != null) goto L16;
        r12 = t.a(r19.getContext());
    L16:
        if (r12 != null) goto L18;
        r12 = new r("", "");
    L18:
        u r14 = new u(r12);
        r14.A(r19.getContext());
        Intrinsics.checkNotNullParameter(r19, "imageFetchManager");
        Drawable r15 = r19.e();
        if (r15 == null) goto L23;
        Rect r16 = r15.getBounds();
        if (r16 == null) goto L23;
        int r17 = r16.width();
    L24:
        Drawable r24 = r19.e();
        if (r24 == null) goto L29;
        Rect r25 = r24.getBounds();
        if (r25 == null) goto L29;
        int r26 = r25.height();
    L30:
        if (r17 <= 0) goto L33;
        if (r26 <= 0) goto L33;
        r14.j = new Point(r17, r26);
    L33:
        r14.y();
        r14.t = System.nanoTime();
        r14.o = "slice";
        y0 r27 = new y0(r19);
        if (r23 == null) goto L36;
        ImageRequest[] r1 = (ImageRequest[]) r23.invoke(r18);
    L37:
        if (r1 == null) goto L93;
        ImageRequest r28 = (ImageRequest) ArraysKt.firstOrNull(r1);
        if (ImageExtensionsKt.h(r1) != null) goto L59;
        int r29 = ProxyRequestListener.c;
        if (r28 == null) goto L43;
        RequestListener r30 = r28.getRequestListener();
    L45:
        if ((r30 instanceof ProxyRequestListener) == true) goto L47;
        r30 = null;
    L47:
        ProxyRequestListener r31 = (ProxyRequestListener) r30;
        if (r31 == null) goto L50;
        Object r32 = r31.a("tag#ArrayImageRequest");
    L52:
        if ((r32 instanceof ImageRequest[]) == true) goto L54;
        r32 = null;
    L54:
        ImageRequest[] r33 = (ImageRequest[]) r32;
        if (r33 == null) goto L59;
        if (ImageExtensionsKt.h(r33) == null) goto L59;
        r1 = r33;
        goto L59
    L50:
        r32 = null;
        goto L52
    L43:
        r30 = null;
    L59:
        int r34 = ProxyRequestListener.c;
        if (r28 == null) goto L62;
        RequestListener r35 = r28.getRequestListener();
    L64:
        if ((r35 instanceof ProxyRequestListener) == true) goto L66;
        r35 = null;
    L66:
        ProxyRequestListener r36 = (ProxyRequestListener) r35;
        if (r36 == null) goto L69;
        Object r37 = r36.a("tag#LowImageRequest");
    L71:
        if ((r37 instanceof ImageRequest) == true) goto L73;
        r37 = null;
    L73:
        ImageRequest r38 = (ImageRequest) r37;
        ImageRequest r39 = (ImageRequest) ArraysKt.firstOrNull(r1);
        if (r39 == null) goto L76;
        RequestListener r40 = r39.getRequestListener();
    L78:
        if ((r40 instanceof ProxyRequestListener) == true) goto L80;
        r40 = null;
    L80:
        ProxyRequestListener r41 = (ProxyRequestListener) r40;
        if (r41 == null) goto L83;
        Object r42 = r41.a("tag#ImageUrlParser");
    L85:
        if ((r42 instanceof com.bytedance.android.shopping.api.image.r) == true) goto L87;
        r42 = null;
    L87:
        com.bytedance.android.shopping.api.image.r r43 = (com.bytedance.android.shopping.api.image.r) r42;
        if (r43 == null) goto L90;
        r14.z = r43;
        Unit r44 = Unit.INSTANCE;
    L90:
        r14.v = System.nanoTime();
        if (ImageExtensionsKt.h(r1) == null) goto L93;
        e(r1, r38, r27, r14, r20, new a(r22, r14), r22, true);
        boolean r45 = true;
    L94:
        if (r45 == false) goto L96;
        Object r110 = null;
    L146:
        if ((r21 instanceof u) == false) goto L149;
        r110 = r21;
    L149:
        u r0 = (u) r110;
        if (r0 == null) goto L154;
        long r46 = r0.t;
        if (r46 <= 0) goto L154;
        r0.f("ec_local_duration", Float.valueOf(com.bytedance.android.ec.core.imagex.common.e.a(r46)));
    L154:
        return true;
    L96:
        ResizeOptions r47 = r27.e();
        List r48 = CollectionsKt.listOf(r18.toString());
        Lazy r49 = ECImageRequestBuilderCacheForSlc.a;
        Intrinsics.checkNotNullParameter(r48, "urls");
        r110 = null;
        List r50 = CollectionsKt.listOfNotNull(new Object[]{r48, r14, r47, null, null, null, null});
        StringBuilder r51 = new StringBuilder();
        Iterator r52 = r50.iterator();
    L98:
        if (r52.hasNext() == false) goto L131;
        Object r53 = r52.next();
        if ((r53 instanceof com.bytedance.android.ec.core.imagex.opt.x) == false) goto L103;
        r53 = ((com.bytedance.android.ec.core.imagex.opt.x) r53).getCacheKey();
    L105:
        if (r53 != null) goto L108;
        String r54 = "null";
    L125:
        if (r51.length() <= 0) goto L127;
        boolean r55 = true;
    L128:
        if (r55 == false) goto L130;
        r51.append("$");
    L130:
        r51.append(r54);
        goto L98
    L127:
        r55 = false;
        goto L128
    L108:
        if ((r53 instanceof String) == false) goto L111;
        r54 = (String) r53;
        goto L125
    L111:
        if ((r53 instanceof List) == false) goto L123;
        StringBuilder r56 = new StringBuilder();
        Iterator r57 = ((List) r53).iterator();
    L114:
        if (r57.hasNext() == false) goto L122;
        Object r58 = r57.next();
        if (r56.length() <= 0) goto L118;
        boolean r59 = true;
    L119:
        if (r59 == false) goto L121;
        r56.append("#");
    L121:
        r56.append(r58);
        goto L114
    L118:
        r59 = false;
        goto L119
    L122:
        r54 = r56.toString();
        goto L125
    L123:
        r54 = r53.toString();
        goto L125
    L103:
        if ((r53 instanceof Postprocessor) == false) goto L105;
        r53 = ((Postprocessor) r53).getPostprocessorCacheKey();
        goto L105
    L131:
        String r60 = r51.toString();
        Triple r61 = ECImageRequestBuilderCacheForSlc.a(r60);
        if (r61 == null) goto L144;
        com.bytedance.android.shopping.api.image.q r62 = (com.bytedance.android.shopping.api.image.q) r61.component1();
        List r63 = (List) r61.component2();
        ImageRequest r64 = (ImageRequest) r61.component3();
        Object[] r65 = r63.toArray(new ImageRequest[0]);
        if (r65 == null) goto L143;
        ImageRequest[] r66 = (ImageRequest[]) r65;
        u r67 = s.a(r14);
        if (r67 == null) goto L138;
        r67.z = r62;
    L138:
        u r68 = s.a(r14);
        if (r68 == null) goto L141;
        r68.B = r60;
    L141:
        a r69 = new a(r22, r14);
        ImageExperiments.G.getClass();
        e(r66, r64, r27, r14, r20, r69, r22, !((Boolean) ImageExperiments.w.getValue()).booleanValue());
        goto L146
    L143:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L144:
        r14.u = System.nanoTime();
        g(new z0(r14, r48, r47, r60, r27, r20, r22));
        goto L146
    L83:
        r42 = null;
        goto L85
    L76:
        r40 = null;
        goto L78
    L69:
        r37 = null;
        goto L71
    L62:
        r35 = null;
    L93:
        r45 = false;
        goto L94
    L36:
        r1 = null;
    L29:
        r26 = 0;
    L23:
        r17 = 0;
        goto L24
    L11:
        r11 = r21;
        goto L12
    }

    public static void e(ImageRequest[] r17, ImageRequest r18, q r19, r r20, com.bytedance.android.ecom.arch.slice.render.widget.fresco.e r21, a r22, com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.a r23, boolean r24) {
        r r1 = r20;
        Ref.ObjectRef r10 = new Ref.ObjectRef();
        r10.element = r17;
        int r11 = 0;
        if (r17.length != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        return;
    L8:
        boolean r13 = r1 instanceof u;
        Integer r14 = null;
        if (r13 == true) goto L11;
        r r15 = null;
    L12:
        u r16 = (u) r15;
        if (r16 != null) goto L15;
    L18:
        ImageRequest r25 = null;
    L19:
        r22.a = r25;
        if (r24 == false) goto L28;
        ImageExperiments.G.getClass();
        if (((Boolean) ImageExperiments.w.getValue()).booleanValue() == true) goto L28;
        ImageRequest r26 = (ImageRequest) ArraysKt.firstOrNull((ImageRequest[]) r10.element);
        KProperty[] r110 = ImageExtensionsKt.a;
        if (ECImageMultiSizeReuseOpt.e.j() == false) goto L28;
        ECImageMultiSizeReuseOpt.b r27 = ECImageMultiSizeReuseOpt.d(r26, r1, true);
        if (r27 == null) goto L28;
        CloseableStaticBitmap r28 = r27.a;
    L29:
        if (r28 != null) goto L31;
    L40:
        if (r24 == false) goto L87;
        ImageRequest[] r29 = (ImageRequest[]) r10.element;
        ImageExperiments.G.getClass();
        boolean r111 = ((Boolean) ImageExperiments.w.getValue()).booleanValue();
        ImagePipeline r112 = Fresco.getImagePipelineFactory().getImagePipeline();
        if (r111 == true) goto L55;
        int r113 = r29.length;
        int r114 = 0;
    L44:
        if (r114 >= r113) goto L79;
        ImageRequest r115 = r29[r114];
        CacheKey r116 = com.bytedance.android.ecom.arch.slice.render.util.e.e(r115, r112.getCacheKeyFactory(), r1);
        if (r116 != null) goto L48;
    L47:
        boolean r30 = false;
    L52:
        if (r30 == true) goto L53;
        r114 = r114 + 1;
        goto L44
    L53:
        RequestListener r31 = r112.getRequestListenerForRequest(r115, null);
        r31.onRequestStart(r115, r1, "-1", false);
        r31.onRequestSuccess(r115, "-1", false);
    L78:
        boolean r32 = true;
    L80:
        if (r32 == false) goto L87;
        if (r13 == true) goto L83;
        r1 = null;
    L83:
        u r33 = (u) r1;
        if (r33 == null) goto L134;
        r33.z();
        return;
    L134:
        return;
    L48:
        CloseableReference r34 = com.bytedance.android.ecom.arch.slice.render.util.e.f(Fresco.getImagePipelineFactory().getImagePipeline().getBitmapMemoryCache(), r116);
        if (r34 == null) goto L47;
        r30 = f(r34, r115, r1, r23);
    L79:
        r32 = false;
        goto L80
    L55:
        ImageRequest r35 = (ImageRequest) ArraysKt.firstOrNull(r29);
        if (r35 == null) goto L79;
        CacheKey r36 = com.bytedance.android.ecom.arch.slice.render.util.e.e(r35, r112.getCacheKeyFactory(), r1);
        if (r36 != null) goto L61;
    L60:
        boolean r117 = false;
    L65:
        if (r117 == false) goto L67;
        RequestListener r37 = r112.getRequestListenerForRequest(r35, null);
        r37.onRequestStart(r35, r1, "-1", false);
        r37.onRequestSuccess(r35, "-1", false);
        goto L78
    L67:
        KProperty[] r118 = ImageExtensionsKt.a;
        if (ECImageMultiSizeReuseOpt.e.j() == false) goto L72;
        ECImageMultiSizeReuseOpt.b r38 = ECImageMultiSizeReuseOpt.c(r36);
        if (r38 == null) goto L72;
        CloseableStaticBitmap r39 = r38.a;
    L73:
        if (r39 == null) goto L79;
        if (com.bytedance.android.ec.core.imagex.opt.i.a(r39) != true) goto L79;
        if (f(com.bytedance.android.ec.core.imagex.opt.i.b(r39), r35, r1, r23) == false) goto L79;
    L72:
        r39 = null;
        goto L73
    L61:
        CloseableReference r119 = com.bytedance.android.ecom.arch.slice.render.util.e.f(Fresco.getImagePipelineFactory().getImagePipeline().getBitmapMemoryCache(), r36);
        if (r119 == null) goto L60;
        r117 = f(r119, r35, r1, r23);
    L87:
        if (r13 == true) goto L89;
        r r40 = null;
    L90:
        u r41 = (u) r40;
        if (r41 == null) goto L93;
        r41.w = System.nanoTime();
    L93:
        ImageRequest r0 = (ImageRequest) ArraysKt.getOrNull(r17, 0);
        if (r0 == null) goto L96;
        Uri r42 = r0.getSourceUri();
    L97:
        if (r13 == true) goto L99;
        r r43 = null;
    L100:
        u r44 = (u) r43;
        if ((r44 instanceof u) == false) goto L129;
        Drawable r45 = com.bytedance.android.ec.core.imagex.common.d.a;
        if (com.bytedance.android.ec.core.imagex.common.d.a(r42, r44, 1) == false) goto L129;
        ResizeOptions r46 = r44.k;
        if (r46 == null) goto L107;
        Integer r47 = Integer.valueOf(r46.width);
    L113:
        if (r47 == null) goto L115;
        r11 = r47.intValue();
    L115:
        ResizeOptions r48 = r44.k;
        if (r48 == null) goto L118;
        r14 = Integer.valueOf(r48.height);
    L123:
        if (r14 == null) goto L125;
        r14.intValue();
    L125:
        Drawable r49 = com.bytedance.android.ec.core.imagex.common.d.b(th.a.e(r19.getContext(), true), r11);
        if (r49 == null) goto L129;
        r19.d(r49, ScalingUtils.ScaleType.FIT_CENTER);
        goto L129
    L118:
        com.bytedance.android.shopping.api.image.q r50 = com.bytedance.android.ec.core.imagex.opt.s.c(r44);
        if (r50 == null) goto L123;
        com.bytedance.android.shopping.api.image.n r51 = r50.b();
        if (r51 == null) goto L123;
        r14 = r51.getValue();
        goto L123
    L107:
        com.bytedance.android.shopping.api.image.q r52 = com.bytedance.android.ec.core.imagex.opt.s.c(r44);
        if (r52 == null) goto L112;
        com.bytedance.android.shopping.api.image.n r53 = r52.d();
        if (r53 == null) goto L112;
        r47 = r53.getValue();
    L112:
        r47 = null;
    L129:
        DomainPreConnect.c.a(r1);
        g(new b(r20, r10, r19, r21, r18, r22));
        return;
    L99:
        r43 = r1;
        goto L100
    L96:
        r42 = null;
        goto L97
    L89:
        r40 = r1;
        goto L90
    L31:
        if (com.bytedance.android.ec.core.imagex.opt.i.a(r28) != true) goto L40;
        if (f(com.bytedance.android.ec.core.imagex.opt.i.b(r28), (ImageRequest) ArraysKt.firstOrNull((ImageRequest[]) r10.element), r1, r23) == false) goto L40;
        if (r13 == true) goto L36;
        r1 = null;
    L36:
        u r54 = (u) r1;
        if (r54 == null) goto L133;
        r54.z();
        return;
    L133:
        return;
    L28:
        r28 = null;
        goto L29
    L15:
        if (r16.n() == null) goto L18;
        if (r17 == null) goto L18;
        r25 = (ImageRequest) ArraysKt.firstOrNull(r17);
        goto L19
    L11:
        r15 = r1;
        goto L12
    L5:
        r12 = false;
        goto L6
    }
}

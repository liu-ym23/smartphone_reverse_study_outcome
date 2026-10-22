package com.larus.avlink.gallery.view;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.router.SmartRouter;
import com.larus.avlink.gallery.business.MediaLifecycleStateManager;
import com.larus.avlink.gallery.coordinator.MediaSyncCoordinator;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.impl.databinding.LarusItemDoraGDeviceManagementMediaAlbumBinding;
import com.larus.bmhome.bigimg.BigImageLocalPhotoViewerDialog;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.plugin.image4.view.ImageViewWithLastMotion;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class MediaAlbumViewHelper implements w88.u, u98.a {
    public static final /* synthetic */ int r = 0;
    public final Context a;
    public final LifecycleOwner b;
    public final LarusItemDoraGDeviceManagementMediaAlbumBinding c;
    public final Lazy d;
    public final Lazy e;
    public AlbumSyncBanner f;
    public BigImageLocalPhotoViewerDialog g;
    public List<? extends com.larus.bmhome.bigimg.t1> h;
    public final MediaAlbumViewHelper$doralink$1 i;
    public final Lazy j;
    public boolean k;
    public boolean l;
    public volatile boolean m;
    public volatile boolean n;
    public final c0 o;
    public final b p;
    public final MediaAlbumViewHelper$albumNotifyListener$1 q;

    public static final class a {
    }

    public static final class b extends ConnectivityManager.NetworkCallback {
        public final /* synthetic */ MediaAlbumViewHelper a;

        public b(MediaAlbumViewHelper r1) {
            this.a = r1;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onAvailable(Network r2) {
            Intrinsics.checkNotNullParameter(r2, "network");
            super.onAvailable(r2);
            com.larus.avlink.n1.d("MediaAlbumViewHelper", "Network available");
            MediaAlbumViewHelper.a(this.a);
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.gallery.view.MediaAlbumViewHelper$onError$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.gallery.view.MediaAlbumViewHelper$onError$1", f = "MediaAlbumViewHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MediaAlbumViewHelper this$0;

        public C01141(MediaAlbumViewHelper r1, Continuation<? super C01141> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01141(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r2);
            AlbumSyncBanner r3 = this.this$0.f;
            if (r3 == null) goto L8;
            r3.T5(z98.a.n.b);
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    @Override // u98.a
    public final void A10() {
    }

    @Override // u98.a
    public final void Ff() {
    }

    @Override // u98.a
    public final void VD(int r1) {
    }

    @Override // u98.a
    public final void Mv() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.b), Dispatchers.getMain(), null, new MediaAlbumViewHelper$onTransferStarted$1(this, null), 2, null);
    }

    @Override // u98.a
    public final void Po() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.b), Dispatchers.getMain(), null, new MediaAlbumViewHelper$onTransferCompleted$1(this, null), 2, null);
    }

    @Override // u98.a
    public final void V00() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.b), Dispatchers.getMain(), null, new MediaAlbumViewHelper$onLowPower$1(this, null), 2, null);
    }

    @Override // u98.a
    public final void WQ() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.b), Dispatchers.getMain(), null, new MediaAlbumViewHelper$onRecording$1(this, null), 2, null);
    }

    public final void c() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.b), Dispatchers.getIO(), null, new MediaAlbumViewHelper$loadData$1(this, null), 2, null);
    }

    public final void e() {
        if (this.n == true) goto L5;
        return;
    L5:
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L10;
        VisionService r1 = r0.V();
        if (r1 == null) goto L10;
        r1.z(this.q);
    L10:
        this.n = false;
        com.larus.avlink.n1.d("MediaAlbumViewHelper", "unregisterAlbumNotifyListener");
    }

    public final void f() {
        if (this.l == true) goto L5;
        return;
    L5:
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L8;
        r0.q0(this.i);
    L8:
        this.l = false;
    }

    public final void g() {
        if (this.k == true) goto L16;
        return;
    L16:
        ((ConnectivityManager) this.j.getValue()).unregisterNetworkCallback(this.p);     // Catch: Throwable -> L8 RuntimeException -> L10
    L12:
        this.k = false;
        return;
    L10:
        e = move-exception;
        com.larus.avlink.n1.c("MediaAlbumViewHelper", "unregisterNetworkCallback failed", e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        this.k = false;
        throw th;
    }

    public final View getView() {
        return this.c.a;
    }

    public final void onStart() {
        MediaSyncCoordinator r0 = MediaSyncCoordinator.a;
        MediaSyncCoordinator.p(this);
        com.larus.avlink.n1.d("MediaAlbumViewHelper", "MediaSyncCoordinator.registerStateListener in onStart");
        if (this.k == true) goto L11;
        NetworkRequest r1 = new NetworkRequest.Builder().addTransportType(1).build();
        ((ConnectivityManager) this.j.getValue()).registerNetworkCallback(r1, this.p);     // Catch: RuntimeException -> L8
        this.k = true;     // Catch: RuntimeException -> L8
    L8:
        e = move-exception;
        com.larus.avlink.n1.c("MediaAlbumViewHelper", "registerNetworkCallback failed", e);
    L11:
        if (this.l == true) goto L18;
        IDoraService r2 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r2 == null) goto L18;
        r2.G(this.i);
        this.l = true;
    L18:
        if (this.n == true) goto L27;
        IDoraService r3 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r3 == null) goto L27;
        VisionService r4 = r3.V();
        if (r4 == null) goto L27;
        r4.r(this.q);
        this.n = true;
        com.larus.avlink.n1.d("MediaAlbumViewHelper", "registerAlbumNotifyListener");
    L27:
        if (this.m == true) goto L30;
        CopyOnWriteArraySet<com.larus.avlink.gallery.business.c> r5 = com.larus.avlink.gallery.business.a.a;
        com.larus.avlink.gallery.business.a.b(this.o);
        this.m = true;
        com.larus.avlink.n1.d("MediaAlbumViewHelper", "registerAlbumMediaChangeListener");
    L30:
        c();
    }

    public final void onDestroy() {
        g();
        f();
        e();
        if (this.m == false) goto L6;
        CopyOnWriteArraySet<com.larus.avlink.gallery.business.c> r0 = com.larus.avlink.gallery.business.a.a;
        com.larus.avlink.gallery.business.a.c(this.o);
        this.m = false;
        com.larus.avlink.n1.d("MediaAlbumViewHelper", "unregisterAlbumMediaChangeListener");
    L6:
        MediaSyncCoordinator r1 = MediaSyncCoordinator.a;
        MediaSyncCoordinator.x(this);
        this.g = null;
        com.larus.avlink.n1.d("MediaAlbumViewHelper", "MediaSyncCoordinator.unregisterStateListener in onDestroy");
    }

    public final void onStop() {
        g();
        f();
        e();
        if (this.m == false) goto L6;
        CopyOnWriteArraySet<com.larus.avlink.gallery.business.c> r0 = com.larus.avlink.gallery.business.a.a;
        com.larus.avlink.gallery.business.a.c(this.o);
        this.m = false;
        com.larus.avlink.n1.d("MediaAlbumViewHelper", "unregisterAlbumMediaChangeListener");
    L6:
        MediaSyncCoordinator r1 = MediaSyncCoordinator.a;
        MediaSyncCoordinator.x(this);
        this.g = null;
        com.larus.avlink.n1.d("MediaAlbumViewHelper", "MediaSyncCoordinator.unregisterStateListener in onStop");
    }

    @Override // u98.a
    public final void N30() {
        c();
    }

    @Override // u98.a
    public final void QR() {
        c();
    }

    public static final void a(MediaAlbumViewHelper r7) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r7.b), Dispatchers.getMain(), null, new MediaAlbumViewHelper$checkAndUpdateUI$1(r7, null), 2, null);
    }

    @Override // u98.a
    public final void RK(int r8) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.b), Dispatchers.getMain(), null, new MediaAlbumViewHelper$onProgressUpdated$1(this, r8, null), 2, null);
    }

    public final void d(boolean r6) {
        Map r0 = MapsKt.mapOf(new Pair[]{TuplesKt.to("card_type", "device_management"), TuplesKt.to("card_content_type", "dora_album"), TuplesKt.to("button_type", "dora_album")});
        IDoraService r1 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r1 == null) goto L5;
        r1.A0("dora_card_click", r0);
    L5:
        com.bytedance.router.i r2 = SmartRouter.buildRoute(this.a, "//flow/dora/media_album");
        r2.j("previous_page", "device_management");
        if (r6 == false) goto L8;
        r2.j("auto_sync", "true");
    L8:
        r2.d();
    }

    @Override // u98.a
    public final void m40(z98.a r8) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.b), Dispatchers.getMain(), null, new MediaAlbumViewHelper$updateSyncBannerState$1(this, r8, null), 2, null);
        if ((r8 instanceof z98.a.c) == false) goto L5;
    L6:
        c();
        return;
    L5:
        if ((r8 instanceof z98.a.d) == true) goto L6;
    }

    @Override // u98.a
    public final void onError(String r7) {
        Intrinsics.checkNotNullParameter(r7, "error");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.b), Dispatchers.getMain(), null, new C01141(this, null), 2, null);
    }

    /* JADX WARN: Type inference failed for: r7v27, types: [com.larus.avlink.gallery.view.MediaAlbumViewHelper$doralink$1] */
    /* JADX WARN: Type inference failed for: r7v30, types: [com.larus.avlink.gallery.view.c0] */
    /* JADX WARN: Type inference failed for: r7v32, types: [com.larus.avlink.gallery.view.MediaAlbumViewHelper$albumNotifyListener$1] */
    public MediaAlbumViewHelper(Context r28, LifecycleOwner r29) {
        Intrinsics.checkNotNullParameter(r28, "context");
        Intrinsics.checkNotNullParameter(r29, "lifecycleOwner");
        this.a = r28;
        this.b = r29;
        ConstraintLayout r1 = LayoutInflater.from(r28).inflate(2131562555, null, false);
        int r3 = 2131362095;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r1, 2131362095);
        if (r6 == null) goto L73;
        r3 = 2131362149;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r1, 2131362149);
        if (r15 == null) goto L73;
        r3 = 2131362483;
        AlbumSyncBanner r14 = (AlbumSyncBanner) ViewBindings.findChildViewById(r1, 2131362483);
        if (r14 == null) goto L73;
        r3 = 2131367812;
        FrameLayout r12 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131367812);
        if (r12 == null) goto L73;
        r3 = 2131370394;
        TextView r13 = (TextView) ViewBindings.findChildViewById(r1, 2131370394);
        if (r13 == null) goto L73;
        r3 = 2131370395;
        TextView r16 = (TextView) ViewBindings.findChildViewById(r1, 2131370395);
        if (r16 == null) goto L73;
        r3 = 2131370396;
        TextView r17 = (TextView) ViewBindings.findChildViewById(r1, 2131370396);
        if (r17 == null) goto L73;
        r3 = 2131370397;
        TextView r18 = (TextView) ViewBindings.findChildViewById(r1, 2131370397);
        if (r18 == null) goto L73;
        r3 = 2131370398;
        TextView r19 = (TextView) ViewBindings.findChildViewById(r1, 2131370398);
        if (r19 == null) goto L73;
        r3 = 2131371599;
        LinearLayout r20 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131371599);
        if (r20 == null) goto L73;
        r3 = 2131371601;
        if (((TextView) ViewBindings.findChildViewById(r1, 2131371601)) == null) goto L73;
        r3 = 2131374718;
        if (((ImageView) ViewBindings.findChildViewById(r1, 2131374718)) == null) goto L73;
        r3 = 2131374935;
        ImageViewWithLastMotion r21 = (ImageViewWithLastMotion) ViewBindings.findChildViewById(r1, 2131374935);
        if (r21 == null) goto L73;
        r3 = 2131374936;
        ImageViewWithLastMotion r22 = (ImageViewWithLastMotion) ViewBindings.findChildViewById(r1, 2131374936);
        if (r22 == null) goto L73;
        r3 = 2131374937;
        ImageViewWithLastMotion r23 = (ImageViewWithLastMotion) ViewBindings.findChildViewById(r1, 2131374937);
        if (r23 == null) goto L73;
        r3 = 2131374938;
        ImageViewWithLastMotion r24 = (ImageViewWithLastMotion) ViewBindings.findChildViewById(r1, 2131374938);
        if (r24 == null) goto L73;
        r3 = 2131374940;
        ImageViewWithLastMotion r25 = (ImageViewWithLastMotion) ViewBindings.findChildViewById(r1, 2131374940);
        if (r25 == null) goto L73;
        r3 = 2131375104;
        LinearLayout r26 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131375104);
        if (r26 == null) goto L73;
        r3 = 2131388915;
        if (((TextView) ViewBindings.findChildViewById(r1, 2131388915)) == null) goto L73;
        ConstraintLayout r2 = r1;
        this.c = new LarusItemDoraGDeviceManagementMediaAlbumBinding(r2, r6, r15, r14, r12, r13, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
        MediaLifecycleStateManager r4 = MediaLifecycleStateManager.b.a();
        this.d = LazyKt.lazy(new z(this));
        this.e = LazyKt.lazy(new a0(this));
        this.h = CollectionsKt.emptyList();
        this.i = new MediaAlbumViewHelper$doralink$1(this);
        this.j = LazyKt.lazy(new b0(this));
        this.o = new c0(this);
        this.p = new b(this);
        this.q = new MediaAlbumViewHelper$albumNotifyListener$1(this);
        r15.setOnClickListener(new f0(this));
        r6.setOnClickListener(new g0(this));
        r2.setOnClickListener(new h0(this));
        this.f = r14;
        r14.setLifecycleOwner(r29);
        ConstraintLayout r5 = this.f;
        if (r5 == null) goto L45;
        View r7 = r5.findViewById(2131363938);
        if (r7 == null) goto L45;
        r7.setVisibility(8);
    L45:
        AlbumSyncBanner r8 = this.f;
        if (r8 == null) goto L48;
        r8.setOverrideBackground(2131102539);
    L48:
        AlbumSyncBanner r9 = this.f;
        if (r9 == null) goto L51;
        r9.setOverrideTextColor(2131103146);
    L51:
        ConstraintLayout r10 = this.f;
        if (r10 == null) goto L56;
        TextView r11 = (TextView) r10.findViewById(2131362484);
        if (r11 == null) goto L56;
        r11.setPadding(r11.getPaddingLeft(), r11.getPaddingTop(), 0, r11.getPaddingBottom());
    L56:
        ConstraintLayout r27 = this.f;
        if (r27 == null) goto L67;
        View r30 = r27.findViewById(2131388915);
        if (r30 == null) goto L67;
        ViewGroup.LayoutParams r31 = r30.getLayoutParams();
        if ((r31 instanceof ViewGroup.MarginLayoutParams) == false) goto L63;
        ViewGroup.MarginLayoutParams r32 = (ViewGroup.MarginLayoutParams) r31;
    L64:
        if (r32 == null) goto L66;
        r32.setMarginStart(0);
    L66:
        r30.setLayoutParams(r32);
        goto L67
    L63:
        r32 = null;
    L67:
        AlbumSyncBanner r33 = this.f;
        if (r33 == null) goto L70;
        r33.setSyncActionHandler(new l0(this));
    L70:
        r29.getLifecycle().addObserver(new AnonymousClass1(this));
        r4.e(new AnonymousClass2(this));
        return;
    L73:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r3)));
    }

    public final void h(int r2, int r3) {
        if ((!this.h.isEmpty()) == true) goto L8;
        if (r2 > 0) goto L8;
        if (r3 > 0) goto L8;
        this.c.c.setVisibility(8);
        this.c.b.setVisibility(8);
        return;
    L8:
        this.c.c.setVisibility(0);
        this.c.b.setVisibility(0);
    }

    public final void i(int r3, int r4) {
        if (r3 > 0) goto L8;
        if (r4 > 0) goto L8;
        ConstraintLayout r5 = this.f;
        if (r5 == null) goto L15;
        r5.setVisibility(8);
        return;
    L15:
        return;
    L8:
        ConstraintLayout r0 = this.f;
        if (r0 == null) goto L11;
        r0.setVisibility(0);
    L11:
        AlbumSyncBanner r1 = this.f;
        if (r1 == null) goto L17;
        r1.T5(new z98.a.h(r3, r4));
        return;
    }

    public static final void b(MediaAlbumViewHelper r7, String r8, MediaMetadata r9) {
        if (r7.g == null) goto L7;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r7.b), Dispatchers.getIO(), null, new MediaAlbumViewHelper$refreshCurrentPhotoViewer$1(r9, r7, r8, null), 2, null);
        return;
    }
}

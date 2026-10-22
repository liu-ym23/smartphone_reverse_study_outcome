package com.bytedance.android.live.lynx.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerConfig;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.bytedance.android.livesdkapi.roomplayer.PlayerClientType;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.drawable.ScalingUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.ui.image.FrescoImageView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001%J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0007J\u0019\u0010\u000f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0007J\u0012\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0007J\u0019\u0010\u0017\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\b\u0017\u0010\u0010J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u001b\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u001e\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0007J\u0012\u0010\u001f\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0007J\u0012\u0010 \u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0007J\b\u0010!\u001a\u00020\u0007H\u0007J\u0012\u0010\"\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0007J\b\u0010#\u001a\u00020\u0007H\u0007J\b\u0010$\u001a\u00020\u0007H\u0007¨\u0006&"}, d2 = {"Lcom/bytedance/android/live/lynx/ui/ECLynxLiveView;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/bytedance/android/live/lynx/ui/LivePlayerContainer;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroidx/lifecycle/LifecycleObserver;", "", "poster", "", "setPoster", "roomId", "setRoomId", "qualities", "setQualities", "", "mute", "setMute", "(Ljava/lang/Boolean;)V", "", "volume", "setVolume", "objectfit", "setObjectfit", "share", "setSharePlayer", "streamData", "setStreamData", "liveData", "setLiveData", "Lcom/lynx/react/bridge/ReadableMap;", "params", "play", "pause", "stop", "sharePlayerToInner", "enterRoom", "onHostDestroy", "onHostResume", "a", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLynxLiveView extends LynxUI<LivePlayerContainer> implements View.OnAttachStateChangeListener, LifecycleObserver {
    public static PipelineDraweeControllerBuilder j;
    public static long k;
    public FrescoImageView a;
    public volatile String b;
    public volatile String c;
    public volatile String d;
    public volatile boolean e;
    public volatile String f;
    public volatile boolean g;
    public volatile boolean h;
    public volatile Room i;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ECLynxLiveView a;
        public final /* synthetic */ Boolean b;

        public b(ECLynxLiveView r1, Boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            if (Intrinsics.areEqual(this.b, Boolean.TRUE) == false) goto L11;
            LivePlayerContainer r0 = (LivePlayerContainer) this.a.getView();
            if (r0 == null) goto L19;
            LivePlayerView r1 = r0.getPlayerView$livehybrid_impl_saasRelease();
            if (r1 == null) goto L20;
            ILivePlayerClient r2 = r1.getClient();
            if (r2 == null) goto L21;
            r2.mute("ECLynxLiveView.setMute1");
            return;
        L21:
            return;
        L20:
            return;
        L19:
            return;
        L11:
            LivePlayerContainer r3 = (LivePlayerContainer) this.a.getView();
            if (r3 == null) goto L23;
            LivePlayerView r4 = r3.getPlayerView$livehybrid_impl_saasRelease();
            if (r4 == null) goto L24;
            ILivePlayerClient r5 = r4.getClient();
            if (r5 == null) goto L25;
            r5.unmute("ECLynxLiveView.setMute1");
            return;
        L25:
            return;
        L24:
            return;
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
        public final /* synthetic */ ECLynxLiveView a;
        public final /* synthetic */ String b;

        public c(ECLynxLiveView r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECLynxLiveView r0 = this.a;     // Catch: Throwable -> L4
            String r1 = this.b;     // Catch: Throwable -> L4
            PipelineDraweeControllerBuilder r2 = ECLynxLiveView.j;     // Catch: Throwable -> L4
            r0.M(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ ECLynxLiveView a;

        public d(ECLynxLiveView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECLynxLiveView r0 = this.a;     // Catch: Throwable -> L4
            PipelineDraweeControllerBuilder r1 = ECLynxLiveView.j;     // Catch: Throwable -> L4
            r0.N(false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ ECLynxLiveView a;
        public final /* synthetic */ String b;

        public e(ECLynxLiveView r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LivePlayerContainer r0 = (LivePlayerContainer) this.a.getView();     // Catch: Throwable -> L13
            if (r0 == null) goto L16;
            LivePlayerView r1 = r0.getPlayerView$livehybrid_impl_saasRelease();     // Catch: Throwable -> L13
            if (r1 == null) goto L20;
            ILivePlayerClient r2 = r1.getClient();     // Catch: Throwable -> L13
            if (r2 == null) goto L21;
            String r3 = this.b;     // Catch: Throwable -> L13
            if (r3 != null) goto L11;
            r3 = "";
        L11:
            r2.switchResolution(r3, "ec_lynx_change_resolution", MapsKt.emptyMap());     // Catch: Throwable -> L13
            return;
        L21:
            return;
        L20:
            return;
        L16:
            return;
        L13:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L22;
            throw th;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ ECLynxLiveView a;
        public final /* synthetic */ String b;

        public f(ECLynxLiveView r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECLynxLiveView r0 = this.a;     // Catch: Throwable -> L4
            String r1 = this.b;     // Catch: Throwable -> L4
            PipelineDraweeControllerBuilder r2 = ECLynxLiveView.j;     // Catch: Throwable -> L4
            r0.P(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ ECLynxLiveView a;
        public final /* synthetic */ float b;

        public g(ECLynxLiveView r1, float r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LivePlayerContainer r0 = (LivePlayerContainer) this.a.getView();     // Catch: Throwable -> L10
            if (r0 == null) goto L13;
            LivePlayerView r1 = r0.getPlayerView$livehybrid_impl_saasRelease();     // Catch: Throwable -> L10
            if (r1 == null) goto L17;
            ILivePlayerClient r2 = r1.getClient();     // Catch: Throwable -> L10
            if (r2 == null) goto L18;
            r2.setPlayerVolume(this.b);     // Catch: Throwable -> L10
            return;
        L18:
            return;
        L17:
            return;
        L13:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onHostResume() {
        this.g = true;
    }

    @LynxUIMethod
    public final void sharePlayerToInner() {
        this.g = false;
        this.h = true;
    }

    static {
        k = 1;
    }

    public final void onDetach() {
        super.onDetach();
        this.b = null;
        if (this.g == false) goto L12;
        LivePlayerContainer r0 = (LivePlayerContainer) getView();
        if (r0 == null) goto L13;
        LivePlayerView r1 = r0.getPlayerView$livehybrid_impl_saasRelease();
        if (r1 == null) goto L14;
        ILivePlayerClient r2 = r1.getClient();
        if (r2 == null) goto L15;
        r2.release();
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onHostDestroy() {
        LynxContext r0 = getLynxContext();
        if ((r0 instanceof LifecycleOwner) == true) goto L5;
        r0 = null;
    L5:
        LifecycleOwner r1 = (LifecycleOwner) r0;
        if (r1 == null) goto L10;
        Lifecycle r2 = r1.getLifecycle();
        if (r2 == null) goto L10;
        r2.removeObserver(this);
    L10:
        ((LivePlayerContainer) getView()).removeOnAttachStateChangeListener(this);
    }

    public ECLynxLiveView(LynxContext r1) {
        super(r1);
        this.f = "0";
        this.g = true;
        this.h = true;
    }

    public final void M(String r4) {
        if (r4 == null) goto L42;
        int r1 = r4.hashCode();
        if (r1 == (-1183789060)) goto L33;
        if (r1 == 94852023) goto L23;
        if (r1 != 951526612) goto L42;
        if (r4.equals("contain") == false) goto L42;
        LivePlayerContainer r5 = (LivePlayerContainer) getView();
        if (r5 == null) goto L19;
        LivePlayerView r6 = r5.getPlayerView$livehybrid_impl_saasRelease();
        if (r6 == null) goto L19;
        r6.setScaleType(1);
    L19:
        FrescoImageView r7 = this.a;
        if (r7 == null) goto L42;
        r7.setScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        goto L42
    L23:
        if (r4.equals("cover") == false) goto L42;
        LivePlayerContainer r8 = (LivePlayerContainer) getView();
        if (r8 == null) goto L29;
        LivePlayerView r9 = r8.getPlayerView$livehybrid_impl_saasRelease();
        if (r9 == null) goto L29;
        r9.setScaleType(2);
    L29:
        FrescoImageView r10 = this.a;
        if (r10 == null) goto L42;
        r10.setScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        goto L42
    L33:
        if (r4.equals("inside") == false) goto L42;
        LivePlayerContainer r11 = (LivePlayerContainer) getView();
        if (r11 == null) goto L39;
        LivePlayerView r12 = r11.getPlayerView$livehybrid_impl_saasRelease();
        if (r12 == null) goto L39;
        r12.setScaleType(0);
    L39:
        FrescoImageView r13 = this.a;
        if (r13 == null) goto L42;
        r13.setScaleType(ScalingUtils.ScaleType.CENTER_INSIDE);
    L42:
        N(false);
    }

    public final void N(boolean r3) {
        if (r3 == false) goto L8;
        FrescoImageView r4 = this.a;
        if (r4 == null) goto L32;
        r4.setVisibility(8);
        return;
    L32:
        return;
    L8:
        FrescoImageView r5 = this.a;
        if (r5 == null) goto L12;
        r5.setSrc(this.c);
    L12:
        if (TextUtils.isEmpty(this.c) == false) goto L14;
        int r6 = 8;
    L15:
        if (r6 != 0) goto L28;
        LivePlayerContainer r1 = (LivePlayerContainer) getView();
        if (r1 == null) goto L28;
        LivePlayerView r2 = r1.getPlayerView$livehybrid_impl_saasRelease();
        if (r2 == null) goto L28;
        ILivePlayerClient r7 = r2.getClient();
        if (r7 == null) goto L28;
        if (r7.isPlaying() == true) goto L28;
        FrescoImageView r0 = this.a;
        if (r0 == null) goto L33;
        r0.setVisibility(r6);
        return;
    L33:
        return;
    L28:
        FrescoImageView r8 = this.a;
        if (r8 == null) goto L34;
        r8.setVisibility(8);
        return;
    L34:
        return;
    L14:
        r6 = 0;
        goto L15
    }

    public final void P(String r24) {
        LivePlayerContainer r2 = (LivePlayerContainer) getView();
        if (r2 == null) goto L30;
        String r7 = this.f;
        boolean r9 = this.h;
        Intrinsics.checkNotNullParameter(r7, "roomId");
        if (r7.length() != 0) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == true) goto L30;
        if (Intrinsics.areEqual("0", r7) == true) goto L30;
        LivePlayerView r6 = r2.a;
        if (r6 == null) goto L17;
        ILivePlayerClient r8 = r6.getClient();
        if (r8 == null) goto L17;
        r8.release();
    L17:
        LivePlayerView r10 = r2.a;
        ViewGroup r11 = null;
        if (r10 == null) goto L20;
        ViewParent r12 = r10.getParent();
    L22:
        if ((r12 instanceof ViewGroup) == true) goto L24;
        r12 = null;
    L24:
        ViewGroup r13 = (ViewGroup) r12;
        if (Intrinsics.areEqual(r13, r2) == false) goto L27;
        r11 = r13;
    L27:
        if (r11 == null) goto L29;
        r11.removeView(r2.a);
    L29:
        LivePlayerView r15 = new LivePlayerView(r2.getContext(), new LivePlayerConfig(ILivePlayerScene.Companion.scene("ec_immersive_preview"), r7, PlayerClientType.NORMAL, r9, null, false, true, IRenderView.RenderViewType.KEEP_TEXTURE_RENDER_VIEW, false, 0, false, 1840, null));
        r2.a = r15;
        r2.addView(r15, -1, -1);
        goto L30
    L20:
        r12 = null;
        goto L22
    L7:
        r5 = false;
    L30:
        if (r24 != null) goto L32;
    L35:
        boolean r3 = true;
    L36:
        if (r3 == false) goto L38;
        return;
    L38:
        this.b = r24;
        LiveRequest.Builder r1 = new LiveRequest.Builder().mute(this.e).streamData(r24);
        String r4 = this.d;
        if (r4 != null) goto L41;
        r4 = "";
    L41:
        LiveRequest r14 = r1.resolution(r4).build();
        LivePlayerContainer r16 = (LivePlayerContainer) getView();
        if (r16 == null) goto L48;
        LivePlayerView r17 = r16.getPlayerView$livehybrid_impl_saasRelease();
        if (r17 == null) goto L48;
        ILivePlayerClient r18 = r17.getClient();
        if (r18 == null) goto L48;
        r18.stream(r14, new ECLynxLiveView$startPlay$1(this));
    L48:
        LivePlayerContainer r19 = (LivePlayerContainer) getView();
        if (r19 == null) goto L62;
        LivePlayerView r20 = r19.getPlayerView$livehybrid_impl_saasRelease();
        if (r20 == null) goto L63;
        IRenderView r21 = r20.getRenderView();
        if (r21 == null) goto L64;
        LivePlayerContainer r22 = (LivePlayerContainer) getView();
        if (r22 == null) goto L65;
        LivePlayerView r23 = r22.getPlayerView$livehybrid_impl_saasRelease();
        if (r23 == null) goto L66;
        ILivePlayerClient r25 = r23.getClient();
        if (r25 == null) goto L67;
        r25.bindRenderView(r21);
        return;
    L67:
        return;
    L66:
        return;
    L65:
        return;
    L64:
        return;
    L63:
        return;
    L62:
        return;
    L32:
        if (r24.length() == 0) goto L35;
        r3 = false;
        goto L36
    }

    public final View createView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (j != null) goto L5;
        j = Fresco.newDraweeControllerBuilder();
    L5:
        this.a = new FrescoImageView(r5, j, null, null);
        LivePlayerContainer r0 = new LivePlayerContainer(r5, null, 6, 0);
        if ((r5 instanceof LifecycleOwner) == true) goto L8;
        r5 = null;
    L8:
        LifecycleOwner r6 = (LifecycleOwner) r5;
        if (r6 == null) goto L13;
        Lifecycle r7 = r6.getLifecycle();
        if (r7 == null) goto L13;
        r7.addObserver(this);
    L13:
        r0.addOnAttachStateChangeListener(this);
        r0.addView(this.a, new ViewGroup.LayoutParams(-1, -1));
        return r0;
    }

    @LynxUIMethod
    public final void enterRoom(ReadableMap r6) {
        if (this.i != null) goto L5;
        return;
    L5:
        LivePlayerContainer r0 = (LivePlayerContainer) getView();
        if (r0 == null) goto L12;
        LivePlayerView r1 = r0.getPlayerView$livehybrid_impl_saasRelease();
        if (r1 == null) goto L12;
        ILivePlayerClient r2 = r1.getClient();
        if (r2 == null) goto L12;
        r2.setShouldDestroy(false);
    L12:
        Bundle r3 = new Bundle();
        Room r4 = this.i;
        if (r4 != null) goto L15;
        return;
    L15:
        if (r4.getCompoundStreamData() == null) goto L17;
        yt2.a.g(r3, "live.intent.extra.PULL_STREAM_DATA", r4.getCompoundStreamData());
        yt2.a.g(r3, "live.intent.extra.PULL_SHARE_URL", r4.getCompoundStreamData());
    L17:
        StreamUrl r5 = r4.getStreamUrl();
        if (r5 == null) goto L23;
        LinkedHashMap r7 = r5.sdkParamsMap;
        if (r7 == null) goto L23;
        String r8 = r7.toString();
        if (r8 == null) goto L23;
    L24:
        r3.putString("live.intent.extra.PULL_SDK_PARAMS", r8);
        r3.putString("live.intent.extra.PULL_DEFAULT_RESOLUTION", r4.getMultiStreamDefaultQualitySdkKey());
        r3.putBoolean("enter_preview_smooth", true);
        r3.putLong("live.intent.extra.ROOM_ID", r4.id);
        if (r6 == null) goto L33;
        Iterator r9 = r6.toHashMap().entrySet().iterator();
    L28:
        if (r9.hasNext() == false) goto L33;
        Map.Entry r10 = (Map.Entry) r9.next();
        if ((r10.getValue() instanceof JavaOnlyMap) == true) goto L31;
        r3.putString((String) r10.getKey(), String.valueOf(r10.getValue()));
        goto L28
    L31:
        r3.putString((String) r10.getKey(), GsonProtectorUtils.toJson(GsonHelper.get(), r10.getValue()));
    L33:
        sharePlayerToInner();
        jc1.k.n(IHostAction.class).enterRoom(getLynxContext(), r3, this.i);
        return;
    L23:
        r8 = "";
        goto L24
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        this.g = true;
        if (this.b == null) goto L6;
        N(false);
        P(this.b);
        return;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        if (this.g == false) goto L12;
        LivePlayerContainer r3 = (LivePlayerContainer) getView();
        if (r3 == null) goto L13;
        LivePlayerView r4 = r3.getPlayerView$livehybrid_impl_saasRelease();
        if (r4 == null) goto L14;
        ILivePlayerClient r5 = r4.getClient();
        if (r5 == null) goto L15;
        r5.release();
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @LynxUIMethod
    public final void pause(ReadableMap r1) {
        LivePlayerContainer r2 = (LivePlayerContainer) getView();
        if (r2 == null) goto L9;
        LivePlayerView r3 = r2.getPlayerView$livehybrid_impl_saasRelease();
        if (r3 == null) goto L9;
        ILivePlayerClient r4 = r3.getClient();
        if (r4 == null) goto L9;
        r4.stop();
    L9:
        N(false);
    }

    @LynxUIMethod
    public final void play(ReadableMap r1) {
        P(this.b);
    }

    @LynxProp(name = "liveData")
    public final void setLiveData(String r4) {
        if (r4 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        String r1 = null;
        if (r0 == false) goto L11;
        Room r5 = null;
    L12:
        if (r5 == null) goto L18;
        this.i = r5;
        StreamUrl r2 = r5.getStreamUrl();
        if (r2 == null) goto L16;
        r1 = r2.getMultiStreamData();
    L16:
        setStreamData(r1);
        setRoomId(String.valueOf(r5.getRoomId()));
        return;
    L18:
        return;
    L11:
        r5 = (Room) GsonProtectorUtils.fromJson(GsonHelper.get(), r4, new com.bytedance.android.live.lynx.ui.a().getType());
        goto L12
    L4:
        if (r4.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    @LynxProp(name = "mute")
    public final void setMute(Boolean r3) {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L8;
        LivePlayerContainer r0 = (LivePlayerContainer) getView();
        if (r0 == null) goto L23;
        r0.post(new b(this, r3));
    L23:
        if (r3 == null) goto L25;
        boolean r4 = r3.booleanValue();
    L26:
        this.e = r4;
        return;
    L25:
        r4 = false;
        goto L26
    L8:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L16;
        LivePlayerContainer r1 = (LivePlayerContainer) getView();
        if (r1 == null) goto L23;
        LivePlayerView r2 = r1.getPlayerView$livehybrid_impl_saasRelease();
        if (r2 == null) goto L23;
        ILivePlayerClient r5 = r2.getClient();
        if (r5 == null) goto L23;
        r5.mute("ECLynxLiveView.setMute");
        goto L23
    L16:
        LivePlayerContainer r6 = (LivePlayerContainer) getView();
        if (r6 == null) goto L23;
        LivePlayerView r7 = r6.getPlayerView$livehybrid_impl_saasRelease();
        if (r7 == null) goto L23;
        ILivePlayerClient r8 = r7.getClient();
        if (r8 == null) goto L23;
        r8.unmute("ECLynxLiveView.setMute");
        goto L23
    }

    @LynxProp(name = "objectfit")
    public final void setObjectfit(String r3) {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L7;
        LivePlayerContainer r0 = (LivePlayerContainer) getView();
        if (r0 == null) goto L9;
        r0.post(new c(this, r3));
        return;
    L9:
        return;
    L7:
        M(r3);
    }

    @LynxProp(name = "poster")
    public final void setPoster(String r2) {
        this.c = r2;
        if (Looper.myLooper() == Looper.getMainLooper()) goto L7;
        LivePlayerContainer r3 = (LivePlayerContainer) getView();
        if (r3 == null) goto L9;
        r3.post(new d(this));
        return;
    L9:
        return;
    L7:
        N(false);
    }

    @LynxProp(name = "qualities")
    public final void setQualities(String r4) {
        this.d = r4;
        if (Looper.myLooper() == Looper.getMainLooper()) goto L7;
        LivePlayerContainer r0 = (LivePlayerContainer) getView();
        if (r0 == null) goto L17;
        r0.post(new e(this, r4));
        return;
    L17:
        return;
    L7:
        LivePlayerContainer r1 = (LivePlayerContainer) getView();
        if (r1 == null) goto L19;
        LivePlayerView r2 = r1.getPlayerView$livehybrid_impl_saasRelease();
        if (r2 == null) goto L20;
        ILivePlayerClient r3 = r2.getClient();
        if (r3 == null) goto L21;
        if (r4 != null) goto L15;
        r4 = "";
    L15:
        r3.switchResolution(r4, "ec_lynx_change_resolution", MapsKt.emptyMap());
        return;
    L21:
        return;
    L20:
        return;
    }

    @LynxProp(name = "room-id")
    public final void setRoomId(String r5) {
        if (r5 != null) goto L4;
        long r0 = k;
        k = 1 + r0;
        r5 = String.valueOf(r0);
    L4:
        this.f = r5;
    }

    @LynxProp(name = "share-player")
    public final void setSharePlayer(Boolean r2) {
        if (r2 == null) goto L5;
        boolean r3 = r2.booleanValue();
        this.g = !r3;
        this.h = r3;
        return;
    }

    @LynxProp(name = "streamData")
    public final void setStreamData(String r3) {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L7;
        LivePlayerContainer r0 = (LivePlayerContainer) getView();
        if (r0 == null) goto L9;
        r0.post(new f(this, r3));
        return;
    L9:
        return;
    L7:
        P(r3);
    }

    @LynxProp(defaultDouble = 0.0d, name = "volume")
    public final void setVolume(float r3) {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L7;
        LivePlayerContainer r0 = (LivePlayerContainer) getView();
        if (r0 == null) goto L15;
        r0.post(new g(this, r3));
        return;
    L15:
        return;
    L7:
        LivePlayerContainer r1 = (LivePlayerContainer) getView();
        if (r1 == null) goto L17;
        LivePlayerView r2 = r1.getPlayerView$livehybrid_impl_saasRelease();
        if (r2 == null) goto L18;
        ILivePlayerClient r4 = r2.getClient();
        if (r4 == null) goto L19;
        r4.setPlayerVolume(r3);
        return;
    L19:
        return;
    L18:
        return;
    }

    @LynxUIMethod
    public final void stop(ReadableMap r1) {
        LivePlayerContainer r2 = (LivePlayerContainer) getView();
        if (r2 == null) goto L9;
        LivePlayerView r3 = r2.getPlayerView$livehybrid_impl_saasRelease();
        if (r3 == null) goto L9;
        ILivePlayerClient r4 = r3.getClient();
        if (r4 == null) goto L9;
        r4.stop();
    L9:
        N(false);
    }

    public final void O(String r3, Map<String, ? extends Object> r4) {
        int r1 = getSign();
        if (r4 != null) goto L5;
        r4 = new LinkedHashMap();
    L5:
        m7a.a r0 = new m7a.a(r1, r3, r4);
        LynxContext r5 = getLynxContext();
        if (r5 == null) goto L11;
        EventEmitter r6 = r5.getEventEmitter();
        if (r6 == null) goto L12;
        r6.sendCustomEvent(r0);
        return;
    L12:
        return;
    }
}

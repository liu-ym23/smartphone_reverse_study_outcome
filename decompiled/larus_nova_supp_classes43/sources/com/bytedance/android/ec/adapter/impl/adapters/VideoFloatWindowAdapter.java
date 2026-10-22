package com.bytedance.android.ec.adapter.impl.adapters;

import android.app.Activity;
import android.os.SystemClock;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.adapter.api.j;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class VideoFloatWindowAdapter implements j {
    public static final Lazy a = null;
    public static Integer b;
    public static final HashMap<Integer, LifecycleObserver> c = null;
    public static final VideoFloatWindowAdapter d = null;

    public static final class a implements IVideoFloatManager.VideoFloatManagerListener {
        public final /* synthetic */ com.bytedance.android.ec.model.j a;

        public final void onViewPositionChanged(int r1, int r10, int r11, int r12) {
        }

        public final void onViewReleased() {
        }

        public final void onClick() {
            this.a.onClick();
        }

        public final void onReturnClick() {
            this.a.onReturnClick();
        }

        public final void onShow() {
            this.a.onShow();
        }

        public a(com.bytedance.android.ec.model.j r1) {
            this.a = r1;
        }

        public final void onClose(boolean r10) {
            this.a.onClose(r10);
        }

        public final void onMuteButtonClick(boolean r10) {
            this.a.onMuteButtonClick(r10);
        }

        public final void onShow(int r1, int r10, int r11, int r12) {
            this.a.onShow();
        }
    }

    public VideoFloatWindowAdapter() {
    }

    static {
        d = new VideoFloatWindowAdapter();
        a = LazyKt.lazy(VideoFloatWindowAdapter$monitorEnable$2.INSTANCE);
        c = new HashMap();
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final boolean checkWindowConflict() {
        ILiveVideoFloatWindowService r0 = k.f(ILiveVideoFloatWindowService.class);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.checkWindowConflict() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final boolean isFloatWindowShowing() {
        ILiveVideoFloatWindowService r0 = k.f(ILiveVideoFloatWindowService.class);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isFloatWindowShowing() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void stopShowFloat() {
        ILiveVideoFloatWindowService r0 = k.f(ILiveVideoFloatWindowService.class);
        if (r0 == null) goto L6;
        r0.stopShowFloat();
        return;
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void stopShowFloatInNextLifecycle() {
        ILiveVideoFloatWindowService r0 = k.f(ILiveVideoFloatWindowService.class);
        if (r0 == null) goto L6;
        r0.stopShowFloatInNextLifecycle();
        return;
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void stopShowNow() {
        ILiveVideoFloatWindowService r0 = k.f(ILiveVideoFloatWindowService.class);
        if (r0 == null) goto L6;
        r0.stopShowNow();
        return;
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void b(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        ILiveVideoFloatWindowService r0 = k.f(ILiveVideoFloatWindowService.class);
        if (r0 == null) goto L6;
        r0.preloadVideoFloatWindowView(r10);
        b = Integer.valueOf(r10.hashCode());
        return;
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void d(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        if ((r10 instanceof IVideoFloatManager.VideoFloatManagerListener) == true) goto L5;
        return;
    L5:
        ILiveVideoFloatWindowService r0 = k.f(ILiveVideoFloatWindowService.class);
        if (r0 == null) goto L9;
        r0.removeVideoFloatManagerListener((IVideoFloatManager.VideoFloatManagerListener) r10);
        return;
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final Object f(com.bytedance.android.ec.model.j r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        a r0 = new a(r10);
        ILiveVideoFloatWindowService r11 = k.f(ILiveVideoFloatWindowService.class);
        if (r11 == null) goto L5;
        r11.addVideoFloatManagerListener(r0);
    L5:
        return r0;
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void setFloatWindowBottomMargin(int r10) {
        ILiveVideoFloatWindowService r0 = k.f(ILiveVideoFloatWindowService.class);
        if (r0 == null) goto L6;
        r0.setFloatWindowBottomMargin(r10);
        return;
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void toggleLiveAudio(boolean r10) {
        ILiveVideoFloatWindowService r0 = k.f(ILiveVideoFloatWindowService.class);
        if (r0 == null) goto L6;
        r0.toggleLiveAudio(r10);
        return;
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void c(Activity r10, com.bytedance.android.ec.adapter.api.a r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, "extra");
        ILiveVideoFloatWindowService r0 = k.f(ILiveVideoFloatWindowService.class);
        if (r0 == null) goto L27;
        final int r1 = r10.hashCode();
        Integer r12 = b;
        boolean r13 = true;
        if (r12 != null) goto L8;
    L10:
        boolean r14 = false;
    L12:
        if (((Boolean) a.getValue()).booleanValue() == false) goto L24;
        HashMap<Integer, LifecycleObserver> r15 = c;
        if (r15.get(Integer.valueOf(r1)) != null) goto L24;
        if ((r10 instanceof LifecycleOwner) == true) goto L18;
        Activity r16 = null;
    L19:
        LifecycleOwner r17 = (LifecycleOwner) r16;
        if (r17 == null) goto L25;
        Lifecycle r18 = r17.getLifecycle();
        if (r18 == null) goto L25;
        LifecycleObserver r19 = new VideoFloatWindowAdapter$startShowFloat$2$1(r1);
        r15.put(Integer.valueOf(r1), r19);
        Unit r20 = Unit.INSTANCE;
        r18.addObserver(r19);
    L25:
        long r21 = SystemClock.elapsedRealtime();
        InnerContextEntity.InnerFloatExtra r22 = new InnerContextEntity.InnerFloatExtra();
        r22.setRequestPage(r11.a);
        r22.setEnterRoomId(r11.b);
        r22.setMobParams(r11.e);
        r22.setParams(r11.f);
        r22.setMute(r11.c);
        r22.setForceNewActivityWhenJumpRoom(r11.d);
        Unit r23 = Unit.INSTANCE;
        r0.startShowFloat(r10, r22);
        h(r10.getClass().getName(), r14, r13, SystemClock.elapsedRealtime() - r21);
        return;
    L18:
        r16 = r10;
    L24:
        r13 = false;
        goto L25
    L8:
        if (r1 != r12.intValue()) goto L10;
        r14 = true;
        goto L12
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void e(Activity r10, com.bytedance.android.ec.adapter.api.a r11) {
        Intrinsics.checkNotNullParameter(r11, "extra");
        if (r10 != null) goto L5;
        return;
    L5:
        ILiveVideoFloatWindowService r0 = k.f(ILiveVideoFloatWindowService.class);
        if (r0 == null) goto L9;
        InnerContextEntity.InnerFloatExtra r1 = new InnerContextEntity.InnerFloatExtra();
        r1.setRequestPage(r11.a);
        r1.setEnterRoomId(r11.b);
        r1.setMobParams(r11.e);
        r1.setParams(r11.f);
        r1.setMute(r11.c);
        r1.setForceNewActivityWhenJumpRoom(r11.d);
        Unit r12 = Unit.INSTANCE;
        r0.startShowFloatInNextLifecycle(r10, r1);
        return;
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void g(DialogFragment r10, FrameLayout r11) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r11, "rootView");
        ILiveVideoFloatWindowService r0 = k.f(ILiveVideoFloatWindowService.class);
        if (r0 == null) goto L6;
        r0.preloadVideoFloatWindowView(r10, r11);
        b = Integer.valueOf(r10.hashCode());
        return;
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void a(DialogFragment r10, FrameLayout r11, com.bytedance.android.ec.adapter.api.a r12) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r11, "rootView");
        Intrinsics.checkNotNullParameter(r12, "extra");
        boolean r0 = r12.d;
        ILiveVideoFloatWindowService r1 = k.f(ILiveVideoFloatWindowService.class);
        if (r1 == null) goto L19;
        final int r13 = r10.hashCode();
        Integer r14 = b;
        boolean r15 = true;
        if (r14 != null) goto L8;
    L10:
        boolean r16 = false;
    L12:
        if (((Boolean) a.getValue()).booleanValue() == false) goto L16;
        HashMap<Integer, LifecycleObserver> r17 = c;
        if (r17.get(Integer.valueOf(r13)) != null) goto L16;
        Lifecycle r18 = r10.getLifecycle();
        LifecycleObserver r19 = new VideoFloatWindowAdapter$startShowFloat$1$1(r13);
        r17.put(Integer.valueOf(r13), r19);
        Unit r20 = Unit.INSTANCE;
        r18.addObserver(r19);
    L17:
        long r21 = SystemClock.elapsedRealtime();
        InnerContextEntity.InnerFloatExtra r22 = new InnerContextEntity.InnerFloatExtra();
        r22.setRequestPage(r12.a);
        r22.setEnterRoomId(r12.b);
        r22.setMobParams(r12.e);
        r22.setParams(r12.f);
        r22.setMute(r12.c);
        r22.setForceNewActivityWhenJumpRoom(r12.d);
        Unit r110 = Unit.INSTANCE;
        r1.startShowFloat(r10, r11, r22);
        h(r10.getClass().getName(), r16, r15, SystemClock.elapsedRealtime() - r21);
        return;
    L16:
        r15 = false;
        goto L17
    L8:
        if (r13 != r14.intValue()) goto L10;
        r16 = true;
        goto L12
    }

    public static void h(String r10, boolean r11, boolean r12, long r13) {
        if (((Boolean) a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        Map<String, com.bytedance.android.ec.core.monitor.a> r0 = com.bytedance.android.ec.core.monitor.c.a;
        MonitorScenes r1 = MonitorScenes.EC_FLOAT_LIVE;
        Map r14 = MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_DURATION, String.valueOf(r13)));
        Pair[] r15 = new Pair[3];
        r15[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, r10);
        String r16 = "1";
        if (r11 == false) goto L8;
        Object r17 = "1";
    L9:
        r15[1] = TuplesKt.to("flag_invoke_preload", r17);
        if (r12 == true) goto L13;
        r16 = "0";
    L13:
        r15[2] = TuplesKt.to("flag_first_open", r16);
        com.bytedance.android.ec.core.monitor.c.b(r1, r14, MapsKt.mapOf(r15));
        return;
    L8:
        r17 = "0";
        goto L9
    }
}

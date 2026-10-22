package com.bytedance.android.livesdk.focus;

import android.animation.AnimatorSet;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.broadcast.api.ICameraInfoService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.sb;
import com.bytedance.android.livesdk.config.va;
import com.bytedance.android.livesdk.j5;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.service.l;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.bytedance.android.livesdkapi.depend.live.ISessionRecordService;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ExposureCompensationInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomSpecificSceneTypeInfo;
import com.bytedance.android.livesdkapi.focus.IFocusContext;
import com.bytedance.android.livesdkapi.focus.IFocusWidget;
import com.bytedance.android.livesdkapi.live.ILiveExternalCameraServiceForOther;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.LiveAddPictureConfig;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/focus/LiveFocusWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lcom/bytedance/android/livesdkapi/focus/IFocusWidget;", "Lcom/bytedance/android/livesdkapi/depend/live/ILiveRecordService$RecordStatusChangeListener;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFocusWidget extends LiveWidget implements IFocusWidget, ILiveRecordService.RecordStatusChangeListener {
    public static final int g = 0;
    public static final int h = 0;
    public static final int i = 0;
    public final Lazy a;
    public final Lazy b;
    public com.bytedance.android.livesdk.focus.b c;
    public Disposable d;
    public Disposable e;
    public boolean f;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LiveFocusWidget a;

        public b(LiveFocusWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            Long r9 = (Long) r8;
            int r10 = nz.d.a;
            va1.b r11 = va1.b.a.a;
            if (((ICameraInfoService) r11.a(ICameraInfoService.class)).m3() == false) goto L9;
            Pair r0 = ((ICameraInfoService) r11.a(ICameraInfoService.class)).C4();
            this.a.getClass();
            nc1.a r2 = LiveFocusWidget.xq();
            if (r2 == null) goto L7;
            r2.c(((Widget) this.a).containerView.getWidth(), ((Widget) this.a).containerView.getHeight(), (int) ((Number) r0.getFirst()).floatValue(), (int) ((Number) r0.getSecond()).floatValue());
        L7:
            ALogger.i("FocusWidget", "apply preview focus info to live: " + ((Number) r0.getFirst()).floatValue() + ", " + ((Number) r0.getSecond()).floatValue());
        L9:
            if (((ICameraInfoService) r11.a(ICameraInfoService.class)).h() == false) goto L27;
            ExposureCompensationInfo r12 = ((ICameraInfoService) r11.a(ICameraInfoService.class)).p1();
            if (r12 == null) goto L28;
            int r1 = com.bytedance.android.livesdk.focus.b.o;
            int r3 = r12.getMin();
            int r4 = r12.getMax();
            int r13 = r12.getExposure();
            this.a.getClass();
            nc1.a r5 = LiveFocusWidget.xq();
            if (r5 == null) goto L16;
            r5.a();
        L16:
            this.a.getClass();
            nc1.a r6 = LiveFocusWidget.xq();
            if (r6 == null) goto L19;
            r6.a();
        L19:
            if (r4 != r3) goto L21;
            float r14 = 0.0f;
        L22:
            this.a.getClass();
            nc1.a r7 = LiveFocusWidget.xq();
            if (r7 == null) goto L25;
            r7.b(r14);
        L25:
            ALogger.i("FocusWidget", "apply preview exposure info to live: " + r14);
            return;
        L21:
            r14 = (((r13 - r3) / (r4 - r3)) * 0) + 0;
            goto L22
        L28:
            return;
        }
    }

    public static final class c implements com.bytedance.android.livesdk.focus.b.a {
        public final /* synthetic */ LiveFocusWidget a;
        public final /* synthetic */ IFocusContext b;

        @Override // com.bytedance.android.livesdk.focus.b.a
        public final ExposureCompensationInfo getCameraECInfo() {
            ExposureCompensationInfo r0 = new ExposureCompensationInfo();
            this.a.getClass();
            nc1.a r1 = LiveFocusWidget.xq();
            if (r1 == null) goto L5;
            r1.a();
        L5:
            r0.setMin(0);
            this.a.getClass();
            nc1.a r2 = LiveFocusWidget.xq();
            if (r2 == null) goto L8;
            r2.a();
        L8:
            r0.setMax(0);
            return r0;
        }

        @Override // com.bytedance.android.livesdk.focus.b.a
        public final void setExposure(int r5) {
            this.a.getClass();
            nc1.a r0 = LiveFocusWidget.xq();
            if (r0 == null) goto L5;
            r0.b(r5);
        L5:
            IFocusContext r1 = this.b;
            if (r1 == null) goto L8;
            r1.setExposure(r5);
        L8:
            LiveFocusWidget r2 = this.a;
            Disposable r3 = r2.d;
            if (r3 != null) goto L11;
        L15:
            r2.d = Observable.timer(sb.a.getValue().longValue(), TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.focus.c(r5));
            return;
        L11:
            if (r3.isDisposed() == true) goto L15;
            Disposable r4 = r2.d;
            if (r4 == null) goto L15;
            r4.dispose();
            goto L15
        }

        public c(LiveFocusWidget r1, IFocusContext r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ LiveFocusWidget a;

        public d(LiveFocusWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);     // Catch: Throwable -> L17
            Float r1 = Float.valueOf(0.0f);     // Catch: Throwable -> L17
            if (r0 == null) goto L9;
            j r2 = r0.getFocusContext();     // Catch: Throwable -> L17
            if (r2 == null) goto L9;
            IFocusContext r3 = (IFocusContext) r2.getValue();     // Catch: Throwable -> L17
            if (r3 == null) goto L9;
            Number r4 = Integer.valueOf(r3.getExposure());     // Catch: Throwable -> L17
        L11:
            if (Intrinsics.areEqual(r4, r1) == true) goto L20;
            this.a.getClass();     // Catch: Throwable -> L17
            nc1.a r5 = LiveFocusWidget.xq();     // Catch: Throwable -> L17
            if (r5 == null) goto L24;
            r5.b(r4.floatValue());     // Catch: Throwable -> L17
            return;
        L24:
            return;
        L20:
            return;
        L9:
            r4 = r1;
        L17:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L25;
            throw th;
        }
    }

    static {
        g = UtilityKotlinExtentionsKt.i(134) + UtilityKotlinExtentionsKt.i(8);
        h = UtilityKotlinExtentionsKt.i(340) + UtilityKotlinExtentionsKt.i(8);
        i = UtilityKotlinExtentionsKt.i(12);
    }

    public final boolean canAdjustExposure() {
        com.bytedance.android.livesdk.focus.b r0 = this.c;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.f != true) goto L7;
        return true;
    }

    public final void wq() {
        this.e = Observable.timer(va.a.getValue().longValue(), TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
    }

    public LiveFocusWidget() {
        this.a = LazyKt.lazy(new LiveFocusWidget$focusIcon$2(this));
        this.b = LazyKt.lazy(new LiveFocusWidget$exposureSeekBar$2(this));
    }

    public static nc1.a xq() {
        j r0 = m.i().getLiveStream();
        if (r0 == null) goto L7;
        com.bytedance.android.live.pushstream.d r1 = (com.bytedance.android.live.pushstream.d) r0.getValue();
        if (r1 == null) goto L7;
        return r1.e();
    L7:
        return null;
    }

    public final void onCreate() {
        super.onCreate();
        RoomContext.a r0 = RoomContext.Companion;
        RoomContext r1 = RoomContext.a.c(r0, null, 0, 3);
        if (r1 == null) goto L7;
        j r2 = r1.getFocusContext();
        if (r2 == null) goto L7;
        IFocusContext r3 = (IFocusContext) r2.getValue();
    L8:
        if (r3 == null) goto L11;
        r3.setFocusWidget(this);
    L11:
        if (((Boolean) j5.a.getValue()).booleanValue() == false) goto L19;
        j r5 = m.i().getLiveStream();
        if (r5 == null) goto L15;
        com.bytedance.android.live.pushstream.d r6 = (com.bytedance.android.live.pushstream.d) r5.getValue();
    L16:
        if (r6 == null) goto L19;
        if (r3 == null) goto L19;
        wq();
        goto L19
    L15:
        r6 = null;
    L19:
        this.c = new com.bytedance.android.livesdk.focus.b(((Widget) this).containerView, (ImageView) this.a.getValue(), (ExposureSeekBarView) this.b.getValue(), new c(this, r3));
        if (((Boolean) qc1.a.a.getValue()).booleanValue() == false) goto L22;
        NewBroadcastMonitor.a r4 = NewBroadcastMonitor.c("ttlive_anchor_set_exposure", null, null, 14);
        r4.l(0);
        r4.i("status_msg", "LiveFocusWidget set exposure listener");
        r4.m("success");
        r4.a().report();
    L22:
        int r7 = g;
        int r8 = h;
        if (a0.b(((Widget) this).dataCenter) == null) goto L29;
        IAbilityCenter r9 = a0.b(((Widget) this).dataCenter);
        if (r9 == null) goto L30;
        ISessionRecordService r10 = r9.getAbility(ISessionRecordService.class);
        if (r10 == null) goto L30;
        r10.addRecordStatsChangeListener(this);
    L30:
        RoomContext r11 = RoomContext.a.c(r0, ((Widget) this).dataCenter, 0, 2);
        if (r11 == null) goto L43;
        com.bytedance.live.datacontext.m r12 = r11.getRoom();
        if (r12 == null) goto L43;
        Room r13 = (Room) r12.getValue();
        if (r13 == null) goto L43;
        RoomSpecificSceneTypeInfo r14 = r13.getSceneTypeInfo();
        if (r14 == null) goto L43;
        if (r14.isLandscapeVertical() != true) goto L43;
        Rect r15 = l00.c.a();
        if (r15 == null) goto L43;
        r7 = r15.top;
        r8 = s1.w() - r15.bottom;
    L43:
        int r16 = i;
        com.bytedance.android.livesdk.focus.b r17 = this.c;
        if (r17 == null) goto L47;
        r17.c = r16;
        r17.a = r7;
        r17.d = r16;
        r17.b = r8;
        return;
    L47:
        return;
    L29:
        l.d().e().addRecordStatsChangeListener(this);
    L7:
        r3 = null;
        goto L8
    }

    public final void onDestroy() {
        super.onDestroy();
        if (a0.b(((Widget) this).dataCenter) == null) goto L9;
        IAbilityCenter r0 = a0.b(((Widget) this).dataCenter);
        if (r0 == null) goto L10;
        ISessionRecordService r1 = r0.getAbility(ISessionRecordService.class);
        if (r1 == null) goto L10;
        r1.removeRecordStatsChangeListener(this);
    L10:
        Disposable r2 = this.d;
        if (r2 == null) goto L13;
        r2.dispose();
    L13:
        Disposable r3 = this.e;
        if (r3 == null) goto L17;
        r3.dispose();
        return;
    L17:
        return;
    L9:
        l.d().e().removeRecordStatsChangeListener(this);
        goto L10
    }

    public final void onResume() {
        super.onResume();
        LiveAddPictureConfig r0 = (LiveAddPictureConfig) LiveInfraSettingKeys.LIVE_ANCHOR_ADD_PICTURE_CONFIG.getValue();
        if (Intrinsics.areEqual(r0.getCameraResetEnable(), Boolean.TRUE) == false) goto L6;
        new Handler(Looper.getMainLooper()).postDelayed(new d(this), r0.getResetDelay());
        return;
    }

    public final boolean isTapValid(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        com.bytedance.android.livesdk.focus.b r1 = this.c;
        if (r1 == null) goto L19;
        Intrinsics.checkNotNullParameter(r7, "event");
        if (r7.getX() >= (r1.k.getX() + r1.c)) goto L7;
    L13:
        boolean r8 = false;
    L14:
        if (r8 == true) goto L16;
        return false;
    L16:
        if (this.f == true) goto L21;
        return true;
    L21:
        return false;
    L7:
        if (r7.getX() > ((r1.k.getWidth() + r1.k.getX()) - r1.d)) goto L13;
        if (r7.getY() < (r1.k.getY() + r1.a)) goto L13;
        if (r7.getY() > ((r1.k.getHeight() + r1.k.getY()) - r1.b)) goto L13;
        r8 = true;
        goto L14
    L19:
        return false;
    }

    public final void onChange(ILiveRecordService.RecordStatus r2) {
        Intrinsics.checkNotNullParameter(r2, "status");
        if (r2 != ILiveRecordService.RecordStatus.RECORDING) goto L5;
        boolean r3 = true;
    L6:
        this.f = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    public final void onSingleTap(MotionEvent r16) {
        Intrinsics.checkNotNullParameter(r16, "event");
        ILiveExternalCameraServiceForOther r1 = k.f(ILiveExternalCameraServiceForOther.class);
        if (r1 != null) goto L5;
    L7:
        com.bytedance.android.livesdk.focus.b r2 = this.c;
        if (r2 == null) goto L39;
        float r4 = r16.getX();
        float r5 = r16.getY();
        if (r2.e == true) goto L12;
    L15:
        r2.k.removeView(r2.l);
        ImageView r6 = r2.l;
        r6.setImageResource(2131251722);
        r6.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(UtilityKotlinExtentionsKt.i(62), UtilityKotlinExtentionsKt.i(62));
        r7.leftMargin = ((int) r4) - (UtilityKotlinExtentionsKt.i(62) / 2);
        r7.topMargin = ((int) r5) - (UtilityKotlinExtentionsKt.i(62) / 2);
        r6.setLayoutParams(r7);
        r6.setAlpha(1.0f);
        r2.k.addView(r2.l);
        ((AnimatorSet) r2.h.getValue()).start();
        r2.e = true;
        float r8 = r16.getX();
        float r9 = r16.getY();
        if (r2.f == false) goto L18;
        ((AnimatorSet) r2.j.getValue()).end();
    L18:
        r2.k.removeView(r2.m);
        if (r8 <= (r2.k.getWidth() - ((int) UtilityKotlinExtentionsKt.h(64.0f)))) goto L21;
        float r10 = r8 - UtilityKotlinExtentionsKt.h(51.5f);
    L22:
        double r11 = ((double) r2.m.getSeekBarTotalLength()) * 0.5d;
        double r13 = ((double) r2.k.getHeight()) - (((double) r2.m.getSeekBarTotalLength()) * 0.5d);
        double r3 = r9;
        if (r3 >= r11) goto L25;
    L27:
        char r12 = 1;
        float[] r14 = null;
    L28:
        if (r14 == null) goto L31;
        ExposureSeekBarView r15 = r2.m;
        float r17 = r14[0];
        float r18 = r14[r12];
        r15.f = r17;
        r15.g = r18;
        r15.k = false;
        r15.h = 0.5f;
        r15.invalidate();
        r15.setAlpha(1.0f);
        r2.n.setExposure(0);
        r2.k.addView(r2.m);
        r2.f = true;
    L31:
        LinkedHashMap r19 = new LinkedHashMap();
        r19.put("scene", "living");
        Integer r20 = (Integer) com.bytedance.android.livesdk.sharedpref.b.a.a();
        if (r20 != null) goto L35;
    L37:
        String r21 = "back";
    L38:
        r19.put("camera_type", r21);
        u.l().sendLog("livesdk_manual_adjust_camera_exposure", r19, new Object[0]);
        goto L39
    L35:
        if (r20.intValue() != 1) goto L37;
        r21 = "front";
        goto L38
    L25:
        if (r3 > r13) goto L27;
        r12 = 1;
        r14 = new float[]{r10, r9};
        goto L28
    L21:
        r10 = r8 + UtilityKotlinExtentionsKt.h(51.5f);
        goto L22
    L12:
        if (r2.g == false) goto L14;
        ((AnimatorSet) r2.h.getValue()).end();
        goto L15
    L14:
        ((AnimatorSet) r2.i.getValue()).end();
    L39:
        nc1.a r22 = xq();
        if (r22 == null) goto L42;
        r22.c(((Widget) this).containerView.getWidth(), ((Widget) this).containerView.getHeight(), (int) r16.getX(), (int) r16.getY());
    L42:
        ALogger.d("FocusWidget", "focus on " + r16.getX() + ", " + r16.getY());
        LinkedHashMap r23 = new LinkedHashMap();
        StringBuilder r24 = new StringBuilder();
        r24.append(r16.getX());
        r24.append('-');
        r24.append(r16.getY());
        r23.put("point", r24.toString());
        NewBroadcastMonitor.g("ttlive_camera_click_exposure", r23);
        return;
    L5:
        if (r1.isConnected() != true) goto L7;
    }

    public final void onScroll(MotionEvent r3, MotionEvent r4, float r5, float r6) {
        Intrinsics.checkNotNullParameter(r3, "e1");
        Intrinsics.checkNotNullParameter(r4, "e2");
        com.bytedance.android.livesdk.focus.b r7 = this.c;
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.g == false) goto L7;
        ((AnimatorSet) r7.h.getValue()).end();
    L8:
        r7.k.removeView(r7.l);
        r7.k.removeView(r7.m);
        r7.k.addView(r7.m);
        r7.k.addView(r7.l);
        r7.f = true;
        r7.e = true;
        r7.m.setProgress(r6);
        float r8 = r7.m.getProgress();
        ExposureCompensationInfo r9 = r7.n.getCameraECInfo();
        if (r9 == null) goto L18;
        int r10 = r9.getMin();
        int r11 = r9.getMax();
        if (Math.abs(r10) >= Math.abs(r11)) goto L15;
        r11 = -r10;
    L17:
        r7.n.setExposure((int) ((r8 * (r11 - r10)) + r10));
        goto L18
    L15:
        if (Math.abs(r11) >= Math.abs(r10)) goto L17;
        r10 = -r11;
    L18:
        ((AnimatorSet) r7.j.getValue()).start();
        ((AnimatorSet) r7.i.getValue()).start();
        return;
    L7:
        ((AnimatorSet) r7.i.getValue()).end();
        ((AnimatorSet) r7.j.getValue()).end();
        goto L8
    }
}

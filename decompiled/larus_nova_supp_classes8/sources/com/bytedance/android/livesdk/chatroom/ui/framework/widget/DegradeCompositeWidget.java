package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.animation.ValueAnimator;
import android.provider.Settings;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.kw0;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/DegradeCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DegradeCompositeWidget extends MiddlewareRoomWidget implements Observer<KVData> {
    public com.bytedance.android.livesdk.chatroom.ui.framework.c a;
    public com.bytedance.android.livesdk.chatroom.ui.framework.a b;
    public final CompositeDisposable c;

    public static final class a implements Runnable {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r0 = com.bytedance.android.livesdk.performance.degrade.f.a;     // Catch: Throwable -> L4
            ALogger.i("DeviceDegrade", "LivePlayFragment observePlayerEventHub reSetHasFirstFrame false");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public DegradeCompositeWidget() {
        this.c = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.a = ho1.a.d(getComponentContext());
        this.b = ho1.a.c(getComponentContext());
        if (kw0.a.getValue().booleanValue() == true) goto L26;
    L15:
        int r0 = com.bytedance.android.live.room.y.a;
        com.bytedance.android.live.room.y.a(((Widget) this).dataCenter, this.c, "DegradeCompositeWidget->LiveRoomDegradeReminder", a.a);
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L18;
        r1.observe("interaction_on_first_frame", this, true);
    L18:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r2 = this.b;
        if (r2 == null) goto L28;
        PropertyOwner r3 = r2.getLoadState();
        if (r3 == null) goto L29;
        Disposable r4 = com.bytedance.android.livesdk.chatroom.ui.framework.b.f(r3, new AnonymousClass2(this));
        if (r4 == null) goto L30;
        RxUtilKt.c(r4, this.c);
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L26:
        Reflect r5 = Reflect.on(ValueAnimator.class);     // Catch: Throwable -> L11
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L11
        if (getContext() != null) goto L9;
    L12:
        Float r7 = (Float) r5.get("sDurationScale", new Class[0]);     // Catch: Throwable -> L11 Throwable -> L11
        com.bytedance.android.livesdk.log.b0.o().getClass();     // Catch: Throwable -> L11 Throwable -> L11
        com.bytedance.android.live.core.log.g.i("LiveAnimator", "sDurationScale: " + r7);     // Catch: Throwable -> L11 Throwable -> L11
        if (r7.floatValue() > 0.0f) goto L15;
        r6.put("sDurationScale", r7.floatValue());     // Catch: Throwable -> L11 Throwable -> L11
        LiveTracingMonitor.f("ttlive_value_animator_duration_scale_error", LiveTracingMonitor.EventModule.common, r6, new JSONObject(), new JSONObject());     // Catch: Throwable -> L11 Throwable -> L11
        r5.call("setDurationScale", new Class[]{Float.TYPE}, new Object[]{Float.valueOf(1.0f)});     // Catch: Throwable -> L11 Throwable -> L11
        goto L15
    L9:
        if (getContext().getContentResolver() == null) goto L12;
        float r8 = Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f);     // Catch: Throwable -> L11 Throwable -> L11
        r6.put("globalAnimatorDurationScale", r8);     // Catch: Throwable -> L11 Throwable -> L11
        com.bytedance.android.livesdk.log.b0.o().getClass();     // Catch: Throwable -> L11 Throwable -> L11
        com.bytedance.android.live.core.log.g.i("LiveAnimator", "globalAnimatorDurationScale: " + r8);     // Catch: Throwable -> L11 Throwable -> L11
        goto L12
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        this.a = null;
        this.c.dispose();
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hq() != true) goto L24;
        if (r4 == null) goto L9;
        String r5 = r4.getKey();
    L10:
        if (r5 != null) goto L13;
        return;
    L13:
        if (r5.hashCode() == 1922181771) goto L16;
        return;
    L16:
        if (r5.equals("interaction_on_first_frame") == false) goto L22;
        Boolean r6 = (Boolean) ((Widget) this).dataCenter.get("interaction_on_first_frame", Boolean.FALSE);
        ALogger.i("DeviceDegrade", "AbsInteractionFragment setHasFirstFrame = " + r6);
        if (r6.booleanValue() == false) goto L23;
        int r7 = com.bytedance.android.livesdk.performance.degrade.f.a;
        return;
    L23:
        return;
    L22:
        return;
    L9:
        r5 = null;
        goto L10
    }
}

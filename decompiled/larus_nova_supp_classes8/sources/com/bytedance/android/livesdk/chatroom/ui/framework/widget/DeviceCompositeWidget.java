package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.utils.HeadsetBroadcastReceiver;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.fc;
import com.bytedance.android.livesdk.config.hx;
import com.bytedance.crash.Npth;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/DeviceCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/n;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeviceCompositeWidget extends MiddlewareRoomWidget implements n {
    public static final /* synthetic */ int h = 0;
    public com.bytedance.android.livesdk.chatroom.ui.framework.c a;
    public final Lazy b;
    public final Lazy c;
    public final PropertyOwner<h80.c<n.a>> d;
    public final HeadsetBroadcastReceiver e;
    public final CompositeDisposable f;
    public boolean g;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ DeviceCompositeWidget a;

        public b(DeviceCompositeWidget r1) {
            this.a = r1;
        }

        public final void a() {
            DeviceCompositeWidget r0 = this.a;
            int r1 = DeviceCompositeWidget.h;
            if (r0.getContext() != null) goto L5;
            return;
        L5:
            if (r0.g == false) goto L25;
            Context r2 = r0.getContext();     // Catch: Exception -> L19
            HeadsetBroadcastReceiver r3 = r0.e;     // Catch: Exception -> L19
            ReceiverRegisterLancet.loge(r3, false);     // Catch: Exception -> L19
            if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L22;
            r2.unregisterReceiver(r3);     // Catch: Exception -> L19
        L17:
            r0.g = false;     // Catch: Exception -> L19
            return;
        L22:
        L12:
            e = move-exception;
            if (r3 == null) goto L15;
            Npth.addTag("unregisterReceiver", r3.toString());     // Catch: Exception -> L19
        L15:
            e.printStackTrace();     // Catch: Exception -> L19
            goto L17
        L9:
            if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r3, r2) == false) goto L17;
            r2.unregisterReceiver(r3);     // Catch: Exception -> L12
        L26:
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
        public final /* synthetic */ DeviceCompositeWidget a;

        public c(DeviceCompositeWidget r1) {
            this.a = r1;
        }

        public final void a() {
            DeviceCompositeWidget r0 = this.a;
            int r1 = DeviceCompositeWidget.h;
            if (r0.getContext() == null) goto L13;
            IntentFilter r2 = new IntentFilter();
            r2.addAction("android.intent.action.HEADSET_PLUG");
            r2.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
            r2.addAction("android.bluetooth.a2dp.profile.action.ACTIVE_DEVICE_CHANGED");
            r2.addAction("android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED");
        L11:
            e = move-exception;
            e.printStackTrace();
            ALogger.e("DeviceCompositeWidget", "registerReceiver " + e.getMessage());
            goto L13
        L6:
            if (Build.VERSION.SDK_INT < 34) goto L8;
            DeviceCompositeWidget.wq(r0.getContext(), r0.e, r2);     // Catch: IllegalArgumentException -> L11
        L9:
            r0.g = true;     // Catch: IllegalArgumentException -> L11
            goto L13
        L8:
            DeviceCompositeWidget.xq(r0.getContext(), r0.e, r2);     // Catch: IllegalArgumentException -> L11
        L13:
            com.bytedance.android.livesdk.chatroom.utils.b0.g();
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
    }

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    public DeviceCompositeWidget() {
        this.b = LazyKt.lazy(DeviceCompositeWidget$isPadDevice$2.INSTANCE);
        this.c = LazyKt.lazy(DeviceCompositeWidget$isFoldDevice$2.INSTANCE);
        this.d = new PropertyOwner(h80.c.b);
        this.e = new HeadsetBroadcastReceiver();
        this.f = new CompositeDisposable();
        new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.a = ho1.a.d(getComponentContext());
        com.bytedance.android.livesdk.utils.ntp.e.b(getContext());
        int r0 = com.bytedance.android.live.room.y.a;
        com.bytedance.android.live.room.y.a(((Widget) this).dataCenter, this.f, "DeviceCompositeWidget#NetworkChangeEvent", new AnonymousClass1(this));
        h70.b r1 = getComponentContext();
        if (r1 == null) goto L8;
        IAbilityCenter r2 = r1.a();
        if (r2 == null) goto L9;
        r2.registerAbility(n.class, this);
        return;
    L9:
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L7;
        IAbilityCenter r1 = r0.a();
        if (r1 == null) goto L7;
        r1.unregisterAbility(n.class);
    L7:
        this.a = null;
        if (this.f.isDisposed() == true) goto L11;
        this.f.dispose();
        return;
    }

    public final void onPause() {
        super.onPause();
        int r0 = com.bytedance.android.live.room.y.a;
        com.bytedance.android.live.room.y.a(((Widget) this).dataCenter, this.f, "DeviceCompositeWidget->unregisterHeadsetListener", new b(this));
    }

    public final void onResume() {
        super.onResume();
        int r0 = com.bytedance.android.live.room.y.a;
        com.bytedance.android.live.room.y.a(((Widget) this).dataCenter, this.f, "DeviceCompositeWidget->registerHeadsetListener", new c(this));
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.n
    public final PropertyOwner sa() {
        return this.d;
    }

    public final void onConfigurationChanged(Configuration r5) {
        Intrinsics.checkNotNullParameter(r5, "newConfig");
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onConfigurationChanged(r5);
        if (hx.a.getValue().booleanValue() == false) goto L7;
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L7;
        r0.put("cmd_anchor_audio_fold_screen", Boolean.TRUE);
    L7:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r1 = this.a;
        boolean r2 = false;
        if (r1 != null) goto L10;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == false) goto L24;
        Integer r4 = fc.a.getValue();
        if (r4 == null) goto L24;
        if (r4.intValue() != 2) goto L24;
        IScreenRotateService r6 = jc1.k.f(IScreenRotateService.class);
        if (r6 == null) goto L24;
        a81.a r7 = r6.configHandler();
        if (r7 == null) goto L24;
        r7.a(((Widget) this).dataCenter, r5);
    L24:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r8 = this.a;
        if (r8 != null) goto L27;
    L29:
        if (r2 == true) goto L31;
        return;
    L31:
        if (((Boolean) this.b.getValue()).booleanValue() == false) goto L33;
    L34:
        PropertyOwner<h80.c<n.a>> r9 = this.d;
        boolean r10 = ((Boolean) this.b.getValue()).booleanValue();
        ((Boolean) this.c.getValue()).booleanValue();
        r9.a(new h80.c(new n.a(r5, r10)));
        return;
    L33:
        if (((Boolean) this.c.getValue()).booleanValue() == true) goto L34;
        return;
    L27:
        if (r8.V9() != true) goto L29;
        r2 = true;
        goto L29
    L10:
        if (r1.dg() != true) goto L12;
        r3 = true;
        goto L13
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void wq(Context r9, HeadsetBroadcastReceiver r10, IntentFilter r11) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r10, r11, 2);
        return;
    L38:
        throw e;
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r11) == false) goto L22;
        int r1 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r10, r11, 2, null, null, 3, r9).result;     // Catch: Exception -> L33
        if (r1 == 1) goto L19;
        if (r1 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r1 == 3) goto L40;
        r9.registerReceiver(r10, r11, 2);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L19:
        r9.registerReceiver(r10, r11, 2);     // Catch: Exception -> L33
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r9.registerReceiver(r10, r11, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r9.registerReceiver(r10, r11, 2);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r11) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r9, r10, r11, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void xq(Context r8, HeadsetBroadcastReceiver r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L22;
        int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8).result;     // Catch: Exception -> L33
        if (r0 != 1) goto L12;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L12:
        if (r0 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r0 == 3) goto L40;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }
}

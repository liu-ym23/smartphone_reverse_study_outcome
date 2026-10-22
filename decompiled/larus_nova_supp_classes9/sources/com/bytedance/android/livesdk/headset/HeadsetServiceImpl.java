package com.bytedance.android.livesdk.headset;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.livesdkapi.service.HeadsetType;
import com.bytedance.android.livesdkapi.service.IHeadsetChange;
import com.bytedance.android.livesdkapi.service.IHeadsetService;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.concurrent.CopyOnWriteArrayList;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u000b*\u0001\u001b\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010 ¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/headset/HeadsetServiceImpl;", "Lcom/bytedance/android/livesdkapi/service/IHeadsetService;", "Lcom/bytedance/android/livesdkapi/service/HeadsetType;", "getHeadsetType", BuildConfig.FLAVOR, "updateFeatureValue", "Landroid/content/Context;", "context", "init", BuildConfig.FLAVOR, "forceRefresh", "getHeadSetType", "startListenHeadSetChange", "Lcom/bytedance/android/livesdkapi/service/IHeadsetChange;", "listener", "addHeadsetChangeListener", "removeHeadsetChangeListener", "currentType", "Lcom/bytedance/android/livesdkapi/service/HeadsetType;", "startedListenChange", "Z", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listenerList$delegate", "Lkotlin/Lazy;", "getListenerList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "listenerList", "com/bytedance/android/livesdk/headset/HeadsetServiceImpl$headsetBroadcastReceiver$2$1", "headsetBroadcastReceiver$delegate", "getHeadsetBroadcastReceiver", "()Lcom/bytedance/android/livesdk/headset/HeadsetServiceImpl$headsetBroadcastReceiver$2$1;", "headsetBroadcastReceiver", "Landroid/content/Context;", "<init>", "()V", "Companion", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeadsetServiceImpl implements IHeadsetService {
    public static final a Companion = null;
    public static final String TAG = "HeadsetServiceImpl";
    private Context context;
    private HeadsetType currentType;
    private final Lazy headsetBroadcastReceiver$delegate;
    private final Lazy listenerList$delegate;
    private boolean startedListenChange;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private final HeadsetServiceImpl$headsetBroadcastReceiver$2.AnonymousClass1 getHeadsetBroadcastReceiver() {
        return (HeadsetServiceImpl$headsetBroadcastReceiver$2.AnonymousClass1) this.headsetBroadcastReceiver$delegate.getValue();
    }

    private final CopyOnWriteArrayList<IHeadsetChange> getListenerList() {
        return (CopyOnWriteArrayList) this.listenerList$delegate.getValue();
    }

    private final HeadsetType getHeadsetType() {
        Context r0 = this.context;
        Object r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.getSystemService("audio");
    L7:
        if ((r2 instanceof AudioManager) == false) goto L10;
        r1 = r2;
    L10:
        AudioManager r3 = (AudioManager) r1;
        if (r3 == null) goto L42;
        ALogger.i(TAG, "get headset type use audio manager");
        if (Build.VERSION.SDK_INT < 23) goto L31;
        AudioDeviceInfo[] r4 = r3.getDevices(2);
        if (r4.length <= 0) goto L42;
        int r5 = r4[0].getType();
        if (r5 == 3) goto L29;
        if (r5 == 4) goto L46;
        if (r5 == 7) goto L45;
        if (r5 == 8) goto L44;
        return HeadsetType.UnKnow;
    L44:
        return HeadsetType.BluetoothA2DP;
    L45:
        return HeadsetType.BluetoothSco;
    L46:
        return HeadsetType.WiredHeadPhones;
    L29:
        return HeadsetType.WiredHeadSet;
    L31:
        if (r3.isWiredHeadsetOn() == false) goto L34;
        return HeadsetType.WiredHeadSet;
    L34:
        if (r3.isBluetoothScoOn() == false) goto L37;
        return HeadsetType.BluetoothSco;
    L37:
        if (r3.isBluetoothA2dpOn() == false) goto L40;
        return HeadsetType.BluetoothA2DP;
    L40:
        return HeadsetType.UnKnow;
    L42:
        return HeadsetType.Null;
    L5:
        r2 = null;
        goto L7
    }

    private final void updateFeatureValue() {
        IFeatureService r0 = k.f(IFeatureService.class);
        if (r0 == null) goto L17;
        z90.a r1 = r0.getFeatureManager();
        if (r1 == null) goto L18;
        HeadsetType r2 = this.currentType;
        int r3 = com.bytedance.android.livesdk.headset.a.a[r2.ordinal()];
        int r4 = 1;
        if (r3 == 1) goto L14;
        if (r3 == 2) goto L14;
        if (r3 != 3) goto L12;
    L15:
        z90.a.a.a(r1, "live_audio_play_type", Integer.valueOf(r4));
        return;
    L12:
        if (r3 == 4) goto L15;
        r4 = 0;
    L14:
        r4 = 2;
        goto L15
    L18:
        return;
    }

    public void startListenHeadSetChange() {
        if (this.startedListenChange == true) goto L11;
        Context r0 = this.context;     // Catch: Throwable -> L8
        if (r0 == null) goto L12;
        ALogger.i(TAG, "started listen headset change");     // Catch: Throwable -> L8
        this.startedListenChange = true;     // Catch: Throwable -> L8
        INVOKEVIRTUAL_com_bytedance_android_livesdk_headset_HeadsetServiceImpl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r0, getHeadsetBroadcastReceiver(), getHeadsetBroadcastReceiver().a);     // Catch: Throwable -> L8
        return;
    L12:
        return;
    L13:
        return;
    }

    public HeadsetServiceImpl() {
        this.currentType = HeadsetType.Null;
        this.listenerList$delegate = LazyKt.lazy(HeadsetServiceImpl$listenerList$2.INSTANCE);
        this.headsetBroadcastReceiver$delegate = LazyKt.lazy(new HeadsetServiceImpl$headsetBroadcastReceiver$2(this));
        k.l(IHeadsetService.class, this);
        ALogger.i(TAG, "register headsetService succeed");
    }

    public static final /* synthetic */ HeadsetType access$getCurrentType$p(HeadsetServiceImpl r0) {
        return r0.currentType;
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getListenerList$p(HeadsetServiceImpl r0) {
        return r0.getListenerList();
    }

    public static final /* synthetic */ void access$updateFeatureValue(HeadsetServiceImpl r0) {
        r0.updateFeatureValue();
    }

    public void addHeadsetChangeListener(IHeadsetChange r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        getListenerList().add(r2);
    }

    public HeadsetType getHeadSetType(boolean r3) {
        if (r3 == true) goto L5;
        HeadsetType r4 = this.currentType;
        if (r4 == HeadsetType.Null) goto L5;
        return r4;
    L5:
        HeadsetType r5 = getHeadsetType();
        ALogger.i(TAG, "get Headset type result: " + r5.getTypeValue() + ' ');
        if (r5 == HeadsetType.Null) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L12;
        r5 = null;
    L12:
        if (r5 == null) goto L15;
        this.currentType = r5;
        updateFeatureValue();
        return r5;
    L15:
        return this.currentType;
    L8:
        r0 = false;
        goto L9
    }

    public void init(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
        getHeadSetType(false);
    }

    public void removeHeadsetChangeListener(IHeadsetChange r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        getListenerList().remove(r2);
    }

    public static final /* synthetic */ void access$setCurrentType$p(HeadsetServiceImpl r0, HeadsetType r1) {
        r0.currentType = r1;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_android_livesdk_headset_HeadsetServiceImpl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r8, BroadcastReceiver r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r10 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8);     // Catch: Exception -> L36
        int r1 = r0.result;     // Catch: Exception -> L36
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        return r8.registerReceiver(r9, r10);
    L19:
        return r0.intent;
    L21:
        return new Intent();
    L23:
        return r8.registerReceiver(r9, r10);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r8.registerReceiver(r9, r10);
    }
}

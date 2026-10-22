package com.byted.cast.sdk.core;

import android.os.Handler;
import android.os.HandlerThread;
import com.byted.cast.sdk.IRTCEngineEventListener;
import com.byted.cast.sdk.RTCEngine;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class RTCEventNotifier implements IRTCEngineEventListener {
    private static final String TAG = "RTCEventNotifier";
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private IRTCEngineEventListener mRTCEngineEventListener;

    public static /* synthetic */ void a(RTCEventNotifier r0, int r1, int r10, int r11, int r12) {
        r0.lambda$onCastPortSet$10(r1, r10, r11, r12);
    }

    public static /* synthetic */ void b(RTCEventNotifier r0, int r1, int r10, int r11, int r12) {
        r0.lambda$onCastPortUnSet$11(r1, r10, r11, r12);
    }

    public static /* synthetic */ void c(RTCEventNotifier r0, int r1) {
        r0.lambda$onServerStart$12(r1);
    }

    public static /* synthetic */ void d(RTCEventNotifier r0, String r1, String r10) {
        r0.lambda$onSinkLatencyStat$7(r1, r10);
    }

    public static /* synthetic */ void e(RTCEventNotifier r0, String r1) {
        r0.lambda$onStuckStat$1(r1);
    }

    public static /* synthetic */ void f(RTCEventNotifier r0, String r1) {
        r0.lambda$onFirstVideoFrame$8(r1);
    }

    public static /* synthetic */ void g(RTCEventNotifier r0, String r1, String r10) {
        r0.lambda$onSinkStuckStat$2(r1, r10);
    }

    public static /* synthetic */ void h(RTCEventNotifier r0, int r1, int r10, String r11) {
        r0.lambda$onInfo$9(r1, r10, r11);
    }

    public static /* synthetic */ void i(RTCEventNotifier r0, String r1) {
        r0.lambda$onIntoBackground$5(r1);
    }

    public static /* synthetic */ void j(RTCEventNotifier r0, String r1, String r10) {
        r0.lambda$onMonitorEvent$3(r1, r10);
    }

    public static /* synthetic */ void k(RTCEventNotifier r0, int r1) {
        r0.lambda$onServerStop$13(r1);
    }

    public static /* synthetic */ void l(RTCEventNotifier r0, String r1) {
        r0.lambda$onIntoForeground$6(r1);
    }

    public static /* synthetic */ void m(RTCEventNotifier r0, String r1) {
        r0.lambda$onStat$0(r1);
    }

    public static /* synthetic */ void n(RTCEventNotifier r0) {
        r0.lambda$onKilled$4();
    }

    private /* synthetic */ void lambda$onKilled$4() {
        this.mRTCEngineEventListener.onKilled();
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onCancelSuccess() {
        this.mHandler.post(new AnonymousClass6(this));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onCastSuccess() {
        this.mHandler.post(new AnonymousClass5(this));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onKilled() {
        this.mHandler.post(new i(this));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onPaused() {
        this.mHandler.post(new AnonymousClass11(this));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onResumed() {
        this.mHandler.post(new AnonymousClass10(this));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onStopped() {
        this.mHandler.post(new AnonymousClass12(this));
    }

    public void remove() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandlerThread.quit();
    }

    public RTCEventNotifier(IRTCEngineEventListener r10) {
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2(TAG);
        this.mHandlerThread = r0;
        ThreadMethodProxy.start(r0);
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        this.mRTCEngineEventListener = r10;
    }

    public static /* synthetic */ IRTCEngineEventListener access$000(RTCEventNotifier r0) {
        return r0.mRTCEngineEventListener;
    }

    private /* synthetic */ void lambda$onFirstVideoFrame$8(String r10) {
        this.mRTCEngineEventListener.onFirstVideoFrame(r10);
    }

    private /* synthetic */ void lambda$onIntoBackground$5(String r10) {
        this.mRTCEngineEventListener.onIntoBackground(r10);
    }

    private /* synthetic */ void lambda$onIntoForeground$6(String r10) {
        this.mRTCEngineEventListener.onIntoForeground(r10);
    }

    private /* synthetic */ void lambda$onServerStart$12(int r10) {
        this.mRTCEngineEventListener.onServerStart(r10);
    }

    private /* synthetic */ void lambda$onServerStop$13(int r10) {
        this.mRTCEngineEventListener.onServerStop(r10);
    }

    private /* synthetic */ void lambda$onStat$0(String r10) {
        this.mRTCEngineEventListener.onStat(r10);
    }

    private /* synthetic */ void lambda$onStuckStat$1(String r10) {
        this.mRTCEngineEventListener.onStuckStat(r10);
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onCancelRequest(final String r10) {
        this.mHandler.post(new AnonymousClass15(this, r10));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onConnectStateChanged(final RTCEngine.ConnectState r10) {
        this.mHandler.post(new AnonymousClass1(this, r10));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onFirstVideoFrame(final String r10) {
        this.mHandler.post(new m(this, r10));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onIntoBackground(final String r10) {
        this.mHandler.post(new h(this, r10));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onIntoForeground(final String r10) {
        this.mHandler.post(new k(this, r10));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onRecvMetaData(final String r10) {
        this.mHandler.post(new AnonymousClass9(this, r10));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onServerStart(final int r10) {
        this.mHandler.post(new l(this, r10));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onServerStop(final int r10) {
        this.mHandler.post(new j(this, r10));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onStat(final String r10) {
        this.mHandler.post(new f(this, r10));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onStuckStat(final String r10) {
        this.mHandler.post(new e(this, r10));
    }

    private /* synthetic */ void lambda$onMonitorEvent$3(String r10, String r11) {
        this.mRTCEngineEventListener.onMonitorEvent(r10, r11);
    }

    private /* synthetic */ void lambda$onSinkLatencyStat$7(String r10, String r11) {
        this.mRTCEngineEventListener.onSinkLatencyStat(r10, r11);
    }

    private /* synthetic */ void lambda$onSinkStuckStat$2(String r10, String r11) {
        this.mRTCEngineEventListener.onSinkStuckStat(r10, r11);
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onCastControl(final int r10, final int r11) {
        this.mHandler.post(new AnonymousClass7(this, r10, r11));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public boolean onCastRequest(String r10, String r11) {
        return this.mRTCEngineEventListener.onCastRequest(r10, r11);
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onConnect(final String r10, final String r11) {
        this.mHandler.post(new AnonymousClass13(this, r10, r11));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onDisconnect(final RTCEngine.ExitReason r10, final String r11) {
        this.mHandler.post(new AnonymousClass8(this, r10, r11));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onError(final int r10, final String r11) {
        this.mHandler.post(new AnonymousClass3(this, r10, r11));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onLogMonitor(final String r10, final String[][] r11) {
        this.mHandler.post(new AnonymousClass2(this, r10, r11));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onMonitorEvent(final String r10, final String r11) {
        this.mHandler.post(new p(this, r10, r11));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onRecvMetaData(final String r10, final String r11) {
        this.mHandler.post(new AnonymousClass16(this, r10, r11));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onSinkLatencyStat(final String r10, final String r11) {
        this.mHandler.post(new d(this, r10, r11));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onSinkStuckStat(final String r10, final String r11) {
        this.mHandler.post(new n(this, r10, r11));
    }

    private /* synthetic */ void lambda$onInfo$9(int r10, int r11, String r12) {
        this.mRTCEngineEventListener.onInfo(r10, r11, r12);
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onAudioSetVolume(final String r10, final float r11, final float r12) {
        this.mHandler.post(new AnonymousClass17(this, r10, r11, r12));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onConnectSuccess(final int r10, final int r11, final int r12) {
        this.mHandler.post(new AnonymousClass4(this, r10, r11, r12));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onDisconnect(final String r10, final RTCEngine.ExitReason r11, final String r12) {
        this.mHandler.post(new AnonymousClass14(this, r10, r11, r12));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onInfo(final int r10, final int r11, final String r12) {
        this.mHandler.post(new o(this, r10, r11, r12));
    }

    private /* synthetic */ void lambda$onCastPortSet$10(int r10, int r11, int r12, int r13) {
        this.mRTCEngineEventListener.onCastPortSet(r10, r11, r12, r13);
    }

    private /* synthetic */ void lambda$onCastPortUnSet$11(int r10, int r11, int r12, int r13) {
        this.mRTCEngineEventListener.onCastPortUnSet(r10, r11, r12, r13);
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void OnVideoSizeChanged(final String r10, final int r11, final int r12, final int r13) {
        this.mHandler.post(new AnonymousClass18(this, r10, r11, r12, r13));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onCastPortSet(final int r10, final int r11, final int r12, final int r13) {
        this.mHandler.post(new c(this, r10, r11, r12, r13));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onCastPortUnSet(final int r10, final int r11, final int r12, final int r13) {
        this.mHandler.post(new g(this, r10, r11, r12, r13));
    }

    @Override // com.byted.cast.sdk.IRTCEngineEventListener
    public void onVideoEncoder(final String r13, final int r14, final int r15, final int r16, final int r17, final boolean r18, final int r19) {
        this.mHandler.post(new AnonymousClass19(this, r13, r14, r15, r16, r17, r18, r19));
    }
}

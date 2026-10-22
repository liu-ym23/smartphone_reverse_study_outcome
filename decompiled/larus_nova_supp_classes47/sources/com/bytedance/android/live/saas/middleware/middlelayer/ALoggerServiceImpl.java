package com.bytedance.android.live.saas.middleware.middlelayer;

import android.content.Intent;
import android.os.Bundle;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.alog.ILogProtocol;
import com.bytedance.badger.collect.impl.BuildConfig;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.ss.alog.middleware.ALogService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u001c\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\u000f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J$\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u0015\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J$\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J/\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0016¢\u0006\u0002\u0010 J$\u0010!\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\"\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010#\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010$\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J&\u0010$\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010$\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/middlelayer/ALoggerServiceImpl;", "Lcom/ss/alog/middleware/ALogService;", "()V", "bundle", "", "priority", "", "tag", "", "Landroid/os/Bundle;", "changeLevel", "level", "d", Constants.OperatorKey.MSG, "destroy", "e", "throwable", "", "flush", "forceLogSharding", Constants.Keys.HEADER, "i", "init", "customName", "intent", "Landroid/content/Intent;", "json", BuildConfig.BUILD_TYPE, "statcktrace", "traceElements", "", "Ljava/lang/StackTraceElement;", "(ILjava/lang/String;[Ljava/lang/StackTraceElement;)V", "thread", "Ljava/lang/Thread;", "v", "w", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class ALoggerServiceImpl extends ALogService {
    public void init() {
    }

    public void init(String r1) {
    }

    public void destroy() {
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public void flush() {
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.flush();
        return;
    }

    public void forceLogSharding() {
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.forceLogSharding();
        return;
    }

    public void release() {
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.release();
        return;
    }

    public ALoggerServiceImpl() {
    }

    public void changeLevel(int r2) {
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.changeLevel(r2);
        return;
    }

    public void d(String r2, String r3) {
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.d(r2, r3);
        return;
    }

    public void e(String r2, String r3) {
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.e(r2, r3);
        return;
    }

    public void i(String r2, String r3) {
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.i(r2, r3);
        return;
    }

    public void v(String r2, String r3) {
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.v(r2, r3);
        return;
    }

    public void w(String r2, String r3) {
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.w(r2, r3);
        return;
    }

    public void e(String r2, Throwable r3) {
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.e(r2, r3);
        return;
    }

    public void w(String r2, Throwable r3) {
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.w(r2, r3);
        return;
    }

    public void bundle(int r2, String r3, Bundle r4) {
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.bundle(r2, r3, r4);
        return;
    }

    public void e(String r2, String r3, Throwable r4) {
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.e(r2, r3, r4);
        return;
    }

    public void header(int r2, String r3, String r4) {
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.header(r2, r3, r4);
        return;
    }

    public void intent(int r2, String r3, Intent r4) {
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.intent(r2, r3, r4);
        return;
    }

    public void json(int r2, String r3, String r4) {
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.json(r2, r3, r4);
        return;
    }

    public void statcktrace(int r2, String r3, StackTraceElement[] r4) {
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.stacktrace(r2, r3, r4);
        return;
    }

    public void thread(int r2, String r3, Thread r4) {
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.thread(r2, r3, r4);
        return;
    }

    public void throwable(int r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "throwable");
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.stacktrace(r2, r3, r4.getStackTrace());
        return;
    }

    public void w(String r2, String r3, Throwable r4) {
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.w(r2, r3, r4);
        return;
    }
}

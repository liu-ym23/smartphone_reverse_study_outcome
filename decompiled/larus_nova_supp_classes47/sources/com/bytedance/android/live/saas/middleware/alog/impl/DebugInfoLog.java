package com.bytedance.android.live.saas.middleware.alog.impl;

import android.content.Intent;
import android.os.Bundle;
import com.bytedance.android.live.saas.middleware.alog.ILogProtocol;
import com.bytedance.badger.collect.impl.BuildConfig;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\nH\u0016J\u0011\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0096\u0001J\u001c\u0010\r\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016J\t\u0010\u000f\u001a\u00020\u0005H\u0096\u0001J)\u0010\u0010\u001a\u00020\u00052\u000e\u0010\b\u001a\n \u0011*\u0004\u0018\u00010\t0\t2\u000e\u0010\u000e\u001a\n \u0011*\u0004\u0018\u00010\t0\tH\u0096\u0001J9\u0010\u0010\u001a\u00020\u00052\u000e\u0010\b\u001a\n \u0011*\u0004\u0018\u00010\t0\t2\u000e\u0010\u000e\u001a\n \u0011*\u0004\u0018\u00010\t0\t2\u000e\u0010\u0012\u001a\n \u0011*\u0004\u0018\u00010\u00130\u0013H\u0096\u0001J)\u0010\u0010\u001a\u00020\u00052\u000e\u0010\b\u001a\n \u0011*\u0004\u0018\u00010\t0\t2\u000e\u0010\u0012\u001a\n \u0011*\u0004\u0018\u00010\u00130\u0013H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0005H\u0096\u0001J\u001f\u0010\u0016\u001a\u00020\t2\u0010\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010\u001aJ$\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\u001c\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016J$\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J$\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016J\t\u0010 \u001a\u00020\u0005H\u0096\u0001J1\u0010!\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u0018H\u0016¢\u0006\u0002\u0010\"J$\u0010#\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J.\u0010%\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010%\u001a\u0004\u0018\u00010\u0013H\u0016J$\u0010%\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010%\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u0010&\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016J)\u0010'\u001a\u00020\u00052\u000e\u0010\b\u001a\n \u0011*\u0004\u0018\u00010\t0\t2\u000e\u0010\u000e\u001a\n \u0011*\u0004\u0018\u00010\t0\tH\u0096\u0001J9\u0010'\u001a\u00020\u00052\u000e\u0010\b\u001a\n \u0011*\u0004\u0018\u00010\t0\t2\u000e\u0010\u000e\u001a\n \u0011*\u0004\u0018\u00010\t0\t2\u000e\u0010\u0012\u001a\n \u0011*\u0004\u0018\u00010\u00130\u0013H\u0096\u0001J)\u0010'\u001a\u00020\u00052\u000e\u0010\b\u001a\n \u0011*\u0004\u0018\u00010\t0\t2\u000e\u0010\u0012\u001a\n \u0011*\u0004\u0018\u00010\u00130\u0013H\u0096\u0001R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/android/live/saas/middleware/alog/impl/DebugInfoLog;", "Lcom/bytedance/android/live/saas/middleware/alog/ILogProtocol;", "aLogService", "(Lcom/bytedance/android/live/saas/middleware/alog/ILogProtocol;)V", "bundle", "", "priority", "", "tag", "", "Landroid/os/Bundle;", "changeLevel", "level", "d", Constants.OperatorKey.MSG, "destroy", "e", "kotlin.jvm.PlatformType", "tr", "", "flush", "forceLogSharding", "getStackTraceString", "traceElements", "", "Ljava/lang/StackTraceElement;", "([Ljava/lang/StackTraceElement;)Ljava/lang/String;", Constants.Keys.HEADER, "i", "intent", "Landroid/content/Intent;", "json", BuildConfig.BUILD_TYPE, "stacktrace", "(ILjava/lang/String;[Ljava/lang/StackTraceElement;)V", "thread", "Ljava/lang/Thread;", "throwable", "v", "w", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class DebugInfoLog implements ILogProtocol {
    private final ILogProtocol aLogService;

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void changeLevel(int r2) {
        this.aLogService.changeLevel(r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void destroy() {
        this.aLogService.destroy();
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void e(String r2, String r3) {
        this.aLogService.e(r2, r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void e(String r2, String r3, Throwable r4) {
        this.aLogService.e(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void e(String r2, Throwable r3) {
        this.aLogService.e(r2, r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void flush() {
        this.aLogService.flush();
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void forceLogSharding() {
        this.aLogService.forceLogSharding();
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void release() {
        this.aLogService.release();
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void w(String r2, String r3) {
        this.aLogService.w(r2, r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void w(String r2, String r3, Throwable r4) {
        this.aLogService.w(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void w(String r2, Throwable r3) {
        this.aLogService.w(r2, r3);
    }

    public DebugInfoLog(ILogProtocol r2) {
        Intrinsics.checkNotNullParameter(r2, "aLogService");
        this.aLogService = r2;
    }

    private final String getStackTraceString(StackTraceElement[] r10) {
        if (r10 == null) goto L12;
        ArrayList r0 = new ArrayList(r10.length);
        int r1 = r10.length;
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L10;
        StackTraceElement r3 = r10[r2];
        if (r3 == null) goto L8;
        String r4 = r3.toString();
    L9:
        r0.add(r4);
        r2 = r2 + 1;
        goto L4
    L8:
        r4 = null;
        goto L9
    L10:
        String r12 = CollectionsKt.joinToString$default(r0, ";\n", null, null, 0, null, null, 62, null);
        if (r12 == null) goto L12;
        return r12;
    L12:
        return "";
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void d(String r2, String r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        this.aLogService.d(r2, r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void i(String r2, String r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        this.aLogService.i(r2, r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void v(String r2, String r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        this.aLogService.v(r2, r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void bundle(int r2, String r3, Bundle r4) {
        if (r2 != 2) goto L5;
        String.valueOf(r4);
    L12:
        this.aLogService.bundle(r2, r3, r4);
        return;
    L5:
        if (r2 != 3) goto L7;
        String.valueOf(r4);
        goto L12
    L7:
        if (r2 != 4) goto L12;
        String.valueOf(r4);
        goto L12
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void header(int r2, String r3, String r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.aLogService.header(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void intent(int r2, String r3, Intent r4) {
        if (r2 != 2) goto L5;
        String.valueOf(r4);
    L12:
        this.aLogService.intent(r2, r3, r4);
        return;
    L5:
        if (r2 != 3) goto L7;
        String.valueOf(r4);
        goto L12
    L7:
        if (r2 != 4) goto L12;
        String.valueOf(r4);
        goto L12
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void json(int r2, String r3, String r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.aLogService.json(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void stacktrace(int r2, String r3, StackTraceElement[] r4) {
        if (r2 != 2) goto L5;
        getStackTraceString(r4);
    L12:
        this.aLogService.stacktrace(r2, r3, r4);
        return;
    L5:
        if (r2 != 3) goto L7;
        getStackTraceString(r4);
        goto L12
    L7:
        if (r2 != 4) goto L12;
        getStackTraceString(r4);
        goto L12
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void thread(int r2, String r3, Thread r4) {
        if (r2 != 2) goto L5;
        String.valueOf(r4);
    L12:
        this.aLogService.thread(r2, r3, r4);
        return;
    L5:
        if (r2 != 3) goto L7;
        String.valueOf(r4);
        goto L12
    L7:
        if (r2 != 4) goto L12;
        String.valueOf(r4);
        goto L12
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void throwable(int r2, String r3, Throwable r4) {
        this.aLogService.throwable(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public void throwable(int r1, String r2, String r3, Throwable r4) {
        this.aLogService.throwable(r1, r2, r4);
    }
}

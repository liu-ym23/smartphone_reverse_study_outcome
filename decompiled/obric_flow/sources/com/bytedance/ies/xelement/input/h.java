package com.bytedance.ies.xelement.input;

import android.graphics.Typeface;
import android.os.Handler;
import android.view.inputmethod.InputMethodManager;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.core.LynxEngineProxy;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import zm.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f6446c;
    public final Object d;
    public final Object e;

    public h(LynxContext r5, LynxBaseInputView r10) {
        this.f6444a = 0;
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "runnableView");
        this.f6446c = r5;
        this.d = r10;
        this.e = new LynxBaseInputView$showSoftInputRetryRunnable$mImmResultReceiver$1(null);
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f6444a) {
            case 0: goto L11;
            case 1: goto L9;
            default: goto L4;
        };
    L4:
        LynxEngineProxy r5 = (LynxEngineProxy) this.e;
        long r10 = r5.f10828a;
        if (r10 != 0) goto L7;
        LynxLog.b(4, "LynxEngineProxy", "invokeLepusApiCallback failed since mNativePtr is null");
        return;
    L7:
        String r11 = (String) this.f6446c;
        ByteBuffer r12 = (ByteBuffer) this.d;
        LynxEngineProxy.c(r5, r10, this.f6445b, r11, r12);
        return;
    L9:
        StringBuilder r13 = new StringBuilder("load font success ");
        r13.append((String) this.f6446c);
        int r14 = this.f6445b;
        r13.append(r14);
        LynxLog.b(2, LynxMonitorService.DEFAULT_PID, r13.toString());
        Typeface r15 = ((com.lynx.tasm.fontface.i) this.e).a(r14);
        ((f0) this.d).b(r15, r14);
        return;
    L11:
        Object r16 = ((LynxContext) this.f6446c).getSystemService("input_method");
        if (r16 == null) goto L21;
        LynxBaseInputView r17 = (LynxBaseInputView) this.d;
        if (((InputMethodManager) r16).showSoftInput(r17.getView(), 1, (LynxBaseInputView$showSoftInputRetryRunnable$mImmResultReceiver$1) this.e) == true) goto L18;
        int r18 = this.f6445b;
        if (r18 >= 3) goto L18;
        this.f6445b = r18 + 1;
        r17.getView().post(this);
        return;
    L18:
        this.f6445b = 0;
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    public h(LynxEngineProxy r5, int r10, String r11, ByteBuffer r12) {
        this.f6444a = 2;
        this.e = r5;
        this.f6445b = r10;
        this.f6446c = r11;
        this.d = r12;
    }

    public h(com.lynx.tasm.fontface.g r5, String r10, int r11, f0 r12, com.lynx.tasm.fontface.i r13, Handler r14) {
        this.f6444a = 1;
        this.f6446c = r10;
        this.f6445b = r11;
        this.d = r12;
        this.e = r13;
    }
}

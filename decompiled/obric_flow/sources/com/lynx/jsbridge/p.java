package com.lynx.jsbridge;

import android.content.Context;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxContext;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RuntimeException f9935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LynxModuleWrapper f9936c;

    public /* synthetic */ p(LynxModuleWrapper r5, RuntimeException r10, int r11) {
        this.f9934a = r11;
        this.f9936c = r5;
        this.f9935b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f9934a) {
            case 0: goto L12;
            default: goto L4;
        };
    L4:
        LynxModuleWrapper r5 = this.f9936c;
        WeakReference r10 = r5.e;
        if (r10 == null) goto L20;
        Context r11 = (Context) r10.get();
        if (r11 != null) goto L9;
        return;
    L9:
        if ((r11 instanceof LynxContext) == false) goto L22;
        LynxError r12 = new LynxError(99900, "NativeModules: getAttributeDescriptors error!moduleName: " + r5.d + " exception: " + this.f9935b.toString(), "", "error");
        r12.f9990a = true;
        ((LynxContext) r11).b(r12);
        return;
    L22:
        return;
    L20:
        return;
    L12:
        LynxModuleWrapper r13 = this.f9936c;
        WeakReference r14 = r13.e;
        if (r14 == null) goto L23;
        Context r15 = (Context) r14.get();
        if (r15 != null) goto L17;
        return;
    L17:
        if ((r15 instanceof LynxContext) == false) goto L25;
        LynxError r16 = new LynxError(99900, "NativeModules: GetMethodDescriptors error!moduleName: " + r13.d + " exception: " + this.f9935b.toString(), "", "error");
        r16.f9990a = true;
        ((LynxContext) r15).b(r16);
        return;
    L25:
        return;
    }
}

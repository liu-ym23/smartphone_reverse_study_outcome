package com.lynx.lottieadapter;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.animax.base.bridge.JavaOnlyArray;
import com.lynx.animax.property.AnimaXKeyPath;
import com.lynx.animax.property.AnimaXPropertyCallback;
import com.lynx.animax.property.AnimaXValueCallback;
import com.lynx.animax.property.AnimaXValueParam;
import com.lynx.animax.property.LayerPropertyType;
import com.lynx.animax.util.AnimaXLog;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LottieAdapterAnimaX$b implements Runnable {
    public final /* synthetic */ d6a.a a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ e6a.b c;
    public final /* synthetic */ LottieAdapterAnimaX d;

    public class a implements AnimaXValueCallback {
        public final /* synthetic */ LottieAdapterAnimaX$b a;

        @Override // com.lynx.animax.property.AnimaXValueCallback
        public final /* synthetic */ Object getValueInternal(float r1, float r2, AnimaXValueParam r3, AnimaXValueParam r4, float r5, float r6, float r7) {
            return AnimaXValueCallback.CC.$default$getValueInternal(this, r1, r2, r3, r4, r5, r6, r7);
        }

        public a(LottieAdapterAnimaX$b r1) {
            this.a = r1;
        }

        @Override // com.lynx.animax.property.AnimaXValueCallback
        public final AnimaXValueParam a(com.lynx.animax.property.a r3) {
            LottieAdapterAnimaX$b r0 = this.a;
            Object r4 = r0.c.a(LottieAdapterAnimaX.access$700(r0.d, r3));
            return LottieAdapterAnimaX.access$800(this.a.d, r4);
        }
    }

    public class b implements AnimaXPropertyCallback {
        @Override // com.lynx.animax.property.AnimaXPropertyCallback
        public final /* synthetic */ void onPropertyCallback(JavaOnlyArray r1) {
            AnimaXPropertyCallback.CC.$default$onPropertyCallback(this, r1);
        }

        @Override // com.lynx.animax.property.AnimaXPropertyCallback
        public final void onSuccess() {
            AnimaXLog.b("LottieAdapterAnimaX", "addValueCallback onSuccess");
        }

        public b() {
        }

        @Override // com.lynx.animax.property.AnimaXPropertyCallback
        public final void a(List<String> r3) {
            AnimaXLog.a("LottieAdapterAnimaX", "addValueCallback onError: " + r3);
        }
    }

    public final void a() {
        if (LottieAdapterAnimaX.access$300(this.d) != null) goto L5;
        return;
    L5:
        if (this.a == null) goto L17;
        Object r0 = this.b;
        if (r0 != null) goto L9;
        return;
    L9:
        if (this.c == null) goto L19;
        LayerPropertyType r1 = LottieAdapterAnimaX.access$600(this.d, r0);
        if (r1 != null) goto L14;
        return;
    L14:
        AnimaXKeyPath r2 = new AnimaXKeyPath((String[]) this.a.a.toArray(new String[0]));
        LottieAdapterAnimaX.access$300(this.d).getPlayer().i(r1, r2, new a(this), new b());
        return;
    L19:
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

    public LottieAdapterAnimaX$b(LottieAdapterAnimaX r1, d6a.a r2, Object r3, e6a.b r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}

package com.bytedance.android.ec.core.vmsdk;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.vmsdk.worker.JsWorker;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class JsWorkerWrapper {
    public final CopyOnWriteArrayList<Pair<String, String>> a;
    public final AtomicBoolean b;
    public final AtomicBoolean c;
    public volatile boolean d;
    public volatile boolean e;
    public final JsWorker f;
    public final String g;

    public static final class a {
    }

    static {
    }

    public final void c() {
    L3:
        if ((!this.a.isEmpty()) == false) goto L16;
        Pair<String, String> r0 = this.a.remove(0);     // Catch: ArrayIndexOutOfBoundsException -> L17
        String r1 = (String) r0.getFirst();     // Catch: ArrayIndexOutOfBoundsException -> L17
        int r10 = r1.hashCode();     // Catch: ArrayIndexOutOfBoundsException -> L17
        if (r10 != (-907685685)) goto L7;
        if (r1.equals("script") == false) goto L3;
        a((String) r0.getSecond());     // Catch: ArrayIndexOutOfBoundsException -> L17
        goto L3
    L7:
        if (r10 != 108417) goto L3;
        if (r1.equals(MessageIndication.MESSAGE_TYPE_MSG) == false) goto L3;
        e((String) r0.getSecond());     // Catch: ArrayIndexOutOfBoundsException -> L17
        goto L3
    }

    public final void a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "script");
        this.f.evaluateJavaScript(r10);
    }

    public final void e(String r10) {
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        if (d(MessageIndication.MESSAGE_TYPE_MSG, r10) == false) goto L5;
        return;
    L5:
        this.f.postMessage(r10);
    }

    public JsWorkerWrapper(JsWorker r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "jsWorker");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        this.f = r10;
        this.g = r11;
        this.a = new CopyOnWriteArrayList();
        r10.setOnErrorCallback(new AnonymousClass1(this));
        this.b = new AtomicBoolean(false);
        this.c = new AtomicBoolean(false);
    }

    public final void b(String r11, String... r12) {
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r12, "params");
        String r13 = r11 + '(' + ArraysKt.joinToString$default(r12, ",", null, null, 0, null, JsWorkerWrapper$executeJsFunction$script$1.INSTANCE, 30, null) + ')';
        if (d("script", r13) == false) goto L5;
        return;
    L5:
        a(r13);
    }

    public final boolean d(String r10, String r11) {
        if (this.d == true) goto L6;
        this.a.add(TuplesKt.to(r10, r11));
        return true;
    L6:
        c();
        return false;
    }
}

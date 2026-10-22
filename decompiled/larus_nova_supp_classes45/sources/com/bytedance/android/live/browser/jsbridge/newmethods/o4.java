package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getDynamicSettings")
public final class o4 extends f<p4, JsonObject> {
    public final String a;

    public o4() {
        this.a = "data.";
    }

    public final void invoke(Object r5, CallContext r6) {
        p4 r7 = (p4) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        List<String> r8 = r7.a();     // Catch: Exception -> L32
        if (r8 != null) goto L6;
    L9:
        boolean r9 = true;
    L10:
        if (r9 == false) goto L12;
        finishWithFailure(new Throwable("keys is null"));     // Catch: Exception -> L32
        return;
    L12:
        List<String> r11 = r7.a();     // Catch: Exception -> L32
        if (r11 == null) goto L27;
        ArrayList r12 = new ArrayList();     // Catch: Exception -> L32
        Iterator<T> r13 = r11.iterator();     // Catch: Exception -> L32
    L16:
        if (r13.hasNext() == false) goto L23;
        Object r2 = r13.next();     // Catch: Exception -> L32
        if (((String) r2).length() <= 0) goto L20;
        boolean r3 = true;
    L21:
        if (r3 == false) goto L16;
        r12.add(r2);     // Catch: Exception -> L32
        goto L16
    L20:
        r3 = false;
        goto L21
    L23:
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));     // Catch: Exception -> L32
        Iterator r15 = r12.iterator();     // Catch: Exception -> L32
    L25:
        if (r15.hasNext() == false) goto L28;
        r14.add(this.a + ((String) r15.next()));     // Catch: Exception -> L32
    L28:
        if (r14 != null) goto L30;
        finishWithFailure(new Throwable("suffixList is null"));     // Catch: Exception -> L32
        return;
    L30:
        jc1.k.n(IHostContext.class).getUgSettingsByKey(1, r14, new n4(this));     // Catch: Exception -> L32
        return;
    L27:
        r14 = null;
        goto L28
    L6:
        if (r8.isEmpty() == true) goto L9;
        r9 = false;
    L32:
        e = move-exception;
        finishWithFailure(e);
    }
}

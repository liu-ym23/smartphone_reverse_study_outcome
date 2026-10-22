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
@XBridgeMethod(biz = "webcast", name = "getActivitySettings")
public final class s3 extends w20.b1<w20.h9, JsonObject> {
    public final String a;

    public s3() {
        this.a = "data.common_info.extra.";
    }

    public final void invoke(Object r5, CallContext r6) {
        w20.h9 r7 = (w20.h9) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        List<String> r8 = r7.a();     // Catch: Exception -> L37
        if (r8 != null) goto L6;
    L9:
        boolean r9 = true;
    L10:
        if (r9 == false) goto L12;
        finishWithFailure(new Throwable("keys is null"));     // Catch: Exception -> L37
        return;
    L12:
        List<String> r11 = r7.a();     // Catch: Exception -> L37
        if (r11 == null) goto L32;
        ArrayList r12 = new ArrayList();     // Catch: Exception -> L37
        Iterator<T> r13 = r11.iterator();     // Catch: Exception -> L37
    L16:
        if (r13.hasNext() == false) goto L28;
        Object r2 = r13.next();     // Catch: Exception -> L37
        String r3 = (String) r2;     // Catch: Exception -> L37
        if (r3 != null) goto L20;
    L25:
        boolean r4 = false;
    L26:
        if (r4 == false) goto L16;
        r12.add(r2);     // Catch: Exception -> L37
        goto L16
    L20:
        if (r3.length() <= 0) goto L22;
        boolean r14 = true;
    L23:
        if (r14 == false) goto L25;
        r4 = true;
        goto L26
    L22:
        r14 = false;
        goto L23
    L28:
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));     // Catch: Exception -> L37
        Iterator r16 = r12.iterator();     // Catch: Exception -> L37
    L30:
        if (r16.hasNext() == false) goto L33;
        r15.add(this.a + ((String) r16.next()));     // Catch: Exception -> L37
    L33:
        if (r15 != null) goto L35;
        finishWithFailure(new Throwable("suffixList is null"));     // Catch: Exception -> L37
        return;
    L35:
        jc1.k.n(IHostContext.class).getUgSettingsByKey(0, r15, new r3(this));     // Catch: Exception -> L37
        return;
    L32:
        r15 = null;
        goto L33
    L6:
        if (r8.isEmpty() == true) goto L9;
        r9 = false;
    L37:
        e = move-exception;
        finishWithFailure(e);
    }
}

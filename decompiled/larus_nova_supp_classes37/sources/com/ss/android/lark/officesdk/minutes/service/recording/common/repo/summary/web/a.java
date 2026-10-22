package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.web;

import android.webkit.ValueCallback;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a<T> implements ValueCallback {
    public final /* synthetic */ Function1<Boolean, Unit> a;

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function1<? super Boolean, Unit> r1) {
        this.a = r1;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r3) {
        String r4 = (String) r3;
        lvb.a.a("MmSummaryNativeToJSHelper", "[checkFishBoneCanScroll] result=" + r4);
        if (r4 == null) goto L7;
        String r5 = StringsKt.trim(r4).toString();
        if (r5 == null) goto L7;
        boolean r6 = Boolean.parseBoolean(r5);
    L8:
        this.a.invoke(Boolean.valueOf(r6));
        return;
    L7:
        r6 = false;
        goto L8
    }
}

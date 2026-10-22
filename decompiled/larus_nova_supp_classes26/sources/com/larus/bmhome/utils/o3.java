package com.larus.bmhome.utils;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class o3 implements Function0 {
    public final /* synthetic */ String a;

    public /* synthetic */ o3(String r1) {
        this.a = r1;
    }

    public final Object invoke() {
        String r0 = this.a;
        ReferenceMessage.Companion.getClass();
        return (ReferenceMessage) GsonProtectorUtils.fromJson((Gson) ReferenceMessage.access$getConvert$delegate$cp().getValue(), r0, ReferenceMessage.class);
    }
}

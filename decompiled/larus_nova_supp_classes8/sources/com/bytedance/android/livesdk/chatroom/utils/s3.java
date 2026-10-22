package com.bytedance.android.livesdk.chatroom.utils;

import io.reactivex.functions.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class s3 implements Function {
    public final /* synthetic */ String a;

    public /* synthetic */ s3(String r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        String r3 = (String) r2;
        return new JSONObject(this.a);
    }
}

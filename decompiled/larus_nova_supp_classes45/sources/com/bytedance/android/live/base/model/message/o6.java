package com.bytedance.android.live.base.model.message;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/base/model/message/o6;", "", "Lcom/bytedance/android/live/base/model/message/a5;", "text", "Lcom/bytedance/android/live/base/model/message/a5;", "a", "()Lcom/bytedance/android/live/base/model/message/a5;", "b", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class o6 implements vh7.h {

    @SerializedName("text")
    protected a5 text;

    public o6() {
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    public o6(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.text = vh7.f.a(r5, a5.class);
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r0);
    }

    public final a5 a() {
        return this.text;
    }

    public final void b(a5 r1) {
        this.text = r1;
    }
}

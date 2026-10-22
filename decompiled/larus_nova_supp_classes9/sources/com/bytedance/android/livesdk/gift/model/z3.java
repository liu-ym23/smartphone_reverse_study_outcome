package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/z3;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "sendActionText", "a", "setSendActionText", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z3 implements vh7.h {

    @SerializedName("send_action_text")
    protected String sendActionText;

    @SerializedName("title")
    protected String title;

    public z3() {
        this.title = BuildConfig.FLAVOR;
        this.sendActionText = BuildConfig.FLAVOR;
    }

    public final String a() {
        return this.sendActionText;
    }

    public z3(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 3) goto L8;
        this.title = am3.h.c(r5);
        goto L3
    L8:
        if (r2 != 5) goto L9;
        this.sendActionText = am3.h.c(r5);
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
        if (this.title != null) goto L16;
        this.title = BuildConfig.FLAVOR;
    L16:
        if (this.sendActionText != null) goto L28;
        this.sendActionText = BuildConfig.FLAVOR;
        return;
    }
}

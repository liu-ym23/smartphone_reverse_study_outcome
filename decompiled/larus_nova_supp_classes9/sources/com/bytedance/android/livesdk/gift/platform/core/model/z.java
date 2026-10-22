package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/z;", BuildConfig.FLAVOR, "Lpy/k;", "popUpImg", "Lpy/k;", "b", "()Lpy/k;", "setPopUpImg", "(Lpy/k;)V", "Lcom/bytedance/android/live/base/model/message/a5;", "popUpText", "Lcom/bytedance/android/live/base/model/message/a5;", "c", "()Lcom/bytedance/android/live/base/model/message/a5;", "setPopUpText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "popUpButtonImg", "a", "setPopUpButtonImg", BuildConfig.FLAVOR, "schemaUrl", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setSchemaUrl", "(Ljava/lang/String;)V", "<init>", "()V", "livegift-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class z implements vh7.h {

    @SerializedName("pop_up_button_img")
    protected py.k popUpButtonImg;

    @SerializedName("pop_up_img")
    protected py.k popUpImg;

    @SerializedName("pop_up_text")
    protected a5 popUpText;

    @SerializedName("scheme_url")
    protected String schemaUrl;

    public z() {
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, py.k] */
    public z(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L18;
        if (r2 != 1) goto L8;
        this.popUpImg = vh7.f.a(r5, py.k.class);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.popUpText = vh7.f.a(r5, a5.class);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.popUpButtonImg = vh7.f.a(r5, py.k.class);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this.schemaUrl = am3.h.c(r5);
        goto L3
    L13:
        am3.h.e(r5);
        goto L3
    L18:
        r5.d(r0);
    }

    public final py.k a() {
        return this.popUpButtonImg;
    }

    public final py.k b() {
        return this.popUpImg;
    }

    public final a5 c() {
        return this.popUpText;
    }

    public final String d() {
        return this.schemaUrl;
    }
}

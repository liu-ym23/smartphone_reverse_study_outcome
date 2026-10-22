package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0016\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/e0;", BuildConfig.FLAVOR, "Lcom/bytedance/android/live/base/model/message/a5;", "text", "Lcom/bytedance/android/live/base/model/message/a5;", BuildConfig.FLAVOR, "textBackgroundColor", "Ljava/lang/String;", "Lpy/k;", "boxImage", "Lpy/k;", "backgroundImage", "uri", BuildConfig.FLAVOR, "animate", "Z", BuildConfig.FLAVOR, "boxId", "Ljava/lang/Long;", "availableBoxCount", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class e0 implements vh7.h {

    @SerializedName("animate")
    public boolean animate;

    @SerializedName("available_box_count")
    public Long availableBoxCount;

    @SerializedName("bg_img")
    public py.k backgroundImage;

    @SerializedName("box_id")
    public Long boxId;

    @SerializedName("box_img")
    public py.k boxImage;

    @SerializedName("display_text")
    public a5 text;

    @SerializedName("display_text_bg_color")
    public String textBackgroundColor;

    @SerializedName("scheme_url")
    public String uri;

    public e0() {
        this.boxId = 0L;
        this.availableBoxCount = 0L;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, py.k] */
    public e0(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        switch(r2) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.availableBoxCount = Long.valueOf(r5.j());
        goto L3
    L8:
        this.boxId = Long.valueOf(r5.j());
        goto L3
    L9:
        this.animate = am3.h.a(r5);
        goto L3
    L10:
        this.uri = am3.h.c(r5);
        goto L3
    L11:
        this.backgroundImage = vh7.f.a(r5, py.k.class);
        goto L3
    L12:
        this.boxImage = vh7.f.a(r5, py.k.class);
        goto L3
    L13:
        this.textBackgroundColor = am3.h.c(r5);
        goto L3
    L14:
        this.text = vh7.f.a(r5, a5.class);
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
        if (this.boxId != null) goto L19;
        this.boxId = 0L;
    L19:
        if (this.availableBoxCount != null) goto L42;
        this.availableBoxCount = 0L;
        return;
    }
}

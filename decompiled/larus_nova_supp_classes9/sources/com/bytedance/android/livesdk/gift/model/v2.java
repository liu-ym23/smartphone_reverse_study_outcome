package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoDecode;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8F@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8F@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00028F@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/v2;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "validMask", "I", "getValidMask", "()I", "setValidMask", "(I)V", BuildConfig.FLAVOR, "pluginInfo", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setPluginInfo", "(Ljava/lang/String;)V", "cardName", "b", "setCardName", "buffLevel", "a", "setBuffLevel", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class v2 implements vh7.h {

    @SerializedName("buff_level")
    @IgnoreProtoDecode
    private int buffLevel;

    @SerializedName("card_name")
    @IgnoreProtoDecode
    private String cardName;

    @SerializedName("plugin_info")
    @IgnoreProtoDecode
    private String pluginInfo;

    @SerializedName("valid_mask")
    protected int validMask;

    public static final class a {
    }

    static {
    }

    public v2() {
    }

    public final int a() {
        if ((this.validMask & 4) > 0) goto L7;
        return 0;
    L7:
        return this.buffLevel;
    }

    public final String b() {
        if ((this.validMask & 2) > 0) goto L7;
        return null;
    L7:
        return this.cardName;
    }

    public final String c() {
        if ((this.validMask & 1) > 0) goto L7;
        return null;
    L7:
        return this.pluginInfo;
    }

    public v2(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.validMask = (int) r5.j();
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r0);
    }
}

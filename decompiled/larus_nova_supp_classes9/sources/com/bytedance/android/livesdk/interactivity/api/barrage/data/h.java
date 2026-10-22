package com.bytedance.android.livesdk.interactivity.api.barrage.data;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/h;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/c;", "redPacket", "Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/c;", "b", "()Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/c;", "setRedPacket", "(Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/c;)V", BuildConfig.FLAVOR, "playContent", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setPlayContent", "(Ljava/lang/String;)V", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h implements vh7.h {

    @SerializedName("play_content")
    protected String playContent;

    @SerializedName("red_packet")
    protected c redPacket;

    public h() {
    }

    public h(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this.redPacket = new c(r5);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.playContent = am3.h.c(r5);
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
    }

    public final String a() {
        return this.playContent;
    }

    public final c b() {
        return this.redPacket;
    }
}

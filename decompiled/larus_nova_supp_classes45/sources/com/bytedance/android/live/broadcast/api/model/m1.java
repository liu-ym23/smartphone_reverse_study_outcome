package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.room.ShareListResponse.ResponseUserData")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000bR\u001a\u0010\u0013\u001a\u00020\f8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0016\u001a\u00020\u00158\u0006X\u0087D¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/m1;", "", "", "userId", "J", "f", "()J", "", "secUserId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "", "relationType", "I", "b", "()I", "descText", "a", "textType", "e", "", "sortScore", "F", "d", "()F", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m1 implements vh7.h {

    @SerializedName("Text")
    protected String descText;

    @SerializedName("RelationType")
    protected int relationType;

    @SerializedName("SecureUserID")
    protected String secUserId;

    @SerializedName("Score")
    protected float sortScore;

    @SerializedName("TextType")
    protected int textType;

    @SerializedName("UserId")
    protected long userId;

    public m1() {
        this.secUserId = "";
        this.descText = "";
    }

    public final String a() {
        return this.descText;
    }

    public final int b() {
        return this.relationType;
    }

    public final String c() {
        return this.secUserId;
    }

    public final float d() {
        return this.sortScore;
    }

    public final int e() {
        return this.textType;
    }

    public final long f() {
        return this.userId;
    }

    public m1(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L13;
        switch(r2) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.sortScore = (float) Double.longBitsToDouble(r5.h());
        goto L3
    L8:
        this.textType = r5.i();
        goto L3
    L9:
        this.descText = am3.h.c(r5);
        goto L3
    L10:
        this.relationType = r5.i();
        goto L3
    L11:
        this.secUserId = am3.h.c(r5);
        goto L3
    L12:
        this.userId = r5.j();
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L13:
        r5.d(r0);
        if (this.secUserId != null) goto L17;
        this.secUserId = "";
    L17:
        if (this.descText != null) goto L36;
        this.descText = "";
        return;
    }
}

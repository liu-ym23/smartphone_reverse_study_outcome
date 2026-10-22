package com.bytedance.android.live.broadcastgame.opengame.network;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.stamp.EntranceVisiableResponse.Data")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/i;", "", "", "disableEntrance", "Z", "a", "()Z", "setDisableEntrance", "(Z)V", "", "startType", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setStartType", "(Ljava/lang/String;)V", "entranceSchemaUrl", "b", "setEntranceSchemaUrl", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i implements vh7.h {
    public static final /* synthetic */ int a = 0;

    @SerializedName("disable_entrance")
    protected boolean disableEntrance;

    @SerializedName("entrance_schema_url")
    protected String entranceSchemaUrl;

    @SerializedName("magic_box_start_type")
    protected String startType;

    public static final class a {
    }

    static {
    }

    public i() {
    }

    public i(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        if (r2 != 1) goto L8;
        this.disableEntrance = am3.h.a(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.startType = am3.h.c(r5);
        goto L3
    L10:
        if (r2 != 5) goto L11;
        this.entranceSchemaUrl = am3.h.c(r5);
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
    }

    public final boolean a() {
        return this.disableEntrance;
    }

    public final String b() {
        return this.entranceSchemaUrl;
    }

    public final String c() {
        return this.startType;
    }
}

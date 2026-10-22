package com.bytedance.android.live.broadcastgame.api.model.response;

import am3.g;
import com.bytedance.android.livesdk.message.model.e0;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.stamp.EntranceInfoResponse.Data")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/response/a;", "", "", "Lcom/bytedance/android/live/broadcastgame/api/model/response/a$a;", "entranceInfoList", "Ljava/util/List;", "a", "()Ljava/util/List;", "setEntranceInfoList", "(Ljava/util/List;)V", "<init>", "()V", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("entrances")
    protected List<C0053a> entranceInfoList;

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.api.model.response.a$a, reason: collision with other inner class name */
    @ProtoMessage("webcast.api.stamp.EntranceInfoResponse.Data.EntranceInfo")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/response/a$a;", "", "Lcom/bytedance/android/livesdk/message/model/e0;", "entranceInfo", "Lcom/bytedance/android/livesdk/message/model/e0;", "b", "()Lcom/bytedance/android/livesdk/message/model/e0;", "setEntranceInfo", "(Lcom/bytedance/android/livesdk/message/model/e0;)V", "", "disableEntrance", "Z", "a", "()Z", "setDisableEntrance", "(Z)V", "<init>", "()V", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C0053a implements h {

        @SerializedName("disable_entrance")
        protected boolean disableEntrance;

        @SerializedName("entrances")
        protected e0 entranceInfo;

        public C0053a() {
        }

        public C0053a(g r5) {
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L12;
            if (r2 != 1) goto L8;
            this.entranceInfo = new e0(r5);
            goto L3
        L8:
            if (r2 != 2) goto L9;
            this.disableEntrance = am3.h.a(r5);
            goto L3
        L9:
            am3.h.e(r5);
            goto L3
        L12:
            r5.d(r0);
        }

        public final boolean a() {
            return this.disableEntrance;
        }

        public final e0 b() {
            return this.entranceInfo;
        }
    }

    public a() {
    }

    public a(g r5) {
        this.entranceInfoList = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.entranceInfoList.add(new C0053a(r5));
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r0);
    }

    public final List<C0053a> a() {
        return this.entranceInfoList;
    }
}

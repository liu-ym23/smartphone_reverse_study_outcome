package com.bytedance.android.live.openplatform.impl.openapi.api.response;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.open.api.GetRoomInfoResponse.Data")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/openapi/api/response/b;", "", "Lcom/bytedance/android/live/openplatform/impl/openapi/api/response/b$a;", "roomInfo", "Lcom/bytedance/android/live/openplatform/impl/openapi/api/response/b$a;", "a", "()Lcom/bytedance/android/live/openplatform/impl/openapi/api/response/b$a;", "setRoomInfo", "(Lcom/bytedance/android/live/openplatform/impl/openapi/api/response/b$a;)V", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements h {

    @SerializedName("room_info")
    protected a roomInfo;

    @ProtoMessage("webcast.open.api.GetRoomInfoResponse.Data.RoomInfo")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/openapi/api/response/b$a;", "", "", "roomId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setRoomId", "(Ljava/lang/String;)V", "", "liveDuration", "Ljava/lang/Long;", "a", "()Ljava/lang/Long;", "setLiveDuration", "(Ljava/lang/Long;)V", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements h {

        @SerializedName("live_duration")
        protected Long liveDuration;

        @SerializedName("room_id")
        protected String roomId;

        public a() {
            this.roomId = "";
            this.liveDuration = 0L;
        }

        public final Long a() {
            return this.liveDuration;
        }

        public final String b() {
            return this.roomId;
        }

        public a(g r5) {
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L12;
            if (r2 != 1) goto L8;
            this.roomId = am3.h.c(r5);
            goto L3
        L8:
            if (r2 != 2) goto L9;
            this.liveDuration = Long.valueOf(r5.i());
            goto L3
        L9:
            am3.h.e(r5);
            goto L3
        L12:
            r5.d(r0);
            if (this.roomId != null) goto L16;
            this.roomId = "";
        L16:
            if (this.liveDuration != null) goto L28;
            this.liveDuration = 0L;
            return;
        }
    }

    public b() {
    }

    public b(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.roomInfo = new a(r5);
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r0);
    }

    public final a a() {
        return this.roomInfo;
    }
}

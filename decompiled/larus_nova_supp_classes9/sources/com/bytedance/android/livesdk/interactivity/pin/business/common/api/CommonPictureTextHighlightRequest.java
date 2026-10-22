package com.bytedance.android.livesdk.interactivity.pin.business.common.api;

import am3.g;
import com.bytedance.android.live.network.c;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import io.reactivex.Observable;
import java.util.HashMap;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.room.CommonPictureTextHighlightRequest")
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\b\u0007\u0018\u0000  2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001a¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/business/common/api/CommonPictureTextHighlightRequest;", BuildConfig.FLAVOR, "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/interactivity/pin/business/common/api/CommonPictureTextHighlightResponse;", "request", BuildConfig.FLAVOR, "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", BuildConfig.FLAVOR, "actionType", "I", "getActionType", "()I", "setActionType", "(I)V", BuildConfig.FLAVOR, "roomId", "J", "getRoomId", "()J", "setRoomId", "(J)V", "pinId", "getPinId", "setPinId", "<init>", "()V", "Companion", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonPictureTextHighlightRequest implements h {
    public static final int ACTION_TYPE_NOT_SUPPORT = 0;
    public static final int ACTION_TYPE_PIN = 1;
    public static final int ACTION_TYPE_UNPIN = 2;
    public static final a Companion = null;

    @SerializedName("action_type")
    protected int actionType;

    @SerializedName("pin_id")
    protected long pinId;

    @SerializedName("room_id")
    protected long roomId;

    @SerializedName("scene")
    protected String scene;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CommonPictureTextHighlightRequest() {
    }

    public final Observable<Response<CommonPictureTextHighlightResponse>> request() {
        HashMap r0 = new HashMap();
        String r1 = this.scene;
        if (r1 == null) goto L5;
        r0.put("scene", r1);
    L5:
        r0.put("action_type", String.valueOf(this.actionType));
        r0.put("room_id", String.valueOf(this.roomId));
        r0.put("pin_id", String.valueOf(this.pinId));
        PinCommonPictureTextApi.a.getClass();
        return ((PinCommonPictureTextApi) c.b().e(PinCommonPictureTextApi.class)).request(r0);
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final long getPinId() {
        return this.pinId;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final String getScene() {
        return this.scene;
    }

    public CommonPictureTextHighlightRequest(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L18;
        if (r2 != 1) goto L8;
        this.scene = am3.h.c(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.actionType = r5.i();
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.roomId = r5.j();
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this.pinId = r5.j();
        goto L3
    L13:
        am3.h.e(r5);
        goto L3
    L18:
        r5.d(r0);
    }

    public final void setActionType(int r1) {
        this.actionType = r1;
    }

    public final void setPinId(long r1) {
        this.pinId = r1;
    }

    public final void setRoomId(long r1) {
        this.roomId = r1;
    }

    public final void setScene(String r1) {
        this.scene = r1;
    }
}

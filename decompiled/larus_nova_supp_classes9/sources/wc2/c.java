package wc2;

import com.bytedance.android.live.base.model.n;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.message.model.fl;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.ShortTermIndicatorConfig;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.g;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "showShortTouchArea")
public final class c extends g<a, Object> {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lwc2/c$a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "roomId", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", BuildConfig.FLAVOR, "actionType", "I", "a", "()I", "Lcom/bytedance/android/live/base/model/n;", "shortTouchArea", "Lcom/bytedance/android/live/base/model/n;", "c", "()Lcom/bytedance/android/live/base/model/n;", "setShortTouchArea", "(Lcom/bytedance/android/live/base/model/n;)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("message_type")
        private final int actionType;

        @SerializedName("room_id")
        private final Long roomId;

        @SerializedName("shortTouchArea")
        private n shortTouchArea;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.roomId, r4.roomId) == true) goto L8;
            return false;
        L8:
            if (this.actionType == r4.actionType) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.shortTouchArea, r4.shortTouchArea) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            Long r0 = this.roomId;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = ((r2 * 31) + this.actionType) * 31;
            n r4 = this.shortTouchArea;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Params(roomId=" + this.roomId + ", actionType=" + this.actionType + ", shortTouchArea=" + this.shortTouchArea + ")";
        }

        public a() {
            this.roomId = null;
            this.actionType = 0;
            this.shortTouchArea = null;
        }

        public final int a() {
            return this.actionType;
        }

        public final Long b() {
            return this.roomId;
        }

        public final n c() {
            return this.shortTouchArea;
        }
    }

    public c() {
    }

    public final Object invoke(Object r9, CallContext r10) {
        a r11 = (a) r9;
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r10, "p1");
        if (r11.b() != null) goto L5;
        ALogger.e("ShortTouchMethod", "roomId is null");
        return null;
    L5:
        RoomContext.a r13 = RoomContext.Companion;
        long r2 = r11.b().longValue();
        r13.getClass();
        RoomContext r14 = RoomContext.a.a(null, r2);
        if (r14 != null) goto L8;
        ALogger.e("ShortTouchMethod", "roomContext is null");
        return null;
    L8:
        Room r3 = (Room) r14.getRoom().getValue();
        if (r3.id != 0) goto L12;
        ALogger.e("ShortTouchMethod", "room is error");
        return null;
    L12:
        if (r11.c() != null) goto L14;
        ALogger.e("ShortTouchMethod", "shortTouchArea is null");
        return null;
    L14:
        n r4 = r11.c();
        Intrinsics.checkNotNull(r4);
        int r5 = r4.type;
        n r6 = r11.c();
        Intrinsics.checkNotNull(r6);
        int r7 = r6.priority;
        ShortTermIndicatorConfig r8 = r3.getShortTermIndicatorConfig();
        if (r8 == null) goto L24;
        Map r15 = r8.getElements();
        if (r15 == null) goto L24;
        Iterator r16 = r15.entrySet().iterator();
    L20:
        if (r16.hasNext() == false) goto L24;
        if (((ShortTermIndicatorConfig.Element) ((Map.Entry) r16.next()).getValue()).getType() != r5) goto L20;
        boolean r17 = true;
    L25:
        if (r17 == true) goto L27;
        ALogger.i("ShortTouchMethod", "not in white list");
        return null;
    L27:
        HashMap r0 = new HashMap();
        r0.put("source", String.valueOf(1));
        fl r1 = new fl();
        r1.H(Integer.valueOf(r11.a()));
        r1.P(r11.c());
        ((BaseMessage) r1).messageExtra = r0;
        vlc.d r18 = (vlc.d) r14.getMessageManager().getValue();
        if (r18 == null) goto L30;
        r18.j(r1, true);
    L30:
        JSONObject r19 = new JSONObject();
        r19.put("code", 1);
        return r19;
    L24:
        r17 = false;
        goto L25
    }
}

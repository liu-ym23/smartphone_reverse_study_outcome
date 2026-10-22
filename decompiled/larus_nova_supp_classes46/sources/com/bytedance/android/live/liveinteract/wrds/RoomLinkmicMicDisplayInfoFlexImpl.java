package com.bytedance.android.live.liveinteract.wrds;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.im.RoomLinkmicMicDisplayInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R0\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR0\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001b\u0010\u0014\u001a\u00020\u00048VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/liveinteract/wrds/RoomLinkmicMicDisplayInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/wrds/RoomLinkmicMicDisplayInfo;", "", "", "Lkd1/b;", "_micDressInfo", "Ljava/util/Map;", "get_micDressInfo", "()Ljava/util/Map;", "set_micDressInfo", "(Ljava/util/Map;)V", "", "_micDressOpenInfo", "get_micDressOpenInfo", "set_micDressOpenInfo", "roomId$delegate", "Ljava/lang/Object;", "getRoomId", "()J", "roomId", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomLinkmicMicDisplayInfoFlexImpl extends FlexModelBase<RoomLinkmicMicDisplayInfo> implements RoomLinkmicMicDisplayInfo, vh7.h {

    @SerializedName("room_id")
    protected long _$$roomId;

    @SerializedName("mic_dress_info")
    protected Map<Long, ? extends kd1.b> _micDressInfo;

    @SerializedName("open_mic_dress_info")
    protected Map<String, ? extends kd1.b> _micDressOpenInfo;

    public RoomLinkmicMicDisplayInfoFlexImpl() {
        super(RoomLinkmicMicDisplayInfo.class);
    }

    @Override // com.bytedance.android.live.liveinteract.wrds.RoomLinkmicMicDisplayInfo
    public final long getRoomId() {
        return this._$$roomId;
    }

    @Override // com.bytedance.android.live.liveinteract.wrds.RoomLinkmicMicDisplayInfo
    public Map<Long, kd1.b> get_micDressInfo() {
        return this._micDressInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.wrds.RoomLinkmicMicDisplayInfo
    public Map<String, kd1.b> get_micDressOpenInfo() {
        return this._micDressOpenInfo;
    }

    public RoomLinkmicMicDisplayInfoFlexImpl(am3.g r15) {
        super(RoomLinkmicMicDisplayInfo.class);
        this._micDressInfo = new HashMap();
        this._micDressOpenInfo = new HashMap();
        setThreadSafe(false);
        long r0 = r15.c();
    L3:
        int r2 = r15.f();
        if (r2 == (-1)) goto L45;
        am3.g.a r5 = decodeExtensionFields(r2, r15);
        if (r2 != 1) goto L7;
        this._$$roomId = r15.j();
        goto L3
    L7:
        Object r9 = null;
        if (r2 == 2) goto L28;
        if (r2 != 5000) goto L11;
        long r10 = r15.c();
        Object r3 = null;
    L13:
        int r6 = r15.f();
        if (r6 == (-1)) goto L20;
        if (r6 != 1) goto L16;
        r9 = am3.h.c(r15);
        goto L13
    L16:
        if (r6 != 2) goto L17;
        r3 = vh7.f.a(r15, kd1.b.class);
        goto L13
    L17:
        am3.h.e(r15);
        goto L13
    L20:
        r15.d(r10);
        Map r4 = this._micDressOpenInfo;
        if (r9 == null) goto L27;
        if (r3 == null) goto L25;
    L39:
        r4.put(r9, r3);
        goto L3
    L25:
        throw new IllegalStateException("Value must not be null");
    L27:
        throw new IllegalStateException("Key must not be null");
    L11:
        am3.h.d(r5, r15);
        goto L3
    L28:
        long r11 = r15.c();
        r3 = null;
    L29:
        int r7 = r15.f();
        if (r7 == (-1)) goto L36;
        if (r7 != 1) goto L32;
        r9 = Long.valueOf(r15.j());
        goto L29
    L32:
        if (r7 != 2) goto L33;
        r3 = vh7.f.a(r15, kd1.b.class);
        goto L29
    L33:
        am3.h.e(r15);
        goto L29
    L36:
        r15.d(r11);
        r4 = this._micDressInfo;
        if (r9 == null) goto L43;
        if (r3 != null) goto L39;
        throw new IllegalStateException("Value must not be null");
    L43:
        throw new IllegalStateException("Key must not be null");
    L45:
        r15.d(r0);
        setThreadSafe(true);
    }

    public void set_micDressInfo(Map<Long, ? extends kd1.b> r1) {
        this._micDressInfo = r1;
    }

    public void set_micDressOpenInfo(Map<String, ? extends kd1.b> r1) {
        this._micDressOpenInfo = r1;
    }
}

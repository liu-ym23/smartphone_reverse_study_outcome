package com.bytedance.android.live.liveinteract.chatroom.chatroom.model;

import am3.g;
import com.bytedance.android.livesdk.multilink.base.model.j;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R0\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/model/GetPositionPanelResponse;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/j;", "", "", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/model/PositionItem;", "positionMap", "Ljava/util/Map;", "getPositionMap", "()Ljava/util/Map;", "setPositionMap", "(Ljava/util/Map;)V", "", "userPosition", "I", "getUserPosition", "()I", "setUserPosition", "(I)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GetPositionPanelResponse extends FlexModelBase<j> implements j, h {

    @SerializedName("position_map")
    protected Map<Long, PositionItem> positionMap;

    @SerializedName("user_position")
    protected int userPosition;

    public GetPositionPanelResponse() {
        super(j.class);
    }

    public Map<Long, PositionItem> getPositionMap() {
        return this.positionMap;
    }

    public int getUserPosition() {
        return this.userPosition;
    }

    public GetPositionPanelResponse(g r11) {
        super(j.class);
        this.positionMap = new HashMap();
        setThreadSafe(false);
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L28;
        g.a r5 = decodeExtensionFields(r2, r11);
        if (r2 != 1) goto L8;
        long r6 = r11.c();
        Long r3 = null;
        PositionItem r7 = null;
    L12:
        int r8 = r11.f();
        if (r8 == (-1)) goto L20;
        if (r8 != 1) goto L16;
        r3 = Long.valueOf(r11.j());
        goto L12
    L16:
        if (r8 != 2) goto L17;
        r7 = new PositionItem(r11);
        goto L12
    L17:
        am3.h.e(r11);
        goto L12
    L20:
        r11.d(r6);
        Map<Long, PositionItem> r4 = this.positionMap;
        if (r3 == null) goto L27;
        if (r7 == null) goto L25;
        r4.put(r3, r7);
        goto L3
    L25:
        throw new IllegalStateException("Value must not be null");
    L27:
        throw new IllegalStateException("Key must not be null");
    L8:
        if (r2 != 4) goto L9;
        this.userPosition = (int) r11.j();
        goto L3
    L9:
        am3.h.d(r5, r11);
        goto L3
    L28:
        r11.d(r0);
        setThreadSafe(true);
    }

    public void setPositionMap(Map<Long, PositionItem> r1) {
        this.positionMap = r1;
    }

    public void setUserPosition(int r1) {
        this.userPosition = r1;
    }
}

package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.api.linkmic_audience.ListV2Response.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bA\u0010BR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR;\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R;\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\n2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0012R+\u0010\u001f\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u00198V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR+\u0010&\u001a\u00020 2\u0006\u0010\f\u001a\u00020 8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\u000e\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R;\u0010*\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010\u000e\u001a\u0004\b(\u0010\u0010\"\u0004\b)\u0010\u0012R;\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\n2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\u000e\u001a\u0004\b,\u0010\u0010\"\u0004\b-\u0010\u0012RG\u00106\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u000200\u0018\u00010/2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u000200\u0018\u00010/8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b1\u0010\u000e\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001b\u00109\u001a\u00020 8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u000e\u001a\u0004\b8\u0010#R/\u0010@\u001a\u0004\u0018\u00010:2\b\u0010\f\u001a\u0004\u0018\u00010:8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b;\u0010\u000e\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006C"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/NewPlayerInfoListDataFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/w0;", "Lcom/bytedance/android/live/liveinteract/plantform/model/q;", "linkerBaseInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/q;", "getLinkerBaseInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/q;", "setLinkerBaseInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/q;)V", "", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "<set-?>", "mPlayerInfo$delegate", "Ljava/lang/Object;", "getMPlayerInfo", "()Ljava/util/List;", "setMPlayerInfo", "(Ljava/util/List;)V", "mPlayerInfo", "Lcom/bytedance/android/live/liveinteract/multianchor/model/LinkmicPositionItem;", "lockedPositions$delegate", "getLockedPositions", "setLockedPositions", "lockedPositions", "", "hasMore$delegate", "getHasMore", "()Z", "setHasMore", "(Z)V", "hasMore", "", "totalCount$delegate", "getTotalCount", "()J", "setTotalCount", "(J)V", "totalCount", "preOnlineList$delegate", "getPreOnlineList", "setPreOnlineList", "preOnlineList", "positions$delegate", "getPositions", "setPositions", "positions", "", "Lcom/bytedance/android/livesdk/link/model/bridge/g2;", "linkerContentMap$delegate", "getLinkerContentMap", "()Ljava/util/Map;", "setLinkerContentMap", "(Ljava/util/Map;)V", "linkerContentMap", "version$delegate", "getVersion", "version", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "clientUiInfo$delegate", "getClientUiInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "setClientUiInfo", "(Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;)V", "clientUiInfo", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class NewPlayerInfoListDataFlexImpl extends FlexModelBase<w0> implements w0, vh7.h {

    @SerializedName("client_ui_info")
    protected ClientUIInfo _$$clientUiInfo;

    @SerializedName("has_more")
    protected boolean _$$hasMore;

    @SerializedName("linker_content_map")
    protected Map<Long, ? extends g2> _$$linkerContentMap;

    @SerializedName("locked_positions")
    protected List<? extends LinkmicPositionItem> _$$lockedPositions;

    @SerializedName("user")
    protected List<? extends com.bytedance.android.livesdk.link.model.bridge.k> _$$mPlayerInfo;

    @SerializedName("positions")
    protected List<? extends LinkmicPositionItem> _$$positions;

    @SerializedName("pre_link_users")
    protected List<? extends com.bytedance.android.livesdk.link.model.bridge.k> _$$preOnlineList;

    @SerializedName("total_count")
    protected long _$$totalCount;

    @SerializedName("version")
    protected long _$$version;

    @SerializedName("linker_base_info")
    protected q linkerBaseInfo;

    public NewPlayerInfoListDataFlexImpl() {
        super(w0.class);
        this._$$hasMore = false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.w0
    public final ClientUIInfo getClientUiInfo() {
        return this._$$clientUiInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.w0
    public final boolean getHasMore() {
        return this._$$hasMore;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.w0
    public q getLinkerBaseInfo() {
        return this.linkerBaseInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.w0
    public final Map<Long, g2> getLinkerContentMap() {
        return this._$$linkerContentMap;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.w0
    public final List<LinkmicPositionItem> getLockedPositions() {
        return this._$$lockedPositions;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.w0
    public final List<com.bytedance.android.livesdk.link.model.bridge.k> getMPlayerInfo() {
        return this._$$mPlayerInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.w0
    public final List<LinkmicPositionItem> getPositions() {
        return this._$$positions;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.w0
    public final List<com.bytedance.android.livesdk.link.model.bridge.k> getPreOnlineList() {
        return this._$$preOnlineList;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.w0
    public final long getTotalCount() {
        return this._$$totalCount;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.w0
    public final long getVersion() {
        return this._$$version;
    }

    /* JADX WARN: Type inference failed for: r4v16, types: [com.bytedance.android.live.liveinteract.plantform.model.q, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v18, types: [com.bytedance.android.livesdkapi.depend.message.ClientUIInfo, java.lang.Object] */
    public NewPlayerInfoListDataFlexImpl(am3.g r13) {
        super(w0.class);
        this._$$mPlayerInfo = new ArrayList();
        this._$$lockedPositions = new ArrayList();
        this._$$preOnlineList = new ArrayList();
        this._$$positions = new ArrayList();
        this._$$linkerContentMap = new HashMap();
        setThreadSafe(false);
        long r1 = r13.c();
        int r3 = 0;
    L3:
        int r4 = r13.f();
        if (r4 == (-1)) goto L37;
        am3.g.a r7 = decodeExtensionFields(r4, r13);
        switch(r4) {
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L30;
            case 5: goto L29;
            case 6: goto L28;
            case 7: goto L27;
            case 8: goto L10;
            case 9: goto L7;
            case 10: goto L9;
            case 11: goto L8;
            default: goto L7;
        };
    L8:
        this._$$clientUiInfo = vh7.f.a(r13, ClientUIInfo.class);
        goto L3
    L9:
        this.linkerBaseInfo = vh7.f.a(r13, q.class);
        goto L3
    L10:
        long r8 = r13.c();
        Long r5 = null;
        Object r9 = null;
    L11:
        int r10 = r13.f();
        if (r10 == (-1)) goto L19;
        if (r10 != 1) goto L15;
        r5 = Long.valueOf(r13.j());
        goto L11
    L15:
        if (r10 != 2) goto L16;
        r9 = vh7.f.a(r13, g2.class);
        goto L11
    L16:
        am3.h.e(r13);
        goto L11
    L19:
        r13.d(r8);
        Map<Long, ? extends g2> r6 = this._$$linkerContentMap;
        if (r5 == null) goto L26;
        if (r9 == null) goto L24;
        r6.put(r5, r9);
        goto L3
    L24:
        throw new IllegalStateException("Value must not be null");
    L26:
        throw new IllegalStateException("Key must not be null");
    L27:
        List<? extends LinkmicPositionItem> r11 = this._$$positions;
    L31:
        Class<LinkmicPositionItem> r12 = LinkmicPositionItem.class;
    L36:
        r11.add(vh7.f.a(r13, r12));
        goto L3
    L28:
        this._$$version = r13.j();
        r3 = r3 | 4;
        goto L3
    L29:
        r11 = this._$$preOnlineList;
    L35:
        r12 = com.bytedance.android.livesdk.link.model.bridge.k.class;
        goto L36
    L30:
        r11 = this._$$lockedPositions;
        goto L31
    L32:
        this._$$totalCount = r13.j();
        r3 = r3 | 2;
        goto L3
    L33:
        this._$$hasMore = am3.h.a(r13);
        r3 = r3 | 1;
        goto L3
    L34:
        r11 = this._$$mPlayerInfo;
        goto L35
    L7:
        am3.h.d(r7, r13);
        goto L3
    L37:
        r13.d(r1);
        setThreadSafe(true);
        if ((r3 & 1) != 0) goto L73;
        this._$$hasMore = false;
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.w0
    public final void setClientUiInfo(ClientUIInfo r1) {
        this._$$clientUiInfo = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.w0
    public final void setHasMore(boolean r1) {
        this._$$hasMore = r1;
    }

    public void setLinkerBaseInfo(q r1) {
        this.linkerBaseInfo = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.w0
    public final void setLinkerContentMap(Map<Long, ? extends g2> r1) {
        this._$$linkerContentMap = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.w0
    public final void setLockedPositions(List<? extends LinkmicPositionItem> r1) {
        this._$$lockedPositions = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.w0
    public final void setMPlayerInfo(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r1) {
        this._$$mPlayerInfo = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.w0
    public final void setPositions(List<? extends LinkmicPositionItem> r1) {
        this._$$positions = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.w0
    public final void setPreOnlineList(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r1) {
        this._$$preOnlineList = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.w0
    public final void setTotalCount(long r1) {
        this._$$totalCount = r1;
    }
}

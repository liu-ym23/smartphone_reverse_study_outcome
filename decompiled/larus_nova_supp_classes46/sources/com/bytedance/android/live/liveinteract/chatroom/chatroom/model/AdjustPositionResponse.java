package com.bytedance.android.live.liveinteract.chatroom.chatroom.model;

import am3.g;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.multilink.base.model.d;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.api.linkmic_audience.AdjustPositionResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR*\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00130\u00128\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/model/AdjustPositionResponse;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/d;", "", "Lcom/bytedance/android/live/liveinteract/multianchor/model/AnchorLinkUser;", "linkedUsers", "Ljava/util/List;", "getLinkedUsers", "()Ljava/util/List;", "setLinkedUsers", "(Ljava/util/List;)V", "", "version", "J", "getVersion", "()J", "setVersion", "(J)V", "", "Lcom/bytedance/android/livesdk/link/model/bridge/g2;", "linkerContentMap", "Ljava/util/Map;", "getLinkerContentMap", "()Ljava/util/Map;", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "clientUiInfo", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "getClientUiInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdjustPositionResponse extends FlexModelBase<d> implements d, h {

    @SerializedName("client_ui_info")
    protected ClientUIInfo clientUiInfo;

    @SerializedName("linked_users")
    protected List<AnchorLinkUser> linkedUsers;

    @SerializedName("linker_content_map")
    protected Map<Long, g2> linkerContentMap;

    @SerializedName("version")
    protected long version;

    public AdjustPositionResponse() {
        super(d.class);
        this.linkerContentMap = new LinkedHashMap();
    }

    public ClientUIInfo getClientUiInfo() {
        return this.clientUiInfo;
    }

    public List<AnchorLinkUser> getLinkedUsers() {
        return this.linkedUsers;
    }

    public Map<Long, g2> getLinkerContentMap() {
        return this.linkerContentMap;
    }

    public long getVersion() {
        return this.version;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdkapi.depend.message.ClientUIInfo, java.lang.Object] */
    public AdjustPositionResponse(g r11) {
        super(d.class);
        this.linkedUsers = new ArrayList();
        this.linkerContentMap = new HashMap();
        setThreadSafe(false);
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L34;
        g.a r5 = decodeExtensionFields(r2, r11);
        if (r2 != 1) goto L8;
        this.linkedUsers.add(new AnchorLinkUser(r11));
        goto L3
    L8:
        if (r2 != 3) goto L10;
        this.version = r11.j();
        goto L3
    L10:
        if (r2 != 4) goto L12;
        long r6 = r11.c();
        Long r3 = null;
        Object r7 = null;
    L16:
        int r8 = r11.f();
        if (r8 == (-1)) goto L24;
        if (r8 != 1) goto L20;
        r3 = Long.valueOf(r11.j());
        goto L16
    L20:
        if (r8 != 2) goto L21;
        r7 = f.a(r11, g2.class);
        goto L16
    L21:
        am3.h.e(r11);
        goto L16
    L24:
        r11.d(r6);
        Map<Long, g2> r4 = this.linkerContentMap;
        if (r3 == null) goto L31;
        if (r7 == null) goto L29;
        r4.put(r3, (g2) r7);
        goto L3
    L29:
        throw new IllegalStateException("Value must not be null");
    L31:
        throw new IllegalStateException("Key must not be null");
    L12:
        if (r2 != 5) goto L13;
        this.clientUiInfo = f.a(r11, ClientUIInfo.class);
        goto L3
    L13:
        am3.h.d(r5, r11);
        goto L3
    L34:
        r11.d(r0);
        setThreadSafe(true);
        if (this.linkerContentMap != null) goto L64;
        this.linkerContentMap = new LinkedHashMap();
        return;
    }

    public void setLinkedUsers(List<AnchorLinkUser> r1) {
        this.linkedUsers = r1;
    }

    public void setVersion(long r1) {
        this.version = r1;
    }
}

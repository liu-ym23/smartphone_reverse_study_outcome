package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R*\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\"\u0010\u0016\u001a\u00020\u00108&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\t\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00178&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\t\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b \u0010\t\u001a\u0004\b\u001e\u0010\u0005\"\u0004\b\u001f\u0010\u0007R*\u0010%\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b$\u0010\t\u001a\u0004\b\"\u0010\u0005\"\u0004\b#\u0010\u0007R0\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020'\u0018\u00010&8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b,\u0010\t\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u00102\u001a\u0004\u0018\u00010.8&X§\u0004¢\u0006\f\u0012\u0004\b1\u0010\t\u001a\u0004\b/\u00100R\u001a\u00105\u001a\u00020\u00178&X§\u0004¢\u0006\f\u0012\u0004\b4\u0010\t\u001a\u0004\b3\u0010\u0019R$\u0010<\u001a\u0004\u0018\u0001068&@&X§\u000e¢\u0006\u0012\u0012\u0004\b;\u0010\t\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006="}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/w0;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "getMPlayerInfo", "()Ljava/util/List;", "setMPlayerInfo", "(Ljava/util/List;)V", "getMPlayerInfo$annotations", "()V", "mPlayerInfo", "Lcom/bytedance/android/live/liveinteract/multianchor/model/LinkmicPositionItem;", "getLockedPositions", "setLockedPositions", "getLockedPositions$annotations", "lockedPositions", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "getHasMore$annotations", "hasMore", "", "getTotalCount", "()J", "setTotalCount", "(J)V", "getTotalCount$annotations", "totalCount", "getPreOnlineList", "setPreOnlineList", "getPreOnlineList$annotations", "preOnlineList", "getPositions", "setPositions", "getPositions$annotations", "positions", "", "Lcom/bytedance/android/livesdk/link/model/bridge/g2;", "getLinkerContentMap", "()Ljava/util/Map;", "setLinkerContentMap", "(Ljava/util/Map;)V", "getLinkerContentMap$annotations", "linkerContentMap", "Lcom/bytedance/android/live/liveinteract/plantform/model/q;", "getLinkerBaseInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/q;", "getLinkerBaseInfo$annotations", "linkerBaseInfo", "getVersion", "getVersion$annotations", "version", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "getClientUiInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "setClientUiInfo", "(Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;)V", "getClientUiInfo$annotations", "clientUiInfo", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface w0 extends vh7.c<w0> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "client_ui_info")
    ClientUIInfo getClientUiInfo();

    @FieldName(name = "has_more")
    boolean getHasMore();

    @FieldName(name = "linker_base_info")
    q getLinkerBaseInfo();

    @FieldName(name = "linker_content_map")
    Map<Long, g2> getLinkerContentMap();

    @FieldName(name = "locked_positions")
    List<LinkmicPositionItem> getLockedPositions();

    @FieldName(name = "user")
    List<com.bytedance.android.livesdk.link.model.bridge.k> getMPlayerInfo();

    @FieldName(name = "positions")
    List<LinkmicPositionItem> getPositions();

    @FieldName(name = "pre_link_users")
    List<com.bytedance.android.livesdk.link.model.bridge.k> getPreOnlineList();

    @FieldName(name = "total_count")
    long getTotalCount();

    @FieldName(name = "version")
    long getVersion();

    @FieldName(name = "client_ui_info#setter")
    void setClientUiInfo(ClientUIInfo r1);

    @FieldName(name = "has_more#setter")
    void setHasMore(boolean r1);

    @FieldName(name = "linker_content_map#setter")
    void setLinkerContentMap(Map<Long, ? extends g2> r1);

    @FieldName(name = "locked_positions#setter")
    void setLockedPositions(List<? extends LinkmicPositionItem> r1);

    @FieldName(name = "user#setter")
    void setMPlayerInfo(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r1);

    @FieldName(name = "positions#setter")
    void setPositions(List<? extends LinkmicPositionItem> r1);

    @FieldName(name = "pre_link_users#setter")
    void setPreOnlineList(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r1);

    @FieldName(name = "total_count#setter")
    void setTotalCount(long r1);
}

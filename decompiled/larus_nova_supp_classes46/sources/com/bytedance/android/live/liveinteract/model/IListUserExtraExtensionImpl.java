package com.bytedance.android.live.liveinteract.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J6\u0010\t\u001a\u00028\u0000\"\u0016\b\u0000\u0010\u0006*\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00020\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0096\u0001¢\u0006\u0004\b\t\u0010\nJ8\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\u0016\b\u0000\u0010\u0006*\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00020\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0096\u0001¢\u0006\u0004\b\u000b\u0010\nJ\t\u0010\r\u001a\u00020\fH\u0097\u0001J\t\u0010\u000e\u001a\u00020\fH\u0097\u0001J\t\u0010\u000f\u001a\u00020\fH\u0097\u0001J\u0011\u0010\u0011\u001a\n \u0005*\u0004\u0018\u00010\u00100\u0010H\u0097\u0001J\t\u0010\u0012\u001a\u00020\fH\u0097\u0001J\t\u0010\u0013\u001a\u00020\fH\u0097\u0001J\u0011\u0010\u0014\u001a\n \u0005*\u0004\u0018\u00010\u00100\u0010H\u0097\u0001J\u0011\u0010\u0015\u001a\n \u0005*\u0004\u0018\u00010\u00100\u0010H\u0097\u0001J\t\u0010\u0016\u001a\u00020\fH\u0097\u0001J\t\u0010\u0018\u001a\u00020\u0017H\u0097\u0001J\t\u0010\u001a\u001a\u00020\u0019H\u0097\u0001R\u001c\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/bytedance/android/live/liveinteract/model/IListUserExtraExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/live/liveinteract/multianchor/model/c;", "Lcom/bytedance/android/live/liveinteract/model/b;", "Lvh7/e;", "kotlin.jvm.PlatformType", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getAppId", "getClientVersion", "getCurrentTime", "", "getDevicePlatform", "getExpectLeaveTime", "getFanTicket", "getFanTicketFuzzyStr", "getFanTicketRealStr", "getJoinChannelTime", "", "getListUserRole", "", "isHost", "", "getRankUserIds", "()Ljava/util/List;", "rankUserIds", "base", "<init>", "(Lcom/bytedance/android/live/liveinteract/multianchor/model/c;)V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IListUserExtraExtensionImpl extends ModelExtensionBase<com.bytedance.android.live.liveinteract.multianchor.model.c, b> implements b, com.bytedance.android.live.liveinteract.multianchor.model.c {
    private final /* synthetic */ com.bytedance.android.live.liveinteract.multianchor.model.c $$delegate_0;

    @Override // com.bytedance.android.live.liveinteract.model.b, com.bytedance.android.live.liveinteract.multianchor.model.c
    public <R extends vh7.e<com.bytedance.android.live.liveinteract.multianchor.model.c>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.model.b, com.bytedance.android.live.liveinteract.multianchor.model.c
    public <R extends vh7.e<com.bytedance.android.live.liveinteract.multianchor.model.c>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.model.b, com.bytedance.android.live.liveinteract.multianchor.model.c
    @FieldName(name = "app_id")
    public long getAppId() {
        return this.$$delegate_0.getAppId();
    }

    @Override // com.bytedance.android.live.liveinteract.model.b, com.bytedance.android.live.liveinteract.multianchor.model.c
    @FieldName(name = "client_version")
    public long getClientVersion() {
        return this.$$delegate_0.getClientVersion();
    }

    @Override // com.bytedance.android.live.liveinteract.model.b, com.bytedance.android.live.liveinteract.multianchor.model.c
    @FieldName(name = "current_time")
    public long getCurrentTime() {
        return this.$$delegate_0.getCurrentTime();
    }

    @Override // com.bytedance.android.live.liveinteract.model.b, com.bytedance.android.live.liveinteract.multianchor.model.c
    @FieldName(name = "device_platform")
    public String getDevicePlatform() {
        return this.$$delegate_0.getDevicePlatform();
    }

    @Override // com.bytedance.android.live.liveinteract.model.b, com.bytedance.android.live.liveinteract.multianchor.model.c
    @FieldName(name = "expected_leave_time")
    public long getExpectLeaveTime() {
        return this.$$delegate_0.getExpectLeaveTime();
    }

    @Override // com.bytedance.android.live.liveinteract.model.b, com.bytedance.android.live.liveinteract.multianchor.model.c
    @FieldName(name = "fan_ticket")
    public long getFanTicket() {
        return this.$$delegate_0.getFanTicket();
    }

    @Override // com.bytedance.android.live.liveinteract.model.b, com.bytedance.android.live.liveinteract.multianchor.model.c
    @FieldName(name = "fan_ticket_fuzzy_str")
    public String getFanTicketFuzzyStr() {
        return this.$$delegate_0.getFanTicketFuzzyStr();
    }

    @Override // com.bytedance.android.live.liveinteract.model.b, com.bytedance.android.live.liveinteract.multianchor.model.c
    @FieldName(name = "fan_ticket_real_str")
    public String getFanTicketRealStr() {
        return this.$$delegate_0.getFanTicketRealStr();
    }

    @Override // com.bytedance.android.live.liveinteract.model.b, com.bytedance.android.live.liveinteract.multianchor.model.c
    @FieldName(name = "join_channel_time")
    public long getJoinChannelTime() {
        return this.$$delegate_0.getJoinChannelTime();
    }

    @Override // com.bytedance.android.live.liveinteract.model.b, com.bytedance.android.live.liveinteract.multianchor.model.c
    @FieldName(name = "list_user_role")
    public int getListUserRole() {
        return this.$$delegate_0.getListUserRole();
    }

    @Override // com.bytedance.android.live.liveinteract.model.b, com.bytedance.android.live.liveinteract.multianchor.model.c
    @FieldName(name = "host_permission")
    public boolean isHost() {
        return this.$$delegate_0.isHost();
    }

    @Override // com.bytedance.android.live.liveinteract.model.b
    public List<Long> getRankUserIds() {
        return (List) get(11, b.class);
    }

    public IListUserExtraExtensionImpl(com.bytedance.android.live.liveinteract.multianchor.model.c r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}

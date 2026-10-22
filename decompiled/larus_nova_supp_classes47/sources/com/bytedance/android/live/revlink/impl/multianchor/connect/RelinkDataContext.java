package com.bytedance.android.live.revlink.impl.multianchor.connect;

import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.n9;
import com.bytedance.android.livesdk.link.model.o9;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.q;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b=\u0010>J\u0006\u0010\u0003\u001a\u00020\u0002R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0007\u001a\u0004\b\u0019\u0010\u0016R!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u001c\u0010\u0016R!\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0007\u001a\u0004\b \u0010\u0016R!\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0007\u001a\u0004\b$\u0010\u0016R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010(\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R0\u00101\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00108\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b8\u0010:\"\u0004\b;\u0010<¨\u0006?"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/connect/RelinkDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "clearEventParams", "Lcom/bytedance/live/datacontext/m;", "Lcom/bytedance/android/live/revlink/impl/multianchor/connect/n;", "relinkState$delegate", "Lcom/bytedance/live/datacontext/p;", "getRelinkState", "()Lcom/bytedance/live/datacontext/m;", "relinkState", "", "relinkSuccessTimestamp", "J", "getRelinkSuccessTimestamp", "()J", "setRelinkSuccessTimestamp", "(J)V", "Lcom/bytedance/live/datacontext/k;", "Lcom/bytedance/android/livesdk/link/model/i6;", "receiveSwitchChannelInvite$delegate", "getReceiveSwitchChannelInvite", "()Lcom/bytedance/live/datacontext/k;", "receiveSwitchChannelInvite", "receiveSwitchChannelReply$delegate", "getReceiveSwitchChannelReply", "receiveSwitchChannelReply", "receiveSwitchChannelCancel$delegate", "getReceiveSwitchChannelCancel", "receiveSwitchChannelCancel", "Lcom/bytedance/android/livesdk/link/model/o9;", "relinkSwitchSuccess$delegate", "getRelinkSwitchSuccess", "relinkSwitchSuccess", "Lcom/bytedance/android/livesdk/link/model/n9;", "relinkInviteSuccess$delegate", "getRelinkInviteSuccess", "relinkInviteSuccess", "", "roomStatus", "Ljava/lang/String;", "getRoomStatus", "()Ljava/lang/String;", "setRoomStatus", "(Ljava/lang/String;)V", "inviteMode", "getInviteMode", "setInviteMode", "", "pkEventTrackingInfo", "Ljava/util/Map;", "getPkEventTrackingInfo", "()Ljava/util/Map;", "setPkEventTrackingInfo", "(Ljava/util/Map;)V", "", "isRelinkInviter", "Z", "()Z", "setRelinkInviter", "(Z)V", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RelinkDataContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private String inviteMode;
    private boolean isRelinkInviter;
    private Map<String, String> pkEventTrackingInfo;
    private final com.bytedance.live.datacontext.p receiveSwitchChannelCancel$delegate;
    private final com.bytedance.live.datacontext.p receiveSwitchChannelInvite$delegate;
    private final com.bytedance.live.datacontext.p receiveSwitchChannelReply$delegate;
    private final com.bytedance.live.datacontext.p relinkInviteSuccess$delegate;
    private final com.bytedance.live.datacontext.p relinkState$delegate;
    private long relinkSuccessTimestamp;
    private final com.bytedance.live.datacontext.p relinkSwitchSuccess$delegate;
    private String roomStatus;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(RelinkDataContext.class, "relinkState", "getRelinkState()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RelinkDataContext.class, "receiveSwitchChannelInvite", "getReceiveSwitchChannelInvite()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(RelinkDataContext.class, "receiveSwitchChannelReply", "getReceiveSwitchChannelReply()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(RelinkDataContext.class, "receiveSwitchChannelCancel", "getReceiveSwitchChannelCancel()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(RelinkDataContext.class, "relinkSwitchSuccess", "getRelinkSwitchSuccess()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(RelinkDataContext.class, "relinkInviteSuccess", "getRelinkInviteSuccess()Lcom/bytedance/live/datacontext/IEventMember;", 0))};
    }

    public final com.bytedance.live.datacontext.k<i6> getReceiveSwitchChannelCancel() {
        return (com.bytedance.live.datacontext.k) this.receiveSwitchChannelCancel$delegate.a(this, $$delegatedProperties[3]);
    }

    public final com.bytedance.live.datacontext.k<i6> getReceiveSwitchChannelInvite() {
        return (com.bytedance.live.datacontext.k) this.receiveSwitchChannelInvite$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.k<i6> getReceiveSwitchChannelReply() {
        return (com.bytedance.live.datacontext.k) this.receiveSwitchChannelReply$delegate.a(this, $$delegatedProperties[2]);
    }

    public final com.bytedance.live.datacontext.k<n9> getRelinkInviteSuccess() {
        return (com.bytedance.live.datacontext.k) this.relinkInviteSuccess$delegate.a(this, $$delegatedProperties[5]);
    }

    public final com.bytedance.live.datacontext.m<n> getRelinkState() {
        return (com.bytedance.live.datacontext.m) this.relinkState$delegate.a(this, $$delegatedProperties[0]);
    }

    public final com.bytedance.live.datacontext.k<o9> getRelinkSwitchSuccess() {
        return (com.bytedance.live.datacontext.k) this.relinkSwitchSuccess$delegate.a(this, $$delegatedProperties[4]);
    }

    public final void clearEventParams() {
        this.roomStatus = "";
        this.inviteMode = "";
        this.pkEventTrackingInfo = null;
        this.isRelinkInviter = false;
    }

    public RelinkDataContext() {
        this.relinkState$delegate = q.d(this, n.c.a);
        this.receiveSwitchChannelInvite$delegate = com.bytedance.live.datacontext.e.a(this, RelinkDataContext$receiveSwitchChannelInvite$2.INSTANCE);
        this.receiveSwitchChannelReply$delegate = com.bytedance.live.datacontext.e.a(this, RelinkDataContext$receiveSwitchChannelReply$2.INSTANCE);
        this.receiveSwitchChannelCancel$delegate = com.bytedance.live.datacontext.e.a(this, RelinkDataContext$receiveSwitchChannelCancel$2.INSTANCE);
        this.relinkSwitchSuccess$delegate = com.bytedance.live.datacontext.e.a(this, RelinkDataContext$relinkSwitchSuccess$2.INSTANCE);
        this.relinkInviteSuccess$delegate = com.bytedance.live.datacontext.e.a(this, RelinkDataContext$relinkInviteSuccess$2.INSTANCE);
        this.roomStatus = "";
        this.inviteMode = "";
    }

    public final String getInviteMode() {
        return this.inviteMode;
    }

    public final Map<String, String> getPkEventTrackingInfo() {
        return this.pkEventTrackingInfo;
    }

    public final long getRelinkSuccessTimestamp() {
        return this.relinkSuccessTimestamp;
    }

    public final String getRoomStatus() {
        return this.roomStatus;
    }

    public final boolean isRelinkInviter() {
        return this.isRelinkInviter;
    }

    public final void setInviteMode(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.inviteMode = r2;
    }

    public final void setPkEventTrackingInfo(Map<String, String> r1) {
        this.pkEventTrackingInfo = r1;
    }

    public final void setRelinkInviter(boolean r1) {
        this.isRelinkInviter = r1;
    }

    public final void setRelinkSuccessTimestamp(long r1) {
        this.relinkSuccessTimestamp = r1;
    }

    public final void setRoomStatus(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.roomStatus = r2;
    }
}

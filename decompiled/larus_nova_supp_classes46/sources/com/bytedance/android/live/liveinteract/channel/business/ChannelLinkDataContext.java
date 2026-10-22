package com.bytedance.android.live.liveinteract.channel.business;

import com.bytedance.android.live.fifa.core.IChannelLinkService;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.IRoomChannelRtcExtInfo;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b,\u0010-R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\rR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\rR!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0016R!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\rR!\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\rR!\u0010%\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010\rR!\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0005\u001a\u0004\b'\u0010\u0016R!\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0005\u001a\u0004\b*\u0010\u0016¨\u00060"}, d2 = {"Lcom/bytedance/android/live/liveinteract/channel/business/ChannelLinkDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/j;", "", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "Lcom/bytedance/live/datacontext/m;", "", "roomId$delegate", "getRoomId", "()Lcom/bytedance/live/datacontext/m;", "roomId", "channelId$delegate", "getChannelId", "channelId", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/IRoomChannelRtcExtInfo;", "currentRtcInfo$delegate", "getCurrentRtcInfo", "()Lcom/bytedance/live/datacontext/n;", "currentRtcInfo", "currentRtcEngineConfig$delegate", "getCurrentRtcEngineConfig", "currentRtcEngineConfig", "", "currentUserLinkStatus$delegate", "getCurrentUserLinkStatus", "currentUserLinkStatus", "Lcom/bytedance/android/live/fifa/core/IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole;", "currentUserRtcRole$delegate", "getCurrentUserRtcRole", "currentUserRtcRole", "joinedTime$delegate", "getJoinedTime", "joinedTime", "chatChannel$delegate", "getChatChannel", "chatChannel", "chatChannelManager$delegate", "getChatChannelManager", "chatChannelManager", "<init>", "()V", "Companion", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChannelLinkDataContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p channelId$delegate;
    private final p chatChannel$delegate;
    private final p chatChannelManager$delegate;
    private final p currentRtcEngineConfig$delegate;
    private final p currentRtcInfo$delegate;
    private final p currentUserLinkStatus$delegate;
    private final p currentUserRtcRole$delegate;
    private final p joinedTime$delegate;
    private final p roomId$delegate;
    private final p service$delegate;

    public static final class a {
        public final ChannelLinkDataContext getContext() {
            DataContext r0 = d.d(ChannelLinkDataContext.class);
            if ((r0 instanceof ChannelLinkDataContext) == true) goto L6;
            r0 = null;
        L6:
            return (ChannelLinkDataContext) r0;
        }

        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ChannelLinkDataContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ChannelLinkDataContext.class, "roomId", "getRoomId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ChannelLinkDataContext.class, "channelId", "getChannelId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ChannelLinkDataContext.class, "currentRtcInfo", "getCurrentRtcInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ChannelLinkDataContext.class, "currentRtcEngineConfig", "getCurrentRtcEngineConfig()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ChannelLinkDataContext.class, "currentUserLinkStatus", "getCurrentUserLinkStatus()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ChannelLinkDataContext.class, "currentUserRtcRole", "getCurrentUserRtcRole()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ChannelLinkDataContext.class, "joinedTime", "getJoinedTime()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ChannelLinkDataContext.class, "chatChannel", "getChatChannel()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ChannelLinkDataContext.class, "chatChannelManager", "getChatChannelManager()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
        Companion = new a();
    }

    public final m<Long> getChannelId() {
        return (m) this.channelId$delegate.a(this, $$delegatedProperties[2]);
    }

    public final n<Object> getChatChannel() {
        return (n) this.chatChannel$delegate.a(this, $$delegatedProperties[8]);
    }

    public final n<Object> getChatChannelManager() {
        return (n) this.chatChannelManager$delegate.a(this, $$delegatedProperties[9]);
    }

    public final n<Object> getCurrentRtcEngineConfig() {
        return (n) this.currentRtcEngineConfig$delegate.a(this, $$delegatedProperties[4]);
    }

    public final n<IRoomChannelRtcExtInfo> getCurrentRtcInfo() {
        return (n) this.currentRtcInfo$delegate.a(this, $$delegatedProperties[3]);
    }

    public final m<Integer> getCurrentUserLinkStatus() {
        return (m) this.currentUserLinkStatus$delegate.a(this, $$delegatedProperties[5]);
    }

    public final m<IChannelLinkService.ICurrentUserLinkStatus.RtcUserRole> getCurrentUserRtcRole() {
        return (m) this.currentUserRtcRole$delegate.a(this, $$delegatedProperties[6]);
    }

    public final m<Long> getJoinedTime() {
        return (m) this.joinedTime$delegate.a(this, $$delegatedProperties[7]);
    }

    public final m<Long> getRoomId() {
        return (m) this.roomId$delegate.a(this, $$delegatedProperties[1]);
    }

    public final j<Object> getService() {
        return (j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    public ChannelLinkDataContext() {
        this.service$delegate = ConstantKt.c(this);
        this.roomId$delegate = q.d(this, 0L);
        this.channelId$delegate = q.d(this, 0L);
        this.currentRtcInfo$delegate = q.c(this);
        this.currentRtcEngineConfig$delegate = q.c(this);
        this.currentUserLinkStatus$delegate = q.d(this, 0);
        this.currentUserRtcRole$delegate = q.d(this, IChannelLinkService.ICurrentUserLinkStatus.RtcUserRole.Unknown);
        this.joinedTime$delegate = q.d(this, 0L);
        this.chatChannel$delegate = q.c(this);
        this.chatChannelManager$delegate = q.c(this);
    }
}

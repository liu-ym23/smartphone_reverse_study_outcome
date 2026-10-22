package com.bytedance.android.live.revlink.impl.multianchor.vm;

import com.bytedance.android.live.revlink.impl.multianchor.connect.UnexpectedFrameMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.utils.s;
import com.bytedance.android.livesdk.link.model.s5;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u0012\b\u0010+\u001a\u0004\u0018\u00010*\u0012\b\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u001b\u0010\u001c\u001a\u00020\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001e\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010#\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010(\u001a\u0004\u0018\u00010'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u0004\u0018\u00010*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010.\u001a\u0004\u0018\u00010-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00062"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/vm/MultiLinkAnchorControlContext;", "Lcom/bytedance/android/live/revlink/impl/multianchor/vm/MultiLinkControlContext;", "Lcom/bytedance/android/livesdk/link/model/s5;", "linkStatsMeta", "", "updateLinkStatsMeta", "", "multiLinkTimes", "I", "getMultiLinkTimes", "()I", "setMultiLinkTimes", "(I)V", "Lcom/bytedance/live/datacontext/m;", "", "forbidInvite$delegate", "Lcom/bytedance/live/datacontext/p;", "getForbidInvite", "()Lcom/bytedance/live/datacontext/m;", "forbidInvite", "forbidApply$delegate", "getForbidApply", "forbidApply", "Lcom/bytedance/android/live/revlink/impl/multianchor/vm/MultiInviteLogDataContext;", "inviteLogContext$delegate", "Lkotlin/Lazy;", "getInviteLogContext", "()Lcom/bytedance/android/live/revlink/impl/multianchor/vm/MultiInviteLogDataContext;", "inviteLogContext", "Lcom/bytedance/android/live/revlink/impl/multianchor/utils/s;", "connectMonitor", "Lcom/bytedance/android/live/revlink/impl/multianchor/utils/s;", "getConnectMonitor", "()Lcom/bytedance/android/live/revlink/impl/multianchor/utils/s;", "Lcom/bytedance/android/live/revlink/impl/multianchor/connect/UnexpectedFrameMonitor;", "unexpectedFrameMonitor", "Lcom/bytedance/android/live/revlink/impl/multianchor/connect/UnexpectedFrameMonitor;", "getUnexpectedFrameMonitor", "()Lcom/bytedance/android/live/revlink/impl/multianchor/connect/UnexpectedFrameMonitor;", "Lld/a;", "linkDataSet", "Lld/a;", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "roomService", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "Lcom/bytedance/android/live/revlink/impl/global/c;", "linkFakeGlobalService", "Lcom/bytedance/android/live/revlink/impl/global/c;", "<init>", "(Lld/a;Lcom/bytedance/android/livesdk/revenue/service/room/c;Lcom/bytedance/android/live/revlink/impl/global/c;)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkAnchorControlContext extends MultiLinkControlContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final s connectMonitor;
    private final p forbidApply$delegate;
    private final p forbidInvite$delegate;
    private final Lazy inviteLogContext$delegate;
    private final ld.a linkDataSet;
    private final com.bytedance.android.live.revlink.impl.global.c linkFakeGlobalService;
    private int multiLinkTimes;
    private final com.bytedance.android.livesdk.revenue.service.room.c roomService;
    private final UnexpectedFrameMonitor unexpectedFrameMonitor;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(MultiLinkAnchorControlContext.class, "forbidInvite", "getForbidInvite()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(MultiLinkAnchorControlContext.class, "forbidApply", "getForbidApply()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
    }

    public final m<Boolean> getForbidApply() {
        return (m) this.forbidApply$delegate.a(this, $$delegatedProperties[1]);
    }

    public final m<Boolean> getForbidInvite() {
        return (m) this.forbidInvite$delegate.a(this, $$delegatedProperties[0]);
    }

    public final MultiInviteLogDataContext getInviteLogContext() {
        return (MultiInviteLogDataContext) this.inviteLogContext$delegate.getValue();
    }

    public final s getConnectMonitor() {
        return this.connectMonitor;
    }

    public final int getMultiLinkTimes() {
        return this.multiLinkTimes;
    }

    public final UnexpectedFrameMonitor getUnexpectedFrameMonitor() {
        return this.unexpectedFrameMonitor;
    }

    public static final /* synthetic */ com.bytedance.android.live.revlink.impl.global.c access$getLinkFakeGlobalService$p(MultiLinkAnchorControlContext r0) {
        return r0.linkFakeGlobalService;
    }

    public final void setMultiLinkTimes(int r1) {
        this.multiLinkTimes = r1;
    }

    public final void updateLinkStatsMeta(s5 r5) {
        m<Boolean> r0 = getForbidInvite();
        boolean r1 = false;
        if (r5 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        r0.setValue(Boolean.valueOf(r3));
        m<Boolean> r2 = getForbidApply();
        if (r5 != null) goto L11;
    L13:
        r2.setValue(Boolean.valueOf(r1));
        return;
    L11:
        if (r5.getForbidApplyFromOther() != true) goto L13;
        r1 = true;
        goto L13
    L5:
        if (r5.getForbidInviteByGeneral() != true) goto L7;
        r3 = true;
        goto L8
    }

    public MultiLinkAnchorControlContext(ld.a r3, com.bytedance.android.livesdk.revenue.service.room.c r4, com.bytedance.android.live.revlink.impl.global.c r5) {
        super(r5);
        this.linkDataSet = r3;
        this.roomService = r4;
        this.linkFakeGlobalService = r5;
        Boolean r0 = Boolean.FALSE;
        this.forbidInvite$delegate = q.d(this, r0);
        this.forbidApply$delegate = q.d(this, r0);
        this.inviteLogContext$delegate = LazyKt.lazy(new MultiLinkAnchorControlContext$inviteLogContext$2(this));
        this.connectMonitor = new s(r5);
        this.unexpectedFrameMonitor = new UnexpectedFrameMonitor(r3, r4, r5);
    }
}

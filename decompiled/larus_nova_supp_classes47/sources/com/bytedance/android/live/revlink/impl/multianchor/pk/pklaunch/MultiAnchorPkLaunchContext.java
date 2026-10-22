package com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch;

import com.bytedance.android.live.revlink.impl.multianchor.vm.LinkingInvitePreloadUtils;
import com.bytedance.android.live.revlink.impl.multianchor.vm.h;
import com.bytedance.android.livesdk.link.model.e7;
import com.bytedance.android.livesdk.link.model.f7;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b,\u0010-J5\u0010\u000b\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fR!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u001cR!\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b!\u0010\"R!\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0010\u001a\u0004\b%\u0010\"R\u0017\u0010(\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/pk/pklaunch/MultiAnchorPkLaunchContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/revlink/impl/multianchor/pk/pklaunch/a;", "Lcom/bytedance/android/livesdk/link/model/e7;", "multiPKModeInfo", "", "toast", "source", "", "showModeTab", "", "updateMultiPkModeInfo", "(Lcom/bytedance/android/livesdk/link/model/e7;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/revlink/impl/multianchor/service/c;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "Lcom/bytedance/android/live/revlink/impl/multianchor/vm/LinkingInvitePreloadUtils;", "linkingInvitePreloadUtils$delegate", "getLinkingInvitePreloadUtils", "linkingInvitePreloadUtils", "Lcom/bytedance/live/datacontext/k;", "Lcom/bytedance/android/live/revlink/impl/multianchor/vm/h;", "preloadCompleteEvent$delegate", "getPreloadCompleteEvent", "()Lcom/bytedance/live/datacontext/k;", "preloadCompleteEvent", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/live/revlink/impl/multianchor/pk/pklaunch/g;", "multiPkModeInfo$delegate", "getMultiPkModeInfo", "()Lcom/bytedance/live/datacontext/n;", "multiPkModeInfo", "lastMultiPkModeInfo$delegate", "getLastMultiPkModeInfo", "lastMultiPkModeInfo", "Lcom/bytedance/android/livesdk/revenue/room/a;", "roomContext", "Lcom/bytedance/android/livesdk/revenue/room/a;", "getRoomContext", "()Lcom/bytedance/android/livesdk/revenue/room/a;", "<init>", "(Lcom/bytedance/android/livesdk/revenue/room/a;)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiAnchorPkLaunchContext extends DataContext implements a {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p lastMultiPkModeInfo$delegate;
    private final p linkingInvitePreloadUtils$delegate;
    private final p multiPkModeInfo$delegate;
    private final p preloadCompleteEvent$delegate;
    private final com.bytedance.android.livesdk.revenue.room.a roomContext;
    private final p service$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(MultiAnchorPkLaunchContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MultiAnchorPkLaunchContext.class, "linkingInvitePreloadUtils", "getLinkingInvitePreloadUtils()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MultiAnchorPkLaunchContext.class, "preloadCompleteEvent", "getPreloadCompleteEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(MultiAnchorPkLaunchContext.class, "multiPkModeInfo", "getMultiPkModeInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MultiAnchorPkLaunchContext.class, "lastMultiPkModeInfo", "getLastMultiPkModeInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
    }

    public final n<g> getLastMultiPkModeInfo() {
        return (n) this.lastMultiPkModeInfo$delegate.a(this, $$delegatedProperties[4]);
    }

    public final j<LinkingInvitePreloadUtils> getLinkingInvitePreloadUtils() {
        return (j) this.linkingInvitePreloadUtils$delegate.a(this, $$delegatedProperties[1]);
    }

    public final n<g> getMultiPkModeInfo() {
        return (n) this.multiPkModeInfo$delegate.a(this, $$delegatedProperties[3]);
    }

    public final k<h> getPreloadCompleteEvent() {
        return (k) this.preloadCompleteEvent$delegate.a(this, $$delegatedProperties[2]);
    }

    public final j<com.bytedance.android.live.revlink.impl.multianchor.service.c> getService() {
        return (j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    public final com.bytedance.android.livesdk.revenue.room.a getRoomContext() {
        return this.roomContext;
    }

    public MultiAnchorPkLaunchContext(com.bytedance.android.livesdk.revenue.room.a r2) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        this.roomContext = r2;
        this.service$delegate = ConstantKt.c(this);
        this.linkingInvitePreloadUtils$delegate = ConstantKt.c(this);
        this.preloadCompleteEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.multiPkModeInfo$delegate = q.c(this);
        this.lastMultiPkModeInfo$delegate = q.c(this);
    }

    public final void updateMultiPkModeInfo(e7 r5, String r6, String r7, Boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "source");
        StringBuilder r0 = new StringBuilder("updateMultiPkModeInfo from ");
        r0.append(r7);
        r0.append(": ");
        if (r5 == null) goto L5;
        String r1 = f7.b(r5);
    L6:
        r0.append(r1);
        jy0.b.c("ttlive_anchor_link_multi_pk", r0.toString(), null, 4);
        if (r5 != null) goto L9;
        return;
    L9:
        g r9 = new g(r5, r6, r8);
        g r10 = (g) getMultiPkModeInfo().getValue();
        if (r10 != null) goto L14;
        getMultiPkModeInfo().setValue(r9);
        getLastMultiPkModeInfo().setValue(r10);
        return;
    L14:
        if (r5.getVersion() < r10.a.getVersion()) goto L17;
        getMultiPkModeInfo().setValue(r9);
        getLastMultiPkModeInfo().setValue(r10);
        return;
    L17:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static /* synthetic */ void updateMultiPkModeInfo$default(MultiAnchorPkLaunchContext r0, e7 r1, String r2, String r3, Boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        r0.updateMultiPkModeInfo(r1, r2, r3, r4);
    }
}

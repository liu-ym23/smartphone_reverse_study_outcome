package com.larus.ugc.feed.impl.ability;

import com.larus.im.internal.delegate.c0;
import com.larus.ugc.feed.api.model.UserCreationKmp;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u001c\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/ugc/feed/impl/ability/CommunityCreateEventFeature;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ugc/feed/api/ability/ICommunityCreateEventAbility;", "<init>", "()V", "mainAbility", "Lcom/larus/ugc/feed/api/ability/IKMPCommunityCreateAbility;", "bindMainAbility", "", "ability", "onTabEnter", "previousPage", "", "enterMethod", "onTabLeave", "leaveMethod", "onCreationPublished", "creation", "Lcom/larus/ugc/feed/api/model/UserCreationKmp;", "onNewIntent", "data", "Lcom/larus/ugc/feed/api/ability/BundleDataKmp;", "onFabDowngradeChanged", "downgrade", "", "onCrossPageEvent", "event", "Lcom/larus/ugc/feed/api/ability/CrossPageEventKmp;", "Companion", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CommunityCreateEventFeature extends ComponentFeature implements g0a.b {
    public volatile g0a.f h;

    public static final class a {
    }

    static {
    }

    public CommunityCreateEventFeature() {
    }

    @Override // g0a.b
    public final void Sd(boolean r4) {
        c0.b.d("CommunityCreateEventFeature", "onFabDowngradeChanged: " + r4);
        g0a.f r0 = this.h;
        if (r0 == null) goto L6;
        r0.vi(r4);
        return;
    }

    @Override // g0a.b
    public final void da(String r4) {
        Intrinsics.checkNotNullParameter(r4, "leaveMethod");
        c0.b.d("CommunityCreateEventFeature", "onTabLeave: method=".concat(r4));
        g0a.f r0 = this.h;
        if (r0 == null) goto L6;
        r0.da(r4);
        return;
    }

    @Override // g0a.b
    public final void mk(UserCreationKmp r4) {
        Intrinsics.checkNotNullParameter(r4, "creation");
        c0.b.d("CommunityCreateEventFeature", "onCreationPublished: id=" + r4.getCreationId());
        g0a.f r0 = this.h;
        if (r0 == null) goto L6;
        r0.gk(r4);
        return;
    }

    @Override // g0a.b
    public final void wK(g0a.a r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        c0 r0 = c0.b;
        StringBuilder r1 = new StringBuilder("onNewIntent: hasUserCreation=");
        if (r4.d == null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        r0.d("CommunityCreateEventFeature", r1.toString());
        UserCreationKmp r5 = r4.d;
        if (r5 == null) goto L12;
        g0a.f r3 = this.h;
        if (r3 == null) goto L13;
        r3.gk(r5);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r2 = false;
        goto L6
    }

    @Override // g0a.b
    public final void nI(String r4, String r5) {
        c0.b.d("CommunityCreateEventFeature", "onTabEnter: prev=" + r4 + " method=" + r5);
        g0a.f r6 = this.h;
        if (r6 == null) goto L6;
        r6.ev();
        return;
    }
}

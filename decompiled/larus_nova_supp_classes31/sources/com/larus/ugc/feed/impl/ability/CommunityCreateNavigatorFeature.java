package com.larus.ugc.feed.impl.ability;

import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016¨\u0006\u0010"}, d2 = {"Lcom/larus/ugc/feed/impl/ability/CommunityCreateNavigatorFeature;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ugc/feed/api/ability/ICommunityCreateNavigatorAbility;", "<init>", "()V", "openProfileMine", "", "landingTab", "", "enterMethod", "openMixCreationPage", "params", "Lcom/larus/ugc/feed/api/ability/OpenMixCreationParamsKmp;", "openCreationSelectPage", "Lcom/larus/ugc/feed/api/ability/OpenCreationSelectParamsKmp;", "openSideBar", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CommunityCreateNavigatorFeature extends ComponentFeature implements g0a.c {
    @Override // g0a.c
    public final void bY(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "enterMethod");
    }

    @Override // g0a.c
    public final void kF(g0a.k r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
    }

    public CommunityCreateNavigatorFeature() {
    }
}

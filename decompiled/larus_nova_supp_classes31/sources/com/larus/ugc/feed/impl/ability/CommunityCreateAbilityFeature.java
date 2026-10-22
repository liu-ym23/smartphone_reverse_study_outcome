package com.larus.ugc.feed.impl.ability;

import com.larus.ugc.feed.api.model.UserCreationKmp;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001,B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007J\t\u0010\b\u001a\u00020\tH\u0096\u0001J\u000e\u0010\n\u001a\u00020\tH\u0096A¢\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\t\u0010\u0011\u001a\u00020\tH\u0096\u0001J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0001J\t\u0010\u0014\u001a\u00020\tH\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0096\u0001J\t\u0010\u0018\u001a\u00020\tH\u0096\u0001J\u0019\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0017H\u0096\u0001J\u0011\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001fH\u0096\u0001J\u000b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0001J\u000b\u0010\"\u001a\u0004\u0018\u00010#H\u0096\u0001J\u0011\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020&H\u0096\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u0096\u0005¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcom/larus/ugc/feed/impl/ability/CommunityCreateAbilityFeature;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ugc/feed/api/ability/IKMPCommunityCreateAbility;", "impl", "Lcom/larus/ugc/feed/impl/ability/CommunityCreateAbilityImpl;", "<init>", "(Lcom/larus/ugc/feed/impl/ability/CommunityCreateAbilityImpl;)V", "()V", "consumePublishedCreation", "", "fetchTabList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initialize", "initParams", "Lcom/larus/ugc/feed/api/model/CommunityCreateInitParamsKmp;", "initDependency", "Lcom/larus/ugc/feed/api/model/CommunityCreateInitDependencyKmp;", "markResumed", "navigator", "Lcom/larus/ugc/feed/api/ability/ICommunityCreateNavigatorAbility;", "onClickCreateButton", "onTabLeave", "leaveMethod", "", "reset", "selectTab", "index", "", "enterMethod", "setPendingPublishedCreation", "creation", "Lcom/larus/ugc/feed/api/model/UserCreationKmp;", "settings", "Lcom/larus/ugc/feed/api/ability/ICommunityCreateSettingsAbility;", "tracker", "Lcom/larus/ugc/feed/api/ability/ICommunityCreateTrackerAbility;", "updateFabDowngrade", "downgrade", "", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/ugc/feed/api/model/CommunityCreateUiStateKmp;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "Companion", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CommunityCreateAbilityFeature extends ComponentFeature implements g0a.f {
    public final CommunityCreateAbilityImpl h;

    public static final class a {
    }

    static {
    }

    public CommunityCreateAbilityFeature() {
        this.h = new CommunityCreateAbilityImpl(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain())), new a1a.a());
    }

    @Override // g0a.f
    public final void Oc() {
        this.h.Oc();
    }

    @Override // g0a.f
    public final void Ow(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "enterMethod");
        this.h.Ow(r2, r3);
    }

    @Override // g0a.f
    public final void da(String r2) {
        Intrinsics.checkNotNullParameter(r2, "leaveMethod");
        this.h.da(r2);
    }

    @Override // g0a.f
    public final void dy() {
        this.h.dy();
    }

    @Override // g0a.f
    public final void ev() {
        this.h.ev();
    }

    @Override // g0a.f
    public final void gk(UserCreationKmp r2) {
        Intrinsics.checkNotNullParameter(r2, "creation");
        this.h.gk(r2);
    }

    @Override // g0a.f
    public final void vi(boolean r2) {
        this.h.vi(r2);
    }

    @Override // g0a.f
    public final void yG(m0a.e r2, m0a.d r3) {
        Intrinsics.checkNotNullParameter(r2, "initParams");
        Intrinsics.checkNotNullParameter(r3, "initDependency");
        this.h.yG(r2, r3);
    }

    @Override // g0a.f
    public final i1<m0a.f> getUiState() {
        return this.h.b.a;
    }
}

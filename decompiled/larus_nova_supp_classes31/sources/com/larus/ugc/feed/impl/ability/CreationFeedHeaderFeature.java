package com.larus.ugc.feed.impl.ability;

import com.larus.ugc.feed.api.ability.AvatarStatus;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/larus/ugc/feed/impl/ability/CreationFeedHeaderFeature;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ugc/feed/api/ability/ICreationFeedHeaderAbility;", "<init>", "()V", "_avatarStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/ugc/feed/api/ability/AvatarStatus;", "avatarStatus", "Lkotlinx/coroutines/flow/StateFlow;", "getAvatarStatus", "()Lkotlinx/coroutines/flow/StateFlow;", "setAvatarStatus", "", "status", "avatarPreviewUrl", "", "refresh", "Companion", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationFeedHeaderFeature extends ComponentFeature implements m1a.a {

    public static final class a {
    }

    static {
    }

    public CreationFeedHeaderFeature() {
        kotlinx.coroutines.flow.e.b(j1.a(AvatarStatus.Unknown));
    }
}

package com.larus.community.impl.detail;

import android.os.Bundle;
import com.larus.community.api.spi.ICommunityDetailContainerProvider;
import com.larus.platform.service.z2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/larus/community/impl/detail/DoubaoCommunityDetailContainerProvider;", "Lcom/larus/community/api/spi/ICommunityDetailContainerProvider;", "<init>", "()V", "createDetailContainer", "Landroidx/fragment/app/Fragment;", "arguments", "Landroid/os/Bundle;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoCommunityDetailContainerProvider implements ICommunityDetailContainerProvider {
    public DoubaoCommunityDetailContainerProvider() {
    }

    @Override // com.larus.community.api.spi.ICommunityDetailContainerProvider
    public final CreationDetailHostFragment a(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "arguments");
        boolean r1 = false;
        if (r3.getBoolean("is_show_profile", false) == true) goto L5;
    L7:
        if (r1 == false) goto L9;
        CreationDetailHostFragment r0 = new CreationDetailHostFragment();
        r0.setArguments(r3);
        return r0;
    L9:
        return null;
    L5:
        if (z2.a.getCreationPageSwipeAuthorConfig().a() == false) goto L7;
        r1 = true;
        goto L7
    }
}

package com.larus.community.impl.applet;

import android.os.Bundle;
import com.larus.community.api.spi.ICommunityFeedRequestSourceFactory;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/larus/community/impl/applet/AICreationCommunityFeedRequestSourceFactory;", "Lcom/larus/community/api/spi/ICommunityFeedRequestSourceFactory;", "<init>", "()V", "create", "Lcom/larus/community/api/spi/CommunityFeedRequestSource;", "arguments", "Landroid/os/Bundle;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AICreationCommunityFeedRequestSourceFactory implements ICommunityFeedRequestSourceFactory {
    public AICreationCommunityFeedRequestSourceFactory() {
    }

    @Override // com.larus.community.api.spi.ICommunityFeedRequestSourceFactory
    public final s a(Bundle r2) {
        cy9.a.a.getClass();
        if (cy9.a.e(r2) == true) goto L7;
        return null;
    L7:
        return new s();
    }
}

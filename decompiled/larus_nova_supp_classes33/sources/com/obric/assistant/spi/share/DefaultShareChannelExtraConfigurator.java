package com.obric.assistant.spi.share;

import java.util.List;
import kn7.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J/\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/spi/share/DefaultShareChannelExtraConfigurator;", "Lcom/obric/assistant/spi/share/IShareChannelExtraConfigurator;", "<init>", "()V", "isAvailable", "", "configureDouyinExtra", "", "shareExtra", "", "hashTags", "", "", "configureWechatMiniAppExtra", "miniAppId", "miniAppPath", "miniProgramType", "", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultShareChannelExtraConfigurator implements IShareChannelExtraConfigurator {
    public DefaultShareChannelExtraConfigurator() {
    }

    @Override // com.obric.assistant.spi.share.IShareChannelExtraConfigurator
    public final void a(a r1, String r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r1, "shareExtra");
        Intrinsics.checkNotNullParameter("gh_b8a66f6c82a7", "miniAppId");
        Intrinsics.checkNotNullParameter(r2, "miniAppPath");
    }

    @Override // com.obric.assistant.spi.share.IShareChannelExtraConfigurator
    public final void b(a r2, List r3) {
        Intrinsics.checkNotNullParameter(r2, "shareExtra");
        Intrinsics.checkNotNullParameter(r3, "hashTags");
    }
}

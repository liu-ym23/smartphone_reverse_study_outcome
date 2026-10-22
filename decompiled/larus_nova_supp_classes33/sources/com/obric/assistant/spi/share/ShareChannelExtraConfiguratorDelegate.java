package com.obric.assistant.spi.share;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kn7.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0096\u0001J0\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0001¢\u0006\u0002\u0010\u0010J\t\u0010\u0011\u001a\u00020\u0012H\u0096\u0001¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/spi/share/ShareChannelExtraConfiguratorDelegate;", "Lcom/obric/assistant/spi/share/IShareChannelExtraConfigurator;", "<init>", "()V", "configureDouyinExtra", "", "shareExtra", "", "hashTags", "", "", "configureWechatMiniAppExtra", "miniAppId", "miniAppPath", "miniProgramType", "", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "isAvailable", "", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareChannelExtraConfiguratorDelegate implements IShareChannelExtraConfigurator {
    public static final ShareChannelExtraConfiguratorDelegate b = null;
    public final /* synthetic */ IShareChannelExtraConfigurator a;

    static {
        b = new ShareChannelExtraConfiguratorDelegate();
    }

    @Override // com.obric.assistant.spi.share.IShareChannelExtraConfigurator
    public final void a(a r3, String r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r3, "shareExtra");
        Intrinsics.checkNotNullParameter("gh_b8a66f6c82a7", "miniAppId");
        Intrinsics.checkNotNullParameter(r4, "miniAppPath");
        this.a.a(r3, r4, r5);
    }

    @Override // com.obric.assistant.spi.share.IShareChannelExtraConfigurator
    public final void b(a r2, List r3) {
        Intrinsics.checkNotNullParameter(r2, "shareExtra");
        Intrinsics.checkNotNullParameter(r3, "hashTags");
        this.a.b(r2, r3);
    }

    private ShareChannelExtraConfiguratorDelegate() {
        IShareChannelExtraConfigurator r0 = (IShareChannelExtraConfigurator) ServiceManager.get().getService(IShareChannelExtraConfigurator.class);
        if (r0 != null) goto L5;
        r0 = new DefaultShareChannelExtraConfigurator();
    L5:
        this.a = r0;
    }
}

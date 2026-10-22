package com.larus.aweme.api.video.service;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.home.impl.route.k;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096\u0001J\t\u0010\n\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u000b\u001a\u00020\u0005H\u0096\u0001¨\u0006\f"}, d2 = {"Lcom/larus/aweme/api/video/service/VideoFragmentProviderDelegate;", "Lcom/larus/aweme/api/video/service/IVideoFragmentProvider;", "<init>", "()V", "createAwemeDoublePostFragment", "Landroidx/fragment/app/Fragment;", "createDouYinBotWrapperFragment", "onBackFromChat", "Lkotlin/Function0;", "", "createDouYinFragment", "createVideoFragment", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class VideoFragmentProviderDelegate implements IVideoFragmentProvider {
    public static final VideoFragmentProviderDelegate b = null;
    public final /* synthetic */ IVideoFragmentProvider a;

    static {
        b = new VideoFragmentProviderDelegate();
    }

    @Override // com.larus.aweme.api.video.service.IVideoFragmentProvider
    public final Fragment a(k r2) {
        Intrinsics.checkNotNullParameter(r2, "onBackFromChat");
        return this.a.a(r2);
    }

    @Override // com.larus.aweme.api.video.service.IVideoFragmentProvider
    public final Fragment b() {
        return this.a.b();
    }

    @Override // com.larus.aweme.api.video.service.IVideoFragmentProvider
    public final Fragment c() {
        return this.a.c();
    }

    @Override // com.larus.aweme.api.video.service.IVideoFragmentProvider
    public final Fragment d() {
        return this.a.d();
    }

    private VideoFragmentProviderDelegate() {
        Object r0 = ServiceManager.get().getService(IVideoFragmentProvider.class);
        Intrinsics.checkNotNull(r0);
        this.a = (IVideoFragmentProvider) r0;
    }
}

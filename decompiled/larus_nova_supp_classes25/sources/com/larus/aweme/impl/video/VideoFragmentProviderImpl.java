package com.larus.aweme.impl.video;

import androidx.fragment.app.Fragment;
import com.larus.aweme.api.video.service.IVideoFragmentProvider;
import com.larus.aweme.impl.bot.DouYinBotWrapperFragment;
import com.larus.aweme.impl.main_bot.AwemeDoublePostWrapperFragment;
import com.larus.aweme.impl.main_bot.DouYinWrapperFragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.home.impl.route.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ma8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"Lcom/larus/aweme/impl/video/VideoFragmentProviderImpl;", "Lcom/larus/aweme/api/video/service/IVideoFragmentProvider;", "<init>", "()V", "createVideoFragment", "Landroidx/fragment/app/Fragment;", "createDouYinBotWrapperFragment", "onBackFromChat", "Lkotlin/Function0;", "", "createAwemeDoublePostFragment", "createDouYinFragment", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class VideoFragmentProviderImpl implements IVideoFragmentProvider {
    public VideoFragmentProviderImpl() {
    }

    @Override // com.larus.aweme.api.video.service.IVideoFragmentProvider
    public final Fragment b() {
        return new VideoTabFragment();
    }

    @Override // com.larus.aweme.api.video.service.IVideoFragmentProvider
    public final Fragment c() {
        return new AwemeDoublePostWrapperFragment();
    }

    @Override // com.larus.aweme.api.video.service.IVideoFragmentProvider
    public final Fragment d() {
        return new DouYinWrapperFragment();
    }

    @Override // com.larus.aweme.api.video.service.IVideoFragmentProvider
    public final Fragment a(final k r3) {
        Intrinsics.checkNotNullParameter(r3, "onBackFromChat");
        DouYinBotWrapperFragment r0 = new DouYinBotWrapperFragment();
        r0.i = new a(r3);
        r0.g = true;
        return r0;
    }
}

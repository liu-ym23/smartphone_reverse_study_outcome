package com.larus.bmhome.block.presentation;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.block.base.config.IBlockDetailNavigatorService;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/block/presentation/BlockDetailNavigatorServiceImpl;", "Lcom/larus/bmhome/chat/block/base/config/IBlockDetailNavigatorService;", "<init>", "()V", "createBlockDetailNavigator", "Lcom/larus/bmhome/chat/block/base/config/BlockDetailNavigator;", "fragment", "Landroidx/fragment/app/Fragment;", "globalConfigProvider", "Lkotlin/Function0;", "Lcom/larus/bmhome/chat/block/base/config/GlobalConfig;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BlockDetailNavigatorServiceImpl implements IBlockDetailNavigatorService {
    public BlockDetailNavigatorServiceImpl() {
    }

    @Override // com.larus.bmhome.chat.block.base.config.IBlockDetailNavigatorService
    public final a a(Fragment r2, kc8.a r3) {
        Intrinsics.checkNotNullParameter(r3, "globalConfigProvider");
        return new a(r2, r3);
    }
}

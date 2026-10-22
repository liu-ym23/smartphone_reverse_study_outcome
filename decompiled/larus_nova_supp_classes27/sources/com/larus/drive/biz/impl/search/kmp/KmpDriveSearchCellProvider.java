package com.larus.drive.biz.impl.search.kmp;

import com.larus.extension.aggregate_search_ui.api.kmp.KmpISearchCellProvider;
import kotlin.Metadata;
import n79.e;
import n79.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/larus/drive/biz/impl/search/kmp/KmpDriveSearchCellProvider;", "Lcom/larus/extension/aggregate_search_ui/api/kmp/KmpISearchCellProvider;", "<init>", "()V", "provide", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpDriveSearchCellProvider implements KmpISearchCellProvider {
    public KmpDriveSearchCellProvider() {
    }

    public final void provide() {
        KmpISearchCellProvider.Companion r0 = KmpISearchCellProvider.Companion;
        r0.addCell(KmpDriveSearchCell.class, a.C0111a.a, new e());
        r0.addCell(KmpRecentDriveCell.class, b.a.a, new i());
    }
}

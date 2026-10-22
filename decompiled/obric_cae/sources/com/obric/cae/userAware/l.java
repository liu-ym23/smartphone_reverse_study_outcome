package com.obric.cae.userAware;

import com.obric.cae.location.cell.CellPoiService;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class l implements CellPoiService.CellPoiListener {
    @Override // com.obric.cae.location.cell.CellPoiService.CellPoiListener
    public final void onCellPoiStatusChange(int r8, int r10, int r11, long r12, int r13, String r14) {
        SensorCollectManager.a(r8, r10, r11, r12, r13, r14);
    }
}

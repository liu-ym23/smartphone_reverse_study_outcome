package com.obric.cae.userAware;

import com.obric.cae.libs.useraware.CellAwareInfo;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface CellAwareInfoMonitor {
    void onCellInfoChange(CellAwareInfo r1);

    void onCellNeighbourInfoChange(List<CellAwareInfo> r1);
}

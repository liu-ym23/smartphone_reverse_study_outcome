package com.obric.cae.userAware;

import com.obric.cae.libs.useraware.CellAwareInfo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface CellAwareInfoMonitor {
    void onCellInfoChange(CellAwareInfo r8);

    void onCellNeighbourInfoChange(List<CellAwareInfo> r8);
}

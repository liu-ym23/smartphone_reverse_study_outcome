package com.obric.dejavu.library;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aikernel.sdk.ext.Params;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/obric/dejavu/library/DbLogWriter;", "", "write", "", "level", "", LocationMonitorConst.TAG, "", Params.CONTENT, "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface DbLogWriter {
    void write(int r1, String r2, String r3);
}

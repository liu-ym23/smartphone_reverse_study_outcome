package com.obric.cae.smartBluetooth.deviceIdentification.bdim;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements FilenameFilter {
    @Override // java.io.FilenameFilter
    public final boolean accept(File r8, String r10) {
        return BdimAutoTestMode.a(r8, r10);
    }
}

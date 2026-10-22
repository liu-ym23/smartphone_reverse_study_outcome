package com.google.protobuf;

import android.os.ParcelUuid;
import com.obric.cae.cldReport.gnss.GnssLogLevelConfig;
import com.obric.cae.log.CaeLog;
import com.obric.cae.log.CommSenseLog;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5192a;

    public /* synthetic */ c(int r8) {
        this.f5192a = r8;
    }

    @Override // java.util.function.Function
    public final Object apply(Object r8) {
        switch(this.f5192a) {
            case 0: goto L12;
            case 1: goto L10;
            case 2: goto L8;
            case 3: goto L6;
            default: goto L14;
        };
    L6:
        return CaeLog.c((String) r8);
    L8:
        return ((ParcelUuid) r8).toString();
    L10:
        return GnssLogLevelConfig.a((Integer) r8);
    L12:
        return LegacyUnredactedTextFormat.legacyUnredactedStringValueOf(r8);
    L14:
        return CommSenseLog.a((String) r8);
    }
}

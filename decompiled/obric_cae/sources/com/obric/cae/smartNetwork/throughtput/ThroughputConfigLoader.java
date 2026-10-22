package com.obric.cae.smartNetwork.throughtput;

import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import ha.m;
import ha.p;
import ha.s;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ThroughputConfigLoader {
    public ThroughputConfigLoader() {
    }

    public static void applyConfigFromJson(String r13) {
        Iterator<p> r14 = l6.a.z0(r13).f().q("configs").iterator();     // Catch: Exception -> L14
    L3:
        if (r14.hasNext() == false) goto L22;
        s r8 = r14.next().f();     // Catch: Exception -> L14
        String r10 = r8.p(BdimCategoryConstants.NAME_BAND).j();     // Catch: Exception -> L14
        String r11 = r8.p("strategy").j();     // Catch: Exception -> L14
        ThroughputPredictor.Band r12 = ThroughputPredictor.Band.valueOf(r10);     // Catch: Exception -> L14
        ThroughputPredictor.setStrategy(r12, ThroughputPredictor.SplitStrategy.valueOf(r11));     // Catch: Exception -> L14
        ArrayList r15 = new ArrayList();     // Catch: Exception -> L14
        Iterator<p> r16 = r8.q("segments").iterator();     // Catch: Exception -> L14
    L7:
        if (r16.hasNext() == false) goto L12;
        s r17 = r16.next().f();     // Catch: Exception -> L14
        double r18 = r17.p("min").c();     // Catch: Exception -> L14
        double r19 = r17.p("max").c();     // Catch: Exception -> L14
        m r20 = r17.q("coeffs");     // Catch: Exception -> L14
        double[] r110 = new double[10];     // Catch: Exception -> L14
        int r21 = 0;
    L9:
        if (r21 >= 10) goto L11;
        r110[r21] = r20.o(r21).c();     // Catch: Exception -> L14
        r21 = r21 + 1;     // Catch: Exception -> L14
        goto L9
    L11:
        r15.add(new ThroughputPredictor.Segment(r18, r19, r110));     // Catch: Exception -> L14
        goto L7
    L12:
        ThroughputPredictor.setSegments(r12, r15);     // Catch: Exception -> L14
        goto L3
    L22:
        return;
    L14:
        e = move-exception;
        CaeLog.d("ThroughputConfigLoader", "Error parsing JSON config: " + e.getMessage());
    }

    public static void applyDefaultConfig() {
        ArrayList r8 = new ArrayList();
        r8.add(new ThroughputPredictor.Segment(0.0d, 1000.0d, new double[]{60725.03d, -249.4d, 59.65d, -240.63d, 0.23d, -0.1d, 0.35d, -0.0d, -0.03d, 0.13d}));
        ThroughputPredictor.Band r10 = ThroughputPredictor.Band.BAND_5G;
        ThroughputPredictor.setStrategy(r10, ThroughputPredictor.SplitStrategy.BY_CCA_BUSY_RATE);
        ThroughputPredictor.setSegments(r10, r8);
        ArrayList r11 = new ArrayList();
        r11.add(new ThroughputPredictor.Segment(0.0d, 1000.0d, new double[]{38215.6d, -149.74d, 42.81d, -87.72d, 0.12d, -0.06d, 0.15d, 0.0d, -0.06d, 0.07d}));
        ThroughputPredictor.Band r12 = ThroughputPredictor.Band.BAND_2G;
        ThroughputPredictor.setStrategy(r12, ThroughputPredictor.SplitStrategy.BY_PER_RATE);
        ThroughputPredictor.setSegments(r12, r11);
    }
}

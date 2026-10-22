package com.ss.android.lark.location.service;

import android.content.Context;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.location.dto.Scene;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface h {

    public interface a {
        void a(POIInfo r1);
    }

    public interface b {
        void a(k r1);

        void b(List<POIInfo> r1);
    }

    void q(Context r1, POIInfo r2, com.ss.android.lark.location_ui.picklocation.k.a r3);

    void q0(double r1, double r3);

    double r0();

    void release();

    void s0(Context r1, Scene r2, b r3, int r4);

    double t0();

    void u0(Context r1, String r2, Scene r3, com.ss.android.lark.location_ui.picklocation.f r4);

    void v0(Context r1, double r2, double r4, Scene r6, com.ss.android.lark.location_ui.picklocation.h r7);
}

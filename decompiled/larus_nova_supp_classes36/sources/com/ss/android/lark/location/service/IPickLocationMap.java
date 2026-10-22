package com.ss.android.lark.location.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.ss.android.lark.location_ui.picklocation.LocationView;
import com.ss.android.lark.location_ui.picklocation.l;
import com.ss.android.lark.location_ui.picklocation.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface IPickLocationMap extends i {

    public static final enum DarkMode extends Enum<DarkMode> {
        public static final DarkMode AUTO = null;
        public static final DarkMode DARK = null;
        public static final DarkMode LIGHT = null;
        public static final /* synthetic */ DarkMode[] a = null;

        static {
            DarkMode r0 = new DarkMode("LIGHT", 0);
            LIGHT = r0;
            DarkMode r1 = new DarkMode("DARK", 1);
            DARK = r1;
            DarkMode r3 = new DarkMode("AUTO", 2);
            AUTO = r3;
            a = new DarkMode[]{r0, r1, r3};
        }

        public static DarkMode[] values() {
            return (DarkMode[]) a.clone();
        }

        public static DarkMode valueOf(String r1) {
            return (DarkMode) r27.a.a(DarkMode.class, r1);
        }

        public DarkMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
    }

    public interface b {
    }

    public interface c {
        void onMapScreenShot(Bitmap r1);
    }

    public interface d {
    }

    void a(double r1, double r3);

    void b();

    void c();

    void d();

    double e();

    void f(double r1, double r3, LocationView.b r5);

    void g();

    void getVendor();

    int getZoomLevel();

    View h(Context r1);

    void i();

    void j(DarkMode r1);

    void k();

    void m(m r1);

    void n(c r1);

    void o(l r1);

    double p();
}

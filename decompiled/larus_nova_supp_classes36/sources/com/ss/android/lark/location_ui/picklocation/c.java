package com.ss.android.lark.location_ui.picklocation;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.location.dto.Scene;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface c extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void E2(double r1, double r3);

        void J3(Context r1, Bitmap r2, q r3);

        void S0(Context r1, Token r2, Scene r3, LocationView.d r4);

        void U4(Context r1, POIInfo r2, boolean r3);

        void i6(Context r1, String r2, Scene r3, LocationView.c.a r4);

        boolean isAdminGpsEnabled();

        void q(Context r1, POIInfo r2, k.a r3);

        void s5(Context r1, double r2, double r4, Scene r6, LocationView.a r7);

        List v5(boolean r1);

        void w6(Context r1, Scene r2, LocationView.i r3, int r4);
    }

    boolean i5();

    boolean onBackPressed();
}

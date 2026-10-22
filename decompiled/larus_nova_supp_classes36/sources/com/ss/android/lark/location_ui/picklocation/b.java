package com.ss.android.lark.location_ui.picklocation;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.mvp.IModel;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.location.dto.Scene;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface b extends IModel {
    void E5(Context r1, String r2, Scene r3, LocationView.c.a r4);

    void W5(Context r1, Scene r2, LocationView.i r3, int r4);

    void W6(Bitmap r1, q r2);

    boolean isAdminGpsEnabled();

    void l5(Context r1, double r2, double r4, Scene r6, LocationView.a r7);

    void q(Context r1, POIInfo r2, k.a r3);

    void q0(double r1, double r3);

    void q7(Context r1, Token r2, Scene r3, LocationView.d r4);
}

package com.ss.android.lark.photoeditor.impl.ui;

import android.graphics.Bitmap;
import com.larksuite.framework.mvp.IView;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface b extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void F6(String r1, Bitmap r2);

        void L7(Bitmap r1, ArrayList<pfc.f.a> r2);

        void n0(Bitmap r1, vfc.d r2);
    }

    void A2();

    void K3();

    boolean onBackPressed();

    void showToast(String r1);

    void v2(String r1, boolean r2, boolean r3, String r4, String r5, String r6, q0c.a r7);

    void y();

    void z(int r1);
}

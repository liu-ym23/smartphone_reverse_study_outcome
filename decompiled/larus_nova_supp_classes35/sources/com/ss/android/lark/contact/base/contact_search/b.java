package com.ss.android.lark.contact.base.contact_search;

import android.app.Activity;
import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.profile.dto.ProfileFinishResult;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface b extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void H4();

        String getUniqueId();

        void v3(String r1, boolean r2);

        void x0(String r1);
    }

    void A3();

    void F2();

    void M0(String r1);

    void N5();

    void O5(ProfileFinishResult r1);

    void V1();

    Activity getActivity();

    void i0();

    void l2();

    void showToast(String r1);

    void v8(String r1);

    void y4(List<? extends bec.a> r1);
}

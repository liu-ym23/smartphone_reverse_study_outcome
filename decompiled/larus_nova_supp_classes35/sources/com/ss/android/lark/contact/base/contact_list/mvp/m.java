package com.ss.android.lark.contact.base.contact_list.mvp;

import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface m extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void N6(String r1);

        void t4(w8b.a r1);
    }

    void O6(w8b.a r1);

    void Q4(Chatter r1);

    void hideLoading();

    List<w8b.a> j6();

    void l3();

    void o2(List<w8b.a> r1);

    void p4(w8b.a r1);

    void showLoading();

    void z(int r1);
}

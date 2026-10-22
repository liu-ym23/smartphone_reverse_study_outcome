package com.ss.android.lark.filedetail.impl.folder.manage.page.file_list;

import com.larksuite.framework.mvp.IView;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface j extends IView<a> {

    public interface a extends IView.IViewDelegate {
        int M();

        void U(int r1);

        boolean o0();

        void onLoadMore();
    }

    void J0(List<nfb.a> r1);

    void Q5(boolean r1);

    void T3(boolean r1, boolean r2, boolean r3);

    void h6(int r1, String r2);

    void n();
}

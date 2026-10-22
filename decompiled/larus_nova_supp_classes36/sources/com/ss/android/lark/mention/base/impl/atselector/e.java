package com.ss.android.lark.mention.base.impl.atselector;

import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface e extends IView<a> {

    public interface a extends IView.IViewDelegate {
        boolean V0();

        void V2(int r1);

        void b6();

        void c5(BaseAtBean r1);

        void f6();

        void l1(BaseAtBean r1);

        void l8(BaseAtBean r1);

        String n6();

        boolean o0();

        void onLoadMore();

        void onSearch(String r1);

        void u4(BaseAtBean r1);
    }

    void D4(Map<String, BaseAtBean> r1, boolean r2);

    void E8(String r1, List<BaseAtBean> r2);

    void G8(List<BaseAtBean> r1);

    void S3(List<BaseAtBean> r1);

    void T5(Map<String, BaseAtBean> r1);

    void j1(com.ss.android.lark.mention.base.impl.atselector.bean.d r1);

    void o3(String r1);

    void o7();

    void p1(List<BaseAtBean> r1);

    void s4(int r1);

    int y0();
}

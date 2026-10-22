package iib;

import android.content.Context;
import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface c extends IView<a> {

    public interface a extends IView.IViewDelegate {
        boolean H2(int r1);

        void K2(Context r1, List<ForwardTarget> r2, RichText r3);

        s5c.d O0(List<SearchBaseInfo> r1);

        void T6(SearchBaseInfo r1);

        void e1(SearchBaseInfo r1, boolean r2);

        void i2(Context r1, List<SearchBaseInfo> r2, RichText r3);

        void i7(SearchBaseInfo r1);

        void n1(SearchBaseInfo r1, boolean r2);

        void n5();

        void s3(int r1);
    }

    void G4(List<SearchBaseInfo> r1);

    void L0(String r1, boolean r2);

    void U3(com.ss.android.lark.forwardv2.impl.model.b r1, List r2);

    void e6(String r1, String r2, boolean r3);

    void k8(List<SearchBaseInfo> r1);

    void onCancelClick();

    void s7(List<SearchBaseInfo> r1);

    void t8();

    void z6(List<SearchBaseInfo> r1);
}

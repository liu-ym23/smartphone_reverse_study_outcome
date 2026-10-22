package com.ss.android.lark.contact.impl.group.join;

import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.chat.entity.chat.Chat;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface b extends IView<a> {

    public interface a extends IView.IViewDelegate {
        boolean canLoadMore();

        void v1();
    }

    void D6(List<Chat> r1);

    void X7(List<Chat> r1);

    void n();

    void refresh();
}

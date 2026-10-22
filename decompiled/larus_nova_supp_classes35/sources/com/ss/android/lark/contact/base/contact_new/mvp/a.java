package com.ss.android.lark.contact.base.contact_new.mvp;

import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.mvp.IModel;
import com.ss.android.lark.contact.base.dto.ChatApplication;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface a extends IModel {

    /* JADX INFO: renamed from: com.ss.android.lark.contact.base.contact_new.mvp.a$a, reason: collision with other inner class name */
    public interface InterfaceC0166a {
        void a(List<ChatApplication> r1);
    }

    void L4();

    void X1(NewContactPresenter.a r1);

    void a4(String r1, UIGetDataCallback r2);

    void e4(UIGetDataCallback r1);

    boolean isHasMore();

    String x1();
}

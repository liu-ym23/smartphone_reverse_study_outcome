package com.ss.android.lark.chat.chatwindow.chat.v2.component.message;

import com.ss.android.lark.biz.im.api.a1;
import com.ss.android.lark.biz.im.api.b1;
import com.ss.android.lark.biz.im.api.d0;
import com.ss.android.lark.biz.im.api.f0;
import com.ss.android.lark.biz.im.api.h1;
import com.ss.android.lark.biz.im.api.s0;
import com.ss.android.lark.biz.im.api.u0;
import com.ss.android.lark.biz.im.api.v0;
import com.ss.android.lark.biz.im.api.w0;
import com.ss.android.lark.biz.im.api.z0;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chatbase.BasePageStore;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface p {
    m2b.a a();

    s0 b();

    d0 c();

    Map<Class<? extends com.ss.android.lark.biz.im.api.message.params.l>, com.ss.android.lark.biz.im.api.message.params.l> d();

    void e(BasePageStore<MessageInfo, ? extends x4b.a<MessageInfo>> r1);

    q4b.a getMessageSender();

    a1 h();

    w0 i();

    z0 j();

    List<b1> k();

    List<com.ss.android.lark.chatbase.i<MessageInfo>> l();

    f0 m();

    Boolean n();

    boolean o();

    v0 p();

    jya.b q();

    z2b.a r();

    List<h1> s();

    Boolean t();

    y6b.e<y6b.c<?>> u();

    Integer v();

    List<u0> w();

    List<y3b.a> x();
}

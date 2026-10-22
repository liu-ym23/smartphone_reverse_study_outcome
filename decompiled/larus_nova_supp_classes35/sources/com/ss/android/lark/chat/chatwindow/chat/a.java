package com.ss.android.lark.chat.chatwindow.chat;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.k;
import java.util.List;
import s2b.f;
import y6b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface a extends f<c<?>>, com.ss.android.lark.chat.chatwindow.chat.scroll.a<c<?>>, zdc.c<c<?>> {

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.a$a, reason: collision with other inner class name */
    public interface InterfaceC0036a {
        Object a(c<?> r1, c<?> r2);
    }

    void Y0(y6b.a<?> r1);

    RecyclerView.Adapter<?> e();

    List<c<?>> getData();

    List o1(int r1, int r2);

    void q0(k r1);

    void s1(boolean r1);

    void setData(List<? extends c<?>> r1);
}

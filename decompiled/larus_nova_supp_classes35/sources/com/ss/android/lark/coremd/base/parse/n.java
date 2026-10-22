package com.ss.android.lark.coremd.base.parse;

import android.content.Context;
import android.text.Layout;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface n {

    public interface a<T extends v7b.s> extends com.ss.android.lark.coremd.base.parse.b {
        Context getContext();

        int getEnd();

        Layout getLayout();

        T getNode();

        int getStart();

        View getView();
    }

    public interface b<T extends v7b.s> {
        void a(com.ss.android.lark.coremd.impl.parse.f r1);
    }

    <T extends v7b.s> void a(Class<T> r1, b<T> r2);

    <T extends v7b.s> b<T> b(Class<T> r1);
}

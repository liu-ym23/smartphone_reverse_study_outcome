package com.ss.android.lark.coremdbiz.facade.link.parser;

import android.text.Spanned;
import com.ss.android.lark.coremd.base.parse.r;
import v7b.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface b {

    public interface a<T extends dab.a> {
        Spanned a(r<n> r1, T r2);

        Class<T> getType();
    }

    void a();

    Spanned b(r<n> r1, dab.a r2);

    void c(a<?> r1);
}

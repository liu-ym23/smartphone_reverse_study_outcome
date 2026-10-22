package com.ss.android.lark.flow.chat.page.flow.plugin.select;

import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h<T> implements Comparator {
    public static final h<T> a = null;

    static {
        a = new h();
    }

    public h() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r1, Object r2) {
        return ((com.ss.android.lark.biz.im.api.extension.message.i) r1).getId() - ((com.ss.android.lark.biz.im.api.extension.message.i) r2).getId();
    }
}

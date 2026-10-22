package com.ss.android.lark.chat.chatwindow.biz.component.banner;

import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d<T> implements Comparator {
    public static final d<T> a = null;

    static {
        a = new d();
    }

    public d() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r1, Object r2) {
        return ((wya.b) r1).getPriority() - ((wya.b) r2).getPriority();
    }
}

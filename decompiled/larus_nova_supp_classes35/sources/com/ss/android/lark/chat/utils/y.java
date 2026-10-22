package com.ss.android.lark.chat.utils;

import com.ss.android.lark.chatbase.BasePageStore;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class y implements hya.c<String, f5b.b> {
    public final /* synthetic */ String a;

    public static final class a<T> implements hya.a {
        public static final a<T> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object a(Object r2) {
            f5b.b r3 = (f5b.b) r2;
            if (r3 == null) goto L5;
            r3.setForceUpdate(true);
            return r3;
        L5:
            return null;
        }
    }

    public final hya.b<String> b() {
        return new BasePageStore.e(this.a);
    }

    public final hya.a<f5b.b> a() {
        return a.a;
    }

    public y(String r1) {
        this.a = r1;
    }
}

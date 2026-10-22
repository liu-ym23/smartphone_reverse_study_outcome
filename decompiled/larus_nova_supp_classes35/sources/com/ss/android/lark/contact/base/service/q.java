package com.ss.android.lark.contact.base.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class q {
    public final List<f9b.a> a;
    public final List<b> b;

    public static class a {
        public static final q a = null;

        static {
            a = new q();
        }
    }

    public interface b {
        void a();
    }

    public interface c extends b {
        void b(com.ss.android.lark.contact.base.entity.a r1);
    }

    public q() {
        this.a = new CopyOnWriteArrayList();
        this.b = new CopyOnWriteArrayList();
        new CopyOnWriteArrayList();
        new CopyOnWriteArrayList();
        new CopyOnWriteArrayList();
    }
}

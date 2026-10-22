package com.bytedance.android.btm.impl.page.model;

import com.bytedance.android.btm.impl.setting.BtmSetting;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface d extends xc.a<d> {
    public static final a d0 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static d a(Object r10) {
            if (BtmSetting.d.c().d().q() != 1) goto L6;
            return new f(r10);
        L6:
            return new e(r10);
        }
    }

    static {
        d0 = a.a;
    }

    Object a();

    h b();

    void c(d r1);

    String d();

    void e(boolean r1, boolean r10);

    void f(String r1);

    void g(d r1);

    d getParentNode();

    String h();

    boolean i();

    boolean isContainer();

    d j();
}

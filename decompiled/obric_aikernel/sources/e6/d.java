package e6;

import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d<T extends Date> {

    class a extends d<Date> {
        a(Class r10) {
            super(r10);
        }
    }

    static {
        new a(Date.class);
    }

    protected d(Class<T> r10) {
    }
}

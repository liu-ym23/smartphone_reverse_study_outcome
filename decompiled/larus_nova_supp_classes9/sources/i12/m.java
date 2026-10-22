package i12;

import com.bytedance.live.datacontext.DataContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface m {
    public static final a e2 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public final d a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(this);
            if ((r0 instanceof m) == true) goto L5;
            r0 = null;
        L5:
            m r1 = (m) r0;
            if (r1 != null) goto L8;
            return null;
        L8:
            return r1.getInst();
        }
    }

    static {
        e2 = a.a;
    }

    d getInst();
}

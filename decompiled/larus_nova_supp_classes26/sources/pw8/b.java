package pw8;

import android.content.Context;
import android.view.ViewGroup;
import lw8.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ pw8.a a(b r6, Context r7, int r8, uvc.b r9, Boolean r10) {
            return r6.a(r7, r8, r9, r10, null);
        }
    }

    pw8.a a(Context r1, int r2, uvc.b r3, Boolean r4, h r5);

    pw8.a b(Context r1, int r2, int r3, ViewGroup r4, uvc.b r5, Boolean r6, h r7);

    boolean c(uvc.b r1);

    int priority();
}

package cab;

import android.content.Context;
import com.ss.android.lark.coremdbiz.facade.plugins.LarkLinkPlugin$visitLink$1$1;
import kotlin.jvm.internal.Intrinsics;
import v7b.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface b {
    public static final a a = null;

    public static final class a implements b {
        public static final /* synthetic */ a b = null;

        static {
            b = new a();
        }

        public a() {
        }

        @Override // cab.b
        public final boolean a(n r2) {
            Intrinsics.checkNotNullParameter(r2, "link");
            return false;
        }

        @Override // cab.b
        public final void b(Context r2, n r3, LarkLinkPlugin$visitLink$1$1 r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "link");
            Intrinsics.checkNotNullParameter(r4, "callback");
            r4.onSuccess(r3);
        }
    }

    static {
        a = a.b;
    }

    boolean a(n r1);

    void b(Context r1, n r2, LarkLinkPlugin$visitLink$1$1 r3);
}

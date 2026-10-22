package iqb;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.location.service.SearchResultErrorCode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SearchResultErrorCode.values().length];
            r0[SearchResultErrorCode.OK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[SearchResultErrorCode.NETWORK_FAILURE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    @JvmStatic
    public static final void a(Context r1, com.ss.android.lark.location.service.k r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "error");
        SearchResultErrorCode r3 = r2.b;
        int r4 = a.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        int r5 = 2131890586;
    L9:
        UDToast.show(r1, r5, 2131256189);
        return;
    L5:
        if (r4 == 2) goto L7;
        r5 = 2131890587;
        goto L9
    L7:
        r5 = 2131890585;
        goto L9
    }
}

package vf8;

import com.larus.bmhome.chat.list.cell.loading.LoadingType;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g extends xc8.b {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LoadingType.values().length];
            r0[LoadingType.IN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[LoadingType.OUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    @Override // xc8.b
    public final int d() {
        LoadingType r0 = i.a(this.a);
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 != 1) goto L9;
        return 0;
    L9:
        if (r1 != 2) goto L15;
        return 1;
    L15:
        return -1;
    L5:
        r1 = a.a[r0.ordinal()];
        goto L7
    }

    public g(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "loadingMessage");
        super(r2);
    }
}

package po8;

import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e implements fh8.d {
    public final Lazy a;
    public DeepThinkFoldStatus b;
    public final List<Function1<DeepThinkFoldStatus, Unit>> c;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DeepThinkFoldStatus.values().length];
            r0[DeepThinkFoldStatus.HalfFold.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DeepThinkFoldStatus.CompleteFold.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DeepThinkFoldStatus.CompleteExpand.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public final DeepThinkFoldStatus a() {
        DeepThinkFoldStatus r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return DeepThinkFoldStatus.CompleteExpand;
    }

    public final boolean b() {
        if (this.b != DeepThinkFoldStatus.HalfFold) goto L5;
        return true;
    L5:
        return false;
    }

    public e() {
        this.a = LazyKt.lazy(new d());
        this.c = new ArrayList();
    }

    public final void c(DeepThinkFoldStatus r3) {
        DeepThinkFoldStatus r0 = this.b;
        this.b = r3;
        if (r0 == r3) goto L9;
        if (r0 == null) goto L11;
        Iterator r1 = ((ArrayList) this.c).iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        ((Function1) r1.next()).invoke(r3);
        goto L7
    L12:
        return;
    L11:
        return;
    }
}

package tu1;

import com.bytedance.android.livesdk.dynamicstrategy.impl.express.exception.SimpleExpressException;
import com.bytedance.android.livesdk.dynamicstrategy.impl.express.parse.ExpressNodeType;
import java.util.Deque;
import java.util.LinkedList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static final b b = null;
        public final Deque<b> a;

        /* JADX INFO: renamed from: tu1.c$a$a, reason: collision with other inner class name */
        public static final class C0417a {
        }

        public final void a() {
            int r0 = 0;
        L4:
            if (r0 >= (((LinkedList) this.a).size() - 1)) goto L13;
            b r1 = (b) CollectionsKt.elementAt(this.a, r0);
            r0 = r0 + 1;
            b r2 = (b) CollectionsKt.elementAt(this.a, r0);
            if (Intrinsics.areEqual(r2, b) == true) goto L18;
            if (r1.a() == false) goto L19;
            if (r2.a() == true) goto L20;
            r2.d = (b) ((LinkedList) this.a).pop();
            goto L4
        L20:
            return;
        L19:
            return;
        L18:
            return;
        }

        static {
            b = new b(ExpressNodeType.LEFT_BRACKET, "(");
        }

        public a() {
            this.a = new LinkedList();
        }

        public final void b(b r5) {
            Intrinsics.checkNotNullParameter(r5, "node");
            if (this.a.isEmpty() == true) goto L11;
            b r0 = (b) ((LinkedList) this.a).pop();
            if (r0.a() == false) goto L9;
            r5.c = r0;
            ((LinkedList) this.a).push(r5);
            return;
        L9:
            throw new SimpleExpressException("express parse failed, retire not full node", null, 2, null);
        L11:
            throw new SimpleExpressException("express parse failed, retire null node", null, 2, null);
        }
    }

    static {
    }
}

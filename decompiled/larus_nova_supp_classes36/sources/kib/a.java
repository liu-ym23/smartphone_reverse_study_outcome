package kib;

import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import com.ss.android.lark.forwardv2.dto.template.ForwardCallType;
import com.ss.android.lark.forwardv2.dto.template.ForwardLocation;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends q5c.a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: kib.a$a, reason: collision with other inner class name */
    public static final class C0288a {
    }

    public static final class b {
        public final List<String> a;
        public final List<ForwardTarget> b;

        /* JADX INFO: renamed from: kib.a$b$a, reason: collision with other inner class name */
        public static final class C0289a {
            public List<String> a;
            public List<? extends ForwardTarget> b;

            public C0289a() {
                this.a = new ArrayList();
                this.b = new ArrayList();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(String r1, List<String> r2, ForwardCallType r3, ForwardLocation r4, List<? extends ForwardTarget> r5) {
            Intrinsics.checkNotNullParameter(r5, "targets");
            this.a = r2;
            this.b = r5;
        }
    }

    static {
    }
}

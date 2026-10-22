package com.bytedance.android.live.core.tetris.layer.core.layout;

import com.bytedance.android.live.core.tetris.layer.core.ViewLayer;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.android.live.core.tetris.layer.core.layout.a$a, reason: collision with other inner class name */
    public static final class C0160a {
        public final Element<?> a;
        public final List<ElementConstraint.c> b;

        public final String toString() {
            return "Dependency(element=" + this.a + ", rules=" + this.b + ")";
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final boolean equals(Object r2) {
            if ((r2 instanceof C0160a) == true) goto L5;
            r2 = null;
        L5:
            C0160a r3 = (C0160a) r2;
            if (r3 != null) goto L8;
            return false;
        L8:
            return Intrinsics.areEqual(r3.a, this.a);
        }

        public C0160a(Element<?> r2, List<ElementConstraint.c> r3) {
            Intrinsics.checkNotNullParameter(r2, "element");
            Intrinsics.checkNotNullParameter(r3, "rules");
            this.a = r2;
            this.b = r3;
        }
    }

    boolean a(ViewLayer r1);

    boolean b(ViewLayer r1);

    void c(ViewLayer r1, C0160a r2);

    void d(ViewLayer r1, Element<?> r2);

    void g(Element<?> r1, ViewLayer r2);
}

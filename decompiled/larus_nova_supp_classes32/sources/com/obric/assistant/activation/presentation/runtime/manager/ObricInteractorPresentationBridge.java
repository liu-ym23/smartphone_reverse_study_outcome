package com.obric.assistant.activation.presentation.runtime.manager;

import com.obric.assistant.activation.presentation.contract.ObricListeningVisualMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ObricInteractorPresentationBridge {
    public static volatile a a;
    public static final ObricInteractorPresentationBridge$binder$1 b = null;

    public static final class a {
        public final int a;
        public final int b;
        public final ObricListeningVisualMode c;
        public final boolean d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a * 31) + this.b) * 31) + this.c.hashCode()) * 31;
            if (this.d == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "LoggedState(renderer=" + this.a + ", dataSource=" + this.b + ", mode=" + this.c + ", visible=" + this.d + ')';
        }

        public a(int r2, int r3, ObricListeningVisualMode r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r4, "mode");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.assistant.activation.presentation.runtime.manager.ObricInteractorPresentationBridge$binder$1] */
    static {
        b = new ObricInteractorPresentationBridge$binder$1();
    }
}

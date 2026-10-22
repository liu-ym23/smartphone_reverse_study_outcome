package com.larus.bmhome.interactionpanel;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class InteractionPanelQueueManager$c {

    public static final class a extends InteractionPanelQueueManager$c {
        public final List<o> a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Hide(keys=" + this.a + ')';
        }

        public a(List<o> r2) {
            Intrinsics.checkNotNullParameter(r2, "keys");
            this.a = r2;
        }
    }

    public static final class b extends InteractionPanelQueueManager$c {
        public final lq8.d a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Upsert(input=" + this.a + ')';
        }

        public b(lq8.d r2) {
            Intrinsics.checkNotNullParameter(r2, "input");
            this.a = r2;
        }
    }

    public InteractionPanelQueueManager$c() {
    }
}

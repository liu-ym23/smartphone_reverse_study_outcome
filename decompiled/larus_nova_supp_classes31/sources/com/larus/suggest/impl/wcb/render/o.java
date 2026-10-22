package com.larus.suggest.impl.wcb.render;

import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface o {

    public static final class a implements o {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof a) == true) goto L9;
            return false;
        L9:
            a r4 = (a) r3;
            return true;
        }

        public final int hashCode() {
            return 810333684;
        }

        public final String toString() {
            return "Add";
        }
    }

    public static final class b implements o {
        public final String a;

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
            return "Ignore(reason=" + this.a + ')';
        }

        public b() {
            Intrinsics.checkNotNullParameter("regenerate target missing", CustomFeedPlayerEvent.EXTRA_KEY_REASON);
            this.a = "regenerate target missing";
        }
    }

    public static final class c implements o {
        public final p a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Update(target=" + this.a + ')';
        }

        public c(p r2) {
            Intrinsics.checkNotNullParameter(r2, "target");
            this.a = r2;
        }
    }
}

package com.larus.suggest.impl.wcb.render;

import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface n {

    public static final class a implements n {
        public final String a;

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
            return "Rejected(reason=" + this.a + ')';
        }

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
            this.a = r2;
        }
    }

    public static final class b implements n {
        public final String a;
        public final Map<String, String> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Submitted(localMessageId=" + this.a + ", ext=" + this.b + ')';
        }

        public b(String r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "localMessageId");
            Intrinsics.checkNotNullParameter(r3, "ext");
            this.a = r2;
            this.b = r3;
        }
    }
}

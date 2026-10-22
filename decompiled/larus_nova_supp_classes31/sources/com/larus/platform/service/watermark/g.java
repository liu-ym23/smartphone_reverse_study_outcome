package com.larus.platform.service.watermark;

import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public abstract class g {

    public static final class a extends g {
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
            return "Degraded(reason=" + this.a + ')';
        }

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
            this.a = r2;
        }
    }

    public static final class b extends g {
        public final String a;
        public final Function1<Continuation<? super Unit>, Object> b;

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
            return "Ready(url=" + this.a + ", cleanup=" + this.b + ')';
        }

        public /* synthetic */ b(String r3) {
            this(r3, new WatermarkResult$Ready$1(null));
        }

        public b(String r2, Function1<? super Continuation<? super Unit>, ? extends Object> r3) {
            Intrinsics.checkNotNullParameter(r2, "url");
            Intrinsics.checkNotNullParameter(r3, "cleanup");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c extends g {
        public final String a;

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
            return "ReadyLocalFile(localPath=" + this.a + ')';
        }

        public c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "localPath");
            this.a = r2;
        }
    }

    public static final class d extends g {
        public final com.larus.platform.service.watermark.c a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "ReadyLocalImage(output=" + this.a + ')';
        }

        public d(com.larus.platform.service.watermark.c r2) {
            Intrinsics.checkNotNullParameter(r2, "output");
            this.a = r2;
        }
    }

    public g() {
    }
}

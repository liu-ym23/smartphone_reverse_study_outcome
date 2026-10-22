package com.bytedance.ai.applet.app.foundation.performance;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface g {

    public static final class a implements i {
        public final long a;
        public final String b;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Page(traceId=" + this.a + ", path=" + this.b + ')';
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.g
        public final long getTraceId() {
            return this.a;
        }

        public a(long r10, String r11) {
            Intrinsics.checkNotNullParameter(r11, "path");
            this.a = r10;
            this.b = r11;
        }
    }

    public static final class b implements g {
        public final long a;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.a == ((b) r10).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (int) (r0 ^ (r0 >>> 32));
        }

        public final String toString() {
            return "Standalone(traceId=" + this.a + ')';
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.g
        public final long getTraceId() {
            return this.a;
        }

        public b(long r1) {
            this.a = r1;
        }
    }

    public static final class c implements i {
        public final long a;
        public final String b;
        public final String c;
        public final boolean d;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r11.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            if (this.d == false) goto L5;
            int r10 = 1231;
        L7:
            return r1 + r10;
        L5:
            r10 = 1237;
            goto L7
        }

        public final String toString() {
            return "Widget(traceId=" + this.a + ", widgetId=" + this.b + ", widgetInstanceId=" + this.c + ", isAppColdLaunch=" + this.d + ')';
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.g
        public final long getTraceId() {
            return this.a;
        }

        public c(long r10, String r11, String r12, boolean r13) {
            Intrinsics.checkNotNullParameter(r11, "widgetId");
            Intrinsics.checkNotNullParameter(r12, "widgetInstanceId");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
        }
    }

    long getTraceId();
}

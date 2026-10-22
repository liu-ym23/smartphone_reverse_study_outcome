package com.bytedance.android.anniex.detect;

import com.byted.cast.sink.api.IServerListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class c {

    public static final class a extends c {
        public final int a;
        public final String b;
        public final FailureStage c;

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
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r11.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "Error(statusCode=" + this.a + ", errorMsg=" + this.b + ", stage=" + this.c + ')';
        }

        public a(int r10, String r11, FailureStage r12) {
            Intrinsics.checkNotNullParameter(r11, "errorMsg");
            Intrinsics.checkNotNullParameter(r12, "stage");
            this.a = r10;
            this.b = r11;
            this.c = r12;
        }
    }

    public static final class b extends c {
        public final int a;
        public final float b;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (Float.compare(this.b, r11.b) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + Float.floatToIntBits(this.b);
        }

        public final String toString() {
            return "PureWhite(statusCode=" + this.a + ", probability=" + this.b + ')';
        }

        public b(float r10) {
            this.a = IServerListener.WHAT_BYTELINK_SINK_ERROR;
            this.b = r10;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.anniex.detect.c$c, reason: collision with other inner class name */
    public static final class C0092c extends c {
        public final int a;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof C0092c) == true) goto L9;
            return false;
        L9:
            if (this.a == ((C0092c) r10).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "Success(statusCode=" + this.a + ')';
        }

        public C0092c() {
            this.a = 200;
        }
    }

    public c() {
    }
}

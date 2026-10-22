package com.bytedance.ai.bridge.core;

import com.bytedance.ai.event.MessageIndication;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class a<T> {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.core.a$a, reason: collision with other inner class name */
    public static final class C0020a {
        public C0020a() {
        }

        public static b a(int r10, String r11) {
            int r0 = a.a;
            Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
            return new b(r10, r11, null, null, 24);
        }
    }

    public static final class b extends a {
        public final int b;
        public final String c;
        public final JsonObject d;
        public final f3.a e;
        public final JsonObject f;

        public b() {
            this(0, null, null, null, 31);
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (this.b == r11.b) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.d, r11.d) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.e, r11.e) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f, r11.f) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final String toString() {
            return "Failure(code=" + this.b + ", msg=" + this.c + ", data=" + this.d + ", errNo=" + this.e + ", extras=" + this.f + ')';
        }

        public final int hashCode() {
            int r0 = ((this.b * 31) + this.c.hashCode()) * 31;
            JsonObject r1 = this.d;
            int r10 = 0;
            if (r1 != null) goto L5;
            int r11 = 0;
        L6:
            int r12 = (r0 + r11) * 31;
            f3.a r13 = this.e;
            if (r13 != null) goto L9;
            int r14 = 0;
        L10:
            int r15 = (r12 + r14) * 31;
            JsonObject r16 = this.f;
            if (r16 == null) goto L15;
            r10 = r16.hashCode();
        L15:
            return r15 + r10;
        L9:
            r14 = r13.a;
            goto L10
        L5:
            r11 = r1.hashCode();
            goto L6
        }

        public /* synthetic */ b(int r10, String r11, JsonObject r12, f3.a r13, int r14) {
            if ((r14 & 1) == 0) goto L5;
            int r1 = 0;
        L7:
            if ((r14 & 2) == 0) goto L9;
            r11 = "";
        L9:
            String r15 = r11;
            if ((r14 & 4) == 0) goto L12;
            JsonObject r16 = null;
        L14:
            if ((r14 & 8) == 0) goto L16;
            f3.a r17 = null;
        L17:
            this(r1, r15, r16, r17, null);
            return;
        L16:
            r17 = r13;
            goto L17
        L12:
            r16 = r12;
            goto L14
        L5:
            r1 = r10;
            goto L7
        }

        public b(int r10, String r11, JsonObject r12, f3.a r13, JsonObject r14) {
            Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
        }
    }

    public static final class c<T> extends a<T> {
        public final T b;
        public final String c;

        public c() {
            throw null;
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            T r0 = this.b;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.c.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public final String toString() {
            return "Success(data=" + this.b + ", msg=" + this.c + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(Object r10) {
            Intrinsics.checkNotNullParameter("", MessageIndication.MESSAGE_TYPE_MSG);
            this.b = r10;
            this.c = "";
        }
    }

    static {
        new C0020a();
    }

    public a() {
    }
}

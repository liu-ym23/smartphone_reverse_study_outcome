package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@Nullsafe(Nullsafe.Mode.STRICT)
public abstract class Objects {

    public static final class ToStringHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ValueHolder f7653b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ValueHolder f7654c;

        public static final class ValueHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f7655a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f7656b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public ValueHolder f7657c;

            public ValueHolder() {
            }
        }

        public ToStringHelper(String r5) {
            ValueHolder r10 = new ValueHolder();
            this.f7653b = r10;
            this.f7654c = r10;
            this.f7652a = r5;
        }

        public final ToStringHelper a(String r5, Object r10) {
            ValueHolder r11 = new ValueHolder();
            this.f7654c.f7657c = r11;
            this.f7654c = r11;
            r11.f7656b = r10;
            r11.f7655a = r5;
            return this;
        }

        public final String toString() {
            StringBuilder r5 = new StringBuilder(32);
            r5.append(this.f7652a);
            r5.append('{');
            ValueHolder r10 = this.f7653b.f7657c;
            String r11 = "";
        L3:
            if (r10 == null) goto L13;
            Object r12 = r10.f7656b;
            r5.append(r11);
            String r13 = r10.f7655a;
            if (r13 == null) goto L7;
            r5.append(r13);
            r5.append('=');
        L7:
            if (r12 != null) goto L9;
        L11:
            r5.append(r12);
        L12:
            r10 = r10.f7657c;
            r11 = ", ";
            goto L3
        L9:
            if (r12.getClass().isArray() == false) goto L11;
            String r14 = Arrays.deepToString(new Object[]{r12});
            r5.append(r14, 1, r14.length() - 1);
            goto L12
        L13:
            r5.append('}');
            return r5.toString();
        }
    }

    public static boolean a(Object r5, Object r10) {
        if (r5 == r10) goto L9;
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.equals(r10) == true) goto L12;
        return false;
    L12:
        return true;
    L9:
        return true;
    }
}

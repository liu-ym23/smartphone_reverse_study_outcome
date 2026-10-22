package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.BaseMVIViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final Map<C0100a, Boolean> a = null;
    public static final Map<Class<?>, Class<?>> b = null;

    /* JADX INFO: renamed from: com.bytedance.android.anya.internal.a$a, reason: collision with other inner class name */
    public static final class C0100a {
        public final Class<? extends BaseMVIViewModel<?, ?>> a;
        public final Class<? extends com.bytedance.android.anya.p> b;

        public final boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof C0100a) == false) goto L10;
            C0100a r11 = (C0100a) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            Class<? extends BaseMVIViewModel<?, ?>> r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r10 = r0.hashCode();
        L6:
            int r11 = r10 * 31;
            Class<? extends com.bytedance.android.anya.p> r12 = this.b;
            if (r12 == null) goto L10;
            r1 = r12.hashCode();
        L10:
            return r11 + r1;
        L5:
            r10 = 0;
            goto L6
        }

        public final String toString() {
            return "CacheEntry(viewModelType=" + this.a + ", actionType=" + this.b + ")";
        }

        public C0100a(Class<? extends BaseMVIViewModel<?, ?>> r1, Class<? extends com.bytedance.android.anya.p> r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    static {
        a = new LinkedHashMap();
        b = new LinkedHashMap();
    }
}

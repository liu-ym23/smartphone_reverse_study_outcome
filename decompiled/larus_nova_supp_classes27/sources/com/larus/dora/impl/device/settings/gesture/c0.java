package com.larus.dora.impl.device.settings.gesture;

import com.larus.dora.impl.model.GestureSettingsKey;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface c0 {

    public static final class a implements c0 {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b implements c0 {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c implements c0 {
        public final Map<GestureSettingsKey, Byte> a;

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
            return "Success(map=" + this.a + ')';
        }

        public c(Map<GestureSettingsKey, Byte> r2) {
            Intrinsics.checkNotNullParameter(r2, "map");
            this.a = r2;
        }
    }
}

package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton.c;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.f2.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class f2<ICON extends ExtendedToolbarButton.c, DATA extends b, BEHAVIOR extends c0.b> {
    public final Map<a, Pair<ICON, BEHAVIOR>> a;

    public static final class a {
        public final String a;
        public final long b;

        public final String toString() {
            return "Key(uniqueId=" + this.a + ", groupType=" + this.b + ")";
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + String.valueOf(this.b).hashCode();
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if (r8 == null) goto L8;
            Class<?> r2 = r8.getClass();
        L10:
            if ((!Intrinsics.areEqual(a.class, r2)) == false) goto L12;
            return false;
        L12:
            if (r8 == null) goto L21;
            a r9 = (a) r8;
            if ((!Intrinsics.areEqual(this.a, r9.a)) == false) goto L17;
            return false;
        L17:
            if (this.b == r9.b) goto L19;
            return false;
        L19:
            return true;
        L21:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.NetworkIconToolbarLoader.Key");
        L8:
            r2 = null;
            goto L10
        }

        public a(String r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "uniqueId");
            this.a = r2;
            this.b = r3;
        }
    }

    public interface b {
    }

    public abstract f10.f a(b r1);

    public abstract BEHAVIOR b(DATA r1);

    public abstract void c(DATA r1);

    public abstract f10.f d(b r1, ExtendedToolbarButton.c r2);

    public f2() {
        this.a = new LinkedHashMap();
    }
}

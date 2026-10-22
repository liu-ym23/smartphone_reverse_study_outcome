package com.bytedance.android.live.base.model.user;

import android.os.Bundle;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface o0 {
    public static final a a = null;

    public static final class a {
        public static final C0015a a = null;
        public static final /* synthetic */ a b = null;

        /* JADX INFO: renamed from: com.bytedance.android.live.base.model.user.o0$a$a, reason: collision with other inner class name */
        public static final class C0015a implements o0 {
            @Override // com.bytedance.android.live.base.model.user.o0
            public final long getAwemeUserId() {
                return 0;
            }

            @Override // com.bytedance.android.live.base.model.user.o0
            public final String getOpenUserId() {
                return "0";
            }

            @Override // com.bytedance.android.live.base.model.user.o0
            public final String getUserId() {
                return "0";
            }

            @Override // com.bytedance.android.live.base.model.user.o0
            public final boolean a() {
                return b.a(this);
            }

            public C0015a() {
            }
        }

        public a() {
        }

        static {
            b = new a();
            a = new C0015a();
        }

        @JvmStatic
        public static boolean b(String r0) {
            if (r0 != null) goto L6;
            return false;
        L6:
            return q0.a(r0);
        }

        @JvmStatic
        public static Object f(String r1) {
            if (q0.a(r1) == false) goto L8;
            if (r1 == null) goto L7;
            return r1;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
        L8:
            return "0";
        }

        @JvmStatic
        public static List h(List r0) {
            if (r0 == null) goto L4;
            return r0;
        L4:
            return CollectionsKt.emptyList();
        }

        @JvmStatic
        public static String i(String r3) {
            Intrinsics.checkNotNullParameter("0", "defVal");
            if (r3 == null) goto L8;
            if (q0.a(r3) != true) goto L8;
            return r3;
        L8:
            return "0";
        }

        @JvmStatic
        public static boolean a(String r2, String r3) {
            if (r2 != null) goto L5;
        L10:
            if (r2 != null) goto L12;
        L13:
            if (r3 != null) goto L15;
            return true;
        L15:
            if (q0.a(r3) != true) goto L21;
        L17:
            return false;
        L21:
            return true;
        L12:
            if (q0.a(r2) == true) goto L17;
        L5:
            if (q0.a(r2) != true) goto L10;
            if (r3 == null) goto L10;
            if (q0.a(r3) != true) goto L10;
            return Intrinsics.areEqual(r2, r3);
        }

        @JvmStatic
        public static String g(Long r2, String r3) {
            if (r2 == null) goto L4;
            String.valueOf(r2.longValue());
        L4:
            if (r3 != null) goto L7;
            return "0";
        L7:
            return r3;
        }

        @JvmStatic
        public static String c(Bundle r1, String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "defaultVal");
            if (r1 != null) goto L6;
            return r3;
        L6:
            if (r1.containsKey(r2) == true) goto L8;
            return r3;
        L8:
            String r4 = r1.getString(r2);
            if (r4 != null) goto L12;
            return r3;
        L12:
            return r4;
        }

        public static /* synthetic */ String d(a r0, Bundle r1, String r2) {
            r0.getClass();
            return c(r1, r2, "0");
        }

        public static String e(a r1, JSONObject r2, String r3) {
            r1.getClass();
            Intrinsics.checkNotNullParameter(r3, "key");
            Intrinsics.checkNotNullParameter("0", "defaultVal");
            if (r2 != null) goto L6;
            return "0";
        L6:
            if (r2.has(r3) == true) goto L9;
            return "0";
        L9:
            return r2.optString(r3, "0");
        }
    }

    public static final class b {
        public static boolean a(o0 r2) {
            o0.a.getClass();
            if (Intrinsics.areEqual(r2, a.a) == false) goto L5;
            return false;
        L5:
            String r3 = r2.getOpenUserId();
            if (r3 != null) goto L8;
            return false;
        L8:
            if (q0.a(r3) != true) goto L12;
            return true;
        L12:
            return false;
        }
    }

    static {
        a = a.b;
    }

    boolean a();

    long getAwemeUserId();

    String getOpenUserId();

    String getUserId();
}

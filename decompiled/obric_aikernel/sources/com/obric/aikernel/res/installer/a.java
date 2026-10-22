package com.obric.aikernel.res.installer;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.res.PrmContext;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public interface a {

    /* JADX INFO: renamed from: com.obric.aikernel.res.installer.a$a, reason: collision with other inner class name */
    public static final class C0113a {
        public static boolean a(a r10, PrmContext r11, String r12, String r13, String r14) {
            Intrinsics.checkNotNullParameter(r11, "context");
            Intrinsics.checkNotNullParameter(r12, WsConstants.KEY_CONNECTION_TYPE);
            Intrinsics.checkNotNullParameter(r13, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r14, "version");
            return false;
        }

        public static void b(a r10, PrmContext r11) {
            Intrinsics.checkNotNullParameter(r11, "context");
        }

        public static List<b> c(a r10, PrmContext r11) {
            Intrinsics.checkNotNullParameter(r11, "context");
            r10.a(r11);
            return CollectionsKt.emptyList();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f5003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f5004b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f5005c;

        public b(String r10, String r11, int r12, int r13) {
            Intrinsics.checkNotNullParameter(r10, "tag");
            Intrinsics.checkNotNullParameter(r11, WsConstants.KEY_CONNECTION_TYPE);
            this.f5003a = r11;
            this.f5004b = r12;
            this.f5005c = r13;
        }

        public /* synthetic */ b(String r10, String r11, int r12, int r13, int r14, DefaultConstructorMarker r15) {
            if ((r14 & 4) == 0) goto L6;
            r12 = 0;
        L6:
            if ((r14 & 8) == 0) goto L8;
            r13 = 0;
        L8:
            this(r10, r11, r12, r13);
        }

        public final int a() {
            return this.f5005c;
        }

        public final int b() {
            return this.f5004b;
        }

        public final String c() {
            return this.f5003a;
        }

        public final void d(int r10) {
            this.f5005c = r10;
        }

        public final void e(int r10) {
            this.f5004b = r10;
        }
    }

    void a(PrmContext r10);

    List<b> b(PrmContext r10);

    boolean c(PrmContext r10, String r11, String r12, String r13);

    String tag();
}

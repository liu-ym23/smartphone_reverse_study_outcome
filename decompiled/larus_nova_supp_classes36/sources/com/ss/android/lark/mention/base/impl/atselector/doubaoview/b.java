package com.ss.android.lark.mention.base.impl.atselector.doubaoview;

import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface b {

    public static final class a implements b {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.mention.base.impl.atselector.doubaoview.b$b, reason: collision with other inner class name */
    public static final class C0175b implements b {
        public final String a;
        public final Throwable b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0175b) == true) goto L8;
            return false;
        L8:
            C0175b r6 = (C0175b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            Throwable r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "Error(message=" + this.a + ", cause=" + this.b + ')';
        }

        public C0175b(Throwable r3) {
            Intrinsics.checkNotNullParameter("", INotificationHitPoint.NoticeType.MESSAGE);
            this.a = "";
            this.b = r3;
        }
    }

    public static final class c implements b {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }
    }

    public static final class d implements b {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }
    }

    public static final class e implements b {
        public final List<BaseAtBean> a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((e) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Success(items=" + this.a + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e(List<? extends BaseAtBean> r2) {
            Intrinsics.checkNotNullParameter(r2, "items");
            this.a = r2;
        }
    }
}

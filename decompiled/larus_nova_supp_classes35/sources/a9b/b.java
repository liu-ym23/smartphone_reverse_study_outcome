package a9b;

import com.ss.android.lark.contact.base.entity.mobile.ContactMobileBean;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final /* synthetic */ int c = 0;
    public final List<C0005b> a;
    public final List<ContactMobileBean> b;

    public static final class a {
    }

    /* JADX INFO: renamed from: a9b.b$b, reason: collision with other inner class name */
    public static final class C0005b {
        public final ContactMobileBean a;
        public final List<a9b.a> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0005b) == true) goto L8;
            return false;
        L8:
            C0005b r6 = (C0005b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "CpFeishuUsers(cp=" + this.a + ", userInfos=" + this.b + ')';
        }

        public C0005b(ContactMobileBean r2, List<a9b.a> r3) {
            Intrinsics.checkNotNullParameter(r2, "cp");
            Intrinsics.checkNotNullParameter(r3, "userInfos");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "ContactsMobileFeishuInfo(cpFeishuUsers=" + this.a + ", cpNotFeishuUsers=" + this.b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<C0005b> r2, List<? extends ContactMobileBean> r3) {
        Intrinsics.checkNotNullParameter(r2, "cpFeishuUsers");
        Intrinsics.checkNotNullParameter(r3, "cpNotFeishuUsers");
        this.a = r2;
        this.b = r3;
    }
}

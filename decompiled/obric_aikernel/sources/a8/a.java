package a8;

import android.content.Context;
import d6.c;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f122a = null;

    /* JADX INFO: renamed from: a8.a$a, reason: collision with other inner class name */
    public static final class C0003a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @c("target_package")
        private final String f123a;

        public final String a() {
            return this.f123a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof C0003a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f123a, ((C0003a) r10).f123a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f123a.hashCode();
        }

        public String toString() {
            return "DebugInfo(targetPackage=" + this.f123a + ')';
        }
    }

    static {
        f122a = new a();
    }

    private a() {
    }

    public final void a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        new File(r10.getFilesDir(), "aee_debug_info.json").delete();
    }

    public final C0003a b(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        File r11 = new File(r10.getFilesDir(), "aee_debug_info.json");
        if (r11.canRead() == true) goto L7;
        return null;
    L7:
        return (C0003a) com.obric.aikernel.res.utils.a.f5222a.h(r11, C0003a.class);
    }
}

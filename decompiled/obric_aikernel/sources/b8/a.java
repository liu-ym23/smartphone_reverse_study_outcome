package b8;

import android.content.Context;
import com.google.gson.k;
import com.obric.aikernel.runtime.utils.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f536a;

    /* JADX INFO: renamed from: b8.a$a, reason: collision with other inner class name */
    public static final class C0025a {
        private C0025a() {
        }

        public /* synthetic */ C0025a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new C0025a(null);
    }

    public a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.f536a = new c(r10);
    }

    public final byte[] a(String r10, k r11) {
        Intrinsics.checkNotNullParameter(r10, "url");
        Intrinsics.checkNotNullParameter(r11, "params");
        com.obric.aikernel.runtime.utils.c.a.a(d.f5417a, "Adapter", "request url is " + r10 + ", params is " + r11, 0, 4, null);
        c r12 = this.f536a;
        String r13 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r13, "params.toString()");
        byte[] r14 = r13.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String).getBytes(charset)");
        return r12.c(r10, r14);
    }
}

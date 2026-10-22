package okhttp3;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public interface m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public static final m f12010a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f12011a = null;

        /* JADX INFO: renamed from: okhttp3.m$a$a, reason: collision with other inner class name */
        private static final class C0269a implements m {
            public C0269a() {
            }

            @Override // okhttp3.m
            public void a(s r10, List<l> r11) {
                Intrinsics.checkNotNullParameter(r10, "url");
                Intrinsics.checkNotNullParameter(r11, "cookies");
            }

            @Override // okhttp3.m
            public List<l> b(s r10) {
                Intrinsics.checkNotNullParameter(r10, "url");
                return CollectionsKt.emptyList();
            }
        }

        static {
            f12011a = new a();
        }

        private a() {
        }
    }

    static {
        a r10 = a.f12011a;
        f12010a = new a.C0269a();
    }

    void a(s r10, List<l> r11);

    List<l> b(s r10);
}

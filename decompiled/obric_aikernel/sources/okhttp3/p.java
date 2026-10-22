package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public interface p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public static final p f12019a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f12020a = null;

        /* JADX INFO: renamed from: okhttp3.p$a$a, reason: collision with other inner class name */
        private static final class C0270a implements p {
            public C0270a() {
            }

            @Override // okhttp3.p
            public List<InetAddress> a(String r10) {
                Intrinsics.checkNotNullParameter(r10, "hostname");
                InetAddress[] r11 = InetAddress.getAllByName(r10);     // Catch: SecurityException -> L5 NullPointerException -> L8
                Intrinsics.checkNotNullExpressionValue(r11, "getAllByName(hostname)");     // Catch: SecurityException -> L5 NullPointerException -> L8
                return ArraysKt.toList(r11);
            L8:
                e = move-exception;
                UnknownHostException r12 = new UnknownHostException("Broken system behaviour for dns lookup of " + r10);
                r12.initCause(e);
                throw r12;
            L5:
                e = move-exception;
                UnknownHostException r13 = new UnknownHostException("Permission denied for dns lookup of " + r10);
                r13.initCause(e);
                throw r13;
            }
        }

        static {
            f12020a = new a();
        }

        private a() {
        }
    }

    static {
        a r10 = a.f12020a;
        f12019a = new a.C0270a();
    }

    List<InetAddress> a(String r10);
}

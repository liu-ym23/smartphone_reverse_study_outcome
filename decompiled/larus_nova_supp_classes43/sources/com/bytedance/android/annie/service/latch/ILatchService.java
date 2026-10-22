package com.bytedance.android.annie.service.latch;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.ies.web.jsbridge2.d0;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface ILatchService extends com.bytedance.android.annie.service.a {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/annie/service/latch/ILatchService$PrefetchStrategy;", "", "Prefetch", "Latch", "Nothing", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final enum PrefetchStrategy extends Enum<PrefetchStrategy> {
        public static final PrefetchStrategy Latch = null;
        public static final PrefetchStrategy Nothing = null;
        public static final PrefetchStrategy Prefetch = null;
        public static final /* synthetic */ PrefetchStrategy[] a = null;

        public static PrefetchStrategy valueOf(String r1) {
            return (PrefetchStrategy) r27.a.a(PrefetchStrategy.class, r1);
        }

        public static PrefetchStrategy[] values() {
            return (PrefetchStrategy[]) a.clone();
        }

        static {
            PrefetchStrategy r0 = new PrefetchStrategy("Prefetch", 0);
            Prefetch = r0;
            PrefetchStrategy r1 = new PrefetchStrategy("Latch", 1);
            Latch = r1;
            PrefetchStrategy r10 = new PrefetchStrategy("Nothing", 2);
            Nothing = r10;
            a = new PrefetchStrategy[]{r0, r1, r10};
        }

        public PrefetchStrategy(String r1, int r10) {
            super(r1, r10);
        }
    }

    public interface a {
        void a(c r1);

        void b(b r1);

        void c(int r1, int r10, String r11, String r12, int r13, String r14, Map<String, ? extends Object> r15);
    }

    public static final class b {
        public final JSONObject a;
        public final JSONObject b;
        public final JSONObject c;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "LatchJsbPromiseMetric(category=" + this.a + ", metrics=" + this.b + ", extra=" + this.c + ')';
        }

        public b(JSONObject r10, JSONObject r11, JSONObject r12) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_CATEGORY);
            Intrinsics.checkNotNullParameter(r11, "metrics");
            Intrinsics.checkNotNullParameter(r12, "extra");
            this.a = r10;
            this.b = r11;
            this.c = r12;
        }
    }

    public static final class c {
        public final JSONObject a;
        public final JSONObject b;
        public final JSONObject c;

        public final String toString() {
            return "LatchPerfMetric(metrics=" + this.a + ", category=" + this.b + ", extra=" + this.c + ')';
        }

        public c(JSONObject r10, JSONObject r11, JSONObject r12) {
            Intrinsics.checkNotNullParameter(r10, "metrics");
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_CATEGORY);
            Intrinsics.checkNotNullParameter(r12, "extra");
            this.a = r10;
            this.b = r11;
            this.c = r12;
        }
    }

    public static final class d {
        public String a;
        public long b;
        public String c;
        public a d;
        public String e;
        public boolean f;
        public final Map<String, String> g;

        public d() {
            this.a = "";
            this.c = "fullscreen";
            this.g = new LinkedHashMap();
        }
    }

    public interface e extends Disposable {
        void f(d0 r1);
    }

    boolean O0(View r1);

    void Q0(String r1);

    String R0(View r1);

    void S0(String r1);

    boolean c(View r1);

    void d(String r1, boolean r10);

    int d1(Context r1, String r10, Uri r11, d r12);

    d e(long r1, String r10, String r11, String r12);

    String i(Uri r1);

    void initPrefetch();

    Pair<PrefetchStrategy, String> k(Uri r1, String r10);

    void s(Uri r1);

    e u0(Context r1, String r10, Uri r11, long r12, d r13, boolean r14);
}

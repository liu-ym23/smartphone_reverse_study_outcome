package pp9;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i {
    public static final Lazy a = null;
    public static Function0<? extends JSONObject> b;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;

    public static final class a implements gx8.e {
        public a() {
        }

        public final String getEventType() {
            return "open_album";
        }

        public final String getUploadName() {
            return "basic_performance_operation_count";
        }

        public final String getUniqueKey() {
            return gx8.e.a.a(this);
        }
    }

    public static final class b implements gx8.e {
        public b() {
        }

        public final String getEventType() {
            return "open_album";
        }

        public final String getUploadName() {
            return "basic_performance_operation_cost_time";
        }

        public final String getUniqueKey() {
            return gx8.e.a.a(this);
        }
    }

    public static final class c implements gx8.e {
        public c() {
        }

        public final String getEventType() {
            return "open_album_frame";
        }

        public final String getUploadName() {
            return "basic_performance_operation_cost_time";
        }

        public final String getUniqueKey() {
            return gx8.e.a.a(this);
        }
    }

    public static final class d extends gx8.a {

        public static final class a implements gx8.d {
            public a() {
            }

            public final JSONObject a() {
                Lazy r0 = i.a;
                Function0<? extends JSONObject> r1 = i.b;
                if (r1 == null) goto L7;
                JSONObject r2 = (JSONObject) r1.invoke();
                if (r2 == null) goto L7;
                return r2;
            L7:
                return new JSONObject();
            }
        }

        public final gx8.d b() {
            return new a();
        }

        public d() {
        }
    }

    static {
        a = LazyKt.lazy(new e());
        c = LazyKt.lazy(new f());
        d = LazyKt.lazy(new g());
        e = LazyKt.lazy(new h());
    }

    public static d a() {
        return (d) a.getValue();
    }

    public static void b(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "extraAttributes");
        d r1 = a();
        a r2 = (a) e.getValue();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r4, "extraAttributes");
        ((gx8.a) r1).a.b(r2, r4);
    }
}

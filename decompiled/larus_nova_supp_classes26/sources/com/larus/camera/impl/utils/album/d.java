package com.larus.camera.impl.utils.album;

import kotlin.Lazy;
import kotlin.LazyKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;

    public static final class a implements gx8.e {
        public a() {
        }

        @Override // gx8.e
        public final String getEventType() {
            return "camera_quick_album";
        }

        @Override // gx8.e
        public final String getUploadName() {
            return "basic_performance_operation_cost_time";
        }

        @Override // gx8.e
        public final String getUniqueKey() {
            return gx8.e.a.a(this);
        }
    }

    public static final class b implements gx8.e {
        public b() {
        }

        @Override // gx8.e
        public final String getEventType() {
            return "camera_quick_album";
        }

        @Override // gx8.e
        public final String getUploadName() {
            return "basic_performance_operation_count";
        }

        @Override // gx8.e
        public final String getUniqueKey() {
            return gx8.e.a.a(this);
        }
    }

    public static final class c extends gx8.a {

        public static final class a implements gx8.d {
            public a() {
            }

            @Override // gx8.d
            public final JSONObject a() {
                JSONObject r0 = new JSONObject();
                r0.put("enter_method", "camera_album_thumbnail_click");
                return r0;
            }
        }

        @Override // gx8.a
        public final gx8.d b() {
            return new a();
        }

        public c() {
        }
    }

    static {
        a = LazyKt.lazy(new com.larus.camera.impl.utils.album.a());
        b = LazyKt.lazy(new com.larus.camera.impl.utils.album.b());
        c = LazyKt.lazy(new com.larus.camera.impl.utils.album.c());
    }
}

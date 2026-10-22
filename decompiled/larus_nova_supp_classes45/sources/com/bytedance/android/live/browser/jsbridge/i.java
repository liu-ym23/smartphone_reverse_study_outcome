package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface i {

    public static abstract class a<T> implements c {
        public a() {
        }

        public abstract T b();

        public abstract g<T> c();

        @Override // com.bytedance.android.live.browser.jsbridge.i.c
        public final String getKey() {
            return c().a;
        }
    }

    public interface b extends c {
        Observable<JsonElement> a(String r1);
    }

    public interface c {
        String getKey();
    }

    public interface d {
        JsonObject a();

        void b(String r1, JSONArray r2, Function2<? super String, ? super com.bytedance.ies.web.jsbridge2.g<JsonObject, JsonObject>, Unit> r3, Function1<? super String, Unit> r4);

        void release();
    }

    public static abstract class e<T> implements f<T> {
        public final String a;

        public static final class a extends e<Episode> {
            public static final /* synthetic */ int b = 0;

            static {
            }
        }

        public static final class b extends e<JsonObject> {
            public static final b b = null;

            static {
                b = new b();
            }

            public b() {
                super("current_live_multitab_info");
            }
        }

        public static final class c extends e<IRoom> {
            public static final c b = null;

            static {
                b = new c();
            }

            public c() {
                super("current_room");
            }
        }

        public static final class d extends e<IBaseUser> {
            public static final d b = null;

            static {
                b = new d();
            }

            public d() {
                super("current_user");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.i$e$e, reason: collision with other inner class name */
        public static abstract class AbstractC0111e<T> extends e<T> {
            public final String b;

            /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.i$e$e$a */
            public static final class a extends AbstractC0111e<JsonObject> {
                public static final a c = null;

                static {
                    c = new a();
                }

                public a() {
                    super("broadcast_game");
                }
            }

            /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.i$e$e$b */
            public static final class b extends AbstractC0111e<JsonObject> {
                public b(String r2) {
                    Intrinsics.checkNotNullParameter(r2, "key");
                    super(r2);
                }
            }

            @Override // com.bytedance.android.live.browser.jsbridge.i.e, com.bytedance.android.live.browser.jsbridge.i.f
            public final String a() {
                return this.b;
            }

            public AbstractC0111e(String r1) {
                super(r1);
                this.b = r1;
            }
        }

        public static final class f extends e<JsonObject> {
            public static final f b = null;

            static {
                b = new f();
            }

            public f() {
                super("room_message");
            }
        }

        @Override // com.bytedance.android.live.browser.jsbridge.i.f
        public String a() {
            return this.a;
        }

        public e(String r1) {
            this.a = r1;
        }
    }

    public interface f<T> {
        String a();
    }

    public static abstract class g<T> implements f<T> {
        public final String a;

        public static final class a extends g<JsonObject> {
            public static final a b = null;

            static {
                b = new a();
            }

            public a() {
                super("adlog");
            }
        }

        public static final class b extends g<JsonObject> {
            public static final /* synthetic */ int b = 0;

            static {
            }
        }

        public static final class c extends g<JsonObject> {
            public static final c b = null;

            static {
                b = new c();
            }

            public c() {
                super("dou_plus");
            }
        }

        public static final class d extends g<JsonObject> {
            public static final d b = null;

            static {
                b = new d();
            }

            public d() {
                super("game");
            }
        }

        public static final class e extends g<JsonObject> {
            public static final /* synthetic */ int b = 0;

            static {
            }
        }

        public static final class f extends g<JsonObject> {
            public static final f b = null;

            static {
                b = new f();
            }

            public f() {
                super("linkmic");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.i$g$g, reason: collision with other inner class name */
        public static final class C0112g extends g<JsonObject> {
            public static final C0112g b = null;

            static {
                b = new C0112g();
            }

            public C0112g() {
                super("log");
            }
        }

        public static final class h extends g<JsonObject> {
            public static final h b = null;

            static {
                b = new h();
            }

            public h() {
                super("prefetch");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.i$g$i, reason: collision with other inner class name */
        public static final class C0113i extends g<JsonObject> {
            public static final C0113i b = null;

            static {
                b = new C0113i();
            }

            public C0113i() {
                super("setting");
            }
        }

        public static final class j extends g<JsonObject> {
            public static final j b = null;

            static {
                b = new j();
            }

            public j() {
                super("storage");
            }
        }

        @Override // com.bytedance.android.live.browser.jsbridge.i.f
        public final String a() {
            return this.a;
        }

        public g(String r1) {
            this.a = r1;
        }
    }

    Map<String, c> a();

    <T> void b(e<T> r1, T r2);

    <T> void registerStaticState(Function1<? super DataCenter, ? extends a<? extends T>> r1);
}

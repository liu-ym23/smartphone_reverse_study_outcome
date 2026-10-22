package ox1;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.cache.LruCache;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements InnerContextEntity.FloatWindowDataSource {
    public static final LruCache<Long, Room> d = null;
    public Room a;
    public Disposable b;
    public final long c;

    public static final class a {
    }

    /* JADX INFO: renamed from: ox1.b$b, reason: collision with other inner class name */
    public static final class C0409b<T, R> implements Function {
        public static final C0409b a = null;

        static {
            a = new C0409b();
        }

        public C0409b() {
        }

        public final Object apply(Object r2) {
            Response r3 = (Response) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return (Room) ((BaseResponse) r3).data;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ b a;
        public final /* synthetic */ Function1 b;

        public c(b r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Room r6 = (Room) r5;
            b r0 = this.a;
            r0.a = r6;
            b.d.put(Long.valueOf(r0.c), r6);
            this.b.invoke(r6);
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r3) {
            ALogger.e("FetchRoomDataSource", "getRoomInfoByScene error: " + ((Throwable) r3).getMessage());
        }
    }

    static {
        d = new LruCache();
    }

    public final IRoom getRoomData() {
        return this.a;
    }

    public b(long r1) {
        this.c = r1;
    }

    public final void runAfterDataReady(LifecycleOwner r5, Function1<? super Room, Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "action");
        if (this.a != null) goto L5;
        this.a = (Room) d.get(Long.valueOf(this.c));
    L5:
        Room r0 = this.a;
        if (r0 == null) goto L9;
        r6.invoke(r0);
        return;
    L9:
        if (r5 != null) goto L11;
        return;
    L11:
        Disposable r1 = this.b;
        if (r1 == null) goto L14;
        r1.dispose();
    L14:
        com.bytedance.android.live.network.c r2 = com.bytedance.android.live.network.c.b();
        if (r2 == null) goto L29;
        RoomRetrofitApi r3 = (RoomRetrofitApi) r2.e(RoomRetrofitApi.class);
        if (r3 == null) goto L29;
        Observable r4 = r3.getRoomInfoByScene(this.c, "product_detail_preview");
        if (r4 == null) goto L29;
        Observable r7 = r4.observeOn(AndroidSchedulers.mainThread());
        if (r7 == null) goto L29;
        Observable r8 = r7.subscribeOn(Schedulers.io());
        if (r8 == null) goto L29;
        Observable r9 = r8.map(C0409b.a);
        if (r9 == null) goto L29;
        ObservableSubscribeProxy r10 = (ObservableSubscribeProxy) r9.as(AutoDispose.bind(r5));
        if (r10 == null) goto L29;
        Disposable r11 = r10.subscribe(new c(this, r6), d.a);
    L30:
        this.b = r11;
        return;
    L29:
        r11 = null;
        goto L30
    }
}

package u10;

import com.bytedance.android.live.broadcastgame.opengame.network.outer.IOpenNetworkApi;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.depend.LiveCall;
import com.bytedance.android.livesdk.config.ns;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements b {
    public final int a;
    public long b;
    public final ConcurrentHashMap<Long, LiveCall<HttpResponse>> c;
    public final AtomicLong d;
    public final ConcurrentHashMap<String, IOpenNetworkApi> e;
    public final k f;
    public final /* synthetic */ i20.a g;

    public static final class a {
    }

    static {
    }

    @Override // u10.b
    public final boolean c() {
        if (this.c.size() < this.a) goto L5;
        return true;
    L5:
        return false;
    }

    public final void f() {
        this.g.b();
        this.f.a.clear();
        Iterator<Map.Entry<Long, LiveCall<HttpResponse>>> r0 = this.c.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().getValue().cancel();
        goto L4
    L6:
        this.c.clear();
    }

    public e(k r3) {
        Intrinsics.checkNotNullParameter(r3, "retrofitProvider");
        this.g = new i20.a();
        this.f = r3;
        this.a = 10;
        this.b = 60000;
        this.c = new ConcurrentHashMap();
        this.d = new AtomicLong(1);
        this.e = new ConcurrentHashMap();
    }

    public final IOpenNetworkApi e(String r3) {
        IOpenNetworkApi r0 = this.e.get(r3);
        if (r0 != null) goto L6;
        IOpenNetworkApi r1 = (IOpenNetworkApi) this.f.getRetrofitInstance(r3).create(IOpenNetworkApi.class);
        this.e.put(r3, r1);
        return r1;
    L6:
        return r0;
    }

    public final void g(long r6) {
        if (1 <= r6) goto L6;
    L8:
        this.b = 60000;
        return;
    L6:
        if (60000 < r6) goto L8;
        this.b = r6;
    }

    public final void d(Call<?> r6, long r7, Function3<? super Integer, ? super JSONObject, ? super String, Unit> r9, Function1<? super Throwable, Unit> r11, boolean r12) {
        c r0 = new c(r6);
        long r1 = this.d.getAndIncrement();
        this.c.put(Long.valueOf(r1), r0);
        if (r7 <= 60000) goto L6;
        r7 = 60000;
    L8:
        if (r12 == false) goto L10;
        Observable r8 = Observable.never();
    L11:
        Disposable r13 = Observable.create(new f(r0)).delaySubscription(r8).timeout(r7, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this, r9, r1), new h(this, r11, r1));
        Intrinsics.checkNotNullParameter(r13, "$this$autoDispose");
        this.g.a(r13);
        return;
    L10:
        r8 = Observable.empty();
        goto L11
    L6:
        if (r7 > 0) goto L8;
        r7 = this.b;
        goto L8
    }

    @Override // u10.b
    public final void b(String r15, String r16, String r17, Map<String, String> r18, Map<String, String> r19, long r21, Function3<? super Integer, ? super JSONObject, ? super String, Unit> r22, Function1<? super Throwable, Unit> r23, boolean r24) {
        Intrinsics.checkNotNullParameter(r15, "domain");
        Intrinsics.checkNotNullParameter(r16, "method");
        Intrinsics.checkNotNullParameter(r17, "relativeUrl");
        Intrinsics.checkNotNullParameter(r18, "headerMap");
        Intrinsics.checkNotNullParameter(r19, "queryMap");
        Intrinsics.checkNotNullParameter(r22, "onSuccess");
        Intrinsics.checkNotNullParameter(r23, "onError");
        if (((Boolean) ns.a.getValue()).booleanValue() == true) goto L28;
        return;
    L28:
    L25:
        th = move-exception;
        r23.invoke(th);
        ALogger.e("OpenNetworkExecutor", "doRequestWithQueryMap", th);
        return;
    L6:
        switch(r16.hashCode()) {
            case -531492226: goto L18;
            case 70454: goto L15;
            case 2213344: goto L12;
            case 2012838315: goto L9;
            default: goto L21;
        };     // Catch: Throwable -> L25
    L21:
        r23.invoke(new Throwable("http method error."));     // Catch: Throwable -> L25
        Call<TypedInput> r0 = null;
    L20:
        Call<TypedInput> r1 = r0;
        if (r1 == null) goto L30;
        d(r1, r21, r22, r23, r24);     // Catch: Throwable -> L25
        return;
    L30:
        return;
    L9:
        if (r16.equals("DELETE") == false) goto L21;
        r0 = e(r15).doDelete(false, Integer.MAX_VALUE, r17, r18, r19);     // Catch: Throwable -> L25
        goto L20
    L12:
        if (r16.equals("HEAD") == false) goto L21;
        r0 = e(r15).doHead(false, Integer.MAX_VALUE, r17, r18, r19);     // Catch: Throwable -> L25
        goto L20
    L15:
        if (r16.equals("GET") == false) goto L21;
        r0 = e(r15).doGet(false, Integer.MAX_VALUE, r17, r18, r19);     // Catch: Throwable -> L25
        goto L20
    L18:
        if (r16.equals("OPTIONS") == false) goto L21;
        r0 = e(r15).doOptions(false, Integer.MAX_VALUE, r17, r18, r19);     // Catch: Throwable -> L25
        goto L20
    }

    @Override // u10.b
    public final void a(String r16, String r17, String r18, Map<String, String> r19, byte[] r21, String r22, long r23, Function3<? super Integer, ? super JSONObject, ? super String, Unit> r24, Function1<? super Throwable, Unit> r25, boolean r26) {
        Intrinsics.checkNotNullParameter(r16, "domain");
        Intrinsics.checkNotNullParameter(r17, "method");
        Intrinsics.checkNotNullParameter(r18, "relativeUrl");
        Intrinsics.checkNotNullParameter(r19, "headerMap");
        Intrinsics.checkNotNullParameter(r22, "mimeType");
        Intrinsics.checkNotNullParameter(r24, "onSuccess");
        Intrinsics.checkNotNullParameter(r25, "onError");
        if (((Boolean) ns.a.getValue()).booleanValue() == true) goto L24;
        return;
    L24:
        int r3 = r17.hashCode();     // Catch: Throwable -> L21
        if (r3 == 79599) goto L14;
        if (r3 == 2461856) goto L11;
    L16:
        r25.invoke(new Throwable("http method error."));     // Catch: Throwable -> L21
        Call<TypedInput> r0 = null;
    L17:
        Call<TypedInput> r1 = r0;
        if (r1 == null) goto L26;
        d(r1, r23, r24, r25, r26);     // Catch: Throwable -> L21
        return;
    L26:
        return;
    L11:
        if (r17.equals("POST") == false) goto L16;
        r0 = e(r16).doPost(false, Integer.MAX_VALUE, r18, r19, new TypedByteArray(r22, r21, new String[0]));     // Catch: Throwable -> L21
        goto L17
    L14:
        if (r17.equals("PUT") == false) goto L16;
        r0 = e(r16).doPut(false, Integer.MAX_VALUE, r18, r19, new TypedByteArray(r22, r21, new String[0]));     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        r25.invoke(th);
        ALogger.e("OpenNetworkExecutor", "doRequestWithBody", th);
    }
}

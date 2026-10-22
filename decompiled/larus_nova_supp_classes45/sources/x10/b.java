package x10;

import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Consumer;
import java.io.IOException;
import java.net.SocketTimeoutException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class b<T> implements ObservableTransformer<T, T> {
    public final PluginContext a;
    public final String b;
    public final String c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final void accept(T r4) {
            b.b(this.a, 0, null, 6);
        }
    }

    /* JADX INFO: renamed from: x10.b$b, reason: collision with other inner class name */
    public static final class C0292b<T> implements Consumer {
        public final /* synthetic */ b a;

        public C0292b(b r1) {
            this.a = r1;
        }

        public final void accept(Object r15) {
            Throwable r16 = (Throwable) r15;
            boolean r2 = false;
            String r3 = "";
            if ((r16 instanceof CustomApiServerException) == false) goto L9;
            JSONObject r4 = new JSONObject(((CustomApiServerException) r16).getExtra());     // Catch: Exception -> L7
            this.a.a(100000, String.valueOf(r4.optInt("errcode", 0)), r4.optString("request_url", ""));     // Catch: Exception -> L7
            return;
        L7:
            b.b(this.a, 100000, "custom api error", 4);
            return;
        L9:
            if ((r16 instanceof NetworkErrorException) == false) goto L30;
            this.a.getClass();     // Catch: Exception -> L22
            String r0 = ((NetworkErrorException) r16).getMessage();     // Catch: Exception -> L22
            if (r0 == null) goto L23;
            int r5 = r0.length();     // Catch: Exception -> L22
            int r6 = StringsKt.indexOf$default(r0, "net::", 0, false, 6, null);     // Catch: Exception -> L22
            if (r6 == (-1)) goto L23;
            int r7 = r6 + 5;     // Catch: Exception -> L22
            if (r7 >= r5) goto L23;
            int r8 = StringsKt.indexOf$default(r0, ",", r7, false, 4, null);     // Catch: Exception -> L22
            if (r8 == (-1)) goto L23;
            if (r7 > r8) goto L23;
            if (r8 >= r5) goto L23;
            r3 = r0.substring(r7, r8);     // Catch: Exception -> L22
        L23:
            b r1 = this.a;
            if (r3.length() != 0) goto L26;
            r2 = true;
        L26:
            if (r2 == false) goto L28;
            r3 = r16.getMessage();
        L28:
            b.b(r1, 100001, r3, 4);
            return;
        L30:
            if ((r16 instanceof SocketTimeoutException) == false) goto L32;
        L35:
            b.b(this.a, 100002, r16.getClass().getName(), 4);
            return;
        L32:
            if ((r16 instanceof IOException) == true) goto L35;
            b.b(this.a, 99999, r16.getClass().getName(), 4);
        }
    }

    public final String getType() {
        return this.c;
    }

    public final ObservableSource<T> apply(Observable<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "upstream");
        return r2.doOnNext(new a(this)).doOnError(new C0292b(this));
    }

    public b(PluginContext r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "path");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public final void a(int r3, String r4, String r5) {
        if (r5 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        String r6 = UriProtector.parse(r5).getPath();
    L11:
        String r1 = this.c;
        int r2 = e.a;
        e.a(this.a, r3, r4, r6, r1);
        return;
    L10:
        r6 = this.b;
        goto L11
    L4:
        if (r5.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static /* synthetic */ void b(b r0, int r1, String r2, int r3) {
        if ((r3 & 2) == 0) goto L5;
        r2 = "";
    L5:
        r0.a(r1, r2, null);
    }
}

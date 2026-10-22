package w78;

import android.os.Handler;
import androidx.lifecycle.Observer;
import com.larus.network.http.HttpLiveData;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class j<T> {
    public final List<String> a;
    public final long b;
    public final HttpLiveData<T> c;
    public long d;
    public final i e;

    public static final class a implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public a(g r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public final void b() {
        FLogger.a.i("UserDynamic", "scheduleCheck " + CollectionsKt.joinToString$default(this.a, null, null, null, 0, null, new h(), 31, null) + ' ' + this.b);
        Handler r0 = t0.a;
        r0.removeCallbacks(this.e);
        r0.postDelayed(this.e, this.b);
    }

    public final void a(boolean r8) {
        if (r8 == false) goto L4;
    L7:
        JSONObject r3 = new JSONObject();
        JSONArray r9 = new JSONArray();
        Iterator<T> r0 = this.a.iterator();
    L9:
        if (r0.hasNext() == false) goto L11;
        r9.put((String) r0.next());
        goto L9
    L11:
        Unit r1 = Unit.INSTANCE;
        r3.put("key_list", r9);
        HttpLiveData.c(this.c, "Infra", "/alice/user/dynamic", r3, false, null, 248);
        return;
    L4:
        if (this.d < 0) goto L7;
        if ((System.currentTimeMillis() - this.d) >= this.b) goto L7;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [w78.g] */
    public j(Class r3, List r4) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        Intrinsics.checkNotNullParameter(r4, "keyList");
        this.a = r4;
        this.b = 21600000;
        HttpLiveData<T> r5 = new HttpLiveData(r3);
        this.c = r5;
        this.d = -1;
        this.e = new i(this);
        r5.c.observeForever(new a(new g(this)));
    }
}

package j8b;

import com.ss.android.lark.http.model.http.HttpHeaders;
import com.ss.android.lark.http.model.http.HttpMethod;
import com.ss.android.lark.http.model.http.HttpParams;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b<T, R> implements Function {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public b(String r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r14) {
        i r15 = (i) r14;
        Intrinsics.checkNotNullParameter(r15, "it");
        i.a r16 = r15.a();
        if (r16 != null) goto L5;
    L7:
        boolean r17 = false;
    L8:
        if (r17 == false) goto L10;
        Single r18 = Single.just(new j());
        Intrinsics.checkNotNull(r18);
        return r18;
    L10:
        CompositeDisposable r19 = d.a;
        String r110 = this.a;
        String r2 = this.b;
        Intrinsics.checkNotNullParameter(r110, "token");
        Intrinsics.checkNotNullParameter(r2, "entityType");
        HttpMethod r5 = HttpMethod.GET;
        HttpParams r9 = new HttpParams();
        HttpHeaders r10 = new HttpHeaders();
        LinkedHashMap r6 = new LinkedHashMap();
        HttpMethod r8 = HttpMethod.POST;
        Intrinsics.checkNotNullParameter(r8, "method");
        Intrinsics.checkNotNullParameter("/lark/scs/compliance/intercept/ccm/result/", "path");
        Map r111 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("isPreEvaluate", Boolean.TRUE), TuplesKt.to("token", r110), TuplesKt.to("entityType", r2), TuplesKt.to("entityOperateList", a.a)});
        Intrinsics.checkNotNullParameter(r111, "body");
        r6.putAll(r111);
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        com.ss.android.lark.security.compliance.infra.network.a r112 = new com.ss.android.lark.security.compliance.infra.network.a("/lark/scs/compliance/intercept/ccm/result/", r8, r9, r10, new JSONObject(r6), true);
        r112.c(BuildConfig.FLAVOR);
        int r0 = com.ss.android.lark.security.compliance.infra.network.service.a.a;
        return Observable.create(new e(r112)).singleOrError().retry(1).map(f.a);
    L5:
        if (r16.a() == true) goto L7;
        r17 = true;
        goto L8
    }
}

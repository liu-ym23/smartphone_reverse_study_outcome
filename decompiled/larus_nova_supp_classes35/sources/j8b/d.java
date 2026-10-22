package j8b;

import com.bytedance.lark.policy.model.ResponseType;
import com.bytedance.lark.policy.model.b0;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.http.model.http.HttpHeaders;
import com.ss.android.lark.http.model.http.HttpMethod;
import com.ss.android.lark.http.model.http.HttpParams;
import com.ss.android.lark.security.compliance.api.model.filepolicy.CCMFileEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public static final CompositeDisposable a = null;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ List<PolicyModel> a;
        public final /* synthetic */ Function1<Map<String, b0>, Unit> b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<PolicyModel> r1, Function1<? super Map<String, b0>, Unit> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r28) {
            j r1 = (j) r28;
            if (r1 != null) goto L5;
            CompositeDisposable r2 = d.a;
            d.b(this.a, this.b);
            return;
        L5:
            CompositeDisposable r3 = d.a;
            List<PolicyModel> r4 = this.a;
            HashMap r5 = new HashMap();
            if (r1.getType() != ResponseType.FAST_PASS) goto L11;
            Iterator<T> r6 = r4.iterator();
        L9:
            if (r6.hasNext() == false) goto L83;
            r5.put(((PolicyModel) r6.next()).getTaskId(), new b0("PERMIT", "dlp_uuid", CollectionsKt.emptyList(), true, ResponseType.FAST_PASS, null, null, 96));
        L83:
            this.b.invoke(r5);
            return;
        L11:
            HashMap r7 = new HashMap();
            Iterator<T> r8 = r4.iterator();
        L13:
            if (r8.hasNext() == false) goto L15;
            PolicyModel r9 = (PolicyModel) r8.next();
            r7.put(r9.getEntity().getEntityOperate(), r9.getTaskId());
            b0 r10 = new b0("PERMIT", "dlp_uuid", CollectionsKt.emptyList(), true, ResponseType.DOWNGRADE, null, null, 96);
            r5.put(r9.getTaskId(), r10);
            goto L13
        L15:
            Iterator<Map.Entry<String, j.b>> r11 = r1.a().entrySet().iterator();
        L17:
            if (r11.hasNext() == false) goto L83;
            Map.Entry<String, j.b> r12 = r11.next();
            String r13 = (String) r7.get(r12.getKey());
            if (r13 == null) goto L17;
            j.b r14 = r12.getValue();
            if (r14 == null) goto L17;
            if (r14.e() == true) goto L26;
            ArrayList r15 = new ArrayList();
            if (idb.f.a().isEnable("admin.security.dlp.banner") == false) goto L57;
            List<m8b.b.a> r16 = r14.f();
            ArrayList r17 = new ArrayList();
            Iterator<T> r18 = r16.iterator();
        L34:
            if (r18.hasNext() == false) goto L56;
            m8b.b.a r19 = (m8b.b.a) r18.next();
            Intrinsics.checkNotNullParameter(r19, "fixedAction");
            String r110 = r19.a();
            if (r110 != null) goto L38;
        L41:
            boolean r111 = true;
        L42:
            if (r111 == false) goto L44;
            Iterator<Map.Entry<String, j.b>> r112 = r11;
            com.bytedance.lark.policy.model.a r20 = null;
        L53:
            if (r20 == null) goto L55;
            r17.add(r20);
        L55:
            r11 = r112;
            goto L34
        L44:
            HashMap r113 = new HashMap();
            HashMap<String, Object> r114 = r19.b();
            if (r114 == null) goto L52;
            Iterator<Map.Entry<String, Object>> r115 = r114.entrySet().iterator();
        L48:
            if (r115.hasNext() == false) goto L52;
            Map.Entry<String, Object> r116 = r115.next();
            if (r116.getValue() == null) goto L48;
            Iterator<Map.Entry<String, j.b>> r117 = r11;
            r113.put(r116.getKey(), String.valueOf(r116.getValue()));
            r11 = r117;
        L52:
            r112 = r11;
            r20 = new com.bytedance.lark.policy.model.a(r19.a(), r113);
            goto L53
        L38:
            if (r110.length() == 0) goto L41;
            r111 = false;
            goto L42
        L56:
            Iterator<Map.Entry<String, j.b>> r118 = r11;
            r15.addAll(r17);
        L64:
            String r119 = null;
        L66:
            if (r14.a() == null) goto L77;
            List<j.a> r21 = r14.a();
            ArrayList r120 = new ArrayList();
            Iterator<T> r22 = r21.iterator();
        L69:
            if (r22.hasNext() == false) goto L76;
            j.a r121 = (j.a) r22.next();
            if (r121.b() == false) goto L73;
            String r122 = r121.a();
        L74:
            if (r122 == null) goto L69;
            r120.add(r122);
            goto L69
        L73:
            r122 = r119;
            goto L74
        L76:
            List r26 = r120;
        L79:
            if (r14.d() == false) goto L81;
            String r23 = "PERMIT";
        L82:
            r5.put(r13, new b0(r23, r14.c(), r15, r14.d(), r1.getType(), null, r26));
            r11 = r118;
            goto L17
        L81:
            r23 = "DENY";
            goto L82
        L77:
            r26 = CollectionsKt.emptyList();
            goto L79
        L57:
            r118 = r11;
            if (r14.b() == null) goto L64;
            if (Intrinsics.areEqual(r14.b(), "FILE_BLOCK_COMMON") == false) goto L62;
            String r24 = "TT_BLOCK";
        L63:
            r119 = null;
            r15.add(new com.bytedance.lark.policy.model.a(r24, null));
            goto L66
        L62:
            r24 = r14.b();
            goto L63
        L26:
            if (r14.d() == false) goto L28;
            String r123 = "PERMIT";
        L29:
            r5.put(r13, new b0(r123, "dlp_uuid", CollectionsKt.emptyList(), r14.d(), ResponseType.DOWNGRADE, null, null, 96));
            goto L17
        L28:
            r123 = "DENY";
            goto L29
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ List<PolicyModel> a;
        public final /* synthetic */ Function1<Map<String, b0>, Unit> b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(List<PolicyModel> r1, Function1<? super Map<String, b0>, Unit> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            CompositeDisposable r4 = d.a;
            d.b(this.a, this.b);
        }
    }

    static {
        a = new CompositeDisposable();
    }

    public static void a(List r22, Function1 r23) {
        Intrinsics.checkNotNullParameter(r22, "policyModels");
        Intrinsics.checkNotNullParameter(r23, "callback");
        if (idb.f.a().isCurrentEnable("ccm.doc.dlp_enable") == true) goto L10;
        ScsLogger.d("SecurityPolicy_DLPEngine", "getDLPResult(), DLP is not enable");
        HashMap r2 = new HashMap();
        Iterator r0 = r22.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        r2.put(((PolicyModel) r0.next()).getTaskId(), new b0("PERMIT", "dlp_uuid", CollectionsKt.emptyList(), true, ResponseType.FAST_PASS, null, null, 96));
        goto L6
    L8:
        r23.invoke(r2);
        return;
    L10:
        Iterator r3 = r22.iterator();
    L11:
        Object r7 = null;
        CCMFileEntity r8 = null;
        if (r3.hasNext() == false) goto L23;
        Object r4 = r3.next();
        CCMFileEntity r9 = ((PolicyModel) r4).getEntity();
        if ((r9 instanceof CCMFileEntity) == false) goto L16;
        r8 = r9;
    L16:
        if (r8 != null) goto L18;
    L20:
        boolean r10 = false;
    L21:
        if (r10 == false) goto L11;
        r7 = r4;
        goto L23
    L18:
        if (r8.getTokenEntityType() == null) goto L20;
        r10 = true;
    L23:
        PolicyModel r11 = (PolicyModel) r7;
        if (r11 != null) goto L26;
        r11 = (PolicyModel) CollectionsKt.firstOrNull(r22);
    L26:
        if (r11 != null) goto L28;
    L54:
        ScsLogger.d("SecurityPolicy_DLPEngine", "getDLPResult(), but policyModel is null or entity is not CCMFileEntity");
        FileAuthMonitor.UpdateTrigger[] r1 = FileAuthMonitor.a;
        FileAuthMonitor.i("policyModel invalid");
        b(r22, r23);
        return;
    L28:
        if ((r11.getEntity() instanceof CCMFileEntity) == false) goto L54;
        CCMFileEntity r5 = r11.getEntity();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.security.compliance.api.model.filepolicy.CCMFileEntity");
        CCMFileEntity r6 = r5;
        String r12 = r6.getToken();
        String r13 = r6.getTokenEntityType();
        if (r13 != null) goto L33;
        r13 = r6.getEntityType();
    L33:
        Long r14 = r6.getOwnerUserId();
        Long r15 = r6.getOwnerTenantId();
        if (r12 != null) goto L36;
    L39:
        boolean r16 = true;
    L40:
        if (r16 == false) goto L43;
        ScsLogger.d("SecurityPolicy_DLPEngine", "getDLPResult(), but token is null or empty");
        FileAuthMonitor.UpdateTrigger[] r17 = FileAuthMonitor.a;
        FileAuthMonitor.i("token empty");
        b(r22, r23);
        return;
    L43:
        String r18 = StringsKt.takeLast(r12, RangesKt.coerceAtMost(5, r12.length()));
        int r19 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_DLPEngine", "getDLPResult(), token is " + r18);
        Intrinsics.checkNotNullParameter(r12, "token");
        Intrinsics.checkNotNullParameter(r13, "entityType");
        HttpMethod r110 = HttpMethod.GET;
        HttpParams r111 = new HttpParams();
        HttpHeaders r112 = new HttpHeaders();
        LinkedHashMap r113 = new LinkedHashMap();
        HttpMethod r114 = HttpMethod.GET;
        Intrinsics.checkNotNullParameter(r114, "method");
        Intrinsics.checkNotNullParameter("/lark/scs/compliance/intercept/ccm/policystatus/", "path");
        Map r20 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("policyType", "DLP"), TuplesKt.to("token", r12), TuplesKt.to("entityType", r13)});
        if (r14 != null) goto L46;
    L48:
        if (r15 != null) goto L50;
    L52:
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        com.ss.android.lark.security.compliance.infra.network.a r21 = new com.ss.android.lark.security.compliance.infra.network.a("/lark/scs/compliance/intercept/ccm/policystatus/", r114, r111, r112, new JSONObject(r113), true);
        r21.c(BuildConfig.FLAVOR);
        r111.put(r20, new boolean[0]);
        int r24 = com.ss.android.lark.security.compliance.infra.network.service.a.a;
        a.add(t4c.a.a(Observable.create(new g(r21)).singleOrError().map(h.a).timeout(2000, TimeUnit.MILLISECONDS, Single.just(new i())).onErrorReturnItem(new i()).flatMap(new j8b.b(r12, r13)).doOnError(c.a)).subscribe(new a(r22, r23), new b(r22, r23)));
        return;
    L50:
        if (r15.longValue() < 0) goto L52;
        r20.put("tenant_id", r15.toString());
        goto L52
    L46:
        if (r14.longValue() < 0) goto L48;
        r20.put("owner_uid", r14.toString());
        goto L48
    L36:
        if (r12.length() == 0) goto L39;
        r16 = false;
        goto L40
    }

    public static void b(List r12, Function1 r13) {
        HashMap r0 = new HashMap();
        Iterator r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        PolicyModel r1 = (PolicyModel) r14.next();
        b0 r11 = new b0("PERMIT", "dlp_uuid", CollectionsKt.emptyList(), true, ResponseType.DOWNGRADE, null, null, 96);
        r0.put(r1.getTaskId(), r11);
        goto L4
    L6:
        r13.invoke(r0);
    }
}

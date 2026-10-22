package vf;

import com.bytedance.android.ec.common.impl.entranceinfo.config.EntranceInfoWriteAction;
import com.bytedance.android.ec.core.data.ParamsForceRule;
import com.bytedance.android.ec.core.data.ParamsWriteConfig;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.sdk.ECSdk;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: vf.a$a, reason: collision with other inner class name */
    public static final class CallableC0208a<V> implements Callable {
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ EntranceInfoScene b;
        public final /* synthetic */ Set c;
        public final /* synthetic */ Set d;

        public CallableC0208a(JSONObject r1, EntranceInfoScene r10, Set r11, Set r12) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            int r0 = a.a;     // Catch: Throwable -> L4
            a.a(this.a, this.b, this.c, this.d);     // Catch: Throwable -> L4
            return;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public static final class b<V> implements Callable {
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ EntranceInfoScene b;
        public final /* synthetic */ Set c;
        public final /* synthetic */ Set d;

        public b(JSONObject r1, EntranceInfoScene r10, Set r11, Set r12) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            int r0 = a.a;     // Catch: Throwable -> L4
            a.a(this.a, this.b, this.c, this.d);     // Catch: Throwable -> L4
            return;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public a() {
    }

    static {
    }

    public static boolean b(EntranceInfoScene r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "scene");
        Intrinsics.checkNotNullParameter(r11, "key");
        HashMap<String, Map<String, ParamsWriteConfig>> r0 = wf.a.c().getRuleList();
        if (r0 == null) goto L21;
        Map<String, ParamsWriteConfig> r13 = r0.get(r10.a());
        if (r13 == null) goto L21;
        ParamsWriteConfig r14 = r13.get(r11);
        if (r14 == null) goto L21;
        Integer r15 = r14.getAction();
        if (r15 != null) goto L12;
    L13:
        Integer r16 = r14.getAction();
        int r17 = EntranceInfoWriteAction.CHANGE.getValue();
        if (r16 != null) goto L17;
    L19:
        return false;
    L17:
        if (r16.intValue() != r17) goto L19;
        return true;
    L12:
        if (r15.intValue() != r12) goto L13;
        return true;
    L21:
        Set<String> r18 = wf.a.c().getCheckKeysList();
        if (r18 != null) goto L24;
        return true;
    L24:
        if (r18.contains(r11) != true) goto L31;
        return false;
    L31:
        return true;
    }

    public static final void a(JSONObject r10, EntranceInfoScene r11, Set r12, Set r13) {
        HashMap<String, Map<String, ParamsWriteConfig>> r0 = wf.a.c().getRuleList();
        if (r0 == null) goto L31;
        Map<String, ParamsWriteConfig> r1 = r0.get(r11.a());
        if (r1 == null) goto L51;
        LinkedHashMap r14 = new LinkedHashMap();
        Iterator<Map.Entry<String, ParamsWriteConfig>> r15 = r1.entrySet().iterator();
    L8:
        if (r15.hasNext() == false) goto L12;
        Map.Entry<String, ParamsWriteConfig> r16 = r15.next();
        if (Intrinsics.areEqual(r16.getValue().getOptional(), Boolean.FALSE) == false) goto L8;
        r14.put(r16.getKey(), r16.getValue());
        goto L8
    L12:
        Iterator r17 = r14.entrySet().iterator();
    L14:
        if (r17.hasNext() == false) goto L52;
        Map.Entry r18 = (Map.Entry) r17.next();
        Integer r19 = ((ParamsWriteConfig) r18.getValue()).getAction();
        int r20 = EntranceInfoWriteAction.PUT.getValue();
        if (r19 == null) goto L23;
        if (r19.intValue() != r20) goto L23;
        if (r12.contains(r18.getKey()) == true) goto L23;
        e(r11, r10, "lost_required_action_put", (String) r18.getKey(), null);
    L23:
        Integer r21 = ((ParamsWriteConfig) r18.getValue()).getAction();
        int r22 = EntranceInfoWriteAction.REMOVE.getValue();
        if (r21 == null) goto L14;
        if (r21.intValue() != r22) goto L14;
        if (r13.contains(r18.getKey()) == true) goto L14;
        e(r11, r10, "lost_required_action_remove", (String) r18.getKey(), null);
        goto L14
    L52:
        return;
    L51:
        return;
    }

    public static String c(JSONObject r10, EntranceInfoScene r11, Set r12, Set r13) {
        Intrinsics.checkNotNullParameter(r10, "entranceInfo");
        Intrinsics.checkNotNullParameter(r11, "scene");
        Intrinsics.checkNotNullParameter(r12, "putSet");
        Intrinsics.checkNotNullParameter(r13, "removeSet");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L36
        int r14 = com.bytedance.android.ec.common.impl.entranceinfo.a.a;     // Catch: Throwable -> L36
        Intrinsics.checkNotNullParameter(r10, "entranceInfo");     // Catch: Throwable -> L36
        if (wf.a.a() == false) goto L35;
        ParamsForceRule r0 = wf.a.c().getForceRuleList();     // Catch: Throwable -> L36
        if (r0 == null) goto L20;
        List<String> r15 = r0.getRemoveIfEmpty();     // Catch: Throwable -> L36
        if (r15 == null) goto L20;
        Iterator<T> r16 = r15.iterator();     // Catch: Throwable -> L36
    L11:
        if (r16.hasNext() == false) goto L20;
        String r17 = (String) r16.next();     // Catch: Throwable -> L36
        if (r10.has(r17) == false) goto L11;
        if (r10.optString(r17).length() != 0) goto L17;
        boolean r18 = true;
    L18:
        if (r18 == false) goto L11;
        r10.remove(r17);     // Catch: Throwable -> L36
        e(r11, r10, "force_remove_if_empty", r17, null);     // Catch: Throwable -> L36
        goto L11
    L17:
        r18 = false;
    L20:
        ParamsForceRule r19 = wf.a.c().getForceRuleList();     // Catch: Throwable -> L36
        if (r19 == null) goto L32;
        List<String> r20 = r19.getForceString();     // Catch: Throwable -> L36
        if (r20 == null) goto L32;
        Iterator<T> r21 = r20.iterator();     // Catch: Throwable -> L36
    L26:
        if (r21.hasNext() == false) goto L32;
        String r22 = (String) r21.next();     // Catch: Throwable -> L36
        if (r10.has(r22) == false) goto L26;
        if ((r10.get(r22) instanceof String) == true) goto L26;
        e(r11, r10, "force_string", r22, null);     // Catch: Throwable -> L36
    L32:
        Single.fromCallable(new CallableC0208a(r10, r11, r12, r13)).subscribeOn(Schedulers.io()).subscribe();     // Catch: Throwable -> L36
        return r10.toString();
    L35:
        return r10.toString();
    L36:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return "";
    }

    public static JSONObject d(JSONObject r10, EntranceInfoScene r11, Set r12, Set r13) {
        Intrinsics.checkNotNullParameter(r10, "entranceInfo");
        Intrinsics.checkNotNullParameter(r11, "scene");
        Intrinsics.checkNotNullParameter(r12, "putSet");
        Intrinsics.checkNotNullParameter(r13, "removeSet");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L34
        int r14 = com.bytedance.android.ec.common.impl.entranceinfo.a.a;     // Catch: Throwable -> L34
        Intrinsics.checkNotNullParameter(r10, "entranceInfo");     // Catch: Throwable -> L34
        if (wf.a.a() == false) goto L33;
        ParamsForceRule r0 = wf.a.c().getForceRuleList();     // Catch: Throwable -> L34
        if (r0 == null) goto L20;
        List<String> r15 = r0.getRemoveIfEmpty();     // Catch: Throwable -> L34
        if (r15 == null) goto L20;
        Iterator<T> r16 = r15.iterator();     // Catch: Throwable -> L34
    L11:
        if (r16.hasNext() == false) goto L20;
        String r17 = (String) r16.next();     // Catch: Throwable -> L34
        if (r10.has(r17) == false) goto L11;
        if (r10.optString(r17).length() != 0) goto L17;
        boolean r18 = true;
    L18:
        if (r18 == false) goto L11;
        r10.remove(r17);     // Catch: Throwable -> L34
        e(r11, r10, "force_remove_if_empty", r17, null);     // Catch: Throwable -> L34
        goto L11
    L17:
        r18 = false;
    L20:
        ParamsForceRule r19 = wf.a.c().getForceRuleList();     // Catch: Throwable -> L34
        if (r19 == null) goto L32;
        List<String> r20 = r19.getForceString();     // Catch: Throwable -> L34
        if (r20 == null) goto L32;
        Iterator<T> r21 = r20.iterator();     // Catch: Throwable -> L34
    L26:
        if (r21.hasNext() == false) goto L32;
        String r22 = (String) r21.next();     // Catch: Throwable -> L34
        if (r10.has(r22) == false) goto L26;
        if ((r10.get(r22) instanceof String) == true) goto L26;
        e(r11, r10, "force_string", r22, null);     // Catch: Throwable -> L34
    L32:
        Single.fromCallable(new b(r10, r11, r12, r13)).subscribeOn(Schedulers.io()).subscribe();     // Catch: Throwable -> L34
    L33:
        return r10;
    L34:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return new JSONObject();
    }

    public static void e(EntranceInfoScene r10, JSONObject r11, String r12, String r13, Object r14) {
        Intrinsics.checkNotNullParameter(r10, "entranceInfoScene");
        Intrinsics.checkNotNullParameter(r11, "entranceInfo");
        Intrinsics.checkNotNullParameter(r12, "errorType");
        Intrinsics.checkNotNullParameter(r13, "key");
        int r1 = ECSdk.a;
        pi.b r15 = (pi.b) ECSdk.a(pi.b.class);
        if (r15 == null) goto L6;
        JSONObject r16 = new JSONObject();
        r16.put("scene", r10.a());
        r16.put(com.bytedance.android.ec.core.event.a.KEY_ERROR_TYPE, r12);
        r16.put("key", r13);
        r16.put(com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, r14);
        Unit r17 = Unit.INSTANCE;
        JSONObject r18 = new JSONObject();
        r18.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r11);
        r15.monitorEvent("ec_entrance_info_check_result", r16, null, r18);
        return;
    }
}

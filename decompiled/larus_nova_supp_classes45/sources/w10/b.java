package w10;

import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.network.OpenGameApi;
import com.bytedance.android.live.broadcastgame.opengame.network.k0;
import com.bytedance.android.live.broadcastgame.opengame.network.s;
import com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import x10.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends BaseOpenMethod<JSONObject> {
    public final String h;
    public final long i;

    public static final class a {
    }

    /* JADX INFO: renamed from: w10.b$b, reason: collision with other inner class name */
    public static final class C0289b<T> implements Consumer {
        public final /* synthetic */ b a;

        public C0289b(b r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void accept(Object r7) {
            ExtraResponse r8 = (ExtraResponse) r7;
            JSONObject r0 = new JSONObject();
            Object r1 = ((s) r8.data).openId;
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            r0.put("openId", r1);
            b r2 = this.a;
            Map<Long, k0> r9 = ((s) r8.data).propInfoMap;
            r2.getClass();
            JSONArray r3 = new JSONArray();
            if (r9 == null) goto L13;
            Set<Map.Entry<Long, k0>> r11 = r9.entrySet();
            if (r11 == null) goto L13;
            Iterator<T> r12 = r11.iterator();
        L11:
            if (r12.hasNext() == false) goto L13;
            Map.Entry r4 = (Map.Entry) r12.next();
            JSONObject r5 = new JSONObject();
            r5.put("propId", String.valueOf(((k0) r4.getValue()).id));
            r5.put("num", ((k0) r4.getValue()).num);
            r3.put(r5);
        L13:
            r0.put("data", r3);
            int r13 = q.a;
            q.f("GetUserPropInfoMethod", new Object[]{"on request success, data: " + r0});
            b r14 = this.a;
            JSONObject r6 = new JSONObject();
            r6.put("propInfo", r0);
            Unit r15 = Unit.INSTANCE;
            r14.r(r6);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            int r0 = q.a;
            q.e("GetUserPropInfoMethod", new Object[]{"on request fail, error: " + r5});
            this.a.o(r5);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "getUserPropInfo";
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r11, CallContext r12) {
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "context");
        int r13 = q.a;
        q.f("GetUserPropInfoMethod", new Object[]{"on call, params: " + r11});
        String r3 = "[]";
        String r14 = r11.optString("propIds", "[]");
        JSONArray r4 = new JSONArray(r14);     // Catch: JSONException -> L15
        JSONArray r5 = new JSONArray();     // Catch: JSONException -> L15
        int r6 = r4.length();     // Catch: JSONException -> L15
        int r7 = 0;
    L4:
        if (r7 >= r6) goto L13;
        Object r8 = r4.get(r7);     // Catch: JSONException -> L15
        if ((r8 instanceof String) == true) goto L20;
        r8 = null;
    L20:
        long r9 = CastLongProtector.parseLong((String) r8);     // Catch: Throwable -> L11
    L12:
        r5.put(r9);     // Catch: JSONException -> L15
        r7 = r7 + 1;     // Catch: JSONException -> L15
    L11:
        r9 = 0;
        goto L12
    L13:
        r3 = r5.toString();     // Catch: JSONException -> L15
    L16:
        Lazy r15 = LiveOpenGameClient.d;
        j(((OpenGameApi) LiveOpenGameClient.a.a().a(OpenGameApi.class)).getUserPropInfo(this.h, this.i, r3).compose(new d(this.d, "/webcast/openapi/game_prop/player/query/", null)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0289b(this), new c(this)));
        return;
    L15:
        int r16 = q.a;
        q.k("GetUserPropInfoMethod", new Object[]{"format json error, propIds=" + r14});
        goto L16
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r1, CallContext r2) {
        call2(r1, r2);
    }

    public b(PluginContext r2, String r3, long r4, Queue<Long> r6) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "appId");
        super(r2, r6);
        this.h = r3;
        this.i = r4;
    }
}

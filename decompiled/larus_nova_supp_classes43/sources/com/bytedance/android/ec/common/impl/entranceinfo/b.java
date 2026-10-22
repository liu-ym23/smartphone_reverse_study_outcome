package com.bytedance.android.ec.common.impl.entranceinfo;

import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.bytedance.android.ec.common.impl.entranceinfo.config.EntranceInfoWriteAction;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements gl.a {
    public static final /* synthetic */ int h = 0;
    public JSONObject a;
    public EntranceInfoScene b;
    public boolean c;
    public final Set<String> d;
    public final Set<String> e;
    public final Set<String> f;
    public Function1<? super b, Unit> g;

    public static final class a {
        public static b a(EntranceInfoScene r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "scene");
            b r0 = new b();
            if (r11 != null) goto L13;
            JSONObject r1 = new JSONObject();
        L10:
            r0.a = r1;
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            r0.b = r10;
            return r0;
        L13:
            if (com.bytedance.android.shopping.anchorv3.a.b(r11) == false) goto L8;
            r1 = new JSONObject(r11);     // Catch: Exception -> L12
        L8:
            r1 = new JSONObject();
            goto L10
        }
    }

    static {
    }

    public final Integer a() {
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.KEY_FOLLOW_STATUS, "key");
        this.f.add(com.bytedance.android.ec.core.event.a.KEY_FOLLOW_STATUS);
        JSONObject r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("jsonObject");
    L6:
        if (r0.has(com.bytedance.android.ec.core.event.a.KEY_FOLLOW_STATUS) == true) goto L9;
        return null;
    L9:
        JSONObject r1 = this.a;
        if (r1 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("jsonObject");
    L13:
        return Integer.valueOf(r1.optInt(com.bytedance.android.ec.core.event.a.KEY_FOLLOW_STATUS));
    }

    public final JSONObject e() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L17
        if (this.c == false) goto L9;
        Function1<? super b, Unit> r10 = this.g;     // Catch: Throwable -> L17
        if (r10 == null) goto L8;
        Unit r11 = (Unit) r10.invoke(this);     // Catch: Throwable -> L17
    L8:
        this.c = false;     // Catch: Throwable -> L17
    L9:
        int r12 = vf.a.a;     // Catch: Throwable -> L17
        JSONObject r13 = this.a;     // Catch: Throwable -> L17
        if (r13 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("jsonObject");     // Catch: Throwable -> L17
    L12:
        EntranceInfoScene r14 = this.b;     // Catch: Throwable -> L17
        if (r14 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("sceneInfo");     // Catch: Throwable -> L17
    L15:
        return vf.a.d(r13, r14, this.d, this.e);
    L17:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        JSONObject r16 = this.a;
        if (r16 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("jsonObject");
    L21:
        return r16;
    }

    public final String h() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L16
        if (this.c == false) goto L8;
        Function1<? super b, Unit> r1 = this.g;     // Catch: Throwable -> L16
        if (r1 == null) goto L7;
        Unit r10 = (Unit) r1.invoke(this);     // Catch: Throwable -> L16
    L7:
        this.c = false;     // Catch: Throwable -> L16
    L8:
        int r11 = vf.a.a;     // Catch: Throwable -> L16
        JSONObject r12 = this.a;     // Catch: Throwable -> L16
        if (r12 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("jsonObject");     // Catch: Throwable -> L16
    L11:
        EntranceInfoScene r13 = this.b;     // Catch: Throwable -> L16
        if (r13 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("sceneInfo");     // Catch: Throwable -> L16
    L14:
        return vf.a.c(r12, r13, this.d, this.e);
    L16:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return "";
    }

    public final Iterator<String> keys() {
        JSONObject r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("jsonObject");
    L6:
        return r0.keys();
    }

    public b() {
        this.d = new LinkedHashSet();
        this.e = new LinkedHashSet();
        this.f = new LinkedHashSet();
    }

    public final void c(gl.a r10) {
        if (r10 == null) goto L8;
        Iterator r0 = r10.keys();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.hasNext() == false) goto L11;
        String r1 = (String) r0.next();
        k(r1, r10.get(r1));
        goto L6
    L11:
        return;
    }

    public final void d(String[] r10) {
        Intrinsics.checkNotNullParameter(r10, "keys");
        int r0 = r10.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        l(r10[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public void delete(String... r10) {
        Intrinsics.checkNotNullParameter(r10, "keys");
        Iterator r11 = ArraysKt.asSequence(r10).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        l((String) r11.next());
        goto L4
    }

    public final void g(Pair<String, ? extends Object>... r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Iterator r11 = ArraysKt.asSequence(r10).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Pair r0 = (Pair) r11.next();
        k((String) r0.getFirst(), r0.getSecond());
        goto L4
    }

    public final Object get(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        JSONObject r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("jsonObject");
    L6:
        return r0.get(r10);
    }

    public final String getString(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        this.f.add(r10);
        JSONObject r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("jsonObject");
    L6:
        if (r0.has(r10) == true) goto L9;
        return null;
    L9:
        JSONObject r1 = this.a;
        if (r1 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("jsonObject");
    L13:
        return r1.optString(r10);
    }

    public final void i(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Iterator<String> r0 = r10.keys();
    L6:
        if (r0.hasNext() == false) goto L8;
        String r1 = r0.next();
        k(r1, r10.get(r1));
        goto L6
    }

    public final void l(String r10) {
        if (wf.a.a() == false) goto L33;
        int r0 = vf.a.a;
        EntranceInfoScene r1 = this.b;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("sceneInfo");
    L8:
        if (vf.a.b(r1, r10, EntranceInfoWriteAction.REMOVE.getValue()) == false) goto L13;
        JSONObject r11 = this.a;
        if (r11 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("jsonObject");
    L12:
        r11.remove(r10);
        this.e.add(r10);
        this.c = true;
        return;
    L13:
        EntranceInfoScene r12 = this.b;
        if (r12 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("sceneInfo");
    L16:
        JSONObject r13 = this.a;
        if (r13 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("jsonObject");
    L19:
        vf.a.e(r12, r13, "action_check_failed", r10, null);
        EntranceInfoScene r14 = this.b;
        if (r14 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("sceneInfo");
    L22:
        String r15 = r14.a;
        Intrinsics.checkNotNullParameter(r15, AIStateLogRequest.SOURCE_PAGE);
        List<String> r16 = wf.a.c().getPassFiltered();
        if (r16 != null) goto L25;
    L27:
        boolean r17 = false;
    L28:
        if (r17 == true) goto L39;
        JSONObject r18 = this.a;
        if (r18 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("jsonObject");
    L32:
        r18.remove(r10);
        this.e.add(r10);
        this.c = true;
        return;
    L39:
        return;
    L25:
        if (r16.contains(r15) == true) goto L27;
        r17 = true;
        goto L28
    L33:
        JSONObject r19 = this.a;
        if (r19 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("jsonObject");
    L36:
        r19.remove(r10);
        this.e.add(r10);
        this.c = true;
    }

    public final void putAll(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Iterator r11 = ((LinkedHashMap) r10).entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) r11.next();
        k((String) r0.getKey(), r0.getValue());
        goto L4
    }

    public final void b(Pair<String, ? extends Object>[] r10, Function2<Object, Object, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "condition");
        Iterator r12 = ArraysKt.asSequence(r10).iterator();
    L4:
        if (r12.hasNext() == false) goto L18;
        Pair r0 = (Pair) r12.next();
        JSONObject r1 = this.a;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("jsonObject");
    L9:
        if (r1.has((String) r0.getFirst()) == false) goto L14;
        JSONObject r13 = this.a;
        if (r13 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("jsonObject");
    L13:
        Object r14 = r13.opt((String) r0.getFirst());
    L16:
        if (((Boolean) r11.invoke(r14, r0.getSecond())).booleanValue() == false) goto L4;
        k((String) r0.getFirst(), r0.getSecond());
        goto L4
    L14:
        r14 = null;
        goto L16
    }

    public final void f(Map<String, ? extends Object> r10, Function2<Object, Object, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "condition");
        Iterator<Map.Entry<String, ? extends Object>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L18;
        Map.Entry<String, ? extends Object> r0 = r12.next();
        JSONObject r1 = this.a;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("jsonObject");
    L9:
        if (r1.has(r0.getKey()) == false) goto L14;
        JSONObject r13 = this.a;
        if (r13 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("jsonObject");
    L13:
        Object r14 = r13.opt(r0.getKey());
    L16:
        if (((Boolean) r11.invoke(r14, r0.getValue())).booleanValue() == false) goto L4;
        k(r0.getKey(), r0.getValue());
        goto L4
    L14:
        r14 = null;
        goto L16
    }

    public final void j(Pair<String, ? extends Object>[] r10, Function1<Object, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "filter");
        Iterator r12 = ArraysKt.asSequence(r10).iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Pair r0 = (Pair) r12.next();
        if (((Boolean) r11.invoke(r0.getSecond())).booleanValue() == false) goto L4;
        k((String) r0.getFirst(), r0.getSecond());
        goto L4
    }

    public final void k(String r10, Object r11) {
        if (wf.a.a() == false) goto L55;
        int r0 = vf.a.a;
        EntranceInfoScene r1 = this.b;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("sceneInfo");
    L7:
        Intrinsics.checkNotNullParameter(r1, "scene");
        Intrinsics.checkNotNullParameter(r10, "key");
        if (r11 != null) goto L10;
        int r12 = EntranceInfoWriteAction.REMOVE.getValue();
    L12:
        if (vf.a.b(r1, r10, r12) == false) goto L26;
        JSONObject r13 = this.a;
        if (r13 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("jsonObject");
    L16:
        Intrinsics.checkNotNullParameter(r13, "$this$safePut");
        if (r10 != null) goto L71;
    L22:
        if (r11 != null) goto L24;
        this.e.add(r10);
    L25:
        this.c = true;
        return;
    L24:
        this.d.add(r10);
        goto L25
    L71:
        r13.put(r10, r11);     // Catch: Exception -> L20
    L20:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L22
    L26:
        EntranceInfoScene r14 = this.b;
        if (r14 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("sceneInfo");
    L29:
        JSONObject r15 = this.a;
        if (r15 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("jsonObject");
    L32:
        vf.a.e(r14, r15, "action_check_failed", r10, r11);
        EntranceInfoScene r16 = this.b;
        if (r16 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("sceneInfo");
    L35:
        String r17 = r16.a;
        Intrinsics.checkNotNullParameter(r17, AIStateLogRequest.SOURCE_PAGE);
        List<String> r18 = wf.a.c().getPassFiltered();
        if (r18 != null) goto L38;
    L40:
        boolean r19 = false;
    L41:
        if (r19 == true) goto L76;
        JSONObject r20 = this.a;
        if (r20 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("jsonObject");
    L45:
        Intrinsics.checkNotNullParameter(r20, "$this$safePut");
        if (r10 != null) goto L69;
    L51:
        if (r11 != null) goto L53;
        this.e.add(r10);
    L54:
        this.c = true;
        return;
    L53:
        this.d.add(r10);
        goto L54
    L69:
        r20.put(r10, r11);     // Catch: Exception -> L49
    L49:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L51
    L76:
        return;
    L38:
        if (r18.contains(r17) == true) goto L40;
        r19 = true;
        goto L41
    L10:
        r12 = EntranceInfoWriteAction.PUT.getValue();
        goto L12
    L55:
        JSONObject r21 = this.a;
        if (r21 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("jsonObject");
    L58:
        Intrinsics.checkNotNullParameter(r21, "$this$safePut");
        if (r10 != null) goto L73;
    L64:
        if (r11 != null) goto L66;
        this.e.add(r10);
    L67:
        this.c = true;
        return;
    L66:
        this.d.add(r10);
        goto L67
    L73:
        r21.put(r10, r11);     // Catch: Exception -> L62
    L62:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L64
    }
}

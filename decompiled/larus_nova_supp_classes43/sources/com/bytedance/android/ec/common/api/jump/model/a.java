package com.bytedance.android.ec.common.api.jump.model;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class a {
    private a parent;

    /* JADX INFO: renamed from: com.bytedance.android.ec.common.api.jump.model.a$a, reason: collision with other inner class name */
    public interface InterfaceC0115a {
        <T extends a> T a(KClass<T> r1);
    }

    public static final class b implements InterfaceC0115a {
        public static final b a = null;

        public b() {
        }

        static {
            a = new b();
        }

        @Override // com.bytedance.android.ec.common.api.jump.model.a.InterfaceC0115a
        public final <T extends a> T a(KClass<T> r10) {
            Intrinsics.checkNotNullParameter(r10, "modelClass");
            return (T) JvmClassMappingKt.getJavaClass(r10).newInstance();
        }
    }

    public a() {
    }

    public Map<String, String> chainParams() {
        return null;
    }

    public final JSONObject getAddToCartEntranceInfo() {
        JSONObject r0 = new JSONObject();
        a r1 = this;
    L3:
        if (r1 == null) goto L16;
        if ((r1 instanceof c) == false) goto L15;
        JSONObject r10 = ((c) r1).addToCartEntranceInfo();
        Iterator<String> r11 = r10.keys();
    L8:
        if (r11.hasNext() == false) goto L15;
        String r12 = r11.next();
        if (r0.has(r12) == true) goto L8;
        r0.put(r12, r10.opt(r12));     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        ye.a.b(e);
    L15:
        r1 = r1.parent;
        goto L3
    L16:
        return r0;
    }

    public final Map<String, String> getChainParams() {
        LinkedHashMap r0 = new LinkedHashMap();
        a r1 = this;
    L3:
        if (r1 == null) goto L14;
        Map<String, String> r10 = r1.chainParams();
        if (r10 == null) goto L12;
        Iterator<Map.Entry<String, String>> r11 = r10.entrySet().iterator();
    L8:
        if (r11.hasNext() == false) goto L12;
        Map.Entry<String, String> r12 = r11.next();
        String r13 = r12.getKey();
        String r14 = r12.getValue();
        if (r0.containsKey(r13) == true) goto L8;
        r0.put(r13, r14);
    L12:
        r1 = r1.parent;
        goto L3
    L14:
        if ((!r0.isEmpty()) == true) goto L25;
        return null;
    L25:
        return r0;
    }

    public final JSONObject getEntranceInfo() {
        JSONObject r0 = new JSONObject();
        a r1 = this;
    L3:
        if (r1 == null) goto L16;
        if ((r1 instanceof d) == false) goto L15;
        JSONObject r10 = ((d) r1).entranceInfo();
        Iterator<String> r11 = r10.keys();
    L8:
        if (r11.hasNext() == false) goto L15;
        String r12 = r11.next();
        if (r0.has(r12) == true) goto L8;
        r0.put(r12, r10.opt(r12));     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        ye.a.b(e);
    L15:
        r1 = r1.parent;
        goto L3
    L16:
        return r0;
    }

    public final a getParent() {
        return this.parent;
    }

    public final <T extends a> T getParamsModel(KClass<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "modelClass");
        T r0 = (T) this;
    L3:
        if (r0 == null) goto L8;
        if (Intrinsics.areEqual(r10, Reflection.getOrCreateKotlinClass(r0.getClass())) == true) goto L6;
        r0 = (T) r0.parent;
        goto L3
    L6:
        return r0;
    L8:
        return null;
    }

    public final <T extends a> T buildParams(KClass<T> r10, InterfaceC0115a r11) {
        Intrinsics.checkNotNullParameter(r10, "modelClass");
        Intrinsics.checkNotNullParameter(r11, "factory");
        T r12 = (T) r11.a(r10);
        r12.parent = this;
        return r12;
    }

    public static /* synthetic */ a buildParams$default(a r0, KClass r1, InterfaceC0115a r10, int r11, Object r12) {
        if (r12 != null) goto L9;
        if ((r11 & 2) == 0) goto L7;
        r10 = b.a;
    L7:
        return r0.buildParams(r1, r10);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildParams");
    }
}

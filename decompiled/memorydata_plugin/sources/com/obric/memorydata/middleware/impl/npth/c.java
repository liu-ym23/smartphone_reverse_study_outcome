package com.obric.memorydata.middleware.impl.npth;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\f\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/middleware/impl/npth/CrashTeaEventStorage;", "", "readValue", "Lkotlin/Function0;", "", "writeValue", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "read", "Lcom/obric/memorydata/middleware/impl/npth/PendingCrashTeaEventSnapshot;", "write", "events", "", "Lcom/obric/memorydata/middleware/impl/npth/PendingCrashTeaEvent;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0<String> f11791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<String, Boolean> f11792b;

    public c(Function0<String> r3, Function1<? super String, Boolean> r4) {
        Function0<String> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Function1<String, Boolean> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "readValue");
        Intrinsics.checkNotNullParameter(r6, "writeValue");
        this.f11791a = r5;
        this.f11792b = r6;
    }

    public final g a() {
        String r7 = (String) ZeusTransformUtils.preCheckCast(this.f11791a.invoke(), String.class, "com.obric.memorydata.plugin");
        int r2 = 0;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L22;
        return new g(CollectionsKt.emptyList(), false);
    L22:
        JSONArray r3 = new JSONArray(r7);     // Catch: JSONException -> L20
        List r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r1 = r3.length();
        boolean r4 = false;
    L9:
        if (r2 >= r1) goto L19;
        JSONObject r5 = r3.optJSONObject(r2);
        if (r5 == null) goto L13;
        e r6 = e.f11794a.a(r5);
    L14:
        if (r6 != null) goto L16;
        r4 = true;
    L17:
        r2 = r2 + 1;
        goto L9
    L16:
        r8.add(r6);
        goto L17
    L13:
        r6 = null;
        goto L14
    L19:
        return new g(r8, r4);
    L21:
        return new g(CollectionsKt.emptyList(), true);
    }

    public final boolean a(List<e> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "events");
        JSONArray r0 = new JSONArray();
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r0.put(((e) ZeusTransformUtils.preCheckCast(r7.next(), e.class, "com.obric.memorydata.plugin")).e());
        goto L4
    L6:
        Function1<String, Boolean> r4 = this.f11792b;
        String r8 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r8, "toString(...)");
        return ((Boolean) ZeusTransformUtils.preCheckCast(r4.invoke(r8), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }
}

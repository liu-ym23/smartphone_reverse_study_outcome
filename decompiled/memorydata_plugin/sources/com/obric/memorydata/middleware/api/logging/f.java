package com.obric.memorydata.middleware.api.logging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001d\b\u0000\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0080\u0002¢\u0006\u0002\b\u000bJ\u0019\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010H\u0000¢\u0006\u0002\b\u0011J\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/middleware/api/logging/LogFields;", "", "values", "", "", "<init>", "(Ljava/util/Map;)V", "getValues$middleware_api_obricRelease", "()Ljava/util/Map;", "plus", "other", "plus$middleware_api_obricRelease", "appendTo", "", "output", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "appendTo$middleware_api_obricRelease", "fitAfter", "prefixLength", "", "fitAfter$middleware_api_obricRelease", "Companion", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11616a = null;
    private static final f c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, String> f11617b;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/middleware/api/logging/LogFields$Companion;", "", "<init>", "()V", "Empty", "Lcom/obric/memorydata/middleware/api/logging/LogFields;", "getEmpty", "()Lcom/obric/memorydata/middleware/api/logging/LogFields;", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final f a() {
            return f.b();
        }
    }

    static {
        f11616a = new a(null);
        c = new f(MapsKt.emptyMap());
    }

    public f(Map<String, String> r3) {
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "values");
        this.f11617b = r4;
    }

    public static final /* synthetic */ f b() {
        return c;
    }

    public final f a(int r8) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r7 = this.f11617b.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L13;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.getValue(), String.class, "com.obric.memorydata.plugin");
        if (r8 != 0) goto L8;
        int r5 = 0;
    L9:
        int r6 = (r5 + r3.length()) + 1;
        int r4 = (1024 - r8) - r6;
        if (r4 <= 0) goto L13;
        String r9 = StringsKt.take(r2, r4);
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).put(r3, r9);
        r8 = r8 + (r6 + r9.length());
        goto L4
    L8:
        r5 = 1;
    L13:
        return new f((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin"));
    }

    public final f a(f r6) {
        Intrinsics.checkNotNullParameter(r6, "other");
        LinkedHashMap r0 = new LinkedHashMap(this.f11617b);
        Iterator<Map.Entry<String, String>> r5 = r6.f11617b.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L11;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r7.getKey(), String.class, "com.obric.memorydata.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.getValue(), String.class, "com.obric.memorydata.plugin");
        if (r0.size() >= 12) goto L11;
        if (((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).containsKey(r2) == true) goto L4;
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).put(r2, r8);
    L11:
        return new f((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin"));
    }

    public final Map<String, String> a() {
        return this.f11617b;
    }

    public final void a(StringBuilder r8) {
        Intrinsics.checkNotNullParameter(r8, "output");
        Iterator<Map.Entry<String, String>> r7 = this.f11617b.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L15;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L8;
        int r3 = 1;
    L9:
        int r4 = r3 ^ 1;
        int r5 = (1024 - r8.length()) - ((r1.length() + r4) + 1);
        if (r5 <= 0) goto L11;
        if (r4 <= 0) goto L14;
        r8.append(' ');
    L14:
        r8.append(r1).append('=');
        r8.append((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), 0, Math.min(r2.length(), r5));
        goto L4
    L11:
        return;
    L8:
        r3 = 0;
        goto L9
    }
}

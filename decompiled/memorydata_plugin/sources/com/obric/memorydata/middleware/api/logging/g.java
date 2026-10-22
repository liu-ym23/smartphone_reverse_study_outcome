package com.obric.memorydata.middleware.api.logging;

import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\t\b\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0001J\b\u0010\u000b\u001a\u00020\fH\u0001J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/middleware/api/logging/LogFieldsBuilder;", "", "<init>", "()V", "values", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", EventBody.KEY_VALUE, "", "key", "build", "Lcom/obric/memorydata/middleware/api/logging/LogFields;", "normalizeKey", "Companion", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f11618a = null;
    private static final Set<String> c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedHashMap<String, String> f11619b;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/middleware/api/logging/LogFieldsBuilder$Companion;", "", "<init>", "()V", "RESERVED_KEYS", "", "", "getRESERVED_KEYS", "()Ljava/util/Set;", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f11618a = new a(null);
        c = SetsKt.setOf(new String[]{AILabCheckPermissionTask.KEY_SOURCE, "module", "biz", "trace", "trace_id", "stage", "event", "code", "message"});
    }

    public g() {
        this.f11619b = new LinkedHashMap();
    }

    private final String a(String r9) {
        int r8 = r9.length();
        boolean r0 = true;
        if (1 <= r8) goto L5;
    L7:
        boolean r10 = false;
    L9:
        if (r10 == false) goto L45;
        char r11 = StringsKt.first((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"));
        if ('a' > r11) goto L14;
        if (r11 >= '{') goto L14;
        boolean r12 = true;
    L15:
        if (r12 == false) goto L45;
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin");
        int r3 = 0;
    L19:
        if (r3 >= r13.length()) goto L41;
        char r6 = r13.charAt(r3);
        if ('a' > r6) goto L24;
        if (r6 >= '{') goto L24;
        boolean r7 = true;
    L25:
        if (r7 == false) goto L27;
    L37:
        boolean r14 = true;
    L38:
        if (r14 == false) goto L39;
        r3 = r3 + 1;
        goto L19
    L39:
        r0 = false;
        goto L41
    L27:
        if ('0' <= r6) goto L29;
    L31:
        boolean r15 = false;
    L32:
        if (r15 == true) goto L37;
        if (r6 == '_') goto L37;
        r14 = false;
        goto L38
    L29:
        if (r6 >= ':') goto L31;
        r15 = true;
    L24:
        r7 = false;
    L41:
        if (r0 == false) goto L44;
        return r9;
    L44:
        return null;
    L14:
        r12 = false;
    L45:
        return null;
    L5:
        if (r8 >= 41) goto L7;
        r10 = true;
        goto L9
    }

    public final f a() {
        return new f(MapsKt.toMap((Map) ZeusTransformUtils.preCheckCast(this.f11619b, Map.class, "com.obric.memorydata.plugin")));
    }

    public final void a(String r4, Object r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        if (r5 != null) goto L5;
        return;
    L5:
        String r6 = a(r4);
        if (r6 != null) goto L9;
        return;
    L9:
        if (c.contains(r6) == false) goto L12;
        return;
    L12:
        if (((Map) ZeusTransformUtils.preCheckCast(this.f11619b, Map.class, "com.obric.memorydata.plugin")).containsKey(r6) == true) goto L17;
        if (this.f11619b.size() < 12) goto L17;
        return;
    L17:
        if (ZeusTransformUtils.instanceOf(r5, Boolean.class) == false) goto L19;
        String r7 = String.valueOf(((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
    L20:
        ((Map) ZeusTransformUtils.preCheckCast(this.f11619b, Map.class, "com.obric.memorydata.plugin")).put(r6, h.f11620a.a(r7, 128));
        return;
    L19:
        r7 = r5.toString();
        goto L20
    }
}

package com.obric.memorydata.personalcontext.external.schedule;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\f\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/schedule/IcsProperty;", "", ActivityLifecycle.NAME, "", EventBody.KEY_VALUE, "parameters", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getName", "()Ljava/lang/String;", "getValue", "getParameters", "()Ljava/util/Map;", "toString", "escapeValue", "foldLine", "line", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12174b;
    private final Map<String, String> c;

    public i(String r3, String r4, Map<String, String> r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r4, EventBody.KEY_VALUE);
        Intrinsics.checkNotNullParameter(r6, "parameters");
        this.f12173a = r3;
        this.f12174b = r4;
        this.c = r6;
    }

    private final String a(String r13) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r13, "\\", "\\\\", false, 4, null), "\r", "", false, 4, null), "\n", "\\n", false, 4, null), ";", "\\;", false, 4, null), ",", "\\,", false, 4, null);
    }

    private final String b(String r4) {
        if (r4.length() > 75) goto L5;
        return r4;
    L5:
        StringBuilder r3 = new StringBuilder();
        int r0 = 0;
    L7:
        if (r0 >= r4.length()) goto L12;
        int r1 = r0 + 75;
        String r2 = r4.substring(r0, Math.min(r1, r4.length()));
        Intrinsics.checkNotNullExpressionValue(r2, "substring(...)");
        r3.append(r2);
        if (r1 >= r4.length()) goto L11;
        r3.append("\r\n ");
    L11:
        r0 = r1;
        goto L7
    L12:
        String r5 = r3.toString();
        Intrinsics.checkNotNullExpressionValue(r5, "toString(...)");
        return r5;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(this.f12173a);
        Iterator<Map.Entry<String, String>> r1 = this.c.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin");
        r0.append(";").append(r3).append("=").append(r4);
        goto L4
    L6:
        r0.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        if (Intrinsics.areEqual(this.f12173a, "SUMMARY") == false) goto L9;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == false) goto L17;
        String r6 = a(this.f12174b);
    L18:
        String r7 = r0.append(r6).toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        return b(r7);
    L17:
        r6 = this.f12174b;
        goto L18
    L9:
        if (Intrinsics.areEqual(this.f12173a, "DESCRIPTION") == true) goto L14;
        if (Intrinsics.areEqual(this.f12173a, "LOCATION") == true) goto L14;
        r5 = false;
        goto L15
    }
}

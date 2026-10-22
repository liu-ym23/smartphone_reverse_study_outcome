package com.obric.memorydata.memory.api;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.entity.Header;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/memory/api/GlassesEnvironmentTimerSettings;", "", "userId", "", "enabled", "", CommonConsts.APM_INNER_EVENT_COST_START, "end", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "getEnabled", "()Z", "getStart", "getEnd", "reportedStart", "getReportedStart", "reportedEnd", "getReportedEnd", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "memory_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0490a f10058a = null;
    private static final Regex f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10059b;
    private final boolean c;
    private final String d;
    private final String e;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.api.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0005J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/api/GlassesEnvironmentTimerSettings$Companion;", "", "<init>", "()V", "KEY", "", "QUERY_SUPPORT", "timePattern", "Lkotlin/text/Regex;", "fromJson", "Lcom/obric/memorydata/memory/api/GlassesEnvironmentTimerSettings;", EventBody.KEY_VALUE, "normalizeTime", "memory_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0490a {
        private C0490a() {
        }

        public /* synthetic */ C0490a(DefaultConstructorMarker r1) {
            this();
        }

        private final String b(String r5) {
            MatchResult r4 = a.d().matchEntire((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"));
            if (r4 != null) goto L7;
            return null;
        L7:
            return StringsKt.padStart((String) ZeusTransformUtils.preCheckCast(r4.getGroupValues().get(1), String.class, "com.obric.memorydata.plugin"), 2, '0') + ':' + StringsKt.padStart((String) ZeusTransformUtils.preCheckCast(r4.getGroupValues().get(2), String.class, "com.obric.memorydata.plugin"), 2, '0');
        }

        public final a a(String r11) {
            Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
            if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L50;
            return null;
        L50:
            JSONObject r0 = new JSONObject(r11);     // Catch: JSONException -> L49
            Object r12 = r0.opt(Header.KEY_USER_ID);
            if (ZeusTransformUtils.instanceOf(r12, String.class) == false) goto L9;
            String r4 = (String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.memorydata.plugin");
        L10:
            if (r4 != null) goto L12;
            return null;
        L12:
            Long r13 = StringsKt.toLongOrNull(r4);
            boolean r3 = true;
            if (r13 != null) goto L15;
        L20:
            r3 = false;
        L21:
            if (r3 == true) goto L23;
            return null;
        L23:
            Object r14 = r0.opt("enabled");
            if (ZeusTransformUtils.instanceOf(r14, Boolean.class) == false) goto L26;
            Boolean r15 = (Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.memorydata.plugin");
        L27:
            if (r15 == null) goto L48;
            boolean r5 = r15.booleanValue();
            Object r16 = r0.opt(CommonConsts.APM_INNER_EVENT_COST_START);
            if (ZeusTransformUtils.instanceOf(r16, String.class) == false) goto L31;
            String r17 = (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.memorydata.plugin");
        L32:
            if (r17 != null) goto L34;
            return null;
        L34:
            String r6 = b(r17);
            if (r6 != null) goto L37;
            return null;
        L37:
            Object r18 = r0.opt("end");
            if (ZeusTransformUtils.instanceOf(r18, String.class) == false) goto L40;
            String r19 = (String) ZeusTransformUtils.preCheckCast(r18, String.class, "com.obric.memorydata.plugin");
        L41:
            if (r19 != null) goto L43;
            return null;
        L43:
            String r7 = b(r19);
            if (r7 != null) goto L47;
            return null;
        L47:
            return new a(r4, r5, r6, r7, null);
        L40:
            r19 = null;
            goto L41
        L31:
            r17 = null;
            goto L32
        L26:
            r15 = null;
            goto L27
        L15:
            if (((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L17;
            boolean r110 = true;
        L18:
            if (r110 != true) goto L20;
        L17:
            r110 = false;
            goto L18
        L9:
            r4 = null;
        L48:
            return null;
        }
    }

    static {
        f10058a = new C0490a(null);
        f = new Regex("([01]?[0-9]|2[0-3]):([0-5]?[0-9])");
    }

    private a(String r1, boolean r2, String r3, String r4) {
        this.f10059b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
    }

    public /* synthetic */ a(String r1, boolean r2, String r3, String r4, DefaultConstructorMarker r5) {
        this(r1, r2, r3, r4);
    }

    public static final /* synthetic */ Regex d() {
        return f;
    }

    public final String a() {
        return this.f10059b;
    }

    public final String b() {
        if (this.c == true) goto L7;
        return "";
    L7:
        return this.d;
    }

    public final String c() {
        if (this.c == true) goto L7;
        return "";
    L7:
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f10059b, r6.f10059b) == true) goto L12;
        return false;
    L12:
        if (this.c == r6.c) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f10059b.hashCode() * 31) + Boolean.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "GlassesEnvironmentTimerSettings(userId=" + this.f10059b + ", enabled=" + this.c + ", start=" + this.d + ", end=" + this.e + ')';
    }
}

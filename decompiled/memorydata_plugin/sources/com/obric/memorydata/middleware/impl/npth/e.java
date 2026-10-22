package com.obric.memorydata.middleware.impl.npth;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/middleware/impl/npth/PendingCrashTeaEvent;", "", OaidModel.KEY_ID, "", "eventName", "paramsJson", "crashTimeMs", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getId", "()Ljava/lang/String;", "getEventName", "getParamsJson", "getCrashTimeMs", "()J", "toJson", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11794a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11795b;
    private final String c;
    private final String d;
    private final long e;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/middleware/impl/npth/PendingCrashTeaEvent$Companion;", "", "<init>", "()V", "MAX_PARAMS_LENGTH", "", "fromJson", "Lcom/obric/memorydata/middleware/impl/npth/PendingCrashTeaEvent;", "json", "Lorg/json/JSONObject;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final e a(JSONObject r9) {
            Intrinsics.checkNotNullParameter(r9, "json");
            String r1 = r9.optString("crash_event_id");
            String r2 = r9.optString("event_name");
            JSONObject r8 = r9.optJSONObject(TrackerImpl.PARAMS);
            if (r8 != null) goto L5;
            return null;
        L5:
            long r6 = r9.optLong("crash_time_ms", 0);
            String r3 = r8.toString();
            Intrinsics.checkNotNullExpressionValue(r3, "toString(...)");
            Intrinsics.checkNotNull(r1);
            if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L8;
        L17:
            return null;
        L8:
            if (b.a().contains(r2) == false) goto L17;
            if (r6 <= 0) goto L17;
            if (r3.length() <= 8192) goto L15;
            return null;
        L15:
            Intrinsics.checkNotNull(r2);
            return new e(r1, r2, r3, r6);
        }
    }

    static {
        f11794a = new a(null);
    }

    public e(String r2, String r3, String r4, long r5) {
        Intrinsics.checkNotNullParameter(r2, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "paramsJson");
        this.f11795b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final String a() {
        return this.f11795b;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final long d() {
        return this.e;
    }

    public final JSONObject e() {
        JSONObject r3 = new JSONObject().put("crash_event_id", this.f11795b).put("event_name", this.c).put(TrackerImpl.PARAMS, new JSONObject(this.d)).put("crash_time_ms", this.e);
        Intrinsics.checkNotNullExpressionValue(r3, "put(...)");
        return r3;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, e.class) == true) goto L8;
        return false;
    L8:
        e r8 = (e) ZeusTransformUtils.preCheckCast(r7, e.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f11795b, r8.f11795b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r8.c) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.d, r8.d) == true) goto L18;
        return false;
    L18:
        if (this.e == r8.e) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f11795b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Long.hashCode(this.e);
    }

    public String toString() {
        return "PendingCrashTeaEvent(id=" + this.f11795b + ", eventName=" + this.c + ", paramsJson=" + this.d + ", crashTimeMs=" + this.e + ')';
    }
}

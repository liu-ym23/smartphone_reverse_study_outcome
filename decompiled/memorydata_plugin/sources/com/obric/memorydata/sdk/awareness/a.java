package com.obric.memorydata.sdk.awareness;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/CommuteClusterResult;", "", "leaveHomeTime", "", "arriveCompanyTime", "leaveCompanyTime", "arriveHomeTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLeaveHomeTime", "()Ljava/lang/String;", "getArriveCompanyTime", "getLeaveCompanyTime", "getArriveHomeTime", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0692a f12817a = null;
    private static final List<String> f = null;
    private static final List<String> g = null;
    private static final List<String> h = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12818b;
    private final String c;
    private final String d;
    private final String e;

    /* JADX INFO: renamed from: com.obric.memorydata.sdk.awareness.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/CommuteClusterResult$Companion;", "", "<init>", "()V", "KEY_LEAVE_HOME_TIME", "", "KEY_ARRIVE_COMPANY_TIME", "KEY_LEAVE_COMPANY_TIME", "KEY_ARRIVE_HOME_TIME", "TO_COMPANY_KEYS", "", "getTO_COMPANY_KEYS", "()Ljava/util/List;", "TO_HOME_KEYS", "getTO_HOME_KEYS", "ALL_TIME_KEYS", "getALL_TIME_KEYS", "parse", "Lcom/obric/memorydata/sdk/awareness/CommuteClusterResult;", EventBody.KEY_VALUE, "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0692a {
        private C0692a() {
        }

        public /* synthetic */ C0692a(DefaultConstructorMarker r1) {
            this();
        }

        public final a a(Object r7) {
            if (r7 != null) goto L29;
        L23:
            JSONObject r8 = null;
        L24:
            if (r8 != null) goto L26;
            return null;
        L26:
            String r0 = r8.optString("LEAVE_HOME_TIME_COMMUTE", "");
            Intrinsics.checkNotNullExpressionValue(r0, "optString(...)");
            String r3 = r8.optString("ARRIVE_COMPANY_TIME_COMMUTE", "");
            Intrinsics.checkNotNullExpressionValue(r3, "optString(...)");
            String r4 = r8.optString("LEAVE_COMPANY_TIME_COMMUTE", "");
            Intrinsics.checkNotNullExpressionValue(r4, "optString(...)");
            String r9 = r8.optString("ARRIVE_HOME_TIME_COMMUTE", "");
            Intrinsics.checkNotNullExpressionValue(r9, "optString(...)");
            return new a(r0, r3, r4, r9);
        L29:
            if (ZeusTransformUtils.instanceOf(r7, JSONObject.class) == false) goto L10;
            r8 = (JSONObject) ZeusTransformUtils.preCheckCast(r7, JSONObject.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L28
            goto L24
        L10:
            if (ZeusTransformUtils.instanceOf(r7, Map.class) == false) goto L13;
            JSONObject r1 = new JSONObject((Map) ZeusTransformUtils.preCheckCast(r7, Map.class, "com.obric.memorydata.plugin"));     // Catch: JSONException -> L28
        L22:
            r8 = r1;
            goto L24
        L13:
            if (ZeusTransformUtils.instanceOf(r7, String.class) == true) goto L15;
            r1 = new JSONObject(r7.toString());     // Catch: JSONException -> L28
            goto L22
        L15:
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L18;
            r7 = null;
        L18:
            String r10 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L28
            if (r10 == null) goto L23;
            r1 = new JSONObject(r10);     // Catch: JSONException -> L28
            goto L22
        }
    }

    static {
        f12817a = new C0692a(null);
        List<String> r0 = CollectionsKt.listOf(new String[]{"LEAVE_HOME_TIME_COMMUTE", "ARRIVE_COMPANY_TIME_COMMUTE"});
        f = r0;
        List<String> r1 = CollectionsKt.listOf(new String[]{"LEAVE_COMPANY_TIME_COMMUTE", "ARRIVE_HOME_TIME_COMMUTE"});
        g = r1;
        h = CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin"));
    }

    public a(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "leaveHomeTime");
        Intrinsics.checkNotNullParameter(r3, "arriveCompanyTime");
        Intrinsics.checkNotNullParameter(r4, "leaveCompanyTime");
        Intrinsics.checkNotNullParameter(r5, "arriveHomeTime");
        this.f12818b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final String a() {
        return this.f12818b;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final String d() {
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
        if (Intrinsics.areEqual(this.f12818b, r6.f12818b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
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
        return (((((this.f12818b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "CommuteClusterResult(leaveHomeTime=" + this.f12818b + ", arriveCompanyTime=" + this.c + ", leaveCompanyTime=" + this.d + ", arriveHomeTime=" + this.e + ')';
    }
}

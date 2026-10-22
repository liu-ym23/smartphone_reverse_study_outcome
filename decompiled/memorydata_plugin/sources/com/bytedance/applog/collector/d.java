package com.bytedance.applog.collector;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004J\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/applog/collector/PageHolder;", "", "()V", "currentPageId", "", "currentPageName", "enabled", "", "sdkPageId", "getPageId", "getPageInfo", "Lcom/bytedance/applog/collector/PageHolder$PageInfo;", "getSdkPageId", "isEnabled", "onBackground", "", "setEnabled", "e", "setPageId", OaidModel.KEY_ID, "setPageName", ActivityLifecycle.NAME, "setSdkPageId", "PageInfo", "agent_chinaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1556b;
    private String c;
    private String d;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0006\u0010\u0018\u001a\u00020\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/applog/collector/PageHolder$PageInfo;", "", CrashBody.PID, "", "pName", "sdkPageId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPName", "()Ljava/lang/String;", "getPid", "getSdkPageId", "appendToJson", "", TypedValues.AttributesType.S_TARGET, "Lorg/json/JSONObject;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toJsonString", "toString", "Companion", "agent_chinaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0099a f1557a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f1558b;
        private final String c;
        private final String d;

        /* JADX INFO: renamed from: com.bytedance.applog.collector.d$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/applog/collector/PageHolder$PageInfo$Companion;", "", "()V", "parse", "Lcom/bytedance/applog/collector/PageHolder$PageInfo;", "json", "", "agent_chinaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class C0099a {
            private C0099a() {
            }

            public /* synthetic */ C0099a(DefaultConstructorMarker r1) {
                this();
            }

            public final a a(String r4) {
                Intrinsics.checkNotNullParameter(r4, "json");
                JSONObject r3 = new JSONObject(r4);     // Catch: Throwable -> L5
                String r0 = r3.optString(CrashBody.PID);     // Catch: Throwable -> L5
                Intrinsics.checkNotNullExpressionValue(r0, "optString(\"pid\")");     // Catch: Throwable -> L5
                String r1 = r3.optString("pName");     // Catch: Throwable -> L5
                Intrinsics.checkNotNullExpressionValue(r1, "optString(\"pName\")");     // Catch: Throwable -> L5
                String r5 = r3.optString("sdkPageId");     // Catch: Throwable -> L5
                Intrinsics.checkNotNullExpressionValue(r5, "optString(\"sdkPageId\")");     // Catch: Throwable -> L5
                return new a(r0, r1, r5);
            L5:
                th = move-exception;
                th.printStackTrace();
                return null;
            }
        }

        static {
            f1557a = new C0099a(null);
        }

        public a(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, CrashBody.PID);
            Intrinsics.checkNotNullParameter(r3, "pName");
            Intrinsics.checkNotNullParameter(r4, "sdkPageId");
            this.f1558b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final String a() {
            JSONObject r0 = new JSONObject();
            r0.put(CrashBody.PID, this.f1558b);
            r0.put("pName", this.c);
            r0.put("sdkPageId", this.d);
            String r3 = r0.toString();
            Intrinsics.checkNotNullExpressionValue(r3, "JSONObject().apply {\n   …\n            }.toString()");
            return r3;
        }

        public final void a(JSONObject r3) {
            Intrinsics.checkNotNullParameter(r3, TypedValues.AttributesType.S_TARGET);
            r3.putOpt("__pid", this.f1558b);
            r3.putOpt("__pname", this.c);
            r3.putOpt("__sdk_pid", this.d);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f1558b, r6.f1558b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f1558b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "PageInfo(pid=" + this.f1558b + ", pName=" + this.c + ", sdkPageId=" + this.d + ')';
        }
    }

    public d() {
        this.f1556b = "__coldstart";
        this.c = "";
        this.d = "__coldstart";
    }

    public final a a() {
        if (this.f1555a == true) goto L7;
        return null;
    L7:
        return new a(this.f1556b, this.c, this.d);
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, OaidModel.KEY_ID);
        this.f1556b = r2;
    }

    public final void a(boolean r1) {
        this.f1555a = r1;
    }

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, OaidModel.KEY_ID);
        this.d = r2;
    }

    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        this.c = r2;
    }
}

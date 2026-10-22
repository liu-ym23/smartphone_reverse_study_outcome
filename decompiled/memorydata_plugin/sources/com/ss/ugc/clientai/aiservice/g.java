package com.ss.ugc.clientai.aiservice;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/ss/ugc/clientai/aiservice/PredictState;", "", "code", "", ActivityLifecycle.NAME, "", "percentage", "", "(ILjava/lang/String;F)V", "getCode", "()I", WsConstants.KEY_EXTRA, "getExtra", "()Ljava/lang/Object;", "setExtra", "(Ljava/lang/Object;)V", "getName", "()Ljava/lang/String;", "getPercentage", "()F", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "service-ohr_release"}, k = 1, mv = {1, 4, 1})
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f15783a = null;
    private static final g f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f15784b;
    private final int c;
    private final String d;
    private final float e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/ugc/clientai/aiservice/PredictState$Companion;", "", "()V", "DEFAULT", "Lcom/ss/ugc/clientai/aiservice/PredictState;", "getDEFAULT", "()Lcom/ss/ugc/clientai/aiservice/PredictState;", "service-ohr_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final g a() {
            return g.d();
        }
    }

    static {
        f15783a = new a(null);
        f = new g(-1, "Default", 1.0f);
    }

    public g(int r2, String r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        this.c = r2;
        this.d = r3;
        this.e = r4;
    }

    public static final /* synthetic */ g d() {
        return f;
    }

    public final Object a() {
        return this.f15784b;
    }

    public final int b() {
        return this.c;
    }

    public final float c() {
        return this.e;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, g.class) == false) goto L13;
        g r4 = (g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.memorydata.plugin");
        if (this.c == r4.c) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L11;
        return false;
    L11:
        if (Float.compare(this.e, r4.e) == 0) goto L20;
        return false;
    L20:
        return true;
    L13:
        return false;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.c) * 31;
        String r1 = this.d;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return ((r0 + r2) * 31) + Float.hashCode(this.e);
    L5:
        r2 = 0;
        goto L7
    }

    public String toString() {
        return "PredictState(code=" + this.c + ", name=" + this.d + ", percentage=" + this.e + ")";
    }
}

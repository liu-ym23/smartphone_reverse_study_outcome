package com.ss.ugc.clientai.aiservice;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u001e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/ss/ugc/clientai/aiservice/AIPredictResult;", "", "status", "", "(I)V", "allPossibleStates", "", "Lcom/ss/ugc/clientai/aiservice/PredictState;", "getAllPossibleStates", "()Ljava/util/List;", "allPossibleStatesImpl", "", "isSuccess", "", "()Z", "<set-?>", "mostPossibleState", "getMostPossibleState", "()Lcom/ss/ugc/clientai/aiservice/PredictState;", "getStatus", "()I", "appendPredictState", "", "state", "toString", "", "Companion", "service-ohr_release"}, k = 1, mv = {1, 4, 1})
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f15779a = null;
    private static final int e = 0;
    private static final int f = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15780b;
    private g c;
    private final List<g> d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/ss/ugc/clientai/aiservice/AIPredictResult$Companion;", "", "()V", "STATUS_SUCCESS", "", "getSTATUS_SUCCESS", "()I", "STATUS_UNAVAILABLE", "getSTATUS_UNAVAILABLE", "STATUS_UNKNOWN", "getSTATUS_UNKNOWN", "service-ohr_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final int a() {
            return d.d();
        }
    }

    static {
        f15779a = new a(null);
        e = -1;
        f = -2;
    }

    public d() {
        this(0, 1, null);
    }

    public d(int r3) {
        this.f15780b = r3;
        this.c = g.f15783a.a();
        this.d = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ d(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        this(r1);
    }

    public static final /* synthetic */ int d() {
        return e;
    }

    public final void a(g r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        if (Intrinsics.areEqual(this.c, g.f15783a.a()) == false) goto L5;
    L6:
        this.c = r3;
    L7:
        ((Collection) ZeusTransformUtils.preCheckCast(this.d, Collection.class, "com.obric.memorydata.plugin")).add(r3);
        return;
    L5:
        if (r3.c() <= this.c.c()) goto L7;
        goto L6
    }

    public final boolean a() {
        if (this.f15780b != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final g b() {
        return this.c;
    }

    public final List<g> c() {
        return this.d;
    }

    public String toString() {
        return "AIPredictResult{status=" + this.f15780b + ", predic=" + this.c.b() + ", confid=" + this.c.c() + '}';
    }
}

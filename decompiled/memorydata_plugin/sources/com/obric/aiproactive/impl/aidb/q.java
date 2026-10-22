package com.obric.aiproactive.impl.aidb;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/aiproactive/impl/aidb/FeedbackReportConfig;", "", "enabled", "", "blackList", "", "Lcom/obric/aiproactive/impl/aidb/FeedbackReportBlockItem;", "<init>", "(ZLjava/util/List;)V", "getEnabled", "()Z", "getBlackList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("enabled")
    private final boolean f6371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName(alternate = {"blacklist"}, value = "blackList")
    private final List<p> f6372b;

    /* JADX WARN: Multi-variable type inference failed */
    public q() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public q(boolean r3, List<p> r4) {
        List<p> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.f6371a = r3;
        this.f6372b = r5;
    }

    public /* synthetic */ q(boolean r2, List r3, int r4, DefaultConstructorMarker r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r6 = null;
    L8:
        this(r2, r6);
    }

    public final boolean a() {
        return this.f6371a;
    }

    public final List<p> b() {
        return this.f6372b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, q.class) == true) goto L8;
        return false;
    L8:
        q r6 = (q) ZeusTransformUtils.preCheckCast(r5, q.class, "com.obric.memorydata.plugin");
        if (this.f6371a == r6.f6371a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6372b, r6.f6372b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = Boolean.hashCode(this.f6371a) * 31;
        List<p> r1 = this.f6372b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "FeedbackReportConfig(enabled=" + this.f6371a + ", blackList=" + this.f6372b + ')';
    }
}

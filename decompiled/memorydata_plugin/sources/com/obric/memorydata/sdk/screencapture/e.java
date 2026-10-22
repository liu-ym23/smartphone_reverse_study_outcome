package com.obric.memorydata.sdk.screencapture;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0017\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0003J5\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/PendingCaptureOperation;", "", "taskOptions", "Lcom/obric/memorydata/sdk/screencapture/TaskOptions;", "targetPackage", "", "callback", "Lkotlin/Function1;", "Lcom/obric/memorydata/sdk/screencapture/ScreenData;", "", "<init>", "(Lcom/obric/memorydata/sdk/screencapture/TaskOptions;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getTaskOptions", "()Lcom/obric/memorydata/sdk/screencapture/TaskOptions;", "getTargetPackage", "()Ljava/lang/String;", "getCallback", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TaskOptions f12850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12851b;
    private final Function1<ScreenData, Unit> c;

    public e(TaskOptions r3, String r4, Function1<? super ScreenData, Unit> r5) {
        Function1<ScreenData, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "taskOptions");
        Intrinsics.checkNotNullParameter(r4, "targetPackage");
        Intrinsics.checkNotNullParameter(r6, "callback");
        this.f12850a = r3;
        this.f12851b = r4;
        this.c = r6;
    }

    public final TaskOptions a() {
        return this.f12850a;
    }

    public final String b() {
        return this.f12851b;
    }

    public final Function1<ScreenData, Unit> c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f12850a, r6.f12850a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f12851b, r6.f12851b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f12850a.hashCode() * 31) + this.f12851b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "PendingCaptureOperation(taskOptions=" + this.f12850a + ", targetPackage=" + this.f12851b + ", callback=" + this.c + ')';
    }
}

package com.obric.oui.bouncelayout;

import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0006\u0010!\u001a\u00020\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006#"}, d2 = {"Lcom/obric/oui/bouncelayout/BounceDebugEvent;", "", "viewName", "", "operation", "x", "", "y", "message", "timeMillis", "", "(Ljava/lang/String;Ljava/lang/String;FFLjava/lang/String;J)V", "getMessage", "()Ljava/lang/String;", "getOperation", "getTimeMillis", "()J", "getViewName", "getX", "()F", "getY", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toLogMessage", "toString", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f13360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f13361b;
    private final float c;
    private final float d;
    private final String e;
    private final long f;

    public c(String r2, String r3, float r4, float r5, String r6, long r7) {
        Intrinsics.checkNotNullParameter(r2, "viewName");
        Intrinsics.checkNotNullParameter(r3, "operation");
        Intrinsics.checkNotNullParameter(r6, "message");
        this.f13360a = r2;
        this.f13361b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }

    public /* synthetic */ c(String r11, String r12, float r13, float r14, String r15, long r16, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 32) == 0) goto L5;
        long r8 = SystemClock.uptimeMillis();
    L6:
        this(r11, r12, r13, r14, r15, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }

    public final String a() {
        return "view=" + this.f13360a + " operation=" + this.f13361b + " x=" + this.c + " y=" + this.d + " time=" + this.f + ' ' + this.e;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, c.class) == true) goto L8;
        return false;
    L8:
        c r8 = (c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f13360a, r8.f13360a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f13361b, r8.f13361b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(Float.valueOf(this.c), Float.valueOf(r8.c)) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(Float.valueOf(this.d), Float.valueOf(r8.d)) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r8.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r8.f) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.f13360a.hashCode() * 31) + this.f13361b.hashCode()) * 31) + Float.hashCode(this.c)) * 31) + Float.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + Long.hashCode(this.f);
    }

    public String toString() {
        return "BounceDebugEvent(viewName=" + this.f13360a + ", operation=" + this.f13361b + ", x=" + this.c + ", y=" + this.d + ", message=" + this.e + ", timeMillis=" + this.f + ')';
    }
}

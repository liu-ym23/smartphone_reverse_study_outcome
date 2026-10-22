package com.obric.aee.impl;

import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aee.res.b;
import com.tom_roush.pdfbox.pdmodel.a.d.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001Bg\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0002\u0010\u0013J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010*\u001a\u00020\rHÆ\u0003J\u0017\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012HÆ\u0003J}\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012HÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u000204HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001f\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00065"}, d2 = {"Lcom/obric/aee/impl/SessionInfo;", "", "serv", "Lcom/obric/aee/impl/EngineBridge$ServiceInfo;", "args", "Landroid/os/Bundle;", "ret", "context", WsConstants.KEY_EXTRA, "Lcom/obric/aee/impl/SafeBundle;", "pack", "Lcom/obric/aee/res/PackageInfo;", "startTime", "", "streamingCallback", "Lkotlin/Function1;", "", f.c, "Lkotlinx/coroutines/CancellableContinuation;", "(Lcom/obric/aee/impl/EngineBridge$ServiceInfo;Landroid/os/Bundle;Landroid/os/Bundle;Landroid/os/Bundle;Lcom/obric/aee/impl/SafeBundle;Lcom/obric/aee/res/PackageInfo;JLkotlin/jvm/functions/Function1;Lkotlinx/coroutines/CancellableContinuation;)V", "getArgs", "()Landroid/os/Bundle;", "getCb", "()Lkotlinx/coroutines/CancellableContinuation;", "getContext", "getExtra", "()Lcom/obric/aee/impl/SafeBundle;", "getPack", "()Lcom/obric/aee/res/PackageInfo;", "getRet", "getServ", "()Lcom/obric/aee/impl/EngineBridge$ServiceInfo;", "getStartTime", "()J", "getStreamingCallback", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Aee_cryptLiteRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EngineBridge.c f5886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bundle f5887b;
    private final Bundle c;
    private final Bundle d;
    private final SafeBundle e;
    private final b f;
    private final long g;
    private final Function1<Bundle, Unit> h;
    private final n<Unit> i;

    public a(EngineBridge.c r3, Bundle r4, Bundle r5, Bundle r6, SafeBundle r7, b r8, long r9, Function1<? super Bundle, Unit> r11, n<? super Unit> r12) {
        Function1<Bundle, Unit> r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        n<Unit> r14 = (n) ZeusTransformUtils.wrapperContextForParams(r12, n.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "args");
        Intrinsics.checkNotNullParameter(r5, "ret");
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r14, f.c);
        this.f5886a = r3;
        this.f5887b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r13;
        this.i = r14;
        if (r3 == null) goto L8;
        AtomicLong r2 = r3.d();
        if (r2 == null) goto L9;
        r2.set(SystemClock.elapsedRealtime());
        return;
    L9:
        return;
    }

    public final EngineBridge.c a() {
        return this.f5886a;
    }

    public final Bundle b() {
        return this.f5887b;
    }

    public final Bundle c() {
        return this.c;
    }

    public final SafeBundle d() {
        return this.e;
    }

    public final long e() {
        return this.g;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
        return false;
    L8:
        a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f5886a, r10.f5886a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f5887b, r10.f5887b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r10.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r10.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final Function1<Bundle, Unit> f() {
        return this.h;
    }

    public final n<Unit> g() {
        return this.i;
    }

    public final Bundle getContext() {
        return this.d;
    }

    public int hashCode() {
        EngineBridge.c r0 = this.f5886a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((((r2 * 31) + this.f5887b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        SafeBundle r4 = this.e;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        b r7 = this.f;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((r6 + r8) * 31) + Long.hashCode(this.g)) * 31;
        Function1<Bundle, Unit> r10 = this.h;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return ((r9 + r1) * 31) + this.i.hashCode();
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SessionInfo(serv=" + this.f5886a + ", args=" + this.f5887b + ", ret=" + this.c + ", context=" + this.d + ", extra=" + this.e + ", pack=" + this.f + ", startTime=" + this.g + ", streamingCallback=" + this.h + ", cb=" + this.i + ')';
    }
}

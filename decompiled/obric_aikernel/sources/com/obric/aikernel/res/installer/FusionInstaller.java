package com.obric.aikernel.res.installer;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.runtime.utils.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.h;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class FusionInstaller implements com.obric.aikernel.res.installer.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<com.obric.aikernel.res.installer.a> f5001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final w<List<com.obric.aikernel.res.installer.a.b>> f5002b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FusionInstaller(List<? extends com.obric.aikernel.res.installer.a> r10) {
        Intrinsics.checkNotNullParameter(r10, "installers");
        this.f5001a = r10;
        this.f5002b = y.b(null, 1, null);
    }

    public static final /* synthetic */ w d(FusionInstaller r10) {
        return r10.f5002b;
    }

    @Override // com.obric.aikernel.res.installer.a
    public void a(PrmContext r10) {
        com.obric.aikernel.res.installer.a.C0113a.b(this, r10);
    }

    @Override // com.obric.aikernel.res.installer.a
    public List<com.obric.aikernel.res.installer.a.b> b(PrmContext r14) {
        Intrinsics.checkNotNullParameter(r14, "context");
        long r10 = System.currentTimeMillis();
        d.f5417a.i("FusionInstaller", "installAllWithInfos start installerCount=" + this.f5001a.size());
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = this.f5001a.iterator();
    L4:
        if (r12.hasNext() == false) goto L16;
        com.obric.aikernel.res.installer.a r13 = (com.obric.aikernel.res.installer.a) r12.next();
        long r15 = System.currentTimeMillis();
        d.f5417a.i("FusionInstaller", "installAllWithInfos installer start tag=" + r13.tag());
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L8
        Object r17 = Result.m32constructorimpl(Boolean.valueOf(r11.addAll(r13.b(r14))));     // Catch: Throwable -> L8
    L10:
        Throwable r18 = Result.m35exceptionOrNullimpl(r17);
        if (r18 == null) goto L14;
        d.f5417a.f("FusionInstaller", "installAll: " + r13.tag() + " error: " + ExceptionsKt.stackTraceToString(r18));
    L14:
        if (Result.m39isSuccessimpl(r17) == false) goto L4;
        ((Boolean) r17).booleanValue();
        d.f5417a.i("FusionInstaller", "installAllWithInfos installer end tag=" + r13.tag() + " costMs=" + (System.currentTimeMillis() - r15));
    L8:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L10
    L16:
        this.f5002b.K(r11);
        d.f5417a.i("FusionInstaller", "installAllWithInfos end costMs=" + (System.currentTimeMillis() - r10) + " installDetailCount=" + r11.size());
        return r11;
    }

    @Override // com.obric.aikernel.res.installer.a
    public boolean c(PrmContext r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, WsConstants.KEY_CONNECTION_TYPE);
        Intrinsics.checkNotNullParameter(r13, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r14, "version");
        Iterator<T> r10 = this.f5001a.iterator();
    L4:
        if (r10.hasNext() == false) goto L22;
        com.obric.aikernel.res.installer.a r15 = (com.obric.aikernel.res.installer.a) r10.next();
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L8
        boolean r17 = r15.c(r11, r12, r13, r14);     // Catch: Throwable -> L8
        d.f5417a.i("FusionInstaller", "install: " + r12 + ' ' + r13 + '@' + r14 + " from " + r15.tag() + " is " + r17);     // Catch: Throwable -> L8
        Object r18 = Result.m32constructorimpl(Boolean.valueOf(r17));     // Catch: Throwable -> L8
    L10:
        Throwable r19 = Result.m35exceptionOrNullimpl(r18);
        if (r19 == null) goto L14;
        d.f5417a.f("FusionInstaller", "install: " + r12 + ' ' + r13 + '@' + r14 + " from " + r15.tag() + " error: " + ExceptionsKt.stackTraceToString(r19));
    L14:
        if (Result.m38isFailureimpl(r18) == false) goto L16;
        r18 = null;
    L16:
        Boolean r20 = (Boolean) r18;
        if (r20 == null) goto L4;
        if (r20.booleanValue() == false) goto L4;
        return true;
    L8:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r18 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L10
    L22:
        return false;
    }

    public final void e(Function2<? super List<com.obric.aikernel.res.installer.a.b>, ? super Continuation<? super Unit>, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "task");
        h.d(m0.a(z0.b()), null, null, new FusionInstaller$executeInitTask$1(r10, this, null), 3, null);
    }

    @Override // com.obric.aikernel.res.installer.a
    public String tag() {
        return "FusionInstaller";
    }
}

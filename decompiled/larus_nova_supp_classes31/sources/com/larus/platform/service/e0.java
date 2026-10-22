package com.larus.platform.service;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.larus.platform.api.creation.CreateCreationSource;
import com.larus.platform.api.creation.CreationFeedCacheEntity;
import com.larus.platform.api.creation.PublisherCreation;
import com.larus.platform.api.creation.PublisherTrackParams;
import com.larus.uaigc.createpage.component.input.CreationInputComponent$tryShowUpdateDialog$1;
import gs9.c;
import gs9.g;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zp9.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e0 implements com.larus.platform.api.g2 {
    public static final e0 a = null;
    public static final Lazy b = null;

    public e0() {
    }

    static {
        a = new e0();
        b = LazyKt.lazy(new d0());
    }

    public static com.larus.platform.api.g2 m() {
        return (com.larus.platform.api.g2) b.getValue();
    }

    @Override // com.larus.platform.api.g2
    public final void d1() {
        com.larus.platform.api.g2 r0 = m();
        if (r0 == null) goto L6;
        r0.d1();
        return;
    }

    @Override // com.larus.platform.api.g2
    public final void f() {
        com.larus.platform.api.g2 r0 = m();
        if (r0 == null) goto L6;
        r0.f();
        return;
    }

    @Override // com.larus.platform.api.g2
    public final boolean j() {
        com.larus.platform.api.g2 r0 = m();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.j() != true) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.g2
    public final void X0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "creationId");
        com.larus.platform.api.g2 r0 = m();
        if (r0 == null) goto L6;
        r0.X0(r2);
        return;
    }

    @Override // com.larus.platform.api.g2
    public final void c1(r r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        com.larus.platform.api.g2 r0 = m();
        if (r0 == null) goto L6;
        r0.c1(r2);
        return;
    }

    @Override // com.larus.platform.api.g2
    public final void e1(r r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        com.larus.platform.api.g2 r0 = m();
        if (r0 == null) goto L6;
        r0.e1(r2);
        return;
    }

    @Override // com.larus.platform.api.g2
    public final void g1(PublisherCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "publisherCreation");
        com.larus.platform.api.g2 r0 = m();
        if (r0 == null) goto L6;
        r0.g1(r2);
        return;
    }

    @Override // com.larus.platform.api.g2
    public final kotlinx.coroutines.flow.i1<CreationFeedCacheEntity> i1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "creationRecommendType");
        com.larus.platform.api.g2 r0 = m();
        if (r0 == null) goto L7;
        kotlinx.coroutines.flow.i1<CreationFeedCacheEntity> r3 = r0.i1(r2);
        if (r3 == null) goto L7;
        return r3;
    L7:
        return kotlinx.coroutines.flow.j1.a(null);
    }

    @Override // com.larus.platform.api.g2
    public final g a(c r2, gs9.d r3) {
        Intrinsics.checkNotNullParameter(r2, "initConfig");
        Intrinsics.checkNotNullParameter(r3, "creationPagerInitParams");
        com.larus.platform.api.g2 r0 = m();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(r2, r3);
    }

    @Override // com.larus.platform.api.g2
    public final void a1(PublisherCreation r2, PublisherTrackParams r3) {
        Intrinsics.checkNotNullParameter(r2, "publisherCreation");
        Intrinsics.checkNotNullParameter(r3, "publisherTrackParams");
        com.larus.platform.api.g2 r0 = m();
        if (r0 == null) goto L6;
        r0.a1(r2, r3);
        return;
    }

    @Override // com.larus.platform.api.g2
    public final CreationFeedCacheEntity b1(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "creationRecommendType");
        com.larus.platform.api.g2 r0 = m();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b1(r2, r3);
    }

    @Override // com.larus.platform.api.g2
    public final Object g(String r2, Continuation<? super Pair<Boolean, String>> r3) {
        com.larus.platform.api.g2 r0 = m();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.g(r2, r3);
    }

    @Override // com.larus.platform.api.g2
    public final Object b(String r2, boolean r3, Continuation<? super Pair<Boolean, String>> r4) {
        com.larus.platform.api.g2 r0 = m();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.b(r2, r3, r4);
    }

    @Override // com.larus.platform.api.g2
    public final void e(int r2, boolean r3, Function1<? super Boolean, Unit> r4) {
        com.larus.platform.api.g2 r0 = m();
        if (r0 == null) goto L6;
        r0.e(r2, r3, r4);
        return;
    }

    @Override // com.larus.platform.api.g2
    public final Object h(String r2, int r3, Continuation<? super Pair<Boolean, String>> r4) {
        com.larus.platform.api.g2 r0 = m();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.h(r2, r3, r4);
    }

    @Override // com.larus.platform.api.g2
    public final Object i(String r2, Map<String, String> r3, Continuation<? super Unit> r4) {
        com.larus.platform.api.g2 r0 = m();
        if (r0 == null) goto L10;
        Object r5 = r0.i(r2, r3, r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r5;
    L8:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    @Override // com.larus.platform.api.g2
    public final Object h1(String r2, String r3, String r4, Continuation<? super Unit> r5) {
        com.larus.platform.api.g2 r0 = m();
        if (r0 == null) goto L10;
        Object r6 = r0.h1(r2, r3, r4, r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r6;
    L8:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    @Override // com.larus.platform.api.g2
    public final Object k(String r2, String r3, String r4, ContinuationImpl r5) {
        com.larus.platform.api.g2 r0 = m();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.k(r2, r3, r4, r5);
    }

    @Override // com.larus.platform.api.g2
    public final Object c(Long r7, Long r8, String r9, Integer r10, ContinuationImpl r11) {
        com.larus.platform.api.g2 r0 = m();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.c(r7, r8, r9, r10, r11);
    }

    @Override // com.larus.platform.api.g2
    public final boolean Y0(int r10, FragmentManager r11, String r12, String r13, boolean r14, Integer r15, CreationInputComponent$tryShowUpdateDialog$1.a r16) {
        Intrinsics.checkNotNullParameter(r11, "fragmentManager");
        Intrinsics.checkNotNullParameter(r12, "enterMethod");
        com.larus.platform.api.g2 r1 = m();
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.Y0(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // com.larus.platform.api.g2
    public final void d(Context r10, nr9.g r11, String r12, String r13, String r14, String r15, Map<String, String> r16) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "videoPlayData");
        com.larus.platform.api.g2 r1 = m();
        if (r1 == null) goto L6;
        r1.d(r10, r11, r12, r13, r14, r15, r16);
        return;
    }

    @Override // com.larus.platform.api.g2
    public final Object l(String r10, int r11, String r12, int r13, String r14, @CreateCreationSource int r15, String r16, Continuation<? super zp9.a> r17) {
        com.larus.platform.api.g2 r0 = m();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.l(r10, r11, r12, r13, r14, r15, r16, r17);
    }
}

package com.bytedance.forest.preload;

import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
final class PreLoader$preload$delegate$1 extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f4563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.forest.utils.a f4564b;

    public PreLoader$preload$delegate$1(d r5, com.bytedance.forest.utils.a r10) {
        this.f4563a = r5;
        this.f4564b = r10;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        s6.c r5 = this.f4563a.f4570a;
        com.bytedance.forest.utils.a r10 = this.f4564b;
        r5.getClass();
        ArrayList r11 = (ArrayList) r5.f21829c;
        monitor-enter(r11);
        f r12 = r5.l(r10);     // Catch: Throwable -> L25
        ArrayList r13 = (ArrayList) r5.f21829c;     // Catch: Throwable -> L25
        if (r13 == null) goto L28;
        TypeIntrinsics.asMutableCollection(r13).remove(r12);     // Catch: Throwable -> L25
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r11);
        s6.c r15 = this.f4563a.f4570a;
        LinkedList r16 = (LinkedList) r15.f21828b;
        monitor-enter(r16);
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L12
        Object r18 = Result.m124constructorimpl((f) ((LinkedList) r15.f21828b).removeLast());     // Catch: Throwable -> L12
    L15:
        if (Result.m130isFailureimpl(r18) == false) goto L17;
        r18 = null;
    L17:
        f r19 = (f) r18;     // Catch: Throwable -> L22
        monitor-exit(r16);
        if (r19 == null) goto L21;
        this.f4563a.d(r19.f4574a, r19.f4575b);
    L21:
        return r14;
    L12:
        th = move-exception;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L22
        r18 = Result.m124constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    L28:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }
}

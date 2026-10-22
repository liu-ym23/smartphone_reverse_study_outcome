package com.larus.ugc.feed.impl.detail.ability;

import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.im.internal.delegate.c0;
import com.larus.platform.api.creation.UserCreation;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreationDetailBottomToolsAbilityImpl implements h0a.b {
    public static final /* synthetic */ int f = 0;
    public final CoroutineScope a;
    public final t0a.a b;
    public final l0a.a c;
    public i0a.a d;
    public i0a.b e;

    public static final class a {
    }

    static {
    }

    public final Object c(Continuation<? super Unit> r7) {
        if ((r7 instanceof CreationDetailBottomToolsAbilityImpl$toggleLike$1) == false) goto L7;
        CreationDetailBottomToolsAbilityImpl$toggleLike$1 r0 = (CreationDetailBottomToolsAbilityImpl$toggleLike$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        boolean r4 = r0.Z$0;
        String r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L23:
        boolean r9 = ((Boolean) r8).booleanValue();
        String r6 = r5;
    L26:
        if (r9 == false) goto L28;
        c0 r10 = c0.b;
        StringBuilder r11 = new StringBuilder("toggleLike success, like=");
        r11.append(!r4);
        r10.i("BottomToolsAbilityImpl", r11.toString());
    L30:
        return Unit.INSTANCE;
    L28:
        c0 r12 = c0.b;
        StringBuilder r13 = new StringBuilder("toggleLike failed, like=");
        r13.append(!r4);
        r13.append(", id=");
        r13.append(r6);
        r12.e("BottomToolsAbilityImpl", r13.toString());
        goto L30
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        boolean r14 = this.b.a().b;
        this.b.update(new com.larus.ugc.feed.impl.detail.ability.a());
        r6 = this.b.a().a;
        i0a.b r15 = this.e;
        if (r15 == null) goto L17;
        j0a.b r16 = r15.a;
    L18:
        if (r16 == null) goto L24;
        r0.L$0 = r6;
        r0.Z$0 = r14;
        r0.label = 1;
        Object r17 = r16.b(r6, !r14);
        if (r17 != r2) goto L22;
        return r2;
    L22:
        r4 = r14;
        r8 = r17;
        r5 = r6;
        goto L23
    L24:
        r4 = r14;
        r9 = false;
        goto L26
    L17:
        r16 = null;
    L7:
        r0 = new CreationDetailBottomToolsAbilityImpl$toggleLike$1(this, r7);
        goto L8
    }

    public final void b(final UserCreation r9, boolean r10) {
        this.b.update(new b(r9));
        if (r9 == null) goto L5;
        String r11 = r9.a;
    L6:
        if (r11 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == true) goto L15;
        BuildersKt.launch$default(this.a, Dispatchers.getDefault(), null, new CreationDetailBottomToolsAbilityImpl$initData$2(this, r11, r10, null), 2, null);
        return;
    L15:
        return;
    L8:
        if (r11.length() == 0) goto L11;
        r1 = false;
        goto L12
    L5:
        r11 = null;
        goto L6
    }

    public CreationDetailBottomToolsAbilityImpl(LifecycleCoroutineScope r2, t0a.a r3, l0a.a r4) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "stateHolder");
        Intrinsics.checkNotNullParameter(r4, "tracker");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}

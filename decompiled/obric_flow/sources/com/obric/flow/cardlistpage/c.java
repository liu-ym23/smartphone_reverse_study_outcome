package com.obric.flow.cardlistpage;

import androidx.room.CoroutinesRoom;
import com.obric.flow.cardlistpage.base.BaseCardModel;
import com.obric.flow.cardlistpage.data.CardDatabase;
import com.obric.flow.cardlistpage.data.g;
import com.obric.flow.cardlistpage.data.h;
import com.obric.flow.cardlistpage.data.j;
import com.obric.flow.cardlistpage.data.l;
import com.obric.flow.cardlistpage.data.n;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.ies.bullet.service.base.c f11462b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile c f11463c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.obric.flow.cardlistpage.data.a f11464a;

    static {
        f11462b = new com.bytedance.ies.bullet.service.base.c(9);
    }

    public c() {
        CardDatabase r5 = n.f11500a;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("db");
        r5 = null;
    L5:
        this.f11464a = r5.a();
    }

    public final Object a(BaseCardModel r5, ContinuationImpl r10) {
        Long r11 = r5.getCreateTime();
        if (r11 == null) goto L5;
        long r12 = r11.longValue();
    L6:
        j r13 = l.a(r5, Boxing.boxLong(r12), 2);
        h r14 = (h) this.f11464a;
        r14.getClass();
        g r15 = new g(r14, r13, 0);
        Object r16 = CoroutinesRoom.execute(r14.f11479a, true, r15, r10);
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r16;
    L10:
        return Unit.INSTANCE;
    L5:
        r12 = System.currentTimeMillis();
        goto L6
    }

    public final Object b(String r5, ContinuationImpl r10) {
        h r11 = (h) this.f11464a;
        r11.getClass();
        com.bytedance.android.anniex.ui.a r12 = new com.bytedance.android.anniex.ui.a(r11, r5, 8);
        Object r13 = CoroutinesRoom.execute(r11.f11479a, true, r12, r10);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r13;
    L6:
        return Unit.INSTANCE;
    }
}

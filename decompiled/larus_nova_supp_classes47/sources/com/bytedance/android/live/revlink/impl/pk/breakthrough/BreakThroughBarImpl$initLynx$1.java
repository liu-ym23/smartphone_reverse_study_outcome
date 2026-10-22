package com.bytedance.android.live.revlink.impl.pk.breakthrough;

import android.net.Uri;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.o;
import com.bytedance.android.live.revenue.common.u;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import com.bytedance.android.scope.m;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.revenue.platform.api.core.e;
import cy0.j;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import vy0.b;
import yy0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lyy0/c;", "", "invoke", "(Lyy0/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class BreakThroughBarImpl$initLynx$1 extends Lambda implements Function1<c, Unit> {
    final /* synthetic */ BreakThroughBarImpl this$0;

    public BreakThroughBarImpl$initLynx$1(BreakThroughBarImpl r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(c r6) {
        Intrinsics.checkNotNullParameter(r6, "$receiver");
        BreakThroughBarImpl r0 = this.this$0;
        int r1 = BreakThroughBarImpl.v;
        r0.getClass();
        int r2 = e.a;
        Uri.Builder r3 = e.a(r0.a).buildUpon();
        IBaseUser r4 = r0.r.getRoomContext().getCommonRoom().getOwnerKt();
        String r5 = null;
        if (r4 == null) goto L5;
        String r7 = r4.getIdString();
    L6:
        r3.appendQueryParameter("anchor_id", r7);
        IBaseUser r8 = r0.r.getRoomContext().getCommonRoom().getOwnerKt();
        if (r8 == null) goto L9;
        Intrinsics.checkNotNullParameter(r8, "$this$secUidExt");
        r5 = r8.getCastSecUid();
    L9:
        r3.appendQueryParameter("sec_anchor_id", r5);
        r3.appendQueryParameter("user_id", r0.r.getRoomContext().getCommonUser().getIdString());
        r3.appendQueryParameter("sec_user_id", o.a(r0.r.getRoomContext().getCommonUser()));
        r3.appendQueryParameter("room_id", r0.r.getRoomContext().getCommonRoom().getIdStr());
        cy0.e.a.getClass();
        j r9 = cy0.e.a.a;
        m.e.getClass();
        Object r10 = m.b(r9).a(Reflection.getOrCreateKotlinClass(b.class));
        Intrinsics.checkNotNull(r10);
        String r12 = ((b) ((f80.a) r10)).appendCommonParams(r3.build().toString());
        HybridType r13 = HybridType.LYNX;
        BreakThroughBarImpl r14 = this.this$0;
        r14.getClass();
        String r15 = UriProtector.getQueryParameter(e.a(r14.a), "fallback_url");
        if (r15 != null) goto L12;
        r15 = "";
    L12:
        r6.e(r12, r13, u.c(r15, u.d()));
        r6.d(new AnonymousClass1(this));
        return;
    L5:
        r7 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((c) r1);
        return Unit.INSTANCE;
    }
}

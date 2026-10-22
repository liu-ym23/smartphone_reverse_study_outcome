package com.bytedance.android.livesdk.dislike.action;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k extends OptionAction {
    public final int e;
    public final ActionsManager f;

    public k(ActionsManager r2) {
        Intrinsics.checkNotNullParameter(r2, "actionsManager");
        super(r2);
        this.f = r2;
        this.e = 6;
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r4) {
        Intrinsics.checkNotNullParameter(r4, "v");
        Room r5 = this.f.d;
        if (r5 == null) goto L5;
        long r0 = r5.id;
    L6:
        com.bytedance.android.live.base.model.user.o.a(jc1.k.n(IUserService.class).user().b());
        Room r6 = this.f.d;
        if (r6 == null) goto L12;
        User r7 = r6.getOwner();
        if (r7 == null) goto L12;
        String r8 = r7.getCastSecUid();
        if (r8 == null) goto L12;
    L13:
        qt1.b.a();
        com.bytedance.android.livesdk.dislike.m r2 = this.f.c;
        if (r2 == null) goto L19;
        Context r3 = r2.getContext();
        if (r3 == null) goto L20;
        qt1.b.c(r0, r8, r3);
        return;
    L20:
        return;
    L19:
        return;
    L12:
        r8 = "";
        goto L13
    L5:
        r0 = 0;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void d(Function1<? super Map<String, ? extends Object>, Unit> r1) {
        String r2 = qt1.b.a;
        qt1.b.b(this.e);
    }
}

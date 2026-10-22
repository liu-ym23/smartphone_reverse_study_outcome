package com.bytedance.android.livesdk.gift.platform.business.pkTray;

import com.bytedance.android.live.revlink.api.ILinkService;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements com.bytedance.android.scope.o {
    public q a;
    public final CompositeDisposable b;
    public final a c;
    public final i12.e d;

    public static final class a<T> implements Observer {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            gt1.d r6 = (gt1.d) r5;
            String r0 = null;
            if (r6 == null) goto L5;
            Integer r7 = Integer.valueOf(r6.f);
        L6:
            if (r7 != null) goto L9;
        L19:
            if (r7 != null) goto L22;
            return;
        L22:
            if (r7.intValue() != 0) goto L53;
            c r8 = this.a;
            if (r8.a == null) goto L26;
            return;
        L26:
            if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.e.B.getValue(null, com.bytedance.android.livesdk.gift.platform.business.e.a[26])).booleanValue() == false) goto L58;
            i12.e r1 = r8.d;
            if (com.bytedance.android.scope.l.b(r1) == true) goto L32;
            r1 = null;
        L32:
            if (r1 == null) goto L55;
            q r2 = new q(r8.d);
            Intrinsics.checkNotNullParameter(r2, "scope");
            Object r3 = e33.k.a;
            if (r2.e != r3) goto L37;
            r0 = "context";
        L48:
            if (r0 != null) goto L51;
            com.bytedance.android.scope.l.a(r2);
            Unit r4 = Unit.INSTANCE;
            r8.a = r2;
            return;
        L51:
            throw new UninitializedPropertyAccessException(r0);
        L37:
            if (r2.f != r3) goto L40;
            r0 = "dataCenter";
            goto L48
        L40:
            if (r2.g != r3) goto L43;
            r0 = "isInLive";
            goto L48
        L43:
            if (r2.h != r3) goto L46;
            r0 = "roomContext";
            goto L48
        L46:
            if (r2.i != r3) goto L48;
            r0 = "roomInstance";
            goto L48
        L55:
            return;
        L58:
            return;
        L53:
            return;
        L9:
            if (r7.intValue() != 1) goto L19;
            c r9 = this.a;
            com.bytedance.android.scope.j r10 = r9.a;
            if (r10 != null) goto L13;
        L18:
            r9.a = null;
            return;
        L13:
            if (com.bytedance.android.scope.l.b(r10) == true) goto L16;
            r10 = null;
        L16:
            if (r10 == null) goto L18;
            com.bytedance.android.scope.l.c(r10);
            goto L18
        L5:
            r7 = null;
            goto L6
        }
    }

    public final void onStart() {
        com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).registerPkStateChangeObserver(this.c);
    }

    public final void onStop() {
        this.b.clear();
        com.bytedance.android.scope.j r0 = this.a;
        if (r0 != null) goto L5;
    L10:
        this.a = null;
        com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).unRegisterPkStateChangeObserver(this.c);
        return;
    L5:
        if (com.bytedance.android.scope.l.b(r0) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        com.bytedance.android.scope.l.c(r0);
        goto L10
    }

    public c(i12.e r2) {
        Intrinsics.checkNotNullParameter(r2, "giftScope");
        this.d = r2;
        this.b = new CompositeDisposable();
        this.c = new a(this);
    }
}

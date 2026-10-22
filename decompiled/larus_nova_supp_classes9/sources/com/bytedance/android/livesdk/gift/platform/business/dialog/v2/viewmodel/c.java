package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel;

import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.f;
import com.bytedance.android.livesdk.gift.platform.business.g;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements Function1<GiftStateMachineConfig.Event, Boolean> {
    public final GiftContext a;

    public static final class a<T> implements Observer {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            GiftStateMachineConfig.g r5 = (GiftStateMachineConfig.g) r4;
            this.a.getClass();
            if ((r5 instanceof GiftStateMachineConfig.a.C0022a) == false) goto L26;
            GiftStateMachineConfig.a.C0022a r6 = (GiftStateMachineConfig.a.C0022a) r5;
            List<f> r1 = null;
            if (r6.b == null) goto L16;
            g r0 = com.bytedance.android.livesdk.gift.util.b.c(false);
            if (r0 == null) goto L9;
            r1 = r0.c();
        L9:
            if (r1 == null) goto L37;
            Iterator<T> r2 = r1.iterator();
        L12:
            if (r2.hasNext() == false) goto L39;
            f r3 = (f) r2.next();
            if (r3 == null) goto L12;
            f.a.a(r3, r6.b);
            goto L12
        L39:
            return;
        L37:
            return;
        L16:
            g r7 = com.bytedance.android.livesdk.gift.util.b.c(false);
            if (r7 == null) goto L19;
            r1 = r7.c();
        L19:
            if (r1 == null) goto L38;
            Iterator<T> r8 = r1.iterator();
        L22:
            if (r8.hasNext() == false) goto L40;
            f r9 = (f) r8.next();
            if (r9 == null) goto L22;
            f.a.a(r9, r6.a);
            goto L22
        L40:
            return;
        L38:
            return;
        }
    }

    public c(GiftContext r4) {
        Intrinsics.checkNotNullParameter(r4, "giftContext");
        this.a = r4;
        r4.getGiftActionManager().b().b(this);
        com.bytedance.android.livesdk.gift.util.b.d("GiftDialogViewModel", null, new a(this), true);
    }

    public final Object invoke(Object r21) {
        GiftStateMachineConfig.Event r0 = (GiftStateMachineConfig.Event) r21;
        Intrinsics.checkNotNullParameter(r0, "event");
        boolean r1 = false;
        g r2 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r2 == null) goto L5;
        List<f> r3 = r2.c();
    L6:
        if (r3 == null) goto L47;
        Iterator<T> r4 = r3.iterator();
    L9:
        if (r4.hasNext() == false) goto L47;
        f r5 = (f) r4.next();
        if (r5 == null) goto L9;
        if ((r0 instanceof GiftStateMachineConfig.Event.p) == false) goto L16;
        boolean r6 = f.a.a(r5, ((GiftStateMachineConfig.Event.p) r0).b);
    L44:
        if (r6 != true) goto L9;
        r1 = true;
        goto L47
    L16:
        if ((r0 instanceof GiftStateMachineConfig.Event.c) == false) goto L20;
        ((GiftStateMachineConfig.Event.c) r0).getClass();
        r5.n();
    L18:
        r6 = false;
        goto L44
    L20:
        if ((r0 instanceof GiftStateMachineConfig.Event.q) == false) goto L23;
        GiftStateMachineConfig.Event.q r7 = (GiftStateMachineConfig.Event.q) r0;
        r6 = f.a.b(r5, r7.b, r7.f, r7.e, false, null, r7.h, null, null, null, null, null, null, 8048);
        goto L44
    L23:
        if ((r0 instanceof GiftStateMachineConfig.Event.g) == false) goto L26;
        r5.d(((GiftStateMachineConfig.Event.g) r0).b);
        goto L18
    L26:
        if ((r0 instanceof GiftStateMachineConfig.Event.h) == false) goto L29;
        r5.c();
        goto L18
    L29:
        if ((r0 instanceof GiftStateMachineConfig.Event.l) == false) goto L32;
        r5.q();
        goto L18
    L32:
        if ((r0 instanceof GiftStateMachineConfig.Event.a0) == false) goto L35;
        AbsPanel<?> r8 = ((GiftStateMachineConfig.Event.a0) r0).b;
        r5.h();
        goto L18
    L35:
        if ((r0 instanceof GiftStateMachineConfig.Event.o) == false) goto L38;
        r6 = f.a.a(r5, null);
        goto L44
    L38:
        if ((r0 instanceof GiftStateMachineConfig.Event.d) == false) goto L41;
        r6 = f.a.a(r5, null);
        goto L44
    L41:
        if ((r0 instanceof GiftStateMachineConfig.Event.r) == false) goto L18;
        ((GiftStateMachineConfig.Event.r) r0).getClass();
        r6 = f.a.c(r5, null, 0, 0, null, false, null, null, null, null, null, 0, null, null, 24496);
    L47:
        return Boolean.valueOf(r1);
    L5:
        r3 = null;
        goto L6
    }
}

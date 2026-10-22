package com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.core.utils.x;
import com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.FormatGiftListViewModel;
import com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.FormatGiftPanelDialogViewModel;
import com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.FormatGiftReceiverViewModel;
import com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.FormatGiftTabViewModel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final int c() {
        q12.a r0 = q12.b.a;
        if (r0 == null) goto L5;
        Object r1 = m.e.d(r0, FormatGiftTabViewModel.class);
    L6:
        FormatGiftTabViewModel r2 = (FormatGiftTabViewModel) r1;
        if (r2 != null) goto L9;
    L15:
        return 0;
    L9:
        if ((r2.e.b() instanceof GiftStateMachineConfig.h.a) == false) goto L15;
        Object r3 = r2.e.b();
        if (r3 == null) goto L14;
        return ((GiftStateMachineConfig.h.a) r3).a;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.TabState.Tab");
    L5:
        r1 = null;
        goto L6
    }

    public static final FormatGiftPanelDialogViewModel f() {
        q12.a r0 = q12.b.a;
        if (r0 == null) goto L5;
        Object r1 = m.e.d(r0, FormatGiftPanelDialogViewModel.class);
    L7:
        return (FormatGiftPanelDialogViewModel) r1;
    L5:
        r1 = null;
        goto L7
    }

    public static final FormatGiftListViewModel h() {
        q12.a r0 = q12.b.a;
        if (r0 == null) goto L5;
        Object r1 = m.e.d(r0, FormatGiftListViewModel.class);
    L7:
        return (FormatGiftListViewModel) r1;
    L5:
        r1 = null;
        goto L7
    }

    public static final FormatGiftReceiverViewModel i() {
        q12.a r0 = q12.b.a;
        if (r0 == null) goto L5;
        Object r1 = m.e.d(r0, FormatGiftReceiverViewModel.class);
    L7:
        return (FormatGiftReceiverViewModel) r1;
    L5:
        r1 = null;
        goto L7
    }

    public static final AbsPanel<?> b() {
        FormatGiftPanelDialogViewModel r0 = f();
        if (r0 != null) goto L7;
        return null;
    L7:
        return ((GiftStateMachineConfig.a) r0.f.b()).a();
    }

    public static final w1 d() {
        FormatGiftListViewModel r0 = h();
        if (r0 == null) goto L5;
        List<w1> r1 = r0.h();
    L6:
        Iterator<w1> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        w1 r3 = r2.next();
        if (r3.getPageType() != c()) goto L8;
        return r3;
    L12:
        return null;
    L5:
        r1 = new ArrayList();
        goto L6
    }

    public static final GiftStateMachineConfig.a e() {
        FormatGiftPanelDialogViewModel r0 = f();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (GiftStateMachineConfig.a) r0.f.b();
    }

    public static final List<w1> g() {
        FormatGiftListViewModel r0 = h();
        if (r0 == null) goto L12;
        List<w1> r1 = r0.h();
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        Object r4 = r3.next();
        if (((w1) r4).getDisplay() == false) goto L6;
        r2.add(r4);
        goto L6
    L10:
        return r2;
    L12:
        return new ArrayList();
    }

    public static final List<IBaseUser> j() {
        FormatGiftReceiverViewModel r0 = i();
        if (r0 == null) goto L5;
        a r1 = (a) r0.f.b();
    L7:
        if ((r1 instanceof a.c) == false) goto L28;
        boolean r3 = false;
        if (a(2) == true) goto L11;
    L14:
        boolean r2 = false;
    L15:
        if (r2 == false) goto L24;
        FormatGiftReceiverViewModel r4 = i();
        if (r4 == null) goto L20;
        a r5 = (a) r4.f.b();
    L22:
        if ((r5 instanceof a.c) == false) goto L24;
        r3 = ((a.c) r5).e;
        goto L24
    L20:
        r5 = null;
    L24:
        if (r3 == false) goto L28;
        return ((a.c) r1).d;
    L11:
        if (a(4) == true) goto L14;
        r2 = true;
    L28:
        return null;
    L5:
        r1 = null;
        goto L7
    }

    public static final IBaseUser m() {
        IRoom r0 = x.a();
        if (r0 == null) goto L7;
        IBaseUser r1 = r0.getOwner();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return f.c(IBaseUser.class);
    }

    public static final boolean a(int r2) {
        FormatGiftReceiverViewModel r0 = i();
        if (r0 == null) goto L9;
        a r1 = (a) r0.f.b();
        if (r1 == null) goto L9;
        if ((r1 instanceof a.c) == false) goto L9;
        return !r1.b(r2).a.isEmpty();
    L9:
        return false;
    }

    public static final int k(int r3) {
        q12.a r0 = q12.b.a;
        if (r0 == null) goto L5;
        Object r1 = m.e.d(r0, FormatGiftTabViewModel.class);
    L6:
        FormatGiftTabViewModel r2 = (FormatGiftTabViewModel) r1;
        if (r2 != null) goto L9;
    L15:
        return 0;
    L9:
        if ((r2.e.b() instanceof GiftStateMachineConfig.h.a) == false) goto L15;
        Object r4 = r2.e.b();
        if (r4 == null) goto L14;
        return ((GiftStateMachineConfig.h.a) r4).a(r3);
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.TabState.Tab");
    L5:
        r1 = null;
        goto L6
    }

    public static final List<AbsPanel<?>> l(int r1) {
        FormatGiftListViewModel r0 = h();
        if (r0 == null) goto L7;
        return r0.g(r1);
    L7:
        return new ArrayList();
    }
}

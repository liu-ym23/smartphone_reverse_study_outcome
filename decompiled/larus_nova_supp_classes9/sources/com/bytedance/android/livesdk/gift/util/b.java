package com.bytedance.android.livesdk.gift.util;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.gift.platform.business.config.j;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftInRoomService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.OpenDialogService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u0;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.scope.m;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.k;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import i12.o;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final j a() {
        GiftContext r0 = b();
        if (r0 == null) goto L9;
        i<j> r1 = r0.getGiftConfigStore();
        if (r1 == null) goto L9;
        j r2 = (j) r1.getValue();
        if (r2 == null) goto L9;
        return r2;
    L9:
        return new com.bytedance.android.livesdk.gift.platform.business.config.c().create();
    }

    public static final GiftContext b() {
        i12.e r0 = o.b();
        if (r0 == null) goto L5;
        Object r1 = m.e.d(r0, GiftInRoomService.class);
    L6:
        GiftInRoomService r2 = (GiftInRoomService) r1;
        if (r2 == null) goto L15;
        Pair<GiftContext, ? extends Disposable> r3 = r2.b;
        if (r3 == null) goto L11;
        GiftContext r4 = (GiftContext) r3.getFirst();
    L12:
        if (r4 == null) goto L15;
    L24:
        return r4;
    L11:
        r4 = null;
    L15:
        i12.e r5 = o.a();
        if (r5 == null) goto L18;
        Object r6 = m.e.d(r5, GiftInRoomService.class);
    L19:
        GiftInRoomService r7 = (GiftInRoomService) r6;
        if (r7 == null) goto L25;
        Pair<GiftContext, ? extends Disposable> r8 = r7.b;
        if (r8 == null) goto L26;
        r4 = (GiftContext) r8.getFirst();
        goto L24
    L26:
        return null;
    L25:
        return null;
    L18:
        r6 = null;
        goto L19
    L5:
        r1 = null;
        goto L6
    }

    public static final com.bytedance.android.livesdk.gift.platform.business.g c(boolean r2) {
        Object r0 = null;
        if (r2 == false) goto L8;
        i12.e r3 = o.a();
        if (r3 == null) goto L13;
        r0 = m.e.d(r3, u0.class);
    L13:
        return (com.bytedance.android.livesdk.gift.platform.business.g) r0;
    L8:
        i12.e r4 = o.b();
        if (r4 == null) goto L12;
        r0 = m.e.d(r4, u0.class);
    L12:
        return (com.bytedance.android.livesdk.gift.platform.business.g) r0;
    }

    public static final void e(LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r3, "owner");
        GiftContext r1 = b();
        if (r1 == null) goto L12;
        i<Map<String, com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a>> r2 = r1.getGiftViewModelMap();
        if (r2 == null) goto L14;
        Map r4 = (Map) r2.getValue();
        if (r4 == null) goto L15;
        Iterator r5 = r4.entrySet().iterator();
    L10:
        if (r5.hasNext() == false) goto L16;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r6 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a) ((Map.Entry) r5.next()).getValue();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r3, "owner");
        r6.a.removeObservers(r3);
        goto L10
    L16:
        return;
    L15:
        return;
    L14:
        return;
    }

    public static final void f(GiftStateMachineConfig.Event r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if ((r5 instanceof GiftStateMachineConfig.Event.h) == false) goto L14;
        if (u.r() == true) goto L14;
        i12.e r0 = o.b();
        if (r0 == null) goto L9;
        Object r1 = m.e.d(r0, OpenDialogService.class);
    L10:
        OpenDialogService r2 = (OpenDialogService) r1;
        if (r2 == null) goto L14;
        OpenDialogService.d(r2, ((GiftStateMachineConfig.Event.h) r5).b, null, 2);
        goto L14
    L9:
        r1 = null;
    L14:
        if (r5.a == false) goto L16;
        jy0.b.d("GiftStateEvent", "GiftViewModelNew: " + r5.a());
    L16:
        GiftContext r3 = b();
        if (r3 == null) goto L22;
        k<GiftStateMachineConfig.Event> r4 = r3.getGiftActionManager();
        if (r4 == null) goto L23;
        r4.post(r5);
        return;
    L23:
        return;
    }

    public static final void d(String r1, LifecycleOwner r2, Observer<GiftStateMachineConfig.g> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r3, "observer");
        GiftContext r0 = b();
        if (r0 == null) goto L11;
        i<Map<String, com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a>> r5 = r0.getGiftViewModelMap();
        if (r5 == null) goto L11;
        Map r6 = (Map) r5.getValue();
        if (r6 == null) goto L11;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r7 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a) r6.get(r1);
        if (r7 == null) goto L11;
        GiftStateMachineConfig.g r8 = r7.c(r2, r3);
    L12:
        if (r4 == false) goto L16;
        if (r8 == null) goto L17;
        r3.onChanged(r8);
        return;
    L17:
        return;
    L16:
        return;
    L11:
        r8 = null;
        goto L12
    }
}

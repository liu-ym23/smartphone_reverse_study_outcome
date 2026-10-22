package com.bytedance.android.live.liveinteract.interactivesong.panel;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.interactivesong.logger.InteractiveSongLoggerKt;
import com.bytedance.android.livesdk.chatroom.model.interact.IMVTab;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ MvSelectDialog a;

    public e(MvSelectDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        final f r8 = (f) r7;
        int r0 = 1;
        String r2 = null;
        if (r8 == null) goto L26;
        List<i> r3 = r8.b;
        if (r3 == null) goto L26;
        if ((!r3.isEmpty()) != true) goto L26;
        MvSelectViewModel r4 = this.a.g;
        if (r4 == null) goto L11;
        i r5 = r4.getLastMvData();
    L12:
        if (r5 != null) goto L26;
        MvSelectViewModel r6 = this.a.g;
        if (r6 == null) goto L22;
        MutableLiveData<g> r9 = r6.getMvSelectUIState();
        if (r9 == null) goto L22;
        g r10 = (g) r9.getValue();
        if (r10 == null) goto L22;
        IMVTab r11 = r10.a;
        if (r11 == null) goto L22;
        String r12 = r11.getName();
    L24:
        if (Intrinsics.areEqual(r12, r8.a.getName()) == false) goto L26;
        ((i) ListProtector.get(r8.b, 0)).b = true;
        this.a.ea0((i) ListProtector.get(r8.b, 0));
    L22:
        r12 = null;
        goto L24
    L11:
        r5 = null;
    L26:
        MvSelectDialog r13 = this.a;
        String r14 = r8.a.getName();
        int r15 = MvSelectDialog.x;
        int r16 = r13.da0(r14);
        MvSelectPagerAdapter r17 = this.a.s;
        if (r17 == null) goto L30;
        r17.f(r8, r16, false, new MvSelectDialog$initObserver$5$1(this, r8));
    L30:
        if (r8.a.getName().length() <= 0) goto L32;
        boolean r18 = true;
    L33:
        if (r18 == false) goto L72;
        String r19 = r8.a.getName();
        MvSelectViewModel r20 = this.a.g;
        if (r20 == null) goto L43;
        MutableLiveData<g> r21 = r20.getMvSelectUIState();
        if (r21 == null) goto L43;
        g r22 = (g) r21.getValue();
        if (r22 == null) goto L43;
        IMVTab r23 = r22.a;
        if (r23 == null) goto L43;
        String r24 = r23.getName();
    L45:
        if (Intrinsics.areEqual(r19, r24) == false) goto L73;
        MvSelectDialog r25 = this.a;
        if (r25.u == false) goto L74;
        r25.u = false;
        MvSelectViewModel r26 = r25.g;
        if (r26 == null) goto L51;
        String r27 = r26.getItemId();
    L52:
        InteractiveSongContext r28 = InteractiveSongContext.Companion.getContext();
        if (r28 == null) goto L56;
        r2 = r28.getCurOrderSongItemId();
    L56:
        if (Intrinsics.areEqual(r27, r2) == false) goto L64;
        List<i> r29 = r8.b;
        if (r29 == null) goto L64;
        if (r29.isEmpty() == true) goto L64;
        if (((i) ListProtector.get(r8.b, 0)).c != 1) goto L64;
    L65:
        String r30 = r8.a.getName();
        MvSelectViewModel r1 = this.a.g;
        if (r1 == null) goto L69;
        String r31 = r1.getItemId();
        if (r31 == null) goto L69;
    L70:
        InteractiveSongLoggerKt.e(r30, r0, r31);
        return;
    L69:
        r31 = "";
    L64:
        r0 = 0;
        goto L65
    L51:
        r27 = null;
        goto L52
    L74:
        return;
    L73:
        return;
    L43:
        r24 = null;
        goto L45
    L72:
        return;
    L32:
        r18 = false;
        goto L33
    }
}

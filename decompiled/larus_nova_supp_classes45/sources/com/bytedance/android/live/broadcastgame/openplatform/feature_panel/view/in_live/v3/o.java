package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o<T> implements Observer {
    public final /* synthetic */ LiveOpenFeatureSearchFragmentV3 a;

    public o(LiveOpenFeatureSearchFragmentV3 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r9) {
        c20.c r11 = (c20.c) r9;
        LiveOpenFeatureSearchFragmentV3 r0 = this.a;
        ArrayList r2 = null;
        if (r11 == null) goto L14;
        List<c20.a> r12 = r11.c;
        if (r12 == null) goto L14;
        AbsOpenFeaturePanelViewModel r3 = r0.m;
        if (r3 == null) goto L12;
        LiveData<Integer> r4 = r3.getOpenFeatureTabIndexData();
        if (r4 == null) goto L12;
        Integer r5 = (Integer) r4.getValue();
        if (r5 == null) goto L12;
    L13:
        c20.a r13 = (c20.a) CollectionsKt.getOrNull(r12, r5.intValue());
    L15:
        r0.p = r13;
        LiveOpenFeatureSearchFragmentV3 r14 = this.a;
        c20.a r1 = r14.p;
        if (r1 != null) goto L18;
        return;
    L18:
        if (r1.a != 6) goto L57;
        AbsOpenFeaturePanelViewModel r15 = r14.m;
        if (r15 == null) goto L58;
        LiveData<List<f10.f>> r16 = r15.getOpenFeatureSearchResult();
        if (r16 == null) goto L59;
        List r17 = (List) r16.getValue();
        if (r17 == null) goto L60;
        c20.a r6 = this.a.p;
        if (r6 == null) goto L46;
        List<f10.f> r7 = r6.b;
        if (r7 == null) goto L46;
        r2 = new ArrayList();
        Iterator<T> r8 = r7.iterator();
    L31:
        if (r8.hasNext() == false) goto L46;
        T r18 = r8.next();
        f10.f r19 = (f10.f) r18;
        List r21 = r17;
        if ((r21 instanceof Collection) == true) goto L35;
    L37:
        Iterator<T> r22 = r21.iterator();
    L39:
        if (r22.hasNext() == false) goto L43;
        if (Intrinsics.areEqual(((ExtendedToolbarButton.c) ((f10.f) r22.next())).s, ((ExtendedToolbarButton.c) r19).s) == false) goto L39;
        boolean r23 = true;
    L44:
        if (r23 == false) goto L31;
        r2.add(r18);
    L43:
        r23 = false;
        goto L44
    L35:
        if (r21.isEmpty() == false) goto L37;
    L46:
        LiveOpenFeatureSearchFragmentV3.S90(this.a, r2);
        return;
    L60:
        return;
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L12:
        r5 = 0;
    L14:
        r13 = null;
        goto L15
    }
}

package com.bytedance.android.live.liveinteract.interactivesong.panel;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.chatroom.model.interact.IMVTab;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ MvSelectDialog a;

    public d(MvSelectDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r11) {
        List<String> r12 = (List) r11;
        MvSelectTabView r0 = this.a.j;
        if (r0 == null) goto L5;
        r0.setDataAndNotify(r12);
    L5:
        MvSelectDialog r1 = this.a;
        MvSelectTabView r2 = r1.j;
        if (r2 == null) goto L19;
        MvSelectViewModel r3 = r1.g;
        if (r3 == null) goto L17;
        MutableLiveData<g> r4 = r3.getMvSelectUIState();
        if (r4 == null) goto L17;
        g r5 = (g) r4.getValue();
        if (r5 == null) goto L17;
        IMVTab r6 = r5.a;
        if (r6 == null) goto L17;
        String r7 = r6.getName();
        if (r7 == null) goto L17;
    L18:
        r2.r(r7);
    L17:
        r7 = "";
    L19:
        MvSelectDialog r8 = this.a;
        MvSelectPagerAdapter r9 = r8.s;
        if (r9 == null) goto L32;
        Context r10 = r8.getContext();
        MvSelectDialog r13 = this.a;
        MvSelectViewModel r14 = r13.g;
        Intrinsics.checkNotNullParameter(r12, "tabs");
        Intrinsics.checkNotNullParameter(r13, "cb");
        if (r10 == null) goto L32;
        r9.b.clear();
        if (TypeIntrinsics.isMutableList(r12) == true) goto L27;
        List<String> r15 = null;
    L28:
        r9.a = r15;
        Iterator<T> r16 = r12.iterator();
    L30:
        if (r16.hasNext() == false) goto L32;
        IMVTab r17 = (IMVTab) r16.next();
        MvSelectListView r18 = new MvSelectListView(r10, null, 6, 0);
        Intrinsics.checkNotNullParameter(r17, "tabName");
        Intrinsics.checkNotNullParameter(r13, "cb");
        r18.a = r17;
        r18.f = r14;
        r18.e = r13;
        r9.b.add(r18);
        goto L30
    L27:
        r15 = r12;
    L32:
        MvSelectPagerAdapter r19 = this.a.s;
        if (r19 == null) goto L37;
        r19.notifyDataSetChanged();
        return;
    }
}

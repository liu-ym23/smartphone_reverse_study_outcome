package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.view.ViewGroup;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.model.e1;
import com.bytedance.android.livesdk.chatroom.model.k1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ LinkPanelTopBarWidget a;

    public q(LinkPanelTopBarWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        List r6 = ((e1) ((com.bytedance.android.live.network.response.e) r5).data).getInteractItems();
        int r0 = r6.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L20;
        if (((k1) ListProtector.get(r6, r2)).getNewArrival() == true) goto L7;
        r2 = r2 + 1;
        goto L3
    L7:
        if (((Boolean) b6.e.getValue()).booleanValue() == false) goto L16;
        ViewGroup r7 = this.a.b;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L11:
        r7.findViewById(2131385981).setBackground(s1.m(2131248695));
        ViewGroup r8 = this.a.b;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L14:
        r8.findViewById(2131385981).setVisibility(0);
        return;
    L16:
        return;
    }
}

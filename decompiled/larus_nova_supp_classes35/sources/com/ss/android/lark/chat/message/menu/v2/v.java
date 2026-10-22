package com.ss.android.lark.chat.message.menu.v2;

import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.AndroidThrottle;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class v implements n0 {
    public final /* synthetic */ MessageActionPanelManager<y6b.a<?>> a;
    public final /* synthetic */ RecyclerView.OnScrollListener b;
    public final /* synthetic */ MessageActionPanel c;
    public final /* synthetic */ RecyclerView.AdapterDataObserver d;
    public final /* synthetic */ g e;
    public final /* synthetic */ yya.n f;
    public final /* synthetic */ yya.a g;

    @Override // com.ss.android.lark.chat.message.menu.v2.n0
    public final void onDismiss() {
        com.ss.android.lark.chat.utils.u.a.a.a();
        Object r0 = this.a.b;
        yya.n r1 = this.f;
        s2b.c r2 = (s2b.c) r0;
        r2.getClass();
        r1.d();
        r2.e.b();
        RecyclerView r3 = this.a.c;
        if (r3 == null) goto L5;
        r3.removeOnScrollListener(this.b);
    L5:
        this.g.getClass();
        MessageActionPanelManager<y6b.a<?>> r4 = this.a;
        r4.k = null;
        r4.h = null;
        r4.o = null;
        ((AndroidThrottle) r4.x.getValue()).b();
        MessageActionPanelManager<y6b.a<?>> r5 = this.a;
        r5.p = false;
        RecyclerView r6 = r5.c;     // Catch: Exception -> L12
        if (r6 == null) goto L17;
        RecyclerView.Adapter r7 = r6.getAdapter();     // Catch: Exception -> L12
        if (r7 == null) goto L18;
        r7.unregisterAdapterDataObserver(this.d);     // Catch: Exception -> L12
        return;
    L18:
        return;
    L17:
        return;
    L12:
        e = move-exception;
        Log.e(this.a.g, "remove data observer, throws exception, e = " + e.getMessage() + ' ');
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.n0
    public final void onShow() {
        RecyclerView r0 = this.a.c;
        if (r0 == null) goto L5;
        r0.addOnScrollListener(this.b);
    L5:
        MessageActionPanelManager<y6b.a<?>> r1 = this.a;
        r1.h = this.c;
        r1.getClass();
        MessageActionPanelManager<y6b.a<?>> r2 = this.a;
        r2.p = false;
        ((s2b.c) r2.b).a(true);
        com.ss.android.lark.chat.utils.u.a.a.e = true;
        RecyclerView r3 = this.a.c;     // Catch: Exception -> L12
        if (r3 == null) goto L17;
        RecyclerView.Adapter r4 = r3.getAdapter();     // Catch: Exception -> L12
        if (r4 == null) goto L18;
        r4.registerAdapterDataObserver(this.d);     // Catch: Exception -> L12
        return;
    L18:
        return;
    L17:
        return;
    L12:
        e = move-exception;
        Log.e(this.a.g, "add observer, throw exception, e = " + e.getMessage());
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.n0
    public final void a(PanelType r2, PanelType r3) {
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, "to");
        if (r3 != PanelType.EMOJI) goto L6;
        this.e.b();
        return;
    }

    public v(MessageActionPanelManager r1, MessageActionPanelManager$createOnScrollListener$1 r2, MessageActionPanel r3, y6b.a r4, MessageActionPanelManager$createAdapterDataObserver$1 r5, u r6, com.ss.android.lark.chat.message.menu.context.a r7, s2b.b r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}

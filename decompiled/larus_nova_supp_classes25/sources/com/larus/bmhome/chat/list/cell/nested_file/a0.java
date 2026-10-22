package com.larus.bmhome.chat.list.cell.nested_file;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.layout.item.u1;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.trace.tracknode.TraceFragment;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a0 implements lr8.a {
    public final /* synthetic */ NewNestedFileCell a;
    public final /* synthetic */ Message b;
    public final /* synthetic */ NestedFileContent c;
    public final /* synthetic */ BaseResourceViewHolder.a d;

    public final void a() {
        u7 r0 = (u7) this.a.k.getValue();
        if (r0 == null) goto L5;
        r0.C90();
    L5:
        u1 r1 = this.a.e;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("newNestedFileBox");
        r1 = null;
    L8:
        r1.n(this.b, this.c, this.d);
    }

    public final CoroutineScope c() {
        NewNestedFileCell r0 = this.a;
        int r1 = NewNestedFileCell.s;
        return (CoroutineScope) r0.p.getValue();
    }

    public final com.larus.trace.tracknode.a f() {
        TraceFragment r0 = lf8.a.d(this.a);
        if ((r0 instanceof TraceFragment) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    public final q0 getAdapter() {
        return lf8.a.b(this.a);
    }

    public final FragmentManager getFragmentManager() {
        Fragment r0 = lf8.a.d(this.a);
        if (r0 == null) goto L7;
        FragmentActivity r1 = r0.getActivity();
        if (r1 == null) goto L7;
        return r1.getSupportFragmentManager();
    L7:
        return null;
    }

    public final wc9.e h() {
        NewNestedFileCell r0 = this.a;
        int r1 = NewNestedFileCell.s;
        com.larus.bmhome.chat.component.cvs.y r2 = r0.r();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.h();
    }

    public final BotModel i() {
        return this.a.f;
    }

    public final boolean i0() {
        com.larus.bmhome.chat.component.collection.o r0 = (com.larus.bmhome.chat.component.collection.o) this.a.r.getValue();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.i0() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public a0(NewNestedFileCell r1, Message r2, NestedFileContent r3, BaseResourceViewHolder.a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}

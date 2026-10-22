package com.larus.bmhome.chat.list.cell.text.user;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.im.bean.bot.BotModel;
import com.larus.trace.tracknode.TraceFragment;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class UserTextCell$d implements lr8.a {
    public final /* synthetic */ UserTextCell a;

    public final void a() {
        u7 r0 = (u7) this.a.q.getValue();
        if (r0 == null) goto L6;
        r0.C90();
        return;
    }

    public final CoroutineScope c() {
        Fragment r0 = lf8.a.d(this.a);
        if (r0 == null) goto L9;
        LiveData r1 = r0.getViewLifecycleOwnerLiveData();
        if (r1 == null) goto L9;
        LifecycleOwner r2 = (LifecycleOwner) r1.getValue();
        if (r2 == null) goto L9;
        return LifecycleOwnerKt.getLifecycleScope(r2);
    L9:
        return null;
    }

    public final com.larus.trace.tracknode.a f() {
        TraceFragment r0 = lf8.a.d(this.a);
        if ((r0 instanceof TraceFragment) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    public final com.larus.bmhome.chat.api.q0 getAdapter() {
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
        UserTextCell r0 = this.a;
        int r1 = UserTextCell.z;
        com.larus.bmhome.chat.component.cvs.y r2 = r0.B();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.h();
    }

    public final BotModel i() {
        UserTextCell r0 = this.a;
        int r1 = UserTextCell.z;
        com.larus.bmhome.chat.component.cvs.y r2 = r0.B();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.j0();
    }

    public final boolean i0() {
        UserTextCell r0 = this.a;
        int r1 = UserTextCell.z;
        com.larus.bmhome.chat.component.collection.o r2 = (com.larus.bmhome.chat.component.collection.o) r0.t.getValue();
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.i0() != true) goto L7;
        return true;
    }

    public UserTextCell$d(UserTextCell r1) {
        this.a = r1;
    }
}

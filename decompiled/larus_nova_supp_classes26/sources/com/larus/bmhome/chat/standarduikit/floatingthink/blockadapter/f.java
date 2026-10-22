package com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f implements lr8.a {
    public final /* synthetic */ ClarificationAnswerDetailFragment a;

    @Override // lr8.a
    public final void a() {
    }

    @Override // lr8.a
    public final com.larus.trace.tracknode.a f() {
        return null;
    }

    @Override // lr8.a
    public final /* bridge */ /* synthetic */ q0 getAdapter() {
        return null;
    }

    @Override // lr8.a
    public final /* bridge */ /* synthetic */ wc9.e h() {
        return null;
    }

    @Override // lr8.a
    public final boolean i0() {
        return true;
    }

    @Override // lr8.a
    public final CoroutineScope c() {
        LifecycleOwner r0 = (LifecycleOwner) this.a.getViewLifecycleOwnerLiveData().getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return LifecycleOwnerKt.getLifecycleScope(r0);
    }

    @Override // lr8.a
    public final FragmentManager getFragmentManager() {
        FragmentActivity r0 = this.a.getActivity();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSupportFragmentManager();
    }

    @Override // lr8.a
    public final BotModel i() {
        kc8.y r1 = this.a.g;
        if (r1 == null) goto L8;
        Function0 r2 = r1.l;
        if (r2 == null) goto L8;
        BotModel r3 = (BotModel) r2.invoke();
        if (r3 == null) goto L8;
    L15:
        return r3;
    L8:
        Message r4 = this.a.h;
        if (r4 == null) goto L11;
        String r5 = r4.getSenderId();
    L12:
        if (r5 != null) goto L14;
        r5 = "";
    L14:
        r3 = new BotModel(r5, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
        goto L15
    L11:
        r5 = null;
        goto L12
    }

    public f(ClarificationAnswerDetailFragment r1) {
        this.a = r1;
    }
}

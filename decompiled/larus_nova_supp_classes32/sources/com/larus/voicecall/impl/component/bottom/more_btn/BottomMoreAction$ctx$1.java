package com.larus.voicecall.impl.component.bottom.more_btn;

import androidx.fragment.app.Fragment;
import com.larus.av_call.util.RealtimeBottomMoreBtn;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class BottomMoreAction$ctx$1 implements d {
    public final Function1<c, Unit> a;
    public final /* synthetic */ b b;
    public final /* synthetic */ w3a.k c;

    @Override // com.larus.voicecall.impl.component.bottom.more_btn.d
    public final t1a.b b() {
        Fragment r0 = this.b.a;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == true) goto L11;
        return null;
    L11:
        return this.b.b;
    L5:
        if (r0.isAdded() != true) goto L7;
        r1 = true;
        goto L7
    }

    @Override // com.larus.voicecall.impl.component.bottom.more_btn.d
    public final Fragment getFragment() {
        Fragment r0 = this.b.a;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == true) goto L11;
        return null;
    L11:
        return this.b.a;
    L5:
        if (r0.isAdded() != true) goto L7;
        r1 = true;
        goto L7
    }

    @Override // com.larus.voicecall.impl.component.bottom.more_btn.d
    public final RealtimeBottomMoreBtn getHostView() {
        return (RealtimeBottomMoreBtn) this.b.c.invoke();
    }

    @Override // com.larus.voicecall.impl.component.bottom.more_btn.d
    public final Function1<c, Unit> a() {
        return this.a;
    }

    @Override // com.larus.voicecall.impl.component.bottom.more_btn.d
    public final w3a.k c() {
        return this.c;
    }

    public BottomMoreAction$ctx$1(b r1, w3a.k r2) {
        this.b = r1;
        this.c = r2;
        this.a = new BottomMoreAction$ctx$1$transTo$1(r1);
    }
}

package com.larus.voicecall.impl.component.bottom.more_btn;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import com.larus.av_call.model.RealtimePageMode;
import com.larus.av_call.util.RealtimeBottomMoreBtn;
import com.larus.voicecall.impl.scene.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class MoreBtnSceneState extends c {
    public final String c;
    public boolean d;
    public final MoreBtnSceneState$sceneObserver$1 e;

    @Override // com.larus.voicecall.impl.component.bottom.more_btn.c
    public final void d() {
    }

    public final com.larus.voicecall.impl.component.scene.a j() {
        t1a.b r0 = this.a.b();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (com.larus.voicecall.impl.component.scene.a) r0.o(Reflection.getOrCreateKotlinClass(com.larus.voicecall.impl.component.scene.a.class));
    }

    @Override // com.larus.voicecall.impl.component.bottom.more_btn.c
    public final void e() {
        super.e();
        Fragment r0 = this.a.getFragment();
        if (r0 == null) goto L10;
        this.d = true;
        com.larus.voicecall.impl.component.scene.a r1 = j();
        if (r1 == null) goto L11;
        LiveData<m> r2 = r1.getCurrentScene();
        if (r2 == null) goto L12;
        r2.observe(r0, this.e);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.larus.voicecall.impl.component.bottom.more_btn.c
    public final void f() {
        super.f();
        RealtimeBottomMoreBtn r0 = this.a.getHostView();
        if (r0 == null) goto L5;
        r0.setBackground(null);
    L5:
        w3a.k r1 = this.a.c();
        if (r1 == null) goto L9;
        RealtimePageMode r2 = RealtimePageMode.HALF_SCREEN;
        int r3 = w3a.k.g;
        r1.b(r2, 0);
        return;
    }

    @Override // com.larus.voicecall.impl.component.bottom.more_btn.c
    public final String b() {
        return this.c;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.voicecall.impl.component.bottom.more_btn.MoreBtnSceneState$sceneObserver$1] */
    public MoreBtnSceneState(final d r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.c = "MoreBtnSceneState";
        this.e = new MoreBtnSceneState$sceneObserver$1(this, r2);
    }

    @Override // com.larus.voicecall.impl.component.bottom.more_btn.c
    public final void c(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        if (this.a.getFragment() == null) goto L9;
        com.larus.voicecall.impl.component.scene.a r4 = j();
        if (r4 == null) goto L9;
        LiveData<m> r5 = r4.getCurrentScene();
        if (r5 == null) goto L9;
        r5.removeObserver(this.e);
    L9:
        com.larus.voicecall.impl.component.scene.a r6 = j();
        if (r6 == null) goto L12;
        r6.Ii(this.c + "_click_exit_scene");
    L12:
        Function1<c, Unit> r7 = this.a.a();
        if (r7 == null) goto L16;
        r7.invoke(new k(this.a));
        return;
    }
}

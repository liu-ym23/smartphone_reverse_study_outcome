package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.interactivity.comment.newinput.view.AudioComposePageViewPager;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<Audio2TextSectionController, Object> {
    public static final C0125a f = null;
    public final InputSectionType a;
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g b;
    public Audio2TextSectionController c;
    public final c d;
    public View e;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.comment.newinput.provider.a$a, reason: collision with other inner class name */
    public static final class C0125a {
        public C0125a() {
        }
    }

    public static final class b {
    }

    public static final class c {
        public c() {
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void g(boolean r1) {
    }

    static {
        f = new C0125a();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void a() {
        if (((fc2.e) ec2.f0.a.getValue()).a() == false) goto L12;
        f72.a.b("on Audio2text Section Switch off");
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.b;
        if (r0 == null) goto L13;
        com.bytedance.android.livesdk.interactivity.comment.audio.c r1 = r0.c;
        if (r1 == null) goto L14;
        r1.n.set(0);
        mf2.a r2 = r1.c.getAndSet(null);
        if (r2 == null) goto L15;
        r2.b();
        com.bytedance.android.livesdk.interactivity.comment.audio.c.b(r2);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void d() {
        Audio2TextSectionController r0 = this.c;
        if (r0 == null) goto L8;
        MainThreadPostUtils.d((Runnable) r0.g.getValue());
        MainThreadPostUtils.d((Runnable) r0.h.getValue());
        AudioComposePageViewPager r1 = r0.i;
        if (r1 == null) goto L9;
        r1.setCanScroll(true);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
        View r0 = this.e;
        if (r0 == null) goto L14;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r1 = this.b;
        if (r1 != null) goto L7;
    L9:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2 = this.b;
        if (r2 == null) goto L12;
        int r3 = r2.W();
    L13:
        com.bytedance.android.live.core.utils.a1.k(r0, r3);
        goto L14
    L12:
        r3 = 0;
        goto L13
    L7:
        if (r1.W() != 0) goto L9;
        r3 = InputPanelSectionContainer.m;
    L14:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r4 = this.b;
        if (r4 == null) goto L25;
        com.bytedance.android.livesdk.interactivity.comment.audio.c r5 = r4.c;
        if (r5 == null) goto L26;
        Audio2TextSectionController r6 = this.c;
        if (r6 == null) goto L24;
        Intrinsics.checkNotNullParameter(r6, "listener");
        r5.o = r6;
        if (((fc2.e) ec2.f0.a.getValue()).a() == false) goto L27;
        f72.a.b("on Audio2text Section Switch on");
        r5.c();
        return;
    L27:
        return;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.comment.audio.BaseAudioKernel.OnRecordListener");
    L26:
        return;
    }

    public a() {
        this.a = InputSectionType.AUDIO2TEXT;
        this.d = new c();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r4) {
        Intrinsics.checkNotNullParameter(r4, "panelBridge");
        Activity r0 = r4.getActivity();
        if (r0 != null) goto L5;
        return null;
    L5:
        this.b = r4;
        if (r4.n0() == false) goto L8;
        View r1 = LayoutInflater.from(r0).inflate(2131567691, null);
    L9:
        this.e = r1;
        if (r1 != null) goto L12;
        return null;
    L12:
        Audio2TextSectionController r2 = new Audio2TextSectionController(r1, r4, null);
        r2.g();
        Unit r3 = Unit.INSTANCE;
        this.c = r2;
        int r5 = InputPanelSectionContainer.m;
        if (r4.W() == 0) goto L15;
        r5 = r4.W();
    L15:
        View r6 = this.e;
        if (r6 == null) goto L19;
        com.bytedance.android.live.core.utils.a1.k(r6, r5);
    L19:
        return this.e;
    L8:
        r1 = LayoutInflater.from(r0).inflate(2131567692, null);
        goto L9
    }
}

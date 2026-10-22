package com.ss.android.lark.chat.service.impl;

import com.ss.android.lark.audio.voiceinput.service.NewAudio2TextPush;
import com.ss.android.lark.audio.voiceinput.service.NewAudio2TextPushRepositoryV2;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class NewAudio2TextPushProxy extends c0c.b implements com.ss.android.lark.audio.voiceinput.service.l {
    public final /* synthetic */ com.ss.android.lark.audio.voiceinput.service.l b;
    public final com.ss.android.lark.passportc.internal.v c;
    public final com.ss.android.lark.passportc.convention.b<com.ss.android.lark.audio.voiceinput.service.l> d;

    public static final class a {
    }

    static {
    }

    public final void Ed(com.ss.android.lark.audio.voiceinput.service.n r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.d.d(new com.ss.android.lark.passportc.convention.b.b(com.ss.android.lark.audio.voiceinput.service.n.class, r4));
    }

    public final void H2(final com.ss.android.lark.audio.voiceinput.service.n r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        this.d.a(new com.ss.android.lark.passportc.convention.b.b(com.ss.android.lark.audio.voiceinput.service.n.class, r6), new com.ss.android.lark.passportc.convention.b.c(new NewAudio2TextPushProxy$addListener$1(r6), new NewAudio2TextPushProxy$addListener$2(r6)));
    }

    public final void mf(f0c.g r4) {
        Intrinsics.checkNotNullParameter(r4, "user");
        Log.i("AudioTextPushProxy", "destroy user: " + r4.b.b);
        Intrinsics.checkNotNullParameter(r4, "user");
        Object r5 = this.d.c();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.audio.voiceinput.service.NewAudio2TextPush");
        ((NewAudio2TextPush) r5).a.a();
    }

    public final void of(f0c.g r4) {
        Intrinsics.checkNotNullParameter(r4, "user");
        Log.i("AudioTextPushProxy", "user onPrepared: " + r4.b.b);
        Intrinsics.checkNotNullParameter(r4, "user");
    }

    public NewAudio2TextPushProxy(com.ss.android.lark.passportc.api.j r4, com.ss.android.lark.passportc.internal.v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<com.ss.android.lark.audio.voiceinput.service.l> r0 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r5.c(r1), com.ss.android.lark.audio.voiceinput.service.l.class), com.ss.android.lark.audio.voiceinput.service.l.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (com.ss.android.lark.audio.voiceinput.service.l) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(f0c.g r4, f0c.g r5) {
        StringBuilder r0 = new StringBuilder("preparing, fromUser: ");
        String r1 = BuildConfig.FLAVOR;
        if (r4 == null) goto L8;
        UserSession r6 = r4.b;
        if (r6 == null) goto L8;
        String r7 = r6.b;
        if (r7 == null) goto L8;
    L9:
        r0.append(r7);
        r0.append(", toUser: ");
        if (r5 == null) goto L17;
        UserSession r8 = r5.b;
        if (r8 == null) goto L17;
        String r9 = r8.b;
        if (r9 == null) goto L17;
        r1 = r9;
    L17:
        r0.append(r1);
        Log.i("AudioTextPushProxy", r0.toString());
        Object r10 = this.d.c();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.ss.android.lark.audio.voiceinput.service.NewAudio2TextPush");
        NewAudio2TextPush r11 = (NewAudio2TextPush) r10;
        NewAudio2TextPushRepositoryV2 r2 = r11.a;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.ss.android.lark.audio.voiceinput.service.NewAudio2TextPushRepositoryV2");
        if (Intrinsics.areEqual(r2.a, "absent_user") == false) goto L20;
        Log.w("AudioTextPushProxy", "from user is ABSENT_USER, call release manually");
        r11.a.a();
    L20:
        com.ss.android.lark.passportc.internal.v r12 = this.c;
        if (r5 == null) goto L24;
        UserSession r13 = r5.b;
        if (r13 == null) goto L24;
    L25:
        com.ss.android.lark.audio.voiceinput.service.l r14 = (com.ss.android.lark.audio.voiceinput.service.l) e0c.k.b(r12.c(r13), com.ss.android.lark.audio.voiceinput.service.l.class);
        this.d.e(r14);
        return;
    L24:
        r13 = ContainerConstsKt.a();
    L8:
        r7 = BuildConfig.FLAVOR;
        goto L9
    }
}

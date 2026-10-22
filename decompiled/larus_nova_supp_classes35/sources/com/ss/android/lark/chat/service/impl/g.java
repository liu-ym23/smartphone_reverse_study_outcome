package com.ss.android.lark.chat.service.impl;

import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class g implements m6b.b {
    public final String a;
    public final com.bytedance.lark.rustclient.api.l b;
    public Disposable c;

    public static final class a {
    }

    static {
    }

    @Override // m6b.b
    public final void b() {
        Disposable r0 = this.c;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    @Inject
    public g(String r2, com.bytedance.lark.rustclient.api.l r3) {
        Intrinsics.checkNotNullParameter(r2, "currentUserId");
        Intrinsics.checkNotNullParameter(r3, "userClient");
        this.a = r2;
        this.b = r3;
    }

    @Override // m6b.b
    public final void a(final d r3, final b r4) {
        Intrinsics.checkNotNullParameter(r3, "onReceive");
        Intrinsics.checkNotNullParameter(r4, "onError");
        this.c = y0.a("AudioTextPushRepositoryV2", this.a, new AudioTextPushRepositoryV2$subscribeAudioMessageRecognitionResultPush$1(this, r3, r4));
    }
}

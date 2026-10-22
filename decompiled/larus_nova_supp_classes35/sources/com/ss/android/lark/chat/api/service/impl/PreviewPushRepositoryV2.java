package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.im.v1.PushMessagePreviewsRequest;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class PreviewPushRepositoryV2 implements a2b.d {
    public final String a;
    public final com.bytedance.lark.rustclient.api.l b;
    public Disposable c;

    public static final class a {
    }

    static {
    }

    @Override // a2b.d
    public final void a() {
        Disposable r0 = this.c;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    @Inject
    public PreviewPushRepositoryV2(String r2, com.bytedance.lark.rustclient.api.l r3) {
        Intrinsics.checkNotNullParameter(r2, "currentUserId");
        Intrinsics.checkNotNullParameter(r3, "userClient");
        this.a = r2;
        this.b = r3;
    }

    @Override // a2b.d
    public final void b(final Function1<? super PushMessagePreviewsRequest, Unit> r3, final Function1<? super Throwable, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "onReceive");
        Intrinsics.checkNotNullParameter(r4, "onError");
        this.c = com.ss.android.lark.chat.service.impl.y0.a("PreviewPushRepositoryV2", this.a, new PreviewPushRepositoryV2$subscribeMessagePreviewPush$1(this, r3, r4));
    }
}

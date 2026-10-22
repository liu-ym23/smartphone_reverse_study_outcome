package com.ss.android.lark.chat.api.service.impl.usergroup;

import com.bytedance.lark.pb.im.v1.PushUserGroupEntitiesRequest;
import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.chat.service.impl.y0;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class UserGroupPushRepository implements b {
    public final String a;
    public final l b;
    public Disposable c;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.chat.api.service.impl.usergroup.b
    public final void b() {
        Disposable r0 = this.c;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    @Inject
    public UserGroupPushRepository(String r2, l r3) {
        Intrinsics.checkNotNullParameter(r2, "currentUserId");
        Intrinsics.checkNotNullParameter(r3, "userClient");
        this.a = r2;
        this.b = r3;
    }

    @Override // com.ss.android.lark.chat.api.service.impl.usergroup.b
    public final void a(final Function1<? super PushUserGroupEntitiesRequest, Unit> r3, final Function1<? super Throwable, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "onReceive");
        Intrinsics.checkNotNullParameter(r4, "onError");
        this.c = y0.a("PreviewPushRepositoryV2", this.a, new UserGroupPushRepository$subscribe$1(this, r3, r4));
    }
}

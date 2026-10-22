package com.ss.android.lark.passport;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@UserScope
public final class UserListFetcher implements b {
    public static final CoroutineScope c = null;
    public final String a;
    public final l b;

    public static final class a {
    }

    static {
        c = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    }

    @Override // com.ss.android.lark.passport.b
    public final Function0<Unit> register() {
        Log.i("UserListFetcher", "current user id is " + this.a);
        final Disposable r0 = t.g(this.b.i(Command.PUSH_CHATTERS, Entity.ADAPTER), new UserListFetcher$register$dis$1(this), UserListFetcher$register$dis$2.INSTANCE);
        return new AnonymousClass1(r0);
    }

    @Inject
    public UserListFetcher(String r2, l r3) {
        Intrinsics.checkNotNullParameter(r2, "currentUserId");
        Intrinsics.checkNotNullParameter(r3, "userRustClient");
        this.a = r2;
        this.b = r3;
    }
}

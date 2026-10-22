package com.ss.android.lark.chat.api.service.impl.secret;

import a2b.i;
import com.bytedance.lark.pb.im.v1.PushSecretChatDataCorruptResponse;
import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class SecretChatDataCorruptPush implements i {
    public final String a;
    public final l b;
    public final Map<Long, Integer> c;
    public final List<i.a> d;
    public final AtomicBoolean e;
    public final Function1<Throwable, Unit> f;
    public final Function1<PushSecretChatDataCorruptResponse, Unit> g;

    public static final class a {
    }

    static {
    }

    @Override // a2b.i
    public final void dispose() {
        ((ConcurrentHashMap) this.c).clear();
        this.e.set(false);
    }

    @Override // a2b.i
    public final void u1(i.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((CopyOnWriteArrayList) this.d).remove(r2);
    }

    @Override // a2b.i
    public final void yc(i.a r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        if (((CopyOnWriteArrayList) this.d).contains(r5) == true) goto L10;
        ((CopyOnWriteArrayList) this.d).add(r5);
        Map<Long, Integer> r0 = this.c;
        r5.getClass();
        if (((ConcurrentHashMap) r0).containsKey(0L) == false) goto L11;
        Integer r1 = (Integer) ((ConcurrentHashMap) this.c).get(0L);
        if (r1 == null) goto L12;
        r1.intValue();
        r5.a();
        return;
    L12:
        return;
    L11:
        return;
    }

    @Inject
    public SecretChatDataCorruptPush(String r2, l r3) {
        Intrinsics.checkNotNullParameter(r2, "currentUserId");
        Intrinsics.checkNotNullParameter(r3, "userClient");
        this.a = r2;
        this.b = r3;
        this.c = new ConcurrentHashMap();
        this.d = new CopyOnWriteArrayList();
        this.e = new AtomicBoolean(false);
        this.f = SecretChatDataCorruptPush$onError$1.INSTANCE;
        this.g = new SecretChatDataCorruptPush$onReceive$1(this);
    }
}

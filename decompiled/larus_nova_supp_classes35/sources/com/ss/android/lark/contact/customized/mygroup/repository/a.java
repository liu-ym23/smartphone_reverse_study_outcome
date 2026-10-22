package com.ss.android.lark.contact.customized.mygroup.repository;

import com.bytedance.lark.pb.im.v1.GetMyGroupChatsRequest;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final GetMyGroupChatsRequest.Type e = null;
    public boolean a;
    public boolean b;
    public long c;
    public final List<Chat> d;

    /* JADX INFO: renamed from: com.ss.android.lark.contact.customized.mygroup.repository.a$a, reason: collision with other inner class name */
    public static final class C0175a {
    }

    static {
        e = GetMyGroupChatsRequest.Type.ALL;
    }

    public a() {
        this.a = true;
        this.d = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.ss.android.lark.contact.customized.mygroup.repository.OfficeMyJoinGroupRepository$getMyJoinedGroupFromNet$1] */
    public final void a(final UIGetDataCallback r6) {
        Intrinsics.checkNotNullParameter(r6, "callback");
        if (this.b == false) goto L5;
        return;
    L5:
        this.b = true;
        ContactBaseModuleDependency.b.getClass();
        ContactBaseModuleDependency.a().f(this.c, e, new OfficeMyJoinGroupRepository$getMyJoinedGroupFromNet$1(this, r6));
    }

    public final void b(List<? extends Chat> r6) {
        if (this.c != 0) goto L6;
        ((ArrayList) this.d).clear();
        ArrayList r0 = (ArrayList) this.d;
        r0.addAll(r6);
        return;
    L6:
        HashSet r1 = new HashSet(r6.size());
        Iterator<T> r2 = r6.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r1.add(((Chat) r2.next()).getId());
        goto L8
    L10:
        Iterator r3 = ((ArrayList) this.d).iterator();
    L12:
        if (r3.hasNext() == false) goto L16;
        if (r1.contains(((Chat) r3.next()).getId()) == false) goto L12;
        r3.remove();
        goto L12
    L16:
        ArrayList r4 = (ArrayList) this.d;
        r4.addAll(r6);
    }
}

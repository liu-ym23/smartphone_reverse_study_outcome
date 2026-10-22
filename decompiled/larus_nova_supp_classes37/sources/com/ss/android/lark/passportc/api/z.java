package com.ss.android.lark.passportc.api;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class z {
    public final List<User> a;
    public final boolean b;

    public z() {
        throw null;
    }

    public abstract String a();

    public final String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(a());
        r0.append(", expectedBackgroundUserList=");
        List<User> r1 = this.a;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r2.add(((User) r3.next()).userId);
        goto L4
    L6:
        r0.append(r2);
        r0.append(",updateBackground = ");
        r0.append(this.b);
        return r0.toString();
    }

    public /* synthetic */ z(List r1, int r2) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new ArrayList();
    L5:
        this(r1, false);
    }

    public z(List r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}

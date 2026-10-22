package com.ss.android.lark.passport.assemble;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h implements Runnable {
    public final /* synthetic */ User a;
    public final /* synthetic */ User b;

    public h(User r1, User r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        StringBuilder r0 = new StringBuilder("dispatchUserListChanged:");
        User r1 = this.a;
        List<? extends User> r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.userId;
    L6:
        r0.append(r3);
        r0.append(", new:");
        User r4 = this.b;
        if (r4 == null) goto L9;
        String r5 = r4.userId;
    L10:
        r0.append(r5);
        PassportLog.d(PassportUserApi.TAG, r0.toString());
        List<? extends User> r6 = CollectionsKt.listOfNotNull(this.b);
        User r7 = this.a;
        if (r7 == null) goto L19;
        String r8 = r7.userId;
        User r9 = this.b;
        if (r9 == null) goto L15;
        String r10 = r9.userId;
    L17:
        if (Intrinsics.areEqual(r8, r10) == true) goto L19;
        PassportLog.d(PassportUserApi.TAG, PickerReporterConstants.VALUE.CLICK.REMOVE);
        r2 = CollectionsKt.listOf(this.a);
        goto L19
    L15:
        r10 = null;
    L19:
        Iterator r11 = CollectionsKt.toMutableList(PassportUserApi.access$getUserListChangeListeners$cp()).iterator();
    L21:
        if (r11.hasNext() == false) goto L25;
        mzb.a r12 = (mzb.a) r11.next();
        r12.p0(r6);
        if (r2 == null) goto L21;
        r12.l0(r2);
        goto L21
    L25:
        return;
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

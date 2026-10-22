package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new;

import bp1.j;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.livesdk.chatroom.k;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveToolbarData;
import com.bytedance.live.datacontext.n;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements Runnable {
    public final /* synthetic */ NewToolbarOriginalDataManager a;
    public final /* synthetic */ ILiveToolbarData b;

    public d(NewToolbarOriginalDataManager r1, ILiveToolbarData r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        k r0 = j.a(this.a.i, 2);
        if (r0 == null) goto L5;
        n r1 = r0.d();
    L6:
        ArrayList<s> r2 = NewToolbarOriginalDataManager.b(r1, this.b.getMorePanelDataList());
        if (r2 == null) goto L35;
        NewToolbarOriginalDataManager r3 = this.a;
        r3.d = r2;
        NewToolbarOriginalDataManager.c(r2, "more_panel");
        PropertyOwner<NewToolbarOriginalDataManager.a> r4 = r3.g;
        ArrayList r5 = new ArrayList();
        ArrayList<s> r6 = r3.d;
        if (r6 == null) goto L28;
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r6.iterator();
    L12:
        if (r8.hasNext() == false) goto L27;
        Object r9 = r8.next();
        s r10 = (s) r9;
        boolean r11 = true;
        if (r3.b.booleanValue() == false) goto L19;
        int r12 = r10.g;
        if (r12 == 3) goto L25;
        if (r12 != 1) goto L19;
    L25:
        if (r11 == false) goto L12;
        r7.add(r9);
    L19:
        if (r3.b.booleanValue() == true) goto L24;
        int r13 = r10.g;
        if (r13 == 3) goto L25;
        if (r13 == 2) goto L25;
    L24:
        r11 = false;
        goto L25
    L27:
        r5.addAll(r7);
    L28:
        r4.a(new NewToolbarOriginalDataManager.c(r5, 101, null, 12));
        return;
    L35:
        return;
    L5:
        r1 = null;
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

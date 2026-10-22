package com.ss.android.lark.inline.ai.logic.push;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ b.C0107b a;
    public final /* synthetic */ String b;

    public d(b.C0107b r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        b.C0107b r0 = this.a;
        String r1 = this.b;
        new Exception("unknown error");
        Exception r3 = new Exception((Throwable) r7);
        ErrorResult r8 = new ErrorResult(0);
        ErrorResult.access$002(r8, -1);
        ErrorResult.access$102(r8, -9999);
        ErrorResult.access$202(r8, 0);
        ErrorResult.access$302(r8, r3);
        ErrorResult.access$402(r8, "");
        ErrorResult.access$502(r8, "");
        ErrorResult.access$602(r8, "");
        ErrorResult.access$702(r8, "");
        ErrorResult.access$802(r8, 0);
        ErrorResult.access$902(r8, null);
        ErrorResult.access$1002(r8, null);
        ErrorResult.access$1102(r8, null);
        monitor-enter(r0);
        List r2 = (List) ((LinkedHashMap) r0.a).get(r1);     // Catch: Throwable -> L15
        if (r2 == null) goto L10;
        Iterator<T> r4 = r2.iterator();     // Catch: Throwable -> L15
    L8:
        if (r4.hasNext() == false) goto L10;
        ((IGetDataCallback) r4.next()).onError(r8);     // Catch: Throwable -> L15
    L10:
        List r9 = (List) ((LinkedHashMap) r0.a).get(r1);     // Catch: Throwable -> L15
        if (r9 == null) goto L13;
        r9.clear();     // Catch: Throwable -> L15
    L13:
        monitor-exit(r0);
        return;
    L15:
        th = move-exception;
        throw th;
    }
}

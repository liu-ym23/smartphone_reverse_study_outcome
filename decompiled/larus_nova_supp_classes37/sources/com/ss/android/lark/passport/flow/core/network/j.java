package com.ss.android.lark.passport.flow.core.network;

import com.bytedance.lark.pb.basic.v1.LarkError;
import com.bytedance.lark.pb.tool.v1.HttpHeader;
import com.bytedance.lark.pb.tool.v1.UserSendHttpResponse;
import com.bytedance.lark.rustclient.api.p;
import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.x;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ AtomicReference<Disposable> b;
    public final /* synthetic */ kotlinx.coroutines.i<f> c;
    public final /* synthetic */ g d;
    public final /* synthetic */ e e;

    public j(AtomicBoolean r1, AtomicReference r2, kotlinx.coroutines.j r3, g r4, e r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void accept(Object r10) {
        x r11 = (s) r10;
        if (this.a.compareAndSet(false, true) == false) goto L42;
        String r1 = null;
        Disposable r0 = this.b.getAndSet(null);
        if (r0 == null) goto L9;
        r0.dispose();
    L9:
        if (this.c.isActive() == true) goto L12;
        return;
    L12:
        if ((r11 instanceof x) == false) goto L22;
        kotlinx.coroutines.i<f> r2 = this.c;
        Result.Companion r3 = Result.Companion;
        g r4 = this.d;
        UserSendHttpResponse r12 = (UserSendHttpResponse) r11.c;
        String r5 = this.e.c;
        r4.getClass();
        LinkedHashMap r6 = new LinkedHashMap();
        Iterator<T> r7 = r12.headers.headers.iterator();
    L15:
        if (r7.hasNext() == false) goto L20;
        HttpHeader r8 = (HttpHeader) r7.next();
        String r9 = r8.name.toLowerCase(Locale.US);
        Object r13 = r6.get(r9);
        if (r13 != null) goto L19;
        r13 = new ArrayList();
        r6.put(r9, r13);
    L19:
        ((List) r13).add(r8.value);
        goto L15
    L20:
        r2.resumeWith(Result.constructor-impl(new f(r12.status_code.intValue(), r6, r12.body.toByteArray(), r5)));
        return;
    L22:
        if ((r11 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L37;
        p r14 = ((com.bytedance.lark.rustclient.api.c) r11).c;
        kotlinx.coroutines.i<f> r15 = this.c;
        String r16 = this.e.c;
        LarkError r17 = r14.b;
        if (r17 == null) goto L26;
        Integer r18 = r17.code;
    L27:
        if (r17 == null) goto L29;
        Integer r19 = r17.status;
    L30:
        if (r17 == null) goto L34;
        LarkError.ErrorDetails r20 = r17.details;
        if (r20 == null) goto L34;
        r1 = r20.x_tt_logid;
    L34:
        PassportHttpTransportException r21 = new PassportHttpTransportException(r16, r18, r19, r1, r14.b());
        Result.Companion r110 = Result.Companion;
        r15.resumeWith(Result.constructor-impl(ResultKt.createFailure(r21)));
        return;
    L29:
        r19 = null;
        goto L30
    L26:
        r18 = null;
        goto L27
    L37:
        throw new NoWhenBranchMatchedException();
    }
}

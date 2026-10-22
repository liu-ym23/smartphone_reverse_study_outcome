package com.bytedance.ai.bridge.remote;

import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static f3.a a(Throwable r10, f3.a r11) {
        Intrinsics.checkNotNullParameter(r10, IHostStyleUIDepend.TOAST_TYPE_ERROR);
        Intrinsics.checkNotNullParameter(r11, "businessErrNo");
        if ((r10 instanceof RemoteApiException.Business) == false) goto L6;
        return r11;
    L6:
        if ((r10 instanceof RemoteApiException.InvalidResponse) == false) goto L9;
        return f3.a.m;
    L9:
        if ((r10 instanceof RemoteApiException.Http) == false) goto L15;
        if (((RemoteApiException.Http) r10).getStatusCode() != 408) goto L69;
        return f3.a.w;
    L69:
        return f3.a.y;
    L15:
        if ((r10 instanceof RemoteApiException.Network) == false) goto L58;
        Throwable r12 = r10.getCause();
        if (r12 == null) goto L20;
        r10 = r12;
    L20:
        List r13 = SequencesKt.toList(SequencesKt.generateSequence(r10, new a()));
        boolean r14 = r13 instanceof Collection;
        boolean r0 = true;
        if (r14 == true) goto L23;
    L25:
        Iterator r15 = r13.iterator();
    L27:
        if (r15.hasNext() == false) goto L31;
        if ((((Throwable) r15.next()) instanceof SocketTimeoutException) == false) goto L27;
        boolean r16 = true;
    L32:
        if (r16 == false) goto L35;
        f3.a r17 = f3.a.w;
    L70:
        return r17;
    L35:
        if (r14 == true) goto L37;
    L39:
        Iterator r18 = r13.iterator();
    L41:
        if (r18.hasNext() == false) goto L53;
        Throwable r19 = (Throwable) r18.next();
        if ((r19 instanceof NetworkNotAvailabeException) == false) goto L45;
    L50:
        boolean r20 = true;
    L51:
        if (r20 == false) goto L41;
    L54:
        if (r0 == false) goto L56;
        r17 = f3.a.x;
        goto L70
    L56:
        r17 = f3.a.y;
        goto L70
    L45:
        if ((r19 instanceof UnknownHostException) == true) goto L50;
        if ((r19 instanceof ConnectException) == true) goto L50;
        r20 = false;
    L53:
        r0 = false;
        goto L54
    L37:
        if (r13.isEmpty() == false) goto L39;
    L31:
        r16 = false;
        goto L32
    L23:
        if (r13.isEmpty() == false) goto L25;
    L58:
        return f3.a.f;
    }
}

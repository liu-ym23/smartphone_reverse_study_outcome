package aj;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthSuccessCode;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.lynx.tasm.base.h;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import xc.e;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f312a;

    public d() {
        this.f312a = new CopyOnWriteArrayList();
    }

    public final li.c a(bj.a r10, IDLXBridgeMethod r11) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, "method");
        if (ki.a.d.f5319a == true) goto L6;
        ki.a.a("XBridgeAuthManager.doAuth: skip by disable auth");
        return new li.c(true, "XBridge unable auth", null, AuthSuccessCode.e, 42);
    L6:
        String r5 = r10.d();
        Intrinsics.checkNotNullParameter(r5, "url");
        boolean r12 = false;
        if (h.f10132b == null) goto L16;
        ConcurrentHashMap r13 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(e.class, "cls");
        e r14 = (e) yc.a.a(e.class, "default_bid");
        if (r14 == null) goto L14;
        xc.d r15 = (xc.d) r14.a(xc.d.class);
        if (r15 == null) goto L14;
        xc.b r16 = r15.i0();
        if (r16 == null) goto L14;
    L15:
        boolean r17 = r16.b();
    L17:
        if (r17 == false) goto L20;
    L53:
        r12 = true;
    L54:
        if (r12 == false) goto L57;
        ki.a.a("XBridgeAuthManager.doAuth: skip by auth recovery");
        li.c r18 = new li.c(true, "recovery over auth", null, AuthSuccessCode.f, 42);
        r18.f19646k = r10.d();
        return r18;
    L57:
        Iterator r19 = this.f312a.iterator();
        li.c r20 = null;
    L59:
        if (r19.hasNext() == false) goto L66;
        r20 = ((a) r19.next()).a(r10, r11);
        if (r20.f19641b == true) goto L65;
        if (r20.f19640a == true) goto L59;
    L65:
        return r20;
    L66:
        if (r20 == null) goto L68;
        return r20;
    L68:
        return new li.c(true, null, null, null, 62);
    L20:
        if (h.f10132b == null) goto L30;
        ConcurrentHashMap r21 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(e.class, "cls");
        e r22 = (e) yc.a.a(e.class, "default_bid");
        if (r22 == null) goto L27;
        xc.d r23 = (xc.d) r22.a(xc.d.class);
        if (r23 == null) goto L27;
        xc.b r24 = r23.i0();
        if (r24 == null) goto L27;
    L28:
        List r25 = r24.a();
        if (r25 == null) goto L30;
    L32:
        if (r25.isEmpty() == true) goto L54;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L36
        Object r27 = Result.m124constructorimpl(URLDecoder.decode(r5, Charsets.UTF_8.name()));     // Catch: Throwable -> L36
    L38:
        Object r28 = r5;
        if (Result.m127exceptionOrNullimpl(r27) != null) goto L41;
        r28 = r27;
    L41:
        String r29 = (String) r28;
        if (r25.isEmpty() == true) goto L54;
        Iterator r30 = r25.iterator();
    L46:
        if (r30.hasNext() == false) goto L54;
        String r31 = (String) r30.next();
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L50
        boolean r33 = Pattern.compile(r31).matcher(r29).find();     // Catch: Throwable -> L50
    L52:
        if (r33 == false) goto L46;
    L50:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        r33 = false;
    L36:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r27 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L27:
        r24 = new xc.b();
    L30:
        r25 = CollectionsKt.emptyList();
    L14:
        r16 = new xc.b();
        goto L15
    L16:
        r17 = false;
        goto L17
    }
}

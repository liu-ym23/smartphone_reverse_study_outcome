package com.bytedance.forest;

import com.bytedance.forest.model.w;
import com.bytedance.forest.utils.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList f4233a = null;

    static {
        f4233a = new ArrayList();
    }

    public static void a(w r13, String r14, JSONObject r15, JSONObject r16, JSONObject r17, int r18, e r19) {
        ArrayList r5 = f4233a;
        monitor-enter(r5);
        Iterator r10 = r5.iterator();     // Catch: Throwable -> L26
    L6:
        if (r10.hasNext() == false) goto L29;
        y4.a r11 = (y4.a) r10.next();     // Catch: Throwable -> L26
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L21
        String r20 = r13.f4441q.getOriginUrl();     // Catch: Throwable -> L21
        String r21 = r13.f4441q.getGroupId();     // Catch: Throwable -> L21
        Object r22 = null;
        if (r21.length() > 0) goto L12;
        r21 = null;
    L12:
        if (r21 == null) goto L14;
        String r23 = r21;
    L19:
        r11.getClass();     // Catch: Throwable -> L21
        y4.a.a(r14, r20, r23, r15, r16, r17, r18);     // Catch: Throwable -> L21
        Object r24 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r25 = Result.m127exceptionOrNullimpl(r24);     // Catch: Throwable -> L26
        if (r25 == null) goto L6;
        com.bytedance.forest.utils.d.b(r19.g, 6, "ResourceReporter", "custom report error", false, r25, null, 40);     // Catch: Throwable -> L26
        goto L6
    L14:
        Object r26 = r13.f4441q.getCustomParams().get("rl_container_uuid");     // Catch: Throwable -> L21
        if ((r26 instanceof String) == false) goto L18;
        r22 = r26;
    L18:
        r23 = (String) r22;     // Catch: Throwable -> L21
        goto L19
    L21:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L26
        r24 = Result.m124constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L26
        goto L23
    L29:
        Unit r28 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(r5);
        return;
    L26:
        th = move-exception;
        throw th;
    }
}

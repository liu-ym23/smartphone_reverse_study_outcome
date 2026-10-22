package com.larus.bmhome.chat.model;

import android.os.Looper;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c0 extends b0 {

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.chat.model.b0
    public final void a() {
        FLogger.a.d("ChatUsuallyConfig", "deleteActionBarInstruction");
        this.b = null;
        f();
    }

    public final void e() {
        f0 r0 = f0.a;
        String r1 = this.a;
        r0.getClass();
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        ArrayList r4 = null;
        if (r3 == true) goto L32;
        String r2 = f0.b.getString(f0.a(r1), "[]");
        Intrinsics.checkNotNullParameter(r2, "data");
        if (StringsKt.isBlank(r2) == true) goto L32;
        if (r2.length() != 0) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == true) goto L32;
        if (Intrinsics.areEqual(StringsKt.trim(r2).toString(), "[]") == true) goto L32;
        if (Intrinsics.areEqual(StringsKt.trim(r2).toString(), "{}") == true) goto L32;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L26
        Object r7 = Result.constructor-impl((com.larus.bmhome.actionbar.model.r) xt7.d.b.c(com.larus.bmhome.actionbar.model.r.Companion.serializer(), r2));     // Catch: Throwable -> L26
    L29:
        if (Result.isFailure-impl(r7) == false) goto L31;
        r7 = null;
    L31:
        com.larus.bmhome.actionbar.model.r r8 = (com.larus.bmhome.actionbar.model.r) r7;
    L33:
        this.b = r8;
        z2 r9 = z2.a;
        boolean r10 = r9.T();
        boolean r11 = r9.L();
        if (r10 == true) goto L37;
        if (r11 == true) goto L37;
        this.b = null;
    L63:
        f();
        FLogger.a.d("ChatUsuallyConfig", "loadChatInstructionConfFromRepo currentInstructionConf:" + this.b);
        return;
    L37:
        com.larus.bmhome.actionbar.model.r r12 = this.b;
        if (r12 == null) goto L63;
        com.larus.bmhome.actionbar.model.r r13 = this.b;
        if (r13 == null) goto L62;
        List<com.larus.bmhome.actionbar.model.u> r14 = r13.b;
        if (r14 == null) goto L62;
        r4 = new ArrayList();
        Iterator<T> r15 = r14.iterator();
    L45:
        if (r15.hasNext() == false) goto L62;
        Object r16 = r15.next();
        com.larus.bmhome.actionbar.model.u r17 = (com.larus.bmhome.actionbar.model.u) r16;
        Integer r18 = r17.a;
        if (r18 != null) goto L50;
    L52:
        Integer r19 = r17.a;
        if (r19 != null) goto L56;
    L59:
        boolean r20 = false;
    L60:
        if (r20 == false) goto L45;
        r4.add(r16);
        goto L45
    L56:
        if (r19.intValue() != 2) goto L59;
        if (r11 == false) goto L59;
    L58:
        r20 = true;
        goto L60
    L50:
        if (r18.intValue() != 1) goto L52;
        if (r10 == true) goto L58;
    L62:
        r12.b = r4;
    L26:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    L17:
        r5 = false;
    L32:
        r8 = null;
        goto L33
    L5:
        if (r1.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public final void f() {
        FLogger r0 = FLogger.a;
        r0.d("ChatUsuallyConfig", "saveCurrentUsuallyConfToRepo currentConversationId:" + this.a);
        f0 r1 = f0.a;
        String r2 = this.a;
        com.larus.bmhome.actionbar.model.r r3 = this.b;
        r1.getClass();
        r0.d("ChatUsuallyRepo", "updateUsuallyConf conversationId:" + r2 + ", instructionConfStr:" + r3);
        if (r2 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L17;
        String r5 = f0.a(r2);
        if (r3 == null) goto L14;
        String r6 = xt7.d.b.a(com.larus.bmhome.actionbar.model.r.Companion.serializer(), r3);
    L15:
        f0.b.storeString(r5, r6);
        return;
    L14:
        r6 = "[]";
        goto L15
    L17:
        return;
    L5:
        if (r2.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    public c0() {
    }

    @Override // com.larus.bmhome.chat.model.b0
    public final com.larus.bmhome.actionbar.model.r b() {
        return this.b;
    }

    @Override // com.larus.bmhome.chat.model.b0
    public final void c(String r6) {
        monitor-enter(this);
        FLogger r2 = FLogger.a;     // Catch: Throwable -> L14
        r2.d("ChatUsuallyConfig", "updateConversationId currentConversationId:" + this.a + " conversationId:" + r6);     // Catch: Throwable -> L14
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == true) goto L8;
        r2.i("ChatUsuallyConfig", "updateConversationId run not in main thread, current thread is " + ThreadMethodProxy.currentThread().getName());     // Catch: Throwable -> L14
    L8:
        if (com.larus.utils.o0.d(r6) == true) goto L10;
    L12:
        monitor-exit(this);
        return;
    L10:
        if (Intrinsics.areEqual(this.a, r6) == true) goto L12;
        r2.i("ChatUsuallyConfig", "perform change conversationId");     // Catch: Throwable -> L14
        this.a = r6;     // Catch: Throwable -> L14
        e();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.bmhome.chat.model.b0
    public final void d(com.larus.bmhome.actionbar.model.r r4) {
        Intrinsics.checkNotNullParameter(r4, "instructionConf");
        FLogger.a.d("ChatUsuallyConfig", "updateUsuallyActionBarInstructionConf content:" + r4);
        this.b = r4;
        f();
    }
}

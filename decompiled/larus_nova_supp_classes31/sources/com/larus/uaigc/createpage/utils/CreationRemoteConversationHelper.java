package com.larus.uaigc.createpage.utils;

import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreationRemoteConversationHelper {
    public static final CreationRemoteConversationHelper a = null;
    public static final MutexImpl b = null;
    public static final ConcurrentHashMap<String, String> c = null;

    public static final class a {
        public final String a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "ResolveResult(conversationId=" + this.a + ", replacedWithRemote=" + this.b + ')';
        }

        public a(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "conversationId");
            this.a = r2;
            this.b = r3;
        }
    }

    public CreationRemoteConversationHelper() {
    }

    static {
        a = new CreationRemoteConversationHelper();
        b = kotlinx.coroutines.sync.b.a();
        c = new ConcurrentHashMap();
    }

    public final Object a(String r5, String r6, Continuation<? super a> r7) {
        if ((r7 instanceof CreationRemoteConversationHelper$resolveBeforeUpload$1) == false) goto L7;
        CreationRemoteConversationHelper$resolveBeforeUpload$1 r0 = (CreationRemoteConversationHelper$resolveBeforeUpload$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L22 CancellationException -> L25
    L20:
    L29:
        return (a) r8;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r8);
        r0.L$0 = r5;     // Catch: Throwable -> L22 CancellationException -> L25
        r0.label = 1;     // Catch: Throwable -> L22 CancellationException -> L25
        r8 = b(r5, r6, r0);     // Catch: Throwable -> L22 CancellationException -> L25
        if (r8 != r2) goto L20;
        return r2;
    L25:
        e = move-exception;
        throw e;
    L22:
        th = move-exception;
        FLogger.a.e("CreationRemoteConversation", "resolve conversation before upload failed, localCvsId=" + r5 + ", error=" + th);
        return new a(r5, false);
    L7:
        r0 = new CreationRemoteConversationHelper$resolveBeforeUpload$1(this, r7);
        goto L8
    }

    public final Object b(String r9, String r10, Continuation<? super a> r11) {
        if ((r11 instanceof CreationRemoteConversationHelper$resolveBeforeUploadInternal$1) == false) goto L7;
        CreationRemoteConversationHelper$resolveBeforeUploadInternal$1 r0 = (CreationRemoteConversationHelper$resolveBeforeUploadInternal$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L18;
        kotlinx.coroutines.sync.a r13 = (kotlinx.coroutines.sync.a) r0.L$1;
        String r14 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L15
    L49:
        a r15 = (a) r12;     // Catch: Throwable -> L15
        if (r15 == null) goto L52;
        c.put(r14, r15.a);     // Catch: Throwable -> L15
    L53:
        a r7 = r15;
        kotlinx.coroutines.sync.a r16 = r13;
        a r17 = r7;
    L54:
        r16.unlock(null);
        return r17;
    L52:
        r15 = new a(r14, false);     // Catch: Throwable -> L15
    L15:
        Throwable th = th;
        r16 = r13;
    L59:
        r16.unlock(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.sync.a r18 = (kotlinx.coroutines.sync.a) r0.L$2;
        r10 = (String) r0.L$1;
        String r4 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);
        r16 = r18;
        r9 = r4;
    L62:
        String r5 = c.get(r9);     // Catch: Throwable -> L57
        if (r5 == null) goto L45;
        r17 = new a(r5, true);     // Catch: Throwable -> L57
        goto L54
    L45:
        CreationRemoteConversationHelper r6 = a;     // Catch: Throwable -> L57
        r0.L$0 = r9;     // Catch: Throwable -> L57
        r0.L$1 = r16;     // Catch: Throwable -> L57
        r0.L$2 = null;     // Catch: Throwable -> L57
        r0.label = 2;     // Catch: Throwable -> L57
        Object r19 = r6.c(r9, r10, r0);     // Catch: Throwable -> L57
        if (r19 != r2) goto L48;
        return r2;
    L48:
        r14 = r9;
        r13 = r16;
        r12 = r19;
    L57:
        th = move-exception;
        th = th;
        goto L59
    L20:
        ResultKt.throwOnFailure(r12);
        if (r9.length() != 0) goto L23;
        boolean r110 = true;
    L24:
        if (r110 == false) goto L28;
        return new a(r9, false);
    L28:
        if (com.larus.im.j.f(r9) == true) goto L32;
        return new a(r9, false);
    L32:
        if (Intrinsics.areEqual(z2.a.getImageInstantUploadConfig().e(), Boxing.boxBoolean(true)) == false) goto L34;
        String r111 = c.get(r9);
        if (r111 != null) goto L38;
        r16 = b;
        r0.L$0 = r9;
        r0.L$1 = r10;
        r0.L$2 = r16;
        r0.label = 1;
        if (r16.a(null, r0) != r2) goto L62;
        return r2;
    L38:
        return new a(r111, true);
    L34:
        return new a(r9, false);
    L23:
        r110 = false;
    L7:
        r0 = new CreationRemoteConversationHelper$resolveBeforeUploadInternal$1(this, r11);
        goto L8
    }

    public final Object c(String r22, String r23, Continuation<? super a> r24) {
        if ((r24 instanceof CreationRemoteConversationHelper$resolveRemoteIfLocalSubConversation$1) == false) goto L7;
        CreationRemoteConversationHelper$resolveRemoteIfLocalSubConversation$1 r1 = (CreationRemoteConversationHelper$resolveRemoteIfLocalSubConversation$1) r24;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        CreationRemoteConversationHelper$resolveRemoteIfLocalSubConversation$1 r15 = r1;
        Object r0 = r15.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r15.label;
        boolean r9 = false;
        int r10 = 2;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        String r4 = (String) r15.L$0;
        ResultKt.throwOnFailure(r0);
        Object r5 = r0;
        String r6 = r4;
        boolean r7 = true;
    L61:
        wc9.e r8 = (wc9.e) r5;
        if (r8 == null) goto L64;
        FLogger.a.i("CreationRemoteConversation", "create remote conversation before upload success, localCvsId=" + r6 + ", remoteCvsId=" + r8.a);
        return new a(r8.a, r7);
    L64:
        FLogger.a.e(r12, "create remote conversation before upload failed, localCvsId=" + r6);
        return null;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        wc9.e r11 = (wc9.e) r15.L$2;
        String r12 = (String) r15.L$1;
        String r13 = (String) r15.L$0;
        ResultKt.throwOnFailure(r0);
        String r16 = r12;
        r6 = r13;
    L41:
        String r17 = (String) r0;
        if (r17 != null) goto L44;
        r17 = r16;
    L44:
        if (r17 != null) goto L46;
    L47:
        r9 = true;
    L48:
        if (r9 == false) goto L51;
        FLogger.a.e("CreationRemoteConversation", "create remote conversation before upload failed, botId is empty, localCvsId=" + r6);
        return null;
    L51:
        IConversationRepoService r18 = RepoDispatcherDelegate.b.f();
        Integer r19 = r11.v;
        if (r19 == null) goto L54;
        r10 = r19.intValue();
    L54:
        wc9.e r20 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r20 == null) goto L57;
        String r21 = r20.a;
    L58:
        r15.L$0 = r6;
        r15.L$1 = null;
        r15.L$2 = null;
        r15.label = 3;
        r7 = true;
        r5 = IConversationRepoService.a.a(r18, r17, r10, r21, null, false, null, null, null, null, r15, 504);
        if (r5 != r14) goto L61;
        return r14;
    L57:
        r21 = null;
        goto L58
    L46:
        if (r17.length() != 0) goto L48;
    L17:
        String r25 = (String) r15.L$1;
        r6 = (String) r15.L$0;
        ResultKt.throwOnFailure(r0);
    L24:
        wc9.e r26 = (wc9.e) r0;
    L26:
        if (r26 != null) goto L29;
        FLogger.a.w("CreationRemoteConversation", "skip create remote conversation before upload, local conversation not found: " + r6);
        return null;
    L29:
        LocalSubConvHelper r27 = LocalSubConvHelper.a;
        if (LocalSubConvHelper.h(r6, r26) == false) goto L34;
        return new a(r6, false);
    L34:
        if (ic8.n.D(r26) == true) goto L37;
        FLogger.a.i("CreationRemoteConversation", "skip create remote conversation before upload, target is not sub conversation: " + r6);
        return null;
    L37:
        r15.L$0 = r6;
        r15.L$1 = r25;
        r15.L$2 = r26;
        r15.label = 2;
        Object r28 = r27.f(r26, r15);
        if (r28 != r14) goto L40;
        return r14;
    L40:
        String r29 = r25;
        r11 = r26;
        r0 = r28;
        r16 = r29;
        goto L41
    L18:
        ResultKt.throwOnFailure(r0);
        r26 = IAIChatControlTraceService.a.h(IAIChatControlTraceService.a, r22);
        if (r26 != null) goto L25;
        IConversationRepoService r30 = RepoDispatcherDelegate.b.f();
        r15.L$0 = r22;
        r15.L$1 = r23;
        r15.label = 1;
        r0 = IConversationRepoService.a.c(r30, r22, true, null, r15, 4);
        if (r0 != r14) goto L23;
        return r14;
    L23:
        r25 = r23;
        r6 = r22;
        goto L24
    L25:
        r25 = r23;
        r6 = r22;
    L7:
        r1 = new CreationRemoteConversationHelper$resolveRemoteIfLocalSubConversation$1(this, r24);
        goto L8
    }
}

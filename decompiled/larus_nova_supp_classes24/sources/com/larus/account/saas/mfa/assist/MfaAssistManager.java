package com.larus.account.saas.mfa.assist;

import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.account.saas.mfa.assist.bean.MfaMessage;
import com.larus.account.saas.mfa.assist.bean.MfaPushCodeResponse;
import com.larus.account.saas.mfa.network.MfaApi;
import com.larus.account.saas.runtime.internal.delegate.SaasApp;
import com.larus.account.saas.runtime.internal.delegate.SaasSettings;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class MfaAssistManager {
    public static final MfaAssistManager a = null;
    public static final CoroutineScope b = null;
    public static final LinkedList<a48.a> c = null;
    public static boolean d;
    public static volatile a e;

    public static abstract class a {
        public final long a;
        public final String b;

        /* JADX INFO: renamed from: com.larus.account.saas.mfa.assist.MfaAssistManager$a$a, reason: collision with other inner class name */
        public static final class C0064a extends a {
            public final long c;
            public final String d;
            public final String e;

            public final int hashCode() {
                long r0 = this.c;
                int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.d.hashCode()) * 31;
                String r2 = this.e;
                if (r2 != null) goto L5;
                int r3 = 0;
            L7:
                return r1 + r3;
            L5:
                r3 = r2.hashCode();
                goto L7
            }

            public final String toString() {
                return "Dismiss(version=" + this.c + ", token=" + this.d + ", toast=" + this.e + ')';
            }

            @Override // com.larus.account.saas.mfa.assist.MfaAssistManager.a
            public final String a() {
                return this.d;
            }

            @Override // com.larus.account.saas.mfa.assist.MfaAssistManager.a
            public final long b() {
                return this.c;
            }

            public final boolean equals(Object r8) {
                if (this != r8) goto L6;
                return true;
            L6:
                if ((r8 instanceof C0064a) == true) goto L8;
                return false;
            L8:
                C0064a r9 = (C0064a) r8;
                if (this.c == r9.c) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.d, r9.d) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.e, r9.e) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public C0064a(long r2, String r4, String r5) {
                Intrinsics.checkNotNullParameter(r4, "token");
                super(r2, r4);
                this.c = r2;
                this.d = r4;
                this.e = r5;
            }
        }

        public static final class b extends a {
            public final long c;
            public final String d;
            public final MfaMessage e;

            public final int hashCode() {
                long r0 = this.c;
                return (((((int) (r0 ^ (r0 >>> 32))) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
            }

            public final String toString() {
                return "Show(version=" + this.c + ", token=" + this.d + ", message=" + this.e + ')';
            }

            @Override // com.larus.account.saas.mfa.assist.MfaAssistManager.a
            public final String a() {
                return this.d;
            }

            @Override // com.larus.account.saas.mfa.assist.MfaAssistManager.a
            public final long b() {
                return this.c;
            }

            public final boolean equals(Object r8) {
                if (this != r8) goto L6;
                return true;
            L6:
                if ((r8 instanceof b) == true) goto L8;
                return false;
            L8:
                b r9 = (b) r8;
                if (this.c == r9.c) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.d, r9.d) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.e, r9.e) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public b(long r2, String r4, MfaMessage r5) {
                Intrinsics.checkNotNullParameter(r4, "token");
                Intrinsics.checkNotNullParameter(r5, "message");
                super(r2, r4);
                this.c = r2;
                this.d = r4;
                this.e = r5;
            }
        }

        public String a() {
            return this.b;
        }

        public long b() {
            return this.a;
        }

        public a(long r1, String r3) {
            this.a = r1;
            this.b = r3;
        }
    }

    public MfaAssistManager() {
    }

    static {
        a = new MfaAssistManager();
        b = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("MfaAssistManager"))).plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        c = new LinkedList();
        e = new a.C0064a(0, "invalid_token", null);
    }

    public static void b(a48.a r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        if (SaasApp.a.isTeenMode() == false) goto L5;
        com.larus.account.saas.runtime.internal.delegate.a.a.d("MfaAssistManager", "ignore mfa event, reason = minor_mode, token = " + r7.a());
        boolean r0 = false;
    L6:
        if (r0 == true) goto L8;
        return;
    L8:
        BuildersKt.launch$default(b, null, null, new MfaAssistManager$enqueue$1(r7, null), 3, null);
        return;
    L5:
        r0 = true;
        goto L6
    }

    public static final Object a(MfaAssistManager r12, Continuation r13) {
        r12.getClass();
        if ((r13 instanceof MfaAssistManager$consumeQueue$1) == false) goto L7;
        MfaAssistManager$consumeQueue$1 r0 = (MfaAssistManager$consumeQueue$1) r13;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        final a r15 = (a) r0.L$1;
        MfaAssistManager r4 = (MfaAssistManager) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L73:
        final MfaPushCodeResponse r16 = (MfaPushCodeResponse) r14;
        if (r16 != null) goto L76;
        com.larus.account.saas.runtime.internal.delegate.a.a.a("MfaAssistManager", "request push code failed, Abort, token = " + r15.a());
        return Unit.INSTANCE;
    L76:
        com.larus.account.saas.runtime.internal.util.b.a.post(new b(r15, r16));
    L78:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        a r17 = e;
        com.larus.account.saas.runtime.internal.delegate.a r5 = com.larus.account.saas.runtime.internal.delegate.a.a;
        StringBuilder r6 = new StringBuilder("before reduce events, eventQueue = ");
        LinkedList<a48.a> r7 = c;
        r6.append(r7);
        r5.d("MfaAssistManager", r6.toString());
        LinkedHashMap r8 = new LinkedHashMap();
        LinkedHashMap r9 = new LinkedHashMap();
        LinkedHashSet r10 = new LinkedHashSet();
        LinkedHashSet r11 = new LinkedHashSet();
        Iterator<T> r19 = r7.iterator();
    L16:
        if (r19.hasNext() == false) goto L35;
        a48.a r20 = (a48.a) r19.next();
        if ((r20 instanceof a48.a.b) == true) goto L20;
        if ((r20 instanceof a48.a.C0002a) == false) goto L16;
        if (r11.add(r20.a()) == false) goto L16;
        if (r8.remove(r20.a()) != null) goto L33;
        r9.put(r20.a(), r20);
        goto L16
    L33:
        r9.remove(r20.a());
        goto L16
    L20:
        if (r10.add(r20.a()) == false) goto L16;
        if (r9.remove(r20.a()) != null) goto L24;
        r8.remove(r20.a());
        r8.put(r20.a(), r20);
        goto L16
    L24:
        r8.remove(r20.a());
        goto L16
    L35:
        com.larus.account.saas.runtime.internal.delegate.a r21 = com.larus.account.saas.runtime.internal.delegate.a.a;
        r21.d("MfaAssistManager", "after reduce events, pendingShowEvents = " + r8 + ", pendingDismissEvents = " + r9);
        a48.a.b r22 = (a48.a.b) CollectionsKt.lastOrNull(r8.values());
        String r23 = null;
        if (r22 == null) goto L48;
        a r24 = e;
        if ((r24 instanceof a.b) == false) goto L40;
        a.b r25 = (a.b) r24;
    L41:
        if (r25 == null) goto L44;
        r23 = r25.d;
    L44:
        if (Intrinsics.areEqual(r23, r22.b) == false) goto L46;
        a r26 = e;
    L61:
        e = r26;
        final a r27 = e;
        c.clear();
        d = false;
        if (r17.b() != r27.b()) goto L65;
        r21.d("MfaAssistManager", "ui state not changed, do nothing, token = " + r17.a());
        return Unit.INSTANCE;
    L65:
        if ((r27 instanceof a.C0064a) == false) goto L68;
        com.larus.account.saas.runtime.internal.util.b.a.post(new com.larus.account.saas.mfa.assist.a(r27));
        goto L78
    L68:
        if ((r27 instanceof a.b) == false) goto L78;
        r0.L$0 = r12;
        r0.L$1 = r27;
        r0.label = 1;
        r14 = r12.c((a.b) r27, r0);
        if (r14 == r2) goto L99;
        r15 = r27;
        goto L73
    L99:
        return r2;
    L46:
        a r29 = new a.b(e.b() + 1, r22.b, r22.c);
    L47:
        r26 = r29;
        goto L61
    L40:
        r25 = null;
        goto L41
    L48:
        a r30 = e;
        if ((r30 instanceof a.b) == false) goto L51;
        a.b r31 = (a.b) r30;
    L52:
        if (r31 != null) goto L54;
        r26 = e;
        goto L61
    L54:
        a48.a.C0002a r32 = (a48.a.C0002a) r9.get(r31.d);
        if (r32 != null) goto L57;
        r26 = e;
        goto L61
    L57:
        if (Intrinsics.areEqual(r32.c.b(), SaasApp.a.e()) == true) goto L59;
        r23 = r32.c.c();
    L59:
        r29 = new a.C0064a(e.b() + 1, r31.d, r23);
        goto L47
    L51:
        r31 = null;
    L7:
        r0 = new MfaAssistManager$consumeQueue$1(r12, r13);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0087 -> B:30:0x008b). Please report as a decompilation issue!!! */
    public final Object c(a.b r14, Continuation<? super MfaPushCodeResponse> r15) {
        if ((r15 instanceof MfaAssistManager$requestPushCode$1) == false) goto L7;
        MfaAssistManager$requestPushCode$1 r0 = (MfaAssistManager$requestPushCode$1) r15;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        int r17 = r0.I$1;
        int r4 = r0.I$0;
        a.b r6 = (a.b) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L30:
        com.larus.account.saas.mfa.network.a r19 = (com.larus.account.saas.mfa.network.a) r16;
        if ((r19 instanceof com.larus.account.saas.mfa.network.a.d) == false) goto L48;
        com.larus.account.saas.mfa.network.a.d r110 = (com.larus.account.saas.mfa.network.a.d) r19;
        MfaPushCodeResponse r7 = (MfaPushCodeResponse) r110.a;
        if (r7 == null) goto L35;
        String r8 = r7.a;
    L36:
        if (r8 != null) goto L38;
    L41:
        boolean r9 = true;
    L43:
        if (r9 == false) goto L45;
        com.larus.account.saas.runtime.internal.delegate.a.a.a("MfaAssistManager", "request push code success #" + r17 + ", but code is empty, token = " + r6.d);
    L57:
        if (r17 == r4) goto L59;
        int r111 = r17 + 1;
        r14 = r6;
    L26:
        int r10 = MfaApi.a;
        String r11 = r14.d;
        String r12 = r14.e.a();
        r0.L$0 = r14;
        r0.I$0 = r4;
        r0.I$1 = r111;
        r0.label = 1;
        Object r13 = MfaApi.b(r11, r12, r0);
        if (r13 != r2) goto L29;
        return r2;
    L29:
        r6 = r14;
        r17 = r111;
        r16 = r13;
    L59:
        return null;
    L45:
        com.larus.account.saas.runtime.internal.delegate.a.a.d("MfaAssistManager", "request push code success #" + r17 + ", token = " + r6.d);
        return r110.a;
    L38:
        if (StringsKt.isBlank(r8) == true) goto L41;
        r9 = false;
        goto L43
    L35:
        r8 = null;
        goto L36
    L48:
        if ((r19 instanceof com.larus.account.saas.mfa.network.a.C0065a) == false) goto L57;
        com.larus.account.saas.runtime.internal.delegate.a r20 = com.larus.account.saas.runtime.internal.delegate.a.a;
        StringBuilder r112 = new StringBuilder("request push code failed #");
        r112.append(r17);
        r112.append(", code = ");
        com.larus.account.saas.mfa.network.a.C0065a r113 = (com.larus.account.saas.mfa.network.a.C0065a) r19;
        r112.append(r113.a.a);
        r112.append(", msg = ");
        r112.append(r113.a.b);
        r112.append(", token = ");
        r112.append(r6.d);
        r20.a("MfaAssistManager", r112.toString());
        int r114 = r113.a.a;
        if (r114 != 1) goto L52;
    L56:
        return null;
    L52:
        if (r114 == 1409) goto L56;
        if (r114 == 1604) goto L56;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        Integer r115 = Boxing.boxInt(SaasSettings.a.a("mfa_config", new JSONObject()).optInt("request_push_code_retry_times"));
        if (r115.intValue() <= 0) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == true) goto L21;
        r115 = null;
    L21:
        if (r115 == null) goto L23;
        int r116 = r115.intValue();
    L24:
        if (1 > r116) goto L59;
        r4 = r116;
        r111 = 1;
        goto L26
    L23:
        r116 = 3;
        goto L24
    L17:
        r5 = false;
    L7:
        r0 = new MfaAssistManager$requestPushCode$1(this, r15);
        goto L8
    }
}

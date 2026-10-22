package com.ss.android.token;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bd_sec_tee.core.TeeProvider;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.sdk.account.devicetransfer.AccountDeviceTransferManager;
import com.bytedance.sdk.account.settings.AccountHostSettingsManager;
import com.bytedance.sdk.account.settings.common.a;
import com.bytedance.sdk.account.utils.j;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class r {
    public static AuthTokenMultiProcessSharedProvider.b a;
    public static volatile boolean b;
    public static volatile Context c;
    public static volatile f0 d;
    public static volatile e0 e;
    public static volatile String f;
    public static volatile String g;
    public static volatile String h;
    public static volatile long i;
    public static long j;
    public static volatile boolean k;
    public static final Object l = null;
    public static final Handler m = null;
    public static volatile q n;
    public static final r o = null;

    public r() {
    }

    static {
        o = new r();
        e = new e0();
        f = "";
        h = "";
        l = new Object();
        m = new Handler(Looper.getMainLooper());
    }

    public static void b() {
        boolean r1 = true;
        if ((!StringsKt.isBlank(e.a)) == false) goto L36;
        a.a();
        if (a.Q == false) goto L37;
        a.a();
        String r0 = a.R;
        if ((!StringsKt.isBlank(r0)) == false) goto L9;
        String r4 = r0;
    L10:
        if (r4 == null) goto L38;
        List r2 = StringsKt.split$default(r4, new String[]{","}, false, 0, 6, null);
        if (r2 == null) goto L39;
        List r3 = r2;
        if ((r3 instanceof Collection) == true) goto L16;
    L18:
        Iterator r5 = r3.iterator();
    L20:
        if (r5.hasNext() == false) goto L24;
        if ((!StringsKt.contains$default(e.a, (String) r5.next(), false, 2, null)) == false) goto L20;
    L25:
        tb7.a.b("TokenFactory", "loadDataFromSp, token not match rule: " + r1);
        String r6 = e.a;
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L28
        r7.put("token", com.bytedance.sdk.account.utils.r.c(r6));     // Catch: Throwable -> L28
        com.bytedance.sdk.account.monitor.a.a("passport_token_value_error", r7);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        tb7.a.c("AccountMonitorUtil", "onTokenValueError", th);
        return;
    L24:
        r1 = false;
        goto L25
    L16:
        if (r3.isEmpty() == false) goto L18;
    L39:
        return;
    L38:
        return;
    L9:
        r4 = null;
        goto L10
    L37:
        return;
    }

    public static e0 e() {
        if (b == true) goto L10;
        f0 r0 = d;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("tokenObjectProviderHelper");
    L9:
        return r0.c();
    L10:
        return e;
    }

    public static void f() {
        if (b == true) goto L5;
        return;
    L5:
        long r4 = System.currentTimeMillis();
        Object r6 = l;
        monitor-enter(r6);
        AuthTokenMultiProcessSharedProvider.b r7 = a;     // Catch: Throwable -> L105
        if (r7 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");     // Catch: Throwable -> L105
    L10:
        String r8 = r7.f("token_encrypted");     // Catch: Throwable -> L105
        Ref.ObjectRef r9 = new Ref.ObjectRef();     // Catch: Throwable -> L105
        AuthTokenMultiProcessSharedProvider.b r10 = a;     // Catch: Throwable -> L105
        if (r10 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");     // Catch: Throwable -> L105
    L13:
        r9.element = r10.f("X-Tt-Token");     // Catch: Throwable -> L105
        AuthTokenMultiProcessSharedProvider.b r11 = a;     // Catch: Throwable -> L105
        if (r11 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");     // Catch: Throwable -> L105
    L16:
        i = r11.e();     // Catch: Throwable -> L105
        AuthTokenMultiProcessSharedProvider.b r12 = a;     // Catch: Throwable -> L105
        if (r12 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");     // Catch: Throwable -> L105
    L19:
        String r13 = r12.f("token_tlb_tag");     // Catch: Throwable -> L105
        AuthTokenMultiProcessSharedProvider.b r14 = a;     // Catch: Throwable -> L105
        if (r14 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");     // Catch: Throwable -> L105
    L22:
        int r15 = r14.d("is_login", -1);     // Catch: Throwable -> L105
        String r16 = "";
        String r17 = "";
        String r18 = "";
        Ref.ObjectRef r19 = new Ref.ObjectRef();     // Catch: Throwable -> L105
        if (((String) r9.element).length() <= 0) goto L25;
        boolean r110 = true;
    L27:
        if (r8.length() <= 0) goto L29;
        boolean r5 = true;
    L30:
        if (r110 == true) goto L34;
        if (r5 == true) goto L34;
    L33:
        String r20 = r16;
        String r21 = r17;
        a.a();     // Catch: Throwable -> L105
        boolean r111 = a.U;     // Catch: Throwable -> L105
        a.a();     // Catch: Throwable -> L105
        boolean r112 = a.V;     // Catch: Throwable -> L105
        if (r111 == false) goto L50;
        if (r5 == false) goto L50;
        r9.element = i(r8);     // Catch: Throwable -> L105
    L50:
        if (TextUtils.isEmpty(r18) == true) goto L52;
        TicketTrackData.Serialized r113 = new TicketTrackData.Serialized(r18);     // Catch: Throwable -> L105
    L53:
        TicketTrackData.Serialized r22 = r113;
        boolean r3 = r110;
        e0 r114 = new e0((String) r9.element, r20, r21, r22, r13, r15);     // Catch: Throwable -> L105
        r19.element = r114;     // Catch: Throwable -> L105
        r114.f = r8;     // Catch: Throwable -> L105
        if (r111 == false) goto L64;
        if (r5 == true) goto L64;
        if (r3 == false) goto L64;
        e0 r1 = new e0((String) r9.element, r20, r21, r22, r13, r15);     // Catch: Throwable -> L105
        r19.element = r1;     // Catch: Throwable -> L105
        c(r1);     // Catch: Throwable -> L105
        tb7.a.d("TokenFactory", "loadDataFromSp, compensate encrypt token: " + ((e0) r19.element).a());     // Catch: Throwable -> L105
        h("compensate_encrypt", (e0) r19.element);     // Catch: Throwable -> L105
        if (AccountHostSettingsManager.d.a() <= 0) goto L62;
        WeakHandler r2 = TokenFactory.j().j;     // Catch: Throwable -> L105
        if (r2 == null) goto L63;
        r2.postDelayed(new a(r9, r19), 5000);     // Catch: Throwable -> L105
    L63:
        boolean r23 = true;
    L65:
        if (r112 == true) goto L69;
        if (r3 == true) goto L69;
        if (r5 == false) goto L69;
        e0 r115 = new e0(i(r8), r20, r21, r22, r13, r15);     // Catch: Throwable -> L105
        r19.element = r115;     // Catch: Throwable -> L105
        r115.f = r8;     // Catch: Throwable -> L105
        tb7.a.d("TokenFactory", "loadDataFromSp, compensate plain text token: " + ((e0) r19.element).a());     // Catch: Throwable -> L105
        h("compensate_plaintext", (e0) r19.element);     // Catch: Throwable -> L105
        boolean r24 = true;
    L70:
        if (r111 == true) goto L74;
        if (r3 == false) goto L74;
        if (r5 == false) goto L74;
        r19.element = new e0((String) r9.element, r20, r21, r22, r13, r15);     // Catch: Throwable -> L105
        tb7.a.d("TokenFactory", "loadDataFromSp, clean encrypt token: " + ((e0) r19.element).a());     // Catch: Throwable -> L105
        h("clean_encrypt", (e0) r19.element);     // Catch: Throwable -> L105
        boolean r25 = true;
    L75:
        if (r112 == false) goto L79;
        if (r3 == false) goto L79;
        if (r5 == false) goto L79;
        e0 r116 = new e0("", r20, r21, r22, r13, 0);     // Catch: Throwable -> L105
        r116.f = r8;     // Catch: Throwable -> L105
        tb7.a.d("TokenFactory", "loadDataFromSp, clean plain text token: " + r116.a());     // Catch: Throwable -> L105
        h("clean_plaintext", r116);     // Catch: Throwable -> L105
        boolean r26 = true;
    L80:
        e0 r27 = (e0) r19.element;     // Catch: Throwable -> L105
        String r28 = r27.a;     // Catch: Throwable -> L105
        if (TextUtils.isEmpty(r28) == false) goto L83;
        String r29 = "";
        boolean r117 = false;
    L84:
        r27.e = r29;     // Catch: Throwable -> L105
        e = (e0) r19.element;     // Catch: Throwable -> L105
        AuthTokenMultiProcessSharedProvider.b r0 = a;     // Catch: Throwable -> L105
        if (r0 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");     // Catch: Throwable -> L105
    L87:
        f = r0.f("mfa_token");     // Catch: Throwable -> L105
        j = System.currentTimeMillis() - r4;     // Catch: Throwable -> L105
        String r30 = (String) r9.element;     // Catch: Throwable -> L105
        if ((!Intrinsics.areEqual("change.token", r30)) == true) goto L90;
    L92:
        k = r117;     // Catch: Throwable -> L105
        AuthTokenMultiProcessSharedProvider.b r31 = a;     // Catch: Throwable -> L105
        if (r31 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");     // Catch: Throwable -> L105
    L95:
        g = r31.f("x-tt-token-last");     // Catch: Throwable -> L105
        AuthTokenMultiProcessSharedProvider.b r32 = a;     // Catch: Throwable -> L105
        if (r32 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");     // Catch: Throwable -> L105
    L98:
        h = r32.f("device_transfer_tee_pub_key");     // Catch: Throwable -> L105
        Unit r33 = Unit.INSTANCE;     // Catch: Throwable -> L105
        monitor-exit(r6);
        AuthTokenMultiProcessSharedProvider.b r34 = a;
        if (r34 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");
    L103:
        r34.c("first_beat", true);
        tb7.a.d("TokenFactory", "loadDataFromSp. token: " + e.a() + ", mfaToken: " + com.bytedance.sdk.account.utils.n.b(f, 4) + ", isTokenValid: " + k + ", loadTokenDuration: " + j + ", mLastSameUserToken: " + com.bytedance.sdk.account.utils.n.b(g, 4) + ", logTagEnableEncrypt: " + r111 + ", logTagHasEncryptToken: " + r5 + ", logTagNeedCompensateEncrypt: " + r23 + ", logTagNeedCleanEncrypt: " + r25 + ", logTagClosePlainText: " + r112 + ", logTagHasPlainTextToken: " + r3 + ", logTagNeedCompensatePlainText: " + r24 + ", logTagNeedCleanPlainText: " + r26 + ", mDeviceTransferTeePubKey: " + h + ", tokenTimestamp: " + i);
        return;
    L90:
        if (TextUtils.isEmpty(r30) == true) goto L92;
        r117 = true;
        goto L92
    L83:
        int r118 = bc7.a.a;     // Catch: Throwable -> L105
        r117 = false;
        r29 = String.valueOf(bc7.a.a(r28.getBytes(), 0));     // Catch: Throwable -> L105
    L79:
        r26 = false;
    L74:
        r25 = false;
    L69:
        r24 = false;
        goto L70
    L62:
        TTTokenMonitor.m((String) r9.element, ((e0) r19.element).f);     // Catch: Throwable -> L105
    L64:
        r23 = false;
        goto L65
    L52:
        r113 = null;
    L34:
        AuthTokenMultiProcessSharedProvider.b r119 = a;     // Catch: Throwable -> L105
        if (r119 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");     // Catch: Throwable -> L105
    L37:
        r16 = r119.f("ts_sign");     // Catch: Throwable -> L105
        AuthTokenMultiProcessSharedProvider.b r120 = a;     // Catch: Throwable -> L105
        if (r120 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");     // Catch: Throwable -> L105
    L40:
        r17 = r120.f("attest_ts_sign");     // Catch: Throwable -> L105
        AuthTokenMultiProcessSharedProvider.b r121 = a;     // Catch: Throwable -> L105
        if (r121 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");     // Catch: Throwable -> L105
    L43:
        r18 = r121.f("track_data");     // Catch: Throwable -> L105
        goto L33
    L29:
        r5 = false;
        goto L30
    L25:
        r110 = false;
    L105:
        th = move-exception;
        throw th;
    }

    public final Context getContext() {
        Context r0 = c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L5:
        return r0;
    }

    public static String d() {
        return e().a;
    }

    public static void c(e0 r6) {
        int r1 = 0;
        if (r6.a.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L24;
        String r2 = r6.f;
        if (r2 != null) goto L10;
    L15:
        String r3 = r6.a;
        if (r3 == null) goto L23;
        String r4 = StringsKt.reversed(r3).toString();
        StringBuilder r5 = new StringBuilder();
        int r7 = r4.length();
    L18:
        if (r1 >= r7) goto L20;
        r5.append((char) (r4.charAt(r1) + (r1 % 5)));
        r1 = r1 + 1;
        goto L18
    L20:
        r6.f = r5.toString();
        return;
    L23:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    L10:
        if (r2.length() <= 0) goto L12;
        boolean r8 = true;
    L13:
        if (r8 != true) goto L15;
        return;
    L12:
        r8 = false;
        goto L13
    L24:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @JvmStatic
    public static final String i(String r5) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r5.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.append((char) (r5.charAt(r2) - (r2 % 5)));
        r2 = r2 + 1;
        goto L3
    L5:
        String r6 = r0.toString();
        if (r6 == null) goto L10;
        return StringsKt.reversed(r6).toString();
    L10:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final int a(String r2, String r3) {
        boolean r1 = false;
        if (Intrinsics.areEqual(r2, r3) == false) goto L6;
        return 0;
    L6:
        if (r2.length() != 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L12;
        return -1;
    L12:
        if (r3.length() != 0) goto L14;
        r1 = true;
    L14:
        if (r1 == false) goto L16;
        return 1;
    L16:
        return 2;
    L8:
        r4 = false;
        goto L9
    }

    public static /* synthetic */ void h(String r2, e0 r3) {
        g(r2, r3, false, null);
    }

    public static void g(String r9, e0 r10, boolean r11, AuthTokenMultiProcessSharedProvider.a r12) {
        if (r12 != null) goto L5;
        boolean r1 = true;
    L6:
        if (r12 != null) goto L12;
        AuthTokenMultiProcessSharedProvider.b r13 = a;
        if (r13 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");
    L11:
        r12 = r13.b();
    L12:
        r12.c("X-Tt-Token", r10.a);
        r12.c("token_encrypted", r10.f);
        r12.c("ts_sign", r10.b);
        r12.c("attest_ts_sign", r10.c);
        r12.c("token_tlb_tag", r10.g);
        if (r11 == false) goto L15;
        i = System.currentTimeMillis();
        long r2 = i;
        r12.b.put("x-tt-token-timestamp", Long.valueOf(r2));
    L15:
        j<TicketTrackData> r3 = r10.d;
        if (r3 == null) goto L20;
        String r4 = r3.a();
        if (r4 == null) goto L20;
    L21:
        r12.c("track_data", r4);
        String r14 = "";
        if (AccountDeviceTransferManager.f() == true) goto L49;
    L31:
        r12.c("device_transfer_tee_pub_key", r14);
        int r0 = r10.h;
        r12.b.put("is_login", Integer.valueOf(r0));
        if (r1 == false) goto L48;
        Object r15 = l;
        monitor-enter(r15);
        r12.a();     // Catch: Throwable -> L45
        String r5 = r10.a;     // Catch: Throwable -> L45
        String r6 = r10.b;     // Catch: Throwable -> L45
        String r7 = r10.g;     // Catch: Throwable -> L45
        a.a();     // Catch: Throwable -> L45
        long r8 = a.b0;     // Catch: Throwable -> L45
        if (r8 <= 0) goto L42;
        Runnable r16 = n;     // Catch: Throwable -> L45
        if (r16 == null) goto L41;
        m.removeCallbacks(r16);     // Catch: Throwable -> L45
    L41:
        Runnable r17 = new q(SystemClock.elapsedRealtime(), r9, r5, r6, r7);     // Catch: Throwable -> L45
        n = r17;     // Catch: Throwable -> L45
        m.postDelayed(r17, r8);     // Catch: Throwable -> L45
    L42:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L45
        monitor-exit(r15);
        return;
    L45:
        th = move-exception;
        throw th;
    L48:
        return;
    L49:
        AccountDeviceTransferManager.h.getClass();     // Catch: Exception -> L28
        Lazy r19 = AccountDeviceTransferManager.g;     // Catch: Exception -> L28
        KProperty r20 = AccountDeviceTransferManager.e[1];     // Catch: Exception -> L28
        r14 = (String) ((TeeProvider) r19.getValue()).a("device_transfer", null).b;     // Catch: Exception -> L28
        if (r14 != null) goto L30;
        r14 = "";
    L30:
        r12.c("device_transfer_tee_pub_key", r14);
    L28:
        e = move-exception;
        tb7.a.f("TokenFactory", "get device transfer tee pub key error", e);
        r14 = "";
    L20:
        r4 = "";
        goto L21
    L5:
        r1 = false;
        goto L6
    }
}

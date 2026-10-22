package com.bytedance.ai.applet.moa;

import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.services.AppLifecycleCallbacks;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k {
    public static final k a = null;
    public static final CoroutineScope b = null;
    public static final ConcurrentHashMap<i, g> c = null;
    public static final ConcurrentHashMap<String, h> d = null;
    public static final ConcurrentHashMap.KeySetView<i, Boolean> e = null;

    public static final class a implements AppLifecycleCallbacks {
        public a() {
        }

        @Override // com.bytedance.ai.applet.services.AppLifecycleCallbacks
        public final void onAppAttached(AppletApplication r10) {
            Intrinsics.checkNotNullParameter(r10, "app");
        }

        @Override // com.bytedance.ai.applet.services.AppLifecycleCallbacks
        public final void onAppDestroyed(AppletApplication r10) {
            Intrinsics.checkNotNullParameter(r10, "app");
            k r0 = k.a;
            final String r11 = r10.getAppId();
            r0.getClass();
            h r1 = k.d.get(r11);
            if (r1 == null) goto L5;
            k.l(r1);
        L5:
            Collection<g> r12 = k.c.values();
            ArrayList r13 = new ArrayList();
            Iterator<T> r14 = r12.iterator();
        L7:
            if (r14.hasNext() == false) goto L11;
            Object r15 = r14.next();
            if (Intrinsics.areEqual(((g) r15).a.a, r11) == false) goto L7;
            r13.add(r15);
            goto L7
        L11:
            Iterator r16 = r13.iterator();
        L13:
            if (r16.hasNext() == false) goto L15;
            g r17 = (g) r16.next();
            k r18 = k.a;
            Intrinsics.checkNotNull(r17);
            MoaGrantingResult r19 = MoaGrantingResult.FAILED;
            r18.getClass();
            k.c(r17, r19);
            goto L13
        L15:
            CollectionsKt.removeAll(k.e, new j(r11));
        }

        @Override // com.bytedance.ai.applet.services.AppLifecycleCallbacks
        public final void onAppCreated(AppletApplication r10, Context r11) {
            Intrinsics.checkNotNullParameter(r10, "app");
            Intrinsics.checkNotNullParameter(r11, "context");
        }

        @Override // com.bytedance.ai.applet.services.AppLifecycleCallbacks
        public final void onAppDestroyView(AppletApplication r10, Context r11) {
            Intrinsics.checkNotNullParameter(r10, "app");
            Intrinsics.checkNotNullParameter(r11, "context");
        }

        @Override // com.bytedance.ai.applet.services.AppLifecycleCallbacks
        public final void onAppResumed(AppletApplication r10, Context r11) {
            Intrinsics.checkNotNullParameter(r10, "app");
            Intrinsics.checkNotNullParameter(r11, "context");
        }

        @Override // com.bytedance.ai.applet.services.AppLifecycleCallbacks
        public final void onAppStopped(AppletApplication r1, Context r10) {
            AppLifecycleCallbacks.a.a(r1, r10);
        }

        @Override // com.bytedance.ai.applet.services.AppLifecycleCallbacks
        public final void onAppTaskBackground(AppletApplication r10, Context r11) {
            Intrinsics.checkNotNullParameter(r10, "app");
            Intrinsics.checkNotNullParameter(r11, "context");
        }

        @Override // com.bytedance.ai.applet.services.AppLifecycleCallbacks
        public final void onAppTaskForeground(AppletApplication r1, Context r10) {
            AppLifecycleCallbacks.a.b(r1, r10);
        }
    }

    public static final class b {
        public final u2.e a;
        public final boolean b;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L14;
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
            return "ParsedGrantingData(data=" + this.a + ", autoAdvanceApprovedItems=" + this.b + ')';
        }

        public b(u2.e r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "data");
            this.a = r10;
            this.b = r11;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[MoaStepResult.values().length];
            r0[MoaStepResult.CONTINUE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L26:
            r0[MoaStepResult.REFUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L38:
            r0[MoaStepResult.FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L28:
            r0[MoaStepResult.WAITING_ACTION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L30:
            r0[MoaStepResult.REQUIRES_CONFIRMATION.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L10:
            a = r0;
            int[] r1 = new int[MoaGrantingResult.values().length];
            r1[MoaGrantingResult.GRANTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L24:
            r1[MoaGrantingResult.REFUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L32:
            r1[MoaGrantingResult.FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L14:
            b = r1;
        }
    }

    public k() {
    }

    static {
        a = new k();
        b = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
        e = ConcurrentHashMap.newKeySet();
        AppletAppManagerService.INSTANCE.registerAppLifecycleCallbacks(new a());
    }

    public static void b(g r10) {
    L3:
        if (r10.a() == null) goto L35;
        u2.f r0 = r10.a();
        if (r0 == null) goto L50;
        if (r10.e == true) goto L10;
    L12:
        boolean r1 = false;
    L13:
        if (r1 == true) goto L51;
        String r11 = r0.c();
        if (r11 == null) goto L52;
        int r12 = r11.hashCode();
        if (r12 != 280295099) goto L19;
        if (r11.equals("granted") == false) goto L57;
        r10.g++;
        goto L3
    L57:
        return;
    L19:
        if (r12 == 854280074) goto L27;
        if (r12 != 1085547216) goto L53;
        if (r11.equals("refused") == false) goto L54;
    L30:
        if (r0.f() == true) goto L56;
        r10.g++;
        goto L3
    L56:
        return;
    L54:
        return;
    L53:
        return;
    L27:
        if (r11.equals("granted_without_system") == true) goto L30;
        return;
    L52:
        return;
    L51:
        return;
    L10:
        if (Intrinsics.areEqual(r0.b(), "permission") == false) goto L12;
        r1 = true;
        goto L13
    L50:
        return;
    }

    public static boolean e(h r10) {
        g r0 = r10.getContext();
        if (c.get(r0.a) != r0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
    L10:
        return false;
    L8:
        if (d.get(r10.getContext().a.a) != r10) goto L10;
        return true;
    L5:
        r1 = false;
        goto L6
    }

    public static b j(JsonObject r20) {
        JsonElement r1 = r20.get("version");
        if (r1 != null) goto L5;
    L10:
        Integer r10 = null;
    L12:
        if (r10 != null) goto L14;
    L16:
        String r11 = g(r20, "type");
        if (r11 != null) goto L19;
        return null;
    L19:
        String r12 = g(r20, "doubaoAppletKey");
        if (r12 != null) goto L22;
        return null;
    L22:
        int r13 = r11.hashCode();
        if (r13 == (-517618225)) goto L40;
        if (r13 == 103149417) goto L37;
        if (r13 == 969075185) goto L30;
    L41:
        return null;
    L30:
        if (r11.equals("aweme_login") == false) goto L41;
        if (g(r20, "authLink") != null) goto L35;
        return null;
    L35:
        List r14 = CollectionsKt.listOf(new u2.f(0, r11, true, "pending", r20.toString()));
    L101:
        return new b(new u2.e(r12, g(r20, "doubaoAppletVersion"), r14, 118), Intrinsics.areEqual(r11, "permission"));
    L37:
        if (r11.equals("login") == false) goto L41;
        r14 = CollectionsKt.listOf(new u2.f(0, r11, true, "pending", r20.toString()));
        goto L101
    L40:
        if (r11.equals("permission") == false) goto L41;
        JsonArray r15 = r20.getAsJsonArray("permissions");
        if (r15 != null) goto L45;
        return null;
    L45:
        ArrayList r16 = new ArrayList();
        Iterator r17 = r15.iterator();
        int r18 = 0;
    L47:
        if (r17.hasNext() == false) goto L94;
        Object r19 = r17.next();
        int r21 = r18 + 1;
        if (r18 >= 0) goto L51;
        CollectionsKt.throwIndexOverflow();
    L51:
        JsonElement r22 = (JsonElement) r19;
        if (r22.isJsonObject() == true) goto L55;
        r22 = null;
    L55:
        if (r22 == null) goto L92;
        JsonObject r23 = r22.getAsJsonObject();
        if (r23 == null) goto L92;
        a.getClass();
        String r110 = g(r23, "scopeName");
        if (r110 == null) goto L61;
        JsonElement r111 = r23.get("priorityLevel");
        if (r111 != null) goto L65;
    L70:
        Integer r112 = null;
    L71:
        if (r112 == null) goto L73;
        r18 = r112.intValue();
    L73:
        int r113 = r18;
        JsonElement r24 = r23.get("required");
        if (r24 != null) goto L76;
    L81:
        Boolean r25 = null;
    L82:
        if (r25 == null) goto L84;
        boolean r114 = r25.booleanValue();
    L85:
        String r26 = g(r23, "permissionStatus");
        if (r26 != null) goto L88;
        r26 = "pending";
    L88:
        String r115 = r26;
        JsonObject r27 = new JsonObject();
        r27.addProperty("scopeName", r110);
        String r28 = g(r23, "scopeDescription");
        if (r28 == null) goto L91;
        r27.addProperty("scopeDescription", r28);
    L91:
        Unit r29 = Unit.INSTANCE;
        r16.add(new u2.f(r113, "permission", r114, r115, r27.toString()));
        r18 = r21;
        goto L47
    L84:
        r114 = false;
        goto L85
    L76:
        if (r24.isJsonNull() == false) goto L79;
        r24 = null;
    L79:
        if (r24 == null) goto L81;
        r25 = Boolean.valueOf(r24.getAsBoolean());
        goto L82
    L65:
        if (r111.isJsonNull() == false) goto L68;
        r111 = null;
    L68:
        if (r111 == null) goto L70;
        r112 = Integer.valueOf(r111.getAsInt());
        goto L71
    L61:
        return null;
    L92:
        return null;
    L94:
        if ((true ^ r16.isEmpty()) == true) goto L97;
        r16 = null;
    L97:
        if (r16 != null) goto L99;
        return null;
    L99:
        r14 = r16;
        goto L101
    L14:
        if (r10.intValue() == 1) goto L16;
        return null;
    L5:
        if (r1.isJsonNull() == false) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L10;
        r10 = Integer.valueOf(r1.getAsInt());
        goto L12
    }

    public static void k(f3.h r10) {
        Intrinsics.checkNotNullParameter(r10, "callback");
        f3.h.a.a(r10, "Error: MOA login flow is no longer active", f3.a.f, null, 10);
    }

    public static void l(h r10) {
        if (d.remove(r10.getContext().a.a, r10) == true) goto L5;
        return;
    L5:
        Job r0 = r10.g;
        if (r0 == null) goto L8;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L8:
        r10.g = null;
        n r1 = r10.f;
        if (r1 == null) goto L11;
        r1.a(r10.a());
    L11:
        r10.f = null;
        r10.d = null;
        r10.e = null;
    }

    public static void m(h r10) {
        Function0<Unit> r0 = r10.e;
        l(r10);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        r0.invoke();     // Catch: Throwable -> L9
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L9
    L11:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L17;
        com.bytedance.ai.utils.g.a.e("MoaGrantingManager", "MOA waiting-action callback failed", r14);
        return;
    L17:
        return;
    L6:
        r12 = null;
    L9:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public static void c(g r10, MoaGrantingResult r11) {
        if (c.remove(r10.a, r10) == true) goto L5;
        return;
    L5:
        int r0 = c.b[r11.ordinal()];
        boolean r1 = true;
        if (r0 != 1) goto L8;
    L14:
        e.add(r10.a);
    L15:
        h r12 = d.get(r10.a.a);
        if (r12 != null) goto L18;
    L26:
        com.bytedance.ai.utils.g.a.i("MoaGrantingManager", "finish authorizationID=" + r10.b.b + ", appletId=" + r10.c.d() + ", result=" + r11.getValue());
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L29
        r10.f.a(r10.b, r11);     // Catch: Throwable -> L29
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L37;
        com.bytedance.ai.utils.g.a.e("MoaGrantingManager", "MOA callback failed", r15);
        return;
    L37:
        return;
    L29:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    L18:
        if (r12.getContext() == r10) goto L21;
        r1 = false;
    L21:
        if (r1 == true) goto L24;
        r12 = null;
    L24:
        if (r12 == null) goto L26;
        a.getClass();
        l(r12);
        goto L26
    L8:
        if (r0 == 2) goto L14;
        if (r0 == 3) goto L15;
        throw new NoWhenBranchMatchedException();
    }

    public static boolean f(g r10, i r11) {
        if (Intrinsics.areEqual(r10.a, r11) == true) goto L5;
    L11:
        return false;
    L5:
        if (Intrinsics.areEqual(r10.b.a, r11.a) == false) goto L11;
        if (Intrinsics.areEqual(r10.b.b, r11.b) == false) goto L11;
        if (Intrinsics.areEqual(r10.c.d(), r11.a) == false) goto L11;
        return true;
    }

    public static String g(JsonObject r1, String r10) {
        JsonElement r11 = r1.get(r10);
        if (r11 != null) goto L5;
        return null;
    L5:
        if (r11.isJsonNull() == false) goto L8;
        r11 = null;
    L8:
        if (r11 == null) goto L19;
        String r12 = StringsKt.trim(r11.getAsString()).toString();
        if (r12.length() <= 0) goto L13;
        boolean r0 = true;
    L14:
        if (r0 == true) goto L16;
        return null;
    L16:
        return r12;
    L13:
        r0 = false;
        goto L14
    L19:
        return null;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:103:0x0202 -> B:112:0x022a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x0215 -> B:107:0x021a). Please report as a decompilation issue!!! */
    public static final Object a(k r17, h r18, Continuation r19) {
        r17.getClass();
        if ((r19 instanceof MoaGrantingManager$runExecution$1) == false) goto L7;
        MoaGrantingManager$runExecution$1 r1 = (MoaGrantingManager$runExecution$1) r19;
        int r10 = r1.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r10 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = r1.label;
        String r13 = "MoaGrantingManager";
        if (r12 == 0) goto L16;
        if (r12 == 1) goto L15;
        if (r12 != 2) goto L14;
        n r14 = (n) r1.L$2;
        g r15 = (g) r1.L$1;
        h r16 = (h) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L107:
        MoaStepResult r20 = (MoaStepResult) r0;
        if (e(r16) == false) goto L162;
        if (r16.f != r14) goto L162;
    L112:
        MoaGrantingManager$runExecution$1 r21 = r1;
        h r22 = r16;
        String r110 = r13;
        Object r23 = r11;
        g r24 = r15;
        String r25 = r110;
        if (r22.c == true) goto L115;
        c(r24, MoaGrantingResult.REFUSED);
        return Unit.INSTANCE;
    L115:
        int r26 = c.a[r20.ordinal()];
        if (r26 != 1) goto L118;
        r14.a(r22.a());
        r22.f = null;
        r24.g++;
        b(r24);
        if (c.get(r24.a) != r24) goto L132;
        boolean r27 = true;
    L133:
        if (r27 == true) goto L136;
        return Unit.INSTANCE;
    L136:
        if (r24.a() != null) goto L139;
        c(r24, MoaGrantingResult.GRANTED);
        return Unit.INSTANCE;
    L139:
        if (r24.e == true) goto L141;
        m(r22);
        return Unit.INSTANCE;
    L141:
        MoaGrantingManager$runExecution$1 r28 = r21;
    L18:
        if (e(r22) == false) goto L143;
        b(r24);
        u2.f r111 = r24.a();
        if (r111 != null) goto L22;
        c(r24, MoaGrantingResult.GRANTED);
        return Unit.INSTANCE;
    L22:
        p.a.getClass();
        Intrinsics.checkNotNullParameter(r111, "item");
        String r29 = r111.b();
        if (r29 != null) goto L25;
        n r112 = null;
    L93:
        if (r112 != null) goto L95;
        com.bytedance.ai.utils.g.a.e(r25, "No MOA handler for grantingName=" + r111.b());
        m(r22);
        return Unit.INSTANCE;
    L95:
        r22.f = r112;
        o r30 = r22.a();
        boolean r31 = r22.c;
        r28.L$0 = r22;
        r28.L$1 = r24;
        r28.L$2 = r112;
        r28.label = 1;
        r0 = r112.g(r30, r31, r28);
        if (r0 == r23) goto L169;
        r16 = r22;
        r1 = r28;
        r14 = r112;
        String r113 = r25;
        r15 = r24;
        r11 = r23;
        r13 = r113;
    L99:
        r20 = (MoaStepResult) r0;
        if (e(r16) == true) goto L103;
        return Unit.INSTANCE;
    L103:
        if (r20 != MoaStepResult.REQUIRES_CONFIRMATION) goto L112;
        o r32 = r16.a();
        r1.L$0 = r16;
        r1.L$1 = r15;
        r1.L$2 = r14;
        r1.label = 2;
        r0 = r14.c(r32, r1);
        if (r0 != r11) goto L107;
        return r11;
    L169:
        return r23;
    L25:
        switch(r29.hashCode()) {
            case -517618225: goto L87;
            case -314498168: goto L81;
            case 103149417: goto L34;
            case 969075185: goto L28;
            default: goto L152;
        };
    L152:
        r112 = null;
        goto L93
    L28:
        if (r29.equals("aweme_login") == false) goto L153;
        u2.d r33 = (u2.d) p.a(r111, u2.d.class);
        if (r33 == null) goto L146;
        int r114 = MoaExternalLoginGrantingStep.d;
        Intrinsics.checkNotNullParameter(r111, "item");
        Intrinsics.checkNotNullParameter(r33, "relatedData");
        r112 = new MoaExternalLoginGrantingStep(r111, r33, null);
        goto L93
    L146:
        r112 = null;
        goto L93
    L153:
        r112 = null;
        goto L93
    L34:
        if (r29.equals("login") == false) goto L154;
        String r34 = r111.e();
        if (r34 != null) goto L39;
    L42:
        boolean r115 = true;
    L43:
        if (r115 == false) goto L144;
        JsonObject r35 = null;
    L56:
        if (r35 == null) goto L155;
        JsonElement r36 = r35.get("type");
        if (r36 != null) goto L61;
    L66:
        String r37 = null;
    L68:
        if (Intrinsics.areEqual(r37, "login") == false) goto L70;
    L77:
        u2.j r38 = (u2.j) p.a(r111, u2.j.class);
        if (r38 == null) goto L149;
        int r39 = MoaLoginGrantingStep.m;
        Intrinsics.checkNotNullParameter(r111, "item");
        Intrinsics.checkNotNullParameter(r38, "relatedData");
        r112 = new MoaLoginGrantingStep(r111, r38, MoaLoginGrantingStep.Type.LOGIN);
        goto L93
    L149:
        r112 = null;
        goto L93
    L70:
        if (r35.has("bizLoginDescription") == true) goto L77;
        if (r35.has("authLink") == false) goto L147;
        u2.l r40 = (u2.l) p.a(r111, u2.l.class);
        if (r40 == null) goto L148;
        int r41 = MoaExternalLoginGrantingStep.d;
        Intrinsics.checkNotNullParameter(r111, "item");
        Intrinsics.checkNotNullParameter(r40, "relatedData");
        r112 = new MoaExternalLoginGrantingStep(r111, null, r40);
        goto L93
    L148:
        r112 = null;
        goto L93
    L147:
        r112 = null;
        goto L93
    L61:
        if (r36.isJsonNull() == false) goto L64;
        r36 = null;
    L64:
        if (r36 == null) goto L66;
        r37 = r36.getAsString();
        goto L68
    L155:
        r112 = null;
        goto L93
    L144:
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L47
        Lazy r117 = com.bytedance.ai.applet.base.gson.e.a;     // Catch: Throwable -> L47
        Object r42 = Result.constructor-impl((JsonObject) com.bytedance.ai.applet.base.gson.e.a(r34, JsonObject.class));     // Catch: Throwable -> L47
    L49:
        Throwable r118 = Result.exceptionOrNull-impl(r42);
        if (r118 == null) goto L53;
        com.bytedance.ai.utils.g.a.e("MoaGrantingStepFactory", "Failed to parse relatedData", r118);
    L53:
        if (Result.isFailure-impl(r42) == false) goto L55;
        r42 = null;
    L55:
        r35 = (JsonObject) r42;
    L47:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r42 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L49
    L39:
        if (StringsKt.isBlank(r34) == true) goto L42;
        r115 = false;
        goto L43
    L154:
        r112 = null;
        goto L93
    L81:
        if (r29.equals("privacy") == false) goto L156;
        u2.j r43 = (u2.j) p.a(r111, u2.j.class);
        if (r43 == null) goto L150;
        int r44 = MoaLoginGrantingStep.m;
        Intrinsics.checkNotNullParameter(r111, "item");
        Intrinsics.checkNotNullParameter(r43, "relatedData");
        r112 = new MoaLoginGrantingStep(r111, r43, MoaLoginGrantingStep.Type.PRIVACY);
        goto L93
    L150:
        r112 = null;
        goto L93
    L156:
        r112 = null;
        goto L93
    L87:
        if (r29.equals("permission") == false) goto L157;
        u2.k r45 = (u2.k) p.a(r111, u2.k.class);
        if (r45 == null) goto L151;
        r112 = new MoaPermissionGrantingStep(r111, r45);
        goto L93
    L151:
        r112 = null;
        goto L93
    L157:
        r112 = null;
        goto L93
    L143:
        return Unit.INSTANCE;
    L132:
        r27 = false;
        goto L133
    L118:
        if (r26 != 2) goto L120;
    L128:
        m(r22);
        return Unit.INSTANCE;
    L120:
        if (r26 == 3) goto L128;
        if (r26 == 4) goto L128;
        if (r26 != 5) goto L127;
        com.bytedance.ai.utils.g.a.e(r25, "Step still requires confirmation after requestConfirmation(), keeping the authorization retryable");
        m(r22);
        return Unit.INSTANCE;
    L127:
        throw new NoWhenBranchMatchedException();
    L162:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r14 = (n) r1.L$2;
        r15 = (g) r1.L$1;
        r16 = (h) r1.L$0;
        ResultKt.throwOnFailure(r0);
        goto L99
    L16:
        ResultKt.throwOnFailure(r0);
        r28 = r1;
        r25 = "MoaGrantingManager";
        r22 = r18;
        r23 = r11;
        r24 = r18.getContext();
    L7:
        r1 = new MoaGrantingManager$runExecution$1(r17, r19);
        goto L8
    }

    public static void h(m r1, MoaGrantingResult r10, com.bytedance.applet.impl.moa.a r11) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        r11.a(r1, r10);     // Catch: Throwable -> L4
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L12;
        com.bytedance.ai.utils.g.a.e("MoaGrantingManager", "MOA callback failed", r13);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public static boolean i(String r11, String r12, boolean r13, WeakReference r14, Function0 r15) {
        Intrinsics.checkNotNullParameter(r11, "appletId");
        Intrinsics.checkNotNullParameter(r12, "authorizationID");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L6;
        com.bytedance.ai.utils.g.a.e("MoaGrantingManager", "operateMoaGranting must be called on the main thread");
        return false;
    L6:
        String r16 = StringsKt.trim(r11).toString();
        String r17 = StringsKt.trim(r12).toString();
        if (StringsKt.isBlank(r16) == false) goto L9;
    L48:
        return false;
    L9:
        if (StringsKt.isBlank(r17) == true) goto L48;
        i r0 = new i(r16, r17);
        ConcurrentHashMap<i, g> r10 = c;
        g r18 = r10.get(r0);
        if (r18 != null) goto L20;
        if (e.contains(r0) == true) goto L16;
        return false;
    L16:
        if (r15 == null) goto L18;
        r15.invoke();
    L18:
        return true;
    L20:
        if (f(r18, r0) == true) goto L24;
        com.bytedance.ai.utils.g.a.e("MoaGrantingManager", "operateMoaGranting: session identity does not match its key");
        return false;
    L24:
        if (e.remove(r0) == false) goto L26;
        com.bytedance.ai.utils.g.a.i("MoaGrantingManager", "Retry completed authorizationID=" + r17 + ", appletId=" + r16);
    L26:
        ConcurrentHashMap<String, h> r19 = d;
        h r1 = r19.get(r16);
        if (r1 != null) goto L29;
        b(r18);
        if (r10.get(r18.a) != r18) goto L35;
        boolean r20 = true;
    L36:
        if (r20 == true) goto L39;
        return true;
    L39:
        if (r18.a() != null) goto L42;
        c(r18, MoaGrantingResult.GRANTED);
        return true;
    L42:
        h r21 = new h(r18, "moa_granting_" + UUID.randomUUID(), r13, r14, r15);
        if (r19.putIfAbsent(r16, r21) == null) goto L46;
        com.bytedance.ai.utils.g.a.w("MoaGrantingManager", "operateMoaGranting: another authorization owns applet UI, appletId=".concat(r16));
        return false;
    L46:
        r21.g = BuildersKt.launch$default(b, null, null, new MoaGrantingManager$startExecution$1(r21, null), 3, null);
        return true;
    L35:
        r20 = false;
        goto L36
    L29:
        if (r1.getContext() != r18) goto L49;
        return true;
    L49:
        return false;
    }

    public static boolean d(String r10, String r11, String r12, String r13, Function1 r14, Function0 r15) {
        Intrinsics.checkNotNullParameter(r12, "appletId");
        Intrinsics.checkNotNullParameter(r13, "label");
        Intrinsics.checkNotNullParameter(r14, "onHandled");
        Intrinsics.checkNotNullParameter(r15, "onRejected");
        if (r10 == null) goto L105;
        String r16 = StringsKt.trim(r10).toString();
        if (r16 == null) goto L105;
        if (StringsKt.startsWith$default(r16, "moa_granting_", false, 2, null) == true) goto L10;
        r16 = null;
    L10:
        if (r16 == null) goto L105;
    L30:
        ConcurrentHashMap<String, h> r17 = d;
        h r18 = r17.get(StringsKt.trim(r12).toString());
        if (r18 != null) goto L34;
    L36:
        r18 = null;
    L37:
        if (r18 == null) goto L42;
        n r19 = r18.f;
        if ((r19 instanceof q) == false) goto L42;
        q r20 = (q) r19;
    L44:
        if (r20 == null) goto L46;
        Object r21 = new com.bytedance.ai.applet.moa.b(r20);
    L87:
        if ((r21 instanceof com.bytedance.ai.applet.moa.b) == false) goto L89;
        r14.invoke(((com.bytedance.ai.applet.moa.b) r21).a);
    L103:
        return true;
    L89:
        d r22 = d.a;
        if (Intrinsics.areEqual(r21, r22) == false) goto L92;
    L99:
        if (r21 != r22) goto L101;
        String r23 = "not attributable to the live attempt";
    L102:
        com.bytedance.ai.utils.g.a.w("MoaGrantingManager", "reject MOA " + r13 + " (" + r23 + "): applet=" + r12);
        r15.invoke();
        goto L103
    L101:
        r23 = "stale attempt";
        goto L102
    L92:
        if (Intrinsics.areEqual(r21, com.bytedance.ai.applet.moa.c.a) == true) goto L99;
        if (Intrinsics.areEqual(r21, com.bytedance.ai.applet.moa.a.a) == false) goto L98;
        return false;
    L98:
        throw new NoWhenBranchMatchedException();
    L46:
        String r24 = StringsKt.trim(r12).toString();
        if (r24.length() <= 0) goto L49;
        boolean r25 = true;
    L50:
        if (r25 == true) goto L52;
    L54:
        boolean r26 = false;
    L55:
        if (r26 == false) goto L57;
        r21 = d.a;
        goto L87
    L57:
        String r27 = StringsKt.trim(r12).toString();
        h r28 = r17.get(r27);
        if (r28 == null) goto L62;
        if (r16 != null) goto L61;
        com.bytedance.ai.utils.g.a.w("MoaGrantingManager", "MOA callback carries no attempt id while applet=" + r27 + " is executing");
    L61:
        boolean r29 = !Intrinsics.areEqual(r28.b, r16);
    L83:
        if (r29 == false) goto L85;
        r21 = com.bytedance.ai.applet.moa.c.a;
        goto L87
    L85:
        r21 = com.bytedance.ai.applet.moa.a.a;
        goto L87
    L62:
        if (r16 != null) goto L64;
    L66:
        boolean r30 = false;
    L67:
        if (r30 == true) goto L69;
        r29 = false;
        goto L83
    L69:
        Set<i> r31 = c.keySet();
        if ((r31 instanceof Collection) == true) goto L72;
    L74:
        Iterator<T> r32 = r31.iterator();
    L76:
        if (r32.hasNext() == false) goto L80;
        if (Intrinsics.areEqual(((i) r32.next()).a, r27) == false) goto L76;
        r29 = true;
    L81:
        if (r29 == true) goto L83;
        com.bytedance.ai.utils.g.a.i("MoaGrantingManager", "Ignore attempt id of an ended MOA authorization: applet=" + r27);
    L80:
        r29 = false;
        goto L81
    L72:
        if (r31.isEmpty() == false) goto L74;
    L64:
        if (StringsKt.startsWith$default(r16, "moa_granting_", false, 2, null) != true) goto L66;
        r30 = true;
        goto L67
    L52:
        if (r17.get(r24) == null) goto L54;
        r26 = true;
        goto L55
    L49:
        r25 = false;
    L42:
        r20 = null;
        goto L44
    L34:
        if (Intrinsics.areEqual(r18.b, r16) == false) goto L36;
    L105:
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L24
        if (r11 == null) goto L21;
        Uri r34 = UriProtector.parse(r11);     // Catch: Throwable -> L24
        if (r34 == null) goto L21;
        String r35 = UriProtector.getQueryParameter(r34, "__moa_attempt_id");     // Catch: Throwable -> L24
        if (r35 == null) goto L21;
        if (StringsKt.startsWith$default(r35, "moa_granting_", false, 2, null) == false) goto L21;
    L22:
        Object r36 = Result.constructor-impl(r35);     // Catch: Throwable -> L24
    L27:
        if (Result.isFailure-impl(r36) == false) goto L29;
        r36 = null;
    L29:
        r16 = (String) r36;
    L21:
        r35 = null;
    L24:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r36 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    }
}

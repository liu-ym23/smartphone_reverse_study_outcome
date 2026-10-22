package com.obric.assistant.special_input;

import com.larus.account.base.api.ILoginService;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL;
import com.obric.aiagent.assistant.idl.bean.OSkillManagerConfig;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.t1;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class OSkillExtensionSettingRepository {
    public static final OSkillExtensionSettingRepository a = null;
    public static final CoroutineScope b = null;
    public static final Object c = null;
    public static final ReentrantLock d = null;
    public static final AtomicBoolean e = null;
    public static final AtomicBoolean f = null;
    public static final AtomicBoolean g = null;
    public static final AtomicBoolean h = null;
    public static final StateFlowImpl i = null;
    public static final kotlinx.coroutines.flow.b1 j = null;

    public OSkillExtensionSettingRepository() {
    }

    static {
        a = new OSkillExtensionSettingRepository();
        b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        c = new Object();
        d = new ReentrantLock();
        e = new AtomicBoolean(false);
        f = new AtomicBoolean(false);
        g = new AtomicBoolean(false);
        h = new AtomicBoolean(false);
        StateFlowImpl r0 = j1.a(new t0(0));
        i = r0;
        j = kotlinx.coroutines.flow.e.b(r0);
    }

    public static void a() {
        StateFlowImpl r0 = i;
        if (((t0) r0.getValue()).b == true) goto L5;
    L7:
        Object r1 = c;
        monitor-enter(r1);
        t0 r3 = (t0) r0.getValue();     // Catch: Throwable -> L33
        AtomicBoolean r2 = h;     // Catch: Throwable -> L33
        boolean r4 = r2.get();     // Catch: Throwable -> L33
        boolean r5 = r3.b;     // Catch: Throwable -> L33
        if (r5 == false) goto L15;
        if (r4 == false) goto L15;
        monitor-exit(r1);
        return;
    L15:
        if (r5 == false) goto L17;
        boolean r6 = true;
    L19:
        if (r3.b == false) goto L21;
        boolean r7 = r3.a;     // Catch: Throwable -> L33
    L24:
        if (r4 == false) goto L26;
        int r8 = r3.e;     // Catch: Throwable -> L33
    L30:
        r2.set(true);     // Catch: Throwable -> L33
        r0.setValue(t0.a(r3, r7, r6, false, false, r8, false, false, 108));     // Catch: Throwable -> L33
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L33
        monitor-exit(r1);
        return;
    L26:
        OSkillExtensionSettingRepository r10 = a;     // Catch: Throwable -> L33
        r8 = t1.a.O0();     // Catch: Throwable -> L33
        r10.getClass();     // Catch: Throwable -> L33
        if (r8 == 0) goto L30;
        if (r8 == 1) goto L30;
        r8 = -1;
        goto L30
    L21:
        if (r6 == false) goto L23;
        r7 = t1.a.p1();     // Catch: Throwable -> L33
        goto L24
    L23:
        r7 = false;
        goto L24
    L17:
        r6 = t1.a.Y();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    L5:
        if (h.get() == false) goto L7;
    }

    public static boolean c() {
        return ILoginService.a.getAccountInfo().a;
    }

    public static void e() {
        Object r0 = c;
        monitor-enter(r0);
        StateFlowImpl r1 = i;     // Catch: Throwable -> L8
        t0 r2 = (t0) r1.getValue();     // Catch: Throwable -> L8
        r1.setValue(new t0(false, false, false, false, -1, false, false));     // Catch: Throwable -> L8
        monitor-exit(r0);
        f.set(false);
        h.set(false);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, WindowEvent.Params.REASON);
        if (c() == true) goto L6;
        e();
        return;
    L6:
        a();
        t0 r0 = (t0) i.getValue();
        if (r0.c == true) goto L9;
    L11:
        d(r2, false);
        return;
    L9:
        if (r0.f == false) goto L11;
    }

    public static void f(String r10) {
        if (c() == true) goto L6;
        e();
        return;
    L6:
        IAgentSkillManagerIDL r0 = com.obric.aiagent.assistant.idl.n.a(Reflection.getOrCreateKotlinClass(IAgentSkillManagerIDL.class));
        Object r2 = null;
        Integer r3 = null;
        if (r0 != null) goto L89;
        FLogger.a.i("SkillExtSettingRepo", "readRemoteEnabled failed, ipc unavailable, reason=" + r10);
        Boolean r1 = null;
    L24:
        IAgentSkillManagerIDL r4 = com.obric.aiagent.assistant.idl.n.a(Reflection.getOrCreateKotlinClass(IAgentSkillManagerIDL.class));
        if (r4 != null) goto L87;
        FLogger.a.i("SkillExtSettingRepo", "readRemoteOmniSkillAvailableState failed, ipc unavailable, reason=" + r10);
    L52:
        if (r1 != null) goto L67;
        if (r3 != null) goto L67;
        StateFlowImpl r5 = i;
        t0 r6 = (t0) r5.getValue();
        FLogger.a.i("SkillExtSettingRepo", "syncRemoteState keep local/default value, reason=" + r10 + ", enabled=" + r6.a + ", hasLocalCache=" + r6.b + ", omniSkillAvailableState=" + r6.e);
        Object r11 = c;
        monitor-enter(r11);
        r5.setValue(i.a(i.b((t0) r5.getValue(), r1), r3));     // Catch: Throwable -> L63
        monitor-exit(r11);
        if (g.compareAndSet(false, true) == false) goto L91;
        com.obric.aiagent.assistant.idl.n.b(Reflection.getOrCreateKotlinClass(IAgentSkillManagerIDL.class), true, new h());
        return;
    L91:
        return;
    L63:
        th = move-exception;
        throw th;
    L67:
        if (c() == true) goto L70;
        e();
        return;
    L70:
        if (r1 == null) goto L72;
        t1.a.n1(r1.booleanValue());
    L72:
        if (r3 == null) goto L74;
        t1.a.l0(r3.intValue());
    L74:
        Object r7 = c;
        monitor-enter(r7);
        StateFlowImpl r8 = i;     // Catch: Throwable -> L80
        r8.setValue(i.a(i.b((t0) r8.getValue(), r1), r3));     // Catch: Throwable -> L80
        monitor-exit(r7);
        FLogger.a.i("SkillExtSettingRepo", "syncRemoteState success, reason=" + r10 + ", enabled=" + r1 + ", omniSkillAvailableState=" + r3);
        return;
    L80:
        th = move-exception;
        throw th;
    L87:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L42
        String r12 = r4.getSkillManagerStatus("omni_skill_available");     // Catch: Throwable -> L42
        if (r12 == null) goto L32;
        String r13 = StringsKt.trim(r12).toString();     // Catch: Throwable -> L42
        if (r13 == null) goto L32;
        String r14 = r13.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L42
    L34:
        if (Intrinsics.areEqual(r14, "true") == false) goto L37;
        Integer r15 = 1;     // Catch: Throwable -> L42
    L40:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L42
    L44:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L48;
        FLogger.a.e("SkillExtSettingRepo", "readRemoteOmniSkillAvailableState failed, reason=" + r10, r17);
    L48:
        if (Result.isFailure-impl(r16) == true) goto L51;
        r2 = r16;
    L51:
        r3 = (Integer) r2;
        goto L52
    L37:
        if (Intrinsics.areEqual(r14, "false") == false) goto L39;
        r15 = 0;     // Catch: Throwable -> L42
        goto L40
    L39:
        r15 = null;
    L32:
        r14 = null;
    L42:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L44
    L89:
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L15
        OSkillManagerConfig r20 = r0.getSkillManagerConfig();     // Catch: Throwable -> L15
        if (r20 == null) goto L12;
        Boolean r21 = (Boolean) r20.getValue("skill_extension_enabled", Boolean.FALSE);     // Catch: Throwable -> L15
    L13:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L15
    L17:
        Throwable r23 = Result.exceptionOrNull-impl(r22);
        if (r23 == null) goto L21;
        FLogger.a.e("SkillExtSettingRepo", "readRemoteEnabled failed, reason=" + r10, r23);
    L21:
        if (Result.isFailure-impl(r22) == false) goto L23;
        r22 = null;
    L23:
        r1 = (Boolean) r22;
        goto L24
    L12:
        r21 = null;
    L15:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }

    public static void d(String r6, boolean r7) {
        if (r7 == false) goto L6;
        f.set(true);
    L6:
        if (e.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        BuildersKt.launch$default(b, null, null, new OSkillExtensionSettingRepository$requestRemoteRead$1(r6, null), 3, null);
    }
}

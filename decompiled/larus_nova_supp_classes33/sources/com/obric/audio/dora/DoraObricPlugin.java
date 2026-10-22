package com.obric.audio.dora;

import com.bytedance.keva.Keva;
import com.larus.avlink.plugins.o4;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.im.service.audio.z0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.audio.service.ObricAssistantForAudioDelegate;
import com.obric.assistant.m;
import com.obric.assistant.settings.ObricPersonalContextSettingApiDelegate;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.obric.assistant.t1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.i1;
import org.json.JSONObject;
import pf9.o;
import pf9.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class DoraObricPlugin extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> implements o4 {
    public static final Set<String> p = null;
    public final String f;
    public Job g;
    public long h;
    public boolean i;
    public boolean j;
    public Keva k;
    public b l;
    public Job m;
    public final d n;
    public final com.obric.audio.dora.a o;

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final boolean b;
        public final boolean c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            int r2 = 1231;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            if (this.c == true) goto L11;
            r2 = 1237;
        L11:
            return ((((((((((r3 + r2) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h;
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "RuntimeContextSettingsSnapshot(autoGuiEnabledScene=" + this.a + ", localDataSearchEnabled=" + this.b + ", lockedScreenUseEnabled=" + this.c + ", autoGuiExecuteOnLockScreenAuthType=" + this.d + ", chatAndOnlineQAOnLockScreenAuthType=" + this.e + ", localAppDataAccessOnLockScreenAuthType=" + this.f + ", chatHistoryAccessOnLockScreenAuthType=" + this.g + ", simpleCommandExecuteOnLockScreenAuthType=" + this.h + ')';
        }

        public b(int r1, boolean r2, boolean r3, int r4, int r5, int r6, int r7, int r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }
    }

    public static final class c extends z0 {
        public final String a;
        public final /* synthetic */ DoraObricPlugin b;

        public final String g() {
            return this.a;
        }

        public c(DoraObricPlugin r1) {
            this.b = r1;
            this.a = r1.f;
        }

        public final void n(z0.a r4) {
            Intrinsics.checkNotNullParameter(r4, "event");
            Intrinsics.checkNotNullParameter(r4, "event");
            if ((r4 instanceof z) == false) goto L6;
            DoraObricPlugin r0 = this.b;
            long r1 = ((z) r4).c;
            r0.h = r1;
            r0.j = false;
            r0.m3(r1, false);
            return;
        L6:
            if ((r4 instanceof o) == false) goto L12;
            DoraObricPlugin r5 = this.b;
            r5.i = true;
            if ((!v88.a.b(Integer.valueOf(r5.getContext().params().k.s))) == false) goto L13;
            this.b.l3();
            this.b.m3(0, true);
            return;
        L13:
            return;
        }
    }

    public static final class d implements m {
        public final /* synthetic */ DoraObricPlugin a;

        public d(DoraObricPlugin r1) {
            this.a = r1;
        }

        public final void a(String r2) {
            if (r2 != null) goto L4;
        L6:
            this.a.j3(r2);
            return;
        L4:
            if (DoraObricPlugin.p.contains(r2) == true) goto L6;
        }
    }

    public final void Q0(int r1) {
    }

    static {
        p = SetsKt.setOf(new String[]{"auto_gui_enable_scene_2025_1225", "locked_screen_use_enabled", "authentication_type_of_auto_gui_execute_on_lock_screen", "authentication_type_of_chat_and_online_qa_on_lock_screen", "authentication_type_of_local_app_data_access_on_lock_screen", "authentication_type_of_chat_history_access_on_lock_screen", "authentication_type_of_simple_command_execute_on_lock_screen"});
    }

    public static b k3() {
        t1 r0 = t1.a;
        return new b(r0.getAutoGuiEnabledScene(), ObricPersonalContextSettingApiDelegate.b.q(), r0.i(), r0.e1(), r0.k1(), r0.v0(), r0.Q1(), r0.W());
    }

    public final z0 S2() {
        return new c(this);
    }

    public final void g3() {
        t1.a.S0(this.n);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        Keva r2 = this.k;     // Catch: Throwable -> L9
        if (r2 == null) goto L6;
        r2.unRegisterChangeListener(this.o);     // Catch: Throwable -> L9
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L9
    L11:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L14;
        FLogger.a.w(this.f, "unRegister localDataSearchChangedListener failed", r5);
    L14:
        this.k = null;
        Job r6 = this.m;
        if (r6 == null) goto L17;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
    L17:
        this.m = null;
        Job r7 = this.g;
        if (r7 == null) goto L20;
        Job.DefaultImpls.cancel$default(r7, null, 1, null);
    L20:
        this.g = null;
        this.l = null;
        this.i = false;
        super.g3();
        return;
    L6:
        r3 = null;
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final void l3() {
        IObricDoraService r0 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r0 == null) goto L5;
        JSONObject r1 = r0.c();
    L6:
        if (r1 == null) goto L12;
        id9.d r2 = getContext().j();
        if (r2 == null) goto L10;
        r2.p(TriggerMode.UPDATE_PERSONAL_CONTEXT, r1.toString());
    L10:
        FLogger.a.i(this.f, "trigger UPDATE_PERSONAL_CONTEXT, personalContext=" + r1);
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void e3() {
        super.e3();
        Job r0 = this.g;
        Object r1 = null;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        i1 r2 = ObricAssistantForAudioDelegate.b.c5();
        if (r2 == null) goto L10;
        CoroutineScope r3 = getContext().r();
        if (r3 == null) goto L10;
        Job r4 = BuildersKt.launch$default(r3, null, null, new DoraObricPlugin$collectSpecialInputOpenState$1$1(r2, this, null), 3, null);
    L11:
        this.g = r4;
        if (r4 != null) goto L14;
        FLogger.a.w(this.f, "collectSpecialInputOpenState skipped, stateFlow or lifecycleScope is null");
    L14:
        this.l = k3();
        t1.a.B0(this.n);
        Keva r5 = this.k;
        if (r5 == null) goto L38;
        r5.unRegisterChangeListener(this.o);
    L38:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L23
        Object r7 = ObricPersonalContextSettingApiDelegate.b.a();     // Catch: Throwable -> L23
        if ((r7 instanceof Keva) == false) goto L20;
        Keva r8 = (Keva) r7;     // Catch: Throwable -> L23
    L21:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L23
    L25:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L29;
        FLogger.a.w(this.f, "registerLocalDataSearchSettingListener failed", r10);
    L29:
        if (Result.isFailure-impl(r9) == true) goto L32;
        r1 = r9;
    L32:
        Keva r11 = (Keva) r1;
        if (r11 != null) goto L35;
        FLogger.a.w(this.f, "registerLocalDataSearchSettingListener skipped, keva is null");
    L36:
        FLogger.a.i(this.f, "registerRuntimeContextSettingListener, initialSnapshot=" + this.l);
        return;
    L35:
        this.k = r11;
        r11.registerChangeListener(this.o);
        goto L36
    L20:
        r8 = null;
    L23:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L10:
        r4 = null;
        goto L11
    }

    public final String T2() {
        return this.f;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.obric.audio.dora.a] */
    public DoraObricPlugin(com.larus.audio.call.arch.c r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = "DoraObricPlugin";
        this.n = new d(this);
        this.o = new com.obric.audio.dora.a(this);
    }

    public final void j3(String r8) {
        CoroutineScope r1 = getContext().r();
        if (r1 != null) goto L6;
        FLogger.a.w(this.f, "skip checkRuntimeContextSettingsChangedWithDebounce, lifecycleScope is null, key=" + r8);
        return;
    L6:
        Job r0 = this.m;
        if (r0 == null) goto L9;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L9:
        this.m = BuildersKt.launch$default(r1, null, null, new DoraObricPlugin$checkRuntimeContextSettingsChangedWithDebounce$1(this, r8, null), 3, null);
    }

    public final void n3(long r4) {
        IObricDoraService r0 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r0 == null) goto L14;
        Map r5 = r0.a(r4, true);
        if (r5 != null) goto L7;
        return;
    L7:
        if (r5.isEmpty() == true) goto L16;
        JSONObject r6 = new JSONObject();
        r6.put("o_runtime_ctx", new JSONObject(r5).toString());
        id9.d r7 = getContext().j();
        if (r7 == null) goto L12;
        TriggerMode r1 = TriggerMode.UPDATE_UI_CONTEXT;
        JSONObject r2 = new JSONObject();
        r2.put("applet_payload", r6);
        Unit r8 = Unit.INSTANCE;
        r7.p(r1, r2.toString());
    L12:
        FLogger.a.i(this.f, "trigger UPDATE_UI_CONTEXT");
        return;
    L16:
        return;
    }

    public final void m3(long r3, boolean r5) {
        IObricDoraService r0 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r0 == null) goto L14;
        Map r6 = r0.a(r3, r5);
        if (r6 != null) goto L7;
        return;
    L7:
        if (r6.isEmpty() == true) goto L16;
        JSONObject r1 = new JSONObject();
        r1.put("round_id", r3);
        JSONObject r4 = new JSONObject();
        r4.put("o_round_ctx", new JSONObject(r6).toString());
        Unit r7 = Unit.INSTANCE;
        r1.put("params", r4);
        id9.d r8 = getContext().j();
        if (r8 == null) goto L12;
        r8.p(TriggerMode.UPDATE_ROUND_CONTEXT, r1.toString());
    L12:
        FLogger.a.i(this.f, "trigger UPDATE_ROUND_CONTEXT");
        return;
    L16:
        return;
    }

    public final void i0(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "caller");
        Intrinsics.checkNotNullParameter(r1, "caller");
        if ((!v88.a.b(Integer.valueOf(getContext().params().k.s))) == true) goto L6;
        l3();
        n3(this.h);
        return;
    }
}

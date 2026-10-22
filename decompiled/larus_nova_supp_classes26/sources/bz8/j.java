package bz8;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import be8.d;
import be8.e;
import com.larus.bmhome.actionbar.model.AgentMode;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.p0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.component.skill.PcEntryDisplayMode;
import com.larus.bmhome.instruction.g;
import com.larus.bmhome.instruction.l;
import com.larus.bmhome.taskskill.a2;
import com.larus.bmhome.taskskill.service.SkillServiceDelegate;
import com.larus.bmhome.taskskill.w1;
import com.larus.utils.logger.FLogger;
import gz8.b;
import gz8.f;
import gz8.i;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t19.s;
import va8.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j implements a2, k, l {
    public be8.a a;
    public w1 b;
    public Fragment c;
    public String d;
    public c0 e;
    public final String f;

    public static final class a {
    }

    static {
    }

    public final boolean i() {
        return true;
    }

    @Override // bz8.k
    public final boolean Z9() {
        w1 r0 = this.b;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        n("refreshTaskModeAfterActionBarConfigReady");
        return r1;
    L5:
        if (r0.Z9() != true) goto L7;
        r1 = true;
        goto L7
    }

    @Override // bz8.k
    public final String kX() {
        be8.a r0 = this.a;
        if (r0 == null) goto L5;
        String r1 = r0.dC();
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        return "cloud";
    L14:
        return "local_pc";
    L8:
        if (StringsKt.isBlank(r1) == true) goto L11;
        r2 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final void l() {
        n("onParentViewCreated");
    }

    public final void onDestroy() {
        SkillServiceDelegate.a.i(this.f, "ChatJobSkillSceneDelegate.onDestroy");
        this.c = null;
        this.a = null;
        this.b = null;
        this.d = null;
        this.e = null;
    }

    @Override // bz8.k
    public final boolean y70() {
        return n("refreshTaskActionBarFilter");
    }

    public j() {
        this.f = "ChatJobSkillSceneDelegate@" + System.identityHashCode(this);
    }

    public final PcEntryDisplayMode f() {
        return PcEntryDisplayMode.SUB_CONVERSATION;
    }

    @Override // com.larus.bmhome.instruction.l
    public final boolean Vp(ReplyOption r6) {
        Intrinsics.checkNotNullParameter(r6, "targetOption");
        Fragment r0 = this.c;
        if (r0 != null) goto L5;
        return false;
    L5:
        g r2 = s1a.a.g(r0).getAbility(g.class);
        if (r2 != null) goto L8;
        return false;
    L8:
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r6, "option");
        p0 r3 = i.a(r2.tq());
        if (r3 != null) goto L11;
        boolean r4 = false;
    L12:
        if (r4 == false) goto L14;
        return false;
    L14:
        s r1 = s.a;
        Context r5 = r0.getContext();
        String r7 = f.b("scheduledTasks_toast_modeUnsupported");
        r1.getClass();
        s.t(r5, r7);
        FLogger.a.i("ChatJobSkillSceneDelegate", "intercept unsupported reply mode, target=" + r6);
        return true;
    L11:
        int r8 = b.b;
        b r9 = b.a.a(r3);
        int r10 = AgentMode.MOA.getValue();
        Intrinsics.checkNotNullParameter(r6, "option");
        r4 = r9.a.c(r6, r10);
        goto L12
    }

    public final void b(d r3) {
        String r0 = null;
        if (r3 == null) goto L9;
        String r4 = r3.c;
        if (r4 == null) goto L9;
        if ((!StringsKt.isBlank(r4)) == false) goto L9;
        r0 = r4;
    L9:
        this.d = r0;
    }

    public final boolean c(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        ChatParam r3 = s1a.a.g(r2).a(ChatParam.class);
        if (r3 == null) goto L5;
        String r4 = r3.d;
    L7:
        return Intrinsics.areEqual(r4, "chat_job");
    L5:
        r4 = null;
        goto L7
    }

    @Override // bz8.k
    public final Map<String, String> lT(Map<String, String> r5) {
        Map<String, String> r6 = MapsKt.toMutableMap(r5);
        if (r6 != null) goto L5;
        r6 = new LinkedHashMap();
    L5:
        be8.a r0 = this.a;
        if (r0 == null) goto L12;
        String r1 = r0.dC();
        if (r1 == null) goto L12;
        if ((!StringsKt.isBlank(r1)) == false) goto L12;
    L13:
        if (r1 == null) goto L17;
        r6.put("task_skill_local_temp_runtime_type", "2");
        if (SkillServiceDelegate.a.k() == false) goto L17;
        r6.put("send_command", "1");
        r6.put("target_device_id", r1);
    L17:
        be8.a r2 = this.a;
        if (r2 == null) goto L30;
        e r3 = r2.getSelectedFolder();
        if (r3 == null) goto L30;
        String r4 = r3.b;
        if (r4 == null) goto L30;
        if ((!StringsKt.isBlank(r4)) == true) goto L27;
        r4 = null;
    L27:
        if (r4 == null) goto L30;
        r6.put("task_workspace", r4);
    L30:
        if ((!r6.isEmpty()) == false) goto L33;
        return r6;
    L33:
        return null;
    L12:
        r1 = null;
        goto L13
    }

    @Override // bz8.k
    public final void mH(Bundle r7) {
        Intrinsics.checkNotNullParameter(r7, "bundle");
        be8.a r0 = this.a;
        if (r0 == null) goto L35;
        String r1 = r0.dC();
        if (r1 == null) goto L35;
        boolean r3 = true;
        String r4 = null;
        if ((!StringsKt.isBlank(r1)) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L35;
        be8.a r2 = this.a;
        if (r2 == null) goto L19;
        String r5 = r2.nF();
        if (r5 == null) goto L19;
        if ((!StringsKt.isBlank(r5)) == false) goto L19;
        r4 = r5;
    L19:
        r7.putString("pending_pc_device_id", r1);
        if (r4 == null) goto L22;
        r7.putString("pending_pc_device_name", r4);
    L22:
        String r6 = this.d;
        if (r6 == null) goto L25;
        r7.putString("pending_pc_device_type", r6);
    L25:
        FLogger r8 = FLogger.a;
        StringBuilder r9 = new StringBuilder("append selected pc device, deviceId=");
        r9.append(r1);
        r9.append(", hasName=");
        if (r4 == null) goto L28;
        boolean r10 = true;
    L29:
        r9.append(r10);
        r9.append(", hasType=");
        if (this.d != null) goto L33;
        r3 = false;
    L33:
        r9.append(r3);
        r8.i("ChatJobSkillSceneDelegate", r9.toString());
        return;
    L28:
        r10 = false;
    L35:
        FLogger.a.i("ChatJobSkillSceneDelegate", "append selected pc device skipped");
    }

    public final boolean n(String r6) {
        Fragment r0 = this.c;
        if (r0 == null) goto L9;
        t1a.b r1 = s1a.a.g(r0);
        if (r1 == null) goto L9;
        c0 r2 = (c0) r1.getAbility(c0.class);
        if (r2 == null) goto L9;
    L10:
        this.e = r2;
        if (r2 == null) goto L13;
        String r3 = r2.uQ();
    L15:
        if (r3 != null) goto L17;
    L20:
        boolean r4 = true;
    L21:
        if (r4 == false) goto L24;
        FLogger.a.w("ChatJobSkillSceneDelegate", "retain task action bar filter skipped, actionBarScopeId is blank, source=".concat(r6));
        return false;
    L24:
        SkillServiceDelegate.a.r(this.f, "ChatJobSkillSceneDelegate.".concat(r6), r3);
        c0 r7 = this.e;
        if (r7 == null) goto L27;
        r7.KY();
    L27:
        return true;
    L17:
        if (StringsKt.isBlank(r3) == true) goto L20;
        r4 = false;
        goto L21
    L13:
        r3 = null;
    L9:
        r2 = this.e;
        goto L10
    }

    public final void d(Fragment r2, be8.a r3, w1 r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "skillAbility");
        Intrinsics.checkNotNullParameter(r4, "actions");
        this.c = r2;
        this.a = r3;
        this.b = r4;
        if (r2 == null) goto L9;
        t1a.b r5 = s1a.a.g(r2);
        if (r5 == null) goto L9;
        c0 r6 = (c0) r5.getAbility(c0.class);
        if (r6 == null) goto L9;
    L10:
        this.e = r6;
        s1a.a.a(r2, this, k.class);
        s1a.a.a(r2, this, l.class);
        n("onAttach");
        return;
    L9:
        r6 = this.e;
        goto L10
    }
}

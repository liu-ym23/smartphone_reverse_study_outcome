package mea;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.live.api.j;
import com.obric.assistant.live.gr.island.island.template.GRCollapseTemplate;
import com.obric.assistant.live.gr.island.island.template.GRExpandedNormalTemplate;
import com.obric.assistant.spi.keyguard.KeyguardService;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.state.api.v2.core.bean.ObricIslandStateType;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import com.obric.livecard.api.entity.Text;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import pea.e;
import pea.f;
import pea.i;
import sea.g;
import sea.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ObricInteractionScene.values().length];
            r0[ObricInteractionScene.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L35:
            r0[ObricInteractionScene.DEEP_THINK_SCENE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L47:
            r0[ObricInteractionScene.REALTIME_CALL_SCENE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L37:
            r0[ObricInteractionScene.COMPLEX_TASK_SCENE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L10:
            a = r0;
            int[] r1 = new int[ObricIslandStateType.values().length];
            r1[ObricIslandStateType.COMPLEX_TASK_CALL_USER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L41:
            r1[ObricIslandStateType.COMPLEX_TASK_ASK_USER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L29:
            r1[ObricIslandStateType.COMPLEX_TASK_TAKING_OVER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L39:
            r1[ObricIslandStateType.TTS_PLAYING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L33:
            r1[ObricIslandStateType.TTS_END.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
        L43:
            r1[ObricIslandStateType.COMPLEX_TASK_OPERATING_VIRTUAL_SCREEN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
        L17:
            b = r1;
        }
    }

    public static final void a(List<e> r5) {
        if (r5.size() >= 2) goto L6;
        return;
    L6:
        if (r5.size() != 2) goto L22;
        Intent r1 = ((e) ListProtector.get(r5, 0)).c;
        if (r1 == null) goto L10;
        r1.setAction("com.obric.assistant.obric.gr.island.pending.action");
    L10:
        Intent r2 = ((e) ListProtector.get(r5, 1)).c;
        if (r2 == null) goto L13;
        r2.setAction("com.obric.assistant.obric.gr.island.pending.action2");
    L13:
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("adjustActionForActions() set action: ");
        Intent r0 = ((e) ListProtector.get(r5, 0)).c;
        String r6 = null;
        if (r0 == null) goto L16;
        String r7 = r0.getAction();
    L17:
        r4.append(r7);
        r4.append(", ");
        Intent r8 = ((e) ListProtector.get(r5, 1)).c;
        if (r8 == null) goto L20;
        r6 = r8.getAction();
    L20:
        r4.append(r6);
        r3.d("GRIslandImpl", r4.toString());
        return;
    L16:
        r7 = null;
        goto L17
    }

    public static final GRCollapseTemplate b(ObricState r12) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        ObricInteractionScene r0 = r12.getScene();
        if (r0 != null) goto L5;
        int r1 = -1;
    L6:
        pea.c r2 = null;
        pea.a r3 = null;
        if (r1 != 4) goto L43;
        int r4 = a.b[r12.getCurrentIslandState().ordinal()];
        if (r4 != 4) goto L11;
    L39:
        Intrinsics.checkNotNullParameter("miui.focus.pic_doubao_icon", "pic");
        i r13 = c.g(r12);
        if (r13 == null) goto L42;
        int r5 = pea.c.e;
        r2 = pea.c.a.a(r13.a, r13.b, null);
    L42:
        int r6 = pea.b.d;
        GRCollapseTemplate r14 = new GRCollapseTemplate(pea.b.a.a("miui.focus.pic_doubao_icon", 2131244415), r2, null, 4, null);
    L53:
        return r14;
    L11:
        if (r4 == 5) goto L39;
        if (r4 == 6) goto L15;
        Text r15 = j0.a(r12);
        Intrinsics.checkNotNullParameter("miui.focus.pic_complex_task", "pic");
        int r7 = pea.b.d;
        return new GRCollapseTemplate(pea.b.a.a("miui.focus.pic_complex_task", 2131244414), null, new pea.a(r15.getText()), 2, null);
    L15:
        Intrinsics.checkNotNullParameter("miui.focus.pic_complex_task", "pic");
        Object r8 = r12.getExt().get("o_gui_package_name");
        if (r8 == null) goto L31;
        String r9 = r8.toString();
        if (r9 == null) goto L31;
        Context r10 = AppHost.a.getApplication().getApplicationContext();
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r9, "packageName");
        int r11 = r10.getPackageManager().getApplicationInfo(r9, 0).icon;     // Catch: PackageManager.NameNotFoundException -> L25
        if (r11 == 0) goto L26;
        Integer r16 = Integer.valueOf(r11);     // Catch: PackageManager.NameNotFoundException -> L25
    L27:
        FLogger.a.d("GRStateIslandUtils", "getCollapsedRightOperatingIcon appResId: " + r16 + ", packageName: " + r9);
        if (r16 == null) goto L31;
        i r17 = new i("miui.focus.pic_app_icon_".concat(r9), r16.intValue(), r9);
    L32:
        if (r17 == null) goto L34;
        int r18 = pea.c.e;
        pea.c r19 = pea.c.a.a(r17.a, r17.b, r17.c);
    L35:
        int r20 = pea.b.d;
        pea.b r21 = pea.b.a.a("miui.focus.pic_complex_task", 2131244414);
        if (r19 != null) goto L52;
        r3 = new pea.a(j0.a(r12).getText());
    L52:
        return new GRCollapseTemplate(r21, r19, r3);
    L34:
        r19 = null;
    L26:
        r16 = null;
    L31:
        r17 = null;
        goto L32
    L43:
        Intrinsics.checkNotNullParameter("miui.focus.pic_small_doubao_icon", "pic");
        i r22 = c.g(r12);
        if (r22 == null) goto L47;
        int r23 = pea.b.d;
        pea.b r24 = pea.b.a.a("miui.focus.pic_small_doubao_icon", 2131244403);
        int r25 = pea.c.e;
        r14 = new GRCollapseTemplate(r24, pea.c.a.a(r22.a, r22.b, null), null, 4, null);
        goto L53
    L47:
        int r26 = pea.b.d;
        return new GRCollapseTemplate(pea.b.a.a("miui.focus.pic_small_doubao_icon", 2131244403), null, new pea.a(j0.b(r12).getText()), 2, null);
    L5:
        r1 = a.a[r0.ordinal()];
        goto L6
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public static final pea.l c(com.obric.assistant.state.api.v2.core.bean.ObricState r32) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0002: CONST_STR (r1v0 ?? I:java.lang.String) = "<this>" A[DECLARE_VAR] (LINE:16777218) in method: mea.d.c(com.obric.assistant.state.api.v2.core.bean.ObricState):pea.l, file: /private/tmp/nixiang/classes33.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 973
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: mea.d.c(com.obric.assistant.state.api.v2.core.bean.ObricState):pea.l");
    }

    public static final GRExpandedNormalTemplate d(ObricState r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        String r0 = j0.h(r6).getText();
        boolean r2 = false;
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        String r4 = "豆包手机助手";
        if (r1 == false) goto L9;
        r0 = "豆包手机助手";
    L9:
        String r3 = j0.i(r6).getText();
        if (r3.length() != 0) goto L12;
        r2 = true;
    L12:
        if (r2 == true) goto L15;
        r4 = r3;
    L15:
        i r5 = c.i(r6);
        return new GRExpandedNormalTemplate(new f(r0, r4, new pea.d(r5.a, r5.b)), c.h(r6));
    L5:
        r1 = false;
        goto L6
    }

    public static final e e(ObricState r14) {
        ObricIslandStateType r0 = r14.getCurrentIslandState();
        int[] r1 = a.b;
        int r2 = r1[r0.ordinal()];
        Boolean r5 = null;
        Boolean r6 = null;
        e r7 = null;
        Boolean r8 = null;
        if (r2 == 1) goto L20;
        if (r2 == 2) goto L15;
        if (r2 == 3) goto L8;
    L25:
        int r3 = r1[r14.getCurrentIslandState().ordinal()];
        if (r3 == 1) goto L43;
        if (r3 != 2) goto L29;
        if (r7 == null) goto L45;
        b r15 = b.a;
        Context r4 = AppHost.a.getApplication().getApplicationContext();
        r15.getClass();
        r7.c = b.b(r4);
    L45:
        return r7;
    L29:
        if (r3 != 3) goto L31;
        if (r7 == null) goto L45;
        g.a.getClass();
        if (g.d(r14) == false) goto L39;
        b r9 = b.a;
        Context r10 = AppHost.a.getApplication().getApplicationContext();
        r9.getClass();
        Intent r16 = b.c(r10, r14);
    L40:
        r7.c = r16;
        goto L45
    L39:
        b r11 = b.a;
        Context r12 = AppHost.a.getApplication().getApplicationContext();
        sea.b.a.getClass();
        Bundle r17 = sea.b.b(r14);
        r11.getClass();
        r16 = b.f(r12, false, r17);
        goto L40
    L31:
        if (r3 == 6) goto L33;
        FLogger.a.w("GRStateIslandUtils", "should not be here!");
        goto L45
    L33:
        if (r7 == null) goto L45;
        b r13 = b.a;
        Context r18 = AppHost.a.getApplication().getApplicationContext();
        sea.b.a.getClass();
        Bundle r19 = sea.b.b(r14);
        r13.getClass();
        r7.c = b.f(r18, false, r19);
        goto L45
    L43:
        if (r7 == null) goto L45;
        b r20 = b.a;
        Context r21 = AppHost.a.getApplication().getApplicationContext();
        sea.b.a.getClass();
        Bundle r110 = sea.b.b(r14);
        r20.getClass();
        r7.c = b.f(r21, true, r110);
        goto L45
    L8:
        if (j0.j(r14) == true) goto L10;
        return null;
    L10:
        String r111 = AppHost.a.getApplication().getString(2131912213);
        if (KeyguardService.a.isKeyguardLocked() == true) goto L14;
        r6 = Boolean.TRUE;
    L14:
        r7 = new e("miui.focus.action_dialogue_action_btn", null, true, r111, r6, 32741);
        goto L25
    L15:
        String r112 = AppHost.a.getApplication().getString(2131912058);
        if (KeyguardService.a.isKeyguardLocked() == true) goto L19;
        r8 = Boolean.TRUE;
    L19:
        r7 = new e("miui.focus.action_dialogue_action_btn", null, true, r112, r8, 32741);
        goto L25
    L20:
        String r113 = AppHost.a.getApplication().getString(2131911916);
        if (KeyguardService.a.isKeyguardLocked() == true) goto L24;
        r5 = Boolean.TRUE;
    L24:
        r7 = new e("miui.focus.action_dialogue_action_btn", null, true, r113, r5, 32741);
        goto L25
    }

    public static final long f(ObricInteractionScene r5) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        boolean r6 = j.a.s(r5);
        FLogger.a.i("ObricLiveDelegate", "getRequestDismissKeyguardFlags, permission: " + r6);
        if (r6 == true) goto L10;
        return 256;
    L10:
        return 0;
    }

    public static final long g(ObricState r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        ObricInteractionScene r0 = r6.getScene();
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 == 1) goto L34;
        if (r1 == 2) goto L41;
        if (r1 == 3) goto L40;
        if (r1 != 4) goto L35;
        ObricIslandStateType r2 = r6.getCurrentIslandState();
        int r3 = a.b[r2.ordinal()];
        if (r3 == 1) goto L27;
        if (r3 == 2) goto L27;
        if (r3 == 3) goto L21;
        return f(r6.getScene());
    L21:
        if (j0.j(r6) == false) goto L37;
        if (AppHost.a.a().isAppBackground() == false) goto L37;
        long r4 = f(r6.getScene());
    L38:
        return r4 | 8;
    L37:
        return f(r6.getScene());
    L27:
        if (AppHost.a.a().isAppBackground() == false) goto L39;
        r4 = f(r6.getScene());
        goto L38
    L39:
        return f(r6.getScene());
    L35:
        return f(r6.getScene());
    L40:
        return f(r6.getScene());
    L41:
        return f(r6.getScene());
    L34:
        return f(r6.getScene());
    L5:
        r1 = a.a[r0.ordinal()];
        goto L7
    }
}

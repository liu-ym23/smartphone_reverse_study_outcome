package com.larus.bmhome.view.actionbar.edit.kmp;

import android.content.ClipData;
import android.content.Context;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.CompatKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.larus.bmhome.actionbar.model.ActionBarItemLocation;
import com.larus.bmhome.actionbar.model.h1;
import com.larus.bmhome.actionbar.model.i0;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.t1;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.bigimg.BigImagePhotoViewerDialog;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.chat.api.IGaokaoPreferenceService;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.api.s;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.bmhome.view.actionbar.edit.component.ButtonRouterTargetPageStarter;
import com.larus.bmhome.view.actionbar.edit.component.j2;
import com.larus.bmhome.view.actionbar.edit.component.p1;
import com.larus.bmhome.view.actionbar.edit.kmp.widget.KmpCommandWidget;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.home.impl.sdk.FlowAppletServiceImpl;
import com.larus.home.impl.sdk.i1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.h0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import cq8.z0;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import wa8.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l implements dq8.g {
    public final /* synthetic */ com.larus.bmhome.view.actionbar.edit.c a;
    public final /* synthetic */ KmpInstructionEditorViewFactory b;

    public final void a(boolean r2) {
        com.larus.bmhome.view.actionbar.edit.c r0 = this.a;
        if (r0 == null) goto L6;
        r0.setImageStyleRadioSelected(r2);
        return;
    }

    public final void b(dq8.a r21) {
        Intrinsics.checkNotNullParameter(r21, "event");
        a r3 = (a) this.b.o.getValue();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r21, "event");
        String r1 = r21.b.c;
        FragmentActivity r4 = null;
        if (r1 == null) goto L5;
        String r2 = StringsKt.substringBefore$default(r1, "?", null, 2, null);
    L7:
        if (Intrinsics.areEqual(r2, "sslocal://flow/music_creation/write_lyrics") == false) goto L11;
        wy9.b r5 = s1a.d.a(r3.c).getAbility(wy9.b.class);
        if (r5 == null) goto L11;
        aq8.f r6 = r3.d.ki(new aq8.c.b(null));
        if ((r6 instanceof aq8.f.c) == false) goto L15;
        aq8.f.c r7 = (aq8.f.c) r6;
    L16:
        if (r7 == null) goto L18;
        Object r8 = r7.a;
    L20:
        if ((r8 instanceof List) == false) goto L22;
        List r9 = (List) r8;
    L23:
        boolean r10 = r5.oX(r9);
    L24:
        if (r10 == false) goto L26;
        r3.c(r21);
        return;
    L26:
        Fragment r11 = r3.b;
        if (r11 == null) goto L29;
        FragmentActivity r12 = r11.getActivity();
    L31:
        if ((r12 instanceof FragmentActivity) == true) goto L34;
        r12 = null;
    L34:
        if (r12 != null) goto L41;
        Object r13 = r3.a.invoke();
        if ((r13 instanceof FragmentActivity) == false) goto L38;
        r4 = (FragmentActivity) r13;
    L38:
        if (r4 != null) goto L40;
        FLogger.a.e("KmpInstructionButtonRouterDispatcher", "launchTargetPage failed, activity is null");
    L49:
        r3.c(r21);
        return;
    L40:
        r12 = r4;
    L41:
        ButtonRouterTargetPageStarter.a r14 = ButtonRouterTargetPageStarter.f;
        String r15 = r21.b.c;
        String r16 = "";
        if (r15 != null) goto L44;
        r15 = "";
    L44:
        String r17 = r21.c;
        if (r17 == null) goto L48;
        r16 = r17;
    L48:
        z0 r18 = r21.d;
        j2 r19 = new j2(r15, r16, new p1(r18.d, r18.f, r18.g, "chat", r18.c, r18.a, r3.b(), r18.j, r21.b.b));
        b r20 = new b(r3, r21);
        r14.getClass();
        ButtonRouterTargetPageStarter.a.a(r12, r19, r20);
        goto L49
    L29:
        r12 = null;
        goto L31
    L22:
        r9 = null;
        goto L23
    L18:
        r8 = null;
        goto L20
    L15:
        r7 = null;
    L11:
        r10 = false;
        goto L24
    L5:
        r2 = null;
        goto L7
    }

    public final void d(dq8.b r31) {
        Intrinsics.checkNotNullParameter(r31, "event");
        a r3 = (a) this.b.o.getValue();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r31, "event");
        z0 r1 = r31.c;
        com.larus.bmhome.actionbar.model.a r0 = r31.b;
        Map r4 = c0.a;
        c0.b(r0.d, ActionBarItemLocation.DETAIL_PANEL, null);
        String r7 = r1.a;
        String r8 = r1.c;
        String r9 = r1.d;
        String r10 = r1.f;
        String r11 = r1.g;
        String r14 = r0.b;
        String r15 = String.valueOf(r0.a);
        Boolean r2 = r1.i;
        String r5 = r1.h;
        String r26 = r3.b();
        tx9.b.f(r7, r8, r9, r10, r11, null, null, r14, r15, 0, 0, null, null, null, r3.a(), "chat", null, null, null, r26, r5, r2, 964704);
    }

    public final void e(String r4) {
        FLogger.a.i("KmpInstructionEditorViewFactory", "[onMediaSelectorRemove] identifier=" + r4);
        KmpInstructionEditorViewFactory r0 = this.b;
        int r1 = KmpInstructionEditorViewFactory.p;
        com.larus.bmhome.instruction.kmp.a r2 = r0.o();
        if (r2 == null) goto L6;
        r2.nf(r4);
        return;
    }

    public final void f(i0 r2) {
        Intrinsics.checkNotNullParameter(r2, "template");
        com.larus.bmhome.view.actionbar.edit.c r0 = this.a;
        if (r0 == null) goto L6;
        r0.onTabSelected(r2);
        return;
    }

    public final void i(boolean r4) {
        FLogger.a.i("KmpInstructionEditorViewFactory", "[onMediaSelectorOpenAlbum] isReplace=" + r4);
        KmpInstructionEditorViewFactory r0 = this.b;
        int r1 = KmpInstructionEditorViewFactory.p;
        com.larus.bmhome.instruction.kmp.a r2 = r0.o();
        if (r2 == null) goto L6;
        r2.g80(r4);
        return;
    }

    public final void j(int r2) {
        com.larus.bmhome.view.actionbar.edit.c r0 = this.a;
        if (r0 == null) goto L6;
        r0.selectInstructionMenu(r2);
        return;
    }

    public final void k(List<w> r2) {
        Intrinsics.checkNotNullParameter(r2, "optionList");
        com.larus.bmhome.view.actionbar.edit.c r0 = this.a;
        if (r0 == null) goto L6;
        r0.setRatioOptionList(r2);
        return;
    }

    public final void l(Long r2) {
        com.larus.bmhome.view.actionbar.edit.c r0 = this.a;
        if (r0 == null) goto L6;
        r0.setDefaultSelectedImageStyleId(r2);
        return;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [com.larus.bmhome.view.actionbar.edit.kmp.d] */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.larus.bmhome.view.actionbar.edit.kmp.c] */
    public final void n(dq8.i r25) {
        Intrinsics.checkNotNullParameter(r25, "toHostCommand");
        final f r3 = (f) this.b.m.getValue();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r25, "toHostCommand");
        FragmentActivity r5 = "";
        FragmentActivity r6 = null;
        if ((r25 instanceof dq8.i.c) == false) goto L57;
        dq8.i.c r1 = (dq8.i.c) r25;
        com.larus.bmhome.actionbar.model.c r7 = r1.b;
        HashMap r0 = r7.c;
        if (r0 == null) goto L10;
        String r2 = (String) r0.get("message_text");
        if (r2 == null) goto L10;
        String r9 = r2;
    L12:
        if (o0.d(r9) == false) goto L54;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L20
        y r8 = (y) r3.d.invoke();     // Catch: Throwable -> L20
        if (r8 == null) goto L17;
        String r10 = r8.Y1();     // Catch: Throwable -> L20
    L18:
        Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L20
    L23:
        if (Result.isFailure-impl(r11) == false) goto L25;
        r11 = null;
    L25:
        String r12 = (String) r11;
        if (r12 != null) goto L28;
        String r13 = "";
    L29:
        String r15 = UUID.randomUUID().toString();
        s r14 = ILegacyChatUiServiceDelegate.b.t8();
        if (r14 == null) goto L32;
        r14.d(r15);
    L32:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KmpInstructionCommandDispatcher$handleSendUserMessage$1(r13, null), 3, null);
        com.larus.bmhome.instruction.g r16 = (com.larus.bmhome.instruction.g) r3.e.invoke();
        Map r17 = (Map) r3.i.invoke(r7);
        Integer r18 = r7.a;
        if (r18 == null) goto L35;
        FragmentActivity r19 = r18.toString();
    L36:
        if (r19 == null) goto L39;
        r5 = r19;
    L39:
        r17.put("action_bar_command_id", r5);
        if (r16 == null) goto L44;
        Map<String, String> r20 = r16.nK(null);
        if (r20 == null) goto L44;
        r17.putAll(r20);
    L44:
        if (r16 == null) goto L46;
        r6 = Integer.valueOf(r16.Q1());
    L46:
        if (r6 != null) goto L49;
    L51:
        String r21 = "chat_action_bar";
    L52:
        u1.a.f(zh8.a.a.getSender(), r9, r13, r21, r17, null, null, r15, false, null, "KmpInstructionCommandDispatcher#handleSendUserMessage", null, s1a.d.a(r3.h).a(ChatPageContext.class), null, false, 27496);
        goto L54
    L49:
        if (r6.intValue() != 21) goto L51;
        r21 = "deep_research_sug";
        goto L52
    L35:
        r19 = null;
        goto L36
    L28:
        r13 = r12;
        goto L29
    L17:
        r10 = null;
    L20:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L54:
        if (Intrinsics.areEqual(r1.b.j, Boolean.TRUE) == true) goto L202;
        r3.b.invoke();
        return;
    L202:
        return;
    L10:
        r9 = "";
        goto L12
    L57:
        if (Intrinsics.areEqual(r25, dq8.i.e.b) == false) goto L64;
        IFlowSdkDepend r23 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r23 == null) goto L204;
        FlowAppletServiceImpl r24 = r23.g0();
        if (r24 == null) goto L205;
        h0.a.a(r24, new e(r3));
        return;
    L205:
        return;
    L204:
        return;
    L64:
        if ((r25 instanceof dq8.i.f) == false) goto L108;
        dq8.i.f r26 = (dq8.i.f) r25;
        ConstraintLayout r27 = r3.a.get(r26.b);
        if ((r27 instanceof KmpCommandWidget) == false) goto L68;
        ConstraintLayout r28 = (KmpCommandWidget) r27;
    L69:
        com.larus.bmhome.actionbar.model.c r29 = r26.c;
        z0 r30 = r26.d;
        zb8.e r31 = s1a.d.a(r3.h).getAbility(zb8.e.class);
        com.larus.bmhome.instruction.g r32 = (com.larus.bmhome.instruction.g) r3.e.invoke();
        HashMap r110 = new HashMap();
        if (r32 == null) goto L72;
        r110.put("action_bar_template_id", String.valueOf(r32.Q1()));
    L72:
        String r33 = r30.g;
        if (r33 == null) goto L75;
        r110.put("action_bar_key", r33);
    L75:
        String r34 = r30.d;
        if (r34 == null) goto L78;
        r110.put("action_bar_template_type", r34);
    L78:
        Map r35 = (Map) r3.i.invoke(r29);
        HashMap r36 = r29.c;
        if (r36 == null) goto L83;
        String r37 = (String) r36.get("disable_text_check");
        if (r37 == null) goto L83;
        r35.put("disable_text_check", r37);
    L83:
        HashMap r38 = r29.c;
        if (r38 == null) goto L87;
        String r39 = (String) r38.get("scene");
        if (r39 == null) goto L87;
    L88:
        String r111 = r39;
        Integer r40 = r29.a;
        if (r40 == null) goto L91;
        r6 = r40.toString();
    L91:
        if (r6 == null) goto L94;
        r5 = r6;
    L94:
        r35.put("action_bar_command_id", r5);
        if (Intrinsics.areEqual(r35.get("college_entrance_examination"), "1") == false) goto L97;
        r35.put("ban_action_bar_auto_shift", "1");
    L97:
        r110.put("extra_params", r35);
        HashMap r41 = r29.c;
        if (r41 == null) goto L101;
        String r42 = (String) r41.get("click_from");
        if (r42 == null) goto L101;
    L102:
        r110.put("click_from", r42);
        if (r31 == null) goto L105;
        zb8.e.a.b(r31, r111, r110, null, null, null, false, 120);
    L105:
        if (r28 == null) goto L207;
        ViewExtKt.g(r28);
        return;
    L207:
        return;
    L101:
        r42 = "health_explain";
    L87:
        r39 = "health_second_camera";
        goto L88
    L68:
        r28 = null;
        goto L69
    L108:
        if (Intrinsics.areEqual(r25, dq8.i.b.b) == false) goto L149;
        ICoreInputAbility r43 = (ICoreInputAbility) r3.f.invoke();
        boolean r44 = true;
        if (r43 == null) goto L113;
        r43.g2(1, true);
    L113:
        if (r43 == null) goto L115;
        ICoreInputAbility.b.e(r43, "KmpInstructionCommandDispatcher.PASTE_URL", null, false, 6);
    L115:
        Context r45 = (Context) r3.c.invoke();
        if (r45 == null) goto L214;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L143
        IFlowSdkDepend r47 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L143
        if (r47 == null) goto L141;
        r47.d0();     // Catch: Throwable -> L143
        ClipData r48 = i1.a.e(r45, "bpea-ai-podcast");     // Catch: Throwable -> L143
        if (r48 == null) goto L141;
        if (r48.getItemCount() <= 0) goto L138;
        FragmentActivity r49 = r48.getItemAt(0).getText();     // Catch: Throwable -> L143
        if (r49 == null) goto L131;
        r5 = r49;
    L131:
        if (r5.length() <= 0) goto L133;
        boolean r50 = true;
    L134:
        if (r50 == false) goto L138;
        va8.o r51 = (va8.o) r3.g.invoke();     // Catch: Throwable -> L143
        if (r51 == null) goto L139;
        r51.Ug(r5.toString());     // Catch: Throwable -> L143
    L139:
        if (r44 == true) goto L141;
        t19.s.a.getClass();     // Catch: Throwable -> L143
        t19.s.t(r45, "Clipboard is empty");     // Catch: Throwable -> L143
        goto L141
    L133:
        r50 = false;
    L138:
        r44 = false;
    L141:
        Object r52 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L143
    L146:
        if (Result.exceptionOrNull-impl(r52) == null) goto L209;
        t19.s.a.getClass();
        t19.s.t(r45, "Paste failed");
        return;
    L209:
        return;
    L143:
        th = move-exception;
        Result.Companion r53 = Result.Companion;
        r52 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L146
    L214:
        return;
    L149:
        if ((r25 instanceof dq8.i.d) == false) goto L158;
        com.larus.bmhome.actionbar.model.c r54 = ((dq8.i.d) r25).b;
        n r55 = n.a;
        com.larus.bmhome.view.actionbar.edit.n r56 = n.b;
        if (r56 == null) goto L211;
        FragmentActivity r57 = r54.d;
        if (r57 == null) goto L156;
        r5 = r57;
    L156:
        r56.a(r5);
        return;
    L211:
        return;
    L158:
        if ((r25 instanceof dq8.i.a) == false) goto L195;
        dq8.i.a r58 = (dq8.i.a) r25;
        ConstraintLayout r59 = r3.a.get(r58.b);
        if ((r59 instanceof KmpCommandWidget) == false) goto L162;
        ConstraintLayout r60 = (KmpCommandWidget) r59;
    L163:
        final com.larus.bmhome.actionbar.model.c r61 = r58.c;
        Context r62 = (Context) r3.c.invoke();
        if (r62 != null) goto L170;
        if (r60 == null) goto L167;
        r62 = r60.getContext();
    L168:
        if (r62 != null) goto L170;
        return;
    L167:
        r62 = null;
    L170:
        final Context r63 = r62;
        Result.Companion r64 = Result.Companion;     // Catch: Throwable -> L177
        if (r60 == null) goto L174;
        Fragment r65 = CompatKt.findFragment(r60);     // Catch: Throwable -> L177
    L175:
        Object r66 = Result.constructor-impl(r65);     // Catch: Throwable -> L177
    L180:
        if (Result.isFailure-impl(r66) == false) goto L182;
        r66 = null;
    L182:
        Fragment r67 = (Fragment) r66;
        if (r67 == null) goto L216;
        FragmentActivity r68 = r67.getActivity();
        if ((r68 instanceof FragmentActivity) == false) goto L188;
        r6 = r68;
    L188:
        if (r6 == null) goto L217;
        LifecycleOwner r69 = r67.getViewLifecycleOwner();
        IGaokaoPreferenceService r70 = (IGaokaoPreferenceService) ServiceManager.get().getService(IGaokaoPreferenceService.class);
        if (r70 == null) goto L213;
        r70.a(r6, r69, new c(r3, r61), new d(r63));
        return;
    L213:
        return;
    L217:
        return;
    L216:
        return;
    L174:
        r65 = null;
    L177:
        th = move-exception;
        Result.Companion r71 = Result.Companion;
        r66 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L180
    L162:
        r60 = null;
        goto L163
    L195:
        throw new NoWhenBranchMatchedException();
    }

    public final void onInstructionMusicTemplateSelected(bq8.a r2) {
        com.larus.bmhome.view.actionbar.edit.c r0 = this.a;
        if (r0 == null) goto L6;
        r0.onInstructionMusicTemplateSelected(r2);
        return;
    }

    public l(com.larus.bmhome.view.actionbar.edit.c r1, KmpInstructionEditorViewFactory r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void c(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "widgetId");
        Intrinsics.checkNotNullParameter(r3, "from");
        if (Intrinsics.areEqual(this.b.j, r2) == true) goto L5;
        return;
    L5:
        this.b.j = null;
        com.larus.bmhome.view.actionbar.edit.c r4 = this.a;
        if (r4 != null) goto L8;
        return;
    L8:
        r r0 = r4.getCurrentInstructionConf();
        if (r0 == null) goto L14;
        h1 r1 = r0.c;
        if (r1 == null) goto L14;
        String r5 = r1.a;
        if (r5 == null) goto L14;
    L15:
        r4.onInputHintChanged(r5, r3);
        return;
    L14:
        r5 = this.b.i;
        goto L15
    }

    public final void g(t1 r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "paramFilterConf");
        com.larus.bmhome.view.actionbar.edit.c r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 == false) goto L7;
        r0.setOptionParamFilterConf(r2);
        return;
    L7:
        r0.onParamFilterConfChanged(r2);
    }

    public final void h(String r24, String r25) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[onMediaSelectorPreview] hasUrl=");
        boolean r3 = true;
        if (r24 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        r1.append(!r4);
        r0.i("KmpInstructionEditorViewFactory", r1.toString());
        LinearLayout r2 = this.b.h;
        if (r2 != null) goto L13;
        return;
    L13:
        if (r25 != null) goto L15;
    L23:
        if (r24 != null) goto L25;
    L30:
        String r5 = null;
    L31:
        if (r5 != null) goto L33;
        return;
    L33:
        String r6 = r5;
    L42:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L36
        new BigImagePhotoViewerDialog(r2.getContext(), CollectionsKt.listOf(new n1(r6)), null, new uo8.k(MapsKt.emptyMap(), null), false, null, null, null, null, null, null, false, false, false, 32756).v(0, r2, "KmpInstructionEditorViewFactory");     // Catch: Throwable -> L36
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L36
    L38:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L44;
        FLogger.a.e("KmpInstructionEditorViewFactory", "[onMediaSelectorPreview] error=" + r9.getMessage());
        return;
    L44:
        return;
    L36:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L38
    L25:
        if (r24.length() > 0) goto L28;
        r3 = false;
    L28:
        if (r3 == false) goto L30;
        r5 = r24;
        goto L31
    L15:
        if (r25.length() <= 0) goto L17;
        boolean r11 = true;
    L18:
        if (r11 == false) goto L20;
        r6 = r25;
    L21:
        if (r6 == null) goto L23;
    L20:
        r6 = null;
        goto L21
    L17:
        r11 = false;
        goto L18
    L5:
        if (StringsKt.isBlank(r24) == true) goto L8;
        r4 = false;
        goto L9
    }

    public final void onInputHintChanged(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "from");
        com.larus.bmhome.view.actionbar.edit.c r0 = this.a;
        if (r0 == null) goto L6;
        r0.onInputHintChanged(r2, r3);
        return;
    }

    public final void m(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "widgetId");
        Intrinsics.checkNotNullParameter(r3, "hint");
        Intrinsics.checkNotNullParameter(r4, "from");
        this.b.j = r2;
        com.larus.bmhome.view.actionbar.edit.c r5 = this.a;
        if (r5 == null) goto L6;
        r5.onInputHintChanged(r3, r4);
        return;
    }
}

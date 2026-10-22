package com.larus.uaigc.music.applet;

import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.view.actionbar.custom.w2;
import com.larus.instruction.service.IInstructionService;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.open.log.TraceLevel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\"\b\u0000\u0018\u0000 P2\u00060\u0001j\u0002`\u00022\u00020\u00032\u00020\u0004:\u0001PB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020-H\u0002J\u0010\u00102\u001a\u00020-2\u0006\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020-H\u0002J\u0010\u00106\u001a\u00020-2\u0006\u00107\u001a\u000208H\u0002J\u0018\u00109\u001a\u00020-2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;H\u0002J\b\u0010=\u001a\u00020;H\u0016J\u0010\u0010>\u001a\u00020-2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u0002082\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020C2\u0006\u0010E\u001a\u00020CH\u0016J\b\u0010F\u001a\u00020GH\u0002J\u0012\u0010H\u001a\u0004\u0018\u00010C2\u0006\u0010E\u001a\u00020CH\u0016J\b\u0010I\u001a\u00020CH\u0016J\u0012\u0010J\u001a\u0004\u0018\u00010C2\u0006\u0010K\u001a\u00020;H\u0016J\b\u0010L\u001a\u00020;H\u0016J\n\u0010M\u001a\u0004\u0018\u00010+H\u0016J\b\u0010N\u001a\u00020-H\u0016J\f\u0010O\u001a\u00020+*\u00020+H\u0002R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\f\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/larus/uaigc/music/applet/MusicAppletInstructionEditorComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/uaigc/music/applet/MusicAppletInstructionEditorAbility;", "Lcom/larus/uaigc/bean/instruction/IMusicAppletInstructionHostAbility;", "<init>", "()V", "instructionEditorViewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "getInstructionEditorViewModel", "()Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "instructionEditorViewModel$delegate", "Lkotlin/Lazy;", "argumentData", "Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "getArgumentData", "()Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "argumentData$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "instructionPanelAbility", "Lcom/larus/uaigc/music/applet/MusicTemplateAppletInstructionPanelAbility;", "getInstructionPanelAbility", "()Lcom/larus/uaigc/music/applet/MusicTemplateAppletInstructionPanelAbility;", "instructionPanelAbility$delegate", "instructionCoreAbility", "Lcom/larus/bmhome/instruction/core/api/IInstructionCoreAbility;", "getInstructionCoreAbility", "()Lcom/larus/bmhome/instruction/core/api/IInstructionCoreAbility;", "instructionCoreAbility$delegate", "inputDepend", "com/larus/uaigc/music/applet/MusicAppletInstructionEditorComponent$inputDepend$1", "Lcom/larus/uaigc/music/applet/MusicAppletInstructionEditorComponent$inputDepend$1;", "instructionEditorFactory", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewFactory;", "instructionBizAdapterFactory", "Lcom/larus/bmhome/instruction/biz/IInstructionBizAdapterFactory;", "editorContainer", "Landroid/widget/LinearLayout;", "musicSendInstructionConf", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionConf;", "onAttach", "", "onViewCreated", "view", "Landroid/view/View;", "initMusicInstructionBizAdapter", "openMusicInstruction", "actionBarItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "observeInstructionPanelVisibility", "updateInstructionPanelVisibility", "visible", "", "updateHostBackground", "attrRes", "", "fallbackColorRes", "currentInstructionType", "onMusicTemplateSelected", "template", "Lcom/larus/bmhome/instruction/core/model/music/MusicGenTemplate;", "checkMusicInstructionInputNotLegal", "input", "", "buildSendMessageContent", "userInput", "buildMusicModeItem", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionItem;", "getActionBarInstructionParam", "getAiGenTypeMobValue", "getDefaultHint", "index", "getCurrentSelectTabIndex", "getCurrentInstructionConf", "onDestroy", "withMusicSendFormats", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MusicAppletInstructionEditorComponent extends BaseContentWidget implements f, wy9.a {
    public static final /* synthetic */ int w = 0;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final b r;
    public com.larus.bmhome.view.actionbar.edit.b s;
    public vp8.i t;
    public LinearLayout u;
    public com.larus.bmhome.actionbar.model.r v;

    public static final class a {
    }

    public static final class b implements com.larus.bmhome.view.actionbar.edit.n {
        public final /* synthetic */ MusicAppletInstructionEditorComponent a;

        public final String b() {
            MusicAppletInstructionEditorComponent r0 = this.a;
            int r1 = MusicAppletInstructionEditorComponent.w;
            va8.o r2 = (va8.o) r0.o.getValue();
            if (r2 == null) goto L5;
            String r3 = r2.u7();
        L6:
            if (r3 != null) goto L9;
            return "";
        L9:
            return r3;
        L5:
            r3 = null;
            goto L6
        }

        public b(MusicAppletInstructionEditorComponent r1) {
            this.a = r1;
        }

        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "clickCommand");
        }
    }

    static {
    }

    public final com.larus.bmhome.view.actionbar.edit.c Y2() {
        return (com.larus.bmhome.view.actionbar.edit.c) this.m.getValue();
    }

    @Override // com.larus.uaigc.music.applet.f
    public final String c0() {
        vp8.i r0 = this.t;
        if (r0 == null) goto L5;
        String r1 = r0.c0();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final void onDestroy() {
        com.larus.bmhome.view.actionbar.edit.b r0 = this.s;
        if (r0 == null) goto L5;
        r0.m();
    L5:
        vp8.i r1 = this.t;
        if (r1 == null) goto L8;
        r1.onDestroy();
    L8:
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.f(com.larus.ui.arch.component.internal.attach.a.b(this, this), f.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.f(com.larus.ui.arch.component.internal.attach.a.b(this, this), wy9.a.class);
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
    }

    public MusicAppletInstructionEditorComponent() {
        this.m = LazyKt.lazy(new g(this));
        this.n = LazyKt.lazy(new h(this));
        this.o = LazyKt.lazy(new i(this));
        this.p = LazyKt.lazy(new j(this));
        this.q = LazyKt.lazy(new k(this));
        this.r = new b(this);
    }

    @Override // com.larus.uaigc.music.applet.f
    public final int Q1() {
        Integer r0 = Y2().getInstructionType();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    @Override // com.larus.uaigc.music.applet.f
    public final int S4() {
        return ((Number) Y2().getInstructionSelectMenuPosition().getValue()).intValue();
    }

    @Override // com.larus.uaigc.music.applet.f
    public final com.larus.bmhome.actionbar.model.r getCurrentInstructionConf() {
        return Y2().getCurrentInstructionConf();
    }

    public final void y2() {
        Y2().setCreationActionBar(Boolean.TRUE);
        IInstructionService.Companion r2 = IInstructionService.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.s = IInstructionService.a.a(r2, null, null, com.larus.ui.arch.component.internal.attach.a.b(this, this), this, 3);
        l r1 = new l(this);
        vp8.i r3 = IAIChatUgcAIGCService.a.M();
        r3.a(new com.larus.uaigc.music.b(this, r1));
        r3.onAttach();
        this.t = r3;
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, f.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, wy9.a.class);
    }

    @Override // com.larus.uaigc.music.applet.f
    public final String Is(String r12) {
        Intrinsics.checkNotNullParameter(r12, "userInput");
        com.larus.bmhome.instruction.j r0 = IAIChatUgcAIGCService.a.e0();
        Integer r2 = Y2().getInstructionType();
        com.larus.bmhome.view.actionbar.edit.b r4 = this.s;
        com.larus.bmhome.actionbar.model.r r1 = this.v;
        if (r1 != null) goto L5;
        r1 = Y2().getCurrentInstructionConf();
    L5:
        com.larus.bmhome.actionbar.model.r r3 = r0.e(r2, r12, r4, r1, ((Number) Y2().getInstructionSelectMenuPosition().getValue()).intValue());
        Object r8 = null;
        if (r3 != null) goto L21;
        return null;
    L21:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L10
        Object r13 = Result.constructor-impl(xt7.d.b.a(com.larus.bmhome.actionbar.model.r.Companion.serializer(), r0.c(r12, r3, Y2(), this.s, Y2().getChosenMsgInstruction(), Y2().getChosenImgInspirePrompt())));     // Catch: Throwable -> L10
    L12:
        Throwable r6 = Result.exceptionOrNull-impl(r13);
        if (r6 == null) goto L16;
        FLogger.a.e("MusicAppletInstructionEditor", "build music applet instruction param failed", r6);
    L16:
        if (Result.isFailure-impl(r13) == true) goto L20;
        r8 = r13;
    L20:
        return (String) r8;
    L10:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // com.larus.uaigc.music.applet.f
    public final String O3(int r3) {
        com.larus.bmhome.view.actionbar.edit.c r0 = Y2();
        com.larus.bmhome.view.actionbar.edit.b r1 = this.s;
        if (r1 == null) goto L7;
        Integer r2 = r1.j();
        if (r2 == null) goto L7;
        int r4 = r2.intValue();
    L9:
        return r0.getHintStr(r3, r4);
    L7:
        r4 = 0;
        goto L9
    }

    public final void m3(boolean r4) {
        if (r4 == false) goto L10;
        LinearLayout r5 = this.u;
        if (r5 == null) goto L6;
        com.larus.utils.e1.x(r5);
    L6:
        va8.o r6 = (va8.o) this.o.getValue();
        if (r6 == null) goto L9;
        r6.G60(v19.c.b(2130970688, getContext(), 2131239146));
    L9:
        h3(2130970531, 2131102535);
        return;
    L10:
        LinearLayout r7 = this.u;
        if (r7 == null) goto L13;
        com.larus.utils.e1.o(r7);
    L13:
        va8.o r8 = (va8.o) this.o.getValue();
        if (r8 == null) goto L16;
        r8.G60(v19.c.b(2130970685, getContext(), 2131239137));
    L16:
        h3(2130970529, 2131102529);
    }

    @Override // com.larus.uaigc.music.applet.f
    public final void mZ(bq8.a r3) {
        Intrinsics.checkNotNullParameter(r3, "template");
        wp8.c r0 = (wp8.c) this.q.getValue();
        if (r0 == null) goto L5;
        r0.ki(new aq8.c.c(r3));
    L5:
        Y2().onInstructionMusicTemplateSelected(r3);
    }

    public final void onViewCreated(View r8) {
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r8, "view");
        LinearLayout r9 = (LinearLayout) F2().findViewById(2131375333);
        if (r9 != null) goto L6;
        FLogger.a.e("MusicAppletInstructionEditor", "create music applet instruction editor failed, container is null");
        return;
    L6:
        this.u = r9;
        r9.setBackgroundResource(v19.c.b(2130970697, getContext(), 2131239177));
        vp8.i r0 = this.t;
        if (r0 == null) goto L9;
        r0.b(r9);
    L9:
        vp8.i r10 = this.t;
        if (r10 == null) goto L12;
        r10.d(Y2());
    L12:
        u1 r11 = (u1) this.p.getValue();
        if (r11 == null) goto L18;
        kotlinx.coroutines.flow.b1 r12 = r11.h30();
        if (r12 == null) goto L18;
        m3(!((Boolean) r12.getValue()).booleanValue());
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MusicAppletInstructionEditorComponent$observeInstructionPanelVisibility$1(r12, this, null), 3, null);
    L18:
        ny9.s r13 = (ny9.s) this.n.getValue();
        if (r13 == null) goto L24;
        com.larus.bmhome.actionbar.model.z0 r14 = r13.f();
        if (r14 == null) goto L25;
        ov(r14);
        return;
    L25:
        return;
    }

    @Override // com.larus.uaigc.music.applet.f
    public final void ov(com.larus.bmhome.actionbar.model.z0 r21) {
        Intrinsics.checkNotNullParameter(r21, "actionBarItem");
        com.larus.bmhome.actionbar.model.r r3 = r21.q;
        String r2 = null;
        if (r3 == null) goto L54;
        com.larus.bmhome.actionbar.model.h1 r4 = r3.c;
        com.larus.bmhome.actionbar.model.j1 r5 = r3.e;
        if (r4 != null) goto L7;
        com.larus.bmhome.actionbar.model.h1 r14 = new com.larus.bmhome.actionbar.model.h1(null, null, null, null, null, 1023);
    L8:
        if (r4 == null) goto L17;
        String r6 = r4.c;
        if (r6 == null) goto L17;
        if ((!StringsKt.isBlank(r6)) == true) goto L15;
        r6 = null;
    L15:
        if (r6 == null) goto L17;
    L18:
        com.larus.bmhome.actionbar.model.h1 r7 = com.larus.bmhome.actionbar.model.h1.a(r14, null, r6, 1019);
        if (r5 != null) goto L21;
        com.larus.bmhome.actionbar.model.j1 r9 = new com.larus.bmhome.actionbar.model.j1(null, 16777215);
    L22:
        if (r5 == null) goto L31;
        String r8 = r5.a;
        if (r8 == null) goto L31;
        if ((!StringsKt.isBlank(r8)) == true) goto L29;
        r8 = null;
    L29:
        if (r8 == null) goto L31;
    L32:
        String r10 = r8;
        if (r5 == null) goto L42;
        String r11 = r5.b;
        if (r11 == null) goto L42;
        if ((!StringsKt.isBlank(r11)) == true) goto L40;
        r11 = null;
    L40:
        if (r11 == null) goto L42;
    L43:
        String r12 = r11;
        if (r5 == null) goto L52;
        String r13 = r5.c;
        if (r13 == null) goto L52;
        if ((!StringsKt.isBlank(r13)) == false) goto L50;
        r2 = r13;
    L50:
        if (r2 == null) goto L52;
    L53:
        r2 = com.larus.bmhome.actionbar.model.r.a(r3, null, r7, com.larus.bmhome.actionbar.model.j1.a(r9, r10, r12, r2, null, null, null, null, null, null, 16777208), null, 4075);
    L52:
        r2 = getContext().getString(2131907940);
    L42:
        r11 = getContext().getString(2131907949);
    L31:
        r8 = getContext().getString(2131907948);
        goto L32
    L21:
        r9 = r5;
    L17:
        r6 = getContext().getString(2131907950);
        goto L18
    L7:
        r14 = r4;
    L54:
        String r15 = r2;
        LinearLayout r16 = this.u;
        com.larus.bmhome.view.actionbar.edit.b r17 = this.s;
        if (r15 == null) goto L69;
        if (r16 == null) goto L69;
        if (r17 == null) goto L69;
        this.v = r15;
        com.larus.bmhome.view.actionbar.edit.c r18 = Y2();
        r18.setCurrentCustomActionBarItem(r21);
        r18.setCurrentInstructionConfig(r15);
        String r1 = r21.e;
        if (r1 != null) goto L62;
        r1 = "";
    L62:
        r18.setActionBarName(r1, String.valueOf(((com.larus.bmhome.actionbar.model.r) r15).a), ((com.larus.bmhome.actionbar.model.r) r15).g);
        ny9.s r19 = (ny9.s) this.n.getValue();
        if (r19 == null) goto L67;
        ChatParam r20 = r19.c();
        if (r20 == null) goto L67;
        r18.bindChatParam(r20);
    L67:
        r16.removeAllViews();
        com.larus.bmhome.view.actionbar.edit.b.a.a(r17, r15, r16, Y2(), null, null, this.r, new com.larus.bmhome.view.actionbar.edit.d(Y2().getInstructionDefaultParams()), null, false, null, 920);
        r17.onViewShow();
        return;
    L69:
        FLogger.a.e("MusicAppletInstructionEditor", "open music applet instruction failed, required state is missing");
    }

    @Override // com.larus.uaigc.music.applet.f
    public final boolean x(String r2) {
        Intrinsics.checkNotNullParameter(r2, "input");
        vp8.i r0 = this.t;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.x(r2);
    }

    @Override // com.larus.uaigc.music.applet.f
    public final String y6(String r25) {
        Intrinsics.checkNotNullParameter(r25, "userInput");
        com.larus.bmhome.view.actionbar.edit.b r1 = this.s;
        Integer r2 = null;
        if (r1 == null) goto L5;
        List r3 = r1.b();
    L6:
        if (r3 != null) goto L8;
        r3 = CollectionsKt.emptyList();
    L8:
        List r4 = r3;
        boolean r6 = false;
        if ((r4 instanceof Collection) == true) goto L11;
    L13:
        Iterator r5 = r4.iterator();
    L15:
        if (r5.hasNext() == false) goto L25;
        Integer r9 = ((com.larus.bmhome.actionbar.model.u) r5.next()).b;
        if (r9 != null) goto L20;
    L22:
        boolean r10 = false;
    L23:
        if (r10 == false) goto L15;
        boolean r7 = true;
    L26:
        if (r7 == false) goto L28;
    L27:
        List r8 = r3;
        w2 r11 = IAIChatUgcAIGCService.a.z0();
        com.larus.bmhome.actionbar.model.r r12 = this.v;
        if (r12 != null) goto L45;
        r12 = Y2().getCurrentInstructionConf();
    L45:
        return w2.a.a(r11, r25, r12, r8, Y2().getChosenMsgInstruction(), Y2().getChosenImgInspirePrompt(), ((Number) Y2().getInstructionSelectMenuPosition().getValue()).intValue(), null, 64);
    L28:
        vp8.i r13 = this.t;
        if (r13 == null) goto L39;
        Integer r14 = r13.X1();
        if (r14 == null) goto L39;
        if (r14.intValue() != 0) goto L35;
        r6 = true;
    L35:
        if (r6 == true) goto L37;
        r2 = r14;
    L37:
        if (r2 == null) goto L39;
        int r15 = r2.intValue();
    L40:
        r3 = CollectionsKt.plus(CollectionsKt.listOf(new com.larus.bmhome.actionbar.model.u(null, 7, null, xt7.d.b.a(com.larus.bmhome.actionbar.model.i0.Companion.serializer(), new com.larus.bmhome.actionbar.model.i0(CollectionsKt.listOf(new com.larus.bmhome.actionbar.model.w(Long.valueOf(r15), null, null, null, 0, null, 1, 8126462)))), null, null, null, 245)), r4);
    L39:
        r15 = 1;
        goto L40
    L20:
        if (r9.intValue() != 7) goto L22;
        r10 = true;
    L25:
        r7 = false;
        goto L26
    L11:
        if (r4.isEmpty() == false) goto L13;
    L5:
        r3 = null;
        goto L6
    }

    public final void h3(int r4, int r5) {
        int r6 = ContextCompat.getColor(getContext(), v19.c.b(r4, getContext(), r5));
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r0 == null) goto L5;
        r0.setBackgroundColor(r6);
    L5:
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r7 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r7 == null) goto L17;
        Window r8 = r7.getWindow();
        if (r8 == null) goto L18;
        View r9 = r8.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L14;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == com.larus.home.impl.utils.c.a) goto L14;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");
    L14:
        if (r9 == null) goto L19;
        r9.setBackgroundColor(r6);
        return;
    L19:
        return;
    L18:
        return;
    }
}

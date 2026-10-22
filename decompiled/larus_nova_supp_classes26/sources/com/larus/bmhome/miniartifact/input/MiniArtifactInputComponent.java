package com.larus.bmhome.miniartifact.input;

import android.content.Context;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import br8.j;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.actionbar.model.h1;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.z8;
import com.larus.bmhome.instruction.k;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.mainbot.api.miniartifact.MiniArtifactBizInfo;
import com.larus.mainbot.api.miniartifact.MiniArtifactInputContent;
import com.larus.mainbot.api.miniartifact.MiniArtifactProductParams;
import com.larus.mainbot.api.miniartifact.MiniArtifactResource;
import com.larus.mainbot.api.miniartifact.MiniArtifactTemplateParams;
import com.larus.mainbot.impl.databinding.LarusMiniArtifactInputBinding;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import t19.s;
import va8.l;
import va8.m;
import va8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 M2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001MB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020>H\u0017J\b\u0010?\u001a\u00020@H\u0002J\b\u0010A\u001a\u00020;H\u0002J\u0012\u0010B\u001a\u00020\u00072\b\u0010C\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010D\u001a\u000204H\u0002J\u0010\u0010E\u001a\u00020;2\u0006\u0010F\u001a\u00020\u0007H\u0002J\b\u0010G\u001a\u00020;H\u0016J\u001c\u0010H\u001a\u00020;2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020403H\u0016J\u0010\u0010J\u001a\u00020;2\u0006\u0010K\u001a\u00020\u0007H\u0016J\b\u0010L\u001a\u00020\u0007H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0013\u001a\u0004\b \u0010!R\u001d\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0013\u001a\u0004\b%\u0010&R\u001d\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0013\u001a\u0004\b*\u0010+R\u001d\u0010-\u001a\u0004\u0018\u00010.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0013\u001a\u0004\b/\u00100R\u001c\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u000204\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/larus/bmhome/miniartifact/input/MiniArtifactInputComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/bmhome/miniartifact/input/IMiniArtifactInputAbility;", "<init>", "()V", "TAG", "", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "Lkotlin/Lazy;", "instructionAbility", "Lcom/larus/bmhome/instruction/IInstructionLogicAbility;", "getInstructionAbility", "()Lcom/larus/bmhome/instruction/IInstructionLogicAbility;", "instructionAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "speakerAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "getSpeakerAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "speakerAbility$delegate", "selectAttachmentAbility", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/IMultiAttachmentSelectorAbility;", "getSelectAttachmentAbility", "()Lcom/larus/uaigc/bean/createpage/component/mediacontainer/IMultiAttachmentSelectorAbility;", "selectAttachmentAbility$delegate", "coreInputManager", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "getCoreInputManager", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "coreInputManager$delegate", "sendInterceptor", "Lkotlin/Function1;", "", "lastVisibilityStatus", "currentMultiAttachmentController", "Lcom/larus/bmhome/instruction/IMultiAttachmentSelectorController;", "inputContentId", "miniArtifactHint", "onAttach", "", "onViewCreated", "view", "Landroid/view/View;", "getMiniArtifactTemplateParams", "Lcom/larus/mainbot/api/miniartifact/MiniArtifactTemplateParams;", "initInputStatus", "getActionSource", "currentPageName", "checkFileSuccess", "send", "prompt", "onDestroy", "setOnActionSendClickInterceptor", "interceptor", "setMiniArtifactHint", "hint", "getMiniArtifactHint", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniArtifactInputComponent extends BaseContentWidget implements br8.a {
    public static final /* synthetic */ int A = 0;
    public final String m;
    public int n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public Function1<? super String, Boolean> v;
    public boolean w;
    public k x;
    public String y;
    public String z;

    public static final class a {
        public static boolean a() {
            s09.a r0 = PollingConfigService.a.d();
            if (r0 == null) goto L10;
            Map r1 = r0.a;
            if (r1 == null) goto L10;
            Object r2 = r1.get("mini_art_dg");
            if (r2 != null) goto L9;
            r2 = "";
        L9:
            String r3 = (String) r2;
        L12:
            return Intrinsics.areEqual(r3, "1");
        L10:
            r3 = null;
            goto L12
        }
    }

    public static final class b implements m {
        public final /* synthetic */ MiniArtifactInputComponent a;

        public final Fragment getChatFragment() {
            return null;
        }

        public final l iX() {
            LarusMiniArtifactInputBinding r0 = LarusMiniArtifactInputBinding.a(this.a.F2());
            Intrinsics.checkNotNull(r0);
            return new br8.b(r0, r0.d);
        }

        public b(MiniArtifactInputComponent r1) {
            this.a = r1;
        }
    }

    public static final class c implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public c(br8.e r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public static final class d implements Function0<ICoreInputAbility> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ICoreInputAbility.class));
        }
    }

    public static final class e implements Function0<com.larus.bmhome.instruction.h> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.h.class));
        }
    }

    public static final class f implements Function0<o> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(o.class));
        }
    }

    public static final class g implements Function0<com.larus.bmhome.instruction.g> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.g.class));
        }
    }

    public static final class h implements Function0<com.larus.bmhome.chat.component.bottom.core.speaker.l> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.core.speaker.l.class));
        }
    }

    public static final class i implements Function0<ry9.h> {
        public final /* synthetic */ AttachReceiver a;

        public i(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ry9.h.class));
        }
    }

    static {
    }

    public final ICoreInputAbility Y2() {
        return (ICoreInputAbility) this.o.getValue();
    }

    public final String h3() {
        String r0 = this.z;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L24;
        IActionBarService r2 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r2 == null) goto L29;
        z0 r3 = r2.e(31);
        if (r3 == null) goto L30;
        r r4 = r3.q;
        if (r4 == null) goto L31;
        h1 r5 = r4.c;
        if (r5 == null) goto L32;
        String r6 = r5.a;
        if (r6 != null) goto L23;
        return "";
    L23:
        return r6;
    L32:
        return "";
    L31:
        return "";
    L30:
        return "";
    L29:
        return "";
    L24:
        String r7 = this.z;
        if (r7 != null) goto L28;
        return "";
    L28:
        return r7;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    public final void onDestroy() {
        Lazy r0 = br8.l.a;
        String r1 = this.y;
        Intrinsics.checkNotNullParameter(r1, "inputContentId");
        ((Map) br8.l.a.getValue()).remove(r1);
    }

    public MiniArtifactInputComponent() {
        this.m = "MiniArtifactInputComponent";
        this.n = 2131365588;
        this.o = LazyKt.lazy(new d(this));
        this.p = LazyKt.lazy(new e(this));
        this.q = LazyKt.lazy(new f(this));
        this.r = LazyKt.lazy(new g(this));
        this.s = LazyKt.lazy(new h(this));
        this.t = LazyKt.lazy(new i(this));
        this.u = LazyKt.lazy(new br8.c(this));
        this.y = "";
    }

    public final MiniArtifactTemplateParams m3() {
        MiniArtifactTemplateParams r0 = s1a.d.a(this).a(MiniArtifactTemplateParams.class);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new MiniArtifactTemplateParams(null, null, null, null, null, null, 63, null);
    }

    public final void y2() {
        String r0 = h3();
        if (r0.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L17;
        ICoreInputAbility r2 = Y2();
        if (r2 == null) goto L13;
        r2.Uu(r0, false);
    L13:
        o r3 = (o) this.q.getValue();
        if (r3 == null) goto L18;
        r3.HH(r0);
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final int U2() {
        return this.n;
    }

    public final void X2(int r1) {
        this.n = r1;
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [br8.e] */
    public final void onViewCreated(View r8) {
        Intrinsics.checkNotNullParameter(r8, "view");
        s1a.d.a(this).c(new b(this), m.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this)).c(this, br8.a.class);
        z8 r0 = (z8) this.u.getValue();
        if (r0 == null) goto L5;
        r0.z9(true);
    L5:
        z8 r1 = (z8) this.u.getValue();
        if (r1 == null) goto L8;
        r1.R8();
    L8:
        z8 r2 = (z8) this.u.getValue();
        if (r2 == null) goto L11;
        r2.n9(true);
    L11:
        z8 r3 = (z8) this.u.getValue();
        if (r3 == null) goto L14;
        r3.X8();
    L14:
        ICoreInputAbility r4 = Y2();
        if (r4 == null) goto L17;
        r4.s20(8);
    L17:
        o r5 = (o) this.q.getValue();
        if (r5 == null) goto L20;
        r5.Jv();
    L20:
        com.larus.bmhome.instruction.g r6 = (com.larus.bmhome.instruction.g) this.r.getValue();
        if (r6 == null) goto L23;
        r6.EF(new br8.d(this));
    L23:
        ry9.h r7 = (ry9.h) this.t.getValue();
        if (r7 == null) goto L28;
        final LiveData r9 = r7.ja();
        if (r9 == null) goto L28;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r9.observe(com.larus.ui.arch.component.internal.attach.a.b(this, this), new c(new br8.e(this, r9)));
    L28:
        ICoreInputAbility r10 = Y2();
        if (r10 == null) goto L31;
        r10.tr(new br8.f(this));
    L31:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r11 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.s.getValue();
        if (r11 == null) goto L34;
        com.larus.bmhome.chat.component.bottom.core.speaker.l.a.b(r11, new br8.g(this));
    L34:
        o r12 = (o) this.q.getValue();
        if (r12 == null) goto L37;
        r12.ra();
    L37:
        o r13 = (o) this.q.getValue();
        if (r13 == null) goto L40;
        r13.GM(new br8.h(this));
    L40:
        ViewExtKt.l(F2().findViewById(2131375324), null, null, null, new br8.i(this), 7);
        F2().getViewTreeObserver().addOnGlobalLayoutListener(new j(this));
        F2().findViewById(2131375324).setBackground(ContextCompat.getDrawable(getContext(), 2131239326));
    }

    public final void p3(String r28) {
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r2 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        if (r2 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L11;
        FLogger.a.w(this.m, "send() called but fragment is not added. Aborting.");
        return;
    L11:
        ry9.h r4 = (ry9.h) this.t.getValue();
        if (r4 == null) goto L32;
        LiveData r5 = r4.ja();
        if (r5 == null) goto L32;
        Map r6 = (Map) r5.getValue();
        if (r6 == null) goto L32;
        if (r6.isEmpty() == true) goto L32;
        Iterator r7 = r6.entrySet().iterator();
    L22:
        if (r7.hasNext() == false) goto L32;
        Map.Entry r8 = (Map.Entry) r7.next();
        if ((((ry9.k) r8.getValue()).b instanceof ry9.j.g) == false) goto L26;
    L29:
        boolean r9 = true;
    L30:
        if (r9 == true) goto L22;
        boolean r10 = false;
    L33:
        if (r10 == true) goto L36;
        FLogger.a.i(this.m, "checkFileSuccess is false");
        s r0 = s.a;
        Context r11 = getContext();
        r0.getClass();
        s.s(r11, 2131905685);
        return;
    L36:
        com.larus.bmhome.instruction.g r12 = (com.larus.bmhome.instruction.g) this.r.getValue();
        if (r12 == null) goto L39;
        r12.A1();
    L39:
        ICoreInputAbility r13 = Y2();
        if (r13 == null) goto L42;
        r13.p80(true);
    L42:
        o r14 = (o) this.q.getValue();
        if (r14 == null) goto L45;
        r14.ra();
    L45:
        k r15 = this.x;
        if (r15 == null) goto L48;
        NestedFileContent r16 = r15.T();
    L49:
        MiniArtifactTemplateParams r17 = m3();
        MiniArtifactInputContent r18 = r17.getMiniArtifactInputContent();
        if (r18 != null) goto L53;
        r18 = new MiniArtifactInputContent(null, null, null, null, null, 31, null);
    L53:
        if (r16 == null) goto L67;
        List r19 = r16.getEntities();
        if (r19 == null) goto L67;
        List r20 = r19;
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator r22 = r20.iterator();
    L58:
        if (r22.hasNext() == false) goto L66;
        UplinkEntityContent r23 = ((UplinkFileEntity) r22.next()).getUplinkEntityContent();
        if (r23 == null) goto L64;
        Image r24 = r23.getUplinkImageInfo();
        if (r24 == null) goto L64;
        String r110 = r24.key;
    L65:
        r21.add(new MiniArtifactResource(null, r110, null, 5, null));
    L64:
        r110 = null;
        goto L65
    L66:
        ArrayList r25 = r21;
    L68:
        Map r26 = r18.getTrackParams();
        if (r26 == null) goto L130;
        Intrinsics.checkNotNullParameter(this, "<this>");
        HashMap<String, Object> r27 = ar8.b.a(r26, com.larus.ui.arch.component.internal.attach.a.b(this, this));
        MiniArtifactInputContent r29 = r17.getMiniArtifactInputContent();
        if (r29 == null) goto L75;
        MiniArtifactBizInfo r30 = r29.getMiniArtifactBizInfo();
        if (r30 == null) goto L75;
        String r31 = r30.getTemplateId();
    L76:
        r27.put("template_id", r31);
        MiniArtifactInputContent r32 = r17.getMiniArtifactInputContent();
        if (r32 == null) goto L81;
        MiniArtifactBizInfo r33 = r32.getMiniArtifactBizInfo();
        if (r33 == null) goto L81;
        String r34 = r33.getTemplateVersion();
    L82:
        r27.put("template_version", r34);
        r27.put("template_name", r17.getTemplateTitle());
        IActionBarService r35 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r35 == null) goto L129;
        z0 r36 = r35.e(31);
        if (r36 == null) goto L129;
        r27.put("action_bar_key", r36.b);
        r27.put("action_bar_template_id", 31);
        MiniArtifactInputContent r37 = r17.getMiniArtifactInputContent();
        if (r37 == null) goto L93;
        List r38 = r37.getMiniArtifactResources();
        if (r38 == null) goto L93;
        if ((!r38.isEmpty()) != true) goto L93;
        boolean r39 = true;
    L94:
        if (r39 == false) goto L96;
        String r40 = "chat_album_preview_click";
    L97:
        r27.put("content_source_entrance", r40);
        String r41 = ar8.b.c(r27);
        r27.put("scene", r41);
        r27.put("is_action_bar", Integer.valueOf(Intrinsics.areEqual(r41, "chat_action_bar") ? 1 : 0));
        MiniArtifactBizInfo r42 = r18.getMiniArtifactBizInfo();
        if (r42 == null) goto L100;
        String r43 = r42.getTemplateId();
    L102:
        if (o0.d(r43) == false) goto L128;
        boolean r44 = !Intrinsics.areEqual(r28, r18.getContent());
        if (r25 == null) goto L109;
        ArrayList r45 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r25, 10));
        Iterator r111 = r25.iterator();
    L107:
        if (r111.hasNext() == false) goto L110;
        r45.add(((MiniArtifactResource) r111.next()).getUri());
    L110:
        List r112 = r18.getMiniArtifactResources();
        if (r112 == null) goto L120;
        List r113 = r112;
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator r115 = r113.iterator();
    L114:
        if (r115.hasNext() == false) goto L121;
        MiniArtifactResource r116 = (MiniArtifactResource) r115.next();
        if (r116 == null) goto L118;
        String r117 = r116.getUri();
    L119:
        r114.add(r117);
        goto L114
    L118:
        r117 = null;
    L121:
        boolean r46 = !Intrinsics.areEqual(r45, r114);
        if (r44 == true) goto L126;
        if (r46 == true) goto L126;
        String r47 = "use_template";
    L127:
        r27.put("original_content_source", r47);
    L126:
        r47 = "change_template";
        goto L127
    L120:
        r114 = null;
        goto L121
    L109:
        r45 = null;
        goto L110
    L128:
        r27.put("original_content_source", "");
        goto L129
    L100:
        r43 = null;
        goto L102
    L96:
        r40 = "";
    L93:
        r39 = false;
    L129:
        Unit r48 = Unit.INSTANCE;
        HashMap<String, Object> r49 = r27;
    L131:
        MiniArtifactInputContent r50 = MiniArtifactInputContent.copy$default(r18, null, r28, r25, null, r49, 9, null);
        FLogger.a.i(this.m, "send: " + r50);
        String r51 = UUID.randomUUID().toString();
        this.y = r51;
        Lazy r52 = br8.l.a;
        Intrinsics.checkNotNullParameter(r51, "inputContentId");
        if (r50 == null) goto L187;
        ((Map) br8.l.a.getValue()).put(r51, r50);
    L187:
        Result.Companion r53 = Result.Companion;     // Catch: Throwable -> L180
        int r54 = ar8.a.a;     // Catch: Throwable -> L180
        if (r50 == null) goto L138;
        r50.getContent();     // Catch: Throwable -> L180
    L138:
        String r55 = this.y;     // Catch: Throwable -> L180
        if (r50 == null) goto L152;
        List r56 = r50.getMiniArtifactResources();     // Catch: Throwable -> L180
        if (r56 == null) goto L152;
        List r57 = r56;     // Catch: Throwable -> L180
        ArrayList r58 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r57, 10));     // Catch: Throwable -> L180
        Iterator r59 = r57.iterator();     // Catch: Throwable -> L180
    L144:
        if (r59.hasNext() == false) goto L151;
        MiniArtifactResource r60 = (MiniArtifactResource) r59.next();     // Catch: Throwable -> L180
        if (r60 == null) goto L149;
        String r61 = r60.getUri();     // Catch: Throwable -> L180
        if (r61 == null) goto L149;
    L150:
        r58.add(r61);     // Catch: Throwable -> L180
    L149:
        r61 = "";
        goto L150
    L151:
        ArrayList r210 = r58;
    L153:
        if (r50 == null) goto L157;
        MiniArtifactBizInfo r62 = r50.getMiniArtifactBizInfo();     // Catch: Throwable -> L180
        if (r62 == null) goto L157;
        String r211 = r62.getTemplateId();     // Catch: Throwable -> L180
    L158:
        if (r50 == null) goto L162;
        MiniArtifactBizInfo r63 = r50.getMiniArtifactBizInfo();     // Catch: Throwable -> L180
        if (r63 == null) goto L162;
        String r212 = r63.getTemplateVersion();     // Catch: Throwable -> L180
    L163:
        Intrinsics.checkNotNullParameter(this, "<this>");     // Catch: Throwable -> L180
        TraceFragment r1 = com.larus.ui.arch.component.internal.attach.a.b(this, this);     // Catch: Throwable -> L180
        if ((r1 instanceof TraceFragment) == false) goto L166;
        TraceFragment r64 = r1;     // Catch: Throwable -> L180
    L167:
        if (r64 == null) goto L169;
        String r213 = r64.k();     // Catch: Throwable -> L180
    L170:
        ar8.a.b(r55, r210, r211, r212, Boolean.TRUE, r213);     // Catch: Throwable -> L180
        Function1<? super String, Boolean> r65 = this.v;     // Catch: Throwable -> L180
        if (r65 != null) goto L173;
    L175:
        boolean r118 = false;
    L176:
        if (r118 == false) goto L178;
        return;
    L178:
        int r66 = com.larus.bmhome.miniartifact.product.r.a;     // Catch: Throwable -> L180
        FragmentActivity r67 = s1a.a.getActivity(this);     // Catch: Throwable -> L180
        Serializable r68 = new MiniArtifactProductParams(r17.getInputPreviewWebUrl(), this.y, null, Boolean.FALSE, null, r50.getTrackParams(), null, null, 212, null);     // Catch: Throwable -> L180
        Intrinsics.checkNotNullParameter(r67, "activity");     // Catch: Throwable -> L180
        com.bytedance.router.i r69 = SmartRouter.buildRoute(r67, "//flow/mini_artifact_product_page");     // Catch: Throwable -> L180
        r69.c.putExtra("mini_artifact_product_page_navigation_params", r68);     // Catch: Throwable -> L180
        r69.d();     // Catch: Throwable -> L180
        Object r70 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L180
    L182:
        Throwable r71 = Result.exceptionOrNull-impl(r70);
        if (r71 == null) goto L185;
        FLogger.a.e(this.m, "send: " + r71);
    L185:
        FLogger.a.i(this.m, "onSend: " + r28 + ' ' + r16);
        return;
    L173:
        if (((Boolean) r65.invoke(this.y)).booleanValue() != true) goto L175;
        r118 = true;
        goto L176
    L169:
        r213 = null;
        goto L170
    L166:
        r64 = null;
    L162:
        r212 = null;
    L157:
        r211 = null;
    L152:
        r210 = null;
    L180:
        th = move-exception;
        Result.Companion r72 = Result.Companion;
        r70 = Result.constructor-impl(ResultKt.createFailure(th));
    L81:
        r34 = null;
    L75:
        r31 = null;
        goto L76
    L130:
        r49 = null;
    L67:
        r25 = null;
        goto L68
    L48:
        r16 = null;
        goto L49
    L26:
        if ((((ry9.k) r8.getValue()).b instanceof ry9.j.c) == true) goto L29;
        r9 = false;
    L32:
        r10 = true;
        goto L33
    L5:
        if (r2.isAdded() != true) goto L7;
        r3 = true;
        goto L8
    }

    @Override // br8.a
    public final void xI(Function1<? super String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        this.v = r2;
    }
}

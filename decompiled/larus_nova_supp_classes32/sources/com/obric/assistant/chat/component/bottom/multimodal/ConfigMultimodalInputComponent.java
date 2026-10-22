package com.obric.assistant.chat.component.bottom.multimodal;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.component.bottom.bottommenu.f1;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.platform.IFlowSdkDepend;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.SafeExtKt;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.spi.startup.AssistantStartupTelemetry;
import com.obric.assistant.spi.startup.IAssistantStartupTelemetry;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import laa.m;
import org.json.JSONObject;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0001TB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u0002042\u0006\u0010?\u001a\u000204H\u0016J\u0018\u0010@\u001a\u00020=2\u0006\u0010A\u001a\u0002042\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020=H\u0016J\b\u0010E\u001a\u00020=H\u0016J\b\u0010F\u001a\u00020=H\u0016J\u0010\u0010G\u001a\u00020/2\u0006\u0010H\u001a\u000202H\u0016J\u0012\u0010I\u001a\u00020/2\b\u0010J\u001a\u0004\u0018\u000102H\u0016J\b\u0010K\u001a\u00020=H\u0002J\b\u0010L\u001a\u00020=H\u0002J\u0010\u0010M\u001a\u00020/2\u0006\u0010N\u001a\u000202H\u0002J\u0010\u0010O\u001a\u00020=2\u0006\u0010N\u001a\u000202H\u0002J\b\u0010P\u001a\u00020=H\u0016J\b\u0010Q\u001a\u00020/H\u0002J\b\u0010R\u001a\u00020=H\u0002J\b\u0010S\u001a\u00020=H\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"R\u001d\u0010$\u001a\u0004\u0018\u00010%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\n\u001a\u0004\b&\u0010'R\u001d\u0010)\u001a\u0004\u0018\u00010*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b+\u0010,R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u00107\u001a\u0004\u0018\u0001088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\n\u001a\u0004\b9\u0010:¨\u0006U"}, d2 = {"Lcom/obric/assistant/chat/component/bottom/multimodal/ConfigMultimodalInputComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/chat/bottom/sub/IObricMultimodalInputAbility;", "<init>", "()V", "chatWindowAbility", "Lcom/obric/assistant/ability/IOrionChatWindowAbility;", "getChatWindowAbility", "()Lcom/obric/assistant/ability/IOrionChatWindowAbility;", "chatWindowAbility$delegate", "Lkotlin/Lazy;", "windowExtraViewAbility", "Lcom/obric/assistant/window/ability/IObricWindowExtraViewAbility;", "getWindowExtraViewAbility", "()Lcom/obric/assistant/window/ability/IObricWindowExtraViewAbility;", "windowExtraViewAbility$delegate", "multimodalInputAbility", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "getMultimodalInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "multimodalInputAbility$delegate", "multimodalPanelAbility", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalPanelAbility;", "getMultimodalPanelAbility", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalPanelAbility;", "multimodalPanelAbility$delegate", "chatCameraAbility", "Lcom/larus/bmhome/camera/IChatCameraAbility;", "getChatCameraAbility", "()Lcom/larus/bmhome/camera/IChatCameraAbility;", "chatCameraAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "conversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "conversationAbility$delegate", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "panelItemProcessorRegistered", NameKeys.UnloadStrategy_No_Strategy, "phoneOperationCameraUiConfigApplied", "pendingLegacyCameraAttemptId", NameKeys.UnloadStrategy_No_Strategy, "pendingLegacyCameraRetryCount", NameKeys.UnloadStrategy_No_Strategy, "phoneOperationPanelItemProcessor", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalPanelAbility$PanelItemConfigProcessor;", "bottomMenuAbility", "Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "getBottomMenuAbility", "()Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "bottomMenuAbility$delegate", "onUpdateBottomMenuHeight", NameKeys.UnloadStrategy_No_Strategy, "curHeight", "normalHeight", "applyResourceBarItemStyle", "viewType", "itemView", "Landroid/view/View;", "onMultimodalViewCreated", "onStart", "onFragmentViewDestroyed", "openPhoneOperationAttachmentCamera", "clickFrom", "openAiKeyCamera", "startupAttemptId", "openPendingAiKeyCameraIfNeeded", "tryOpenPendingAiKeyCamera", "isActiveCameraStartupAttempt", "attemptId", "clearPendingLegacyCameraAttempt", "clearPhoneOperationCameraUiConfig", "openPhoneOperationAttachmentAlbum", "registerPhoneOperationPanelItemProcessor", "unregisterPhoneOperationPanelItemProcessor", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConfigMultimodalInputComponent extends ComponentFeature implements ada.d {
    public static final /* synthetic */ int v = 0;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public boolean p;
    public boolean q;
    public String r;
    public int s;
    public final com.obric.assistant.chat.component.bottom.multimodal.a t;
    public final Lazy u;

    public static final class a {
    }

    public static final class b implements Function0<m> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(m.class));
        }
    }

    public static final class c implements Function0<xha.e> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(xha.e.class));
        }
    }

    public static final class d implements Function0<com.larus.bmhome.chat.component.bottom.multimodal.g> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.multimodal.g.class));
        }
    }

    public static final class e implements Function0<com.larus.bmhome.chat.component.bottom.multimodal.h> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.multimodal.h.class));
        }
    }

    public static final class f implements Function0<zb8.e> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(zb8.e.class));
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

    public static final class h implements Function0<y> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(y.class));
        }
    }

    public static final class i implements Function0<f1> {
        public final /* synthetic */ AttachReceiver a;

        public i(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(f1.class));
        }
    }

    public static final class j implements Function0<de8.c> {
        public final /* synthetic */ AttachReceiver a;

        public j(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).g(Reflection.getOrCreateKotlinClass(de8.c.class));
        }
    }

    static {
    }

    public final void A2() {
        String r6 = this.r;
        if (r6 == null) goto L5;
        IAssistantStartupTelemetry.a.a(AssistantStartupTelemetry.a, r6, "dropped", "camera_legacy_host_destroyed", null, 24);
        uga.c.a(r6);
    L5:
        this.r = null;
        this.s = 0;
        if (this.p == false) goto L12;
        com.larus.bmhome.chat.component.bottom.multimodal.h r1 = (com.larus.bmhome.chat.component.bottom.multimodal.h) this.k.getValue();
        if (r1 == null) goto L11;
        r1.q80(this.t);
    L11:
        this.p = false;
    L12:
        Iy();
    }

    public final void F2() {
        if (this.r == null) goto L5;
        return;
    L5:
        de8.c r0 = (de8.c) this.o.getValue();
        if (r0 != null) goto L8;
        return;
    L8:
        Bundle r1 = r0.b;
        if (r1 == null) goto L28;
        String r2 = r1.getString("obric_startup_attempt_id");
        if (r2 != null) goto L13;
        return;
    L13:
        if ((!StringsKt.isBlank(r2)) == true) goto L16;
        r2 = null;
    L16:
        if (r2 != null) goto L18;
        return;
    L18:
        if (r0.v() == true) goto L20;
        return;
    L20:
        Bundle r3 = r0.b;
        if (r3 == null) goto L24;
        r3.remove("auto_open_plus_camera");
        Unit r4 = Unit.INSTANCE;
    L24:
        if (uga.c.b(r2) == true) goto L26;
        return;
    L26:
        this.r = r2;
        this.s = 0;
        L2();
        return;
    }

    @Override // ada.d
    public final void Iy() {
        if (this.q == true) goto L5;
        return;
    L5:
        zb8.e r0 = (zb8.e) this.l.getValue();
        if (r0 == null) goto L8;
        r0.md(null);
    L8:
        this.q = false;
    }

    public final void L2() {
        String r6 = this.r;
        if (r6 != null) goto L6;
        return;
    L6:
        if (uga.c.b(r6) == true) goto L10;
        this.r = null;
        this.s = 0;
        uga.c.a(r6);
        return;
    L10:
        if (WV(r6) == false) goto L12;
        return;
    L12:
        this.s++;
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (this.s >= 15) goto L17;
        if (r0 == null) goto L17;
        SafeExtKt.b(r0, new ConfigMultimodalInputComponent$tryOpenPendingAiKeyCamera$1(this), 100);
        return;
    L17:
        IAssistantStartupTelemetry.a.a(AssistantStartupTelemetry.a, r6, "dropped", "camera_legacy_exact_launch_unavailable", null, 24);
        uga.c.a(r6);
        this.r = null;
        this.s = 0;
        com.larus.bmhome.chat.component.bottom.multimodal.g r1 = (com.larus.bmhome.chat.component.bottom.multimodal.g) this.j.getValue();
        if (r1 == null) goto L21;
        r1.QS();
        return;
    }

    @Override // ada.d
    public final void ma() {
        if (((f1) this.u.getValue()) != null) goto L5;
        FLogger.a.w("ConfigMultimodalInputComponent", "onMultimodalViewCreated: not found bottomMenuAbility");
    L5:
        FLogger.a.i("ConfigMultimodalInputComponent", "onMultimodalViewCreated");
        f1 r0 = (f1) this.u.getValue();
        if (r0 == null) goto L8;
        r0.aJ();
    L8:
        xha.e r1 = (xha.e) this.i.getValue();
        if (r1 == null) goto L12;
        r1.Cq();
    L12:
        if (this.p == true) goto L18;
        com.larus.bmhome.chat.component.bottom.multimodal.h r2 = (com.larus.bmhome.chat.component.bottom.multimodal.h) this.k.getValue();
        if (r2 == null) goto L18;
        r2.xp(this.t);
        r2.d6();
        this.p = true;
    L18:
        F2();
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [com.obric.assistant.chat.component.bottom.multimodal.a] */
    public ConfigMultimodalInputComponent() {
        this.h = LazyKt.lazy(new b(this));
        this.i = LazyKt.lazy(new c(this));
        this.j = LazyKt.lazy(new d(this));
        this.k = LazyKt.lazy(new e(this));
        this.l = LazyKt.lazy(new f(this));
        this.m = LazyKt.lazy(new g(this));
        this.n = LazyKt.lazy(new h(this));
        this.o = LazyKt.lazy(new j(this));
        this.t = new com.obric.assistant.chat.component.bottom.multimodal.a(this);
        this.u = LazyKt.lazy(new i(this));
    }

    public final void onStart() {
        F2();
    }

    @Override // ada.d
    public final boolean WV(final String r8) {
        xe8.a r0 = null;
        if (r8 != null) goto L5;
    L7:
        r8 = null;
    L9:
        if (r8 != null) goto L11;
    L13:
        IFlowSdkDepend r3 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r3 == null) goto L16;
        r3.x();
    L16:
        final zb8.e r4 = (zb8.e) this.l.getValue();
        if (r4 != null) goto L19;
        return false;
    L19:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r5 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        if ((r5 instanceof xe8.a) == false) goto L22;
        r0 = (xe8.a) r5;
    L22:
        if (r0 != null) goto L24;
        return false;
    L24:
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r6 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r6 != null) goto L27;
        return false;
    L27:
        final HashMap r2 = new HashMap();
        r2.put("chat_key", Long.valueOf(r0.getChatUniqueKey()));
        r2.put("click_from", "plus_panel");
        f1 r1 = (f1) this.u.getValue();
        if (r1 == null) goto L32;
        Map r7 = r1.wV();
        if (r7 == null) goto L32;
        r2.putAll(r7);
    L32:
        Object r9 = r2.get("extra_params");
        if ((r9 instanceof JSONObject) == false) goto L36;
        JSONObject r10 = new JSONObject(((JSONObject) r9).toString());
    L39:
        if (r8 == null) goto L41;
        r10.put("obric_startup_attempt_id", r8);
    L41:
        r2.put("extra_params", r10);
        SafeExtKt.b(r6, new com.obric.assistant.chat.component.bottom.multimodal.b(r8, this, r4, r2), 100);
        return true;
    L36:
        if ((r9 instanceof Map) == false) goto L38;
        r10 = new JSONObject((Map) r9);
        goto L39
    L38:
        r10 = new JSONObject();
        goto L39
    L11:
        if (uga.c.b(r8) == true) goto L13;
        return false;
    L5:
        if ((!StringsKt.isBlank(r8)) == false) goto L7;
        goto L7
    }

    @Override // ada.d
    public final boolean qL(final String r4) {
        Intrinsics.checkNotNullParameter(r4, "clickFrom");
        if (com.obric.assistant.task.skill.f.d() == true) goto L5;
        return false;
    L5:
        final zb8.e r0 = (zb8.e) this.l.getValue();
        if (r0 != null) goto L8;
        return false;
    L8:
        com.obric.assistant.spi.keyguard.a.b(false, new com.obric.assistant.chat.component.bottom.multimodal.c(this, r4, r0), 3);
        return true;
    }

    @Override // ada.d
    public final void L(int r4, int r5) {
        if (((m) this.h.getValue()) != null) goto L5;
        FLogger.a.w("ConfigMultimodalInputComponent", "onUpdateBottomMenuHeight: not found chatWindowAbility");
    L5:
        if (r5 <= 0) goto L7;
        float r6 = r4 / r5;
    L8:
        m r7 = (m) this.h.getValue();
        if (r7 == null) goto L12;
        r7.L10(r6);
        return;
    L12:
        return;
    L7:
        r6 = 0.0f;
        goto L8
    }

    @Override // ada.d
    public final void gi(int r4, View r5) {
        Intrinsics.checkNotNullParameter(r5, "itemView");
        FLogger.a.i("ConfigMultimodalInputComponent", "applyResourceBarItemStyle: " + r4);
        ImageView r1 = null;
        ViewGroup r2 = null;
        if (r4 != ResourceType.ADD.getValue()) goto L12;
        if ((r5 instanceof ViewGroup) == false) goto L7;
        r2 = (ViewGroup) r5;
    L7:
        if (r2 == null) goto L22;
        View r6 = r2.getChildAt(0);
        if (r6 == null) goto L23;
        r6.setBackgroundResource(2131232096);
        return;
    L23:
        return;
    L22:
        return;
    L12:
        if (r4 == ResourceType.CUSTOM.getValue()) goto L25;
        View r7 = r5.findViewById(2131372443);
        if ((r7 instanceof ImageView) == false) goto L16;
        r1 = (ImageView) r7;
    L16:
        if (r1 == null) goto L26;
        r1.setScaleType(ImageView.ScaleType.CENTER);
        r1.setImageResource(2131238026);
        ViewGroup.LayoutParams r8 = r1.getLayoutParams();
        if (r8 == null) goto L21;
        r8.width = c7.b(18);
        r8.height = c7.b(18);
        r1.setLayoutParams(r8);
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L26:
        return;
    }
}

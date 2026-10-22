package com.obric.assistant.chat.component.fastsend;

import cda.b;
import com.larus.bmhome.chat.component.fastsend.f0;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.base.interact.KeyguardLockedState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import laa.d;
import maa.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\u0013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/chat/component/fastsend/ObricFastSendImageComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/bmhome/chat/component/fastsend/IFastSendImageComponentDelegateAbility;", "<init>", "()V", "pageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateAbility$delegate", "Lkotlin/Lazy;", "clickTalkAbility", "Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "getClickTalkAbility", "()Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "clickTalkAbility$delegate", "getFastSendEnable", NameKeys.UnloadStrategy_No_Strategy, "onPageSlideHandleSpeaker", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricFastSendImageComponent extends ComponentFeature implements f0 {
    public static final /* synthetic */ int j = 0;
    public final Lazy h;
    public final Lazy i;

    public static final class a {
    }

    static {
    }

    public final boolean eT() {
        return false;
    }

    public final boolean ox() {
        e r0 = (e) this.i.getValue();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        FLogger.a.i("ObricFastSendImageComponent", "onPageSlideHandleSpeaker: click-talk active, skip performCancel");
        return true;
    L11:
        return false;
    L5:
        if (r0.x3() != true) goto L7;
        r1 = true;
        goto L8
    }

    public ObricFastSendImageComponent() {
        this.h = LazyKt.lazy(new cda.a(this));
        this.i = LazyKt.lazy(new b(this));
    }

    public final boolean WL() {
        if (s1a.a.e(this) == true) goto L16;
        d r0 = (d) this.h.getValue();
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L16;
        if (IAssistantInteractionServiceKt.getInteractionStateService().getInteractionKeyguardLockedState() != KeyguardLockedState.LOCKED) goto L15;
        return false;
    L15:
        return true;
    L7:
        if (r0.aF() != true) goto L9;
        r1 = true;
    L16:
        return false;
    }
}

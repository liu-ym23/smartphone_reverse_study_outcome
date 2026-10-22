package com.obric.assistant.special_input;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.ability.ObricSpecialInputScene;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/special_input/SpecialInputCheckShowComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/ability/IObricSpecialInputCheckShowAbility;", "<init>", "()V", "specialInputAbility", "Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "getSpecialInputAbility", "()Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "specialInputAbility$delegate", "Lkotlin/Lazy;", "obricInstructionAbility", "Lcom/obric/assistant/ability/chat/instruction/IObricInstructionAbility;", "getObricInstructionAbility", "()Lcom/obric/assistant/ability/chat/instruction/IObricInstructionAbility;", "obricInstructionAbility$delegate", "obricInstructionExtAbility", "Lcom/obric/assistant/ability/IObricInstructionExtAbility;", "getObricInstructionExtAbility", "()Lcom/obric/assistant/ability/IObricInstructionExtAbility;", "obricInstructionExtAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "checkShowSpecialInput", "", "isVoiceInput", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpecialInputCheckShowComponent extends ComponentFeature implements laa.k {
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;

    public static final class a {
    }

    public static final class b implements Function0<laa.j> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.j.class));
        }
    }

    public static final class c implements Function0<qaa.a> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(qaa.a.class));
        }
    }

    public static final class d implements Function0<laa.e> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.e.class));
        }
    }

    public static final class e implements Function0<ICoreInputAbility> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
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

    static {
    }

    public SpecialInputCheckShowComponent() {
        this.h = LazyKt.lazy(new b(this));
        this.i = LazyKt.lazy(new c(this));
        this.j = LazyKt.lazy(new d(this));
        this.k = LazyKt.lazy(new e(this));
    }

    public final void Z00(boolean r13) {
        FLogger r0 = FLogger.a;
        r0.i("SpecialInputCheckShowComponent", "checkShowSpecialInput: isVoiceInput = " + r13);
        ISpecialInputTask r1 = com.obric.assistant.special_input.c.a();
        Integer r3 = null;
        if (r1 == null) goto L5;
        StateInfo r6 = r1.a();
    L6:
        if (r6 != null) goto L9;
        r0.i("SpecialInputCheckShowComponent", "checkShowSpecialInput: no waiting input task");
        return;
    L9:
        ObricSpecialInputScene.a r2 = ObricSpecialInputScene.Companion;
        String r4 = r6.getTaskType();
        r2.getClass();
        ObricSpecialInputScene r7 = ObricSpecialInputScene.a.a(r4);
        ICoreInputAbility r5 = (ICoreInputAbility) this.k.getValue();
        if (r5 == null) goto L12;
        r3 = Integer.valueOf(r5.Rp());
    L12:
        qaa.a r8 = (qaa.a) this.i.getValue();
        if (r8 == null) goto L17;
        boolean r9 = true;
        if (r8.z0() != true) goto L17;
    L18:
        r0.i("SpecialInputCheckShowComponent", "checkShowSpecialInput: open for " + r6 + ", lastInputStatus = " + r3 + ", isInstructionOpen = " + r9);
        laa.j r10 = (laa.j) this.h.getValue();
        if (r10 == null) goto L31;
        if (r13 == false) goto L29;
        if (r3 != null) goto L24;
    L25:
        if (r9 == true) goto L29;
        r0.i("SpecialInputCheckShowComponent", "checkShowSpecialInput: ignoreShowImeOnce");
        laa.e r14 = (laa.e) this.j.getValue();
        if (r14 == null) goto L29;
        r14.rg();
        goto L29
    L24:
        if (r3.intValue() != 2) goto L25;
    L29:
        laa.j.a.a(r10, false, r6, r7, null, true, false, 72);
        return;
    L31:
        return;
    L17:
        r9 = false;
        goto L18
    L5:
        r6 = null;
        goto L6
    }
}

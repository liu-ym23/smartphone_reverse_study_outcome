package com.obric.assistant.special_input;

import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.network.api.IObricNetworkService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0004*\u0001\u000e\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/special_input/SpecialInputAdditionMonitorComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "<init>", "()V", "obricSpecialInputAbility", "Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "getObricSpecialInputAbility", "()Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "obricSpecialInputAbility$delegate", "Lkotlin/Lazy;", "onCreate", "", "onDestroy", "obricSpecialInputStateListener", "com/obric/assistant/special_input/SpecialInputAdditionMonitorComponent$obricSpecialInputStateListener$1", "Lcom/obric/assistant/special_input/SpecialInputAdditionMonitorComponent$obricSpecialInputStateListener$1;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpecialInputAdditionMonitorComponent extends ComponentFeature {
    public final Lazy h;
    public final b i;

    public static final class a {
    }

    public static final class b implements laa.u {
        public final /* synthetic */ SpecialInputAdditionMonitorComponent a;

        public b(SpecialInputAdditionMonitorComponent r1) {
            this.a = r1;
        }

        public final void a(laa.t r9) {
            Intrinsics.checkNotNullParameter(r9, "state");
            boolean r0 = r9.a;
            StateInfo r1 = r9.b;
            boolean r2 = false;
            if (r1 != null) goto L5;
        L7:
            boolean r3 = false;
        L8:
            DMTaskState r10 = r9.d;
            if (r10 == null) goto L11;
            String r11 = com.obric.assistant.utils.l.d(r10);
        L12:
            FLogger r5 = FLogger.a;
            r5.i("SpecialInputAdditionMonitorComponent", "onStateChange: isOpen=" + r0 + ", isAddition=" + r3 + ", omniTaskId=" + r11);
            if (com.obric.assistant.util.t0.a(this.a) == true) goto L16;
            r5.i("SpecialInputAdditionMonitorComponent", "ignore state change because not top chat page");
            return;
        L16:
            if (r3 == true) goto L18;
            return;
        L18:
            if (r11 != null) goto L20;
        L21:
            r2 = true;
        L22:
            if (r2 == false) goto L26;
            r5.w("SpecialInputAdditionMonitorComponent", "omniTaskId is empty");
            return;
        L26:
            if (r0 == false) goto L28;
            String r4 = "begin";
        L29:
            r5.i("SpecialInputAdditionMonitorComponent", "notify addition ".concat(r4));
            IObricNetworkService r6 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
            if (r6 == null) goto L36;
            if (r0 == false) goto L33;
            String r7 = "addition_begin";
        L34:
            r6.b(r11, r7, null, null);
            return;
        L33:
            r7 = "addition_end";
            goto L34
        L36:
            return;
        L28:
            r4 = "end";
            goto L29
        L20:
            if (r11.length() != 0) goto L22;
        L11:
            r11 = null;
            goto L12
        L5:
            if (r1.getRequestType() != 2) goto L7;
            r3 = true;
            goto L8
        }
    }

    public static final class c implements Function0<laa.j> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
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

    static {
    }

    public final void onCreate() {
        FLogger.a.i("SpecialInputAdditionMonitorComponent", "onCreate");
        laa.j r0 = (laa.j) this.h.getValue();
        if (r0 == null) goto L6;
        r0.e00(this.i);
        return;
    }

    public final void onDestroy() {
        FLogger.a.i("SpecialInputAdditionMonitorComponent", "onDestroy");
        laa.j r0 = (laa.j) this.h.getValue();
        if (r0 == null) goto L6;
        r0.RC(this.i);
        return;
    }

    public SpecialInputAdditionMonitorComponent() {
        this.h = LazyKt.lazy(new c(this));
        this.i = new b(this);
    }
}

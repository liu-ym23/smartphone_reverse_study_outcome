package com.obric.assistant.window.component;

import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.obric.assistant.common.spi.IObricUIService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/obric/assistant/window/component/ChangeFontSizeToSPComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "<init>", "()V", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "Lkotlin/Lazy;", "chatInputUiCoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUiCoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUiCoreAbility$delegate", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "binding$delegate", "inputText", "Landroid/widget/TextView;", "getInputText", "()Landroid/widget/TextView;", "onCreate", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChangeFontSizeToSPComponent extends ComponentFeature {
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;

    public static final class a implements Function0<va8.m> {
        public final /* synthetic */ AttachReceiver a;

        public a(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.m.class));
        }
    }

    public static final class b implements Function0<va8.o> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.o.class));
        }
    }

    public ChangeFontSizeToSPComponent() {
        this.h = LazyKt.lazy(new a(this));
        this.i = LazyKt.lazy(new b(this));
        this.j = LazyKt.lazy(new com.obric.assistant.window.component.a(this));
    }

    public final void onCreate() {
        IObricUIService r0 = nda.d.a();
        TextView[] r2 = new TextView[1];
        va8.o r3 = (va8.o) this.i.getValue();
        TextView r4 = null;
        if (r3 == null) goto L7;
        com.larus.bmhome.chat.component.bottom.core.a r5 = r3.Uv();
        if (r5 == null) goto L7;
        TextView r6 = r5.b();
    L8:
        r2[0] = r6;
        r0.na(r2);
        IObricUIService r1 = nda.d.a();
        TextView[] r7 = new TextView[1];
        va8.l r8 = (va8.l) this.j.getValue();
        if (r8 == null) goto L13;
        ConstraintLayout r9 = r8.getRootView();
        if (r9 == null) goto L13;
        TextView r10 = (TextView) r9.findViewById(2131391601);
    L15:
        if ((r10 instanceof TextView) == false) goto L17;
        r4 = r10;
    L17:
        r7[0] = r4;
        r1.na(r7);
        return;
    L13:
        r10 = null;
    L7:
        r6 = null;
        goto L8
    }
}

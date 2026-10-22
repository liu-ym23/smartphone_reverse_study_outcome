package com.obric.assistant.window;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/obric/assistant/window/ObricInputComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "<init>", "()V", "TAG", "", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "binding$delegate", "inputContainer", "Landroid/widget/FrameLayout;", "getInputContainer", "()Landroid/widget/FrameLayout;", "inputContainer$delegate", "onCreate", "", "onResume", "tryAttachInputViewToFloatSlot", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricInputComponent extends BaseContentWidget {
    public static final /* synthetic */ int q = 0;
    public final String m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;

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

    public final void onResume() {
    }

    public ObricInputComponent() {
        this.m = "ObricInputComponent";
        this.n = LazyKt.lazy(new a(this));
        this.o = LazyKt.lazy(new b(this));
        this.p = LazyKt.lazy(new c(this));
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        va8.l r0 = (va8.l) this.o.getValue();
        ViewGroup r1 = null;
        if (r0 == null) goto L5;
        ViewGroup r2 = r0.d();
    L7:
        if ((r2 instanceof ChatConstraintLayout) == false) goto L16;
        FLogger r3 = FLogger.a;
        String r4 = this.m;
        StringBuilder r5 = new StringBuilder("onCreate: chatRoot is ");
        va8.l r6 = (va8.l) this.o.getValue();
        if (r6 == null) goto L11;
        ViewGroup r7 = r6.d();
    L12:
        r5.append(r7);
        r5.append(", context is ");
        r5.append(getContext());
        r3.e(r4, r5.toString());
        va8.l r8 = (va8.l) this.o.getValue();
        if (r8 == null) goto L15;
        r1 = r8.d();
    L15:
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.larus.bmhome.view.ChatConstraintLayout");
        ((ChatConstraintLayout) r1).k6(getContext());
        goto L16
    L11:
        r7 = null;
    L16:
        InputViewCreatorDelegate.b.b((FrameLayout) this.p.getValue());
        return;
    L5:
        r2 = null;
        goto L7
    }
}

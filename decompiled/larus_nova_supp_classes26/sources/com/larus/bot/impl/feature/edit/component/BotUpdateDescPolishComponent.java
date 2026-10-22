package com.larus.bot.impl.feature.edit.component;

import android.animation.ObjectAnimator;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.larus.bot.impl.databinding.LarusPageBotEditBinding;
import com.larus.bot.impl.feature.edit.BotUpdateViewModel;
import com.larus.bot.impl.feature.edit.DescPolishStatus;
import com.larus.settings.value.e10;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0002\u0010\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/bot/impl/feature/edit/component/BotUpdateDescPolishComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "<init>", "()V", "botEditAbility", "Lcom/larus/bot/impl/feature/ability/IBotEditAbility;", "getBotEditAbility", "()Lcom/larus/bot/impl/feature/ability/IBotEditAbility;", "botEditAbility$delegate", "Lkotlin/Lazy;", "botUpdateAbility", "Lcom/larus/bot/impl/feature/ability/IBotUpdateAbility;", "getBotUpdateAbility", "()Lcom/larus/bot/impl/feature/ability/IBotUpdateAbility;", "botUpdateAbility$delegate", "descLoadingAnimation1", "Landroid/animation/ObjectAnimator;", "descLoadingAnimation2", "onParentViewCreated", "", "setUpDescPolish", "()Lkotlin/Unit;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotUpdateDescPolishComponent extends ComponentFeature {
    public final Lazy h;
    public final Lazy i;
    public ObjectAnimator j;
    public ObjectAnimator k;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DescPolishStatus.values().length];
            r0[DescPolishStatus.BEFORE_POLISH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DescPolishStatus.IN_POLISH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DescPolishStatus.AFTER_POLISH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(Function1 r2) {
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

    public final ru8.e F2() {
        return (ru8.e) this.h.getValue();
    }

    public BotUpdateDescPolishComponent() {
        this.h = LazyKt.lazy(new e1(this));
        this.i = LazyKt.lazy(new f1(this));
    }

    public final void B2() {
        ru8.e r0 = F2();
        if (r0 == null) goto L22;
        final LarusPageBotEditBinding r1 = r0.e();
        if (r1 == null) goto L23;
        e10 r2 = e10.a;
        if (e10.c() == false) goto L20;
        ru8.f r3 = (ru8.f) this.i.getValue();
        if (r3 == null) goto L20;
        final BotUpdateViewModel r4 = r3.c50();
        if (r4 == null) goto L20;
        ru8.e r5 = F2();
        if (r5 == null) goto L20;
        LifecycleOwner r6 = r5.s4();
        if (r6 == null) goto L20;
        r1.l.setAlpha(0.3f);
        r1.l.setEnabled(false);
        r1.l.setVisibility(0);
        r1.m.setAlpha(0.3f);
        r1.m.setEnabled(false);
        com.larus.utils.e1.d(r1.l, new w0(r4));
        com.larus.utils.e1.d(r1.m, new z0(r4));
        r4.getDescPolishBtnStatus().observe(r6, new b(new a1(r1, this, r4)));
        r4.getDescPolishStatus().observe(r6, new b(new b1(r1, this, r4)));
        r4.getDescPolishResult().observe(r6, new b(new c1(this, r1)));
        r4.getDescGenerating().observe(r6, new b(new d1(r1, this)));
    L20:
        Unit r7 = Unit.INSTANCE;
        return;
    L23:
        return;
    }
}

package com.larus.bot.impl.feature.edit.feature.autofill;

import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bot.impl.common.propertyconfig.Visibility;
import com.larus.bot.impl.databinding.LarusLayoutAutoFillBtnBinding;
import com.larus.common_ui.view.b0;
import com.larus.platform.service.z2;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class BotAutoFillUIBinder {
    public static final /* synthetic */ int f = 0;
    public final TraceFragment a;
    public final b0<LarusLayoutAutoFillBtnBinding> b;
    public final j c;
    public final dv8.b d;
    public final boolean e;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Visibility.values().length];
            r0[Visibility.VISIBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Visibility.DISABLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Visibility.HIDDEN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public final void a() {
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(this.c.getUiEvent(), new BotAutoFillUIBinder$bindUIEvent$1(this, null)), LifecycleOwnerKt.getLifecycleScope(this.a.getViewLifecycleOwner()));
    }

    public final void b() {
        if (z2.a.createBotAutoFillEnable() == false) goto L18;
        this.b.b();
        if (this.e == true) goto L11;
        LarusLayoutAutoFillBtnBinding r0 = (LarusLayoutAutoFillBtnBinding) this.b.c;
        if (r0 == null) goto L11;
        LinearLayout r1 = r0.a;
        if (r1 == null) goto L11;
        r1.setBackgroundResource(2131238735);
    L11:
        LarusLayoutAutoFillBtnBinding r2 = (LarusLayoutAutoFillBtnBinding) this.b.c;
        if (r2 == null) goto L16;
        LinearLayout r3 = r2.a;
        if (r3 == null) goto L16;
        e1.d(r3, new d(this));
    L16:
        LifecycleOwnerKt.getLifecycleScope(this.a.getViewLifecycleOwner()).launchWhenStarted(new BotAutoFillUIBinder$initView$2(this, null));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a.getViewLifecycleOwner()), null, null, new BotAutoFillUIBinder$bindObservers$1(this, null), 3, null);
        a();
        return;
    }

    public BotAutoFillUIBinder(TraceFragment r2, b0<LarusLayoutAutoFillBtnBinding> r3, j r4, dv8.b r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "viewStub");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}

package com.obric.assistant.settings.autogui;

import androidx.lifecycle.LifecycleOwnerKt;
import com.obric.assistant.impl.databinding.ObricFragmentAutoGuiSettingsBinding;
import com.obric.assistant.t1;
import com.obric.oui.layout.OUILinearLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricAutoGuiSettingsFragment$settingsChangedListener$1$onSettingsChanged$1", f = "ObricAutoGuiSettingsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricAutoGuiSettingsFragment$settingsChangedListener$1$onSettingsChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricAutoGuiSettingsFragment this$0;

    public ObricAutoGuiSettingsFragment$settingsChangedListener$1$onSettingsChanged$1(ObricAutoGuiSettingsFragment r1, Continuation<? super ObricAutoGuiSettingsFragment$settingsChangedListener$1$onSettingsChanged$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricAutoGuiSettingsFragment$settingsChangedListener$1$onSettingsChanged$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r10);
        ObricAutoGuiSettingsFragment r4 = this.this$0;
        int r11 = ObricAutoGuiSettingsFragment.h;
        r4.getClass();
        if (t1.a.getAutoGuiEnabledScene() != 2) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == true) goto L15;
        ObricFragmentAutoGuiSettingsBinding r13 = r4.e;
        if (r13 == null) goto L14;
        OUILinearLayout r14 = r13.b;
        if (r14 == null) goto L14;
        r14.setVisibility(8);
    L14:
        r4.V90(c7.b(96));
        ((ObricAutoGuiViewModel) r4.f.getValue()).refreshListBySwitchChanged();
    L17:
        return Unit.INSTANCE;
    L15:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r4), Dispatchers.getMain(), null, new ObricAutoGuiSettingsFragment$checkGetInstalledAppPermission$1(true, false, r4, true, null), 2, null);
        goto L17
    L7:
        r12 = false;
        goto L8
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

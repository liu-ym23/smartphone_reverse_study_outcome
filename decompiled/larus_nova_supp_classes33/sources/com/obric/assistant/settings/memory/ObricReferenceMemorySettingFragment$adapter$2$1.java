package com.obric.assistant.settings.memory;

import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ObricReferenceMemorySettingFragment$adapter$2$1 extends FunctionReferenceImpl implements Function2<y, Boolean, Unit> {
    public ObricReferenceMemorySettingFragment$adapter$2$1(Object r8) {
        super(2, r8, ObricReferenceMemorySettingFragment.class, "handleSwitchChanged", "handleSwitchChanged(Lcom/obric/assistant/settings/memory/ObricReferenceMemoryRow;Z)V", 0);
    }

    public final void invoke(y r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "p0");
        ObricReferenceMemorySettingFragment r0 = (ObricReferenceMemorySettingFragment) ((CallableReference) this).receiver;
        Job r1 = r0.j;
        if (r1 == null) goto L5;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L5:
        r0.j = null;
        SystemHiddenApiHelper r2 = SystemHiddenApiHelper.INSTANCE;
        if (r6 == false) goto L8;
        VibratorSmtFeedbackEffect r3 = VibratorSmtFeedbackEffect.EFFECT_RIGID;
    L9:
        r2.performVibratorSmtFeedback(r3);
        if (r5.f != ObricReferenceMemorySwitchGroup.MAIN) goto L12;
        r0.V90().setMainSwitchEnabled(r6, new ObricReferenceMemorySettingFragment$handleSwitchChanged$1(r0));
        return;
    L12:
        r0.V90().setChildSwitchEnabled(r5.a, r6, new ObricReferenceMemorySettingFragment$handleSwitchChanged$2(r0));
        return;
    L8:
        r3 = VibratorSmtFeedbackEffect.EFFECT_SOFT;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((y) r1, ((Boolean) r2).booleanValue());
        return Unit.INSTANCE;
    }
}

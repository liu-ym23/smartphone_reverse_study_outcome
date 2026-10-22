package com.obric.aiproactive.ui.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.material.OMaterialHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0006H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000\"\u000e\u0010\u000e\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"bindProactiveCloseAction", "", "Lcom/obric/oui/button/OIconButtonFloating;", "onClick", "Lkotlin/Function0;", "applyProactiveTopBarMaterialCompatibility", "Lcom/obric/oui/button/OButtonGroup;", "Landroid/view/View;", "fallbackDrawableRes", "", "needsProactiveTopBarMaterialCompatibility", "", "context", "Landroid/content/Context;", "MATERIAL_LEVEL_FLUID", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class m {
    public static final /* synthetic */ void a(View r0, int r1) {
        b(r0, r1);
    }

    private static final void a(OIconButtonFloating r0, ColorStateList r1) {
        r0.setIconTintColor(r1);
    }

    public static final void a(final OIconButtonFloating r4, Function0<Unit> r5) {
        final Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r6, "onClick");
        final ColorStateList r0 = ColorStateList.valueOf(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.ai_proactive_demo_text_primary, TypedValues.Custom.S_COLOR, "ai_proactive_demo_text_primary")));
        Intrinsics.checkNotNullExpressionValue(r0, "valueOf(...)");
        r4.setEnabled(true);
        r4.setClickable(true);
        r4.setFocusable(true);
        r4.setAlpha(1.0f);
        r4.setIconTintColor(r0);
        r4.post(new $$Lambda$m$ipfXvchAGWiER65ZzmCmv0aFYXw(r4, r0));
        r4.setOnClickListener(new $$Lambda$m$X3R3e0e74wt7B7Wg8g745sIPXD0(r6));
    }

    private static final void a(Function0 r1, View r2) {
        ((Function0) ZeusTransformUtils.wrapperContextForParams(r1, Function0.class, "com.obric.memorydata.plugin")).invoke();
    }

    public static final boolean a(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        boolean r2 = false;
        if ((ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r0 = true;
    L26:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L19
        if (OMaterialHelper.a(r6) == true) goto L9;
    L11:
        boolean r7 = false;
    L12:
        if (r7 == false) goto L16;
        if (r0 == true) goto L15;
    L17:
        Object r8 = Result.m1421constructorimpl(Boolean.valueOf(r2));     // Catch: Throwable -> L19
    L22:
        if (Result.m1427isFailureimpl(r8) == false) goto L25;
        r8 = true;
    L25:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L15:
        if (OMaterialHelper.b(r6) < 2) goto L17;
    L16:
        r2 = true;
        goto L17
    L9:
        if (OMaterialHelper.d() == false) goto L11;
        r7 = true;
    L19:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L22
    L5:
        r0 = false;
        goto L26
    }

    private static final void b(View r3, int r4) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "getContext(...)");
        if (a(r0) == true) goto L5;
        return;
    L5:
        r3.setForeground(ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
        r3.setForegroundGravity(IdlErrors.E_RejectInferDeviceOverheat);
    }

    public static /* synthetic */ void lambda$X3R3e0e74wt7B7Wg8g745sIPXD0(Function0 r0, View r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$ipfXvchAGWiER65ZzmCmv0aFYXw(OIconButtonFloating r0, ColorStateList r1) {
        a(r0, r1);
    }
}

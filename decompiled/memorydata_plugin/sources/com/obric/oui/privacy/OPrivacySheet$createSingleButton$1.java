package com.obric.oui.privacy;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.obric.oui.button.OButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/obric/oui/button/OButton;", "styledContext", "Landroid/content/Context;", "<anonymous parameter 1>", "", "height", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OPrivacySheet$createSingleButton$1 extends Lambda implements Function3<Context, Integer, Integer, OButton> {
    final /* synthetic */ Function1<View, Unit> $onClickListener;
    final /* synthetic */ String $text;

    OPrivacySheet$createSingleButton$1(String r3, Function1<? super View, Unit> r4) {
        Function1<View, Unit> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        this.$text = r3;
        this.$onClickListener = r5;
        super(3);
    }

    /* JADX INFO: renamed from: invoke$lambda-1$lambda-0, reason: not valid java name */
    private static final void m1342invoke$lambda1$lambda0(Function1 r2, View r3) {
        ((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3);
    }

    /* JADX INFO: renamed from: lambda$2wmdQuYgj-iuBj3fAam_S_4iXU0, reason: not valid java name */
    public static /* synthetic */ void m1343lambda$2wmdQuYgjiuBj3fAam_S_4iXU0(Function1 r0, View r1) {
        m1342invoke$lambda1$lambda0(r0, r1);
    }

    public final OButton invoke(Context r10, int r11, int r12) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "styledContext");
        OButton r13 = new OButton(r2, null, 0, 0, null, 28, null);
        String r14 = this.$text;
        final Function1<View, Unit> r9 = this.$onClickListener;
        r13.setText((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"));
        r13.setLayoutParams(new ViewGroup.LayoutParams(-1, r12));
        if (r9 != null) goto L5;
        View.OnClickListener r15 = null;
    L6:
        r13.setOnClickListener(r15);
        return r13;
    L5:
        r15 = new $$Lambda$OPrivacySheet$createSingleButton$1$2wmdQuYgjiuBj3fAam_S_4iXU0(r9);
        goto L6
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ OButton invoke(Context r3, Integer r4, Integer r5) {
        return invoke((Context) ZeusTransformUtils.preCheckCast(r3, Context.class, "com.obric.memorydata.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue());
    }
}

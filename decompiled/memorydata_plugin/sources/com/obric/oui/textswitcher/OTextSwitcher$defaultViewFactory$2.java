package com.obric.oui.textswitcher;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ViewSwitcher;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/ViewSwitcher$ViewFactory;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OTextSwitcher$defaultViewFactory$2 extends Lambda implements Function0<ViewSwitcher.ViewFactory> {
    final /* synthetic */ Context $context;
    final /* synthetic */ OTextSwitcher this$0;

    OTextSwitcher$defaultViewFactory$2(Context r3, OTextSwitcher r4) {
        this.$context = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.this$0 = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke$lambda-4, reason: not valid java name */
    private static final View m1379invoke$lambda4(Context r9, OTextSwitcher r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "$context");
        Intrinsics.checkNotNullParameter(r10, "this$0");
        OTextView r11 = new OTextView(r3, null, 0, null, 14, null);
        d r0 = OTextSwitcher.a(r10);
        if (r0 != null) goto L5;
        b r1 = null;
    L6:
        if (r1 == null) goto L13;
        Integer r2 = r1.a();
        if (r2 == null) goto L13;
        r11.setTextColor(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).intValue());
    L13:
        if (r1 == null) goto L19;
        Float r4 = r1.b();
        if (r4 == null) goto L19;
        r11.setTextSize(1, ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).floatValue());
    L19:
        boolean r5 = false;
        if (r1 == null) goto L28;
        int[] r6 = r1.c();
        if (r6 == null) goto L28;
        if (r6.length != 4) goto L28;
        r11.setPadding(r6[0], r6[1], r6[2], r6[3]);
    L28:
        r11.setGravity(16);
        r11.setSingleLine(true);
        d r12 = OTextSwitcher.a(r10);
        if (r12 != null) goto L32;
    L34:
        if (r5 == false) goto L36;
        r11.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        r11.setMarqueeRepeatLimit(-1);
        r11.setSelected(true);
        r11.setHorizontallyScrolling(true);
        r11.setFocusableInTouchMode(true);
    L38:
        return (View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.memorydata.plugin");
    L36:
        r11.setEllipsize(TextUtils.TruncateAt.END);
        goto L38
    L32:
        if (r12.b() != true) goto L34;
        r5 = true;
        goto L34
    L5:
        r1 = r0.a();
        goto L6
    }

    /* JADX INFO: renamed from: lambda$G8x4wi64-mlphvpcxNsyjBZwGzc, reason: not valid java name */
    public static /* synthetic */ View m1380lambda$G8x4wi64mlphvpcxNsyjBZwGzc(Context r0, OTextSwitcher r1) {
        return m1379invoke$lambda4(r0, r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewSwitcher.ViewFactory invoke() {
        final Context r0 = this.$context;
        final OTextSwitcher r2 = this.this$0;
        return new $$Lambda$OTextSwitcher$defaultViewFactory$2$G8x4wi64mlphvpcxNsyjBZwGzc(r0, r2);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewSwitcher.ViewFactory invoke() {
        return invoke();
    }
}

package com.obric.oui.window.permission;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.obric.flow.cardlistpage.ui.view.h;
import com.obric.oui.button.OButton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/obric/oui/button/OButton;", "styledContext", "Landroid/content/Context;", "width", "", "height", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class PrivacyStatementActivity$createSingleButton$1 extends Lambda implements Function3<Context, Integer, Integer, OButton> {
    final /* synthetic */ Function1<View, Unit> $onClickListener;
    final /* synthetic */ String $text;

    /* JADX WARN: Multi-variable type inference failed */
    public PrivacyStatementActivity$createSingleButton$1(String r5, Function1<? super View, Unit> r10) {
        this.$text = r5;
        this.$onClickListener = r10;
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ OButton invoke(Context r5, Integer r10, Integer r11) {
        return invoke(r5, r10.intValue(), r11.intValue());
    }

    public final OButton invoke(Context r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "styledContext");
        h r12 = null;
        OButton r13 = new OButton(r5, null, 0, 28);
        String r14 = this.$text;
        Function1<View, Unit> r15 = this.$onClickListener;
        r13.setText(r14);
        r13.setLayoutParams(new ViewGroup.LayoutParams(-1, r11));
        if (r15 == null) goto L6;
        r12 = new h(2, r15);
    L6:
        r13.setOnClickListener(r12);
        return r13;
    }
}

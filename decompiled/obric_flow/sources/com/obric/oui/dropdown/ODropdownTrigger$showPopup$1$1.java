package com.obric.oui.dropdown;

import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", ST.IMPLICIT_ARG_NAME, "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class ODropdownTrigger$showPopup$1$1 extends Lambda implements Function1<CharSequence, Unit> {
    final /* synthetic */ ODropdownTrigger this$0;

    public ODropdownTrigger$showPopup$1$1(ODropdownTrigger r5) {
        this.this$0 = r5;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CharSequence r5) {
        invoke2(r5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CharSequence r5) {
        this.this$0.getValue().setText(r5);
    }
}

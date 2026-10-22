package com.obric.memorydata.memory.ui.list;

import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class PersonalGroupListAdapter$ContentViewHolder$holdPressedUntilMenuDismiss$1 extends FunctionReferenceImpl implements Function2<View, Boolean, Unit> {
    public static final PersonalGroupListAdapter$ContentViewHolder$holdPressedUntilMenuDismiss$1 INSTANCE = null;

    static {
        INSTANCE = new PersonalGroupListAdapter$ContentViewHolder$holdPressedUntilMenuDismiss$1();
    }

    PersonalGroupListAdapter$ContentViewHolder$holdPressedUntilMenuDismiss$1() {
        super(2, bb.class, "setCardContentPressed", "setCardContentPressed(Landroid/view/View;Z)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Unit invoke(View r3, Boolean r4) {
        invoke((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"), ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "p0");
        bb.a(r1, r2);
    }
}

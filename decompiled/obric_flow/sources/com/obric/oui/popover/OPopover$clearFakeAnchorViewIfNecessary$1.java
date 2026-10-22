package com.obric.oui.popover;

import android.view.View;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ST.IMPLICIT_ARG_NAME, "Landroid/view/View;", "invoke", "(Landroid/view/View;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OPopover$clearFakeAnchorViewIfNecessary$1 extends Lambda implements Function1<View, Boolean> {
    public static final OPopover$clearFakeAnchorViewIfNecessary$1 INSTANCE = null;

    static {
        INSTANCE = new OPopover$clearFakeAnchorViewIfNecessary$1();
    }

    public OPopover$clearFakeAnchorViewIfNecessary$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(View r5) {
        return invoke2(r5);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(View r5) {
        Intrinsics.checkNotNullParameter(r5, ST.IMPLICIT_ARG_NAME);
        return Boolean.valueOf(r5 instanceof FakeAnchorView);
    }
}

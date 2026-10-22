package com.ss.android.lark.picker.base.widget.scenario;

import android.view.View;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\b¨\u0006\n"}, d2 = {"bindScenarioEntriesView", "", "root", "Landroid/view/View;", "showPersonnel", "", "showPermission", "onPersonnelClick", "Lkotlin/Function0;", "onPermissionClick", "picker-base_release"}, k = 2, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ScenarioEntriesBinderKt {
    public static final void bindScenarioEntriesView(View r3, boolean r4, boolean r5, final Function0<Unit> r6, final Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r3, "root");
        Intrinsics.checkNotNullParameter(r6, "onPersonnelClick");
        Intrinsics.checkNotNullParameter(r7, "onPermissionClick");
        View r0 = r3.findViewById(2131382280);
        View r8 = r3.findViewById(2131382279);
        int r1 = 0;
        if (r4 == false) goto L5;
        int r9 = 0;
    L6:
        r0.setVisibility(r9);
        if (r5 == true) goto L10;
        r1 = 8;
    L10:
        r8.setVisibility(r1);
        r0.setOnClickListener(new AnonymousClass1(r6));
        r8.setOnClickListener(new AnonymousClass2(r7));
        return;
    L5:
        r9 = 8;
        goto L6
    }
}

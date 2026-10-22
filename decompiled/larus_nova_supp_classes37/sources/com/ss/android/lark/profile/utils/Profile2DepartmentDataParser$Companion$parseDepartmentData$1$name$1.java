package com.ss.android.lark.profile.utils;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.profile.v2.entity.DepartmentField;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/profile/v2/entity/DepartmentField$DepartmentNode;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class Profile2DepartmentDataParser$Companion$parseDepartmentData$1$name$1 extends Lambda implements Function1<DepartmentField.DepartmentNode, CharSequence> {
    public static final Profile2DepartmentDataParser$Companion$parseDepartmentData$1$name$1 INSTANCE = null;

    static {
        INSTANCE = new Profile2DepartmentDataParser$Companion$parseDepartmentData$1$name$1();
    }

    public Profile2DepartmentDataParser$Companion$parseDepartmentData$1$name$1() {
        super(1);
    }

    public final CharSequence invoke(DepartmentField.DepartmentNode r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        String r3 = r2.getDepartmentName();
        if (r3 != null) goto L6;
        return "";
    L6:
        return r3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((DepartmentField.DepartmentNode) r1);
    }
}

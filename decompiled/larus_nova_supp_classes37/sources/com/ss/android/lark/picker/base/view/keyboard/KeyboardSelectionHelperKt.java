package com.ss.android.lark.picker.base.view.keyboard;

import android.widget.EditText;
import androidx.recyclerview.widget.RecyclerView;
import aoc.b;
import com.larksuite.framework.utils.ExternalKeyboardUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.suite.lark.emm.autofocus.AutoFocusEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\b¨\u0006\t"}, d2 = {"enableKeyboardNavigation", "", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/ss/android/lark/picker/base/view/keyboard/KeyboardSelectionAdapter;", "editText", "Landroid/widget/EditText;", "disableKeyboardSelection", "Lcom/suite/lark/emm/autofocus/AutoFocusEditText;", "picker-base_release"}, k = 2, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class KeyboardSelectionHelperKt {
    public static final void disableKeyboardSelection(AutoFocusEditText r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.a(null);
    }

    public static final void enableKeyboardNavigation(RecyclerView r1, KeyboardSelectionAdapter<?, ?> r2, EditText r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "adapter");
        if (b.a() == true) goto L5;
    L13:
        Log.e("KeyboardNav", "Adapter must implement KeyboardSelectionHelperAware");
        return;
    L5:
        if ((r2 instanceof KeyboardSelectionHelperAware) == false) goto L13;
        if ((r3 instanceof AutoFocusEditText) == false) goto L15;
        Boolean r0 = ExternalKeyboardUtils.a;
        if (ExternalKeyboardUtils.b(false) == false) goto L16;
        KeyboardSelectionHelper.Companion.getInstance(r1, r2, (AutoFocusEditText) r3);
        return;
    L16:
        return;
    }
}

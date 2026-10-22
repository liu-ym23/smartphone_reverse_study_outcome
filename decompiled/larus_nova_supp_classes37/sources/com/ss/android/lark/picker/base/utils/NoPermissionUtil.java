package com.ss.android.lark.picker.base.utils;

import android.content.Context;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/picker/base/utils/NoPermissionUtil;", "", "<init>", "()V", "showNoPermissionDialog", "", "context", "Landroid/content/Context;", "tipsRes", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class NoPermissionUtil {
    public static final NoPermissionUtil INSTANCE = null;

    static {
        INSTANCE = new NoPermissionUtil();
    }

    private NoPermissionUtil() {
    }

    @JvmStatic
    public static final void showNoPermissionDialog(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new UDDialogBuilder(r2).title(2131891417).message(r3).addActionButton(2131391777, 2131891416, null).show();
    }
}

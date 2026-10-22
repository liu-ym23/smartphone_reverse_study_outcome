package com.obric.assistant.onelogin.impl.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.obric.oui.dialog.v2.common.ODialogListItemView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricEnterpriseAccountTipListItemBinding implements ViewBinding {
    public final ODialogListItemView a;
    public final ODialogListItemView b;

    public final View getRoot() {
        return this.a;
    }

    public static ObricEnterpriseAccountTipListItemBinding a(View r1) {
        ODialogListItemView r2 = (ODialogListItemView) r1;
        return new ObricEnterpriseAccountTipListItemBinding(r2, r2);
    }

    public ObricEnterpriseAccountTipListItemBinding(ODialogListItemView r1, ODialogListItemView r2) {
        this.a = r1;
        this.b = r2;
    }
}

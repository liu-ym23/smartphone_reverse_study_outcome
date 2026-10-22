package com.obric.oui.sheet;

import android.app.Dialog;
import android.os.Bundle;
import com.obric.common.oui.R$style;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/sheet/OExpandableSheet;", "Lcom/obric/oui/sheet/OSheet;", "<init>", "()V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OExpandableSheet extends OSheet {
    public OExpandableSheet() {
    }

    @Override // com.obric.oui.sheet.OSheet, com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r5) {
        OBottomSheetDialog r10 = new OBottomSheetDialog(requireContext(), R$style.AppBottomSheetDialogTheme);
        if (r10.f14405a != null) goto L5;
        r10.b();
    L5:
        r10.f14405a.setSkipCollapsed(true);
        if (r10.f14405a != null) goto L8;
        r10.b();
    L8:
        r10.f14405a.setFitToContents(true);
        r10.g = true;
        return r10;
    }
}

package com.obric.oui.sheet;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/sheet/OExpandableSheet;", "Lcom/obric/oui/sheet/OSheet;", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OExpandableSheet extends OSheet {
    public OExpandableSheet() {
    }

    @Override // com.obric.oui.sheet.OSheet, com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r5) {
        OBottomSheetDialog r6 = new OBottomSheetDialog((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.style.AppBottomSheetDialogTheme, "style", "AppBottomSheetDialogTheme"));
        r6.setDismissWithAnimation(false);
        r6.getBehavior().setSkipCollapsed(true);
        r6.getBehavior().setFitToContents(true);
        r6.setIs69Expandable(true);
        return (Dialog) ZeusTransformUtils.preCheckCast(r6, Dialog.class, "com.obric.memorydata.plugin");
    }
}

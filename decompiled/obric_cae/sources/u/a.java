package u;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"LogConditional"})
public final class a {
    public static String a(Context r8, int r10) {
        if (r10 != (-1)) goto L10;
        return BdimCategoryConstants.VALUE_UNKNOWN;
    L10:
        return r8.getResources().getResourceEntryName(r10);
    L9:
        return defpackage.a.d("?", r10);
    }

    public static String b(View r8) {
        return r8.getContext().getResources().getResourceEntryName(r8.getId());
    L4:
        return BdimCategoryConstants.VALUE_UNKNOWN;
    }
}

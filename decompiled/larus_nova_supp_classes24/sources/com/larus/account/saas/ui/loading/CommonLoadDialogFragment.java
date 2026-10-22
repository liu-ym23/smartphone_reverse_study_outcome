package com.larus.account.saas.ui.loading;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/larus/account/saas/ui/loading/CommonLoadDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "a", "account-saas-ui-android_release"}, k = 1, mv = {1, 7, 1})
public final class CommonLoadDialogFragment extends DialogFragment {
    public float d;

    public static final class a {
    }

    static {
    }

    public CommonLoadDialogFragment() {
        this.d = 0.2f;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L5;
        float r4 = r3.getFloat("key_dim");
    L6:
        this.d = r4;
        return;
    L5:
        r4 = 0.2f;
        goto L6
    }

    public final Dialog onCreateDialog(Bundle r3) {
        return new i48.a(requireActivity(), this.d);
    }
}

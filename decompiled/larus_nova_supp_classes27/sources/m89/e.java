package m89;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.larus.drive.sdk.impl.databinding.LarusDialogDriveRenameBinding;
import com.larus.drive.sdk.impl.view.operation.DriveRenameDialog;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e implements TextWatcher {
    public final /* synthetic */ DriveRenameDialog a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public e(DriveRenameDialog r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r6) {
        if (this.a.m == false) goto L5;
        return;
    L5:
        EditText r0 = null;
        if (r6 == null) goto L8;
        String r1 = r6.toString();
    L9:
        if (r1 != null) goto L11;
        r1 = "";
    L11:
        v79.d r2 = this.a.k;
        if (r2 == null) goto L15;
        Pair<Boolean, String> r3 = r2.c(r1);
        if (r3 == null) goto L15;
    L17:
        if (((Boolean) r3.getFirst()).booleanValue() == false) goto L31;
        DriveRenameDialog r4 = this.a;
        r4.m = true;
        LarusDialogDriveRenameBinding r5 = r4.d;
        if (r5 == null) goto L21;
        r0 = r5.e;
    L21:
        String r7 = (String) r3.getSecond();
        if (r6 == null) goto L29;
        if (r0 == null) goto L25;
        int r8 = r0.getSelectionEnd();
    L26:
        r6.replace(0, r6.length(), r7);
        int r9 = Math.min(r8, r7.length());
        if (r0 == null) goto L29;
        r0.setSelection(r9);
        goto L29
    L25:
        r8 = 0;
    L29:
        this.a.m = false;
        return;
    L31:
        return;
    L15:
        r3 = new Pair(Boolean.FALSE, r1);
        goto L17
    L8:
        r1 = null;
        goto L9
    }
}

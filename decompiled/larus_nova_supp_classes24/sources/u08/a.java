package u08;

import android.text.Editable;
import android.text.TextWatcher;
import com.larksuite.component.universe_design.edittext.UDEditText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements TextWatcher {
    public final /* synthetic */ UDEditText a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "s");
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "s");
    }

    public a(UDEditText r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r2) {
        Intrinsics.checkNotNullParameter(r2, "s");
        UDEditText r3 = this.a;
        int r0 = UDEditText.k0;
        r3.d();
    }
}

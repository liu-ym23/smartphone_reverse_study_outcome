package lob;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.EditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface a extends TextWatcher {
    @Override // android.text.TextWatcher
    void afterTextChanged(Editable r1);

    @Override // android.text.TextWatcher
    void beforeTextChanged(CharSequence r1, int r2, int r3, int r4);

    void j(EditText r1);

    @Override // android.text.TextWatcher
    void onTextChanged(CharSequence r1, int r2, int r3, int r4);

    void r(Editable r1, int r2, int r3);

    boolean z(int r1, KeyEvent r2);
}

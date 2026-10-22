package xv0;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements TextWatcher {
    public final /* synthetic */ EditText a;
    public final /* synthetic */ c b;
    public final /* synthetic */ long c;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public b(EditText r1, c r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r5, int r6, int r7, int r8) {
        int r9 = 0;
        if (r5 == null) goto L9;
        if (StringsKt.startsWith$default(r5, DataType.FALSE, false, 2, null) != true) goto L9;
        this.a.setText(Editable.Factory.getInstance().newEditable(r5.subSequence(1, r5.length()).toString()));
        return;
    L9:
        if (TextUtils.isEmpty(r5) == false) goto L12;
        this.b.c.getInputMoney().postValue(0L);
        return;
    L12:
        if (r5 == null) goto L16;
        String r10 = r5.toString();
        if (r10 == null) goto L16;
        long r2 = (long) (CastLongProtector.parseLong(r10) * 100.0f);
    L18:
        if (r2 != 0) goto L20;
        this.a.setText(Editable.Factory.getInstance().newEditable(""));
    L26:
        this.b.c.getInputMoney().postValue(Long.valueOf(r2));
        return;
    L20:
        long r0 = this.c;
        if (r2 <= r0) goto L26;
        this.a.setText(Editable.Factory.getInstance().newEditable(String.valueOf((long) (this.c / 100.0f))));
        EditText r12 = this.a;
        Editable r13 = r12.getText();
        if (r13 == null) goto L25;
        r9 = r13.length();
    L25:
        r12.setSelection(r9);
        r2 = r0;
    L16:
        r2 = 0;
        goto L18
    }
}

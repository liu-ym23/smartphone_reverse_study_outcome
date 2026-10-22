package q29;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g implements TextWatcher {
    public final /* synthetic */ Ref.ObjectRef<String> a;
    public final /* synthetic */ Ref.IntRef b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Function3<String, Boolean, Integer, Unit> d;
    public final /* synthetic */ EditText e;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r7) {
        if (r7 == null) goto L4;
        String r8 = r7.toString();
    L6:
        if (r8 != null) goto L8;
        r8 = "";
    L8:
        int r1 = r8.length() + h.a(r8);
        if (r1 <= this.c) goto L25;
        int r2 = ((String) this.a.element).length() + h.a((CharSequence) this.a.element);
        int r3 = this.c;
        if (r2 <= r3) goto L13;
        this.b.element = 0;
        this.a.element = "";
        r2 = 0;
    L13:
        int r4 = r3 - r2;
        int r0 = r8.length() - 1;
        int r5 = this.b.element;
        int r6 = r8.length();
    L14:
        if (r5 >= r6) goto L19;
        r4 = r4 - (h.a(String.valueOf(r8.charAt(r5))) + 1);
        if (r4 < 0) goto L17;
        r5 = r5 + 1;
        goto L14
    L17:
        r0 = r5;
    L19:
        Ref.ObjectRef<String> r9 = this.a;
        Ref.IntRef r10 = this.b;
        EditText r11 = this.e;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L22
        r8 = r8.substring(0, r0) + ((String) r9.element).substring(r10.element);     // Catch: Throwable -> L22
        r11.setText(r8);     // Catch: Throwable -> L22
        r11.setSelection(r0);     // Catch: Throwable -> L22
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        this.d.invoke(r8, Boolean.TRUE, Integer.valueOf((this.c + 1) / 2));
        return;
    L22:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L25:
        this.d.invoke(r8, Boolean.FALSE, Integer.valueOf((r1 + 1) / 2));
        return;
    L4:
        r8 = null;
        goto L6
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        if (r1 == null) goto L4;
        String r5 = r1.toString();
    L5:
        if (r5 != null) goto L7;
        r5 = "";
    L7:
        this.a.element = r5;
        return;
    L4:
        r5 = null;
        goto L5
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        this.b.element = r2;
    }

    public g(Ref.ObjectRef r1, Ref.IntRef r2, int r3, com.larus.community.impl.publish.a r4, AppCompatEditText r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}

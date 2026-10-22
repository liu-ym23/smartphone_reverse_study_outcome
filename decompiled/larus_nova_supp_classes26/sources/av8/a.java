package av8;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements TextWatcher {
    public final /* synthetic */ Ref.ObjectRef<String> a;
    public final /* synthetic */ Ref.IntRef b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Function1<String, Unit> d;
    public final /* synthetic */ EditText e;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r7) {
        if (r7 == null) goto L4;
        String r8 = r7.toString();
    L6:
        if (r8 != null) goto L9;
        r8 = "";
    L9:
        if ((r8.length() + b.a(r8)) <= this.c) goto L25;
        int r1 = ((String) this.a.element).length() + b.a((CharSequence) this.a.element);
        int r2 = this.c;
        if (r1 <= r2) goto L13;
        this.b.element = 0;
        this.a.element = "";
        r1 = 0;
    L13:
        int r3 = r2 - r1;
        int r0 = r8.length() - 1;
        int r4 = this.b.element;
        int r5 = r8.length();
    L14:
        if (r4 >= r5) goto L19;
        r3 = r3 - (b.a(String.valueOf(r8.charAt(r4))) + 1);
        if (r3 < 0) goto L17;
        r4 = r4 + 1;
        goto L14
    L17:
        r0 = r4;
    L19:
        Ref.ObjectRef<String> r6 = this.a;
        Ref.IntRef r9 = this.b;
        EditText r10 = this.e;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L22
        r8 = r8.substring(0, r0) + ((String) r6.element).substring(r9.element);     // Catch: Throwable -> L22
        r10.setText(r8);     // Catch: Throwable -> L22
        r10.setSelection(r0);     // Catch: Throwable -> L22
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        this.d.invoke(r8);
        return;
    L22:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L25:
        this.d.invoke(r8);
        return;
    L4:
        r8 = null;
        goto L6
    }

    public a(Ref.ObjectRef r1, Ref.IntRef r2, com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.b r3, AppCompatEditText r4) {
        this.a = r1;
        this.b = r2;
        this.c = 180;
        this.d = r3;
        this.e = r4;
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
}

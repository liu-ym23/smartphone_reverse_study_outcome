package sob;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements TextWatcher {
    public final Function0<Unit> a;
    public final Function1<Boolean, Unit> b;
    public long c;

    public static final class a {
    }

    static {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r3) {
        if (r3 == null) goto L4;
        CharSequence r4 = StringsKt.trim(r3);
    L5:
        Function1<Boolean, Unit> r0 = this.b;
        boolean r1 = false;
        if (r4 != null) goto L8;
    L10:
        r0.invoke(Boolean.valueOf(r1));
        return;
    L8:
        if (r4.length() <= 0) goto L10;
        r1 = true;
        goto L10
    L4:
        r4 = null;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(Function0<Unit> r2, Function1<? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "mentionAction");
        Intrinsics.checkNotNullParameter(r3, "whenInputText");
        this.a = r2;
        this.b = r3;
        this.c = System.currentTimeMillis();
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r6, int r7, int r8, int r9) {
        boolean r10 = true;
        if (r9 == 1) goto L5;
        return;
    L5:
        if (r6 != null) goto L7;
    L9:
        boolean r11 = false;
    L10:
        if (r11 == false) goto L19;
        long r12 = System.currentTimeMillis();
        if ((r12 - this.c) <= 1000) goto L14;
        this.c = r12;
    L15:
        if (r10 == false) goto L20;
        this.a.invoke();
        return;
    L20:
        return;
    L14:
        r10 = false;
        goto L15
    L19:
        return;
    L7:
        if (r6.charAt(r7) != '@') goto L9;
        r11 = true;
        goto L10
    }
}

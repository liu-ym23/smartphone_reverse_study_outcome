package dob;

import android.text.SpannableStringBuilder;
import com.ss.android.lark.keyboard.edittext2.utils.e;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends com.ss.android.lark.keyboard.edittext2.edittors.a {
    public final Set<d> f;

    public a() {
        this.f = new LinkedHashSet();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.a
    public final void V() {
        int r0 = e.c(com.ss.android.lark.keyboard.edittext2.base.c.a.a(this));
        if (r0 >= 0) goto L24;
        int r1 = com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getSelectionStart() - 1;
    L6:
        if (r1 <= (-1)) goto L22;
        Character r3 = StringsKt.getOrNull(com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getText(), r1);
        if (r3 != null) goto L11;
    L13:
        Character r4 = StringsKt.getOrNull(com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getText(), r1);
        if (r4 != null) goto L16;
    L18:
        boolean r5 = false;
    L19:
        if (r5 == true) goto L20;
        r1 = r1 - 1;
        goto L6
    L20:
        r1 = -1;
        goto L22
    L16:
        if (CharsKt.isWhitespace(r4.charValue()) != true) goto L18;
        r5 = true;
        goto L19
    L11:
        if (r3.charValue() != '@') goto L13;
    L22:
        if (r1 < 0) goto L29;
        com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getEditableText().delete(r1, com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getSelectionStart());
        return;
    L29:
        return;
    L24:
        com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getEditableText().delete(r0, r0 + 1);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.a
    public final void U(com.ss.android.lark.keyboard.edittext2.edittors.at.c<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "strategy");
        super.U(r2);
        if ((r2 instanceof d) == false) goto L6;
        this.f.add(r2);
        return;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final void T(hob.c r2, SpannableStringBuilder r3, int r4, int r5) {
        hob.c r6 = r2;
        Intrinsics.checkNotNullParameter(r6, "data");
        Intrinsics.checkNotNullParameter(r3, "text");
        Intrinsics.checkNotNullParameter(r3, "text");
        if ((!com.ss.android.lark.keyboard.edittext2.utils.d.a("messenger.im.disable_doubao_insert_at_space_fix")) == true) goto L5;
        return;
    L5:
        if (r6.f == false) goto L10;
        if (r5 <= r4) goto L11;
        r3.append(' ');
        r6.f = false;
        return;
    L11:
        return;
    }
}

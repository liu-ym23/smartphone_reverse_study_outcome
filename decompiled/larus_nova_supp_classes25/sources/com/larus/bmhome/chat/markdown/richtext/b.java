package com.larus.bmhome.chat.markdown.richtext;

import android.text.Spanned;
import android.widget.TextView;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b extends lsc.a {
    public b() {
    }

    public final void G4(TextView r5) {
        Intrinsics.checkNotNullParameter(r5, "textView");
        Object r1 = r5.getTag(2131377343);
        List r3 = null;
        if ((r1 instanceof AvatarBinding) == false) goto L5;
        AvatarBinding r2 = (AvatarBinding) r1;
    L6:
        if (r2 == null) goto L8;
        r2.a();
        r5.removeOnAttachStateChangeListener(r2);
    L8:
        r5.setTag(2131377343, null);
        CharSequence r4 = r5.getText();
        if ((r4 instanceof Spanned) == false) goto L11;
        Spanned r6 = (Spanned) r4;
    L12:
        if (r6 == null) goto L14;
        r3 = fh8.o.c(r6, d.class);
    L14:
        if (r3 != null) goto L17;
        r3 = CollectionsKt.emptyList();
    L17:
        if (r3.isEmpty() == false) goto L19;
        return;
    L19:
        AvatarBinding r7 = new AvatarBinding(r5, r3);
        r5.setTag(2131377343, r7);
        r5.addOnAttachStateChangeListener(r7);
        if (r5.isAttachedToWindow() == false) goto L23;
        r7.b();
        return;
    L23:
        return;
    L11:
        r6 = null;
        goto L12
    L5:
        r2 = null;
        goto L6
    }
}

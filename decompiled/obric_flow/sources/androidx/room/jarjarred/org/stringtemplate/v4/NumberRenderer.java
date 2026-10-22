package androidx.room.jarjarred.org.stringtemplate.v4;

import java.util.Formatter;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class NumberRenderer implements AttributeRenderer {
    public NumberRenderer() {
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.AttributeRenderer
    public String toString(Object r5, String r10, Locale r11) {
        if (r10 == null) goto L4;
        Formatter r12 = new Formatter(r11);
        r12.format(r10, new Object[]{r5});
        return r12.toString();
    L4:
        return r5.toString();
    }
}

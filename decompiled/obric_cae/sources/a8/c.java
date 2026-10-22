package a8;

import android.text.TextUtils;
import android.util.Printer;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Printer {
    @Override // android.util.Printer
    public final void println(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        boolean r10 = false;
        if (r8.charAt(0) != '>') goto L10;
        r10 = true;
    L8:
        e.a(r10, r8, null);
        return;
    L10:
        if (r8.charAt(0) == '<') goto L8;
    }
}

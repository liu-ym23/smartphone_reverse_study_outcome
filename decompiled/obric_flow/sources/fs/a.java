package fs;

import android.text.InputFilter;
import android.text.Spanned;
import com.obric.oui.stepper.OSteppers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f17008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.core.view.inputmethod.a f17009c;

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r5, int r10, int r11, Spanned r12, int r13, int r14) {
        int r15 = Integer.parseInt(r12.toString() + r5.toString());     // Catch: NumberFormatException -> L18
        int r16 = this.f17007a;     // Catch: NumberFormatException -> L18
        int r17 = this.f17008b;     // Catch: NumberFormatException -> L18
        boolean r18 = false;
        if (r17 <= r16) goto L7;
        if (r15 < r16) goto L10;
        if (r15 > r17) goto L10;
    L6:
        r18 = true;
    L10:
        if (r18 == false) goto L13;
        return null;
    L13:
        androidx.core.view.inputmethod.a r19 = this.f17009c;     // Catch: NumberFormatException -> L18
        if (r19 == null) goto L21;
        r19.getClass();     // Catch: NumberFormatException -> L18
        int r20 = OSteppers.f14557w;     // Catch: NumberFormatException -> L18
        OSteppers r21 = (OSteppers) r19.f497b;     // Catch: NumberFormatException -> L18
        Intrinsics.checkNotNullParameter(r21, "this$0");     // Catch: NumberFormatException -> L18
        r21.getClass();     // Catch: NumberFormatException -> L18
        return "";
    L21:
        return "";
    L7:
        if (r15 < r17) goto L10;
        if (r15 > r16) goto L10;
    L22:
        return "";
    }
}

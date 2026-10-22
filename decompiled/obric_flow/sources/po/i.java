package po;

import android.text.InputFilter;
import android.text.Spanned;
import com.lynx.xelement.input.LynxUIBaseInput;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LynxUIBaseInput f21381b;

    public /* synthetic */ i(LynxUIBaseInput r5, int r10) {
        this.f21380a = r10;
        this.f21381b = r5;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r5, int r10, int r11, Spanned r12, int r13, int r14) {
        switch(this.f21380a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "source");
        if (this.f21381b.f11198a == false) goto L7;
        return "";
    L7:
        return null;
    L9:
        Intrinsics.checkNotNullParameter(r5, "source");
        Intrinsics.checkNotNullParameter(r12, "dest");
        String r15 = this.f21381b.f11205l;
        if (r15 == null) goto L24;
        StringBuilder r16 = new StringBuilder("");
        int r17 = 0;
    L13:
        if (r17 >= r5.length()) goto L19;
        char r18 = r5.charAt(r17);
        String r19 = String.valueOf(r18);
        if (new Regex(r15).matches(r19) == false) goto L17;
        r16.append(r18);
    L17:
        r17 = r17 + 1;
        goto L13
    L19:
        return r16.toString();
    L24:
        return r5;
    }
}

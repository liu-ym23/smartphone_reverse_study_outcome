package re;

import ai.j0;
import android.text.Editable;
import android.text.Selection;
import com.bytedance.ies.xelement.input.t;
import kotlin.jvm.internal.Intrinsics;
import we.b;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f21724a = null;

    static {
        f21724a = new a();
    }

    @Override // com.bytedance.ies.xelement.input.t
    public final boolean a(Editable r10) {
        Intrinsics.checkNotNullParameter(r10, "editableText");
        int r11 = Selection.getSelectionStart(r10);
        Object[] r5 = r10.getSpans(r11, Selection.getSelectionEnd(r10), b.class);
        int r12 = r5.length;
        int r13 = 0;
    L3:
        Object r14 = null;
        if (r13 >= r12) goto L9;
        Object r15 = r5[r13];
        j0.A(r15);
        if (r10.getSpanEnd(null) == r11) goto L7;
        r13 = r13 + 1;
        goto L3
    L7:
        r14 = r15;
    L9:
        j0.A(r14);
        return false;
    }
}

package lob;

import android.text.Editable;
import android.view.KeyEvent;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements a {
    public final List<a> a;
    public boolean b;

    public b() {
        this.a = new ArrayList();
    }

    public final void a(boolean r4) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        a r1 = (a) r0.next();
        if ((r1 instanceof mob.b) == false) goto L4;
        ((mob.b) r1).a(r4);
        goto L4
    }

    @Override // lob.a, android.text.TextWatcher
    public final void afterTextChanged(Editable r3) {
        if (this.b == false) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.a.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((a) r0.next()).afterTextChanged(r3);
        goto L7
    }

    @Override // lob.a
    public final void j(EditText r3) {
        Intrinsics.checkNotNullParameter(r3, "editText");
        if (this.b == false) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.a.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((a) r0.next()).j(r3);
        goto L7
    }

    @Override // lob.a
    public final boolean z(int r4, KeyEvent r5) {
        Iterator<T> r0 = this.a.iterator();
        boolean r1 = false;
    L4:
        if (r0.hasNext() == false) goto L6;
        r1 = r1 & ((a) r0.next()).z(r4, r5);
        goto L4
    L6:
        return r1;
    }

    @Override // lob.a
    public final void r(Editable r3, int r4, int r5) {
        if (this.b == false) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.a.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((a) r0.next()).r(r3, r4, r5);
        goto L7
    }

    @Override // lob.a, android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r3, int r4, int r5, int r6) {
        if (this.b == false) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.a.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((a) r0.next()).beforeTextChanged(r3, r4, r5, r6);
        goto L7
    }

    @Override // lob.a, android.text.TextWatcher
    public final void onTextChanged(CharSequence r3, int r4, int r5, int r6) {
        if (this.b == false) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.a.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((a) r0.next()).onTextChanged(r3, r4, r5, r6);
        goto L7
    }
}

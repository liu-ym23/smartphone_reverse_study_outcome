package q0;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class g implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f10118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f10119b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public a f10120m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f10121n;

    public static class a extends androidx.emoji2.text.f.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference f10122a;

        public a(EditText r8) {
            this.f10122a = new WeakReference(r8);
        }

        @Override // androidx.emoji2.text.f.e
        public final void a() {
            g.a((EditText) this.f10122a.get(), 1);
        }
    }

    public g(EditText r8) {
        this.f10118a = r8;
        this.f10119b = false;
        this.f10121n = true;
    }

    public static void a(EditText r8, int r10) {
        if (r10 != 1) goto L20;
        if (r8 != null) goto L6;
        return;
    L6:
        if (r8.isAttachedToWindow() == false) goto L22;
        Editable r11 = r8.getEditableText();
        int r12 = Selection.getSelectionStart(r11);
        int r13 = Selection.getSelectionEnd(r11);
        androidx.emoji2.text.f r14 = androidx.emoji2.text.f.a();
        if (r11 != null) goto L10;
        int r15 = 0;
    L11:
        r14.f(0, r15, r11);
        if (r12 < 0) goto L15;
        if (r13 < 0) goto L15;
        Selection.setSelection(r11, r12, r13);
        return;
    L15:
        if (r12 < 0) goto L17;
        Selection.setSelection(r11, r12);
        return;
    L17:
        if (r13 < 0) goto L25;
        Selection.setSelection(r11, r13);
        return;
    L25:
        return;
    L10:
        r14.getClass();
        r15 = r11.length();
        goto L11
    L22:
        return;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r8) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r8, int r10, int r11, int r12) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r8, int r10, int r11, int r12) {
        EditText r13 = this.f10118a;
        if (r13.isInEditMode() == false) goto L5;
        return;
    L5:
        if (this.f10121n == false) goto L13;
        boolean r14 = false;
        if (this.f10119b == false) goto L9;
    L14:
        if (r14 == true) goto L35;
        if (r11 <= r12) goto L18;
        return;
    L18:
        if ((r8 instanceof Spannable) == false) goto L33;
        int r15 = androidx.emoji2.text.f.a().b();
        if (r15 == 0) goto L26;
        if (r15 != 1) goto L23;
        androidx.emoji2.text.f.a().f(r10, r12 + r10, (Spannable) r8);
        return;
    L23:
        if (r15 == 3) goto L26;
        return;
    L26:
        androidx.emoji2.text.f r16 = androidx.emoji2.text.f.a();
        if (this.f10120m != null) goto L29;
        this.f10120m = new a(r13);
    L29:
        r16.h(this.f10120m);
        return;
    L33:
        return;
    L35:
        return;
    L9:
        if (androidx.emoji2.text.f.f1747j == null) goto L11;
        boolean r17 = true;
    L12:
        if (r17 == true) goto L14;
    L11:
        r17 = false;
    L13:
        r14 = true;
        goto L14
    }
}

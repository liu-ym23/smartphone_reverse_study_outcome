package q0;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class d implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f10107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f10108b;

    public static class a extends androidx.emoji2.text.f.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference f10109a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference f10110b;

        public a(TextView r8, d r10) {
            this.f10109a = new WeakReference(r8);
            this.f10110b = new WeakReference(r10);
        }

        @Override // androidx.emoji2.text.f.e
        public final void a() {
            TextView r8 = (TextView) this.f10109a.get();
            InputFilter r10 = (InputFilter) this.f10110b.get();
            if (r10 == null) goto L16;
            if (r8 == null) goto L16;
            InputFilter[] r11 = r8.getFilters();
            if (r11 == null) goto L16;
            int r12 = 0;
        L11:
            if (r12 >= r11.length) goto L16;
            if (r11[r12] == r10) goto L14;
            r12 = r12 + 1;
            goto L11
        L14:
            boolean r13 = true;
        L17:
            if (r13 == true) goto L20;
            return;
        L20:
            if (r8.isAttachedToWindow() == false) goto L41;
            CharSequence r14 = r8.getText();
            androidx.emoji2.text.f r15 = androidx.emoji2.text.f.a();
            if (r14 != null) goto L24;
            int r16 = 0;
        L25:
            CharSequence r17 = r15.f(0, r16, r14);
            if (r14 != r17) goto L28;
            return;
        L28:
            int r18 = Selection.getSelectionStart(r17);
            int r19 = Selection.getSelectionEnd(r17);
            r8.setText(r17);
            if ((r17 instanceof Spannable) == false) goto L42;
            Spannable r20 = (Spannable) r17;
            if (r18 < 0) goto L34;
            if (r19 < 0) goto L34;
            Selection.setSelection(r20, r18, r19);
            return;
        L34:
            if (r18 < 0) goto L36;
            Selection.setSelection(r20, r18);
            return;
        L36:
            if (r19 < 0) goto L45;
            Selection.setSelection(r20, r19);
            return;
        L45:
            return;
        L42:
            return;
        L24:
            r15.getClass();
            r16 = r14.length();
            goto L25
        L41:
            return;
        L16:
            r13 = false;
            goto L17
        }
    }

    public d(TextView r8) {
        this.f10107a = r8;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r8, int r10, int r11, Spanned r12, int r13, int r14) {
        TextView r15 = this.f10107a;
        if (r15.isInEditMode() == false) goto L5;
        return r8;
    L5:
        int r16 = androidx.emoji2.text.f.a().b();
        if (r16 == 0) goto L29;
        boolean r17 = true;
        if (r16 != 1) goto L10;
        if (r14 != 0) goto L19;
        if (r13 != 0) goto L19;
        if (r12.length() != 0) goto L19;
        if (r8 != r15.getText()) goto L19;
        r17 = false;
    L19:
        if (r17 == false) goto L28;
        if (r8 == null) goto L28;
        if (r10 == 0) goto L23;
    L25:
        r8 = r8.subSequence(r10, r11);
    L27:
        return androidx.emoji2.text.f.a().g(r8, r8.length());
    L23:
        if (r11 != r8.length()) goto L25;
    L28:
        return r8;
    L10:
        if (r16 == 3) goto L29;
        return r8;
    L29:
        androidx.emoji2.text.f r18 = androidx.emoji2.text.f.a();
        if (this.f10108b != null) goto L32;
        this.f10108b = new a(r15, this);
    L32:
        r18.h(this.f10108b);
        return r8;
    }
}

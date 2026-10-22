package q0;

import android.os.Bundle;
import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import android.widget.TextView;
import androidx.emoji2.text.j;

/* JADX INFO: loaded from: classes.dex */
public final class c extends InputConnectionWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f10105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f10106b;

    public static class a {
    }

    public c(EditText r8, InputConnection r10, EditorInfo r11) {
        a r12 = new a();
        super(r10, false);
        this.f10105a = r8;
        this.f10106b = r12;
        boolean r13 = true;
        if (androidx.emoji2.text.f.f1747j == null) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L23;
        androidx.emoji2.text.f r15 = androidx.emoji2.text.f.a();
        if (r15.b() == 1) goto L11;
        r13 = false;
    L11:
        if (r13 == false) goto L24;
        if (r11 != null) goto L15;
        return;
    L15:
        if (r11.extras != null) goto L17;
        r11.extras = new Bundle();
    L17:
        androidx.emoji2.text.f.a r16 = r15.f1752e;
        r16.getClass();
        Bundle r17 = r11.extras;
        p0.b r18 = r16.f1757c.f1796a;
        int r19 = r18.a(4);
        if (r19 == 0) goto L20;
        int r20 = r18.f9913b.getInt(r19 + r18.f9912a);
    L21:
        r17.putInt("android.support.text.emoji.emojiCompat_metadataVersion", r20);
        Bundle r21 = r11.extras;
        r16.f1758a.getClass();
        r21.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
        return;
    L20:
        r20 = 0;
        goto L21
    L24:
        return;
    L23:
        return;
    L5:
        r14 = false;
        goto L6
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int r8, int r10) {
        Editable r11 = this.f10105a.getEditableText();
        this.f10106b.getClass();
        Object r12 = androidx.emoji2.text.f.f1746i;
        if (j.b(this, r11, r8, r10, false) == false) goto L5;
    L6:
        return true;
    L5:
        if (super.deleteSurroundingText(r8, r10) == true) goto L6;
        return false;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int r8, int r10) {
        Editable r11 = this.f10105a.getEditableText();
        this.f10106b.getClass();
        Object r12 = androidx.emoji2.text.f.f1746i;
        if (j.b(this, r11, r8, r10, true) == false) goto L5;
        return true;
    L5:
        if (super.deleteSurroundingTextInCodePoints(r8, r10) == true) goto L10;
        return false;
    L10:
        return true;
    }
}

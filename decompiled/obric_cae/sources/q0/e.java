package q0;

import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.emoji2.text.j;

/* JADX INFO: loaded from: classes.dex */
public final class e implements KeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KeyListener f10111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f10112b;

    public static class a {
    }

    public e(KeyListener r8) {
        a r10 = new a();
        this.f10111a = r8;
        this.f10112b = r10;
    }

    @Override // android.text.method.KeyListener
    public final void clearMetaKeyState(View r8, Editable r10, int r11) {
        this.f10111a.clearMetaKeyState(r8, r10, r11);
    }

    @Override // android.text.method.KeyListener
    public final int getInputType() {
        return this.f10111a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyDown(View r8, Editable r10, int r11, KeyEvent r12) {
        this.f10112b.getClass();
        Object r13 = androidx.emoji2.text.f.f1746i;
        if (r11 != 67) goto L5;
        boolean r14 = j.a(r10, r12, false);
    L9:
        if (r14 == false) goto L11;
        MetaKeyKeyListener.adjustMetaAfterKeypress(r10);
        boolean r15 = true;
    L12:
        if (r15 == true) goto L16;
        if (this.f10111a.onKeyDown(r8, r10, r11, r12) == true) goto L16;
        return false;
    L16:
        return true;
    L11:
        r15 = false;
        goto L12
    L5:
        if (r11 == 112) goto L7;
        r14 = false;
        goto L9
    L7:
        r14 = j.a(r10, r12, true);
        goto L9
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyOther(View r8, Editable r10, KeyEvent r11) {
        return this.f10111a.onKeyOther(r8, r10, r11);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyUp(View r8, Editable r10, int r11, KeyEvent r12) {
        return this.f10111a.onKeyUp(r8, r10, r11, r12);
    }
}

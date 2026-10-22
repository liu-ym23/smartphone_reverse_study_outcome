package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import java.io.Serializable;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1201b;

    public k(EditText r8) {
        this.f1200a = r8;
        this.f1201b = new q0.a(r8);
    }

    public final KeyListener a(KeyListener r8) {
        if ((!(r8 instanceof NumberKeyListener)) == false) goto L14;
        ((q0.a) this.f1201b).f10099a.getClass();
        if ((r8 instanceof q0.e) == true) goto L16;
        if (r8 != null) goto L10;
        return null;
    L10:
        if ((r8 instanceof NumberKeyListener) == false) goto L13;
        return r8;
    L13:
        return new q0.e(r8);
    L16:
        return r8;
    L14:
        return r8;
    }

    public final void b(AttributeSet r8, int r10) {
        TypedArray r11 = ((EditText) this.f1200a).getContext().obtainStyledAttributes(r8, c.a.f3223i, r10, 0);
        boolean r12 = true;
        if (r11.hasValue(14) == false) goto L6;
        r12 = r11.getBoolean(14, true);     // Catch: Throwable -> L8
    L6:
        r11.recycle();
        d(r12);
        return;
    L8:
        th = move-exception;
        r11.recycle();
        throw th;
    }

    public final InputConnection c(InputConnection r8, EditorInfo r10) {
        q0.a r11 = (q0.a) this.f1201b;
        if (r8 != null) goto L5;
        r11.getClass();
        return null;
    L5:
        q0.a.C0138a r12 = r11.f10099a;
        r12.getClass();
        if ((r8 instanceof q0.c) == true) goto L10;
        r8 = new q0.c(r12.f10100a, r8, r10);
    L10:
        return r8;
    }

    public final void d(boolean r8) {
        q0.g r10 = ((q0.a) this.f1201b).f10099a.f10101b;
        if (r10.f10121n != r8) goto L5;
        return;
    L5:
        if (r10.f10120m == null) goto L12;
        androidx.emoji2.text.f r11 = androidx.emoji2.text.f.a();
        q0.g.a r12 = r10.f10120m;
        r11.getClass();
        t2.b.n(r12, "initCallback cannot be null");
        ReentrantReadWriteLock r13 = r11.f1748a;
        r13.writeLock().lock();
        r11.f1749b.remove(r12);     // Catch: Throwable -> L9
        r13.writeLock().unlock();
    L9:
        th = move-exception;
        r13.writeLock().unlock();
        throw th;
    L12:
        r10.f10121n = r8;
        if (r8 == false) goto L19;
        int r14 = androidx.emoji2.text.f.a().b();
        q0.g.a(r10.f10118a, r14);
        return;
    }

    public /* synthetic */ k(Serializable r8, String r10) {
        this.f1200a = r10;
        this.f1201b = r8;
    }
}

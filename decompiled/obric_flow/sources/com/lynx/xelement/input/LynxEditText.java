package com.lynx.xelement.input;

import android.content.Context;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import po.a;
import po.b;
import po.d;
import po.e;
import po.g;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0007\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/lynx/xelement/input/LynxEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Lpo/d;", "backSpaceListener", "", "setBackSpaceListener", "(Lpo/d;)V", "Lpo/a;", "copyListener", "setCopyListener", "(Lpo/a;)V", "", "a", "Z", "getMPasting", "()Z", "setMPasting", "(Z)V", "mPasting", "Lpo/b;", "e", "Lpo/b;", "getOnAttachedToWindowListener", "()Lpo/b;", "setOnAttachedToWindowListener", "(Lpo/b;)V", "onAttachedToWindowListener", "Input_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class LynxEditText extends AppCompatEditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f11194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f11195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11196c;
    public int d;
    public b e;

    public LynxEditText(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        new LinkedHashMap();
        super(r5);
        this.d = -1;
        e r10 = new e(null, true);
        this.f11195b = r10;
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNullParameter(this, "editText");
    }

    public final boolean getMPasting() {
        return this.f11194a;
    }

    public final b getOnAttachedToWindowListener() {
        return this.e;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setCursorVisible(true);
        int r5 = this.d;
        if (r5 == (-1)) goto L20;
        b r10 = this.e;
        if (r10 == null) goto L21;
        LynxUIBaseInput r11 = ((g) r10).f21378a;
        LynxBaseUI r12 = r11.getParentBaseUI();
    L7:
        if (r12 == null) goto L14;
        if (Intrinsics.areEqual(r12.getTagName(), "x-overlay-ng") == true) goto L10;
        r12 = r12.getParentBaseUI();
        goto L7
    L10:
        Window r13 = r12.getWindow();
        if (r13 == null) goto L22;
        r13.setSoftInputMode(r5);
        return;
    L22:
        return;
    L14:
        Window r14 = r11.getWindow();
        if (r14 == null) goto L24;
        r14.setSoftInputMode(r5);
        return;
    L24:
        return;
    L21:
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo r5) {
        InputConnection r10 = super.onCreateInputConnection(r5);
        if (r10 != null) goto L5;
        return null;
    L5:
        e r11 = this.f11195b;
        if (r11 != null) goto L12;
    L10:
        this.f11196c = true;
        return r11;
    L12:
        r11.setTarget(r10);     // Catch: SecurityException -> L9
    L9:
        return null;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int r5) {
        if (r5 == 16908321) goto L11;
        if (r5 != 16908322) goto L7;
        this.f11194a = true;
        return super.onTextContextMenuItem(r5);
    L7:
        return super.onTextContextMenuItem(r5);
    L11:
        return super.onTextContextMenuItem(r5);
    }

    public final void setBackSpaceListener(d r5) {
    }

    public final void setCopyListener(a r5) {
        Intrinsics.checkNotNullParameter(r5, "copyListener");
    }

    public final void setMPasting(boolean r5) {
        this.f11194a = r5;
    }

    public final void setOnAttachedToWindowListener(b r5) {
        this.e = r5;
    }
}

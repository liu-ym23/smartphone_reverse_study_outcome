package com.bytedance.ies.xelement.input;

import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0007\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ies/xelement/input/LynxEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Lcom/bytedance/ies/xelement/input/k;", "backSpaceListener", "", "setBackSpaceListener", "(Lcom/bytedance/ies/xelement/input/k;)V", "Lcom/bytedance/ies/xelement/input/i;", "copyListener", "setCopyListener", "(Lcom/bytedance/ies/xelement/input/i;)V", "", "a", "Z", "getMPasting", "()Z", "setMPasting", "(Z)V", "mPasting", "Lcom/bytedance/ies/xelement/input/j;", "f", "Lcom/bytedance/ies/xelement/input/j;", "getOnAttachedToWindowListener", "()Lcom/bytedance/ies/xelement/input/j;", "setOnAttachedToWindowListener", "(Lcom/bytedance/ies/xelement/input/j;)V", "onAttachedToWindowListener", "x-element-input_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class LynxEditText extends AppCompatEditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f6425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i f6426c;
    public boolean d;
    public int e;
    public j f;

    public LynxEditText(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        new LinkedHashMap();
        super(r5);
        this.e = -1;
        l r10 = new l(null, true);
        this.f6425b = r10;
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNullParameter(this, "editText");
    }

    public final l a() {
        if (this.d == true) goto L7;
        LynxLog.b(3, "LynxEditText", "InputConnection has not been initialized yet ");
        return null;
    L7:
        return this.f6425b;
    }

    public final boolean getMPasting() {
        return this.f6424a;
    }

    public final j getOnAttachedToWindowListener() {
        return this.f;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setCursorVisible(true);
        int r5 = this.e;
        if (r5 == (-1)) goto L20;
        j r10 = this.f;
        if (r10 == null) goto L21;
        LynxBaseInputView r11 = ((g) r10).f6443a;
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
        l r11 = this.f6425b;
        if (r11 != null) goto L12;
    L10:
        this.d = true;
        return r11;
    L12:
        r11.setTarget(r10);     // Catch: SecurityException -> L9
    L9:
        return null;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int r17) {
        if (r17 != 16908321) goto L5;
        i r5 = this.f6426c;
        if (r5 == null) goto L60;
        Intrinsics.checkNotNull(r5);
        LynxTextAreaView r10 = ((s) r5).f6468a;
        LynxEditText r11 = r10.M;
        if (r11 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r11 = null;
    L15:
        int r12 = Selection.getSelectionStart(r11.getText());
        LynxEditText r13 = r10.M;
        if (r13 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r13 = null;
    L18:
        int r14 = Selection.getSelectionEnd(r13.getText());
        Method r15 = TextView.class.getDeclaredMethod("stopTextActionMode", null);     // Catch: Throwable -> L55 NoSuchMethodException -> L57
    L21:
        if (r12 == (-1)) goto L51;
        if (r14 == (-1)) goto L51;
        if (r12 > r14) goto L26;
        int r16 = r12;
    L27:
        if (r12 > r14) goto L29;
        r12 = r14;
    L29:
        LynxEditText r18 = r10.M;
        if (r18 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r18 = null;
    L32:
        Editable r19 = r18.getText();
        Intrinsics.checkNotNull(r19);
        Intrinsics.checkNotNullParameter(r19, "editable");
        LynxEditText r20 = r10.M;
        if (r20 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r20 = null;
    L35:
        SpannableStringBuilder r21 = new SpannableStringBuilder(r20.getText());
        se.b[] r22 = (se.b[]) r21.getSpans(r16, r12, se.b.class);
        int r110 = r22.length;
        int r111 = 0;
    L36:
        if (r111 >= r110) goto L38;
        se.b r112 = r22[r111];
        int r113 = r21.getSpanStart(r112);
        r21.delete(r113, r21.getSpanEnd(r112));
        r21.insert(r113, r112.f21890b + r112.f21889a);
        r111 = r111 + 1;
        goto L36
    L38:
        we.b[] r23 = (we.b[]) r21.getSpans(r16, r12, we.b.class);
        int r114 = r23.length;
        int r115 = 0;
    L39:
        if (r115 >= r114) goto L42;
        we.b r116 = r23[r115];
        r21.removeSpan(null);
        r115 = r115 + 1;
        goto L39
    L42:
        if (r16 <= r21.length()) goto L44;
    L46:
        ClipData r24 = ClipData.newPlainText(null, "");
    L47:
        LynxTextAreaView.t(r10, r24);
        r15.setAccessible(true);
        LynxEditText r25 = r10.M;
        if (r25 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r25 = null;
    L50:
        r15.invoke(r25, null);
    L58:
        return true;
    L44:
        if (r12 > r21.length()) goto L46;
        r24 = ClipData.newPlainText(null, r21.subSequence(r16, r12));
        goto L47
    L26:
        r16 = r14;
    L51:
        LynxTextAreaView.t(r10, ClipData.newPlainText(null, ""));
        r15.setAccessible(true);
        LynxEditText r26 = r10.M;
        if (r26 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r26 = null;
    L54:
        r15.invoke(r26, null);
    L57:
        LynxLog.b(4, "LynxTextAreaView", "Unable to find stopTextActionMode method");
    L55:
        th = move-exception;
        LynxLog.b(4, "LynxTextAreaView", "An unexpected error was encountered while getting the stopTextActionMode method. error message: " + th.getMessage());
        goto L58
    L60:
        return super.onTextContextMenuItem(r17);
    L5:
        if (r17 != 16908322) goto L7;
        this.f6424a = true;
        return super.onTextContextMenuItem(r17);
    L7:
        return super.onTextContextMenuItem(r17);
    }

    public final void setBackSpaceListener(k r5) {
        l r10 = this.f6425b;
        if (r10 == null) goto L6;
        r10.f6447a = r5;
        return;
    }

    public final void setCopyListener(i r5) {
        Intrinsics.checkNotNullParameter(r5, "copyListener");
        this.f6426c = r5;
    }

    public final void setMPasting(boolean r5) {
        this.f6424a = r5;
    }

    public final void setOnAttachedToWindowListener(j r5) {
        this.f = r5;
    }
}

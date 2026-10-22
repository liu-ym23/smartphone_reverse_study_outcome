package com.larus.browsertakeover.render;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStructure;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.AppCompatEditText;
import com.larus.bmhome.share.panel.ShareType;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0000\u0018\u0000 E2\u00020\u0001:\u0002DEB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J0\u0010 \u001a\u00020!2\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020$0#j\b\u0012\u0004\u0012\u00020$`%2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0007H\u0016J\u0018\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0014H\u0016J\b\u0010,\u001a\u00020\u0007H\u0017J\u0018\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0007H\u0017J\u001e\u00101\u001a\u00020!2\u0006\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u00020\u0011J\u000e\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020\u0014J\u0006\u00107\u001a\u00020\u0014J\u0006\u00108\u001a\u00020\u0014J\u0006\u00109\u001a\u00020!J\u0006\u0010:\u001a\u00020!J\u0006\u0010;\u001a\u00020!J\u0006\u0010<\u001a\u00020\u0011J\u0006\u0010=\u001a\u00020!J\b\u0010>\u001a\u00020\u0014H\u0002J\n\u0010?\u001a\u0004\u0018\u00010\u0011H\u0002J\n\u0010@\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010A\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010B\u001a\u00020!H\u0002J\b\u0010C\u001a\u00020\u0011H\u0002R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/larus/browsertakeover/render/RemoteImeEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "listener", "Lcom/larus/browsertakeover/render/RemoteImeEditText$Listener;", "getListener", "()Lcom/larus/browsertakeover/render/RemoteImeEditText$Listener;", "setListener", "(Lcom/larus/browsertakeover/render/RemoteImeEditText$Listener;)V", "composingText", "", "remoteInputMode", "proxyMode", "", "activeInputConnection", "Landroid/view/inputmethod/InputConnection;", "onCreateInputConnection", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onKeyPreIme", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyDown", "onKeyUp", "addFocusables", "", "views", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "direction", "focusableMode", "requestRectangleOnScreen", "rectangle", "Landroid/graphics/Rect;", "immediate", "getAutofillType", "onProvideAutofillStructure", "structure", "Landroid/view/ViewStructure;", "flags", "applyRemoteInputMode", "inputMode", "isPassword", "enterKeyHint", "setProxyMode", "enabled", "canEnterProxyMode", "isProxyMode", "flushProxyComposition", "finishProxyComposition", "cancelProxyComposition", "consumePendingText", "clearPendingText", "hasLocalComposition", "currentComposingSpanText", "currentCompositionCandidate", "handleRemoteKeyEvent", "clearLocalText", "validatedLocalText", "Listener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RemoteImeEditText extends AppCompatEditText {
    public static final Set<String> f = null;
    public static final Set<String> g = null;
    public b a;
    public String b;
    public String c;
    public boolean d;
    public c e;

    public static final class a {
    }

    public interface b {
        void I10(String r1);

        void LI();

        void hQ();

        void ob();

        void y9(int r1, int r2);
    }

    public static final class c extends InputConnectionWrapper {
        public final /* synthetic */ RemoteImeEditText a;

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean finishComposingText() {
            RemoteImeEditText r0 = this.a;
            if (r0.d == false) goto L5;
            String r1 = r0.f();
            if (r1 != null) goto L10;
            r1 = this.a.b;
        L10:
            if (r1 == null) goto L25;
            boolean r3 = true;
            if (r1.length() <= 0) goto L14;
            boolean r2 = true;
        L15:
            if (r2 == true) goto L18;
            r1 = null;
        L18:
            if (r1 == null) goto L25;
            if (r1.length() <= 4096) goto L23;
            r3 = false;
        L23:
            if (r3 == false) goto L25;
        L26:
            boolean r4 = super.finishComposingText();
            RemoteImeEditText r5 = this.a;
            r5.b = null;
            if (r1 == null) goto L31;
            b r6 = r5.getListener();
            if (r6 == null) goto L31;
            r6.I10(r1);
        L31:
            this.a.e();
            return r4;
        L14:
            r2 = false;
        L25:
            r1 = null;
            goto L26
        L5:
            return super.finishComposingText();
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean sendKeyEvent(KeyEvent r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            RemoteImeEditText r0 = this.a;
            if (r0.d == true) goto L7;
            return super.sendKeyEvent(r3);
        L7:
            if (r0.h(r3) == false) goto L10;
            return true;
        L10:
            return super.sendKeyEvent(r3);
        }

        public c(InputConnection r1, RemoteImeEditText r2) {
            this.a = r2;
            super(r1, true);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean commitText(CharSequence r7, int r8) {
            if (this.a.d == false) goto L5;
            boolean r9 = super.commitText(r7, r8);
            Editable r10 = this.a.getText();
            if (r10 == null) goto L9;
            String r11 = r10.toString();
        L10:
            String r1 = "";
            if (r11 != null) goto L13;
            r11 = "";
        L13:
            boolean r4 = true;
            if (r11.length() > 4096) goto L16;
            boolean r2 = true;
        L17:
            if (r2 == true) goto L20;
            r11 = null;
        L20:
            if (r11 == null) goto L23;
            r1 = r11;
        L23:
            this.a.b = null;
            if (r1.length() > 0) goto L27;
            r4 = false;
        L27:
            if (r4 == false) goto L31;
            b r12 = this.a.getListener();
            if (r12 == null) goto L31;
            r12.I10(r1);
        L31:
            this.a.e();
            return r9;
        L16:
            r2 = false;
            goto L17
        L9:
            r11 = null;
            goto L10
        L5:
            return super.commitText(r7, r8);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean deleteSurroundingText(int r4, int r5) {
            RemoteImeEditText r0 = this.a;
            if (r0.d == true) goto L7;
            return super.deleteSurroundingText(r4, r5);
        L7:
            if (r0.i() == false) goto L10;
            boolean r6 = super.deleteSurroundingText(r4, r5);
            RemoteImeEditText r7 = this.a;
            r7.b = RemoteImeEditText.c(r7);
            return r6;
        L10:
            b r1 = this.a.getListener();
            if (r1 == null) goto L15;
            r1.y9(RangesKt.coerceIn(r4, 0, 64), RangesKt.coerceIn(r5, 0, 64));
            return true;
        L15:
            return true;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean deleteSurroundingTextInCodePoints(int r4, int r5) {
            RemoteImeEditText r0 = this.a;
            if (r0.d == true) goto L7;
            return super.deleteSurroundingTextInCodePoints(r4, r5);
        L7:
            if (r0.i() == false) goto L10;
            boolean r6 = super.deleteSurroundingTextInCodePoints(r4, r5);
            RemoteImeEditText r7 = this.a;
            r7.b = RemoteImeEditText.c(r7);
            return r6;
        L10:
            b r1 = this.a.getListener();
            if (r1 == null) goto L15;
            r1.y9(RangesKt.coerceIn(r4, 0, 64), RangesKt.coerceIn(r5, 0, 64));
            return true;
        L15:
            return true;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean setComposingText(CharSequence r2, int r3) {
            if (this.a.d == false) goto L5;
            boolean r4 = super.setComposingText(r2, r3);
            RemoteImeEditText r5 = this.a;
            r5.b = RemoteImeEditText.c(r5);
            return r4;
        L5:
            return super.setComposingText(r2, r3);
        }
    }

    public RemoteImeEditText(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RemoteImeEditText(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public int getAutofillType() {
        return 0;
    }

    static {
        f = SetsKt.setOf(new String[]{"numeric", "decimal"});
        g = SetsKt.setOf(new String[]{ShareType.TEXT, "email", ShareType.URL, "tel", "numeric", "decimal", "search"});
    }

    public final void g() {
        if (this.d == true) goto L6;
        return;
    L6:
        if (i() == false) goto L11;
        c r0 = this.e;
        if (r0 == null) goto L12;
        r0.finishComposingText();
        return;
    L12:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e() {
        Editable r0 = getText();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L14;
        Editable r2 = getText();
        if (r2 == null) goto L14;
        r2.clear();
    L14:
        if (Build.VERSION.SDK_INT < 26) goto L17;
        setImportantForAutofill(8);
        return;
    L17:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final String f() {
        Editable r0 = getText();
        if (r0 != null) goto L5;
        return null;
    L5:
        int r2 = BaseInputConnection.getComposingSpanStart(r0);
        int r3 = BaseInputConnection.getComposingSpanEnd(r0);
        if (r2 < 0) goto L13;
        if (r3 <= r2) goto L13;
        if (r3 > r0.length()) goto L13;
        return r0.subSequence(r2, r3).toString();
    L13:
        return null;
    }

    public final boolean i() {
        Editable r0 = getText();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (BaseInputConnection.getComposingSpanStart(r0) < 0) goto L8;
    L17:
        return true;
    L8:
        if (BaseInputConnection.getComposingSpanEnd(r0) >= 0) goto L17;
        String r1 = this.b;
        if (r1 != null) goto L12;
    L15:
        boolean r2 = true;
    L16:
        if (r2 == false) goto L17;
        return false;
    L12:
        if (r1.length() == 0) goto L15;
        r2 = false;
        goto L16
    }

    public final b getListener() {
        return this.a;
    }

    public static final String c(RemoteImeEditText r4) {
        String r0 = r4.f();
        if (r0 != null) goto L20;
        Editable r5 = r4.getText();
        if (r5 == null) goto L18;
        String r1 = r5.toString();
        if (r1 == null) goto L18;
        boolean r2 = false;
        if (r1.length() <= 0) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == true) goto L14;
    L16:
        if (r2 == false) goto L18;
        return r1;
    L14:
        if (r1.length() > 4096) goto L16;
        r2 = true;
        goto L16
    L11:
        r6 = false;
    L18:
        return null;
    L20:
        return r0;
    }

    public final boolean h(KeyEvent r8) {
        if (i() == false) goto L6;
        return false;
    L6:
        if (r8.getAction() != 1) goto L18;
        if (r8.getKeyCode() != 67) goto L10;
    L15:
        return true;
    L10:
        if (r8.getKeyCode() == 112) goto L15;
        if (r8.getKeyCode() == 66) goto L15;
        if (r8.getKeyCode() == 61) goto L15;
        return false;
    L18:
        if (r8.getAction() == 0) goto L20;
        return false;
    L20:
        int r0 = r8.getKeyCode();
        if (r0 == 61) goto L46;
        if (r0 == 112) goto L43;
        if (r0 == 66) goto L40;
        if (r0 == 67) goto L37;
        int r9 = r8.getUnicodeChar();
        if ((Integer.MIN_VALUE & r9) == 0) goto L28;
        boolean r1 = true;
    L29:
        if (r9 <= 0) goto L52;
        if (r1 == false) goto L32;
        return false;
    L32:
        if (Character.isValidCodePoint(r9) == false) goto L54;
        b r2 = this.a;
        if (r2 == null) goto L49;
        r2.I10(new String(Character.toChars(r9)));
    L49:
        return true;
    L54:
        return false;
    L52:
        return false;
    L28:
        r1 = false;
        goto L29
    L37:
        b r10 = this.a;
        if (r10 == null) goto L49;
        r10.y9(1, 0);
        goto L49
    L40:
        b r11 = this.a;
        if (r11 == null) goto L49;
        r11.ob();
        goto L49
    L43:
        b r12 = this.a;
        if (r12 == null) goto L49;
        r12.y9(0, 1);
        goto L49
    L46:
        b r13 = this.a;
        if (r13 == null) goto L49;
        r13.LI();
        goto L49
    }

    public final InputConnection onCreateInputConnection(EditorInfo r4) {
        Intrinsics.checkNotNullParameter(r4, "outAttrs");
        InputConnection r0 = super.onCreateInputConnection(r4);
        if (r0 != null) goto L6;
        return null;
    L6:
        r4.imeOptions = (r4.imeOptions | 268435456) | 16777216;
        c r5 = new c(r0, this);
        this.e = r5;
        return r5;
    }

    public final void setListener(b r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setProxyMode(boolean r3) {
        boolean r0 = this.d;
        if (r0 != r3) goto L5;
        return;
    L5:
        InputMethodManager r1 = null;
        if (r0 == false) goto L12;
        if (r3 == true) goto L12;
        this.b = null;
        Editable r2 = getText();
        if (r2 == null) goto L11;
        BaseInputConnection.removeComposingSpans(r2);
    L11:
        e();
    L12:
        this.d = r3;
        this.b = null;
        Object r4 = getContext().getSystemService("input_method");
        if ((r4 instanceof InputMethodManager) == false) goto L15;
        r1 = (InputMethodManager) r4;
    L15:
        if (r1 == null) goto L18;
        r1.restartInput(this);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onKeyDown(int r2, KeyEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if (this.d == false) goto L9;
        if (h(r3) == false) goto L9;
        return true;
    L9:
        return super/*android.widget.EditText*/.onKeyDown(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onKeyPreIme(int r4, KeyEvent r5) {
        if (r4 != 4) goto L14;
        boolean r0 = false;
        if (r5 != null) goto L7;
    L9:
        if (r0 == false) goto L14;
        b r1 = this.a;
        if (r1 == null) goto L14;
        r1.hQ();
        goto L14
    L7:
        if (r5.getAction() != 1) goto L9;
        r0 = true;
    L14:
        return super/*android.widget.EditText*/.onKeyPreIme(r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onKeyUp(int r2, KeyEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if (this.d == false) goto L9;
        if (h(r3) == false) goto L9;
        return true;
    L9:
        return super/*android.widget.EditText*/.onKeyUp(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onProvideAutofillStructure(ViewStructure r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "structure");
        super/*android.widget.EditText*/.onProvideAutofillStructure(r2, r3);
        r2.setAutofillType(0);
        r2.setText("");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean requestRectangleOnScreen(Rect r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "rectangle");
        if (this.d == false) goto L6;
        return false;
    L6:
        return super/*android.widget.EditText*/.requestRectangleOnScreen(r2, r3);
    }

    public RemoteImeEditText(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = ShareType.TEXT;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void addFocusables(ArrayList<View> r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "views");
        if (this.d == false) goto L6;
        super/*android.widget.EditText*/.addFocusables(r2, r3, r4);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(String r7, boolean r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "inputMode");
        Intrinsics.checkNotNullParameter(r9, "enterKeyHint");
        Locale r0 = Locale.US;
        String r10 = r7.toLowerCase(r0);
        InputMethodManager r2 = null;
        if (g.contains(r10) == true) goto L6;
        r10 = null;
    L6:
        if (r10 != null) goto L8;
        r10 = ShareType.TEXT;
    L8:
        int r1 = 2;
        if (r8 == true) goto L11;
    L13:
        if (r8 == false) goto L16;
        int r11 = 129;
    L31:
        String r12 = r9.toLowerCase(r0);
        int r3 = r12.hashCode();
        if (r3 == (-906336856)) goto L52;
        if (r3 == 3304) goto L49;
        if (r3 == 3089282) goto L45;
        if (r3 != 3377907) goto L54;
        if (r12.equals("next") == false) goto L54;
        r1 = 5;
    L57:
        int r13 = (268435456 | r1) | 16777216;
        if (Intrinsics.areEqual(this.c, r10) == true) goto L60;
    L64:
        this.c = r10;
        setInputType(r11);
        setImeOptions(r13);
        Object r14 = getContext().getSystemService("input_method");
        if ((r14 instanceof InputMethodManager) == false) goto L67;
        r2 = (InputMethodManager) r14;
    L67:
        if (r2 == null) goto L70;
        r2.restartInput(this);
        return;
    L70:
        return;
    L60:
        if (getInputType() != r11) goto L64;
        if (getImeOptions() != r13) goto L64;
        return;
    L54:
        if (Intrinsics.areEqual(r10, "search") == false) goto L56;
    L55:
        r1 = 3;
        goto L57
    L56:
        r1 = 4;
        goto L57
    L45:
        if (r12.equals("done") == false) goto L54;
        r1 = 6;
        goto L57
    L49:
        if (r12.equals("go") == true) goto L57;
    L52:
        if (r12.equals("search") == true) goto L55;
    L16:
        if (Intrinsics.areEqual(r10, "email") == false) goto L19;
        r11 = 33;
        goto L31
    L19:
        if (Intrinsics.areEqual(r10, ShareType.URL) == false) goto L22;
        r11 = 17;
        goto L31
    L22:
        if (Intrinsics.areEqual(r10, "tel") == false) goto L25;
        r11 = 3;
        goto L31
    L25:
        if (Intrinsics.areEqual(r10, "numeric") == false) goto L28;
        r11 = 2;
        goto L31
    L28:
        if (Intrinsics.areEqual(r10, "decimal") == false) goto L30;
        r11 = 8194;
        goto L31
    L30:
        r11 = 16385;
        goto L31
    L11:
        if (f.contains(r10) == false) goto L13;
        r11 = 18;
        goto L31
    }

    public /* synthetic */ RemoteImeEditText(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r3 & 4) == 0) goto L8;
        int r5 = R.attr.editTextStyle;
    L9:
        this(r1, r2, r5);
        return;
    L8:
        r5 = 0;
        goto L9
    }
}

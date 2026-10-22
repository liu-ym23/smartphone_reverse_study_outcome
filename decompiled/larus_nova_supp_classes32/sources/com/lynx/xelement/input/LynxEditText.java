package com.lynx.xelement.input;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.render.PlatformRendererContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.obric.aivoice.core.data.NameKeys;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u0011./B\u0011\b\u0016\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'B\u0019\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b&\u0010*B!\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b&\u0010-J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001b\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00060"}, d2 = {"Lcom/lynx/xelement/input/LynxEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Lx6a/e;", "Lx6a/i;", "renderer", NameKeys.UnloadStrategy_No_Strategy, "setRenderer", "getRenderer", "Landroid/view/View;", "getView", "Lcom/lynx/xelement/input/a$a;", "backSpaceListener", "setBackSpaceListener", "Lcom/lynx/xelement/input/LynxEditText$b;", "copyListener", "setCopyListener", NameKeys.UnloadStrategy_No_Strategy, "a", "Z", "getMPasting", "()Z", "setMPasting", "(Z)V", "mPasting", "f", "getMHasDrawn", "setMHasDrawn", "mHasDrawn", "Lcom/lynx/xelement/input/LynxEditText$c;", "g", "Lcom/lynx/xelement/input/LynxEditText$c;", "getOnAttachedToWindowListener", "()Lcom/lynx/xelement/input/LynxEditText$c;", "setOnAttachedToWindowListener", "(Lcom/lynx/xelement/input/LynxEditText$c;)V", "onAttachedToWindowListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", NameKeys.UnloadStrategy_No_Strategy, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "c", "Input_release"}, k = 1, mv = {1, 6, 0})
public class LynxEditText extends AppCompatEditText implements x6a.e {
    public boolean a;
    public com.lynx.xelement.input.a b;
    public boolean c;
    public int d;
    public x6a.i e;
    public boolean f;
    public c g;

    public static final class a {
    }

    public interface b {
    }

    public interface c {
        void a(int r1);
    }

    static {
    }

    @Override // x6a.e
    public final /* synthetic */ void applyRendererClipBounds(boolean r1, Rect r2) {
        x6a.d.a(this, r1, r2);
    }

    @Override // x6a.e
    public final /* synthetic */ void applyRendererOpacity(float r1) {
        x6a.d.b(this, r1);
    }

    @Override // x6a.e
    public final /* synthetic */ void applyRendererTransform(float[] r1) {
        x6a.d.c(this, r1);
    }

    @Override // x6a.e
    public final /* synthetic */ PointF convertPointInRendererHostToScreen(PointF r1) {
        return x6a.d.d(this, r1);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // x6a.e
    public View getView() {
        return this;
    }

    @Override // x6a.e
    public final /* synthetic */ void invalidateForRenderer() {
        x6a.d.i(this);
    }

    @Override // x6a.e
    public final /* synthetic */ boolean invokeUIMethod(String r1, ReadableMap r2, Callback r3) {
        return false;
    }

    @Override // x6a.e
    public final /* synthetic */ void requestLayoutForRenderer() {
        x6a.d.j(this);
    }

    public final void setBackSpaceListener(com.lynx.xelement.input.a.InterfaceC0069a r1) {
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
        x6a.d.k(this, r1);
    }

    public final void setCopyListener(b r2) {
        Intrinsics.checkNotNullParameter(r2, "copyListener");
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
        x6a.d.l(this, r1);
    }

    public final void c() {
        com.lynx.xelement.input.a r0 = new com.lynx.xelement.input.a();
        this.b = r0;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(this, "editText");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.EditText*/.onAttachedToWindow();
        setCursorVisible(true);
        int r0 = this.d;
        if (r0 == (-1)) goto L8;
        c r1 = this.g;
        if (r1 == null) goto L9;
        r1.a(r0);
        return;
    L9:
        return;
    }

    public final boolean getMHasDrawn() {
        return this.f;
    }

    public final boolean getMPasting() {
        return this.a;
    }

    public final c getOnAttachedToWindowListener() {
        return this.g;
    }

    @Override // x6a.e
    public x6a.i getRenderer() {
        return this.e;
    }

    public LynxEditText(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2);
        this.d = -1;
        c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dispatchDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        super/*android.widget.EditText*/.dispatchDraw(r2);
        x6a.i r0 = this.e;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    public final InputConnection onCreateInputConnection(EditorInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "outAttrs");
        InputConnection r4 = super.onCreateInputConnection(r3);
        if (r4 != null) goto L11;
        return null;
    L11:
        com.lynx.xelement.input.a r1 = this.b;     // Catch: SecurityException -> L10
        if (r1 == null) goto L8;
        r1.setTarget(r4);     // Catch: SecurityException -> L10
    L8:
        this.c = true;
        return this.b;
    L10:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        x6a.i r0 = this.e;
        if (r0 == null) goto L5;
        r0.g(r2);
        r0.c(r2);
    L5:
        super/*android.widget.EditText*/.onDraw(r2);
        this.f = true;
    }

    public final boolean onTextContextMenuItem(int r2) {
        switch(r2) {
            case 16908321: goto L8;
            case 16908322: goto L5;
            default: goto L4;
        };
    L5:
        this.a = true;
        return super.onTextContextMenuItem(r2);
    L4:
        return super.onTextContextMenuItem(r2);
    L8:
        return super.onTextContextMenuItem(r2);
    }

    public final void setMHasDrawn(boolean r1) {
        this.f = r1;
    }

    public final void setMPasting(boolean r1) {
        this.a = r1;
    }

    public final void setOnAttachedToWindowListener(c r1) {
        this.g = r1;
    }

    @Override // x6a.e
    public void setRenderer(x6a.i r2) {
        Intrinsics.checkNotNullParameter(r2, "renderer");
        this.e = r2;
    }

    public LynxEditText(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        new LinkedHashMap();
        super(r2, r3);
        this.d = -1;
        c();
    }

    @Override // x6a.e
    public final x6a.i createRenderer(PlatformRendererContext r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "platformRendererContext");
        return new x6a.i(r2, r3);
    }

    public LynxEditText(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        new LinkedHashMap();
        super(r2, r3, r4);
        this.d = -1;
        c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        x6a.i r0 = this.e;
        if (r0 == null) goto L7;
        LynxBaseUI r1 = r0.h;
        if (r1 == null) goto L7;
        r1.measure();
    L7:
        super/*android.widget.EditText*/.onLayout(r2, r3, r4, r5, r6);
    }
}

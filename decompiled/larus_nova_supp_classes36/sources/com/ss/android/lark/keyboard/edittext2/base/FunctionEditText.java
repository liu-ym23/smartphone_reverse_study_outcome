package com.ss.android.lark.keyboard.edittext2.base;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import com.ss.android.lark.KeyboardBaseModule;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.edittext2.widget.g;
import com.ss.android.lark.keyboard.edittext2.widget.p;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u000f\u001a\u00020\u0010\"\b\b\u0000\u0010\u0011*\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\rJ%\u0010\u0013\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0015H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0004H\u0016J!\u0010\u0017\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u000e*\b\u0012\u0004\u0012\u0002H\u00110\rH\u0002¢\u0006\u0002\u0010\u0018J%\u0010\u0019\u001a\u00020\u00102\u001d\u0010\u001a\u001a\u0019\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00100\u001b¢\u0006\u0002\b\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!H\u0016R\u001e\u0010\u000b\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/ss/android/lark/keyboard/edittext2/base/FunctionEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Lcom/ss/android/lark/keyboard/edittext2/base/IFunctionProvider;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "editors", "", "Ljava/lang/Class;", "Lcom/ss/android/lark/keyboard/edittext2/base/IEditFunction;", "use", "", "E", "clazz", "get", TabAppInfo.IMAGE_JSON_KEY, "Lcom/ss/android/lark/keyboard/edittext2/base/IEditFunction$Key;", "(Lcom/ss/android/lark/keyboard/edittext2/base/IEditFunction$Key;)Lcom/ss/android/lark/keyboard/edittext2/base/IEditFunction;", "instanceAndInit", "(Ljava/lang/Class;)Lcom/ss/android/lark/keyboard/edittext2/base/IEditFunction;", "batchEdit", "action", "Lkotlin/Function2;", "Landroid/text/Editable;", "Lkotlin/ExtensionFunctionType;", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "Companion", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public class FunctionEditText extends AppCompatEditText implements b {
    public static final CopyOnWriteArraySet<Class<? extends com.ss.android.lark.keyboard.edittext2.base.a>> b = null;
    public final Map<Class<?>, com.ss.android.lark.keyboard.edittext2.base.a> a;

    public static final class a {
    }

    public FunctionEditText(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FunctionEditText(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    static {
        b = new CopyOnWriteArraySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.keyboard.edittext2.base.b
    public final Context context() {
        return getContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(Function2<? super FunctionEditText, ? super Editable, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        Editable r0 = getEditableText();
        if ((r0 instanceof p) == true) goto L6;
        Intrinsics.checkNotNull(r0);
        r3.invoke(this, r0);
        return;
    L6:
        p r1 = (p) r0;
        r1.a();
        r3.invoke(this, r0);
        Iterator<p.b> r4 = r1.b.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r4.next().b.decrementAndGet();
        goto L8
    L10:
        r1.b();
    }

    public final <E extends com.ss.android.lark.keyboard.edittext2.base.a> void d(Class<E> r4) {
        Intrinsics.checkNotNullParameter(r4, "clazz");
        Iterator<Class<? extends com.ss.android.lark.keyboard.edittext2.base.a>> r0 = b.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Class<? extends com.ss.android.lark.keyboard.edittext2.base.a> r1 = r0.next();
        if (r1.isAssignableFrom(r4) == false) goto L4;
    L9:
        Class<? extends com.ss.android.lark.keyboard.edittext2.base.a> r2 = r1;
        if (r2 != null) goto L13;
        Log.e("FunctionEditText", "use current class " + r4.getName() + " is not registered in support class set");
        return;
    L13:
        Map<Class<?>, com.ss.android.lark.keyboard.edittext2.base.a> r3 = this.a;
        E r5 = r4.newInstance();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type E of com.ss.android.lark.keyboard.edittext2.base.FunctionEditText.instanceAndInit");
        E r6 = r5;
        r6.A(this);
        r6.d();
        r3.put(r2, r6);
        return;
    L8:
        r1 = null;
        goto L9
    }

    public InputConnection onCreateInputConnection(EditorInfo r4) {
        Intrinsics.checkNotNullParameter(r4, "outAttrs");
        InputConnection r0 = super.onCreateInputConnection(r4);
        if (KeyboardBaseModule.a().isFeatureGatingEnable("im.messenger.keyboard.pass_attrs_revert") == false) goto L6;
        return r0;
    L6:
        if (r4.extras != null) goto L8;
        r4.extras = new Bundle();
    L8:
        Log.i("FunctionEditText", "set scene for funcEditText");
        Bundle r5 = r4.extras;
        if (r5 == null) goto L11;
        r5.putString("scene", "lark_im");
    L11:
        return r0;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.b
    public final <E extends com.ss.android.lark.keyboard.edittext2.base.a> E q(com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC0134a<E> r4) {
        Intrinsics.checkNotNullParameter(r4, TabAppInfo.IMAGE_JSON_KEY);
        Class<E> r5 = r4.a();
        LinkedHashMap r0 = (LinkedHashMap) this.a;
        E r1 = (E) r0.get(r5);
        if (r1 != null) goto L5;
        E r2 = r5.newInstance();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type E of com.ss.android.lark.keyboard.edittext2.base.FunctionEditText.instanceAndInit");
        r1 = r2;
        r1.A(this);
        r1.d();
        r0.put(r5, r1);
    L5:
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type E of com.ss.android.lark.keyboard.edittext2.base.FunctionEditText.get");
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FunctionEditText(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        setEditableFactory(g.a);
    }

    public /* synthetic */ FunctionEditText(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

package com.obric.oui.animation.style;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, d2 = {"findAllEditTexts", "", "Landroid/widget/EditText;", "view", "Landroid/view/View;", "hideSoftKeyboard", "", "rootView", "OUIAnimation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class b {
    public static final List<EditText> a(View r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        List<EditText> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.class) == false) goto L8;
        int r1 = 0;
        int r3 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.memorydata.plugin")).getChildCount();
    L5:
        if (r1 >= r3) goto L10;
        int r4 = r1 + 1;
        View r2 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.memorydata.plugin")).getChildAt(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "child");
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(a(r2), Collection.class, "com.obric.memorydata.plugin"));
        r1 = r4;
    L10:
        return r0;
    L8:
        if (ZeusTransformUtils.instanceOf(r6, EditText.class) == false) goto L10;
        r0.add(r6);
        goto L10
    }

    public static final void b(View r4) {
        Intrinsics.checkNotNullParameter(r4, "rootView");
        List<EditText> r0 = a(r4);
        Object r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("input_method");
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager r6 = (InputMethodManager) ZeusTransformUtils.preCheckCast(r5, InputMethodManager.class, "com.obric.memorydata.plugin");
        Iterator<EditText> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        EditText r2 = (EditText) ZeusTransformUtils.preCheckCast(r1.next(), EditText.class, "com.obric.memorydata.plugin");
        if (r6.isActive((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin")) == false) goto L4;
        r6.hideSoftInputFromWindow(r2.getWindowToken(), 0);
        goto L4
    }
}

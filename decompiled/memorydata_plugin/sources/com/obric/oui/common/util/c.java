package com.obric.oui.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0014\u0010\b\u001a\u00020\t*\u00020\u00032\b\b\u0001\u0010\n\u001a\u00020\t\u001a$\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t\u001a\u0016\u0010\u0010\u001a\u0004\u0018\u00010\f*\u00020\u00032\b\b\u0001\u0010\n\u001a\u00020\t\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0013\u001a\u0012\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u000e\u0010\u0016\u001a\u0004\u0018\u00010\u0013*\u00020\u0001H\u0007¨\u0006\u0017"}, d2 = {"getActivity", "Landroid/app/Activity;", "context", "Landroid/content/Context;", "getAppcompatActivity", "Landroidx/appcompat/app/AppCompatActivity;", "getLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "colorRes2Hex", "", "resId", "getMultiColorAttr", "Landroid/graphics/drawable/Drawable;", "typedArray", "Landroid/content/res/TypedArray;", "index", "getMutateDrawable", "toggleVisible", "", "Landroid/view/View;", "visible", "", "tryGetTopDecorView", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class c {
    public static final View a(Activity r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (ZeusTransformUtils.getWindow(r7, "com.obric.memorydata.plugin").getDecorView().hasWindowFocus() == false) goto L7;
        return ZeusTransformUtils.getWindow(r7, "com.obric.memorydata.plugin").getDecorView();
    L7:
        if (ZeusTransformUtils.instanceOf(r7, FragmentActivity.class) == false) goto L36;
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(((FragmentActivity) ZeusTransformUtils.preCheckCast(r7, FragmentActivity.class, "com.obric.memorydata.plugin")).getSupportFragmentManager().getFragments(), Collection.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L11;
    L14:
        boolean r1 = true;
    L15:
        if (r1 == true) goto L37;
        List<Fragment> r8 = ((FragmentActivity) ZeusTransformUtils.preCheckCast(r7, FragmentActivity.class, "com.obric.memorydata.plugin")).getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(r8, "supportFragmentManager.fragments");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L18:
        if (r9.hasNext() == false) goto L39;
        Fragment r2 = (Fragment) ZeusTransformUtils.preCheckCast(r9.next(), Fragment.class, "com.obric.memorydata.plugin");
        View r5 = r2.getView();
        if (r5 != null) goto L23;
    L21:
        boolean r10 = false;
    L25:
        if (r10 == false) goto L18;
        View r11 = r2.getView();
        if (r11 != null) goto L30;
        return null;
    L30:
        return r11.getRootView();
    L23:
        if (r5.hasWindowFocus() != true) goto L21;
        r10 = true;
        goto L25
    L39:
        return null;
    L37:
        return null;
    L11:
        if (r0.isEmpty() == true) goto L14;
        r1 = false;
        goto L15
    L36:
        return null;
    }

    public static final Activity getActivity(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
    L4:
        if (ZeusTransformUtils.instanceOf(r3, ContextWrapper.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r3, Activity.class) == true) goto L8;
        r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r3, ContextWrapper.class, "com.obric.memorydata.plugin")).getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r3, "rContext.baseContext");
        goto L4
    L8:
        return (Activity) ZeusTransformUtils.preCheckCast(r3, Activity.class, "com.obric.memorydata.plugin");
    L10:
        return null;
    }
}

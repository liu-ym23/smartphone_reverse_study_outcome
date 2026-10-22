package com.obric.assistant.window.materials.services.impl;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import bia.g;
import com.obric.assistant.window.materials.MaterialSceneType;
import com.obric.assistant.window.materials.services.IWindowMaterialService;
import com.obric.oui.material.OMaterialHelper;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J2\u0010\u0012\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0014H\u0016J\u0014\u0010\u0019\u001a\u00020\u000e*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u0010*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u001b\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\u00100\u0014H\u0002J\u0012\u0010\u001c\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\u00160\u0014H\u0002J\u0012\u0010\u001d\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\u00180\u0014H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/window/materials/services/impl/OWindowMaterialServiceImpl;", "Lcom/obric/assistant/window/materials/services/IWindowMaterialService;", "<init>", "()V", "materialsMap", "", "Lcom/obric/assistant/window/materials/MaterialSceneType;", "", "isMaterialEnabled", "", "context", "Landroid/content/Context;", "isBlurEnabled", "setupMaterials", "", "view", "Landroid/view/View;", "materialSceneType", "processWindowBottomMenu", "bgViews", "", "iconViews", "Landroid/widget/ImageView;", "textViews", "Landroid/widget/TextView;", "internalSetupMaterials", "getTargetView", "processBottomMenuBg", "processBottomMenuIcon", "processBottomMenuText", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OWindowMaterialServiceImpl implements IWindowMaterialService {
    public final Map<MaterialSceneType, Integer> a;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MaterialSceneType.values().length];
            r0[MaterialSceneType.INPUT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[MaterialSceneType.FLOATING_BG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[MaterialSceneType.WINDOW_BG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[MaterialSceneType.WINDOW_BG_WITH_BOTTOM_RADIUS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public OWindowMaterialServiceImpl() {
        if (OMaterialHelper.f() >= 4) goto L5;
        Map<MaterialSceneType, Integer> r0 = MapsKt.mapOf(new Pair[]{TuplesKt.to(MaterialSceneType.INPUT, 2131232210), TuplesKt.to(MaterialSceneType.ACTION_BAR, 2131232198), TuplesKt.to(MaterialSceneType.ACTION_BAR_SELECTED, 2131232200), TuplesKt.to(MaterialSceneType.ACTION_BAR_TASK_SKILL, 2131232202), TuplesKt.to(MaterialSceneType.ACTION_BAR_TASK_SKILL_SELECTED, 2131232204), TuplesKt.to(MaterialSceneType.BOTTOM_MENU, 2131232206), TuplesKt.to(MaterialSceneType.WINDOW_BG, 2131232197), TuplesKt.to(MaterialSceneType.WINDOW_BG_WITH_BOTTOM_RADIUS, 2131232197), TuplesKt.to(MaterialSceneType.FLOATING_BG, 2131232208)});
    L6:
        this.a = r0;
        return;
    L5:
        r0 = MapsKt.mapOf(new Pair[]{TuplesKt.to(MaterialSceneType.INPUT, 2131232211), TuplesKt.to(MaterialSceneType.ACTION_BAR, 2131232199), TuplesKt.to(MaterialSceneType.ACTION_BAR_SELECTED, 2131232201), TuplesKt.to(MaterialSceneType.ACTION_BAR_TASK_SKILL, 2131232203), TuplesKt.to(MaterialSceneType.ACTION_BAR_TASK_SKILL_SELECTED, 2131232205), TuplesKt.to(MaterialSceneType.BOTTOM_MENU, 2131232207), TuplesKt.to(MaterialSceneType.WINDOW_BG, 2131232212), TuplesKt.to(MaterialSceneType.WINDOW_BG_WITH_BOTTOM_RADIUS, 2131232213), TuplesKt.to(MaterialSceneType.FLOATING_BG, 2131232209)});
        goto L6
    }

    @Override // com.obric.assistant.window.materials.services.IWindowMaterialService
    public final boolean b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (OMaterialHelper.j(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (OMaterialHelper.f() < 3) goto L7;
        return true;
    }

    @Override // com.obric.assistant.window.materials.services.IWindowMaterialService
    public final void a(View r3, MaterialSceneType r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "materialSceneType");
        if (b.a[r4.ordinal()] == 1) goto L5;
        d(r3, r4);
        return;
    L5:
        if (r3.getId() == 2131375337) goto L7;
        r3.setBackground(new ColorDrawable(0));
        return;
    L7:
        d(r3, r4);
    }

    public final void d(View r5, MaterialSceneType r6) {
        Integer r0 = this.a.get(r6);
        if (r0 == null) goto L35;
        int r1 = r0.intValue();
        Object r2 = r5.getTag(2131381207);
        View r3 = null;
        if ((r2 instanceof View) == false) goto L7;
        View r4 = (View) r2;
    L8:
        if (r4 != null) goto L25;
        int r7 = b.a[r6.ordinal()];
        if (r7 != 2) goto L12;
    L23:
        r3 = r5;
    L24:
        r4 = r3;
        goto L25
    L12:
        if (r7 == 3) goto L23;
        if (r7 == 4) goto L23;
        Context r8 = r5.getContext();
        if ((r8 instanceof Activity) == false) goto L18;
        Activity r9 = (Activity) r8;
    L19:
        if (r9 == null) goto L24;
        Window r10 = r9.getWindow();
        if (r10 == null) goto L24;
        r3 = r10.findViewById(2131375324);
        goto L24
    L18:
        r9 = null;
    L25:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        OMaterialHelper.t(r5, r4);
        r5.setBackground(AppCompatResources.getDrawable(r5.getContext(), r1));
        int[] r11 = r5.getDrawableState();
        Intrinsics.checkNotNull(r11);
        if (r11.length != 0) goto L28;
        boolean r12 = true;
    L30:
        if ((!r12) == false) goto L32;
        int[] r13 = new int[0];
    L33:
        r5.getBackground().setState(r13);
        r5.getBackground().setState(r11);
        r5.getBackground().invalidateSelf();
        return;
    L32:
        r13 = new int[]{R.attr.state_enabled};
        goto L33
    L28:
        r12 = false;
        goto L30
    L7:
        r4 = null;
        goto L8
    }

    @Override // com.obric.assistant.window.materials.services.IWindowMaterialService
    public final void c(List<? extends View> r4, List<? extends ImageView> r5, List<? extends TextView> r6) {
        Intrinsics.checkNotNullParameter(r4, "bgViews");
        Intrinsics.checkNotNullParameter(r5, "iconViews");
        Intrinsics.checkNotNullParameter(r6, "textViews");
        Iterator<T> r7 = r4.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        View r0 = (View) r7.next();
        r0.setAlpha(1.0f);
        Lazy r1 = g.a;
        g.a(r0, true, MaterialSceneType.BOTTOM_MENU);
        goto L4
    L6:
        Iterator<T> r8 = r5.iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        ((ImageView) r8.next()).setBackground(new ColorDrawable(0));
        goto L8
    L10:
        Iterator<T> r9 = r6.iterator();
    L12:
        if (r9.hasNext() == false) goto L14;
        ((TextView) r9.next()).setAlpha(1.0f);
        goto L12
    }
}

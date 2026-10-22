package com.obric.oui.material;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\f\u0010\t\u001a\u00020\u0002*\u00020\nH\u0002\u001a0\u0010\u000b\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u001a&\u0010\u0011\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u001a;\u0010\u0012\u001a\u00020\u0001*\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e¢\u0006\u0002\u0010\u0015\u001a1\u0010\u0016\u001a\u00020\u0001*\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e¢\u0006\u0002\u0010\u0017\u001a\n\u0010\u0018\u001a\u00020\u000e*\u00020\u0019\u001a\n\u0010\u0018\u001a\u00020\u000e*\u00020\u0002\u001a\n\u0010\u001a\u001a\u00020\u0004*\u00020\u0019\u001a\n\u0010\u001a\u001a\u00020\u0004*\u00020\u0002\u001a\u001c\u0010\u0007\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000e\u001a$\u0010\u0007\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d\u001a\u001c\u0010\u0007\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000e\u001a&\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e\u001a&\u0010\u0007\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e\u001a\u0012\u0010\u0007\u001a\u00020\u0001*\u00020 2\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010!\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\b\u001a\u001a\u0010!\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001d\u001a\u0012\u0010!\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\b\u001a\u001c\u0010!\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\u0004\u001a\u001c\u0010!\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\u0004\u001a\u0012\u0010!\u001a\u00020\u0001*\u00020 2\u0006\u0010\u0007\u001a\u00020\b\u001a'\u0010\u0013\u001a\u00020\u0001*\u00020\u001b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\"\u001a'\u0010\u0013\u001a\u00020\u0001*\u00020\u001e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010#\u001a=\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010%\u001a1\u0010\u0013\u001a\u00020\u0001*\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010&\u001a'\u0010\u0013\u001a\u00020\u0001*\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\u0010$\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010'\u001a)\u0010\u0013\u001a\u00020\u0001*\u00020 2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010(\u001a3\u0010)\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010*\u001a3\u0010)\u001a\u00020\u0001*\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010+\u001a\u001d\u0010,\u001a\u00020\u0001*\u00020\u001b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\u0010-\u001a\u001d\u0010,\u001a\u00020\u0001*\u00020\u001e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\u0010.\u001a3\u0010,\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010*\u001a3\u0010,\u001a\u00020\u0001*\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010+\u001a)\u0010,\u001a\u00020\u0001*\u00020 2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010(\u001a\u001c\u0010/\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000e\u001a$\u0010/\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d\u001a\u001c\u0010/\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000e\u001a&\u0010/\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e\u001a&\u0010/\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e\u001a\u001c\u0010/\u001a\u00020\u0001*\u00020 2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000e\u001a\u0012\u00100\u001a\u00020\u0001*\u00020\u001b2\u0006\u00101\u001a\u00020\u0002\u001a\u001a\u00100\u001a\u00020\u0001*\u00020\u001b2\u0006\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u000e\u001a\u0012\u00100\u001a\u00020\u0001*\u00020\u001e2\u0006\u00101\u001a\u00020\u0002\u001a\u001a\u00100\u001a\u00020\u0001*\u00020\u001e2\u0006\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u000e\u001a\u0014\u00100\u001a\u00020\u0001*\u00020\u00022\b\u00101\u001a\u0004\u0018\u00010\u0002\u001a\u001c\u00100\u001a\u00020\u0001*\u00020\u00022\b\u00101\u001a\u0004\u0018\u00010\u00022\u0006\u00102\u001a\u00020\u000e\u001a\u001c\u00103\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\u0004\u001a\u001c\u00103\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\u0004\u001a)\u00104\u001a\u00020\u0001*\u00020\u001b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\"\u001a/\u00104\u001a\u00020\u0001*\u00020\u001b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0002\u00105\u001a'\u00104\u001a\u00020\u0001*\u00020\u001e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010#\u001a1\u00104\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u00106\u001a1\u00104\u001a\u00020\u0001*\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010&\u001a'\u00104\u001a\u00020\u0001*\u00020 2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u00107\u001a\u0012\u00108\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e\u001a\u0012\u00109\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010:\u001a\u00020\u0004\u001a\u0012\u00109\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010:\u001a\u00020\u0004\u001a\u0012\u00109\u001a\u00020\u0001*\u00020\u00022\u0006\u0010:\u001a\u00020\u0004\u001a\u0012\u0010;\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010;\u001a\u00020\u0001*\u00020\u00022\u0006\u0010<\u001a\u00020=¨\u0006>"}, d2 = {"applyMaterial", "", "Landroid/view/View;", "enable", "", "applyMaterialFromWindow", "applyMaterialShadow", "material", "Lcom/obric/oui/material/MaterialConfig;", "asMaterialView", "Landroid/widget/Button;", "contentMaterial", "Landroid/widget/ImageView;", "srcType", "", "drawMode", "drawableSrc", "contentMaterialFromWindow", "contentMaterials", "materials", "", "(Landroid/widget/ImageView;[Lcom/obric/oui/material/MaterialConfig;III)V", "contentMaterialsFromWindow", "(Landroid/widget/ImageView;[Lcom/obric/oui/material/MaterialConfig;II)V", "getMaterialLevel", "Landroid/content/Context;", "isMaterialEffectEnabled", "Landroid/graphics/Paint;", "density", "", "Landroid/graphics/drawable/Drawable;", "clearBackground", "Landroid/widget/TextView;", "materialFromWindow", "(Landroid/graphics/Paint;[Lcom/obric/oui/material/MaterialConfig;I)V", "(Landroid/graphics/drawable/Drawable;[Lcom/obric/oui/material/MaterialConfig;I)V", "level", "(Landroid/view/View;[Lcom/obric/oui/material/MaterialConfig;ZILjava/lang/Integer;)V", "(Landroid/widget/Button;[Lcom/obric/oui/material/MaterialConfig;ZI)V", "(Landroid/widget/Button;[Lcom/obric/oui/material/MaterialConfig;Ljava/lang/Integer;)V", "(Landroid/widget/TextView;[Lcom/obric/oui/material/MaterialConfig;Ljava/lang/Integer;)V", "materialsComplex", "(Landroid/view/View;[Lcom/obric/oui/material/MaterialConfig;ZLjava/lang/Integer;)V", "(Landroid/widget/Button;[Lcom/obric/oui/material/MaterialConfig;ZLjava/lang/Integer;)V", "materialsFromWindow", "(Landroid/graphics/Paint;[Lcom/obric/oui/material/MaterialConfig;)V", "(Landroid/graphics/drawable/Drawable;[Lcom/obric/oui/material/MaterialConfig;)V", "setMaterial", "setMaterialBackdropTarget", TypedValues.AttributesType.S_TARGET, "captureMode", "setMaterialFromWindow", "setMaterials", "(Landroid/graphics/Paint;[Lcom/obric/oui/material/MaterialConfig;IF)V", "(Landroid/view/View;[Lcom/obric/oui/material/MaterialConfig;ZI)V", "(Landroid/widget/TextView;[Lcom/obric/oui/material/MaterialConfig;I)V", "updateMaterialBackdropSrcType", "updateMaterialBackdropTargetType", "backdropView", "updateStatefulOverlayBlend", "overlayBlendConfigs", "Lcom/obric/oui/res/BlendConfigStateList;", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class l {
    public static final void a(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 == (-1)) goto L6;
        OMaterialHelper.b(r1, r2);
        return;
    }

    public static final void a(View r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        OMaterialHelper.a(r1, r2);
    }

    private static final void a(View r5, c r6) {
        if (ZeusTransformUtils.instanceOf(r5, com.obric.oui.common.style.b.class) == true) goto L5;
        return;
    L5:
        if (((com.obric.oui.common.style.b) ZeusTransformUtils.preCheckCast(r5, com.obric.oui.common.style.b.class, "com.obric.memorydata.plugin")).isEnableShadowWidthRadius() == false) goto L21;
        com.obric.oui.shadow.a[] r7 = r6.i();
        if (r7 != null) goto L12;
        ((com.obric.oui.common.style.b) ZeusTransformUtils.preCheckCast(r5, com.obric.oui.common.style.b.class, "com.obric.memorydata.plugin")).a(null, null);
        return;
    L12:
        if (r7.length <= 1) goto L15;
        float r0 = ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getDisplayMetrics().density;
        ((com.obric.oui.common.style.b) ZeusTransformUtils.preCheckCast(r5, com.obric.oui.common.style.b.class, "com.obric.memorydata.plugin")).a(com.obric.oui.common.style.k.f13495a.a(r7[0], r0), com.obric.oui.common.style.k.f13495a.a(r7[1], r0));
        return;
    L15:
        if (r7.length != 1) goto L20;
        float r2 = ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getDisplayMetrics().density;
        ((com.obric.oui.common.style.b) ZeusTransformUtils.preCheckCast(r5, com.obric.oui.common.style.b.class, "com.obric.memorydata.plugin")).a(com.obric.oui.common.style.k.f13495a.a(r7[0], r2), null);
        return;
    L20:
        return;
    }

    public static final void a(View r1, c r2, boolean r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "material");
        b(r1, r2, r3, r4);
    }

    public static /* synthetic */ void a(View r0, c r1, boolean r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 2;
    L8:
        a(r0, r1, r2, r3);
    }

    public static final void a(View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        OMaterialHelper.a(r1, r2);
    }

    public static final void a(View r1, c[] r2, boolean r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "materials");
        if (r3 == false) goto L5;
        r1.setBackgroundColor(0);
    L5:
        OMaterialHelper.a(r1, r4, r2, ZeusTransformUtils.getResources(r1, "com.obric.memorydata.plugin").getDisplayMetrics().density);
    }

    public static final void a(View r2, c[] r3, boolean r4, int r5, Integer r6) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "materials");
        if (r6 == null) goto L5;
        b(r2, r3[r6.intValue() - 1], r4, r5);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        Log.e("OUIMaterial", "error!! View.materials: error level=" + r6 + ", " + e);
        return;
    L5:
        if (r3.length != 1) goto L8;
        a(r2, r3[0], r4, r5);
        return;
    L8:
        a(r2, r3, r4, r5);
        a(r2, r3[Math.min(r3.length - 1, Math.max(0, b(r2) - 1))]);
    }

    public static /* synthetic */ void a(View r0, c[] r1, boolean r2, int r3, Integer r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = 2;
    L9:
        if ((r5 & 8) == 0) goto L11;
        r4 = null;
    L11:
        a(r0, r1, r2, r3, r4);
    }

    public static final void a(View r8, c[] r9, boolean r10, Integer r11) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "materials");
        boolean r0 = true;
        if (r11 == null) goto L5;
        a(r8, r9[r11.intValue() - 1], r10, 3);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        Log.e("OUIMaterial", "error!! View.materialsFromWindow: error level=" + r11 + ", " + e);
        return;
    L5:
        if (r9.length == 0) goto L8;
        r0 = false;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        a(r8, r9, r10, 3, null, 8, null);
    }

    public static /* synthetic */ void a(View r0, c[] r1, boolean r2, Integer r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        a(r0, r1, r2, r3);
    }

    public static final boolean a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return OMaterialHelper.a(r3);
    }

    public static final boolean a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return OMaterialHelper.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    public static final int b(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return OMaterialHelper.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    public static final void b(View r1, c r2, boolean r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "material");
        a(r1, r2);
        if (OMaterialHelper.a() == true) goto L5;
        return;
    L5:
        if (r3 == false) goto L7;
        r1.setBackgroundColor(0);
    L7:
        OMaterialHelper.a(r1, r4, r2, ZeusTransformUtils.getResources(r1, "com.obric.memorydata.plugin").getDisplayMetrics().density);
    }

    public static final void b(View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        OMaterialHelper.b(r1, r2);
    }
}

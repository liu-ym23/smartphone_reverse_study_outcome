package com.larus.business.multitask_management.impl.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.multitask_management.api.data.quick_access.NodeType;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[NodeType.values().length];
            r0[NodeType.FILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public static final class b extends ViewOutlineProvider {
        public final /* synthetic */ float a;

        public b(float r1) {
            this.a = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r8, Outline r9) {
            Intrinsics.checkNotNullParameter(r8, "view");
            Intrinsics.checkNotNullParameter(r9, "outline");
            r9.setRoundRect(0, 0, r8.getWidth(), r8.getHeight(), this.a);
        }
    }

    public static final void a(View r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        r3.setOutlineProvider(new b(c7.c(16)));
        r3.setClipToOutline(false);
        ViewCompat.setElevation(r3, c7.c(10));
        if (Build.VERSION.SDK_INT < 28) goto L5;
        int r1 = Color.argb(5, 0, 0, 0);
        r3.setOutlineAmbientShadowColor(r1);
        r3.setOutlineSpotShadowColor(r1);
    L5:
        Iterator r4 = CollectionsKt.listOfNotNull(new View[]{r3.findViewById(2131380392), r3.findViewById(2131380393), r3.findViewById(2131380406), r3.findViewById(2131380400)}).iterator();
    L7:
        if (r4.hasNext() == false) goto L15;
        View r0 = (View) r4.next();
        Drawable r2 = r0.getBackground();
        if (r2 == null) goto L13;
        Drawable r5 = r2.mutate();
        if (r5 == null) goto L13;
        r5.setAlpha(179);
    L14:
        r0.setBackground(r5);
    L13:
        r5 = null;
        goto L14
    }

    public static final int b(ll9.t r6) {
        Intrinsics.checkNotNullParameter(r6, "node");
        Object r2 = null;
        if (a.a[r6.a.ordinal()] != 1) goto L17;
        Iterator r0 = QuickAccessNodeDefaultFileIcons.getEntries().iterator();
    L6:
        if (r0.hasNext() == false) goto L14;
        Object r1 = r0.next();
        String r3 = ((QuickAccessNodeDefaultFileIcons) r1).getFileType();
        Map r4 = r6.i;
        if (r4 == null) goto L10;
        String r5 = (String) r4.get("file_type");
    L12:
        if (Intrinsics.areEqual(r3, r5) == false) goto L6;
        r2 = r1;
        goto L14
    L10:
        r5 = null;
    L14:
        QuickAccessNodeDefaultFileIcons r7 = (QuickAccessNodeDefaultFileIcons) r2;
        if (r7 != null) goto L39;
    L29:
        return 2131243087;
    L39:
        return r7.getResId();
    L17:
        Iterator r8 = QuickAccessNodeDefaultIcons.getEntries().iterator();
    L19:
        if (r8.hasNext() == false) goto L26;
        Object r9 = r8.next();
        if (((QuickAccessNodeDefaultIcons) r9).getNodeType() != r6.a) goto L23;
        boolean r10 = true;
    L24:
        if (r10 == false) goto L19;
        r2 = r9;
        goto L26
    L23:
        r10 = false;
    L26:
        QuickAccessNodeDefaultIcons r11 = (QuickAccessNodeDefaultIcons) r2;
        if (r11 == null) goto L29;
        return r11.getResId();
    }

    public static final int d(String r5, boolean r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (StringsKt.startsWith$default(r5, "#", false, 2, null) == true) goto L5;
    L7:
        int r8 = ColorProtector.parseColor(r5);
        if (r6 == true) goto L10;
        return r8;
    L10:
        int r9 = Color.alpha(r8);
        if (r9 < 255) goto L13;
        return r8;
    L13:
        float r10 = r9 / 255.0f;
        int r1 = Color.red(r8);
        int r2 = Color.green(r8);
        int r11 = Color.blue(r8);
        return Color.argb(255, e(r10, r1, Color.red(r7)), e(r10, r2, Color.green(r7)), e(r10, r11, Color.blue(r7)));
    L5:
        if (r5.length() != 9) goto L7;
        r5 = "#" + StringsKt.takeLast(r5, 2) + r5.substring(1, 7);
        goto L7
    }

    public static final int e(float r1, int r2, int r3) {
        return RangesKt.coerceIn(MathKt.roundToInt((r2 * r1) + (r3 * (1 - r1))), 0, 255);
    }

    public static final void c(Context r3, SimpleDraweeView r4, String r5, String r6, Integer r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "imageView");
        boolean r0 = v19.h.a;
        boolean r1 = true;
        int r2 = 0;
        if (v19.h.b(r3) == false) goto L13;
        if (r6 != null) goto L6;
    L9:
        boolean r8 = true;
    L10:
        if (r8 == true) goto L13;
        r5 = r6;
        goto L13
    L6:
        if (r6.length() == 0) goto L9;
        r8 = false;
    L13:
        Object r9 = null;
        if (o0.d(r5) == false) goto L40;
        Iterator r10 = MultitaskDefaultIcons.getEntries().iterator();
    L17:
        if (r10.hasNext() == false) goto L21;
        Object r11 = r10.next();
        if (Intrinsics.areEqual(((MultitaskDefaultIcons) r11).getUri(), r5) == false) goto L17;
        r9 = r11;
    L21:
        MultitaskDefaultIcons r12 = (MultitaskDefaultIcons) r9;
        if (r12 == null) goto L24;
        r4.setImageResource(r12.getResId());
    L38:
        if (r1 == true) goto L47;
        ImageLoaderKt.u(r4, r5, "multitask");
        return;
    L47:
        return;
    L24:
        if (r5 == null) goto L37;
        Uri r13 = UriProtector.parse(r5);
        if (r13 == null) goto L37;
        if (Intrinsics.areEqual(r13.getScheme(), "res") == false) goto L37;
        String r14 = r13.getLastPathSegment();
        if (r14 == null) goto L36;
        Integer r15 = StringsKt.toIntOrNull(r14);
        if (r15 == null) goto L36;
        r2 = r15.intValue();
    L36:
        r4.setImageResource(r2);
    L37:
        r1 = false;
        goto L38
    L40:
        if (r7 == null) goto L42;
        r4.setImageResource(r7.intValue());
        return;
    L42:
        r4.setImageDrawable(null);
    }
}

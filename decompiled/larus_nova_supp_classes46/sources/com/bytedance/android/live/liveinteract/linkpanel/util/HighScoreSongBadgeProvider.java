package com.bytedance.android.live.liveinteract.linkpanel.util;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.message.model.fc;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class HighScoreSongBadgeProvider implements a<c.AbstractC0043c, fc> {
    public static final Lazy a = null;
    public static WeakReference<fc> b;
    public static final c.AbstractC0043c.a c = null;
    public static final HighScoreSongBadgeProvider d = null;

    public HighScoreSongBadgeProvider() {
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.util.a
    public final String c() {
        return "";
    }

    static {
        d = new HighScoreSongBadgeProvider();
        a = LazyKt.lazy(HighScoreSongBadgeProvider$singRecordConfig$2.INSTANCE);
        c = c.AbstractC0043c.a.a;
    }

    public final boolean e() {
        WeakReference<fc> r0 = b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L5:
        fc r1 = r0.get();
        if (r1 != null) goto L9;
        return false;
    L9:
        if (((Boolean) a.getValue()).booleanValue() == false) goto L22;
        String r2 = r1.getHighScoreSongCount();
        if (r2 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == true) goto L22;
        if (Intrinsics.areEqual(r1.getHighScoreSongCount(), "0") == true) goto L22;
        return true;
    L13:
        if (StringsKt.isBlank(r2) == true) goto L16;
        r3 = false;
    L22:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.util.a
    public final c b() {
        return c;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.util.a
    public final View a(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return LayoutInflater.from(r3).inflate(2131565206, r4, false);
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.util.a
    public final void d(View r7, Function1<? super View, Unit> r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        WeakReference<fc> r9 = b;
        if (r9 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L5:
        fc r10 = r9.get();
        if (r10 != null) goto L8;
        return;
    L8:
        LinearLayout r0 = (LinearLayout) r7.findViewById(2131374349);
        TextView r1 = (TextView) r7.findViewById(2131390738);
        HSImageView r11 = r7.findViewById(2131376289);
        List r2 = r10.getBgColor();
        if (r2 == null) goto L16;
        List r3 = r2;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r5 = r3.iterator();
    L12:
        if (r5.hasNext() == false) goto L14;
        r4.add(Integer.valueOf(ColorProtector.parseColor((String) r5.next())));
        goto L12
    L14:
        int[] r6 = CollectionsKt.toIntArray(r4);
        if (r6 == null) goto L16;
    L18:
        if (r6.length <= 1) goto L20;
        GradientDrawable r12 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, r6);
        r12.setShape(0);
        r12.setCornerRadius(s1.e(27.0f));
        r0.setBackground(r12);
    L20:
        r1.setText(r10.getHighScoreSongCount());
        Uri r13 = UriProtector.parse(r10.getIcon());
        if (r11 == null) goto L27;
        if (r13 == null) goto L28;
        r11.setImageURI(r13);
        return;
    L28:
        return;
    L27:
        return;
    L16:
        r6 = new int[0];
        goto L18
    }
}

package com.ss.android.lark.movable.attatchment;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.movable.MovableView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final a a = null;
    public static final List<WeakReference<LKUIRoundedImageView2>> b = null;

    public a() {
    }

    static {
        a = new a();
        b = new ArrayList();
    }

    public static LKUIRoundedImageView2 a(d r14, String r15, int r16, int r17, String r18, p r19) {
        Intrinsics.checkNotNullParameter(r14, "container");
        Intrinsics.checkNotNullParameter(r15, "url");
        Intrinsics.checkNotNullParameter(r18, "imgType");
        int r0 = o.a;
        o.a r1 = o.a(r14.getContext(), r16, r17, "AttachmentImageHelper");
        Iterator r4 = ((ArrayList) b).iterator();
    L3:
        ViewGroup r6 = null;
        if (r4.hasNext() == false) goto L23;
        Object r5 = r4.next();
        LKUIRoundedImageView2 r7 = (LKUIRoundedImageView2) ((WeakReference) r5).get();
        if (r7 == null) goto L8;
        Object r8 = r7.getTag();
    L9:
        boolean r9 = false;
        if (Intrinsics.areEqual(r8, r15) == false) goto L21;
        a.getClass();
        ViewParent r10 = r7.getParent();
    L13:
        if (r10 == null) goto L18;
        if ((r10 instanceof MovableView) == true) goto L16;
        r10 = r10.getParent();
        goto L13
    L16:
        boolean r11 = true;
    L19:
        if (r11 == true) goto L21;
        r9 = true;
        goto L21
    L18:
        r11 = false;
    L21:
        if (r9 == false) goto L3;
    L24:
        WeakReference r12 = (WeakReference) r5;
        if (r12 == null) goto L27;
        LKUIRoundedImageView2 r13 = (LKUIRoundedImageView2) r12.get();
    L28:
        if (r13 == null) goto L34;
        ViewParent r20 = r13.getParent();
        if ((r20 instanceof ViewGroup) == false) goto L32;
        r6 = (ViewGroup) r20;
    L32:
        if (r6 == null) goto L34;
        r6.removeView(r13);
    L34:
        Context r21 = r14.getContext();
        MovableView r2 = r14.getMovableView();
        if (r13 != null) goto L46;
        Intrinsics.checkNotNull(r21);
        LKUIRoundedImageView2 r110 = new LKUIRoundedImageView2(r21, null, 0, 6, null);
        ((ArrayList) b).add(new WeakReference(r110));
        r110.setTag(r15);
        r110.setScaleType(ImageView.ScaleType.FIT_CENTER);
        a r22 = a;
        int r23 = r1.a;
        int r24 = r1.b;
        r22.getClass();
        c(r110, r2, r15, r18, r23, r24, r19);
        return r110;
    L46:
        return r13;
    L27:
        r13 = null;
        goto L28
    L8:
        r8 = null;
        goto L9
    L23:
        r5 = null;
        goto L24
    }

    public static /* synthetic */ LKUIRoundedImageView2 b(a r6, d r7, String r8, int r9, int r10, String r11) {
        r6.getClass();
        return a(r7, r8, r9, r10, r11, null);
    }

    public static void c(LKUIRoundedImageView2 r9, MovableView r10, String r11, String r12, int r13, int r14, p r15) {
        Integer r1 = null;
        String r2 = null;
        if (Intrinsics.areEqual(r12, "photo_with_size") == true) goto L76;
        if (r15 != null) goto L54;
        r15 = r10.getRootMovableView().getImageLoader$movable_release();
        if (r15 != null) goto L54;
        r15 = new h();
    L54:
        p r3 = r15;
        if (Intrinsics.areEqual(r12, "ud_icon_key") == true) goto L57;
    L74:
        r3.b(r11, r9, r13, r14, r12);
        return;
    L57:
        if (r3.a() == true) goto L74;
        int r16 = q.d;
        q r17 = q.a.a(r11);
        int r18 = com.ss.android.lark.movable.utils.h.a;
        if (r17 == null) goto L61;
        String r19 = r17.a;
    L63:
        if (Intrinsics.areEqual(r19, "icon_copy_outlined") == false) goto L65;
        Integer r110 = 2131254165;
    L66:
        if (r110 == null) goto L68;
        r9.setImageResource(r110.intValue());
    L68:
        int r111 = com.ss.android.lark.movable.utils.g.a;
        if (r17 == null) goto L71;
        r2 = r17.c;
    L71:
        Integer r112 = com.ss.android.lark.movable.utils.g.a(r2);
        if (r112 == null) goto L78;
        r9.setColorFilter(UIUtils.getColor(r9.getContext(), r112.intValue()), PorterDuff.Mode.SRC_IN);
        return;
    L78:
        return;
    L65:
        r110 = null;
        goto L66
    L61:
        r19 = null;
        goto L63
    L76:
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L6
        Object r114 = Result.constructor-impl(new JSONObject(r11));     // Catch: Throwable -> L6
    L9:
        if (Result.isFailure-impl(r114) == false) goto L11;
        r114 = null;
    L11:
        JSONObject r115 = (JSONObject) r114;
        if (r115 != null) goto L14;
        r r116 = null;
    L15:
        if (r116 == null) goto L17;
        String r117 = r116.a;
    L19:
        if (r117 != null) goto L21;
        String r4 = "";
    L22:
        if (r116 == null) goto L24;
        String r118 = r116.getType();
    L25:
        if (r118 != null) goto L27;
        String r5 = "";
    L28:
        boolean r119 = false;
        if (r116 == null) goto L39;
        Integer r6 = Integer.valueOf((int) r116.c);
        if (r6.intValue() <= 0) goto L33;
        boolean r7 = true;
    L34:
        if (r7 == true) goto L37;
        r6 = null;
    L37:
        if (r6 == null) goto L39;
        r13 = r6.intValue();
        goto L39
    L33:
        r7 = false;
    L39:
        int r8 = r13;
        if (r116 == null) goto L48;
        Integer r120 = Integer.valueOf((int) r116.d);
        if (r120.intValue() <= 0) goto L44;
        r119 = true;
    L44:
        if (r119 == false) goto L46;
        r1 = r120;
    L46:
        if (r1 == null) goto L48;
        r14 = r1.intValue();
    L48:
        c(r9, r10, r4, r5, r8, r14, r15);
        return;
    L27:
        r5 = r118;
        goto L28
    L24:
        r118 = null;
        goto L25
    L21:
        r4 = r117;
        goto L22
    L17:
        r117 = null;
        goto L19
    L14:
        r116 = new r(r115.optString(TabAppInfo.IMAGE_JSON_KEY), r115.optString("type"), (float) r115.optDouble("width"), (float) r115.optDouble("height"));
    L6:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r114 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }
}

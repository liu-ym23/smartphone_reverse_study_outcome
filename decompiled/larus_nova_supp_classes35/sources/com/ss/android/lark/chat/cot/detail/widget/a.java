package com.ss.android.lark.chat.cot.detail.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.widget.ImageView;
import androidx.core.widget.ImageViewCompat;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.chat.constant.ChatFromType;
import com.ss.android.lark.chat.cot.detail.CotDetailBlockType;
import com.ss.android.lark.contact.base.entity.api.ContactMobileApi$From;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.image.entity.PassThroughImage;
import java.util.HashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rkb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final a a = null;
    public static final HashMap<String, Integer> b = null;
    public static final int c = 0;
    public static final Map<String, Integer> d = null;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.cot.detail.widget.a$a, reason: collision with other inner class name */
    public static final class C0091a {
        public final int a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0091a) == true) goto L8;
            return false;
        L8:
            C0091a r6 = (C0091a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "StatusStyle(iconRes=" + this.a + ", colorRes=" + this.b + ')';
        }

        public C0091a(int r1) {
            this.a = r1;
            this.b = 2131102419;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CotDetailBlockType.values().length];
            r0[CotDetailBlockType.GROUP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[CotDetailBlockType.TOOLCALL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[CotDetailBlockType.THINKING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[CotDetailBlockType.ACTION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[CotDetailBlockType.STATUS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public static final class c implements g<Object, Object> {
        public final /* synthetic */ ImageView a;

        public final boolean onResourceReady(Object r1, Object r2, Target<Object> r3, DataSource r4, boolean r5) {
            return false;
        }

        public c(ImageView r1) {
            this.a = r1;
        }

        public final boolean onLoadFailed(Exception r1, Object r2, Target<Object> r3, boolean r4) {
            this.a.setImageDrawable(null);
            this.a.setVisibility(8);
            return true;
        }
    }

    public a() {
    }

    static {
        a = new a();
        b = new HashMap();
        c = 2131231929;
        d = MapsKt.mapOf(new Pair[]{TuplesKt.to(ChatFromType.SEARCH, 2131255617), TuplesKt.to("bash", 2131254132), TuplesKt.to("read", 2131255253), TuplesKt.to("write", 2131254285), TuplesKt.to("edit", 2131254285), TuplesKt.to(ContactMobileApi$From.DOC, 2131254246), TuplesKt.to(ChatFromType.CALENDAR, 2131253990), TuplesKt.to("task", 2131256017), TuplesKt.to("vc_meeting", 2131256135), TuplesKt.to("meeting", 2131256135)});
    }

    public static void a(ImageView r1) {
        ImageLoader.clear(r1);
        r1.setScaleType(ImageView.ScaleType.CENTER);
        ImageViewCompat.setImageTintList(r1, null);
        r1.clearColorFilter();
        r1.setImageResource(c);
    }

    public static void g(ImageView r1) {
        Intrinsics.checkNotNullParameter(r1, "markerView");
        ImageLoader.clear(r1);
        ImageViewCompat.setImageTintList(r1, null);
        r1.clearColorFilter();
        r1.setImageDrawable(null);
    }

    public static void c(ImageView r1, Object r2) {
        r1.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ImageViewCompat.setImageTintList(r1, null);
        r1.clearColorFilter();
        ImageLoader.with(r1.getContext()).load(r2).fitCenter().error(c).setErrorScaleType(ImageView.ScaleType.CENTER).into(r1);
    }

    public static void d(ImageView r1, Object r2) {
        r1.setVisibility(0);
        r1.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ImageViewCompat.setImageTintList(r1, null);
        r1.clearColorFilter();
        ImageLoader.with(r1.getContext()).load(r2).fitCenter().listener(new c(r1)).into(r1);
    }

    public static boolean e(ImageView r4, com.ss.android.lark.chat.cot.c r5) {
        Intrinsics.checkNotNullParameter(r4, "iconView");
        Context r0 = r4.getContext();
        if ((r5 instanceof com.ss.android.lark.chat.cot.c.a) == false) goto L9;
        Integer r6 = d.get(((com.ss.android.lark.chat.cot.c.a) r5).a);
        if (r6 == null) goto L7;
        b(r4, r6.intValue(), true);
    L20:
        return true;
    L7:
        return false;
    L9:
        if ((r5 instanceof com.ss.android.lark.chat.cot.c.f) == false) goto L15;
        Intrinsics.checkNotNull(r0);
        com.ss.android.lark.chat.cot.c.f r7 = (com.ss.android.lark.chat.cot.c.f) r5;
        int r1 = i(r0, r7.a);
        if (r1 != 0) goto L13;
        return false;
    L13:
        b(r4, r1, !StringsKt.endsWith(r7.a, "_colorful", true));
        goto L20
    L15:
        if ((r5 instanceof com.ss.android.lark.chat.cot.c.C0087c) == false) goto L18;
        d(r4, new PassThroughImage(((com.ss.android.lark.chat.cot.c.C0087c) r5).a, null));
        goto L20
    L18:
        if ((r5 instanceof com.ss.android.lark.chat.cot.c.d) == false) goto L22;
        d(r4, ((com.ss.android.lark.chat.cot.c.d) r5).a);
        goto L20
    L22:
        if (Intrinsics.areEqual(r5, com.ss.android.lark.chat.cot.c.b.a) == false) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(r5, com.ss.android.lark.chat.cot.c.e.a) == true) goto L31;
        if (r5 != null) goto L28;
        return false;
    L28:
        throw new NoWhenBranchMatchedException();
    L31:
        return false;
    }

    public static void f(ImageView r3, com.ss.android.lark.chat.cot.c r4) {
        Intrinsics.checkNotNullParameter(r3, "iconView");
        Context r0 = r3.getContext();
        if ((r4 instanceof com.ss.android.lark.chat.cot.c.a) == false) goto L9;
        Integer r5 = d.get(((com.ss.android.lark.chat.cot.c.a) r4).a);
        if (r5 == null) goto L7;
        b(r3, r5.intValue(), true);
        return;
    L7:
        a(r3);
        return;
    L9:
        if ((r4 instanceof com.ss.android.lark.chat.cot.c.f) == false) goto L15;
        Intrinsics.checkNotNull(r0);
        com.ss.android.lark.chat.cot.c.f r6 = (com.ss.android.lark.chat.cot.c.f) r4;
        int r1 = i(r0, r6.a);
        if (r1 == 0) goto L13;
        b(r3, r1, !StringsKt.endsWith(r6.a, "_colorful", true));
        return;
    L13:
        a(r3);
        return;
    L15:
        if ((r4 instanceof com.ss.android.lark.chat.cot.c.C0087c) == false) goto L18;
        c(r3, new PassThroughImage(((com.ss.android.lark.chat.cot.c.C0087c) r4).a, null));
        return;
    L18:
        if ((r4 instanceof com.ss.android.lark.chat.cot.c.d) == false) goto L21;
        c(r3, ((com.ss.android.lark.chat.cot.c.d) r4).a);
        return;
    L21:
        if (Intrinsics.areEqual(r4, com.ss.android.lark.chat.cot.c.b.a) == false) goto L23;
    L28:
        a(r3);
        return;
    L23:
        if (Intrinsics.areEqual(r4, com.ss.android.lark.chat.cot.c.e.a) == true) goto L28;
        if (r4 == null) goto L28;
        throw new NoWhenBranchMatchedException();
    }

    public static boolean h(Context r1, com.ss.android.lark.chat.cot.c r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if ((r2 instanceof com.ss.android.lark.chat.cot.c.a) == false) goto L6;
        return d.containsKey(((com.ss.android.lark.chat.cot.c.a) r2).a);
    L6:
        if ((r2 instanceof com.ss.android.lark.chat.cot.c.f) == false) goto L11;
        if (i(r1, ((com.ss.android.lark.chat.cot.c.f) r2).a) != 0) goto L24;
    L23:
        return false;
    L24:
        return true;
    L11:
        if ((r2 instanceof com.ss.android.lark.chat.cot.c.C0087c) == true) goto L24;
        if ((r2 instanceof com.ss.android.lark.chat.cot.c.d) == true) goto L24;
        if (Intrinsics.areEqual(r2, com.ss.android.lark.chat.cot.c.b.a) == true) goto L23;
        if (Intrinsics.areEqual(r2, com.ss.android.lark.chat.cot.c.e.a) == true) goto L23;
        if (r2 == null) goto L23;
        throw new NoWhenBranchMatchedException();
    }

    public static int i(Context r10, String r11) {
        String r0 = r10.getPackageName() + ':' + r11;
        HashMap<String, Integer> r1 = b;
        Integer r2 = r1.get(r0);
        if (r2 != null) goto L5;
        int r12 = r10.getResources().getIdentifier("ud_icon_" + StringsKt.replace$default(r11, "-", "_", false, 4, null), "drawable", r10.getPackageName());
        r1.put(r0, Integer.valueOf(r12));
        return r12;
    L5:
        return r2.intValue();
    }

    public static void b(ImageView r1, int r2, boolean r3) {
        ImageLoader.clear(r1);
        r1.setScaleType(ImageView.ScaleType.FIT_CENTER);
        if (r3 == false) goto L5;
        ImageViewCompat.setImageTintList(r1, ColorStateList.valueOf(UDColorUtils.getColor(r1.getContext(), 2131102419)));
    L6:
        r1.setImageResource(r2);
        return;
    L5:
        ImageViewCompat.setImageTintList(r1, null);
        r1.clearColorFilter();
        goto L6
    }
}

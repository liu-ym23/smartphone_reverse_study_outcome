package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils;

import android.content.Context;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.larksuite.framework.utils.UIUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import pl.droidsonroids.gif.d;
import pl.droidsonroids.gif.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class SpannableStringUtils {
    public static final Lazy a = null;
    public static final Lazy b = null;

    public static final class a implements Drawable.Callback {
        public final WeakReference<TextView> a;

        public a(TextView r2) {
            Intrinsics.checkNotNullParameter(r2, "textView");
            this.a = new WeakReference(r2);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable r2) {
            Intrinsics.checkNotNullParameter(r2, "who");
            TextView r3 = this.a.get();
            if (r3 == null) goto L6;
            r3.invalidate();
            return;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable r2, Runnable r3) {
            Intrinsics.checkNotNullParameter(r2, "who");
            Intrinsics.checkNotNullParameter(r3, "what");
            TextView r4 = this.a.get();
            if (r4 == null) goto L6;
            r4.removeCallbacks(r3);
            return;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable r2, Runnable r3, long r4) {
            Intrinsics.checkNotNullParameter(r2, "who");
            Intrinsics.checkNotNullParameter(r3, "what");
            TextView r5 = this.a.get();
            if (r5 == null) goto L6;
            r5.postDelayed(r3, r4);
            return;
        }
    }

    public SpannableStringUtils() {
    }

    static {
        a = LazyKt.lazy(SpannableStringUtils$sDotLoadingDrawable$2.INSTANCE);
        b = LazyKt.lazy(SpannableStringUtils$sDotLoadingCallback$2.INSTANCE);
    }

    public static void c(Editable r2) {
        d(r2, com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.a.class, SpannableStringUtils$removeDotDrawable$1.INSTANCE);
        d(r2, SuffixAsrSpan.class, SpannableStringUtils$removeDotDrawable$2.INSTANCE);
    }

    public static SpannableStringBuilder b(Context r3, CharSequence r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        SpannableStringBuilder r0 = new SpannableStringBuilder(r4);
        int r6 = r0.length();
        int r7 = Math.max(Math.min(r5, r6), 0);
        r0.setSpan(new SuffixAsrSpan(UIUtils.getColor(r3, 2131106620)), r7, r6, 33);
        return r0;
    }

    public static void d(Editable r5, Class r6, Function1 r7) {
        if (r5 != null) goto L4;
        return;
    L4:
        int r0 = 0;
    L6:
        if (r0 >= r5.length()) goto L14;
        int r1 = r5.nextSpanTransition(r0, r5.length(), r6);
        Iterator r2 = ArrayIteratorKt.iterator(r5.getSpans(r0, r1, r6));
    L9:
        if (r2.hasNext() == false) goto L13;
        Object r3 = r2.next();
        if (((Boolean) r7.invoke(r3)).booleanValue() == false) goto L9;
        r5.removeSpan(r3);
    L15:
        if (r0 < 0) goto L22;
        r5.delete(r0, r0 + 1);
        return;
    L22:
        return;
    L13:
        r0 = r1;
        goto L6
    L14:
        r0 = -1;
        goto L15
    }

    public static void e(SpannableStringBuilder r9, String r10, SuffixAsrSpan r11) {
        Intrinsics.checkNotNullParameter(r9, "resultSpanBuilder");
        Intrinsics.checkNotNullParameter(r11, "colorSpan");
        int r0 = r9.length();
        if (r0 <= 0) goto L16;
        boolean r2 = false;
        int r1 = RangesKt.coerceAtLeast(r0 - 3, 0);
        if (r10 != null) goto L7;
    L8:
        r2 = true;
    L9:
        if (r2 == true) goto L13;
        int r3 = StringsKt.lastIndexOf$default(r9.toString(), r10, 0, false, 6, null);
        if (r3 == (-1)) goto L13;
        r1 = Math.max(r1, r3 + r10.length());
    L13:
        if (r1 >= r0) goto L17;
        r9.setSpan(r11, r1, r0, 33);
        return;
    L17:
        return;
    L7:
        if (r10.length() != 0) goto L9;
    }

    public static SpannableStringBuilder a(Context r4, SpannableStringBuilder r5, a r6, PorterDuffColorFilter r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "spannable");
        d r0 = (d) a.getValue();
        if (r0 != null) goto L5;
        return r5;
    L5:
        if (r7 == null) goto L7;
        r0.setColorFilter(r7);
    L7:
        r5.append(" ");
        int r1 = r5.length();
        r5.append(" ");
        int r8 = r5.length();
        Lazy r2 = b;
        ((m) r2.getValue()).a(r6);
        r0.setCallback((m) r2.getValue());
        r0.setBounds(0, UIUtils.dp2px(r4, 8.0f), UIUtils.dp2px(r4, 19.0f), UIUtils.dp2px(r4, 11.0f));
        r5.setSpan(new com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.a(r0), r1, r8, 33);
        return r5;
    }
}

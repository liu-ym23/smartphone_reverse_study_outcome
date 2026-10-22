package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class PSHighlightRenderHelper {
    public static final int a = 0;
    public static final int b = 0;
    public static final int c = 0;
    public static final int d = 0;
    public static final Lazy e = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/PSHighlightRenderHelper$AnimType;", BuildConfig.FLAVOR, "None", "VerticalFadeSlide", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum AnimType extends Enum<AnimType> {
        public static final AnimType None = null;
        public static final AnimType VerticalFadeSlide = null;
        public static final /* synthetic */ AnimType[] a = null;

        static {
            AnimType r1 = new AnimType("None", 0);
            None = r1;
            AnimType r2 = new AnimType("VerticalFadeSlide", 1);
            VerticalFadeSlide = r2;
            a = new AnimType[]{r1, r2};
        }

        public static AnimType valueOf(String r1) {
            return (AnimType) r27.a.a(AnimType.class, r1);
        }

        public static AnimType[] values() {
            return (AnimType[]) a.clone();
        }

        public AnimType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
        void a(View r1);

        boolean b(View r1, ek6.c r2);
    }

    public PSHighlightRenderHelper() {
    }

    static {
        a = UtilityKotlinExtentionsKt.i(100);
        b = UtilityKotlinExtentionsKt.i(8);
        c = UtilityKotlinExtentionsKt.i(3);
        d = UtilityKotlinExtentionsKt.i(4);
        e = LazyKt.lazy(PSHighlightRenderHelper$defaultSpanRendConfig$2.INSTANCE);
    }

    public static final float a(View r3) {
        int r0 = r3.getMeasuredHeight();
        if (r0 > 0) goto L6;
        r3.measure(View.MeasureSpec.makeMeasureSpec(s1.y(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(a, Integer.MIN_VALUE));
        r0 = r3.getMeasuredHeight();
    L6:
        return r0;
    }

    @JvmStatic
    public static final void b(DataCenter r4, TextView r5) {
        com.bytedance.android.livesdk.interactivity.api.h r6 = com.bytedance.android.livesdk.interactivity.api.i.a(MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r4, 0, 2), r4);
        if (r6 == null) goto L17;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> r7 = r6.getPublicScreenContext();
        if (r7 == null) goto L18;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r8 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.l) r7.getValue();
        if (r8 == null) goto L19;
        e52.a r9 = r8.getTextConfig();
        if (r9 == null) goto L20;
        g52.e r10 = r9.getTextConfig();
        if (r10 == null) goto L21;
        if (r5 == null) goto L14;
        int r0 = g52.e.j;
        r10.a(r5, true);
    L14:
        if (r5 == null) goto L22;
        int r11 = b;
        int r1 = c;
        r5.setPadding(r11, r1, d, r1);
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    @JvmStatic
    public static final q4.b c(final View r1, boolean r2, AnimType r3, final Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "animType");
        Intrinsics.checkNotNullParameter(r4, "onEnd");
        if (r1 == null) goto L5;
        int r5 = p.a[r3.ordinal()];
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L13;
        return u4.c(new PSHighlightRenderHelper$getAnim$3(r1, r2, r4));
    L13:
        throw new NoWhenBranchMatchedException();
    L15:
        return u4.c(new PSHighlightRenderHelper$getAnim$2(r1, r4));
    L5:
        return u4.c(new PSHighlightRenderHelper$getAnim$1(r4));
    }
}

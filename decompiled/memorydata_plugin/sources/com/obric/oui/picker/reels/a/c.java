package com.obric.oui.picker.reels.a;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J4\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J0\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0004J\n\u0010\u0019\u001a\u00020\u0004*\u00020\u001a¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/Utils;", "", "()V", "dayCount", "", "month", "isLeapYear", "", "defaultDateFormatter", "", "date", "Ljava/time/LocalDate;", "generateDateRange", "", CommonConsts.APM_INNER_EVENT_COST_START, TypedValues.TransitionType.S_TO, "formatter", "Ljava/util/function/Function;", "generateMonthRange", "context", "Landroid/content/Context;", "generateRange", "suffix", "paddedLen", "year", "toShortRepr", "Ljava/time/DayOfWeek;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f14291a = null;

    static {
        f14291a = new c();
    }

    private c() {
    }

    public static /* synthetic */ List a(c r0, int r1, int r2, String r3, int r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = "";
    L6:
        if ((r5 & 8) == 0) goto L9;
        r4 = 2;
    L9:
        return r0.a(r1, r2, r3, r4);
    }

    public final List<String> a(int r4, int r5, String r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "suffix");
        List<String> r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r4 > r5) goto L8;
    L4:
        int r0 = r4 + 1;
        r3.add(Intrinsics.stringPlus(StringsKt.padStart(String.valueOf(r4), r7, '0'), r6));
        if (r4 == r5) goto L8;
        r4 = r0;
    L8:
        return r3;
    }

    public final List<String> a(Context r5, int r6, int r7) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        List<String> r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r6 > r7) goto L23;
    L4:
        int r0 = r6 + 1;
        switch(r6) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L7;
            default: goto L6;
        };
    L6:
        int r2 = R.string.oui_reel_picker_month_def;
        String r3 = "oui_reel_picker_month_def";
    L19:
        String r1 = r4.getString(ZeusTransformUtils.mapRes(r2, TypedValues.Custom.S_STRING, r3));
        Intrinsics.checkNotNullExpressionValue(r1, "context.getString(monthRes)");
        r8.add(r1);
        if (r6 == r7) goto L23;
        r6 = r0;
        goto L4
    L7:
        r2 = R.string.oui_reel_picker_month_dec;
        r3 = "oui_reel_picker_month_dec";
        goto L19
    L8:
        r2 = R.string.oui_reel_picker_month_nov;
        r3 = "oui_reel_picker_month_nov";
        goto L19
    L9:
        r2 = R.string.oui_reel_picker_month_oct;
        r3 = "oui_reel_picker_month_oct";
        goto L19
    L10:
        r2 = R.string.oui_reel_picker_month_sep;
        r3 = "oui_reel_picker_month_sep";
        goto L19
    L11:
        r2 = R.string.oui_reel_picker_month_aug;
        r3 = "oui_reel_picker_month_aug";
        goto L19
    L12:
        r2 = R.string.oui_reel_picker_month_jul;
        r3 = "oui_reel_picker_month_jul";
        goto L19
    L13:
        r2 = R.string.oui_reel_picker_month_jun;
        r3 = "oui_reel_picker_month_jun";
        goto L19
    L14:
        r2 = R.string.oui_reel_picker_month_may;
        r3 = "oui_reel_picker_month_may";
        goto L19
    L15:
        r2 = R.string.oui_reel_picker_month_apr;
        r3 = "oui_reel_picker_month_apr";
        goto L19
    L16:
        r2 = R.string.oui_reel_picker_month_mar;
        r3 = "oui_reel_picker_month_mar";
        goto L19
    L17:
        r2 = R.string.oui_reel_picker_month_feb;
        r3 = "oui_reel_picker_month_feb";
        goto L19
    L18:
        r2 = R.string.oui_reel_picker_month_jan;
        r3 = "oui_reel_picker_month_jan";
    L23:
        return r8;
    }
}

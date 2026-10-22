package com.ss.android.lark.custom.repeat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.bytedance.lark.pb.basic.v1.LanguageType;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public i() {
    }

    public static void a(Context r4, String r5, GregorianCalendar r6, CustomRepeatParams$DayOfWeek r7, LanguageType r8, Fragment r9) {
        ArrayList<String> r0 = new ArrayList();
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "lastRRule");
        Intrinsics.checkNotNullParameter(r7, "firstDayOfWeek");
        Intrinsics.checkNotNullParameter(r8, "languageType");
        Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "selfDefineRepeatItemText");
        Intrinsics.checkNotNullParameter(r0, "hiddenRRuleList");
        Log.i("CustomRepeatEntrance", "start choose repeat page!");
        Intent r1 = new Intent();
        r1.setClass(r4, ChooseRepeatActivity.class);
        r1.putExtra("custom_repeat_last_rrule", r5);
        r1.putExtra("custom_repeat_is_single_in_week", false);
        r1.putExtra("custom_repeat_is_single_in_month", false);
        r1.putStringArrayListExtra("custom_hide_repeat", r0);
        r1.putExtra("custom_repeat_is_fixed_default_date", false);
        r1.putExtra("custom_repeat_default_date", r6);
        r1.putExtra("custom_repeat_first_day_of_week", r7);
        r1.putExtra("custom_repeat_language_type", r8);
        r1.putExtra("custom_repeat_banned_unselected_localize_id", null);
        r1.putExtra("custom_repeat_banned_select_localize_id", null);
        r1.putExtra("custom_repeat_rrule_list", null);
        r1.putExtra("custom_repeat_self_define_item_text", BuildConfig.FLAVOR);
        if (r9 == null) goto L6;
        r9.startActivityForResult(r1, 256);
        return;
    L6:
        if ((r4 instanceof Activity) == false) goto L8;
        ((Activity) r4).startActivityForResult(r1, 256);
        return;
    L8:
        r4.startActivity(r1);
    }
}

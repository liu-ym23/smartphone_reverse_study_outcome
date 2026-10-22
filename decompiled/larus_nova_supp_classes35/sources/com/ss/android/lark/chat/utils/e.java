package com.ss.android.lark.chat.utils;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.File;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final boolean b(List<File> r2, List<File> r3) {
        List<File> r4 = r2;
        if (r4 != null) goto L5;
    L8:
        boolean r5 = true;
    L10:
        if ((!r5) == true) goto L20;
        List<File> r6 = r3;
        if (r6 != null) goto L14;
    L17:
        boolean r7 = true;
    L19:
        if ((!r7) == true) goto L20;
        return false;
    L14:
        if (r6.isEmpty() == true) goto L17;
        r7 = false;
    L20:
        return true;
    L5:
        if (r4.isEmpty() == true) goto L8;
        r5 = false;
        goto L10
    }

    @JvmStatic
    public static final CharSequence a(CharSequence r0, List<File> r1, List<File> r2) {
        if (b(r1, r2) == true) goto L8;
        if (r0 != null) goto L12;
        return BuildConfig.FLAVOR;
    L12:
        return r0;
    L8:
        if (TextUtils.isEmpty(r0) == false) goto L11;
        return UIHelper.getString(2131890956);
    L11:
        return new SpannableStringBuilder(r0).append(UIHelper.getString(2131890956));
    }
}

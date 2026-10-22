package com.larksuite.component.blockit.props;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c {
    public static CharSequence a(List<f> r8, Map<String, Object> r9) {
        SpannableStringBuilder r0 = new SpannableStringBuilder();
        if (CollectionUtils.isEmpty(r8) == true) goto L12;
        int r2 = 0;
    L6:
        if (r2 >= r8.size()) goto L12;
        String r3 = "#" + ((f) ListProtector.get(r8, r2)).a;
        String r4 = ((f) ListProtector.get(r8, r2)).b;
        String r5 = ((f) ListProtector.get(r8, r2)).c;
        SpannableString r6 = new SpannableString(r3);
        r6.setSpan(new b(r4, r5, r9), 0, r3.length(), 33);
        r0.append(r6);
        if (r2 >= (r8.size() - 1)) goto L10;
        String r7 = "    ";
    L11:
        r0.append(r7);
        r2 = r2 + 1;
        goto L6
    L10:
        r7 = " ";
    L12:
        return r0;
    }
}

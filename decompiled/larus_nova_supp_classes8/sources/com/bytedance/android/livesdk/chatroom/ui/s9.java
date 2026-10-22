package com.bytedance.android.livesdk.chatroom.ui;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s9 extends com.bytedance.android.live.core.utils.q0 {
    public final /* synthetic */ UserFeatureLabelListAdapter.LabelViewHolder a;

    public s9(UserFeatureLabelListAdapter.LabelViewHolder r1) {
        this.a = r1;
    }

    public final void h(py.k r4, int r5, int r6) {
        if (r6 <= 0) goto L22;
        if (r5 <= 0) goto L23;
        ViewGroup.LayoutParams r0 = this.a.b.getLayoutParams();
        UserFeatureLabelListAdapter.LabelViewHolder r1 = this.a;
        int r2 = r1.a;
        r0.height = r2;
        r0.width = (r5 * r2) / r6;
        r1.b.setLayoutParams(r0);
        ImageView r7 = this.a.b;
    L15:
        e = move-exception;
        ALogger.e("UserFeatureLabelListAdapter", "getDesc:" + e);
    L17:
        String r8 = "";
    L18:
        com.bytedance.android.livesdk.r3.c(r7, r8, false);
        return;
    L6:
        if (TextUtils.isEmpty(r4.getUri()) == true) goto L8;
    L9:
        Matcher r9 = PatternProtector.compile(".+_v\\d_(\\d+).png").matcher(r4.getUri());     // Catch: Exception -> L15
        if (r9.find() == false) goto L17;
        if (r9.groupCount() <= 0) goto L17;
        r8 = "用户等级" + r9.group(1);     // Catch: Exception -> L15
        goto L18
    L8:
        if (r4.getUri().contains("user_grade_level") == false) goto L17;
    L23:
        return;
    }
}

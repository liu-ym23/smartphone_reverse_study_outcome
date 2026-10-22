package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/SmallWindowQuestionCircleDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SmallWindowQuestionCircleDialog extends CommonStandardBottomDialog {
    public boolean B;

    public final int getLayoutId() {
        return 2131565776;
    }

    public SmallWindowQuestionCircleDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, false);
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        LinearLayout r4 = (LinearLayout) findViewById(2131379207);
        String r0 = com.bytedance.android.livesdk.floatview.inner.h.a;
        if (com.bytedance.android.livesdk.config.g4.a.getValue().booleanValue() == false) goto L6;
        if (r4 == null) goto L9;
        r4.setVisibility(0);
    L9:
        if (this.B == true) goto L32;
        return;
    L32:
        View r5 = findViewById(2131364122);     // Catch: Exception -> L31
        if (r5 == null) goto L14;
        r5.setBackgroundResource(2131249496);     // Catch: Exception -> L31
    L14:
        View r6 = findViewById(2131369197);     // Catch: Exception -> L31
        if (r6 == null) goto L17;
        r6.setBackgroundColor(Color.parseColor("#33161823"));     // Catch: Exception -> L31
    L17:
        TextView r7 = (TextView) findViewById(2131380302);     // Catch: Exception -> L31
        if (r7 == null) goto L21;
        r7.setTextColor(Color.parseColor("#99161823"));     // Catch: Exception -> L31
    L21:
        TextView r8 = (TextView) findViewById(2131374378);     // Catch: Exception -> L31
        if (r8 == null) goto L24;
        r8.setTextColor(Color.parseColor("#99161823"));     // Catch: Exception -> L31
    L24:
        TextView r9 = (TextView) findViewById(2131379206);     // Catch: Exception -> L31
        if (r9 == null) goto L27;
        r9.setTextColor(Color.parseColor("#99161823"));     // Catch: Exception -> L31
    L27:
        TextView r10 = (TextView) findViewById(2131384106);     // Catch: Exception -> L31
        if (r10 == null) goto L35;
        r10.setTextColor(Color.parseColor("#99161823"));     // Catch: Exception -> L31
        return;
    L35:
        return;
    L36:
        return;
    L6:
        if (r4 == null) goto L9;
        r4.setVisibility(8);
        goto L9
    }
}

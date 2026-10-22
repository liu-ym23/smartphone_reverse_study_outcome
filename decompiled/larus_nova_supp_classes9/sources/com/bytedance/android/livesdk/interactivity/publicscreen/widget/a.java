package com.bytedance.android.livesdk.interactivity.publicscreen.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.Spannable;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.common.utility.UIUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements IHostFrescoHelper.GetBitmapCallBack {
    public final /* synthetic */ Spannable a;
    public final /* synthetic */ TextView b;

    public final void fail(IHostFrescoHelper.BitmapDataSource r1) {
    }

    public final void onNewResultImpl(Bitmap r5) {
        Intrinsics.checkNotNullParameter(r5, "bitmap");
        Bitmap r6 = r5.copy(Bitmap.Config.ARGB_8888, true);
        Spannable r0 = this.a;
        if (r6 != null) goto L5;
    L11:
        this.b.setText(this.a);
        return;
    L5:
        if (r6.isRecycled() == false) goto L8;
        if (r0 == null) goto L11;
    L8:
        if (r0.length() == 0) goto L11;
        Context r1 = s1.getContext();
        int r2 = (int) UIUtils.dip2Px(s1.getContext(), 16.0f);
        BitmapDrawable r3 = new BitmapDrawable(r1.getResources(), r6);
        r3.setBounds(0, 0, r2, r2);
        r0.setSpan(new com.bytedance.android.livesdk.widget.a(r3), r0.length() - 1, r0.length(), 33);
        goto L11
    }

    public a(Spannable r1, NoMoreSpaceTextView r2) {
        this.a = r1;
        this.b = r2;
    }
}

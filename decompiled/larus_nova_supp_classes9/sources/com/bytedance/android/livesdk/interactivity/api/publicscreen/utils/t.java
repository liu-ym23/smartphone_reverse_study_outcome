package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import android.text.Spannable;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t {
    public static final a a = null;
    public static final int b = 0;

    public static final class a extends Spannable.Factory {
        public a() {
        }

        @Override // android.text.Spannable.Factory
        public final Spannable newSpannable(CharSequence r2) {
            if ((r2 instanceof Spannable) == true) goto L5;
            CharSequence r0 = null;
        L6:
            Spannable r1 = (Spannable) r0;
            if (r1 == null) goto L9;
            return r1;
        L9:
            return super.newSpannable(r2);
        L5:
            r0 = r2;
            goto L6
        }
    }

    static {
        a = new a();
        b = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW / ((Number) PublicScreenABHelper.E.getValue()).intValue();
    }

    public static void a(TextView r1) {
        Intrinsics.checkNotNullParameter(r1, "view");
        r1.setSpannableFactory(a);
        if ((r1 instanceof NoMoreSpaceTextView) == false) goto L6;
        ((NoMoreSpaceTextView) r1).setAlwaysInvalidateIntervalInMS(b);
        return;
    }

    public static void b(TextView r1, CharSequence r2) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r2, "chatSequence");
        if ((!Intrinsics.areEqual(r1.getText(), r2)) == false) goto L6;
        r1.setText(r2, TextView.BufferType.SPANNABLE);
        return;
    }
}

package com.bytedance.android.live.broadcastgame.opengame.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.bytedance.android.livesdk.t8;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/view/CollectSuccessDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CollectSuccessDialog extends CommonBottomDialog {
    public final boolean a;

    public final int getLayoutId() {
        return 2131565679;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        if (this.a == false) goto L21;
        Window r7 = getWindow();
        if (r7 == null) goto L9;
        WindowManager.LayoutParams r8 = r7.getAttributes();
        if (r8 == null) goto L9;
        r8.width = s1.f(390.0f);
    L9:
        View r9 = findViewById(2131384828);
        if (r9 == null) goto L17;
        a1.k(r9, s1.q(getContext()).heightPixels);
        Drawable r11 = r9.getBackground();
        if ((r11 instanceof GradientDrawable) == true) goto L14;
        r11 = null;
    L14:
        GradientDrawable r12 = (GradientDrawable) r11;
        float r1 = s1.e(12.0f);
        if (r12 == null) goto L17;
        r12.setCornerRadii(new float[]{r1, r1, 0.0f, 0.0f, 0.0f, 0.0f, r1, r1});
    L17:
        Window r13 = getWindow();
        if (r13 == null) goto L20;
        r13.setGravity(5);
    L20:
        t8.d(getWindow());
    L21:
        ((TextView) findViewById(2131392071)).setOnClickListener(new a(this));
        String r14 = i2.a;
        i2.e((HSImageView) findViewById(2131384493), "/broadcastgame/ttlive_open_game_tip_visit_collect_path.png");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onWindowFocusChanged(boolean r2) {
        if (this.a == false) goto L6;
        if (r2 == false) goto L6;
        t8.d(getWindow());
    L6:
        super/*android.app.Dialog*/.onWindowFocusChanged(r2);
    }

    public CollectSuccessDialog(Context r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, false);
        this.a = r3;
    }
}

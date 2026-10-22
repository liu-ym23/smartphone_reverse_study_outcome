package nu0;

import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements DialogInterface.OnShowListener {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r3) {
        if ((r3 instanceof c9) == true) goto L5;
        r3 = null;
    L5:
        c9 r4 = (c9) r3;
        if (r4 == null) goto L11;
        View r5 = r4.e;
        if (r5 == null) goto L12;
        GradientDrawable r0 = new GradientDrawable();
        r0.setColor(-1);
        r0.setCornerRadius(s1.f(16.0f));
        Unit r1 = Unit.INSTANCE;
        r5.setBackground(r0);
        return;
    L12:
        return;
    }
}

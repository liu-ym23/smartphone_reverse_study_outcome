package m82;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.t9;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.presenter.MyItemDecoration;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class a {
    public a() {
    }

    public static MyItemDecoration a(h82.b r5) {
        float r3 = 2;
        int r0 = (int) ((((s1.t() - (s1.e(99.0f) * 3)) - (s1.e(16.0f) * r3)) / r3) - s1.e(5.0f));
        if (r0 > 0) goto L5;
    L6:
        r0 = s1.f(16.0f);
    L7:
        t9 r6 = r5.h.d;
        if (r6 != null) goto L10;
    L11:
        if (r6 != null) goto L13;
    L15:
        int r7 = s1.f(60.0f);
    L17:
        return new MyItemDecoration(r0, r7, s1.f(16.0f));
    L13:
        if (r6.h != true) goto L15;
    L14:
        r7 = s1.f(16.0f);
        goto L17
    L10:
        if (r6.g == true) goto L14;
    L5:
        if (r0 < s1.f(16.0f)) goto L7;
        goto L6
    }
}

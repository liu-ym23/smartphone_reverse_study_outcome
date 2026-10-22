package com.larus.bmhome.view;

import android.os.Message;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.s5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class r implements OnApplyWindowInsetsListener {
    public final /* synthetic */ ChatConstraintLayout a;

    public /* synthetic */ r(ChatConstraintLayout r1) {
        this.a = r1;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View r5, WindowInsetsCompat r6) {
        ChatConstraintLayout r0 = this.a;
        int r1 = ChatConstraintLayout.H;
        Intrinsics.checkNotNullParameter(r5, "<unused var>");
        Intrinsics.checkNotNullParameter(r6, "insets");
        if (s5.a == true) goto L19;
        Function0 r7 = r0.z;
        if (r7 == null) goto L9;
        boolean r2 = true;
        if (((Boolean) r7.invoke()).booleanValue() != true) goto L9;
    L10:
        if (r2 == true) goto L19;
        if (r6.isVisible(WindowInsetsCompat.Type.ime()) == true) goto L16;
        r0.A = Integer.valueOf(r6.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom);
    L16:
        if (r0.G.hasMessages(2) == false) goto L18;
        r0.G.removeMessages(2);
    L18:
        r0.t = null;
        Message r8 = Message.obtain(r0.G, 2, r6.getInsets(WindowInsetsCompat.Type.ime()));
        FLogger.a.i("ChatConstraintLayout", "onApplyWindowInsets, schedule IME insets fallback");
        r0.G.sendMessageDelayed(r8, 50);
    L9:
        r2 = false;
    L19:
        return r6;
    }
}

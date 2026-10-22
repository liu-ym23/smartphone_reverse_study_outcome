package com.larus.bmhome.chat.list.cell.prompt;

import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.layout.item.PromptSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class r0 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ PromptCell a;

    public /* synthetic */ r0(PromptCell r1) {
        this.a = r1;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        PromptCell r0 = this.a;
        Keva r1 = PromptCell.Y;
        RecyclerView r2 = ((BaseMessageListCell) r0).b;
        if (r2 == null) goto L27;
        WindowInsetsCompat r3 = ViewCompat.getRootWindowInsets(r2);
        if (r3 == null) goto L22;
        boolean r4 = r3.isVisible(WindowInsetsCompat.Type.ime());
        Boolean r5 = r0.B;
        r0.B = Boolean.valueOf(r4);
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L23;
        if (r4 == false) goto L11;
        return;
    L11:
        if (r0.y == true) goto L13;
        return;
    L13:
        if (r0.D().f == true) goto L26;
        PromptSpan r6 = r0.e;
        if (r6 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("span");
        r6 = null;
    L18:
        if (r6.getVisibility() != 0) goto L28;
        r0.O();
        return;
    L28:
        return;
    L26:
        return;
    L23:
        return;
    L22:
        return;
    }
}

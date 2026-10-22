package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.layout.widget.MessageLoading;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s0 extends i {
    public final MessageLoading p;
    public int q;

    @Override // com.larus.bmhome.chat.layout.item.i
    public int getBoxType() {
        return this.q;
    }

    public final MessageLoading getLoadingView() {
        return this.p;
    }

    public s0(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8);
        MessageLoading r0 = new MessageLoading(r8);
        int r9 = getResources().getDimensionPixelSize(2131167561);
        int r1 = getResources().getDimensionPixelSize(2131167561);
        int r2 = getResources().getDimensionPixelSize(2131167562);
        int r3 = getResources().getDimensionPixelSize(2131167562);
        FLogger.a.i("updatePaddingRelative", "view:" + r0.getClass().getSimpleName() + ",source:,start:" + r9 + ",top:" + r2 + ",end:" + r1 + ",bottom:" + r3);
        r0.setPaddingRelative(r9, r2, r1, r3);
        addView(r0, new LinearLayout.LayoutParams(-2, -2));
        this.p = r0;
        this.q = super.getBoxType();
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public void setBoxType(int r5) {
        super.setBoxType(r5);
        this.q = r5;
        if (r5 == 0) goto L9;
        if (r5 != 1) goto L15;
        this.p.setColor(ContextCompat.getColor(getContext(), 2131103298));
        return;
    L15:
        return;
    L9:
        if (getImmerseBgColor() == null) goto L11;
        this.p.setColor(ContextCompat.getColor(getContext(), 2131103298));
        return;
    L11:
        this.p.setColor(ContextCompat.getColor(getContext(), v19.c.b(2130972079, getContext(), 2131103136)));
    }
}

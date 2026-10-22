package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s3 extends i {
    public final AppCompatTextView p;
    public int q;

    @Override // com.larus.bmhome.chat.layout.item.i
    public int getBoxType() {
        return this.q;
    }

    public final AppCompatTextView getTextView() {
        return this.p;
    }

    public s3(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8);
        AppCompatTextView r0 = new AppCompatTextView(r8);
        r0.setTextSize(0, i5.t());
        r0.setLineSpacing(0.0f, 1.1f);
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
        if (r5 != 0) goto L5;
        this.p.setTextColor(ContextCompat.getColor(getContext(), v19.c.b(2130972079, getContext(), 2131103136)));
        return;
    L5:
        if (r5 != 1) goto L11;
        this.p.setTextColor(ContextCompat.getColor(getContext(), 2131103298));
        return;
    }
}

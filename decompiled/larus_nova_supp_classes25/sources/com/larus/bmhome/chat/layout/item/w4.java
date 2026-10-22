package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import com.larus.bmhome.chat.standarduikit.widget.view.WidgetView;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class w4 extends xc8.h {
    public WidgetView p;
    public int q;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public int getBoxType() {
        return super.getBoxType();
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public int getMaxWidth() {
        return this.q;
    }

    public w4(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        Lazy r6 = com.larus.bmhome.utils.z1.a;
        if (com.larus.bmhome.utils.z1.b(0, null) == false) goto L8;
        com.larus.platform.service.e2 r1 = com.larus.platform.service.e2.a;
        if (r1.isPad() == false) goto L7;
        int r7 = (int) ((((double) r1.g()) * 0.75d) - ((double) (i5.h() * 2)));
    L9:
        this.q = r7;
        return;
    L7:
        r7 = com.larus.bmhome.utils.z1.h(0, null, false, false, 28);
        goto L9
    L8:
        r7 = super.getMaxWidth();
        goto L9
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public void setBoxType(int r1) {
        super.setBoxType(r1);
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public void setMaxWidth(int r1) {
        this.q = r1;
    }

    public final void setupWidget(WidgetView r3) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        if (indexOfChild(r3) == (-1)) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.p = r3;
        addView(r3);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public final void l(boolean r4, boolean r5) {
        super.l(r4, r5);
        Lazy r0 = com.larus.bmhome.utils.z1.a;
        int r6 = com.larus.bmhome.utils.z1.h(getBoxType(), getImmerseBgColor(), r4, r5, 16);
        if (com.larus.platform.service.e2.a.isPad() == true) goto L15;
        WidgetView r7 = this.p;
        if (r7 != null) goto L7;
    L9:
        boolean r8 = false;
    L10:
        if (r8 == true) goto L16;
        setMaxWidth(r6);
        WidgetView r9 = this.p;
        if (r9 == null) goto L17;
        r9.setMaxWidth(getMaxWidth());
        return;
    L17:
        return;
    L16:
        return;
    L7:
        if (r7.getMaxWidth() != r6) goto L9;
        r8 = true;
        goto L10
    }
}

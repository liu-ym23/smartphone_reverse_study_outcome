package com.ss.android.lark.contact.base.contact_search;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class InviteExternalSearchDescoration extends RecyclerView.ItemDecoration {
    public final TextPaint a;
    public final int b;
    public final int c;
    public final Paint d;
    public final String e;
    public final int f;
    public final int g;
    public final String h;
    public final String i;

    public InviteExternalSearchDescoration(Activity r3, String r4) {
        this.h = UIHelper.getString(2131890921);
        this.i = UIHelper.getString(2131890922);
        TextPaint r0 = new TextPaint();
        this.a = r0;
        r0.setAntiAlias(true);
        r0.setTextSize(y9c.d.d(r3, 2131168444));
        r0.setColor(y9c.d.c(r3, 2131106620));
        r0.setTextAlign(Paint.Align.LEFT);
        Paint r1 = new Paint();
        this.d = r1;
        r1.setColor(y9c.d.c(r3, 2131100545));
        this.b = y9c.d.d(r3, 2131167882);
        this.c = y9c.d.d(r3, 2131168448);
        this.f = y9c.d.d(r3, 2131167702);
        this.g = y9c.d.d(r3, 2131168450);
        this.e = r4;
    }

    public final void onDraw(Canvas r9, RecyclerView r10, RecyclerView.State r11) {
        super.onDrawOver(r9, r10, r11);
        View r12 = r10.getChildAt(0);
        if (r12 == null) goto L15;
        int r0 = r10.getChildAdapterPosition(r12);
        float r4 = r12.getBottom();
        if (r10.getChildCount() <= 1) goto L16;
        if (r0 == 0) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(this.e) == false) goto L10;
        return;
    L10:
        if (this.e.contains("@") == false) goto L12;
        String r13 = this.h;
    L13:
        r9.drawText(r13, this.c, this.g + r4, this.a);
        r9.drawRect(0.0f, r4, r12.getRight(), r4 + this.f, this.d);
        return;
    L12:
        r13 = this.i;
        goto L13
    L16:
        return;
    }

    public final void getItemOffsets(Rect r1, View r2, RecyclerView r3, RecyclerView.State r4) {
        super.getItemOffsets(r1, r2, r3, r4);
        if (r3.getChildAdapterPosition(r2) != 0) goto L6;
        r1.bottom = this.b;
        return;
    }
}

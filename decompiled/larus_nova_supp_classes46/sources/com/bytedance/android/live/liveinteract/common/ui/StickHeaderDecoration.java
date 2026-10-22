package com.bytedance.android.live.liveinteract.common.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.list.e;
import com.bytedance.android.live.liveinteract.linkpanel.list.f;
import com.bytedance.android.live.liveinteract.linkpanel.list.q;
import com.bytedance.android.live.liveinteract.linkpanel.list.r;
import com.bytedance.android.live.liveinteract.linkpanel.list.t;
import com.bytedance.android.live.liveinteract.linkpanel.util.k;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.List;
import zf0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class StickHeaderDecoration extends RecyclerView.ItemDecoration {
    public static final int e = 0;
    public static final int f = 0;
    public static final int g = 0;
    public final Paint a;
    public final Paint b;
    public final Rect c;
    public IRoom d;

    static {
        e = s1.f(32.0f);
        f = s1.f(16.0f);
        g = s1.f(13.0f);
    }

    public StickHeaderDecoration() {
        this.c = new Rect();
        Paint r0 = new Paint(1);
        this.a = r0;
        r0.setColor(-1);
        Paint r1 = new Paint(1);
        this.b = r1;
        r1.setTextSize(g);
        r1.setColor(ColorProtector.parseColor("#57161823"));
    }

    public final String h(List<?> r3, int r4) {
        Object r0 = ListProtector.get(r3, r4);
        if ((r0 instanceof ILinkPlayerInfoBridge) == true) goto L41;
        if ((r0 instanceof t) == true) goto L41;
        if ((r0 instanceof r) == true) goto L41;
        if ((r0 instanceof c.a) == true) goto L41;
        if ((ListProtector.get(r3, r4) instanceof e) == false) goto L35;
        k.a.getClass();
        if (k.a.a() == false) goto L16;
    L18:
        boolean r5 = false;
    L19:
        if (r5 == false) goto L22;
        return s1.B(2131918038);
    L22:
        if (k.a.a() == false) goto L30;
        IRoom r6 = this.d;
        if (r6 == null) goto L44;
        if (r6.getVisibilityRange() != 15) goto L44;
        return s1.B(2131918159);
    L44:
        return s1.B(2131918160);
    L30:
        if (k.a.b() == false) goto L33;
        return s1.B(2131918161);
    L33:
        return s1.B(2131918038);
    L16:
        if (k.a.b() == true) goto L18;
        r5 = true;
        goto L19
    L35:
        if ((ListProtector.get(r3, r4) instanceof f) == true) goto L37;
        return "";
    L37:
        return s1.B(2131918038);
    L41:
        return s1.B(2131918036);
    }

    public final boolean i(List<?> r4, int r5) {
        if (r5 > 0) goto L5;
    L25:
        return false;
    L5:
        if (r5 >= r4.size()) goto L25;
        if ((ListProtector.get(r4, r5) instanceof ILinkPlayerInfoBridge) == false) goto L15;
        Object r6 = ListProtector.get(r4, r5 - 1);
        boolean r7 = !(r6 instanceof ILinkPlayerInfoBridge);
        boolean r8 = r6 instanceof q;
        if (r7 == false) goto L26;
        if (r8 == true) goto L27;
        return true;
    L27:
        return false;
    L26:
        return false;
    L15:
        if ((ListProtector.get(r4, r5) instanceof f) == false) goto L19;
        return !(ListProtector.get(r4, r5 - 1) instanceof f);
    L19:
        if ((ListProtector.get(r4, r5) instanceof e) == false) goto L23;
        return !(ListProtector.get(r4, r5 - 1) instanceof e);
    L23:
        if ((ListProtector.get(r4, r5) instanceof c.a) == false) goto L25;
        return true;
    }

    public final void onDraw(Canvas r17, RecyclerView r18, RecyclerView.State r19) {
        if (r18.getAdapter() == null) goto L11;
        List<?> r2 = r18.getAdapter().a;
        int r3 = r18.getChildCount();
        int r5 = 0;
    L5:
        if (r5 >= r3) goto L15;
        View r6 = r18.getChildAt(r5);
        int r7 = r18.getChildLayoutPosition(r6);
        if (i(r2, r7) == false) goto L10;
        int r8 = r6.getTop();
        int r15 = e;
        r17.drawRect(0.0f, r8 - r15, r18.getWidth(), r6.getTop(), this.a);
        this.b.getTextBounds(h(r2, r7), 0, h(r2, r7).length(), this.c);
        r17.drawText(h(r2, r7), f, (r6.getTop() - (r15 / 2)) + (this.c.height() / 2), this.b);
    L10:
        r5 = r5 + 1;
        goto L5
    L15:
        return;
    }

    public final void onDrawOver(Canvas r12, RecyclerView r13, RecyclerView.State r14) {
        if (r13.getAdapter() != null) goto L5;
        return;
    L5:
        if (r13.getLayoutManager() == null) goto L17;
        List<?> r15 = r13.getAdapter().a;
        int r0 = r13.getLayoutManager().findFirstVisibleItemPosition();
        if (r13.findViewHolderForAdapterPosition(r0) == null) goto L18;
        View r1 = r13.findViewHolderForAdapterPosition(r0).itemView;
        if (i(r15, r0 + 1) == false) goto L12;
        if (r0 == 0) goto L12;
        int r2 = e;
        int r4 = Math.min(r2, r1.getBottom());
        r12.drawRect(0.0f, r1.getTop() - r13.getWidth(), r13.getWidth(), r4, this.a);
        this.b.getTextBounds(h(r15, r0), 0, h(r15, r0).length(), this.c);
        r12.drawText(h(r15, r0), f, ((this.c.height() / 2) - (r2 / 2)) + r4, this.b);
    L14:
        r12.save();
        return;
    L12:
        if (r0 == 0) goto L14;
        float r7 = r13.getWidth();
        int r16 = e;
        r12.drawRect(0.0f, 0.0f, r7, r16, this.a);
        this.b.getTextBounds(h(r15, r0), 0, h(r15, r0).length(), this.c);
        r12.drawText(h(r15, r0), f, (r16 / 2) + (this.c.height() / 2), this.b);
        goto L14
    L18:
        return;
    }

    public final void getItemOffsets(Rect r1, View r2, RecyclerView r3, RecyclerView.State r4) {
        if (r3.getAdapter() != null) goto L5;
        return;
    L5:
        if (i(r3.getAdapter().a, r3.getChildLayoutPosition(r2)) == false) goto L9;
        r1.top = e;
        return;
    }
}

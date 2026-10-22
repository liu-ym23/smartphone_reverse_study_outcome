package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import am2.x;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.BaseHeaderLoader;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i extends BaseHeaderLoader {
    public final TextView a;
    public final View b;
    public boolean c;
    public boolean d;
    public final q4.b e;
    public final ViewGroup f;

    public static final class a {
    }

    static {
    }

    private final int getResourceLayout() {
        return 2131566859;
    }

    public final void b() {
        if (this.d == true) goto L6;
        return;
    L6:
        if (this.e.b() == false) goto L8;
        return;
    L8:
        ViewGroup r0 = this.f;
        if (r0 != null) goto L11;
        return;
    L11:
        this.d = false;
        UtilityKotlinExtentionsKt.t(r0);
        TextView r1 = this.a;
        if (r1 == null) goto L14;
        r1.setAlpha(0.0f);
    L14:
        HashMap r2 = new HashMap();
        r2.put("comment_send_num", "0");
        j0.l().sendLog("livesdk_history_comment_load", r2, new Object[]{new x(), IRoom.class});
    }

    public float getHeaderHeight() {
        return UtilityKotlinExtentionsKt.h(52.0f);
    }

    public final ViewGroup getNoMoreLayout() {
        return this.f;
    }

    public final boolean getShouldStartAnim() {
        return this.c;
    }

    public final void a(int r4) {
        if (this.c == true) goto L5;
        return;
    L5:
        ViewGroup r0 = this.f;
        if (r0 != null) goto L9;
        return;
    L9:
        if (this.d == true) goto L11;
        this.d = true;
        UtilityKotlinExtentionsKt.w(r0);
    L11:
        ViewGroup.LayoutParams r1 = this.f.getLayoutParams();
        r1.height = Math.abs(r4);
        this.f.setLayoutParams(r1);
        TextView r2 = this.a;
        if (r2 == null) goto L15;
        float r3 = 26;
        r2.setAlpha(RangesKt.coerceAtLeast(RangesKt.coerceAtMost((Math.abs(r4) - UtilityKotlinExtentionsKt.h(r3)) / UtilityKotlinExtentionsKt.h(r3), 1.0f), 0.0f));
        return;
    }

    public final void setShouldStartAnim(boolean r1) {
        this.c = r1;
    }

    public final void setShow(boolean r1) {
        this.d = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(Context r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        TextView r1 = null;
        super(r4, null, 0);
        this.f = r5;
        this.c = true;
        this.b = LayoutInflater.from(r4).inflate(getResourceLayout(), this, true);
        if (r5 == null) goto L5;
        r1 = (TextView) r5.findViewById(2131380930);
    L5:
        this.a = r1;
        if (r1 == null) goto L8;
        r1.setText(2131919529);
        r1.setTextColor(-1);
    L8:
        if (r5 == null) goto L10;
        UtilityKotlinExtentionsKt.t(r5);
    L10:
        this.e = u4.c(new LiveMessageHeadLoaderView$hideAnimController$1(this));
    }
}

package com.bytedance.android.livesdk.interactivity.api.publicscreenV2.base;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.DispatchCallbackLinearLayout;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.t;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.u;
import g52.b;
import h52.c;
import k52.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreenV2/base/AbsPublicScreenMessageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lg52/b;", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsPublicScreenMessageViewHolder extends RecyclerView.ViewHolder implements b {
    public c a;
    public boolean b;
    public final DispatchCallbackLinearLayout c;
    public final NoMoreSpaceTextView d;
    public final a e;

    public abstract void T3(c r1);

    public final void d3() {
        DispatchCallbackLinearLayout r0 = this.c;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.b == false) goto L8;
        int r1 = l.a;
        int r2 = l.a;
    L9:
        Drawable r3 = r0.getBackground();
        Drawable r4 = null;
        if ((r3 instanceof GradientDrawable) == true) goto L12;
        r3 = null;
    L12:
        GradientDrawable r5 = (GradientDrawable) r3;
        if (r5 != null) goto L19;
        r0.setBackgroundResource(2131249529);
        Drawable r6 = r0.getBackground();
        if ((r6 instanceof GradientDrawable) == false) goto L18;
        r4 = r6;
    L18:
        r5 = (GradientDrawable) r4;
    L19:
        if (r5 == null) goto L22;
        r5.setColor(r2);
        return;
    L22:
        return;
    L8:
        int r7 = l.a;
        r2 = l.b;
        goto L9
    }

    @Override // g52.b
    public final void c(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "ev");
        int r4 = r3.getAction();
        if (r4 != 0) goto L5;
        this.b = true;
        d3();
        return;
    L5:
        if (r4 != 1) goto L7;
        this.b = false;
        d3();
        return;
    L7:
        if (r4 != 3) goto L15;
        this.b = false;
        d3();
        return;
    }

    public AbsPublicScreenMessageViewHolder(View r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "pipelineConfig");
        super(r2);
        this.e = r3;
        DispatchCallbackLinearLayout r4 = (DispatchCallbackLinearLayout) r2.findViewById(2131363806);
        this.c = r4;
        NoMoreSpaceTextView r5 = r2.findViewById(2131367794);
        this.d = r5;
        if (r4 == null) goto L5;
        r4.setDispatchCallback(this);
    L5:
        if (r5 == null) goto L8;
        r5.setMovementMethod(u.a());
        r5.setHighlightColor(0);
        t.a(r5);
        return;
    }
}

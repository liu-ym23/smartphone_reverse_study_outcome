package com.bytedance.android.livesdk.interactivity.comment.input;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/input/OGCFixedCommentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OGCFixedCommentViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int k = 0;
    public int a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final View f;
    public final py.k g;
    public final py.k h;
    public final Integer i;
    public final Integer j;

    public static final class a implements View.OnTouchListener {
        public final /* synthetic */ OGCFixedCommentViewHolder a;

        public a(OGCFixedCommentViewHolder r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r3, MotionEvent r4) {
            int r5 = r4.getAction();
            if (r5 == 0) goto L9;
            if (r5 != 1) goto L6;
        L8:
            OGCFixedCommentViewHolder r6 = this.a;
            int r0 = OGCFixedCommentViewHolder.k;
            r6.T3(false);
        L10:
            return false;
        L6:
            if (r5 == 3) goto L8;
        L9:
            OGCFixedCommentViewHolder r7 = this.a;
            int r1 = OGCFixedCommentViewHolder.k;
            r7.T3(true);
            goto L10
        }
    }

    public final void T3(boolean r4) {
        if (this.a == 1) goto L5;
        return;
    L5:
        ALogger.d("OGCFixedCommentViewHolder[" + hashCode() + ']', "index:" + getAdapterPosition() + ",switch to " + r4);
        if (r4 == false) goto L18;
        HSImageView r5 = (HSImageView) this.c.getValue();
        if (r5 == null) goto L10;
        UtilityKotlinExtentionsKt.t(r5);
    L10:
        HSImageView r6 = (HSImageView) this.d.getValue();
        if (r6 == null) goto L14;
        UtilityKotlinExtentionsKt.w(r6);
    L14:
        if (this.j == null) goto L30;
        TextView r7 = (TextView) this.e.getValue();
        if (r7 == null) goto L31;
        r7.setTextColor(this.j.intValue());
        return;
    L31:
        return;
    L30:
        return;
    L18:
        HSImageView r8 = (HSImageView) this.c.getValue();
        if (r8 == null) goto L21;
        UtilityKotlinExtentionsKt.w(r8);
    L21:
        HSImageView r9 = (HSImageView) this.d.getValue();
        if (r9 == null) goto L25;
        UtilityKotlinExtentionsKt.t(r9);
    L25:
        if (this.i == null) goto L33;
        TextView r10 = (TextView) this.e.getValue();
        if (r10 == null) goto L34;
        r10.setTextColor(this.i.intValue());
        return;
    L34:
        return;
    }

    public OGCFixedCommentViewHolder(View r4, py.k r5, py.k r6, Integer r7, Integer r8) {
        Intrinsics.checkNotNullParameter(r4, "rootView");
        super(r4);
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.j = r8;
        this.a = 2;
        this.b = LazyKt.lazy(new OGCFixedCommentViewHolder$ogcFixedItemRoot$2(this));
        Lazy r9 = LazyKt.lazy(new OGCFixedCommentViewHolder$ogcFixedTextBgDefault$2(this));
        this.c = r9;
        Lazy r10 = LazyKt.lazy(new OGCFixedCommentViewHolder$ogcFixedTextBgSelect$2(this));
        this.d = r10;
        this.e = LazyKt.lazy(new OGCFixedCommentViewHolder$ogcFixedText$2(this));
        a r11 = new a(this);
        if (r6 != null) goto L5;
    L7:
        if (r5 != null) goto L9;
    L11:
        ((RecyclerView.ViewHolder) this).itemView.setOnTouchListener(r11);
        return;
    L9:
        if ((!r5.getUrls().isEmpty()) == false) goto L11;
        a1.t((HSImageView) r9.getValue(), r5, false, null);
        goto L11
    L5:
        if ((!r6.getUrls().isEmpty()) == false) goto L7;
        a1.t((HSImageView) r10.getValue(), r6, false, null);
        goto L7
    }
}

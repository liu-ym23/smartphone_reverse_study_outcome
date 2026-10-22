package com.bytedance.android.livesdk.dislike.layout;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.dislike.action.y;
import com.bytedance.android.livesdk.dislike.z;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import nt1.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/layout/ShareFansItemLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/dislike/z;", "item", "", "update", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShareFansItemLayout extends FrameLayout {
    public final TextView a;
    public final TextView b;
    public z c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ShareFansItemLayout a;

        public a(ShareFansItemLayout r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            z r0 = this.a.c;
            if (r0 == null) goto L7;
            pt1.a r1 = r0.c;
        L8:
            r2.setTag(r1);
            z r3 = this.a.c;
            if (r3 == null) goto L14;
            y r4 = r3.d;
            if (r4 == null) goto L15;
            r4.b(r2);
            return;
        L15:
            return;
        L14:
            return;
        L7:
            r1 = null;
            goto L8
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ShareFansItemLayout a;

        public b(ShareFansItemLayout r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            z r0 = this.a.c;
            if (r0 == null) goto L7;
            pt1.a r1 = r0.c;
        L8:
            r2.setTag(r1);
            z r3 = this.a.c;
            if (r3 == null) goto L14;
            y r4 = r3.d;
            if (r4 == null) goto L15;
            r4.b(r2);
            return;
        L15:
            return;
        L14:
            return;
        L7:
            r1 = null;
            goto L8
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ShareFansItemLayout a;

        public c(ShareFansItemLayout r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            z r0 = this.a.c;
            if (r0 == null) goto L7;
            pt1.a r1 = r0.c;
        L8:
            r2.setTag(r1);
            z r3 = this.a.c;
            if (r3 == null) goto L14;
            y r4 = r3.d;
            if (r4 == null) goto L15;
            r4.b(r2);
            return;
        L15:
            return;
        L14:
            return;
        L7:
            r1 = null;
            goto L8
        }
    }

    public ShareFansItemLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        View.inflate(getContext(), 2131565769, this);
        TextView r3 = (TextView) findViewById(2131386061);
        if (r3 == null) goto L5;
        r3.setOnClickListener(new c(this));
        r3.setOnTouchListener(new e(this));
        Unit r0 = Unit.INSTANCE;
    L6:
        this.a = r3;
        this.b = (TextView) findViewById(2131386152);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void update(z r5) {
        Intrinsics.checkNotNullParameter(r5, "item");
        this.c = r5;
        pt1.a r6 = r5.c;
        r6.getClass();
        pt1.a.e.getClass();
        ArrayList r0 = pt1.a.b.a();
        if (r0 == null) goto L12;
        Room r7 = r6.a;
        if (r7 == null) goto L7;
        long r2 = r7.getRoomId();
    L9:
        if (r0.contains(Long.valueOf(r2)) == false) goto L12;
        boolean r8 = false;
    L14:
        if (r8 == false) goto L16;
        b(this.a, 0);
        b(this.b, 8);
        return;
    L16:
        b(this.a, 8);
        b(this.b, 0);
        return;
    L7:
        r2 = 0;
    L12:
        r8 = true;
        goto L14
    }

    public ShareFansItemLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        View.inflate(getContext(), 2131565769, this);
        TextView r4 = (TextView) findViewById(2131386061);
        if (r4 == null) goto L5;
        r4.setOnClickListener(new b(this));
        r4.setOnTouchListener(new e(this));
        Unit r5 = Unit.INSTANCE;
    L6:
        this.a = r4;
        this.b = (TextView) findViewById(2131386152);
        return;
    L5:
        r4 = null;
        goto L6
    }

    public static void b(View r1, int r2) {
        if (r1 != null) goto L4;
    L5:
        if (r1 == null) goto L9;
        r1.setVisibility(r2);
        return;
    L9:
        return;
    L4:
        if (r1.getVisibility() != r2) goto L5;
    }

    public ShareFansItemLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View.inflate(getContext(), 2131565769, this);
        TextView r5 = (TextView) findViewById(2131386061);
        if (r5 == null) goto L5;
        r5.setOnClickListener(new a(this));
        r5.setOnTouchListener(new e(this));
        Unit r6 = Unit.INSTANCE;
    L6:
        this.a = r5;
        this.b = (TextView) findViewById(2131386152);
        return;
    L5:
        r5 = null;
        goto L6
    }

    public static final void a(ShareFansItemLayout r4, boolean r5, View r6) {
        r4.getClass();
        float[] r7 = new float[2];
        float r0 = 1.0f;
        if (r5 == false) goto L5;
        float r2 = 1.0f;
    L6:
        r7[0] = r2;
        if (r5 == false) goto L9;
        r0 = 0.75f;
    L9:
        r7[1] = r0;
        ObjectAnimator r8 = ObjectAnimator.ofFloat(r6, "alpha", r7);
        r8.setDuration(100);
        r8.start();
        return;
    L5:
        r2 = 0.75f;
        goto L6
    }
}

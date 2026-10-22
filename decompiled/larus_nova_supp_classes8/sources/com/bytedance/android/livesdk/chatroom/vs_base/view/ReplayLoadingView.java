package com.bytedance.android.livesdk.chatroom.vs_base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.ui.DouyinLoadingLayout;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mq1.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/view/ReplayLoadingView;", "Landroid/widget/FrameLayout;", "", "text", "", "setText", "", "color", "setTextColor", "url", "setLandBackgroundUrl", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayLoadingView extends FrameLayout {
    public final TextView a;
    public final HSImageView b;
    public final ImageView c;
    public final DouyinLoadingLayout d;
    public boolean e;
    public String f;

    public static final class a implements View.OnClickListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            o r0 = s.d();
            if (r0 == null) goto L6;
            o.a.a(r0, 1, 0, 0, null, 30);
            return;
        }
    }

    public ReplayLoadingView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ReplayLoadingView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a() {
        UtilityKotlinExtentionsKt.h(this.b);
        if (this.e == true) goto L6;
        UtilityKotlinExtentionsKt.j(this.c);
        return;
    }

    public final void setLandBackgroundUrl(String r3) {
        this.f = r3;
        if (this.b.getVisibility() != 0) goto L8;
        String r4 = this.f;
        if (r4 == null) goto L9;
        a1.r(this.b, r4, 2131108332);
        return;
    L9:
        return;
    }

    public final void setText(String r3) {
        Intrinsics.checkNotNullParameter(r3, "text");
        UtilityKotlinExtentionsKt.j(this);
        this.d.setVisibility(0);
        this.a.setText(r3);
    }

    public final void setTextColor(int r3) {
        UtilityKotlinExtentionsKt.j(this);
        this.d.setVisibility(0);
        this.a.setTextColor(s1.h(r3));
    }

    public ReplayLoadingView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(getContext()).inflate(2131567309, this, true);
        this.a = (TextView) findViewById(2131392934);
        this.b = findViewById(2131376339);
        ImageView r5 = (ImageView) findViewById(2131376032);
        this.c = r5;
        this.d = (DouyinLoadingLayout) findViewById(2131392933);
        r5.setOnClickListener(a.a);
        a();
    }

    public /* synthetic */ ReplayLoadingView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

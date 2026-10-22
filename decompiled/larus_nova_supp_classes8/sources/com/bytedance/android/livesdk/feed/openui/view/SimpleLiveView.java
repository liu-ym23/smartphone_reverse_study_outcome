package com.bytedance.android.livesdk.feed.openui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.model.LiveCoverConfig;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/feed/openui/view/SimpleLiveView;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public final class SimpleLiveView extends RelativeLayout {
    public static final /* synthetic */ int g = 0;
    public Room a;
    public String b;
    public boolean c;
    public boolean d;
    public String e;
    public HashMap f;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ SimpleLiveView a;

        public b(SimpleLiveView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SimpleLiveView r0 = this.a;     // Catch: Throwable -> L4
            SimpleLiveView.b(r0, r0.d, r0.a(2131376143).getMeasuredWidth());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public SimpleLiveView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SimpleLiveView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final View a(int r3) {
        if (this.f != null) goto L5;
        this.f = new HashMap();
    L5:
        View r0 = (View) this.f.get(Integer.valueOf(r3));
        if (r0 != null) goto L9;
        View r1 = findViewById(r3);
        this.f.put(Integer.valueOf(r3), r1);
        return r1;
    L9:
        return r0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.c = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.c = false;
        removeCallbacks(new b(this));
    }

    public SimpleLiveView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = "unknown";
        this.e = "";
        View.inflate(getContext(), 2131565988, this);
    }

    public static final void b(SimpleLiveView r2, boolean r3, int r4) {
        if (r2.c == false) goto L11;
        int r0 = ((RelativeLayout) r2.a(2131392560)).getMeasuredWidth();
        if (r3 == false) goto L8;
        ((TextView) r2.a(2131390141)).setMaxWidth((r0 - r4) - LiveResUtil.dp2Px(8.0f));
        return;
    L8:
        ((TextView) r2.a(2131390141)).setMaxWidth(r0);
        return;
    }

    public /* synthetic */ SimpleLiveView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void c(User r5, ImageModel r6, String r7, long r8, String r10, LiveCoverConfig r11) {
        if (r5 != null) goto L4;
        return;
    L4:
        ((TextView) a(2131390141)).setText(r5.getNickName());
        if (r5.getAvatarThumb() != null) goto L7;
        a(2131376019).setBackground(getContext().getResources().getDrawable(2131251889));
    L9:
        if (r6 == null) goto L14;
        if (r11 != null) goto L12;
    L13:
        this.d = true;
        UIUtils.setViewVisibility(a(2131376143), 0);
        ImageLoader.d r9 = ImageLoader.load(r6);
        r9.e = new h(this);
        r9.a(a(2131376143));
    L15:
        if (r11 != null) goto L17;
    L31:
        ((TextView) a(2131391326)).setText(r7);
        if (r11 != null) goto L34;
    L42:
        ((TextView) a(2131390173)).setText(getContext().getString(2131916621, new Object[]{r10}));
        setOnClickListener(new j(this));
        return;
    L34:
        if ((r11 instanceof mw1.b) == false) goto L42;
        if (((mw1.b) r11).f == false) goto L41;
        ((TextView) a(2131391239)).setText(String.valueOf(r8));
        ((TextView) a(2131391239)).setVisibility(0);
        if (r8 >= 4) goto L40;
        ((TextView) a(2131391239)).setTextColor(LiveResUtil.getColor(2131107472));
        goto L42
    L40:
        ((TextView) a(2131391239)).setTextColor(LiveResUtil.getColor(2131107473));
        goto L42
    L41:
        ((TextView) a(2131391239)).setVisibility(8);
        goto L42
    L17:
        if ((r11 instanceof mw1.b) == false) goto L31;
        if ((((LinearLayout) a(2131378486)).getBackground() instanceof GradientDrawable) == false) goto L28;
        Drawable r1 = ((LinearLayout) a(2131378486)).getBackground();
        if (r1 == null) goto L26;
        GradientDrawable r2 = (GradientDrawable) r1;
        Integer r3 = ((mw1.b) r11).a;
        if (r3 == null) goto L28;
        int r4 = r3.intValue();
        r2.setColor(r4);
        a(2131376366).setColors(r4, r4);
        goto L28
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L28:
        if (((mw1.b) r11).g == false) goto L30;
        UtilityKotlinExtentionsKt.z(a(2131376187), true);
        ((LinearLayout) a(2131378486)).getLayoutParams().width = LiveResUtil.getDimension(2131168622);
        goto L31
    L30:
        UtilityKotlinExtentionsKt.z(a(2131376187), false);
        ((LinearLayout) a(2131378486)).getLayoutParams().width = LiveResUtil.getDimension(2131168641);
        goto L31
    L12:
        if (r11.getEnableContentLabel() == true) goto L13;
    L14:
        this.d = false;
        UIUtils.setViewVisibility(a(2131376143), 8);
        post(new i(this));
        goto L15
    L7:
        a1.x(a(2131376019), r5.getAvatarThumb(), a(2131376019).getWidth(), a(2131376019).getHeight(), 2131251889);
        goto L9
    }
}

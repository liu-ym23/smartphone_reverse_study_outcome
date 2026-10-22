package com.bytedance.android.livesdk.dislike.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livesdk.config.m70;
import com.bytedance.android.livesdk.dislike.a0;
import com.bytedance.android.livesdk.dislike.action.OptionAction;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveLongPressPanelItemConfig;
import hd0.c;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/layout/ShareLiveToDailyLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/dislike/a0;", "item", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "", "update", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShareLiveToDailyLayout extends FrameLayout {
    public final TextView a;
    public final HSImageView b;
    public final View c;
    public OptionAction d;
    public boolean e;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ShareLiveToDailyLayout a;

        public a(ShareLiveToDailyLayout r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            ShareLiveToDailyLayout r0 = this.a;
            if (r0.e == true) goto L5;
            OptionAction r1 = r0.d;
            if (r1 == null) goto L13;
            r1.b(r3);
            return;
        L13:
            return;
        L5:
            if (r3.getContext() == null) goto L11;
            f2.b(2131922507, 0);
            return;
        }
    }

    public ShareLiveToDailyLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ShareLiveToDailyLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("share_to_story_type", "live_room");
        r1.put("enter_method", "live_room_inner_long_press");
        Unit r2 = Unit.INSTANCE;
        r0.h("show_share_to_diary", r1, new Object[0]);
    }

    public final void update(a0 r3, Room r4) {
        Intrinsics.checkNotNullParameter(r3, "item");
        this.d = r3.b;
        boolean r5 = false;
        if (r4 == null) goto L5;
        int r0 = r4.getVisibilityRange();
    L7:
        if (r0 == 0) goto L9;
    L8:
        r5 = true;
    L18:
        this.e = r5;
        LiveLongPressPanelItemConfig r6 = m70.a.getValue();
        if (r6 == null) goto L25;
        String r7 = r6.getLiveShareLiveToDailyText();
        if (r7 == null) goto L25;
        TextView r1 = this.a;
        if (r1 == null) goto L25;
        r1.setText(r7);
    L25:
        if (r6 == null) goto L32;
        String r8 = r6.getLiveShareLiveToDailyIcon();
        if (r8 == null) goto L32;
        HSImageView r9 = this.b;
        if (r9 == null) goto L32;
        ImageLoader.bindImage(r9, r8);
    L32:
        if (this.e == false) goto L43;
        TextView r10 = this.a;
        if (r10 == null) goto L36;
        r10.setAlpha(0.5f);
    L36:
        HSImageView r11 = this.b;
        if (r11 == null) goto L39;
        r11.setAlpha(0.5f);
    L39:
        View r12 = this.c;
        if (r12 == null) goto L44;
        r12.setAlpha(0.5f);
        return;
    L44:
        return;
    L43:
        return;
    L9:
        if (r4 == null) goto L16;
        User r13 = r4.getOwner();
        if (r13 == null) goto L16;
        if (r13.getSecret() == 1) goto L8;
    L16:
        if (c.f().h() == false) goto L18;
    L5:
        r0 = 0;
        goto L7
    }

    public ShareLiveToDailyLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View.inflate(r2, 2131563519, this);
        setOnClickListener(new a(this));
        TextView r5 = (TextView) findViewById(2131388772);
        IMiddlewareHostApp r6 = k.f(IMiddlewareHostApp.class);
        if (r6 == null) goto L7;
        String r7 = r6.replaceBrand(2131922506);
        if (r7 == null) goto L7;
    L8:
        r5.setText(r7);
        Unit r8 = Unit.INSTANCE;
        this.a = r5;
        this.b = findViewById(2131374718);
        this.c = findViewById(2131364981);
        return;
    L7:
        r7 = "转发到日常";
        goto L8
    }

    public /* synthetic */ ShareLiveToDailyLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

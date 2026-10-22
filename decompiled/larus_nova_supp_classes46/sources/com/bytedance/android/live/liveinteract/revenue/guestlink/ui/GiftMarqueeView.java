package com.bytedance.android.live.liveinteract.revenue.guestlink.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.message.model.n5;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/guestlink/ui/GiftMarqueeView;", "Landroid/widget/FrameLayout;", "", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftMarqueeView extends FrameLayout {
    public Map<Integer, View> a;

    public GiftMarqueeView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GiftMarqueeView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final View a(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final void b(n5 r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "giftMessage");
        if (r8 == false) goto L5;
        TextView r9 = (TextView) a(2131390697);
        StringCompanionObject r2 = StringCompanionObject.INSTANCE;
        r9.setText(String.format("x%s", Arrays.copyOf(new Object[]{Long.valueOf(r7.getRepeatCount())}, 1)));
        return;
    L5:
        h1 r10 = r7.getGift();
        if (r10 == null) goto L10;
        k r11 = r10.getImage();
        if (r11 == null) goto L10;
        ImageUtil.loadImage((ImageView) a(2131373724), r11, 0);
    L10:
        TextView r12 = (TextView) a(2131390669);
        IBaseUser r4 = r7.getFromUser();
        String r5 = "";
        if (r4 == null) goto L15;
        String r6 = r4.getNickName();
        if (r6 == null) goto L15;
    L16:
        r12.setText(r6);
        TextView r13 = (TextView) a(2131391631);
        IBaseUser r14 = r7.getToUser();
        if (r14 == null) goto L21;
        String r15 = r14.getNickName();
        if (r15 == null) goto L21;
        r5 = r15;
    L21:
        r13.setText(r5);
        TextView r16 = (TextView) a(2131390697);
        StringCompanionObject r3 = StringCompanionObject.INSTANCE;
        r16.setText(String.format("x%s", Arrays.copyOf(new Object[]{Long.valueOf(r7.getRepeatCount())}, 1)));
        return;
    L15:
        r6 = "";
        goto L16
    }

    public GiftMarqueeView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        LayoutInflater.from(r2).inflate(2131566147, this, true);
    }

    public /* synthetic */ GiftMarqueeView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

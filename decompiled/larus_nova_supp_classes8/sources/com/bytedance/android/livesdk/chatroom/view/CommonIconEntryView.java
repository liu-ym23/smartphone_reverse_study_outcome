package com.bytedance.android.livesdk.chatroom.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.base.model.q;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.common.utility.UIUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/view/CommonIconEntryView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonIconEntryView extends FrameLayout {

    public static final class a {
    }

    static {
    }

    public CommonIconEntryView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CommonIconEntryView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a(String r5, q.a r6) {
        Intrinsics.checkNotNullParameter(r5, "bgImageUrl");
        HSImageView r0 = new HSImageView(getContext());
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        FrescoLoader.with(r0.getContext()).load(r5).actualScaleType(ImageView.ScaleType.FIT_XY).into(r0);
        Unit r7 = Unit.INSTANCE;
        addView(r0);
        if (r6 == null) goto L15;
        int r8 = r6.baseWidth;
        if (r8 > 0) goto L7;
    L9:
        List r9 = r6.layers;
        if (r9 == null) goto L17;
        Iterator r10 = r9.iterator();
    L13:
        if (r10.hasNext() == false) goto L18;
        q.a.a r11 = (q.a.a) r10.next();
        HSImageView r1 = new HSImageView(getContext());
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(UtilityKotlinExtentionsKt.i(r11.width), UtilityKotlinExtentionsKt.i(r11.height));
        r2.leftMargin = UtilityKotlinExtentionsKt.i(r11.x);
        r2.topMargin = UtilityKotlinExtentionsKt.i(r11.y);
        Unit r3 = Unit.INSTANCE;
        r1.setLayoutParams(r2);
        FrescoLoader.with(r1.getContext()).load(r11.url).cornersRadius(UtilityKotlinExtentionsKt.i(r11.radius)).actualScaleType(ImageView.ScaleType.FIT_XY).into(r1);
        addView(r1);
        goto L13
    L18:
        return;
    L17:
        return;
    L7:
        if (r6.baseHeight <= 0) goto L9;
        UIUtils.updateLayout(this, UtilityKotlinExtentionsKt.i(r8), UtilityKotlinExtentionsKt.i(r6.baseHeight));
        goto L9
    }

    public CommonIconEntryView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setLayoutParams(new ViewGroup.LayoutParams(UtilityKotlinExtentionsKt.i(80), UtilityKotlinExtentionsKt.i(96)));
    }

    public /* synthetic */ CommonIconEntryView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

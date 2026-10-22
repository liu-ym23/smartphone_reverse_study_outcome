package com.bytedance.android.livesdk.feed.openui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdkapi.view.SaasLiveCircleView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/feed/openui/view/DouyinLivingView;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public final class DouyinLivingView extends RelativeLayout {
    public HashMap a;

    public DouyinLivingView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DouyinLivingView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final View a(int r3) {
        if (this.a != null) goto L5;
        this.a = new HashMap();
    L5:
        View r0 = (View) this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L9;
        View r1 = findViewById(r3);
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L9:
        return r0;
    }

    public DouyinLivingView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        HSImageView r5 = a(2131376157);
        TextView r6 = (TextView) a(2131390975);
        SaasLiveCircleView r7 = a(2131376366);
        LinearLayout r8 = (LinearLayout) a(2131378486);
        TextView r9 = (TextView) a(2131390896);
        View.inflate(getContext(), 2131565986, this);
    }

    public /* synthetic */ DouyinLivingView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

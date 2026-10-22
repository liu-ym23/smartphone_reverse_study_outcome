package com.bytedance.android.livesdk.dislike.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.f;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.TTLiveSDK;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0013B\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fB\u001b\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000b\u0010\u000fB#\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u000b\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/layout/IMContactDescItemLayoutV2;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/live/base/model/user/f;", "contact", "", "update", "Landroidx/fragment/app/Fragment;", "fragment", "setFragment", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IMContactDescItemLayoutV2 extends LinearLayout {
    public static final int f = 0;
    public static final int g = 0;
    public final TextView a;
    public final HSImageView b;
    public final ImageView c;
    public final View d;
    public Fragment e;

    public static final class a {
    }

    static {
        f = UtilityKotlinExtentionsKt.i(16);
        g = UtilityKotlinExtentionsKt.i(10);
    }

    public IMContactDescItemLayoutV2(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        View.inflate(getContext(), 2131565627, this);
        setGravity(16);
        this.a = (TextView) findViewById(2131368819);
        this.b = findViewById(2131374718);
        this.c = (ImageView) findViewById(2131392462);
        this.d = findViewById(2131374914);
        int r4 = f;
        int r0 = g;
        setPadding(r4, r0, 0, r0);
    }

    public final void setFragment(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.e = r2;
    }

    public final void update(f r5) {
        Intrinsics.checkNotNullParameter(r5, "contact");
        HSImageView r0 = this.b;
        r5.getClass();
        ImageLoader.bindImage(r0, null);
        StringBuilder r1 = new StringBuilder();
        r1.append(null);
        TextView r2 = this.a;
        if (r2 == null) goto L5;
        r2.setText(r1);
    L5:
        Fragment r3 = this.e;
        if (r3 == null) goto L9;
        TTLiveSDK.hostService().user().observeAndUpdateActiveStatus(r3, this.c, r5, null);
        return;
    }

    public IMContactDescItemLayoutV2(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        View.inflate(getContext(), 2131565627, this);
        setGravity(16);
        this.a = (TextView) findViewById(2131368819);
        this.b = findViewById(2131374718);
        this.c = (ImageView) findViewById(2131392462);
        this.d = findViewById(2131374914);
        int r4 = f;
        int r5 = g;
        setPadding(r4, r5, 0, r5);
    }

    public IMContactDescItemLayoutV2(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View.inflate(getContext(), 2131565627, this);
        setGravity(16);
        this.a = (TextView) findViewById(2131368819);
        this.b = findViewById(2131374718);
        this.c = (ImageView) findViewById(2131392462);
        this.d = findViewById(2131374914);
        int r5 = f;
        int r6 = g;
        setPadding(r5, r6, 0, r6);
    }
}

package com.bytedance.android.livesdk.interactivity.chatchannel.v2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/v2/view/ChatChannelAvatarView;", "Landroid/widget/FrameLayout;", BuildConfig.FLAVOR, "Lpy/k;", "list", BuildConfig.FLAVOR, "setAvatarData", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelAvatarView extends FrameLayout {
    public final HSImageView a;
    public final RelativeLayout b;
    public final HSImageView c;
    public final HSImageView d;

    public ChatChannelAvatarView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ChatChannelAvatarView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void setAvatarData(List<? extends k> r5) {
        Intrinsics.checkNotNullParameter(r5, "list");
        if (r5.isEmpty() == false) goto L6;
        UtilityKotlinExtentionsKt.t(this.a);
        UtilityKotlinExtentionsKt.t(this.b);
        return;
    L6:
        if (r5.size() != 1) goto L9;
        UtilityKotlinExtentionsKt.w(this.a);
        UtilityKotlinExtentionsKt.t(this.b);
        ImageUtil.loadImage(this.a, (k) CollectionsKt.first(r5), 0);
        return;
    L9:
        if (r5.size() < 2) goto L14;
        UtilityKotlinExtentionsKt.t(this.a);
        UtilityKotlinExtentionsKt.w(this.b);
        ImageUtil.loadImage(this.d, (k) CollectionsKt.first(r5), 0);
        ImageUtil.loadImage(this.c, (k) ListProtector.get(r5, 1), 0);
        return;
    }

    public ChatChannelAvatarView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        FrameLayout.inflate(r2, 2131565294, this);
        this.a = findViewById(2131386550);
        this.b = (RelativeLayout) findViewById(2131380424);
        this.c = findViewById(2131389114);
        this.d = findViewById(2131364405);
    }

    public /* synthetic */ ChatChannelAvatarView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

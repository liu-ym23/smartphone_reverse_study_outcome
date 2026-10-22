package com.bytedance.android.live.liveinteract.videotalk.themecompetition;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/themecompetition/ThemedCompetitionSeatEffectView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ThemedCompetitionSeatEffectView extends FrameLayout {

    public static final class a {
    }

    static {
    }

    public ThemedCompetitionSeatEffectView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ThemedCompetitionSeatEffectView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public ThemedCompetitionSeatEffectView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View r5 = LayoutInflater.from(r2).inflate(2131567510, null, false);
        addView(r5);
        HSImageView r6 = r5.findViewById(2131389839);
        int r7 = qy.a.a;
        ImageUtil.loadImage(r6, qy.a.b("", CollectionsKt.arrayListOf(new String[]{LiveCommonConstants.assembleTosObjectUrl(d.e)})), 0);
    }

    public /* synthetic */ ThemedCompetitionSeatEffectView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

package com.ss.android.lark.feed.shared.page.utils;

import android.view.View;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class CanvasUtil$drawOvalClippedAvatarChild$orderedChildIndices$1 extends Lambda implements Function1<Integer, Comparable<?>> {
    final /* synthetic */ View $avatarView;

    public CanvasUtil$drawOvalClippedAvatarChild$orderedChildIndices$1(View r1) {
        this.$avatarView = r1;
        super(1);
    }

    public final Comparable<?> invoke(int r2) {
        return Float.valueOf(this.$avatarView.getChildAt(r2).getElevation());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke(((Number) r1).intValue());
    }
}

package com.bytedance.android.livesdk.interactivity.common.adjuster.logical;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"px2dp", BuildConfig.FLAVOR, "px", BuildConfig.FLAVOR, "density", "invoke"}, k = 3, mv = {1, 4, 3})
final class CommentLpHelper$handleNewHorizontalVideo$1 extends Lambda implements Function2<Integer, Float, Float> {
    public static final CommentLpHelper$handleNewHorizontalVideo$1 INSTANCE = null;

    static {
        INSTANCE = new CommentLpHelper$handleNewHorizontalVideo$1();
    }

    public CommentLpHelper$handleNewHorizontalVideo$1() {
        super(2);
    }

    public final float invoke(int r1, float r2) {
        return r1 / r2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return Float.valueOf(invoke(((Number) r1).intValue(), ((Number) r2).floatValue()));
    }
}

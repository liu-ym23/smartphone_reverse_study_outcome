package com.bytedance.ies.bullet.pool.util;

import android.view.ViewGroup;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", ST.IMPLICIT_ARG_NAME, "Landroid/view/ViewGroup;", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 48)
final class PoolUtilKt$removeParent$1 extends Lambda implements Function1<ViewGroup, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f5818a;

    public PoolUtilKt$removeParent$1(ViewGroup r5) {
        this.f5818a = r5;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewGroup r5) {
        ViewGroup r10 = r5;
        Intrinsics.checkNotNullParameter(r10, ST.IMPLICIT_ARG_NAME);
        r10.removeView(this.f5818a);
        return Unit.INSTANCE;
    }
}

package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.View;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "p1", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class MoreSectionProvider$MorePanelController$buttonAdapter$1$1 extends FunctionReferenceImpl implements Function1<View, Unit> {
    public MoreSectionProvider$MorePanelController$buttonAdapter$1$1(c1.a r8) {
        super(1, r8, c1.a.class, "dispatchClickEvent", "dispatchClickEvent(Landroid/view/View;)V", 0);
    }

    public final void invoke(View r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        ((c1.a) ((CallableReference) this).receiver).k.onClick(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((View) r1);
        return Unit.INSTANCE;
    }
}

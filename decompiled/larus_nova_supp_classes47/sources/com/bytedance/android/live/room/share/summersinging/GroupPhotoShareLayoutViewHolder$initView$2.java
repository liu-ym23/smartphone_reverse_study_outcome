package com.bytedance.android.live.room.share.summersinging;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class GroupPhotoShareLayoutViewHolder$initView$2 extends FunctionReferenceImpl implements Function1<View, Unit> {
    public GroupPhotoShareLayoutViewHolder$initView$2(l r8) {
        super(1, r8, l.class, "onShareWeixinClick", "onShareWeixinClick(Landroid/view/View;)V", 0);
    }

    public final void invoke(View r5) {
        l r0 = (l) ((CallableReference) this).receiver;
        int r1 = l.e;
        r0.getClass();
        if (r5 == null) goto L12;
        Context r6 = r5.getContext();
        if (r6 == null) goto L14;
        String r2 = s1.B(2131917213);
        if (puc.a.isInstalledApp(r6, "com.tencent.mm") == true) goto L10;
        f2.c(r2, 0);
        return;
    L10:
        l.a(r0, r6, new GroupPhotoShareLayoutViewHolder$tryShareToApp$1(r0, r6, "com.tencent.mm"));
        return;
    L14:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((View) r1);
        return Unit.INSTANCE;
    }
}

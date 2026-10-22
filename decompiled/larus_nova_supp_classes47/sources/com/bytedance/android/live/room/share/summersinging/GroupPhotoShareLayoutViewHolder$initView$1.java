package com.bytedance.android.live.room.share.summersinging;

import android.content.Context;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class GroupPhotoShareLayoutViewHolder$initView$1 extends FunctionReferenceImpl implements Function1<View, Unit> {
    public GroupPhotoShareLayoutViewHolder$initView$1(l r8) {
        super(1, r8, l.class, "onShareFriendClick", "onShareFriendClick(Landroid/view/View;)V", 0);
    }

    public final void invoke(View r3) {
        final l r0 = (l) ((CallableReference) this).receiver;
        int r1 = l.e;
        r0.getClass();
        if (r3 == null) goto L9;
        final Context r4 = r3.getContext();
        if (r4 == null) goto L10;
        l.a(r0, r4, new GroupPhotoShareLayoutViewHolder$onShareFriendClick$1(r0, r4));
        return;
    L10:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((View) r1);
        return Unit.INSTANCE;
    }
}

package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.MmEndWindowWebHelper", f = "MmEndWindowWebHelper.kt", i = {0, 0, 0, 0, 0}, l = {608}, m = "buildAvatarInfoArray", n = {"avatarArray", "endWindowInfo", "item", "avatarSize", "startTime"}, s = {"L$0", "L$1", "L$3", "I$0", "J$0"})
final class MmEndWindowWebHelper$buildAvatarInfoArray$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmEndWindowWebHelper this$0;

    public MmEndWindowWebHelper$buildAvatarInfoArray$1(MmEndWindowWebHelper r1, Continuation<? super MmEndWindowWebHelper$buildAvatarInfoArray$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MmEndWindowWebHelper.a(this.this$0, 0, this);
    }
}

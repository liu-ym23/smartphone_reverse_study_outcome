package com.bytedance.android.live.room.share.summersinging;

import android.content.Context;
import com.bytedance.android.live.core.utils.f2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class GroupPhotoShareLayoutViewHolder$tryShareToApp$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $packageStr;
    final /* synthetic */ l this$0;

    public GroupPhotoShareLayoutViewHolder$tryShareToApp$1(l r1, Context r2, String r3) {
        this.this$0 = r1;
        this.$context = r2;
        this.$packageStr = r3;
        super(1);
    }

    public final void invoke(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        f2.b(2131917215, 0);
        this.this$0.d.uy();
        puc.a.openInstalledApp(this.$context, this.$packageStr);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}

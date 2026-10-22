package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg;

import android.content.Context;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.LikeEggHelper;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bpea.cert.token.TokenCert;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lpy/k;", "imageModel", BuildConfig.FLAVOR, "index", BuildConfig.FLAVOR, "invoke", "(Lpy/k;I)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class LikeEggPSTopView$launchTemplatePreviewDialog$1 extends Lambda implements Function2<k, Integer, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ com.bytedance.android.livesdk.chatroom.likeegg.a $msg;
    final /* synthetic */ LikeEggPSTopView this$0;

    public LikeEggPSTopView$launchTemplatePreviewDialog$1(LikeEggPSTopView r1, com.bytedance.android.livesdk.chatroom.likeegg.a r2, Context r3) {
        this.this$0 = r1;
        this.$msg = r2;
        this.$context = r3;
        super(2);
    }

    public final void invoke(k r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "imageModel");
        LikeEggPSTopView.n(this.this$0, "saving template at index " + r5 + ", template photo: " + r4.getUrls());
        int r0 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.a;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.a(this.$msg, r5, "template");
        TokenCert r6 = LikeEggHelper.a;
        LikeEggHelper.e(this.$context, r4, this.this$0.o);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((k) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}

package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg;

import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {1, 4, 3})
public final class LikeEggPSTopView$launchImagePicker$1$retryAction$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $path;
    final /* synthetic */ String $templateId;
    final /* synthetic */ Ref.ObjectRef $textReplaceMap;
    final /* synthetic */ LikeEggPSTopView$launchImagePicker$1 this$0;

    public LikeEggPSTopView$launchImagePicker$1$retryAction$1(LikeEggPSTopView$launchImagePicker$1 r1, String r2, String r3, Ref.ObjectRef r4) {
        this.this$0 = r1;
        this.$templateId = r2;
        this.$path = r3;
        this.$textReplaceMap = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m866invoke() {
        LikeEggPSTopView.n(this.this$0.this$0, "start applying template to photo");
        r.k().c(this.$templateId, this.$path, (Map) this.$textReplaceMap.element, new AnonymousClass1(this), new AnonymousClass2(this));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m866invoke();
        return Unit.INSTANCE;
    }
}

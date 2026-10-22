package z92;

import com.bytedance.android.live.base.model.message.t3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PSMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$MessageModelType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.j;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends i {
    public final PublicScreenConfig$MessageModelType h;
    public PSMessageAction i;
    public final d j;
    public final t3 k;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
    public final IBaseUser f() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
    public final IPublicAreaCommon c() {
        return this.k.getOrInitPublicAreaCommon();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
    public final PSMessageAction a() {
        return this.i;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
    public final j<? extends i, ? extends PSMessageViewHolder> b() {
        return this.j;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
    public PublicScreenConfig$MessageModelType getType() {
        return this.h;
    }

    public a(t3 r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        this.k = r3;
        this.e = Long.valueOf(r3.getMessageId());
        this.f = r3.getMessageMethod();
        this.g = Long.valueOf(r3.getTimestamp());
        this.h = PublicScreenConfig$MessageModelType.HOVER_AREA;
        this.i = PSMessageAction.SYSTEM;
        this.j = d.b;
    }
}

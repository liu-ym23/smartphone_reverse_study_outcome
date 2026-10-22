package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"onConfirmChangeSticker", "", "currentSticker", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "newSticker", "invoke"}, k = 3, mv = {1, 4, 3})
final class AudienceStickerServiceWidget$onLoad$1$1 extends Lambda implements Function2<Sticker, Sticker, Unit> {
    final /* synthetic */ zg1.o $it;
    final /* synthetic */ Ref.ObjectRef $panel;

    public AudienceStickerServiceWidget$onLoad$1$1(Ref.ObjectRef r1, zg1.o r2) {
        this.$panel = r1;
        this.$it = r2;
        super(2);
    }

    public final void invoke(Sticker r3, Sticker r4) {
        Intrinsics.checkNotNullParameter(r4, "newSticker");
        List r0 = LiveEffectContext.h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate.Type.LINK).a().S((String) this.$panel.element, r3, r4);
        zg1.q r5 = this.$it.d;
        if (r5 == null) goto L6;
        zg1.q.a.a(r5, true);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Sticker) r1, (Sticker) r2);
        return Unit.INSTANCE;
    }
}

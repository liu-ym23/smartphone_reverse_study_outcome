package com.bytedance.android.live.room.share.jsbridge;

import com.bytedance.android.livehostapi.business.depend.share.LiveWebShareParams;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/room/api/screenrotation/rotate/g;", "", "", "invoke", "(Lcom/bytedance/android/live/room/api/screenrotation/rotate/g;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class ShareLiveMethod$shareDialog$2 extends Lambda implements Function1<com.bytedance.android.live.room.api.screenrotation.rotate.g<Object>, Unit> {
    final /* synthetic */ LiveWebShareParams $params;
    final /* synthetic */ ShareParams.Builder $shareParamsBuilder;
    final /* synthetic */ ShareLiveMethod this$0;

    /* JADX INFO: renamed from: com.bytedance.android.live.room.share.jsbridge.ShareLiveMethod$shareDialog$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/android/live/room/api/screenrotation/rotate/b;", "", "it", "", "invoke", "(Lcom/bytedance/android/live/room/api/screenrotation/rotate/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function1<com.bytedance.android.live.room.api.screenrotation.rotate.b<Object>, Unit> {
        final /* synthetic */ ShareLiveMethod$shareDialog$2 this$0;

        public AnonymousClass1(ShareLiveMethod$shareDialog$2 r1) {
            this.this$0 = r1;
            super(1);
        }

        public final void invoke(com.bytedance.android.live.room.api.screenrotation.rotate.b<Object> r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            r2.d(new C02171(this));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.live.room.api.screenrotation.rotate.b) r1);
            return Unit.INSTANCE;
        }
    }

    public ShareLiveMethod$shareDialog$2(ShareLiveMethod r1, LiveWebShareParams r2, ShareParams.Builder r3) {
        this.this$0 = r1;
        this.$params = r2;
        this.$shareParamsBuilder = r3;
        super(1);
    }

    public final void invoke(com.bytedance.android.live.room.api.screenrotation.rotate.g<Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        r2.d = new AnonymousClass1(this);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.live.room.api.screenrotation.rotate.g) r1);
        return Unit.INSTANCE;
    }
}

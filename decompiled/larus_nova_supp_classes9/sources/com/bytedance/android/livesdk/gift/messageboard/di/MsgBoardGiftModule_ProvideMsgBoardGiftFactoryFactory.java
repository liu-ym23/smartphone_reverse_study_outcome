package com.bytedance.android.livesdk.gift.messageboard.di;

import com.bytedance.android.livesdk.gift.platform.business.h;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import fz1.a;
import fz1.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class MsgBoardGiftModule_ProvideMsgBoardGiftFactoryFactory implements Factory<h.a> {
    private final b module;

    public h.a get() {
        return provideMsgBoardGiftFactory(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m42get() {
        return get();
    }

    public MsgBoardGiftModule_ProvideMsgBoardGiftFactoryFactory(b r1) {
        this.module = r1;
    }

    public static MsgBoardGiftModule_ProvideMsgBoardGiftFactoryFactory create(b r1) {
        return new MsgBoardGiftModule_ProvideMsgBoardGiftFactoryFactory(r1);
    }

    public static h.a provideMsgBoardGiftFactory(b r0) {
        r0.getClass();
        return (h.a) Preconditions.checkNotNullFromProvides(new a());
    }
}

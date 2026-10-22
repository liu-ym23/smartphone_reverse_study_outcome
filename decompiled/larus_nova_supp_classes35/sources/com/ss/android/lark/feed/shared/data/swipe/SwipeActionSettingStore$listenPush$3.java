package com.ss.android.lark.feed.shared.data.swipe;

import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "err", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class SwipeActionSettingStore$listenPush$3 extends Lambda implements Function1<Throwable, Unit> {
    public static final SwipeActionSettingStore$listenPush$3 INSTANCE = null;

    static {
        INSTANCE = new SwipeActionSettingStore$listenPush$3();
    }

    public SwipeActionSettingStore$listenPush$3() {
        super(1);
    }

    public final void invoke(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "err");
        Log.e("SwipeActionSettingStore", "get PUSH_FEED_ACTION_SETTING error", r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Throwable) r1);
        return Unit.INSTANCE;
    }
}

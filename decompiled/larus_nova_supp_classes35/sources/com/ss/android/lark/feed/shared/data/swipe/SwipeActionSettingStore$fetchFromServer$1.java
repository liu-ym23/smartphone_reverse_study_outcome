package com.ss.android.lark.feed.shared.data.swipe;

import com.bytedance.lark.pb.feed.v1.FeedSlideActionSetting;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/feed/shared/data/swipe/SwipeActionSettingStore$fetchFromServer$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/bytedance/lark/pb/feed/v1/FeedSlideActionSetting;", "onSuccess", BuildConfig.FLAVOR, Keys.API_RETURN_KEY_DATA, "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SwipeActionSettingStore$fetchFromServer$1 implements IGetDataCallback<FeedSlideActionSetting> {
    final /* synthetic */ a this$0;

    public SwipeActionSettingStore$fetchFromServer$1(a r1) {
        this.this$0 = r1;
    }

    public void onError(ErrorResult r3) {
        Intrinsics.checkNotNullParameter(r3, "err");
        Log.e("SwipeActionSettingStore", "fetchSlideAction error", r3);
        a.a(this.this$0, 0);
    }

    public void onSuccess(FeedSlideActionSetting r2) {
        if (r2 == null) goto L4;
        a.b(this.this$0, r2);
        return;
    L4:
        Log.e("SwipeActionSettingStore", "fetchSlideAction error, data is null.");
        a.a(this.this$0, 0);
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((FeedSlideActionSetting) r1);
    }
}

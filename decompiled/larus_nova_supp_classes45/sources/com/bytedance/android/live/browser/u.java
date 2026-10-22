package com.bytedance.android.live.browser;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.browser.webview.fragment.LiveAnnieFragment;
import com.bytedance.android.live.browser.webview.fragment.LiveAnnieXFragment;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.subjects.PublishSubject;
import kotlin.Deprecated;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface u {
    void a();

    String appendCommonParams(String r1);

    String appendFeedCommonParams(String r1, IRoom r2);

    @Deprecated(message = "废弃，主线直播更不要调用仅为saas，saas也不推荐")
    void b(Activity r1);

    LiveAnnieFragment c();

    @Deprecated(message = "废弃，主线直播更不要调用仅为saas，saas也不推荐")
    com.bytedance.android.live.browser.webview.fragment.i createBrowserFragment(Bundle r1);

    @Deprecated(message = "废弃，主线直播更不要调用仅为saas，saas也不推荐")
    com.bytedance.android.live.browser.webview.fragment.i createSimpleBrowserFragment(Bundle r1);

    void d();

    LiveAnnieXFragment e();

    boolean f(String r1);

    void g();

    r h(Context r1, PublishSubject r2, Fragment r3);

    u30.a i(Context r1, String r2);
}

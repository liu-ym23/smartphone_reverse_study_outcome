package com.larus.platform.model.video.business;

import com.larus.video.impl.douyin.DouYinVideoActivity;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import pr9.g;
import pr9.h;
import qr9.a;
import qr9.b;
import qr9.c;
import zp9.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u001aH\u0016J\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u000bH\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%H\u0016J\n\u0010&\u001a\u0004\u0018\u00010'H\u0016¨\u0006("}, d2 = {"Lcom/larus/platform/model/video/business/VideoFeedProviderNoop;", "Lcom/larus/platform/model/video/business/IVideoFeedProvider;", "<init>", "()V", "openFragment", "Lcom/larus/platform/model/video/sdkwrapper/feed/IOperateFeedFragment;", "videoFeedConfigure", "Lcom/larus/platform/model/video/business/VideoFeedConfigure;", "getPreLoader", "Lcom/larus/platform/model/video/sdkwrapper/preload/IPreloadVideoProvider;", "getLoadMoreAids", "", "loadMoreTimes", "", "callback", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomILoadMoreCallback;", "getTopPlayerController", "Lcom/larus/platform/model/video/sdkwrapper/preload/ICustomPlayerController;", "addGlobalPlayerListener", "listener", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomGlobalPlayerListener;", "removeGlobalPlayerListener", "addLoadMoreListener", "Lcom/larus/platform/model/video/sdkwrapper/feed/IGetAidsCallback;", "removeLoadMoreListener", "addSendEventListener", "Lcom/larus/platform/model/video/sdkwrapper/feed/ISendEventCallback;", "removeSendEventListener", "doSendEvent", "event", "", "params", "Lorg/json/JSONObject;", "init", "getBmfBitmapHandler", "Lcom/larus/platform/api/creation/IBitmapHandler;", "context", "Landroid/content/Context;", "getBmfVideoSRHelper", "Lcom/larus/platform/api/creation/IBmfVideoSRHelper;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class VideoFeedProviderNoop implements IVideoFeedProvider {
    public VideoFeedProviderNoop() {
    }

    public final void a(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "params");
    }

    public final void c(DouYinVideoActivity.e r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void e(g r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final k f() {
        return null;
    }

    public final void g(g r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final b getTopPlayerController() {
        return null;
    }

    public final void h(DouYinVideoActivity.e r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void init() {
    }

    public final c b() {
        return new a();
    }

    public final h i(VideoFeedConfigure r2) {
        Intrinsics.checkNotNullParameter(r2, "videoFeedConfigure");
        return new or9.b();
    }

    public final void d(int r2, l48.a r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        r3.a(false, CollectionsKt.emptyList());
    }
}

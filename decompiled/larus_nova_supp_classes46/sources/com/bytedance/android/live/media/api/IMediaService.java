package com.bytedance.android.live.media.api;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.live.utility.ServiceLookup;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ServiceLookup("com.bytedance.android.live.media.impl.MediaService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\u000bH&J\b\u0010\u000f\u001a\u00020\u000bH&J\b\u0010\u0010\u001a\u00020\u000bH&J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H&J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&J\u001a\u0010\u0017\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H&¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/media/api/IMediaService;", "Lcom/bytedance/android/live/base/IService;", "createView", "Landroid/view/View;", "context", "Landroid/content/Context;", "isPortrait", "", "getCloseBtnView", "mMediaView", "getMediaAnchorResId", "", "getMediaDetailMaskResId", "getMediaIntroductionResId", "getMediaMoveDownCloseResId", "getMediaTitleResId", "getMediaWatchNumberResId", "hideMediaIntroduction", "", "view", "initMediaView", "manager", "Lcom/bytedance/android/live/core/tetris/widgets/RecyclableWidgetManager;", "prepareReplayWidget", "setInteractionVisibility", "container", "visible", "immediately", "livemedia-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMediaService extends IService {
    View createView(Context r1, boolean r2);

    View getCloseBtnView(View r1);

    int getMediaAnchorResId();

    int getMediaDetailMaskResId();

    int getMediaIntroductionResId();

    int getMediaMoveDownCloseResId();

    int getMediaTitleResId();

    int getMediaWatchNumberResId();

    void hideMediaIntroduction(View r1);

    void initMediaView(View r1, RecyclableWidgetManager r2);

    void prepareReplayWidget(View r1, boolean r2);

    void setInteractionVisibility(View r1, boolean r2, boolean r3);
}

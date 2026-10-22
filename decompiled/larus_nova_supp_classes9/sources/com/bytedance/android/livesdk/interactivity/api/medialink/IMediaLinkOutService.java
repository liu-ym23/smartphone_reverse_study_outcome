package com.bytedance.android.livesdk.interactivity.api.medialink;

import android.view.ViewGroup;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;
import x32.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.medialink.service.MediaLinkOutServiceImp")
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\tH&J\b\u0010\u0012\u001a\u00020\u000bH&J\b\u0010\u0013\u001a\u00020\u000bH&J\b\u0010\u0014\u001a\u00020\u0010H&J\"\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H&¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/medialink/IMediaLinkOutService;", "Lcom/bytedance/android/live/base/IService;", BuildConfig.FLAVOR, "factory", "Lx32/b;", "switchContext", "Lcom/bytedance/ies/sdk/widgets/Widget;", "createMediaMultiAnchorWidget", "createMediaMultiAudienceWidget", BuildConfig.FLAVOR, "uid", BuildConfig.FLAVOR, "isUserInMediaLink", BuildConfig.FLAVOR, "scene", "reqSrc", BuildConfig.FLAVOR, "finishMediaAnchorLink", "blockDigg", "isMediaLinkOn", "onClickLinkIcon", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "Lcom/bytedance/android/livesdk/interactivity/api/medialink/BaseMediaLinkControlWidget$a;", "callback", "Landroid/view/ViewGroup;", "parentView", "Lcom/bytedance/android/livesdk/interactivity/api/medialink/BaseMediaLinkControlWidget;", "createRevMediaControlWidget", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMediaLinkOutService extends IService {
    boolean blockDigg();

    Widget createMediaMultiAnchorWidget(Object r1, b r2);

    Widget createMediaMultiAudienceWidget(b r1);

    BaseMediaLinkControlWidget createRevMediaControlWidget(Room r1, BaseMediaLinkControlWidget.a r2, ViewGroup r3);

    void finishMediaAnchorLink(int r1, String r2);

    boolean isMediaLinkOn();

    boolean isUserInMediaLink(String r1);

    void onClickLinkIcon();
}

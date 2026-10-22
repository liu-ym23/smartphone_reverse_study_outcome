package com.bytedance.android.live.room.api;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.base.model.user.f;
import com.bytedance.android.live.browser.jsbridge.base.ShareLiveResultModel;
import com.bytedance.android.live.room.api.share.ILiveMiddlewareShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livehostapi.business.depend.share.ICommonLiveSharePackage;
import com.bytedance.android.livehostapi.business.depend.share.IShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.IVSPosterClickListener;
import com.bytedance.android.livehostapi.business.depend.share.LiveWebShareParams;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.business.shareinter.ILiveIMSharePostscriptComponent;
import com.bytedance.android.livehostapi.business.shareinter.LiveIMSharePostscriptConfig;
import com.bytedance.android.livehostapi.business.shareinter.LiveIMShareTitleWithConListConfig;
import com.bytedance.android.livehostapi.business.shareinter.sharelinkpanel.IInRoomMorePanelShareLinkViewSlotDelegate;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.g;
import i81.a;
import i81.b;
import i81.c;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;
import w20.se;
import y6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.live.room.share.LiveShareService")
@Metadata(d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J2\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\rH&J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u0004H&J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0014H&J6\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0014\u0010\u001d\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00160\u001cH&J\u001c\u0010!\u001a\u00020 2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H&J\u0014\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0\"H&J\u0014\u0010(\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%H&J\u001c\u0010,\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020'0%2\u0006\u0010*\u001a\u00020)H&J\u001c\u0010.\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%2\u0006\u0010-\u001a\u00020)H&J\u0014\u00101\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000%H&J\u001e\u00106\u001a\u0002052\f\u00104\u001a\b\u0012\u0004\u0012\u000203022\u0006\u0010-\u001a\u00020)H&J\u001c\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004082\u0006\u00107\u001a\u00020\rH&J$\u0010<\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u00042\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000408H&J(\u0010C\u001a\u0004\u0018\u00010B2\b\u0010=\u001a\u0004\u0018\u0001032\b\u0010?\u001a\u0004\u0018\u00010>2\b\u0010A\u001a\u0004\u0018\u00010@H&J\u001c\u0010E\u001a\u00020 2\b\u0010=\u001a\u0004\u0018\u0001032\b\u0010D\u001a\u0004\u0018\u00010\u0004H&J\b\u0010F\u001a\u00020 H&J\u0016\u0010H\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0004\u0018\u00010GH&J\u0010\u0010K\u001a\u00020\u00162\u0006\u0010J\u001a\u00020IH&J\u0010\u0010N\u001a\u00020M2\u0006\u0010J\u001a\u00020LH&J&\u0010Q\u001a\u00020\u00162\b\u0010O\u001a\u0004\u0018\u0001032\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000408H&J\b\u0010R\u001a\u00020 H&J\u0010\u0010S\u001a\u00020B2\u0006\u0010R\u001a\u00020 H&J\u0012\u0010U\u001a\u00020 2\b\u0010T\u001a\u0004\u0018\u00010'H&J\n\u0010W\u001a\u0004\u0018\u00010VH&J>\u0010a\u001a\u0004\u0018\u00010B2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020X2\u0006\u0010[\u001a\u00020Z2\u0006\u0010]\u001a\u00020\\2\b\u0010T\u001a\u0004\u0018\u00010^2\b\u0010`\u001a\u0004\u0018\u00010_H&¨\u0006b"}, d2 = {"Lcom/bytedance/android/live/room/api/ILiveShareService;", "Lcom/bytedance/android/live/room/api/share/ILiveMiddlewareShareService;", "Li81/a;", "liveShareParams", "", "sourcePage", "Lcom/bytedance/android/live/room/api/share/model/LiveShareType;", "shareType", "Lcom/bytedance/android/livehostapi/business/depend/share/IShareCallback;", "shareCallback", "Lio/reactivex/Single;", "Li81/b;", "share", "Lcom/bytedance/android/live/base/model/user/f;", "contactUser", "getIMContactConversationId", "conversationId", "getContactUserObjById", "Landroid/app/Activity;", "activity", "Lcom/bytedance/android/livehostapi/business/depend/share/ShareParams;", "shareParams", "", "promotion", "", "schemaType", "objectId", "editionUid", "Lkotlin/Function1;", "callback", "getQrCodeFromUrl", "hostShareType", "", "isShareAvailable", "Lcom/bytedance/ies/web/jsbridge2/g;", "Lorg/json/JSONObject;", "getShareScreenMethod", "Lcom/bytedance/ies/web/jsbridge2/f;", "Lcom/bytedance/android/livehostapi/business/depend/share/LiveWebShareParams;", "", "getShareFullParamsMethod", "Ly6/d;", "shareInfoListener", "Li81/c;", "getShareInfoMethod", "provider", "getSharePanelMethod", "Lw20/se;", "Lcom/bytedance/android/live/browser/jsbridge/base/ShareLiveResultModel;", "getShareLiveMethod", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "mContextRef", "Ln56/c;", "getShareMethod", "contact", "", "getToUserConversationId", "event", "extra", "reportLiveShareEvent", "context", "Lcom/bytedance/android/live/base/model/data/f;", "groupPhotoDetail", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lio/reactivex/disposables/Disposable;", "showGroupPhotoDialog", "packageName", "openInstallApp", "enableFilterBusinessAccount", "Lkotlin/Pair;", "getSharePanelMoreText", "Lcom/bytedance/android/livehostapi/business/shareinter/LiveIMShareTitleWithConListConfig;", "config", "addShareContactsListComponent", "Lcom/bytedance/android/livehostapi/business/shareinter/LiveIMSharePostscriptConfig;", "Lcom/bytedance/android/livehostapi/business/shareinter/ILiveIMSharePostscriptComponent;", "addSharePostscriptComponent", "ctx", "map", "cacheMob", "canBeFoundByShare", "changeCanBeFoundByShare", "liveSharePackage", "hasLocalLifeShareCoupon", "Lcom/bytedance/android/livehostapi/business/shareinter/sharelinkpanel/IInRoomMorePanelShareLinkViewSlotDelegate;", "getLocalLifeShareCouponWidget", "Landroid/view/ViewGroup;", "posterContainer", "Landroid/app/Dialog;", "dialog", "Landroidx/fragment/app/DialogFragment;", "dialogFragment", "Lcom/bytedance/android/livehostapi/business/depend/share/ICommonLiveSharePackage;", "Lcom/bytedance/android/livehostapi/business/depend/share/IVSPosterClickListener;", "vsPosterClickListener", "initVSPoster", "experience-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveShareService extends ILiveMiddlewareShareService {
    void addShareContactsListComponent(LiveIMShareTitleWithConListConfig r1);

    ILiveIMSharePostscriptComponent addSharePostscriptComponent(LiveIMSharePostscriptConfig r1);

    void cacheMob(Context r1, Map<String, String> r2);

    boolean canBeFoundByShare();

    Disposable changeCanBeFoundByShare(boolean r1);

    boolean enableFilterBusinessAccount();

    f getContactUserObjById(String r1);

    String getIMContactConversationId(f r1);

    IInRoomMorePanelShareLinkViewSlotDelegate getLocalLifeShareCouponWidget();

    void getQrCodeFromUrl(int r1, String r2, String r3, Function1<? super String, Unit> r4);

    com.bytedance.ies.web.jsbridge2.f<LiveWebShareParams, Object> getShareFullParamsMethod();

    com.bytedance.ies.web.jsbridge2.f<c, Object> getShareInfoMethod(d r1);

    com.bytedance.ies.web.jsbridge2.f<se, ShareLiveResultModel> getShareLiveMethod();

    n56.c getShareMethod(WeakReference<Context> r1, d r2);

    com.bytedance.ies.web.jsbridge2.f<LiveWebShareParams, Object> getSharePanelMethod(d r1);

    Pair<Boolean, String> getSharePanelMoreText();

    g<JSONObject, JSONObject> getShareScreenMethod();

    Map<String, String> getToUserConversationId(f r1);

    boolean hasLocalLifeShareCoupon(Object r1);

    Disposable initVSPoster(Activity r1, ViewGroup r2, Dialog r3, DialogFragment r4, ICommonLiveSharePackage r5, IVSPosterClickListener r6);

    boolean isShareAvailable(Activity r1, String r2);

    boolean openInstallApp(Context r1, String r2);

    void promotion(Activity r1, ShareParams r2);

    void reportLiveShareEvent(String r1, Map<String, String> r2);

    @Override // com.bytedance.android.live.room.api.share.ILiveMiddlewareShareService
    Single<b> share(a r1, String r2, LiveShareType r3, IShareCallback r4);

    Disposable showGroupPhotoDialog(Context r1, com.bytedance.android.live.base.model.data.f r2, DataCenter r3);
}

package com.bytedance.android.live.room.share;

import am2.x;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.browser.jsbridge.base.ShareLiveResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.trace.e;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.live.room.share.jsbridge.ShareLiveMethod;
import com.bytedance.android.live.room.share.jsbridge.i;
import com.bytedance.android.live.room.share.jsbridge.k;
import com.bytedance.android.live.room.share.jsbridge.q;
import com.bytedance.android.live.room.share.summersinging.h;
import com.bytedance.android.live.room.share.summersinging.j;
import com.bytedance.android.live.room.share.summersinging.p;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.bytedance.android.livehostapi.business.depend.share.ICommonLiveSharePackage;
import com.bytedance.android.livehostapi.business.depend.share.IShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.IVSPosterClickListener;
import com.bytedance.android.livehostapi.business.depend.share.LiveWebShareParams;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback;
import com.bytedance.android.livehostapi.business.shareinter.ILiveIMSharePostscriptComponent;
import com.bytedance.android.livehostapi.business.shareinter.LiveIMSharePostscriptConfig;
import com.bytedance.android.livehostapi.business.shareinter.LiveIMShareTitleWithConListConfig;
import com.bytedance.android.livehostapi.business.shareinter.sharelinkpanel.IInRoomMorePanelShareLinkViewSlotDelegate;
import com.bytedance.android.livesdk.chatroom.c1;
import com.bytedance.android.livesdk.chatroom.d1;
import com.bytedance.android.livesdk.chatroom.e1;
import com.bytedance.android.livesdk.chatroom.f1;
import com.bytedance.android.livesdk.chatroom.j0;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.config.vr0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.badger.collect.impl.BuildConfig;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.api.appjump.AppJumpEntry;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.SingleSubject;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import w20.se;
import y6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0094\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 {2\u00020\u0001:\u0001|B\u0007¢\u0006\u0004\by\u0010zJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J2\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u001a\u0010\u001c\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J.\u0010\"\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\n2\u0014\u0010!\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00060 H\u0016J6\u0010$\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\u0014\u0010!\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00060 H\u0016J\u001c\u0010'\u001a\u00020&2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010%\u001a\u0004\u0018\u00010\nH\u0016J\u0014\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0(H\u0016J\u0014\u0010.\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+H\u0016J\u001c\u00102\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020-0+2\u0006\u00100\u001a\u00020/H\u0016J\u001c\u00104\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+2\u0006\u00103\u001a\u00020/H\u0016J\u001e\u00109\u001a\u0002082\f\u00107\u001a\b\u0012\u0004\u0012\u000206052\u0006\u00103\u001a\u00020/H\u0016J\u001c\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0;2\u0006\u0010:\u001a\u00020\u0013H\u0016J$\u0010?\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\n2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0;H\u0016J\"\u0010A\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\n2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0;J(\u0010H\u001a\u0004\u0018\u00010G2\b\u0010B\u001a\u0004\u0018\u0001062\b\u0010D\u001a\u0004\u0018\u00010C2\b\u0010F\u001a\u0004\u0018\u00010EH\u0016J\u0014\u0010K\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020J0+H\u0016J\u001c\u0010M\u001a\u00020&2\b\u0010B\u001a\u0004\u0018\u0001062\b\u0010L\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0;2\u0006\u0010N\u001a\u00020\nH\u0016J\b\u0010P\u001a\u00020&H\u0016J\u0016\u0010R\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\n\u0018\u00010QH\u0016J\u0010\u0010U\u001a\u00020\u00062\u0006\u0010T\u001a\u00020SH\u0016J\u0010\u0010X\u001a\u00020W2\u0006\u0010T\u001a\u00020VH\u0016J&\u0010[\u001a\u00020\u00062\b\u0010Y\u001a\u0004\u0018\u0001062\u0012\u0010Z\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0;H\u0016J\b\u0010\\\u001a\u00020&H\u0016J\u0010\u0010]\u001a\u00020G2\u0006\u0010\\\u001a\u00020&H\u0016J\u0012\u0010_\u001a\u00020&2\b\u0010^\u001a\u0004\u0018\u00010-H\u0016J\n\u0010a\u001a\u0004\u0018\u00010`H\u0016J>\u0010k\u001a\u0004\u0018\u00010G2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010c\u001a\u00020b2\u0006\u0010e\u001a\u00020d2\u0006\u0010g\u001a\u00020f2\b\u0010^\u001a\u0004\u0018\u00010h2\b\u0010j\u001a\u0004\u0018\u00010iH\u0016R\u001e\u0010m\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010l8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u001b\u0010t\u001a\u00020o8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010sR\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010uR\u0014\u0010w\u001a\u00020v8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010x¨\u0006}"}, d2 = {"Lcom/bytedance/android/live/room/share/LiveShareService;", "Lcom/bytedance/android/live/room/api/ILiveShareService;", "Li81/a;", "liveShareParams", "Lcom/bytedance/android/livehostapi/business/depend/share/IShareCallback;", "shareCallback", "", "showShareDialog", "doDouyinShowShareDialog", BuildConfig.BUILD_TYPE, "", "sourcePage", "Lcom/bytedance/android/live/room/api/share/model/LiveShareType;", "shareType", "Lio/reactivex/Single;", "Li81/b;", "share", "url", "getShortUrl", "Lcom/bytedance/android/live/base/model/user/f;", "contactUser", "getIMContactConversationId", "conversationId", "getContactUserObjById", "Landroid/app/Activity;", "activity", "Lcom/bytedance/android/livehostapi/business/depend/share/ShareParams;", "shareParams", "promotion", "", "schemaType", "objectId", "Lkotlin/Function1;", "callback", "getQrCodeInfo", "editionUid", "getQrCodeFromUrl", "hostShareType", "", "isShareAvailable", "Lcom/bytedance/ies/web/jsbridge2/g;", "Lorg/json/JSONObject;", "getShareScreenMethod", "Lcom/bytedance/ies/web/jsbridge2/f;", "Lcom/bytedance/android/livehostapi/business/depend/share/LiveWebShareParams;", "", "getShareFullParamsMethod", "Ly6/d;", "shareInfoListener", "Li81/c;", "getShareInfoMethod", "provider", "getSharePanelMethod", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "mContextRef", "Ln56/c;", "getShareMethod", "contact", "", "getToUserConversationId", "event", "extra", "reportLiveShareEvent", "extraMap", "logTrace", "context", "Lcom/bytedance/android/live/base/model/data/f;", "groupPhotoDetail", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lio/reactivex/disposables/Disposable;", "showGroupPhotoDialog", "Lw20/se;", "Lcom/bytedance/android/live/browser/jsbridge/base/ShareLiveResultModel;", "getShareLiveMethod", "packageName", "openInstallApp", "shareInfo", "getLocalLifeShareParams", "enableFilterBusinessAccount", "Lkotlin/Pair;", "getSharePanelMoreText", "Lcom/bytedance/android/livehostapi/business/shareinter/LiveIMShareTitleWithConListConfig;", "config", "addShareContactsListComponent", "Lcom/bytedance/android/livehostapi/business/shareinter/LiveIMSharePostscriptConfig;", "Lcom/bytedance/android/livehostapi/business/shareinter/ILiveIMSharePostscriptComponent;", "addSharePostscriptComponent", "ctx", "map", "cacheMob", "canBeFoundByShare", "changeCanBeFoundByShare", "liveSharePackage", "hasLocalLifeShareCoupon", "Lcom/bytedance/android/livehostapi/business/shareinter/sharelinkpanel/IInRoomMorePanelShareLinkViewSlotDelegate;", "getLocalLifeShareCouponWidget", "Landroid/view/ViewGroup;", "posterContainer", "Landroid/app/Dialog;", "dialog", "Landroidx/fragment/app/DialogFragment;", "dialogFragment", "Lcom/bytedance/android/livehostapi/business/depend/share/ICommonLiveSharePackage;", "Lcom/bytedance/android/livehostapi/business/depend/share/IVSPosterClickListener;", "vsPosterClickListener", "initVSPoster", "Lio/reactivex/subjects/SingleSubject;", "liveShareResult", "Lio/reactivex/subjects/SingleSubject;", "Lcom/bytedance/android/livehostapi/business/IHostShare;", "iHostShare$delegate", "Lkotlin/Lazy;", "getIHostShare", "()Lcom/bytedance/android/livehostapi/business/IHostShare;", "iHostShare", "Lcom/bytedance/android/livehostapi/business/depend/share/IShareCallback;", "Lcom/bytedance/android/livehostapi/business/IHostShare$ValueCallback;", "valueCallback", "Lcom/bytedance/android/livehostapi/business/IHostShare$ValueCallback;", "<init>", "()V", "Companion", "a", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveShareService implements ILiveShareService {
    public static final a Companion = null;
    public static final String TAG = "LiveShareService";
    private final IShareCallback callback;
    private final Lazy iHostShare$delegate;
    private SingleSubject<i81.b> liveShareResult;
    private final IHostShare.ValueCallback valueCallback;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends SimpleShareCallback {
        public final /* synthetic */ LiveShareService a;

        public b(LiveShareService r1) {
            this.a = r1;
        }

        public final void onFail(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "throwable");
            if (LiveShareService.access$getLiveShareResult$p(this.a) == null) goto L9;
            SingleSubject r0 = LiveShareService.access$getLiveShareResult$p(this.a);
            if (r0 == null) goto L7;
            r0.onError(r2);
        L7:
            LiveShareService.access$release(this.a);
            return;
        }

        public final void onSuccess(String r2, String r3) {
            if (LiveShareService.access$getLiveShareResult$p(this.a) == null) goto L9;
            SingleSubject r4 = LiveShareService.access$getLiveShareResult$p(this.a);
            if (r4 == null) goto L7;
            r4.onSuccess(new i81.b(null, null));
        L7:
            LiveShareService.access$release(this.a);
            return;
        }

        public final void onSuccessWithExtra(String r2, String r3, Map<String, List<String>> r4) {
            if (LiveShareService.access$getLiveShareResult$p(this.a) == null) goto L9;
            SingleSubject r5 = LiveShareService.access$getLiveShareResult$p(this.a);
            if (r5 == null) goto L7;
            r5.onSuccess(new i81.b(null, r4));
        L7:
            LiveShareService.access$release(this.a);
            return;
        }
    }

    public static final class c implements IHostShare.ValueCallback {
        public final /* synthetic */ LiveShareService a;

        public c(LiveShareService r1) {
            this.a = r1;
        }

        public final void onFailed(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "throwable");
            if (LiveShareService.access$getLiveShareResult$p(this.a) == null) goto L9;
            SingleSubject r0 = LiveShareService.access$getLiveShareResult$p(this.a);
            if (r0 == null) goto L7;
            r0.onError(r2);
        L7:
            LiveShareService.access$release(this.a);
            return;
        }

        public final void onSucceed(String r4) {
            if (LiveShareService.access$getLiveShareResult$p(this.a) == null) goto L9;
            SingleSubject r0 = LiveShareService.access$getLiveShareResult$p(this.a);
            if (r0 == null) goto L7;
            r0.onSuccess(new i81.b(r4, null));
        L7:
            LiveShareService.access$release(this.a);
            return;
        }
    }

    static {
        Companion = new a();
    }

    private final IHostShare getIHostShare() {
        return (IHostShare) this.iHostShare$delegate.getValue();
    }

    private final void release() {
        this.liveShareResult = null;
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public f<LiveWebShareParams, Object> getShareFullParamsMethod() {
        return new com.bytedance.android.live.room.share.jsbridge.b();
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public f<se, ShareLiveResultModel> getShareLiveMethod() {
        return new ShareLiveMethod();
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public g<JSONObject, JSONObject> getShareScreenMethod() {
        return new q();
    }

    public LiveShareService() {
        this.iHostShare$delegate = LazyKt.lazy(LiveShareService$iHostShare$2.INSTANCE);
        this.callback = new b(this);
        this.valueCallback = new c(this);
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public boolean canBeFoundByShare() {
        return getIHostShare().canBeFoundByShare();
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public boolean enableFilterBusinessAccount() {
        return getIHostShare().enableFilterBusinessAccount();
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public IInRoomMorePanelShareLinkViewSlotDelegate getLocalLifeShareCouponWidget() {
        return getIHostShare().getLocalLifeShareCouponWidget();
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public Pair<Boolean, String> getSharePanelMoreText() {
        return getIHostShare().getSharePanelMoreText();
    }

    public static final /* synthetic */ IShareCallback access$getCallback$p(LiveShareService r0) {
        return r0.callback;
    }

    public static final /* synthetic */ IHostShare access$getIHostShare$p(LiveShareService r0) {
        return r0.getIHostShare();
    }

    public static final /* synthetic */ SingleSubject access$getLiveShareResult$p(LiveShareService r0) {
        return r0.liveShareResult;
    }

    public static final /* synthetic */ void access$release(LiveShareService r0) {
        r0.release();
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public void addShareContactsListComponent(LiveIMShareTitleWithConListConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        getIHostShare().addShareContactsListComponent(r2);
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public ILiveIMSharePostscriptComponent addSharePostscriptComponent(LiveIMSharePostscriptConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        return getIHostShare().addSharePostscriptComponent(r2);
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public Disposable changeCanBeFoundByShare(boolean r2) {
        return getIHostShare().changeCanBeFoundByShare(r2);
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public com.bytedance.android.live.base.model.user.f getContactUserObjById(String r2) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        return getIHostShare().getContactUserById(r2);
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public String getIMContactConversationId(com.bytedance.android.live.base.model.user.f r3) {
        Intrinsics.checkNotNullParameter(r3, "contactUser");
        StringBuilder r0 = new StringBuilder("getIMContactConversationId: ");
        int r1 = com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.q.a;
        r3.getClass();
        r0.append(com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.q.a("ContactUser{mBase=null, mType=0, isStickTop=false, mDisplayName='null', mDisplayAvatar=null, mUidString='null'}"));
        ALogger.i(TAG, r0.toString());
        return getIHostShare().getIMContactConversationId(r3);
    }

    @Override // com.bytedance.android.live.room.api.share.ILiveMiddlewareShareService
    public Map<String, String> getLocalLifeShareParams(String r7) {
        Intrinsics.checkNotNullParameter(r7, "shareInfo");
        LinkedHashMap r1 = new LinkedHashMap();
        c1 r8 = (c1) GsonHelper.get().fromJson(r7, c1.class);     // Catch: Exception -> L31
        if (r8 != null) goto L6;
        return r1;
    L6:
        d1 r9 = r8.a();     // Catch: Exception -> L31
        if (r9 != null) goto L9;
        return r1;
    L9:
        String r10 = r9.a();     // Catch: Exception -> L31
        if (TextUtils.isEmpty(r10) == false) goto L12;
        return r1;
    L12:
        e1 r12 = (e1) GsonHelper.get().fromJson(r10, e1.class);     // Catch: Exception -> L31
        if (r12 != null) goto L15;
        return r1;
    L15:
        f1 r13 = r12.a();     // Catch: Exception -> L31
        if (r13 != null) goto L18;
        return r1;
    L18:
        String r2 = r13.b();     // Catch: Exception -> L31
        String r3 = "";
        if (r2 != null) goto L22;
        r2 = "";
    L22:
        j0 r4 = r13.a();     // Catch: Exception -> L31
        if (r4 != null) goto L25;
        return r1;
    L25:
        String r5 = r4.a();     // Catch: Exception -> L31
        if (r5 == null) goto L29;
        r3 = r5;
    L29:
        String r14 = String.valueOf(r13.c());     // Catch: Exception -> L31
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L31
        r6.put("play_share_id", r2);     // Catch: Exception -> L31
        r6.put("share_task_fromuser_status", r14);     // Catch: Exception -> L31
        r1.put("share_task_fromuser_info", r6.toString());     // Catch: Exception -> L31
        r1.put("play_id", r3);     // Catch: Exception -> L31
        r1.put("play_share_id", r2);     // Catch: Exception -> L31
        r1.put("share_module_status", r14);     // Catch: Exception -> L31
    L30:
        return r1;
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public f<i81.c, Object> getShareInfoMethod(d r2) {
        Intrinsics.checkNotNullParameter(r2, "shareInfoListener");
        return new com.bytedance.android.live.room.share.jsbridge.d(r2);
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public f<LiveWebShareParams, Object> getSharePanelMethod(d r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        return new k(r2);
    }

    @Override // com.bytedance.android.live.room.api.share.ILiveMiddlewareShareService
    public Single<i81.b> getShortUrl(String r3) {
        Intrinsics.checkNotNullParameter(r3, "url");
        ALogger.i(TAG, "getShortUrl: " + r3);
        getIHostShare().getShortUrl(r3, this.valueCallback);
        SingleSubject<i81.b> r4 = SingleSubject.create();
        this.liveShareResult = r4;
        return r4;
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public Map<String, String> getToUserConversationId(com.bytedance.android.live.base.model.user.f r2) {
        Intrinsics.checkNotNullParameter(r2, "contact");
        return getIHostShare().getToUserConversationId(r2);
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public boolean hasLocalLifeShareCoupon(Object r2) {
        return getIHostShare().hasLocalLifeShareCoupon(r2);
    }

    public static final /* synthetic */ void access$setLiveShareResult$p(LiveShareService r0, SingleSubject r1) {
        r0.liveShareResult = r1;
    }

    private final void doDouyinShowShareDialog(i81.a r3, IShareCallback r4) {
        IHostShare r0 = getIHostShare();
        Activity r1 = r3.getActivity();
        ShareParams r5 = r3.d;
        if (r4 != null) goto L5;
        r4 = this.callback;
    L5:
        r0.showShareDialog(r1, r5, r4);
    }

    private final void showShareDialog(i81.a r3, IShareCallback r4) {
        IHostShare r0 = getIHostShare();
        Activity r1 = r3.getActivity();
        ShareParams r5 = r3.d;
        if (r4 != null) goto L5;
        r4 = this.callback;
    L5:
        r0.showNativeShareDialog(r1, r5, r4);
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public void cacheMob(Context r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "map");
        getIHostShare().cacheMob(r2, r3);
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public n56.c getShareMethod(WeakReference<Context> r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "mContextRef");
        Intrinsics.checkNotNullParameter(r3, "provider");
        return new i(r2, r3);
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public boolean isShareAvailable(Activity r3, String r4) {
        ALogger.i(TAG, "isShareAvailable \n hostShareType: " + r4);
        return getIHostShare().isShareAvailable(r4, r3);
    }

    public final void logTrace(String r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r4, "event");
        Intrinsics.checkNotNullParameter(r5, "extraMap");
        Room r0 = ((IRoomService) jc1.k.n(IRoomService.class)).getCurrentRoomFromRoomContext();
        int r1 = e.m;
        e.a r6 = e.b.a(r4, "live_share");
        r6.c = "webcast_client_community";
        com.bytedance.android.livesdk.user.f r2 = jc1.k.n(IUserService.class).user();
        String r3 = null;
        if (r2 == null) goto L5;
        String r7 = r2.n();
    L6:
        r6.g = r7;
        if (r0 == null) goto L9;
        String r8 = r0.getOwnerUserIdString();
    L10:
        r6.f = r8;
        if (r0 == null) goto L13;
        String r9 = r0.getIdStr();
    L14:
        r6.e = r9;
        com.bytedance.android.livesdk.user.f r10 = jc1.k.n(IUserService.class).user();
        if (r10 == null) goto L17;
        r3 = r10.n();
    L17:
        r6.a = r3;
        e r12 = r6.a();
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L20
        BaseMonitor.add(r13, "message", r5.toString());     // Catch: Exception -> L20
        com.bytedance.android.live.core.monitor.trace.c.b(r12, r13);     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        ALogger.e(TAG, "IllegalArgumentException error: " + e.toString());
        return;
    L13:
        r9 = null;
        goto L14
    L9:
        r8 = null;
        goto L10
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public boolean openInstallApp(Context r3, String r4) {
        int r0 = com.bytedance.android.live.room.share.util.a.a;
        Intent r1 = null;
        if (r3 != null) goto L21;
        PackageManager r2 = null;
    L8:
        if (r2 == null) goto L12;
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        r1 = r2.getLaunchIntentForPackage(r4);     // Catch: Exception -> L5
    L12:
        if (r1 == null) goto L14;
        r1.addFlags(268435456);     // Catch: Exception -> L5
    L14:
        if (r1 == null) goto L19;
        if (r3 == null) goto L19;
        AppJumpEntry.c(r3, r1, TokenCert.Companion.with("bpea-screen_share_open_third_app"));     // Catch: Exception -> L5
    L5:
        e = move-exception;
        ALogger.e("LiveShareHelper", e.getMessage());
        return false;
    L19:
        return true;
    L21:
        r2 = r3.getPackageManager();     // Catch: Exception -> L5
        goto L8
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public void promotion(Activity r3, ShareParams r4) {
        Intrinsics.checkNotNullParameter(r4, "shareParams");
        StringBuilder r0 = new StringBuilder("promotion: ");
        int r1 = com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.q.a;
        r0.append(com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.q.a(r4.toString()));
        ALogger.i(TAG, r0.toString());
        getIHostShare().promotion(r3, r4);
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public void reportLiveShareEvent(String r5, Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r5, "event");
        Intrinsics.checkNotNullParameter(r6, "extra");
        u.l().sendLog(r5, r6, new Object[]{x.class, Room.class});
        logTrace(r5, r6);
    }

    public static final /* synthetic */ void access$showShareDialog(LiveShareService r0, i81.a r1, IShareCallback r2) {
        r0.showShareDialog(r1, r2);
    }

    @Override // com.bytedance.android.live.room.api.share.ILiveMiddlewareShareService
    public void getQrCodeInfo(int r3, String r4, Function1<? super String, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "objectId");
        Intrinsics.checkNotNullParameter(r5, "callback");
        ALogger.i(TAG, "getQrCodeInfo \n schemaType: " + r3 + " \n objectId: " + r4);
        getIHostShare().getQrCodeInfo(r3, r4, r5);
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public Disposable showGroupPhotoDialog(Context r6, com.bytedance.android.live.base.model.data.f r7, DataCenter r8) {
        ALogger.i(TAG, "open GroupPhotoDialogFragment");
        if (r7 != null) goto L6;
        ALogger.e(TAG, "GroupPhotoJumpDetail is null");
        return null;
    L6:
        FragmentActivity r9 = ContextUtil.contextToFragmentActivity(r6);
        if (r9 == null) goto L9;
        FragmentManager r10 = r9.getSupportFragmentManager();
    L10:
        if (r10 != null) goto L15;
        FragmentActivity r12 = ContextUtil.contextToFragmentActivity(com.bytedance.android.live.core.utils.a.d());
        if (r12 == null) goto L14;
        r10 = r12.getSupportFragmentManager();
        goto L15
    L14:
        r10 = null;
    L15:
        if (r10 != null) goto L18;
        ALogger.e(TAG, "fragmentManager is null");
        return null;
    L18:
        int r0 = com.bytedance.android.live.room.share.summersinging.k.a;
        Intrinsics.checkNotNullParameter(r7, "groupPhotoDetail");
        Observable r1 = a1.k(r7.groupPhoto).subscribeOn(Schedulers.io()).map(com.bytedance.android.live.room.share.summersinging.i.a).onErrorReturn(j.a);
        IUserService r2 = jc1.k.f(IUserService.class);
        if (r2 == null) goto L25;
        com.bytedance.android.livesdk.user.f r3 = r2.user();
        if (r3 == null) goto L25;
        IUser r4 = r3.b();
        if (r4 == null) goto L25;
        py.k r5 = r4.getAvatarThumb();
    L26:
        Observable r13 = a1.k(r5).subscribeOn(Schedulers.io()).map(com.bytedance.android.live.room.share.summersinging.g.a).onErrorReturn(h.a);
        ALogger.i("GroupPhotoDialogLauncher", "flavor is hotsoon, don't load qr code");
        return Observable.zip(r1, r13, Observable.just(sh6.a.a), com.bytedance.android.live.room.share.summersinging.e.a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).onErrorReturnItem(new p(null, null, null)).subscribe(new com.bytedance.android.live.room.share.summersinging.f(r10, r7, r8));
    L25:
        r5 = null;
        goto L26
    L9:
        r10 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public void getQrCodeFromUrl(int r3, String r4, String r5, Function1<? super String, Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "objectId");
        Intrinsics.checkNotNullParameter(r5, "editionUid");
        Intrinsics.checkNotNullParameter(r6, "callback");
        ALogger.i(TAG, "getQrCodeFromUrl \n schemaType: " + r3 + " \n objectId: " + r4 + " \n editionUid: " + r5);
        getIHostShare().getQrCodeFromUrl(r3, r4, r5, r6);
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService, com.bytedance.android.live.room.api.share.ILiveMiddlewareShareService
    public Single<i81.b> share(final i81.a r18, String r19, LiveShareType r20, IShareCallback r22) {
        final IShareCallback r4 = r22;
        Intrinsics.checkNotNullParameter(r18, "liveShareParams");
        Intrinsics.checkNotNullParameter(r19, "sourcePage");
        Intrinsics.checkNotNullParameter(r20, "shareType");
        StringBuilder r6 = new StringBuilder("liveShareParams: ");
        int r7 = com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.q.a;
        r6.append(com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.q.a(r18.toString()));
        r6.append(" \n sourcePage: ");
        r6.append(r19);
        r6.append(" \n shareType: ");
        r6.append(r20);
        ALogger.i(TAG, r6.toString());
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("source", r19);
        ShareParams r9 = r18.d;
        if (r9 == null) goto L7;
        Map r10 = r9.getLogV3Params();
        if (r10 == null) goto L7;
        String r12 = (String) r10.put("source", r19);
    L7:
        r8.put("live_share_type", String.valueOf(r20.ordinal()));
        ShareParams r13 = r18.d;
        String r14 = null;
        if (r13 == null) goto L10;
        LiveWebShareParams r15 = r13.getLiveWebShareParams();
    L11:
        if (r15 != null) goto L13;
        String r16 = "url";
    L14:
        r8.put("share_content", r16);
        if (TextUtils.isEmpty(r19) == true) goto L132;
        int r2 = com.bytedance.android.live.room.share.util.c.a;
        Intrinsics.checkNotNullParameter(r20, "liveShareType");
        Intrinsics.checkNotNullParameter(r18, "liveShareParams");
        Intrinsics.checkNotNullParameter(r8, "logMap");
        switch(com.bytedance.android.live.room.share.util.b.a[r20.ordinal()]) {
            case 1: goto L75;
            case 2: goto L64;
            case 3: goto L45;
            case 4: goto L45;
            case 5: goto L40;
            case 6: goto L29;
            case 7: goto L24;
            case 8: goto L19;
            default: goto L91;
        };
    L19:
        JSONObject r3 = new JSONObject();
        r3.put("report_type", r18.k);
        Unit r17 = Unit.INSTANCE;
        r8.put("params_required", r3.toString());
        if (r18.getActivity() != null) goto L22;
    L23:
        ALogger.e(TAG, "Report_dialog: the input params are abnormal!");
    L90:
        boolean r5 = false;
    L92:
        if (r5 == false) goto L132;
        r8.put("result", DataType.TRUE);
        reportLiveShareEvent("livesdk_experience_link_share_params_check", r8);
        switch(com.bytedance.android.live.room.share.a.a[r20.ordinal()]) {
            case 1: goto L129;
            case 2: goto L119;
            case 3: goto L114;
            case 4: goto L110;
            case 5: goto L102;
            case 6: goto L100;
            case 7: goto L99;
            case 8: goto L98;
            case 9: goto L97;
            default: goto L131;
        };
    L97:
        getIHostShare().showReportDialog(r18.getActivity(), r18.d, r18.k);
        goto L131
    L98:
        getIHostShare().shareText2FansGroup(r18.g, r18.h);
        goto L131
    L99:
        getIHostShare().shareVideo2FansGroups(r18.e, r18.f, r18.j);
        goto L131
    L100:
        getIHostShare().shareActivity(r18.getContext(), r18.i, this.callback);
        this.liveShareResult = SingleSubject.create();
        goto L131
    L110:
        IHostShare r23 = getIHostShare();
        Activity r24 = r18.getActivity();
        ShareParams r1 = r18.d;
        if (r4 != null) goto L113;
        r4 = this.callback;
    L113:
        r23.share(r24, r1, r4);
        this.liveShareResult = SingleSubject.create();
        goto L131
    L114:
        IHostShare r25 = getIHostShare();
        Activity r26 = r18.getActivity();
        com.bytedance.android.live.base.model.user.f r27 = r18.c;
        ShareParams r28 = r18.d;
        if (r4 != null) goto L117;
        r4 = this.callback;
    L117:
        r25.shareLive(r26, r27, r28, r4);
        this.liveShareResult = SingleSubject.create();
        goto L131
    L129:
        getIHostShare().directJsbShare(r18.getContext(), r18.n, r18.o);
        goto L131
    L102:
        if (Intrinsics.areEqual(r18.l, Boolean.TRUE) == true) goto L104;
    L109:
        showShareDialog(r18, r4);
        goto L131
    L104:
        if (((Boolean) vr0.a.getValue()).booleanValue() == false) goto L109;
        ShareParams r29 = r18.d;
        if (r29 != null) goto L108;
        r29 = ShareParams.builder().build();
    L108:
        com.bytedance.android.live.room.share.util.a.a(r18, r29, new AnonymousClass2(this, r18, r4));
        goto L131
    L119:
        if (r18.q == false) goto L124;
        ShareParams r30 = r18.d;
        if (r30 != null) goto L123;
        r30 = ShareParams.builder().build();
    L123:
        com.bytedance.android.live.room.share.util.a.a(r18, r30, new AnonymousClass1(this, r18, r4));
    L128:
        this.liveShareResult = SingleSubject.create();
        goto L131
    L124:
        IHostShare r32 = getIHostShare();
        Activity r33 = r18.getActivity();
        ShareParams r34 = r18.d;
        if (r4 != null) goto L127;
        r4 = this.callback;
    L127:
        r32.shareDirect(r33, r34, r4, r18.p);
    L131:
        return this.liveShareResult;
    L22:
        if (TextUtils.isEmpty(r18.k) == false) goto L91;
    L24:
        JSONObject r35 = new JSONObject();
        r35.put("conversation_id", r18.g);
        Unit r36 = Unit.INSTANCE;
        r8.put("params_required", r35.toString());
        if (r18.g != null) goto L27;
    L28:
        ALogger.e(TAG, "Share_text2FansGroups: the input params are abnormal!");
        goto L90
    L27:
        if (TextUtils.isEmpty(r18.h) == false) goto L91;
    L29:
        JSONObject r37 = new JSONObject();
        r37.put("fans_group_id_list", String.valueOf(r18.e));
        r37.put("video_file_path_list", String.valueOf(r18.f));
        Unit r38 = Unit.INSTANCE;
        r8.put("params_required", r37.toString());
        List<String> r39 = r18.e;
        if (r39 != null) goto L32;
    L33:
        List<String> r40 = r18.f;
        if (r40 == null) goto L38;
        if (r40.isEmpty() != true) goto L38;
    L39:
        ALogger.e(TAG, "Share_video2FansGroups: the input params are abnormal!");
    L38:
        if (r18.j != null) goto L91;
    L32:
        if (r39.isEmpty() == true) goto L39;
    L40:
        JSONObject r42 = new JSONObject();
        r42.put("activity_params", String.valueOf(r18.i));
        Unit r43 = Unit.INSTANCE;
        r8.put("params_required", r42.toString());
        if (r18.getContext() != null) goto L43;
    L44:
        ALogger.e(TAG, "Share_activity: the input params are abnormal!");
        goto L90
    L43:
        if (r18.i != null) goto L91;
    L45:
        JSONObject r44 = new JSONObject();
        ShareParams r110 = r18.d;
        if (r110 == null) goto L48;
        LiveWebShareParams r111 = r110.getLiveWebShareParams();
    L49:
        if (r111 != null) goto L51;
        Object r112 = DataType.TRUE;
    L52:
        r44.put("live_web_share_params_is_null", r112);
        ShareParams r45 = r18.d;
        if (r45 == null) goto L57;
        LiveWebShareParams r46 = r45.getLiveWebShareParams();
        if (r46 == null) goto L57;
        String r47 = r46.getPlatform();
    L58:
        r44.put("platform", r47);
        ShareParams r48 = r18.d;
        if (r48 == null) goto L61;
        r14 = r48.getUrl();
    L61:
        r44.put("share_url", r14);
        Unit r49 = Unit.INSTANCE;
        r8.put("params_required", r44.toString());
        if (r18.getActivity() != null) goto L91;
        ALogger.e(TAG, "Share_dialog: the input params are abnormal!");
    L57:
        r47 = null;
        goto L58
    L51:
        r112 = DataType.FALSE;
        goto L52
    L48:
        r111 = null;
        goto L49
    L64:
        JSONObject r50 = new JSONObject();
        ShareParams r52 = r18.d;
        if (r52 == null) goto L67;
        String r53 = r52.getPlatform();
    L68:
        r50.put("platform", r53);
        Unit r54 = Unit.INSTANCE;
        r8.put("params_required", r50.toString());
        if (r18.getActivity() == null) goto L74;
        ShareParams r55 = r18.d;
        if (r55 == null) goto L73;
        r14 = r55.getPlatform();
    L73:
        if (r14 != null) goto L91;
    L74:
        ALogger.e(TAG, "Share_third: the input params are abnormal!");
        goto L90
    L67:
        r53 = null;
        goto L68
    L75:
        JSONObject r56 = new JSONObject();
        r56.put("contact_user", String.valueOf(r18.c));
        ShareParams r57 = r18.d;
        if (r57 == null) goto L80;
        IRoom r58 = r57.getRoom();
        if (r58 == null) goto L80;
        Long r59 = Long.valueOf(r58.getRoomId());
    L81:
        r56.put("room_id", r59);
        Unit r60 = Unit.INSTANCE;
        r8.put("params_required", r56.toString());
        if (r18.getActivity() != null) goto L84;
    L89:
        ALogger.e(TAG, "Share_IM: the input params are abnormal!");
        goto L90
    L84:
        if (r18.c == null) goto L89;
        ShareParams r62 = r18.d;
        if (r62 == null) goto L88;
        r14 = r62.getRoom();
    L88:
        if (r14 != null) goto L91;
    L80:
        r59 = null;
    L91:
        r5 = true;
    L132:
        ALogger.e(TAG, "ShareParams are abnormal!");
        r8.put("result", DataType.FALSE);
        reportLiveShareEvent("livesdk_experience_link_share_params_check", r8);
        return this.liveShareResult;
    L13:
        r16 = "live";
        goto L14
    L10:
        r15 = null;
        goto L11
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public Disposable initVSPoster(Activity r9, ViewGroup r10, Dialog r12, DialogFragment r13, ICommonLiveSharePackage r14, IVSPosterClickListener r15) {
        Intrinsics.checkNotNullParameter(r9, "activity");
        Intrinsics.checkNotNullParameter(r10, "posterContainer");
        Intrinsics.checkNotNullParameter(r12, "dialog");
        Intrinsics.checkNotNullParameter(r13, "dialogFragment");
        return getIHostShare().initVSPoster(r9, r10, r12, r13, r14, r15);
    }
}

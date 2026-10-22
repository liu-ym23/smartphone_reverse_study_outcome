package com.bytedance.android.ec.core.widget.liveboxview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient;
import com.bytedance.android.ec.adapter.api.player.IECPlayerViewService;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.ec.hybrid.ui.IHybridLiveBoxView;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.common.utility.Logger;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0001_B%\u0012\u0006\u0010Z\u001a\u00020Y\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010Q\u0012\b\b\u0002\u0010V\u001a\u00020\t¢\u0006\u0004\b[\u0010\\B\u0011\b\u0016\u0012\u0006\u0010Z\u001a\u00020Y¢\u0006\u0004\b[\u0010]J\u0016\u0010\u0006\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J \u0010\u000f\u001a\u00020\u00042\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fH\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016JN\u0010!\u001a\u00020\u00042D\u0010 \u001a@\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\f¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0015\u0012\u0013\u0018\u00010\u001e¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00040\u001aH\u0016J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0013H\u0016J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0007H\u0016J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*H\u0016J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0007H\u0016J\u0010\u00101\u001a\u0004\u0018\u0001002\u0006\u0010.\u001a\u00020\u0007J\u0012\u00103\u001a\u00020\u00042\b\u00102\u001a\u0004\u0018\u00010\u0007H\u0016J\u001e\u00104\u001a\u00020\u00042\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0016J\u0012\u00105\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u00107\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u0007H\u0016JN\u0010:\u001a\u00020\u00042D\u00109\u001a@\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(8\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00040\u001aH\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010;R\u0018\u00102\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010;R\u0018\u0010<\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010>\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010;R\u0016\u0010?\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010&\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010AR\u0018\u0010B\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010;R\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010G\u001a\u00020F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u001b\u0010M\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u001b\u0010P\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010J\u001a\u0004\bO\u0010LR\u0019\u0010R\u001a\u0004\u0018\u00010Q8\u0006¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u0017\u0010V\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\bV\u0010@\u001a\u0004\bW\u0010X¨\u0006`"}, d2 = {"Lcom/bytedance/android/ec/core/widget/liveboxview/HybridLiveBoxView;", "Lcom/bytedance/android/ec/hybrid/ui/IHybridLiveBoxView;", "Landroid/view/View$OnAttachStateChangeListener;", "Lkotlin/Function0;", "", "task", "runOnMainThread", "", "roomID", "", "scaleType", "createPlayer", "", "", "params", "enterRoom", "curClientHash", "scene", "releasePlayerClient", "", "hidePoster", "handlePoster", "objectfit", "handleObjectfit", "playing", "destroy", "Lkotlin/Function2;", "Lkotlin/ParameterName;", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "extraInfo", "Landroid/graphics/Bitmap;", "bitmap", "callback", "saveFrameV2", "Landroid/view/View;", "v", "onViewAttachedToWindow", "onViewDetachedFromWindow", "mute", "setMute", "poster", "setPoster", "", "volume", "setVolume", "setRoomID", "liveData", "setLiveData", "Lcom/bytedance/android/ec/core/widget/liveboxview/a;", "parseLiveData", "streamData", "setStreamData", "enterDetail", "stopPlayerClient", "resolution", "switchResolution", "type", "sendCustomEvents", "stream", "Ljava/lang/String;", "mallLiveData", "Lcom/bytedance/android/ec/core/widget/liveboxview/a;", "posterUrl", "initScaleType", "I", "Z", "qualities", "Lle/b;", "playerView", "Lle/b;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "posterView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "smoothEnterRoomWithAnim$delegate", "Lkotlin/Lazy;", "getSmoothEnterRoomWithAnim", "()Z", "smoothEnterRoomWithAnim", "smoothEnterRoom$delegate", "getSmoothEnterRoom", "smoothEnterRoom", "Landroid/util/AttributeSet;", "attrs", "Landroid/util/AttributeSet;", "getAttrs", "()Landroid/util/AttributeSet;", "defStyleAttr", "getDefStyleAttr", "()I", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "Companion", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HybridLiveBoxView extends IHybridLiveBoxView implements View.OnAttachStateChangeListener {
    public static final a Companion = null;
    private static final String EVENT_ENDED = "ended";
    private static final String EVENT_ERROR = "error";
    private static final String EVENT_FROZEN = "frozen";
    private static final String EVENT_PAUSE = "pause";
    private static final String EVENT_PLAY = "play";
    private static final String EVENT_RESUME = "resume";
    private static final String EVENT_SEI = "sei";
    private static final String LIVE_PULL_DEFAULT_RESOLUTION = "origin";
    private static final String OBJECTFIT_TYPE_CONTAIN = "contain";
    private static final String OBJECTFIT_TYPE_COVER = "cover";
    private static final String OBJECTFIT_TYPE_INSIDE = "inside";
    private static final String PLAYER_SCENE = "ec_mall_homepage_live_card_preview";
    private static final String PLAYER_SCENE_LOG_TAG = "ec_mall_homepage_live_card_preview_log_tag";
    private static final String TAG = "ECLiveBoxForLynx";
    private final AttributeSet attrs;
    private final int defStyleAttr;
    private int initScaleType;
    private com.bytedance.android.ec.core.widget.liveboxview.a mallLiveData;
    private boolean mute;
    private le.b playerView;
    private String posterUrl;
    private SimpleDraweeView posterView;
    private String qualities;
    private String roomID;
    private final Lazy smoothEnterRoom$delegate;
    private final Lazy smoothEnterRoomWithAnim$delegate;
    private String streamData;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Function0 a;

        public b(Function0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    private final void enterRoom(Map<String, ? extends Object> r1) {
    }

    private final boolean getSmoothEnterRoom() {
        return ((Boolean) this.smoothEnterRoom$delegate.getValue()).booleanValue();
    }

    private final boolean getSmoothEnterRoomWithAnim() {
        return ((Boolean) this.smoothEnterRoomWithAnim$delegate.getValue()).booleanValue();
    }

    public void saveFrameV2(Function2<? super Map<String, ? extends Object>, ? super Bitmap, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "callback");
    }

    private final String curClientHash() {
        le.b r0 = this.playerView;
        if (r0 == null) goto L10;
        IECLivePlayerClient r1 = r0.a();
        if (r1 == null) goto L10;
        Integer r10 = r1.livePlayClientHashCode();
        if (r10 == null) goto L10;
        String r11 = String.valueOf(r10.intValue());
        if (r11 == null) goto L10;
        return r11;
    L10:
        return "";
    }

    public void destroy() {
        releasePlayerClient("live card destroy");
    }

    public boolean playing() {
        le.b r0 = this.playerView;
        if (r0 == null) goto L9;
        IECLivePlayerClient r1 = r0.a();
        if (r1 == null) goto L9;
        if (r1.isPlaying() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final AttributeSet getAttrs() {
        return this.attrs;
    }

    public final int getDefStyleAttr() {
        return this.defStyleAttr;
    }

    public HybridLiveBoxView(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, null, 0);
    }

    public static final /* synthetic */ String access$curClientHash(HybridLiveBoxView r0) {
        return r0.curClientHash();
    }

    public static final /* synthetic */ le.b access$getPlayerView$p(HybridLiveBoxView r0) {
        return r0.playerView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void runOnMainThread(Function0<Unit> r10) {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L5;
        post(new b(r10));
        return;
    L5:
        r10.invoke();
    }

    public void enterDetail(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        enterRoom(r10);
    }

    public void handleObjectfit(String r10) {
        Intrinsics.checkNotNullParameter(r10, "objectfit");
        int r0 = r10.hashCode();
        if (r0 == (-1183789060)) goto L16;
        if (r0 == 94852023) goto L13;
        if (r0 == 951526612) goto L10;
    L18:
        IHybridLiveBoxView.handlePoster$default(this, false, 1, null);
        return;
    L10:
        if (r10.equals(OBJECTFIT_TYPE_CONTAIN) == false) goto L18;
        this.initScaleType = 1;
        this.posterView.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        goto L18
    L13:
        if (r10.equals(OBJECTFIT_TYPE_COVER) == false) goto L18;
        this.initScaleType = 2;
        this.posterView.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        goto L18
    L16:
        if (r10.equals(OBJECTFIT_TYPE_INSIDE) == false) goto L18;
        this.initScaleType = 0;
        this.posterView.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE);
        goto L18
    }

    public void handlePoster(boolean r10) {
        if (r10 == false) goto L7;
        this.posterView.setVisibility(8);
        return;
    L7:
        if (TextUtils.isEmpty(this.posterUrl) == false) goto L9;
        char r11 = '\b';
    L10:
        if (r11 != 0) goto L23;
        le.b r12 = this.playerView;
        if (r12 == null) goto L17;
        IECLivePlayerClient r13 = r12.a();
        if (r13 == null) goto L17;
        if (r13.isPlaying() == true) goto L23;
    L17:
        this.posterView.setVisibility(0);
        int r14 = ECSdk.a;
        IECHostService r15 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r15 == null) goto L25;
        ri.b r16 = r15.getIECHostFrescoService();
        if (r16 == null) goto L26;
        r16.bindImage(this.posterView, this.posterUrl);
        return;
    L26:
        return;
    L25:
        return;
    L23:
        this.posterView.setVisibility(8);
        return;
    L9:
        r11 = 0;
        goto L10
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View r10) {
        Intrinsics.checkNotNullParameter(r10, "v");
        Logger.d(TAG, "onViewAttachedToWindow:" + this);
        setSharePlayer(false);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View r10) {
        Intrinsics.checkNotNullParameter(r10, "v");
        releasePlayerClient("live card on detach");
    }

    public final com.bytedance.android.ec.core.widget.liveboxview.a parseLiveData(String r10) {
        Intrinsics.checkNotNullParameter(r10, "liveData");
        return (com.bytedance.android.ec.core.widget.liveboxview.a) u0.c().fromJson(r10, com.bytedance.android.ec.core.widget.liveboxview.a.class);
    L6:
        throw new RuntimeException("Error while parse liveData.");
    }

    public void releasePlayerClient(String r10) {
        StringBuilder r0 = new StringBuilder("try to release the player[");
        le.b r1 = this.playerView;
        if (r1 == null) goto L7;
        IECLivePlayerClient r11 = r1.a();
        if (r11 == null) goto L7;
        Integer r12 = Integer.valueOf(r11.hashCode());
    L8:
        r0.append(r12);
        r0.append("], invoke scene: ");
        r0.append(r10);
        r0.append(", sharePlayer: ");
        r0.append(getSharePlayer());
        Logger.i(PLAYER_SCENE_LOG_TAG, r0.toString());
        if (getSharePlayer() == true) goto L16;
        le.b r13 = this.playerView;
        if (r13 == null) goto L17;
        IECLivePlayerClient r14 = r13.a();
        if (r14 == null) goto L18;
        r14.release();
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L7:
        r12 = null;
        goto L8
    }

    public void setLiveData(String r10) {
        Intrinsics.checkNotNullParameter(r10, "liveData");
        com.bytedance.android.ec.core.widget.liveboxview.a r11 = parseLiveData(r10);
        this.mallLiveData = r11;
        String r0 = null;
        if (r11 == null) goto L5;
        String r12 = r11.b();
    L6:
        this.streamData = r12;
        com.bytedance.android.ec.core.widget.liveboxview.a r13 = this.mallLiveData;
        if (r13 == null) goto L9;
        r0 = r13.a();
    L9:
        this.roomID = r0;
        return;
    L5:
        r12 = null;
        goto L6
    }

    public void setMute(boolean r10) {
        if (r10 == false) goto L8;
        le.b r0 = this.playerView;
        if (r0 == null) goto L13;
        IECLivePlayerClient r1 = r0.a();
        if (r1 == null) goto L13;
        r1.mute();
    L13:
        this.mute = r10;
        return;
    L8:
        le.b r11 = this.playerView;
        if (r11 == null) goto L13;
        IECLivePlayerClient r12 = r11.a();
        if (r12 == null) goto L13;
        r12.unmute();
        goto L13
    }

    public void setPoster(String r10) {
        Intrinsics.checkNotNullParameter(r10, "poster");
        this.posterUrl = r10;
    }

    public void setRoomID(String r10) {
        Intrinsics.checkNotNullParameter(r10, "roomID");
        this.roomID = r10;
    }

    public void setStreamData(String r1) {
        this.streamData = r1;
    }

    public void setVolume(float r10) {
        le.b r0 = this.playerView;
        if (r0 == null) goto L8;
        IECLivePlayerClient r1 = r0.a();
        if (r1 == null) goto L9;
        r1.setPlayerVolume(r10);
        return;
    L9:
        return;
    }

    public void stopPlayerClient(String r10) {
        StringBuilder r0 = new StringBuilder("try to stop the player[");
        le.b r1 = this.playerView;
        if (r1 == null) goto L7;
        IECLivePlayerClient r11 = r1.a();
        if (r11 == null) goto L7;
        Integer r12 = Integer.valueOf(r11.hashCode());
    L8:
        r0.append(r12);
        r0.append("], invoke scene: ");
        r0.append(r10);
        r0.append(", sharePlayer: ");
        r0.append(getSharePlayer());
        Logger.i(PLAYER_SCENE_LOG_TAG, r0.toString());
        if (getSharePlayer() == true) goto L16;
        le.b r13 = this.playerView;
        if (r13 == null) goto L17;
        IECLivePlayerClient r14 = r13.a();
        if (r14 == null) goto L18;
        r14.stop();
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L7:
        r12 = null;
        goto L8
    }

    public void stream(final Function2<? super String, ? super Map<String, ? extends Object>, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "sendCustomEvents");
        if (TextUtils.isEmpty(this.streamData) == false) goto L5;
        return;
    L5:
        String r0 = this.roomID;
        if (r0 != null) goto L8;
        r0 = "0";
    L8:
        createPlayer(r0, this.initScaleType);
        le.a.C0179a r1 = new le.a.C0179a();
        r1.h = this.mute;
        String r11 = this.streamData;
        String r12 = "";
        if (r11 != null) goto L11;
        r11 = "";
    L11:
        Intrinsics.checkNotNullParameter(r11, "data");
        r1.a = r11;
        String r13 = this.qualities;
        if (r13 == null) goto L15;
        r12 = r13;
    L15:
        Intrinsics.checkNotNullParameter(r12, "resolution");
        r1.b = r12;
        Lazy r14 = HybridAppInfoService.a;
        if (HybridAppInfoService.n() == false) goto L18;
    L21:
        Intrinsics.checkNotNullParameter("order_center", "enterLiveSource");
        r1.d = "order_center";
    L22:
        r1.f = true;
        le.a r15 = r1.a();
        le.b r16 = this.playerView;
        if (r16 == null) goto L28;
        IECLivePlayerClient r17 = r16.a();
        if (r17 == null) goto L29;
        r17.stream(r15, new AnonymousClass1(this, r10));
        return;
    L29:
        return;
    L28:
        return;
    L18:
        if (((Boolean) HybridAppInfoService.l.getValue()).booleanValue() == true) goto L21;
        if (((Boolean) HybridAppInfoService.m.getValue()).booleanValue() == false) goto L22;
        goto L21
    }

    public void switchResolution(String r10) {
        Intrinsics.checkNotNullParameter(r10, "resolution");
        this.qualities = r10;
        le.b r0 = this.playerView;
        if (r0 == null) goto L8;
        IECLivePlayerClient r1 = r0.a();
        if (r1 == null) goto L9;
        r1.switchResolution(r10);
        return;
    L9:
        return;
    }

    public static final /* synthetic */ void access$setPlayerView$p(HybridLiveBoxView r0, le.b r1) {
        r0.playerView = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void createPlayer(String r12, int r13) {
        if (TextUtils.equals("0", r12) == false) goto L5;
        return;
    L5:
        releasePlayerClient("before createPlayer");
        le.b r0 = this.playerView;
        le.b r1 = null;
        if (r0 == null) goto L10;
        LivePlayerView r10 = r0.getView();
        if (r10 == null) goto L10;
        ViewParent r11 = r10.getParent();
    L12:
        if ((r11 instanceof ViewGroup) == true) goto L14;
        r11 = null;
    L14:
        ViewGroup r14 = (ViewGroup) r11;
        if (Intrinsics.areEqual(r14, this) == true) goto L18;
        r14 = null;
    L18:
        if (r14 == null) goto L25;
        le.b r15 = this.playerView;
        if (r15 == null) goto L22;
        LivePlayerView r16 = r15.getView();
    L23:
        r14.removeView(r16);
        goto L25
    L22:
        r16 = null;
    L25:
        if (ECSdk.c() == false) goto L32;
        IAdapterService r17 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r17 == null) goto L31;
        IECPlayerViewService r18 = r17.getPlayerViewService();
        if (r18 == null) goto L31;
        r1 = IECPlayerViewService.a.a(r18, getContext(), this.attrs, this.defStyleAttr, r12, PLAYER_SCENE, false, false, 480);
    L31:
        this.playerView = r1;
    L32:
        le.b r19 = this.playerView;
        if (r19 == null) goto L35;
        r19.setScaleType(r13);
    L35:
        le.b r110 = this.playerView;
        if (r110 == null) goto L40;
        LivePlayerView r111 = r110.getView();
        if (r111 == null) goto L40;
        r111.setVisibility(0);
    L40:
        le.b r112 = this.playerView;
        if (r112 != null) goto L43;
        return;
    L43:
        Intrinsics.checkNotNull(r112);
        addView(r112.getView(), -1, -1);
        return;
    L10:
        r11 = null;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HybridLiveBoxView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.attrs = r11;
        this.defStyleAttr = r12;
        this.initScaleType = 2;
        this.posterView = new SimpleDraweeView(r10);
        this.smoothEnterRoomWithAnim$delegate = LazyKt.lazy(HybridLiveBoxView$smoothEnterRoomWithAnim$2.INSTANCE);
        this.smoothEnterRoom$delegate = LazyKt.lazy(HybridLiveBoxView$smoothEnterRoom$2.INSTANCE);
        addView(this.posterView, -1, -1);
        addOnAttachStateChangeListener(this);
    }

    public /* synthetic */ HybridLiveBoxView(Context r1, AttributeSet r10, int r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 4) == 0) goto L8;
        r11 = 0;
    L8:
        this(r1, r10, r11);
    }
}

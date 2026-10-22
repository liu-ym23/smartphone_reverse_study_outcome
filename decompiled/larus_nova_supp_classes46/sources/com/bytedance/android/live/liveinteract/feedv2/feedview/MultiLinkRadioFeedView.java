package com.bytedance.android.live.liveinteract.feedv2.feedview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.c3;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.liveinteract.bgComponent.theme.VideoThemeView;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.MultiLinkFeedDynamicWidgetNew;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.view.RadioTextBoardView;
import com.bytedance.android.live.liveinteract.voicechat.view.VoiceChatRoomAnchorView;
import com.bytedance.android.livesdk.chatroom.model.interact.SubtitleEventType;
import com.bytedance.android.livesdk.config.jb0;
import com.bytedance.android.livesdk.config.mf;
import com.bytedance.android.livesdk.config.pb0;
import com.bytedance.android.livesdk.message.model.cj;
import com.bytedance.android.livesdk.message.model.l9;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdk.message.model.ok;
import com.bytedance.android.livesdk.message.model.qb;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBasisData;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001/J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0016R$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010.\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00060"}, d2 = {"Lcom/bytedance/android/live/liveinteract/feedv2/feedview/MultiLinkRadioFeedView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/liveinteract/feedv2/feedview/a;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Lcom/bytedance/android/livesdk/utils/ViewModelStoreOwnerCompat;", "Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/b;", "", "stateOn", "", "setTextContainerState", "visible", "setAvatarVisible", "", "getFeedViewName", "Landroid/view/View;", "getViewCompat", "", "getMicSeatRvViewId", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "Lcom/google/gson/JsonObject;", "getLinkmicAreaFrameInfo", "getLinkmicSeatListInfo", "Landroidx/lifecycle/ViewModelStore;", "o", "Landroidx/lifecycle/ViewModelStore;", "getMViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "setMViewModelStore", "(Landroidx/lifecycle/ViewModelStore;)V", "mViewModelStore", "Landroidx/lifecycle/ViewModelProvider;", "p", "Landroidx/lifecycle/ViewModelProvider;", "getViewModelProvider", "()Landroidx/lifecycle/ViewModelProvider;", "setViewModelProvider", "(Landroidx/lifecycle/ViewModelProvider;)V", "viewModelProvider", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "q", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getFeedDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "setFeedDataCenter", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "feedDataCenter", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkRadioFeedView extends FrameLayout implements com.bytedance.android.live.liveinteract.feedv2.feedview.a, LifecycleOwnerCompat, ViewModelStoreOwnerCompat, com.bytedance.android.live.liveinteract.plantform.dynamicframe.b {
    public static final /* synthetic */ int C = 0;
    public final int A;
    public final int B;
    public Map<Integer, View> a;
    public IPreviewMultiLinkOuterConfigProvider b;
    public te0.a c;
    public final CompositeDisposable d;
    public Disposable e;
    public final HSImageView f;
    public final HSImageView g;
    public VideoThemeView h;
    public IRoom i;
    public com.bytedance.android.live.liveinteract.feed.a j;
    public com.bytedance.android.live.ui.q k;
    public final boolean l;
    public boolean m;
    public boolean n;
    public ViewModelStore o;
    public ViewModelProvider p;
    public DataCenter q;
    public VoiceChatRoomAnchorView r;
    public MultiLinkFeedDynamicWidgetNew s;
    public WidgetManager t;
    public LifecycleRegistry u;
    public boolean v;
    public com.bytedance.android.live.liveinteract.voicechat.radio.k w;
    public boolean x;
    public boolean y;
    public final b z;

    public static final class a {
    }

    public static final class b implements vlc.l {
        public final /* synthetic */ MultiLinkRadioFeedView a;

        public b(MultiLinkRadioFeedView r1) {
            this.a = r1;
        }

        public final void onMessage(tlc.d r9) {
            if ((r9 instanceof l9) == false) goto L29;
            MultiLinkRadioFeedView r0 = this.a;
            l9 r10 = (l9) r9;
            IPreviewMultiLinkOuterConfigProvider r1 = r0.b;
            if (r1 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
        L7:
            IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r1, "MultiLinkRadioFeedView", r0.hashCode(), "consumeLinkmicPlaymodeMessage", false, 8, null);
            if (StringsKt.equals$default(r10.getWrdsSubKeyFlex(), "SubtitleStatusSubSyncKey", false, 2, null) == true) goto L10;
            return;
        L10:
            if (r10.getLinkmicSubtitleSettingStatus() == null) goto L15;
            if (r0.x == true) goto L15;
            r0.x = true;
        L15:
            if (r10.getLinkmicSubtitleSettingStatus() == null) goto L17;
            boolean r11 = true;
        L19:
            if (r11 == r0.y) goto L31;
            r0.y = r11;
            if (r11 == false) goto L25;
            r0.v = true;
            com.bytedance.android.live.liveinteract.voicechat.radio.k r12 = r0.w;
            if (r12 == null) goto L32;
            r12.d();
            return;
        L32:
            return;
        L25:
            r0.v = false;
            com.bytedance.android.live.liveinteract.voicechat.radio.k r13 = r0.w;
            if (r13 == null) goto L34;
            r13.e();
            return;
        L34:
            return;
        L31:
            return;
        L17:
            r11 = false;
            goto L19
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final Integer a() {
        return 0;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final boolean c() {
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "seiString");
    }

    public HashMap<String, Object> getChatRoomEnterRoomExtraParam() {
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public String getFeedViewName() {
        return "MultiLinkRadioFeedView";
    }

    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public JsonObject getLinkmicAreaFrameInfo() {
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public JsonObject getLinkmicSeatListInfo() {
        return null;
    }

    public int getMicSeatRvViewId() {
        return -1;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public View getViewCompat() {
        return this;
    }

    public /* bridge */ /* synthetic */ ViewModelStore getViewModelStore() {
        return ViewModelStoreOwnerCompat.-CC.$default$getViewModelStore(this);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final int i() {
        return 0;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final void l() {
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void m(int r1, int r2, List<Integer> r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void onLivePlayerVideoSizeChanged() {
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void onViewHolderPause() {
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void onViewHolderResume() {
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void onViewHolderSelected() {
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void onViewHolderUnSelected() {
        this.m = false;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void removeEffectView() {
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void s() {
    }

    public static boolean v() {
        if (((Boolean) vm2.d.z7.getValue(null, vm2.d.a[438(0x1b6, float:6.14E-43)])).booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public FrameLayout.LayoutParams getKtvComponentLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -2);
    }

    public Lifecycle getLifecycleCompat() {
        LifecycleRegistry r0 = this.u;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new LifecycleRegistry(this);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final MessageHub p() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.b;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L6:
        return r0.getMessageHub();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final IRoom r() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.b;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L6:
        return r0.getRoom();
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void release() {
        this.d.clear();
        Disposable r0 = this.e;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        ViewModelStore r1 = this.o;
        if (r1 == null) goto L8;
        r1.clear();
    L8:
        this.o = null;
        this.p = null;
        this.q = null;
        MultiLinkFeedDynamicWidgetNew r2 = this.s;
        if (r2 == null) goto L11;
        r2.jc("audiochat_stage");
    L11:
        MultiLinkFeedDynamicWidgetNew r3 = this.s;
        if (r3 == null) goto L14;
        r3.onDestroy();
    L14:
        this.s = null;
        IPreviewMultiLinkOuterConfigProvider r4 = this.b;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L17:
        MessageHub r5 = r4.getMessageHub();
        if (r5 == null) goto L21;
        r5.removeMessageListener(MessageType.LINK_MIC_PLAYMODE.getIntType(), this.z);
        return;
    }

    public final ViewModelStore tf() {
        ViewModelStore r0 = this.o;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new ViewModelStore();
    }

    public final boolean w() {
        LinkFeedTypeConstant.Companion r0 = LinkFeedTypeConstant.Companion;
        IPreviewMultiLinkOuterConfigProvider r1 = this.b;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L6:
        if (r0.isDouyinFullScreen(r1.getShowFrom()) == true) goto L8;
        return false;
    L8:
        if (com.bytedance.android.live.liveinteract.voicechat.radio.e.d(false) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public final boolean x() {
        if (((Boolean) c3.a.getValue()).booleanValue() == false) goto L10;
        IPreviewMultiLinkOuterConfigProvider r0 = this.b;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L8:
        if (com.bytedance.android.live.liveinteract.utils.h.e(r0.getShowFrom()) == false) goto L10;
        return true;
    L10:
        return false;
    }

    public final DataCenter getFeedDataCenter() {
        return this.q;
    }

    public final ViewModelStore getMViewModelStore() {
        return this.o;
    }

    public final ViewModelProvider getViewModelProvider() {
        return this.p;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final boolean k() {
        return this.y;
    }

    private final void setAvatarVisible(boolean r5) {
        JsonObject r0 = new JsonObject();
        r0.addProperty("type", "avatar_visible");
        JsonObject r1 = new JsonObject();
        r1.addProperty("visible", Boolean.valueOf(r5));
        r0.add("data", r1);
        MultiLinkFeedDynamicWidgetNew r6 = this.s;
        if (r6 == null) goto L6;
        r6.Dk("radio", "radio_event", r0, false);
        return;
    }

    private final void setTextContainerState(boolean r5) {
        JsonObject r0 = new JsonObject();
        r0.addProperty("type", "radio_text_container");
        JsonObject r1 = new JsonObject();
        r1.addProperty("state", Boolean.valueOf(r5));
        r0.add("data", r1);
        MultiLinkFeedDynamicWidgetNew r6 = this.s;
        if (r6 == null) goto L6;
        r6.Dk("radio", "radio_event", r0, false);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void f(qb r1) {
        if (r1 == null) goto L5;
        z(r1);
        return;
    }

    public final View g(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void h(SeiAppData r3) {
        Intrinsics.checkNotNullParameter(r3, "seiAppData");
        DataCenter r0 = this.q;
        if (r0 == null) goto L16;
        com.bytedance.android.live.liveinteract.bgComponent.platform.a r1 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.c(r0);
        if (r1 == null) goto L7;
        r1.Aj(this.A);
    L7:
        String r4 = r3.getShowPlayer();
        if (r4 == null) goto L12;
        boolean r2 = true;
        if (r4.equals("true") != true) goto L12;
    L13:
        if (r1 == null) goto L17;
        r1.fo(r2);
        return;
    L17:
        return;
    L12:
        r2 = false;
        goto L13
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void j(cj r1) {
        if (r1 == null) goto L5;
        y(r1);
        return;
    }

    public final void setFeedDataCenter(DataCenter r1) {
        this.q = r1;
    }

    public final void setMViewModelStore(ViewModelStore r1) {
        this.o = r1;
    }

    public final void setViewModelProvider(ViewModelProvider r1) {
        this.p = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateMvControllerSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        Intrinsics.checkNotNullParameter(r2, "sei");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updatePreloadRoomLinkMicSyncData(RoomLinkMicSyncData r2) {
        Intrinsics.checkNotNullParameter(r2, "wrds");
        Intrinsics.checkNotNullParameter(r2, "wrds");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateRadioSei(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "sei");
        JSONObject r4 = JSONObjectProtectorUtils.getJSONObject(r3, "radio_sei");     // Catch: Exception -> L7
        if (r4.has("speaking") == false) goto L10;
        this.n = r4.optBoolean("speaking");     // Catch: Exception -> L7
        return;
    L10:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateRadioTextSei(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "sei");
        ConstraintLayout r1 = (RadioTextBoardView) g(2131383612);
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.getVisibility());
    L7:
        if (r2.intValue() == 0) goto L9;
        return;
    L9:
        if (this.l == false) goto L15;
        RadioTextBoardView r0 = (RadioTextBoardView) g(2131383612);
        if (r0 == null) goto L16;
        r0.R5(r3);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateSpeechRecognitionSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        Intrinsics.checkNotNullParameter(r2, "sei");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateSpeechRhythmSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        Intrinsics.checkNotNullParameter(r2, "sei");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void updateSubtitleSei(String r7) {
        Intrinsics.checkNotNullParameter(r7, "sei");
        if (w() == true) goto L6;
        return;
    L6:
        if (this.x == true) goto L8;
    L14:
        List r3 = null;
        if (StringsKt.contains$default(r7, "audio_subtitle", false, 2, null) == false) goto L87;
        LiveSeiUtil.i.getClass();
        if (LiveSeiUtil.b(r7) == true) goto L19;
    L77:
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.e(r7);
        return;
    L19:
        if (((Boolean) mf.a.getValue()).booleanValue() == true) goto L21;
    L79:
        String r0 = JSONObjectProtectorUtils.getString(LiveSeiUtil.c(r7), "audio_subtitle");     // Catch: Exception -> L76
        if (r0 == null) goto L88;
        String r1 = JSONObjectProtectorUtils.getString(new JSONObject(r0), "subtitles");     // Catch: Exception -> L76
        if (r1 == null) goto L89;
        ArrayList r2 = new ArrayList();     // Catch: Exception -> L76
        int r4 = com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a;     // Catch: Exception -> L76
        IPreviewMultiLinkOuterConfigProvider r5 = this.b;     // Catch: Exception -> L76
        if (r5 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");     // Catch: Exception -> L76
    L33:
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(r5.getShowFrom()) == false) goto L42;
        te0.a r6 = this.c;     // Catch: Exception -> L76
        if (r6 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");     // Catch: Exception -> L76
    L37:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.h r8 = r6.c();     // Catch: Exception -> L76
        if (r8 == null) goto L50;
        BehaviorSubject<List<ch0.e>> r9 = r8.b;     // Catch: Exception -> L76
        if (r9 == null) goto L50;
        r3 = (List) r9.getValue();     // Catch: Exception -> L76
    L50:
        if (r3 == null) goto L55;
        Iterator r10 = r3.iterator();     // Catch: Exception -> L76
    L53:
        if (r10.hasNext() == false) goto L55;
        r2.add(((ch0.e) r10.next()).a);     // Catch: Exception -> L76
    L55:
        List r11 = com.bytedance.android.live.liveinteract.voicechat.subtitle.g0.e(r1, r2);     // Catch: Exception -> L76
        if (((ArrayList) r11).isEmpty() == false) goto L58;
        return;
    L58:
        List<nj0.g> r12 = com.bytedance.android.live.liveinteract.voicechat.subtitle.r.b;     // Catch: Exception -> L76
        if (com.bytedance.android.live.liveinteract.voicechat.subtitle.r.a(this.v, r11) == false) goto L61;
        return;
    L61:
        Iterator r13 = ((ArrayList) r11).iterator();     // Catch: Exception -> L76
    L63:
        if (r13.hasNext() == false) goto L70;
        nj0.g r14 = (nj0.g) r13.next();     // Catch: Exception -> L76
        if (r14.a != null) goto L63;
        IPreviewMultiLinkOuterConfigProvider r15 = this.b;     // Catch: Exception -> L76
        if (r15 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");     // Catch: Exception -> L76
    L69:
        r14.a = r15.getRoom().getOwner();     // Catch: Exception -> L76
        goto L63
    L70:
        com.bytedance.android.live.liveinteract.voicechat.subtitle.r.b(r11);     // Catch: Exception -> L76
        if (this.v == false) goto L90;
        int r16 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a;     // Catch: Exception -> L76
        JsonObject r17 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.h(r11);     // Catch: Exception -> L76
        r17.addProperty("type", Integer.valueOf(SubtitleEventType.CONTENT.ordinal()));     // Catch: Exception -> L76
        com.bytedance.android.live.liveinteract.voicechat.radio.k r18 = this.w;     // Catch: Exception -> L76
        if (r18 == null) goto L91;
        Intrinsics.checkNotNullParameter(r17, "extraObject");     // Catch: Exception -> L76
        r18.f(r17);     // Catch: Exception -> L76
        return;
    L91:
        return;
    L90:
        return;
    L42:
        te0.a r19 = this.c;     // Catch: Exception -> L76
        if (r19 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");     // Catch: Exception -> L76
    L45:
        ue0.c r20 = r19.f();     // Catch: Exception -> L76
        if (r20 == null) goto L50;
        BehaviorSubject<List<ch0.e>> r21 = r20.b;     // Catch: Exception -> L76
        if (r21 == null) goto L50;
        r3 = (List) r21.getValue();     // Catch: Exception -> L76
        goto L50
    L89:
        return;
    L88:
        return;
    L76:
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.e(r7);
        return;
    L21:
        if (com.bytedance.android.live.liveinteract.voicechat.subtitle.g0.d(r7) == true) goto L79;
    L87:
        return;
    L8:
        if (this.y == false) goto L14;
        if (this.v == true) goto L14;
        this.v = true;
        com.bytedance.android.live.liveinteract.voicechat.radio.k r22 = this.w;
        if (r22 == null) goto L14;
        r22.d();
        goto L14
    }

    public final void y(cj r3) {
        ALogger.i("RadioStageContainerWidget", "[radio_feed_view] wrds radioGiftMessageState:" + r3);
        Integer r0 = r3.msgType;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.intValue() != 1) goto L20;
        cj.f r4 = r3.metaContent;
        if (r4 == null) goto L10;
        Boolean r5 = r4.isActivate;
    L12:
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L16;
        com.bytedance.android.live.liveinteract.voicechat.radio.k r6 = this.w;
        if (r6 == null) goto L21;
        r6.e = true;
        r6.h(MultiLinkOpenSource.MESSAGE);
        return;
    L21:
        return;
    L16:
        com.bytedance.android.live.liveinteract.voicechat.radio.k r7 = this.w;
        if (r7 == null) goto L23;
        r7.e = false;
        r7.i(MultiLinkOpenSource.MESSAGE);
        return;
    L23:
        return;
    L10:
        r5 = null;
        goto L12
    }

    public final void z(qb r9) {
        if (LinkFeedTypeConstant.Companion.isDouyinFullScreen(this.B) == true) goto L5;
        return;
    L5:
        if (this.l == true) goto L7;
        return;
    L7:
        if ((r9 instanceof o0) == true) goto L9;
        qb r0 = null;
    L10:
        o0 r1 = (o0) r0;
        if (r1 == null) goto L15;
        CommonMessageData r2 = ((BaseMessage) r1).baseMessage;
        if (r2 == null) goto L15;
        Long r3 = Long.valueOf(r2.roomId);
    L16:
        IRoom r4 = this.i;
        if (r4 == null) goto L19;
        Long r5 = Long.valueOf(r4.getId());
    L21:
        if (Intrinsics.areEqual(r3, r5) == true) goto L23;
        return;
    L23:
        if (r9.getPlaceholder() != 1) goto L47;
        ok r10 = r9.getTextBg();
        if (r10 == null) goto L57;
        setTextContainerState(true);
        ConstraintLayout r6 = (RadioTextBoardView) g(2131383612);
        if (r6 == null) goto L29;
        r6.setVisibility(0);
    L29:
        RadioTextBoardView r7 = (RadioTextBoardView) g(2131383612);
        if (r7 == null) goto L33;
        com.bytedance.android.live.liveinteract.view.c.f.getClass();
        r7.T5(com.bytedance.android.live.liveinteract.view.c.a.a(r10));
    L33:
        if (this.m == true) goto L60;
        this.m = true;
        HashMap r11 = new HashMap();
        r11.put("live_type", "voice_live");
        r11.put("function_type2", "live");
        r11.put("voice_mode", "head");
        r11.put("action_type", "show");
        IRoom r8 = this.i;
        String r12 = "0";
        if (r8 == null) goto L39;
        String r13 = r8.getAnchorId();
        if (r13 == null) goto L39;
    L40:
        r11.put("anchor_id", r13);
        IRoom r14 = this.i;
        if (r14 == null) goto L46;
        String r15 = r14.getIdStr();
        if (r15 == null) goto L46;
        r12 = r15;
    L46:
        r11.put("room_id", r12);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_live_text_show_play", r11, new Object[0]);
        return;
    L39:
        r13 = "0";
        goto L40
    L60:
        return;
    L57:
        return;
    L47:
        setTextContainerState(false);
        RadioTextBoardView r16 = (RadioTextBoardView) g(2131383612);
        if (r16 == null) goto L50;
        r16.S5();
        r16.g = null;
    L50:
        ConstraintLayout r17 = (RadioTextBoardView) g(2131383612);
        if (r17 == null) goto L59;
        r17.setVisibility(8);
        return;
    L59:
        return;
    L19:
        r5 = null;
    L15:
        r3 = null;
        goto L16
    L9:
        r0 = r9;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void b(String r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "syncKey");
        Intrinsics.checkNotNullParameter(r1, "syncKey");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void insertEffectView(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r1, "view");
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.a
    public final void o(IPreviewMultiLinkOuterConfigProvider r30, te0.a r31) {
        Intrinsics.checkNotNullParameter(r30, "configOuterProvider");
        Intrinsics.checkNotNullParameter(r31, "configInnerProvider");
        this.b = r30;
        this.c = r31;
        this.i = r30.getRoom();
        if (this.u != null) goto L6;
        this.u = new LifecycleRegistry(this);
    L6:
        if (this.o != null) goto L9;
        this.o = new ViewModelStore();
    L9:
        if (this.p != null) goto L12;
        this.p = new ViewModelProvider(this);
    L12:
        if (this.q != null) goto L26;
        this.q = DataCenter.create(this.p, this);
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        if (vm2.h.W().feedLogRoom() == false) goto L26;
        IPreviewMultiLinkOuterConfigProvider r1 = this.b;
        if (r1 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L18:
        IRoom r2 = r1.getRoom();
        if (r2 == null) goto L26;
        DataCenter r3 = this.q;
        if (r3 == null) goto L23;
        r3.put("data_room", r2);
    L23:
        DataCenter r4 = this.q;
        if (r4 == null) goto L26;
        r4.put("data_is_feed", Boolean.TRUE);
    L26:
        IRoom r5 = this.i;
        Intrinsics.checkNotNull(r5);
        boolean r6 = v();
        if (r6 == false) goto L29;
        com.bytedance.android.live.core.utils.i0.c().post(new k0(this));
    L29:
        this.r = (VoiceChatRoomAnchorView) g(2131363504);
        if (LinkFeedTypeConstant.Companion.isDouyinFullScreen(this.B) == true) goto L32;
        VoiceChatRoomAnchorView r7 = this.r;
        if (r7 == null) goto L55;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
    L57:
        if ((r8 instanceof ConstraintLayout.LayoutParams) == true) goto L59;
        r8 = null;
    L59:
        ConstraintLayout.LayoutParams r9 = (ConstraintLayout.LayoutParams) r8;
        if (r9 == null) goto L62;
        r9.topToTop = 0;
        r9.bottomToBottom = 0;
        r9.leftToLeft = 0;
        r9.rightToRight = 0;
        r9.setMargins(0, 0, 0, 0);
    L62:
        setTextContainerState(false);
        ((RadioTextBoardView) g(2131383612)).setVisibility(8);
    L63:
        VoiceChatRoomAnchorView r10 = this.r;
        if (r10 == null) goto L66;
        r10.setUserNameVisibility(8);
    L66:
        setClickable(false);
        if (r6 == true) goto L117;
        View r11 = g(2131383617);
        if (r11 == null) goto L116;
        this.h = (VideoThemeView) r11;
        ViewGroup.LayoutParams r12 = new ConstraintLayout.LayoutParams(-1, -1);
        ((ConstraintLayout.LayoutParams) r12).topToTop = 0;
        ((ConstraintLayout.LayoutParams) r12).bottomToBottom = 0;
        ((ConstraintLayout.LayoutParams) r12).leftToLeft = 0;
        ((ConstraintLayout.LayoutParams) r12).rightToRight = 0;
        VideoThemeView r13 = this.h;
        if (r13 == null) goto L73;
        r13.setLayoutParams(r12);
    L73:
        this.j = new com.bytedance.android.live.liveinteract.feed.a(false, this.f, this.g, this.h, new l0(this));
        com.bytedance.android.live.liveinteract.videotalk.ui.theme.b.a r14 = new com.bytedance.android.live.liveinteract.videotalk.ui.theme.b.a();
        com.bytedance.android.live.liveinteract.feed.a r15 = this.j;
        Intrinsics.checkNotNull(r15);
        com.bytedance.android.live.ui.q.a.c(r14, r15);
        this.k = r14.a();
        IRoom r16 = this.i;
        if (r16 == null) goto L76;
        IVoiceLiveTheme r17 = r16.getVoiceLiveTheme();
    L78:
        if (r17 != null) goto L80;
    L81:
        if (r17 != null) goto L83;
    L87:
        VideoThemeView r18 = this.h;
        if (r18 == null) goto L90;
        r18.setVisibility(4);
    L90:
        com.bytedance.android.live.ui.q r19 = this.k;
        if (r19 == null) goto L93;
        r19.c(com.bytedance.android.livesdk.model.k.a());
    L93:
        IRoomBasisData r20 = r5.getBasisRoomData();
        if (r20 == null) goto L96;
        Boolean r21 = r20.isCustomizeAudioRoom();
    L98:
        if (Intrinsics.areEqual(r21, Boolean.TRUE) == false) goto L117;
        IRoom r22 = this.i;
        if (r22 == null) goto L102;
        IVoiceLiveTheme r23 = r22.getVoiceLiveTheme();
    L103:
        if (r23 != null) goto L105;
    L106:
        if (r23 != null) goto L108;
    L110:
        r23 = com.bytedance.android.livesdk.model.k.a();
    L111:
        com.bytedance.android.live.ui.q r24 = this.k;
        if (r24 == null) goto L114;
        r24.d(r23);
    L114:
        this.j = null;
        this.k = null;
        goto L117
    L108:
        if (5 != r23.getBgType()) goto L110;
    L105:
        if (2 == r23.getBgType()) goto L111;
    L102:
        r23 = null;
        goto L103
    L96:
        r21 = null;
        goto L98
    L83:
        if (5 != r17.getBgType()) goto L87;
    L84:
        com.bytedance.android.live.ui.q r25 = this.k;
        if (r25 == null) goto L93;
        r25.c(r17);
        goto L93
    L80:
        if (2 == r17.getBgType()) goto L84;
    L76:
        r17 = null;
        goto L78
    L116:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.bgComponent.theme.VideoThemeView");
    L117:
        com.bytedance.android.live.liveinteract.pre.a.c.a.c(this.i, true);
        VoiceChatRoomAnchorView r26 = this.r;
        if (r26 == null) goto L123;
        if (r5 == null) goto L122;
        r26.f(r5);
        goto L123
    L122:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.IRoom");
    L123:
        VoiceChatRoomAnchorView r27 = this.r;
        if (r27 == null) goto L126;
        r27.d(1);
    L126:
        IPreviewMultiLinkOuterConfigProvider r28 = this.b;
        if (r28 != null) goto L129;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L129:
        FrameLayout r29 = r28.getContainerView();
        if (r29 == null) goto L132;
        r29.post(new m0(this, r29));
    L132:
        IRoom r32 = this.i;
        if (r32 == null) goto L137;
        IRoomBasisData r33 = r32.getBasisRoomData();
        if (r33 == null) goto L137;
        Boolean r34 = r33.isCustomizeAudioRoom();
    L138:
        Boolean r35 = Boolean.TRUE;
        if (Intrinsics.areEqual(r34, r35) == false) goto L147;
        if (x() == false) goto L143;
        setAvatarVisible(true);
        goto L147
    L143:
        VoiceChatRoomAnchorView r36 = this.r;
        if (r36 == null) goto L147;
        r36.setVisibility(8);
    L147:
        if (this.l == false) goto L150;
        g(2131384822).setClipChildren(true);
    L150:
        if (x() == false) goto L220;
        if (((Boolean) jb0.a.getValue()).booleanValue() == true) goto L155;
    L158:
        Context r37 = getContext();
        DataCenter r38 = this.q;
        Intrinsics.checkNotNull(r38);
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.c r39 = null;
        IPreviewMultiLinkOuterConfigProvider r40 = this.b;
        if (r40 != null) goto L161;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L161:
        int r110 = r40.getShowFrom();
        te0.a r41 = this.c;
        if (r41 != null) goto L164;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L164:
        ue0.c r111 = r41.f();
        IPreviewMultiLinkOuterConfigProvider r42 = this.b;
        if (r42 != null) goto L167;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L167:
        MultiLinkFeedDynamicWidgetNew r43 = new MultiLinkFeedDynamicWidgetNew(this, r37, r38, this, r39, r110, r111, r42.getEnterFromMerge(), 896);
        this.s = r43;
        te0.a r44 = this.c;
        if (r44 != null) goto L170;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L170:
        r43.b(r44.g());
    L171:
        IRoom r45 = this.i;
        if (r45 == null) goto L176;
        MultiLinkFeedDynamicWidgetNew r46 = this.s;
        if (r46 == null) goto L176;
        r46.updateRoom(r45);
    L176:
        LinkedHashMap r47 = new LinkedHashMap();
        IPreviewMultiLinkOuterConfigProvider r48 = this.b;
        if (r48 != null) goto L179;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L179:
        IBaseUser r49 = r48.getRoom().getOwner();
        if (r49 == null) goto L187;
        py.k r50 = r49.getAvatarMedium();
        if (r50 == null) goto L187;
        List r51 = r50.getUrls();
        if (r51 == null) goto L187;
        String r52 = (String) CollectionsKt.getOrNull(r51, 0);
        if (r52 == null) goto L187;
    L188:
        r47.put("anchor_avatar_url", r52);
        r47.put("scene", "0");
        IPreviewMultiLinkOuterConfigProvider r53 = this.b;
        if (r53 != null) goto L191;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L191:
        IRoomBasisData r54 = r53.getRoom().getBasisRoomData();
        if (r54 == null) goto L194;
        Boolean r55 = r54.isCustomizeAudioRoom();
    L195:
        r47.put("is_customize_audio", String.valueOf(Intrinsics.areEqual(r55, r35)));
        IPreviewMultiLinkOuterConfigProvider r56 = this.b;
        if (r56 != null) goto L198;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L198:
        r47.put("is_live_audio", String.valueOf(r56.getRoom().isLiveTypeAudio()));
        MultiLinkFeedDynamicWidgetNew r57 = this.s;
        if (r57 == null) goto L203;
        ih0.c r58 = r57.tb();
        if (r58 == null) goto L203;
        r58.updateData(r47);
    L203:
        VoiceChatRoomAnchorView r59 = this.r;
        if (r59 == null) goto L206;
        r59.setVisibility(4);
    L206:
        com.bytedance.android.live.liveinteract.voicechat.radio.k r60 = this.w;
        if (r60 == null) goto L211;
        boolean r61 = true;
        if (r60.b() != true) goto L212;
        boolean r62 = true;
    L213:
        ALogger.i("RadioStageContainerWidget", "[sendRadioStageStateToLynx] state:" + r62);
        JsonObject r63 = new JsonObject();
        r63.addProperty("state", Boolean.valueOf(r62));
        nh0.f r65 = new nh0.f("radio_stage_state", null, null, null, r63, null, false, 222);
        MultiLinkFeedDynamicWidgetNew r66 = this.s;
        if (r66 == null) goto L216;
        r66.fg(r65);
    L216:
        setAvatarVisible(r61);
        JsonObject r67 = new JsonObject();
        r67.addProperty("type", "avatar_position");
        JsonObject r68 = new JsonObject();
        r68.addProperty("top_offset", 0);
        r67.add("data", r68);
        MultiLinkFeedDynamicWidgetNew r69 = this.s;
        if (r69 == null) goto L220;
        r69.Dk("radio", "radio_event", r67, false);
    L212:
        r62 = false;
        goto L213
    L211:
        r61 = true;
        goto L212
    L194:
        r55 = null;
    L187:
        r52 = "";
        goto L188
    L155:
        if (this.s != null) goto L171;
    L220:
        if (this.l == false) goto L228;
        te0.a r70 = this.c;
        if (r70 != null) goto L225;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L225:
        qb r71 = r70.e();
        if (r71 == null) goto L228;
        z(r71);
    L228:
        com.bytedance.android.live.liveinteract.voicechat.radio.k r72 = new com.bytedance.android.live.liveinteract.voicechat.radio.k(getContext(), this.i, this.q, g(2131384822), this, 0, null, 192);
        this.w = r72;
        j0 r73 = new j0(this);
        Intrinsics.checkNotNullParameter(r73, "stateChangeCallback");
        r72.a = r73;
        te0.a r74 = this.c;
        if (r74 != null) goto L231;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L231:
        cj r75 = r74.b();
        if (r75 == null) goto L235;
        y(r75);
    L235:
        if (w() == false) goto L252;
        IPreviewMultiLinkOuterConfigProvider r76 = this.b;
        if (r76 != null) goto L239;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L239:
        MessageHub r77 = r76.getMessageHub();
        if (r77 == null) goto L242;
        r77.removeMessageListener(MessageType.LINK_MIC_PLAYMODE.getIntType(), this.z);
    L242:
        IPreviewMultiLinkOuterConfigProvider r78 = this.b;
        if (r78 != null) goto L245;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L245:
        xlc.a r79 = r78.getMessageHub();
        if ((r79 instanceof xlc.a) == true) goto L248;
        xlc.a r112 = null;
    L249:
        xlc.a r113 = r112;
        if (r113 == null) goto L252;
        r113.D(MessageType.LINK_MIC_PLAYMODE.getIntType(), this.z, "SubtitleStatusSubSyncKey");
        goto L252
    L248:
        r112 = r79;
    L252:
        Disposable r80 = this.e;
        if (r80 == null) goto L255;
        r80.dispose();
    L255:
        this.e = Observable.interval(1000, TimeUnit.MILLISECONDS).subscribe(new n0(this));
        return;
    L137:
        r34 = null;
        goto L138
    L55:
        r8 = null;
        goto L57
    L32:
        if (((Boolean) pb0.a.getValue()).booleanValue() == false) goto L41;
        IPreviewMultiLinkOuterConfigProvider r81 = this.b;
        if (r81 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L37:
        if (com.bytedance.android.live.liveinteract.utils.h.e(r81.getShowFrom()) == false) goto L41;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L41;
        int r82 = UtilityKotlinExtentionsKt.i(108) + StatusBarUtil.getStatusBarHeight(s1.getContext());
    L42:
        VoiceChatRoomAnchorView r83 = this.r;
        if (r83 == null) goto L45;
        ViewGroup.LayoutParams r84 = r83.getLayoutParams();
    L47:
        if ((r84 instanceof ConstraintLayout.LayoutParams) == true) goto L49;
        r84 = null;
    L49:
        ConstraintLayout.LayoutParams r85 = (ConstraintLayout.LayoutParams) r84;
        if (r85 == null) goto L63;
        ((ViewGroup.MarginLayoutParams) r85).topMargin = r82;
        goto L63
    L45:
        r84 = null;
    L41:
        r82 = UtilityKotlinExtentionsKt.i(108);
        goto L42
    }

    public static final void t(MultiLinkRadioFeedView r3, boolean r4, String r5) {
        r3.getClass();
        JsonObject r0 = new JsonObject();
        r0.addProperty("type", "radio_stage");
        JsonObject r1 = new JsonObject();
        r1.addProperty("state", Boolean.valueOf(r4));
        int r2 = 108;
        if (((Boolean) pb0.a.getValue()).booleanValue() == true) goto L5;
    L7:
        r1.addProperty("avatar_bottom", Integer.valueOf((r2 + 120) - 19));
        r1.addProperty("screen_width", Float.valueOf(s1.G(s1.y())));
        r1.addProperty("screen_height", Float.valueOf(s1.G(s1.w())));
        if (Intrinsics.areEqual(r5, "subtitle") == false) goto L10;
        r1.addProperty("subtitle_state", "1");
    L10:
        r0.add("data", r1);
        MultiLinkFeedDynamicWidgetNew r6 = r3.s;
        if (r6 == null) goto L14;
        r6.Dk("radio", "radio_event", r0, false);
        return;
    L14:
        return;
    L5:
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L7;
        r2 = 108 + ((int) s1.G(StatusBarUtil.getStatusBarHeight(s1.getContext())));
        goto L7
    }

    public static final void u(MultiLinkRadioFeedView r2, View r3, int r4) {
        r2.getClass();
        int r5 = (int) (UtilityKotlinExtentionsKt.h(r4) * (r3.getWidth() / s1.y()));
        a1.p(r2.g(2131389468), r5);
        a1.k(r2.g(2131389468), r5);
        int r6 = (int) (r5 * 1.5f);
        a1.p(r2.g(2131383601), r6);
        a1.k(r2.g(2131383601), r6);
        a1.p(r2.g(2131387480), r6);
        a1.k(r2.g(2131387480), r6);
        a1.k(r2.g(2131362578), r6);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final void updateViewInLiveBg(String r2, JsonObject r3, ih0.h r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "updateCallback");
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.b.a.a(r2, r3, (com.bytedance.android.live.liveinteract.jsbridge.method.l0) r4);
    }

    public MultiLinkRadioFeedView(Context r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, null, 0);
        this.A = r4;
        this.B = r6;
        this.a = new LinkedHashMap();
        this.d = new CompositeDisposable();
        this.f = new HSImageView(r3);
        this.g = new HSImageView(r3);
        this.l = vm2.h.f();
        this.z = new b(this);
        com.bytedance.android.live.liveinteract.pre.a.c.a.a(hashCode(), r5);
        VerticalNitaInflate.a(VerticalNitaInflate.Tag.CommonMultiLinkFeedView_container.name(), 2131567756, r3, this, true);
    }
}

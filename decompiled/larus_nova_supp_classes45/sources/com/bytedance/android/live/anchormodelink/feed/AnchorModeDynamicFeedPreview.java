package com.bytedance.android.live.anchormodelink.feed;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.android.live.anchormodelink.util.JsbParamParseUtil;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.jsbridge.method.l0;
import com.bytedance.android.live.liveinteract.jsbridge.method.s;
import com.bytedance.android.live.liveinteract.plantform.utils.l;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import com.bytedance.android.livesdkapi.model.AnchorModeParseSeiData;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.android.livesdkapi.util.IInteractPlayView;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.android.scope.j;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ly.h;
import ly.u;
import ny.o;
import ny.t;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001\u000fJ\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/anchormodelink/feed/AnchorModeDynamicFeedPreview;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/anchormodelink/feed/b;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Lcom/bytedance/android/livesdk/utils/ViewModelStoreOwnerCompat;", "Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/b;", "", "getFeedViewName", "", "getMicSeatRvViewId", "Lcom/google/gson/JsonObject;", "getLinkmicAreaFrameInfo", "getLinkmicSeatListInfo", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorModeDynamicFeedPreview extends FrameLayout implements com.bytedance.android.live.anchormodelink.feed.b, LifecycleOwnerCompat, ViewModelStoreOwnerCompat, com.bytedance.android.live.liveinteract.plantform.dynamicframe.b {
    public static final /* synthetic */ int r = 0;
    public IPreviewMultiLinkOuterConfigProvider a;
    public com.bytedance.android.live.anchormodelink.feed.c b;
    public int c;
    public h d;
    public LifecycleRegistry e;
    public ViewModelStore f;
    public ViewModelProvider g;
    public DataCenter h;
    public final List<iy.e> i;
    public com.bytedance.android.live.anchormodelink.handlers.d j;
    public oy.c k;
    public final d l;
    public final c m;
    public final b n;
    public int o;
    public AnchorModeParseSeiData p;
    public final j q;

    public static final class a {
    }

    public static final class b implements u {
        public final /* synthetic */ AnchorModeDynamicFeedPreview a;

        @Override // ly.u
        public final LivePlayerView R8() {
            IPreviewMultiLinkOuterConfigProvider r0 = this.a.a;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
        L6:
            return r0.getLivePlayerView();
        }

        @Override // ly.u
        public final IRoom getRoom() {
            IPreviewMultiLinkOuterConfigProvider r0 = this.a.a;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
        L6:
            return r0.getRoom();
        }

        @Override // ly.u
        public final IBaseUser getUser() {
            return k.n(IMiddlewareUserService.class).user().b();
        }

        @Override // ly.u
        public final String n6() {
            IPreviewMultiLinkOuterConfigProvider r0 = this.a.a;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
        L6:
            return r0.getEnterFromMerge();
        }

        public b(AnchorModeDynamicFeedPreview r1) {
            this.a = r1;
        }
    }

    public static final class c implements s {
        public final /* synthetic */ AnchorModeDynamicFeedPreview a;

        public c(AnchorModeDynamicFeedPreview r1) {
            this.a = r1;
        }

        public final JsonObject C(my.b r4) {
            Intrinsics.checkNotNullParameter(r4, "getStatusData");
            boolean r0 = iy.b.a;
            iy.b.e("AnchorModeDynamicFeedPreview", "getLinkMicStatus type=" + r4.getType());
            List<iy.e> r1 = this.a.i;
            if (r1 == null) goto L11;
            Iterator r2 = ((ArrayList) r1).iterator();
        L6:
            if (r2.hasNext() == false) goto L16;
            iy.e r3 = (iy.e) r2.next();
            if (r3.c(r4.getType()) == false) goto L6;
            return r3.C(r4);
        L16:
            return null;
        L11:
            return null;
        }

        public final void P0(my.c r3, com.bytedance.android.live.liveinteract.jsbridge.method.k r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r3, "updateStatus");
            Intrinsics.checkNotNullParameter(r4, "updateCallback");
            boolean r6 = iy.b.a;
            iy.b.e("AnchorModeDynamicFeedPreview", "updateLinkMicStatus type=" + r3.getType() + " extra=" + r3.b);
            List<iy.e> r7 = this.a.i;
            if (r7 == null) goto L10;
            Iterator r8 = ((ArrayList) r7).iterator();
        L6:
            if (r8.hasNext() == false) goto L16;
            iy.e r0 = (iy.e) r8.next();
            if (r0.a(r3.getType()) == false) goto L6;
            r0.b(r3, r4);
            goto L6
        L16:
            return;
        }
    }

    public static final class d implements iy.h {
        public final /* synthetic */ AnchorModeDynamicFeedPreview a;

        @Override // iy.h
        public final ApiServerException B4(int r1, String r2) {
            Intrinsics.checkNotNullParameter(r2, "errMsg");
            return null;
        }

        @Override // iy.h
        public final boolean C4() {
            return false;
        }

        @Override // iy.h
        public final void Q1() {
        }

        @Override // iy.h
        public final String d() {
            return "";
        }

        @Override // iy.h
        public final int g() {
            return 0;
        }

        @Override // iy.h
        public final void m4() {
        }

        @Override // iy.h
        public final void n4(Function0<Unit> r2, Function0<Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "success");
            Intrinsics.checkNotNullParameter(r3, "failed");
        }

        @Override // iy.h
        public final void o4(t r1, ei6.a r2) {
        }

        @Override // iy.h
        public final Object q4() {
            return null;
        }

        @Override // iy.h
        public final l r4() {
            return null;
        }

        @Override // iy.h
        public final boolean v4() {
            return false;
        }

        @Override // iy.h
        public final Integer O0() {
            return Integer.valueOf(this.a.o);
        }

        public final com.bytedance.android.live.anchormodelink.handlers.d a() {
            h r0 = this.a.d;
            if (r0 == null) goto L8;
            ly.t r1 = r0.j;
            if (r1 != null) goto L7;
            return null;
        L7:
            return r1.a;
        L8:
            return null;
        }

        @Override // iy.h
        public Context getContext() {
            IPreviewMultiLinkOuterConfigProvider r0 = this.a.a;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
        L6:
            return r0.getContext();
        }

        @Override // iy.h
        public final IRoomBase getRoom() {
            IPreviewMultiLinkOuterConfigProvider r0 = this.a.a;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
        L6:
            return r0.getRoom();
        }

        @Override // iy.h
        public final void p4() {
            Intrinsics.checkNotNullParameter("Jsb invoke", "string");
            Intrinsics.checkNotNullParameter("Jsb invoke", "string");
        }

        @Override // iy.h
        public final boolean t4() {
            return ((Boolean) vm2.d.f.getValue(null, vm2.d.a[4])).booleanValue();
        }

        @Override // iy.h
        public final void x4() {
            Intrinsics.checkNotNullParameter("Jsb invoke", "string");
            Intrinsics.checkNotNullParameter("Jsb invoke", "string");
        }

        @Override // iy.h
        public final long y4() {
            boolean r0 = ky.a.a;
            return vm2.d.c0().getTalkingStateInterval();
        }

        public d(AnchorModeDynamicFeedPreview r1) {
            this.a = r1;
        }

        @Override // iy.h
        public final void A4(JsonObject r7) {
            Intrinsics.checkNotNullParameter(r7, "extra");
            if (this.a.c != 5) goto L32;
            int r0 = JsbParamParseUtil.a;
            Intrinsics.checkNotNullParameter(r7, "params");
            oy.c r1 = null;
            JsonElement r8 = r7.get("params");     // Catch: Exception -> L25
            if (r8 == null) goto L12;
            JsonObject r9 = r8.getAsJsonObject();     // Catch: Exception -> L25
            if (r9 == null) goto L12;
            JsonElement r11 = r9.get("to");     // Catch: Exception -> L25
            if (r11 == null) goto L12;
            JsonObject r12 = r11.getAsJsonObject();     // Catch: Exception -> L25
        L13:
            if (r12 == null) goto L21;
            JsonElement r13 = r12.get("uiAttributes");     // Catch: Exception -> L25
            if (r13 == null) goto L21;
            JsonObject r14 = r13.getAsJsonObject();     // Catch: Exception -> L25
            if (r14 == null) goto L21;
            JsonElement r15 = r14.get("playerFrame");     // Catch: Exception -> L25
            if (r15 == null) goto L21;
            JsonObject r16 = r15.getAsJsonObject();     // Catch: Exception -> L25
        L22:
            if (r16 == null) goto L27;
            r1 = new oy.c(s1.e(r16.get("x").getAsFloat()), s1.e(r16.get("y").getAsFloat()), s1.e(r16.get("w").getAsFloat()), s1.e(r16.get("h").getAsFloat()));     // Catch: Exception -> L25
        L27:
            if (r1 == null) goto L33;
            AnchorModeDynamicFeedPreview r17 = this.a;
            r17.k = r1;
            r17.e(r1);
            return;
        L33:
            return;
        L21:
            r16 = null;
        L12:
            r12 = null;
        L25:
            e = move-exception;
            boolean r2 = iy.b.a;
            iy.b.b("getSeatViewContainerConfig parseJson error: (cause:" + e.getCause() + " message:" + e.getMessage() + " stack: " + bytekn.foundation.utils.b.a(e, 3) + ')');
            goto L27
        }

        @Override // iy.h
        public final void s4(JSONObject r3) {
            Intrinsics.checkNotNullParameter(r3, "seiObj");
            h r0 = this.a.d;
            if (r0 == null) goto L10;
            Intrinsics.checkNotNullParameter(r3, "seiData");
            ly.t r1 = r0.j;
            if (r1 == null) goto L11;
            ih0.c r2 = r1.d;
            if (r2 == null) goto L12;
            r2.sendJsEvent("H5_sei", r3);
            return;
        L12:
            return;
        L11:
            return;
        }

        @Override // iy.h
        public final void w4(JsonObject r3) {
            Intrinsics.checkNotNullParameter("liveLinkCallBack", "eventName");
            h r0 = this.a.d;
            if (r0 == null) goto L6;
            r0.h("liveLinkCallBack", r3);
            return;
        }

        @Override // iy.h
        public final Object u4(String r3, o r4) {
            Intrinsics.checkNotNullParameter(r3, "liveCoreSetting");
            Intrinsics.checkNotNullParameter(r4, "setupLiveLinkParams");
            Intrinsics.checkNotNullParameter(r3, "liveCoreSetting");
            Intrinsics.checkNotNullParameter(r4, "setupLiveLinkParams");
            return null;
        }

        @Override // iy.h
        public final void z4(ny.e r1, ec6.a r2, Function0 r3, Function0 r4) {
            Intrinsics.checkNotNullParameter(r3, "onConfirm");
            Intrinsics.checkNotNullParameter(r4, "onCancel");
            Intrinsics.checkNotNullParameter(r3, "onConfirm");
            Intrinsics.checkNotNullParameter(r4, "onCancel");
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ AnchorModeDynamicFeedPreview a;

        public e(AnchorModeDynamicFeedPreview r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnchorModeDynamicFeedPreview r0 = this.a;     // Catch: Throwable -> L4
            int r1 = AnchorModeDynamicFeedPreview.r;     // Catch: Throwable -> L4
            r0.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ AnchorModeDynamicFeedPreview a;

        public f(AnchorModeDynamicFeedPreview r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnchorModeDynamicFeedPreview r0 = this.a;     // Catch: Throwable -> L4
            int r1 = AnchorModeDynamicFeedPreview.r;     // Catch: Throwable -> L4
            r0.b();     // Catch: Throwable -> L4
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
    }

    public final boolean c() {
        return false;
    }

    public HashMap<String, Object> getChatRoomEnterRoomExtraParam() {
        return null;
    }

    @Override // com.bytedance.android.live.anchormodelink.feed.b
    public String getFeedViewName() {
        return "AnchorModeDynamicFeedPreview";
    }

    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public JsonObject getLinkmicAreaFrameInfo() {
        return null;
    }

    public JsonObject getLinkmicSeatListInfo() {
        return null;
    }

    public int getMicSeatRvViewId() {
        return 0;
    }

    @Override // com.bytedance.android.live.anchormodelink.feed.b
    public View getViewCompat() {
        return this;
    }

    public /* bridge */ /* synthetic */ ViewModelStore getViewModelStore() {
        return ViewModelStoreOwnerCompat.-CC.$default$getViewModelStore(this);
    }

    public final int i() {
        return 0;
    }

    public final boolean k() {
        return false;
    }

    public final Integer a() {
        return Integer.valueOf(this.o);
    }

    public final void b() {
        com.bytedance.android.live.anchormodelink.feed.c r0 = this.b;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L6:
        if (r0.shouldUseNewLivePlayerLayout() == false) goto L8;
        return;
    L8:
        boolean r1 = iy.b.a;
        StringBuilder r2 = new StringBuilder("adjustContainerAndRenderView from:");
        IPreviewMultiLinkOuterConfigProvider r3 = this.a;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L11:
        r2.append(r3.getShowFrom());
        r2.append(" uiLayout=");
        r2.append(this.o);
        iy.b.e("AnchorModeDynamicFeedPreview", r2.toString());
        IPreviewMultiLinkOuterConfigProvider r4 = this.a;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L15:
        if (com.bytedance.android.live.liveinteract.utils.h.e(r4.getShowFrom()) == true) goto L57;
        IPreviewMultiLinkOuterConfigProvider r5 = this.a;
        if (r5 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L19:
        com.bytedance.android.live.liveinteract.utils.h.b(r5.getPlayerContainerAbility());
        com.bytedance.android.live.anchormodelink.feed.c r6 = this.b;
        if (r6 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L22:
        int r11 = r6.getContainerWidth();
        com.bytedance.android.live.anchormodelink.feed.c r7 = this.b;
        if (r7 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L25:
        int r12 = r7.l();
        IPreviewMultiLinkOuterConfigProvider r8 = this.a;
        if (r8 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L28:
        LivePlayerView r9 = r8.getLivePlayerView();
        LivePlayerView r13 = null;
        if (r9 == null) goto L31;
        IRenderView r14 = r9.getRenderView();
    L32:
        com.bytedance.android.live.anchormodelink.feed.c r15 = this.b;
        if (r15 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L35:
        IInteractPlayView r16 = r15.n();
        oy.c r17 = this.k;
        boolean r18 = ky.a.a;
        if (vm2.d.c0().getSearchFeedPlayerAdjustOpt() == true) goto L38;
    L41:
        if (r14 == null) goto L59;
        ViewGroup.LayoutParams r19 = r14.getLayoutParams();
        if ((r19 instanceof FrameLayout.LayoutParams) == true) goto L46;
        r19 = null;
    L46:
        if (((FrameLayout.LayoutParams) r19) == null) goto L60;
        if (r16 == null) goto L61;
        AnchorModeParseSeiData r21 = this.p;
        int r22 = this.o;
        LivePlayerView r23 = r14.getParent();
        if ((r23 instanceof LivePlayerView) == false) goto L52;
        r13 = r23;
    L52:
        LivePlayerView r24 = r13;
        Context r25 = getContext();
        IPreviewMultiLinkOuterConfigProvider r26 = this.a;
        if (r26 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L55:
        r16.resizePlayViewForNewLinkFeedView(r21, r22, r24, r25, r26.getRoom(), this.c, r11, r12);
        return;
    L61:
        return;
    L60:
        return;
    L59:
        return;
    L38:
        if (this.c != 5) goto L41;
        if (r17 == null) goto L41;
        e(r17);
        return;
    L31:
        r14 = null;
        goto L32
    }

    public Lifecycle getLifecycleCompat() {
        LifecycleRegistry r0 = this.e;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new LifecycleRegistry(this);
    }

    public final void j() {
        iy.b.e("AnchorModeDynamicFeedPreview", "onViewHolderPause");
        if (this.d == null) goto L6;
        iy.b.e("AnchorModeDynamicCardManager", "onPause");
        return;
    }

    public final void m() {
        iy.b.e("AnchorModeDynamicFeedPreview", "onViewHolderResume");
        h r1 = this.d;
        com.bytedance.android.live.anchormodelink.handlers.d r2 = null;
        if (r1 == null) goto L23;
        ly.t r3 = r1.j;
        if (r3 == null) goto L9;
        ih0.c r4 = r3.d;
        if (r4 == null) goto L9;
        View r5 = r4.S0();
    L10:
        StringBuilder r6 = new StringBuilder("onFeedResume is in self:");
        if (r5 == null) goto L13;
        ViewParent r7 = r5.getParent();
    L14:
        r6.append(Intrinsics.areEqual(r7, r1.d));
        r6.append(" ,cardView=");
        r6.append(r5);
        iy.b.e("AnchorModeDynamicCardManager", r6.toString());
        if (r5 == null) goto L23;
        if ((!Intrinsics.areEqual(r5.getParent(), r1.d)) == false) goto L23;
        u r8 = r1.i;
        if (r8 == null) goto L23;
        IRoomBase r9 = r8.getRoom();
        if (r9 == null) goto L23;
        r1.e(IRoomKtKt.getId(r9));
        goto L23
    L13:
        r7 = null;
    L9:
        r5 = null;
    L23:
        h r11 = this.d;
        if (r11 == null) goto L26;
        r11.c(this.q);
    L26:
        h r12 = this.d;
        if (r12 == null) goto L31;
        ly.t r13 = r12.j;
        if (r13 == null) goto L31;
        com.bytedance.android.live.anchormodelink.handlers.d r14 = r13.a;
    L33:
        if ((r14 instanceof com.bytedance.android.live.anchormodelink.handlers.d) == false) goto L36;
        r2 = r14;
    L36:
        if (r2 != null) goto L38;
        return;
    L38:
        iy.b.e("AnchorModeDynamicFeedPreview", "[seiHandler.setOutProvider] feed recover set");
        r2.j = this.l;
        return;
    L31:
        r14 = null;
        goto L33
    }

    public final void o() {
        iy.b.e("AnchorModeDynamicFeedPreview", "onViewHolderSelected");
        b();
        h r0 = this.d;
        if (r0 == null) goto L10;
        r0.k = true;
        ly.t r1 = r0.j;
        if (r1 == null) goto L11;
        ih0.c r2 = r1.d;
        if (r2 == null) goto L12;
        r2.updateData(r0.a());
        return;
    L12:
        return;
    L11:
        return;
    }

    public final MessageHub p() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L6:
        return r0.getMessageHub();
    }

    public final IRoom r() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L6:
        return r0.getRoom();
    }

    public final void release() {
        iy.b.e("AnchorModeDynamicFeedPreview", "release");
        h r0 = this.d;
        if (r0 == null) goto L5;
        r0.f();
    L5:
        this.d = null;
        ViewModelStore r1 = this.f;
        if (r1 == null) goto L8;
        r1.clear();
    L8:
        this.f = null;
        LifecycleRegistry r2 = this.e;
        if (r2 == null) goto L17;
        Lifecycle.State r3 = r2.getCurrentState();
        if (r3 == null) goto L17;
        if (r3.isAtLeast(Lifecycle.State.CREATED) != true) goto L17;
        LifecycleRegistry r4 = this.e;
        if (r4 == null) goto L17;
        r4.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    L17:
        this.e = null;
        this.g = null;
        this.h = null;
    }

    public final void s() {
        iy.b.e("AnchorModeDynamicFeedPreview", "onViewHolderUnSelected");
    }

    public final ViewModelStore tf() {
        ViewModelStore r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new ViewModelStore();
    }

    public final void l() {
        b();
    }

    public final void e(oy.c r14) {
        com.bytedance.android.live.anchormodelink.feed.c r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L5:
        int r1 = r0.getContainerWidth();
        com.bytedance.android.live.anchormodelink.feed.c r2 = this.b;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L8:
        int r3 = r2.l();
        int r4 = s1.y();
        float r5 = r1;
        float r6 = r4;
        float r7 = r3;
        float r8 = s1.w() + StatusBarUtil.getStatusBarHeight(getContext());
        float r9 = Math.min(r5 / r6, r7 / r8);
        float r11 = r14.a * r9;
        float r12 = (r14.b * r9) + ((r7 - (r8 * r9)) / 2.0f);
        RectF r13 = new RectF(((r5 - (r6 * r9)) / 2.0f) + r11, r12, r11 + (r14.c * r9), (r14.d * r9) + r12);
        IPreviewMultiLinkOuterConfigProvider r15 = this.a;
        if (r15 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L11:
        LivePlayerView r16 = r15.getLivePlayerView();
        View r17 = null;
        if (r16 == null) goto L14;
        View r18 = r16.getRenderView();
    L15:
        boolean r19 = r18 instanceof View;
        if (r19 == true) goto L18;
        View r21 = null;
    L19:
        View r22 = r21;
        if (r22 == null) goto L36;
        if (r19 == true) goto L23;
        View r110 = null;
    L24:
        View r111 = r110;
        if (r111 == null) goto L27;
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
    L29:
        if ((r112 instanceof ViewGroup.MarginLayoutParams) == true) goto L31;
        r112 = null;
    L31:
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112;
        if (r113 == null) goto L34;
        r113.width = (int) r13.width();
        r113.height = (int) r13.height();
        r113.topMargin = (int) r13.top;
        r113.leftMargin = (int) r13.left;
        Unit r114 = Unit.INSTANCE;
    L35:
        r22.setLayoutParams(r113);
        goto L36
    L34:
        r113 = null;
        goto L35
    L27:
        r112 = null;
        goto L29
    L23:
        r110 = r18;
    L36:
        float r23 = r7 * (r6 / r8);
        int r24 = (int) ((r5 - r23) / 2.0f);
        Rect r25 = new Rect(r24, 0, (int) (r24 + r23), r3);
        Rect r26 = new Rect(0, 0, r1, r3);
        float r27 = r13.left;
        float r28 = r25.left;
        if (r27 >= r28) goto L39;
        r26.left = (int) (r28 - r27);
    L39:
        if (r19 == false) goto L42;
        r17 = r18;
    L42:
        View r29 = r17;
        if (r29 == null) goto L46;
        r29.requestLayout();
        return;
    L46:
        return;
    L18:
        r21 = r18;
        goto L19
    L14:
        r18 = null;
        goto L15
    }

    public final void g(AnchorModeParseSeiData r3) {
        Intrinsics.checkNotNullParameter(r3, "seiAppData");
        boolean r0 = iy.b.a;
        iy.b.a("AnchorModeDynamicFeedPreview", "onSeiAppDataUpdated seiAppData:" + r3);
        IPreviewMultiLinkOuterConfigProvider r4 = this.a;
        if (r4 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L6:
        if (r4.getFeedLiveType() != 5) goto L9;
        post(new e(this));
        return;
    }

    public final void h(String r3) {
        Intrinsics.checkNotNullParameter(r3, "seiString");
        boolean r0 = iy.b.a;
        iy.b.a("AnchorModeDynamicFeedPreview", "onSeiUpdated seiString:".concat(r3));
        com.bytedance.android.live.anchormodelink.handlers.d r1 = this.j;
        if (r1 == null) goto L6;
        r1.j(r3);
        return;
    }

    public final void f(IPreviewMultiLinkOuterConfigProvider r12, com.bytedance.android.live.anchormodelink.feed.c r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r12, "configOuterProvider");
        Intrinsics.checkNotNullParameter(r13, "configInnerProvider");
        boolean r1 = iy.b.a;
        iy.b.e("AnchorModeDynamicFeedPreview", "init scope:" + this.q);
        this.a = r12;
        this.b = r13;
        this.c = r12.getShowFrom();
        if (this.e != null) goto L6;
        this.e = new LifecycleRegistry(this);
    L6:
        if (this.f != null) goto L9;
        this.f = new ViewModelStore();
    L9:
        if (this.g != null) goto L12;
        this.g = new ViewModelProvider(this);
    L12:
        if (this.h != null) goto L14;
        this.h = DataCenter.create(this.g, this);
    L14:
        IPreviewMultiLinkOuterConfigProvider r15 = this.a;
        if (r15 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L17:
        r15.getContainerView().post(new com.bytedance.android.live.anchormodelink.feed.a(this));
        Context r2 = getContext();
        DataCenter r3 = this.h;
        Intrinsics.checkNotNull(r3);
        h r16 = new h(r2, r3, this, true, r12.getFeedLiveType(), false, (ViewGroup) getParent(), this.m, this.n);
        this.d = r16;
        r16.g(r12.getRoom().getRoomId(), !r14);
        h r17 = this.d;
        if (r17 == null) goto L20;
        r17.c(this.q);
    L20:
        com.bytedance.android.live.anchormodelink.handlers.d r18 = this.l.a();
        if (r18 == null) goto L25;
        this.j = r18;
        r18.j = this.l;
        List<iy.e> r19 = this.i;
        if (r19 == null) goto L25;
        ((ArrayList) r19).add(r18);
    L25:
        h r110 = this.l.a.d;
        if (r110 == null) goto L30;
        ly.t r111 = r110.j;
        if (r111 == null) goto L30;
        com.bytedance.android.live.anchormodelink.handlers.a r112 = r111.b;
    L31:
        if (r112 == null) goto L35;
        List<iy.e> r113 = this.i;
        if (r113 == null) goto L35;
        ((ArrayList) r113).add(r112);
    L35:
        List<iy.e> r114 = this.i;
        if (r114 == null) goto L41;
        Iterator r115 = ((ArrayList) r114).iterator();
    L39:
        if (r115.hasNext() == false) goto L43;
        ((iy.e) r115.next()).onStart();
        goto L39
    L43:
        return;
    L41:
        return;
    L30:
        r112 = null;
        goto L31
    }

    public final void t(AnchorModeParseSeiData r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "seiData");
        boolean r0 = iy.b.a;
        iy.b.e("AnchorModeDynamicFeedPreview", "updateUILayout seiVer=" + r4 + ", uiLayout=" + r5);
        this.p = r3;
        this.o = r5;
        post(new f(this));
        if (this.d == null) goto L6;
        iy.b.e("AnchorModeDynamicCardManager", "onLayoutChange uiLayout：" + r5);
        return;
    }

    public final void updateViewInLiveBg(String r2, JsonObject r3, ih0.h r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "updateCallback");
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.b.a.a(r2, r3, (l0) r4);
    }

    public AnchorModeDynamicFeedPreview(Context r3, int r4, AnchorModeParseSeiData r5, j r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "seiData");
        super(r3, null, 0);
        this.o = r4;
        this.p = r5;
        this.q = r6;
        this.i = new ArrayList();
        this.l = new d(this);
        this.m = new c(this);
        this.n = new b(this);
    }
}

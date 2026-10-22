package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.context.MultiLinkDynamicContext;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.AudioChatStageUpdateType;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.StageItemId;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.SubtitleUpdateType;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.config.h30;
import com.bytedance.android.livesdk.config.nb0;
import com.bytedance.android.livesdk.config.oa1;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.android.livesdkapi.util.IMultiScenePreviewStatistics;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.text.StringsKt;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/MultiLinkFeedDynamicWidgetNew;", "Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/live/liveinteract/jsbridge/method/t;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkFeedDynamicWidgetNew implements com.bytedance.android.live.liveinteract.plantform.dynamicframe.a, Observer<KVData>, com.bytedance.android.live.liveinteract.jsbridge.method.t {
    public final eh0.b A;
    public final String B;
    public MultiLinkFeedHybridCardManager a;
    public final LinkedHashMap<String, o> b;
    public final CompositeDisposable c;
    public final LinkedHashMap<String, ih0.g> d;
    public final Map<String, ih0.c> e;
    public IRoom f;
    public mh0.h g;
    public mh0.p h;
    public mh0.d i;
    public mh0.f j;
    public mh0.b k;
    public mh0.i l;
    public mh0.j m;
    public List<? extends lh0.a> n;
    public final Map<String, WeakReference<vlc.l>> o;
    public boolean p;
    public boolean q;
    public final ViewGroup r;
    public final Context s;
    public final DataCenter t;
    public final b u;
    public final c v;
    public final int w;
    public final ue0.c x;
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.d y;
    public final eh0.b z;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.dynamicframe.MultiLinkFeedDynamicWidgetNew$onDestroy$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0Impl {
        public AnonymousClass1(MultiLinkFeedDynamicWidgetNew r7) {
            super(r7, MultiLinkFeedDynamicWidgetNew.class, "handlerList", "getHandlerList()Ljava/util/List;", 0);
        }

        public Object get() {
            List<? extends lh0.a> r0 = ((MultiLinkFeedDynamicWidgetNew) ((CallableReference) this).receiver).n;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("handlerList");
        L5:
            return r0;
        }

        public void set(Object r2) {
            List<? extends lh0.a> r3 = (List) r2;
            ((MultiLinkFeedDynamicWidgetNew) ((CallableReference) this).receiver).n = r3;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.dynamicframe.MultiLinkFeedDynamicWidgetNew$onPause$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class C03051 extends MutablePropertyReference0Impl {
        public C03051(MultiLinkFeedDynamicWidgetNew r7) {
            super(r7, MultiLinkFeedDynamicWidgetNew.class, "handlerList", "getHandlerList()Ljava/util/List;", 0);
        }

        public Object get() {
            List<? extends lh0.a> r0 = ((MultiLinkFeedDynamicWidgetNew) ((CallableReference) this).receiver).n;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("handlerList");
        L5:
            return r0;
        }

        public void set(Object r2) {
            List<? extends lh0.a> r3 = (List) r2;
            ((MultiLinkFeedDynamicWidgetNew) ((CallableReference) this).receiver).n = r3;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.dynamicframe.MultiLinkFeedDynamicWidgetNew$onResume$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class C03061 extends MutablePropertyReference0Impl {
        public C03061(MultiLinkFeedDynamicWidgetNew r7) {
            super(r7, MultiLinkFeedDynamicWidgetNew.class, "handlerList", "getHandlerList()Ljava/util/List;", 0);
        }

        public Object get() {
            List<? extends lh0.a> r0 = ((MultiLinkFeedDynamicWidgetNew) ((CallableReference) this).receiver).n;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("handlerList");
        L5:
            return r0;
        }

        public void set(Object r2) {
            List<? extends lh0.a> r3 = (List) r2;
            ((MultiLinkFeedDynamicWidgetNew) ((CallableReference) this).receiver).n = r3;
        }
    }

    static {
    }

    @Override // ih0.b
    public final JsonObject Nm() {
        Intrinsics.checkNotNullParameter("adventure", "bizId");
        Intrinsics.checkNotNullParameter("state", "key");
        return null;
    }

    @Override // ih0.b
    public final Object Xg() {
        return null;
    }

    @Override // ih0.b
    public final ih0.c Z9() {
        return null;
    }

    @Override // ih0.b
    public final boolean isDynamicAnimating() {
        return false;
    }

    @Override // ih0.b
    public final boolean jl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "bizId");
        return false;
    }

    @Override // ih0.b
    public final Object ql(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        return null;
    }

    @Override // ih0.b
    public final void setDynamicAnimatorListener(Function0<Unit> r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.a
    public final void Kk() {
        MultiLinkFeedHybridCardManager r0 = this.a;
        if (r0 == null) goto L5;
        ih0.c r1 = r0.a;
    L6:
        fa(r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // ih0.b
    public final Map<Integer, List<Integer>> Pl() {
        mh0.p r0 = this.h;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("micSeatHandler");
    L6:
        return r0.g;
    }

    @Override // ih0.b
    public final Map<String, LayoutConfigModel> en() {
        mh0.p r0 = this.h;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("micSeatHandler");
    L6:
        return r0.f;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.a
    public final void initDataContext() {
        Pair r0 = com.bytedance.live.datacontext.d.a(MultiLinkFeedDynamicWidgetNew$initDataContext$pair$1.INSTANCE);
        MultiLinkDynamicContext r1 = (MultiLinkDynamicContext) r0.getFirst();
        r1.getServiceMutable().setValue(this);
        r1.isFeed().d(Boolean.TRUE);
        if (((Boolean) oa1.a.getValue()).booleanValue() == false) goto L11;
        com.bytedance.live.datacontext.b.a(r1, "MultiLinkDynamicFeedContext");
        if (((Boolean) nb0.a.getValue()).booleanValue() == false) goto L12;
        IRoom r2 = this.u.r();
        if (r2 == null) goto L9;
        Object r3 = Long.valueOf(r2.getRoomId());
    L10:
        com.bytedance.live.datacontext.b.a(r1, "MultiLinkDynamicFeedContext_" + r3);
        goto L12
    L9:
        r3 = "";
    L12:
        this.c.add((Disposable) r0.getSecond());
        return;
    L11:
        com.bytedance.live.datacontext.b.a(r1, com.bytedance.android.live.liveinteract.plantform.dynamicframe.context.b.class);
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.a
    public final void onDestroy() {
        ALogger.i("MultiLinkFeedDynamicWidget", "onDestroy");
        Iterator<o> r1 = this.b.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().a("feed_root_widget_destroy");
        goto L4
    L6:
        ALogger.i("MultiLinkFeedDynamicWidget", "解除麦位监听， dataCenter=" + this.t);
        DataCenter r0 = this.t;
        if (r0 == null) goto L9;
        r0.removeObserver("data_multi_lick_dynamic_event_change", this);
    L9:
        DataCenter r2 = this.t;
        if (r2 == null) goto L12;
        r2.removeObserver("data_multi_lick_dynamic_widget_start", this);
    L12:
        DataCenter r3 = this.t;
        if (r3 == null) goto L15;
        r3.removeObserver("data_multi_link_dynamic_layout_info_change", this);
    L15:
        DataCenter r4 = this.t;
        if (r4 == null) goto L18;
        r4.removeObserver("data_multi_link_dynamic_guest_list_change", this);
    L18:
        this.b.clear();
        MultiLinkFeedHybridCardManager r5 = this.a;
        if (r5 == null) goto L43;
        ALogger.i("MultiLinkFeedHybridCardManager", "MultiLinkMainHybridCardManager onDestroy");
        if (vm2.h.O().a() == false) goto L23;
        int r6 = d0.a;
        d0.d(r5.a, r5.h, r5.j.p());
    L31:
        if (vm2.h.O().e() == false) goto L33;
        int r7 = z0.b;
        z0.g(r5.b, r5.h, r5.j.p());
    L40:
        j r8 = r5.c;
        if (r8 == null) goto L43;
        r8.a();
        goto L43
    L33:
        ih0.c r9 = r5.b;
        if (r9 == null) goto L36;
        r9.J();
    L36:
        ih0.c r10 = r5.b;
        if (r10 == null) goto L39;
        r10.release();
    L39:
        r5.b = null;
        goto L40
    L23:
        ih0.c r11 = r5.a;
        if (r11 == null) goto L31;
        r11.release();
        ViewGroup r12 = r5.i;
        ih0.c r13 = r5.a;
        if (r13 == null) goto L28;
        View r14 = r13.S0();
    L29:
        r12.removeView(r14);
        goto L31
    L28:
        r14 = null;
    L43:
        ((LinkedHashMap) this.e).clear();
        this.c.clear();
        int r15 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.plantform.multiroom.e.e(this.t, null, null);
        List<? extends lh0.a> r16 = this.n;
        if (r16 == null) goto L49;
        Iterator<T> r17 = r16.iterator();
    L47:
        if (r17.hasNext() == false) goto L52;
        ((lh0.a) r17.next()).d();
        goto L47
    L52:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.a
    public final void onPause() {
        List<? extends lh0.a> r0 = this.n;
        if (r0 == null) goto L10;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("handlerList");
    L6:
        Iterator<T> r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((lh0.a) r1.next()).getClass();
    L10:
        this.q = true;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.a
    public final void onResume() {
        List<? extends lh0.a> r0 = this.n;
        if (r0 == null) goto L11;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("handlerList");
    L6:
        Iterator<T> r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L11;
        ((lh0.a) r1.next()).getClass();
    L11:
        if (this.q == false) goto L15;
        this.q = false;
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.a
    public final void onViewHolderSelected() {
        mh0.p r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("micSeatHandler");
    L5:
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r1 = r0.t;
        if (r1 == null) goto L13;
        BehaviorSubject<List<tf0.e>> r2 = r1.b;
        if (r2 == null) goto L14;
        List<? extends tf0.e> r3 = (List) r2.getValue();
        if (r3 == null) goto L15;
        r0.k(r3);
        r0.l(r3);
        r0.j(r3);
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // ih0.b
    public final ih0.c oo() {
        Intrinsics.checkNotNullParameter("radio_stage", "itemId");
        Map<String, ih0.c> r0 = this.e;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (ih0.c) ((LinkedHashMap) r0).get("radio_stage");
    }

    @Override // ih0.b
    public final ih0.c tb() {
        MultiLinkFeedHybridCardManager r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    @Override // ih0.b
    public final void Ll(List<? extends tf0.e> r3) {
        mh0.p r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("micSeatHandler");
    L5:
        if (r0 == null) goto L8;
        r0.k(r3);
        return;
    }

    @Override // ih0.b
    public final JsonObject T(ih0.e r12) {
        Intrinsics.checkNotNullParameter(r12, "getStatusData");
        JsonObject r1 = r12.c;
        JsonObject r4 = null;
        if (r1 != null) goto L6;
        ALogger.e("MultiLinkFeedDynamicWidget", "get status but getExtraInfo is empty");
        return null;
    L6:
        char r6 = 0;
        boolean r7 = false;
        r7 = false;
        r7 = false;
        int r8 = 0;
        r8 = 0;
        r8 = 0;
        r8 = 0;
        int r9 = 0;
        r9 = 0;
        r9 = 0;
        if (r12.b.length() != 0) goto L9;
        boolean r5 = true;
    L11:
        if (r5 == false) goto L14;
        ALogger.e("MultiLinkFeedDynamicWidget", "get status but fromBizId is empty");
        return null;
    L14:
        ALogger.i("MultiLinkFeedDynamicWidget", "get status getExtraInfo=" + r1);
        switch(l.b[r12.getType().ordinal()]) {
            case 1: goto L200;
            case 2: goto L200;
            case 3: goto L200;
            case 4: goto L182;
            case 5: goto L171;
            case 6: goto L53;
            case 7: goto L37;
            case 8: goto L17;
            default: goto L16;
        };
    L16:
        return null;
    L17:
        mh0.i r2 = this.l;
        if (r2 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("interactiveOrderSongHandler");
    L20:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r12, "getStatusData");
        JsonObject r13 = r12.c;
        if (r13 == null) goto L36;
        if (r13.has("type") != true) goto L36;
        JsonElement r14 = r13.get("type");
        if (r14 == null) goto L27;
        r4 = r14.getAsString();
    L27:
        if (r4 == null) goto L36;
        if (r4.hashCode() != (-127455574)) goto L36;
        if (r4.equals("particle_ready") == false) goto L36;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.m.a(r2.e);
    L36:
        return new JsonObject();
    L37:
        mh0.j r3 = this.m;
        if (r3 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("ktvHandler");
    L40:
        r3.getClass();
        Intrinsics.checkNotNullParameter(r12, "getStatusData");
        JsonObject r0 = r12.c;
        if (r0 == null) goto L222;
        ALogger.i("KtvFeedDynamicHandler", "get status getExtraInfo=" + r0 + ", type = " + r12.getType());
        if (mh0.k.b[r12.getType().ordinal()] != 1) goto L223;
        IKtvService r10 = jc1.k.f(IKtvService.class);
        if (r10 == null) goto L50;
        JsonObject r15 = r10.handleKtvCommonJsbGetAction(r12.c, true);
        if (r15 == null) goto L50;
    L52:
        return r15;
    L50:
        r15 = new JsonObject();
        goto L52
    L223:
        return null;
    L222:
        return null;
    L53:
        mh0.f r11 = this.j;
        if (r11 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("avatarHandler");
    L56:
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "getStatusData");
        JsonObject r16 = r12.c;
        if (r16 == null) goto L224;
        ALogger.i(r11.e, "get status getExtraInfo=" + r16 + ", type = " + r12.getType());
        if (mh0.e.a[r12.getType().ordinal()] != 1) goto L225;
        JsonObject r17 = new JsonObject();
        String r18 = r16.get("type").getAsString();
        if (r18 == null) goto L170;
        switch(r18.hashCode()) {
            case -1822196135: goto L159;
            case -1094219786: goto L151;
            case -934592106: goto L124;
            case 245675462: goto L105;
            case 396970964: goto L87;
            case 735062463: goto L69;
            default: goto L170;
        };
    L69:
        if (r18.equals("big_head") == false) goto L170;
        HamletAvatarContext.a r19 = HamletAvatarContext.Companion;
        HamletAvatarContext r20 = r19.getContext();
        if (r20 == null) goto L77;
        com.bytedance.live.datacontext.j<gd0.g> r21 = r20.getHamletAvatarService();
        if (r21 == null) goto L77;
        gd0.g r22 = (gd0.g) r21.getValue();
        if (r22 == null) goto L77;
        boolean r23 = r22.kl();
    L78:
        HamletAvatarContext r24 = r19.getContext();
        if (r24 == null) goto L85;
        com.bytedance.live.datacontext.j<gd0.g> r25 = r24.getHamletAvatarService();
        if (r25 == null) goto L85;
        gd0.g r26 = (gd0.g) r25.getValue();
        if (r26 == null) goto L85;
        r7 = r26.mg(0);
    L85:
        ALogger.w("HamletAvatar", "get bighead status,  isAvatarRender=" + r23 + ", isFirstEnlargeUserTalking=" + r7);
        JsonObject r27 = new JsonObject();
        r27.addProperty("display", Boolean.valueOf(r23 ^ true));
        r27.addProperty("talking", Boolean.valueOf(r7));
        Unit r28 = Unit.INSTANCE;
        r17.add("avatar", r27);
    L77:
        r23 = true;
        goto L78
    L87:
        if (r18.equals("avatar_info") == false) goto L170;
        JsonArray r29 = new JsonArray();
        HamletAvatarContext r30 = HamletAvatarContext.Companion.getContext();
        if (r30 == null) goto L96;
        Map<Long, Float> r31 = r30.getDownloadAvatarProgressRecord();
        if (r31 == null) goto L96;
        Iterator<Map.Entry<Long, Float>> r32 = r31.entrySet().iterator();
    L94:
        if (r32.hasNext() == false) goto L96;
        Map.Entry<Long, Float> r33 = r32.next();
        long r34 = r33.getKey().longValue();
        float r35 = r33.getValue().floatValue();
        JsonObject r36 = new JsonObject();
        r36.addProperty("avatar_id", Long.valueOf(r34));
        r36.addProperty("progress", Float.valueOf(r35));
        Unit r37 = Unit.INSTANCE;
        r29.add(r36);
    L96:
        JsonObject r38 = new JsonObject();
        HamletAvatarContext r39 = HamletAvatarContext.Companion.getContext();
        if (r39 == null) goto L103;
        com.bytedance.live.datacontext.j<gd0.g> r40 = r39.getHamletAvatarService();
        if (r40 == null) goto L103;
        gd0.g r41 = (gd0.g) r40.getValue();
        if (r41 == null) goto L103;
        r4 = r41.Ue();
    L103:
        r38.addProperty("avatar_id", r4);
        r38.add("avatar_progress", r29);
        Unit r42 = Unit.INSTANCE;
        r17.add("avatar", r38);
        goto L170
    L105:
        if (r18.equals("multi_camera_status") == false) goto L170;
        StringBuilder r43 = new StringBuilder("multi_camera_status, hasMultiCamera, ");
        HamletAvatarContext.a r44 = HamletAvatarContext.Companion;
        HamletAvatarContext r45 = r44.getContext();
        if (r45 == null) goto L113;
        com.bytedance.live.datacontext.j<gd0.g> r46 = r45.getHamletAvatarService();
        if (r46 == null) goto L113;
        gd0.g r47 = (gd0.g) r46.getValue();
        if (r47 == null) goto L113;
        r4 = Boolean.valueOf(r47.ib());
    L113:
        r43.append(r4);
        ALogger.w("HamletAvatar", r43.toString());
        JsonObject r48 = new JsonObject();
        HamletAvatarContext r49 = r44.getContext();
        if (r49 == null) goto L122;
        com.bytedance.live.datacontext.j<gd0.g> r50 = r49.getHamletAvatarService();
        if (r50 == null) goto L122;
        gd0.g r51 = (gd0.g) r50.getValue();
        if (r51 == null) goto L122;
        if (r51.ib() != true) goto L122;
        r8 = 1;
    L122:
        r48.addProperty("multi_camera_status", Integer.valueOf(r8));
        Unit r52 = Unit.INSTANCE;
        r17.add("avatar", r48);
        goto L170
    L124:
        if (r18.equals("render") == false) goto L170;
        HamletAvatarContext.a r53 = HamletAvatarContext.Companion;
        HamletAvatarContext r54 = r53.getContext();
        if (r54 == null) goto L132;
        com.bytedance.live.datacontext.j<gd0.g> r55 = r54.getHamletAvatarService();
        if (r55 == null) goto L132;
        gd0.g r56 = (gd0.g) r55.getValue();
        if (r56 == null) goto L132;
        boolean r57 = r56.kl();
    L133:
        HamletAvatarContext r58 = r53.getContext();
        if (r58 == null) goto L140;
        com.bytedance.live.datacontext.m<Boolean> r59 = r58.isStreamRending();
        if (r59 == null) goto L140;
        if (((Boolean) r59.getValue()).booleanValue() != true) goto L140;
        r9 = 1;
    L140:
        ALogger.w("HamletAvatar", "get Avatar isRender=" + r57 + "， hamletContext=" + r53.getContext());
        JsonObject r60 = new JsonObject();
        r60.addProperty("is_render", Boolean.valueOf(r57));
        HamletAvatarContext r61 = r53.getContext();
        if (r61 == null) goto L148;
        com.bytedance.live.datacontext.n<Long> r62 = r61.getCurrentSelectAvatarID();
        if (r62 == null) goto L148;
        Long r63 = (Long) r62.getValue();
        if (r63 == null) goto L148;
        String r65 = String.valueOf(r63.longValue());
        if (r65 == null) goto L148;
    L149:
        r60.addProperty("avatar_id", r65);
        r60.addProperty("is_xplay_running", Integer.valueOf(r9));
        Unit r66 = Unit.INSTANCE;
        r17.add("avatar", r60);
    L148:
        r65 = "0";
    L132:
        r57 = false;
        goto L133
    L151:
        if (r18.equals("topleft_seat_frame") == false) goto L170;
        IInteractService r67 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r67 == null) goto L157;
        qd0.a r68 = r67.getAudioTalkService();
        if (r68 == null) goto L157;
        r4 = r68.getTopLeftSeatFrameInfo();
    L157:
        ALogger.w("HamletAvatar", "get topleft_seat_frame frameInfo=" + GsonProtectorUtils.toJson(GsonHelper.get(), r4));
        r17.add("avatar", r4);
        goto L170
    L159:
        if (r18.equals("default_animation_index") == false) goto L170;
        HamletAvatarContext r69 = HamletAvatarContext.Companion.getContext();
        if (r69 == null) goto L167;
        com.bytedance.live.datacontext.n<Long> r70 = r69.getCurrentSelectAnimationIndex();
        if (r70 == null) goto L167;
        Long r71 = (Long) r70.getValue();
        if (r71 == null) goto L167;
        long r72 = r71.longValue();
    L168:
        JsonObject r73 = new JsonObject();
        r73.addProperty("default_animation_index", Long.valueOf(r72));
        Unit r74 = Unit.INSTANCE;
        r17.add("avatar", r73);
    L167:
        r72 = 0;
    L170:
        return r17;
    L225:
        return null;
    L224:
        return null;
    L171:
        mh0.b r75 = this.k;
        if (r75 != null) goto L174;
        Intrinsics.throwUninitializedPropertyAccessException("audioChatStageHandler");
    L174:
        r75.getClass();
        Intrinsics.checkNotNullParameter(r12, "getStatusData");
        JsonObject r76 = r12.c;
        if (r76 == null) goto L226;
        ALogger.i(r75.e, "get status getExtraInfo=" + r76 + ", type = " + r12.getType());
        if (mh0.a.b[r12.getType().ordinal()] != 1) goto L227;
        JsonObject r77 = new JsonObject();
        int r110 = com.bytedance.android.live.liveinteract.voicechat.subtitle.g0.a;
        r77.addProperty("guest_subtitle_option", Boolean.TRUE);
        r77.addProperty("subtitle_status", Boolean.valueOf(r75.d.k()));
        r77.addProperty("show_recognition_lyrics", Boolean.valueOf(r75.d.c()));
        return r77;
    L227:
        return null;
    L226:
        return null;
    L182:
        mh0.h r78 = this.g;
        if (r78 != null) goto L185;
        Intrinsics.throwUninitializedPropertyAccessException("basicHandler");
    L185:
        r78.getClass();
        Intrinsics.checkNotNullParameter(r12, "getStatusData");
        JsonObject r79 = r12.c;
        if (r79 != null) goto L189;
        ALogger.e("MultiLinkFeedDynamicWidget", "get status but getExtraInfo is empty");
    L199:
        return r4;
    L189:
        if (r12.b.length() != 0) goto L191;
        r6 = 1;
    L191:
        if (r6 == 0) goto L193;
        ALogger.e("MultiLinkFeedDynamicWidget", "get status but fromBizId is empty");
        goto L199
    L193:
        ALogger.i("MultiLinkFeedDynamicWidget", "get status getExtraInfo=" + r79);
        if (mh0.g.b[r12.getType().ordinal()] != 1) goto L199;
        r4 = new JsonObject();
        IRoom r111 = r78.b();
        if (r111 == null) goto L199;
        r4.add(PbRequest.SwitchType.ROOM, GsonProtectorUtils.toJsonTree(new Gson(), r111).getAsJsonObject());
        goto L199
    L200:
        mh0.p r80 = this.h;
        if (r80 != null) goto L203;
        Intrinsics.throwUninitializedPropertyAccessException("micSeatHandler");
    L203:
        r80.getClass();
        Intrinsics.checkNotNullParameter(r12, "getStatusData");
        JsonObject r81 = r12.c;
        if (r81 == null) goto L232;
        ALogger.i(r80.e, "get status getExtraInfo=" + r81 + ", type = " + r12.getType());
        int r112 = mh0.l.b[r12.getType().ordinal()];
        if (r112 != 1) goto L209;
        JsonObject r82 = new JsonObject();
        r82.addProperty("ui_layout", r80.d.a());
        r82.addProperty("scene", Integer.valueOf(r80.d.i()));
        return r82;
    L209:
        if (r112 != 2) goto L211;
        IRoom r113 = r80.b();
        if (r113 != null) goto L217;
        return null;
    L217:
        if (r113.isLiveTypeAudio() == true) goto L231;
        return null;
    L231:
        return r80.d.getLinkmicSeatListInfo();
    L211:
        if (r112 == 3) goto L228;
        return null;
    L228:
        return r80.d.getLinkmicAreaFrameInfo();
    L232:
        return null;
    L9:
        r5 = false;
        goto L11
    }

    @Override // ih0.b
    public final void Tl(ih0.c r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Iterator r0 = ((LinkedHashMap) this.e).entrySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        if (Intrinsics.areEqual((ih0.c) ((Map.Entry) r0.next()).getValue(), r3) == false) goto L6;
        r0.remove();
        goto L6
    }

    @Override // ih0.b
    public final vlc.l U6(String r2) {
        Intrinsics.checkNotNullParameter(r2, "listenerId");
        WeakReference r3 = (WeakReference) ((LinkedHashMap) this.o).get(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return (vlc.l) r3.get();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.a
    public final void Wf(Integer r8) {
        mh0.p r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("micSeatHandler");
    L5:
        r0.getClass();
        if (r8 == null) goto L70;
        r8.intValue();
        Integer r1 = r0.d.a();
        if (r1 != null) goto L11;
        return;
    L11:
        if (r1.intValue() == 28) goto L13;
        return;
    L13:
        if ((!Intrinsics.areEqual(r0.v, r8)) == false) goto L72;
        r0.v = r8;
        if (r8.intValue() != 1) goto L17;
        boolean r9 = true;
    L18:
        JsonObject r3 = new JsonObject();
        r3.addProperty("type", "render");
        JsonObject r4 = new JsonObject();
        r4.addProperty("is_render", Boolean.valueOf(r9));
        Unit r5 = Unit.INSTANCE;
        r3.add("data", r4);
        r0.y.Dk("avatar", "avatar_event", r3, false);
        int r6 = com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a;
        String r7 = null;
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(r0.z) == false) goto L41;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r10 = r0.B;
        if (r10 == null) goto L58;
        BehaviorSubject<List<ch0.e>> r11 = r10.f();
        if (r11 == null) goto L58;
        List r12 = (List) r11.getValue();
        if (r12 == null) goto L58;
        Iterator r13 = r12.iterator();
    L28:
        if (r13.hasNext() == false) goto L35;
        Object r14 = r13.next();
        if (((ch0.e) r14).a.isEnlarged() != true) goto L32;
        boolean r15 = true;
    L33:
        if (r15 == false) goto L28;
    L36:
        ch0.e r16 = (ch0.e) r14;
        if (r16 == null) goto L58;
        ch0.h r2 = r16.b;
        if (r2 == null) goto L58;
        r7 = r2.a;
        goto L58
    L32:
        r15 = false;
        goto L33
    L35:
        r14 = null;
    L58:
        r0.i(!r9, Intrinsics.areEqual(r0.h.get(r7), Boolean.TRUE));
        return;
    L41:
        ue0.c r17 = r0.A;
        if (r17 == null) goto L58;
        Iterator<T> r18 = r17.o().iterator();
    L45:
        if (r18.hasNext() == false) goto L52;
        Object r19 = r18.next();
        if (((ch0.e) r19).a.isEnlarged() != true) goto L49;
        boolean r20 = true;
    L50:
        if (r20 == false) goto L45;
    L53:
        ch0.e r21 = (ch0.e) r19;
        if (r21 == null) goto L58;
        ch0.h r22 = r21.b;
        if (r22 == null) goto L58;
        r7 = r22.a;
        goto L58
    L49:
        r20 = false;
        goto L50
    L52:
        r19 = null;
        goto L53
    L17:
        r9 = false;
        goto L18
    L72:
        return;
    }

    public final void b(IMultiScenePreviewStatistics r12) {
        initDataContext();
        int r0 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.plantform.multiroom.e.e(this.t, this, null);
        this.g = new mh0.h(this.s, this.t, this.u, this.r, this);
        mh0.p r10 = new mh0.p(this.s, this.t, this.u, this, this.w, this.x, this.y, this.z, this.A);
        this.h = r10;
        r10.s = r12;
        r10.u = this.p;
        this.i = new mh0.d(this.s, this.t, this.u);
        this.j = new mh0.f(this.s, this.t, this.u);
        this.k = new mh0.b(this.s, this.t, this.u, this.v);
        this.l = new mh0.i(this.s, this.t, this.u, this);
        this.m = new mh0.j(this.s, this.t, this.u);
        lh0.a[] r1 = new lh0.a[7];
        mh0.h r2 = this.g;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("basicHandler");
    L5:
        r1[0] = r2;
        mh0.p r3 = this.h;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("micSeatHandler");
    L8:
        r1[1] = r3;
        mh0.d r4 = this.i;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("audioLayoutHandler");
    L11:
        r1[2] = r4;
        mh0.f r5 = this.j;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("avatarHandler");
    L14:
        r1[3] = r5;
        mh0.b r6 = this.k;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("audioChatStageHandler");
    L17:
        r1[4] = r6;
        mh0.j r7 = this.m;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("ktvHandler");
    L20:
        r1[5] = r7;
        mh0.i r8 = this.l;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("interactiveOrderSongHandler");
    L23:
        r1[6] = r8;
        List<? extends lh0.a> r9 = CollectionsKt.listOf(r1);
        this.n = r9;
        if (r9 == null) goto L30;
        Iterator<T> r11 = r9.iterator();
    L27:
        if (r11.hasNext() == false) goto L30;
        ((lh0.a) r11.next()).c();
    L30:
        if (this.s == null) goto L32;
        this.a = new MultiLinkFeedHybridCardManager(this.s, this.t, this.r, this.u, this.w, r12, this, this.B);
    L32:
        ALogger.i("MultiLinkFeedDynamicWidget", "注册麦位监听， dataCenter=" + this.t);
        DataCenter r13 = this.t;
        if (r13 == null) goto L35;
        r13.observeForever("data_multi_lick_dynamic_event_change", this);
    L35:
        DataCenter r14 = this.t;
        if (r14 == null) goto L38;
        r14.observeForever("data_multi_lick_dynamic_widget_start", this);
    L38:
        DataCenter r15 = this.t;
        if (r15 == null) goto L41;
        r15.observeForever("data_multi_link_dynamic_layout_info_change", this, true);
    L41:
        DataCenter r16 = this.t;
        if (r16 == null) goto L44;
        r16.observeForever("data_multi_link_dynamic_guest_list_change", this, true);
    L44:
        com.bytedance.android.livesdk.log.j0.l().addSendLogFilter(com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.t.class, com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.t.c);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.a
    public final void bh(boolean r3) {
        this.p = r3;
        mh0.p r0 = this.h;
        if (r0 == null) goto L8;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("micSeatHandler");
    L6:
        r0.u = r3;
        return;
    }

    @Override // ih0.b
    public final void fa(ih0.c r2) {
        MultiLinkFeedHybridCardManager r0 = this.a;
        if (r0 == null) goto L6;
        r0.h(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.a
    public final void fd(com.bytedance.android.live.liveinteract.plantform.datamerge.a r3) {
        mh0.p r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("micSeatHandler");
    L5:
        if (r3 != null) goto L7;
        r0.getClass();
        return;
    L7:
        r0.t = r3;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r4 = r3.g;
        if (r4 == null) goto L10;
        Integer r5 = Integer.valueOf(r4.getUiLayout());
    L11:
        r0.h(r5.intValue());
        r0.r.clear();
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r6 = r0.t;
        if (r6 == null) goto L22;
        BehaviorSubject<List<tf0.e>> r7 = r6.b;
        if (r7 == null) goto L23;
        Observable r8 = RxUtilKt.h(r7);
        if (r8 == null) goto L24;
        Disposable r9 = r8.subscribe(new mh0.m(r0));
        if (r9 == null) goto L25;
        RxUtilKt.c(r9, r0.r);
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L10:
        r5 = null;
        goto L11
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.a
    public final void fg(nh0.f r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        JsonObject r0 = r5.a();
        if (r0 != null) goto L38;
        return;
    L38:
        JsonObject r1 = new JsonObject();     // Catch: JSONException -> L35
        r1.add("data", r0);     // Catch: JSONException -> L35
        r1.addProperty("type", r5.a);     // Catch: JSONException -> L35
        String r2 = r5.a;     // Catch: JSONException -> L35
        int r3 = r2.hashCode();     // Catch: JSONException -> L35
        if (r3 == (-1753865563)) goto L23;
        if (r3 == 177093645) goto L18;
        if (r3 == 2011270307) goto L13;
    L27:
        MultiLinkFeedHybridCardManager r6 = this.a;     // Catch: JSONException -> L35
        if (r6 == null) goto L30;
        r6.i(r1);     // Catch: JSONException -> L35
    L30:
        Iterator r7 = ((LinkedHashMap) this.e).entrySet().iterator();     // Catch: JSONException -> L35
    L31:
        if (r7.hasNext() == false) goto L41;
        ((ih0.c) ((Map.Entry) r7.next()).getValue()).sendJsEvent("onLinkmicStatusChange", r1);     // Catch: JSONException -> L35
        goto L31
    L41:
        return;
    L13:
        if (r2.equals("layout_info") == false) goto L27;
        MultiLinkFeedHybridCardManager r4 = this.a;     // Catch: JSONException -> L35
        if (r4 == null) goto L27;
        r4.l(r5, r1);     // Catch: JSONException -> L35
        goto L27
    L18:
        if (r2.equals("linkmic") == false) goto L27;
        MultiLinkFeedHybridCardManager r8 = this.a;     // Catch: JSONException -> L35
        if (r8 == null) goto L27;
        r8.l(r5, r1);     // Catch: JSONException -> L35
        goto L27
    L23:
        if (r2.equals("guest_list") == false) goto L27;
        MultiLinkFeedHybridCardManager r9 = this.a;     // Catch: JSONException -> L35
        if (r9 == null) goto L27;
        r9.l(r5, r1);     // Catch: JSONException -> L35
    L35:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // ih0.b
    public final void jc(String r2) {
        Intrinsics.checkNotNullParameter(r2, "bizId");
        this.d.remove(r2);
    }

    public final void onChanged(Object r9) {
        KVData r10 = (KVData) r9;
        String r0 = null;
        if (r10 == null) goto L5;
        String r1 = r10.getKey();
    L7:
        if (Intrinsics.areEqual(r1, "data_multi_lick_dynamic_widget_start") == false) goto L12;
        Boolean r2 = (Boolean) r10.getData();
        if (r2 != null) goto L11;
        r2 = Boolean.TRUE;
    L11:
        r2.booleanValue();
    L12:
        mh0.p r3 = this.h;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("micSeatHandler");
    L15:
        r3.getClass();
        StringBuilder r4 = new StringBuilder("onChanged: ");
        if (r10 == null) goto L18;
        String r5 = r10.getKey();
    L19:
        r4.append(r5);
        ALogger.e("MultiLinkFeedDynamicWidget", r4.toString());
        if (r10 == null) goto L22;
        String r6 = r10.getKey();
    L23:
        int r7 = 0;
        if (Intrinsics.areEqual(r6, "data_multi_link_dynamic_layout_info_change") == false) goto L33;
        nh0.f r8 = (nh0.f) r10.getData();
        if (r8 == null) goto L63;
        MultiLinkFeedDynamicWidgetNew r11 = r3.n();
        Intrinsics.checkNotNullParameter(r8, "updateEvent");
        sf0.b r12 = r8.e;
        if (r12 == null) goto L32;
        int r13 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a;
        r11.Dk("root", "layout_info", com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.f(r12), false);
        goto L33
    L32:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.linkbase.DynamicFrameInfo");
    L63:
        return;
    L33:
        if (r10 == null) goto L35;
        String r14 = r10.getKey();
    L37:
        if (Intrinsics.areEqual(r14, "data_multi_lick_dynamic_event_change") == false) goto L52;
        nh0.f r15 = (nh0.f) r10.getData();
        if (r15 != null) goto L42;
        return;
    L42:
        if (Intrinsics.areEqual(r15.a, "linkmic") == false) goto L51;
        int r16 = r3.l;
        nh0.e r17 = r15.b;
        if (r17 != null) goto L46;
    L48:
        if (r17 == null) goto L50;
        r7 = r17.b;
    L50:
        r3.n().fg(r15);
        r3.h(r7);
        r3.l = r7;
        goto L52
    L46:
        if (r16 != r17.b) goto L48;
        ALogger.i("MultiLinkFeedDynamicWidget", "updateDynamicEventChange uilayout same return");
        return;
    L51:
        r3.n().fg(r15);
    L52:
        if (r10 == null) goto L55;
        r0 = r10.getKey();
    L55:
        if (Intrinsics.areEqual(r0, "data_multi_link_dynamic_guest_list_change") == false) goto L62;
        nh0.f r18 = (nh0.f) r10.getData();
        if (r18 == null) goto L65;
        r3.n().fg(r18);
        return;
    L65:
        return;
    L62:
        return;
    L35:
        r14 = null;
        goto L37
    L22:
        r6 = null;
        goto L23
    L18:
        r5 = null;
        goto L19
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.a
    public final void updateRoom(IRoom r3) {
        Intrinsics.checkNotNullParameter(r3, PbRequest.SwitchType.ROOM);
        this.f = r3;
        if (com.bytedance.android.live.liveinteract.utils.w0.e() == true) goto L15;
        Map<String, ? extends Object> r4 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("currentRoom", a("", com.bytedance.android.annie.api.data.subscribe.d.b(r3)))});     // Catch: Exception -> L10
        MultiLinkFeedHybridCardManager r0 = this.a;     // Catch: Exception -> L10
        if (r0 == null) goto L16;
        ih0.c r1 = r0.a;     // Catch: Exception -> L10
        if (r1 == null) goto L17;
        r1.updateData(r4);     // Catch: Exception -> L10
        return;
    L17:
        return;
    L16:
        return;
    L10:
        e = move-exception;
        ALogger.e("MultiLinkFeedDynamicWidget", "updateRoom to AnnieCard failed", e);
        return;
    }

    @Override // ih0.b
    public final void E6(String r2, ih0.g r3) {
        Intrinsics.checkNotNullParameter(r2, "bizId");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.d.put(r2, r3);
    }

    @Override // ih0.b
    public final void Gb(String r2, ih0.c r3) {
        Intrinsics.checkNotNullParameter(r2, "itemId");
        if (r3 != null) goto L6;
        return;
    L6:
        if (((LinkedHashMap) this.e).values().contains(r3) == true) goto L9;
        this.e.put(r2, r3);
        return;
    }

    public final JsonElement a(String r8, JsonElement r9) {
        Intrinsics.checkNotNullParameter("", "keyParam");
        Intrinsics.checkNotNullParameter(r9, "element");
        int r6 = 0;
        if ("".length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return r9;
    L8:
        List r0 = StringsKt.split$default("", new char[]{'.'}, false, 0, 6, null);
        Intrinsics.checkNotNullParameter(r0, "paths");
        Intrinsics.checkNotNullParameter(r9, "element");
        JsonElement r10 = new JsonObject();
        Iterator r2 = r0.iterator();
        JsonElement r3 = r10;
    L10:
        if (r2.hasNext() == false) goto L23;
        Object r4 = r2.next();
        int r5 = r6 + 1;
        if (r6 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        String r7 = (String) r4;
        if ((r9 instanceof JsonObject) == false) goto L17;
        Intrinsics.checkNotNull(r9);
        r9 = r9.getAsJsonObject().get(r7);
    L19:
        if (r6 != (r0.size() - 1)) goto L21;
        r3.getAsJsonObject().add(r7, r9);
    L22:
        r6 = r5;
        goto L10
    L21:
        JsonElement r11 = new JsonObject();
        r3.getAsJsonObject().add(r7, r11);
        Unit r12 = Unit.INSTANCE;
        r3 = r11;
        goto L22
    L17:
        r9 = JsonNull.INSTANCE;
        goto L19
    L23:
        return r10;
    L5:
        r1 = false;
        goto L6
    }

    @Override // ih0.b
    public final void oe(String r3, vlc.l r4) {
        Intrinsics.checkNotNullParameter(r3, "listenerId");
        this.o.put(r3, new WeakReference(r4));
    }

    @Override // ih0.b
    public final void B1(ih0.f r20, ih0.h r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r20, "updateStatus");
        Intrinsics.checkNotNullParameter(r21, "updateCallback");
        JsonObject r5 = r20.d;
        if (r5 != null) goto L6;
        ALogger.e("MultiLinkFeedDynamicWidget", "update status but updateExtraInfo is empty");
        r21.a(UpdateLinkmicStatusResultModel.Code.Success, "", null);
        return;
    L6:
        String r9 = r20.c;
        IRoom r10 = this.f;
        if (r10 == null) goto L9;
        r10.isLiveTypeAudio();
    L9:
        boolean r11 = false;
        if (r9.length() != 0) goto L12;
        boolean r12 = true;
    L13:
        if (r12 == false) goto L16;
        ALogger.e("MultiLinkFeedDynamicWidget", "update status but fromBizId is empty");
        r21.a(UpdateLinkmicStatusResultModel.Code.Failed, "", null);
        return;
    L16:
        ALogger.i("MultiLinkFeedDynamicWidget", "update status type=" + r20.getType() + " updateExtraInfo=" + r5);
        switch(l.a[r20.getType().ordinal()]) {
            case 1: goto L143;
            case 2: goto L143;
            case 3: goto L143;
            case 4: goto L132;
            case 5: goto L78;
            case 6: goto L40;
            case 7: goto L40;
            case 8: goto L40;
            case 9: goto L23;
            case 10: goto L19;
            case 11: goto L19;
            default: goto L262;
        };
    L19:
        mh0.i r6 = this.l;
        if (r6 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("interactiveOrderSongHandler");
    L22:
        r6.getClass();
        Intrinsics.checkNotNullParameter(r20, "updateStatus");
        Intrinsics.checkNotNullParameter(r21, "updateCallback");
        goto L262
    L23:
        if (r22 == false) goto L262;
        mh0.j r7 = this.m;
        if (r7 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("ktvHandler");
    L27:
        r7.getClass();
        Intrinsics.checkNotNullParameter(r20, "updateStatus");
        Intrinsics.checkNotNullParameter(r21, "updateCallback");
        JsonObject r3 = r20.d;
        if (r3 == null) goto L262;
        if (mh0.k.a[r20.getType().ordinal()] != 1) goto L262;
        IKtvService r0 = jc1.k.f(IKtvService.class);
        if (r0 == null) goto L36;
        JsonObject r1 = r0.handleKtvCommonJsbUpdateAction(r3, true);
    L37:
        if (r1 == null) goto L39;
        Intrinsics.checkNotNullParameter(r21, "updateCallback");
        lh0.c.a.a(r21, r1);
        goto L262
    L39:
        r7.e(r21, "");
        goto L262
    L36:
        r1 = null;
        goto L37
    L40:
        mh0.p r8 = this.h;
        if (r8 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("micSeatHandler");
    L43:
        r8.getClass();
        Intrinsics.checkNotNullParameter(r20, "updateStatus");
        Intrinsics.checkNotNullParameter(r21, "updateCallback");
        JsonObject r4 = r20.d;
        if (r4 == null) goto L262;
        int r13 = mh0.l.a[r20.getType().ordinal()];
        if (r13 == 1) goto L69;
        if (r13 == 2) goto L264;
        if (r13 != 3) goto L262;
        if (((Boolean) h30.a.getValue()).booleanValue() == false) goto L262;
        new LinkedHashMap();
        Map<Integer, List<Integer>> r2 = ((nh0.h) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r4, nh0.h.class)).a();
        ALogger.d(r8.e, "dynamicUpdateUIFeature, current ui_layout: " + r8.d.a() + " offset_config: " + r2.get(r8.d.a()));
        ((LinkedHashMap) r8.g).clear();
        r8.g.putAll(r2);
        r8.d.l();
        if (MultiLinkLoadWidgetUtils.g() == false) goto L60;
        IRoom r14 = r8.d.r();
        if (r14 == null) goto L58;
        String r15 = r14.getIdStr();
    L59:
        RxBusAbility.INSTANCE.getRxBus(je0.d.l(r15, true)).post(new zg1.r0());
        goto L262
    L58:
        r15 = null;
        goto L59
    L60:
        xs2.b.a().post(new zg1.r0());
        goto L262
    L264:
        ALogger.i(r8.e, "ITEM_LOAD_DURATION " + r20.d);     // Catch: Exception -> L66
        tf0.f r16 = (tf0.f) new GsonBuilder().create().fromJson(r20.d, tf0.f.class);     // Catch: Exception -> L66
        IMultiScenePreviewStatistics r17 = r8.s;     // Catch: Exception -> L66
        if (r17 == null) goto L262;
        r17.handleDynamicViewLoadDuration(r16);     // Catch: Exception -> L66
    L66:
        e = move-exception;
        ALogger.e(r8.e, "dynamicHandleLoadDuration gson failed!", e);
        r8.e(r21, "dynamicHandleLoadDuration gson failed!");
        goto L262
    L69:
        if (((Boolean) h30.a.getValue()).booleanValue() == true) goto L262;
        new LinkedHashMap();
        Map<String, LayoutConfigModel> r18 = ((nh0.g) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r4, nh0.g.class)).a();
        ((LinkedHashMap) r8.f).clear();
        r8.f.putAll(r18);
        r8.d.l();
        if (MultiLinkLoadWidgetUtils.g() == false) goto L77;
        IRoom r19 = r8.d.r();
        if (r19 == null) goto L75;
        String r23 = r19.getIdStr();
    L76:
        RxBusAbility.INSTANCE.getRxBus(je0.d.l(r23, true)).post(new zg1.r0());
        goto L262
    L75:
        r23 = null;
        goto L76
    L77:
        xs2.b.a().post(new zg1.r0());
        goto L262
    L78:
        mh0.b r24 = this.k;
        if (r24 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("audioChatStageHandler");
    L81:
        r24.getClass();
        Intrinsics.checkNotNullParameter(r20, "updateStatus");
        Intrinsics.checkNotNullParameter(r21, "updateCallback");
        if (r20.d == null) goto L262;
        int r25 = mh0.a.a[r20.getType().ordinal()];
        if (r25 == 1) goto L94;
        if (r25 != 2) goto L131;
        JsonObject r26 = r20.d;
        if (r26 == null) goto L93;
        JsonElement r27 = r26.get("type");
        if (r27 == null) goto L93;
        r27.getAsInt();
    L93:
        SubtitleUpdateType.UNKNOWN.ordinal();
    L131:
        r24.a(r21, null);
        goto L262
    L94:
        c r28 = r24.f;
        JsonObject r29 = r20.d;
        if (r29 == null) goto L99;
        JsonElement r30 = r29.get("type");
        if (r30 == null) goto L99;
        int r31 = r30.getAsInt();
    L101:
        if (r31 != AudioChatStageUpdateType.AUDIO_STAGE_UPDATE_SEAT_LOCATION.ordinal()) goto L123;
        boolean r32 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.f.a(r20.d);
        int r33 = com.bytedance.android.live.liveinteract.voicechat.stage.a.a;
        com.bytedance.android.live.liveinteract.voicechat.stage.a.e("audio_stage_update_seat_location_event", "isOrderSingSetEnlarge " + r32);
        JsonObject r34 = r20.d;
        if (r34 == null) goto L107;
        JsonElement r35 = r34.get("item_id");
        if (r35 == null) goto L107;
        String r36 = r35.getAsString();
    L109:
        if (Intrinsics.areEqual(r36, StageItemId.ORDER_SING_STAGE.getValue()) == false) goto L131;
        InteractiveSongContext.a r37 = InteractiveSongContext.Companion;
        InteractiveSongContext r38 = r37.getContext();
        if (r38 == null) goto L116;
        com.bytedance.live.datacontext.m<Boolean> r39 = r38.getShowOrderSingStage();
        if (r39 == null) goto L116;
        if (((Boolean) r39.getValue()).booleanValue() == r32) goto L131;
    L116:
        InteractiveSongContext r40 = r37.getContext();
        if (r40 == null) goto L121;
        com.bytedance.live.datacontext.m<Boolean> r41 = r40.getShowOrderSingStage();
        if (r41 == null) goto L121;
        r41.setValue(Boolean.valueOf(r32));
    L121:
        r24.c.put("data_order_sing_stage_is_inert", Boolean.valueOf(r32));
    L107:
        r36 = null;
        goto L109
    L123:
        if (r31 != AudioChatStageUpdateType.STAGE_IS_INSERT.ordinal()) goto L131;
        JsonObject r42 = r20.d;
        if (r42 == null) goto L129;
        JsonElement r43 = r42.get("stage_is_insert");
        if (r43 == null) goto L129;
        r11 = r43.getAsBoolean();
    L129:
        if (r28 == null) goto L131;
        r28.g(r11);
    L99:
        r31 = AudioChatStageUpdateType.UNKNOWN.ordinal();
        goto L101
    L132:
        mh0.d r44 = this.i;
        if (r44 != null) goto L135;
        Intrinsics.throwUninitializedPropertyAccessException("audioLayoutHandler");
    L135:
        r44.getClass();
        Intrinsics.checkNotNullParameter(r20, "updateStatus");
        Intrinsics.checkNotNullParameter(r21, "updateCallback");
        if (r20.d == null) goto L262;
        if (mh0.c.a[r20.getType().ordinal()] != 1) goto L142;
        ALogger.i(r44.e, "SEAT_ANIMATE " + r20.d);
        GsonBuilder r45 = new GsonBuilder();
        r45.registerTypeAdapter(Object.class, new PointOrNumberDeserializer());
        tf0.u r46 = (tf0.u) GsonProtectorUtils.fromJson(r45.create(), r20.d, tf0.u.class);
        ALogger.i(r44.e, "post DATA_DYNAMIC_ISLAND_LAYOUT_ANIMTE, feedDataCenter=" + r44.c);
        r44.c.put("data_dynamic_island_layout_animte", r46);
    L142:
        r44.a(r21, null);
        goto L262
    L143:
        mh0.h r47 = this.g;
        if (r47 != null) goto L146;
        Intrinsics.throwUninitializedPropertyAccessException("basicHandler");
    L146:
        r47.getClass();
        Intrinsics.checkNotNullParameter(r20, "updateStatus");
        Intrinsics.checkNotNullParameter(r21, "updateCallback");
        JsonObject r48 = r20.d;
        if (r48 == null) goto L262;
        String r49 = r20.c;
        b r110 = r47.d;
        if (r110 == null) goto L154;
        IRoom r111 = r110.r();
        if (r111 == null) goto L154;
        r111.isLiveTypeAudio();
    L154:
        ALogger.i("MultiLinkFeedDynamicWidget", "update status type=" + r20.getType() + " updateExtraInfo=" + r48);
        int r112 = mh0.g.a[r20.getType().ordinal()];
        if (r112 == 1) goto L240;
        if (r112 == 2) goto L223;
        if (r112 != 3) goto L259;
        o r50 = r47.e.get(r49);
        if (r50 == null) goto L259;
        Intrinsics.checkNotNullParameter(r20, "updateStatusData");
        if (m.a[r20.getType().ordinal()] != 1) goto L259;
        nh0.o r51 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.f.b(r20.d);
        if (r51 == null) goto L259;
        ALogger.i("MultiLinkFeedDynamicWidget-Time", "start load stage card loadTime=" + r51.g);
        String r52 = r51.b;
        int r53 = m.c[r51.getType().ordinal()];
        if (r53 == 1) goto L196;
        if (r53 == 2) goto L195;
        if (r53 != 3) goto L259;
        if (((Boolean) vm2.h.V5.getValue(null, vm2.h.a[358(0x166, float:5.02E-43)])).booleanValue() == false) goto L259;
        h r54 = (h) ((LinkedHashMap) r50.a).get(r52);
        if (r54 == null) goto L259;
        ih0.c r55 = r54.a;
        if (r55 == null) goto L259;
        nh0.n r56 = r51.f;
        if (r56 == null) goto L259;
        View r57 = r55.S0();
        if (r57 == null) goto L185;
        ViewGroup.LayoutParams r58 = r57.getLayoutParams();
    L187:
        if ((r58 instanceof FrameLayout.LayoutParams) == true) goto L189;
        r58 = null;
    L189:
        FrameLayout.LayoutParams r59 = (FrameLayout.LayoutParams) r58;
        if (r59 == null) goto L259;
        r59.topMargin = s1.f(r56.b);
        r59.leftMargin = s1.f(r56.a);
        View r60 = r55.S0();
        if (r60 == null) goto L259;
        r60.setLayoutParams(r59);
        goto L259
    L185:
        r58 = null;
        goto L187
    L195:
        r50.b(r52);
        goto L259
    L196:
        h r61 = (h) ((LinkedHashMap) r50.a).get(r52);
        if (r61 != null) goto L199;
    L202:
        h r62 = new h(r50.c, r51.c, r51.d, r51.h, r50.e, new n(r50, r52));
        r50.a.put(r52, r62);
        ih0.c r63 = r62.a(null);
        if (r63 == null) goto L259;
        r50.b.fa(r63);
        nh0.n r65 = r51.f;
        if (r65 == null) goto L259;
        int r66 = m.b[r51.e.ordinal()];
        if (r66 != 1) goto L211;
        FrameLayout r67 = (FrameLayout) r50.d.findViewById(2131370477);
    L215:
        if (r67 == null) goto L221;
        UtilityKotlinExtentionsKt.w(r67);
        FrameLayout.LayoutParams r113 = new FrameLayout.LayoutParams(s1.f(r65.c), s1.f(r65.d));
        r113.topMargin = s1.f(r65.b);
        r113.leftMargin = s1.f(r65.a);
        View r68 = r63.S0();
        if (r68 == null) goto L219;
        r68.setLayoutParams(r113);
    L219:
        r67.addView(r63.S0());
    L221:
        if (r51.i == false) goto L259;
        r50.b.Gb(r51.b, r63);
        goto L259
    L211:
        if (r66 == 3) goto L213;
        r67 = null;
        goto L215
    L213:
        r67 = (FrameLayout) r50.d.findViewById(2131370478);
        goto L215
    L199:
        if (Intrinsics.areEqual(r61.d, r51.d) == true) goto L259;
        r61.b();
        h r69 = r50.a.remove(r52);
    L259:
        r47.a(r21, null);
        goto L262
    L223:
        JsonElement r70 = r48.get("biz_id");
        if (r70 == null) goto L226;
        String r71 = r70.getAsString();
    L227:
        if (r71 != null) goto L229;
    L239:
        ALogger.e("MultiLinkFeedDynamicWidget", "Unload Biz but bizId is empty");
        r47.e(r21, "");
        goto L262
    L229:
        if (r71.length() != 0) goto L231;
        r11 = true;
    L231:
        if (r11 == true) goto L239;
        boolean r72 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.g(r71, r20.getType()) == true) goto L236;
        r47.e(r21, "");
        goto L262
    L236:
        ALogger.i("MultiLinkDynamicWidget", "removeBizController, bidId: ".concat(r71));
        o r73 = r47.e.remove(r71);
        if (r73 == null) goto L259;
        r73.a("jsb");
        goto L259
    L226:
        r71 = null;
        goto L227
    L240:
        JsonElement r74 = r48.get("biz_id");
        if (r74 == null) goto L243;
        String r75 = r74.getAsString();
    L244:
        if (r75 != null) goto L246;
    L261:
        ALogger.e("MultiLinkFeedDynamicWidget", "Load Biz but bizId is empty");
        r47.e(r21, "");
        goto L262
    L246:
        if (r75.length() != 0) goto L248;
        r11 = true;
    L248:
        if (r11 == true) goto L261;
        boolean r76 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.g(r75, r20.getType()) == true) goto L254;
        ALogger.e("MultiLinkFeedDynamicWidget", "updateStatus type=" + r20.getType() + " fromBizId=" + r75 + " not support dynamic return");
        r47.e(r21, "");
        goto L262
    L254:
        if (r47.e.get(r75) == null) goto L256;
    L260:
        r47.a(r21, null);
        goto L262
    L256:
        if (r47.getContext() == null) goto L260;
        o r77 = new o(r47.g, r47.getContext(), r47.f, r75);
        r47.e.put(r75, r77);
        int r78 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.s.a;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.s.b(r77.e);
        goto L259
    L243:
        r75 = null;
    L262:
        r21.a(UpdateLinkmicStatusResultModel.Code.Success, "", null);
        return;
    L12:
        r12 = false;
        goto L13
    }

    @Override // ih0.b
    public final void updateViewInLiveBg(String r2, JsonObject r3, ih0.h r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "updateCallback");
        this.u.updateViewInLiveBg(r2, r3, r4);
    }

    @Override // ih0.b
    public final void Dk(String r10, String r11, JsonObject r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "bizId");
        Intrinsics.checkNotNullParameter(r11, "eventType");
        ALogger.i("MultiLinkFeedDynamicWidget", "sendJSEvent, bidId: " + r10 + ", eventName: " + r11 + ", content: " + r12);
        if (r12 == null) goto L5;
        r12.addProperty("biz_id", r10);
    L5:
        fg(new nh0.f(r11, null, null, null, r12, null, false, 222));
    }

    @Override // ih0.b
    public final com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c Bi(Context r9, Uri r10, b7.a r11, long r12, DataCenter r14) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "uri");
        Intrinsics.checkNotNullParameter(r11, "commonLifecycle");
        return com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.b(r9, r10, r11, r12, r14, 32);
    }

    public /* synthetic */ MultiLinkFeedDynamicWidgetNew(ViewGroup r15, Context r16, DataCenter r17, b r18, c r19, int r20, ue0.c r21, String r22, int r23) {
        if ((r23 & 64) == 0) goto L5;
        ue0.c r9 = null;
    L7:
        if ((r23 & 1024) == 0) goto L9;
        String r13 = "";
    L10:
        this(r15, r16, r17, r18, r19, r20, r9, null, null, null, r13);
        return;
    L9:
        r13 = r22;
        goto L10
    L5:
        r9 = r21;
        goto L7
    }

    public MultiLinkFeedDynamicWidgetNew(ViewGroup r2, Context r3, DataCenter r4, b r5, c r6, int r7, ue0.c r8, com.bytedance.android.live.liveinteract.plantform.datamerge.d r9, eh0.b r10, eh0.b r11, String r12) {
        Intrinsics.checkNotNullParameter(r2, "mLinkRootView");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter(r5, "feedInfoProvider");
        this.r = r2;
        this.s = r3;
        this.t = r4;
        this.u = r5;
        this.v = r6;
        this.w = r7;
        this.x = r8;
        this.y = r9;
        this.z = r10;
        this.A = r11;
        this.B = r12;
        this.b = new LinkedHashMap();
        this.c = new CompositeDisposable();
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        new LinkedHashMap();
        this.o = new LinkedHashMap();
    }
}

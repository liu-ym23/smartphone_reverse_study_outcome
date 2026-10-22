package com.bytedance.android.live.liveinteract.wrdspreload;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkAnchorApi;
import com.bytedance.android.live.liveinteract.plantform.model.LinkerBaseInfo;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.live.liveinteract.plantform.model.q;
import com.bytedance.android.live.liveinteract.plantform.model.w0;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.message.model.gc;
import com.bytedance.android.livesdk.message.model.in;
import com.bytedance.android.livesdk.message.model.xe;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.multilink.IMultiLinkWRDSPreloadService;
import com.bytedance.android.livesdkapi.multilink.MultiLinkMsgPreloadBizListener;
import com.bytedance.android.livesdkapi.multilink.RoomLinkMicSyncDataPreloadBizListener;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import com.ss.ugc.live.sdk.platform.bytelink.f;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkWRDSPreloadManager implements IMultiLinkWRDSPreloadService {
    public static final Lazy i = null;
    public final com.bytedance.android.live.liveinteract.wrdspreload.c a;
    public String b;
    public boolean c;
    public final Map<String, Map<Long, List<RoomLinkMicSyncDataPreloadBizListener>>> d;
    public final Map<String, Map<Long, List<MultiLinkMsgPreloadBizListener>>> e;
    public final Map<String, Map<Long, List<MultiLinkMsgPreloadBizListener>>> f;
    public final Map<Long, Disposable> g;
    public final d h;

    public static final class a {
        public static MultiLinkWRDSPreloadManager a() {
            return (MultiLinkWRDSPreloadManager) MultiLinkWRDSPreloadManager.i.getValue();
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ MultiLinkWRDSPreloadManager a;
        public final /* synthetic */ IRoom b;

        public b(MultiLinkWRDSPreloadManager r1, IRoom r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r10) {
            e r11 = (e) r10;
            Intrinsics.checkNotNullParameter(r11, "response");
            MultiLinkWRDSPreloadManager r1 = this.a;
            int r3 = r1.hashCode();
            StringBuilder r0 = new StringBuilder("receive list v2 response, roomId=");
            IRoom r4 = this.b;
            q r8 = null;
            if (r4 == null) goto L5;
            Long r5 = Long.valueOf(r4.getId());
        L6:
            r0.append(r5);
            IMultiLinkWRDSPreloadService.DefaultImpls.printALogger$default(r1, "MultiLinkWRDSPreloadManager", r3, r0.toString(), false, 8, null);
            if (LocalTestManager.b(new Class[]{wy.a.class}) == false) goto L9;
            f2.c("下一个直播间兜底请求list/v2接口成功", 0);
        L9:
            LinkedHashMap r2 = new LinkedHashMap();
            Map<Long, g2> r6 = ((w0) r11.data).getLinkerContentMap();
            if (r6 == null) goto L17;
            Iterator<Map.Entry<Long, g2>> r7 = r6.entrySet().iterator();
        L13:
            if (r7.hasNext() == false) goto L17;
            Map.Entry<Long, g2> r9 = r7.next();
            long r12 = r9.getKey().longValue();
            g2 r13 = r9.getValue();
            if ((r13 instanceof RoomLinkerContent) == false) goto L13;
            r2.put(Long.valueOf(r12), r13);
        L17:
            q r14 = ((w0) r11.data).getLinkerBaseInfo();
            if ((r14 instanceof LinkerBaseInfo) == false) goto L21;
            r8 = r14;
        L21:
            RoomLinkMicSyncData r15 = new RoomLinkMicSyncData();
            r15.mLinkUsers = ((w0) r11.data).getMPlayerInfo();
            r15.lockedPositions = ((w0) r11.data).getLockedPositions();
            r15.positions = ((w0) r11.data).getPositions();
            r15.clientUIInfo = ((w0) r11.data).getClientUiInfo();
            r15.linkerContentMap = r2;
            r15.linkerBaseInfo = (LinkerBaseInfo) r8;
            Lazy r16 = MultiLinkLoadWidgetUtils.a;
            long r17 = 0;
            if (h.W().getByteLinkWrdsIgnoreSceneList().contains("RoomLinkMicSyncData") == false) goto L38;
            Iterator r18 = MapsKt.toMap(this.a.d).entrySet().iterator();
        L25:
            if (r18.hasNext() == false) goto L64;
            Map r19 = (Map) ((Map.Entry) r18.next()).getValue();
            IRoom r20 = this.b;
            if (r20 == null) goto L29;
            long r21 = r20.getId();
        L30:
            List r22 = (List) r19.get(Long.valueOf(r21));
            if (r22 == null) goto L25;
            List r23 = CollectionsKt.toList(r22);
            if (r23 == null) goto L25;
            Iterator<T> r24 = r23.iterator();
        L36:
            if (r24.hasNext() == false) goto L25;
            ((RoomLinkMicSyncDataPreloadBizListener) r24.next()).receiveWrds(r15);
            goto L36
        L29:
            r21 = 0;
            goto L30
        L64:
            return;
        L38:
            MultiLinkWRDSPreloadManager r110 = this.a;
            Map r111 = (Map) ((LinkedHashMap) r110.d).get(r110.b);
            if (r111 == null) goto L49;
            IRoom r25 = this.b;
            if (r25 == null) goto L43;
            r17 = r25.getId();
        L43:
            List r112 = (List) r111.get(Long.valueOf(r17));
            if (r112 == null) goto L63;
            Iterator<T> r113 = r112.iterator();
        L47:
            if (r113.hasNext() == false) goto L65;
            ((RoomLinkMicSyncDataPreloadBizListener) r113.next()).receiveWrds(r15);
            goto L47
        L65:
            return;
        L63:
            return;
        L49:
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r2) {
            Intrinsics.checkNotNullParameter((Throwable) r2, "throwable");
        }
    }

    public static final class d implements com.ss.ugc.live.sdk.platform.bytelink.dispatch.c {
        public d(MultiLinkWRDSPreloadManager r1) {
        }
    }

    static {
        i = LazyKt.lazy(MultiLinkWRDSPreloadManager$Companion$instance$2.INSTANCE);
    }

    public MultiLinkWRDSPreloadManager() {
        this.a = new com.bytedance.android.live.liveinteract.wrdspreload.c();
        this.b = "";
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
        this.g = new LinkedHashMap();
        this.h = new d(this);
    }

    public final boolean enableStatusBarMarginOpt() {
        if (MultiLinkLoadWidgetUtils.g() == true) goto L5;
    L7:
        return false;
    L5:
        if (h.W().statusBarOpt() == false) goto L7;
        return true;
    }

    public final void b(IRoom r9) {
        int r2 = hashCode();
        StringBuilder r0 = new StringBuilder("start fetch list v2, roomId=");
        if (r9 == null) goto L5;
        Long r3 = Long.valueOf(r9.getId());
    L6:
        r0.append(r3);
        IMultiLinkWRDSPreloadService.DefaultImpls.printALogger$default(this, "MultiLinkWRDSPreloadManager", r2, r0.toString(), false, 8, null);
        LinkAnchorApi r1 = (LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class);
        long r4 = 0;
        if (r9 == null) goto L9;
        long r5 = r9.getId();
    L10:
        if (r9 == null) goto L14;
        String r6 = r9.getOwnerUserIdString();
        if (r6 == null) goto L14;
        r4 = d5.c(r6);
    L14:
        long r7 = r4;
        if (r9 == null) goto L18;
        String r8 = r9.getOwnerUserIdString();
        if (r8 == null) goto L18;
    L19:
        r1.getLinkListV2(r5, r7, r8).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r9), c.a);
        return;
    L18:
        r8 = "0L";
        goto L19
    L9:
        r5 = 0;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void clearTargetScene(String r9) {
        Intrinsics.checkNotNullParameter(r9, "scene");
        IMultiLinkWRDSPreloadService.DefaultImpls.printALogger$default(this, "MultiLinkWRDSPreloadManager", hashCode(), "clearTargetScene, scene=" + r9, false, 8, null);
        com.bytedance.android.live.liveinteract.wrdspreload.c r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r9, "scene");
        ((ConcurrentHashMap) r1.a).remove(r9);
        ((ConcurrentHashMap) r1.b).remove(r9);
        this.d.remove(r9);
        this.e.remove(r9);
    }

    public final gc getBgMsg(String r11, IRoom r12) {
        Intrinsics.checkNotNullParameter(r11, "scene");
        String r2 = null;
        if (MultiLinkLoadWidgetUtils.a() == true) goto L5;
        return null;
    L5:
        long r3 = 0;
        if (h.W().getByteLinkWrdsIgnoreSceneList().contains("WebcastAudioBGImgMessage") == false) goto L18;
        com.bytedance.android.live.liveinteract.wrdspreload.c r0 = this.a;
        if (r12 == null) goto L10;
        r3 = r12.getId();
    L10:
        Iterator r1 = MapsKt.toMap(r0.b).entrySet().iterator();
    L12:
        if (r1.hasNext() == false) goto L24;
        Map.Entry r4 = (Map.Entry) r1.next();
        if (((Map) r4.getValue()).containsKey(Long.valueOf(r3)) == false) goto L12;
        if (((Map) r4.getValue()).get(Long.valueOf(r3)) == null) goto L12;
        in r5 = (in) ((Map) r4.getValue()).get(Long.valueOf(r3));
    L25:
        int r6 = hashCode();
        StringBuilder r7 = new StringBuilder("getPreloadBgMsg scene=");
        r7.append(r11);
        r7.append(", roomId=");
        if (r12 == null) goto L28;
        r2 = r12.getIdStr();
    L28:
        r7.append(r2);
        r7.append(", preloadBgMsg=");
        r7.append(r5);
        IMultiLinkWRDSPreloadService.DefaultImpls.printALogger$default(this, "MultiLinkWRDSPreloadManager", r6, r7.toString(), false, 8, null);
        return r5;
    L24:
        r5 = null;
        goto L25
    L18:
        com.bytedance.android.live.liveinteract.wrdspreload.c r8 = this.a;
        if (r12 == null) goto L21;
        r3 = r12.getId();
    L21:
        r8.getClass();
        Intrinsics.checkNotNullParameter(r11, "scene");
        Map r9 = (Map) ((ConcurrentHashMap) r8.b).get(r11);
        if (r9 == null) goto L24;
        r5 = (in) r9.get(Long.valueOf(r3));
        goto L25
    }

    public final void registerPublisher(String r11, List<Long> r12) {
        Intrinsics.checkNotNullParameter(r11, "scene");
        Intrinsics.checkNotNullParameter(r12, "publisherRoomId");
        if (MultiLinkLoadWidgetUtils.a() == true) goto L5;
        return;
    L5:
        IMultiLinkWRDSPreloadService.DefaultImpls.printALogger$default(this, "MultiLinkWRDSPreloadManager", hashCode(), "registerPublisher, scene=" + r11 + ", publisherRoomId=" + r12, false, 8, null);
        if (this.c == true) goto L17;
        this.c = true;
        f r0 = com.ss.ugc.live.sdk.platform.a.f;
        if (r0 == null) goto L10;
        r0.d("RoomLinkMicSyncData", this.h);
    L10:
        Map r1 = qmc.a.a;
        qmc.a.a.a("WebcastAudioBGImgMessage", in.class);
        f r2 = com.ss.ugc.live.sdk.platform.a.f;
        if (r2 == null) goto L13;
        r2.d("WebcastAudioBGImgMessage", this.h);
    L13:
        qmc.a.a.a("WebcastLinkMicMethod", xe.class);
        f r3 = com.ss.ugc.live.sdk.platform.a.f;
        if (r3 == null) goto L16;
        r3.d("WebcastLinkMicMethod", this.h);
    L16:
        IMultiLinkWRDSPreloadService.DefaultImpls.printALogger$default(this, "MultiLinkWRDSPreloadManager", hashCode(), "registerPublisher, addPayloadListener ByteLinkClient=" + com.ss.ugc.live.sdk.platform.a.f, false, 8, null);
    L17:
        com.bytedance.android.live.liveinteract.wrdspreload.c r4 = this.a;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r12, "publisherRoomIdList");
        Iterator r5 = ((ConcurrentHashMap) r4.a).values().iterator();
    L19:
        if (r5.hasNext() == false) goto L26;
        Iterator r6 = ((Map) r5.next()).entrySet().iterator();
    L22:
        if (r6.hasNext() == false) goto L19;
        if (r12.contains(((Map.Entry) r6.next()).getKey()) == true) goto L22;
        r6.remove();
        goto L22
    L26:
        Iterator r7 = ((ConcurrentHashMap) r4.b).values().iterator();
    L28:
        if (r7.hasNext() == false) goto L35;
        Iterator r8 = ((Map) r7.next()).entrySet().iterator();
    L31:
        if (r8.hasNext() == false) goto L28;
        if (r12.contains(((Map.Entry) r8.next()).getKey()) == true) goto L31;
        r8.remove();
        goto L31
    L35:
        this.b = r11;
    }

    public final void removeRoomLinkMicSyncData(String r5, IRoom r6) {
        Intrinsics.checkNotNullParameter(r5, "scene");
        com.bytedance.android.live.liveinteract.wrdspreload.c r1 = this.a;
        if (r6 == null) goto L5;
        long r2 = r6.getId();
    L6:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "scene");
        Map r7 = (Map) ((ConcurrentHashMap) r1.a).get(r5);
        if (r7 == null) goto L10;
        RoomLinkMicSyncData r8 = (RoomLinkMicSyncData) r7.remove(Long.valueOf(r2));
        return;
    L10:
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public final void addBgMsgBizListener(String r9, long r10, MultiLinkMsgPreloadBizListener r12) {
        Intrinsics.checkNotNullParameter(r9, "scene");
        Intrinsics.checkNotNullParameter(r12, "listener");
        if (MultiLinkLoadWidgetUtils.a() == true) goto L5;
        return;
    L5:
        IMultiLinkWRDSPreloadService.DefaultImpls.printALogger$default(this, "MultiLinkWRDSPreloadManager", hashCode(), "addBgMsgBizListener, scene=" + r9 + ", roomId=" + r10 + ", listener=" + r12, false, 8, null);
        if (((LinkedHashMap) this.e).get(r9) != null) goto L8;
        this.e.put(r9, new LinkedHashMap());
    L8:
        Map r0 = (Map) ((LinkedHashMap) this.e).get(r9);
        if (r0 == null) goto L11;
        List r1 = (List) r0.get(Long.valueOf(r10));
    L12:
        if (r1 != null) goto L16;
        Map r2 = (Map) ((LinkedHashMap) this.e).get(r9);
        if (r2 == null) goto L16;
        List r3 = (List) r2.put(Long.valueOf(r10), new ArrayList());
    L16:
        Map r11 = (Map) ((LinkedHashMap) this.e).get(r9);
        if (r11 == null) goto L22;
        List r13 = (List) r11.get(Long.valueOf(r10));
        if (r13 == null) goto L23;
        r13.add(r12);
        return;
    L23:
        return;
    L22:
        return;
    L11:
        r1 = null;
        goto L12
    }

    public final void addLinkMicMsgBizListener(String r9, long r10, MultiLinkMsgPreloadBizListener r12) {
        Intrinsics.checkNotNullParameter(r9, "scene");
        Intrinsics.checkNotNullParameter(r12, "listener");
        if (MultiLinkLoadWidgetUtils.a() == true) goto L5;
        return;
    L5:
        IMultiLinkWRDSPreloadService.DefaultImpls.printALogger$default(this, "MultiLinkWRDSPreloadManager", hashCode(), "addLinkMicMsgBizListener, scene=" + r9 + ", roomId=" + r10 + ", listener=" + r12, false, 8, null);
        if (((LinkedHashMap) this.f).get(r9) != null) goto L8;
        this.f.put(r9, new LinkedHashMap());
    L8:
        Map r0 = (Map) ((LinkedHashMap) this.f).get(r9);
        if (r0 == null) goto L11;
        List r1 = (List) r0.get(Long.valueOf(r10));
    L12:
        if (r1 != null) goto L16;
        Map r2 = (Map) ((LinkedHashMap) this.f).get(r9);
        if (r2 == null) goto L16;
        List r3 = (List) r2.put(Long.valueOf(r10), new ArrayList());
    L16:
        Map r11 = (Map) ((LinkedHashMap) this.f).get(r9);
        if (r11 == null) goto L22;
        List r13 = (List) r11.get(Long.valueOf(r10));
        if (r13 == null) goto L23;
        r13.add(r12);
        return;
    L23:
        return;
    L22:
        return;
    L11:
        r1 = null;
        goto L12
    }

    public final void addRoomLinkMicSyncDataBizListener(String r9, long r10, RoomLinkMicSyncDataPreloadBizListener r12) {
        Intrinsics.checkNotNullParameter(r9, "scene");
        Intrinsics.checkNotNullParameter(r12, "listener");
        if (MultiLinkLoadWidgetUtils.a() == true) goto L5;
        return;
    L5:
        IMultiLinkWRDSPreloadService.DefaultImpls.printALogger$default(this, "MultiLinkWRDSPreloadManager", hashCode(), "addRoomLinkMicSyncDataBizListener, scene=" + r9 + ", roomId=" + r10 + ", listener=" + r12, false, 8, null);
        if (((LinkedHashMap) this.d).get(r9) != null) goto L8;
        this.d.put(r9, new LinkedHashMap());
    L8:
        Map r0 = (Map) ((LinkedHashMap) this.d).get(r9);
        if (r0 == null) goto L11;
        List r1 = (List) r0.get(Long.valueOf(r10));
    L12:
        if (r1 != null) goto L16;
        Map r2 = (Map) ((LinkedHashMap) this.d).get(r9);
        if (r2 == null) goto L16;
        List r3 = (List) r2.put(Long.valueOf(r10), new ArrayList());
    L16:
        Map r11 = (Map) ((LinkedHashMap) this.d).get(r9);
        if (r11 == null) goto L22;
        List r13 = (List) r11.get(Long.valueOf(r10));
        if (r13 == null) goto L23;
        r13.add(r12);
        return;
    L23:
        return;
    L22:
        return;
    L11:
        r1 = null;
        goto L12
    }

    public final RoomLinkMicSyncData getRoomLinkMicSyncData(String r16, IRoom r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r16, "scene");
        Long r10 = null;
        if (MultiLinkLoadWidgetUtils.a() == true) goto L5;
        return null;
    L5:
        long r11 = 0;
        if (h.W().getByteLinkWrdsIgnoreSceneList().contains("RoomLinkMicSyncData") == false) goto L19;
        com.bytedance.android.live.liveinteract.wrdspreload.c r0 = this.a;
        if (r17 == null) goto L10;
        long r1 = r17.getId();
    L11:
        Iterator r2 = MapsKt.toMap(r0.a).entrySet().iterator();
    L13:
        if (r2.hasNext() == false) goto L27;
        Map.Entry r3 = (Map.Entry) r2.next();
        if (((Map) r3.getValue()).containsKey(Long.valueOf(r1)) == false) goto L13;
        if (((Map) r3.getValue()).get(Long.valueOf(r1)) == null) goto L13;
        RoomLinkMicSyncData r4 = (RoomLinkMicSyncData) ((Map) r3.getValue()).get(Long.valueOf(r1));
    L26:
        RoomLinkMicSyncData r13 = r4;
    L28:
        int r5 = hashCode();
        StringBuilder r6 = new StringBuilder("getPreloadWRDS, scene=");
        r6.append(r16);
        r6.append(", roomId=");
        if (r17 == null) goto L31;
        String r7 = r17.getIdStr();
    L32:
        r6.append(r7);
        r6.append(", preloadWrds=");
        r6.append(r13);
        IMultiLinkWRDSPreloadService.DefaultImpls.printALogger$default(this, "MultiLinkWRDSPreloadManager", r5, r6.toString(), false, 8, null);
        if (r18 == true) goto L35;
    L78:
        return r13;
    L35:
        if (Intrinsics.areEqual(r16, "inner_feed") == false) goto L78;
        if (r13 != null) goto L78;
        Map<Long, Disposable> r8 = this.g;
        if (r17 == null) goto L40;
        long r9 = r17.getId();
    L42:
        if (r8.containsKey(Long.valueOf(r9)) == true) goto L78;
        if (r17 == null) goto L45;
        Map r12 = r17.getLinkMap();
    L46:
        boolean r14 = false;
        if (r12 != null) goto L49;
    L50:
        if (r12 != null) goto L52;
    L53:
        if (r12 != null) goto L55;
    L56:
        if (r12 != null) goto L58;
    L60:
        boolean r15 = false;
    L61:
        if (r15 == false) goto L78;
        if (MultiLinkLoadWidgetUtils.g() == true) goto L65;
    L67:
        if (r14 == false) goto L78;
        int r19 = hashCode();
        StringBuilder r20 = new StringBuilder("fetchListV2Observable, scene=");
        r20.append(r16);
        r20.append(", roomId=");
        if (r17 == null) goto L71;
        r10 = Long.valueOf(r17.getId());
    L71:
        r20.append(r10);
        IMultiLinkWRDSPreloadService.DefaultImpls.printALogger$default(this, "MultiLinkWRDSPreloadManager", r19, r20.toString(), false, 8, null);
        if (h.W().listV2PreloadDelayTime() <= 0) goto L77;
        Disposable r21 = Observable.timer(h.W().listV2PreloadDelayTime(), TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.liveinteract.wrdspreload.a(this, r16, r17), com.bytedance.android.live.liveinteract.wrdspreload.b.a);
        Map<Long, Disposable> r22 = this.g;
        if (r17 == null) goto L76;
        r11 = r17.getId();
    L76:
        r22.put(Long.valueOf(r11), r21);
        goto L78
    L77:
        b(r17);
        goto L78
    L65:
        if (h.W().listV2PreloadOpt() == false) goto L67;
        r14 = true;
        goto L67
    L58:
        if (r12.containsKey(String.valueOf(16)) != true) goto L60;
    L59:
        r15 = true;
        goto L61
    L55:
        if (r12.containsKey(String.valueOf(12)) == true) goto L59;
    L52:
        if (r12.containsKey(String.valueOf(8)) == true) goto L59;
    L49:
        if (r12.containsKey(String.valueOf(5)) == true) goto L59;
    L45:
        r12 = null;
        goto L46
    L40:
        r9 = 0;
        goto L42
    L31:
        r7 = null;
    L27:
        r13 = null;
        goto L28
    L10:
        r1 = 0;
        goto L11
    L19:
        com.bytedance.android.live.liveinteract.wrdspreload.c r23 = this.a;
        if (r17 == null) goto L22;
        long r24 = r17.getId();
    L23:
        r23.getClass();
        Intrinsics.checkNotNullParameter(r16, "scene");
        Map r25 = (Map) ((ConcurrentHashMap) r23.a).get(r16);
        if (r25 == null) goto L27;
        r4 = (RoomLinkMicSyncData) r25.get(Long.valueOf(r24));
        goto L26
    L22:
        r24 = 0;
        goto L23
    }

    public final void removeBgMsgBizListener(String r9, long r10, MultiLinkMsgPreloadBizListener r12) {
        Intrinsics.checkNotNullParameter(r9, "scene");
        Intrinsics.checkNotNullParameter(r12, "listener");
        if (MultiLinkLoadWidgetUtils.a() == true) goto L5;
        return;
    L5:
        IMultiLinkWRDSPreloadService.DefaultImpls.printALogger$default(this, "MultiLinkWRDSPreloadManager", hashCode(), "removeBgMsgBizListener, scene=" + r9 + ", roomId=" + r10 + ", listener=" + r12, false, 8, null);
        Map r11 = (Map) ((LinkedHashMap) this.e).get(r9);
        if (r11 == null) goto L11;
        List r13 = (List) r11.get(Long.valueOf(r10));
        if (r13 == null) goto L12;
        r13.remove(r12);
        return;
    L12:
        return;
    }

    public final void removeLinkMicMsgBizListener(String r9, long r10, MultiLinkMsgPreloadBizListener r12) {
        Intrinsics.checkNotNullParameter(r9, "scene");
        Intrinsics.checkNotNullParameter(r12, "listener");
        if (MultiLinkLoadWidgetUtils.a() == true) goto L5;
        return;
    L5:
        IMultiLinkWRDSPreloadService.DefaultImpls.printALogger$default(this, "MultiLinkWRDSPreloadManager", hashCode(), "removeLinkMicMsgBizListener, scene=" + r9 + ", roomId=" + r10 + ", listener=" + r12, false, 8, null);
        Map r11 = (Map) ((LinkedHashMap) this.f).get(r9);
        if (r11 == null) goto L11;
        List r13 = (List) r11.get(Long.valueOf(r10));
        if (r13 == null) goto L12;
        r13.remove(r12);
        return;
    L12:
        return;
    }

    public final void removeRoomLinkMicSyncDataBizListener(String r9, long r10, RoomLinkMicSyncDataPreloadBizListener r12) {
        Intrinsics.checkNotNullParameter(r9, "scene");
        Intrinsics.checkNotNullParameter(r12, "listener");
        if (MultiLinkLoadWidgetUtils.a() == true) goto L5;
        return;
    L5:
        IMultiLinkWRDSPreloadService.DefaultImpls.printALogger$default(this, "MultiLinkWRDSPreloadManager", hashCode(), "removeRoomLinkMicSyncDataBizListener, scene=" + r9 + ", roomId=" + r10 + ", listener=" + r12, false, 8, null);
        Map r0 = (Map) ((LinkedHashMap) this.d).get(r9);
        if (r0 == null) goto L11;
        List r1 = (List) r0.get(Long.valueOf(r10));
        if (r1 == null) goto L11;
        r1.remove(r12);
    L11:
        if (Intrinsics.areEqual(r9, "inner_feed") == true) goto L13;
        return;
    L13:
        if (this.g.containsKey(Long.valueOf(r10)) == false) goto L20;
        IMultiLinkWRDSPreloadService.DefaultImpls.printALogger$default(this, "MultiLinkWRDSPreloadManager", hashCode(), "remove fetchListV2Disposable, roomId=" + r10, false, 8, null);
        Disposable r11 = (Disposable) ((LinkedHashMap) this.g).get(Long.valueOf(r10));
        if (r11 == null) goto L17;
        r11.dispose();
    L17:
        this.g.remove(Long.valueOf(r10));
        return;
    }

    public final void printALogger(String r4, int r5, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "subTag");
        Intrinsics.checkNotNullParameter(r6, "content");
        if (r7 == false) goto L5;
        ALogger.e("MultiLinkWRDSPreload", r4 + '#' + r5 + ", content=" + r6);
        return;
    L5:
        ALogger.i("MultiLinkWRDSPreload", r4 + '#' + r5 + ", content=" + r6);
    }
}

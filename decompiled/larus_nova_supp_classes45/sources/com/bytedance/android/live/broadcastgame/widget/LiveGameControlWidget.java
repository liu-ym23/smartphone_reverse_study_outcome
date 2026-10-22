package com.bytedance.android.live.broadcastgame.widget;

import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.api.model.q;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.broadcastgame.effectgame.base.e;
import com.bytedance.android.live.broadcastgame.effectgame.base.g;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.util.WeakReferenceWrapper;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/widget/LiveGameControlWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveGameControlWidget extends LiveRecyclableWidget implements Observer<KVData> {
    public static final /* synthetic */ int f = 0;
    public u a;
    public Map<String, ? extends Object> b;
    public c c;
    public d d;
    public final com.bytedance.android.live.pushstream.d e;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.broadcastgame.effectgame.base.a {
        public final /* synthetic */ LiveGameControlWidget a;
        public final /* synthetic */ List b;
        public final /* synthetic */ long c;
        public final /* synthetic */ List d;
        public final /* synthetic */ u e;
        public final /* synthetic */ Map f;
        public final /* synthetic */ int g;

        @Override // com.bytedance.android.live.broadcastgame.effectgame.base.a
        public final void b(int r1, int r2, long r3, Sticker r5) {
            Intrinsics.checkNotNullParameter(r5, "sticker");
        }

        @Override // com.bytedance.android.live.broadcastgame.effectgame.base.a
        public final void c(int r1, Sticker r2) {
            Intrinsics.checkNotNullParameter(r2, "sticker");
        }

        @Override // com.bytedance.android.live.broadcastgame.effectgame.base.a
        public final void d(int r8, Sticker r9, ExceptionResult r11) {
            Intrinsics.checkNotNullParameter(r9, "sticker");
            LiveGameControlWidget r0 = this.a;
            List<u> r1 = this.b;
            long r2 = this.c;
            List<u> r4 = this.d;
            Map<u, ExceptionResult> r5 = this.f;
            r5.put(this.e, r11);
            Unit r12 = Unit.INSTANCE;
            int r6 = this.g + 1;
            int r13 = LiveGameControlWidget.f;
            r0.xq(r1, r2, r4, r5, r6);
        }

        @Override // com.bytedance.android.live.broadcastgame.effectgame.base.a
        public final void a(int r8, boolean r9, int r11, Sticker r12) {
            Intrinsics.checkNotNullParameter(r12, "sticker");
            if (r8 != 1) goto L9;
            LiveGameControlWidget r0 = this.a;
            List<u> r1 = this.b;
            long r2 = this.c;
            List<u> r4 = this.d;
            if (r9 == true) goto L7;
            r4.add(this.e);
        L7:
            Unit r13 = Unit.INSTANCE;
            Map<u, ExceptionResult> r5 = this.f;
            int r6 = this.g + 1;
            int r14 = LiveGameControlWidget.f;
            r0.xq(r1, r2, r4, r5, r6);
            return;
        }

        public b(LiveGameControlWidget r1, List r2, long r3, List r5, u r6, Map r7, int r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131567724;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public final String getSpm() {
        return "a100.a100.a139";
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public final void onPause() {
        super.onPause();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public final void onResume() {
        super.onResume();
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        if (r6 == null) goto L5;
        String r1 = r6.getKey();
    L6:
        if (r1 == null) goto L57;
        int r2 = r1.hashCode();
        if (r2 == (-1802015048)) goto L48;
        if (r2 == (-550251746)) goto L14;
        return;
    L14:
        if (r1.equals("cmd_broadcast_game_click") == false) goto L51;
        q r7 = (q) r6.getData(null);
        if (r7 == null) goto L59;
        u r8 = r7.a;
        if (r8 == null) goto L21;
        Integer r3 = Integer.valueOf(r8.interactId);
    L22:
        int r4 = InteractID.EffectGame.getValue();
        if (r3 != null) goto L26;
        return;
    L26:
        if (r3.intValue() == r4) goto L28;
        return;
    L28:
        if (r8.c() == null) goto L61;
        this.a = r8;
        this.b = null;
        r r0 = r8.c();
        if (r0 == null) goto L40;
        Sticker r9 = r0.a;
        if (r9 == null) goto L40;
        if (r9.isDownloaded() == true) goto L37;
    L39:
        LiveGameControlWidget$fetchCallBack$1 r11 = new LiveGameControlWidget$fetchCallBack$1(this);
        int r12 = com.bytedance.android.live.broadcastgame.effectgame.base.c.a;
        com.bytedance.android.live.broadcastgame.effectgame.base.c.b(r9, 1, new LiveGameControlWidget$processEffectGameSticker$1(this, r11, r8));
        return;
    L37:
        if (r9.getGameInfo().isGuideDownloaded() == false) goto L39;
        r8.c();
        return;
    L40:
        LiveGameControlWidget$fetchCallBack$1 r13 = new LiveGameControlWidget$fetchCallBack$1(this);
        r r14 = r8.c();
        if (r14 == null) goto L62;
        this.d = new d(this, r8, r14, r13);
        int r15 = com.bytedance.android.live.broadcastgame.effectgame.base.c.a;
        String r16 = String.valueOf(r14.l());
        d r17 = this.d;
        if (r17 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("mEffectFetchListener");
    L46:
        com.bytedance.android.live.broadcastgame.effectgame.base.c.a r18 = (com.bytedance.android.live.broadcastgame.effectgame.base.c.a) WeakReferenceWrapper.wrap(r17);
        Intrinsics.checkNotNullParameter(r16, "effectId");
        Intrinsics.checkNotNullParameter(r18, "listener");
        List<String> r19 = LiveEffectContext.h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().r().d(r16, new e(r18, r16));
        return;
    L62:
        return;
    L61:
        return;
    L21:
        r3 = null;
        goto L22
    L59:
        return;
    L51:
        return;
    L48:
        if (r1.equals("data_broadcast_game_list") == false) goto L56;
        yq((List) r6.getData());
        return;
    L56:
        return;
    L57:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r2) {
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L6;
        r3.observe("data_broadcast_game_list", this);
        r3.observe("cmd_broadcast_game_click", this);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r3) {
        DataCenter r4 = ((Widget) this).dataCenter;
        List<u> r0 = null;
        if (r4 == null) goto L5;
        r0 = (List) r4.get("data_broadcast_game_list", null);
    L5:
        yq(r0);
    }

    public final void yq(List<u> r7) {
        if (r7 == null) goto L45;
        ArrayList r1 = new ArrayList();
        Iterator<T> r0 = r7.iterator();
    L4:
        boolean r3 = true;
        if (r0.hasNext() == false) goto L12;
        Object r2 = r0.next();
        if (((u) r2).interactId == InteractID.EffectGame.getValue()) goto L10;
        r3 = false;
    L10:
        if (r3 == false) goto L4;
        r1.add(r2);
        goto L4
    L12:
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r5 = r1.iterator();
    L14:
        if (r5.hasNext() == false) goto L21;
        r r6 = ((u) r5.next()).c();
        if (r6 == null) goto L19;
        String r8 = String.valueOf(r6.l());
        if (r8 == null) goto L19;
    L20:
        r4.add(r8);
    L19:
        r8 = "";
        goto L20
    L21:
        ArrayList r9 = new ArrayList();
        Iterator r11 = r4.iterator();
    L23:
        if (r11.hasNext() == false) goto L27;
        Object r12 = r11.next();
        if ((!TextUtils.isEmpty((String) r12)) == false) goto L23;
        r9.add(r12);
        goto L23
    L27:
        this.c = new c(this, r7);
        int r13 = com.bytedance.android.live.broadcastgame.effectgame.base.c.a;
        c r14 = this.c;
        if (r14 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mEffectListFetchListener");
    L30:
        com.bytedance.android.live.broadcastgame.effectgame.base.c.b r15 = (com.bytedance.android.live.broadcastgame.effectgame.base.c.b) WeakReferenceWrapper.wrap(r14);
        Intrinsics.checkNotNullParameter(r9, "effectIds");
        Intrinsics.checkNotNullParameter(r15, "listener");
        List<String> r16 = LiveEffectContext.h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().r().j(r9, new g(r15));
        return;
    }

    public LiveGameControlWidget(com.bytedance.android.live.pushstream.d r2, FragmentManager r3) {
        Intrinsics.checkNotNullParameter(r2, "liveStream");
        Intrinsics.checkNotNullParameter(r3, "fragmentManager");
        this.e = r2;
    }

    public static final void wq(LiveGameControlWidget r5, u r6, long r7, boolean r9) {
        r5.getClass();
        long r0 = System.currentTimeMillis() - r7;
        if (r9 == true) goto L5;
        String r8 = "0";
    L6:
        com.bytedance.android.livesdk.log.g r11 = com.bytedance.android.livesdk.log.u.l();
        Pair[] r12 = new Pair[4];
        r12[0] = TuplesKt.to("game_name", r6.name);
        r r13 = r6.c();
        if (r13 == null) goto L9;
        long r3 = r13.p();
    L10:
        r12[1] = TuplesKt.to("game_id", String.valueOf(r3));
        r12[2] = TuplesKt.to("duration", String.valueOf(r0));
        r12[3] = TuplesKt.to("status", r8);
        r11.sendLog("livesdk_live_game_loading_duration", MapsKt.mapOf(r12), new Object[]{Room.class});
        return;
    L9:
        r3 = 0;
        goto L10
    L5:
        r8 = GamePromoteDataContext.GAME_TYPE_MOBILE;
        goto L6
    }

    public final void xq(List<u> r21, long r22, List<u> r24, Map<u, ExceptionResult> r25, int r26) {
        int r0 = r21.size();
        Sticker r11 = null;
        if (r26 < 0) goto L13;
        if (r0 <= r26) goto L13;
        u r13 = (u) ListProtector.get(r21, r26);
        b r14 = new b(this, r21, r22, r24, r13, r25, r26);
        r r1 = r13.c();
        if (r1 == null) goto L9;
        r11 = r1.a;
    L9:
        if (r11 == null) goto L11;
        int r2 = com.bytedance.android.live.broadcastgame.effectgame.base.c.a;
        com.bytedance.android.live.broadcastgame.effectgame.base.c.b(r11, 1, new LiveGameControlWidget$processEffectGameSticker$1(this, r14, r13));
        return;
    L11:
        xq(r21, r22, r24, r25, r26 + 1);
        return;
    L13:
        if ((!r24.isEmpty()) == false) goto L16;
        ((IInteractGameMonitorService) k.n(IInteractGameMonitorService.class)).logEffectBatchLoadEnd(0, r24, r22, 0, "");
    L16:
        if ((!r25.isEmpty()) == false) goto L32;
        Map.Entry r3 = (Map.Entry) CollectionsKt.firstOrNull(r25.entrySet());
        if (r3 == null) goto L20;
        r11 = (ExceptionResult) r3.getValue();
    L20:
        IInteractGameMonitorService r12 = (IInteractGameMonitorService) k.n(IInteractGameMonitorService.class);
        Set<Map.Entry<u, ExceptionResult>> r4 = r25.entrySet();
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r5 = r4.iterator();
    L22:
        if (r5.hasNext() == false) goto L24;
        r15.add((u) ((Map.Entry) r5.next()).getKey());
        goto L22
    L24:
        if (r11 == null) goto L26;
        int r17 = r11.getErrorCode();
    L27:
        if (r11 == null) goto L30;
        String r6 = r11.getMsg();
        if (r6 == null) goto L30;
    L31:
        r12.logEffectBatchLoadEnd(1, r15, r22, r17, r6);
    L30:
        r6 = "";
        goto L31
    L26:
        r17 = 0;
    L32:
        ALogger.d("LiveGameControlWidget", "batch download[" + r24.size() + '/' + r25.size() + "] cost: " + (System.currentTimeMillis() - r22) + "ms");
    }
}

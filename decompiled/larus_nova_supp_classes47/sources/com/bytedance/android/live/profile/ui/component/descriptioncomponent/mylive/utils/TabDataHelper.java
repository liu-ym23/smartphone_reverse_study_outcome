package com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive.utils;

import com.bytedance.android.live.base.model.user.LiveDSLContainer;
import com.bytedance.android.live.base.model.user.MyLiveTab;
import com.bytedance.android.live.base.model.user.MyLiveTabData;
import com.bytedance.android.live.base.model.user.MyLiveTabItem;
import com.bytedance.android.live.base.model.user.MyLiveUIConfig;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profile.repository.NewProfileApi;
import com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive.TabItemAdapter;
import com.bytedance.android.livesdk.dsl.recyclerview.e;
import com.bytedance.android.livesdk.dsl.recyclerview.f;
import com.bytedance.android.livesdkapi.depend.model.live.LiveDSLModel;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import yt1.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class TabDataHelper {
    public TabItemAdapter a;
    public final Lazy b;
    public MyLiveTab.Extra c;
    public Disposable d;
    public final List<e> e;
    public MyLiveTab f;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ TabDataHelper a;

        public b(TabDataHelper r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            com.bytedance.android.live.network.response.e r9 = (com.bytedance.android.live.network.response.e) r8;
            TabDataHelper r0 = this.a;
            Object r1 = null;
            if (r9 == null) goto L9;
            r0.getClass();
            MyLiveTabData r2 = (MyLiveTabData) ((ExtraResponse) r9).data;
            if (r2 == null) goto L9;
            MyLiveTab r3 = r2.getTab();
            if (r3 == null) goto L9;
            MyLiveTab.Extra r4 = r3.getExtra();
        L10:
            r0.c = r4;
            TabDataHelper r5 = this.a;
            r5.getClass();
            if (r9 == null) goto L84;
            MyLiveTabData r10 = (MyLiveTabData) ((ExtraResponse) r9).data;
            if (r10 == null) goto L85;
            MyLiveTab r12 = r10.getTab();
            if (r12 == null) goto L87;
            r5.f = r12;
            if ((CollectionsKt.lastOrNull(r5.e) instanceof rt0.a) == false) goto L25;
            int r13 = CollectionsKt.getLastIndex(r5.e);
            CollectionsKt.removeLastOrNull(r5.e);
            TabItemAdapter r6 = r5.a;
            if (r6 == null) goto L22;
            r6.setData(r5.e);
        L22:
            TabItemAdapter r7 = r5.a;
            if (r7 == null) goto L25;
            r7.notifyItemRemoved(r13);
        L25:
            com.bytedance.android.livesdk.dsl.recyclerview.b r14 = (e) CollectionsKt.lastOrNull(r5.e);
            if (r14 == null) goto L28;
            String r15 = r14.getGroupId();
        L29:
            if (r14 == null) goto L31;
            String r16 = r14.getGroupId();
        L32:
            List r17 = r5.f.getItems();
            if (r17 == null) goto L39;
            MyLiveTabItem r18 = (MyLiveTabItem) CollectionsKt.firstOrNull(r17);
            if (r18 == null) goto L39;
            MyLiveUIConfig r19 = r18.getUiConfig();
            if (r19 == null) goto L39;
            String r20 = r19.group;
        L41:
            if ((!Intrinsics.areEqual(r16, r20)) == false) goto L57;
            if ((r14 instanceof com.bytedance.android.livesdk.dsl.recyclerview.b) == false) goto L70;
            com.bytedance.android.livesdk.dsl.recyclerview.b r22 = r14;
            HashMap r23 = r22.e;
            if (r23 == null) goto L47;
            Object r24 = r23.get("radius");
        L49:
            if (TypeIntrinsics.isMutableMap(r24) == false) goto L52;
            r1 = r24;
        L52:
            Map r25 = (Map) r1;
            if (r25 == null) goto L55;
            String r26 = (String) r25.put("bottom", "12");
        L55:
            r22.a(MapsKt.mapOf(TuplesKt.to("radius", r25)));
            goto L70
        L47:
            r24 = null;
        L70:
            List<e> r27 = r5.b(r5.a(r15, r5.f.getItems()), ((ArrayList) r5.e).size());
            int r28 = ((ArrayList) r5.e).size();
            ((ArrayList) r5.e).addAll(r27);
            TabItemAdapter r29 = r5.a;
            if (r29 == null) goto L73;
            r29.setData(r5.e);
        L73:
            TabItemAdapter r30 = r5.a;
            if (r30 == null) goto L76;
            r30.notifyItemRangeInserted(r28, ((ArrayList) r27).size());
        L76:
            int r32 = ((ArrayList) r27).size();
            int r33 = r28 - 1;
            if (r33 < 0) goto L79;
            r32 = r32 + 1;
        L80:
            TabItemAdapter r34 = r5.a;
            if (r34 == null) goto L86;
            r34.notifyItemRangeChanged(r33, r32);
            return;
        L86:
            return;
        L79:
            r33 = 0;
            goto L80
        L57:
            if ((r14 instanceof com.bytedance.android.livesdk.dsl.recyclerview.b) == false) goto L70;
            com.bytedance.android.livesdk.dsl.recyclerview.b r35 = r14;
            HashMap r36 = r35.e;
            if (r36 == null) goto L61;
            Object r37 = r36.get("radius");
        L63:
            if (TypeIntrinsics.isMutableMap(r37) == false) goto L66;
            r1 = r37;
        L66:
            Map r38 = (Map) r1;
            if (r38 == null) goto L69;
            String r39 = (String) r38.put("bottom", DataType.FALSE);
        L69:
            r35.a(MapsKt.mapOf(TuplesKt.to("radius", r38)));
            goto L70
        L61:
            r37 = null;
        L39:
            r20 = null;
            goto L41
        L31:
            r16 = null;
            goto L32
        L28:
            r15 = null;
            goto L29
        L87:
            return;
        L85:
            return;
        L84:
            return;
        L9:
            r4 = null;
            goto L10
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ TabDataHelper a;

        public c(TabDataHelper r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            TabDataHelper r5 = this.a;
            e r0 = (e) CollectionsKt.lastOrNull(r5.e);
            if (r0 != null) goto L6;
            return;
        L6:
            if ((r0 instanceof rt0.a) == false) goto L8;
            ((rt0.a) r0).c = false;
        L8:
            TabItemAdapter r1 = r5.a;
            if (r1 == null) goto L11;
            r1.setData(r5.e);
        L11:
            TabItemAdapter r2 = r5.a;
            if (r2 == null) goto L15;
            r2.notifyItemChanged(CollectionsKt.getLastIndex(r5.e));
            return;
        }
    }

    static {
    }

    public final void c() {
        MyLiveTab.Extra r0 = this.c;
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.getHasMore() != true) goto L7;
    L9:
        if (r1 == true) goto L12;
        ALogger.i("TabDataHelper", "queryMore, there's no more ");
        return;
    L12:
        Disposable r2 = this.d;
        if (r2 != null) goto L15;
    L18:
        MyLiveTab.Extra r3 = this.c;
        if (r3 != null) goto L21;
        return;
    L21:
        NewProfileApi r4 = (NewProfileApi) com.bytedance.android.live.network.c.b().e(NewProfileApi.class);
        if (r4 == null) goto L30;
        Single<com.bytedance.android.live.network.response.e<MyLiveTabData>> r5 = r4.queryMoreTabsInfo(this.f.getBizName(), r3.getNextQueryIndex());
        if (r5 == null) goto L30;
        Single r6 = r5.subscribeOn(Schedulers.io());
        if (r6 == null) goto L30;
        Single r7 = r6.observeOn(AndroidSchedulers.mainThread());
        if (r7 == null) goto L30;
        Disposable r8 = r7.subscribe(new b(this), new c(this));
    L31:
        this.d = r8;
        return;
    L30:
        r8 = null;
        goto L31
    L15:
        if (r2.isDisposed() == true) goto L18;
        ALogger.i("TabDataHelper", "is requesting");
        return;
    L7:
        r1 = false;
        goto L9
    }

    public TabDataHelper(MyLiveTab r2) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        this.f = r2;
        this.b = LazyKt.lazy(TabDataHelper$templateStore$2.INSTANCE);
        this.c = this.f.getExtra();
        this.e = new ArrayList();
    }

    public final List<MyLiveTabItem> a(String r9, List<MyLiveTabItem> r10) {
        ArrayList r0 = new ArrayList();
        MyLiveTabItem r3 = null;
        if (r10 == null) goto L23;
        Iterator<T> r12 = r10.iterator();
        MyLiveTabItem r4 = null;
        int r5 = 0;
    L6:
        if (r12.hasNext() == false) goto L22;
        Object r6 = r12.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        MyLiveTabItem r8 = (MyLiveTabItem) r6;
        MyLiveUIConfig r13 = r8.getUiConfig();
        if (r13 == null) goto L13;
        String r14 = r13.group;
    L15:
        if ((!Intrinsics.areEqual(r14, r9)) == false) goto L17;
        d(r4, false, true);
        int r15 = rt0.c.c;
        MyLiveTabItem r16 = new MyLiveTabItem();
        r16.setLocalId(-101);
        r0.add(r16);
        d(r8, true, false);
    L17:
        r0.add(r8);
        MyLiveUIConfig r17 = r8.getUiConfig();
        if (r17 == null) goto L20;
        r9 = r17.group;
    L21:
        r4 = r8;
        r5 = r7;
        goto L6
    L20:
        r9 = null;
        goto L21
    L13:
        r14 = null;
        goto L15
    L22:
        r3 = r4;
    L23:
        MyLiveTab.Extra r18 = this.c;
        if (r18 != null) goto L26;
    L28:
        boolean r19 = false;
    L29:
        if (r19 == false) goto L31;
        d(r3, false, true);
        int r20 = rt0.a.d;
        MyLiveTabItem r22 = new MyLiveTabItem();
        r22.setLocalId(-100);
        r0.add(r22);
    L31:
        return r0;
    L26:
        if (r18.getHasMore() != true) goto L28;
        r19 = true;
        goto L29
    }

    public final List<e> b(List<MyLiveTabItem> r14, int r15) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r16 = r14.iterator();
        int r2 = 0;
    L4:
        if (r16.hasNext() == false) goto L60;
        Object r3 = r16.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        MyLiveTabItem r5 = (MyLiveTabItem) r3;
        Integer r6 = r5.getLocalId();
        if (r6 != null) goto L12;
    L14:
        if (r6 != null) goto L17;
    L19:
        int r7 = r2 + r15;
        LiveDSLContainer r8 = r5.getDslItem();
        Long r9 = null;
        if (r8 == null) goto L22;
        LiveDSLModel r10 = r8.getDslModel();
    L23:
        Integer r12 = r5.getLocalId();
        if (r12 != null) goto L28;
        if (r10 == null) goto L27;
        r12 = Integer.valueOf((int) r10.getId());
        goto L28
    L27:
        r12 = null;
    L28:
        int r13 = -1;
        if (r12 == null) goto L31;
        int r17 = r12.intValue();
    L33:
        if (r5.getRadius() == null) goto L35;
        Map r18 = MapsKt.mapOf(TuplesKt.to("radius", r5.getRadius()));
    L37:
        if (r10 == null) goto L40;
        String r19 = r10.getDslData();
        if (r19 == null) goto L40;
    L41:
        MyLiveUIConfig r110 = r5.getUiConfig();
        if (r110 == null) goto L44;
        String r111 = r110.group;
    L45:
        e r112 = new rt0.b(r19, r7, r17, r111);
        if (r10 == null) goto L48;
        r9 = Long.valueOf(r10.getId());
    L48:
        ((com.bytedance.android.livesdk.dsl.recyclerview.b) r112).b = r9;
        if (r18 == null) goto L51;
        r112.a(r18);
    L51:
        r112.a(MapsKt.mapOf(TuplesKt.to("tab_type", this.f.getBizName())));
        r0.add(r112);
        LiveDSLContainer r20 = r5.getDslItem();
        if (r20 == null) goto L59;
        LiveDSLModel r22 = r20.getDslModel();
        if (r22 == null) goto L59;
        f r23 = (f) this.b.getValue();
        TabItemAdapter r24 = this.a;
        if (r24 == null) goto L58;
        r13 = r24.y2(r112);
    L58:
        o.e.getClass();
        r23.b(r13, o.a.b(r22));
    L59:
        r2 = r4;
        goto L4
    L44:
        r111 = null;
    L40:
        r19 = "";
        goto L41
    L35:
        r18 = null;
        goto L37
    L31:
        r17 = -1;
        goto L33
    L22:
        r10 = null;
        goto L23
    L17:
        if (r6.intValue() != (-101)) goto L19;
        r0.add(new rt0.c());
        goto L59
    L12:
        if (r6.intValue() != (-100)) goto L14;
        r0.add(new rt0.a(0));
        goto L59
    L60:
        return r0;
    }

    public static void d(MyLiveTabItem r6, boolean r7, boolean r8) {
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.getRadius() != null) goto L7;
        r6.setRadius(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("top", DataType.FALSE), TuplesKt.to("bottom", DataType.FALSE)}));
    L7:
        Map r9 = r6.getRadius();
        if (r9 != null) goto L10;
        return;
    L10:
        if (r7 == false) goto L12;
        r9.put("top", "12");
    L12:
        if (r8 == false) goto L16;
        r9.put("bottom", "12");
        return;
    }
}

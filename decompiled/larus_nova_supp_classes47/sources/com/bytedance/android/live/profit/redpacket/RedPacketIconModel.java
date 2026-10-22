package com.bytedance.android.live.profit.redpacket;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profit.redpacket.trace.RedPacketTraceMonitor;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.sti.IRevIconModel;
import com.bytedance.android.livesdk.revenue.sti.RevStiElementType;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import zg1.q2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RedPacketIconModel extends com.bytedance.android.live.revenue.common.a<y0.a> {
    public static final com.bytedance.android.live.revenue.common.u0 w = null;
    public final CompositeDisposable f;
    public final CompositeDisposable g;
    public Disposable h;
    public boolean i;
    public String j;
    public final PropertyOwner<Integer> k;
    public boolean l;
    public String m;
    public String n;
    public final String o;
    public final w0 p;
    public final y0 q;
    public final bv0.b r;
    public final c01.a s;
    public final yz0.k t;
    public final RedPacketHybridService u;
    public final r0 v;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ RedPacketIconModel a;

        public b(RedPacketIconModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ALogger.i("RedPacketIconMode", "on red packet check event");
            if (((Boolean) r3).booleanValue() == false) goto L15;
            RedPacketIconModel r4 = this.a;
            r4.getClass();
            if (((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).isLogin() == true) goto L8;
            ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).z4(r4.getContext(), RedPacketIconModel$login$1.INSTANCE);
        L11:
            Disposable r5 = this.a.h;
            if (r5 == null) goto L16;
            r5.dispose();
            return;
        L16:
            return;
        L8:
            if (((List) r4.q.k.e.d).isEmpty() == false) goto L10;
            ToastUtil.a(2131922013, 0);
            goto L11
        L10:
            r4.h(false);
            goto L11
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ RedPacketIconModel a;

        public c(RedPacketIconModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            RedPacketIconModel r0 = this.a;
            r0.moveToState((y0.a) r2);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ RedPacketIconModel a;

        public d(RedPacketIconModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            if (((q2) r3).a != 0) goto L9;
            RedPacketIconModel r4 = this.a;
            r4.getClass();
            l01.d r0 = (l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class);
            if (r0.isLogin() == true) goto L7;
            r0.z4(r4.getContext(), RedPacketIconModel$wannaSend$1.INSTANCE);
            return;
        L7:
            r4.j();
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ RedPacketIconModel a;

        public e(RedPacketIconModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            PropertyOwner<Integer> r0 = this.a.k;
            r0.a((Integer) r2);
        }
    }

    public final void onClick() {
        h(false);
        com.bytedance.android.live.profit.util.e.a(this.p, com.bytedance.android.live.profit.util.m.b);
    }

    static {
        com.bytedance.android.live.revenue.common.u0 r0 = com.bytedance.android.live.revenue.common.u0.f;
        w = com.bytedance.android.live.revenue.common.u0.a.a(5);
    }

    @Override // com.bytedance.android.live.revenue.common.a
    public final void g() {
        bindModel(com.bytedance.android.live.core.arch.mvvm.f.b(this.q.d).subscribe(new c(this)));
        bindModel(xs2.b.a().b(q2.class).subscribe(new d(this)));
        bindModel(this.q.h.subscribe(new k0(this)));
        bindModel(com.bytedance.android.live.core.arch.mvvm.f.b(this.q.j).subscribe(new l0(this)));
        RxUtilKt.c(com.bytedance.android.live.core.arch.mvvm.f.b(this.v.o).subscribe(new f0(this)), this.f);
        RxUtilKt.c(com.bytedance.android.live.core.arch.mvvm.f.b(this.v.s).subscribe(new h0(this)), this.f);
        RxUtilKt.c(com.bytedance.android.live.core.arch.mvvm.f.b(this.v.q).subscribe(new i0(this)), this.f);
        bindModel(com.bytedance.android.live.core.arch.mvvm.f.b(this.q.k.i).subscribe(new e(this)));
    }

    public final void j() {
        Uri.Builder r0 = UriProtector.parse("sslocal://webcast_webview").buildUpon();
        ReadOnlyProperty r1 = i1.e;
        KProperty[] r2 = i1.a;
        String r3 = (String) r1.getValue(null, r2[3]);
        Integer r4 = (Integer) vh6.c.b(wh6.a.class).getClientABValue(i1.m);
        boolean r6 = true;
        if (((Boolean) i1.k.getValue(null, r2[9])).booleanValue() == true) goto L8;
        if (r4 != null) goto L7;
    L9:
        Uri.Builder r5 = UriProtector.parse(r3).buildUpon();
        IBaseUser r7 = this.t.getRoom().getOwner();
        if (r7 == null) goto L12;
        r5.appendQueryParameter("anchor_id", r7.getIdString());
    L12:
        r5.appendQueryParameter("room_id", String.valueOf(this.t.getRoom().getId()));
        IBaseUser r8 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).b();
        Intrinsics.checkNotNullParameter(r8, "$this$isFirstConsume");
        py.d r9 = r8.getUserHonor();
        if (r9 != null) goto L15;
    L17:
        r6 = false;
    L18:
        if (r6 == false) goto L20;
        String r10 = DataType.TRUE;
    L21:
        r5.appendQueryParameter("is_first_consume", r10);
        r5.appendQueryParameter("room_type", o.c());
        Uri r12 = r5.build();
        Set r13 = UriProtector.getQueryParameterNames(r12);
        if (r13 == null) goto L27;
        Iterator r14 = r13.iterator();
    L25:
        if (r14.hasNext() == false) goto L27;
        String r15 = (String) r14.next();
        r0.appendQueryParameter(r15, UriProtector.getQueryParameter(r12, r15));
    L27:
        ((zz0.g) com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class)).S2(getContext(), r0.build().toString());
        return;
    L20:
        r10 = DataType.FALSE;
        goto L21
    L15:
        if (r9.getLevel() != 0) goto L17;
    L7:
        if (r4.intValue() != 1) goto L9;
    L8:
        r0 = UriProtector.parse("sslocal://webcast_lynxview").buildUpon();
        r3 = (String) i1.l.getValue(null, r2[10]);
        goto L9
    }

    @Override // com.bytedance.android.live.revenue.common.a
    public final void onAppear() {
        ALogger.i("RedPacketIconMode", "on appear");
        if (this.h != null) goto L6;
        this.h = com.bytedance.android.live.core.arch.mvvm.f.b(this.q.k.k).subscribe(new b(this));
        return;
    }

    @Override // com.bytedance.android.live.revenue.common.a
    public final void onDestroy() {
        this.f.dispose();
    }

    @Override // com.bytedance.android.live.revenue.common.a
    public final void onHideTempState() {
        this.g.clear();
    }

    public final xr2.h getViewForState(Object r10) {
        y0.a r12 = (y0.a) r10;
        Intrinsics.checkNotNullParameter(r12, "state");
        View r3 = null;
        if ((r12 instanceof y0.a.e) == false) goto L11;
        xr2.f r0 = createIconTemplate(xr2.f.class);
        r0.setContentView(r0.inflateContentView(2131567773));
        View r4 = r0.getContentView();
        if ((r4 instanceof ViewGroup) == false) goto L8;
        r3 = r4;
    L8:
        b0.c((ViewGroup) r3, r12, this.r);
        r0.setContentRightMargin(com.bytedance.android.live.revenue.common.i.b(10));
        r0.setContentTopMargin(com.bytedance.android.live.revenue.common.i.b(6));
    L30:
        return r0;
    L11:
        if ((r12 instanceof y0.a.C0049a) == false) goto L18;
        r0 = createIconTemplate(xr2.f.class);
        xr2.f r5 = r0;
        r5.setContentView(r5.inflateContentView(2131567772));
        View r6 = r5.getContentView();
        if ((r6 instanceof ViewGroup) == false) goto L16;
        r3 = r6;
    L16:
        b0.c((ViewGroup) r3, r12, this.r);
        r5.setContentRightMargin(com.bytedance.android.live.revenue.common.i.b(10));
        r5.setContentTopMargin(com.bytedance.android.live.revenue.common.i.b(6));
        goto L30
    L18:
        if ((r12 instanceof y0.a.b) == false) goto L29;
        xr2.b r13 = createIconTemplate(xr2.b.class);
        xr2.b r1 = r13;
        HSImageView r2 = new HSImageView(getContext());
        GenericDraweeHierarchyBuilder r7 = GenericDraweeHierarchyBuilder.newInstance(getContext().getResources()).setFadeDuration(0);
        xr2.h r8 = getCurrentView();
        if (r8 == null) goto L22;
        r3 = r8.getView();
    L22:
        if (r3 == null) goto L27;
        int r9 = r3.getMeasuredWidth();
        int r14 = r3.getMeasuredHeight();
        if (r9 <= 0) goto L27;
        if (r14 <= 0) goto L27;
        Bitmap r15 = Bitmap.createBitmap(r9, r14, Bitmap.Config.ARGB_8888);
        Canvas r16 = new Canvas(r15);
        r3.layout(0, 0, r15.getWidth(), r15.getHeight());
        r3.draw(r16);
        r7.setPlaceholderImage(new BitmapDrawable(getContext().getResources(), r15));
    L27:
        r2.setHierarchy(r7.build());
        Unit r17 = Unit.INSTANCE;
        r1.setContentView(r2);
        return r13;
    L29:
        if ((r12 instanceof y0.a.c) == false) goto L32;
        return null;
    L32:
        throw new NoWhenBranchMatchedException();
    }

    public final void h(boolean r8) {
        Object r0 = getCurrentState();
        com.bytedance.android.live.profit.redpacket.e r2 = null;
        if ((r0 instanceof y0.a.d) == true) goto L5;
        r0 = null;
    L5:
        y0.a.d r1 = (y0.a.d) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        com.bytedance.android.live.profit.redpacket.e r3 = r1.a();
        if ((r1 instanceof y0.a.b) == true) goto L11;
        r1 = null;
    L11:
        y0.a.b r4 = (y0.a.b) r1;
        if (r4 == null) goto L15;
        r2 = r4.a;
    L15:
        if (((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).isLogin() == true) goto L17;
        ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).z4(getContext(), RedPacketIconModel$login$1.INSTANCE);
    L18:
        n0 r5 = r3.getState().getInfo();
        boolean r6 = this.t.isAnchor();
        Intrinsics.checkNotNullParameter(r5, "currentPacket");
        long r7 = RangesKt.coerceAtLeast(r5.h.b(x0.d()).a / com.bytedance.android.live.revenue.common.u0.b, 0);
        int r9 = r5.m;
        Intrinsics.checkNotNullParameter(r5, "currentPacket");
        Pair[] r10 = new Pair[3];
        if (r8 == false) goto L21;
        String r12 = "all";
    L22:
        r10[0] = TuplesKt.to("click_from", r12);
        r10[1] = TuplesKt.to("money", String.valueOf(r9));
        r10[2] = TuplesKt.to(Constants.OperatorKey.KEY_COST_TIME, String.valueOf(r7));
        Map<? extends String, ? extends String> r13 = MapsKt.mutableMapOf(r10);
        o.a(r13, r5, r6);
        mz0.n r14 = new mz0.n();
        Map<String, String> r15 = r14.a;
        Intrinsics.checkNotNullParameter(r15, "map");
        Intrinsics.checkNotNullParameter(r13, "map");
        r15.putAll(r13);
        mz0.m r16 = new mz0.m();
        r16.b(LogCommon.PAGE_SOURCE_LOG);
        r16.b(LogCommon.ROOM);
        ((ArrayList) r14.b).addAll(r16.a);
        cy0.e.a.getClass();
        cy0.j r17 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r18 = com.bytedance.android.scope.m.b(r17).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r18);
        ((mz0.i) ((f80.a) r18)).w3("livesdk_redpackage_click", r14.a, r14.b);
        int r19 = RedPacketTraceMonitor.a;
        RedPacketTraceMonitor.a(RedPacketTraceMonitor.EventName.TTLIVE_RED_PACKET_CLICK.getEventName(), "", MapsKt.emptyMap());
        int r20 = h.a;
        bindModel(RxUtilKt.r(h.a(this.t.getRoom()), "RedPacketIconModel"));
        return;
    L21:
        r12 = DataType.Normal;
        goto L22
    L17:
        i(r2, CollectionsKt.emptyList(), RedPacketDialogShowFrom.STI_CLICK);
        goto L18
    }

    @Override // com.bytedance.android.live.revenue.common.a
    public final void onShowTempState(int r5) {
        Object r6 = getCurrentState();
        com.bytedance.android.live.revenue.common.u0 r1 = null;
        if ((r6 instanceof y0.a.d) == true) goto L5;
        r6 = null;
    L5:
        y0.a.d r7 = (y0.a.d) r6;
        if (r7 == null) goto L12;
        com.bytedance.android.live.profit.redpacket.e r8 = r7.a();
        if (r8 == null) goto L12;
        RedPacketState r9 = r8.getState();
        if (r9 == null) goto L12;
        n0 r10 = r9.getInfo();
    L13:
        if (r10 == null) goto L16;
        com.bytedance.android.live.revenue.common.u0 r0 = r10.h;
        if (r0 == null) goto L16;
    L17:
        com.bytedance.android.live.revenue.common.u0 r2 = r0.b(x0.d());
        com.bytedance.android.live.revenue.common.u0 r3 = w;
        r2.a(r3);
        StringBuilder r4 = new StringBuilder("curPacket?.waitDuration = ");
        if (r10 == null) goto L20;
        r1 = r10.g;
    L20:
        r4.append(r1);
        r4.append("  + TEMP_STATUS_SMALLEST_SHOW_TIME=");
        r4.append(r3);
        ALogger.i("RedPacketIconMode", r4.toString());
        if (r10 != null) goto L23;
    L25:
        showNormalState();
        return;
    L23:
        if ((getCurrentState() instanceof y0.a.C0049a) == true) goto L25;
        this.m = r10.d;
        return;
    L16:
        r0 = com.bytedance.android.live.revenue.common.u0.f;
    L12:
        r10 = null;
        goto L13
    }

    public final IRevIconModel.a getEntryViewForState(Object r19, Object r20) {
        Object r1 = (y0.a) r19;
        y0.a r2 = (y0.a) r20;
        Intrinsics.checkNotNullParameter(r1, "state");
        if ((r1 instanceof y0.a.d) == true) goto L5;
    L136:
        return null;
    L5:
        if ((r2 instanceof y0.a.c) == false) goto L136;
        int r3 = ((Number) i1.h.getValue(null, i1.a[6])).intValue();
        ArraysKt.contains(new Integer[]{1, 2, 6, 7}, Integer.valueOf(r3));
        ArraysKt.contains(new Integer[]{2, 7}, Integer.valueOf(r3));
        ArraysKt.contains(new Integer[]{3, 5, 6, 7}, Integer.valueOf(r3));
        if (ArraysKt.contains(new Integer[]{4, 5, 6, 7}, Integer.valueOf(r3)) == false) goto L126;
        IRevIconModel.a r4 = inflateEntryView(2131567278);
        View r5 = r4.a;
        if (r5 == null) goto L125;
        ViewGroup r6 = (ViewGroup) r5;
        int r10 = this.q.c();
        Iterable r7 = (Iterable) this.q.k.e.d;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r8 = r7.iterator();
    L12:
        if (r8.hasNext() == false) goto L14;
        r12.add(((RedPacket) r8.next()).getState().getInfo());
        goto L12
    L14:
        Intrinsics.checkNotNullParameter(r12, "infoList");
        Iterator r14 = r12.iterator();
        if (r14.hasNext() == true) goto L17;
        Object r9 = null;
    L26:
        final n0 r13 = (n0) r9;
        if (r13 == null) goto L29;
        py.k r15 = x0.c(r13);
    L30:
        LinkedHashMap r16 = new LinkedHashMap();
        Iterator r17 = r12.iterator();
    L32:
        if (r17.hasNext() == false) goto L53;
        Object r18 = r17.next();
        n0 r22 = (n0) r18;
        IBaseUser r23 = r22.j;
        String r110 = r23.getWebcastUid();
        if (r110 != null) goto L36;
    L39:
        boolean r111 = true;
    L40:
        if (r111 == true) goto L43;
        r23 = null;
    L43:
        if (r23 == null) goto L46;
        String r24 = r23.getIdString();
        if (r24 == null) goto L46;
    L47:
        if (r24 != null) goto L49;
        r24 = "";
    L49:
        Object r25 = r16.get(r24);
        if (r25 != null) goto L52;
        r25 = new ArrayList();
        r16.put(r24, r25);
    L52:
        ((List) r25).add(r18);
    L46:
        r24 = r22.j.getWebcastUid();
        goto L47
    L36:
        if (r110.length() == 0) goto L39;
        r111 = false;
        goto L40
    L53:
        List r26 = SequencesKt.toList(SequencesKt.sortedWith(SequencesKt.map(CollectionsKt.asSequence(r16.values()), RedPacketIconHelpersKt$generateEntryList$topUsers$2.INSTANCE), z.a));
        List r27 = SequencesKt.toList(SequencesKt.map(SequencesKt.take(SequencesKt.filter(CollectionsKt.asSequence(r26), new RedPacketIconHelpersKt$generateEntryList$topTwoUsers$1(r13)), 2), RedPacketIconHelpersKt$generateEntryList$topTwoUsers$2.INSTANCE));
        List r28 = SequencesKt.toList(SequencesKt.take(CollectionsKt.asSequence(r26), 3));
        ArrayList r29 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r28, 10));
        Iterator r30 = r28.iterator();
    L55:
        if (r30.hasNext() == false) goto L57;
        r29.add(((RedPacketIconHelpersKt$generateEntryList$topUsers$2.a) r30.next()).b);
        goto L55
    L57:
        ArrayList r32 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r29, 10));
        Iterator r33 = r29.iterator();
    L59:
        if (r33.hasNext() == false) goto L61;
        r32.add(((n0) r33.next()).j);
        goto L59
    L61:
        com.bytedance.android.live.profit.redpacket.c r34 = new com.bytedance.android.live.profit.redpacket.c(CollectionsKt.filterNotNull(CollectionsKt.plus(r27, CollectionsKt.listOf(r15))));
        bv0.b r35 = this.r;
        Intrinsics.checkNotNullParameter(r6, "rootView");
        Intrinsics.checkNotNullParameter(r34, "entryInfo");
        Intrinsics.checkNotNullParameter(r35, "redPacketDressService");
        List<py.k> r36 = r34.a;
        ((TextView) r6.findViewById(2131367087)).setText(String.valueOf(r10));
        ViewGroup r37 = (ViewGroup) r6.findViewById(2131363653);
        HSImageView r38 = r6.findViewById(2131367089);
        if (r38 == null) goto L64;
        py.k r112 = r3.a();
        Intrinsics.checkNotNullParameter(r38, "$this$bindImage");
        ImageLoader.bindImage(r38, r112);
    L64:
        LayoutInflater r39 = LayoutInflater.from(r6.getContext());
        int r113 = r36.size();
        if (r113 == 1) goto L69;
        if (r113 == 2) goto L68;
        r39.inflate(2131567281, r37);
    L70:
        Iterator r40 = CollectionsKt.zip(r36, new Integer[]{2131363624, 2131363625, 2131363626}).iterator();
    L72:
        if (r40.hasNext() == false) goto L76;
        Pair r42 = (Pair) r40.next();
        py.k r43 = (py.k) r42.component1();
        HSImageView r44 = r37.findViewById(((Number) r42.component2()).intValue());
        if (r44 == null) goto L72;
        Intrinsics.checkNotNullParameter(r44, "$this$bindImage");
        ImageLoader.bindImage(r44, r43);
        goto L72
    L76:
        HSImageView r45 = r6.findViewById(2131363806);
        String r46 = r34.b;
        if (r46 == null) goto L121;
        RedPacketDressType r47 = RedPacketDressType.EnterSkinPng;
        r35.getClass();
        Intrinsics.checkNotNullParameter(r46, "dressId");
        Intrinsics.checkNotNullParameter(r47, "dressType");
        if (StringsKt.isBlank(r46) == true) goto L121;
        if (((LinkedHashMap) r35.a).keySet().contains(r46) == true) goto L84;
    L85:
        zt0.d r48 = yt0.c.b();
        if (r48 == null) goto L88;
        zt0.c r49 = r48.d2();
    L89:
        Map<String, com.bytedance.android.live.profit.dress.w> r50 = r35.a;
        if (r49 == null) goto L94;
        com.bytedance.android.live.profit.dress.config.y r52 = (com.bytedance.android.live.profit.dress.config.y) r49.a(r46, Reflection.getOrCreateKotlinClass(com.bytedance.android.live.profit.dress.config.y.class));
        if (r52 == null) goto L94;
        com.bytedance.android.live.profit.dress.w r53 = r52.c;
    L95:
        r50.put(r46, r53);
    L96:
        com.bytedance.android.live.profit.dress.w r54 = (com.bytedance.android.live.profit.dress.w) ((LinkedHashMap) r35.a).get(r46);
        switch(bv0.a.a[r47.ordinal()]) {
            case 1: goto L119;
            case 2: goto L117;
            case 3: goto L115;
            case 4: goto L113;
            case 5: goto L111;
            case 6: goto L109;
            case 7: goto L107;
            case 8: goto L105;
            case 9: goto L103;
            case 10: goto L101;
            case 11: goto L99;
            default: goto L121;
        };
    L99:
        if (r54 == null) goto L121;
        py.k r55 = r54.l;
    L122:
        ImageUtil.loadImage(r45, r55, 0);
        r6.setOnClickListener(new e0(this));
        return r4;
    L101:
        if (r54 == null) goto L121;
        r55 = r54.i;
        goto L122
    L103:
        if (r54 == null) goto L121;
        r55 = r54.k;
        goto L122
    L105:
        if (r54 == null) goto L121;
        r55 = r54.j;
        goto L122
    L107:
        if (r54 == null) goto L121;
        r55 = r54.h;
        goto L122
    L109:
        if (r54 == null) goto L121;
        r55 = r54.g;
        goto L122
    L111:
        if (r54 == null) goto L121;
        r55 = r54.f;
        goto L122
    L113:
        if (r54 == null) goto L121;
        r55 = r54.e;
        goto L122
    L115:
        if (r54 == null) goto L121;
        r55 = r54.d;
        goto L122
    L117:
        if (r54 == null) goto L121;
        r55 = r54.c;
        goto L122
    L119:
        if (r54 == null) goto L121;
        r55 = r54.b;
    L94:
        r53 = null;
        goto L95
    L88:
        r49 = null;
        goto L89
    L84:
        if (((LinkedHashMap) r35.a).get(r46) != null) goto L96;
    L121:
        r55 = null;
        goto L122
    L68:
        r39.inflate(2131567280, r37);
        goto L70
    L69:
        r39.inflate(2131567279, r37);
        goto L70
    L29:
        r15 = null;
        goto L30
    L17:
        r9 = r14.next();
        if (r14.hasNext() == false) goto L26;
        com.bytedance.android.live.revenue.common.u0 r114 = ((n0) r9).h;
    L21:
        Object r115 = r14.next();
        com.bytedance.android.live.revenue.common.u0 r56 = ((n0) r115).h;
        if (r114.compareTo(r56) <= 0) goto L25;
        r114 = r56;
        r9 = r115;
    L25:
        if (r14.hasNext() == true) goto L21;
    L125:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L126:
        IRevIconModel.a r57 = inflateEntryView(2131567771);
        View r58 = r57.a;
        if (r58 == null) goto L135;
        ViewGroup r59 = (ViewGroup) r58;
        HSImageView r60 = r59.findViewById(2131376711);
        TextView r62 = (TextView) r59.findViewById(2131390324);
        HSImageView r63 = r59.findViewById(2131367089);
        n0 r64 = ((y0.a.d) r1).a().getState().getInfo();
        if (r60 == null) goto L131;
        py.k r65 = x0.c(r64);
        Intrinsics.checkNotNullParameter(r60, "$this$bindImage");
        ImageLoader.bindImage(r60, r65);
    L131:
        if (r63 == null) goto L133;
        py.k r66 = r3.a();
        Intrinsics.checkNotNullParameter(r63, "$this$bindImage");
        ImageLoader.bindImage(r63, r66);
    L133:
        r62.setText(String.valueOf(r64.m));
        return r57;
    L135:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(Object r17, Object r18, xr2.h r19) {
        y0.a r8 = (y0.a) r17;
        y0.a r9 = (y0.a) r18;
        Intrinsics.checkNotNullParameter(r9, "curState");
        boolean r10 = r9 instanceof y0.a.d;
        if (r10 == false) goto L41;
        if ((r19 instanceof xr2.a) == false) goto L41;
        bindState(RxUtilKt.e(com.bytedance.android.live.core.arch.mvvm.f.b(this.q.f)).subscribe(new c0(this, r19)));
        if ((r9 instanceof y0.a.e) == false) goto L14;
        y0.a.d r13 = (y0.a.d) r9;
        startCountDown(r13.a().getState().getInfo().h.b(x0.d()).a, null, null, null);
        bindModel(getCountDownObservable().subscribe(new j0(this)));
        View r0 = r19.getView();
        if (r0 == null) goto L12;
        HSImageView r1 = ((ViewGroup) r0).findViewById(2131376711);
        r1.setActualImageResource(0);
        py.k r2 = x0.c(r13.a().getState().getInfo());
        Intrinsics.checkNotNullParameter(r1, "$this$bindImage");
        ImageLoader.bindImage(r1, r2);
    L37:
        String r3 = ((y0.a.d) r9).a().getState().getInfo().d;
        if ((!Intrinsics.areEqual(this.j, r3)) == false) goto L41;
        com.bytedance.android.live.profit.util.e.b(this.p, com.bytedance.android.live.profit.util.m.b);
        this.j = r3;
        goto L41
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L14:
        if ((r9 instanceof y0.a.b) == false) goto L25;
        if ((r19 instanceof xr2.b) == false) goto L37;
        HSImageView r4 = ((xr2.b) r19).getContentView();
        if ((r4 instanceof HSImageView) == false) goto L37;
        if (((Number) this.q.f.a).intValue() != 0) goto L22;
        b0.b(r9, this.r, RedPacketDressType.ShortTouchEmptyHideWebp);
        String r5 = "asset://com.ss.android.ies.live.sdk/ttlive_red_packet_sti_empty_hide.webp";
    L23:
        HSImageView r6 = r4;
        r6.setController(Fresco.newDraweeControllerBuilder().setUri(r5).setControllerListener(com.bytedance.android.live.profit.util.k.a(null, ((y0.a.b) r9).b, false, 13)).build());
        r6.getHierarchy();
        goto L37
    L22:
        b0.b(r9, this.r, RedPacketDressType.ShortTouchEmptyMoreWebp);
        r5 = "asset://com.ss.android.ies.live.sdk/ttlive_red_packet_sti_empty_more.webp";
        goto L23
    L25:
        if ((r9 instanceof y0.a.C0049a) == false) goto L37;
        if ((r8 instanceof y0.a.C0049a) == true) goto L32;
        if ((r19 instanceof xr2.f) == false) goto L32;
        ((xr2.f) r19).shake();
        bindState(Disposables.fromAction(new d0(r19)));
    L32:
        if (Intrinsics.areEqual(((y0.a.d) r9).a().getState().getInfo().d, this.m.toString()) == false) goto L37;
        if (this.l == false) goto L36;
        this.l = false;
    L36:
        showNormalState();
    L41:
        if (this.i == true) goto L65;
        if (r10 == true) goto L44;
        return;
    L44:
        if ((r8 instanceof y0.a.d) == true) goto L67;
        long r7 = System.currentTimeMillis() - this.p.p().b;
        n0 r12 = ((y0.a.d) r9).a().getState().getInfo();
        int r14 = ((Number) this.q.f.a).intValue();
        int r15 = this.q.c();
        boolean r16 = this.t.isAnchor();
        Long r20 = Long.valueOf(r7);
        Intrinsics.checkNotNullParameter(r12, "currentPacket");
        long r22 = RangesKt.coerceAtLeast(r12.h.b(x0.d()).a / com.bytedance.android.live.revenue.common.u0.b, 0);
        RedPacketDataSource r23 = r12.o;
        Intrinsics.checkNotNullParameter(r12, "currentPacket");
        Intrinsics.checkNotNullParameter(r23, "dataSource");
        Pair[] r24 = new Pair[4];
        r24[0] = TuplesKt.to("count", String.valueOf(r14));
        r24[1] = TuplesKt.to(Constants.OperatorKey.KEY_COST_TIME, String.valueOf(r22));
        r24[2] = TuplesKt.to("money", String.valueOf(r15));
        int[] r25 = n.a;
        int r26 = r25[r23.ordinal()];
        String r27 = "send";
        if (r26 == 1) goto L51;
        if (r26 != 2) goto L50;
        Object r28 = "send";
    L52:
        r24[3] = TuplesKt.to("show_time", r28);
        Map<? extends String, ? extends String> r29 = MapsKt.mutableMapOf(r24);
        o.a(r29, r12, r16);
        mz0.n r30 = new mz0.n();
        Map<String, String> r32 = r30.a;
        Intrinsics.checkNotNullParameter(r32, "map");
        Intrinsics.checkNotNullParameter(r29, "map");
        r32.putAll(r29);
        mz0.m r33 = new mz0.m();
        LogCommon r110 = LogCommon.PAGE_SOURCE_LOG;
        r33.b(r110);
        LogCommon r111 = LogCommon.ROOM;
        r33.b(r111);
        ((ArrayList) r30.b).addAll(r33.a);
        cy0.e.a.getClass();
        cy0.j r34 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r112 = com.bytedance.android.scope.m.b(r34).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r112);
        ((mz0.i) ((f80.a) r112)).w3("livesdk_redpackage_show", r30.a, r30.b);
        int r35 = r25[r23.ordinal()];
        if (r35 != 1) goto L55;
        r27 = "enter";
    L61:
        if (Intrinsics.areEqual(r27, "enter") == false) goto L63;
        r29.put(Constants.Keys.duration, String.valueOf(r20));
    L63:
        mz0.n r36 = new mz0.n();
        Map<String, String> r37 = r36.a;
        Intrinsics.checkNotNullParameter(r37, "map");
        Intrinsics.checkNotNullParameter(r29, "map");
        r37.putAll(r29);
        mz0.m r38 = new mz0.m();
        r38.b(r110);
        r38.b(r111);
        ((ArrayList) r36.b).addAll(r38.a);
        Object r39 = com.bytedance.android.scope.m.b(r34).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r39);
        ((mz0.i) ((f80.a) r39)).w3("livesdk_lucky_box_item_enter_room_show", r36.a, r36.b);
        this.i = true;
        return;
    L55:
        if (r35 == 2) goto L61;
        throw new NoWhenBranchMatchedException();
    L50:
        throw new NoWhenBranchMatchedException();
    L51:
        r28 = "enter";
        goto L52
    L67:
        return;
    }

    public final void i(com.bytedance.android.live.profit.redpacket.e r12, List<? extends com.bytedance.android.livesdk.chatroom.model.n1.e> r13, RedPacketDialogShowFrom r14) {
        if (r12 != null) goto L17;
        Iterator r15 = ((Iterable) this.q.k.e.d).iterator();
    L5:
        if (r15.hasNext() == false) goto L9;
        Object r0 = r15.next();
        if ((!f.a(((RedPacket) r0).getState())) == false) goto L5;
    L10:
        RedPacket r3 = (RedPacket) r0;
        if (r3 == null) goto L18;
        this.u.f(getContext(), r3, getCountDownSec(), this.t.getRoom(), r13, r14, null, RedPacketIconModel$showRushDialog$2$1.INSTANCE);
        Unit r16 = Unit.INSTANCE;
        return;
    L18:
        return;
    L9:
        r0 = null;
        goto L10
    }

    public RedPacketIconModel(w0 r3, y0 r4, bv0.b r5, c01.a r6, yz0.k r7, RedPacketHybridService r8, r0 r9) {
        Intrinsics.checkNotNullParameter(r3, "redPacketScope");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        Intrinsics.checkNotNullParameter(r5, "redPacketDressService");
        Intrinsics.checkNotNullParameter(r6, "stiService");
        Intrinsics.checkNotNullParameter(r7, "roomDataService");
        Intrinsics.checkNotNullParameter(r8, "redPackerHybridService");
        Intrinsics.checkNotNullParameter(r9, "redPacketRepository");
        super(y0.a.c.a, RevStiElementType.RegularLuckyBox.getTypeId());
        this.p = r3;
        this.q = r4;
        this.r = r5;
        this.s = r6;
        this.t = r7;
        this.u = r8;
        this.v = r9;
        this.f = new CompositeDisposable();
        this.g = new CompositeDisposable();
        this.j = "";
        this.k = new PropertyOwner(0);
        this.m = "";
        this.n = "";
        this.o = "";
        new PropertyOwner(Boolean.FALSE);
    }
}

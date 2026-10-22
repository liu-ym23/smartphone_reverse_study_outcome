package com.bytedance.android.live.revlink.link.biz.audiencecomponent;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.common.player.utils.LiveSeiUtil;
import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import com.bytedance.android.live.revlink.impl.audience.SeiLoadPkSource;
import com.bytedance.android.live.revlink.impl.audience.h;
import com.bytedance.android.live.revlink.impl.multianchor.utils.h0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiAnchorLinkContext;
import com.bytedance.android.live.revlink.impl.pk.service.IPkAudienceLoadService;
import com.bytedance.android.live.revlink.impl.pk.utils.s;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.impl.utils.t;
import com.bytedance.android.live.revlink.link.biz.service.i;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.m;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.livesdk.model.RevSeiRegion;
import com.bytedance.android.livesdk.model.p0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.revenue.platform.api.core.rx.l;
import com.bytedance.revenue.platform.api.core.rx.p;
import f31.k;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiAudienceSeiComponent implements com.bytedance.android.live.revlink.link.biz.service.d {
    public final String a;
    public final CompositeDisposable b;
    public final h c;
    public final com.bytedance.android.live.revlink.impl.audience.f d;
    public final com.bytedance.android.live.revlink.impl.audience.a e;
    public boolean f;
    public final long g;
    public RevSeiFrame h;
    public boolean i;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b j;
    public final MultiAnchorLinkContext k;
    public final c l;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ MultiAudienceSeiComponent a;

        public a(MultiAudienceSeiComponent r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Unit r2 = (Unit) r1;
            Disposable r3 = this.a.l.b.b;
            if (r3 == null) goto L6;
            r3.dispose();
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.audiencecomponent.MultiAudienceSeiComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/live/revenue/common/player/vendor/link/RevSeiFrame;", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<RevSeiFrame, Unit> {
        public AnonymousClass1(MultiAudienceSeiComponent r8) {
            super(1, r8, MultiAudienceSeiComponent.class, "onSeiFrameChange", "onSeiFrameChange(Lcom/bytedance/android/live/revenue/common/player/vendor/link/RevSeiFrame;)V", 0);
        }

        public final void invoke(RevSeiFrame r38) {
            MultiAudienceSeiComponent r2 = (MultiAudienceSeiComponent) ((CallableReference) this).receiver;
            if (r38 != null) goto L5;
            r2.getClass();
            return;
        L5:
            h r3 = r2.c;
            String r4 = r38.C;
            boolean r5 = r2.f;
            r3.getClass();
            if (r4 != null) goto L8;
        L11:
            boolean r8 = true;
        L13:
            if (r8 == false) goto L16;
            String r12 = " sei=";
            CharSequence r7 = "TTLiveSDK_Windows";
            CharSequence r36 = "TTLiveSDK_IOS";
        L96:
            if (((String) r38.f.getValue()) == null) goto L99;
            i.F(r2).f();
            i.F(r2).e();
        L99:
            if (z41.d.c.B6() == true) goto L101;
        L180:
            r2.a(r38);
            r2.h = r38;
            if (r2.f == false) goto L188;
            com.bytedance.android.live.revlink.impl.settings.live.c r1 = com.bytedance.android.live.revlink.impl.settings.live.c.D;
            r1.getClass();
            if (((Boolean) com.bytedance.android.live.revlink.impl.settings.live.c.m.getValue(r1, com.bytedance.android.live.revlink.impl.settings.live.c.a[11])).booleanValue() == false) goto L188;
            l r6 = l.a;
            String r9 = r38.C;
            if (r9 != null) goto L187;
            r9 = "";
        L187:
            Observable r10 = Observable.just(r9).map(new d(r38)).filter(e.a);
            int r13 = p.a;
            r10.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(r2, r38), new g(r2));
            return;
        L188:
            String r0 = r38.C;
            if (StringsKt.contains$default(r0, "TTLiveSDK_Android", false, 2, null) == false) goto L191;
        L196:
            String r14 = com.bytedance.android.live.revlink.link.biz.service.e.a.a(r2);
            StringBuilder r15 = new StringBuilder("seiUpdated=");
            r15.append(r2.f);
            r15.append(" intercept sei unload, loadDuration=");
            i97.a r16 = i97.a.a;
            r15.append(System.currentTimeMillis() - r2.g);
            r15.append("ms, ");
            r15.append(r0);
            jy0.b.f(r14, r15.toString(), null, 4);
            return;
        L191:
            if (StringsKt.contains$default(r0, r36, false, 2, null) == true) goto L196;
            if (LiveSeiUtil.b(r0) == true) goto L196;
            if (StringsKt.contains$default(r0, r7, false, 2, null) == true) goto L196;
            return;
        L101:
            if (StringsKt.contains$default(r38.C, "app_data", false, 2, null) == false) goto L180;
            Integer r17 = r38.n();
            if (r17 != null) goto L106;
        L107:
            Intrinsics.checkNotNullParameter(r2, "$this$seiLoadMonitor");
            com.bytedance.android.live.revlink.impl.audience.g r18 = i.getContext(r2).Ee();
            Integer r19 = r38.n();
            if (r19 == null) goto L110;
            int r20 = r19.intValue();
        L111:
            String r22 = r38.C;
            long r110 = r2.g;
            r18.getClass();
            if (r20 == 6) goto L125;
            i97.a r111 = i97.a.a;
            long r112 = System.currentTimeMillis() - r110;
            jy0.b.c("ttlive_revlink_sei", "scene=7 seiVersion=" + r20 + " invalid loadedDuration=" + r112 + r12 + r22, null, 4);
            if (r112 <= 10000) goto L125;
            if ((System.currentTimeMillis() - r18.e) < 60000) goto L125;
            r18.e = System.currentTimeMillis();
            JSONObject r23 = new JSONObject();
            int r113 = y50.b.a;
            y50.b.a.c(r23, "loaded_duration", r112);
            y50.b.a.b(r23, "sei_version", r20);
            y50.b.a.d(r23, "sei_string", r22);
            com.bytedance.android.live.revlink.impl.audience.g.m(r18, "revlink_sei_version_invalid", r23, 7, r20, null, 48);
            com.bytedance.android.live.revlink.impl.global.c r24 = r18.d;
            if (r24 == null) goto L122;
            d31.f r25 = r24.y2();
        L123:
            if (r25 == null) goto L125;
            d31.f.f(r25, "revlink_sei_version_invalid", r20, null, 7, 0, null, null, null, 244);
            goto L125
        L122:
            r25 = null;
        L125:
            com.bytedance.android.live.revlink.impl.audience.f r26 = r2.d;
            String r27 = r38.C;
            JSONObject r28 = r38.d();
            r26.getClass();
            if (r27 != null) goto L128;
        L131:
            boolean r29 = true;
        L132:
            if (r29 == true) goto L179;
            if (r28 == null) goto L179;
            int r30 = r28.optInt("ver");
            if (r30 != 2) goto L138;
        L141:
            boolean r114 = true;
        L142:
            if (r114 == false) goto L179;
            JSONArray r32 = r28.optJSONArray("grids");
            if (r32 != null) goto L147;
        L150:
            jy0.b.d("ttlive_revlink_sei", "sei grids empty, cnt=" + r26.a);
            if (r26.c == true) goto L176;
            if (t.a(r26.b) <= 10000) goto L176;
            if (r26.a <= 3) goto L176;
            com.bytedance.android.live.revlink.impl.global.c r33 = r26.d;
            if (r33 == null) goto L159;
            com.bytedance.android.live.revlink.impl.audience.g r34 = r33.Ee();
        L160:
            if (r34 != null) goto L162;
        L174:
            r26.c = true;
            goto L176
        L162:
            if (r30 != 2) goto L165;
            int r115 = 1;
        L168:
            JSONObject r35 = new JSONObject();
            int r37 = y50.b.a;
            y50.b.a.d(r35, "sei_string", r27);
            com.bytedance.android.live.revlink.impl.audience.g.m(r34, "sei_grids_empty", r35, r115, 0, null, 56);
            com.bytedance.android.live.revlink.impl.global.c r39 = r34.d;
            if (r39 == null) goto L171;
            d31.f r40 = r39.y2();
        L172:
            if (r40 == null) goto L174;
            d31.f.f(r40, "sei_grids_empty", 0, null, r115, 0, null, null, null, 246);
            goto L174
        L171:
            r40 = null;
            goto L172
        L165:
            if (r30 != 6) goto L167;
            r115 = 7;
            goto L168
        L167:
            r115 = 0;
            goto L168
        L159:
            r34 = null;
        L176:
            if (r26.a != 0) goto L178;
            i97.a r42 = i97.a.a;
            r26.b = System.currentTimeMillis();
        L178:
            r26.a++;
            goto L179
        L147:
            if (r32.length() == 0) goto L150;
            r26.a = 0;
            r26.b = 0;
            goto L179
        L138:
            if (r30 == 6) goto L141;
            r114 = false;
        L179:
            r2.a(r38);
            r2.h = r38;
            return;
        L128:
            if (r27.length() == 0) goto L131;
            r29 = false;
            goto L132
        L110:
            r20 = -1;
            goto L111
        L106:
            if (r17.intValue() == 6) goto L125;
        L16:
            if (r5 == false) goto L18;
        L59:
            r12 = " sei=";
        L60:
            r7 = "TTLiveSDK_Windows";
            r36 = "TTLiveSDK_IOS";
        L58:
            boolean r43 = false;
        L62:
            if (r4 != null) goto L64;
        L66:
            boolean r44 = false;
        L67:
            if (r44 == false) goto L96;
            if (StringsKt.contains$default(r4, "\\\"ver\\\":2,", r43, 2, null) == false) goto L96;
            StringBuilder r45 = new StringBuilder("multi link receive pk sei loadedTime=");
            i97.a r46 = i97.a.a;
            r45.append(System.currentTimeMillis() - r3.d);
            r45.append(' ');
            r45.append(r4);
            jy0.b.d("ttlive_pk_sei_unload", r45.toString());
            if ((System.currentTimeMillis() - r3.d) < r3.b.h9()) goto L96;
            r3.c.getClass();
            JSONObject r47 = h0.b(r4);
            if (r47 != null) goto L77;
        L76:
            p0 r48 = null;
        L81:
            if (r48 == null) goto L96;
            if (r48.getVersion() != 2) goto L96;
            jy0.b.d("ttlive_pk_sei_unload", "try unload multi link, launch pk");
            if ((System.currentTimeMillis() - r3.e) < r3.b.A3()) goto L96;
            if (r3.a.a4() == false) goto L96;
            r3.e = System.currentTimeMillis();
            com.bytedance.android.live.revlink.impl.global.c r49 = r3.g;
            if (r49 == null) goto L92;
            IPkAudienceLoadService r50 = r49.Ik();
        L93:
            if (r50 == null) goto L96;
            SeiLoadPkSource r52 = SeiLoadPkSource.NORMAL_SEI;
            r50.a();
            goto L96
        L92:
            r50 = null;
            goto L93
        L77:
            r3.c.getClass();
            JSONObject r53 = h0.a(r47);
            if (r53 == null) goto L76;
            int r54 = s.c;
            r48 = s.a.a(r53, r4);
            goto L81
        L64:
            if (StringsKt.contains$default(r4, "app_data", r43, 2, null) != true) goto L66;
            r44 = true;
            goto L67
        L18:
            if (StringsKt.contains$default(r4, "TTLiveSDK_Android", false, 2, null) == false) goto L20;
        L29:
            boolean r55 = true;
        L30:
            if (r55 == false) goto L59;
            jy0.b.d("ttlive_pk_sei_unload", "scene=7 commonLiveSeiCount=" + r3.f + " sei=" + r4);
            int r56 = r3.f + 1;
            r3.f = r56;
            if (r56 <= r3.b.b2()) goto L59;
            i97.a r57 = i97.a.a;
            r12 = " sei=";
            if ((System.currentTimeMillis() - r3.d) <= r3.b.B5()) goto L60;
            com.bytedance.android.live.revlink.impl.global.c r116 = r3.g;
            if (r116 == null) goto L38;
            com.bytedance.android.live.revlink.impl.audience.g r117 = r116.Ee();
        L39:
            if (r117 == null) goto L49;
            int r118 = r3.f;
            long r58 = System.currentTimeMillis() - r3.d;
            Intrinsics.checkNotNullParameter(r4, "rawSei");
            r7 = "TTLiveSDK_Windows";
            r36 = "TTLiveSDK_IOS";
            if ((System.currentTimeMillis() - r117.f) < 60000) goto L51;
            r117.f = System.currentTimeMillis();
            JSONObject r59 = new JSONObject();
            y50.b.a.b(r59, "sei_count", r118);
            y50.b.a.c(r59, "loaded_time", r58);
            y50.b.a.d(r59, "raw_sei", r4);
            com.bytedance.android.live.revlink.impl.audience.g.m(r117, "sei_backup_unload", r59, 7, 0, null, 56);
            com.bytedance.android.live.revlink.impl.global.c r60 = r117.d;
            if (r60 == null) goto L46;
            d31.f r210 = r60.y2();
        L47:
            if (r210 == null) goto L51;
            d31.f.f(r210, "sei_backup_unload", 0, null, 7, 0, null, null, null, 246);
            goto L51
        L46:
            r210 = null;
        L51:
            if (r3.a.A4() == false) goto L58;
            com.bytedance.android.live.revlink.impl.global.c r62 = r3.g;
            if (r62 == null) goto L55;
            com.bytedance.android.live.revlink.impl.service.internal.a r63 = r62.Do();
        L56:
            if (r63 == null) goto L58;
            r43 = false;
            com.bytedance.android.live.revlink.impl.service.internal.b.a.a(r63, 64, false, 6);
            goto L62
        L55:
            r63 = null;
            goto L56
        L49:
            r7 = "TTLiveSDK_Windows";
            r36 = "TTLiveSDK_IOS";
            goto L51
        L38:
            r117 = null;
            goto L39
        L20:
            if (StringsKt.contains$default(r4, "TTLiveSDK_IOS", false, 2, null) == true) goto L29;
            if (StringsKt.contains$default(r4, "TTLiveSDK_Windows", false, 2, null) == true) goto L29;
            if (StringsKt.contains$default(r4, "\\\"ver\\\":15", false, 2, null) == true) goto L29;
            if (LiveSeiUtil.b(r4) == true) goto L29;
            r55 = false;
            goto L30
        L8:
            if (r4.length() == 0) goto L11;
            r8 = false;
            goto L13
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((RevSeiFrame) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.audiencecomponent.MultiAudienceSeiComponent$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lf31/f;", "p1", "", "invoke", "(Lf31/f;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<f31.f, Unit> {
        public AnonymousClass2(MultiAudienceSeiComponent r8) {
            super(1, r8, MultiAudienceSeiComponent.class, "onLayoutStatusChange", "onLayoutStatusChange(Lcom/bytedance/android/live/revlink/impl/multianchor/model/LayoutStatus;)V", 0);
        }

        public final void invoke(f31.f r2) {
            MultiAudienceSeiComponent r0 = (MultiAudienceSeiComponent) ((CallableReference) this).receiver;
            if (r2 != null) goto L5;
            r0.getClass();
            return;
        L5:
            r0.b(r2);
            r0.e.a();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((f31.f) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.audiencecomponent.MultiAudienceSeiComponent$attach$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/bytedance/android/livesdk/link/model/p;", "p1", "", "p2", "", "invoke", "(Ljava/util/List;I)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function2<List<? extends com.bytedance.android.livesdk.link.model.p>, Integer, Unit> {
        public AnonymousClass3(MultiAudienceSeiComponent r8) {
            super(2, r8, MultiAudienceSeiComponent.class, "onOnlineListChange", "onOnlineListChange(Ljava/util/List;I)V", 0);
        }

        public final void invoke(List<? extends com.bytedance.android.livesdk.link.model.p> r7, int r8) {
            Intrinsics.checkNotNullParameter(r7, "p1");
            MultiAudienceSeiComponent r9 = (MultiAudienceSeiComponent) ((CallableReference) this).receiver;
            f31.f r0 = (f31.f) r9.getContext().hh().getValue();
            if (r0 == null) goto L23;
            List<k> r1 = r0.a;
            if (r1 == null) goto L18;
            Iterator<T> r2 = r1.iterator();
        L9:
            if (r2.hasNext() == false) goto L18;
            k r3 = (k) r2.next();
            com.bytedance.android.livesdk.link.model.p r4 = i.t(r9).getGuestInfo(null, r3.a);
            if (r4 == null) goto L16;
            IBaseUser r5 = r4.getUser();
            if (r5 == null) goto L16;
            String r6 = iz.a.a(r5);
            if (r6 == null) goto L16;
        L17:
            Intrinsics.checkNotNullParameter(r6, "<set-?>");
            r3.b = r6;
        L16:
            r6 = "";
        L18:
            r9.b(r0);
            r7.size();
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((List) r1, ((Number) r2).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.audiencecomponent.MultiAudienceSeiComponent$attach$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<String, Unit> {
        public AnonymousClass5(MultiAudienceSeiComponent r8) {
            super(1, r8, MultiAudienceSeiComponent.class, "notifySeiForMonitor", "notifySeiForMonitor(Ljava/lang/String;)V", 0);
        }

        public final void invoke(String r17) {
            com.bytedance.android.live.revlink.impl.audience.a r1 = ((MultiAudienceSeiComponent) ((CallableReference) this).receiver).e;
            if (r1.c == false) goto L77;
            r1.f++;
            String r2 = "";
            if (r17 != null) goto L8;
            String r4 = "";
        L9:
            v r6 = null;
            jy0.b.c("RevenueAudienceSeiMonitor", r4, null, 4);
            int r5 = com.bytedance.android.live.revlink.impl.audience.e.a;
            if (r17 != null) goto L12;
            String r7 = "";
        L13:
            Intrinsics.checkNotNullParameter(r7, "str");
            if (StringsKt.contains$default(r7, "TTLiveSDK_", false, 2, null) == false) goto L16;
            Pair r8 = new Pair(1, null);
        L47:
            int r3 = ((Number) r8.component1()).intValue();
            String r9 = (String) r8.component2();
            if (r9 == null) goto L54;
            if (r1.d.size() <= com.bytedance.android.live.revlink.impl.audience.a.b().O4()) goto L52;
            r1.d.removeFirstOrNull();
        L52:
            ArrayDeque<Pair<Long, String>> r10 = r1.d;
            i97.a r12 = i97.a.a;
            r10.addLast(new Pair(Long.valueOf(System.currentTimeMillis()), r9));
        L54:
            if (r3 == 3) goto L56;
            return;
        L56:
            if (r1.h == false) goto L58;
            boolean r13 = com.bytedance.android.live.revlink.impl.audience.a.b().q8();
        L59:
            if (r13 == false) goto L75;
            com.bytedance.android.live.revlink.impl.global.c r14 = r1.g;
            if (r14 == null) goto L63;
            r6 = r14.getMultiLinkMonitor();
        L63:
            if (r6 == null) goto L76;
            JSONObject r15 = new JSONObject();
            int r16 = y50.b.a;
            y50.b.a.b(r15, "error_code", r3);
            if (r9 == null) goto L68;
            r2 = r9;
        L68:
            y50.b.a.d(r15, "sei", r2);
            r6.g(r15);
            r6.I("revenue_audience_illegal_sei", r15, false);
            return;
        L76:
            return;
        L75:
            return;
        L58:
            r13 = com.bytedance.android.live.revlink.impl.audience.a.b().Z8();
            goto L59
        L16:
            int r18 = StringsKt.indexOf$default(r7, "app_data", 0, false, 6, null);
            if (r18 != (-1)) goto L19;
            r8 = new Pair(2, null);
            goto L47
        L19:
            int r19 = r7.length();
        L21:
            if (r18 >= r19) goto L25;
            if (r7.charAt(r18) == '{') goto L25;
            r18 = r18 + 1;
        L25:
            if (r18 < r19) goto L27;
        L29:
            int r110 = -1;
        L30:
            if (r110 != (-1)) goto L33;
            Pair r20 = new Pair(3, r7);
        L32:
            r8 = r20;
            goto L47
        L33:
            int r22 = 0;
        L34:
            if (r18 >= r19) goto L44;
            if (r7.charAt(r18) != '{') goto L39;
            r22 = r22 + 1;
        L41:
            if (r22 == 0) goto L44;
            r18 = r18 + 1;
            goto L34
        L39:
            if (r7.charAt(r18) != '}') goto L41;
            r22 = r22 - 1;
        L44:
            if (r22 != 0) goto L46;
            r8 = new Pair(4, r7.substring(r110, r18 + 1));
            goto L47
        L46:
            r20 = new Pair(3, r7);
            goto L32
        L27:
            if (r7.charAt(r18) != '{') goto L29;
            r110 = r18;
            goto L30
        L12:
            r7 = r17;
            goto L13
        L8:
            r4 = r17;
            goto L9
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((String) r1);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        this.i = true;
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.i(getContext().lb(), new AnonymousClass1(this)), this.b);
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.i(getContext().hh(), new AnonymousClass2(this)), this.b);
        com.bytedance.revenue.platform.api.core.rx.f.a(i.t(this).m(new AnonymousClass3(this)), this.b);
        com.bytedance.revenue.platform.api.core.rx.f.a(getContext().ci().subscribe(new a(this)), this.b);
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.d(getContext().ul(), new AnonymousClass5(this)), this.b);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.i = false;
        this.b.clear();
        this.e.a();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAudienceComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.d, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.a;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.d, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b getContext() {
        return this.j;
    }

    public final void a(RevSeiFrame r18) {
        Long r1 = r18.e();
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.longValue() > (-1)) goto L7;
        return;
    L7:
        Integer r2 = r18.n();
        if (r2 != null) goto L11;
    L12:
        if (r2 != null) goto L15;
        return;
    L15:
        if (r2.intValue() == 2) goto L17;
        return;
    L17:
        boolean r3 = true;
        this.f = true;
        i.F(this).f();
        p0 r4 = r18.b();
        if (r4 == null) goto L40;
        List r5 = r4.e();
        if (r5 == null) goto L40;
        Iterator r6 = r5.iterator();
    L23:
        if (r6.hasNext() == false) goto L40;
        RevSeiRegion r7 = (RevSeiRegion) r6.next();
        if (Intrinsics.areEqual(r7.getInteractId(), i.e0(this)) == true) goto L23;
        String r8 = r7.getInteractId();
        if (r8 != null) goto L31;
        r8 = "";
    L31:
        if (StringsKt.startsWith$default(r8, "1_", false, 2, null) == true) goto L35;
        z41.g r9 = z41.g.o;
        r9.getClass();
        if (((Boolean) z41.g.m.getValue(r9, z41.g.a[11])).booleanValue() == true) goto L23;
    L35:
        m r10 = getContext().im();
        if (r7.getStatus() != 0) goto L38;
        boolean r12 = true;
    L39:
        r10.a(r8, r12);
        goto L23
    L38:
        r12 = false;
    L40:
        p0 r13 = r18.b();
        if (r13 == null) goto L56;
        List r14 = r13.e();
        if (r14 == null) goto L56;
        Iterator r15 = r14.iterator();
    L46:
        if (r15.hasNext() == false) goto L50;
        Object r16 = r15.next();
        if ((!Intrinsics.areEqual(((RevSeiRegion) r16).getInteractId(), i.e0(this))) == false) goto L46;
    L51:
        RevSeiRegion r17 = (RevSeiRegion) r16;
        if (r17 == null) goto L56;
        com.bytedance.android.live.revlink.impl.lynxcontainer.a r19 = i.U(this);
        if (r19 == null) goto L56;
        r19.b("double_mute_status", String.valueOf(r17.getMuteAudio()));
        goto L56
    L50:
        r16 = null;
    L56:
        this.f = true;
        p0 r20 = r18.b();
        if (r20 == null) goto L210;
        List r22 = r20.e();
        if (r22 == null) goto L211;
        List r23 = r22;
        ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        Iterator r25 = r23.iterator();
    L62:
        if (r25.hasNext() == false) goto L68;
        RevSeiRegion r26 = (RevSeiRegion) r25.next();
        String r27 = r26.getInteractId();
        if (r27 != null) goto L66;
        String r110 = "";
    L67:
        Intrinsics.checkNotNullParameter(r26, "$this$toLinkRegion");
        Intrinsics.checkNotNullParameter(r110, "key");
        r24.add(new pc0.c(r110, (float) r26.getX(), (float) r26.getY(), (float) r26.getWidth(), (float) r26.getHeight()));
        r25 = r25;
        goto L62
    L66:
        r110 = r27;
        goto L67
    L68:
        com.bytedance.android.live.revlink.impl.pk.utils.h r28 = i.q(this);
        p0 r29 = r18.b();
        r28.getClass();
        Intrinsics.checkNotNullParameter(r24, "linkRegions");
        com.bytedance.android.live.revlink.impl.global.c r30 = r28.c;
        if (r30 == null) goto L71;
        RevLinkWindowRegionContext r32 = r30.P8();
    L72:
        if (r32 == null) goto L181;
        com.bytedance.android.live.revlink.impl.region.c r33 = r32.getRevStreamRegionUpdater();
        if (r33 == null) goto L181;
        Intrinsics.checkNotNullParameter(r24, "linkRegions");
        if (r29 == null) goto L78;
        List r34 = r29.e();
    L79:
        p0 r35 = r33.a;
        if (r35 == null) goto L82;
        List r36 = r35.e();
    L83:
        if (r34 != null) goto L86;
        if (r36 != null) goto L86;
    L158:
        if (r3 == true) goto L181;
        com.bytedance.android.live.revlink.impl.global.c r37 = r33.d;
        if (r37 == null) goto L162;
        RevLinkWindowRegionContext r38 = r37.P8();
    L163:
        if (r38 == null) goto L165;
        r38.clearStreamRegion();
    L165:
        Iterator r39 = r24.iterator();
    L167:
        if (r39.hasNext() == false) goto L174;
        pc0.c r40 = (pc0.c) r39.next();
        com.bytedance.android.live.revlink.impl.global.c r42 = r33.d;
        if (r42 == null) goto L171;
        RevLinkWindowRegionContext r43 = r42.P8();
    L172:
        if (r43 == null) goto L167;
        r43.updateStreamRegion(r40.a, r40);
        goto L167
    L171:
        r43 = null;
        goto L172
    L174:
        com.bytedance.android.live.revlink.impl.global.c r44 = r33.d;
        if (r44 == null) goto L177;
        RevLinkWindowRegionContext r45 = r44.P8();
    L178:
        if (r45 == null) goto L180;
        r45.notifyStreamRegionUpdate();
    L180:
        r33.a = r29;
        goto L181
    L177:
        r45 = null;
        goto L178
    L162:
        r38 = null;
    L86:
        if (r34 == null) goto L88;
        Integer r46 = Integer.valueOf(r34.size());
    L89:
        if (r36 == null) goto L91;
        Integer r111 = Integer.valueOf(r36.size());
    L93:
        if ((!Intrinsics.areEqual(r46, r111)) == true) goto L156;
        if (r34 == null) goto L158;
        if (r36 == null) goto L158;
        int r47 = r34.size();
        int r112 = 0;
    L98:
        if (r112 >= r47) goto L158;
        RevSeiRegion r113 = (RevSeiRegion) ListProtector.get(r34, r112);
        RevSeiRegion r114 = (RevSeiRegion) ListProtector.get(r36, r112);
        if (r113 != null) goto L103;
        if (r114 != null) goto L103;
    L153:
        boolean r115 = true;
    L155:
        if (r115 == false) goto L156;
        r112 = r112 + 1;
    L103:
        if (Intrinsics.areEqual(r113, r114) == true) goto L153;
        if (r113 == null) goto L107;
        Double r116 = Double.valueOf(r113.getX());
    L108:
        if (r114 == null) goto L110;
        Double r117 = Double.valueOf(r114.getX());
    L112:
        if (Intrinsics.areEqual(r116, r117) == false) goto L154;
        if (r113 == null) goto L115;
        Double r118 = Double.valueOf(r113.getY());
    L116:
        if (r114 == null) goto L118;
        Double r119 = Double.valueOf(r114.getY());
    L120:
        if (Intrinsics.areEqual(r118, r119) == false) goto L154;
        if (r113 == null) goto L123;
        String r120 = r113.getUidStr();
    L124:
        if (r114 == null) goto L126;
        String r121 = r114.getUidStr();
    L128:
        if (Intrinsics.areEqual(r120, r121) == false) goto L154;
        if (r113 == null) goto L131;
        Long r122 = Long.valueOf(r113.getUid());
    L132:
        if (r114 == null) goto L134;
        Long r123 = Long.valueOf(r114.getUid());
    L136:
        if (Intrinsics.areEqual(r122, r123) == false) goto L154;
        if (r113 == null) goto L139;
        Double r124 = Double.valueOf(r113.getWidth());
    L140:
        if (r114 == null) goto L142;
        Double r125 = Double.valueOf(r114.getWidth());
    L144:
        if (Intrinsics.areEqual(r124, r125) == false) goto L154;
        if (r113 == null) goto L147;
        Double r126 = Double.valueOf(r113.getHeight());
    L148:
        if (r114 == null) goto L150;
        Double r127 = Double.valueOf(r114.getHeight());
    L152:
        if (Intrinsics.areEqual(r126, r127) == false) goto L154;
    L150:
        r127 = null;
        goto L152
    L147:
        r126 = null;
        goto L148
    L142:
        r125 = null;
        goto L144
    L139:
        r124 = null;
        goto L140
    L134:
        r123 = null;
        goto L136
    L131:
        r122 = null;
        goto L132
    L126:
        r121 = null;
        goto L128
    L123:
        r120 = null;
        goto L124
    L118:
        r119 = null;
        goto L120
    L115:
        r118 = null;
    L154:
        r115 = false;
        goto L155
    L110:
        r117 = null;
        goto L112
    L107:
        r116 = null;
    L156:
        r3 = false;
        goto L158
    L91:
        r111 = null;
        goto L93
    L88:
        r46 = null;
        goto L89
    L82:
        r36 = null;
        goto L83
    L78:
        r34 = null;
    L181:
        MultiAudienceSeiComponent$logUILayoutChange$1 r48 = MultiAudienceSeiComponent$logUILayoutChange$1.INSTANCE;
        Integer r49 = r18.m();
        if (r49 == null) goto L184;
        int r50 = r49.intValue();
    L185:
        MultiAudienceSeiComponent$logUILayoutChange$1.invoke$default(r48, r50, false, 2, null);
        i.F(this).e();
        return;
    L184:
        r50 = 0;
        goto L185
    L71:
        r32 = null;
        goto L72
    L211:
        return;
    L210:
        return;
    L11:
        if (r2.intValue() == 6) goto L17;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.revlink.impl.utils.e0] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayList] */
    public final void b(f31.f r5) {
        Intrinsics.checkNotNullParameter(this, "$this$windowDiffCheckUtil");
        ?? r0 = i.getContext(this).w6();
        if (r5 == null) goto L10;
        List<k> r6 = r5.a;
        if (r6 == null) goto L10;
        List<k> r7 = r6;
        ?? r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L11;
        r1.add(new b((k) r8.next()));
    L11:
        r0.a(r1);
        return;
    L10:
        r1 = CollectionsKt.emptyList();
        goto L11
    }

    public MultiAudienceSeiComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b r5, MultiAnchorLinkContext r6, c r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "linkContext");
        Intrinsics.checkNotNullParameter(r7, "bizDataContext");
        this.j = r5;
        this.k = r6;
        this.l = r7;
        this.a = "MultiAudienceSeiComponent";
        this.b = new CompositeDisposable();
        this.c = new h(getContext());
        this.d = new com.bytedance.android.live.revlink.impl.audience.f(getContext());
        com.bytedance.android.live.revlink.impl.audience.a r8 = new com.bytedance.android.live.revlink.impl.audience.a(getContext());
        com.bytedance.android.live.revlink.impl.control.launchcontext.b r9 = i.E(this);
        if (r9 == null) goto L5;
        com.bytedance.android.live.revlink.impl.audience.c r10 = r9.b;
    L7:
        if (Intrinsics.areEqual(r10, com.bytedance.android.live.revlink.impl.audience.c.b.b) == false) goto L10;
        int r12 = 1;
    L16:
        r8.c = true;
        long r0 = com.bytedance.android.live.revlink.impl.audience.a.b().a1();
        boolean r13 = com.bytedance.android.live.revlink.impl.audience.a.b().H3();
        l r2 = l.a;
        int r3 = p.a;
        Scheduler r4 = Schedulers.computation();
        r8.a = Observable.timer(r0, TimeUnit.MILLISECONDS, r4).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.revlink.impl.audience.b(r8, r13));
        i97.a r14 = i97.a.a;
        r8.b = System.currentTimeMillis();
        r8.e = r12 | r8.e;
        Unit r15 = Unit.INSTANCE;
        this.e = r8;
        this.g = System.currentTimeMillis();
        return;
    L10:
        if (Intrinsics.areEqual(r10, com.bytedance.android.live.revlink.impl.audience.c.a.b) == false) goto L13;
        r12 = 2;
        goto L16
    L13:
        if (Intrinsics.areEqual(r10, com.bytedance.android.live.revlink.impl.audience.c.C0119c.b) == false) goto L15;
        r12 = 3;
        goto L16
    L15:
        r12 = 0;
        goto L16
    L5:
        r10 = null;
        goto L7
    }
}

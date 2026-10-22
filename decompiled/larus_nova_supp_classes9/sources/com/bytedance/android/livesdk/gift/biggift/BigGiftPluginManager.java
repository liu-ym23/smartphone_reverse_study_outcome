package com.bytedance.android.livesdk.gift.biggift;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.gift.biggift.view.BigGiftComboDialog;
import com.bytedance.android.livesdk.gift.biggift.viewModel.BigGiftViewModel;
import com.bytedance.android.livesdk.gift.configmodel.GiftAfterSendConfig;
import com.bytedance.android.livesdk.gift.model.ComboHintInfo;
import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.k3;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.model.p;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.platform.business.GiftPluginType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftSearchDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.j0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectedStatus;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetDownloadPriority;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.effect.delete.ResourceRecordService;
import com.bytedance.android.livesdk.gift.platform.business.i;
import com.bytedance.android.livesdk.gift.platform.business.l;
import com.bytedance.android.livesdk.gift.platform.business.sendGift.GiftTransaction;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.e0;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.model.GiftTransactionReqCount;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftStrategy;
import com.bytedance.android.livesdk.gift.platform.core.model.SeriesSendType;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import com.bytedance.android.livesdk.gift.platform.core.model.k;
import com.bytedance.android.livesdk.gift.platform.core.model.n;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.d0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.m0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.q2;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.r2;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.w0;
import com.bytedance.android.livesdk.gift.platform.core.utils.a0;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.init.I18nInitTask;
import com.bytedance.android.scope.o;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import i12.m;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class BigGiftPluginManager extends l implements o {
    public BigGiftComboDialog e;
    public Disposable f;
    public a g;
    public final CompositeDisposable h;
    public final GiftPluginType i;
    public final Lazy j;
    public final BigGiftViewModel k;
    public final u0 l;
    public final q2 m;
    public final e1 n;
    public final GiftExtraRepo o;

    public static final class a {
        public final long a;
        public final long b;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof a) == false) goto L10;
            a r7 = (a) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (this.b == r7.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.b;
            return r1 + ((int) (r3 ^ (r3 >>> 32)));
        }

        public final String toString() {
            return "LastDownloadInfo(giftId=" + this.a + ", downloadTime=" + this.b + ")";
        }

        public a(long r1, long r3) {
            this.a = r1;
            this.b = r3;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ BigGiftPluginManager a;
        public final /* synthetic */ h1 b;
        public final /* synthetic */ Integer c;

        public b(BigGiftPluginManager r1, h1 r2, Integer r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r3) {
            Unit r4 = (Unit) r3;
            this.a.L(this.b, this.c);
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ BigGiftPluginManager a;
        public final /* synthetic */ AbsPanel b;
        public final /* synthetic */ ArrayList c;
        public final /* synthetic */ IBaseUser d;
        public final /* synthetic */ int e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ List g;
        public final /* synthetic */ long h;
        public final /* synthetic */ int i;
        public final /* synthetic */ String j;
        public final /* synthetic */ boolean k;
        public final /* synthetic */ n l;
        public final /* synthetic */ k m;
        public final /* synthetic */ k n;
        public final /* synthetic */ com.bytedance.android.livesdk.gift.model.n o;
        public final /* synthetic */ l1 p;
        public final /* synthetic */ String q;
        public final /* synthetic */ String r;
        public final /* synthetic */ String s;
        public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.core.model.a t;

        public c(BigGiftPluginManager r4, AbsPanel r5, ArrayList r6, IBaseUser r7, int r8, boolean r9, List r10, long r11, int r13, String r14, boolean r15, n r16, k r17, k r18, com.bytedance.android.livesdk.gift.model.n r19, l1 r20, String r21, String r23, String r24, com.bytedance.android.livesdk.gift.platform.core.model.a r25) {
            this.a = r4;
            this.b = r5;
            this.c = r6;
            this.d = r7;
            this.e = r8;
            this.f = r9;
            this.g = r10;
            this.h = r11;
            this.i = r13;
            this.j = r14;
            this.k = r15;
            this.l = r16;
            this.m = r17;
            this.n = r18;
            this.o = r19;
            this.p = r20;
            this.q = r21;
            this.r = r23;
            this.s = r24;
            this.t = r25;
        }

        public final void a() {
            if (u.r() == false) goto L5;
            long r2 = this.b.c();
            AbsPanel r1 = this.b;
            h.G(r2, r1.h instanceof h1, true, r1.f, r1.c, this.c, this.d);
        L5:
            i12.d r3 = m.e2.a();
            List r4 = null;
            if (r3 == null) goto L8;
            Object r5 = com.bytedance.android.scope.m.e.d(r3, GiftSearchDataStore.class);
        L9:
            GiftSearchDataStore r6 = (GiftSearchDataStore) r5;
            BigGiftPluginManager r7 = this.a;
            long r8 = this.b.c();
            T r9 = this.b.h;
            boolean r10 = r9 instanceof l2;
            if (r10 == false) goto L15;
            if (r9 == 0) goto L14;
            long r11 = ((l2) r9).isAwemeFreeGift();
        L16:
            int r14 = this.e;
            IBaseUser r13 = this.d;
            ArrayList r15 = this.c;
            this.b.getClass();
            boolean r16 = this.f;
            if (r16 == false) goto L19;
            r4 = this.g;
        L19:
            List r20 = r4;
            long r17 = this.h;
            int r18 = this.i;
            String r19 = this.j;
            if (this.k == false) goto L22;
            SeriesSendType r21 = SeriesSendType.SINGLE;
        L23:
            SeriesSendType r31 = r21;
            n r23 = this.l;
            k r110 = this.m;
            k r111 = this.n;
            com.bytedance.android.livesdk.gift.model.n r112 = this.o;
            int r43 = BigGiftPluginManager.I(this.a, this.b.c(), this.p, this.o);
            String r24 = this.q;
            String r113 = this.r;
            String r114 = this.s;
            if (r6 == null) goto L26;
            boolean r47 = r6.s();
        L28:
            if (r6 == null) goto L33;
            String r115 = r6.q();
            if (r115 == null) goto L33;
            String r48 = r115;
        L34:
            if (r6 == null) goto L39;
            String r25 = r6.j;
            if (r25 == null) goto L39;
            String r49 = r25;
        L40:
            BigGiftPluginManager.N(r7, r8, r10, r11, r14, 0, null, null, null, com.bytedance.android.livesdk.gift.model.e.FETCH_FROM_GIFT_PANEL, r13, null, r15, false, r16, r20, r17, 0, null, null, null, false, r18, r19, null, r31, null, null, false, null, r23, 0, false, false, r110, r111, r112, r43, r24, r113, r114, r47, r48, r49, null, this.t, 0, null, null, -560003856, 59392);
            return;
        L39:
            r49 = BuildConfig.FLAVOR;
        L33:
            r48 = BuildConfig.FLAVOR;
            goto L34
        L26:
            r47 = false;
            goto L28
        L22:
            r21 = SeriesSendType.NONE;
            goto L23
        L14:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IProp");
        L15:
            r11 = 0;
            goto L16
        L8:
            r5 = null;
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ BigGiftPluginManager a;
        public final /* synthetic */ AbsPanel b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ IBaseUser e;
        public final /* synthetic */ ArrayList f;
        public final /* synthetic */ boolean g;
        public final /* synthetic */ List h;
        public final /* synthetic */ long i;
        public final /* synthetic */ String j;
        public final /* synthetic */ n k;
        public final /* synthetic */ Ref.IntRef l;
        public final /* synthetic */ k m;
        public final /* synthetic */ int n;
        public final /* synthetic */ k o;
        public final /* synthetic */ com.bytedance.android.livesdk.gift.model.n p;
        public final /* synthetic */ l1 q;
        public final /* synthetic */ String r;
        public final /* synthetic */ String s;
        public final /* synthetic */ String t;
        public final /* synthetic */ GiftSearchDataStore u;
        public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.core.model.a v;

        public d(BigGiftPluginManager r4, AbsPanel r5, int r6, int r7, IBaseUser r8, ArrayList r9, boolean r10, List r11, long r13, String r14, n r15, Ref.IntRef r16, k r17, int r18, k r19, com.bytedance.android.livesdk.gift.model.n r20, l1 r21, String r23, String r24, String r25, GiftSearchDataStore r26, com.bytedance.android.livesdk.gift.platform.core.model.a r27) {
            this.a = r4;
            this.b = r5;
            this.c = r6;
            this.d = r7;
            this.e = r8;
            this.f = r9;
            this.g = r10;
            this.h = r11;
            this.i = r13;
            this.j = r14;
            this.k = r15;
            this.l = r16;
            this.m = r17;
            this.n = r18;
            this.o = r19;
            this.p = r20;
            this.q = r21;
            this.r = r23;
            this.s = r24;
            this.t = r25;
            this.u = r26;
            this.v = r27;
        }

        public final void a() {
            BigGiftPluginManager r1 = this.a;
            long r2 = this.b.c();
            T r4 = this.b.h;
            boolean r5 = r4 instanceof l2;
            if (r5 == false) goto L8;
            if (r4 == 0) goto L7;
            long r6 = ((l2) r4).isAwemeFreeGift();
        L9:
            int r8 = this.c;
            int r13 = this.d;
            IBaseUser r15 = this.e;
            ArrayList r7 = this.f;
            this.b.getClass();
            boolean r14 = this.g;
            if (r14 == false) goto L12;
            List r9 = this.h;
        L13:
            List r18 = r9;
            long r10 = this.i;
            String r11 = this.j;
            n r16 = this.k;
            int r17 = this.l.element;
            k r19 = this.m;
            int r110 = this.n;
            k r111 = this.o;
            com.bytedance.android.livesdk.gift.model.n r112 = this.p;
            int r43 = BigGiftPluginManager.I(this.a, this.b.c(), this.q, this.p);
            String r20 = this.r;
            String r113 = this.s;
            String r114 = this.t;
            GiftSearchDataStore r21 = this.u;
            if (r21 == null) goto L16;
            boolean r45 = r21.s();
        L17:
            GiftSearchDataStore r23 = this.u;
            if (r23 == null) goto L23;
            String r24 = r23.q();
            if (r24 == null) goto L23;
            String r46 = r24;
        L24:
            GiftSearchDataStore r25 = this.u;
            if (r25 == null) goto L30;
            String r26 = r25.j;
            if (r26 == null) goto L30;
            String r47 = r26;
        L31:
            long r27 = r6;
            BigGiftPluginManager.N(r1, r2, r5, r27, r8, r13, null, null, null, com.bytedance.android.livesdk.gift.model.e.FETCH_FROM_GIFT_PANEL, r15, null, r7, false, r14, r18, r10, 0, null, null, null, false, r110, r11, null, null, null, null, false, null, r16, r17, false, true, r19, r111, r112, r43, r20, r113, r114, r45, r46, r47, null, this.v, this.d, null, null, -1616968480, 51200);
            return;
        L30:
            r47 = BuildConfig.FLAVOR;
        L23:
            r46 = BuildConfig.FLAVOR;
            goto L24
        L16:
            r45 = false;
            goto L17
        L12:
            r9 = null;
            goto L13
        L7:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IProp");
        L8:
            r6 = 0;
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ BigGiftPluginManager a;

        public e(BigGiftPluginManager r1) {
            this.a = r1;
        }

        public final void accept(Object r63) {
            e0 r1 = (e0) r63;
            GiftExtraRepo r2 = this.a.o;
            long r3 = r1.a;
            ArrayList<e3> r5 = r1.j;
            r2.getClass();
            if (r5 != null) goto L5;
        L8:
            boolean r6 = true;
        L10:
            if (r6 == true) goto L42;
            g0 r4 = r2.q(r3);
            if (r4 == null) goto L28;
            p r7 = r4.getDiyGiftToolbarInfo();
            if (r7 == null) goto L28;
            Iterator<T> r8 = r7.getCards().iterator();
        L18:
            if (r8.hasNext() == false) goto L22;
            com.bytedance.android.livesdk.gift.model.n r9 = (com.bytedance.android.livesdk.gift.model.n) r8.next();
            if (gz1.c.h(gz1.c.g(r9), r5) == false) goto L18;
            com.bytedance.android.livesdk.gift.model.n r10 = r9;
        L43:
            BigGiftPluginManager r11 = this.a;
            long r13 = r1.a;
            int r14 = r1.b;
            BigGiftPluginManager.N(r11, r13, false, 0, r14, r1.c, r1.d, r1.e, r1.f, r1.g, r1.h, r1.i, r1.j, r1.k, false, r1.r, r1.l, r1.m, r1.n, r1.o, r1.p, r1.q, 0, null, r1.s, r1.t, r1.u, r1.v, r1.w, r1.H, null, 0, r1.x, true, r1.y, r1.z, r10, BigGiftPluginManager.I(r11, r13, r11.o.o(r14, r13), r10), null, null, r1.A, r1.B, r1.C, r1.D, r1.E, null, r1.c, r1.F, r1.G, 1616912384, 4192);
            return;
        L22:
            Iterator<T> r15 = r7.getForceIndexCards().iterator();
        L24:
            if (r15.hasNext() == false) goto L28;
            com.bytedance.android.livesdk.gift.model.n r16 = (com.bytedance.android.livesdk.gift.model.n) r15.next();
            if (gz1.c.h(gz1.c.g(r16), r5) == false) goto L24;
            r10 = r16;
        L28:
            i12.e r17 = i12.o.b();
            if (r17 == null) goto L31;
            Object r18 = com.bytedance.android.scope.m.e.d(r17, m0.class);
        L32:
            m0 r19 = (m0) r18;
            if (r19 == null) goto L42;
            ArrayList<sz1.a> r20 = r19.a.get(String.valueOf(r3));
            if (r20 == null) goto L42;
            Iterator<T> r21 = r20.iterator();
        L38:
            if (r21.hasNext() == false) goto L42;
            r10 = (sz1.a) r21.next();
            if (gz1.c.h(gz1.c.g(r10), r5) == false) goto L38;
        L31:
            r18 = null;
        L42:
            r10 = null;
            goto L43
        L5:
            if (r5.isEmpty() == true) goto L8;
            r6 = false;
            goto L10
        }
    }

    public final void onStop() {
    }

    public final void onStart() {
        u0 r0 = this.l;
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "plugin");
        r0.i(this, F(), r0.g);
        GiftContext r1 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.k<e0> r2 = r1.getOpenBigGiftDialogEvent();
        if (r2 == null) goto L9;
        PublishSubject r3 = r2.onEvent();
        if (r3 == null) goto L9;
        Disposable r4 = r3.subscribe(new e(this));
    L10:
        this.f = r4;
        return;
    L9:
        r4 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.h
    public final void onDestroy() {
        super.onDestroy();
        Disposable r0 = this.f;
        if (r0 == null) goto L6;
        r0.dispose();
    L6:
        if (this.h.isDisposed() == true) goto L9;
        this.h.dispose();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l
    public final GiftPluginType F() {
        return this.i;
    }

    public final boolean J(Long r8) {
        a r0 = this.g;
        if (r0 != null) goto L6;
        return true;
    L6:
        if (r0 == null) goto L16;
        long r3 = r0.a;
        if (r8 != null) goto L11;
        return true;
    L11:
        if (r3 == r8.longValue()) goto L14;
        return true;
    L14:
        if ((System.currentTimeMillis() - r0.b) <= I18nInitTask.DELAY_TS_MS) goto L16;
        return true;
    L16:
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.h
    public final void k(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r2, "context");
        if (this.a.get() != null) goto L7;
        this.a = new WeakReference(r2);
        return;
    }

    public final long K(long r6, Integer r8) {
        this.g = new a(r6, System.currentTimeMillis());
        Long r1 = null;
        if (this.n == null) goto L19;
        h1 r7 = GiftManagerKt.j(r6, r8);
        if (r7 != null) goto L7;
        long r9 = 4;
    L17:
        r1 = Long.valueOf(r9);
        goto L19
    L7:
        if (r7.getType() == 4) goto L15;
        Iterator<T> r10 = r7.getAssetIds().iterator();
        r9 = 6;
    L10:
        if (r10.hasNext() == false) goto L17;
        r9 = ((Number) r10.next()).longValue();
        AssetsService r0 = (AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class);
        com.bytedance.android.live.core.resources.e r2 = r0.G1(r9);
        AssetDownloadPriority r3 = AssetDownloadPriority.LOCAL;
        if (r2 != null) goto L14;
        r0.p0(r9);
    L14:
        r0.ib(r2, null, IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW, r3);
        goto L10
    L15:
        r9 = 5;
    L19:
        return r1.longValue();
    }

    public final void L(h1 r5, Integer r6) {
        h.F(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("gift_id", String.valueOf(r5.getId())), TuplesKt.to("pre_type", "gift_select"), TuplesKt.to("start_result", String.valueOf(K(r5.getId(), r6)))}));
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final void j(long r4, Integer r6) {
        if (com.bytedance.android.livesdk.gift.platform.core.h.g().a() == true) goto L6;
        return;
    L6:
        if (J(Long.valueOf(r4)) == false) goto L9;
        h.F(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("gift_id", String.valueOf(r4)), TuplesKt.to("pre_type", "buff_select"), TuplesKt.to("start_result", String.valueOf(K(r4, r6)))}));
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean x(AbsPanel<?> r4, SelectedStatus r5, Integer r6) {
        Intrinsics.checkNotNullParameter(r5, "selectedStatus");
        if (com.bytedance.android.livesdk.gift.platform.core.h.g().c() == true) goto L5;
        return false;
    L5:
        Object r7 = null;
        if (r4 == null) goto L8;
        Object r8 = r4.h;
    L10:
        if ((r8 instanceof h1) == false) goto L13;
        r7 = r8;
    L13:
        h1 r9 = (h1) r7;
        if (r9 != null) goto L16;
    L29:
        return false;
    L16:
        if (r9.getType() == 2) goto L22;
        if (r9.getType() == 13) goto L22;
        if (r9.getType() != 15) goto L29;
    L22:
        if (J(Long.valueOf(r9.getId())) == false) goto L29;
        if (((Boolean) this.j.getValue()).booleanValue() == true) goto L26;
    L28:
        L(r9, r6);
        goto L29
    L26:
        if ((!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) == false) goto L28;
        com.bytedance.revenue.platform.api.core.rx.l r10 = com.bytedance.revenue.platform.api.core.rx.l.a;
        Observable r11 = Observable.just(Unit.INSTANCE);
        int r1 = com.bytedance.revenue.platform.api.core.rx.p.a;
        this.h.add(r11.observeOn(Schedulers.single()).subscribe(new b(this, r9, r6)));
        goto L29
    L8:
        r8 = null;
        goto L10
    }

    public static final int I(BigGiftPluginManager r1, long r2, l1 r4, com.bytedance.android.livesdk.gift.model.n r5) {
        if (r4 == null) goto L9;
        g0 r3 = r1.o.q(r4.getBuffGiftId());
        if (r3 == null) goto L17;
        ComboHintInfo r6 = r3.getComboHintInfo();
        if (r6 != null) goto L19;
        return 0;
    L19:
        return r6.getButtonStyle();
    L17:
        return 0;
    L9:
        if (r5 == null) goto L13;
        r1.getClass();
        ComboHintInfo r7 = r5.getComboHintInfo();
        if (r7 != null) goto L21;
        return 0;
    L21:
        return r7.getButtonStyle();
    L13:
        g0 r8 = r1.o.q(r2);
        if (r8 != null) goto L16;
        return 0;
    L16:
        return r8.getGiftSelectedStyle();
    }

    public BigGiftPluginManager(BigGiftViewModel r2, u0 r3, q2 r4, e1 r5, DataCenter r6, Context r7, GiftExtraRepo r8, cz1.a r9) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "giftInternalScopeService");
        Intrinsics.checkNotNullParameter(r4, "carnivalMessageService");
        Intrinsics.checkNotNullParameter(r5, "giftListService");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "giftExtraRepo");
        Intrinsics.checkNotNullParameter(r9, "livePetGiftPlugin");
        super(r6, r7);
        this.k = r2;
        this.l = r3;
        this.m = r4;
        this.n = r5;
        this.o = r8;
        this.h = new CompositeDisposable();
        this.i = GiftPluginType.TYPE_BIG_GIFT;
        this.j = LazyKt.lazy(BigGiftPluginManager$giftSelectedPostOnThread$2.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean A(AbsPanel<?> r26, int r27, int r28, IBaseUser r29, boolean r30, List<? extends IBaseUser> r31, boolean r33, n r34, k r35, k r36, l1 r37, com.bytedance.android.livesdk.gift.model.n r38, String r39, String r310, com.bytedance.android.livesdk.gift.platform.core.model.a r40) {
        Intrinsics.checkNotNullParameter(r29, "toUser");
        Intrinsics.checkNotNullParameter(r34, "showInfo");
        if (r26 != null) goto L5;
        return false;
    L5:
        if (r37 != null) goto L7;
    L9:
        int r5 = r27;
    L10:
        if (r38 != null) goto L12;
    L14:
        ArrayList<e3> r1 = r26.b;
    L15:
        ArrayList<e3> r3 = r1;
        if (r38 != null) goto L18;
    L20:
        String r2 = r26.c;
    L21:
        String r11 = r2;
        if (r38 != null) goto L24;
    L26:
        long r6 = r26.g;
    L27:
        long r8 = r6;
        T r4 = r26.h;
        if ((r4 instanceof h1) == false) goto L34;
        if (r4 == 0) goto L32;
        String r7 = ((h1) r4).getSortExtra();
    L40:
        String r20 = r7;
        if (j0.c(r26) == false) goto L43;
    L56:
        return false;
    L43:
        if (j0.b(r26) == true) goto L54;
        Intrinsics.checkNotNullParameter(r26, "$this$isMultiInteractPanel");
        Object r9 = r26.h;
        if ((r9 instanceof h1) == true) goto L47;
        r9 = null;
    L47:
        h1 r10 = (h1) r9;
        if (r10 != null) goto L50;
    L52:
        boolean r13 = false;
    L53:
        if (r13 == false) goto L56;
    L50:
        if (r10.getType() != 15) goto L52;
        r13 = true;
    L54:
        new Handler(Looper.getMainLooper()).post(new c(this, r26, r3, r29, r5, r30, r31, r8, r28, r11, r33, r34, r35, r36, r38, r37, r39, r310, r20, r40));
        return true;
    L32:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L34:
        if ((r4 instanceof l2) == false) goto L39;
        if (r4 == 0) goto L38;
        r7 = ((l2) r4).getGift().getSortExtra();
        goto L40
    L38:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IProp");
    L39:
        r7 = BuildConfig.FLAVOR;
        goto L40
    L24:
        if (nz1.a.s() == false) goto L26;
        r6 = r38.getConfigId();
        goto L27
    L18:
        if (nz1.a.s() == false) goto L20;
        r2 = r38.getCardName();
        goto L21
    L12:
        if (nz1.a.s() == false) goto L14;
        r1 = gz1.c.g(r38);
        goto L15
    L7:
        if (nz1.a.r() == false) goto L9;
        r5 = r37.getBuffLevel();
        goto L10
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean o(AbsPanel<?> r28, int r29, int r30, IBaseUser r31, boolean r33, List<? extends IBaseUser> r34, n r35, k r36, k r37, l1 r38, com.bytedance.android.livesdk.gift.model.n r39, String r310, int r40, String r41, com.bytedance.android.livesdk.gift.platform.core.model.a r43) {
        Intrinsics.checkNotNullParameter(r31, "toUser");
        Intrinsics.checkNotNullParameter(r35, "showInfo");
        if (r28 != null) goto L5;
        return false;
    L5:
        if (r38 != null) goto L7;
    L9:
        int r13 = r29;
    L10:
        if (r39 != null) goto L12;
    L14:
        ArrayList<e3> r1 = r28.b;
    L15:
        ArrayList<e3> r14 = r1;
        if (r39 != null) goto L18;
    L20:
        String r2 = r28.c;
    L21:
        String r15 = r2;
        if (r39 != null) goto L24;
    L26:
        long r3 = r28.g;
    L27:
        long r16 = r3;
        T r4 = r28.h;
        if ((r4 instanceof h1) == false) goto L34;
        if (r4 == 0) goto L32;
        String r5 = ((h1) r4).getSortExtra();
    L40:
        String r21 = r5;
        if (j0.b(r28) == false) goto L51;
        h.G(r28.c(), r28.h instanceof h1, true, r28.f, r28.c, r28.b, r31);
        Ref.IntRef r9 = new Ref.IntRef();
        r9.element = 1;
        Object r6 = null;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.T.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[44])).booleanValue() == false) goto L45;
        r9.element = r30;
    L46:
        i12.d r0 = m.e2.a();
        if (r0 == null) goto L49;
        r6 = com.bytedance.android.scope.m.e.d(r0, GiftSearchDataStore.class);
    L49:
        GiftSearchDataStore r23 = (GiftSearchDataStore) r6;
        new Handler(Looper.getMainLooper()).post(new d(this, r28, r13, r30, r31, r14, r33, r34, r16, r15, r35, r9, r36, r40, r37, r39, r38, r310, r41, r21, r23, r43));
        return true;
    L45:
        r9.element = 1;
        goto L46
    L51:
        return false;
    L32:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L34:
        if ((r4 instanceof l2) == false) goto L39;
        if (r4 == 0) goto L38;
        r5 = ((l2) r4).getGift().getSortExtra();
        goto L40
    L38:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IProp");
    L39:
        r5 = BuildConfig.FLAVOR;
        goto L40
    L24:
        if (nz1.a.s() == false) goto L26;
        r3 = r39.getConfigId();
        goto L27
    L18:
        if (nz1.a.s() == false) goto L20;
        r2 = r39.getCardName();
        goto L21
    L12:
        if (nz1.a.s() == false) goto L14;
        r1 = gz1.c.g(r39);
        goto L15
    L7:
        if (nz1.a.r() == false) goto L9;
        r13 = r38.getBuffLevel();
        goto L10
    }

    public static void N(BigGiftPluginManager r73, long r74, boolean r75, long r76, int r78, int r79, String r80, String r81, SendGiftSource r83, String r84, IBaseUser r85, String r86, ArrayList r87, boolean r88, boolean r89, List r810, long r90, int r93, ReceiverType r94, Long r95, String r96, boolean r97, int r98, String r99, List r910, SeriesSendType r100, String r101, String r102, boolean r103, Function1 r104, n r105, int r106, boolean r107, boolean r108, k r109, k r110, com.bytedance.android.livesdk.gift.model.n r111, int r112, String r113, String r114, String r115, boolean r116, String r117, String r118, Map r119, com.bytedance.android.livesdk.gift.platform.core.model.a r120, int r121, Map r122, Map r123, int r124, int r125) {
        if ((r124 & 16) == 0) goto L5;
        int r14 = 1;
    L6:
        int r3 = r124 & 32;
        String r4 = BuildConfig.FLAVOR;
        if (r3 == 0) goto L9;
        String r59 = BuildConfig.FLAVOR;
    L11:
        if ((r124 & 64) == 0) goto L13;
        String r13 = BuildConfig.FLAVOR;
    L15:
        if ((r124 & 128) == 0) goto L17;
        SendGiftSource r15 = SendGiftSource.GiftDialog;
    L19:
        if ((r124 & 1024) == 0) goto L21;
        String r10 = BuildConfig.FLAVOR;
    L23:
        if ((r124 & 2048) == 0) goto L25;
        ArrayList r16 = null;
    L27:
        if ((r124 & 8192) == 0) goto L29;
        boolean r61 = false;
    L31:
        if ((r124 & 16384) == 0) goto L33;
        List r63 = null;
    L35:
        if ((65536 & r124) == 0) goto L37;
        int r37 = 0;
    L39:
        if ((131072 & r124) == 0) goto L41;
        ReceiverType r9 = null;
    L43:
        if ((262144 & r124) == 0) goto L45;
        Long r33 = null;
    L47:
        if ((524288 & r124) == 0) goto L49;
        String r34 = null;
    L51:
        if ((1048576 & r124) == 0) goto L53;
        boolean r64 = false;
    L55:
        if ((2097152 & r124) == 0) goto L57;
        int r28 = 0;
    L59:
        if ((4194304 & r124) == 0) goto L61;
        String r40 = BuildConfig.FLAVOR;
    L63:
        if ((8388608 & r124) == 0) goto L65;
        List r65 = null;
    L67:
        if ((16777216 & r124) == 0) goto L69;
        SeriesSendType r30 = SeriesSendType.NONE;
    L71:
        if ((33554432 & r124) == 0) goto L73;
        String r31 = null;
    L75:
        if ((67108864 & r124) == 0) goto L77;
        String r8 = null;
    L79:
        if ((134217728 & r124) == 0) goto L81;
        boolean r43 = false;
    L83:
        if ((268435456 & r124) == 0) goto L85;
        Function1 r7 = BigGiftPluginManager$openComboDialog$1.INSTANCE;
    L87:
        if ((536870912 & r124) == 0) goto L89;
        n r35 = new n(null, null, 7);
    L91:
        if ((1073741824 & r124) == 0) goto L93;
        int r19 = 1;
    L95:
        if ((r124 & Integer.MIN_VALUE) == 0) goto L97;
        boolean r66 = false;
    L99:
        if ((r125 & 2) == 0) goto L101;
        k r44 = null;
    L103:
        if ((r125 & 4) == 0) goto L105;
        k r45 = null;
    L107:
        if ((r125 & 8) == 0) goto L109;
        com.bytedance.android.livesdk.gift.model.n r6 = null;
    L111:
        if ((r125 & 16) == 0) goto L113;
        int r67 = 0;
    L115:
        if ((r125 & 32) == 0) goto L117;
        String r46 = null;
    L119:
        if ((r125 & 64) == 0) goto L121;
        String r47 = null;
    L123:
        if ((r125 & 128) == 0) goto L125;
        String r48 = null;
    L127:
        if ((r125 & 256) == 0) goto L129;
        boolean r49 = false;
    L131:
        if ((r125 & 512) == 0) goto L133;
        String r50 = BuildConfig.FLAVOR;
    L135:
        if ((r125 & 1024) == 0) goto L137;
        String r51 = BuildConfig.FLAVOR;
    L139:
        if ((r125 & 2048) == 0) goto L141;
        Map r53 = null;
    L143:
        if ((r125 & 4096) == 0) goto L145;
        com.bytedance.android.livesdk.gift.platform.core.model.a r54 = null;
    L147:
        if ((r125 & 8192) == 0) goto L149;
        int r55 = 1;
    L151:
        if ((r125 & 16384) == 0) goto L153;
        Map r56 = null;
    L155:
        if ((32768 & r125) == 0) goto L157;
        Map r57 = null;
    L158:
        r73.getClass();
        StringBuilder r0 = new StringBuilder();
        yz0.k r2 = com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), yz0.k.class);
        if (r2 == null) goto L166;
        IBaseUser r5 = r2.getUser();
        if (r5 == null) goto L166;
        String r11 = r5.getIdString();
        if (r11 == null) goto L166;
        r4 = r11;
    L166:
        r0.append(r4);
        r0.append(com.bytedance.live.kmp.util.e.b());
        String r1 = r0.toString();
        if (r75 == true) goto L169;
        String r17 = String.valueOf(r74);
    L170:
        if (r75 == false) goto L172;
        String r18 = String.valueOf(r74);
    L173:
        ReceiverType r710 = r9;
        q2.a r20 = new q2.a(r17, r18, 0, ((dy1.a) com.bytedance.android.livesdk.gift.biggift.b.d.getValue(null, com.bytedance.android.livesdk.gift.biggift.b.a[2])).a(), r55, r1, 4);
        BigGiftViewModel r21 = r73.k;
        if (r21 == null) goto L176;
        Intrinsics.checkNotNullParameter(r1, "id");
        r21.i = r1;
    L176:
        r73.m.K5().onNext(r20);
        i12.e r23 = i12.o.b();
        if (r23 == null) goto L179;
        Object r24 = com.bytedance.android.scope.m.e.d(r23, com.bytedance.android.livesdk.gift.platform.core.scope.service.n.class);
    L180:
        com.bytedance.android.livesdk.gift.platform.core.scope.service.n r25 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.n) r24;
        if (r25 == null) goto L183;
        r25.a();
    L183:
        i12.e r26 = i12.o.b();
        if (r26 == null) goto L186;
        Object r27 = com.bytedance.android.scope.m.e.d(r26, d0.class);
    L187:
        d0 r29 = (d0) r27;
        if (r29 == null) goto L190;
        r29.a();
    L190:
        BigGiftComboDialog r36 = r73.e;
        if (r36 == null) goto L210;
        Handler r38 = DialogLancet.resolveDialogHandler(r36);
        if (r38 != null) goto L195;
    L197:
        DialogLancet.beforeDialogDismiss(r36);
        r36.dismiss();     // Catch: Throwable -> L200 Exception -> L202
    L207:
        DialogLancet.afterDialogDismiss(r36);
        goto L210
    L200:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r36);
        throw th;
    L202:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L200
        Throwable r39 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L200
        if (r39 == null) goto L207;
        com.bytedance.crash.d.d(r39, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L200
        goto L207
    L195:
        if (Looper.myLooper() == r38.getLooper()) goto L197;
        r38.post(DialogLancet.createDismissRunnable(r36));
    L210:
        Boolean r41 = (Boolean) r73.b.get("data_is_portrait", Boolean.TRUE);
        if (r41 == null) goto L213;
        boolean r58 = r41.booleanValue();
    L214:
        yz0.k r60 = com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), yz0.k.class);
        if (r60 == null) goto L217;
        boolean r68 = r60.isAnchor();
    L219:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.b.G.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[31])).booleanValue() == false) goto L243;
        if (r75 == true) goto L243;
        if (r108 == true) goto L243;
        if (r85 == null) goto L225;
        Long r126 = Long.valueOf(com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(r85));
    L226:
        SendGiftStrategy r210 = SendGiftStrategy.REQUEST_AFTER_RESPONSE;
        m.a r69 = m.e2;
        i12.d r70 = r69.a();
        if (r70 == null) goto L229;
        Object r71 = com.bytedance.android.scope.m.e.d(r70, w0.class);
    L230:
        w0 r77 = (w0) r71;
        if (r77 == null) goto L233;
        String r410 = r77.a;
    L234:
        i12.d r91 = r69.a();
        if (r91 == null) goto L237;
        Object r127 = com.bytedance.android.scope.m.e.d(r91, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f.class);
    L238:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r128 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f) r127;
        if (r128 == null) goto L241;
        Map<String, String> r310 = r128.c;
    L242:
        ReceiverType r811 = r710;
        SendGiftSource r812 = r15;
        String r813 = r8;
        GiftTransaction r129 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.p(new b0(r74, r15, r85, r126, 5, 0, r10, null, null, r13, r78, r84, r16, r88, r210, r19, r75, null, r76, r811, r61, r63, r64, r28, r65, r30, r31, r35, r33, r34, r310, null, r37, r90, r40, null, r43, r44, r45, r46, r47, r48, r410, r49, r50, r51, r53, r54, r55, r56, r57, -2147352160, 4194387));
    L265:
        if (i.i().E7().getEnable() == false) goto L294;
        ResourceRecordService r130 = (ResourceRecordService) com.bytedance.android.live.revenue.core.util.f.a(ResourceRecordService.class);
        AssetsService r131 = (AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class);
        long r132 = System.currentTimeMillis() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        List r133 = r65;
        if (r133 != null) goto L270;
    L273:
        boolean r134 = true;
    L274:
        if (r134 == true) goto L286;
        Iterator r135 = r65.iterator();
    L277:
        if (r135.hasNext() == false) goto L294;
        h2 r136 = GiftManagerKt.l(((k3) r135.next()).getGiftId());
        if (r136 == null) goto L277;
        Iterator<T> r137 = r136.getAssetIds().iterator();
    L282:
        if (r137.hasNext() == false) goto L277;
        String r138 = r131.D1(((Number) r137.next()).longValue());
        if (r138 == null) goto L282;
        r130.f0(r138, r132);
        goto L282
    L286:
        h2 r139 = GiftManagerKt.l(r74);
        if (r139 == null) goto L294;
        Iterator<T> r140 = r139.getAssetIds().iterator();
    L290:
        if (r140.hasNext() == false) goto L294;
        String r141 = r131.D1(((Number) r140.next()).longValue());
        if (r141 == null) goto L290;
        r130.f0(r141, r132);
        goto L290
    L270:
        if (r133.isEmpty() == true) goto L273;
        r134 = false;
    L294:
        BigGiftViewModel r142 = r73.k;
        r142.b = r6;
        r142.h(r129, true);
        int r143 = r14;
        int r144 = r73.k.f(r143, true);
        if (r144 == 0) goto L297;
        r7.invoke(Integer.valueOf(r144));
    L305:
        if (((Boolean) com.bytedance.android.livesdk.gift.biggift.e.c.getValue(null, com.bytedance.android.livesdk.gift.biggift.e.a[1])).booleanValue() == true) goto L307;
    L308:
        Activity r145 = ContextUtil.contextToActivity(r73.getContext());
        if (r145 == null) goto L452;
        int r146 = a0.a;
        h2 r147 = GiftManagerKt.l(r74);
        if (r147 == null) goto L313;
        Integer r148 = Integer.valueOf(r147.getAfterSendAction());
    L314:
        if (r148 == null) goto L318;
        r148.intValue();
        if ((r148.intValue() & 2) != 2) goto L318;
        boolean r149 = true;
    L319:
        if (r149 == true) goto L323;
        if (r75 == true) goto L323;
        boolean r150 = false;
    L324:
        if (r150 == false) goto L327;
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.h(r74, 4));
    L327:
        if (r64 == false) goto L333;
        if (r63 == null) goto L330;
        int r151 = r63.size();
    L331:
        if (r151 <= 1) goto L333;
        boolean r152 = true;
    L334:
        if (r61 == true) goto L453;
        h2 r153 = GiftManagerKt.l(r74);
        if (r153 != null) goto L338;
    L354:
        boolean r154 = false;
    L355:
        if (r154 == true) goto L358;
        if (r75 == true) goto L358;
        return;
    L358:
        if (r811 == ReceiverType.MicTeamAnchor) goto L455;
        if (r152 == true) goto L456;
        if (r66 == true) goto L457;
        BigGiftViewModel r155 = r73.k;
        DataCenter r156 = r73.b;
        if (r143 <= 1) goto L364;
        boolean r157 = true;
    L365:
        h2 r158 = GiftManagerKt.l(r74);
        if (r158 == null) goto L376;
        Intrinsics.checkNotNullParameter(r158, "$this$isSupportLongPressCombo");
        if ((r158 instanceof h1) == true) goto L370;
        r158 = null;
    L370:
        h1 r159 = (h1) r158;
        if (r159 == null) goto L373;
        boolean r160 = r159.isSupportLongPressCombo();
    L374:
        if (r160 != true) goto L376;
        boolean r161 = true;
    L377:
        if (r161 == false) goto L379;
    L382:
        boolean r162 = true;
    L383:
        if (r65 == null) goto L385;
        boolean r163 = true;
    L386:
        BigGiftComboDialog r164 = new BigGiftComboDialog(r145, r58, r68, r155, r156, r59, r157, r162, r163, r67);
        r73.e = r164;
        if (DialogLancet.shouldBlockDialogShow(r164) == false) goto L432;
        DialogLancet.handleBlockedDialogShow(r164);
    L391:
        SendGiftSource r165 = r812;
        if (r165 != SendGiftSource.GiftDialog) goto L413;
        if (r150 == false) goto L413;
        i12.e r166 = i12.o.b();
        if (r166 == null) goto L397;
        Object r167 = com.bytedance.android.scope.m.e.d(r166, com.bytedance.android.livesdk.gift.platform.core.scope.service.n.class);
    L398:
        com.bytedance.android.livesdk.gift.platform.core.scope.service.n r168 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.n) r167;
        if (r168 != null) goto L401;
        return;
    L401:
        if (com.bytedance.android.livesdk.gift.platform.business.b.c().b().b() == true) goto L404;
    L405:
        boolean r169 = false;
    L407:
        if (r169 == false) goto L466;
        r168.b = System.currentTimeMillis();
        r2 r170 = r168.c;
        if (r170 == null) goto L459;
        r170.onStart();
        return;
    L459:
        return;
    L466:
        return;
    L404:
        if (com.bytedance.android.livesdk.gift.platform.business.b.c().b().d().contains(Long.valueOf(r74)) == true) goto L405;
        r169 = true;
        goto L407
    L397:
        r167 = null;
    L413:
        if (r165 == SendGiftSource.JsbPage) goto L415;
        return;
    L415:
        if (TextUtils.isEmpty(r813) == true) goto L462;
        i12.e r171 = i12.o.b();
        if (r171 == null) goto L419;
        Object r172 = com.bytedance.android.scope.m.e.d(r171, d0.class);
    L420:
        d0 r173 = (d0) r172;
        if (r173 != null) goto L423;
        return;
    L423:
        if (com.bytedance.android.livesdk.gift.platform.business.b.c().a().getType() == GiftAfterSendConfig.FePageConfigType.COMBO_TYPE.getType()) goto L425;
        return;
    L425:
        if (TextUtils.isEmpty(r813) == true) goto L467;
        r173.a();
        r173.b = System.currentTimeMillis();
        r173.a = r813;
        r2 r174 = r173.e;
        if (r174 == null) goto L465;
        r174.onStart();
        return;
    L465:
        return;
    L467:
        return;
    L419:
        r172 = null;
        goto L420
    L462:
        return;
    L432:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L431
    L390:
        DialogLancet.beforeDialogShow(r164);
        r164.show();
        DialogLancet.afterDialogShow(r164);
        goto L391
    L385:
        r163 = false;
        goto L386
    L379:
        if (((Boolean) com.bytedance.android.livesdk.gift.biggift.b.c.getValue(null, com.bytedance.android.livesdk.gift.biggift.b.a[1])).booleanValue() == true) goto L382;
        r162 = false;
        goto L383
    L373:
        r160 = false;
    L376:
        r161 = false;
        goto L377
    L364:
        r157 = false;
        goto L365
    L457:
        return;
    L456:
        return;
    L455:
        return;
    L338:
        if ((r153.getAfterSendAction() & 1) != 0) goto L354;
        h2 r175 = GiftManagerKt.l(r74);
        if (r175 != null) goto L343;
    L350:
        boolean r176 = false;
    L352:
        if (r176 == false) goto L354;
        r154 = true;
        goto L355
    L343:
        if (r175.getType() != 13) goto L351;
        com.bytedance.android.live.core.resources.e r177 = ((AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class)).G1(r175.getPrimaryEffectId());
        if (r177 == null) goto L350;
        boolean r178 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.k();
        if (r177.getResourceType() != 10) goto L351;
        if (r178 == true) goto L350;
    L351:
        r176 = true;
        goto L352
    L453:
        return;
    L330:
        r151 = 0;
    L333:
        r152 = false;
    L323:
        r150 = true;
    L318:
        r149 = false;
        goto L319
    L313:
        r148 = null;
        goto L314
    L452:
        return;
    L307:
        if (r144 != GiftTransactionReqCount.TransactionBlock.getValue()) goto L308;
        return;
    L297:
        Function1 r179 = r7;
        if (r129 == null) goto L300;
        Observable<ExtraResponse<p2, ? extends Extra>> r180 = r129.getObservable();
    L301:
        if (r180 == null) goto L305;
        r180.subscribe(new f(r179), new g(r179));
        goto L305
    L300:
        r180 = null;
        goto L301
    L241:
        r310 = null;
        goto L242
    L237:
        r127 = null;
        goto L238
    L233:
        r410 = null;
        goto L234
    L229:
        r71 = null;
        goto L230
    L225:
        r126 = null;
    L243:
        r811 = r710;
        r813 = r8;
        r812 = r15;
        if (r85 == null) goto L246;
        Long r181 = Long.valueOf(com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(r85));
    L247:
        SendGiftStrategy r182 = SendGiftStrategy.ONE_SEND_ONE_REQUEST;
        m.a r183 = m.e2;
        i12.d r184 = r183.a();
        if (r184 == null) goto L250;
        Object r185 = com.bytedance.android.scope.m.e.d(r184, w0.class);
    L251:
        w0 r186 = (w0) r185;
        if (r186 == null) goto L254;
        String r411 = r186.a;
    L255:
        i12.d r187 = r183.a();
        if (r187 == null) goto L258;
        Object r188 = com.bytedance.android.scope.m.e.d(r187, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f.class);
    L259:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r189 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f) r188;
        if (r189 == null) goto L262;
        Map<String, String> r311 = r189.c;
    L263:
        r129 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.p(new b0(r74, r812, r85, r181, 1, 0, r10, null, null, r13, r78, r84, r16, r88, r182, r19, r75, null, r76, r811, r61, r63, r64, r28, r65, r30, r31, r35, r33, r34, r311, null, r37, r90, r40, null, r43, r44, r45, r46, r47, r48, r411, r49, r50, r51, r53, r54, r55, r56, r57, -2147352160, 4194387));
        goto L265
    L262:
        r311 = null;
        goto L263
    L258:
        r188 = null;
        goto L259
    L254:
        r411 = null;
        goto L255
    L250:
        r185 = null;
        goto L251
    L246:
        r181 = null;
        goto L247
    L217:
        r68 = false;
        goto L219
    L213:
        r58 = true;
        goto L214
    L186:
        r27 = null;
        goto L187
    L179:
        r24 = null;
        goto L180
    L172:
        r18 = null;
        goto L173
    L169:
        r17 = null;
        goto L170
    L157:
        r57 = r123;
        goto L158
    L153:
        r56 = r122;
        goto L155
    L149:
        r55 = r121;
        goto L151
    L145:
        r54 = r120;
        goto L147
    L141:
        r53 = r119;
        goto L143
    L137:
        r51 = r118;
        goto L139
    L133:
        r50 = r117;
        goto L135
    L129:
        r49 = r116;
        goto L131
    L125:
        r48 = r115;
        goto L127
    L121:
        r47 = r114;
        goto L123
    L117:
        r46 = r113;
        goto L119
    L113:
        r67 = r112;
        goto L115
    L109:
        r6 = r111;
        goto L111
    L105:
        r45 = r110;
        goto L107
    L101:
        r44 = r109;
        goto L103
    L97:
        r66 = r107;
        goto L99
    L93:
        r19 = r106;
        goto L95
    L89:
        r35 = r105;
        goto L91
    L85:
        r7 = r104;
        goto L87
    L81:
        r43 = r103;
        goto L83
    L77:
        r8 = r102;
        goto L79
    L73:
        r31 = r101;
        goto L75
    L69:
        r30 = r100;
        goto L71
    L65:
        r65 = r910;
        goto L67
    L61:
        r40 = r99;
        goto L63
    L57:
        r28 = r98;
        goto L59
    L53:
        r64 = r97;
        goto L55
    L49:
        r34 = r96;
        goto L51
    L45:
        r33 = r95;
        goto L47
    L41:
        r9 = r94;
        goto L43
    L37:
        r37 = r93;
        goto L39
    L33:
        r63 = r810;
        goto L35
    L29:
        r61 = r89;
        goto L31
    L25:
        r16 = r87;
        goto L27
    L21:
        r10 = r86;
        goto L23
    L17:
        r15 = r83;
        goto L19
    L13:
        r13 = r81;
        goto L15
    L9:
        r59 = r80;
        goto L11
    L5:
        r14 = r79;
        goto L6
    }
}

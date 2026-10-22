package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LongSparseArray;
import android.view.WindowManager;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.downloader.GiftResourceManagerFactory;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetDownloadPriority;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetsUtils;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.AssetsDownloadPolicyService;
import com.bytedance.android.livesdk.gift.platform.business.effect.delete.ResourceRecordService;
import com.bytedance.android.livesdk.gift.platform.business.effect.delete.StorageService;
import com.bytedance.android.livesdk.gift.platform.core.GiftServiceKt;
import com.bytedance.android.livesdk.gift.platform.core.download.TTDownloadException;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.livesdk.revenue.service.broadcast.IRevBroadcastService;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception.BaseGetResourceException;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception.Md5InvalidException;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception.NetworkException;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception.UnzipException;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception.WriteStorageException;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class AssetsService implements com.bytedance.android.scope.o, dy0.c, IAssetsManager {
    public com.bytedance.android.livesdk.gift.configmodel.h A;
    public com.bytedance.android.livesdk.gift.configmodel.q B;
    public final boolean C;
    public final boolean D;
    public long E;
    public final Lazy F;
    public final Lazy G;
    public final Lazy H;
    public final Lazy I;
    public final ResourceRecordService J;
    public final AssetsDownloadPolicyService K;
    public final List<IAssetsManager.b> a;
    public final CopyOnWriteArrayList<com.bytedance.android.live.core.resources.e> b;
    public LongSparseArray<com.bytedance.android.live.core.resources.e> c;
    public final JSONObject d;
    public Disposable e;
    public com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e f;
    public final com.bytedance.android.livesdk.gift.configmodel.f g;
    public LongSparseArray<com.bytedance.android.live.core.resources.e> h;
    public LongSparseArray<com.bytedance.android.live.core.resources.e> i;
    public String j;
    public long k;
    public com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.f l;
    public com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public final List<Long> t;
    public final ConcurrentHashMap<Long, com.bytedance.android.livesdk.gift.platform.business.effect.assets.a> u;
    public boolean v;
    public final CompositeDisposable w;
    public List<com.bytedance.android.live.core.resources.e> x;
    public com.bytedance.android.livesdk.gift.configmodel.m y;
    public com.bytedance.android.livesdk.gift.configmodel.i0 z;

    public static final class a {
    }

    public static final class b implements Action {
        public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.business.effect.assets.e a;

        public b(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r1) {
            this.a = r1;
        }

        public final void run() {
            iz0.a r0 = com.bytedance.android.livesdk.gift.platform.core.keva_store.a.a;
            com.bytedance.android.livesdk.gift.platform.core.keva_store.a.d(this.a.k, System.currentTimeMillis() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW));
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.business.effect.assets.e a;

        public c(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r1) {
            this.a = r1;
        }

        public final void run() {
            iz0.a r0 = com.bytedance.android.livesdk.gift.platform.core.keva_store.a.a;
            com.bytedance.android.livesdk.gift.platform.core.keva_store.a.d(this.a.k, System.currentTimeMillis() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW));
        }
    }

    public static final class d implements com.bytedance.kmp.livesdk.gift.platform.resourcemanager.c {
        public final /* synthetic */ AssetsService a;
        public final /* synthetic */ com.bytedance.android.live.core.resources.e b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.business.effect.assets.e d;
        public final /* synthetic */ int e;
        public final /* synthetic */ long f;
        public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.business.effect.assets.f g;

        public static final class a implements yp2.a {
            public final /* synthetic */ d a;
            public final /* synthetic */ String b;
            public final /* synthetic */ long c;

            public final void onSuccess() {
                d r0 = this.a;
                if (r0.c == false) goto L5;
            L16:
                com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r1 = this.a.g;
                if (r1 == null) goto L20;
                r1.c(this.c, this.b);
                return;
            L20:
                return;
            L5:
                if (r0.b == null) goto L16;
                long r2 = 0;
                if (r0.a.q == false) goto L11;
                long r3 = r0.d.c;
                if (r3 <= 0) goto L11;
                float r4 = r3 / 1048576.0f;
            L12:
                d r5 = this.a;
                AssetsService.f(r5.a, r5.b, r5.d, r5.e, r5.f, r4);
                int r6 = com.bytedance.android.livesdk.gift.platform.core.b.a;
                com.bytedance.android.livesdk.gift.platform.core.b.b(this.a.d.k);
                jy0.b.c("AssetsUtils", "downloads first: " + this.b, null, 4);
                d r7 = this.a;
                ResourceRecordService r8 = r7.a.J;
                String r9 = r7.d.k;
                long r10 = com.bytedance.live.kmp.util.e.b() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
                long r11 = (long) (r4 * 1024);
                long r13 = this.c;
                com.bytedance.android.live.core.resources.b r14 = this.a.b.getCleanStrategy();
                if (r14 == null) goto L15;
                r2 = r14.getKeepAliveTime();
            L15:
                r8.K(r9, r10, r11, r13, r2);
            L11:
                int r15 = com.bytedance.android.livesdk.gift.platform.core.b.a;
                r4 = com.bytedance.android.livesdk.gift.platform.core.b.a(this.b);
                goto L12
            }

            public final void onFailure(Exception r9) {
                com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r0 = this.a.g;
                if (r0 == null) goto L5;
                r0.onFailed(new Throwable(r9));
            L5:
                d r1 = this.a;
                AssetsService.a(r1.a, r1.b, r1.d, r1.e, r1.f, r9);
            }

            public a(d r1, String r2, long r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }
        }

        public final void a(long r2) {
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r0 = this.g;
            if (r0 == null) goto L6;
            r0.a(r2);
            return;
        }

        public final void b(BaseGetResourceException r9) {
            Intrinsics.checkNotNullParameter(r9, "t");
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r0 = this.g;
            if (r0 == null) goto L5;
            r0.onFailed(r9);
        L5:
            AssetsService r1 = this.a;
            long r2 = this.b.getId();
            if (r1.z.C7() == false) goto L22;
            if (r1.z.q9() <= 0) goto L22;
            i12.e r3 = i12.o.b();
            if (r3 == null) goto L12;
            Object r4 = com.bytedance.android.scope.m.e.d(r3, GiftDataStorageService.class);
        L13:
            GiftDataStorageService r5 = (GiftDataStorageService) r4;
            if (r5 == null) goto L22;
            if (r5.l.size() <= com.bytedance.android.livesdk.gift.platform.business.i.h().q9()) goto L20;
            w12.a.d = false;
            int r6 = r5.k;
            if (r6 >= 1) goto L20;
            r5.k = r6 + 1;
            String r7 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
            Pair[] r8 = {TuplesKt.to("fail_count", String.valueOf(r5.l.size())), TuplesKt.to("callback_count", String.valueOf(r5.k))};
            LinkedHashMap r10 = new LinkedHashMap();
            MapsKt.putAll(r10, r8);
            mz0.n r11 = new mz0.n();
            Map r13 = r11.a;
            Intrinsics.checkNotNullParameter(r13, "map");
            Intrinsics.checkNotNullParameter(r10, "map");
            r13.putAll(r10);
            mz0.m r14 = new mz0.m();
            com.bytedance.android.livesdk.revenue.log.i r15 = vh6.c.b(kr2.a.class).ud();
            Intrinsics.checkNotNullParameter(r15, "pageSourceLog");
            ((ArrayList) r14.a).add(r15.a);
            r14.b(LogCommon.ROOM);
            ((ArrayList) r11.b).addAll(r14.a);
            cy0.e.a.getClass();
            cy0.j r16 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r17 = com.bytedance.android.scope.m.b(r16).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r17);
            ((f80.a) r17).w3("livesdk_asset_url_error_template", r11.a, r11.b);
            r1.T2(2, "AssetServiceTemplateError");
        L20:
            r5.l.add(Long.valueOf(r2));
            goto L22
        L12:
            r4 = null;
        L22:
            if (this.c == true) goto L27;
            com.bytedance.android.live.core.resources.e r18 = this.b;
            if (r18 == null) goto L28;
            AssetsService.a(this.a, r18, this.d, this.e, this.f, new Exception(r9));
            return;
        L28:
            return;
        }

        public final void onProgress(int r2) {
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r0 = this.g;
            if (r0 == null) goto L6;
            r0.onProgress(r2);
            return;
        }

        public final void c(long r17, String r19) {
            Intrinsics.checkNotNullParameter(r19, "path");
            AssetsService r1 = this.a;
            com.bytedance.android.live.core.resources.e r2 = this.b;
            r1.getClass();
            boolean r3 = true;
            if (r2 != null) goto L6;
        L8:
            if (r3 == false) goto L28;
            if (this.c == false) goto L12;
        L24:
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r4 = this.g;
            if (r4 == null) goto L42;
            r4.c(r17, r19);
            return;
        L42:
            return;
        L12:
            if (this.b == null) goto L24;
            if (this.a.q == false) goto L18;
            long r5 = this.d.c;
            if (r5 <= 0) goto L18;
            float r6 = r5 / 1048576.0f;
        L19:
            AssetsService.f(this.a, this.b, this.d, this.e, this.f, r6);
            jy0.b.a("AssetsUtils", "downloads first: " + r19);
            int r7 = com.bytedance.android.livesdk.gift.platform.core.b.a;
            com.bytedance.android.livesdk.gift.platform.core.b.b(this.d.k);
            ResourceRecordService r8 = this.a.J;
            String r9 = this.d.k;
            long r10 = com.bytedance.live.kmp.util.e.b() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
            long r11 = (long) (r6 * 1024);
            com.bytedance.android.live.core.resources.b r13 = this.b.getCleanStrategy();
            if (r13 == null) goto L22;
            long r14 = r13.getKeepAliveTime();
        L23:
            r8.K(r9, r10, r11, r17, r14);
            goto L24
        L22:
            r14 = 0;
        L18:
            r6 = com.bytedance.android.livesdk.gift.platform.core.b.a(r19);
            goto L19
        L28:
            if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.effect.c.class).N2() == false) goto L37;
            com.bytedance.android.livesdk.revenue.service.effect.c r15 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.effect.c.class);
            com.bytedance.android.live.core.resources.h r16 = this.b.getLokiExtraModel();
            Map r18 = null;
            if (r16 == null) goto L32;
            List r20 = r16.o8();
        L33:
            com.bytedance.android.live.core.resources.h r21 = this.b.getLokiExtraModel();
            if (r21 == null) goto L36;
            r18 = com.bytedance.android.live.core.resources.i.a(r21);
        L36:
            r15.Bj(r20, r18, new a(this, r19, r17));
            return;
        L32:
            r20 = null;
            goto L33
        L37:
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r23 = this.g;
            if (r23 == null) goto L40;
            r23.onFailed(new Throwable("downloadable model support is not supported in this host."));
        L40:
            AssetsService.a(this.a, this.b, this.d, this.e, this.f, new Exception("downloadable model support is not supported in this host."));
            return;
        L6:
            if (r2.getLokiExtraModel() == null) goto L8;
            r3 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.effect.c.class).he(r2);
            goto L8
        }

        public d(AssetsService r1, com.bytedance.android.live.core.resources.e r2, boolean r3, com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r4, int r5, long r6, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r8;
        }
    }

    public static final class e extends BDNetworkTagContextProviderAdapter {
        public final int triggerType() {
            return 1;
        }

        public e() {
        }
    }

    public static final class f implements Action {
        public final /* synthetic */ AssetsService a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ long g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ int k;

        public f(AssetsService r1, long r2, String r4, String r5, int r6, String r7, long r8, String r10, String r11, String r13, int r14) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r10;
            this.i = r11;
            this.j = r13;
            this.k = r14;
        }

        public final void run() {
            AssetsService r1 = this.a;
            long r2 = this.b;
            r1.getClass();
            long r13 = AssetsService.w0(r2);
            AssetsService r3 = this.a;
            String r4 = String.valueOf(this.b);
            String r5 = this.c;
            String r6 = this.d;
            int r7 = this.e;
            String r8 = this.f;
            long r9 = this.g;
            String r11 = this.h;
            String r14 = this.i;
            String r15 = this.j;
            int r10 = this.k;
            r3.getClass();
            AssetsService.J0(r4, r5, r6, r7, r8, r9, r11, r14, r13, r15, r10);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ AssetsService a;
        public final /* synthetic */ int b;
        public final /* synthetic */ List c;
        public final /* synthetic */ int d;
        public final /* synthetic */ long e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public g(AssetsService r1, int r2, List r3, int r4, long r5, String r7, String r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r7;
            this.g = r8;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void accept(Object r27) {
            g<T> r0 = this;
            ExtraResponse r1 = (ExtraResponse) r27;
            long r5 = System.currentTimeMillis();
            com.bytedance.android.livesdk.gift.model.d r2 = (com.bytedance.android.livesdk.gift.model.d) r1.data;
            if (r0.a.I().d0() == false) goto L43;
            AssetsService r3 = r0.a;
            int r15 = r0.b;
            r3.getClass();
            CopyOnWriteArrayList r7 = new CopyOnWriteArrayList(r2.getAssets());
            Iterator r4 = r7.iterator();
        L6:
            if (r4.hasNext() == false) goto L8;
            com.bytedance.android.live.core.resources.e r8 = (com.bytedance.android.live.core.resources.e) r4.next();
            r3.i.put(r8.getId(), r8);
            r5 = r5;
            goto L6
        L8:
            long r21 = r5;
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e r6 = r3.f;
            if (r6 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("downloadPolicy");
        L11:
            if (r6 == null) goto L32;
            boolean r9 = AssetsUtils.b;
            if (AssetsUtils.b(g02.a.e()) == true) goto L32;
            i12.e r10 = i12.o.b();
            if (r10 == null) goto L17;
            Object r11 = com.bytedance.android.scope.m.e.d(r10, com.bytedance.android.livesdk.gift.platform.business.effect.delete.c.class);
        L18:
            com.bytedance.android.livesdk.gift.platform.business.effect.delete.c r13 = (com.bytedance.android.livesdk.gift.platform.business.effect.delete.c) r11;
            if (r13 == null) goto L21;
            r13.f(r7);
        L21:
            StringBuilder r14 = new StringBuilder("trigger resource download, ids = ");
            ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
            Iterator r17 = r7.iterator();
        L23:
            if (r17.hasNext() == false) goto L25;
            r16.add(Long.valueOf(((com.bytedance.android.live.core.resources.e) r17.next()).getId()));
            goto L23
        L25:
            r14.append(r16);
            r14.append(", source = ");
            r14.append(r15);
            r14.append(", isAnchor = ");
            r14.append(g02.a.e());
            r14.append(", policy =");
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e r18 = r3.f;
            if (r18 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("downloadPolicy");
        L28:
            r14.append(r18);
            jy0.b.a("AssetsService", r14.toString());
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e r19 = r3.f;
            if (r19 != null) goto L31;
            Intrinsics.throwUninitializedPropertyAccessException("downloadPolicy");
        L31:
            r19.g(r7, r15, g02.a.e());
            goto L32
        L17:
            r11 = null;
        L32:
            int r20 = r3.h.size();
            int r23 = r3.i.size() + r20;
            ArrayList r24 = new ArrayList(r23);
            int r25 = 0;
        L33:
            if (r25 >= r23) goto L38;
            if (r25 >= r20) goto L36;
            com.bytedance.android.live.core.resources.e r26 = r3.h.valueAt(r25);
        L37:
            r24.add(r26);
            r25 = r25 + 1;
            goto L33
        L36:
            r26 = r3.i.valueAt(r25 - r20);
            goto L37
        L38:
            int r28 = ((ArrayList) r3.a).size();
        L39:
            r28 = r28 - 1;
            if (r28 < 0) goto L42;
            ((IAssetsManager.b) ListProtector.get(r3.a, r28)).b(r24);
            goto L39
        L42:
            ExtraResponse r110 = r1;
        L131:
            AssetsService r29 = r0.a;
            if (r29.n == true) goto L134;
            r29.o = com.bytedance.android.livesdk.gift.platform.core.a0.a();
        L134:
            AssetsService r30 = r0.a;
            if (r30.o == false) goto L144;
            Disposable r31 = r30.e;
            if (r31 == null) goto L144;
            if (r31.isDisposed() == true) goto L144;
            Disposable r33 = r0.a.e;
            if (r33 == null) goto L143;
            r33.dispose();
        L143:
            r0.a.e = null;
        L144:
            ExtraResponse r34 = r110;
            com.bytedance.android.livesdk.gift.platform.core.utils.h.S(r0.d, r0.e, r21, 0, 0, ((com.bytedance.android.livesdk.gift.model.d) r34.data).getAssets().size(), 3, r0.f, null, r0.g, 0, null, 0, r34.logId, 0, 23552);
            return;
        L43:
            r21 = r5;
            AssetsService r35 = r0.a;
            int r36 = r0.b;
            List r37 = r0.c;
            r35.getClass();
            CopyOnWriteArrayList r38 = new CopyOnWriteArrayList(r2.getAssets());
            if (r37 != null) goto L46;
        L73:
            i12.e r39 = i12.o.b();
            if (r39 == null) goto L76;
            Object r40 = com.bytedance.android.scope.m.e.d(r39, com.bytedance.android.livesdk.gift.platform.business.effect.delete.c.class);
        L77:
            com.bytedance.android.livesdk.gift.platform.business.effect.delete.c r41 = (com.bytedance.android.livesdk.gift.platform.business.effect.delete.c) r40;
            if (r41 == null) goto L80;
            r41.g(r2.getAssetPools());
        L80:
            r35.b.addAll(r38);
            AssetsUtils.a();
            List<Long> r43 = r2.getZipSweepMarkAssets();
            ((ArrayList) r35.t).clear();
            ((ArrayList) r35.t).addAll(r43);
            Iterator r44 = ((ArrayList) r35.t).iterator();
        L82:
            if (r44.hasNext() == false) goto L95;
            long r45 = ((Number) r44.next()).longValue();
            com.bytedance.android.live.core.resources.e r111 = r35.G1(r45);
            if (r111 == null) goto L82;
            Iterator r210 = r44;
            ConcurrentHashMap<Long, com.bytedance.android.livesdk.gift.platform.business.effect.assets.a> r46 = r35.u;
            Long r47 = Long.valueOf(r45);
            ExtraResponse r112 = r1;
            String r48 = r111.getMD5();
            com.bytedance.android.live.core.resources.j r113 = r111.getH265ResourceModel();
            if (r113 == null) goto L88;
            String r49 = r113.getMd5();
        L89:
            com.bytedance.android.live.core.resources.k r114 = r111.getH265SuperResourceModel();
            if (r114 == null) goto L92;
            String r115 = r114.getMd5();
        L93:
            r46.put(r47, new com.bytedance.android.livesdk.gift.platform.business.effect.assets.a(r48, r49, r115));
            r44 = r210;
            r1 = r112;
            goto L82
        L92:
            r115 = null;
            goto L93
        L88:
            r49 = null;
            goto L89
        L95:
            r110 = r1;
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e r50 = r35.f;
            if (r50 != null) goto L98;
            Intrinsics.throwUninitializedPropertyAccessException("downloadPolicy");
        L98:
            if (r50 == null) goto L126;
            boolean r51 = AssetsUtils.b;
            if (AssetsUtils.b(g02.a.e()) == true) goto L126;
            ArrayList r53 = new ArrayList();
            if (r35.p == false) goto L104;
            r53.addAll(AssetsService.A(r38, r35.t));
        L105:
            List<com.bytedance.android.live.core.resources.e> r54 = r35.x(r53);
            r53.clear();
            r53.addAll(r54);
            ((ArrayList) r35.x).clear();
            if (r36 != 3) goto L108;
            ((ArrayList) r35.x).addAll(r53);
        L108:
            i12.e r55 = i12.o.b();
            if (r55 == null) goto L111;
            Object r56 = com.bytedance.android.scope.m.e.d(r55, com.bytedance.android.livesdk.gift.platform.business.effect.delete.c.class);
        L112:
            com.bytedance.android.livesdk.gift.platform.business.effect.delete.c r57 = (com.bytedance.android.livesdk.gift.platform.business.effect.delete.c) r56;
            if (r57 == null) goto L115;
            r57.f(r2.getAssets());
        L115:
            StringBuilder r58 = new StringBuilder("trigger resource download, ids = ");
            ArrayList r59 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r53, 10));
            Iterator r60 = r53.iterator();
        L117:
            if (r60.hasNext() == false) goto L119;
            r59.add(Long.valueOf(((com.bytedance.android.live.core.resources.e) r60.next()).getId()));
            goto L117
        L119:
            r58.append(r59);
            r58.append(", source = ");
            r58.append(r36);
            r58.append(", isAnchor = ");
            r58.append(g02.a.e());
            r58.append(", policy =");
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e r61 = r35.f;
            if (r61 != null) goto L122;
            Intrinsics.throwUninitializedPropertyAccessException("downloadPolicy");
        L122:
            r58.append(r61);
            jy0.b.a("AssetsService", r58.toString());
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e r63 = r35.f;
            if (r63 != null) goto L125;
            Intrinsics.throwUninitializedPropertyAccessException("downloadPolicy");
        L125:
            r63.g(r53, r36, g02.a.e());
            goto L126
        L111:
            r56 = null;
            goto L112
        L104:
            r53.addAll(r38);
        L126:
            int r64 = ((ArrayList) r35.a).size();
        L127:
            r64 = r64 - 1;
            if (r64 < 0) goto L130;
            ((IAssetsManager.b) ListProtector.get(r35.a, r64)).b(r35.b);
            goto L127
        L130:
            r0 = this;
            goto L131
        L76:
            r40 = null;
            goto L77
        L46:
            if ((!r37.isEmpty()) != true) goto L73;
            Iterator<T> r65 = r37.iterator();
        L49:
            if (r65.hasNext() == false) goto L73;
            long r116 = ((Number) r65.next()).longValue();
            Iterator r66 = r38.iterator();
        L52:
            if (r66.hasNext() == false) goto L59;
            Object r117 = r66.next();
            if (((com.bytedance.android.live.core.resources.e) r117).getId() != r116) goto L56;
            boolean r211 = true;
        L57:
            if (r211 == false) goto L52;
        L61:
            if (((com.bytedance.android.live.core.resources.e) r117) == null) goto L49;
            CopyOnWriteArrayList<com.bytedance.android.live.core.resources.e> r67 = r35.b;
            Iterator<com.bytedance.android.live.core.resources.e> r118 = r67.iterator();
        L64:
            if (r118.hasNext() == false) goto L71;
            com.bytedance.android.live.core.resources.e r212 = r118.next();
            if (r212.getId() != r116) goto L68;
            boolean r213 = true;
        L69:
            if (r213 == false) goto L64;
            com.bytedance.android.live.core.resources.e r119 = r212;
        L72:
            r67.remove(r119);
            goto L49
        L68:
            r213 = false;
            goto L69
        L71:
            r119 = null;
            goto L72
        L56:
            r211 = false;
            goto L57
        L59:
            r117 = null;
            goto L61
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ AssetsService a;

        public h(AssetsService r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            Intrinsics.checkNotNullParameter(r3, "throwable");
            Logger.e("AssetsService", r3.getMessage());
            Iterator<T> r4 = CollectionsKt.reversed(this.a.a).iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            ((IAssetsManager.b) r4.next()).a();
            goto L4
        L6:
            AssetsService r5 = this.a;
            if (r5.n == true) goto L9;
            r5.o = com.bytedance.android.livesdk.gift.platform.core.a0.a();
        L9:
            AssetsService r6 = this.a;
            if (r6.o == false) goto L21;
            Disposable r7 = r6.e;
            if (r7 != null) goto L14;
            return;
        L14:
            if (r7.isDisposed() == true) goto L23;
            Disposable r8 = this.a.e;
            if (r8 == null) goto L18;
            r8.dispose();
        L18:
            this.a.e = null;
            return;
        L23:
            return;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ AssetsService a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;
        public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.business.effect.assets.d d;

        public i(AssetsService r1, int r2, long r3, com.bytedance.android.livesdk.gift.platform.business.effect.assets.d r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final void accept(Object r10) {
            ExtraResponse r11 = (ExtraResponse) r10;
            if (this.a.A.p7() == false) goto L41;
            AssetsService r0 = this.a;
            int r1 = this.b;
            long r2 = this.c;
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.d r4 = this.d;
            r0.getClass();
            com.bytedance.android.livesdk.gift.platform.core.b0 r5 = com.bytedance.android.livesdk.gift.platform.core.b0.a;
            com.bytedance.android.livesdk.gift.platform.core.b0.a(System.currentTimeMillis() - r2, r1);
            if (r11 == null) goto L11;
            com.bytedance.android.livesdk.gift.model.d r3 = (com.bytedance.android.livesdk.gift.model.d) r11.data;
            if (r3 == null) goto L11;
            com.bytedance.android.livesdk.gift.model.f2 r6 = r3.getImageTemplate();
            if (r6 == null) goto L11;
            w12.a.b(r6);
        L11:
            if (r11 == null) goto L21;
            com.bytedance.android.livesdk.gift.model.d r7 = (com.bytedance.android.livesdk.gift.model.d) r11.data;
            if (r7 == null) goto L21;
            List<com.bytedance.android.live.core.resources.e> r8 = r7.getAssets();
            if (r8 == null) goto L21;
            Iterator<T> r9 = r8.iterator();
        L18:
            if (r9.hasNext() == false) goto L21;
            com.bytedance.android.live.core.resources.e r13 = (com.bytedance.android.live.core.resources.e) r9.next();
            r0.b0(r13);
            r4.getClass();
            Intrinsics.checkNotNullParameter(r13, "assetsModel");
            r4.a(r13.getDownloadType());
        L21:
            if (r0.c.size() != 0) goto L23;
            boolean r14 = true;
        L24:
            if (r14 == false) goto L50;
            Iterator<T> r15 = ((com.bytedance.android.livesdk.gift.model.d) r11.data).getAssets().iterator();
        L27:
            if (r15.hasNext() == false) goto L51;
            com.bytedance.android.live.core.resources.e r16 = (com.bytedance.android.live.core.resources.e) r15.next();
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d r17 = r0.m;
            if (r17 != null) goto L31;
            Intrinsics.throwUninitializedPropertyAccessException("mAssetsManagerSupport");
        L31:
            c12.e r18 = r17.c(r16, r1);
            com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r19 = GiftResourceManagerFactory.a();
            if (r19 != null) goto L34;
        L36:
            boolean r20 = false;
        L37:
            if (r20 == false) goto L27;
            if (r0.d.length() >= 500) goto L27;
            r0.d.put(String.valueOf(r16.getId()), r16.getModifyVersion());
            goto L27
        L34:
            if (r19.e(r18) != true) goto L36;
            r20 = true;
            goto L37
        L51:
            return;
        L50:
            return;
        L23:
            r14 = false;
            goto L24
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ AssetsService a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;
        public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.business.effect.assets.d f;
        public final /* synthetic */ String g;
        public final /* synthetic */ boolean h;

        public j(AssetsService r1, int r2, long r3, int r5, String r6, com.bytedance.android.livesdk.gift.platform.business.effect.assets.d r7, String r8, boolean r9) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
        }

        public final void accept(Object r48) {
            final ExtraResponse r1 = (ExtraResponse) r48;
            if (this.a.A.p7() == false) goto L64;
            AssetsService r2 = this.a;
            int r8 = this.b;
            long r9 = this.c;
            int r13 = this.d;
            String r14 = this.e;
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.d r11 = this.f;
            String r15 = this.g;
            r2.getClass();
            long r17 = System.currentTimeMillis();
            i12.e r16 = i12.o.b();
            if (r16 == null) goto L7;
            Object r5 = com.bytedance.android.scope.m.e.d(r16, com.bytedance.android.livesdk.gift.platform.business.effect.delete.c.class);
        L8:
            com.bytedance.android.livesdk.gift.platform.business.effect.delete.c r6 = (com.bytedance.android.livesdk.gift.platform.business.effect.delete.c) r5;
            if (r6 == null) goto L11;
            r6.g(((com.bytedance.android.livesdk.gift.model.d) r1.data).getAssetPools());
        L11:
            com.bytedance.android.livesdk.gift.model.d r7 = (com.bytedance.android.livesdk.gift.model.d) r1.data;
            List<Long> r10 = r7.getZipSweepMarkAssets();
            if (r2.c.size() != 0) goto L14;
            int r19 = 1;
        L15:
            Iterator<T> r18 = r7.getAssets().iterator();
        L17:
            if (r18.hasNext() == false) goto L30;
            com.bytedance.android.live.core.resources.e r3 = (com.bytedance.android.live.core.resources.e) r18.next();
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.d r27 = r11;
            String r28 = r15;
            r2.c.put(r3.getId(), r3);
            if (r10.contains(Long.valueOf(r3.getId())) != true) goto L29;
            String r110 = r3.getMD5();
            com.bytedance.android.live.core.resources.j r111 = r3.getH265ResourceModel();
            if (r111 == null) goto L23;
            String r112 = r111.getMd5();
        L24:
            com.bytedance.android.live.core.resources.k r23 = r3.getH265SuperResourceModel();
            if (r23 == null) goto L27;
            String r20 = r23.getMd5();
        L28:
            r2.u.put(Long.valueOf(r3.getId()), new com.bytedance.android.livesdk.gift.platform.business.effect.assets.a(r110, r112, r20));
            r10 = r10;
            goto L29
        L27:
            r20 = null;
            goto L28
        L23:
            r112 = null;
        L29:
            r11 = r27;
            r15 = r28;
            goto L17
        L30:
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.d r29 = r11;
            String r210 = r15;
            Iterator<T> r4 = r7.getDeleteAssets().iterator();
        L32:
            if (r4.hasNext() == false) goto L34;
            r2.c.remove(((Number) r4.next()).longValue());
            goto L32
        L34:
            List<Long> r21 = r7.getZipSweepMarkAssets();
            ((ArrayList) r2.t).clear();
            ((ArrayList) r2.t).addAll(r21);
            int r24 = r2.c.size();
            ArrayList r25 = new ArrayList(r24);
            int r26 = 0;
        L35:
            if (r26 >= r24) goto L38;
            r25.add(r2.c.valueAt(r26));
            r26 = r26 + 1;
            goto L35
        L38:
            if (r2.A.o4() == true) goto L40;
            AssetsUtils.a();
        L40:
            com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.g.a(r2.A.v3(), new AssetsService$handleAssetResponse$4(r1));
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e r30 = r2.f;
            if (r30 != null) goto L43;
            Intrinsics.throwUninitializedPropertyAccessException("downloadPolicy");
        L43:
            if (r30 == null) goto L57;
            boolean r31 = AssetsUtils.b;
            if (AssetsUtils.b(g02.a.e()) == true) goto L57;
            ArrayList r33 = new ArrayList();
            if (r2.p == false) goto L49;
            r33.addAll(AssetsService.A(((com.bytedance.android.livesdk.gift.model.d) r1.data).getAssets(), r2.t));
        L50:
            List<com.bytedance.android.live.core.resources.e> r34 = r2.x(r33);
            r33.clear();
            r33.addAll(r34);
            ((ArrayList) r2.x).clear();
            if (r8 != 3) goto L53;
            ((ArrayList) r2.x).addAll(r33);
        L53:
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e r35 = r2.f;
            if (r35 != null) goto L56;
            Intrinsics.throwUninitializedPropertyAccessException("downloadPolicy");
        L56:
            r35.g(r33, r8, g02.a.e());
            goto L57
        L49:
            r33.addAll(((com.bytedance.android.livesdk.gift.model.d) r1.data).getAssets());
        L57:
            if (r19 == 0) goto L59;
            r2.e1(((com.bytedance.android.livesdk.gift.model.d) r1.data).getAssets());
        L59:
            int r36 = ((ArrayList) r2.a).size();
        L60:
            r36 = r36 - 1;
            if (r36 < 0) goto L63;
            ((IAssetsManager.b) ListProtector.get(r2.a, r36)).b(r25);
            goto L60
        L63:
            Handler r37 = UtilityKotlinExtentionsKt.a;
            com.bytedance.android.livesdk.gift.platform.core.utils.h.S(r8, r9, r17, r13, r19, r7.getAssets().size(), 2, r14, r29, r210, 0, null, 0, r1.logId, 0, 23552);
            return;
        L14:
            r19 = 0;
            goto L15
        L7:
            r5 = null;
            goto L8
        L64:
            long r38 = System.currentTimeMillis();
            this.a.k = r38;
            com.bytedance.android.livesdk.gift.platform.core.b0 r39 = com.bytedance.android.livesdk.gift.platform.core.b0.a;
            com.bytedance.android.livesdk.gift.platform.core.b0.a(SystemClock.uptimeMillis() - this.c, this.b);
            if (r1 == null) goto L72;
            com.bytedance.android.livesdk.gift.model.d r40 = (com.bytedance.android.livesdk.gift.model.d) r1.data;
            if (r40 == null) goto L72;
            com.bytedance.android.livesdk.gift.model.f2 r41 = r40.getImageTemplate();
            if (r41 == null) goto L72;
            w12.a.b(r41);
        L72:
            if (r1 == null) goto L81;
            com.bytedance.android.livesdk.gift.model.d r43 = (com.bytedance.android.livesdk.gift.model.d) r1.data;
            if (r43 == null) goto L81;
            List<com.bytedance.android.live.core.resources.e> r44 = r43.getAssets();
            if (r44 == null) goto L81;
            Iterator<T> r45 = r44.iterator();
        L79:
            if (r45.hasNext() == false) goto L81;
            com.bytedance.android.live.core.resources.e r46 = (com.bytedance.android.live.core.resources.e) r45.next();
            r46.setCdnDomainOpt(this.a.z.C7());
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.d r47 = this.f;
            r47.getClass();
            Intrinsics.checkNotNullParameter(r46, "assetsModel");
            r47.a(r46.getDownloadType());
        L81:
            i12.e r49 = i12.o.b();
            if (r49 == null) goto L84;
            Object r50 = com.bytedance.android.scope.m.e.d(r49, com.bytedance.android.livesdk.gift.platform.business.effect.delete.c.class);
        L85:
            com.bytedance.android.livesdk.gift.platform.business.effect.delete.c r51 = (com.bytedance.android.livesdk.gift.platform.business.effect.delete.c) r50;
            if (r51 == null) goto L89;
            r51.g(((com.bytedance.android.livesdk.gift.model.d) r1.data).getAssetPools());
        L89:
            if (this.a.c.size() != 0) goto L91;
            int r310 = 1;
        L92:
            if (r310 == 0) goto L109;
            Iterator<T> r53 = ((com.bytedance.android.livesdk.gift.model.d) r1.data).getAssets().iterator();
        L95:
            if (r53.hasNext() == false) goto L109;
            com.bytedance.android.live.core.resources.e r54 = (com.bytedance.android.live.core.resources.e) r53.next();
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d r55 = this.a.m;
            if (r55 != null) goto L99;
            Intrinsics.throwUninitializedPropertyAccessException("mAssetsManagerSupport");
        L99:
            c12.e r56 = r55.c(r54, this.b);
            com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r57 = GiftResourceManagerFactory.a();
            if (r57 != null) goto L102;
        L104:
            boolean r113 = false;
        L105:
            if (r113 == false) goto L95;
            if (this.a.d.length() >= 500) goto L95;
            this.a.d.put(String.valueOf(r54.getId()), r54.getModifyVersion());
            goto L95
        L102:
            if (r57.e(r56) != true) goto L104;
            r113 = true;
        L109:
            com.bytedance.android.livesdk.gift.model.d r58 = (com.bytedance.android.livesdk.gift.model.d) r1.data;
            List<Long> r59 = r58.getZipSweepMarkAssets();
            Iterator<T> r60 = r58.getAssets().iterator();
        L111:
            if (r60.hasNext() == false) goto L124;
            com.bytedance.android.live.core.resources.e r61 = (com.bytedance.android.live.core.resources.e) r60.next();
            this.a.c.put(r61.getId(), r61);
            if (r59.contains(Long.valueOf(r61.getId())) != true) goto L123;
            String r114 = r61.getMD5();
            com.bytedance.android.live.core.resources.j r115 = r61.getH265ResourceModel();
            if (r115 == null) goto L117;
            String r116 = r115.getMd5();
        L118:
            com.bytedance.android.live.core.resources.k r117 = r61.getH265SuperResourceModel();
            if (r117 == null) goto L121;
            String r118 = r117.getMd5();
        L122:
            this.a.u.put(Long.valueOf(r61.getId()), new com.bytedance.android.livesdk.gift.platform.business.effect.assets.a(r114, r116, r118));
            goto L123
        L121:
            r118 = null;
            goto L122
        L117:
            r116 = null;
        L123:
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.d r119 = this.f;
            r119.getClass();
            Intrinsics.checkNotNullParameter(r61, "assetsModel");
            r119.a(r61.getDownloadType());
            goto L111
        L124:
            Iterator<T> r63 = r58.getDeleteAssets().iterator();
        L126:
            if (r63.hasNext() == false) goto L128;
            this.a.c.remove(((Number) r63.next()).longValue());
            goto L126
        L128:
            List<Long> r64 = r58.getZipSweepMarkAssets();
            ((ArrayList) this.a.t).clear();
            ((ArrayList) this.a.t).addAll(r64);
            int r65 = this.a.c.size();
            ArrayList r66 = new ArrayList(r65);
            int r67 = 0;
        L129:
            if (r67 >= r65) goto L131;
            r66.add(this.a.c.valueAt(r67));
            r67 = r67 + 1;
            goto L129
        L131:
            AssetsUtils.a();
            i12.e r68 = i12.o.b();
            if (r68 == null) goto L134;
            Object r120 = com.bytedance.android.scope.m.e.d(r68, com.bytedance.android.livesdk.gift.platform.business.effect.delete.c.class);
        L135:
            com.bytedance.android.livesdk.gift.platform.business.effect.delete.c r69 = (com.bytedance.android.livesdk.gift.platform.business.effect.delete.c) r120;
            if (r69 == null) goto L138;
            r69.f(((com.bytedance.android.livesdk.gift.model.d) r1.data).getAssets());
        L138:
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e r70 = this.a.f;
            if (r70 != null) goto L141;
            Intrinsics.throwUninitializedPropertyAccessException("downloadPolicy");
        L141:
            if (r70 != null) goto L143;
        L155:
            if (r310 == 0) goto L157;
            this.a.e1(((com.bytedance.android.livesdk.gift.model.d) r1.data).getAssets());
        L157:
            int r71 = ((ArrayList) this.a.a).size();
        L158:
            r71 = r71 - 1;
            if (r71 < 0) goto L162;
            ((IAssetsManager.b) ListProtector.get(this.a.a, r71)).b(r66);
            goto L158
        L162:
            if (this.b != 2) goto L166;
            GiftServiceKt.Companion.getClass();
            if (GiftServiceKt.access$getExitRoomClearGiftMemoryMills$cp() <= 0) goto L166;
            long r73 = System.currentTimeMillis() - GiftServiceKt.access$getExitRoomClearGiftMemoryMills$cp();
            GiftServiceKt.access$setExitRoomClearGiftMemoryMills$cp(0);
            long r410 = r73;
        L167:
            int r74 = this.b;
            long r75 = this.c;
            int r76 = this.d;
            Handler r77 = UtilityKotlinExtentionsKt.a;
            com.bytedance.android.livesdk.gift.platform.core.utils.h.S(r74, r75, r38, r76, r310, r58.getAssets().size(), 1, this.e, this.f, this.g, 0, null, 0, r1.logId, r410, 7168);
            return;
        L166:
            r410 = 0;
            goto L167
        L143:
            if (AssetsUtils.b(this.h) == true) goto L155;
            ArrayList r78 = new ArrayList();
            if (this.a.p == false) goto L147;
            r78.addAll(AssetsService.A(((com.bytedance.android.livesdk.gift.model.d) r1.data).getAssets(), this.a.t));
        L148:
            List<com.bytedance.android.live.core.resources.e> r79 = this.a.x(r78);
            r78.clear();
            r78.addAll(r79);
            ((ArrayList) this.a.x).clear();
            if (this.b != 3) goto L151;
            ((ArrayList) this.a.x).addAll(r78);
        L151:
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e r80 = this.a.f;
            if (r80 != null) goto L154;
            Intrinsics.throwUninitializedPropertyAccessException("downloadPolicy");
        L154:
            r80.g(r78, this.b, this.h);
            goto L155
        L147:
            r78.addAll(((com.bytedance.android.livesdk.gift.model.d) r1.data).getAssets());
            goto L148
        L134:
            r120 = null;
            goto L135
        L91:
            r310 = 0;
            goto L92
        L84:
            r50 = null;
            goto L85
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ AssetsService a;
        public final /* synthetic */ int b;

        public k(AssetsService r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            Intrinsics.checkNotNullParameter(r4, "throwable");
            Logger.e("AssetsService", r4.getMessage());
            boolean r0 = com.bytedance.android.livesdk.gift.platform.core.d0.a;
            com.bytedance.android.livesdk.gift.platform.core.d0.f(r4.getMessage(), com.bytedance.android.live.revenue.common.r0.a(r4), this.b);
            Iterator<T> r5 = CollectionsKt.reversed(this.a.a).iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            ((IAssetsManager.b) r5.next()).a();
            goto L4
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ AssetsService a;
        public final /* synthetic */ long b;
        public final /* synthetic */ int c;

        public l(AssetsService r1, long r2, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void accept(Object r6) {
            ExtraResponse r7 = (ExtraResponse) r6;
            com.bytedance.android.livesdk.gift.platform.core.b0 r0 = com.bytedance.android.livesdk.gift.platform.core.b0.a;
            com.bytedance.android.livesdk.gift.platform.core.b0.a(System.currentTimeMillis() - this.b, this.c);
            if (r7 == null) goto L9;
            com.bytedance.android.livesdk.gift.model.d r1 = (com.bytedance.android.livesdk.gift.model.d) r7.data;
            if (r1 == null) goto L9;
            com.bytedance.android.livesdk.gift.model.f2 r2 = r1.getImageTemplate();
            if (r2 == null) goto L9;
            w12.a.b(r2);
        L9:
            com.bytedance.android.livesdk.gift.model.d r3 = (com.bytedance.android.livesdk.gift.model.d) r7.data;
            if (r3 == null) goto L17;
            List<com.bytedance.android.live.core.resources.e> r4 = r3.getAssets();
            if (r4 == null) goto L17;
            Iterator<T> r5 = r4.iterator();
        L15:
            if (r5.hasNext() == false) goto L17;
            com.bytedance.android.live.core.resources.e r8 = (com.bytedance.android.live.core.resources.e) r5.next();
            this.a.b0(r8);
        L17:
            com.bytedance.android.livesdk.gift.model.d r9 = (com.bytedance.android.livesdk.gift.model.d) r7.data;
            if (r9 == null) goto L25;
            List<com.bytedance.android.live.core.resources.e> r10 = r9.getBaseAssets();
            if (r10 == null) goto L25;
            Iterator<T> r11 = r10.iterator();
        L23:
            if (r11.hasNext() == false) goto L25;
            com.bytedance.android.live.core.resources.e r13 = (com.bytedance.android.live.core.resources.e) r11.next();
            this.a.b0(r13);
        L25:
            AssetsService r14 = this.a;
            if (r14.E != 0) goto L28;
            r14.E = System.currentTimeMillis();
        L28:
            this.a.g(0);
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ AssetsService a;
        public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.business.effect.assets.d b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;
        public final /* synthetic */ long e;
        public final /* synthetic */ int f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        public m(AssetsService r1, com.bytedance.android.livesdk.gift.platform.business.effect.assets.d r2, boolean r3, int r4, long r5, int r7, String r8, String r9) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r7;
            this.g = r8;
            this.h = r9;
        }

        public final void accept(Object r23) {
            ExtraResponse r1 = (ExtraResponse) r23;
            if (r1 != null) goto L5;
            return;
        L5:
            if (r1.data == null) goto L137;
            long r6 = System.currentTimeMillis();
            this.a.k = r6;
            final com.bytedance.android.livesdk.gift.model.d r2 = (com.bytedance.android.livesdk.gift.model.d) r1.data;
            List<Long> r3 = r2.getZipSweepMarkAssets();
            com.bytedance.android.livesdk.gift.model.f2 r4 = r2.getImageTemplate();
            if (r4 == null) goto L10;
            w12.a.b(r4);
        L10:
            Map<String, ? extends com.bytedance.android.live.core.resources.c> r5 = r2.getAssetPools();
            if (r5 != null) goto L13;
        L21:
            List<com.bytedance.android.live.core.resources.e> r7 = r2.getAssets();
            if (r7 == null) goto L38;
            Iterator<T> r8 = r7.iterator();
        L25:
            if (r8.hasNext() == false) goto L38;
            com.bytedance.android.live.core.resources.e r9 = (com.bytedance.android.live.core.resources.e) r8.next();
            r9.setCdnDomainOpt(this.a.z.C7());
            this.a.i.put(r9.getId(), r9);
            if (r3.contains(Long.valueOf(r9.getId())) != true) goto L25;
            String r11 = r9.getMD5();
            com.bytedance.android.live.core.resources.j r13 = r9.getH265ResourceModel();
            if (r13 == null) goto L31;
            String r14 = r13.getMd5();
        L32:
            com.bytedance.android.live.core.resources.k r15 = r9.getH265SuperResourceModel();
            if (r15 == null) goto L35;
            String r16 = r15.getMd5();
        L36:
            this.a.u.put(Long.valueOf(r9.getId()), new com.bytedance.android.livesdk.gift.platform.business.effect.assets.a(r11, r14, r16));
            goto L25
        L35:
            r16 = null;
            goto L36
        L31:
            r14 = null;
        L38:
            if (r2.getBaseAssets() != null) goto L40;
        L59:
            this.a.j = r2.getAssetMetaBaseVersion();
            Iterator<T> r10 = r2.getDeleteAssets().iterator();
        L61:
            if (r10.hasNext() == false) goto L63;
            long r17 = ((Number) r10.next()).longValue();
            this.a.h.remove(r17);
            this.a.i.remove(r17);
            goto L61
        L63:
            List<Long> r18 = r2.getZipSweepMarkAssets();
            if (r2.getZipSweepMarkAssets().size() <= 0) goto L66;
            ((ArrayList) this.a.t).clear();
            ((ArrayList) this.a.t).addAll(r18);
        L66:
            int r19 = this.a.h.size();
            int r110 = this.a.i.size();
            int r20 = r19 + r110;
            ArrayList r21 = new ArrayList(r20);
            int r24 = 0;
        L67:
            if (r24 >= r20) goto L72;
            if (r24 >= r19) goto L70;
            com.bytedance.android.live.core.resources.e r111 = this.a.h.valueAt(r24);
        L71:
            r21.add(r111);
            r24 = r24 + 1;
            goto L67
        L70:
            r111 = this.a.i.valueAt(r24 - r19);
            goto L71
        L72:
            com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.g.a(this.a.A.v3(), new AssetsService$syncAssetsListV3$2$7(r2));
            Iterator r25 = r21.iterator();
        L74:
            if (r25.hasNext() == false) goto L76;
            ((com.bytedance.android.live.core.resources.e) r25.next()).setDownloadType(2);
            goto L74
        L76:
            com.bytedance.android.live.core.resources.d r26 = r2.getDynamicControl();
            if (r26 == null) goto L87;
            Map r27 = r26.getDownloadTypeMap();
            if (r27 == null) goto L87;
            Iterator r28 = r27.entrySet().iterator();
        L82:
            if (r28.hasNext() == false) goto L87;
            Map.Entry r29 = (Map.Entry) r28.next();
            long r112 = ((Number) r29.getKey()).intValue();
            int r30 = ((Number) r29.getValue()).intValue();
            com.bytedance.android.live.core.resources.e r113 = this.a.G1(r112);
            if (r113 == null) goto L86;
            r113.setDownloadType(r30);
        L86:
            this.b.a(r30);
        L87:
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e r31 = this.a.f;
            if (r31 != null) goto L90;
            Intrinsics.throwUninitializedPropertyAccessException("downloadPolicy");
        L90:
            if (r31 == null) goto L105;
            boolean r33 = AssetsUtils.b;
            if (AssetsUtils.b(this.c) == true) goto L105;
            ArrayList r34 = new ArrayList();
            AssetsService r114 = this.a;
            if (r114.p == false) goto L96;
            r34.addAll(AssetsService.A(r21, r114.t));
        L97:
            List<com.bytedance.android.live.core.resources.e> r115 = this.a.x(r34);
            r34.clear();
            r34.addAll(r115);
            ((ArrayList) this.a.x).clear();
            if (this.d != 3) goto L100;
            ((ArrayList) this.a.x).addAll(r34);
        L100:
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e r116 = this.a.f;
            if (r116 != null) goto L103;
            Intrinsics.throwUninitializedPropertyAccessException("downloadPolicy");
        L103:
            r116.g(r34, this.d, this.c);
            goto L105
        L96:
            r34.addAll(r21);
        L105:
            if (r2.getBaseAssets().size() <= 0) goto L107;
            this.a.e1(r21);
        L107:
            int r35 = ((ArrayList) this.a.a).size();
        L108:
            r35 = r35 - 1;
            if (r35 < 0) goto L112;
            ((IAssetsManager.b) ListProtector.get(this.a.a, r35)).b(r21);
            goto L108
        L112:
            if (r2.getBaseAssets().size() <= 0) goto L114;
            int r36 = 1;
        L115:
            com.bytedance.android.livesdk.gift.platform.core.utils.h.S(this.d, this.e, r6, this.f, r36, r2.getAssets().size(), 4, this.g, this.b, this.h, r19, this.a.j, r110, r1.logId, 0, 16384);
            return;
        L114:
            r36 = 0;
            goto L115
        L40:
            if (r2.getBaseAssets().size() <= 0) goto L59;
            if ((!Intrinsics.areEqual(this.a.j, r2.getAssetMetaBaseVersion())) == false) goto L59;
            this.a.h.clear();
            List<com.bytedance.android.live.core.resources.e> r37 = r2.getBaseAssets();
            if (r37 == null) goto L59;
            Iterator<T> r38 = r37.iterator();
        L47:
            if (r38.hasNext() == false) goto L59;
            com.bytedance.android.live.core.resources.e r39 = (com.bytedance.android.live.core.resources.e) r38.next();
            r39.setCdnDomainOpt(this.a.z.C7());
            this.a.h.put(r39.getId(), r39);
            if (r3.contains(Long.valueOf(r39.getId())) != true) goto L47;
            String r117 = r39.getMD5();
            com.bytedance.android.live.core.resources.j r118 = r39.getH265ResourceModel();
            if (r118 == null) goto L53;
            String r119 = r118.getMd5();
        L54:
            com.bytedance.android.live.core.resources.k r120 = r39.getH265SuperResourceModel();
            if (r120 == null) goto L57;
            String r121 = r120.getMd5();
        L58:
            this.a.u.put(Long.valueOf(r39.getId()), new com.bytedance.android.livesdk.gift.platform.business.effect.assets.a(r117, r119, r121));
            goto L47
        L57:
            r121 = null;
            goto L58
        L53:
            r119 = null;
            goto L54
        L13:
            if (r5.size() <= 0) goto L21;
            i12.e r40 = i12.o.b();
            if (r40 == null) goto L17;
            Object r41 = com.bytedance.android.scope.m.e.d(r40, com.bytedance.android.livesdk.gift.platform.business.effect.delete.c.class);
        L18:
            com.bytedance.android.livesdk.gift.platform.business.effect.delete.c r43 = (com.bytedance.android.livesdk.gift.platform.business.effect.delete.c) r41;
            if (r43 == null) goto L21;
            r43.g(r5);
            goto L21
        L17:
            r41 = null;
            goto L18
        }
    }

    public static final class n<T> implements Consumer {
        public final /* synthetic */ AssetsService a;
        public final /* synthetic */ int b;

        public n(AssetsService r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            Intrinsics.checkNotNullParameter(r4, "throwable");
            Logger.e("AssetsService", r4.getMessage());
            boolean r0 = com.bytedance.android.livesdk.gift.platform.core.d0.a;
            com.bytedance.android.livesdk.gift.platform.core.d0.f(r4.getMessage(), com.bytedance.android.live.revenue.common.r0.a(r4), this.b);
            Iterator<T> r5 = CollectionsKt.reversed(this.a.a).iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            ((IAssetsManager.b) r5.next()).a();
            goto L4
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ AssetsService a;
        public final /* synthetic */ List b;

        public o(AssetsService r1, List r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r10) {
            Integer r11 = (Integer) r10;
            long r2 = ((Number) ay1.b.K.getValue(null, ay1.b.a[42])).longValue();
            if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.a0.l.getValue(null, com.bytedance.android.livesdk.gift.platform.core.a0.a[10])).booleanValue() == false) goto L8;
            if ((System.currentTimeMillis() - r2) >= 86400000) goto L8;
            return;
        L8:
            if (r2 != 0) goto L10;
            ay1.b.w(System.currentTimeMillis());
        L10:
            com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r13 = GiftResourceManagerFactory.a();
            if (r13 == null) goto L15;
            com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a r14 = r13.a();
            if (r14 == null) goto L15;
            String r15 = r14.a();
        L17:
            if (r15 != null) goto L19;
        L22:
            boolean r3 = true;
        L23:
            if (r3 == true) goto L101;
            PolarisFileWrapper r4 = new PolarisFileWrapper(r15);
            if (r4.exists() == true) goto L28;
            jy0.b.c("AssetsService", "delete useless resource failed: not found root path: " + r15, null, 4);
            return;
        L28:
            File[] r16 = r4.listFiles();
            ArrayList r1 = new ArrayList();
            com.bytedance.android.livesdk.gift.configmodel.f r5 = ((GiftResourceFileCacheService) com.bytedance.android.live.revenue.core.util.f.a(GiftResourceFileCacheService.class)).h();
            if (r5 != null) goto L31;
        L37:
            Iterator r17 = r1.iterator();
            int r6 = 0;
        L39:
            if (r17.hasNext() == false) goto L71;
            File r7 = (File) r17.next();
            if (r7.exists() == false) goto L39;
            String r8 = r7.getName();
            Iterator r9 = this.b.iterator();
        L45:
            if (r9.hasNext() == false) goto L56;
            com.bytedance.android.live.core.resources.e r18 = (com.bytedance.android.live.core.resources.e) r9.next();
            if (gz1.a.b(r18, r8) == false) goto L45;
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d r19 = this.a.m;
            if (r19 != null) goto L51;
            Intrinsics.throwUninitializedPropertyAccessException("mAssetsManagerSupport");
        L51:
            c12.e r20 = r19.c(r18, 0);
            if (r20 == null) goto L45;
            if (TextUtils.equals(r8, r20.k) == false) goto L45;
            boolean r21 = false;
        L57:
            if (r21 == false) goto L39;
            int r23 = GiftResourceFileCacheService.p;
            if ("zip".equals(r7.getName()) == true) goto L39;
            com.bytedance.android.live.revenue.common.c0.b(r7);
            r6 = r6 + 1;
            if (r8 == null) goto L39;
            if (r8.length() != 32) goto L39;
            int r24 = com.bytedance.android.livesdk.gift.platform.core.b.a;
            Intrinsics.checkNotNullParameter(r8, "assetMd5");
            GiftResourceFileCacheService r25 = (GiftResourceFileCacheService) com.bytedance.android.live.revenue.core.util.f.a(GiftResourceFileCacheService.class);
            if (r8.length() != 0) goto L67;
            boolean r26 = true;
        L68:
            if (r26 == true) goto L39;
            r25.c.remove(r8);
            goto L39
        L67:
            r26 = false;
            goto L68
        L56:
            r21 = true;
            goto L57
        L71:
            ay1.b.w(System.currentTimeMillis());
            if (r6 <= 0) goto L99;
            com.bytedance.android.livesdk.gift.platform.core.d0.i(r6, 1);
            return;
        L99:
            return;
        L31:
            if (r5.getEnable() != true) goto L37;
            PolarisFileWrapper r27 = new PolarisFileWrapper(((GiftResourceFileCacheService) com.bytedance.android.live.revenue.core.util.f.a(GiftResourceFileCacheService.class)).b);
            CollectionsKt.addAll(r1, r16);
            File[] r110 = r27.listFiles();
            if (r110 == null) goto L37;
            if (r110.length <= 0) goto L37;
            CollectionsKt.addAll(r1, r110);
            goto L37
        L101:
            return;
        L19:
            if (r15.length() == 0) goto L22;
            r3 = false;
        L15:
            r15 = null;
            goto L17
        }
    }

    static {
    }

    public final com.bytedance.android.livesdk.gift.configmodel.f1 I() {
        return (com.bytedance.android.livesdk.gift.configmodel.f1) this.F.getValue();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager
    public final int B7() {
        if (this.n == true) goto L6;
        this.o = com.bytedance.android.livesdk.gift.platform.core.a0.a();
    L6:
        if (this.o == false) goto L9;
        return this.c.size();
    L9:
        return this.b.size();
    }

    public final android.util.Pair<String, String> E() {
        if (((Boolean) this.H.getValue()).booleanValue() == true) goto L5;
        return null;
    L5:
        return BDNetworkTagManager.getInstance().buildBDNetworkTag(new e());
    }

    public final void clearGiftMemoryCache() {
        ArrayList r0 = new ArrayList();
        Iterator<String> r1 = this.d.keys();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.add(r1.next());
        goto L4
    L6:
        Iterator r2 = r0.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        String r3 = (String) r2.next();
        this.d.remove(r3);
        goto L8
    L10:
        this.c.clear();
        this.c = new LongSparseArray();
        this.u.clear();
        ((ArrayList) this.t).clear();
        this.b.clear();
        this.h.clear();
        this.h = new LongSparseArray();
        this.i.clear();
        this.i = new LongSparseArray();
        this.j = "0";
        this.k = 0;
        this.x.clear();
        this.x = new ArrayList();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager
    public final LiveData<List<Pair<com.bytedance.android.live.core.resources.e, Boolean>>> h0() {
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("downloadPolicy");
    L5:
        if (r0 == null) goto L10;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e r1 = this.f;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("downloadPolicy");
    L12:
        return r1.h0();
    L10:
        return null;
    }

    public final void onStart() {
        KmpEnv r0 = KmpEnv.a;
        if (KmpEnv.b() == false) goto L6;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.f r1 = new com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.j();
    L9:
        this.l = r1;
        if (com.bytedance.android.livesdk.gift.platform.business.i.f().S2() == false) goto L12;
    L15:
        boolean r2 = true;
    L17:
        if (r2 == false) goto L19;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e r3 = this.K;
    L23:
        this.f = r3;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.f r4 = this.l;
        if (r4 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mDownloadPolicyFactory");
    L26:
        this.m = r4.c();
        if (com.bytedance.android.livesdk.gift.platform.core.a0.e().W8() == true) goto L32;
        GiftPanelBizBoostUtils.E.getClass();
        if (((Boolean) GiftPanelBizBoostUtils.r.getValue()).booleanValue() == true) goto L32;
        boolean r5 = false;
    L33:
        this.n = r5;
        if (r5 == false) goto L36;
        this.o = com.bytedance.android.livesdk.gift.platform.core.a0.a();
    L36:
        this.p = ((com.bytedance.android.livesdk.gift.configmodel.c) com.bytedance.android.livesdk.gift.platform.business.i.m.getValue(null, com.bytedance.android.livesdk.gift.platform.business.i.a[11])).h1();
        ReadOnlyProperty r6 = com.bytedance.android.livesdk.gift.platform.core.a0.e;
        KProperty[] r7 = com.bytedance.android.livesdk.gift.platform.core.a0.a;
        this.q = ((Boolean) r6.getValue(null, r7[3])).booleanValue();
        this.r = ((Boolean) com.bytedance.android.livesdk.gift.platform.core.a0.f.getValue(null, r7[4])).booleanValue();
        ((Boolean) com.bytedance.android.livesdk.gift.platform.core.a0.g.getValue(null, r7[5])).booleanValue();
        this.v = com.bytedance.android.livesdk.gift.platform.business.i.j();
        com.bytedance.android.livesdk.gift.configmodel.m r8 = com.bytedance.android.livesdk.gift.platform.business.i.i();
        this.y = r8;
        this.B = r8.V1();
        this.z = com.bytedance.android.livesdk.gift.platform.business.i.h();
        this.A = com.bytedance.android.livesdk.gift.platform.business.i.e();
        AssetsUtils.a = -1;
        AssetsUtils.b = ((Boolean) com.bytedance.android.livesdk.gift.platform.core.a0.m.getValue(null, r7[11])).booleanValue();
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L39;
        return;
    L39:
        if (com.bytedance.android.livesdk.gift.platform.core.z.a() == false) goto L58;
        f02.a.C0229a r9 = f02.a.h;
        Context r10 = com.bytedance.android.live.core.utils.s1.getContext();
        r9.getClass();
        if (r10 != null) goto L44;
        return;
    L44:
        if (f02.a.g == true) goto L60;
        WindowManager r11 = (WindowManager) r10.getSystemService(WindowManager.class);
        f02.a r13 = f02.a.f;
        if (r13 != null) goto L50;
        f02.a.f = new f02.a(r10);
    L52:
        WindowManager.LayoutParams r14 = new WindowManager.LayoutParams(com.bytedance.android.live.core.utils.s1.f(100.0f), com.bytedance.android.live.core.utils.s1.f(100.0f));
        r14.width = -2;
        r14.height = -2;
        r14.x = 0;
        r14.y = 0;
        r14.gravity = 51;
        r14.type = 2038;
        r14.flags = 262184;
        f02.a r15 = f02.a.f;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r15, r14);
        r11.addView(r15, r14);
        f02.a.g = true;
        return;
    L50:
        if (r13.getParent() == null) goto L52;
        r11.removeView(f02.a.f);     // Catch: Exception -> L54
        goto L52
    L60:
        return;
    L58:
        return;
    L32:
        r5 = true;
        goto L33
    L19:
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.f r16 = this.l;
        if (r16 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mDownloadPolicyFactory");
    L22:
        r3 = r16.b(this);
        goto L23
    L12:
        if (com.bytedance.android.livesdk.gift.platform.business.i.f().Q1() == true) goto L15;
        r2 = false;
        goto L17
    L6:
        if (KmpEnv.a() == false) goto L8;
        r1 = new com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.h();
        goto L9
    L8:
        r1 = new com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.f();
        goto L9
    }

    public final void onStop() {
        this.w.clear();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.j
    public final void yj() {
        if (this.C == false) goto L8;
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r0 = GiftResourceManagerFactory.a();
        if (r0 == null) goto L9;
        r0.f();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager
    public final String vg() {
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r0 = GiftResourceManagerFactory.a();
        if (r0 == null) goto L7;
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a r1 = r0.a();
        if (r1 == null) goto L7;
        return r1.a();
    L7:
        return null;
    }

    public static long w0(long r7) {
        iz0.a r0 = com.bytedance.android.livesdk.gift.platform.core.keva_store.a.a;
        iz0.a r2 = com.bytedance.android.livesdk.gift.platform.core.keva_store.a.a;
        long r3 = CastLongProtector.parseLong(r2.d("repeat_download_time_" + r7, "0")) + 1;
        r2.a("repeat_download_time_" + r7, String.valueOf(r3));
        return r3;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager, com.bytedance.android.livesdk.gift.platform.business.effect.assets.j
    public final String D1(long r3) {
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d r0 = this.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAssetsManagerSupport");
    L5:
        c12.e r4 = r0.c(G1(r3), 0);
        if (r4 != null) goto L10;
        return null;
    L10:
        return r4.k;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager, com.bytedance.android.livesdk.gift.platform.business.effect.assets.j
    public final com.bytedance.android.live.core.resources.e G1(long r7) {
        if (I().d0() == false) goto L10;
        com.bytedance.android.live.core.resources.e r0 = this.i.get(r7);
        if (r0 == null) goto L7;
        return r0;
    L7:
        com.bytedance.android.live.core.resources.e r1 = this.h.get(r7);
        if (r1 == null) goto L10;
        return r1;
    L10:
        com.bytedance.android.live.core.resources.e r2 = this.c.get(r7);
        if (r2 == null) goto L13;
        return r2;
    L13:
        CopyOnWriteArrayList<com.bytedance.android.live.core.resources.e> r3 = this.b;
        if (r3 != null) goto L16;
        return null;
    L16:
        Iterator<com.bytedance.android.live.core.resources.e> r4 = r3.iterator();
    L18:
        if (r4.hasNext() == false) goto L43;
        com.bytedance.android.live.core.resources.e r5 = r4.next();
        if (r5.getId() != r7) goto L18;
        boolean r8 = AssetsUtils.b;
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L34;
        yz0.k r9 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r9 == null) goto L34;
        if (r9.isLiveTypeSandbox() == true) goto L34;
        com.bytedance.android.live.core.resources.f r10 = r5.castToOrNull(com.bytedance.android.live.core.resources.f.class);
        if (r10 == null) goto L34;
        boolean r11 = true;
        if (r10.isTest() != true) goto L34;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.a.m.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[11])).booleanValue() == false) goto L34;
    L35:
        if (r11 == false) goto L38;
        return null;
    L38:
        return r5;
    L34:
        r11 = false;
        goto L35
    L43:
        return null;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager, com.bytedance.android.livesdk.gift.platform.business.effect.assets.j
    public final String H0(long r2) {
        return gn(r2, this.g.H7());
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager
    public final boolean O9(com.bytedance.android.live.core.resources.e r3) {
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d r0 = this.m;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mAssetsManagerSupport");
    L6:
        return r0.d(r3);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager, com.bytedance.android.livesdk.gift.platform.business.effect.assets.j
    public final void T(IAssetsManager.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (((ArrayList) this.a).contains(r2) == true) goto L6;
        ((ArrayList) this.a).add(r2);
        return;
    }

    public final void b0(com.bytedance.android.live.core.resources.e r2) {
        if (r2 == null) goto L21;
        r2.setCdnDomainOpt(this.z.C7());
        if (r2.getH265ResourceModel() == null) goto L11;
        com.bytedance.android.live.core.resources.j r3 = r2.getH265ResourceModel();
        if (r3 == null) goto L22;
        com.bytedance.android.live.core.resources.l r4 = r3.getResourceModel();
        if (r4 == null) goto L23;
        com.bytedance.android.live.core.resources.m.a(r4);
        return;
    L23:
        return;
    L22:
        return;
    L11:
        if (r2.getH265SuperResourceModel() == null) goto L17;
        com.bytedance.android.live.core.resources.j r5 = r2.getH265ResourceModel();
        if (r5 == null) goto L25;
        com.bytedance.android.live.core.resources.l r6 = r5.getResourceModel();
        if (r6 == null) goto L26;
        com.bytedance.android.live.core.resources.m.a(r6);
        return;
    L26:
        return;
    L25:
        return;
    L17:
        com.bytedance.android.live.core.resources.l r7 = r2.getResourceModel();
        if (r7 == null) goto L28;
        com.bytedance.android.live.core.resources.m.a(r7);
        return;
    L28:
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager
    public final void cb(String r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        AssetsUtils.c(r1);
    }

    public final void e1(List<? extends com.bytedance.android.live.core.resources.e> r3) {
        if (this.y.k9() == true) goto L6;
        return;
    L6:
        if (Lists.isEmpty(r3) == false) goto L8;
        return;
    L8:
        Single.just(1).observeOn(Schedulers.io()).subscribe(new o(this, r3), com.bytedance.android.live.revenue.common.h0.a);
    }

    public final boolean f0(com.bytedance.android.live.core.resources.e r5) {
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d r0 = this.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAssetsManagerSupport");
    L5:
        boolean r1 = r0.a(r5);
        if (r5 != null) goto L8;
    L17:
        if (r5 != null) goto L19;
        return r1;
    L19:
        if (r5.getResourceType() == 8) goto L21;
        return r1;
    L21:
        if (r5.getLokiExtraModel() != null) goto L23;
        return r1;
    L23:
        if (r5.getLokiExtraModel() == null) goto L25;
        boolean r6 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.effect.c.class).he(r5);
    L26:
        if (r1 == false) goto L29;
        if (r6 == false) goto L29;
    L28:
        return true;
    L29:
        return false;
    L25:
        r6 = true;
        goto L26
    L8:
        if (r5.getResourceType() != 5) goto L17;
        if (r5.getModelRequirements() == null) goto L17;
        List r2 = r5.getModelRequirements();
        Intrinsics.checkNotNull(r2);
        if ((!r2.isEmpty()) == false) goto L17;
        IRevBroadcastService r3 = vh6.c.b(IRevBroadcastService.class);
        List r7 = r5.getModelRequirements();
        Intrinsics.checkNotNull(r7);
        boolean r8 = r3.Li(r7);
        if (r1 == false) goto L29;
        if (r8 == false) goto L29;
        goto L29
    }

    public final void g(int r5) {
        if (r5 == 1) goto L5;
    L7:
        long r0 = (System.currentTimeMillis() - this.E) / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        if (this.i.size() > 0) goto L10;
        return;
    L10:
        if (r0 <= I().O0()) goto L14;
        this.i.clear();
        this.E = System.currentTimeMillis();
        return;
    L14:
        return;
    L5:
        if (this.i.size() <= I().E4()) goto L7;
        this.i.clear();
        this.E = System.currentTimeMillis();
        goto L7
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager, com.bytedance.android.livesdk.gift.platform.business.effect.assets.j
    public final boolean g1(long r2) {
        com.bytedance.android.live.core.resources.e r0 = G1(r2);
        if (r0 != null) goto L6;
        p0(r2);
    L6:
        return f0(r0);
    }

    public final void h(List<Long> r7) {
        Intrinsics.checkNotNullParameter(r7, "showGiftAssetId");
        if (com.bytedance.android.livesdk.gift.platform.business.i.f().S2() == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
        return;
    L11:
        boolean r1 = AssetsUtils.b;
        if (AssetsUtils.b(com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.h()) == false) goto L14;
        return;
    L14:
        ArrayList r2 = new ArrayList();
        Iterator<T> r8 = r7.iterator();
    L16:
        if (r8.hasNext() == false) goto L20;
        Object r3 = r8.next();
        long r4 = ((Number) r3).longValue();
        if ((!((ArrayList) this.t).contains(Long.valueOf(r4))) == false) goto L16;
        r2.add(r3);
        goto L16
    L20:
        ArrayList r9 = new ArrayList();
        Iterator r5 = r2.iterator();
    L22:
        if (r5.hasNext() == false) goto L26;
        com.bytedance.android.live.core.resources.e r6 = G1(((Number) r5.next()).longValue());
        if (r6 == null) goto L22;
        r9.add(r6);
        goto L22
    L26:
        List<com.bytedance.android.live.core.resources.e> r10 = x(r9);
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e r11 = this.f;
        if (r11 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("downloadPolicy");
    L29:
        r11.f(CollectionsKt.toMutableList(r10), com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.h());
        return;
    L5:
        if (com.bytedance.android.livesdk.gift.platform.business.i.f().Q1() == true) goto L8;
        r0 = false;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager, com.bytedance.android.livesdk.gift.platform.business.effect.assets.j
    public final void l0(IAssetsManager.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (((ArrayList) this.a).contains(r2) == false) goto L6;
        ((ArrayList) this.a).remove(r2);
        return;
    }

    public final void p0(long r13) {
        if (this.k > 0) goto L5;
        return;
    L5:
        if (((Boolean) this.G.getValue()).booleanValue() == true) goto L7;
        return;
    L7:
        if (r13 > 0) goto L9;
        return;
    L9:
        if (I().d0() == false) goto L11;
        int r6 = this.h.size();
        int r8 = this.i.size();
        String r7 = this.j;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.u(r13, r6, r7, r8, r6 + r8, this.k);
        return;
    L11:
        com.bytedance.android.livesdk.gift.platform.core.utils.h.u(r13, 0, "0", 0, this.c.size(), this.k);
    }

    public final List<com.bytedance.android.live.core.resources.e> x(List<? extends com.bytedance.android.live.core.resources.e> r13) {
        ArrayList r0 = new ArrayList();
        if (this.y.G6().getEnable() == true) goto L6;
        r0.addAll(r13);
        return r0;
    L6:
        ResourceRecordService r1 = (ResourceRecordService) com.bytedance.android.live.revenue.core.util.f.a(ResourceRecordService.class);
        ArrayList r2 = new ArrayList();
        if (r1.g().G6().getEnable() == false) goto L14;
        com.bytedance.live.kmp.util.c r3 = com.bytedance.live.kmp.util.c.a;
        long r4 = System.currentTimeMillis() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        Iterator<Map.Entry<String, Long>> r5 = r1.a.entrySet().iterator();
    L10:
        if (r5.hasNext() == false) goto L14;
        Map.Entry<String, Long> r6 = r5.next();
        String r7 = r6.getKey();
        if ((r4 - r6.getValue().longValue()) >= r1.g().G6().getExpireTime()) goto L10;
        r2.add(r7);
    L14:
        jy0.b.c("GiftAssetClean", "黑名单内容: " + r2, null, 4);
        Boolean r8 = (Boolean) r1.d.getValue();
        if (r8 == null) goto L17;
        boolean r9 = r8.booleanValue();
    L18:
        Iterator r14 = ((ArrayList) r13).iterator();
    L20:
        if (r14.hasNext() == false) goto L43;
        com.bytedance.android.live.core.resources.e r10 = (com.bytedance.android.live.core.resources.e) r14.next();
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d r11 = this.m;
        if (r11 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mAssetsManagerSupport");
    L24:
        c12.e r15 = r11.c(r10, 0);
        if (r15 == null) goto L27;
        String r16 = r15.k;
    L29:
        if (by0.b.a(r16) == false) goto L42;
        if (r10.getDownloadType() != 4) goto L34;
        if (r9 == false) goto L20;
    L34:
        if (r15 == null) goto L36;
        String r17 = r15.k;
    L38:
        if (CollectionsKt.contains(r2, r17) == false) goto L42;
        if (r10.getDownloadType() == 1) goto L42;
    L36:
        r17 = null;
    L42:
        r0.add(r10);
        goto L20
    L27:
        r16 = null;
        goto L29
    L43:
        return r0;
    L17:
        r9 = false;
        goto L18
    }

    public AssetsService(ResourceRecordService r24, AssetsDownloadPolicyService r25) {
        Intrinsics.checkNotNullParameter(r24, "resourceRecordService");
        Intrinsics.checkNotNullParameter(r25, "assetsDownloadPolicyService");
        this.J = r24;
        this.K = r25;
        this.a = new ArrayList();
        new ArrayList();
        this.b = new CopyOnWriteArrayList();
        this.c = new LongSparseArray();
        this.d = new JSONObject();
        this.g = com.bytedance.android.livesdk.gift.platform.business.i.a();
        this.h = new LongSparseArray();
        this.i = new LongSparseArray();
        this.j = "0";
        this.s = AssetsUtils.b(false);
        this.t = new ArrayList();
        this.u = new ConcurrentHashMap();
        this.w = new CompositeDisposable();
        this.x = new ArrayList();
        Class r2 = com.bytedance.android.livesdk.gift.configmodel.m.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r3 = vh7.b.a;
        Object r4 = r3.get(r2);
        if (r4 != null) goto L12;
        r4 = r2.getConstructor(new Class[0]);
        if (r4 == null) goto L11;
        Object r5 = r3.putIfAbsent(r2, r4);
        if (r5 == null) goto L12;
        r4 = r5;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r6 = ((SerializableObjectJsonAdapterBase) ((Constructor) r4).newInstance(new Object[0])).createInstance();
        if (r6 == null) goto L59;
        this.y = (com.bytedance.android.livesdk.gift.configmodel.m) r6;
        Class r7 = com.bytedance.android.livesdk.gift.configmodel.i0.class.getAnnotation(JsonAdapter.class).value();
        Object r8 = r3.get(r7);
        if (r8 != null) goto L24;
        r8 = r7.getConstructor(new Class[0]);
        if (r8 == null) goto L23;
        Object r9 = r3.putIfAbsent(r7, r8);
        if (r9 == null) goto L24;
        r8 = r9;
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L24:
        Object r10 = ((SerializableObjectJsonAdapterBase) ((Constructor) r8).newInstance(new Object[0])).createInstance();
        if (r10 == null) goto L57;
        this.z = (com.bytedance.android.livesdk.gift.configmodel.i0) r10;
        Class r11 = com.bytedance.android.livesdk.gift.configmodel.h.class.getAnnotation(JsonAdapter.class).value();
        Object r13 = r3.get(r11);
        if (r13 != null) goto L36;
        r13 = r11.getConstructor(new Class[0]);
        if (r13 == null) goto L35;
        Object r14 = r3.putIfAbsent(r11, r13);
        if (r14 == null) goto L36;
        r13 = r14;
        goto L36
    L35:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L36:
        Object r15 = ((SerializableObjectJsonAdapterBase) ((Constructor) r13).newInstance(new Object[0])).createInstance();
        if (r15 == null) goto L55;
        this.A = (com.bytedance.android.livesdk.gift.configmodel.h) r15;
        Class r16 = com.bytedance.android.livesdk.gift.configmodel.q.class.getAnnotation(JsonAdapter.class).value();
        Object r17 = r3.get(r16);
        if (r17 != null) goto L48;
        r17 = r16.getConstructor(new Class[0]);
        if (r17 == null) goto L47;
        Object r18 = r3.putIfAbsent(r16, r17);
        if (r18 == null) goto L48;
        r17 = r18;
        goto L48
    L47:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L48:
        Object r1 = ((SerializableObjectJsonAdapterBase) ((Constructor) r17).newInstance(new Object[0])).createInstance();
        if (r1 == null) goto L53;
        this.B = (com.bytedance.android.livesdk.gift.configmodel.q) r1;
        ReadOnlyProperty r19 = com.bytedance.android.livesdk.gift.platform.business.i.j;
        KProperty[] r20 = com.bytedance.android.livesdk.gift.platform.business.i.a;
        this.C = ((Boolean) r19.getValue(null, r20[8])).booleanValue();
        this.D = ((Boolean) com.bytedance.android.livesdk.gift.platform.business.i.k.getValue(null, r20[9])).booleanValue();
        this.F = LazyKt.lazy(AssetsService$assetSplitOpt$2.INSTANCE);
        this.G = LazyKt.lazy(AssetsService$assetFindFailReport$2.INSTANCE);
        this.H = LazyKt.lazy(AssetsService$addHeaderEnable$2.INSTANCE);
        this.I = LazyKt.lazy(AssetsService$storageWriteScheduler$2.INSTANCE);
        new String[]{"yuv", "NailSLAM_jni", "ttffmpeg", "c++_shared", "AGFX", "bytenn", "audioeffect", "byteaudio", "gaia_lib", "effect"};
        new String[]{"yuv", "NailSLAM_jni", "ttffmpeg", "c++_shared", "AGFX", "bytenn", "IESSaliency", "audioeffect", "byteaudio", "gaia_lib", "effect"};
        new String[]{"yuv", "NailSLAM_jni", "ttffmpeg", "c++_shared", "AGFX", "bytenn", "IESSaliency", "audioeffect", "gaia_lib", "effect"};
        return;
    L53:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.DeviceStorageSetting");
    L55:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.AssetServiceOpt");
    L57:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.GiftImageCdnOpt");
    L59:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.CleanStrategyConfig");
    }

    public static List A(List r4, List r5) {
        ArrayList r0 = new ArrayList();
        Iterator r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        com.bytedance.android.live.core.resources.e r1 = (com.bytedance.android.live.core.resources.e) r6.next();
        ArrayList r3 = (ArrayList) r5;
        if (r3.contains(Long.valueOf(r1.getId())) == true) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.j
    public final boolean Re(com.bytedance.android.live.core.resources.e r2, int r3) {
        return ib(r2, null, r3, null);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager
    public final void T2(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "traceFlag");
        List<String> r0 = w12.a.a;
        w12.a.e = this.z.T0();
        L0(r2, false, r3);
    }

    public final void f1(int r3, boolean r4) {
        if (r3 == 1006) goto L5;
        return;
    L5:
        if (((ArrayList) this.x).isEmpty() == true) goto L21;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e r0 = this.f;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("downloadPolicy");
    L10:
        if (r0 != null) goto L12;
        return;
    L12:
        if (AssetsUtils.b(r4) == true) goto L20;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e r1 = this.f;
        if (r1 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("downloadPolicy");
    L16:
        r1.g(this.x, r3, r4);
        return;
    L20:
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager
    public final String gn(long r13, boolean r14) {
        com.bytedance.android.live.core.resources.e r0 = G1(r13);
        String r1 = null;
        if (r0 != null) goto L6;
        p0(r13);
        return null;
    L6:
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d r2 = this.m;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mAssetsManagerSupport");
    L9:
        c12.e r3 = r2.c(r0, 0);
        if (r3 != null) goto L12;
        return null;
    L12:
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r4 = GiftResourceManagerFactory.a();
        if (r4 == null) goto L16;
        r1 = r4.h(r3, r14);
    L16:
        if (by0.b.a(r1) == false) goto L22;
        ResourceRecordService r5 = this.J;
        String r6 = r3.k;
        long r7 = com.bytedance.live.kmp.util.e.b() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        com.bytedance.android.live.core.resources.b r15 = r0.getCleanStrategy();
        if (r15 == null) goto L20;
        long r8 = r15.getKeepAliveTime();
    L21:
        ResourceRecordService.b0(r5, r6, r7, r13, r8);
        goto L22
    L20:
        r8 = 0;
    L22:
        return r1;
    }

    public final void L0(int r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "traceFlag");
        List<String> r0 = w12.a.a;
        w12.a.e = this.z.T0();
        if (I().d0() == false) goto L5;
        X0(r3, r4, BuildConfig.FLAVOR, r5);
        return;
    L5:
        T0(r3, r4, BuildConfig.FLAVOR, r5);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager
    public final boolean Ne(com.bytedance.android.live.core.resources.e r2, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r3, int r4) {
        return ib(r2, r3, r4, null);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager
    public final boolean j4(long r2, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r4, int r5) {
        com.bytedance.android.live.core.resources.e r0 = G1(r2);
        if (r0 != null) goto L6;
        p0(r2);
    L6:
        return ib(r0, r4, r5, null);
    }

    public final void S0(int r3, boolean r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "traceFlag");
        List<String> r0 = w12.a.a;
        w12.a.e = this.z.T0();
        if (I().d0() == false) goto L7;
        if (r5 != null) goto L6;
        r5 = BuildConfig.FLAVOR;
    L6:
        X0(r3, r4, r5, r6);
        return;
    L7:
        if (r5 != null) goto L9;
        r5 = BuildConfig.FLAVOR;
    L9:
        T0(r3, r4, r5, r6);
    }

    public final void T0(int r24, boolean r25, String r26, String r27) {
        if (com.bytedance.android.livesdk.gift.platform.business.effect.b.a() == false) goto L5;
        String r0 = "1";
    L6:
        String r8 = r0;
        if (r25 == true) goto L15;
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r1 = GiftResourceManagerFactory.a();
        if (r1 == null) goto L11;
        r1.i(com.bytedance.android.livesdk.gift.platform.business.i.c().F3());
    L11:
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r2 = GiftResourceManagerFactory.a();
        if (r2 == null) goto L15;
        r2.d(com.bytedance.android.livesdk.gift.platform.business.i.c().b8());
    L15:
        if (this.d.length() >= 500) goto L20;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.e r3 = this.f;
        if (r3 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("downloadPolicy");
    L19:
        r3.a(this.d);
    L20:
        String r4 = this.d.toString();
        JSONObject r5 = new JSONObject();
        if (this.B.getEnable() == false) goto L37;
        i12.e r6 = i12.o.b();
        if (r6 == null) goto L25;
        Object r7 = com.bytedance.android.scope.m.e.d(r6, StorageService.class);
    L26:
        StorageService r9 = (StorageService) r7;
        if (r9 == null) goto L29;
        r9.a();
        long r10 = r9.a;
    L30:
        int r11 = this.B.v0().size();
        int r13 = 0;
    L31:
        if (r13 >= r11) goto L37;
        if (r10 >= ((Number) ListProtector.get(this.B.v0(), r13)).longValue()) goto L35;
        r5.put("available_disk_rank", r13);
    L35:
        r13 = r13 + 1;
        goto L31
    L29:
        r10 = 0;
        goto L30
    L25:
        r7 = null;
    L37:
        if (this.z.C7() == true) goto L39;
    L41:
        int r14 = 0;
    L42:
        android.util.Pair<String, String> r15 = E();
        tz0.b r16 = tz0.b.a;
        uz0.e r17 = new uz0.e();
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "$this$beforeConfigureRequest");
        uz0.f r18 = new uz0.f(((uz0.a) r17).b);
        r18.a("download_assets_from", Integer.valueOf(r24).toString());
        r18.a("asset_265_supported", r8);
        r18.a("is_living", String.valueOf(r25));
        Integer r19 = 1;
        r18.a("enable_effect_list_new", r19.toString());
        r18.a("local_asset_info", r4);
        if (r26.length() <= 0) goto L45;
        boolean r20 = true;
    L46:
        if (r20 != true) goto L48;
        r18.a("room_id", r26);
    L48:
        r18.a("device_ctx", r5.toString());
        r18.a("image_template_type", Integer.valueOf(r14).toString());
        if (r15 == null) goto L51;
        Map r21 = ((uz0.a) r17).a;
        Intrinsics.checkNotNullParameter(r21, "headersMap");
        String r23 = (String) r15.first;
        String r28 = (String) r15.second;
        Intrinsics.checkNotNullParameter(r23, "$this$setTo");
        Intrinsics.checkNotNullParameter(r28, "value");
        r21.put(r23, r28);
    L51:
        Intrinsics.checkNotNullParameter(r17, "$this$afterConfigureRequest");
        Observable r29 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(INetworkService.Biz.Revenue, "/webcast/assets/effects/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.livesdk.gift.model.d.class)), Extra.class, ((uz0.a) r17).d, ((uz0.a) r17).a, ((uz0.a) r17).b, ((uz0.a) r17).c, r17.e, r17.f, r17.g);
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.d r30 = new com.bytedance.android.livesdk.gift.platform.business.effect.assets.d(0);
        long r110 = System.currentTimeMillis();
        this.e = r29.subscribeOn(Schedulers.io()).doOnNext(new i(this, r24, r110, r30)).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this, r24, r110, r14, r27, r30, r8, r25), new k(this, r24));
        return;
    L45:
        r20 = false;
        goto L46
    L39:
        if (w12.a.d == false) goto L41;
        r14 = 1;
        goto L42
    L5:
        r0 = "0";
        goto L6
    }

    public final void X0(int r25, boolean r26, String r27, String r28) {
        if (com.bytedance.android.livesdk.gift.platform.business.effect.b.a() == false) goto L5;
        String r0 = "1";
    L6:
        String r9 = r0;
        if (r26 == true) goto L14;
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r1 = GiftResourceManagerFactory.a();
        if (r1 == null) goto L11;
        r1.i(com.bytedance.android.livesdk.gift.platform.business.i.c().F3());
    L11:
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r2 = GiftResourceManagerFactory.a();
        if (r2 == null) goto L14;
        r2.d(com.bytedance.android.livesdk.gift.platform.business.i.c().b8());
    L14:
        JSONObject r3 = new JSONObject();
        if (this.B.getEnable() == false) goto L31;
        i12.e r4 = i12.o.b();
        if (r4 == null) goto L19;
        Object r5 = com.bytedance.android.scope.m.e.d(r4, StorageService.class);
    L20:
        StorageService r6 = (StorageService) r5;
        if (r6 == null) goto L23;
        r6.a();
        long r7 = r6.a;
    L24:
        int r8 = this.B.v0().size();
        int r10 = 0;
    L25:
        if (r10 >= r8) goto L31;
        if (r7 >= ((Number) ListProtector.get(this.B.v0(), r10)).longValue()) goto L29;
        r3.put("available_disk_rank", r10);
    L29:
        r10 = r10 + 1;
        goto L25
    L23:
        r7 = 0;
        goto L24
    L19:
        r5 = null;
    L31:
        if (this.z.C7() == true) goto L33;
    L35:
        int r11 = 0;
    L36:
        android.util.Pair<String, String> r13 = E();
        tz0.b r14 = tz0.b.a;
        uz0.e r15 = new uz0.e();
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "$this$beforeConfigureRequest");
        uz0.f r16 = new uz0.f(((uz0.a) r15).b);
        r16.a("download_assets_from", Integer.valueOf(r25).toString());
        r16.a("asset_265_supported", r9);
        r16.a("is_living", String.valueOf(r26));
        Integer r17 = 1;
        r16.a("enable_effect_list_new", r17.toString());
        if (r27.length() <= 0) goto L39;
        boolean r18 = true;
    L40:
        if (r18 != true) goto L42;
        r16.a("room_id", r27);
    L42:
        r16.a("device_ctx", r3.toString());
        r16.a("image_template_type", Integer.valueOf(r11).toString());
        r16.a("asset_meta_base_version", this.j);
        if (r13 == null) goto L45;
        Map r19 = ((uz0.a) r15).a;
        Intrinsics.checkNotNullParameter(r19, "headersMap");
        String r20 = (String) r13.first;
        String r21 = (String) r13.second;
        Intrinsics.checkNotNullParameter(r20, "$this$setTo");
        Intrinsics.checkNotNullParameter(r21, "value");
        r19.put(r20, r21);
    L45:
        Intrinsics.checkNotNullParameter(r15, "$this$afterConfigureRequest");
        Observable r23 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(INetworkService.Biz.Revenue, "/webcast/assets/effects/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.livesdk.gift.model.d.class)), Extra.class, ((uz0.a) r15).d, ((uz0.a) r15).a, ((uz0.a) r15).b, ((uz0.a) r15).c, r15.e, r15.f, r15.g);
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.d r24 = new com.bytedance.android.livesdk.gift.platform.business.effect.assets.d(0);
        long r29 = System.currentTimeMillis();
        this.e = r23.subscribeOn(Schedulers.io()).doOnNext(new l(this, r29, r25)).observeOn(AndroidSchedulers.mainThread()).subscribe(new m(this, r24, r26, r25, r29, r11, r28, r9), new n(this, r25));
        return;
    L39:
        r18 = false;
        goto L40
    L33:
        if (w12.a.d == false) goto L35;
        r11 = 1;
        goto L36
    L5:
        r0 = "0";
        goto L6
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager
    public final void d4(int r2, boolean r3, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r6, "traceFlag");
        ArrayList r0 = new ArrayList();
        r0.add(Long.valueOf(r4));
        ji(r2, r3, r0, r6);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.j
    public final boolean ib(com.bytedance.android.live.core.resources.e r23, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r24, int r25, AssetDownloadPriority r26) {
        if (r23 != null) goto L7;
        if (r24 == null) goto L6;
        r24.onFailed(new Exception("can‘t find assets"));
    L6:
        return false;
    L7:
        long r6 = System.currentTimeMillis();
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d r1 = this.m;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mAssetsManagerSupport");
    L10:
        c12.e r13 = r1.c(r23, r25);
        if (r13 != null) goto L15;
        if (r24 == null) goto L14;
        r24.onFailed(new Exception("AssetsManager.downloadAssets: GetResourceRequest is null"));
    L14:
        return false;
    L15:
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r2 = GiftResourceManagerFactory.a();
        if (r2 != null) goto L18;
    L20:
        boolean r14 = false;
    L21:
        if (r24 == null) goto L24;
        r24.b(r14);
    L24:
        if (this.A.O2() == false) goto L27;
        this.w.add(Completable.fromAction(new b(r13)).subscribeOn((Scheduler) this.I.getValue()).subscribe());
    L31:
        if (r25 == 4) goto L37;
        if (r25 == 1000) goto L37;
        if (r25 == 1010) goto L37;
        boolean r3 = false;
    L38:
        r13.a = r3;
        r13.d = IAssetsManager.a.a(r26, r25).getPriority();
        String r4 = r13.k;
        if (r4 == null) goto L41;
        this.J.x(r4, false, r23.getId());
    L41:
        if (r14 == true) goto L43;
    L53:
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r15 = GiftResourceManagerFactory.a();
        if (r15 == null) goto L56;
        r15.c(r13, new d(this, r23, r14, r13, r25, r6, r24));
    L56:
        if (r14 == true) goto L70;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.d.g.getClass();
        boolean r0 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.d.d;
        if (r0 == false) goto L60;
        boolean r5 = this.s;
    L61:
        if (r5 == false) goto L64;
        jy0.b.a("AssetsUtils", "resource: " + r23.getId() + "has not downloaded before since hit delay downloads policy");
    L64:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.d.e == true) goto L70;
        com.bytedance.android.livesdk.gift.platform.core.c0 r7 = com.bytedance.android.livesdk.gift.platform.core.c0.a;
        long r8 = r23.getId();
        if (r0 == false) goto L68;
        boolean r9 = this.s;
    L69:
        String r16 = com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_gift_asset_download_source");
        JSONObject r18 = new JSONObject();
        JSONObject r10 = new JSONObject();
        JSONObject r11 = new JSONObject();
        Intrinsics.checkNotNullParameter(r11, "extra");
        Intrinsics.checkNotNullParameter(r10, "metric");
        EventModule r17 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r17, "eventModule");
        String r19 = r17.getValue();
        Intrinsics.checkNotNullParameter(r11, "map");
        Long r20 = Long.valueOf(r8);
        Intrinsics.checkNotNullParameter("asset_id", "key");
        Intrinsics.checkNotNullParameter(r20, "value");
        r11.put("asset_id", r20);
        Integer r21 = Integer.valueOf(r25);
        Intrinsics.checkNotNullParameter("source_type", "key");
        Intrinsics.checkNotNullParameter(r21, "value");
        r11.put("source_type", r21);
        Boolean r27 = Boolean.valueOf(r9);
        Intrinsics.checkNotNullParameter("is_delay_download", "key");
        Intrinsics.checkNotNullParameter(r27, "value");
        r11.put("is_delay_download", r27);
        cy0.e.a.getClass();
        cy0.j r28 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r29 = com.bytedance.android.scope.m.b(r28).b(n97.a.class);
        Intrinsics.checkNotNull(r29);
        ((com.bytedance.live.kmp.core.c) r29).g(r16, r19, "bussiness_api_call", r18, r10, r11);
        goto L70
    L68:
        boolean r30 = AssetsUtils.b;
        r9 = AssetsUtils.b(g02.a.e());
        goto L69
    L60:
        boolean r31 = AssetsUtils.b;
        r5 = AssetsUtils.b(g02.a.e());
    L70:
        return r14;
    L43:
        if (r25 == 3) goto L47;
        if (r25 == 2) goto L47;
    L48:
        ResourceRecordService r110 = this.J;
        String r111 = r13.k;
        long r112 = com.bytedance.live.kmp.util.e.b() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        long r113 = r23.getId();
        com.bytedance.android.live.core.resources.b r33 = r23.getCleanStrategy();
        if (r33 == null) goto L51;
        long r34 = r33.getKeepAliveTime();
    L52:
        ResourceRecordService.b0(r110, r111, r112, r113, r34);
        goto L53
    L51:
        r34 = 0;
    L47:
        if (r23.getDownloadType() != 1) goto L53;
    L37:
        r3 = true;
        goto L38
    L27:
        if (this.v == false) goto L29;
        this.w.add(Completable.complete().observeOn(Schedulers.single()).subscribe(new c(r13)));
        goto L31
    L29:
        iz0.a r35 = com.bytedance.android.livesdk.gift.platform.core.keva_store.a.a;
        com.bytedance.android.livesdk.gift.platform.core.keva_store.a.d(r13.k, System.currentTimeMillis() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW));
        goto L31
    L18:
        if (r2.e(r13) != true) goto L20;
        r14 = true;
        goto L21
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager
    public final void ji(int r24, boolean r25, List<Long> r26, String r27) {
        Intrinsics.checkNotNullParameter(r27, "traceFlag");
        List<String> r0 = w12.a.a;
        w12.a.e = this.z.T0();
        long r5 = System.currentTimeMillis();
        if (com.bytedance.android.livesdk.gift.platform.business.effect.b.a() == false) goto L5;
        String r1 = "1";
    L6:
        String r8 = r1;
        if (r26 == null) goto L10;
        String r2 = r26.toString();
        if (r2 == null) goto L10;
    L11:
        JSONObject r3 = new JSONObject();
        if (this.B.getEnable() == false) goto L28;
        i12.e r4 = i12.o.b();
        if (r4 == null) goto L16;
        Object r6 = com.bytedance.android.scope.m.e.d(r4, StorageService.class);
    L17:
        StorageService r7 = (StorageService) r6;
        if (r7 == null) goto L20;
        r7.a();
        long r9 = r7.a;
    L21:
        int r10 = this.B.v0().size();
        int r11 = 0;
    L22:
        if (r11 >= r10) goto L28;
        if (r9 >= ((Number) ListProtector.get(this.B.v0(), r11)).longValue()) goto L26;
        r3.put("available_disk_rank", r11);
    L26:
        r11 = r11 + 1;
        goto L22
    L20:
        r9 = 0;
        goto L21
    L16:
        r6 = null;
    L28:
        if (r24 != 1008) goto L30;
    L33:
        int r13 = 4;
    L34:
        android.util.Pair<String, String> r14 = E();
        tz0.b r15 = tz0.b.a;
        uz0.e r16 = new uz0.e();
        r15.getClass();
        Intrinsics.checkNotNullParameter(r16, "$this$beforeConfigureRequest");
        Map r17 = ((uz0.a) r16).b;
        Intrinsics.checkNotNullParameter(r17, "queriesMap");
        String r18 = Integer.valueOf(r13).toString();
        Intrinsics.checkNotNullParameter("download_assets_from", "$this$setTo");
        if (r18 == null) goto L37;
        r17.put("download_assets_from", r18);
    L37:
        Intrinsics.checkNotNullParameter("required_asset_ids", "$this$setTo");
        r17.put("required_asset_ids", r2);
        Intrinsics.checkNotNullParameter("asset_265_supported", "$this$setTo");
        r17.put("asset_265_supported", r8);
        String r19 = String.valueOf(r25);
        Intrinsics.checkNotNullParameter("is_living", "$this$setTo");
        if (r19 == null) goto L40;
        r17.put("is_living", r19);
    L40:
        String r20 = r3.toString();
        Intrinsics.checkNotNullParameter("device_ctx", "$this$setTo");
        if (r20 == null) goto L43;
        r17.put("device_ctx", r20);
    L43:
        if (r14 == null) goto L45;
        Map r21 = ((uz0.a) r16).a;
        Intrinsics.checkNotNullParameter(r21, "headersMap");
        String r23 = (String) r14.first;
        String r28 = (String) r14.second;
        Intrinsics.checkNotNullParameter(r23, "$this$setTo");
        Intrinsics.checkNotNullParameter(r28, "value");
        r21.put(r23, r28);
    L45:
        Intrinsics.checkNotNullParameter(r16, "$this$afterConfigureRequest");
        this.e = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(INetworkService.Biz.Revenue, "/webcast/assets/effects/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.livesdk.gift.model.d.class)), Extra.class, ((uz0.a) r16).d, ((uz0.a) r16).a, ((uz0.a) r16).b, ((uz0.a) r16).c, r16.e, r16.f, r16.g).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this, r13, r26, r24, r5, r27, r8), new h(this));
        return;
    L30:
        if (r24 == 1007) goto L33;
        r13 = r24;
    L10:
        r2 = BuildConfig.FLAVOR;
        goto L11
    L5:
        r1 = "0";
        goto L6
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager, com.bytedance.android.livesdk.gift.platform.business.effect.assets.j
    public final boolean r0(long r2, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r4, int r5, AssetDownloadPriority r6) {
        com.bytedance.android.live.core.resources.e r0 = G1(r2);
        if (r0 != null) goto L6;
        p0(r2);
    L6:
        return ib(r0, r4, r5, r6);
    }

    public static final void a(AssetsService r16, com.bytedance.android.live.core.resources.e r17, com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r18, int r19, long r20, Exception r23) {
        r16.getClass();
        long r3 = System.currentTimeMillis() - r20;
        long r5 = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        int r4 = (int) (r3 / r5);
        String r6 = r18.k;
        Intrinsics.checkNotNullParameter(r6, "downloadedAssetMd5");
        if (r17 != null) goto L6;
    L28:
        int r1 = m02.d.a(r18.k, r17);
        long r7 = r17.getId();
        String r8 = String.valueOf(r17.getResourceType());
        String r9 = String.valueOf(r19);
        String r10 = String.valueOf(System.currentTimeMillis() - r20);
        String r11 = String.valueOf(r1);
        com.bytedance.android.live.core.resources.b r2 = r17.getCleanStrategy();
        if (r2 == null) goto L32;
        String r13 = r2.getAssetType();
        if (r13 == null) goto L32;
    L33:
        r16.K(r7, r8, r9, 1, r10, -1, r11, "0", r13, r17.getDownloadType());
        return;
    L32:
        r13 = BuildConfig.FLAVOR;
        goto L33
    L6:
        if ((r23 instanceof NetworkException) == false) goto L9;
        int r14 = 1;
    L23:
        int r15 = m02.d.a(r6, r17);
        com.bytedance.android.livesdk.gift.platform.core.c0 r21 = com.bytedance.android.livesdk.gift.platform.core.c0.a;
        long r110 = r17.getId();
        int r111 = r17.getResourceType();
        long r112 = r19;
        String r24 = String.valueOf(r23);
        JSONObject r25 = new JSONObject();
        com.bytedance.android.livesdk.gift.platform.core.c0.r(r25, "error_code", Integer.valueOf(r14));
        com.bytedance.android.livesdk.gift.platform.core.c0.r(r25, "error_msg", r24);
        com.bytedance.android.livesdk.gift.platform.core.c0.r(r25, "asset_id", Long.valueOf(r110));
        com.bytedance.android.livesdk.gift.platform.core.c0.r(r25, "asset_type", Integer.valueOf(r111));
        com.bytedance.android.livesdk.gift.platform.core.c0.r(r25, "download_total_time", Integer.valueOf(r4));
        com.bytedance.android.livesdk.gift.platform.core.c0.r(r25, "download_assets_from", Long.valueOf(r112));
        com.bytedance.android.livesdk.gift.platform.core.c0.r(r25, "video_asset_type", Integer.valueOf(r15));
        com.bytedance.android.livesdk.gift.platform.core.c0.r(r25, "asset_size", Float.valueOf(0.0f));
        com.bytedance.android.livesdk.gift.platform.core.c0.r(r25, "predownload_status", Integer.valueOf(((Number) com.bytedance.android.livesdk.gift.platform.core.a0.j.getValue(null, com.bytedance.android.livesdk.gift.platform.core.a0.a[8])).intValue()));
        if (r112 != r5) goto L26;
        com.bytedance.android.livesdk.gift.platform.core.c0.r(r25, "free_display", 1);
    L27:
        r21.o("ttlive_gift_asset_download_status", r25);
        goto L28
    L26:
        com.bytedance.android.livesdk.gift.platform.core.c0.r(r25, "free_display", 0);
        goto L27
    L9:
        if ((r23 instanceof WriteStorageException) == false) goto L12;
        r14 = 2;
        goto L23
    L12:
        if ((r23 instanceof Md5InvalidException) == false) goto L15;
        r14 = 3;
        goto L23
    L15:
        if ((r23 instanceof UnzipException) == false) goto L18;
        r14 = 4;
        goto L23
    L18:
        if ((r23 instanceof TTDownloadException) == false) goto L20;
        r14 = 5;
        goto L23
    L20:
        if (r23 == null) goto L22;
        r14 = com.bytedance.android.live.revenue.common.r0.a(r23);
        goto L23
    L22:
        r14 = -1;
        goto L23
    }

    public static final void f(AssetsService r21, com.bytedance.android.live.core.resources.e r23, com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r24, int r25, long r26, float r27) {
        r21.getClass();
        if (r24.g == true) goto L12;
        if (r25 == 3) goto L9;
        if (r25 != 2) goto L12;
    L9:
        if (r21.A.x3() == false) goto L12;
        return;
    L12:
        int r3 = m02.d.a(r24.k, r23);
        long r10 = System.currentTimeMillis() - r24.f;
        long r5 = System.currentTimeMillis() - r26;
        com.bytedance.android.livesdk.gift.platform.core.c0 r0 = com.bytedance.android.livesdk.gift.platform.core.c0.a;
        long r7 = r23.getId();
        int r1 = r23.getResourceType();
        long r13 = r25;
        String r15 = com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_gift_asset_download_status");
        JSONObject r18 = new JSONObject();
        JSONObject r9 = new JSONObject();
        JSONObject r14 = new JSONObject();
        Intrinsics.checkNotNullParameter(r14, "extra");
        Intrinsics.checkNotNullParameter(r9, "metric");
        EventModule r2 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r2, "eventModule");
        String r16 = r2.getValue();
        r9.put("status", String.valueOf(0));
        rz0.b r4 = new rz0.b(r14);
        r4.a("asset_id", Long.valueOf(r7));
        r4.a("asset_type", Integer.valueOf(r1));
        r4.a("download_total_time", Long.valueOf(r5));
        r4.a("download_assets_from", Long.valueOf(r13));
        r4.a("video_asset_type", Integer.valueOf(r3));
        r4.a("asset_size", Float.valueOf(r27));
        r4.a("predownload_status", Integer.valueOf(((Number) com.bytedance.android.livesdk.gift.platform.core.a0.j.getValue(null, com.bytedance.android.livesdk.gift.platform.core.a0.a[8])).intValue()));
        if (r13 != IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW) goto L15;
        r4.a("free_display", 1);
    L16:
        cy0.e.a.getClass();
        cy0.j r6 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r8 = com.bytedance.android.scope.m.b(r6).b(n97.a.class);
        Intrinsics.checkNotNull(r8);
        ((com.bytedance.live.kmp.core.c) r8).g(r15, r16, "bussiness_api_call", r18, r9, r14);
        long r11 = r23.getId();
        String r17 = String.valueOf(r23.getResourceType());
        String r19 = String.valueOf(r25);
        String r20 = String.valueOf(System.currentTimeMillis() - r26);
        String r110 = String.valueOf(r3);
        String r111 = String.valueOf(r27);
        com.bytedance.android.live.core.resources.b r28 = r23.getCleanStrategy();
        if (r28 == null) goto L20;
        String r29 = r28.getAssetType();
        if (r29 == null) goto L20;
    L21:
        r21.K(r11, r17, r19, 0, r20, r10, r110, r111, r29, r23.getDownloadType());
        return;
    L20:
        r29 = BuildConfig.FLAVOR;
        goto L21
    L15:
        r4.a("free_display", 0);
        goto L16
    }

    public final void K(long r18, String r20, String r21, int r23, String r24, long r25, String r26, String r27, String r28, int r29) {
        if (this.v == false) goto L5;
        this.w.add(Completable.complete().observeOn(Schedulers.single()).subscribe(new f(this, r18, r20, r21, r23, r24, r25, r26, r27, r28, r29)));
        return;
    L5:
        long r11 = w0(r18);
        J0(String.valueOf(r18), r20, r21, r23, r24, r25, r26, r27, r11, r28, r29);
    }

    public static void J0(String r2, String r3, String r4, int r5, String r6, long r7, String r9, String r10, long r11, String r13, int r14) {
        Intrinsics.checkNotNullParameter(r2, "assetId");
        Intrinsics.checkNotNullParameter(r3, "resourceType");
        Intrinsics.checkNotNullParameter(r4, "downloadFrom");
        Intrinsics.checkNotNullParameter(r6, "totalTime");
        Intrinsics.checkNotNullParameter(r9, "videoType");
        Intrinsics.checkNotNullParameter(r10, "size");
        Intrinsics.checkNotNullParameter(r13, "assetPoolType");
        HashMap r0 = new HashMap();
        r0.put("asset_id", r2);
        r0.put("resource_type", r3);
        r0.put("download_from", r4);
        r0.put("download_assets_from", r4);
        r0.put("download_total_time", r6);
        r0.put("video_asset_type", r9);
        r0.put("asset_size", r10);
        r0.put("real_download_time", String.valueOf(r7));
        r0.put("status", String.valueOf(r5));
        String r8 = String.valueOf(ay1.b.u());
        if (r8 != null) goto L5;
        r8 = "0";
    L5:
        r0.put("level", r8);
        r0.put("asset_pool_type", r13);
        r0.put("download_type", String.valueOf(r14));
        if (r11 <= 0) goto L9;
        r0.put("redownload_times", String.valueOf(r11));
    L9:
        if (g02.a.e() == false) goto L11;
        r0.put("is_anchor", "1");
    L12:
        mz0.n r15 = new mz0.n();
        Map r16 = r15.a;
        Intrinsics.checkNotNullParameter(r16, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r16.putAll(r0);
        mz0.m r17 = new mz0.m();
        r17.b(LogCommon.LIVE_SHARE_LOG);
        r17.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r18 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r18, "pageSourceLog");
        List r19 = r17.a;
        ArrayList r20 = (ArrayList) r19;
        r20.add(r18.a);
        List r21 = r15.b;
        ArrayList r23 = (ArrayList) r21;
        r23.addAll(r17.a);
        cy0.e.a.getClass();
        cy0.j r24 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r25 = com.bytedance.android.scope.m.b(r24).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r25);
        ((f80.a) r25).w3("livesdk_rd_gift_resource_download", r15.a, r15.b);
        return;
    L11:
        r0.put("is_anchor", "0");
        goto L12
    }
}

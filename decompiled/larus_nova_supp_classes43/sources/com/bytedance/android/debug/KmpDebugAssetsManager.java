package com.bytedance.android.debug;

import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.downloader.GiftResourceManagerFactory;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetDownloadPriority;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.revenue.service.broadcast.IRevBroadcastService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class KmpDebugAssetsManager implements ca0.n, com.bytedance.android.scope.o {
    public final List<IAssetsManager.b> a;
    public final CopyOnWriteArrayList<com.bytedance.android.live.core.resources.e> b;
    public final Lazy c;
    public final uy0.b d;

    public final com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d h() {
        return (com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d) this.c.getValue();
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final void yj() {
    }

    public KmpDebugAssetsManager(uy0.b r10) {
        Intrinsics.checkNotNullParameter(r10, "fileService");
        this.d = r10;
        this.a = new ArrayList();
        new LinkedHashMap();
        this.b = new CopyOnWriteArrayList();
        this.c = LazyKt.lazy(KmpDebugAssetsManager$innerAssetsManagerSupport$2.INSTANCE);
    }

    public final String D1(long r10) {
        c12.e r11 = h().c(G1(r10), 0);
        if (r11 != null) goto L7;
        return null;
    L7:
        return ((com.bytedance.android.livesdk.gift.platform.business.effect.assets.e) r11).k;
    }

    public final com.bytedance.android.live.core.resources.e G1(long r10) {
        Iterator<com.bytedance.android.live.core.resources.e> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        com.bytedance.android.live.core.resources.e r1 = r0.next();
        if (r1.getId() != r10) goto L4;
        return r1;
    L8:
        return null;
    }

    public final String H0(long r10) {
        boolean r0 = com.bytedance.android.livesdk.gift.platform.business.i.a().H7();
        c12.e r11 = h().c(G1(r10), 0);
        if (r11 == null) goto L8;
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r12 = GiftResourceManagerFactory.a();
        if (r12 == null) goto L8;
        return r12.h(r11, r0);
    L8:
        return null;
    }

    public final void T(IAssetsManager.b r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        if (((ArrayList) this.a).contains(r10) == true) goto L6;
        ((ArrayList) this.a).add(r10);
        return;
    }

    public final boolean g1(long r10) {
        com.bytedance.android.live.core.resources.e r11 = G1(r10);
        boolean r12 = h().a(r11);
        if (r11 != null) goto L5;
    L14:
        if (r11 != null) goto L16;
        return r12;
    L16:
        if (r11.getResourceType() != 8) goto L29;
        Intrinsics.checkNotNullParameter(r11, "$this$getLokiExtraModel");
        if (r11.getLokiExtraModel() == null) goto L30;
        Intrinsics.checkNotNullParameter(r11, "$this$getLokiExtraModel");
        if (r11.getLokiExtraModel() == null) goto L22;
        boolean r13 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.effect.c.class).he(r11);
    L23:
        if (r12 == false) goto L26;
        if (r13 == false) goto L26;
    L25:
        return true;
    L26:
        return false;
    L22:
        r13 = true;
        goto L23
    L30:
        return r12;
    L29:
        return r12;
    L5:
        if (r11.getResourceType() != 5) goto L14;
        if (r11.getModelRequirements() == null) goto L14;
        List r1 = r11.getModelRequirements();
        Intrinsics.checkNotNull(r1);
        if ((!r1.isEmpty()) == false) goto L14;
        cy0.e.a.getClass();
        cy0.j r14 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r14).b(IRevBroadcastService.class);
        Intrinsics.checkNotNull(r15);
        List r16 = r11.getModelRequirements();
        Intrinsics.checkNotNull(r16);
        boolean r17 = ((com.bytedance.live.kmp.core.c) r15).Li(r16);
        if (r12 == false) goto L26;
        if (r17 == false) goto L26;
        goto L26
    }

    public final void l0(IAssetsManager.b r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        if (((ArrayList) this.a).contains(r10) == false) goto L6;
        ((ArrayList) this.a).remove(r10);
        return;
    }

    public final boolean Re(com.bytedance.android.live.core.resources.e r10, int r11) {
        ib(r10, null, r11, AssetDownloadPriority.NORMAL);
        return false;
    }

    public final AssetDownloadPriority g(AssetDownloadPriority r10, int r11) {
        if (r10 == null) goto L7;
        if (r10.getPriority() == AssetDownloadPriority.NORMAL.getPriority()) goto L7;
        return r10;
    L7:
        if (r11 == 1000) goto L22;
        if (r11 == 1010) goto L22;
        if (r11 != 4) goto L16;
        return AssetDownloadPriority.OTHER_SEND;
    L16:
        if (r11 != 1007) goto L20;
        return AssetDownloadPriority.JSB_PLAY;
    L20:
        return AssetDownloadPriority.NORMAL;
    L22:
        return AssetDownloadPriority.LOCAL;
    }

    public static final void a(final KmpDebugAssetsManager r10, JSONArray r11, final Function1 r12) {
        r10.getClass();
        Function2<Integer, Object, Unit> r0 = new KmpDebugAssetsManager$findJsObjAtJsAryRecursive$1(r10, r12);
        if (r11.length() == 0) goto L8;
        int r13 = r11.length();
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L10;
        r0.invoke(Integer.valueOf(r14), r11.get(r14));
        r14 = r14 + 1;
        goto L6
    L10:
        return;
    }

    public static final void f(final KmpDebugAssetsManager r10, JSONObject r11, final Function1 r12) {
        r10.getClass();
        Function2<String, Object, Unit> r0 = new KmpDebugAssetsManager$findJsObjAtJsObjRecursive$1(r10, r12);
        Iterator<String> r13 = r11.keys();
    L4:
        if (r13.hasNext() == false) goto L6;
        String r14 = r13.next();
        r0.invoke(r14, r11.get(r14));
        goto L4
    }

    public final boolean ib(com.bytedance.android.live.core.resources.e r10, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r11, int r12, AssetDownloadPriority r13) {
        ArrayList r0 = new ArrayList();
        if (r12 == 10) goto L12;
        if (r12 == 20) goto L12;
        if (r12 == 30) goto L12;
        List r1 = h().b(r10, 2);
        Iterator r14 = r1.iterator();
    L9:
        if (r14.hasNext() == false) goto L11;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r15 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.e) r14.next();
        r15.d = g(r13, r12).getPriority();
        goto L9
    L11:
        r0.addAll(r1);
    L26:
        if (r0.isEmpty() == false) goto L28;
        ToastUtil.b("下载失败", 0);
    L34:
        return false;
    L28:
        int r16 = r0.size();
        int r17 = 0;
    L29:
        if (r17 >= r16) goto L34;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r18 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.e) ListProtector.get(r0, r17);
        r18.a = true;
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r19 = GiftResourceManagerFactory.a();
        if (r19 == null) goto L33;
        r19.c(r18, new o(this, r10, r11));
    L33:
        r17 = r17 + 1;
    L12:
        c12.e r20 = h().c(r10, r12);
        if (r20 == null) goto L15;
        ((com.bytedance.android.livesdk.gift.platform.business.effect.assets.e) r20).d = g(r13, r12).getPriority();
    L16:
        if (r20 != null) goto L24;
        if (r12 != 10) goto L19;
        ToastUtil.b("该资源未配置H264", 0);
    L23:
        return false;
    L19:
        if (r12 != 20) goto L21;
        ToastUtil.b("该资源未配置H265", 0);
        goto L23
    L21:
        if (r12 != 30) goto L23;
        ToastUtil.b("该资源未配置H265超分", 0);
        goto L23
    L24:
        r0.add(r20);
        goto L26
    L15:
        r20 = null;
        goto L16
    }

    public final boolean r0(long r1, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r10, int r11, AssetDownloadPriority r12) {
        ib(G1(r1), r10, r11, AssetDownloadPriority.NORMAL);
        return false;
    }
}

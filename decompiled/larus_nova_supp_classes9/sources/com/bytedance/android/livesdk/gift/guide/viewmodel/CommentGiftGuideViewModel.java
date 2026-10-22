package com.bytedance.android.livesdk.gift.guide.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.service.interactivity.RevMockMessageSource;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import cy0.e;
import cy0.j;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import mz0.i;
import mz0.m;
import mz0.n;
import vh6.c;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J!\u0010\n\u001a\u00020\u00072\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0002J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0007J\b\u0010\u000f\u001a\u00020\u0007H\u0014R(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/gift/guide/viewmodel/CommentGiftGuideViewModel;", "Landroidx/lifecycle/ViewModel;", BuildConfig.FLAVOR, "giftDiamondCount", "getPriceRangeIndex", "Lkotlin/Function1;", "Lzy1/a;", BuildConfig.FLAVOR, "Lkotlin/ExtensionFunctionType;", "configFun", "updateModel", BuildConfig.FLAVOR, "comment", "onCommentChanged", "sendCommentGift", "onCleared", "Landroidx/lifecycle/MutableLiveData;", "commentGiftGuideModel", "Landroidx/lifecycle/MutableLiveData;", "getCommentGiftGuideModel", "()Landroidx/lifecycle/MutableLiveData;", "setCommentGiftGuideModel", "(Landroidx/lifecycle/MutableLiveData;)V", "Ljava/lang/Runnable;", "sendGiftListener", "Ljava/lang/Runnable;", "getSendGiftListener", "()Ljava/lang/Runnable;", "setSendGiftListener", "(Ljava/lang/Runnable;)V", "Lio/reactivex/disposables/Disposable;", "disposable", "Lio/reactivex/disposables/Disposable;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentGiftGuideViewModel extends ViewModel {
    private MutableLiveData<zy1.a> commentGiftGuideModel;
    private Disposable disposable;
    private Runnable sendGiftListener;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ String a;

        public a(String r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            ExtraResponse r5 = (ExtraResponse) r4;
            ((p2) r5.data).setComment(this.a);
            c.b(com.bytedance.android.livesdk.revenue.service.interactivity.b.class).Jk(RevMockMessageSource.GIFT, (p2) r5.data);
            ay1.b.k.setValue(null, ay1.b.a[10], 0);
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public final void sendCommentGift() {
        zy1.a r1 = (zy1.a) this.commentGiftGuideModel.getValue();
        if (r1 == null) goto L5;
        long r4 = r1.g;
    L7:
        if (r4 <= 0) goto L24;
        zy1.a r2 = (zy1.a) this.commentGiftGuideModel.getValue();
        String r3 = BuildConfig.FLAVOR;
        if (r2 == null) goto L12;
        String r5 = r2.h;
        if (r5 == null) goto L12;
    L13:
        this.disposable = d.o(new b0(r4, SendGiftSource.Comment, null, null, 0, 0, null, "comment_guide", r5, null, 0, null, null, false, null, 0, false, null, 0, null, false, null, false, 0, null, null, null, null, null, null, null, null, 0, 0, null, null, false, null, null, null, null, null, null, false, null, null, null, null, 0, null, null, -388, 8388607), 1).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r5), b.a);
        Runnable r6 = this.sendGiftListener;
        if (r6 == null) goto L16;
        r6.run();
    L16:
        HashMap r7 = new HashMap();
        r7.put("gift_id", String.valueOf(r4));
        zy1.a r8 = (zy1.a) this.commentGiftGuideModel.getValue();
        if (r8 == null) goto L22;
        String r9 = String.valueOf(r8.f);
        if (r9 == null) goto L22;
        r3 = r9;
    L22:
        r7.put("gift_price", r3);
        n r10 = new n();
        Map r11 = r10.a;
        Intrinsics.checkNotNullParameter(r11, "map");
        Intrinsics.checkNotNullParameter(r7, "map");
        r11.putAll(r7);
        m r13 = new m();
        r13.b(LogCommon.ROOM);
        r13.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r10.b).addAll(r13.a);
        e.a.getClass();
        j r14 = e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r15);
        ((f80.a) r15).w3("gift_guide_click", r10.a, r10.b);
        return;
    L12:
        r5 = BuildConfig.FLAVOR;
        goto L13
    L24:
        return;
    L5:
        r4 = 0;
        goto L7
    }

    public CommentGiftGuideViewModel() {
        this.commentGiftGuideModel = new MutableLiveData();
    }

    public void onCleared() {
        super.onCleared();
        this.sendGiftListener = null;
    }

    public final MutableLiveData<zy1.a> getCommentGiftGuideModel() {
        return this.commentGiftGuideModel;
    }

    public final Runnable getSendGiftListener() {
        return this.sendGiftListener;
    }

    private final int getPriceRangeIndex(int r6) {
        List<Integer> r0 = xy1.a.a().c();
        if (r0 == null) goto L19;
        int r2 = r0.size();
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L13;
        if (r6 < ((Number) ListProtector.get(r0, r3)).intValue()) goto L8;
        r3 = r3 + 1;
        goto L5
    L8:
        if (r3 > 0) goto L10;
        return 0;
    L10:
        return r3 - 1;
    L13:
        if (r0.size() > 0) goto L15;
        return 0;
    L15:
        return r0.size() - 1;
    L19:
        return 0;
    }

    private final void updateModel(Function1<? super zy1.a, Unit> r2) {
        zy1.a r0 = (zy1.a) this.commentGiftGuideModel.getValue();
        if (r0 != null) goto L5;
        r0 = new zy1.a();
    L5:
        r2.invoke(r0);
        this.commentGiftGuideModel.setValue(r0);
    }

    public final void onCommentChanged(final String r14) {
        Intrinsics.checkNotNullParameter(r14, "comment");
        com.bytedance.tools.kcp.spongepreference.runtime.a r1 = ay1.b.i;
        KProperty[] r2 = ay1.b.a;
        boolean r4 = false;
        if ((System.currentTimeMillis() - ((Number) r1.getValue(null, r2[8])).longValue()) >= 86400000) goto L6;
        r1.setValue(null, r2[8], Long.valueOf(System.currentTimeMillis()));
        ay1.b.j.setValue(null, r2[9], 0);
    L6:
        if (ay1.b.a() < xy1.a.a().d()) goto L8;
    L11:
        boolean r3 = false;
    L12:
        k r5 = f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), k.class);
        if (r5 == null) goto L15;
        IRoom r6 = r5.getRoom();
    L16:
        if (r6 == null) goto L21;
        IRoomAuthStatus r7 = r6.getRoomAuthStatus();
        if (r7 == null) goto L21;
        if (r7.getEnableGift() != true) goto L21;
    L22:
        int r8 = c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getCurrentScene();
        c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).Il().a();
        if (r8 != 10) goto L25;
        r3 = false;
    L25:
        GiftManagerKt.z.getClass();
        Intrinsics.checkNotNullParameter(r14, "comment");
        e1 r9 = (e1) f.a(e1.class);
        if (u.r() == true) goto L29;
        Intrinsics.checkNotNullParameter(r14, "comment");
        h2 r10 = ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).d(r14);
    L55:
        if (r10 != null) goto L57;
        r3 = false;
    L57:
        zv0.f r0 = jc1.k.n(IRechargeService.class).rechargeCenter();
        if (r10 == null) goto L60;
        long r11 = r10.getDiamondCount();
    L62:
        if (r0.isDiamondAvailable(r11) == false) goto L65;
        r4 = r3;
    L65:
        if (r4 == true) goto L72;
        zy1.a r13 = (zy1.a) this.commentGiftGuideModel.getValue();
        if (r13 != null) goto L69;
        return;
    L69:
        if (r13.a != true) goto L89;
        updateModel(AnonymousClass1.INSTANCE);
        return;
    L89:
        return;
    L72:
        if (r10 == null) goto L90;
        final int r15 = getPriceRangeIndex(r10.getDiamondCount());
        final zy1.b r16 = xy1.a.a();
        final h2 r17 = r10;
        updateModel(new CommentGiftGuideViewModel$onCommentChanged$$inlined$apply$lambda$1(r15, r16, this, r17, r14));
        com.bytedance.tools.kcp.spongepreference.runtime.a r18 = ay1.b.j;
        KProperty[] r19 = ay1.b.a;
        int r20 = ((Number) r18.getValue(null, r19[9])).intValue();
        int r21 = ay1.b.a();
        r18.setValue(null, r19[9], Integer.valueOf(r20 + 1));
        ay1.b.k.setValue(null, r19[10], Integer.valueOf(r21 + 1));
        return;
    L90:
        return;
    L60:
        r11 = 0;
        goto L62
    L29:
        if (TextUtils.isEmpty(r14) == true) goto L54;
        Iterator<String> r23 = GiftManagerKt.f.keySet().iterator();
    L33:
        if (r23.hasNext() == false) goto L54;
        String r24 = r23.next();
        if (StringsKt.equals(r14, r24, true) == false) goto L33;
        Long r25 = GiftManagerKt.f.get(r24);
        if (r25 == null) goto L33;
        h2 r26 = GiftManagerKt.l(r25.longValue());
        if (r26 == null) goto L33;
        if (r26.isDisplayedOnPanel() == false) goto L33;
        if (r26.getType() == 2) goto L51;
        if (r26.getType() == 8) goto L51;
        if (r26.getType() == 11) goto L51;
    L53:
        r10 = r26;
    L51:
        if (GiftManagerKt.v().g1(r26.getPrimaryEffectId()) == true) goto L53;
    L54:
        r10 = null;
    L21:
        r3 = false;
        goto L22
    L15:
        r6 = null;
        goto L16
    L8:
        if (ay1.b.a() >= xy1.a.a().e()) goto L11;
        r3 = true;
        goto L12
    }

    public final void setCommentGiftGuideModel(MutableLiveData<zy1.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.commentGiftGuideModel = r2;
    }

    public final void setSendGiftListener(Runnable r1) {
        this.sendGiftListener = r1;
    }
}

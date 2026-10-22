package com.bytedance.android.livesdk.gift.platform.core.ui.configuration.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.r0;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.gift.model.a0;
import com.bytedance.android.livesdk.gift.model.c0;
import com.bytedance.android.livesdk.gift.model.x3;
import com.bytedance.android.livesdk.gift.model.y3;
import com.bytedance.android.livesdk.gift.platform.core.ui.configuration.ClickType;
import com.bytedance.android.livesdk.gift.platform.core.ui.configuration.p;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.m;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b4\u00105J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002J \u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nJ\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nJ\u001c\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012J!\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0014R\u001b\u0010\u001d\u001a\u00060\u001bj\u0002`\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010#\u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010\u00020\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\"\u0010%\u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010\u00020\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010$R\"\u0010&\u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010\u00020\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010'\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00020,8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\u00020,8F¢\u0006\u0006\u001a\u0004\b0\u0010.R\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020\u00020,8F¢\u0006\u0006\u001a\u0004\b2\u0010.¨\u00066"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/ui/configuration/viewmodel/GiftEffectConfigurationViewModelForAnchor;", "Landroidx/lifecycle/ViewModel;", BuildConfig.FLAVOR, "isBeforeLive", BuildConfig.FLAVOR, "setIsBeforeLive", "updateStickerEffectStatus", "newStatus", "uploadChangeStatus", "switch", "Lkotlin/Function0;", "onSuccessAction", "updateGameEffectSwitch", "getGameEffectSwitch", "getRoleSkillEffectSwitch", "updateRoleSkillEffectSwitch", BuildConfig.FLAVOR, "moduleName", "Lcom/bytedance/android/livesdk/gift/platform/core/ui/configuration/ClickType;", "clickType", "logAnchorConfigDialogShow", "switchStatus", "logConfigDialogClick", "(Lcom/bytedance/android/livesdk/gift/platform/core/ui/configuration/ClickType;Ljava/lang/Boolean;)V", "result", "logConfigSetResult", "onCleared", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "_stickerEffectSwitchStatus", "Landroidx/lifecycle/MutableLiveData;", "_gameEffectSwitchStatus", "_roleSkillEffectSwitchStatus", "hasManualChangeRoleSkillEffectStatus", "Z", "Lp12/c;", "giftEffectRepo", "Lp12/c;", "Landroidx/lifecycle/LiveData;", "getStickerEffectSwitchStatus", "()Landroidx/lifecycle/LiveData;", "stickerEffectSwitchStatus", "getGameEffectSwitchStatus", "gameEffectSwitchStatus", "getRoleSkillEffectSwitchStatus", "roleSkillEffectSwitchStatus", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftEffectConfigurationViewModelForAnchor extends ViewModel {
    private final MutableLiveData<Boolean> _gameEffectSwitchStatus;
    private final MutableLiveData<Boolean> _roleSkillEffectSwitchStatus;
    private final MutableLiveData<Boolean> _stickerEffectSwitchStatus;
    private final CompositeDisposable compositeDisposable;
    private final p12.c giftEffectRepo;
    private boolean hasManualChangeRoleSkillEffectStatus;
    private boolean isBeforeLive;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ GiftEffectConfigurationViewModelForAnchor a;

        public a(GiftEffectConfigurationViewModelForAnchor r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            boolean r3 = !((a0) r2).getForbiddenSwitch();
            ay1.d.e(r3);
            GiftEffectConfigurationViewModelForAnchor.access$get_gameEffectSwitchStatus$p(this.a).setValue(Boolean.valueOf(r3));
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

    public static final class c<T> implements Consumer {
        public final /* synthetic */ GiftEffectConfigurationViewModelForAnchor a;

        public c(GiftEffectConfigurationViewModelForAnchor r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            c0 r3 = (c0) r2;
            if (GiftEffectConfigurationViewModelForAnchor.access$getHasManualChangeRoleSkillEffectStatus$p(this.a) == true) goto L7;
            boolean r4 = r3.getEffectSwitchStatus();
            ay1.d.f(r4);
            GiftEffectConfigurationViewModelForAnchor.access$get_roleSkillEffectSwitchStatus$p(this.a).setValue(Boolean.valueOf(r4));
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ GiftEffectConfigurationViewModelForAnchor a;
        public final /* synthetic */ Function0 b;
        public final /* synthetic */ boolean c;

        public e(GiftEffectConfigurationViewModelForAnchor r1, Function0 r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            boolean r5 = !((x3) r4).getForbiddenSwitch();
            ay1.d.e(r5);
            GiftEffectConfigurationViewModelForAnchor.access$get_gameEffectSwitchStatus$p(this.a).setValue(Boolean.valueOf(r5));
            Function0 r6 = this.b;
            if (r6 == null) goto L5;
            Unit r7 = (Unit) r6.invoke();
        L5:
            this.a.logConfigSetResult(ClickType.EffectGame, this.c, true);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ GiftEffectConfigurationViewModelForAnchor a;
        public final /* synthetic */ boolean b;

        public f(GiftEffectConfigurationViewModelForAnchor r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            ay1.d.e(!this.b);
            GiftEffectConfigurationViewModelForAnchor.access$get_gameEffectSwitchStatus$p(this.a).setValue(Boolean.valueOf(!this.b));
            this.a.logConfigSetResult(ClickType.EffectGame, this.b, false);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ GiftEffectConfigurationViewModelForAnchor a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ Function0 c;

        public g(GiftEffectConfigurationViewModelForAnchor r1, boolean r2, Function0 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            y3 r5 = (y3) r4;
            if (GiftEffectConfigurationViewModelForAnchor.access$getHasManualChangeRoleSkillEffectStatus$p(this.a) == true) goto L5;
            GiftEffectConfigurationViewModelForAnchor.access$setHasManualChangeRoleSkillEffectStatus$p(this.a, true);
        L5:
            ay1.d.f(this.b);
            GiftEffectConfigurationViewModelForAnchor.access$get_roleSkillEffectSwitchStatus$p(this.a).setValue(Boolean.valueOf(this.b));
            Function0 r6 = this.c;
            if (r6 == null) goto L8;
            Unit r7 = (Unit) r6.invoke();
        L8:
            this.a.logConfigSetResult(ClickType.RoleSkill, this.b, true);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ GiftEffectConfigurationViewModelForAnchor a;
        public final /* synthetic */ boolean b;

        public h(GiftEffectConfigurationViewModelForAnchor r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            ay1.d.f(!this.b);
            GiftEffectConfigurationViewModelForAnchor.access$get_roleSkillEffectSwitchStatus$p(this.a).setValue(Boolean.valueOf(!this.b));
            this.a.logConfigSetResult(ClickType.RoleSkill, this.b, false);
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ GiftEffectConfigurationViewModelForAnchor a;

        public i(GiftEffectConfigurationViewModelForAnchor r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            if (((r0) ((ExtraResponse) ((com.bytedance.android.live.network.response.e) r5)).data).faceGiftSwitch == 2) goto L5;
            boolean r6 = true;
        L6:
            ay1.d.g(r6);
            GiftEffectConfigurationViewModelForAnchor.access$get_stickerEffectSwitchStatus$p(this.a).setValue(Boolean.valueOf(r6));
            return;
        L5:
            r6 = false;
            goto L6
        }
    }

    public static final class j<T> implements Consumer {
        public static final j a = null;

        static {
            a = new j();
        }

        public j() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ GiftEffectConfigurationViewModelForAnchor a;
        public final /* synthetic */ boolean b;

        public k(GiftEffectConfigurationViewModelForAnchor r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            com.bytedance.android.live.network.response.e r5 = (com.bytedance.android.live.network.response.e) r4;
            this.a.logConfigSetResult(ClickType.StickerGiftEffectSwitch, this.b, true);
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ GiftEffectConfigurationViewModelForAnchor a;
        public final /* synthetic */ boolean b;

        public l(GiftEffectConfigurationViewModelForAnchor r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            ay1.d.g(!this.b);
            GiftEffectConfigurationViewModelForAnchor.access$get_stickerEffectSwitchStatus$p(this.a).setValue(Boolean.valueOf(!this.b));
            this.a.logConfigSetResult(ClickType.StickerGiftEffectSwitch, this.b, false);
        }
    }

    public final void getGameEffectSwitch() {
        yz0.k r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r0 == null) goto L11;
        IRoom r1 = r0.getRoom();
        if (r1 == null) goto L12;
        String r2 = r1.getIdStr();
        if (r2 == null) goto L13;
        this.giftEffectRepo.getClass();
        Intrinsics.checkNotNullParameter(r2, "roomId");
        tz0.b r3 = tz0.b.a;
        uz0.c r4 = new uz0.c();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "$this$beforeConfigureRequest");
        Map r5 = ((uz0.a) r4).b;
        Intrinsics.checkNotNullParameter(r5, "queriesMap");
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        r5.put("room_id", r2);
        Intrinsics.checkNotNullParameter(r4, "$this$afterConfigureRequest");
        com.bytedance.revenue.platform.api.core.rx.f.a(com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).x0(INetworkService.Biz.Revenue, "/webcast/gift/effect_game/get_config/", TypesJVMKt.getJavaType(Reflection.typeOf(a0.class)), Extra.class, ((uz0.a) r4).d, ((uz0.a) r4).a, ((uz0.a) r4).b, ((uz0.a) r4).c).map(p12.a.a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this), b.a), this.compositeDisposable);
        return;
    L13:
        return;
    L12:
        return;
    }

    public final void getRoleSkillEffectSwitch() {
        String r0 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).getCurrentUserId();
        this.giftEffectRepo.getClass();
        Intrinsics.checkNotNullParameter(r0, "userId");
        tz0.b r1 = tz0.b.a;
        uz0.c r2 = new uz0.c();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "$this$beforeConfigureRequest");
        Map r3 = ((uz0.a) r2).b;
        Intrinsics.checkNotNullParameter(r3, "queriesMap");
        Intrinsics.checkNotNullParameter("target_user_id", "$this$setTo");
        if (r0 == null) goto L5;
        r3.put("target_user_id", r0);
    L5:
        Intrinsics.checkNotNullParameter(r2, "$this$afterConfigureRequest");
        com.bytedance.revenue.platform.api.core.rx.f.a(com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).x0(INetworkService.Biz.Revenue, "/webcast/rare_gift/effect_switch/get/", TypesJVMKt.getJavaType(Reflection.typeOf(c0.class)), Extra.class, ((uz0.a) r2).d, ((uz0.a) r2).a, ((uz0.a) r2).b, ((uz0.a) r2).c).map(p12.b.a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), d.a), this.compositeDisposable);
    }

    public void onCleared() {
        this.compositeDisposable.dispose();
        super.onCleared();
    }

    public final void updateStickerEffectStatus() {
        IBaseUser r0 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).b();
        if (r0 != null) goto L5;
        return;
    L5:
        String r1 = r0.getIdString();
        Intrinsics.checkNotNullParameter(r0, "$this$secUidExt");
        String r2 = r0.getCastSecUid();
        ds2.a r3 = vh6.c.b(ds2.a.class);
        if (this.isBeforeLive == false) goto L8;
        String r4 = "start_live";
    L9:
        Disposable r5 = r3.queryAnchorStickerStatus(r1, r2, r4).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(this), j.a);
        if (r5 != null) goto L12;
        return;
    L12:
        this.compositeDisposable.add(r5);
        return;
    L8:
        r4 = null;
        goto L9
    }

    public GiftEffectConfigurationViewModelForAnchor() {
        this.compositeDisposable = new CompositeDisposable();
        this._stickerEffectSwitchStatus = new MutableLiveData(Boolean.valueOf(ay1.d.d()));
        this._gameEffectSwitchStatus = new MutableLiveData(Boolean.valueOf(ay1.d.a()));
        this._roleSkillEffectSwitchStatus = new MutableLiveData(Boolean.valueOf(ay1.d.c()));
        this.giftEffectRepo = new p12.c();
    }

    public final CompositeDisposable getCompositeDisposable() {
        return this.compositeDisposable;
    }

    public final LiveData<Boolean> getGameEffectSwitchStatus() {
        return this._gameEffectSwitchStatus;
    }

    public final LiveData<Boolean> getRoleSkillEffectSwitchStatus() {
        return this._roleSkillEffectSwitchStatus;
    }

    public final LiveData<Boolean> getStickerEffectSwitchStatus() {
        return this._stickerEffectSwitchStatus;
    }

    public final boolean isBeforeLive() {
        return this.isBeforeLive;
    }

    public static final /* synthetic */ boolean access$getHasManualChangeRoleSkillEffectStatus$p(GiftEffectConfigurationViewModelForAnchor r0) {
        return r0.hasManualChangeRoleSkillEffectStatus;
    }

    public static final /* synthetic */ MutableLiveData access$get_gameEffectSwitchStatus$p(GiftEffectConfigurationViewModelForAnchor r0) {
        return r0._gameEffectSwitchStatus;
    }

    public static final /* synthetic */ MutableLiveData access$get_roleSkillEffectSwitchStatus$p(GiftEffectConfigurationViewModelForAnchor r0) {
        return r0._roleSkillEffectSwitchStatus;
    }

    public static final /* synthetic */ MutableLiveData access$get_stickerEffectSwitchStatus$p(GiftEffectConfigurationViewModelForAnchor r0) {
        return r0._stickerEffectSwitchStatus;
    }

    public final void setIsBeforeLive(boolean r1) {
        this.isBeforeLive = r1;
    }

    public final void uploadChangeStatus(boolean r4) {
        Disposable r5 = vh6.c.b(ds2.a.class).uploadAnchorStickerStatus(r4, this.isBeforeLive).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new k(this, r4), new l(this, r4));
        if (r5 != null) goto L5;
        return;
    L5:
        this.compositeDisposable.add(r5);
    }

    public static final /* synthetic */ void access$setHasManualChangeRoleSkillEffectStatus$p(GiftEffectConfigurationViewModelForAnchor r0, boolean r1) {
        r0.hasManualChangeRoleSkillEffectStatus = r1;
    }

    public final void logAnchorConfigDialogShow(String r6, ClickType r7) {
        Intrinsics.checkNotNullParameter(r6, "moduleName");
        int r1 = p.a;
        Intrinsics.checkNotNullParameter(r6, "moduleName");
        n r0 = new n();
        p.a(r0);
        Map r2 = r0.a;
        Intrinsics.checkNotNullParameter(r2, "map");
        Map r8 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("module_name", r6)});
        if (r7 == null) goto L5;
        r8.put("gift_type", r7.getValue());
    L5:
        Intrinsics.checkNotNullParameter(r8, "map");
        r2.putAll(r8);
        cy0.e.a.getClass();
        cy0.j r9 = cy0.e.a.a;
        m.e.getClass();
        Object r10 = m.b(r9).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r10);
        ((f80.a) r10).w3("livesdk_anchor_gift_effects_setting_popup_show", r0.a, r0.b);
    }

    public final void logConfigDialogClick(ClickType r2, Boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "clickType");
        p.b(r2, r3);
    }

    public final void updateGameEffectSwitch(boolean r4, Function0<Unit> r5) {
        yz0.k r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r0 == null) goto L7;
        IRoom r1 = r0.getRoom();
        if (r1 == null) goto L7;
        String r2 = r1.getIdStr();
    L9:
        if (r2 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == false) goto L18;
        logConfigSetResult(ClickType.EffectGame, r4, true);
        return;
    L18:
        this.giftEffectRepo.getClass();
        com.bytedance.revenue.platform.api.core.rx.f.a(p12.c.a(r2, !r4).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this, r5, r4), new f(this, r4)), this.compositeDisposable);
        return;
    L11:
        if (r2.length() == 0) goto L14;
        r3 = false;
    L7:
        r2 = null;
        goto L9
    }

    public final void updateRoleSkillEffectSwitch(boolean r18, Function0<Unit> r19) {
        String r2 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).getCurrentUserId();
        int r3 = !r18 ? 1 : 0;
        this.giftEffectRepo.getClass();
        Intrinsics.checkNotNullParameter(r2, "userId");
        tz0.b r4 = tz0.b.a;
        uz0.e r5 = new uz0.e();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "$this$beforeConfigureRequest");
        Map r6 = ((uz0.a) r5).b;
        Intrinsics.checkNotNullParameter(r6, "queriesMap");
        Intrinsics.checkNotNullParameter("target_user_id", "$this$setTo");
        if (r2 == null) goto L5;
        r6.put("target_user_id", r2);
    L5:
        String r7 = Integer.valueOf(r3).toString();
        Intrinsics.checkNotNullParameter("effect_switcher", "$this$setTo");
        if (r7 == null) goto L8;
        r6.put("effect_switcher", r7);
    L8:
        Intrinsics.checkNotNullParameter(r5, "$this$afterConfigureRequest");
        com.bytedance.revenue.platform.api.core.rx.f.a(com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(INetworkService.Biz.Revenue, "/webcast/rare_gift/effect_switch/set/", TypesJVMKt.getJavaType(Reflection.typeOf(y3.class)), Extra.class, ((uz0.a) r5).d, ((uz0.a) r5).a, ((uz0.a) r5).b, ((uz0.a) r5).c, r5.e, r5.f, r5.g).map(p12.d.a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this, r18, r19), new h(this, r18)), this.compositeDisposable);
    }

    public final void logConfigSetResult(ClickType r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "clickType");
        p.c(r2, r3, r4);
    }

    public static /* synthetic */ void logAnchorConfigDialogShow$default(GiftEffectConfigurationViewModelForAnchor r0, String r1, ClickType r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = "set";
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        r0.logAnchorConfigDialogShow(r1, r2);
    }

    public static /* synthetic */ void logConfigDialogClick$default(GiftEffectConfigurationViewModelForAnchor r0, ClickType r1, Boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.logConfigDialogClick(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateGameEffectSwitch$default(GiftEffectConfigurationViewModelForAnchor r0, boolean r1, Function0 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.updateGameEffectSwitch(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateRoleSkillEffectSwitch$default(GiftEffectConfigurationViewModelForAnchor r0, boolean r1, Function0 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.updateRoleSkillEffectSwitch(r1, r2);
    }
}

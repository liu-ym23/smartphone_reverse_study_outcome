package com.bytedance.android.live.room.navi.userinfo.viewmodel;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import k91.d;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0002QRB\u0007¢\u0006\u0004\bN\u0010OJ9\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u00012\u001c\b\n\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0005H\u0082\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010 \u001a\u00020\u001c8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020!8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000e\u001a\u0004\b#\u0010$R\u001b\u0010*\u001a\u00020&8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u000e\u001a\u0004\b(\u0010)R\u001b\u0010/\u001a\u00020+8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u000e\u001a\u0004\b-\u0010.R\u001b\u00104\u001a\u0002008VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u000e\u001a\u0004\b2\u00103R\u001b\u00109\u001a\u0002058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u000e\u001a\u0004\b7\u00108R\u001b\u0010>\u001a\u00020:8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u000e\u001a\u0004\b<\u0010=R\u001b\u0010C\u001a\u00020?8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u000e\u001a\u0004\bA\u0010BR\u001b\u0010H\u001a\u00020D8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u000e\u001a\u0004\bF\u0010GR\u001b\u0010M\u001a\u00020I8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u000e\u001a\u0004\bK\u0010L¨\u0006S"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoVM;", "Lcom/bytedance/live/datacontext/DataContext;", "Lk91/d;", "DC", "Lkotlin/Function0;", "Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/ValueFactory;", "factory", "Lkotlin/Lazy;", "shareViewModel", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoBasicVM;", "basicVM$delegate", "Lkotlin/Lazy;", "getBasicVM", "()Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoBasicVM;", "basicVM", "Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoAvatarVM;", "avatarVM$delegate", "getAvatarVM", "()Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoAvatarVM;", "avatarVM", "Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/ElementServiceVM;", "serviceVm$delegate", "getServiceVm", "()Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/ElementServiceVM;", "serviceVm", "Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoFollowVM;", "followVm$delegate", "getFollowVm", "()Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoFollowVM;", "followVm", "Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoFansVM;", "fansVm$delegate", "getFansVm", "()Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoFansVM;", "fansVm", "Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoCertAnimVM;", "certAnimVm$delegate", "getCertAnimVm", "()Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoCertAnimVM;", "certAnimVm", "Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoMiddleVM;", "middleVm$delegate", "getMiddleVm", "()Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoMiddleVM;", "middleVm", "Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoProfileAnimVM;", "profileAnimVm$delegate", "getProfileAnimVm", "()Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoProfileAnimVM;", "profileAnimVm", "Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoPopupVM;", "popupVm$delegate", "getPopupVm", "()Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoPopupVM;", "popupVm", "Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoGiftExhibitionVM;", "giftExhibitionVm$delegate", "getGiftExhibitionVm", "()Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoGiftExhibitionVM;", "giftExhibitionVm", "Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoAvatarBorderVM;", "avatarBorderVm$delegate", "getAvatarBorderVm", "()Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoAvatarBorderVM;", "avatarBorderVm", "Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoFlipTabVM;", "flipTabVm$delegate", "getFlipTabVm", "()Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoFlipTabVM;", "flipTabVm", "Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoNicknameVM;", "nicknameVm$delegate", "getNicknameVm", "()Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoNicknameVM;", "nicknameVm", "<init>", "()V", "Companion", "b", "c", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoVM extends DataContext implements d {
    public static final b Companion = null;
    public static final String SHARE_TAG = "UserInfoVM-Shared";
    private final Lazy avatarBorderVm$delegate;
    private final Lazy avatarVM$delegate;
    private final Lazy basicVM$delegate;
    private final Lazy certAnimVm$delegate;
    private final CompositeDisposable disposables;
    private final Lazy fansVm$delegate;
    private final Lazy flipTabVm$delegate;
    private final Lazy followVm$delegate;
    private final Lazy giftExhibitionVm$delegate;
    private final Lazy middleVm$delegate;
    private final Lazy nicknameVm$delegate;
    private final Lazy popupVm$delegate;
    private final Lazy profileAnimVm$delegate;
    private final Lazy serviceVm$delegate;

    public static final class a implements Action {
        public final /* synthetic */ UserInfoVM a;

        public a(UserInfoVM r1) {
            this.a = r1;
        }

        public final void run() {
            UserInfoVM.access$getDisposables$p(this.a).clear();
        }
    }

    public static final class b {
        @JvmStatic
        public static d a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d("UserInfoVM-Shared");
            if ((r0 instanceof d) == true) goto L6;
            r0 = null;
        L6:
            return (d) r0;
        }

        public b() {
        }
    }

    public final class c<DC extends DataContext> implements Lazy<DC> {
        public DC a;
        public final Class<DC> b;
        public final Function0<DC> c;
        public final /* synthetic */ UserInfoVM d;

        public final Object getValue() {
            DC r0 = this.a;
            if (r0 != null) goto L6;
            Pair r1 = com.bytedance.live.datacontext.d.a(new UserInfoVM$ShareDcLazy$value$1(this));
            UserInfoVM.access$getDisposables$p(this.d).add((Disposable) r1.getSecond());
            DC r2 = (DC) r1.getFirst();
            com.bytedance.live.datacontext.b.a(r2, r2.getClass());
            this.a = r2;
            return r2;
        L6:
            return r0;
        }

        public final boolean isInitialized() {
            if (this.a == null) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(UserInfoVM r2, Class<DC> r3, Function0<? extends DC> r4) {
            Intrinsics.checkNotNullParameter(r3, "dataContextClass");
            this.d = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
        Companion = new b();
    }

    @JvmStatic
    public static final d share() {
        Companion.getClass();
        return b.a();
    }

    public UserInfoAvatarBorderVM getAvatarBorderVm() {
        return (UserInfoAvatarBorderVM) this.avatarBorderVm$delegate.getValue();
    }

    public UserInfoAvatarVM getAvatarVM() {
        return (UserInfoAvatarVM) this.avatarVM$delegate.getValue();
    }

    @Override // k91.d
    public UserInfoBasicVM getBasicVM() {
        return (UserInfoBasicVM) this.basicVM$delegate.getValue();
    }

    public UserInfoCertAnimVM getCertAnimVm() {
        return (UserInfoCertAnimVM) this.certAnimVm$delegate.getValue();
    }

    public UserInfoFansVM getFansVm() {
        return (UserInfoFansVM) this.fansVm$delegate.getValue();
    }

    public UserInfoFlipTabVM getFlipTabVm() {
        return (UserInfoFlipTabVM) this.flipTabVm$delegate.getValue();
    }

    public UserInfoFollowVM getFollowVm() {
        return (UserInfoFollowVM) this.followVm$delegate.getValue();
    }

    public UserInfoGiftExhibitionVM getGiftExhibitionVm() {
        return (UserInfoGiftExhibitionVM) this.giftExhibitionVm$delegate.getValue();
    }

    public UserInfoMiddleVM getMiddleVm() {
        return (UserInfoMiddleVM) this.middleVm$delegate.getValue();
    }

    public UserInfoNicknameVM getNicknameVm() {
        return (UserInfoNicknameVM) this.nicknameVm$delegate.getValue();
    }

    public UserInfoPopupVM getPopupVm() {
        return (UserInfoPopupVM) this.popupVm$delegate.getValue();
    }

    public UserInfoProfileAnimVM getProfileAnimVm() {
        return (UserInfoProfileAnimVM) this.profileAnimVm$delegate.getValue();
    }

    public ElementServiceVM getServiceVm() {
        return (ElementServiceVM) this.serviceVm$delegate.getValue();
    }

    public UserInfoVM() {
        CompositeDisposable r0 = new CompositeDisposable();
        this.disposables = r0;
        RxUtilKt.c(getOnCleared().subscribe(new a(this)), r0);
        this.basicVM$delegate = new c(this, UserInfoBasicVM.class, UserInfoVM$basicVM$2.INSTANCE);
        this.avatarVM$delegate = new c(this, UserInfoAvatarVM.class, UserInfoVM$avatarVM$2.INSTANCE);
        this.serviceVm$delegate = new c(this, ElementServiceVM.class, UserInfoVM$serviceVm$2.INSTANCE);
        this.followVm$delegate = new c(this, UserInfoFollowVM.class, UserInfoVM$followVm$2.INSTANCE);
        this.fansVm$delegate = new c(this, UserInfoFansVM.class, UserInfoVM$fansVm$2.INSTANCE);
        this.certAnimVm$delegate = new c(this, UserInfoCertAnimVM.class, UserInfoVM$certAnimVm$2.INSTANCE);
        this.middleVm$delegate = new c(this, UserInfoMiddleVM.class, UserInfoVM$middleVm$2.INSTANCE);
        this.profileAnimVm$delegate = new c(this, UserInfoProfileAnimVM.class, UserInfoVM$profileAnimVm$2.INSTANCE);
        this.popupVm$delegate = new c(this, UserInfoPopupVM.class, UserInfoVM$popupVm$2.INSTANCE);
        this.giftExhibitionVm$delegate = new c(this, UserInfoGiftExhibitionVM.class, UserInfoVM$giftExhibitionVm$2.INSTANCE);
        this.avatarBorderVm$delegate = new c(this, UserInfoAvatarBorderVM.class, UserInfoVM$avatarBorderVm$2.INSTANCE);
        this.flipTabVm$delegate = new c(this, UserInfoFlipTabVM.class, UserInfoVM$flipTabVm$2.INSTANCE);
        this.nicknameVm$delegate = new c(this, UserInfoNicknameVM.class, UserInfoVM$nicknameVm$2.INSTANCE);
    }

    /* JADX INFO: renamed from: getAvatarBorderVm, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ k91.a m1067getAvatarBorderVm() {
        return getAvatarBorderVm();
    }

    /* JADX INFO: renamed from: getFlipTabVm, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ k91.b m1068getFlipTabVm() {
        return getFlipTabVm();
    }

    /* JADX INFO: renamed from: getNicknameVm, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ k91.c m1069getNicknameVm() {
        return getNicknameVm();
    }

    public static final /* synthetic */ CompositeDisposable access$getDisposables$p(UserInfoVM r0) {
        return r0.disposables;
    }

    @JvmStatic
    public static final boolean save(d r1) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r1, "userInfoVM");
        if ((r1 instanceof DataContext) == true) goto L5;
        r1 = null;
    L5:
        DataContext r2 = (DataContext) r1;
        if (r2 == null) goto L8;
        int r0 = com.bytedance.live.datacontext.d.a;
        Intrinsics.checkNotNullParameter(r2, "self");
        com.bytedance.live.datacontext.b.a(r2, "UserInfoVM-Shared");
        return true;
    L8:
        return false;
    }

    private final /* synthetic */ <DC extends DataContext> Lazy<DC> shareViewModel(Function0<? extends DC> r4) {
        Intrinsics.reifiedOperationMarker(4, "DC");
        return new c(this, DataContext.class, r4);
    }

    public static /* synthetic */ Lazy shareViewModel$default(UserInfoVM r1, Function0 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r2 = null;
    L5:
        Intrinsics.reifiedOperationMarker(4, "DC");
        return new c(r1, DataContext.class, r2);
    }
}

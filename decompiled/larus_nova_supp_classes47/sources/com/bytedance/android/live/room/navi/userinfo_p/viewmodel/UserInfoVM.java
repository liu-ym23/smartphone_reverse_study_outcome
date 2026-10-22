package com.bytedance.android.live.room.navi.userinfo_p.viewmodel;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0002\u001f B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ9\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u00012\u001c\b\n\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0005H\u0082\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u001a¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/viewmodel/UserInfoVM;", "Lcom/bytedance/live/datacontext/DataContext;", "Laa1/a;", "DC", "Lkotlin/Function0;", "Lcom/bytedance/android/live/room/navi/userinfo_p/ValueFactory;", "factory", "Lkotlin/Lazy;", "shareViewModel", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/android/live/room/navi/userinfo_p/viewmodel/ElementInteractServiceVM;", "elementInteractVm$delegate", "Lkotlin/Lazy;", "getElementInteractVm", "()Lcom/bytedance/android/live/room/navi/userinfo_p/viewmodel/ElementInteractServiceVM;", "elementInteractVm", "Lcom/bytedance/android/live/room/navi/userinfo_p/viewmodel/ElementMiddleVM;", "middleVm$delegate", "getMiddleVm", "()Lcom/bytedance/android/live/room/navi/userinfo_p/viewmodel/ElementMiddleVM;", "middleVm", "Lcom/bytedance/android/live/room/navi/userinfo_p/viewmodel/ElementBasicVM;", "basicVm$delegate", "getBasicVm", "()Lcom/bytedance/android/live/room/navi/userinfo_p/viewmodel/ElementBasicVM;", "basicVm", "<init>", "()V", "Companion", "b", "c", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoVM extends DataContext implements aa1.a {
    public static final b Companion = null;
    public static final String SHARE_TAG = "UserInfoVM-Shared";
    private final Lazy basicVm$delegate;
    private final CompositeDisposable disposables;
    private final Lazy elementInteractVm$delegate;
    private final Lazy middleVm$delegate;

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
        public static aa1.a b() {
            DataContext r0 = d.d("UserInfoVM-Shared");
            if ((r0 instanceof aa1.a) == true) goto L6;
            r0 = null;
        L6:
            return (aa1.a) r0;
        }

        public b() {
        }

        @JvmStatic
        public static boolean a(aa1.a r1) {
            Intrinsics.checkNotNullParameter(r1, "userInfoVM");
            if ((r1 instanceof DataContext) == true) goto L5;
            r1 = null;
        L5:
            DataContext r2 = (DataContext) r1;
            if (r2 == null) goto L8;
            int r0 = d.a;
            Intrinsics.checkNotNullParameter(r2, "self");
            com.bytedance.live.datacontext.b.a(r2, "UserInfoVM-Shared");
            return true;
        L8:
            return false;
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
            Pair r1 = d.a(new UserInfoVM$ShareDcLazy$value$1(this));
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
    public static final boolean save(aa1.a r1) {
        Companion.getClass();
        return b.a(r1);
    }

    @JvmStatic
    public static final aa1.a share() {
        Companion.getClass();
        return b.b();
    }

    @Override // aa1.a
    public ElementBasicVM getBasicVm() {
        return (ElementBasicVM) this.basicVm$delegate.getValue();
    }

    @Override // aa1.a
    public ElementInteractServiceVM getElementInteractVm() {
        return (ElementInteractServiceVM) this.elementInteractVm$delegate.getValue();
    }

    @Override // aa1.a
    public ElementMiddleVM getMiddleVm() {
        return (ElementMiddleVM) this.middleVm$delegate.getValue();
    }

    public UserInfoVM() {
        CompositeDisposable r0 = new CompositeDisposable();
        this.disposables = r0;
        RxUtilKt.c(getOnCleared().subscribe(new a(this)), r0);
        this.elementInteractVm$delegate = new c(this, ElementInteractServiceVM.class, UserInfoVM$elementInteractVm$2.INSTANCE);
        this.middleVm$delegate = new c(this, ElementMiddleVM.class, UserInfoVM$middleVm$2.INSTANCE);
        this.basicVm$delegate = new c(this, ElementBasicVM.class, UserInfoVM$basicVm$2.INSTANCE);
    }

    public static final /* synthetic */ CompositeDisposable access$getDisposables$p(UserInfoVM r0) {
        return r0.disposables;
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

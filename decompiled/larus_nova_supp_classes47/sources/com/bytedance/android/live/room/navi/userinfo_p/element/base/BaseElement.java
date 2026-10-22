package com.bytedance.android.live.room.navi.userinfo_p.element.base;

import aa1.a;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import m91.b;
import m91.c;
import m91.d;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/element/base/BaseElement;", "Lm91/c;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseElement implements c, LifecycleOwnerCompat {
    public final String a;
    public final LifecycleRegistry b;
    public final c c;

    @Override // m91.c
    public final boolean a() {
        return this.c.a();
    }

    @Override // m91.c
    public final a b() {
        return this.c.b();
    }

    @Override // m91.c
    public final boolean c() {
        return true;
    }

    @Override // m91.c
    public final LifecycleOwner e() {
        return this.c.e();
    }

    public void f() {
    }

    @Override // m91.c
    public final k getAvatarThumb() {
        return null;
    }

    @Override // m91.c
    public Context getContext() {
        return this.c.getContext();
    }

    @Override // m91.c
    public final DataCenter getDataCenter() {
        return this.c.getDataCenter();
    }

    @Override // m91.c
    public final Fragment getFragment() {
        return this.c.getFragment();
    }

    public final /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    @Override // m91.c
    public final String getName() {
        return "";
    }

    @Override // m91.c
    public final IRoom getRoom() {
        return this.c.getRoom();
    }

    @Override // m91.c
    public final DataContext getRoomContext() {
        return this.c.getRoomContext();
    }

    @Override // m91.c
    public final boolean isAnchor() {
        return this.c.isAnchor();
    }

    @Override // m91.c
    public final boolean isPortrait() {
        return this.c.isPortrait();
    }

    public void h() {
        ALogger.d(g(), "WIDGET onInit");
    }

    public void i() {
        ALogger.d(g(), "WIDGET onLoad");
    }

    public void j() {
        ALogger.d(g(), "WIDGET onUnload");
    }

    public void k() {
        ALogger.d(g(), "WIDGET onWidgetPrepareViewOnLoad");
    }

    public String g() {
        return this.a;
    }

    public final Lifecycle getLifecycleCompat() {
        return this.b;
    }

    public BaseElement(d r2) {
        Intrinsics.checkNotNullParameter(r2, "userInfoAbility");
        this.c = r2;
        this.a = "Element";
        this.b = new LifecycleRegistry(this);
    }

    public void l(IRoom r2) {
        ALogger.d(g(), "WIDGET onWidgetRoomEntered");
    }

    public final void m(Observable r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$subscribeElement");
        Intrinsics.checkNotNullParameter(r4, "onNext");
        Intrinsics.checkNotNullParameter(r3, "$this$subscribeElement");
        Intrinsics.checkNotNullParameter(r4, "onNext");
        ((ObservableSubscribeProxy) r3.as(AutoDispose.bind(this.c.e()))).subscribe(new m91.a(this, r4), new b(this));
    }
}

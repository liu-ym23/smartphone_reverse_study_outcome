package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import fp0.c;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import lp0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\b\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b(\u0010)J\b\u0010\u0004\u001a\u00020\u0003H&J<\u0010\f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\t0\bH\u0004ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJH\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u000e*\b\u0012\u0004\u0012\u00028\u00000\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00102\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\bH\u0004J\b\u0010\u0014\u001a\u00020\u0003H\u0015J\t\u0010\u0015\u001a\u00020\u0003H\u0096\u0001J\u0011\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0096\u0001J\r\u0010\u0019\u001a\u00020\u0003*\u00020\u0016H\u0096\u0001R.\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010%\u001a\u00020\"8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\"8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b&\u0010$\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/base/MiniAppChooseBaseViewModel;", "Landroidx/lifecycle/ViewModel;", "", "", "onScopeInitialized", "T", "Lkotlin/Result;", "result", "Lkotlin/Function1;", "", "isEmpty", "Lfp0/c;", "toLoadUiState", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lfp0/c;", "R", "Landroidx/lifecycle/MutableLiveData;", "Lio/reactivex/Observable;", "observable", "transform", "subscribe", "onCleared", "dispose", "Lio/reactivex/disposables/Disposable;", "d", "remove", "autoDispose", "Llp0/a;", "value", "scope", "Llp0/a;", "getScope", "()Llp0/a;", "setScope", "(Llp0/a;)V", "", "getScene", "()J", "scene", "getRoomId", "roomId", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class MiniAppChooseBaseViewModel extends ViewModel {
    private final /* synthetic */ com.bytedance.android.live.openplatform.impl.base.utils.a $$delegate_0;
    private lp0.a scope;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ MutableLiveData a;
        public final /* synthetic */ Function1 b;

        public a(MutableLiveData r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(R r3) {
            this.a.setValue(this.b.invoke(r3));
        }
    }

    public void autoDispose(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$autoDispose");
        this.$$delegate_0.a(r2);
    }

    public void dispose() {
        this.$$delegate_0.b();
    }

    public abstract void onScopeInitialized();

    public void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
        this.$$delegate_0.c(r2);
    }

    public final long getRoomId() {
        if (b.d(this.scope) == false) goto L12;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L13;
        m r1 = r0.getRoom();
        if (r1 == null) goto L14;
        Room r2 = (Room) r1.getValue();
        if (r2 != null) goto L11;
        return 0;
    L11:
        return r2.id;
    L14:
        return 0;
    L13:
        return 0;
    L12:
        return 0;
    }

    public final long getScene() {
        if (b.d(this.scope) == false) goto L5;
        return 2;
    L5:
        return 1;
    }

    public MiniAppChooseBaseViewModel() {
        this.$$delegate_0 = new com.bytedance.android.live.openplatform.impl.base.utils.a();
    }

    public final lp0.a getScope() {
        return this.scope;
    }

    public void onCleared() {
        dispose();
    }

    public final void setScope(lp0.a r1) {
        this.scope = r1;
        if (r1 == null) goto L6;
        onScopeInitialized();
        return;
    }

    public final <T> c toLoadUiState(Object r2, Function1<? super T, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "isEmpty");
        if (Result.isSuccess-impl(r2) == false) goto L12;
        if (Result.isFailure-impl(r2) == false) goto L8;
        r2 = null;
    L8:
        if (((Boolean) r3.invoke(r2)).booleanValue() == false) goto L14;
        return c.a.a;
    L14:
        return c.d.a;
    L12:
        return new c.b(Result.exceptionOrNull-impl(r2));
    }

    public final <T, R> MutableLiveData<T> subscribe(MutableLiveData<T> r2, Observable<R> r3, Function1<? super R, ? extends T> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$subscribe");
        Intrinsics.checkNotNullParameter(r4, "transform");
        if (r3 == null) goto L7;
        Disposable r5 = r3.subscribe(new a(r2, r4));
        if (r5 == null) goto L7;
        autoDispose(r5);
    L7:
        return r2;
    }
}

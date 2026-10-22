package com.bytedance.android.live.componentsmarket.impl.components;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.componentsmarket.impl.components.close.RoomCloseWidget;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.room.IRoomPreloadTaskManager;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.PreloadOpt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.n;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sh6.b;
import sh6.c;
import t70.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/componentsmarket/impl/components/BaseComponentsTetris;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LiveTetris;", "Ld90/a;", "Landroid/view/View$OnClickListener;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livecomponentsmarket-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseComponentsTetris extends LiveTetris<d90.a> implements View.OnClickListener, Observer<KVData> {
    public ViewGroup o;
    public ViewModel p;
    public Room q;
    public o40.a r;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ BaseComponentsTetris a;
        public final /* synthetic */ Runnable b;

        public a(RoomCloseWidget r1, Runnable r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            b r6 = (b) r5;
            if (r6 == null) goto L41;
            Boolean r7 = (Boolean) c.b(r6);
            if (r7 != null) goto L7;
            return;
        L7:
            if (r7.booleanValue() == true) goto L10;
            r7 = null;
        L10:
            if (r7 == null) goto L43;
            r7.booleanValue();
            MultiRoomConfig r8 = MultiRoomConfig.INSTANCE;
            PreloadOpt r0 = r8.getPreloadOpt();
            if (r0 != null) goto L14;
        L39:
            this.b.run();
            return;
        L14:
            if (r0.getPostVisibleTask() != true) goto L39;
            d90.a r1 = (d90.a) this.a.K();
            if (r1 == null) goto L22;
            MiddlewareRoomContext r2 = r1.e;
            if (r2 == null) goto L22;
            n r3 = r2.isPostTask();
            if (r3 == null) goto L22;
            Boolean r4 = (Boolean) r3.getValue();
        L24:
            if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L39;
            d90.a r9 = (d90.a) this.a.K();
            if (r9 == null) goto L38;
            DataCenter r11 = r9.h;
            if (r11 == null) goto L38;
            IRoomPreloadTaskManager r12 = (IRoomPreloadTaskManager) r11.get("data_preload_task_manager", null);
            if (r12 == null) goto L38;
            Runnable r13 = this.b;
            PreloadOpt r14 = r8.getPreloadOpt();
            if (r14 == null) goto L36;
            Long r15 = r14.getPostRoomInnerTaskDelayTime();
            if (r15 == null) goto L36;
            long r16 = r15.longValue();
        L37:
            r12.postTask(r13, r16, this.a.getClass().getSimpleName());
            return;
        L36:
            r16 = 0;
        L38:
            this.b.run();
            return;
        L22:
            r4 = null;
            goto L24
        L43:
            return;
        }
    }

    public abstract ViewModel a0(FragmentActivity r1);

    public abstract ConstraintLayout b0(k r1);

    public abstract o40.a c0();

    public abstract void d0();

    public void g0(KVData r1) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
    }

    public void V() {
        o40.a r0 = this.r;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public final ViewGroup Z() {
        ViewGroup r0 = this.o;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        return r0;
    }

    public void f0() {
        o40.a r0 = this.r;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public void O() {
        d90.a r0 = (d90.a) K();
        if (r0 == null) goto L5;
        Context r1 = r0.getContext();
    L7:
        if ((r1 instanceof FragmentActivity) == false) goto L13;
        this.p = a0((FragmentActivity) r1);
        o40.a r2 = c0();
        this.r = r2;
        if (r2 == null) goto L11;
        r2.e(this.p);
    L11:
        d0();
        V();
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void W() {
        d90.a r0 = (d90.a) K();
        DataCenter r1 = null;
        if (r0 == null) goto L7;
        DataCenter r2 = r0.h;
        if (r2 == null) goto L7;
        Room r3 = z.o(r2);
    L8:
        this.q = r3;
        o40.a r4 = this.r;
        if (r4 == null) goto L15;
        d90.a r5 = (d90.a) K();
        if (r5 == null) goto L13;
        r1 = r5.h;
    L13:
        r4.b(r3, r1);
        return;
    L15:
        return;
    L7:
        r3 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isScreenPortrait() {
        d90.a r0 = (d90.a) K();
        DataCenter r1 = null;
        if (r0 == null) goto L5;
        DataCenter r2 = r0.h;
    L6:
        if (r2 == null) goto L11;
        d90.a r3 = (d90.a) K();
        if (r3 == null) goto L10;
        r1 = r3.h;
    L10:
        Intrinsics.checkNotNull(r1);
        return ((Boolean) r1.get("data_is_portrait", Boolean.FALSE)).booleanValue();
    L11:
        return false;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void onStart() {
        super.onStart();
        W();
    }

    public BaseComponentsTetris() {
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public View G(k r2) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        this.o = b0(r2);
        f0();
        ViewGroup r3 = this.o;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        return r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h0(Runnable r4) {
        Intrinsics.checkNotNullParameter(r4, "runnable");
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L25;
        MiddlewareRoomContext r0 = ((d90.a) K()).e;
        Boolean r1 = null;
        if (r0 == null) goto L9;
        n r2 = r0.isRoomVisible();
        if (r2 == null) goto L9;
        Boolean r3 = (Boolean) r2.getValue();
    L10:
        if (r3 != null) goto L12;
    L16:
        MiddlewareRoomContext r5 = ((d90.a) K()).e;
        if (r5 == null) goto L27;
        n r6 = r5.isRoomVisible();
        if (r6 == null) goto L28;
        Observable r7 = r6.a();
        if (r7 == null) goto L29;
        ObservableSubscribeProxy r8 = (ObservableSubscribeProxy) r7.as(AutoDispose.bind(this));
        if (r8 == null) goto L30;
        r8.subscribe(new a((RoomCloseWidget) this, r4));
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L12:
        if (r3.booleanValue() == false) goto L14;
        r1 = r3;
    L14:
        if (r1 == null) goto L16;
        r1.booleanValue();
        r4.run();
    L9:
        r3 = null;
        goto L10
    L25:
        r4.run();
    }

    public /* bridge */ /* synthetic */ void onChanged(Object r1) {
        g0((KVData) r1);
    }
}

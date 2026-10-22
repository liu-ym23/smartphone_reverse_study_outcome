package com.bytedance.android.live.messagewindow.business.tetris;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.layer.TetrisComponentKey;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement;
import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.messagewindow.framework.container.AbsMsgWindowContainer;
import com.bytedance.android.live.messagewindow.framework.context.CardContext;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.live.room.api.messagewindow.service.dependenceproxy.IMsgWindowProxyService;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.android.livesdk.utils.g7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.n;
import d90.d;
import d90.g;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import t70.k;
import zg1.q3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/messagewindow/business/tetris/TopRightWindowCardTetris;", "Lcom/bytedance/android/live/messagewindow/framework/container/AbsMsgWindowContainer;", "Ld90/d;", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TopRightWindowCardTetris extends AbsMsgWindowContainer<d> {
    public final MsgWindowPosition r;
    public ViewGroup s;
    public final CompositeDisposable t;
    public final com.bytedance.android.live.messagewindow.business.util.a u;

    public static final class a implements com.bytedance.android.live.messagewindow.business.util.a.InterfaceC0127a {
        public final /* synthetic */ TopRightWindowCardTetris a;

        public a(TopRightWindowCardTetris r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.messagewindow.business.util.a.InterfaceC0127a
        public final WidgetElement a(Class<? extends Widget> r8, ViewGroup r9, boolean r10, Object[] r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r8, "widgetClass");
            Intrinsics.checkNotNullParameter(r9, "elementView");
            return this.a.P(r8, r9, r10, r11, r12);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ TopRightWindowCardTetris a;

        public b(TopRightWindowCardTetris r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            if (((q3) r1) == null) goto L5;
            boolean r2 = g7.a;
            g7.a(this.a.L());
            return;
        L5:
            boolean r3 = g7.a;
            g7.b(this.a.L());
        }
    }

    @Override // com.bytedance.android.live.messagewindow.framework.container.AbsMsgWindowContainer
    public final String a0() {
        return "TopRightWindowCardTetris";
    }

    public TopRightWindowCardTetris() {
        this.r = MsgWindowPosition.TOP_RIGHT;
        this.t = new CompositeDisposable();
        this.u = new com.bytedance.android.live.messagewindow.business.util.a(new a(this));
    }

    public final void O() {
        CardContext r0 = V();
        if (r0 == null) goto L5;
        r0.provideWindowContainer(this.r, this);
    L5:
        DataCenter r1 = K().h;
        if (r1 == null) goto L14;
        IRoom r2 = a0.n(r1);
        if (r2 == null) goto L14;
        long r3 = r2.getId();
        r r4 = z51.a.e(K().h);
        if (r4 == null) goto L14;
        n r5 = r4.m();
        if (r5 == null) goto L14;
        r5.setValue(new Pair(Long.valueOf(r3), this));
    L14:
        Disposable r6 = xs2.b.a().b(q3.class).subscribe(new b(this));
        this.t.add(r6);
    }

    @Override // com.bytedance.android.live.messagewindow.framework.container.AbsMsgWindowContainer
    public final DataCenter Z() {
        return K().h;
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris*/.onDestroy();
        b0();
        this.t.clear();
    }

    @Override // com.bytedance.android.live.messagewindow.framework.container.AbsMsgWindowContainer
    public final com.bytedance.android.live.messagewindow.business.util.a W() {
        return this.u;
    }

    public final View G(k r9) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        DataCenter r0 = K().h;
        if (r0 == null) goto L11;
        IRoom r1 = a0.n(r0);
        if (r1 == null) goto L11;
        long r2 = r1.getId();
        r r3 = z51.a.e(K().h);
        if (r3 == null) goto L11;
        n r4 = r3.m();
        if (r4 == null) goto L11;
        r4.setValue(new Pair(Long.valueOf(r2), this));
    L11:
        IMsgWindowProxyService r5 = jc1.k.f(IMsgWindowProxyService.class);
        if (r5 == null) goto L16;
        l71.b r6 = r5.getDSLContainerDynamicProxy();
        if (r6 == null) goto L16;
        d r7 = K();
        int r8 = g.a;
        is2.k r10 = r6.a(r7, this);
    L17:
        ((Tetris) this).j = r10;
        if (r10 == null) goto L38;
        HashMap r11 = ((Tetris) this).k;
        TetrisComponentKey r12 = TetrisComponentKey.UNIQUE_NATIVE_VIEW;
        r11.put(r12.getKey(), new TopRightWindowCardTetris$createTetrisView$2(this));
        is2.k r13 = ((Tetris) this).j;
        if (r13 == null) goto L24;
        KeyEvent.Callback r14 = r13.c();
        if (r14 == null) goto L24;
    L25:
        if (r14 == null) goto L37;
        this.s = (ViewGroup) r14;
        is2.k r15 = ((Tetris) this).j;
        if (r15 == null) goto L32;
        String r16 = r12.getKey();
        ViewGroup r17 = this.s;
        if (r17 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L31:
        r15.b(r16, r17.findViewById(2131365163));
    L32:
        ViewGroup r18 = this.s;
        if (r18 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L35:
        return r18;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L24:
        r14 = r9.b(2131567781);
        goto L25
    L38:
        View r19 = r9.b(2131567781);
        if (r19 == null) goto L45;
        ViewGroup r20 = (ViewGroup) r19;
        this.s = r20;
        this.q = (ViewGroup) r20.findViewById(2131365163);
        ViewGroup r21 = this.s;
        if (r21 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L43:
        return r21;
    L45:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L16:
        r10 = null;
        goto L17
    }
}

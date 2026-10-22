package com.bytedance.android.live.room.navi.tetris.desc;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrlExtra;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.m;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import d90.f;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import j70.j;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class A11yInteractionShowDescriptor extends j<d90.d> {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/room/navi/tetris/desc/A11yInteractionShowDescriptor$A11yInteractionTetris;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/Tetris;", "Ld90/d;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class A11yInteractionTetris extends Tetris<d90.d> implements Observer<KVData> {
        public final CompositeDisposable o;
        public Button p;
        public final b q;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ A11yInteractionTetris a;

            public a(A11yInteractionTetris r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r3) {
                if (r3.l(r3.getContext()) == false) goto L22;
                d90.d r4 = this.a.K();
                Intrinsics.checkNotNullParameter(r4, "$this$isLandscape");
                if ((!f.a(r4)) == false) goto L11;
                d90.d r5 = this.a.K();
                if (r5 == null) goto L23;
                DataCenter r6 = r5.h;
                if (r6 == null) goto L24;
                r6.put("cmd_change_landscape_visibility", Boolean.TRUE);
                return;
            L24:
                return;
            L23:
                return;
            L11:
                A11yInteractionTetris r7 = this.a;
                if (d90.e.g(r7.K()) == false) goto L20;
                m<Boolean> r0 = r7.R();
                if (r0 == null) goto L16;
                boolean r1 = !((Boolean) r0.getValue()).booleanValue();
            L17:
                m<Boolean> r8 = r7.R();
                if (r8 == null) goto L26;
                r8.setValue(Boolean.valueOf(r1));
                return;
            L26:
                return;
            L16:
                r1 = false;
                goto L17
            L20:
                xs2.b.a().post(new a61.a());
                return;
            }
        }

        public static final class b implements AccessibilityManagerCompat.TouchExplorationStateChangeListener {
            public final /* synthetic */ A11yInteractionTetris a;

            public b(A11yInteractionTetris r1) {
                this.a = r1;
            }

            public final void onTouchExplorationStateChanged(boolean r2) {
                this.a.Q(r2);
            }
        }

        public static final class c<T> implements Consumer {
            public final /* synthetic */ A11yInteractionTetris a;

            public c(A11yInteractionTetris r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                this.a.P(((Boolean) r2).booleanValue());
            }
        }

        public static final class d<T> implements Consumer {
            public final /* synthetic */ A11yInteractionTetris a;

            public d(A11yInteractionTetris r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                this.a.P(((Boolean) r2).booleanValue());
            }
        }

        public static final class e<T> implements Consumer {
            public final /* synthetic */ MiddlewareRoomContext a;
            public final /* synthetic */ A11yInteractionTetris b;

            public e(MiddlewareRoomContext r1, A11yInteractionTetris r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r4) {
                A11yInteractionTetris r0 = this.b;
                boolean r1 = false;
                if (((Boolean) r4).booleanValue() == true) goto L11;
                Button r5 = this.b.p;
                if (r5 == null) goto L7;
                Context r6 = r5.getContext();
            L9:
                if (r3.l(r6) == false) goto L11;
                boolean r7 = true;
            L12:
                r0.Q(r7);
                if (d90.e.g(this.b.K()) == false) goto L19;
                m<Boolean> r8 = this.b.R();
                if (r8 != null) goto L17;
            L24:
                this.b.P(r1);
                return;
            L17:
                if (((Boolean) r8.getValue()).booleanValue() != true) goto L24;
            L23:
                r1 = true;
                goto L24
            L19:
                m r9 = this.a.isShowCastScreenUIByClickScreen();
                if (r9 == null) goto L24;
                if (((Boolean) r9.getValue()).booleanValue() != true) goto L24;
            L7:
                r6 = null;
            L11:
                r7 = false;
                goto L12
            }
        }

        public final void O() {
            int r0 = r3.a;
            Button r1 = this.p;
            Context r2 = null;
            if (r1 == null) goto L5;
            Context r3 = r1.getContext();
        L6:
            r3.f(r3, this.q);
            Button r4 = this.p;
            if (r4 == null) goto L9;
            r2 = r4.getContext();
        L9:
            Q(r3.l(r2));
            d90.d r5 = K();
            Intrinsics.checkNotNullParameter(r5, "$this$isLandscape");
            if ((!f.a(r5)) == false) goto L14;
            DataCenter r6 = K().h;
            if (r6 == null) goto L32;
            r6.observe("data_is_hiding_landscape_buttons", this);
            return;
        L32:
            return;
        L14:
            MiddlewareRoomContext r7 = K().e;
            if (r7 != null) goto L17;
            return;
        L17:
            if (d90.e.g(K()) == false) goto L21;
            m<Boolean> r8 = R();
            if (r8 == null) goto L24;
            P(((Boolean) r8.getValue()).booleanValue());
            RxUtilKt.c(r8.a().subscribe(new c(this)), this.o);
        L24:
            m r9 = r7.isCleanMode();
            if (r9 == null) goto L35;
            Observable r10 = r9.a();
            if (r10 == null) goto L36;
            Disposable r12 = r10.subscribe(new e(r7, this));
            if (r12 == null) goto L37;
            RxUtilKt.c(r12, this.o);
            return;
        L37:
            return;
        L36:
            return;
        L35:
            return;
        L21:
            m r13 = r7.isShowCastScreenUIByClickScreen();
            if (r13 == null) goto L24;
            P(((Boolean) r13.getValue()).booleanValue());
            RxUtilKt.c(r13.a().subscribe(new d(this)), this.o);
            goto L24
        L5:
            r3 = null;
            goto L6
        }

        public final m<Boolean> R() {
            IVSPlayerService r0 = k.f(IVSPlayerService.class);
            if (r0 == null) goto L9;
            com.bytedance.android.livesdk.chatroom.vsplayer.api.c r1 = r0.provideVSPlayerViewControlService(K().h);
            if (r1 == null) goto L9;
            VSPlayerViewControlContext r2 = r1.provideContext();
            if (r2 == null) goto L9;
            return r2.getPlayerViewVisible();
        L9:
            return null;
        }

        public A11yInteractionTetris() {
            this.o = new CompositeDisposable();
            this.q = new b(this);
        }

        public final void onDestroy() {
            super.onDestroy();
            this.o.clear();
            int r0 = r3.a;
            Button r1 = this.p;
            if (r1 == null) goto L5;
            Context r2 = r1.getContext();
        L6:
            r3.o(r2, this.q);
            DataCenter r3 = K().h;
            if (r3 == null) goto L10;
            r3.removeObserver("data_is_hiding_landscape_buttons", this);
            return;
        L10:
            return;
        L5:
            r2 = null;
            goto L6
        }

        public final View G(t70.k r3) {
            Intrinsics.checkNotNullParameter(r3, "inflater");
            View r4 = r3.b(2131566549);
            if (r4 == null) goto L5;
            Button r0 = (Button) r4.findViewById(2131364630);
        L6:
            this.p = r0;
            if (r0 == null) goto L9;
            r0.setOnClickListener(new a(this));
        L9:
            return r4;
        L5:
            r0 = null;
            goto L6
        }

        public final void P(boolean r3) {
            if (r3 == false) goto L4;
            String r4 = "隐藏播控";
        L5:
            int r0 = r3.a;
            r3.c(this.p, r4, true);
            return;
        L4:
            r4 = "展示播控";
            goto L5
        }

        public final void Q(boolean r2) {
            if (r2 == true) goto L6;
            Button r3 = this.p;
            if (r3 == null) goto L10;
            r3.setVisibility(8);
            return;
        L10:
            return;
        L6:
            Button r4 = this.p;
            if (r4 == null) goto L12;
            r4.setVisibility(0);
            return;
        }

        public final void onChanged(Object r5) {
            KVData r6 = (KVData) r5;
            Object r0 = null;
            if (r6 == null) goto L5;
            String r1 = r6.getKey();
        L6:
            if (r1 != null) goto L9;
            return;
        L9:
            if (r1.hashCode() == 1883240861) goto L12;
            return;
        L12:
            if (r1.equals("data_is_hiding_landscape_buttons") == false) goto L27;
            if (r6 == null) goto L20;
            Object r7 = r6.getData();
            if ((r7 instanceof Boolean) == false) goto L18;
            r0 = r7;
        L18:
            r0 = (Boolean) r0;
        L20:
            if (Intrinsics.areEqual(r0, Boolean.TRUE) == false) goto L25;
            Button r8 = this.p;
            if (r8 == null) goto L24;
            ViewCompat.setImportantForAccessibility(r8, 1);
        L24:
            int r9 = r3.a;
            r3.c(this.p, "显示控件", true);
            return;
        L25:
            int r10 = r3.a;
            r3.n(this.p);
            return;
        L27:
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public final Tetris<? extends h70.b> b() {
        return new A11yInteractionTetris();
    }

    public A11yInteractionShowDescriptor() {
    }

    public final boolean B(h70.b r5) {
        d90.d r6 = (d90.d) r5;
        Intrinsics.checkNotNullParameter(r6, "layerContext");
        if (d90.e.a(r6) == true) goto L29;
        Intrinsics.checkNotNullParameter(r6, "$this$isLandscape");
        if ((!f.a(r6)) == false) goto L7;
    L27:
        return true;
    L7:
        if (f.a(r6) == false) goto L30;
        Intrinsics.checkNotNullParameter(r6, "$this$isHorizontalStream");
        MiddlewareRoomContext r7 = r6.e;
        if (r7 == null) goto L25;
        m r8 = r7.getRoom();
        if (r8 == null) goto L25;
        Room r9 = (Room) r8.getValue();
        if (r9 == null) goto L25;
        StreamUrl r0 = r9.getStreamUrl();
        if (r0 != null) goto L17;
    L19:
        StreamUrlExtra r10 = r9.getStreamUrlExtraSafely();
        if (r10.getWidth() <= r10.getHeight()) goto L22;
        boolean r12 = true;
    L23:
        if (r12 == false) goto L25;
    L24:
        boolean r13 = true;
    L26:
        if (r13 == true) goto L27;
        return false;
    L22:
        r12 = false;
        goto L23
    L17:
        if (r0.getStreamOrientation() != 2) goto L19;
    L25:
        r13 = false;
        goto L26
    L30:
        return false;
    L29:
        return false;
    }

    public final j70.f C(h70.b r2) {
        d90.d r3 = (d90.d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        r3.f.getClass();
        return d90.d.a.A;
    }

    public final LayerIndex E(h70.b r2) {
        d90.d r3 = (d90.d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        if (f.a(r3) == false) goto L6;
        return LayerIndex.INDEX_4;
    L6:
        return LayerIndex.INDEX_6;
    }

    public final ElementConstraint J(h70.b r2) {
        final d90.d r3 = (d90.d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        return I(new A11yInteractionShowDescriptor$generateConstraint$1(r3));
    }
}

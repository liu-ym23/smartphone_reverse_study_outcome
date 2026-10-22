package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.castscreen.views.CastScreenViewModel;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.x6;
import com.bytedance.android.livesdk.widgetdescriptor.data.LandscapeInteractionModel;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.android.livesdkapi.bytecast.ILiveByteCastService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeRestoreTetris;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LiveTetris;", "Lcom/bytedance/android/livesdk/widgetdescriptor/e0;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeRestoreTetris extends LiveTetris<e0> implements View.OnClickListener {
    public final Lazy o;
    public Disposable p;
    public final CompositeDisposable q;

    public static final class a<T> implements Observer {
        public final /* synthetic */ LandscapeRestoreTetris a;
        public final /* synthetic */ TextView b;

        public a(LandscapeRestoreTetris r1, TextView r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            LandscapeRestoreTetris.V(this.a, this.b);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LandscapeRestoreTetris a;
        public final /* synthetic */ TextView b;

        public b(LandscapeRestoreTetris r1, TextView r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            LandscapeRestoreTetris.V(this.a, this.b);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LandscapeRestoreTetris a;
        public final /* synthetic */ TextView b;

        public c(LandscapeRestoreTetris r1, TextView r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            LandscapeRestoreTetris.V(this.a, this.b);
        }
    }

    public final void O() {
    }

    public LandscapeRestoreTetris() {
        this.o = InfraKotlinExtsKt.mainThreadLazy(new LandscapeRestoreTetris$interactionModel$2(this));
        this.q = new CompositeDisposable();
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris*/.onDestroy();
        this.q.clear();
    }

    public final View G(t70.k r6) {
        Intrinsics.checkNotNullParameter(r6, "inflater");
        TextView r7 = new TextView(K().getContext());
        r7.setBackgroundResource(2131249869);
        r7.setText(2131923566);
        r7.setTextColor(s1.h(2131108569));
        r7.setTextSize(1, 13.0f);
        r7.setGravity(17);
        r7.setVisibility(8);
        r7.setOnClickListener(this);
        ((LandscapeInteractionModel) this.o.getValue()).isInZoomState().observe(this, new a(this, r7));
        Disposable r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.m r1 = r0.isSandwichAdapter();
        if (r1 == null) goto L11;
        Observable r2 = r1.a();
        if (r2 == null) goto L11;
        Disposable r3 = r2.subscribe(new b(this, r7));
        if (r3 == null) goto L11;
        RxUtilKt.c(r3, this.q);
        r4 = r3;
    L11:
        this.p = r4;
        CastScreenViewModel.Companion.getClass();
        CastScreenViewModel r5 = CastScreenViewModel.a.a();
        if (r5 == null) goto L20;
        com.bytedance.live.datacontext.m r8 = r5.getCastOrMirrorScreenMode();
        if (r8 == null) goto L20;
        Observable r9 = r8.a();
        if (r9 == null) goto L20;
        Disposable r10 = r9.subscribe(new c(this, r7));
        if (r10 == null) goto L20;
        RxUtilKt.c(r10, this.q);
    L20:
        return r7;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r13) {
        boolean r14 = x6.f();
        RoomContext.a r0 = RoomContext.Companion;
        RoomContext r5 = RoomContext.a.c(r0, null, 0, 3);
        if (r5 == null) goto L7;
        com.bytedance.live.datacontext.m r6 = r5.getRoom();
        if (r6 == null) goto L7;
        Room r7 = (Room) r6.getValue();
    L8:
        IUserService r8 = jc1.k.f(IUserService.class);
        if (r8 == null) goto L13;
        com.bytedance.android.livesdk.user.f r9 = r8.user();
        if (r9 == null) goto L13;
        String r10 = r9.n();
    L14:
        Pair[] r11 = new Pair[6];
        r11[0] = TuplesKt.to("user_id", r10);
        if (r7 == null) goto L17;
        String r12 = r7.getIdStr();
    L18:
        r11[1] = TuplesKt.to("room_id", r12);
        if (r7 == null) goto L21;
        int r15 = r7.isGameRoom();
    L22:
        r11[2] = TuplesKt.to("is_game_live", String.valueOf(r15));
        if (r7 == null) goto L25;
        long r16 = r7.getGameTagId();
    L26:
        r11[3] = TuplesKt.to("game_tag_id", String.valueOf(r16));
        if (r7 == null) goto L30;
        Object r17 = r7.getAnchorId();
        if (r17 == null) goto L30;
    L31:
        r11[4] = TuplesKt.to("anchor_id", r17.toString());
        r11[5] = TuplesKt.to("is_sandwich", String.valueOf(r14 ? 1 : 0));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_enlarge_restore", MapsKt.mutableMapOf(r11), new Object[0]);
        RoomContext r18 = RoomContext.a.c(r0, null, 0, 3);
        if (r18 == null) goto L36;
        com.bytedance.live.datacontext.m r19 = r18.isSandwichAdapter();
        if (r19 == null) goto L36;
        r19.setValue(Boolean.FALSE);
    L36:
        RoomContext r1 = RoomContext.a.c(r0, null, 0, 3);
        if (r1 == null) goto L41;
        com.bytedance.live.datacontext.m r2 = r1.isRestoreSandwich();
        if (r2 == null) goto L41;
        r2.setValue(Boolean.TRUE);
    L41:
        ALogger.i("SandwichBorderInfo", "sandwichState " + (r14 ? 1 : 0) + " , cur pic type " + x6.a);
        xs2.b.a().post(new do1.a(x6.a, r14 ? 1 : 0, 1, 0));
        f2.b(2131923567, 0);
        return;
    L30:
        r17 = 0;
        goto L31
    L25:
        r16 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = null;
    L13:
        r10 = null;
    L7:
        r7 = null;
        goto L8
    }

    public static final void V(LandscapeRestoreTetris r7, View r8) {
        Boolean r9 = (Boolean) ((LandscapeInteractionModel) r7.o.getValue()).isInZoomState().getValue();
        Boolean r0 = Boolean.TRUE;
        Boolean r1 = null;
        int r3 = 0;
        if (Intrinsics.areEqual(r9, r0) == true) goto L12;
        RoomContext r10 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r10 == null) goto L11;
        com.bytedance.live.datacontext.m r11 = r10.isSandwichAdapter();
        if (r11 == null) goto L11;
        if (((Boolean) r11.getValue()).booleanValue() == true) goto L12;
    L11:
        boolean r12 = false;
    L13:
        ILiveByteCastService r4 = jc1.k.f(ILiveByteCastService.class);
        if (r4 != null) goto L16;
    L17:
        ILiveByteCastService r2 = jc1.k.f(ILiveByteCastService.class);
        if (r2 == null) goto L21;
        r1 = r2.isSysExtendedCastMode();
    L21:
        if (Intrinsics.areEqual(r1, r0) == false) goto L23;
    L22:
        r12 = false;
    L23:
        if (r12 == true) goto L26;
        r3 = 8;
    L26:
        r8.setVisibility(r3);
        return;
    L16:
        if (r4.isCasting() == true) goto L22;
    L12:
        r12 = true;
        goto L13
    }
}

package com.bytedance.android.live.broadcastgame.xplay;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.config.n30;
import com.bytedance.android.livesdk.config.p20;
import com.bytedance.android.livesdk.config.zr;
import com.bytedance.android.livesdk.config.zs;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Action;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q1 {
    public static final PublishSubject<Unit> a = null;
    public static final PublishSubject b = null;

    public final class a implements Action {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void run() {
            this.a.invoke();
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
            q1.a.onNext(Unit.INSTANCE);
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ Function0 a;

        public c(Function0 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
            this.a.invoke();
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ Function0 a;

        public d(Function0 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
            this.a.invoke();
        }
    }

    public static final boolean d() {
        return ((Boolean) zs.a.getValue()).booleanValue();
    }

    public static final boolean e() {
        IInteractService r0 = jc1.k.f(IInteractService.class);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isEnableDanmuGameServerMerge() != true) goto L7;
        return true;
    }

    static {
        PublishSubject<Unit> r0 = PublishSubject.create();
        a = r0;
        b = r0;
    }

    public static final boolean f() {
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L14;
        CharSequence r0 = (CharSequence) n30.a.getValue();
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L15;
        return true;
    L15:
        return false;
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
        goto L11
    L14:
        return false;
    }

    public static final boolean c(String r2) {
        Boolean r0 = (Boolean) zr.a.getValue();
        List r1 = (List) p20.a.getValue();
        if (r0.booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (CollectionsKt.contains(r1, r2) == true) goto L7;
        return true;
    }

    public static final boolean g(com.bytedance.android.live.broadcastgame.api.model.r r2) {
        if (f() == false) goto L11;
        if (r2 == null) goto L9;
        com.bytedance.android.live.broadcastgame.api.model.g r3 = r2.n();
        if (r3 == null) goto L9;
        com.bytedance.android.live.broadcastgame.api.model.q0 r4 = r3.b();
        if (r4 == null) goto L9;
    L10:
        com.bytedance.android.live.broadcastgame.api.model.q0 r5 = com.bytedance.android.live.broadcastgame.api.model.q0.a(r4, (String) n30.a.getValue());
    L16:
        if (r5 == null) goto L18;
    L19:
        return true;
    L18:
        if (f() == true) goto L19;
        return false;
    L9:
        r4 = new com.bytedance.android.live.broadcastgame.api.model.q0(0);
        goto L10
    L11:
        if (r2 == null) goto L15;
        com.bytedance.android.live.broadcastgame.api.model.g r6 = r2.n();
        if (r6 == null) goto L15;
        r5 = r6.b();
    L15:
        r5 = null;
        goto L16
    }

    public static final Rect a(j r6, j r7) {
        Intrinsics.checkNotNullParameter(r6, "containerSize");
        Intrinsics.checkNotNullParameter(r7, "contentRatio");
        double r0 = Math.min(((double) r6.a) / ((double) r7.a), ((double) r6.b) / ((double) r7.b));
        return com.bytedance.android.live.broadcastgame.xplay.b.a(new j(MathKt.roundToInt(((double) r7.a) * r0), MathKt.roundToInt(((double) r7.b) * r0)), 0, r6.b / 2, 10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Completable b(Completable r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$doAfterSubscribe");
        Intrinsics.checkNotNullParameter(r3, "action");
        return Completable.mergeArray(new CompletableSource[]{r2, Completable.complete().doOnComplete(new a(r3))});
    }

    public static final com.bytedance.android.livesdk.widget.x0 h(com.bytedance.android.live.broadcastgame.api.xplay.p r3, int r4, String r5, boolean r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r3, "newEnv");
        Intrinsics.checkNotNullParameter(r5, "message");
        Intrinsics.checkNotNullParameter(r7, "quit");
        if (r6 == false) goto L11;
        Context r8 = r3.getContext();
        com.bytedance.android.livesdk.widget.x0.d r9 = new com.bytedance.android.livesdk.widget.x0.d();
        r9.b = r8;
        r9.a = 4;
        r9.k = false;
        r9.l = false;
        r9.c = r9.b.getText(r4);
        r9.d = r5;
        b r11 = b.a;
        com.bytedance.android.livesdk.widget.x0.c[] r12 = r9.g;
        com.bytedance.android.livesdk.widget.x0.c r13 = r12[0];
        if (r13 != null) goto L7;
        r13 = new com.bytedance.android.livesdk.widget.x0.c();
        r12[0] = r13;
    L7:
        r13.a = "重新进入";
        r13.b = r11;
        c r14 = new c(r7);
        com.bytedance.android.livesdk.widget.x0.c[] r15 = r9.g;
        com.bytedance.android.livesdk.widget.x0.c r16 = r15[1];
        if (r16 != null) goto L10;
        r16 = new com.bytedance.android.livesdk.widget.x0.c();
        r15[1] = r16;
    L10:
        r16.a = "退出玩法";
        r16.b = r14;
        com.bytedance.android.livesdk.widget.x0 r17 = new com.bytedance.android.livesdk.widget.x0(r9.b, r9);
        com.bytedance.android.livesdk.widget.x0.b.g(r17);
        return r17;
    L11:
        Context r18 = r3.getContext();
        com.bytedance.android.livesdk.widget.x0.d r19 = new com.bytedance.android.livesdk.widget.x0.d();
        r19.b = r18;
        r19.a = 4;
        r19.k = false;
        r19.l = false;
        r19.c = r18.getText(r4);
        r19.d = r5;
        d r21 = new d(r7);
        com.bytedance.android.livesdk.widget.x0.c[] r22 = r19.g;
        com.bytedance.android.livesdk.widget.x0.c r23 = r22[0];
        if (r23 != null) goto L14;
        r23 = new com.bytedance.android.livesdk.widget.x0.c();
        r22[0] = r23;
    L14:
        r23.a = "退出玩法";
        r23.b = r21;
        com.bytedance.android.livesdk.widget.x0 r24 = new com.bytedance.android.livesdk.widget.x0(r19.b, r19);
        com.bytedance.android.livesdk.widget.x0.b.g(r24);
        return r24;
    }
}

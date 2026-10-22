package com.bytedance.android.live.broadcastgame.xplay;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/l;", "", "invoke", "(Lcom/bytedance/android/live/broadcastgame/xplay/l;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class XplayMainService$start$1 extends Lambda implements Function1<l, Unit> {
    final /* synthetic */ c1 $totalPm;
    final /* synthetic */ XplayMainService this$0;

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.xplay.XplayMainService$start$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/l;", "", "invoke", "(Lcom/bytedance/android/live/broadcastgame/xplay/l;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function1<l, Unit> {
        final /* synthetic */ XplayMainService$start$1 this$0;

        public AnonymousClass1(XplayMainService$start$1 r1) {
            this.this$0 = r1;
            super(1);
        }

        public final void invoke(l r3) {
            Intrinsics.checkNotNullParameter(r3, "$receiver");
            r3.b("request app token", new C00971(this));
            XplayMainService r0 = this.this$0.this$0;
            if (r0.f == true) goto L12;
            com.bytedance.android.live.broadcastgame.api.xplay.p r1 = r0.i;
            if (r1.d == false) goto L13;
            com.bytedance.android.live.broadcastgame.api.xplay.s r2 = r1.j;
            if (r2 != null) goto L9;
        L10:
            r3.b("request app start", new AnonymousClass2(this));
            return;
        L9:
            if (r2.f != true) goto L10;
            return;
        L13:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((l) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.xplay.XplayMainService$start$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/l;", "", "invoke", "(Lcom/bytedance/android/live/broadcastgame/xplay/l;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass2 extends Lambda implements Function1<l, Unit> {
        final /* synthetic */ XplayMainService$start$1 this$0;

        public AnonymousClass2(XplayMainService$start$1 r1) {
            this.this$0 = r1;
            super(1);
        }

        public final void invoke(l r3) {
            Intrinsics.checkNotNullParameter(r3, "$receiver");
            XplayMainService r0 = this.this$0.this$0;
            if (r0.f == false) goto L11;
            com.bytedance.android.live.broadcastgame.api.xplay.p r1 = r0.i;
            if (r1.d == false) goto L11;
            com.bytedance.android.live.broadcastgame.api.xplay.s r2 = r1.j;
            if (r2 != null) goto L9;
        L10:
            r3.b("request app start", new AnonymousClass1(this));
            goto L11
        L9:
            if (r2.f != true) goto L10;
        L11:
            r3.b("load Xplay", new C01012(this));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((l) r1);
            return Unit.INSTANCE;
        }
    }

    public XplayMainService$start$1(XplayMainService r1, c1 r2) {
        this.this$0 = r1;
        this.$totalPm = r2;
        super(1);
    }

    public final void invoke(l r3) {
        Intrinsics.checkNotNullParameter(r3, "$receiver");
        r3.d("request tokens", new AnonymousClass1(this));
        r3.d("load Xplay", new AnonymousClass2(this));
        r3.b("run Xplay", new AnonymousClass3(this));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((l) r1);
        return Unit.INSTANCE;
    }
}

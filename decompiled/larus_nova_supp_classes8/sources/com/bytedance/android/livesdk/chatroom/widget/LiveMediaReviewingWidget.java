package com.bytedance.android.livesdk.chatroom.widget;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/LiveMediaReviewingWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMediaReviewingWidget extends LiveRecyclableWidget {
    public final Lazy a;
    public Button b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public RoomContext f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ LiveMediaReviewingWidget a;

        public a(LiveMediaReviewingWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            LiveMediaReviewingWidget r0 = this.a;
            r0.wq((Integer) r2);
        }
    }

    public final int getLayoutId() {
        return 2131566978;
    }

    public final void onUnload() {
    }

    public final void xq() {
        Button r0 = this.b;
        if (r0 == null) goto L6;
        r0.setOnClickListener(t0.a);
        return;
    }

    public LiveMediaReviewingWidget() {
        this.a = InfraKotlinExtsKt.mainThreadLazy(LiveMediaReviewingWidget$compositeDisposable$2.INSTANCE);
    }

    public final void onInit(Object[] r5) {
        this.f = RoomContext.a.c(RoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        this.b = (Button) ((Widget) this).contentView.findViewById(2131378417);
        this.c = (ImageView) ((Widget) this).contentView.findViewById(2131378414);
        TextView r6 = (TextView) ((Widget) this).contentView.findViewById(2131378415);
        this.e = r6;
        if (r6 == null) goto L5;
        r6.setSelected(false);
    L5:
        this.d = (TextView) ((Widget) this).contentView.findViewById(2131378416);
        RoomContext r7 = this.f;
        if (r7 == null) goto L10;
        com.bytedance.live.datacontext.m r8 = r7.getMediaReviewStatus();
        if (r8 == null) goto L10;
        Integer r9 = (Integer) r8.getValue();
    L11:
        wq(r9);
        RoomContext r10 = this.f;
        if (r10 == null) goto L21;
        com.bytedance.live.datacontext.m r11 = r10.getMediaReviewStatus();
        if (r11 == null) goto L22;
        Observable r12 = r11.a();
        if (r12 == null) goto L23;
        Disposable r13 = r12.subscribe(new a(this));
        if (r13 == null) goto L24;
        Intrinsics.checkNotNullParameter(r13, "$this$bind");
        ((CompositeDisposable) this.a.getValue()).add(r13);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L10:
        r9 = null;
        goto L11
    }

    public final void onLoad(Object[] r2) {
        xq();
        TextView r3 = this.e;
        if (r3 == null) goto L6;
        r3.setSelected(true);
        return;
    }

    public final void wq(Integer r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.intValue() == 2) goto L7;
        return;
    L7:
        TextView r3 = this.d;
        if (r3 == null) goto L10;
        r3.setText(com.bytedance.android.live.core.utils.s1.B(2131920326));
    L10:
        TextView r4 = this.e;
        if (r4 == null) goto L13;
        r4.setText(com.bytedance.android.live.core.utils.s1.B(2131920322));
    L13:
        ImageView r5 = this.c;
        if (r5 == null) goto L16;
        r5.setImageDrawable(com.bytedance.android.live.core.utils.s1.m(2131252333));
    L16:
        Button r6 = this.b;
        if (r6 == null) goto L19;
        r6.setVisibility(0);
    L19:
        xq();
    }
}

package com.bytedance.android.livesdk.interactivity.comment.record.view;

import android.os.Message;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.api.record.LiveScreenRecordGuideConfig;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.record.RecordDragContainer;
import com.bytedance.android.livesdk.chatroom.viewmodule.record.RecordDragParentView;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.comment.record.event.HighlightRecordEvent;
import com.bytedance.android.livesdk.interactivity.comment.record.guide.RecordGuideContext;
import com.bytedance.android.livesdk.interactivity.comment.record.viewmodel.HighlightRecordContext;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.j;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import t70.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/record/view/LiveHighlightRecordTetris;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LiveTetris;", "Ld90/d;", "Lcom/bytedance/common/utility/collection/WeakHandler$IHandler;", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "StopType", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveHighlightRecordTetris extends LiveTetris<d90.d> implements WeakHandler.IHandler, Observer<KVData> {
    public final String o;
    public final CompositeDisposable p;
    public RecordDragParentView q;
    public LiveHighlightRecordController r;
    public int s;
    public final long t;
    public final int u;
    public final int v;
    public WeakHandler w;
    public com.bytedance.android.livesdk.interactivity.comment.record.guide.b x;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/record/view/LiveHighlightRecordTetris$StopType;", BuildConfig.FLAVOR, "OverTime", "UserClick", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum StopType extends Enum<StopType> {
        public static final StopType OverTime = null;
        public static final StopType UserClick = null;
        public static final /* synthetic */ StopType[] a = null;

        static {
            StopType r1 = new StopType("OverTime", 0);
            OverTime = r1;
            StopType r2 = new StopType("UserClick", 1);
            UserClick = r2;
            a = new StopType[]{r1, r2};
        }

        public static StopType valueOf(String r1) {
            return (StopType) r27.a.a(StopType.class, r1);
        }

        public static StopType[] values() {
            return (StopType[]) a.clone();
        }

        public StopType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final void O() {
    }

    public final HighlightRecordContext V() {
        HighlightRecordContext.b r0 = HighlightRecordContext.Companion;
        MiddlewareRoomContext r1 = K().e;
        DataCenter r2 = K().h;
        r0.getClass();
        return HighlightRecordContext.b.a(r1, r2);
    }

    public final void W() {
        LiveHighlightRecordController r0 = this.r;
        if (r0 == null) goto L8;
        r0.a();
        RecordDragParentView r2 = r0.l;
        View r3 = r2.a;
        if (r3 == null) goto L7;
        r2.removeView(r3);
    L7:
        r2.a = null;
        UtilityKotlinExtentionsKt.t(r0.l);
        r0.b = 0;
    L8:
        this.s = 0;
        WeakHandler r1 = this.w;
        if (r1 == null) goto L11;
        r1.removeMessages(this.v);
    L11:
        WeakHandler r4 = this.w;
        if (r4 == null) goto L15;
        r4.removeMessages(this.u);
        return;
    }

    public final void Z() {
        if (this.s >= this.t) goto L6;
        f2.c("最少录制" + this.t + 31186, 0);
        return;
    L6:
        W();
        HighlightRecordContext r0 = V();
        if (r0 == null) goto L10;
        r0.reqRecord(false);
        return;
    }

    public LiveHighlightRecordTetris() {
        this.o = "LiveHighlightRecordTetris";
        this.p = new CompositeDisposable();
        LiveScreenRecordGuideConfig.c.getClass();
        this.t = LiveScreenRecordGuideConfig.a.b().e();
        this.u = 1;
        this.v = 2;
    }

    public final void onCreate() {
        super/*com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris*/.onCreate();
        DataCenter r0 = K().h;
        if (r0 == null) goto L5;
        r0.observe("cmd_playfragment_visible", this);
    L5:
        com.bytedance.revenue.platform.api.core.rx.f.a(RxUtilKt.h(xs2.b.a().b(HighlightRecordEvent.class)).subscribe(new e(this)), this.p);
        HighlightRecordContext r1 = V();
        if (r1 == null) goto L9;
        com.bytedance.revenue.platform.api.core.rx.f.a(RxUtilKt.h(r1.getRecordReqStart()).subscribe(new a(this)), this.p);
        com.bytedance.revenue.platform.api.core.rx.f.a(RxUtilKt.h(r1.getRecordReqStop()).subscribe(new b(this)), this.p);
        com.bytedance.revenue.platform.api.core.rx.f.a(RxUtilKt.h(r1.getClickRecordStopBtn()).subscribe(new c(this)), this.p);
        com.bytedance.revenue.platform.api.core.rx.f.a(RxUtilKt.h(r1.getCancelRecord()).subscribe(new d(this)), this.p);
        return;
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris*/.onDestroy();
        WeakHandler r0 = this.w;
        if (r0 == null) goto L5;
        r0.removeMessages(this.v);
    L5:
        WeakHandler r1 = this.w;
        if (r1 == null) goto L8;
        r1.removeMessages(this.u);
    L8:
        this.p.clear();
        HighlightRecordContext r2 = V();
        if (r2 == null) goto L11;
        r2.release();
    L11:
        com.bytedance.android.livesdk.interactivity.comment.record.guide.b r3 = this.x;
        if (r3 == null) goto L18;
        com.bytedance.android.livesdk.interactivity.comment.record.guide.d r4 = r3.a;
        if (r4 == null) goto L18;
        RecordGuideContext r5 = r4.B();
        if (r5 == null) goto L18;
        r5.release();
    L18:
        this.x = null;
    }

    public final View G(k r5) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        View r6 = r5.b(2131567849);
        MiddlewareRoomContext r0 = K().e;
        if (r0 == null) goto L7;
        j r1 = r0.getHighlightRecordContext();
        if (r1 == null) goto L7;
        r1.e(new LiveHighlightRecordTetris$initView$1(this));
    L7:
        this.q = r6.findViewById(2131370212);
        View r2 = LayoutInflater.from(K().getContext()).inflate(2131567685, this.q, false);
        if ((r2 instanceof RecordDragContainer) == true) goto L10;
        r2 = null;
    L10:
        RecordDragContainer r3 = (RecordDragContainer) r2;
        RecordDragParentView r4 = this.q;
        if (r4 == null) goto L14;
        if (r3 == null) goto L14;
        this.r = new LiveHighlightRecordController(V(), r4, r3);
    L14:
        this.w = new WeakHandler(this);
        return r6;
    }

    public final void handleMsg(Message r13) {
        String r0 = null;
        if (r13 == null) goto L5;
        Integer r1 = Integer.valueOf(r13.what);
    L6:
        int r2 = this.u;
        if (r1 != null) goto L10;
    L19:
        int r3 = this.v;
        if (r1 != null) goto L23;
        return;
    L23:
        if (r1.intValue() != r3) goto L58;
        long r4 = SystemClock.uptimeMillis();
        Object r5 = r13.obj;
        if (r5 == null) goto L56;
        long r6 = r4 - ((Long) r5).longValue();
        Object r14 = r13.obj;
        if (r14 == null) goto L54;
        long r7 = ((Long) r14).longValue();
        long r8 = r6 / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        int r15 = (int) r8;
        this.s = r15;
        long r9 = r15;
        HighlightRecordContext r16 = V();
        if (r16 == null) goto L37;
        com.bytedance.android.livesdk.interactivity.comment.highlight.d r17 = r16.getRecordResponse();
        if (r17 == null) goto L37;
        com.bytedance.android.livesdk.interactivity.comment.highlight.c r18 = r17.b();
        if (r18 == null) goto L37;
        Long r19 = r18.a();
        if (r19 == null) goto L37;
        long r10 = r19.longValue();
    L39:
        if (r9 < r10) goto L43;
        WeakHandler r110 = this.w;
        if (r110 == null) goto L43;
        r110.sendEmptyMessage(this.u);
    L43:
        long r11 = 60;
        long r20 = r8 / r11;
        long r21 = r8 % r11;
        LiveHighlightRecordController r111 = this.r;
        if (r111 == null) goto L46;
        StringBuilder r23 = new StringBuilder();
        StringCompanionObject r24 = StringCompanionObject.INSTANCE;
        r23.append(String.format(Locale.getDefault(), "%02d", Arrays.copyOf(new Object[]{Long.valueOf(r20)}, 1)));
        r23.append(String.format(Locale.getDefault(), ":%02d ", Arrays.copyOf(new Object[]{Long.valueOf(r21)}, 1)));
        String r25 = r23.toString();
        Intrinsics.checkNotNullParameter(r25, "time");
        r111.e.setText(r25);
    L46:
        WeakHandler r112 = this.w;
        if (r112 == null) goto L59;
        Message r113 = r112.obtainMessage(this.v, Long.valueOf(r7));
        if (r113 == null) goto L60;
        WeakHandler r26 = this.w;
        if (r26 == null) goto L61;
        r26.sendMessageDelayed(r113, 300);
        return;
    L61:
        return;
    L60:
        return;
    L59:
        return;
    L37:
        r10 = 180;
        goto L39
    L54:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L56:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L58:
        return;
    L10:
        if (r1.intValue() != r2) goto L19;
        StopType r114 = StopType.OverTime;
        Z();
        HighlightRecordContext r115 = V();
        if (r115 == null) goto L18;
        com.bytedance.android.livesdk.interactivity.comment.highlight.d r116 = r115.getRecordResponse();
        if (r116 == null) goto L18;
        com.bytedance.android.livesdk.interactivity.comment.highlight.c r117 = r116.b();
        if (r117 == null) goto L18;
        r0 = r117.b();
    L18:
        f2.c(r0, 0);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        Intrinsics.checkNotNullParameter(r5, "kvData");
        String r0 = r5.getKey();
        if (r0.hashCode() == 1046302364) goto L6;
        return;
    L6:
        if (r0.equals("cmd_playfragment_visible") == true) goto L8;
        return;
    L8:
        if ((!Intrinsics.areEqual((Boolean) r5.getData(), Boolean.FALSE)) == true) goto L14;
        ALogger.i(this.o, "当前直播间不可见，停止录屏");
        HighlightRecordContext r6 = V();
        if (r6 == null) goto L15;
        r6.tryCancelRecord();
        return;
    L15:
        return;
    }
}

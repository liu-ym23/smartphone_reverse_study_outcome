package com.bytedance.android.live.room.navi.userinfo.util;

import android.view.View;
import com.bytedance.android.livesdk.utils.q4;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "T", "R", "Lcom/bytedance/android/livesdk/utils/q4;", "", "invoke", "(Lcom/bytedance/android/livesdk/utils/q4;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class LiveRoomUserInfoUtils$getAndStartReplaceAnim$controller$1 extends Lambda implements Function1<q4, Unit> {
    final /* synthetic */ long $durationInMs;
    final /* synthetic */ View $hideView;
    final /* synthetic */ Function2 $onEndOrCancel;
    final /* synthetic */ View $showView;

    /* JADX INFO: renamed from: com.bytedance.android.live.room.navi.userinfo.util.LiveRoomUserInfoUtils$getAndStartReplaceAnim$controller$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "T", "R", "Lcom/bytedance/android/livesdk/utils/q4;", "", "invoke", "(Lcom/bytedance/android/livesdk/utils/q4;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass3 extends Lambda implements Function1<q4, Unit> {
        final /* synthetic */ LiveRoomUserInfoUtils$getAndStartReplaceAnim$controller$1 this$0;

        public AnonymousClass3(LiveRoomUserInfoUtils$getAndStartReplaceAnim$controller$1 r1) {
            this.this$0 = r1;
            super(1);
        }

        public final void invoke(q4 r3) {
            Intrinsics.checkNotNullParameter(r3, "$receiver");
            r3.d(new AnonymousClass1(this));
            r3.a(this.this$0.$durationInMs);
            r3.d(new AnonymousClass2(this));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((q4) r1);
            return Unit.INSTANCE;
        }
    }

    public LiveRoomUserInfoUtils$getAndStartReplaceAnim$controller$1(View r1, View r2, Function2 r3, long r4) {
        this.$showView = r1;
        this.$hideView = r2;
        this.$onEndOrCancel = r3;
        this.$durationInMs = r4;
        super(1);
    }

    public final void invoke(q4 r2) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        r2.e = new AnonymousClass1(this);
        r2.f = new AnonymousClass2(this);
        r2.c(new AnonymousClass3(this));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((q4) r1);
        return Unit.INSTANCE;
    }
}

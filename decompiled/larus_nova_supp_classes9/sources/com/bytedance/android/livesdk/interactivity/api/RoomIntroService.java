package com.bytedance.android.livesdk.interactivity.api;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.interactivity.api.roomintro.api.RoomIntroApi;
import com.bytedance.android.livesdk.interactivity.api.settings.config.u0;
import com.bytedance.android.livesdk.interactivity.roomintro.view.RoomIntroDialog;
import com.bytedance.android.livesdk.interactivity.roomintro.view.RoomIntroDialogV2;
import com.bytedance.android.livesdk.interactivity.roomintro.view.b0;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import r52.a4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J|\u0010\u0014\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2#\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0017\u001a\u00020\u0016H\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/RoomIntroService;", "Lcom/bytedance/android/livesdk/interactivity/api/IRoomIntroService;", "Landroidx/fragment/app/FragmentActivity;", "activity", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "liveMode", BuildConfig.FLAVOR, "gameCategory", "Lgz/b;", "inputPoiStruct", "Lkotlin/Function1;", BuildConfig.FLAVOR, "poiChangeCallback", BuildConfig.FLAVOR, "Lkotlin/ParameterName;", "name", "isNewRoomIntroOn", "onRoomIntroChangeCallback", "openRoomIntroDialog", "(Landroidx/fragment/app/FragmentActivity;Lcom/bytedance/android/livesdkapi/depend/model/live/Room;Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;Ljava/lang/Long;Lgz/b;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", BuildConfig.FLAVOR, "getRoomIntroDialogTag", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RoomIntroService implements IRoomIntroService {
    public RoomIntroService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IRoomIntroService
    public String getRoomIntroDialogTag() {
        return "com.bytedance.android.livesdk.interactivity.roomintro.view.RoomIntroDialog";
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IRoomIntroService
    public void openRoomIntroDialog(FragmentActivity r11, Room r13, LiveMode r14, Long r15, gz.b r16, Function1<? super gz.b, Unit> r17, Function1<? super Boolean, Unit> r18) {
        if (((u0) a4.a.getValue()).a() == false) goto L12;
        int r1 = RoomIntroDialogV2.u;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r9 = new com.bytedance.android.livesdk.interactivity.roomintro.v2.c(r13, r14, r15, r16, r17, r18);
        Intrinsics.checkNotNullParameter(r9, "params");
        if (r11 == null) goto L27;
        Observable r2 = ((RoomIntroApi) com.bytedance.android.live.network.c.b().e(RoomIntroApi.class)).getRoomIntro(r9.d(), r9.c(), r9.b()).compose(RxUtil.rxSchedulerHelper());
        if (r2 == null) goto L22;
        ObservableSubscribeProxy r3 = (ObservableSubscribeProxy) r2.as(AutoDispose.bind(r11));
        if (r3 == null) goto L23;
        r3.subscribe(new com.bytedance.android.livesdk.interactivity.roomintro.view.m(r11, r9), new com.bytedance.android.livesdk.interactivity.roomintro.view.n(r11));
        return;
    L23:
        return;
    L22:
        return;
    L27:
        return;
    L12:
        int r4 = RoomIntroDialog.l;
        Intrinsics.checkNotNull(r11);
        b0 r5 = new b0(r13, r14, r15);
        Intrinsics.checkNotNullParameter(r11, "activity");
        Intrinsics.checkNotNullParameter(r5, "params");
        RoomIntroApi r6 = (RoomIntroApi) com.bytedance.android.live.network.c.b().e(RoomIntroApi.class);
        if (r13 == null) goto L15;
        Long r7 = Long.valueOf(r13.id);
    L16:
        Observable r8 = r6.getRoomIntro(r7, r5.c(), r5.b()).compose(RxUtil.rxSchedulerHelper());
        if (r8 == null) goto L25;
        ObservableSubscribeProxy r10 = (ObservableSubscribeProxy) r8.as(AutoDispose.bind(r11));
        if (r10 == null) goto L26;
        r10.subscribe(new com.bytedance.android.livesdk.interactivity.roomintro.view.a(r11, r5), new com.bytedance.android.livesdk.interactivity.roomintro.view.b(r11));
        return;
    L26:
        return;
    L25:
        return;
    L15:
        r7 = null;
        goto L16
    }
}

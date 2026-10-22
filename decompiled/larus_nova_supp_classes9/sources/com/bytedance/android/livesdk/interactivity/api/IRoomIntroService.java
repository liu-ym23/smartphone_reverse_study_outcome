package com.bytedance.android.livesdk.interactivity.api;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.api.RoomIntroService")
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J|\u0010\u0014\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2#\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\r\u0018\u00010\fH&¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0017\u001a\u00020\u0016H&¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/IRoomIntroService;", "Lcom/bytedance/android/live/base/IService;", "Landroidx/fragment/app/FragmentActivity;", "activity", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "liveMode", BuildConfig.FLAVOR, "gameCategory", "Lgz/b;", "inputPoiStruct", "Lkotlin/Function1;", BuildConfig.FLAVOR, "poiChangeCallback", BuildConfig.FLAVOR, "Lkotlin/ParameterName;", "name", "isNewRoomIntroOn", "onRoomIntroChangeCallback", "openRoomIntroDialog", "(Landroidx/fragment/app/FragmentActivity;Lcom/bytedance/android/livesdkapi/depend/model/live/Room;Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;Ljava/lang/Long;Lgz/b;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", BuildConfig.FLAVOR, "getRoomIntroDialogTag", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IRoomIntroService extends IService {
    String getRoomIntroDialogTag();

    void openRoomIntroDialog(FragmentActivity r1, Room r2, LiveMode r3, Long r4, gz.b r5, Function1<? super gz.b, Unit> r6, Function1<? super Boolean, Unit> r7);
}

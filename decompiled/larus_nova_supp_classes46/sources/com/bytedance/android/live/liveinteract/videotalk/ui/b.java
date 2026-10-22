package com.bytedance.android.live.liveinteract.videotalk.ui;

import android.graphics.Bitmap;
import android.view.View;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.gift.effect.normal.utils.BitmapTranslateUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.k;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import vm2.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ View a;
        public final /* synthetic */ DataCenter b;

        public a(View r1, DataCenter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            if (d.q0().isOpenSmoothViewMock() == true) goto L5;
            return;
        L5:
            if (this.a.getWidth() > 0) goto L7;
            return;
        L7:
            if (this.a.getHeight() <= 0) goto L12;
            Bitmap r5 = BitmapTranslateUtils.d(this.a);
            Objects.toString(r5);
            this.b.put("cmd_multi_leave_room_show_view_mock", r5);
            return;
        }
    }

    static {
    }

    public static void a(DataCenter r3) {
        if (r3 == null) goto L5;
        r3.put("not_multi_video_feed", Boolean.FALSE);
    L5:
        if (r3 == null) goto L7;
        r3.put("feed_live_enter_sei_version", 0);
    L7:
        if (r3 == null) goto L9;
        r3.put("feed_live_enter_ui_layout", 0);
    L9:
        if (r3 == null) goto L11;
        r3.put("feed_live_seat_list_model", new ArrayList());
    L11:
        if (r3 == null) goto L14;
        r3.put("feed_live_enter_sei_sub_scene", 0);
    L14:
        if (r3 == null) goto L17;
        r3.put("audio_ktv_current_sing_user_id", "");
    L17:
        if (r3 == null) goto L19;
        r3.put("audio_ktv_video_state_sei_data", null);
    L19:
        if (r3 == null) goto L21;
        r3.put("audio_ktv_sei_parse_result_data", null);
    L21:
        if (r3 == null) goto L23;
        r3.put("video_ktv_sei_model", null);
    L23:
        if (r3 == null) goto L25;
        r3.put("video_ktv_current_sing_user_id", "");
    L25:
        if (r3 == null) goto L28;
        r3.put("data_room_enter_info", null);
        return;
    }

    public static Disposable b(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "viewToCapture");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        k r1 = m.n(r3, null, 2).F1();
        if (r1 == null) goto L8;
        PublishSubject r4 = r1.onEvent();
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4.subscribe(new a(r2, r3));
    L8:
        return null;
    }
}

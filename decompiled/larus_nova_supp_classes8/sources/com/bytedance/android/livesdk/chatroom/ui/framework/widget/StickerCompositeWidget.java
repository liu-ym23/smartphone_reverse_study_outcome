package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/StickerCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerCompositeWidget extends MiddlewareRoomWidget implements Observer<KVData> {
    public a a;
    public final int b;

    public static final class a extends Handler {
        public final /* synthetic */ StickerCompositeWidget a;

        @Override // android.os.Handler
        public final void handleMessage(Message r3) {
            Intrinsics.checkNotNullParameter(r3, "msg");
            int r4 = r3.what;
            StickerCompositeWidget r0 = this.a;
            if (r4 != r0.b) goto L8;
            DataCenter r5 = ((Widget) r0).dataCenter;
            if (r5 == null) goto L9;
            r5.put("data_has_sticker_effective", Boolean.TRUE);
            return;
        L9:
            return;
        }

        public a(StickerCompositeWidget r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public StickerCompositeWidget() {
        this.b = 100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.observe("cmd_sticker_is_selected", this);
    L5:
        this.a = new a(this, Looper.getMainLooper());
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        a r1 = this.a;
        if (r1 == null) goto L8;
        r1.removeCallbacksAndMessages(null);
    L8:
        this.a = null;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (isViewValid() == false) goto L28;
        Object r0 = null;
        if (r5 == null) goto L7;
        String r1 = r5.getKey();
    L9:
        if (TextUtils.isEmpty(r1) == true) goto L29;
        if (r5 == null) goto L12;
        r0 = r5.getData();
    L12:
        if (r0 == null) goto L33;
        String r2 = r5.getKey();
        if (r2.hashCode() == 2002249609) goto L18;
        return;
    L18:
        if (r2.equals("cmd_sticker_is_selected") == true) goto L20;
        return;
    L20:
        if (((com.bytedance.android.live.broadcast.api.model.r0) r5.getData()) != null) goto L22;
        return;
    L22:
        if (isViewValid() == false) goto L35;
        a r6 = this.a;
        if (r6 == null) goto L32;
        r6.removeMessages(this.b);
        return;
    L32:
        return;
    L35:
        return;
    L33:
        return;
    L29:
        return;
    L7:
        r1 = null;
        goto L9
    }
}

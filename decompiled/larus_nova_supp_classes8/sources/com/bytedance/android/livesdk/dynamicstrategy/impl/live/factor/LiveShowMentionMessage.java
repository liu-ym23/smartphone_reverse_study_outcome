package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r52.c1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/live/factor/LiveShowMentionMessage;", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/DynamicFactor;", "", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveShowMentionMessage extends DynamicFactor<Integer> implements Observer<KVData> {
    public static final Long d = null;
    public b b;
    public final DataCenter c;

    public static final class a {
    }

    public static final class b extends Handler {
        public final /* synthetic */ LiveShowMentionMessage a;

        @Override // android.os.Handler
        public final void handleMessage(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            if (r2.what != 1009) goto L6;
            this.a.update(0);
            return;
        }

        public b(LiveShowMentionMessage r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        return 0;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_mention_chat_show_in_public_screen";
    }

    static {
        d = (Long) c1.a.getValue();
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
        this.b = new b(this, Looper.getMainLooper());
        this.c.observe("data_mention_message_show_in_public_screen", this);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
        this.c.removeObserver(this);
        b r0 = this.b;
        if (r0 == null) goto L5;
        r0.removeCallbacksAndMessages(null);
    L5:
        this.b = null;
    }

    public LiveShowMentionMessage(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.c = r2;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L19;
        String r6 = r5.getKey();
        if (r6.hashCode() == 1342535624) goto L9;
        return;
    L9:
        if (r6.equals("data_mention_message_show_in_public_screen") == false) goto L17;
        update(1);
        b r7 = this.b;
        if (r7 == null) goto L13;
        r7.removeMessages(1009);
    L13:
        b r8 = this.b;
        if (r8 == null) goto L18;
        r8.sendEmptyMessageDelayed(1009, d.longValue());
        return;
    L18:
        return;
    L17:
        return;
    }
}

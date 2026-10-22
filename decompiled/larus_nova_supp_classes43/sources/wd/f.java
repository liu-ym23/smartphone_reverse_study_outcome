package wd;

import com.bytedance.android.ec.adapter.api.handler.viewinterface.ECExternalViewGroupAction;
import com.bytedance.android.livesdk.livecommerce.room.widgets.start_live.StartLivePromotionButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface f {
    void a(StartLivePromotionButton r1);

    void addListener(Function3<? super f, ? super e, ? super ECExternalViewGroupAction, Unit> r1);

    void b(StartLivePromotionButton r1);

    void removeListener(Function3<? super f, ? super e, ? super ECExternalViewGroupAction, Unit> r1);
}

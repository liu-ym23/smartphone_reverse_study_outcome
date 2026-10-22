package dq1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.vs_impl.message.BizAdMsgPanelViewManager;
import com.bytedance.android.livesdk.chatroom.vs_impl.message.BusinessMsgView;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessConfigure;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface c {
    boolean a(BusinessConfigure r1);

    boolean c(String r1, BusinessConfigure r2);

    BusinessMsgView d(Context r1, AttributeSet r2, int r3);

    ur1.a f();

    BizAdMsgPanelViewManager g(DataCenter r1, Context r2, ViewGroup r3);

    void h(String r1, String r2, BusinessConfigure r3, Map<String, String> r4);

    String i(Long r1);
}

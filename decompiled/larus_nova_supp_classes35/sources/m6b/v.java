package m6b;

import com.bytedance.lark.pb.basic.v1.Message;
import com.larksuite.framework.utils.DeviceUtils;
import com.ss.android.lark.abtest.api.IABTestService;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.UIHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class v {
    public boolean a;
    public final Map<Integer, Double> b;

    public static final class a {
        public static final v a = null;

        static {
            a = new v();
        }
    }

    public static int a() {
        List r0 = com.ss.android.lark.monitor.abtest.a.a;
        if (((Boolean) ((IABTestService) ApiUtils.getApi(IABTestService.class)).getAbTestValue(zrb.a.class, true)).booleanValue() == false) goto L5;
        float r1 = 55.0f;
    L7:
        return (DeviceUtils.getScreenHeight(ImSdk.a.getContext()) / UIHelper.dp2px(r1)) + 1;
    L5:
        r1 = 20.0f;
        goto L7
    }

    public v() {
        this.a = false;
        HashMap r0 = new HashMap();
        this.b = r0;
        Integer r1 = Integer.valueOf(Message.Type.UNKNOWN.getValue());
        Double r2 = Double.valueOf(1.0d);
        r0.put(r1, r2);
        Integer r3 = Integer.valueOf(Message.Type.POST.getValue());
        Double r4 = Double.valueOf(2.0d);
        r0.put(r3, r4);
        Integer r5 = Integer.valueOf(Message.Type.FILE.getValue());
        Double r6 = Double.valueOf(1.5d);
        r0.put(r5, r6);
        r0.put(Integer.valueOf(Message.Type.TEXT.getValue()), r2);
        r0.put(Integer.valueOf(Message.Type.IMAGE.getValue()), r4);
        r0.put(Integer.valueOf(Message.Type.SYSTEM.getValue()), r2);
        r0.put(Integer.valueOf(Message.Type.AUDIO.getValue()), r2);
        Integer r7 = Integer.valueOf(Message.Type.SHARE_GROUP_CHAT.getValue());
        Double r8 = Double.valueOf(3.0d);
        r0.put(r7, r8);
        r0.put(Integer.valueOf(Message.Type.STICKER.getValue()), r4);
        r0.put(Integer.valueOf(Message.Type.MERGE_FORWARD.getValue()), r6);
        r0.put(Integer.valueOf(Message.Type.CALENDAR.getValue()), r8);
        r0.put(Integer.valueOf(Message.Type.CARD.getValue()), r8);
        r0.put(Integer.valueOf(Message.Type.MEDIA.getValue()), r4);
        r0.put(Integer.valueOf(Message.Type.SHARE_CALENDAR_EVENT.getValue()), r8);
        r0.put(Integer.valueOf(Message.Type.HONGBAO.getValue()), r4);
        r0.put(Integer.valueOf(Message.Type.VIDEO_CHAT.getValue()), Double.valueOf(2.5d));
        r0.put(Integer.valueOf(Message.Type.LOCATION.getValue()), Double.valueOf(3.5d));
        r0.put(Integer.valueOf(Message.Type.GENERAL_CALENDAR.getValue()), r8);
        r0.put(Integer.valueOf(Message.Type.TODO.getValue()), r8);
    }
}

package gm0;

import com.bytedance.android.live.room.api.messagewindow.trigger.TriggerId;
import com.bytedance.android.livesdk.message.model.m1;
import com.bytedance.android.livesdk.message.model.u1;
import com.bytedance.android.livesdk.message.model.y1;
import com.bytedance.android.livesdk.message.model.z1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.StringsKt;
import mm0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends gm0.a {
    public final m1 d;

    public static final class a {
    }

    static {
    }

    public final List<u71.b> b() {
        m1 r0 = this.d;
        if (r0 == null) goto L7;
        u1 r1 = r0.cardDisplayInfo;
        if (r1 == null) goto L7;
        z1 r2 = r1.triggerConfig;
    L8:
        int r3 = 0;
        if (r2 == null) goto L24;
        List r4 = r2.commonTriggerList;
        if (r4 == null) goto L24;
        Iterator r5 = r4.iterator();
    L14:
        if (r5.hasNext() == false) goto L24;
        y1 r6 = (y1) r5.next();
        DataCenter r7 = this.c;
        int r8 = r6.type;
        Long r9 = r6.value;
        m1 r10 = this.d;
        if (r10 == null) goto L20;
        Integer r11 = r10.type;
        if (r11 == null) goto L20;
        int r12 = r11.intValue();
    L21:
        lm0.a r13 = e.a(r7, r8, r9, r12);
        if (r13 == null) goto L14;
        ((ArrayList) this.a).add(r13);
    L20:
        r12 = 0;
    L24:
        if (r2 == null) goto L45;
        Map r14 = r2.customTriggerMap;
        if (r14 == null) goto L45;
        Iterator r15 = r14.entrySet().iterator();
    L29:
        if (r15.hasNext() == false) goto L45;
        Map.Entry r16 = (Map.Entry) r15.next();
        String r17 = (String) r16.getKey();
        if (r17.hashCode() != 1570418086) goto L29;
        if (r17.equals("before_ofchannel_finish") == false) goto L29;
        DataCenter r18 = this.c;
        int r19 = TriggerId.EXIT_MIC_TIME_LIMIT.getValue();
        Long r20 = StringsKt.toLongOrNull((String) r16.getValue());
        m1 r21 = this.d;
        if (r21 == null) goto L40;
        Integer r22 = r21.type;
        if (r22 == null) goto L40;
        int r23 = r22.intValue();
    L41:
        lm0.a r24 = e.a(r18, r19, r20, r23);
        if (r24 == null) goto L29;
        ((ArrayList) this.a).add(r24);
    L40:
        r23 = 0;
    L45:
        if (((ArrayList) this.a).isEmpty() == false) goto L55;
        DataCenter r25 = this.c;
        int r26 = TriggerId.ENTER_ROOM_TIME_LIMIT.getValue();
        m1 r27 = this.d;
        if (r27 == null) goto L51;
        Integer r28 = r27.type;
        if (r28 == null) goto L51;
        r3 = r28.intValue();
    L51:
        lm0.a r29 = e.a(r25, r26, 0L, r3);
        if (r29 == null) goto L55;
        ((ArrayList) this.a).add(r29);
    L55:
        return this.a;
    L7:
        r2 = null;
        goto L8
    }

    public b(m1 r1, DataCenter r2) {
        super(r2);
        this.d = r1;
    }
}

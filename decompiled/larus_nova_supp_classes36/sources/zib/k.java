package zib;

import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.forwardv3.ForwardModuleV3;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.forwardv3.data.ForwardTargetChatterInfo;
import com.ss.android.lark.forwardv3.data.ForwardTargetGroupChatInfo;
import com.ss.android.lark.forwardv3.data.ForwardTargetThreadInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k implements Runnable {
    public final /* synthetic */ e.b a;

    public k(e.b r1) {
        this.a = r1;
    }

    public final void a() {
        e.b r0 = this.a;
        r0.getClass();
        a r1 = ForwardModuleV3.a().getEventParams(r0.b);
        if (r1 == null) goto L48;
        int r2 = r0.c.size();
        boolean r3 = !TextUtils.isEmpty(r0.a);
        ArrayList r5 = new ArrayList();
        Iterator<T> r4 = r0.c.iterator();
    L7:
        if (r4.hasNext() == false) goto L24;
        ForwardTargetBaseInfoNew r6 = (ForwardTargetBaseInfoNew) r4.next();
        int r7 = r6.getType();
        if (r7 != 1) goto L11;
        if ((r6 instanceof ForwardTargetGroupChatInfo) == false) goto L7;
        r5.add(((ForwardTargetGroupChatInfo) r6).j);
        goto L7
    L11:
        if (r7 != 2) goto L13;
        if ((r6 instanceof ForwardTargetChatterInfo) == false) goto L7;
        r5.add(((ForwardTargetChatterInfo) r6).h);
        goto L7
    L13:
        if (r7 != 3) goto L7;
        if ((r6 instanceof ForwardTargetThreadInfo) == false) goto L7;
        r5.add(((ForwardTargetThreadInfo) r6).g.getId());
        goto L7
    L24:
        JSONArray r8 = new JSONArray();
        Iterator<T> r9 = r1.e.values().iterator();
    L26:
        if (r9.hasNext() == false) goto L28;
        Message r10 = (Message) r9.next();
        r8.put(new JSONObject().put("id", r10.getId()).put("message_type", r10.getType().getNumber()));
        goto L26
    L28:
        JSONObject r11 = new JSONObject().put("user_unique_id", r1.a).put("receiver_num", r2).put("is_postscript", r3).put("chat_type", r1.d).put("chat_aim_id", r5).put("chat_id", r1.b).put("messages", r8).put("thread_id", r1.c);
        Log.d("ForwardHitPointV3", "message forward hit point: " + r11);
        Statistics.sendEvent("message_forward", r11);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

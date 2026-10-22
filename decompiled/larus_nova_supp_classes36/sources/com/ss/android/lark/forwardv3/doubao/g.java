package com.ss.android.lark.forwardv3.doubao;

import android.os.Bundle;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.forwardv3.data.ForwardTargetChatterInfo;
import com.ss.android.lark.forwardv3.data.ForwardTargetGroupChatInfo;
import com.ss.android.lark.forwardv3.data.ForwardTargetShieldP2PChatInfo;
import com.ss.android.lark.forwardv3.data.ForwardTargetThreadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g {
    public static final Bundle a(Map r13) {
        ArrayList<String> r0 = new ArrayList(r13.size());
        ArrayList<String> r1 = new ArrayList(r13.size());
        ArrayList<String> r2 = new ArrayList(r13.size());
        ArrayList<String> r3 = new ArrayList(r13.size());
        ArrayList<String> r4 = new ArrayList(r13.size());
        ArrayList<Integer> r5 = new ArrayList(r13.size());
        ArrayList<String> r6 = new ArrayList(r13.size());
        Iterator r14 = r13.entrySet().iterator();
    L4:
        if (r14.hasNext() == false) goto L18;
        Map.Entry r7 = (Map.Entry) r14.next();
        String r8 = (String) r7.getKey();
        ForwardTargetBaseInfoNew r9 = (ForwardTargetBaseInfoNew) r7.getValue();
        npc.c r10 = new npc.c();
        String r11 = r9.a;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r10.a = r11;
        String r12 = r9.c;
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r10.b = r12;
        String r15 = r9.b;
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r10.c = r15;
        if ((r9 instanceof ForwardTargetChatterInfo) == false) goto L9;
        r10.e = 1;
    L17:
        r0.add(r8);
        r1.add(r10.a);
        r2.add(r10.b);
        r3.add(r10.c);
        r4.add(r10.d);
        r5.add(Integer.valueOf(r10.e));
        r6.add(r10.f);
        goto L4
    L9:
        if ((r9 instanceof ForwardTargetShieldP2PChatInfo) == false) goto L12;
        r10.e = 1;
        goto L17
    L12:
        if ((r9 instanceof ForwardTargetGroupChatInfo) == false) goto L15;
        r10.e = 2;
        goto L17
    L15:
        if ((r9 instanceof ForwardTargetThreadInfo) == false) goto L17;
        r10.e = 3;
        String r16 = ((ForwardTargetThreadInfo) r9).h;
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r10.d = r16;
        goto L17
    L18:
        Bundle r17 = new Bundle();
        r17.putStringArrayList("doubao_forward_result_message_ids", r0);
        r17.putStringArrayList("doubao_forward_result_target_ids", r1);
        r17.putStringArrayList("doubao_forward_result_avatar_keys", r2);
        r17.putStringArrayList("doubao_forward_result_names", r3);
        r17.putStringArrayList("doubao_forward_result_thread_ids", r4);
        r17.putIntegerArrayList("doubao_forward_result_target_types", r5);
        r17.putStringArrayList("doubao_forward_result_p2p_chat_ids", r6);
        return r17;
    }
}

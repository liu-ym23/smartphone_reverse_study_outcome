package com.ss.android.lark.chat.chatwindow.chat.model.push;

import com.larksuite.framework.utils.AndroidThrottle;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements AndroidThrottle.d<MessageInfo> {
    public final Map<String, MessageInfo> a;

    public final synchronized void clear() {
        monitor-enter(this);
        monitor-exit(this);
    }

    public final Collection a() {
        ArrayList r0 = new ArrayList(((LinkedHashMap) this.a).values());
        Collections.sort(r0);
        ((LinkedHashMap) this.a).clear();
        return r0;
    }

    public final int size() {
        return this.a.size();
    }

    public b() {
        this.a = new LinkedHashMap();
    }

    public final void put(Object r12) {
        MessageInfo r13 = (MessageInfo) r12;
        if (r13 == null) goto L31;
        Log.d("chatwindow", "DistinctPushMessageBuffer: put called , msgId: " + r13.getId());
        Message r0 = r13.getMessage();
        String r2 = r0.getId();
        MessageInfo r3 = (MessageInfo) ((LinkedHashMap) this.a).get(r2);
        if (r3 == null) goto L26;
        Message r4 = r3.getMessage();
        Log.d("chatwindow", "newMessage: " + r13 + " \n ; lastMessage: " + r3);
        Message.Type r5 = r0.getType();
        Message.Type r6 = Message.Type.AUDIO;
        if (r5 != r6) goto L15;
        if (r4.getType() != r6) goto L15;
        int r7 = q3b.a.a;
        if ((!FeatureGatingModule.getFeatureGatingService().isEnable("im.message.audio_text_result_disable")) == false) goto L15;
        q3b.a.a(r4.getContent(), r0.getContent());
    L15:
        if (r4.getUpdateTime() >= r0.getUpdateTime()) goto L18;
        this.a.put(r0.getId(), r13);
        Log.i("chatwindow", "update message in buffer: " + r2);
        return;
    L18:
        if (r4.getUpdateTime() != r0.getUpdateTime()) goto L25;
        Intrinsics.checkNotNullParameter(r13, "newValue");
        Intrinsics.checkNotNullParameter(r3, "oldValue");
        if (r13.getMessage().isDing() == false) goto L22;
    L23:
        r13.getMessage().setDing(true);
    L24:
        this.a.put(r0.getId(), r13);
        Log.i("chatwindow", "merge message in buffer: " + r2);
        return;
    L22:
        if (r3.getMessage().isDing() == false) goto L24;
    L25:
        Log.i("chatwindow", "filter update message in buffer: " + r2);
        return;
    L26:
        this.a.put(r0.getId(), r13);
        return;
    }
}

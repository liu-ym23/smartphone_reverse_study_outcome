package com.ss.android.lark.chat.chatwindow.chat.model.preload.audio;

import android.text.TextUtils;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.im.api.extension.message.f;
import com.ss.android.lark.biz.im.api.extension.message.g;
import com.ss.android.lark.chat.constant.ChatFromType;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.log.Log;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class AudioResourceLoadTask extends g {

    public static final class a {
    }

    static {
    }

    public final String getTaskType() {
        return "audio";
    }

    public final Set<String> getScenes() {
        HashSet r0 = new HashSet();
        r0.add("chat");
        r0.add(ChatFromType.CHAT_THREAD);
        r0.add(ChatFromType.REPLY_IN_THREAD);
        return r0;
    }

    public AudioResourceLoadTask(f r2) {
        Intrinsics.checkNotNullParameter(r2, "loadTaskContext");
        super(r2);
    }

    public final boolean c(Set<? extends MessageInfo> r3) {
        Intrinsics.checkNotNullParameter(r3, "messageInfoList");
        return a(r3, false, null);
    }

    public final boolean d(Message.Type r2) {
        Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
        if (r2 != Message.Type.AUDIO) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean e(Set<? extends MessageInfo> r2, IGetDataCallback<Map<String, String>> r3) {
        return a(r2, true, r3);
    }

    public final boolean a(Set<? extends MessageInfo> r9, final boolean r10, final IGetDataCallback<Map<String, String>> r11) {
        Log.i("AudioResourceLoadTask", "load audio forceLoad =" + r10);
        final HashMap r4 = new HashMap();
        final HashMap r5 = new HashMap();
        Iterator<? extends MessageInfo> r12 = r9.iterator();
    L4:
        if (r12.hasNext() == false) goto L25;
        MessageInfo r0 = r12.next();
        if (r0 == null) goto L8;
        Message r2 = r0.getMessage();
    L9:
        if (r2 == null) goto L4;
        if (r0.getMessage().getType() != Message.Type.AUDIO) goto L4;
        Message r3 = r0.getMessage();
        AudioContent r6 = (AudioContent) r3.getContent();
        String r7 = r6.getKey();
        if (TextUtils.isEmpty(r7) == true) goto L4;
        if (r10 == true) goto L21;
        if (TextUtils.isEmpty(r6.getLocalFilePath()) == true) goto L21;
        if (r6.getAudioWaveBytes() != null) goto L4;
    L21:
        if (TextUtils.equals(r3.getId(), r3.getcId()) == true) goto L4;
        String r8 = r3.getId();
        r4.put(r7, r8);
        r5.put(r8, r0);
        goto L4
    L8:
        r2 = null;
        goto L9
    L25:
        if (CollectionUtils.isEmpty(r4) == false) goto L28;
        return false;
    L28:
        if (r10 == false) goto L33;
        Iterator r13 = r4.entrySet().iterator();
    L31:
        if (r13.hasNext() == false) goto L33;
        Map.Entry r1 = (Map.Entry) r13.next();
        Log.i("AudioResourceLoadTask", "forceFetch audio key:" + ((String) r1.getKey()) + ", messageId:" + ((String) r1.getValue()));
    L33:
        Log.d("AudioResourceLoadTask", "prepareAudioMessage1:" + r4.size());
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new AudioResourceLoadTask$load$2(r10, r4, r5, this, r11));
        return true;
    }
}

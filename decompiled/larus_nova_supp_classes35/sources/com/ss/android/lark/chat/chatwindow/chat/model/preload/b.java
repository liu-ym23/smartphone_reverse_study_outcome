package com.ss.android.lark.chat.chatwindow.chat.model.preload;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.extension.message.TaskType;
import com.ss.android.lark.chat.core.api.e;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface b {
    void a(e r1);

    void b(List<? extends MessageInfo> r1);

    void c(@TaskType String r1, List<? extends MessageInfo> r2, String r3, String r4, IGetDataCallback<Map<String, String>> r5);

    void destroy();
}

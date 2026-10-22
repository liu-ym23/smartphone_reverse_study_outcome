package com.ss.android.lark.integrator.im.chat.core.dependency;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.Message;
import com.bytedance.lark.pb.media.v1.GetFileStateRequest;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.download.service.FileState;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements w4b.j {
    public static final Map<aqb.b, wbb.b> a = null;

    public f() {
    }

    static {
        a = new ConcurrentHashMap();
    }

    public final void a(com.ss.android.lark.chat.chatwindow.chat.v2.push.f.b r3) {
        ConcurrentHashMap r0 = (ConcurrentHashMap) a;
        wbb.b r1 = (wbb.b) r0.get(r3);
        if (r1 == null) goto L13;
        r0.remove(r3);
        vbb.a.a().getClass();
        com.ss.android.lark.download.service.impl.a r4 = com.ss.android.lark.download.service.impl.a.c.a;
        r4.c.remove(r1);
        if (((HashMap) r4.a).size() == 0) goto L7;
        return;
    L7:
        if (r4.e.size() != 0) goto L15;
        r4.f = false;
        com.ss.android.lark.http.netstate.c r2 = r4.b;
        com.ss.android.lark.download.service.impl.b r5 = r4.d;
        if (r5 == null) goto L11;
        r2.c.remove(r5);
        return;
    L11:
        r2.getClass();
        return;
    L15:
        return;
    }

    public final void b(com.ss.android.lark.chat.chatwindow.chat.v2.push.f.b r3) {
        e r0 = new e(r3);
        ((ConcurrentHashMap) a).put(r3, r0);
        vbb.a.a().getClass();
        com.ss.android.lark.download.service.impl.a r4 = com.ss.android.lark.download.service.impl.a.c.a;
        r4.c.add(r0);
        if (r4.d != null) goto L6;
        r4.d = new com.ss.android.lark.download.service.impl.b(r4);
    L6:
        if (r4.f == true) goto L9;
        r4.f = true;
        r4.b.a(r4.d);
        return;
    }

    public final void c(String r3, String r4, int r5, String r6, final IGetDataCallback r7) {
        if (r7 == null) goto L5;
        IGetDataCallback<FileState> r1 = new DownloadDependencyImpl$2(this, r7);
    L6:
        vbb.a.a().getClass();
        GetFileStateRequest.Builder r8 = new GetFileStateRequest.Builder().message_id(r3).file_key(r6);
        if (TextUtils.isEmpty(r4) == true) goto L9;
        r8.source_id(r4);
    L9:
        Message.SourceType r9 = Message.SourceType.fromValue(r5);
        if (r9 == null) goto L12;
        r8.source_type(r9);
    L12:
        r8.options(com.ss.android.lark.download.service.impl.j.b(null, r6, null));
        Log.i("DownloadFile", "downloadFileScene:-99");
        SdkSender.asynSendRequestNonWrap(Command.GET_FILE_STATE, r8, r1, new com.ss.android.lark.download.service.impl.h());
        return;
    L5:
        r1 = null;
        goto L6
    }
}

package com.ss.android.lark.chat.chatwindow.chat.v2.model.operation;

import com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarViewModel;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.chat.entity.message.content.FileState;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.log.Log;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class p implements Function1<f5b.b, f5b.b> {
    public final int a;
    public final long b;

    public final Object invoke(Object r4) {
        f5b.b r5 = (f5b.b) r4;
        if (r5 == null) goto L11;
        Message r0 = r5.getMessage();
        Message.Type r1 = r0.getType();
        r0.setSendStatus(SendStatus.SENDING);
        if (r1 != Message.Type.FILE) goto L8;
        FileContent r2 = (FileContent) r0.getContent();
        r2.setProgress(this.a);
        r2.setFileState(FileState.UPLOADING);
        r2.setSpeed(this.b);
        goto L11
    L8:
        if (r1 != Message.Type.MEDIA) goto L10;
        MediaContent r3 = (MediaContent) r0.getContent();
        r3.setUploadProgress(this.a);
        r3.setFileState(FileState.UPLOADING);
        goto L11
    L10:
        Log.i(TitlebarViewModel.LOG_TAG, "Unknown message typeunhandled Push Progress, message: " + r0);
    L11:
        return r5;
    }

    public p(int r1, long r2) {
        this.a = r1;
        this.b = r2;
    }
}

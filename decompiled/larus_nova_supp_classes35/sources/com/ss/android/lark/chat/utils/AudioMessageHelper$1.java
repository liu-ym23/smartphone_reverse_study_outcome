package com.ss.android.lark.chat.utils;

import android.text.TextUtils;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
class AudioMessageHelper$1 implements IGetDataCallback<String> {
    final /* synthetic */ AudioContent val$audioContent;

    public AudioMessageHelper$1(AudioContent r1) {
        this.val$audioContent = r1;
    }

    public void onError(ErrorResult r2) {
        Log.d(r2.toString());
        this.val$audioContent.setFileState(AudioContent.AudioState.DOWNLOAD);
    }

    public void onSuccess(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        this.val$audioContent.setFileState(AudioContent.AudioState.DOWNLOAD);
        return;
    L5:
        this.val$audioContent.setProgress(100);
        this.val$audioContent.setFileState(AudioContent.AudioState.DONE);
        this.val$audioContent.setLocalFilePath(r3);
        final AudioContent r4 = this.val$audioContent;
        if (r4 != null) goto L8;
        return;
    L8:
        if (r4.getAudioWaveBytes() == null) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r4.getLocalFilePath()) == true) goto L16;
        RxScheduledExecutor.justInIO(new a(r4));
        return;
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((String) r1);
    }
}

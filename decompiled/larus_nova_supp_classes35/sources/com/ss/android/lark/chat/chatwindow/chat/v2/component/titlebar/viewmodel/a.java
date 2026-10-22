package com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel;

import com.bytedance.lark.pb.contact.v1.PushFocusChatter;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkPush;
import com.larksuite.rucket.job.RucketJob;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface a {
    @SdkPush(1282)
    RucketJob<PushFocusChatter> focusChatterPush();
}

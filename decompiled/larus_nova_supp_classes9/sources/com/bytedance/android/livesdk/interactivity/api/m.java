package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$MessageModelType;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface m {
    void checkAndRegisterMessageListener(String r1);

    void deleteMessage(com.bytedance.android.livesdk.interactivity.api.publicscreen.i r1);

    List<com.bytedance.android.livesdk.interactivity.api.publicscreen.i> findMessageByType(PublicScreenConfig$MessageModelType r1);

    void insertMessage(com.bytedance.android.livesdk.interactivity.api.publicscreen.i r1);

    void modifyMessage(com.bytedance.android.livesdk.interactivity.api.publicscreen.i r1);
}

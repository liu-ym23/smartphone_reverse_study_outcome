package vr1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface t {
    String a(Context r1, String r2);

    com.bytedance.android.livesdk.chatroom.ui.record.e c(Activity r1, String r2);

    void d(ILiveRecordService.RecordStatus r1, DataCenter r2);

    boolean f(DataCenter r1);

    Intent getRecordPermissionIntent();

    boolean isRecording(DataCenter r1);

    void saveRecordPermissionIntent(Intent r1);

    void setClearScreen(boolean r1);
}

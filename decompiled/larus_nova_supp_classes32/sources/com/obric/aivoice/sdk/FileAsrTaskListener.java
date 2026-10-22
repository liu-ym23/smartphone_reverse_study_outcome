package com.obric.aivoice.sdk;

import com.obric.aivoice.TaskListener;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lcom/obric/aivoice/sdk/FileAsrTaskListener;", "Lcom/obric/aivoice/TaskListener$Stub;", "()V", "onTaskEvent", NameKeys.UnloadStrategy_No_Strategy, "taskId", NameKeys.UnloadStrategy_No_Strategy, "resp", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class FileAsrTaskListener extends TaskListener.Stub {
    @Override // com.obric.aivoice.TaskListener
    public abstract int onTaskEvent(String r1, String r2);

    public FileAsrTaskListener() {
    }
}

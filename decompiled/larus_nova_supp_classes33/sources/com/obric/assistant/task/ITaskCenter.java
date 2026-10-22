package com.obric.assistant.task;

import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH&¨\u0006\f"}, d2 = {"Lcom/obric/assistant/task/ITaskCenter;", "", "post", "", "newTask", "Lcom/obric/assistant/task/TaskEntry;", WindowEvent.WindowOpenPerfResult.CANCEL, "id", "", "get", "getAll", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ITaskCenter {
    void a(b r1);

    void cancel(String r1);

    b get(String r1);

    List<b> getAll();
}

package com.obric.memorydata.memory.utils;

import com.obric.memorydata.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/utils/EnablePinnedShortcutOperations;", "", "enable", "", BuildConfig.CHANNEL, "queryFinalState", "Lcom/obric/memorydata/memory/utils/PinnedShortcutState;", "onFailure", "error", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface b {
    void a();

    void a(Throwable r1);

    PinnedShortcutState b();

    void update();
}

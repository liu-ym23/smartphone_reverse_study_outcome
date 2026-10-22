package com.obric.assistant.interaction.impl.essentialtask.task.migration;

import android.content.Context;
import com.obric.memorydata.plugin_api.MemoryPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/task/migration/DataMigrationTask$Memory;", "Lcom/obric/assistant/interaction/impl/essentialtask/task/migration/DataMigrationTask;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DataMigrationTask$Memory extends DataMigrationTask {
    public DataMigrationTask$Memory(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, MemoryPlugin.PLUGIN_PKG_NAME, "com.obric.memorydata", "com.obric.memorydata.transfer");
    }
}

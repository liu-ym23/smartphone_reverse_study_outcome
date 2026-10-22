package com.obric.memorydata.memory.ui.list;

import android.os.Bundle;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/WearableMemoryListActivity;", "Lcom/obric/memorydata/memory/ui/list/MemoryListActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WearableMemoryListActivity extends MemoryListActivity {
    public WearableMemoryListActivity() {
    }

    @Override // com.obric.memorydata.memory.ui.list.MemoryListActivity, com.obric.memorydata.ui.BaseAuthActivity, com.obric.memorydata.ui.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r4) {
        if (r4 != null) goto L4;
        getIntent().putExtra(MemoryListActivity.ARG_TARGET_GLASSES, true);
        getIntent().putExtra("from", MemoryEventTracker.SourceType.WEARABLE_DEVICE.getValue());
    L4:
        super.onCreate(r4);
    }
}

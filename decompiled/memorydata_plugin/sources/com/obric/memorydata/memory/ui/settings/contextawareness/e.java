package com.obric.memorydata.memory.ui.settings.contextawareness;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.settingsharness.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\u0004"}, d2 = {"navigationState", "Lcom/obric/memorydata/ui/settingsharness/SettingsRowState;", "enabled", "", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class e {
    public static final /* synthetic */ com.obric.memorydata.ui.settingsharness.o a(boolean r0) {
        return b(r0);
    }

    private static final com.obric.memorydata.ui.settingsharness.o b(boolean r9) {
        if (r9 == false) goto L5;
        int r10 = R.string.context_awareness_enabled;
        String r2 = "context_awareness_enabled";
    L7:
        return new com.obric.memorydata.ui.settingsharness.o(false, false, false, null, (q) ZeusTransformUtils.preCheckCast(new q.b(ZeusTransformUtils.mapRes(r10, TypedValues.Custom.S_STRING, r2)), q.class, "com.obric.memorydata.plugin"), 15, null);
    L5:
        r10 = R.string.context_awareness_disabled;
        r2 = "context_awareness_disabled";
        goto L7
    }
}

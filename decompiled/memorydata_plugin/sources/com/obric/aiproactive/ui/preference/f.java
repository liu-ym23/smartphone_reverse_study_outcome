package com.obric.aiproactive.ui.preference;

import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000¨\u0006\u0003"}, d2 = {"resolveInterviewTrackerEnterFrom", "", AILabCheckPermissionTask.KEY_SOURCE, "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class f {
    public static final String a(String r1) {
        if (Intrinsics.areEqual(r1, "preference_page") == false) goto L5;
        return "preference";
    L5:
        return "home";
    }
}

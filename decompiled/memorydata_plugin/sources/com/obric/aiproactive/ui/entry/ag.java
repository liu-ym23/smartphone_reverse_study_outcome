package com.obric.aiproactive.ui.entry;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000\u001a\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0001H\u0000\u001a\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0001H\u0000¨\u0006\t"}, d2 = {"isAiProactiveUidValid", "", "userId", "", "resolveAiProactiveEntryGate", "Lcom/obric/aiproactive/ui/entry/AiProactiveEntryGate;", "aiProactiveDbReady", "resolveWakeUpGate", "Lcom/obric/aiproactive/ui/entry/WakeUpGate;", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ag {
    public static final AiProactiveEntryGate a(String r0, boolean r1) {
        if (a(r0) == false) goto L7;
        if (r1 == false) goto L7;
        return AiProactiveEntryGate.ALLOW;
    L7:
        return AiProactiveEntryGate.BLOCK;
    }

    public static final boolean a(String r3) {
        if (r3 == null) goto L5;
        String r4 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L6:
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L11;
        boolean r0 = true;
    L12:
        if (r0 == false) goto L17;
        if (Intrinsics.areEqual(r4, "0") == true) goto L17;
        return true;
    L17:
        return false;
    L11:
        r0 = false;
        goto L12
    L5:
        r4 = null;
        goto L6
    }
}

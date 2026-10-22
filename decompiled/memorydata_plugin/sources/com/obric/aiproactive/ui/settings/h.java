package com.obric.aiproactive.ui.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0012\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"PROACTIVE_UI_PREFERENCE_NAME", "", "PROACTIVE_INITIATIVE_LEVEL_KEY", "buildInitiativeLevelKey", "userId", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class h {
    public static final String a(String r2) {
        if (r2 == null) goto L5;
        String r3 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L6:
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L11;
    L14:
        return "proactive_initiative_level";
    L11:
        if (Intrinsics.areEqual(r3, "0") == true) goto L14;
        return "proactive_initiative_level_" + r3;
    L5:
        r3 = null;
        goto L6
    }
}

package com.obric.aiproactive.impl.livecard;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u0012\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"REQUIRED_LIVECARD_VERSION", "", "BUTTON_STYLE_LEFT", "", "BUTTON_STYLE_FULL_CENTER", "supportsAiSuggestionMultiButton", "", "versionCode", "shouldDismissKeyguardForExecuteButton", "actionExecuteInstruction", "ai_proactive_impl_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class m {
    public static final boolean a(int r1) {
        if (r1 < 8) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean a(String r2) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L10:
        return !r4;
    L5:
        if (StringsKt.isBlank(r3) == true) goto L8;
        r4 = false;
        goto L10
    }
}

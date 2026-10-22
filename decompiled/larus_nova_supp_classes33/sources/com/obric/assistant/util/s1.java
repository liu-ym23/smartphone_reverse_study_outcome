package com.obric.assistant.util;

import com.larus.bmhome.view.ChatInputText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class s1 implements ChatInputText.b {
    public final /* synthetic */ ObricMentionHighlightHelper.a a;

    public s1(ObricMentionHighlightHelper.a r1) {
        this.a = r1;
    }

    public final boolean y9(int r1, int r2) {
        if (r1 <= 0) goto L7;
        if (r2 != 0) goto L7;
        if (this.a.d() == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final boolean z9(int r1, int r2) {
        if (r1 <= 0) goto L7;
        if (r2 != 0) goto L7;
        if (this.a.d() == false) goto L7;
        return true;
    L7:
        return false;
    }
}

package com.ss.android.lark.chat.cot;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/cot/TextExtra;", "Lcom/ss/android/lark/chat/cot/CotBlockExtra;", "<init>", "()V", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextExtra implements CotBlockExtra {
    public static final TextExtra INSTANCE = null;

    static {
        INSTANCE = new TextExtra();
    }

    private TextExtra() {
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L6;
        return true;
    L6:
        if ((r3 instanceof TextExtra) == true) goto L9;
        return false;
    L9:
        TextExtra r4 = (TextExtra) r3;
        return true;
    }

    public int hashCode() {
        return 338769607;
    }

    public String toString() {
        return "TextExtra";
    }
}

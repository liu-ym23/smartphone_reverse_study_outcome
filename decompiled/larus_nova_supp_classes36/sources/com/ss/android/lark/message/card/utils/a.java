package com.ss.android.lark.message.card.utils;

import android.text.TextUtils;
import com.ss.android.lark.chat.entity.message.content.CardContent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(CardContent.CardHeader r2) {
        if (r2 != null) goto L6;
        return true;
    L6:
        if (TextUtils.isEmpty(r2.getMainTitle()) == true) goto L8;
    L10:
        return false;
    L8:
        if (TextUtils.isEmpty(r2.getTitle()) == false) goto L10;
        return true;
    }
}

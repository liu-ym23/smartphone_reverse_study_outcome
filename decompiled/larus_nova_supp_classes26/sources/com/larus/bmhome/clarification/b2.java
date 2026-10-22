package com.larus.bmhome.clarification;

import com.larus.im.bean.message.block.InteractionAskBlockStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b2 {
    public static final int a = 0;
    public static final int b = 0;
    public static final int c = 0;
    public static final int d = 0;

    static {
        a = InteractionAskBlockStatus.STATUS_UNKNOWN.getValue();
        b = InteractionAskBlockStatus.STATUS_PROCESSING.getValue();
        c = InteractionAskBlockStatus.STATUS_FINISH.getValue();
        d = InteractionAskBlockStatus.STATUS_CANCEL.getValue();
    }
}

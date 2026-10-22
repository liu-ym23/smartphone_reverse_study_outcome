package com.larus.bmhome.chat.cotdetail.list.cellstate.base;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/bmhome/chat/cotdetail/list/cellstate/base/ThreadMsgCellStateType;", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public @interface ThreadMsgCellStateType {
    public static final int BOT_LOADING = 101;
    public static final int BOT_REPLY = 100;
    public static final a Companion = null;
    public static final int EMPTY = 1;
    public static final int UN_KNOWN = 0;
    public static final int USER_FILE = 4;
    public static final int USER_IMAGE = 3;
    public static final int USER_TEXT = 2;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.a;
    }
}

package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/messagelist/render/cell/ListMode;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "NORMAL", "SELECT_MESSAGES_FOR_CALLER", "MULTI_SELECT", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ListMode extends Enum<ListMode> {
    public static final ListMode MULTI_SELECT = null;
    public static final ListMode NORMAL = null;
    public static final ListMode SELECT_MESSAGES_FOR_CALLER = null;
    public static final /* synthetic */ ListMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ListMode> getEntries() {
        return b;
    }

    static {
        ListMode r0 = new ListMode("NORMAL", 0);
        NORMAL = r0;
        ListMode r1 = new ListMode("SELECT_MESSAGES_FOR_CALLER", 1);
        SELECT_MESSAGES_FOR_CALLER = r1;
        ListMode r3 = new ListMode("MULTI_SELECT", 2);
        MULTI_SELECT = r3;
        ListMode[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ListMode[] values() {
        return (ListMode[]) a.clone();
    }

    public static ListMode valueOf(String r1) {
        return (ListMode) a.a(ListMode.class, r1);
    }

    public ListMode(String r1, int r2) {
        super(r1, r2);
    }
}

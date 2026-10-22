package com.bytedance.ai.applet.login;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/applet/login/DialogAction;", "", "<init>", "(Ljava/lang/String;I)V", "AGREE", "REJECT", "CLOSE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DialogAction extends Enum<DialogAction> {
    public static final DialogAction AGREE = null;
    public static final DialogAction CLOSE = null;
    public static final DialogAction REJECT = null;
    public static final /* synthetic */ DialogAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DialogAction> getEntries() {
        return b;
    }

    static {
        DialogAction r0 = new DialogAction("AGREE", 0);
        AGREE = r0;
        DialogAction r1 = new DialogAction("REJECT", 1);
        REJECT = r1;
        DialogAction r10 = new DialogAction("CLOSE", 2);
        CLOSE = r10;
        DialogAction[] r11 = {r0, r1, r10};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static DialogAction[] values() {
        return (DialogAction[]) a.clone();
    }

    public static DialogAction valueOf(String r1) {
        return (DialogAction) r27.a.a(DialogAction.class, r1);
    }

    public DialogAction(String r1, int r10) {
        super(r1, r10);
    }
}

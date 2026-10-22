package com.bytedance.ai.applet.login;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/applet/login/DialogAction;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum DialogAction extends Enum<DialogAction> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DialogAction f1721a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DialogAction f1722b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ DialogAction[] f1723c = null;

    static {
        DialogAction r5 = new DialogAction("AGREE", 0);
        f1721a = r5;
        DialogAction r10 = new DialogAction("REJECT", 1);
        f1722b = r10;
        DialogAction[] r11 = {r5, r10, new DialogAction("CLOSE", 2)};
        f1723c = r11;
        EnumEntriesKt.enumEntries(r11);
    }

    public DialogAction(String r5, int r10) {
        super(r5, r10);
    }

    public static DialogAction valueOf(String r5) {
        return (DialogAction) Enum.valueOf(DialogAction.class, r5);
    }

    public static DialogAction[] values() {
        return (DialogAction[]) f1723c.clone();
    }
}

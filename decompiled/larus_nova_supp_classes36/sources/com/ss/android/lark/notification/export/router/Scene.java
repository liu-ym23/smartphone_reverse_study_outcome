package com.ss.android.lark.notification.export.router;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.lark.inv.export.router.InvRouter$InviteExternalPage$Param$From;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/notification/export/router/Scene;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PROFILE", "SETTING", "UNKNOWN", "notification-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum Scene extends Enum<Scene> {
    public static final Scene PROFILE = null;
    public static final Scene SETTING = null;
    public static final Scene UNKNOWN = null;
    public static final /* synthetic */ Scene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<Scene> getEntries() {
        return b;
    }

    static {
        Scene r0 = new Scene("PROFILE", 0, InvRouter$InviteExternalPage$Param$From.PROFILE);
        PROFILE = r0;
        Scene r1 = new Scene("SETTING", 1, "setting");
        SETTING = r1;
        Scene r2 = new Scene("UNKNOWN", 2, InvRouter.UNKNOWN);
        UNKNOWN = r2;
        Scene[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static Scene[] values() {
        return (Scene[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static Scene valueOf(String r1) {
        return (Scene) a.a(Scene.class, r1);
    }

    public Scene(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}

package com.ss.android.lark.feed.export.feedcard.action;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/feed/export/feedcard/action/ActionScene;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "SHORTCUT", "FEED", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionScene extends Enum<ActionScene> {
    public static final ActionScene FEED = null;
    public static final ActionScene SHORTCUT = null;
    public static final /* synthetic */ ActionScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ActionScene> getEntries() {
        return b;
    }

    static {
        ActionScene r0 = new ActionScene("SHORTCUT", 0);
        SHORTCUT = r0;
        ActionScene r1 = new ActionScene("FEED", 1);
        FEED = r1;
        ActionScene[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ActionScene[] values() {
        return (ActionScene[]) a.clone();
    }

    public static ActionScene valueOf(String r1) {
        return (ActionScene) a.a(ActionScene.class, r1);
    }

    public ActionScene(String r1, int r2) {
        super(r1, r2);
    }
}

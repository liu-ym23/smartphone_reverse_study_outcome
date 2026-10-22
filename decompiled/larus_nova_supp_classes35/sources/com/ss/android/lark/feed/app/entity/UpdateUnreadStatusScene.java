package com.ss.android.lark.feed.app.entity;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/feed/app/entity/UpdateUnreadStatusScene;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "FEED_ITEM", "HALF_SCREEN", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UpdateUnreadStatusScene extends Enum<UpdateUnreadStatusScene> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ UpdateUnreadStatusScene[] $VALUES = null;
    public static final UpdateUnreadStatusScene FEED_ITEM = null;
    public static final UpdateUnreadStatusScene HALF_SCREEN = null;

    private static final /* synthetic */ UpdateUnreadStatusScene[] $values() {
        return new UpdateUnreadStatusScene[]{FEED_ITEM, HALF_SCREEN};
    }

    public static EnumEntries<UpdateUnreadStatusScene> getEntries() {
        return $ENTRIES;
    }

    static {
        FEED_ITEM = new UpdateUnreadStatusScene("FEED_ITEM", 0);
        HALF_SCREEN = new UpdateUnreadStatusScene("HALF_SCREEN", 1);
        UpdateUnreadStatusScene[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static UpdateUnreadStatusScene[] values() {
        return (UpdateUnreadStatusScene[]) $VALUES.clone();
    }

    public static UpdateUnreadStatusScene valueOf(String r1) {
        return (UpdateUnreadStatusScene) a.a(UpdateUnreadStatusScene.class, r1);
    }

    private UpdateUnreadStatusScene(String r1, int r2) {
        super(r1, r2);
    }
}

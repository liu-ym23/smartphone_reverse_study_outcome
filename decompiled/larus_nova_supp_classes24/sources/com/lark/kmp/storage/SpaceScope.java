package com.lark.kmp.storage;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/lark/kmp/storage/SpaceScope;", "", "scopeName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getScopeName", "()Ljava/lang/String;", "Global", "User", "lark-storage-kmp_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum SpaceScope extends Enum<SpaceScope> {
    public static final SpaceScope Global = null;
    public static final SpaceScope User = null;
    public static final /* synthetic */ SpaceScope[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String scopeName;

    public static EnumEntries<SpaceScope> getEntries() {
        return b;
    }

    static {
        SpaceScope r0 = new SpaceScope("Global", 0, "global");
        Global = r0;
        SpaceScope r1 = new SpaceScope("User", 1, "user");
        User = r1;
        SpaceScope[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static SpaceScope[] values() {
        return (SpaceScope[]) a.clone();
    }

    public final String getScopeName() {
        return this.scopeName;
    }

    public static SpaceScope valueOf(String r1) {
        return (SpaceScope) r27.a.a(SpaceScope.class, r1);
    }

    public SpaceScope(String r1, int r2, String r3) {
        super(r1, r2);
        this.scopeName = r3;
    }
}

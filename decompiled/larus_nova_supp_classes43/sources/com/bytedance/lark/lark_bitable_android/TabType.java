package com.bytedance.lark.lark_bitable_android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/bytedance/lark/lark_bitable_android/TabType;", "", "(Ljava/lang/String;I)V", "into", "Llark_bitable/proto/TabType;", "intoInt", "", "Main", "Stage", "Companion", "lark_bitable_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum TabType extends Enum<TabType> {
    public static final a Companion = null;
    public static final TabType Main = null;
    public static final TabType Stage = null;
    public static final /* synthetic */ TabType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TabType.values().length];
            r0[TabType.Main.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[TabType.Stage.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static EnumEntries<TabType> getEntries() {
        return b;
    }

    public static TabType valueOf(String r1) {
        return (TabType) r27.a.a(TabType.class, r1);
    }

    public static TabType[] values() {
        return (TabType[]) a.clone();
    }

    static {
        TabType r0 = new TabType("Main", 0);
        Main = r0;
        TabType r1 = new TabType("Stage", 1);
        Stage = r1;
        TabType[] r10 = {r0, r1};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
        Companion = new a();
    }

    public final lark_bitable.proto.TabType into() {
        int r0 = b.a[ordinal()];
        if (r0 == 1) goto L10;
        if (r0 != 2) goto L8;
        return lark_bitable.proto.TabType.VAR_TAB_TYPE_STAGE;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return lark_bitable.proto.TabType.VAR_TAB_TYPE_MAIN;
    }

    public final int intoInt() {
        int r0 = b.a[ordinal()];
        if (r0 != 1) goto L5;
        return 0;
    L5:
        if (r0 != 2) goto L8;
        return 1;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final TabType fromInt(int r1) {
        Companion.getClass();
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L8;
        return Stage;
    L8:
        throw new RuntimeException("Unmatched primitive enum value: TabType with ");
    L10:
        return Main;
    }

    public TabType(String r1, int r10) {
        super(r1, r10);
    }
}

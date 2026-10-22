package com.bytedance.lark.lark_bitable_android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/lark/lark_bitable_android/HomepageListType;", "", "(Ljava/lang/String;I)V", "into", "Llark_bitable/proto/HomepageListType;", "intoInt", "", "Recent", "Pin", "Favorite", "Workspace", "Unknown", "Companion", "lark_bitable_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum HomepageListType extends Enum<HomepageListType> {
    public static final a Companion = null;
    public static final HomepageListType Favorite = null;
    public static final HomepageListType Pin = null;
    public static final HomepageListType Recent = null;
    public static final HomepageListType Unknown = null;
    public static final HomepageListType Workspace = null;
    public static final /* synthetic */ HomepageListType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[HomepageListType.values().length];
            r0[HomepageListType.Recent.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[HomepageListType.Pin.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[HomepageListType.Favorite.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[HomepageListType.Workspace.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[HomepageListType.Unknown.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public static EnumEntries<HomepageListType> getEntries() {
        return b;
    }

    public static HomepageListType valueOf(String r1) {
        return (HomepageListType) r27.a.a(HomepageListType.class, r1);
    }

    public static HomepageListType[] values() {
        return (HomepageListType[]) a.clone();
    }

    static {
        HomepageListType r0 = new HomepageListType("Recent", 0);
        Recent = r0;
        HomepageListType r1 = new HomepageListType("Pin", 1);
        Pin = r1;
        HomepageListType r10 = new HomepageListType("Favorite", 2);
        Favorite = r10;
        HomepageListType r11 = new HomepageListType("Workspace", 3);
        Workspace = r11;
        HomepageListType r12 = new HomepageListType("Unknown", 4);
        Unknown = r12;
        HomepageListType[] r13 = {r0, r1, r10, r11, r12};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
        Companion = new a();
    }

    public final lark_bitable.proto.HomepageListType into() {
        int r0 = b.a[ordinal()];
        if (r0 == 1) goto L19;
        if (r0 == 2) goto L23;
        if (r0 == 3) goto L22;
        if (r0 == 4) goto L21;
        if (r0 != 5) goto L14;
        return lark_bitable.proto.HomepageListType.VAR_HOMEPAGE_LIST_TYPE_UNKNOWN;
    L14:
        throw new NoWhenBranchMatchedException();
    L21:
        return lark_bitable.proto.HomepageListType.VAR_HOMEPAGE_LIST_TYPE_WORKSPACE;
    L22:
        return lark_bitable.proto.HomepageListType.VAR_HOMEPAGE_LIST_TYPE_FAVORITE;
    L23:
        return lark_bitable.proto.HomepageListType.VAR_HOMEPAGE_LIST_TYPE_PIN;
    L19:
        return lark_bitable.proto.HomepageListType.VAR_HOMEPAGE_LIST_TYPE_RECENT;
    }

    public final int intoInt() {
        int r0 = b.a[ordinal()];
        if (r0 != 1) goto L5;
        return 0;
    L5:
        if (r0 != 2) goto L7;
        return 1;
    L7:
        if (r0 != 3) goto L9;
        return 2;
    L9:
        if (r0 != 4) goto L11;
        return 3;
    L11:
        if (r0 != 5) goto L14;
        return 4;
    L14:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final HomepageListType fromInt(int r1) {
        Companion.getClass();
        if (r1 == 0) goto L19;
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L22;
        if (r1 == 3) goto L21;
        if (r1 != 4) goto L14;
        return Unknown;
    L14:
        throw new RuntimeException("Unmatched primitive enum value: HomepageListType with ");
    L21:
        return Workspace;
    L22:
        return Favorite;
    L23:
        return Pin;
    L19:
        return Recent;
    }

    public HomepageListType(String r1, int r10) {
        super(r1, r10);
    }
}

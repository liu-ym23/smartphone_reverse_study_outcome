package com.bytedance.lark.lark_bitable_android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/lark/lark_bitable_android/HomepageAction;", "", "(Ljava/lang/String;I)V", "into", "Llark_bitable/proto/HomepageAction;", "intoInt", "", "Refresh", "LoadMore", "Delete", "CancelFavorite", "CancelPin", "OpenShare", "OpenMore", "OpenBitable", "SwitchListType", "OpenWorkSpacePanel", "Companion", "lark_bitable_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum HomepageAction extends Enum<HomepageAction> {
    public static final HomepageAction CancelFavorite = null;
    public static final HomepageAction CancelPin = null;
    public static final a Companion = null;
    public static final HomepageAction Delete = null;
    public static final HomepageAction LoadMore = null;
    public static final HomepageAction OpenBitable = null;
    public static final HomepageAction OpenMore = null;
    public static final HomepageAction OpenShare = null;
    public static final HomepageAction OpenWorkSpacePanel = null;
    public static final HomepageAction Refresh = null;
    public static final HomepageAction SwitchListType = null;
    public static final /* synthetic */ HomepageAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[HomepageAction.values().length];
            r0[HomepageAction.Refresh.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r0[HomepageAction.LoadMore.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r0[HomepageAction.Delete.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[HomepageAction.CancelFavorite.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[HomepageAction.CancelPin.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r0[HomepageAction.OpenShare.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r0[HomepageAction.OpenMore.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r0[HomepageAction.OpenBitable.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r0[HomepageAction.SwitchListType.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[HomepageAction.OpenWorkSpacePanel.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            a = r0;
        }
    }

    public static EnumEntries<HomepageAction> getEntries() {
        return b;
    }

    public static HomepageAction valueOf(String r1) {
        return (HomepageAction) r27.a.a(HomepageAction.class, r1);
    }

    public static HomepageAction[] values() {
        return (HomepageAction[]) a.clone();
    }

    static {
        HomepageAction r0 = new HomepageAction("Refresh", 0);
        Refresh = r0;
        HomepageAction r1 = new HomepageAction("LoadMore", 1);
        LoadMore = r1;
        HomepageAction r10 = new HomepageAction("Delete", 2);
        Delete = r10;
        HomepageAction r11 = new HomepageAction("CancelFavorite", 3);
        CancelFavorite = r11;
        HomepageAction r12 = new HomepageAction("CancelPin", 4);
        CancelPin = r12;
        HomepageAction r13 = new HomepageAction("OpenShare", 5);
        OpenShare = r13;
        HomepageAction r14 = new HomepageAction("OpenMore", 6);
        OpenMore = r14;
        HomepageAction r15 = new HomepageAction("OpenBitable", 7);
        OpenBitable = r15;
        HomepageAction r16 = new HomepageAction("SwitchListType", 8);
        SwitchListType = r16;
        HomepageAction r17 = new HomepageAction("OpenWorkSpacePanel", 9);
        OpenWorkSpacePanel = r17;
        HomepageAction[] r18 = {r0, r1, r10, r11, r12, r13, r14, r15, r16, r17};
        a = r18;
        b = EnumEntriesKt.enumEntries(r18);
        Companion = new a();
    }

    public final lark_bitable.proto.HomepageAction into() {
        switch(b.a[ordinal()]) {
            case 1: goto L16;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L23;
            case 5: goto L22;
            case 6: goto L21;
            case 7: goto L20;
            case 8: goto L19;
            case 9: goto L18;
            case 10: goto L17;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L17:
        return lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_OPEN_WORK_SPACE_PANEL;
    L18:
        return lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_SWITCH_LIST_TYPE;
    L19:
        return lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_OPEN_BITABLE;
    L20:
        return lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_OPEN_MORE;
    L21:
        return lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_OPEN_SHARE;
    L22:
        return lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_CANCEL_PIN;
    L23:
        return lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_CANCEL_FAVORITE;
    L24:
        return lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_DELETE;
    L25:
        return lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_LOAD_MORE;
    L16:
        return lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_REFRESH;
    }

    public final int intoInt() {
        switch(b.a[ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            default: goto L5;
        };
    L6:
        return 9;
    L7:
        return 8;
    L8:
        return 7;
    L9:
        return 6;
    L10:
        return 5;
    L11:
        return 4;
    L12:
        return 3;
    L13:
        return 2;
    L14:
        return 1;
    L15:
        return 0;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final HomepageAction fromInt(int r1) {
        Companion.getClass();
        switch(r1) {
            case 0: goto L16;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L17;
            default: goto L5;
        };
    L5:
        throw new RuntimeException("Unmatched primitive enum value: HomepageAction with ");
    L17:
        return OpenWorkSpacePanel;
    L18:
        return SwitchListType;
    L19:
        return OpenBitable;
    L20:
        return OpenMore;
    L21:
        return OpenShare;
    L22:
        return CancelPin;
    L23:
        return CancelFavorite;
    L24:
        return Delete;
    L25:
        return LoadMore;
    L16:
        return Refresh;
    }

    public HomepageAction(String r1, int r10) {
        super(r1, r10);
    }
}

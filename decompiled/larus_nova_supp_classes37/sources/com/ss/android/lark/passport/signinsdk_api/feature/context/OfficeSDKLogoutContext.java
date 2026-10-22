package com.ss.android.lark.passport.signinsdk_api.feature.context;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import lzb.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDKLogoutContext implements a {
    public final Action a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/feature/context/OfficeSDKLogoutContext$Action;", "", "<init>", "(Ljava/lang/String;I)V", "LOGOUT", "SWITCH", "DOUBAO_CHANGE_BINDING", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum Action extends Enum<Action> {
        public static final Action DOUBAO_CHANGE_BINDING = null;
        public static final Action LOGOUT = null;
        public static final Action SWITCH = null;
        public static final /* synthetic */ Action[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Action> getEntries() {
            return b;
        }

        static {
            Action r0 = new Action("LOGOUT", 0);
            LOGOUT = r0;
            Action r1 = new Action("SWITCH", 1);
            SWITCH = r1;
            Action r3 = new Action("DOUBAO_CHANGE_BINDING", 2);
            DOUBAO_CHANGE_BINDING = r3;
            Action[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static Action[] values() {
            return (Action[]) a.clone();
        }

        public static Action valueOf(String r1) {
            return (Action) r27.a.a(Action.class, r1);
        }

        public Action(String r1, int r2) {
            super(r1, r2);
        }
    }

    public OfficeSDKLogoutContext() {
        this(Action.LOGOUT);
    }

    public OfficeSDKLogoutContext(Action r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.a = r2;
    }
}

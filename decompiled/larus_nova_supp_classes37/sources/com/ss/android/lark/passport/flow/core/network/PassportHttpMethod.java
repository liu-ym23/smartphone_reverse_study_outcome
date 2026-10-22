package com.ss.android.lark.passport.flow.core.network;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/passport/flow/core/network/PassportHttpMethod;", "", "<init>", "(Ljava/lang/String;I)V", "GET", "POST", "DELETE", "PUT", "PATCH", "HEAD", "OPTIONS", "flow-passport-core_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum PassportHttpMethod extends Enum<PassportHttpMethod> {
    public static final PassportHttpMethod DELETE = null;
    public static final PassportHttpMethod GET = null;
    public static final PassportHttpMethod HEAD = null;
    public static final PassportHttpMethod OPTIONS = null;
    public static final PassportHttpMethod PATCH = null;
    public static final PassportHttpMethod POST = null;
    public static final PassportHttpMethod PUT = null;
    public static final /* synthetic */ PassportHttpMethod[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PassportHttpMethod> getEntries() {
        return b;
    }

    static {
        PassportHttpMethod r0 = new PassportHttpMethod("GET", 0);
        GET = r0;
        PassportHttpMethod r1 = new PassportHttpMethod("POST", 1);
        POST = r1;
        PassportHttpMethod r3 = new PassportHttpMethod("DELETE", 2);
        DELETE = r3;
        PassportHttpMethod r5 = new PassportHttpMethod("PUT", 3);
        PUT = r5;
        PassportHttpMethod r7 = new PassportHttpMethod("PATCH", 4);
        PATCH = r7;
        PassportHttpMethod r9 = new PassportHttpMethod("HEAD", 5);
        HEAD = r9;
        PassportHttpMethod r11 = new PassportHttpMethod("OPTIONS", 6);
        OPTIONS = r11;
        PassportHttpMethod[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static PassportHttpMethod[] values() {
        return (PassportHttpMethod[]) a.clone();
    }

    public static PassportHttpMethod valueOf(String r1) {
        return (PassportHttpMethod) r27.a.a(PassportHttpMethod.class, r1);
    }

    public PassportHttpMethod(String r1, int r2) {
        super(r1, r2);
    }
}

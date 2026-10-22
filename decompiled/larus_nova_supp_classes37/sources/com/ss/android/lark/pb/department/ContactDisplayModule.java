package com.ss.android.lark.pb.department;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ContactDisplayModule extends Enum<ContactDisplayModule> implements WireEnum {
    private static final /* synthetic */ ContactDisplayModule[] $VALUES = null;
    public static final ProtoAdapter<ContactDisplayModule> ADAPTER = null;
    public static final ContactDisplayModule DISPLAY_MODULE_DEPARTMENT = null;
    public static final ContactDisplayModule DISPLAY_MODULE_DEPARTMENT_LEADER = null;
    public static final ContactDisplayModule DISPLAY_MODULE_USER = null;
    private final int value;

    static {
        ContactDisplayModule r0 = new ContactDisplayModule("DISPLAY_MODULE_DEPARTMENT_LEADER", 0, 1);
        DISPLAY_MODULE_DEPARTMENT_LEADER = r0;
        ContactDisplayModule r1 = new ContactDisplayModule("DISPLAY_MODULE_DEPARTMENT", 1, 2);
        DISPLAY_MODULE_DEPARTMENT = r1;
        ContactDisplayModule r4 = new ContactDisplayModule("DISPLAY_MODULE_USER", 2, 3);
        DISPLAY_MODULE_USER = r4;
        $VALUES = new ContactDisplayModule[]{r0, r1, r4};
        ADAPTER = ProtoAdapter.newEnumAdapter(ContactDisplayModule.class);
    }

    public static ContactDisplayModule[] values() {
        return (ContactDisplayModule[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ContactDisplayModule fromValue(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return null;
    L11:
        return DISPLAY_MODULE_USER;
    L13:
        return DISPLAY_MODULE_DEPARTMENT;
    L15:
        return DISPLAY_MODULE_DEPARTMENT_LEADER;
    }

    public static ContactDisplayModule valueOf(String r1) {
        return (ContactDisplayModule) a.a(ContactDisplayModule.class, r1);
    }

    private ContactDisplayModule(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

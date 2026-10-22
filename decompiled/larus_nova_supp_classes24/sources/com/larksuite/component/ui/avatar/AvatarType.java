package com.larksuite.component.ui.avatar;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/larksuite/component/ui/avatar/AvatarType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "CHAT", "THRED", "TOPIC", "DOC", "CHATTER", "MICROAPP", "Companion", "avatar-badge_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum AvatarType extends Enum<AvatarType> {
    public static final AvatarType CHAT = null;
    public static final AvatarType CHATTER = null;
    public static final a Companion = null;
    public static final AvatarType DOC = null;
    public static final AvatarType MICROAPP = null;
    public static final AvatarType THRED = null;
    public static final AvatarType TOPIC = null;
    public static final AvatarType UNKNOWN = null;
    public static final /* synthetic */ AvatarType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<AvatarType> getEntries() {
        return b;
    }

    static {
        AvatarType r0 = new AvatarType("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        AvatarType r1 = new AvatarType("CHAT", 1, 1);
        CHAT = r1;
        AvatarType r3 = new AvatarType("THRED", 2, 2);
        THRED = r3;
        AvatarType r5 = new AvatarType("TOPIC", 3, 3);
        TOPIC = r5;
        AvatarType r7 = new AvatarType("DOC", 4, 4);
        DOC = r7;
        AvatarType r9 = new AvatarType("CHATTER", 5, 5);
        CHATTER = r9;
        AvatarType r11 = new AvatarType("MICROAPP", 6, 6);
        MICROAPP = r11;
        AvatarType[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
        Companion = new a();
    }

    public static AvatarType[] values() {
        return (AvatarType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final AvatarType valueOf(int r6) {
        Companion.getClass();
        AvatarType[] r0 = values();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        AvatarType r4 = r0[r3];
        if (r4.getValue() != r6) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == true) goto L15;
        r3 = r3 + 1;
        goto L3
    L15:
        return r4;
    L7:
        r5 = false;
        goto L8
    L11:
        return null;
    }

    public static AvatarType valueOf(String r1) {
        return (AvatarType) r27.a.a(AvatarType.class, r1);
    }

    public AvatarType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

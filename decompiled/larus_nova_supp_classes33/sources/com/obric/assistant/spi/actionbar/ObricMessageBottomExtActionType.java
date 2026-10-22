package com.obric.assistant.spi.actionbar;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/obric/assistant/spi/actionbar/ObricMessageBottomExtActionType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "OBRIC_JUMP_DEEP_THINK", "Companion", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricMessageBottomExtActionType extends Enum<ObricMessageBottomExtActionType> {
    public static final a Companion = null;
    public static final String KEY_DISABLE_OBRIC_DEEP_THINK = "disable_obric_deep_think";
    public static final ObricMessageBottomExtActionType OBRIC_JUMP_DEEP_THINK = null;
    public static final String SCENE_OBRIC_DIRECT_SEND = "obric_direct_send";
    public static final /* synthetic */ ObricMessageBottomExtActionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ObricMessageBottomExtActionType> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.assistant.spi.actionbar.ObricMessageBottomExtActionType$a] */
    static {
        ObricMessageBottomExtActionType r0 = new ObricMessageBottomExtActionType();
        OBRIC_JUMP_DEEP_THINK = r0;
        ObricMessageBottomExtActionType[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
        Companion = new a();
    }

    public ObricMessageBottomExtActionType() {
        super("OBRIC_JUMP_DEEP_THINK", 0);
        this.value = 3;
    }

    public static ObricMessageBottomExtActionType[] values() {
        return (ObricMessageBottomExtActionType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ObricMessageBottomExtActionType valueOf(String r1) {
        return (ObricMessageBottomExtActionType) r27.a.a(ObricMessageBottomExtActionType.class, r1);
    }
}

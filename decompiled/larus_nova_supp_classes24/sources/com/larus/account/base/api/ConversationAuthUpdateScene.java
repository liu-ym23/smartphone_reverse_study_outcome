package com.larus.account.base.api;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/account/base/api/ConversationAuthUpdateScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Login", "Bind", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum ConversationAuthUpdateScene extends Enum<ConversationAuthUpdateScene> {
    public static final ConversationAuthUpdateScene Bind = null;
    public static final ConversationAuthUpdateScene Login = null;
    public static final /* synthetic */ ConversationAuthUpdateScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ConversationAuthUpdateScene> getEntries() {
        return b;
    }

    static {
        ConversationAuthUpdateScene r0 = new ConversationAuthUpdateScene("Login", 0, 1);
        Login = r0;
        ConversationAuthUpdateScene r1 = new ConversationAuthUpdateScene("Bind", 1, 2);
        Bind = r1;
        ConversationAuthUpdateScene[] r4 = {r0, r1};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static ConversationAuthUpdateScene[] values() {
        return (ConversationAuthUpdateScene[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ConversationAuthUpdateScene valueOf(String r1) {
        return (ConversationAuthUpdateScene) a.a(ConversationAuthUpdateScene.class, r1);
    }

    public ConversationAuthUpdateScene(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

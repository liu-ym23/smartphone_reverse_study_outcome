package com.ss.android.lark.chat.open.message;

import com.ss.android.lark.blueprint.v;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/chat/open/message/IMMessageKeys$Slots;", "Lcom/ss/android/lark/blueprint/ISlotId;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "CONTENT", "AVATAR", "TOP", "HEADER", "FOOTER", "CORNER_1", "CORNER_2", "BOTTOM", "ROOF", "DING_ICON", "SELECT", "INNER_EXPOSURE", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IMMessageKeys$Slots extends Enum<IMMessageKeys$Slots> implements v {
    public static final IMMessageKeys$Slots AVATAR = null;
    public static final IMMessageKeys$Slots BOTTOM = null;
    public static final IMMessageKeys$Slots CONTENT = null;
    public static final IMMessageKeys$Slots CORNER_1 = null;
    public static final IMMessageKeys$Slots CORNER_2 = null;
    public static final IMMessageKeys$Slots DING_ICON = null;
    public static final IMMessageKeys$Slots FOOTER = null;
    public static final IMMessageKeys$Slots HEADER = null;
    public static final IMMessageKeys$Slots INNER_EXPOSURE = null;
    public static final IMMessageKeys$Slots ROOF = null;
    public static final IMMessageKeys$Slots SELECT = null;
    public static final IMMessageKeys$Slots TOP = null;
    public static final /* synthetic */ IMMessageKeys$Slots[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<IMMessageKeys$Slots> getEntries() {
        return b;
    }

    static {
        IMMessageKeys$Slots r0 = new IMMessageKeys$Slots("CONTENT", 0);
        CONTENT = r0;
        IMMessageKeys$Slots r1 = new IMMessageKeys$Slots("AVATAR", 1);
        AVATAR = r1;
        IMMessageKeys$Slots r3 = new IMMessageKeys$Slots("TOP", 2);
        TOP = r3;
        IMMessageKeys$Slots r5 = new IMMessageKeys$Slots("HEADER", 3);
        HEADER = r5;
        IMMessageKeys$Slots r7 = new IMMessageKeys$Slots("FOOTER", 4);
        FOOTER = r7;
        IMMessageKeys$Slots r9 = new IMMessageKeys$Slots("CORNER_1", 5);
        CORNER_1 = r9;
        IMMessageKeys$Slots r11 = new IMMessageKeys$Slots("CORNER_2", 6);
        CORNER_2 = r11;
        IMMessageKeys$Slots r13 = new IMMessageKeys$Slots("BOTTOM", 7);
        BOTTOM = r13;
        IMMessageKeys$Slots r15 = new IMMessageKeys$Slots("ROOF", 8);
        ROOF = r15;
        IMMessageKeys$Slots r14 = new IMMessageKeys$Slots("DING_ICON", 9);
        DING_ICON = r14;
        IMMessageKeys$Slots r12 = new IMMessageKeys$Slots("SELECT", 10);
        SELECT = r12;
        IMMessageKeys$Slots r10 = new IMMessageKeys$Slots("INNER_EXPOSURE", 11);
        INNER_EXPOSURE = r10;
        IMMessageKeys$Slots[] r8 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static IMMessageKeys$Slots[] values() {
        return (IMMessageKeys$Slots[]) a.clone();
    }

    public static IMMessageKeys$Slots valueOf(String r1) {
        return (IMMessageKeys$Slots) a.a(IMMessageKeys$Slots.class, r1);
    }

    public IMMessageKeys$Slots(String r1, int r2) {
        super(r1, r2);
    }
}

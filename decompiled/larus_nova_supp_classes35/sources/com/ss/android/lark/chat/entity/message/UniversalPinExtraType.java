package com.ss.android.lark.chat.entity.message;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/UniversalPinExtraType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "MESSAGE_PIN", "URL_PIN", "ANNOUNCEMENT_PIN", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UniversalPinExtraType extends Enum<UniversalPinExtraType> {
    public static final UniversalPinExtraType ANNOUNCEMENT_PIN = null;
    public static final UniversalPinExtraType MESSAGE_PIN = null;
    public static final UniversalPinExtraType UNKNOWN = null;
    public static final UniversalPinExtraType URL_PIN = null;
    public static final /* synthetic */ UniversalPinExtraType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<UniversalPinExtraType> getEntries() {
        return b;
    }

    static {
        UniversalPinExtraType r0 = new UniversalPinExtraType("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        UniversalPinExtraType r1 = new UniversalPinExtraType("MESSAGE_PIN", 1, 1);
        MESSAGE_PIN = r1;
        UniversalPinExtraType r3 = new UniversalPinExtraType("URL_PIN", 2, 2);
        URL_PIN = r3;
        UniversalPinExtraType r5 = new UniversalPinExtraType("ANNOUNCEMENT_PIN", 3, 3);
        ANNOUNCEMENT_PIN = r5;
        UniversalPinExtraType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static UniversalPinExtraType[] values() {
        return (UniversalPinExtraType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static UniversalPinExtraType valueOf(String r1) {
        return (UniversalPinExtraType) r27.a.a(UniversalPinExtraType.class, r1);
    }

    public UniversalPinExtraType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

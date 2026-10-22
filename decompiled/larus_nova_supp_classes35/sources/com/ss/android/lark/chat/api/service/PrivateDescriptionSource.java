package com.ss.android.lark.chat.api.service;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/api/service/PrivateDescriptionSource;", BuildConfig.FLAVOR, "rustValue", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getRustValue", "()I", "CHAT_MESSAGE", "P2P_CHAT_SUBTITLE", "CHAT_MEMBER", "CONTACT_IN_ORGANIZATION", "im-sdk-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PrivateDescriptionSource extends Enum<PrivateDescriptionSource> {
    public static final PrivateDescriptionSource CHAT_MEMBER = null;
    public static final PrivateDescriptionSource CHAT_MESSAGE = null;
    public static final PrivateDescriptionSource CONTACT_IN_ORGANIZATION = null;
    public static final PrivateDescriptionSource P2P_CHAT_SUBTITLE = null;
    public static final /* synthetic */ PrivateDescriptionSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int rustValue;

    public static EnumEntries<PrivateDescriptionSource> getEntries() {
        return b;
    }

    static {
        PrivateDescriptionSource r0 = new PrivateDescriptionSource("CHAT_MESSAGE", 0, 1);
        CHAT_MESSAGE = r0;
        PrivateDescriptionSource r1 = new PrivateDescriptionSource("P2P_CHAT_SUBTITLE", 1, 2);
        P2P_CHAT_SUBTITLE = r1;
        PrivateDescriptionSource r4 = new PrivateDescriptionSource("CHAT_MEMBER", 2, 6);
        CHAT_MEMBER = r4;
        PrivateDescriptionSource r6 = new PrivateDescriptionSource("CONTACT_IN_ORGANIZATION", 3, 7);
        CONTACT_IN_ORGANIZATION = r6;
        PrivateDescriptionSource[] r7 = {r0, r1, r4, r6};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static PrivateDescriptionSource[] values() {
        return (PrivateDescriptionSource[]) a.clone();
    }

    public final int getRustValue() {
        return this.rustValue;
    }

    public static PrivateDescriptionSource valueOf(String r1) {
        return (PrivateDescriptionSource) a.a(PrivateDescriptionSource.class, r1);
    }

    public PrivateDescriptionSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.rustValue = r3;
    }
}

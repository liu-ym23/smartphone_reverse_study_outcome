package com.ss.android.lark.create.groupchat.dto;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/create/groupchat/dto/CreateGroupMode;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CONVERSATION_MODE", "TOPIC_MODE", "SECRET_MODE", "create-group-chat-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreateGroupMode extends Enum<CreateGroupMode> {
    public static final CreateGroupMode CONVERSATION_MODE = null;
    public static final CreateGroupMode SECRET_MODE = null;
    public static final CreateGroupMode TOPIC_MODE = null;
    public static final /* synthetic */ CreateGroupMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<CreateGroupMode> getEntries() {
        return b;
    }

    static {
        CreateGroupMode r0 = new CreateGroupMode("CONVERSATION_MODE", 0, 1);
        CONVERSATION_MODE = r0;
        CreateGroupMode r1 = new CreateGroupMode("TOPIC_MODE", 1, 2);
        TOPIC_MODE = r1;
        CreateGroupMode r4 = new CreateGroupMode("SECRET_MODE", 2, 3);
        SECRET_MODE = r4;
        CreateGroupMode[] r6 = {r0, r1, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static CreateGroupMode[] values() {
        return (CreateGroupMode[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static CreateGroupMode valueOf(String r1) {
        return (CreateGroupMode) a.a(CreateGroupMode.class, r1);
    }

    public CreateGroupMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

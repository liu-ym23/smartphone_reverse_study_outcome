package com.ss.android.lark.chat.api.service;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chat/api/service/StorePrivateDescriptionScene;", BuildConfig.FLAVOR, "source", "Lcom/ss/android/lark/chat/api/service/PrivateDescriptionSource;", "strategy", "Lcom/ss/android/lark/chat/api/service/Strategy;", "logTag", BuildConfig.FLAVOR, "dispatcherName", "<init>", "(Ljava/lang/String;ILcom/ss/android/lark/chat/api/service/PrivateDescriptionSource;Lcom/ss/android/lark/chat/api/service/Strategy;Ljava/lang/String;Ljava/lang/String;)V", "getSource", "()Lcom/ss/android/lark/chat/api/service/PrivateDescriptionSource;", "getStrategy", "()Lcom/ss/android/lark/chat/api/service/Strategy;", "getLogTag", "()Ljava/lang/String;", "getDispatcherName", "GROUP_MESSAGE", "REPLY_IN_THREAD", "MERGE_FORWARD", "SECRET_GROUP_MESSAGE", "im-sdk-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum StorePrivateDescriptionScene extends Enum<StorePrivateDescriptionScene> {
    public static final StorePrivateDescriptionScene GROUP_MESSAGE = null;
    public static final StorePrivateDescriptionScene MERGE_FORWARD = null;
    public static final StorePrivateDescriptionScene REPLY_IN_THREAD = null;
    public static final StorePrivateDescriptionScene SECRET_GROUP_MESSAGE = null;
    public static final /* synthetic */ StorePrivateDescriptionScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String dispatcherName;
    private final String logTag;
    private final PrivateDescriptionSource source;
    private final Strategy strategy;

    public static EnumEntries<StorePrivateDescriptionScene> getEntries() {
        return b;
    }

    static {
        PrivateDescriptionSource r15 = PrivateDescriptionSource.CHAT_MESSAGE;
        Strategy r16 = Strategy.TRY_LOCAL;
        StorePrivateDescriptionScene r7 = new StorePrivateDescriptionScene("GROUP_MESSAGE", 0, r15, r16, "GroupMsgPrivateDesHandler", "chat-group-private-description");
        GROUP_MESSAGE = r7;
        StorePrivateDescriptionScene r0 = new StorePrivateDescriptionScene("REPLY_IN_THREAD", 1, r15, r16, "ReplyThreadPrivateDesHandler", "reply-thread-private-description");
        REPLY_IN_THREAD = r0;
        StorePrivateDescriptionScene r1 = new StorePrivateDescriptionScene("MERGE_FORWARD", 2, r15, r16, "MergeForwardPrivateDesHandler", "merge-forward-private-description");
        MERGE_FORWARD = r1;
        StorePrivateDescriptionScene r2 = new StorePrivateDescriptionScene("SECRET_GROUP_MESSAGE", 3, r15, r16, "SecretGroupPrivateDesHandler", "secret-group-private-description");
        SECRET_GROUP_MESSAGE = r2;
        StorePrivateDescriptionScene[] r3 = {r7, r0, r1, r2};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static StorePrivateDescriptionScene[] values() {
        return (StorePrivateDescriptionScene[]) a.clone();
    }

    public final String getDispatcherName() {
        return this.dispatcherName;
    }

    public final String getLogTag() {
        return this.logTag;
    }

    public final PrivateDescriptionSource getSource() {
        return this.source;
    }

    public final Strategy getStrategy() {
        return this.strategy;
    }

    public static StorePrivateDescriptionScene valueOf(String r1) {
        return (StorePrivateDescriptionScene) a.a(StorePrivateDescriptionScene.class, r1);
    }

    public StorePrivateDescriptionScene(String r1, int r2, PrivateDescriptionSource r3, Strategy r4, String r5, String r6) {
        super(r1, r2);
        this.source = r3;
        this.strategy = r4;
        this.logTag = r5;
        this.dispatcherName = r6;
    }
}

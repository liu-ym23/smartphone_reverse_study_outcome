package com.ss.android.lark.chat.entity.chat;

import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 22\u00020\u0001:\u000223B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010#\u001a\u00020$J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003JI\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010,\u001a\u00020$2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000fR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00064"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatTab;", "Ljava/io/Serializable;", "id", BuildConfig.FLAVOR, IPortraitService.NAME, BuildConfig.FLAVOR, IPortraitService.TYPE, "Lcom/ss/android/lark/chat/entity/chat/ChatTab$ChatTabType;", "payload", "Lokio/ByteString;", "payloadString", "serverId", "<init>", "(JLjava/lang/String;Lcom/ss/android/lark/chat/entity/chat/ChatTab$ChatTabType;Lokio/ByteString;Ljava/lang/String;J)V", "getId", "()J", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getType", "()Lcom/ss/android/lark/chat/entity/chat/ChatTab$ChatTabType;", "setType", "(Lcom/ss/android/lark/chat/entity/chat/ChatTab$ChatTabType;)V", "getPayload", "()Lokio/ByteString;", "getPayloadString", "setPayloadString", "getServerId", "extra", "Lcom/ss/android/lark/chat/entity/chat/ChatTabExtra;", "getExtra", "()Lcom/ss/android/lark/chat/entity/chat/ChatTabExtra;", "setExtra", "(Lcom/ss/android/lark/chat/entity/chat/ChatTabExtra;)V", "isSingleton", BuildConfig.FLAVOR, "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "ChatTabType", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatTab implements Serializable {
    public static final a Companion = null;
    public static final long MESSAGE_LIST_ID = 100001;
    public static final long SPACE_LIST_ID = 100002;
    private ChatTabExtra extra;
    private final long id;
    private String name;
    private final ByteString payload;
    private String payloadString;
    private final long serverId;
    private ChatTabType type;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatTab$ChatTabType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "MESSAGE", "DOC_SPACE", "DOC", "PIN", "MEETING_MINUTE", "CHAT_ANNOUNCEMENT", "URL", "FILE", "TASK", "DOC_FILE_URL_MERGE", "IMAGE_VIDEO_MERGE", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ChatTabType extends Enum<ChatTabType> {
        public static final ChatTabType CHAT_ANNOUNCEMENT = null;
        public static final a Companion = null;
        public static final ChatTabType DOC = null;
        public static final ChatTabType DOC_FILE_URL_MERGE = null;
        public static final ChatTabType DOC_SPACE = null;
        public static final ChatTabType FILE = null;
        public static final ChatTabType IMAGE_VIDEO_MERGE = null;
        public static final ChatTabType MEETING_MINUTE = null;
        public static final ChatTabType MESSAGE = null;
        public static final ChatTabType PIN = null;
        public static final ChatTabType TASK = null;
        public static final ChatTabType UNKNOWN = null;
        public static final ChatTabType URL = null;
        public static final /* synthetic */ ChatTabType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<ChatTabType> getEntries() {
            return b;
        }

        static {
            ChatTabType r0 = new ChatTabType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ChatTabType r1 = new ChatTabType("MESSAGE", 1, 1);
            MESSAGE = r1;
            ChatTabType r3 = new ChatTabType("DOC_SPACE", 2, 2);
            DOC_SPACE = r3;
            ChatTabType r5 = new ChatTabType("DOC", 3, 3);
            DOC = r5;
            ChatTabType r7 = new ChatTabType("PIN", 4, 4);
            PIN = r7;
            ChatTabType r9 = new ChatTabType("MEETING_MINUTE", 5, 5);
            MEETING_MINUTE = r9;
            ChatTabType r11 = new ChatTabType("CHAT_ANNOUNCEMENT", 6, 6);
            CHAT_ANNOUNCEMENT = r11;
            ChatTabType r13 = new ChatTabType("URL", 7, 7);
            URL = r13;
            ChatTabType r15 = new ChatTabType("FILE", 8, 8);
            FILE = r15;
            ChatTabType r14 = new ChatTabType("TASK", 9, 9);
            TASK = r14;
            ChatTabType r12 = new ChatTabType("DOC_FILE_URL_MERGE", 10, 10);
            DOC_FILE_URL_MERGE = r12;
            ChatTabType r10 = new ChatTabType("IMAGE_VIDEO_MERGE", 11, 11);
            IMAGE_VIDEO_MERGE = r10;
            ChatTabType[] r8 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
            a = r8;
            b = EnumEntriesKt.enumEntries(r8);
            Companion = new a();
        }

        public static ChatTabType[] values() {
            return (ChatTabType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ChatTabType valueOf(String r1) {
            return (ChatTabType) r27.a.a(ChatTabType.class, r1);
        }

        public ChatTabType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static boolean a(ChatTab r2) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            if (r2.getType() != ChatTabType.DOC) goto L5;
        L10:
            return true;
        L5:
            if (r2.getType() == ChatTabType.URL) goto L10;
            if (r2.getType() == ChatTabType.TASK) goto L10;
            return false;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ ChatTab copy$default(ChatTab r9, long r10, String r12, ChatTabType r13, ByteString r14, String r15, long r16, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        long r1 = r9.id;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.name;
    L11:
        if ((r18 & 4) == 0) goto L13;
        ChatTabType r4 = r9.type;
    L15:
        if ((r18 & 8) == 0) goto L17;
        ByteString r5 = r9.payload;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.payloadString;
    L23:
        if ((r18 & 32) == 0) goto L25;
        long r7 = r9.serverId;
    L27:
        return r9.copy(r1, r3, r4, r5, r6, r7);
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    @JvmStatic
    public static final boolean isChatTabCustom(ChatTab r1) {
        Companion.getClass();
        return a.a(r1);
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final ChatTabType component3() {
        return this.type;
    }

    public final ByteString component4() {
        return this.payload;
    }

    public final String component5() {
        return this.payloadString;
    }

    public final long component6() {
        return this.serverId;
    }

    public final ChatTab copy(long r11, String r13, ChatTabType r14, ByteString r15, String r16, long r17) {
        Intrinsics.checkNotNullParameter(r13, IPortraitService.NAME);
        Intrinsics.checkNotNullParameter(r14, IPortraitService.TYPE);
        return new ChatTab(r11, r13, r14, r15, r16, r17);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ChatTab) == true) goto L8;
        return false;
    L8:
        ChatTab r9 = (ChatTab) r8;
        if (this.id == r9.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r9.name) == true) goto L15;
        return false;
    L15:
        if (this.type == r9.type) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.payload, r9.payload) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.payloadString, r9.payloadString) == true) goto L24;
        return false;
    L24:
        if (this.serverId == r9.serverId) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        long r0 = this.id;
        int r1 = ((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.name.hashCode()) * 31) + this.type.hashCode()) * 31;
        ByteString r2 = this.payload;
        int r3 = 0;
        if (r2 != null) goto L5;
        int r4 = 0;
    L6:
        int r5 = (r1 + r4) * 31;
        String r6 = this.payloadString;
        if (r6 == null) goto L10;
        r3 = r6.hashCode();
    L10:
        int r7 = (r5 + r3) * 31;
        long r8 = this.serverId;
        return r7 + ((int) (r8 ^ (r8 >>> 32)));
    L5:
        r4 = r2.hashCode();
        goto L6
    }

    public String toString() {
        return "ChatTab(id=" + this.id + ", name=" + this.name + ", type=" + this.type + ", payload=" + this.payload + ", payloadString=" + this.payloadString + ", serverId=" + this.serverId + ')';
    }

    public final boolean isSingleton() {
        ChatTabType r0 = this.type;
        if (r0 != ChatTabType.DOC_SPACE) goto L5;
    L20:
        return true;
    L5:
        if (r0 == ChatTabType.MESSAGE) goto L20;
        if (r0 == ChatTabType.PIN) goto L20;
        if (r0 == ChatTabType.MEETING_MINUTE) goto L20;
        if (r0 == ChatTabType.CHAT_ANNOUNCEMENT) goto L20;
        if (r0 == ChatTabType.FILE) goto L20;
        if (r0 == ChatTabType.DOC_FILE_URL_MERGE) goto L20;
        if (r0 == ChatTabType.IMAGE_VIDEO_MERGE) goto L20;
        return false;
    }

    public final ChatTabExtra getExtra() {
        return this.extra;
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final ByteString getPayload() {
        return this.payload;
    }

    public final String getPayloadString() {
        return this.payloadString;
    }

    public final long getServerId() {
        return this.serverId;
    }

    public final ChatTabType getType() {
        return this.type;
    }

    @JvmStatic
    public static final boolean containsBizTabs(List<ChatTab> r2) {
        Companion.getClass();
        if (r2 == null) goto L15;
        List<ChatTab> r3 = r2;
        if ((r3 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L15;
        if ((!((ChatTab) r4.next()).isSingleton()) == false) goto L11;
        return true;
    L7:
        if (r3.isEmpty() == false) goto L9;
    L15:
        return false;
    }

    public final void setExtra(ChatTabExtra r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.extra = r2;
    }

    public final void setName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.name = r2;
    }

    public final void setPayloadString(String r1) {
        this.payloadString = r1;
    }

    public final void setType(ChatTabType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.type = r2;
    }

    @JvmStatic
    public static final ChatTab preChatTab(String r10, ChatTabType r11, ByteString r12, String r13) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r10, IPortraitService.NAME);
        Intrinsics.checkNotNullParameter(r11, IPortraitService.TYPE);
        Intrinsics.checkNotNullParameter(r13, "payloadJson");
        return new ChatTab(-1, r10, r11, r12, r13, -1);
    }

    public ChatTab(long r2, String r4, ChatTabType r5, ByteString r6, String r7, long r8) {
        Intrinsics.checkNotNullParameter(r4, IPortraitService.NAME);
        Intrinsics.checkNotNullParameter(r5, IPortraitService.TYPE);
        this.id = r2;
        this.name = r4;
        this.type = r5;
        this.payload = r6;
        this.payloadString = r7;
        this.serverId = r8;
        this.extra = new ChatTabExtra(0, 0);
    }
}

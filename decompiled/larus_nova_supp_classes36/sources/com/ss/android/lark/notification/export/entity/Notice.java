package com.ss.android.lark.notification.export.entity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class Notice {
    public String content;
    public long createTime;
    public Extra extra;
    public boolean isFromBackgroundUser;
    public String key;
    public String messageId;
    public final Object pbNotification;
    public int position;
    public boolean shouldNotify;
    public int state;
    public String title;
    public int type;
    public String voipParams;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ChannelType {
        public static final int CHAT = 1;
        public static final int DOC = 3;
        public static final int EMAIL = 2;
        public static final int UNKNOWN = 0;
    }

    public static class Extra {
        public String a;
        public ChatType b;
        public String c;
        public ChatMode d;
        public String e;
        public boolean f;
        public String g;
        public int h;
        public int i;
        public String j;
        public int k;
        public int l;
        public String m;
        public String n;
        public String o;
        public String p;
        public boolean q;
        public Boolean r;
        public String s;
        public String t;

        public static final enum ChatMode extends Enum<ChatMode> {
            public static final ChatMode DEFAULT = null;
            public static final ChatMode THREAD = null;
            public static final ChatMode THREAD_V2 = null;
            public static final ChatMode UNKNOWN = null;
            public static final /* synthetic */ ChatMode[] a = null;
            private final int value;

            static {
                ChatMode r0 = new ChatMode("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                ChatMode r1 = new ChatMode("DEFAULT", 1, 1);
                DEFAULT = r1;
                ChatMode r3 = new ChatMode("THREAD", 2, 2);
                THREAD = r3;
                ChatMode r5 = new ChatMode("THREAD_V2", 3, 3);
                THREAD_V2 = r5;
                a = new ChatMode[]{r0, r1, r3, r5};
            }

            public static ChatMode[] values() {
                return (ChatMode[]) a.clone();
            }

            public int getNumber() {
                return this.value;
            }

            public static ChatMode forNumber(int r1) {
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L13;
                if (r1 == 3) goto L11;
                return UNKNOWN;
            L11:
                return THREAD_V2;
            L13:
                return THREAD;
            L15:
                return DEFAULT;
            }

            public static ChatMode valueOf(String r1) {
                return (ChatMode) r27.a.a(ChatMode.class, r1);
            }

            public static ChatMode valueOf(int r0) {
                return forNumber(r0);
            }

            public ChatMode(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final enum ChatType extends Enum<ChatType> {
            public static final ChatType GROUP = null;
            public static final ChatType P2P = null;
            public static final /* synthetic */ ChatType[] a = null;
            private final int value;

            static {
                ChatType r0 = new ChatType("P2P", 0, 1);
                P2P = r0;
                ChatType r1 = new ChatType("GROUP", 1, 2);
                GROUP = r1;
                a = new ChatType[]{r0, r1};
            }

            public static ChatType[] values() {
                return (ChatType[]) a.clone();
            }

            public int getNumber() {
                return this.value;
            }

            public static ChatType forNumber(int r1) {
                if (r1 == 1) goto L11;
                if (r1 == 2) goto L9;
                return null;
            L9:
                return GROUP;
            L11:
                return P2P;
            }

            public static ChatType valueOf(String r1) {
                return (ChatType) r27.a.a(ChatType.class, r1);
            }

            public static ChatType valueOf(int r0) {
                return forNumber(r0);
            }

            public ChatType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public Extra() {
            this.a = "";
            this.b = null;
            this.c = "";
            new ArrayList();
            this.d = null;
            this.e = "";
            this.f = false;
            this.g = "";
            this.h = 0;
            this.m = null;
            this.n = null;
            this.o = null;
            this.p = null;
            this.q = false;
            this.r = Boolean.FALSE;
            this.s = null;
            this.t = null;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
        public static final int DELETE = 3;
        public static final int FAILED = 4;
        public static final int NEW = 1;
        public static final int RECALL = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
        public static final int AT = 2;
        public static final int CALENDAR_REMINDER = 10001;
        public static final int CHAT_APPLICATION = 6;
        public static final int CHAT_APPLY = 8;
        public static final int DOC_IMAGE_REPLY = 9;
        public static final int MAIL = 7;
        public static final int MEDIA_UPLOAD = 13;
        public static final int NORMAL = 1;
        public static final int OFFLINE = 20001;
        public static final int OFFLINE_VOIP = 20002;
        public static final int OPEN_APP = 10;
        public static final int OPEN_APP_CHAT = 11;
        public static final int OPEN_APP_FEED = 14;
        public static final int REACTION = 4;
        public static final int TODO_REMINDER = 10006;
        public static final int URGENT = 3;
        public static final int URGENT_ACK = 5;
        public static final int URGENT_FAILED = 12;
        public static final int VC_CALENDAR_PROMPT = 10005;
        public static final int VIDEO_CHAT_RING = 10003;
        public static final int VOIP_MISSED_CALL = 10002;
        public static final int VOIP_RING = 10004;
    }

    public Notice() {
        this(null);
    }

    public boolean isOnTimeDel() {
        return this.extra.q;
    }

    public Notice(Notice r3) {
        this(r3.pbNotification);
        this.messageId = r3.messageId;
        this.state = r3.state;
        this.content = r3.content;
        this.title = r3.title;
        this.type = r3.type;
        this.key = r3.key;
        this.extra = r3.extra;
        this.createTime = r3.createTime;
        this.position = r3.position;
        this.shouldNotify = r3.shouldNotify;
        this.voipParams = r3.voipParams;
        this.isFromBackgroundUser = r3.isFromBackgroundUser;
    }

    public Notice(Object r2) {
        this.extra = new Extra();
        this.shouldNotify = true;
        this.isFromBackgroundUser = false;
        this.pbNotification = r2;
    }
}

package com.ss.android.lark.chat.entity.message;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.bytedance.lark.pb.basic.v1.UrlPreviewHangPoint;
import com.larksuite.framework.utils.e;
import com.ss.android.lark.chat.entity.Channel;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.MessageParams.a;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class MessageParams<T extends MessageParams<T, B>, B extends a<T, B>> {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final Message.Type e;
    public final Channel.Type f;
    public final String g;
    public final String h;
    public final int i;
    public final boolean j;
    public final boolean k;
    public final String l;
    public final boolean m;
    public final CreateScene n;
    public final Long o;
    public final Long p;
    public final LarkAgentContext q;
    public final boolean r;
    public final com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo s;
    public final String t;
    public final boolean u;
    public final boolean v;
    public final Long w;
    public final Boolean x;
    public final Map<String, UrlPreviewHangPoint> y;
    public final Map<String, UrlPreviewEntity> z;

    public static final enum CreateScene extends Enum<CreateScene> {
        public static final CreateScene COMMON_SHARE = null;
        public static final CreateScene NORMAL = null;
        public static final CreateScene SHARE_DOC = null;
        public static final CreateScene SHARE_GROUP_CHAT = null;
        public static final CreateScene SHARE_MINUTES = null;
        public static final CreateScene SHARE_QR_CODE = null;
        public static final CreateScene SHARE_SUBSCRIPTION = null;
        public static final /* synthetic */ CreateScene[] a = null;
        private final int value;

        static {
            CreateScene r0 = new CreateScene("NORMAL", 0, 0);
            NORMAL = r0;
            CreateScene r1 = new CreateScene("SHARE_GROUP_CHAT", 1, 1);
            SHARE_GROUP_CHAT = r1;
            CreateScene r3 = new CreateScene("SHARE_DOC", 2, 3);
            SHARE_DOC = r3;
            CreateScene r5 = new CreateScene("SHARE_MINUTES", 3, 5);
            SHARE_MINUTES = r5;
            CreateScene r8 = new CreateScene("SHARE_QR_CODE", 4, 6);
            SHARE_QR_CODE = r8;
            CreateScene r10 = new CreateScene("SHARE_SUBSCRIPTION", 5, 7);
            SHARE_SUBSCRIPTION = r10;
            CreateScene r13 = new CreateScene("COMMON_SHARE", 6, 9);
            COMMON_SHARE = r13;
            a = new CreateScene[]{r0, r1, r3, r5, r8, r10, r13};
        }

        public static CreateScene[] values() {
            return (CreateScene[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static CreateScene forNumber(int r1) {
            if (r1 == 1) goto L23;
            if (r1 == 3) goto L21;
            if (r1 == 5) goto L19;
            if (r1 == 6) goto L17;
            if (r1 == 7) goto L15;
            return NORMAL;
        L15:
            return SHARE_SUBSCRIPTION;
        L17:
            return SHARE_QR_CODE;
        L19:
            return SHARE_MINUTES;
        L21:
            return SHARE_DOC;
        L23:
            return SHARE_GROUP_CHAT;
        }

        public static CreateScene valueOf(String r1) {
            return (CreateScene) r27.a.a(CreateScene.class, r1);
        }

        public static CreateScene valueOf(int r0) {
            return forNumber(r0);
        }

        public CreateScene(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static abstract class a<T extends MessageParams<T, B>, B extends a<T, B>> {
        public String a;
        public String b;
        public String c;
        public String d;
        public int e;
        public String f;
        public Channel.Type g;
        public Message.Type h;
        public String i;
        public boolean j;
        public boolean k;
        public String l;
        public boolean m;
        public CreateScene n;
        public long o;
        public Long p;
        public LarkAgentContext q;
        public boolean r;
        public com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo s;
        public String t;
        public boolean u;
        public boolean v;
        public Long w;
        public Boolean x;
        public Map<String, UrlPreviewHangPoint> y;
        public Map<String, UrlPreviewEntity> z;

        public abstract T a();

        public a() {
            this.e = -1;
            this.g = Channel.Type.CHAT;
            this.k = false;
            this.m = false;
            this.o = -1;
            this.p = null;
            this.q = null;
            this.r = false;
            this.s = null;
            this.u = false;
            this.v = false;
            this.w = null;
            this.x = null;
            this.y = null;
            this.z = null;
        }
    }

    public abstract Message c(String r1, String r2);

    public MessageParams(B r5) {
        this.i = -1;
        this.a = r5.a;
        this.b = r5.b;
        String r0 = r5.c;
        this.c = r0;
        Message.Type r1 = r5.h;
        this.e = r1;
        this.i = r5.e;
        Channel.Type r2 = r5.g;
        this.f = r2;
        if (r2 != Channel.Type.CHAT) goto L5;
        String r3 = r0;
    L6:
        this.g = r3;
        if (TextUtils.isEmpty(r5.d) == false) goto L9;
        String r4 = UUID.randomUUID().toString();
    L10:
        this.d = r4;
        this.h = r5.i;
        this.j = r5.j;
        this.k = r5.k;
        this.l = r5.l;
        this.m = r5.m;
        this.n = r5.n;
        this.o = Long.valueOf(r5.o);
        this.p = r5.p;
        this.r = r5.r;
        this.s = r5.s;
        this.t = r5.t;
        this.u = r5.u;
        this.q = r5.q;
        this.v = r5.v;
        this.w = r5.w;
        this.x = r5.x;
        this.y = r5.y;
        this.z = r5.z;
        if (r0 == null) goto L15;
        if (r1 == null) goto L15;
        return;
    L15:
        throw new IllegalArgumentException("miss required field");
    L9:
        r4 = r5.d;
        goto L10
    L5:
        r3 = r5.f;
        goto L6
    }

    public final Message b(String r6, String r7) {
        Message r0 = new Message();
        r0.setChatId(this.c);
        r0.setRootId(this.a);
        r0.setParentId(this.b);
        if (TextUtils.isEmpty(this.h) == true) goto L5;
        r0.setThreadId(this.h);
    L5:
        r0.setType(this.e);
        if (this.m == false) goto L10;
        r0.setPosition(-3);
        int r1 = this.i;
        if (r1 < 0) goto L14;
        r0.setThreadPosition(r1 + 1);
    L14:
        if (TextUtils.isEmpty(r6) == true) goto L17;
        r0.setcId(r6);
        r0.setId(r6);
    L20:
        long r3 = e.e();
        r0.setCreateTime(r3);
        r0.setUpdateTime(r3);
        r0.setSendStatus(SendStatus.SENDING);
        r0.setFromType(Message.FromType.USER);
        r0.setIsFromMe(true);
        r0.setFromId(r7);
        Channel.Type r8 = this.f;
        if (r8 != Channel.Type.CHAT) goto L23;
        String r2 = this.c;
    L24:
        r0.setChannel(new Channel(r8, r2));
        Long r9 = this.p;
        if (r9 == null) goto L27;
        r0.setAiChatModeId(r9.longValue());
    L27:
        return r0;
    L23:
        r2 = this.g;
        goto L24
    L17:
        if (TextUtils.isEmpty(this.d) == false) goto L19;
        String r10 = UUID.randomUUID().toString();
        r0.setcId(r10);
        r0.setId(r10);
        goto L20
    L19:
        r0.setcId(this.d);
        r0.setId(this.d);
        goto L20
    L10:
        int r4 = this.i;
        if (r4 < 0) goto L14;
        r0.setPosition(r4);
        goto L14
    }
}

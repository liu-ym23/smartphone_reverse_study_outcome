package b2b;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.content.LocationContent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends MessageParams<a, C0008a> {
    public final LocationContent A;
    public final String B;
    public final int C;
    public final int D;

    /* JADX INFO: renamed from: b2b.a$a, reason: collision with other inner class name */
    public static final class C0008a extends MessageParams.a<a, C0008a> {
        public LocationContent A;
        public String B;
        public int C;
        public int D;

        @Override // com.ss.android.lark.chat.entity.message.MessageParams.a
        public final MessageParams a() {
            this.h = Message.Type.LOCATION;
            return new a(this);
        }

        public C0008a() {
        }
    }

    public a(C0008a r2) {
        super(r2);
        this.A = r2.A;
        this.B = r2.B;
        this.C = r2.C;
        this.D = r2.D;
    }

    @Override // com.ss.android.lark.chat.entity.message.MessageParams
    public final Message c(String r1, String r2) {
        Message r3 = b(r1, r2);
        r3.setType(Message.Type.LOCATION);
        r3.setMessageContent(this.A);
        return r3;
    }
}

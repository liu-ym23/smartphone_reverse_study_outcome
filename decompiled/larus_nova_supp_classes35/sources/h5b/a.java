package h5b;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.widget.richtext.RichText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends MessageParams<a, C0230a> {
    public final String A;
    public final int B;
    public final AudioContent.AudioState C;
    public final String D;
    public final String E;
    public final String F;
    public final RichText G;

    /* JADX INFO: renamed from: h5b.a$a, reason: collision with other inner class name */
    public static final class C0230a extends MessageParams.a<a, C0230a> {
        public String A;
        public int B;
        public AudioContent.AudioState C;
        public String D;
        public String E;

        public final a b() {
            this.h = Message.Type.AUDIO;
            return new a(this);
        }

        @Override // com.ss.android.lark.chat.entity.message.MessageParams.a
        public final /* bridge */ /* synthetic */ MessageParams a() {
            return b();
        }

        public C0230a() {
        }
    }

    public a(C0230a r2) {
        super(r2);
        this.A = r2.A;
        this.B = r2.B;
        this.C = r2.C;
        this.D = r2.D;
        this.E = r2.E;
        this.F = null;
        this.G = null;
    }

    @Override // com.ss.android.lark.chat.entity.message.MessageParams
    public final Message c(String r2, String r3) {
        Message r4 = b(r2, r3);
        r4.setType(Message.Type.AUDIO);
        AudioContent r5 = new AudioContent();
        r5.setLocalFilePath(this.A);
        r5.setDuration(this.B);
        r5.setFileState(this.C);
        r5.setUploadId(this.D);
        r5.setAudioToken(this.E);
        if (this.F == null) goto L5;
        boolean r0 = true;
    L6:
        r5.setAudioWithText(r0);
        String r1 = this.F;
        if (r1 != null) goto L10;
        r1 = BuildConfig.FLAVOR;
    L10:
        r5.setRecognizedText(r1);
        r5.setRecognizedRichText(this.G);
        r4.setMessageContent(r5);
        return r4;
    L5:
        r0 = false;
        goto L6
    }
}

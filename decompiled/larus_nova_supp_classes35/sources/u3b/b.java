package u3b;

import android.text.TextUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends a {
    public final String a;
    public String b;
    public final String c;
    public final String d;
    public final fxa.b e;

    @Override // u3b.a
    public final String a() {
        return "ChatDataPreLoadTask_uniqueId:" + this.a;
    }

    public b(fxa.b r2) {
        this.e = r2;
        this.b = r2.getChatId();
        this.c = r2.getMessageId();
        String r0 = r2.b();
        this.d = r0;
        r2.o();
        r2.isSecretChat();
        if (TextUtils.isEmpty(this.b) == true) goto L5;
        r0 = this.b;
    L5:
        this.a = r0;
    }
}

package w3b;

import android.text.TextUtils;
import com.larksuite.framework.utils.l0;
import com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.DataPreLoaderType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements d<i7b.a> {
    public final fxa.b a;
    public final String b;
    public String c;
    public final String d;
    public final String e;
    public final fxa.b f;

    /* JADX INFO: renamed from: w3b.a$a, reason: collision with other inner class name */
    public static final class C0315a {
    }

    static {
    }

    @Override // w3b.d
    public final DataPreLoaderType type() {
        return DataPreLoaderType.CHAT_DATA;
    }

    public a(fxa.b r2) {
        Intrinsics.checkNotNullParameter(r2, "chatBundle");
        this.a = r2;
        this.c = r2.getChatId();
        this.d = r2.getMessageId();
        String r0 = r2.b();
        this.e = r0;
        r2.o();
        r2.isSecretChat();
        this.f = r2;
        if (TextUtils.isEmpty(this.c) == true) goto L5;
        r0 = this.c;
    L5:
        if (r0 != null) goto L7;
        r0 = l0.a().toString();
    L7:
        this.b = r0;
    }
}

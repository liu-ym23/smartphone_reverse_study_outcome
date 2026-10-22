package w3b;

import com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.DataPreLoaderType;
import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements d<ChatMessageResponse> {
    public final String a;
    public final int b;

    public static final class a {
    }

    static {
    }

    public final String a() {
        return String.format("ChatWindowPreLoadTask_chatId:%s_showPosition:%s", Arrays.copyOf(new Object[]{this.a, String.valueOf(this.b)}, 2));
    }

    @Override // w3b.d
    public final DataPreLoaderType type() {
        return DataPreLoaderType.CHAT_WINDOW;
    }

    public b(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        this.a = r2;
        this.b = r3;
    }
}

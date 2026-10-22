package androidx.emoji2.text;

import android.content.Context;
import android.os.Handler;
import androidx.core.provider.FontRequest;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class FontRequestEmojiCompatConfig extends EmojiCompat.Config {
    private static final FontProviderHelper DEFAULT_FONTS_CONTRACT = null;

    static {
        DEFAULT_FONTS_CONTRACT = new FontProviderHelper();
    }

    public FontRequestEmojiCompatConfig setHandler(Handler r1) {
        if (r1 != null) goto L4;
        return this;
    L4:
        setLoadingExecutor(ConcurrencyHelpers.convertHandlerToExecutor(r1));
        return this;
    }

    public FontRequestEmojiCompatConfig setLoadingExecutor(Executor r2) {
        getMetadataRepoLoader().setExecutor(r2);
        return this;
    }

    public FontRequestEmojiCompatConfig setRetryPolicy(RetryPolicy r2) {
        getMetadataRepoLoader().setRetryPolicy(r2);
        return this;
    }

    public FontRequestEmojiCompatConfig(Context r3, FontRequest r4) {
        super(new FontRequestMetadataLoader(r3, r4, DEFAULT_FONTS_CONTRACT));
    }

    public FontRequestEmojiCompatConfig(Context r2, FontRequest r3, FontProviderHelper r4) {
        super(new FontRequestMetadataLoader(r2, r3, r4));
    }
}

package s22;

import com.bytedance.android.livehostapi.platform.depend.im.IMEmoji;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface b {
    IMEmoji a(String r1);

    void b(String r1, Function1<? super String, Unit> r2);

    List<IMEmoji> getEmojiList();
}

package or1;

import com.bytedance.android.livesdk.chatroom.bl.PlatformMessageHelper;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements PlatformMessageHelper.c {
    public final /* synthetic */ Function0 a;

    public f() {
        this.a = null;
    }

    public final void AS(BaseMessage r1) {
        if (r1 != null) goto L8;
        Function0 r2 = this.a;
        if (r2 == null) goto L6;
        Unit r3 = (Unit) r2.invoke();
    L6:
        PlatformMessageHelper.INSTANCE.onMessageFinish();
        return;
    }
}

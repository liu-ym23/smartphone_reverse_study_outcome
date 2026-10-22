package lf8;

import android.view.View;
import com.larus.bmhome.chat.cache.MessageHeightCache;
import com.larus.im.bean.message.Message;
import com.larus.utils.o0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d implements View.OnLayoutChangeListener {
    public final /* synthetic */ Message a;

    public d(Message r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        if (o0.d(this.a.getMessageId()) == false) goto L9;
        MessageHeightCache r10 = MessageHeightCache.INSTANCE;
        String r11 = this.a.getMessageId();
        if (r11 != null) goto L7;
        r11 = "";
    L7:
        r10.put(r11, Integer.valueOf(r1.getHeight()));
        return;
    }
}

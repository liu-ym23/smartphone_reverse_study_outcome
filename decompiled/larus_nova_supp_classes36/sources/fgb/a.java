package fgb;

import com.ss.android.lark.biz.im.api.extension.message.IMessageResourcePreloadTask;
import com.ss.android.lark.biz.im.api.extension.message.f;
import com.ss.android.lark.chat.chatwindow.chat.model.preload.audio.AudioResourceLoadTask;
import com.ss.android.lark.chat.core.api.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements e {
    public a() {
    }

    public final List<IMessageResourcePreloadTask> a(f r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        ArrayList r0 = new ArrayList();
        r0.add(new AudioResourceLoadTask(r5));
        ArrayList r6 = new ArrayList();
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Object r2 = r1.next();
        if (((IMessageResourcePreloadTask) r2).getScenes().contains("chat") == false) goto L4;
        r6.add(r2);
        goto L4
    L8:
        return r6;
    }

    public final List<IMessageResourcePreloadTask> b(f r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new ArrayList();
    }
}

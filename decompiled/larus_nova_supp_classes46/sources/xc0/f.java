package xc0;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.cache.LruCache;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.m;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ d a;
    public final /* synthetic */ Function2 b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public f(d r1, Function2 r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r5) {
        String r6 = (String) r5;
        m r1 = null;
        if (TextUtils.isEmpty(r6) == false) goto L17;
        this.b.invoke(Boolean.FALSE, null);
        ALogger.e("InteractAnimation.ResourceReader", "readAndParseInteractEmoji#file empty:" + this.c);
        return;
    L17:
        r1 = (m) GsonHelper.get().fromJson(r6, m.class);     // Catch: Throwable -> L7
    L9:
        if (r1 == null) goto L15;
        d r7 = this.a;
        String r0 = this.d;
        r7.getClass();
        d.a(r0, r1.getSenderEmoji());
        d.a(r0, r1.getPathEmoji());
        d.a(r0, r1.getReceiverEmoji());
        LruCache<String, m> r8 = h.a;
        String r9 = this.c;
        Intrinsics.checkNotNullParameter(r9, "key");
        Intrinsics.checkNotNullParameter(r1, "value");
        if (TextUtils.isEmpty(r9) == true) goto L14;
        h.a.put(r9, r1);
    L14:
        this.b.invoke(Boolean.TRUE, r1);
        ALogger.i("InteractAnimation.ResourceReader", "readAndParseInteractEmoji#JSON parse success:" + this.c + ",data:" + r1);
        return;
    L15:
        this.b.invoke(Boolean.FALSE, r1);
        ALogger.i("InteractAnimation.ResourceReader", "readAndParseInteractEmoji#JSON parse failed:" + this.c);
        return;
    L7:
        th = move-exception;
        ALogger.e("InteractAnimation.ResourceReader", "readAndParseInteractEmoji#JSON parse error:" + th);
        goto L9
    }
}

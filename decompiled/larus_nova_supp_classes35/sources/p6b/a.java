package p6b;

import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.chat.service.impl.u;
import com.ss.android.lark.chat.service.impl.v;
import com.ss.android.lark.videosend.compress.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class a extends m {
    public final d.b a;
    public int b;

    public a(d.b r2) {
        this.b = -1;
        this.a = r2;
    }

    public final void a(float r3) {
        if (this.b != (-1)) goto L7;
        v r0 = this.a.e;
        if ((r0 instanceof v) == false) goto L7;
        r0.onCompressMediaStart();
    L7:
        int r4 = (int) (r3 * 60.0f);
        if (r4 > this.b) goto L10;
        return;
    L10:
        d.b r1 = this.a;
        if (r1.d == true) goto L13;
    L15:
        this.b = r4;
        return;
    L13:
        if ((r1.e instanceof u) == false) goto L15;
        MediaContent r2 = new MediaContent((MediaContent) this.a.b.getContent());
        r2.setProgress(r4);
        this.a.b.setMessageContent(r2);
        d.b r5 = this.a;
        r5.e.onUpdateMediaCompressProgress(r5.b);
        goto L15
    }
}

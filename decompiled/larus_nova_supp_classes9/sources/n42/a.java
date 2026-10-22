package n42;

import android.graphics.Rect;
import android.graphics.Typeface;
import com.bytedance.android.livesdk.interactivity.api.utils.MessageCommonColorUtil;
import com.bytedance.android.livesdkapi.depend.live.MessageSceneType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public int a;
    public Typeface b;
    public int c;
    public Rect d;
    public boolean e;
    public boolean f;
    public Integer g;
    public Integer h;
    public int i;
    public int j;
    public int k;
    public int l;
    public MessageSceneType m;

    public final String toString() {
        StringBuilder r0 = new StringBuilder("TextMessageStyleConfig{messageTextSizeInPx=");
        r0.append(this.a);
        r0.append(", messageTypeface=");
        Typeface r1 = this.b;
        String r2 = "null";
        if (r1 != null) goto L5;
        Object r3 = "null";
    L6:
        r0.append(r3);
        r0.append(", messageMinHeight=");
        r0.append(this.c);
        r0.append(", messagePadding=");
        Rect r4 = this.d;
        if (r4 != null) goto L9;
        String r5 = "null";
    L10:
        r0.append(r5);
        r0.append(", countTextSizeInPx=");
        r0.append(this.i);
        r0.append(", countTextColor=");
        r0.append(this.j);
        r0.append(", countTextMinHeight=");
        r0.append(this.k);
        r0.append(", countTextBackgroundResId=");
        r0.append(this.l);
        r0.append(", textSceneType=");
        MessageSceneType r6 = this.m;
        if (r6 == null) goto L14;
        r2 = r6.toString();
    L14:
        r0.append(r2);
        r0.append('}');
        return r0.toString();
    L9:
        r5 = r4.toString();
        goto L10
    L5:
        r3 = Integer.valueOf(r1.getStyle());
        goto L6
    }

    public a() {
        this.e = false;
        this.f = false;
        this.g = null;
        this.h = null;
        int r0 = MessageCommonColorUtil.a;
        MessageCommonColorUtil.d();
        MessageCommonColorUtil.d();
    }
}

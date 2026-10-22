package lh;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.pia.core.misc.LRUCache;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import ko.r;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.lynx.animax.player.b f19630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LRUCache f19631b;

    public g() {
        this.f19630a = new com.lynx.animax.player.b(12);
        this.f19631b = new LRUCache();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String a(Uri r13) {
        LRUCache r5 = this.f19631b;
        String r10 = (String) r5.get(r13);
        if (TextUtils.isEmpty(r10) == true) goto L5;
        return r10;
    L5:
        r r11 = r.h(r13);
        if (r11 != null) goto L8;
        return null;
    L8:
        com.lynx.animax.player.b r12 = this.f19630a;
        r12.getClass();
        ArrayList r14 = (ArrayList) r11.f18728b;
        int r15 = 0;
        if (r14.isEmpty() == true) goto L27;
        Stack r16 = new Stack();
        r16.push(new e((f) r12.f9657b, 0));
    L13:
        if (r16.isEmpty() == true) goto L27;
        e r17 = (e) r16.pop();
        int r18 = r17.f19626b;
        int r19 = r14.size();
        f r20 = r17.f19625a;
        if (r18 == r19) goto L16;
        Object r21 = r14.get(r18);
        String r22 = (String) r12.f9658c;
        if (r22 == null) goto L24;
        f r23 = (f) r20.f19627a.get(r22);
        if (r23 == null) goto L24;
        r16.push(new e(r23, r18 + 1));
    L24:
        f r24 = (f) r20.f19627a.get(r21);
        if (r24 == null) goto L13;
        r16.push(new e(r24, r18 + 1));
        goto L13
    L16:
        r r25 = r20.f19628b;
        if (r25 == null) goto L13;
    L28:
        if (r25 != null) goto L53;
        return null;
    L53:
        StringBuilder r110 = new StringBuilder("pia_page");     // Catch: Throwable -> L52
    L33:
        if (r15 >= r14.size()) goto L39;
        if (((String) ((ArrayList) r25.f18728b).get(r15)).startsWith("^") == false) goto L38;
        r110.append("/");     // Catch: Throwable -> L52
        r110.append((String) r14.get(r15));     // Catch: Throwable -> L52
    L38:
        r15 = r15 + 1;     // Catch: Throwable -> L52
        goto L33
    L39:
        ArrayList r26 = (ArrayList) r25.f18729c;     // Catch: Throwable -> L52
        if (r26 == null) goto L47;
        Iterator r27 = r26.iterator();     // Catch: Throwable -> L52
    L43:
        if (r27.hasNext() == false) goto L47;
        String r28 = r13.getQueryParameter((String) r27.next());     // Catch: Throwable -> L52
        if (TextUtils.isEmpty(r28) == true) goto L43;
        r110.append("/");     // Catch: Throwable -> L52
        r110.append(r28);     // Catch: Throwable -> L52
    L47:
        String r111 = r110.toString();     // Catch: Throwable -> L52
        if (r111.equals("pia_page") == false) goto L50;
        return null;
    L50:
        r5.put(r13, r111);     // Catch: Throwable -> L52
        return r111;
    L52:
        return null;
    L27:
        r25 = null;
        goto L28
    }
}

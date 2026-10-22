package n4a;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.AutoEndConversationTime;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class n3 {
    public final LinkedList<m3> a;
    public final PolarisFileWrapper b;
    public boolean c;
    public final Handler d;
    public final String e;
    public boolean f;
    public final a g;

    public class a implements Runnable {
        public final /* synthetic */ n3 a;

        public a(n3 r1) {
            this.a = r1;
        }

        public final void a() {
            n3 r0 = this.a;
            if (r0.c == false) goto L5;
            return;
        L5:
            if (r0.f == false) goto L18;
            StringBuilder r1 = new StringBuilder();
            Iterator<m3> r2 = r0.a.iterator();
        L8:
            if (r2.hasNext() == false) goto L14;
            r1.append(y4.d(t3.c(r2.next().a().getBytes("UTF-8"), r0.e)) + "\n");     // Catch: UnsupportedEncodingException -> L12
        L12:
            e = move-exception;
            e.printStackTrace();
            goto L8
        L14:
            String r3 = r1.toString();
            if (TextUtils.isEmpty(r3) == true) goto L17;
            j4.h(r0.b, r3);
        L17:
            this.a.f = false;
        L18:
            n3 r4 = this.a;
            Handler r5 = r4.d;
            if (r5 == null) goto L29;
            r5.postDelayed(r4.g, AutoEndConversationTime.AFTER_60_SECONDS);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void b(m3 r10, int r11) {
        Iterator<m3> r0 = this.a.iterator();
        m3 r2 = null;
        m3 r3 = null;
        int r4 = 0;
    L4:
        if (r0.hasNext() == false) goto L11;
        m3 r5 = r0.next();
        if (r5.a != r11) goto L4;
        if (r3 != null) goto L9;
        r3 = r5;
    L9:
        r4 = r4 + 1;
        r2 = r5;
        goto L4
    L11:
        if (r2 == null) goto L18;
        if ((r10.d - r2.d) >= AutoEndConversationTime.AFTER_20_SECONDS) goto L18;
        if (j4.c(new double[]{r10.b, r10.c, r2.b, r2.c}) >= 20.0f) goto L18;
        return;
    L18:
        if (r4 < 5) goto L21;
        this.a.remove(r3);
    L21:
        if (this.a.size() < 10) goto L23;
        this.a.removeFirst();
    L23:
        this.a.add(r10);
        this.f = true;
    }

    public n3(Context r3, Handler r4) {
        this.a = new LinkedList();
        this.c = false;
        this.e = null;
        this.g = new a(this);
        this.d = r4;
        String r5 = r3.getFilesDir().getPath();
        this.e = j4.I(r3);
        this.b = new PolarisFileWrapper(r5, "hisloc");     // Catch: Throwable -> L5
    L6:
        LinkedList<m3> r6 = this.a;
        if (r6 != null) goto L9;
    L11:
        Iterator r7 = ((ArrayList) j4.g(this.b)).iterator();
    L13:
        if (r7.hasNext() == false) goto L21;
        String r0 = new String(t3.e(y4.e((String) r7.next()), this.e), "UTF-8");     // Catch: JSONException -> L17 UnsupportedEncodingException -> L19
        m3 r8 = new m3();     // Catch: JSONException -> L17 UnsupportedEncodingException -> L19
        r8.b(new JSONObject(r0));     // Catch: JSONException -> L17 UnsupportedEncodingException -> L19
        this.a.add(r8);     // Catch: JSONException -> L17 UnsupportedEncodingException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
    L17:
        e = move-exception;
        e.printStackTrace();
    L21:
        Handler r9 = this.d;
        if (r9 == null) goto L34;
        r9.removeCallbacks(this.g);
        this.d.postDelayed(this.g, AutoEndConversationTime.AFTER_60_SECONDS);
        return;
    L34:
        return;
    L9:
        if (r6.size() <= 0) goto L11;
        goto L11
    }

    public final List<m3> a(ArrayList<k3> r10, ArrayList<v2> r11) {
        int r0 = 0;
        if (r10 != null) goto L5;
    L17:
        boolean r12 = true;
    L18:
        if (r12 == false) goto L28;
        long r13 = System.currentTimeMillis();
        ArrayList r1 = new ArrayList();
        Iterator<m3> r2 = this.a.iterator();
    L21:
        if (r2.hasNext() == false) goto L27;
        m3 r3 = r2.next();
        if ((r13 - r3.d) >= 21600000000L) goto L26;
        r1.add(r3);
        r0 = r0 + 1;
    L26:
        if (r0 != 10) goto L21;
    L27:
        return r1;
    L28:
        return null;
    L5:
        if (r10.size() <= 0) goto L17;
        if (r11 == null) goto L17;
        if (r11.size() <= 0) goto L17;
        if (r10.size() < 4) goto L15;
    L13:
        r12 = false;
        goto L18
    L15:
        if (r11.size() < 20) goto L17;
        goto L17
    }
}

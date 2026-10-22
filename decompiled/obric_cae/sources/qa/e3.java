package qa;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<d3> f10369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f10370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f10372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f10373e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f10374f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f10375g;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e3 f10376a;

        public a(e3 r8) {
            this.f10376a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e3 r8 = this.f10376a;
            if (r8.f10371c == false) goto L5;
            return;
        L5:
            if (r8.f10374f == false) goto L18;
            StringBuilder r10 = new StringBuilder();
            Iterator<d3> r11 = r8.f10369a.iterator();
        L8:
            if (r11.hasNext() == false) goto L14;
            String r12 = r11.next().a();     // Catch: UnsupportedEncodingException -> L12
            StringBuilder r13 = new StringBuilder();     // Catch: UnsupportedEncodingException -> L12
            byte[] r14 = r12.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L12
            r13.append(l4.d(h3.b(r8.f10373e, r14)));     // Catch: UnsupportedEncodingException -> L12
            r13.append("\n");     // Catch: UnsupportedEncodingException -> L12
            r10.append(r13.toString());     // Catch: UnsupportedEncodingException -> L12
        L12:
            e = move-exception;
            e.printStackTrace();
            goto L8
        L14:
            String r15 = r10.toString();
            if (TextUtils.isEmpty(r15) == true) goto L17;
            y3.g(r8.f10370b, r15);
        L17:
            r8.f10374f = false;
        L18:
            Handler r16 = r8.f10372d;
            if (r16 == null) goto L29;
            r16.postDelayed(r8.f10375g, 60000);
            return;
        }
    }

    public e3(Context r8, Handler r10) {
        this.f10369a = new LinkedList();
        this.f10371c = false;
        this.f10373e = null;
        this.f10375g = new a(this);
        this.f10372d = r10;
        String r11 = r8.getFilesDir().getPath();
        this.f10373e = y3.E(r8);
        this.f10370b = new File(r11, "hisloc");     // Catch: Throwable -> L23
    L4:
        LinkedList<d3> r12 = this.f10369a;
        if (r12 != null) goto L7;
    L9:
        Iterator r13 = y3.f(this.f10370b).iterator();
    L11:
        if (r13.hasNext() == false) goto L19;
        byte[] r14 = l4.e((String) r13.next());     // Catch: JSONException -> L15 UnsupportedEncodingException -> L17
        String r15 = new String(h3.e(this.f10373e, r14), "UTF-8");     // Catch: JSONException -> L15 UnsupportedEncodingException -> L17
        d3 r16 = new d3();     // Catch: JSONException -> L15 UnsupportedEncodingException -> L17
        r16.b(new JSONObject(r15));     // Catch: JSONException -> L15 UnsupportedEncodingException -> L17
        r12.add(r16);     // Catch: JSONException -> L15 UnsupportedEncodingException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
    L15:
        e = move-exception;
        e.printStackTrace();
    L19:
        Handler r17 = this.f10372d;
        if (r17 == null) goto L33;
        r17.removeCallbacks(this.f10375g);
        this.f10372d.postDelayed(this.f10375g, 60000);
        return;
    L33:
        return;
    L7:
        if (r12.size() <= 0) goto L9;
        goto L9
    }

    public final ArrayList a(ArrayList r8, ArrayList r10) {
        int r11 = 0;
        if (r8 != null) goto L5;
    L17:
        boolean r12 = true;
    L18:
        if (r12 == false) goto L28;
        long r13 = System.currentTimeMillis();
        ArrayList r14 = new ArrayList();
        Iterator<d3> r15 = this.f10369a.iterator();
    L21:
        if (r15.hasNext() == false) goto L27;
        d3 r16 = r15.next();
        if ((r13 - r16.f10303d) >= 21600000000L) goto L26;
        r14.add(r16);
        r11 = r11 + 1;
    L26:
        if (r11 != 10) goto L21;
    L27:
        return r14;
    L28:
        return null;
    L5:
        if (r8.size() <= 0) goto L17;
        if (r10 == null) goto L17;
        if (r10.size() <= 0) goto L17;
        if (r8.size() < 4) goto L15;
    L16:
        r12 = false;
        goto L18
    L15:
        if (r10.size() < 20) goto L17;
        goto L16
    }

    public final void b(d3 r11, int r12) {
        LinkedList<d3> r8 = this.f10369a;
        Iterator<d3> r10 = r8.iterator();
        d3 r13 = null;
        int r14 = 0;
        d3 r15 = null;
    L4:
        if (r10.hasNext() == false) goto L11;
        d3 r16 = r10.next();
        if (r16.f10300a != r12) goto L4;
        if (r15 != null) goto L9;
        r15 = r16;
    L9:
        r14 = r14 + 1;
        r13 = r16;
        goto L4
    L11:
        if (r13 == null) goto L18;
        if ((r11.f10303d - r13.f10303d) >= 20000) goto L18;
        if (y3.b(new double[]{r11.f10301b, r11.f10302c, r13.f10301b, r13.f10302c}) >= 20.0f) goto L18;
        return;
    L18:
        if (r14 < 5) goto L21;
        r8.remove(r15);
    L21:
        if (r8.size() < 10) goto L23;
        r8.removeFirst();
    L23:
        r8.add(r11);
        this.f10374f = true;
    }
}

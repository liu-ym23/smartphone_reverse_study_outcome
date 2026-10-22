package r5;

import android.text.TextUtils;
import android.util.Log;
import android.util.Printer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f11494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f11495b;

    public static class a implements Printer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList f11496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList f11497b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList f11498c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f11499d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f11500e;

        public a() {
            this.f11496a = new ArrayList();
            this.f11497b = new ArrayList();
            this.f11498c = new ArrayList();
            this.f11499d = false;
            this.f11500e = false;
        }

        @Override // android.util.Printer
        public final void println(String r8) {
            if (TextUtils.isEmpty(r8) == false) goto L5;
            return;
        L5:
            char r10 = r8.charAt(0);
            ArrayList r11 = this.f11498c;
            ArrayList r12 = this.f11496a;
            if (r10 != '>') goto L17;
            if (this.f11500e == false) goto L17;
            Iterator r13 = r11.iterator();
        L11:
            if (r13.hasNext() == false) goto L15;
            Printer r14 = (Printer) r13.next();
            if (r12.contains(r14) == true) goto L11;
            r12.add(r14);
            goto L11
        L15:
            r11.clear();
            this.f11500e = false;
        L17:
            if (r12.size() <= 5) goto L19;
            Log.e("LooperPrinterUtils", "wrapper contains too many printer,please check if the useless printer have been removed");
        L19:
            Iterator r15 = r12.iterator();
        L21:
            if (r15.hasNext() == false) goto L26;
            Printer r16 = (Printer) r15.next();
            if (r16 == null) goto L21;
            r16.println(r8);
            goto L21
        L26:
            if (r8.charAt(0) == '<') goto L28;
            return;
        L28:
            if (this.f11499d == false) goto L47;
            ArrayList r17 = this.f11497b;
            Iterator r18 = r17.iterator();
        L31:
            if (r18.hasNext() == false) goto L33;
            Printer r19 = (Printer) r18.next();
            r12.remove(r19);
            r11.remove(r19);
            goto L31
        L33:
            r17.clear();
            this.f11499d = false;
            return;
        }
    }
}

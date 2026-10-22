package com.bytedance.monitor.collector;

import androidx.core.app.NotificationCompat;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class m {

    static class a implements Comparator<b> {
        a() {
        }

        public int a(b r10, b r11) {
            return Long.compare(((long) (r11.f2373g + 1)) * (r11.f2376j - r11.f2375i), ((long) (r10.f2373g + 1)) * (r10.f2376j - r10.f2375i));
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(b r10, b r11) {
            return a(r10, r11);
        }
    }

    static class b implements Comparable<b> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f2372c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f2373g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        long f2374h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        long f2375i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        long f2376j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        long f2377k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        long f2378l;

        public b(boolean r10, int r11, long r12, long r13, long r14, long r15) {
            this.f2372c = false;
            this.f2372c = r10;
            this.f2373g = r11;
            this.f2374h = r12;
            this.f2375i = r13;
            this.f2376j = r14;
            this.f2377k = r15;
            this.f2378l = (r14 - r13) / TimeUtils.NANOSECONDS_PER_MILLISECOND;
        }

        public int a(b r10) {
            long r11 = this.f2375i;
            long r12 = r10.f2375i;
            if (r11 <= r12) goto L7;
            return 1;
        L7:
            if (r11 != r12) goto L10;
            return 0;
        L10:
            return -1;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(b r10) {
            return a(r10);
        }

        public String toString() {
            StringBuilder r10 = new StringBuilder();
            r10.append(this.f2373g);
            r10.append(",");
            if (this.f2372c == false) goto L5;
            String r11 = NotificationCompat.CATEGORY_SYSTEM;
        L6:
            r10.append(r11);
            r10.append(",");
            r10.append(this.f2374h);
            r10.append(",");
            r10.append(this.f2375i);
            r10.append(",");
            r10.append(this.f2376j);
            r10.append(",");
            r10.append(this.f2377k);
            return r10.toString();
        L5:
            r11 = "app";
            goto L6
        }
    }

    public static String a(List<b> r10, long r11) {
        StringBuilder r12 = new StringBuilder();
        long r13 = (long) (r11 * 0.3f);
        LinkedList r14 = new LinkedList();
        Iterator<b> r15 = r10.iterator();
    L4:
        if (r15.hasNext() == false) goto L8;
        b r16 = r15.next();
        if ((r16.f2376j - r16.f2375i) < r13) goto L4;
        r14.add(r16);
        goto L4
    L8:
        Collections.sort(r14, new a());
        if (r14.isEmpty() == true) goto L11;
    L13:
        Iterator r17 = r14.iterator();
        if (r17.hasNext() == false) goto L17;
        r12.append(((b) r17.next()).f2374h + "\n");
    L17:
        return r12.toString();
    L11:
        if (r10.isEmpty() == true) goto L13;
        r14.add(r10.get(0));
        goto L13
    }

    private static LinkedList<b> b(String r19) {
        LinkedList<b> r10 = new LinkedList();
        String[] r11 = r19.split("\n");
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L11;
        String[] r14 = r11[r13].split(",");
        if (r14 == null) goto L10;
        if (r14.length < 6) goto L10;
        r10.add(new b(r14[1].startsWith(NotificationCompat.CATEGORY_SYSTEM), Integer.parseInt(r14[0]), Long.parseLong(r14[2]), Long.parseLong(r14[3]), Long.parseLong(r14[4]), Long.parseLong(r14[5])));
    L10:
        r13 = r13 + 1;
        goto L3
    L11:
        Collections.sort(r10);
        return r10;
    }

    public static String c(String r10, StringBuilder r11, int r12, long r13) {
        LinkedList<b> r14 = b(r10);
    L4:
        if (r14.size() <= r12) goto L11;
        long r15 = 21;
        Iterator<b> r16 = r14.iterator();
    L7:
        if (r16.hasNext() == false) goto L4;
        if (r16.next().f2378l >= r15) goto L7;
        r16.remove();
        goto L7
    L11:
        Iterator<b> r17 = r14.iterator();
    L13:
        if (r17.hasNext() == false) goto L16;
        r11.append(r17.next().toString());
        r11.append('\n');
        goto L13
    L16:
        if (r14.size() != 0) goto L20;
        return null;
    L20:
        return a(r14, r13);
    }
}

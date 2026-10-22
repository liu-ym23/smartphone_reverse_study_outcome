package com.larus.bmhome.bigimg;

import com.larus.platform.model.GeoLocationInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface t1 {

    public static final class a {
        public static /* synthetic */ t1 a(t1 r15, String r16, boolean r17, boolean r18, int r19) {
            GeoLocationInfo r2 = null;
            if ((r19 & 1) == 0) goto L5;
            String r4 = r15.getName();
        L7:
            if ((r19 & 2) == 0) goto L9;
            String r5 = r15.getPath();
        L11:
            if ((r19 & 4) == 0) goto L13;
            long r6 = r15.e();
        L15:
            if ((r19 & 8) == 0) goto L17;
            String r8 = r15.g();
        L19:
            if ((r19 & 16) == 0) goto L21;
            int r9 = r15.c();
        L23:
            if ((r19 & 32) == 0) goto L25;
            boolean r10 = r15.b();
        L27:
            if ((r19 & 64) == 0) goto L29;
            boolean r11 = r15.isSelected();
        L31:
            if ((r19 & 128) == 0) goto L33;
            boolean r12 = r15.d();
        L35:
            if ((r19 & 256) == 0) goto L37;
            int r13 = r15.getIndex();
        L39:
            if ((r19 & 512) == 0) goto L42;
            r2 = r15.a();
        L42:
            return r15.f(r4, r5, r6, r8, r9, r10, r11, r12, r13, r2);
        L37:
            r13 = 0;
            goto L39
        L33:
            r12 = false;
            goto L35
        L29:
            r11 = r18;
            goto L31
        L25:
            r10 = r17;
            goto L27
        L21:
            r9 = 0;
            goto L23
        L17:
            r8 = null;
            goto L19
        L13:
            r6 = 0;
            goto L15
        L9:
            r5 = r16;
            goto L11
        L5:
            r4 = null;
            goto L7
        }
    }

    GeoLocationInfo a();

    boolean b();

    int c();

    boolean d();

    long e();

    t1 f(String r1, String r2, long r3, String r5, int r6, boolean r7, boolean r8, boolean r9, int r10, GeoLocationInfo r11);

    String g();

    int getIndex();

    int getMediaType();

    String getName();

    String getPath();

    boolean isSelected();
}

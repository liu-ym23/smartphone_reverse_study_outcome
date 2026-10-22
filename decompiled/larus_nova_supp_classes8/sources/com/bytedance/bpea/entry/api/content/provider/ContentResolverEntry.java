package com.bytedance.bpea.entry.api.content.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ContentResolverEntry {
    public static final Companion a = null;

    public static final class Companion {
        public Companion() {
        }

        public static String a(Uri r2) {
            String r3 = r2.getAuthority();
            if (r3 == null) goto L16;
            int r0 = r3.hashCode();
            if (r0 == (-845193793)) goto L14;
            if (r0 != (-456066902)) goto L16;
            if (r3.equals("com.android.calendar") == false) goto L16;
            return "calendar";
        L14:
            if (r3.equals("com.android.contacts") == false) goto L16;
            return "contact";
        L16:
            return "contentProvider";
        }

        @JvmStatic
        public final int delete(final ContentResolver r5, final Uri r6, final Bundle r7, Cert r8) throws BPEAException {
            return ((Number) BaseAuthEntry.a.a(e.a(r8, new String[]{a(r6)}, "contentProvider_delete", 240019), new ContentResolverEntry$Companion$delete$2(r5, r6, r7))).intValue();
        }

        @JvmStatic
        public final Uri insert(final ContentResolver r5, final Uri r6, final ContentValues r7, Cert r8) throws BPEAException {
            return (Uri) BaseAuthEntry.a.a(e.a(r8, new String[]{a(r6)}, "contentProvider_insert", 240017), new ContentResolverEntry$Companion$insert$1(r5, r6, r7));
        }

        @JvmStatic
        public final int delete(final ContentResolver r5, final Uri r6, final String r7, final String[] r8, Cert r9) throws BPEAException {
            return ((Number) BaseAuthEntry.a.a(e.a(r9, new String[]{a(r6)}, "contentProvider_delete", 240019), new ContentResolverEntry$Companion$delete$1(r5, r6, r7, r8))).intValue();
        }

        @JvmStatic
        public final Uri insert(final ContentResolver r5, final Uri r6, final ContentValues r7, final Bundle r8, Cert r9) throws BPEAException {
            return (Uri) BaseAuthEntry.a.a(e.a(r9, new String[]{a(r6)}, "contentProvider_insert", 240017), new ContentResolverEntry$Companion$insert$2(r5, r6, r7, r8));
        }

        @JvmStatic
        public final int update(final ContentResolver r5, final Uri r6, final ContentValues r7, final Bundle r8, Cert r9) throws BPEAException {
            return ((Number) BaseAuthEntry.a.a(e.a(r9, new String[]{a(r6)}, "contentProvider_update", 240018), new ContentResolverEntry$Companion$update$2(r5, r6, r7, r8))).intValue();
        }

        @JvmStatic
        public final Cursor query(final ContentResolver r9, final Uri r10, final String[] r11, final Bundle r12, final CancellationSignal r13, Cert r14) throws BPEAException {
            return (Cursor) BaseAuthEntry.a.a(e.a(r14, new String[]{a(r10)}, "contentProvider_query", 240004), new ContentResolverEntry$Companion$query$3(r9, r10, r11, r12, r13));
        }

        @JvmStatic
        public final int update(final ContentResolver r9, final Uri r10, final ContentValues r11, final String r12, final String[] r13, Cert r14) throws BPEAException {
            return ((Number) BaseAuthEntry.a.a(e.a(r14, new String[]{a(r10)}, "contentProvider_update", 240018), new ContentResolverEntry$Companion$update$1(r9, r10, r11, r12, r13))).intValue();
        }

        @JvmStatic
        public final Cursor query(final ContentResolver r11, final Uri r12, final String[] r13, final String r14, final String[] r15, final String r16, Cert r17) throws BPEAException {
            return (Cursor) BaseAuthEntry.a.a(e.a(r17, new String[]{a(r12)}, "contentProvider_query", 240004), new ContentResolverEntry$Companion$query$1(r11, r12, r13, r14, r15, r16));
        }

        @JvmStatic
        public final Cursor query(final ContentResolver r12, final Uri r13, final String[] r14, final String r15, final String[] r16, final String r17, final CancellationSignal r18, Cert r19) throws BPEAException {
            return (Cursor) BaseAuthEntry.a.a(e.a(r19, new String[]{a(r13)}, "contentProvider_query", 240004), new ContentResolverEntry$Companion$query$2(r12, r13, r14, r15, r16, r17, r18));
        }
    }

    @JvmStatic
    public static final int delete(ContentResolver r1, Uri r2, Bundle r3, Cert r4) throws BPEAException {
        return a.delete(r1, r2, r3, r4);
    }

    @JvmStatic
    public static final int delete(ContentResolver r6, Uri r7, String r8, String[] r9, Cert r10) throws BPEAException {
        return a.delete(r6, r7, r8, r9, r10);
    }

    @JvmStatic
    public static final Uri insert(ContentResolver r6, Uri r7, ContentValues r8, Bundle r9, Cert r10) throws BPEAException {
        return a.insert(r6, r7, r8, r9, r10);
    }

    @JvmStatic
    public static final Uri insert(ContentResolver r1, Uri r2, ContentValues r3, Cert r4) throws BPEAException {
        return a.insert(r1, r2, r3, r4);
    }

    @JvmStatic
    public static final Cursor query(ContentResolver r7, Uri r8, String[] r9, Bundle r10, CancellationSignal r11, Cert r12) throws BPEAException {
        return a.query(r7, r8, r9, r10, r11, r12);
    }

    @JvmStatic
    public static final Cursor query(ContentResolver r9, Uri r10, String[] r11, String r12, String[] r13, String r14, CancellationSignal r15, Cert r16) throws BPEAException {
        return a.query(r9, r10, r11, r12, r13, r14, r15, r16);
    }

    @JvmStatic
    public static final Cursor query(ContentResolver r8, Uri r9, String[] r10, String r11, String[] r12, String r13, Cert r14) throws BPEAException {
        return a.query(r8, r9, r10, r11, r12, r13, r14);
    }

    @JvmStatic
    public static final int update(ContentResolver r6, Uri r7, ContentValues r8, Bundle r9, Cert r10) throws BPEAException {
        return a.update(r6, r7, r8, r9, r10);
    }

    @JvmStatic
    public static final int update(ContentResolver r7, Uri r8, ContentValues r9, String r10, String[] r11, Cert r12) throws BPEAException {
        return a.update(r7, r8, r9, r10, r11, r12);
    }

    static {
        a = new Companion();
    }
}

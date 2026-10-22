package androidx.core.provider;

import ai.j0;
import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.FontResourcesParserCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class FontProvider {
    private static final Comparator<byte[]> sByteArrayComparator = null;

    public interface ContentQueryWrapper {
        static ContentQueryWrapper make(Context r5, Uri r10) {
            return new ContentQueryWrapperApi24Impl(r5, r10);
        }

        void close();

        Cursor query(Uri r5, String[] r10, String r11, String[] r12, String r13, CancellationSignal r14);
    }

    public static class ContentQueryWrapperApi16Impl implements ContentQueryWrapper {
        private final ContentProviderClient mClient;

        public ContentQueryWrapperApi16Impl(Context r5, Uri r10) {
            this.mClient = r5.getContentResolver().acquireUnstableContentProviderClient(r10);
        }

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public void close() {
            ContentProviderClient r5 = this.mClient;
            if (r5 == null) goto L6;
            r5.release();
            return;
        }

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public Cursor query(Uri r10, String[] r11, String r12, String[] r13, String r14, CancellationSignal r15) {
            ContentProviderClient r5 = this.mClient;
            if (r5 != null) goto L11;
            return null;
        L11:
            return r5.query(r10, r11, r12, r13, r14, r15);
        L8:
            e = move-exception;
            Log.w("FontsProvider", "Unable to query the content provider", e);
            return null;
        }
    }

    @RequiresApi(24)
    public static class ContentQueryWrapperApi24Impl implements ContentQueryWrapper {
        private final ContentProviderClient mClient;

        public ContentQueryWrapperApi24Impl(Context r5, Uri r10) {
            this.mClient = r5.getContentResolver().acquireUnstableContentProviderClient(r10);
        }

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public void close() {
            ContentProviderClient r5 = this.mClient;
            if (r5 == null) goto L6;
            r5.close();
            return;
        }

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public Cursor query(Uri r10, String[] r11, String r12, String[] r13, String r14, CancellationSignal r15) {
            ContentProviderClient r5 = this.mClient;
            if (r5 != null) goto L11;
            return null;
        L11:
            return r5.query(r10, r11, r12, r13, r14, r15);
        L8:
            e = move-exception;
            Log.w("FontsProvider", "Unable to query the content provider", e);
            return null;
        }
    }

    static {
        sByteArrayComparator = new a();
    }

    private FontProvider() {
    }

    public static /* synthetic */ int a(byte[] r5, byte[] r10) {
        return lambda$static$0(r5, r10);
    }

    private static List<byte[]> convertToByteArrayList(Signature[] r5) {
        ArrayList r10 = new ArrayList();
        int r11 = r5.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10.add(r5[r12].toByteArray());
        r12 = r12 + 1;
        goto L3
    L5:
        return r10;
    }

    private static boolean equalsByteArrayList(List<byte[]> r5, List<byte[]> r10) {
        if (r5.size() == r10.size()) goto L5;
        return false;
    L5:
        int r11 = 0;
    L7:
        if (r11 >= r5.size()) goto L12;
        if (Arrays.equals(r5.get(r11), r10.get(r11)) == false) goto L10;
        r11 = r11 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    private static List<List<byte[]>> getCertificates(FontRequest r5, Resources r10) {
        if (r5.getCertificates() == null) goto L7;
        return r5.getCertificates();
    L7:
        return FontResourcesParserCompat.readCerts(r10, r5.getCertificatesArrayResId());
    }

    @NonNull
    public static FontsContractCompat.FontFamilyResult getFontFamilyResult(@NonNull Context r5, @NonNull FontRequest r10, @Nullable CancellationSignal r11) throws PackageManager.NameNotFoundException {
        ProviderInfo r12 = getProvider(r5.getPackageManager(), r10, r5.getResources());
        if (r12 != null) goto L7;
        return FontsContractCompat.FontFamilyResult.create(1, null);
    L7:
        return FontsContractCompat.FontFamilyResult.create(0, query(r5, r10, r12.authority, r11));
    }

    @Nullable
    @VisibleForTesting
    public static ProviderInfo getProvider(@NonNull PackageManager r5, @NonNull FontRequest r10, @Nullable Resources r11) throws PackageManager.NameNotFoundException {
        String r12 = r10.getProviderAuthority();
        int r13 = 0;
        ProviderInfo r14 = r5.resolveContentProvider(r12, 0);
        if (r14 == null) goto L18;
        if (r14.packageName.equals(r10.getProviderPackage()) == false) goto L15;
        List<byte[]> r15 = convertToByteArrayList(r5.getPackageInfo(r14.packageName, 64).signatures);
        Collections.sort(r15, sByteArrayComparator);
        List<List<byte[]>> r16 = getCertificates(r10, r11);
    L8:
        if (r13 >= r16.size()) goto L13;
        ArrayList r17 = new ArrayList(r16.get(r13));
        Collections.sort(r17, sByteArrayComparator);
        if (equalsByteArrayList(r15, r17) == true) goto L11;
        r13 = r13 + 1;
        goto L8
    L11:
        return r14;
    L13:
        return null;
    L15:
        StringBuilder r18 = j0.x("Found content provider ", r12, ", but package was not ");
        r18.append(r10.getProviderPackage());
        throw new PackageManager.NameNotFoundException(r18.toString());
    L18:
        throw new PackageManager.NameNotFoundException(j0.C("No package found for authority: ", r12));
    }

    private static /* synthetic */ int lambda$static$0(byte[] r5, byte[] r10) {
        if (r5.length != r10.length) goto L5;
        int r11 = 0;
    L8:
        if (r11 >= r5.length) goto L14;
        byte r12 = r5[r11];
        byte r13 = r10[r11];
        if (r12 != r13) goto L12;
        r11 = r11 + 1;
        goto L8
    L12:
        return r12 - r13;
    L14:
        return 0;
    L5:
        return r5.length - r10.length;
    }

    @NonNull
    @VisibleForTesting
    public static FontsContractCompat.FontInfo[] query(Context r16, FontRequest r17, String r18, CancellationSignal r19) {
        ArrayList r5 = new ArrayList();
        Uri r10 = new Uri.Builder().scheme("content").authority(r18).build();
        Uri r11 = new Uri.Builder().scheme("content").authority(r18).appendPath("file").build();
        ContentQueryWrapper r12 = ContentQueryWrapper.make(r16, r10);
        Cursor r13 = null;
        r13 = r12.query(r10, new String[]{"_id", FontsContractCompat.Columns.FILE_ID, FontsContractCompat.Columns.TTC_INDEX, FontsContractCompat.Columns.VARIATION_SETTINGS, FontsContractCompat.Columns.WEIGHT, FontsContractCompat.Columns.ITALIC, "result_code"}, "query = ?", new String[]{r17.getQuery()}, null, r19);     // Catch: Throwable -> L13
        if (r13 != null) goto L6;
    L33:
        if (r13 == null) goto L35;
        r13.close();
    L35:
        r12.close();
        return (FontsContractCompat.FontInfo[]) r5.toArray(new FontsContractCompat.FontInfo[0]);
    L6:
        if (r13.getCount() <= 0) goto L33;
        int r14 = r13.getColumnIndex("result_code");     // Catch: Throwable -> L13
        ArrayList r15 = new ArrayList();     // Catch: Throwable -> L13
        int r20 = r13.getColumnIndex("_id");     // Catch: Throwable -> L13
        int r21 = r13.getColumnIndex(FontsContractCompat.Columns.FILE_ID);     // Catch: Throwable -> L13
        int r22 = r13.getColumnIndex(FontsContractCompat.Columns.TTC_INDEX);     // Catch: Throwable -> L13
        int r23 = r13.getColumnIndex(FontsContractCompat.Columns.WEIGHT);     // Catch: Throwable -> L13
        int r110 = r13.getColumnIndex(FontsContractCompat.Columns.ITALIC);     // Catch: Throwable -> L13
    L8:
        if (r13.moveToNext() == false) goto L32;
        if (r14 == (-1)) goto L15;
        int r111 = r13.getInt(r14);     // Catch: Throwable -> L13
    L16:
        if (r22 == (-1)) goto L18;
        int r112 = r13.getInt(r22);     // Catch: Throwable -> L13
    L19:
        if (r21 != (-1)) goto L21;
        Uri r24 = ContentUris.withAppendedId(r10, r13.getLong(r20));     // Catch: Throwable -> L13
    L22:
        if (r23 == (-1)) goto L24;
        int r25 = r13.getInt(r23);     // Catch: Throwable -> L13
    L25:
        if (r110 == (-1)) goto L29;
        boolean r113 = true;
        if (r13.getInt(r110) != 1) goto L29;
    L30:
        FontsContractCompat.FontInfo r26 = FontsContractCompat.FontInfo.create(r24, r112, r25, r113, r111);     // Catch: Throwable -> L13
        r15 = r15;
        r15.add(r26);     // Catch: Throwable -> L13
    L29:
        r113 = false;
        goto L30
    L24:
        r25 = 400;
        goto L25
    L21:
        r24 = ContentUris.withAppendedId(r11, r13.getLong(r21));     // Catch: Throwable -> L13
        goto L22
    L18:
        r112 = 0;
        goto L19
    L15:
        r111 = 0;
        goto L16
    L32:
        r5 = r15;
    L13:
        th = move-exception;
        if (r13 == null) goto L39;
        r13.close();
    L39:
        r12.close();
        throw th;
    }
}

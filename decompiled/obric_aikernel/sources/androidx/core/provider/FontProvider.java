package androidx.core.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.annotation.DoNotInline;
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

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static Cursor query(ContentResolver r10, Uri r11, String[] r12, String r13, String[] r14, String r15, Object r16) {
            return r10.query(r11, r12, r13, r14, r15, (CancellationSignal) r16);
        }
    }

    static {
        sByteArrayComparator = a.f337c;
    }

    private FontProvider() {
    }

    public static /* synthetic */ int a(byte[] r10, byte[] r11) {
        return lambda$static$0(r10, r11);
    }

    private static List<byte[]> convertToByteArrayList(Signature[] r10) {
        ArrayList r11 = new ArrayList();
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.add(r10[r13].toByteArray());
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    private static boolean equalsByteArrayList(List<byte[]> r10, List<byte[]> r11) {
        if (r10.size() == r11.size()) goto L5;
        return false;
    L5:
        int r12 = 0;
    L7:
        if (r12 >= r10.size()) goto L12;
        if (Arrays.equals(r10.get(r12), r11.get(r12)) == false) goto L10;
        r12 = r12 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    private static List<List<byte[]>> getCertificates(FontRequest r10, Resources r11) {
        if (r10.getCertificates() == null) goto L7;
        return r10.getCertificates();
    L7:
        return FontResourcesParserCompat.readCerts(r11, r10.getCertificatesArrayResId());
    }

    @NonNull
    static FontsContractCompat.FontFamilyResult getFontFamilyResult(@NonNull Context r10, @NonNull FontRequest r11, @Nullable CancellationSignal r12) {
        ProviderInfo r13 = getProvider(r10.getPackageManager(), r11, r10.getResources());
        if (r13 != null) goto L7;
        return FontsContractCompat.FontFamilyResult.create(1, null);
    L7:
        return FontsContractCompat.FontFamilyResult.create(0, query(r10, r11, r13.authority, r12));
    }

    @Nullable
    @VisibleForTesting
    static ProviderInfo getProvider(@NonNull PackageManager r10, @NonNull FontRequest r11, @Nullable Resources r12) {
        String r13 = r11.getProviderAuthority();
        int r14 = 0;
        ProviderInfo r15 = r10.resolveContentProvider(r13, 0);
        if (r15 == null) goto L18;
        if (r15.packageName.equals(r11.getProviderPackage()) == false) goto L16;
        List<byte[]> r16 = convertToByteArrayList(r10.getPackageInfo(r15.packageName, 64).signatures);
        Collections.sort(r16, sByteArrayComparator);
        List<List<byte[]>> r17 = getCertificates(r11, r12);
    L8:
        if (r14 >= r17.size()) goto L13;
        ArrayList r18 = new ArrayList(r17.get(r14));
        Collections.sort(r18, sByteArrayComparator);
        if (equalsByteArrayList(r16, r18) == true) goto L11;
        r14 = r14 + 1;
        goto L8
    L11:
        return r15;
    L13:
        return null;
    L16:
        throw new PackageManager.NameNotFoundException("Found content provider " + r13 + ", but package was not " + r11.getProviderPackage());
    L18:
        throw new PackageManager.NameNotFoundException("No package found for authority: " + r13);
    }

    private static /* synthetic */ int lambda$static$0(byte[] r10, byte[] r11) {
        if (r10.length == r11.length) goto L7;
        int r12 = r10.length;
        int r13 = r11.length;
    L6:
        return r12 - r13;
    L7:
        int r14 = 0;
    L9:
        if (r14 >= r10.length) goto L14;
        if (r10[r14] != r11[r14]) goto L12;
        r14 = r14 + 1;
        goto L9
    L12:
        r12 = r10[r14];
        r13 = r11[r14];
        goto L6
    L14:
        return 0;
    }

    @NonNull
    @VisibleForTesting
    static FontsContractCompat.FontInfo[] query(Context r16, FontRequest r17, String r18, CancellationSignal r19) {
        ArrayList r10 = new ArrayList();
        Uri r11 = new Uri.Builder().scheme("content").authority(r18).build();
        Uri r12 = new Uri.Builder().scheme("content").authority(r18).appendPath("file").build();
        Cursor r13 = null;
        String[] r14 = {"_id", FontsContractCompat.Columns.FILE_ID, FontsContractCompat.Columns.TTC_INDEX, FontsContractCompat.Columns.VARIATION_SETTINGS, FontsContractCompat.Columns.WEIGHT, FontsContractCompat.Columns.ITALIC, "result_code"};     // Catch: Throwable -> L39
        ContentResolver r15 = r16.getContentResolver();     // Catch: Throwable -> L39
        int r110 = 0;
        if (Build.VERSION.SDK_INT <= 16) goto L6;
        r13 = Api16Impl.query(r15, r11, r14, "query = ?", new String[]{r17.getQuery()}, null, r19);     // Catch: Throwable -> L39
    L7:
        if (r13 != null) goto L9;
    L35:
        if (r13 == null) goto L38;
        r13.close();
    L38:
        return (FontsContractCompat.FontInfo[]) r10.toArray(new FontsContractCompat.FontInfo[0]);
    L9:
        if (r13.getCount() <= 0) goto L35;
        int r20 = r13.getColumnIndex("result_code");     // Catch: Throwable -> L39
        ArrayList r21 = new ArrayList();     // Catch: Throwable -> L39
        int r22 = r13.getColumnIndex("_id");     // Catch: Throwable -> L39
        int r23 = r13.getColumnIndex(FontsContractCompat.Columns.FILE_ID);     // Catch: Throwable -> L39
        int r24 = r13.getColumnIndex(FontsContractCompat.Columns.TTC_INDEX);     // Catch: Throwable -> L39
        int r25 = r13.getColumnIndex(FontsContractCompat.Columns.WEIGHT);     // Catch: Throwable -> L39
        int r26 = r13.getColumnIndex(FontsContractCompat.Columns.ITALIC);     // Catch: Throwable -> L39
    L11:
        if (r13.moveToNext() == false) goto L34;
        if (r20 == (-1)) goto L16;
        int r111 = r13.getInt(r20);     // Catch: Throwable -> L39
    L17:
        if (r24 == (-1)) goto L19;
        int r112 = r13.getInt(r24);     // Catch: Throwable -> L39
    L20:
        int r113 = r111;
        if (r23 != (-1)) goto L23;
        Uri r114 = ContentUris.withAppendedId(r11, r13.getLong(r22));     // Catch: Throwable -> L39
    L24:
        if (r25 == (-1)) goto L26;
        int r115 = r13.getInt(r25);     // Catch: Throwable -> L39
    L27:
        if (r26 != (-1)) goto L29;
    L31:
        boolean r116 = false;
    L32:
        r21.add(FontsContractCompat.FontInfo.create(r114, r112, r115, r116, r113));     // Catch: Throwable -> L39
        r110 = 0;
        goto L11
    L29:
        if (r13.getInt(r26) != 1) goto L31;
        r116 = true;
        goto L32
    L26:
        r115 = 400;
        goto L27
    L23:
        r114 = ContentUris.withAppendedId(r12, r13.getLong(r23));     // Catch: Throwable -> L39
        goto L24
    L19:
        r112 = r110;
        goto L20
    L16:
        r111 = r110;
        goto L17
    L34:
        r10 = r21;
        goto L35
    L6:
        r13 = r15.query(r11, r14, "query = ?", new String[]{r17.getQuery()}, null);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        if (r13 == null) goto L42;
        r13.close();
    L42:
        throw th;
    }
}

package g0;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f7504a = null;

    public static class a {
        public static Cursor a(ContentResolver r8, Uri r10, String[] r11, String r12, String[] r13, String r14, Object r15) {
            return r8.query(r10, r11, r12, r13, r14, (CancellationSignal) r15);
        }
    }

    static {
        f7504a = new d(0);
    }

    public static l a(Context r22, f r23) {
        PackageManager r8 = r22.getPackageManager();
        Resources r10 = r22.getResources();
        String r11 = r23.f7505a;
        ProviderInfo r12 = r8.resolveContentProvider(r11, 0);
        if (r12 == null) goto L81;
        String r13 = r12.packageName;
        String r14 = r23.f7506b;
        if (r13.equals(r14) == false) goto L79;
        Signature[] r15 = r8.getPackageInfo(r12.packageName, 64).signatures;
        ArrayList r16 = new ArrayList();
        int r17 = r15.length;
        int r18 = 0;
    L7:
        if (r18 >= r17) goto L9;
        r16.add(r15[r18].toByteArray());
        r18 = r18 + 1;
        goto L7
    L9:
        d r19 = f7504a;
        Collections.sort(r16, r19);
        List<List<byte[]>> r20 = r23.f7508d;
        if (r20 != null) goto L13;
        r20 = z.d.b(r10, 0);
    L13:
        int r21 = 0;
    L15:
        if (r21 >= r20.size()) goto L30;
        ArrayList r24 = new ArrayList(r20.get(r21));
        Collections.sort(r24, r19);
        if (r16.size() != r24.size()) goto L24;
        int r110 = 0;
    L21:
        if (r110 >= r16.size()) goto L26;
        if (Arrays.equals((byte[]) r16.get(r110), (byte[]) r24.get(r110)) == false) goto L24;
        r110 = r110 + 1;
        goto L21
    L26:
        boolean r25 = true;
    L27:
        if (r25 == true) goto L31;
        r21 = r21 + 1;
    L31:
        if (r12 == null) goto L33;
        String r26 = r12.authority;
        ArrayList r111 = new ArrayList();
        Uri r112 = new Uri.Builder().scheme("content").authority(r26).build();
        Uri r27 = new Uri.Builder().scheme("content").authority(r26).appendPath(BwdlDropConstant.FILE).build();
        Cursor r28 = a.a(r22.getContentResolver(), r112, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{r23.f7507c}, null, null);     // Catch: Throwable -> L73
        if (r28 != null) goto L82;
    L69:
        if (r28 == null) goto L72;
        r28.close();
    L72:
        return new l(0, (m[]) r111.toArray(new m[0]));
    L82:
    L67:
        th = th;
    L75:
        if (r28 == null) goto L77;
        r28.close();
    L77:
        throw th;
    L38:
        if (r28.getCount() <= 0) goto L69;
        int r29 = r28.getColumnIndex("result_code");     // Catch: Throwable -> L67
        r111 = new ArrayList();     // Catch: Throwable -> L67
        int r30 = r28.getColumnIndex("_id");     // Catch: Throwable -> L67
        int r31 = r28.getColumnIndex("file_id");     // Catch: Throwable -> L67
        int r32 = r28.getColumnIndex("font_ttc_index");     // Catch: Throwable -> L67
        int r33 = r28.getColumnIndex("font_weight");     // Catch: Throwable -> L67
        int r34 = r28.getColumnIndex("font_italic");     // Catch: Throwable -> L67
    L40:
        if (r28.moveToNext() == false) goto L69;
        if (r29 == (-1)) goto L45;
        int r35 = r28.getInt(r29);     // Catch: Throwable -> L67
    L46:
        int r210 = r35;
        if (r32 == (-1)) goto L49;
        int r36 = r28.getInt(r32);     // Catch: Throwable -> L67
    L50:
        int r113 = r36;
        if (r31 != (-1)) goto L53;
        Uri r37 = ContentUris.withAppendedId(r112, r28.getLong(r30));     // Catch: Throwable -> L67
    L54:
        Uri r114 = r37;
        if (r33 == (-1)) goto L57;
        int r38 = r28.getInt(r33);     // Catch: Throwable -> L67
    L58:
        int r115 = r38;
        if (r34 == (-1)) goto L64;
        if (r28.getInt(r34) != 1) goto L64;
        boolean r211 = true;
    L65:
        r111.add(new m(r114, r113, r115, r211, r210));     // Catch: Throwable -> L67
    L64:
        r211 = false;
        goto L65
    L57:
        r38 = 400;
        goto L58
    L53:
        r37 = ContentUris.withAppendedId(r27, r28.getLong(r31));     // Catch: Throwable -> L67
        goto L54
    L49:
        r36 = 0;
        goto L50
    L45:
        r35 = 0;
    L73:
        th = th;
        r28 = null;
        goto L75
    L33:
        return new l(1, null);
    L24:
        r25 = false;
        goto L27
    L30:
        r12 = null;
        goto L31
    L79:
        throw new PackageManager.NameNotFoundException(defpackage.b.e("Found content provider ", r11, ", but package was not ", r14));
    L81:
        throw new PackageManager.NameNotFoundException(defpackage.b.c("No package found for authority: ", r11));
    }
}

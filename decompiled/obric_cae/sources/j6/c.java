package j6;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8719a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f8720b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f8721m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f8722n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final a f8723o = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final a f8724p = null;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final /* synthetic */ a[] f8725q = null;

        static {
            a r8 = new a(BdimCategoryConstants.VALUE_NONE, 0);
            f8719a = r8;
            a r10 = new a("MOBILE", 1);
            f8720b = r10;
            a r11 = new a("MOBILE_2G", 2);
            f8721m = r11;
            a r12 = new a("MOBILE_3G", 3);
            f8722n = r12;
            a r13 = new a("WIFI", 4);
            f8723o = r13;
            a r14 = new a("MOBILE_4G", 5);
            f8724p = r14;
            f8725q = new a[]{r8, r10, r11, r12, r13, r14};
        }

        public a(String r8, int r10) {
            super(r8, r10);
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) f8725q.clone();
        }
    }

    public static a a(Context r8) {
        NetworkInfo r10 = ((ConnectivityManager) r8.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L47
        if (r10 == null) goto L46;
        if (r10.isAvailable() == false) goto L46;
        int r11 = r10.getType();     // Catch: Throwable -> L47
        if (1 == r11) goto L10;
        if (r11 != 0) goto L44;
        TelephonyManager r12 = (TelephonyManager) r8.getSystemService("phone");     // Catch: Throwable -> L47
        if (r12 != null) goto L17;
        return a.f8720b;
    L17:
        if (r12.getNetworkType() == 3) goto L42;
        if (r12.getNetworkType() == 5) goto L42;
        if (r12.getNetworkType() == 6) goto L42;
        if (r12.getNetworkType() == 8) goto L42;
        if (r12.getNetworkType() == 9) goto L42;
        if (r12.getNetworkType() == 10) goto L42;
        if (r12.getNetworkType() == 12) goto L42;
        if (r12.getNetworkType() == 14) goto L42;
        if (r12.getNetworkType() == 15) goto L42;
        if (r12.getNetworkType() != 13) goto L40;
        return a.f8724p;
    L40:
        return a.f8720b;
    L42:
        return a.f8722n;
    L44:
        return a.f8720b;
    L10:
        return a.f8723o;
    L46:
        return a.f8719a;
    L48:
        return a.f8720b;
    }

    public static boolean b(Context r8) {
        NetworkInfo r10 = ((ConnectivityManager) r8.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r10 == null) goto L12;
        if (r10.isAvailable() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }
}

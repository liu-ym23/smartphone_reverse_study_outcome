package f8;

import ai.j0;
import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.core.content.ContextCompat;
import com.bytedance.android.monitorV2.h;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.android.monitorV2.listener.e;
import com.bytedance.common.wschannel.server.NetworkUtils$NetworkType;
import com.bytedance.gkfs.cdc.c;
import com.bytedance.gkfs.io.ChunkFrom;
import com.bytedance.gkfs.io.d;
import com.bytedance.gkfs.io.j;
import com.bytedance.gkfs.io.k;
import com.bytedance.gkfs.io.l;
import com.bytedance.gkfs.io.m;
import com.bytedance.gkfs.io.n;
import com.bytedance.gkfs.storage.g;
import com.bytedance.gkfs.storage.i;
import com.google.common.base.b0;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nu.u;
import okio.ByteString;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public static NetworkUtils$NetworkType a(Context r5) {
        NetworkInfo r10 = ((ConnectivityManager) r5.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L47
        if (r10 == null) goto L46;
        if (r10.isAvailable() == false) goto L46;
        int r11 = r10.getType();     // Catch: Throwable -> L47
        if (1 == r11) goto L10;
        if (r11 != 0) goto L44;
        TelephonyManager r12 = (TelephonyManager) r5.getSystemService("phone");     // Catch: Throwable -> L47
        if (r12 != null) goto L17;
        return NetworkUtils$NetworkType.f4015b;
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
        return NetworkUtils$NetworkType.f;
    L40:
        return NetworkUtils$NetworkType.f4015b;
    L42:
        return NetworkUtils$NetworkType.d;
    L44:
        return NetworkUtils$NetworkType.f4015b;
    L10:
        return NetworkUtils$NetworkType.e;
    L46:
        return NetworkUtils$NetworkType.f4014a;
    L48:
        return NetworkUtils$NetworkType.f4015b;
    }

    public static void b() {
        if (e.f3615k == true) goto L16;
        h.e().a().d().getClass();
        if (Switches.f3594m.f3600a == false) goto L16;
        h r5 = h.e();
        e r10 = new e();
        r5.getClass();
        monitor-enter(r10);
        r5.f3585i.add(r10);     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
        e.f3615k = true;
    L12:
        th = move-exception;
        throw th;
    L16:
        if (com.bytedance.android.monitorV2.listener.b.f3610b == false) goto L19;
    L28:
        d5.b.c("SettingsParseManager", "highPriorityTaskDone");
        return;
    L19:
        if (Switches.f3593l.f3600a == false) goto L28;
        h r11 = h.e();
        com.bytedance.android.monitorV2.listener.b r12 = new com.bytedance.android.monitorV2.listener.b();
        r11.getClass();
        monitor-enter(r12);
        r11.f3586j.add(r12);     // Catch: Throwable -> L25
        monitor-exit(r12);     // Catch: Throwable -> L25
        com.bytedance.android.monitorV2.listener.b.f3610b = true;
    L25:
        th = move-exception;
        throw th;
    }

    public static void c(m r10) {
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L8
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L8
        File r12 = r10.f4893b;     // Catch: Throwable -> L8
        c r13 = r10.f4894c;
        j r14 = r10.f4892a;
        k r15 = r14.f4881b;
        List r16 = r14.f4882c;
        l r17 = r10.d;
        n r18 = r17.f4888c;
        r11.put("origin_file", r12.getAbsolutePath());     // Catch: Throwable -> L8
        r11.put("gkfs_version", r15.f4883a);     // Catch: Throwable -> L8
        r11.put("header_size", r15.f4885c);     // Catch: Throwable -> L8
        r11.put("chunk_count", r16.size());     // Catch: Throwable -> L8
        Iterator r19 = r16.iterator();     // Catch: Throwable -> L8
        int r20 = 0;
        int r21 = 0;
    L6:
        if (r19.hasNext() == false) goto L10;
        r21 = r21 + ((d) r19.next()).f4861c.f4928i;     // Catch: Throwable -> L8
        goto L6
    L10:
        r11.put("chunk_size", r21);     // Catch: Throwable -> L8
        Iterator r22 = r16.iterator();     // Catch: Throwable -> L8
    L12:
        if (r22.hasNext() == false) goto L14;
        r20 = r20 + ((Number) ((d) r22.next()).f4861c.f4924a.getValue()).intValue();     // Catch: Throwable -> L8
        goto L12
    L14:
        r11.put("chunk_diluted_size", r20);     // Catch: Throwable -> L8
        r11.put("cdc_stats", r13.f4825a.f4897c.f4849a);     // Catch: Throwable -> L8
        Throwable r23 = r13.f4825a.f4896b;     // Catch: Throwable -> L8
        if (r23 == null) goto L18;
        r11.put("cdc_error_msg", r23.getMessage() + ", cause:" + r23.getCause());     // Catch: Throwable -> L8
    L26:
        Object r24 = Result.m124constructorimpl(r11);     // Catch: Throwable -> L8
    L30:
        if (Result.m131isSuccessimpl(r24) == false) goto L32;
        com.lynx.tasm.utils.j.g("geckosdk_gkfs_store_stats", (JSONObject) r24);
    L32:
        Throwable r25 = Result.m127exceptionOrNullimpl(r24);
        if (r25 == null) goto L36;
        r25.printStackTrace();
    L36:
        if (Result.m130isFailureimpl(r24) == false) goto L38;
        r24 = null;
    L38:
        JSONObject r26 = (JSONObject) r24;
        return;
    L18:
        r11.put("min_size_suppress", r13.f4826b);     // Catch: Throwable -> L8
        r11.put("max_size_suppress", r13.f4827c);     // Catch: Throwable -> L8
        Iterator r27 = r13.d.values().iterator();     // Catch: Throwable -> L8
        long r28 = 0;
    L20:
        if (r27.hasNext() == false) goto L22;
        r28 = r28 + ((Number) r27.next()).longValue();     // Catch: Throwable -> L8
        goto L20
    L22:
        r11.put("cdc_chunk_time_cost", r28);     // Catch: Throwable -> L8
        r11.put("cdc_time_cost", r13.f);     // Catch: Throwable -> L8
        r11.put("store_stats", r18.f4897c.f4849a);     // Catch: Throwable -> L8
        Throwable r29 = r18.f4896b;     // Catch: Throwable -> L8
        if (r29 == null) goto L25;
        r11.put("store_error_msg", r29.getMessage() + ", cause:" + r29.getCause());     // Catch: Throwable -> L8
        goto L26
    L25:
        r11.put("header_time_cost", r17.d);     // Catch: Throwable -> L8
        r11.put("chunk_time_cost", CollectionsKt.D(r17.f.f4863b.values()));     // Catch: Throwable -> L8
        r11.put("tail_size", r17.f4890i);     // Catch: Throwable -> L8
        r11.put("tail_time_cost", r17.f4889h);     // Catch: Throwable -> L8
        r11.put("total_time_cost", r17.f4891j);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r24 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L30
    }

    public static void d(n r5, File r10, ChunkFrom r11, d r12) {
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L10
        if (r5.f4895a == false) goto L5;
        return;
    L5:
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L10
        r14.put("source_file", r10.getAbsolutePath());     // Catch: Throwable -> L10
        com.bytedance.gkfs.io.c r15 = r12.f4859a;     // Catch: Throwable -> L10
        com.bytedance.gkfs.storage.e r16 = r12.f4861c;
        r14.put("id", r15.f4858a);     // Catch: Throwable -> L10
        r14.put("stats", r5.f4897c.f4849a);     // Catch: Throwable -> L10
        Throwable r17 = r5.f4896b;     // Catch: Throwable -> L10
        if (r17 == null) goto L12;
        r14.put("error_msg", r17.getMessage() + ", cause:" + r17.getCause());     // Catch: Throwable -> L10
    L13:
        Object r18 = Result.m124constructorimpl(r14);     // Catch: Throwable -> L10
    L17:
        if (Result.m131isSuccessimpl(r18) == false) goto L19;
        com.lynx.tasm.utils.j.g("geckosdk_gkfs_chunk_read_stats", (JSONObject) r18);
    L19:
        Throwable r19 = Result.m127exceptionOrNullimpl(r18);
        if (r19 == null) goto L23;
        r19.printStackTrace();
    L23:
        if (Result.m130isFailureimpl(r18) == false) goto L25;
        r18 = null;
    L25:
        JSONObject r20 = (JSONObject) r18;
        return;
    L12:
        r14.put("from", r11.f4836a);     // Catch: Throwable -> L10
        r14.put("size", r16.f4928i);     // Catch: Throwable -> L10
        r14.put("lock_cost", r16.f);     // Catch: Throwable -> L10
        r14.put("indexing_cost", r16.e.f);     // Catch: Throwable -> L10
        r14.put("read_cost", r16.g);     // Catch: Throwable -> L10
        r14.put("total_cost", r16.f4927h);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r18 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    public static void e(StringBuilder r5, String r10, String r11, String r12, String r13) {
        androidx.constraintlayout.motion.widget.a.C(r5, r10, r11, r12, r13);
    }

    public static void f(Throwable r5, g r10, long r11) {
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L10
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L10
        if (r5 == null) goto L12;
        String r14 = r5.getMessage();     // Catch: Throwable -> L10
        if (r14 != null) goto L9;
        r14 = r5.toString();     // Catch: Throwable -> L10
    L9:
        r13.put("error_msg", r14);     // Catch: Throwable -> L10
    L15:
        Object r15 = Result.m124constructorimpl(r13);     // Catch: Throwable -> L10
    L19:
        if (Result.m131isSuccessimpl(r15) == false) goto L21;
        com.lynx.tasm.utils.j.g("geckosdk_gkfs_resource_info", (JSONObject) r15);
    L21:
        Throwable r16 = Result.m127exceptionOrNullimpl(r15);
        if (r16 == null) goto L25;
        r16.printStackTrace();
    L25:
        if (Result.m130isFailureimpl(r15) == false) goto L27;
        r15 = null;
    L27:
        JSONObject r17 = (JSONObject) r15;
        return;
    L12:
        if (r10 != null) goto L14;
        r13.put("error_msg", "GkFSChunkTidyInfo is null");     // Catch: Throwable -> L10
        goto L15
    L14:
        i r18 = r10.f;     // Catch: Throwable -> L10
        r13.put("gecko_total_resource_usage", r11);     // Catch: Throwable -> L10
        r13.put("gkfs_file_count", r18.f4937a);     // Catch: Throwable -> L10
        r13.put("gkfs_chunk_count", r18.f4938b);     // Catch: Throwable -> L10
        r13.put("gkfs_chunk_usage", r18.f4939c);     // Catch: Throwable -> L10
        r13.put("gkfs_total_resource_usage", r18.d);     // Catch: Throwable -> L10
        r13.put("gkfs_diluted_resource_usage", r18.e);     // Catch: Throwable -> L10
        r13.put("gkfs_tidy_delete_chunk_count", r10.f4931a);     // Catch: Throwable -> L10
        r13.put("gkfs_tidy_delete_chunk_size", 0);     // Catch: Throwable -> L10
        r13.put("gkfs_tidy_refs_reduce_chunk_count", r10.f4932b);     // Catch: Throwable -> L10
        r13.put("gkfs_tidy_chunk_indexing_cost", r10.f4933c);     // Catch: Throwable -> L10
        r13.put("gkfs_tidy_chunk_io_cost", r10.d);     // Catch: Throwable -> L10
        r13.put("gkfs_tidy_chunk_time_cost", r10.e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r15 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    public static boolean g(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        if (Build.VERSION.SDK_INT < 33) goto L14;
        if (r10.getApplicationInfo().targetSdkVersion < 33) goto L14;
        if (ContextCompat.checkSelfPermission(r10, "android.permission.ACCESS_COARSE_LOCATION") == (-1)) goto L9;
    L12:
        return true;
    L9:
        if (ContextCompat.checkSelfPermission(r10, "android.permission.ACCESS_FINE_LOCATION") != (-1)) goto L12;
        return false;
    L14:
        if (ContextCompat.checkSelfPermission(r10, "android.permission.ACCESS_COARSE_LOCATION") != (-1)) goto L16;
    L18:
        return false;
    L16:
        if (ContextCompat.checkSelfPermission(r10, "android.permission.ACCESS_FINE_LOCATION") == (-1)) goto L18;
        return true;
    }

    public static void h() {
        com.bytedance.android.monitorV2.c.f3517a.a();
        if (Switches.f3599r.f3600a == true) goto L5;
    L8:
        d5.b.c("SettingsParseManager", "lowPriorityTaskDone");
        return;
    L5:
        if (fj.a.f16916b == null) goto L7;
        pg.a.b("hybrid_monitor").d();
        d5.b.f("SettingsParseManager", "update app settings...");
        goto L8
    L7:
        fj.a.f16916b = new android.support.v4.media.c(2);
        goto L8
    }

    public static boolean i(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Object r10 = r5.getSystemService("location");
        if ((r10 instanceof LocationManager) == false) goto L5;
        LocationManager r11 = (LocationManager) r10;
    L6:
        if (r11 != null) goto L8;
        return false;
    L8:
        return r11.isLocationEnabled();
    L5:
        r11 = null;
        goto L6
    }

    public static boolean j(Context r5) {
        NetworkInfo r10 = ((ConnectivityManager) r5.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L10
        if (r10 == null) goto L9;
        if (r10.isAvailable() == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static void k(long r21, nu.j r23, int r24, List r25, int r26, int r27, List r28) {
        int r5 = r24;
        int r10 = 0;
        int r11 = 1;
        if (r26 >= r27) goto L5;
        boolean r12 = true;
    L7:
        if (r12 == false) goto L69;
        int r13 = r26;
    L9:
        if (r13 >= r27) goto L15;
        if (((ByteString) r25.get(r13)).size() < r5) goto L14;
        r13 = r13 + 1;
        goto L9
    L14:
        throw new IllegalArgumentException("Failed requirement.");
    L15:
        ByteString r14 = (ByteString) r25.get(r26);
        ByteString r15 = (ByteString) r25.get(r27 - 1);
        int r16 = -1;
        if (r5 != r14.size()) goto L18;
        int r17 = ((Number) r28.get(r26)).intValue();
        int r18 = r26 + 1;
        ByteString r19 = (ByteString) r25.get(r18);
        int r20 = r18;
        int r22 = r17;
        r14 = r19;
    L20:
        if (r14.getByte(r5) == r15.getByte(r5)) goto L51;
        int r29 = r20 + 1;
    L22:
        if (r29 >= r27) goto L27;
        if (((ByteString) r25.get(r29 - 1)).getByte(r5) == ((ByteString) r25.get(r29)).getByte(r5)) goto L26;
        r11 = r11 + 1;
    L26:
        r29 = r29 + 1;
        goto L22
    L27:
        long r30 = 4;
        long r110 = ((long) (r11 * 2)) + (((r23.f20328b / r30) + r21) + ((long) 2));
        r23.W(r11);
        r23.W(r22);
        int r31 = r20;
    L28:
        if (r31 >= r27) goto L35;
        int r32 = ((ByteString) r25.get(r31)).getByte(r5);
        if (r31 != r20) goto L32;
    L33:
        r23.W(r32 & 255);
    L34:
        r31 = r31 + 1;
        goto L28
    L32:
        if (r32 == ((ByteString) r25.get(r31 - 1)).getByte(r5)) goto L34;
    L35:
        nu.j r33 = new nu.j();
    L36:
        if (r20 >= r27) goto L50;
        byte r34 = ((ByteString) r25.get(r20)).getByte(r5);
        int r35 = r20 + 1;
        int r36 = r35;
    L38:
        if (r36 >= r27) goto L43;
        if (r34 != ((ByteString) r25.get(r36)).getByte(r5)) goto L41;
        r36 = r36 + 1;
        goto L38
    L41:
        int r37 = r36;
    L44:
        if (r35 == r37) goto L46;
    L48:
        r23.W(((int) ((r33.f20328b / r30) + r110)) * r16);
        int r111 = r37;
        k(r110, r33, r5 + 1, r25, r20, r111, r28);
    L49:
        r33 = r33;
        r20 = r111;
        r30 = r30;
        r16 = -1;
        goto L36
    L46:
        if ((r5 + 1) != ((ByteString) r25.get(r20)).size()) goto L48;
        r23.W(((Number) r28.get(r20)).intValue());
        r111 = r37;
        goto L49
    L43:
        r37 = r27;
        goto L44
    L50:
        r23.G(r33);
        return;
    L51:
        int r38 = Math.min(r14.size(), r15.size());
        int r39 = r5;
    L52:
        if (r39 >= r38) goto L56;
        if (r14.getByte(r39) != r15.getByte(r39)) goto L56;
        r10 = r10 + 1;
        r39 = r39 + 1;
    L56:
        long r112 = 4;
        long r40 = ((((r23.f20328b / r112) + r21) + ((long) 2)) + ((long) r10)) + 1;
        r23.W(-r10);
        r23.W(r22);
        int r41 = r5 + r10;
    L57:
        if (r5 >= r41) goto L60;
        r23.W(r14.getByte(r5) & 255);
        r5 = r5 + 1;
        goto L57
    L60:
        if ((r20 + 1) == r27) goto L62;
        nu.j r113 = new nu.j();
        r23.W(((int) ((r113.f20328b / r112) + r40)) * (-1));
        k(r40, r113, r41, r25, r20, r27, r28);
        r23.G(r113);
        return;
    L62:
        if (r41 != ((ByteString) r25.get(r20)).size()) goto L65;
        r23.W(((Number) r28.get(r20)).intValue());
        return;
    L65:
        throw new IllegalStateException("Check failed.");
    L18:
        r20 = r26;
        r22 = -1;
        goto L20
    L69:
        throw new IllegalArgumentException("Failed requirement.");
    L5:
        r12 = false;
        goto L7
    }

    public static int l(long r5, long r10) {
        long r11 = r5 ^ Long.MIN_VALUE;
        long r12 = r10 ^ Long.MIN_VALUE;
        if (r11 >= r12) goto L5;
        return -1;
    L5:
        if (r11 <= r12) goto L7;
        return 1;
    L7:
        return 0;
    }

    public static long m(long r5, long r10) {
        if (r10 >= 0) goto L10;
        if (l(r5, r10) >= 0) goto L7;
        return 0;
    L7:
        return 1;
    L10:
        if (r5 >= 0) goto L12;
        int r11 = 1;
        long r12 = ((r5 >>> 1) / r10) << 1;
        if (l(r5 - (r12 * r10), r10) >= 0) goto L18;
        r11 = 0;
    L18:
        return r12 + ((long) r11);
    L12:
        return r5 / r10;
    }

    public static u n(ByteString... r11) {
        Intrinsics.checkNotNullParameter(r11, "byteStrings");
        int r5 = 0;
        if (r11.length == 0) goto L5;
        List r10 = ArraysKt.toMutableList(r11);
        CollectionsKt.sort(r10);
        ArrayList r12 = new ArrayList(r11.length);
        int r13 = r11.length;
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L9;
        ByteString r15 = r11[r14];
        r14 = j0.d(-1, r12, r14, 1);
        goto L7
    L9:
        Object[] r16 = r12.toArray(new Integer[0]);
        if (r16 == null) goto L43;
        Integer[] r17 = (Integer[]) r16;
        List r18 = CollectionsKt.mutableListOf((Integer[]) Arrays.copyOf(r17, r17.length));
        int r19 = r11.length;
        int r20 = 0;
        int r21 = 0;
    L12:
        if (r20 >= r19) goto L15;
        r18.set(CollectionsKt.f(r10, r11[r20]), Integer.valueOf(r21));
        r20 = r20 + 1;
        r21 = r21 + 1;
        goto L12
    L15:
        if (((ByteString) r10.get(0)).size() <= 0) goto L41;
        int r22 = 0;
    L18:
        if (r22 >= r10.size()) goto L34;
        ByteString r23 = (ByteString) r10.get(r22);
        int r24 = r22 + 1;
        int r25 = r24;
    L21:
        if (r25 >= r10.size()) goto L33;
        ByteString r26 = (ByteString) r10.get(r25);
        if (r26.startsWith(r23) == false) goto L33;
        if (r26.size() == r23.size()) goto L32;
        if (((Number) r18.get(r25)).intValue() > ((Number) r18.get(r22)).intValue()) goto L29;
        r25 = r25 + 1;
        goto L21
    L29:
        r10.remove(r25);
        r18.remove(r25);
        goto L21
    L32:
        throw new IllegalArgumentException(("duplicate option: " + r26).toString());
    L33:
        r22 = r24;
        goto L18
    L34:
        nu.j r27 = new nu.j();
        k(0, r27, 0, r10, 0, r10.size(), r18);
        int[] r28 = new int[(int) (r27.f20328b / ((long) 4))];
    L36:
        if (r27.y() == true) goto L39;
        r28[r5] = r27.readInt();
        r5 = r5 + 1;
        goto L36
    L39:
        return new u((ByteString[]) Arrays.copyOf(r11, r11.length), r28);
    L41:
        throw new IllegalArgumentException("the empty byte string is not a supported option");
    L43:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L5:
        return new u(new ByteString[0], new int[]{0, -1});
    }

    public static long o(long r5, long r10) {
        if (r10 >= 0) goto L10;
        if (l(r5, r10) >= 0) goto L8;
        return r5;
    L8:
        return r5 - r10;
    L10:
        if (r5 >= 0) goto L12;
        long r11 = r5 - ((((r5 >>> 1) / r10) << 1) * r10);
        if (l(r11, r10) >= 0) goto L18;
        r10 = 0;
    L18:
        return r11 - r10;
    L12:
        return r5 % r10;
    }

    public static String p(long r10, int r11) {
        if (r11 >= 2) goto L5;
    L7:
        boolean r5 = false;
    L8:
        b0.d(r11, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", r5);
        if (r10 != 0) goto L12;
        return "0";
    L12:
        if (r10 > 0) goto L14;
        int r12 = 64;
        char[] r13 = new char[64];
        int r14 = r11 - 1;
        if ((r11 & r14) != 0) goto L22;
        int r15 = Integer.numberOfTrailingZeros(r11);
    L18:
        r12 = r12 - 1;
        r13[r12] = Character.forDigit(((int) r10) & r14, r11);
        r10 = r10 >>> r15;
        if (r10 != 0) goto L18;
    L31:
        return new String(r13, r12, 64 - r12);
    L22:
        if ((r11 & 1) != 0) goto L24;
        long r16 = (r10 >>> 1) / ((long) (r11 >>> 1));
    L25:
        long r17 = r11;
        int r18 = 63;
        r13[63] = Character.forDigit((int) (r10 - (r16 * r17)), r11);
    L27:
        if (r16 <= 0) goto L29;
        r18 = r18 - 1;
        r13[r18] = Character.forDigit((int) (r16 % r17), r11);
        r16 = r16 / r17;
        goto L27
    L29:
        r12 = r18;
        goto L31
    L24:
        r16 = m(r10, r11);
        goto L25
    L14:
        return Long.toString(r10, r11);
    L5:
        if (r11 > 36) goto L7;
        r5 = true;
        goto L8
    }
}

package ita;

import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.ttnet.INetworkApi;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import cua.b;
import eta.c;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    static {
        new String[]{"mac_address", "oaid", "openudid", "uuid", "imei"};
    }

    public static String a(int r9, String r10, List r11) throws Exception {
        c r7 = new c();
        if (StringUtils.isEmpty(r10) == false) goto L5;
        r7.setResult(null);
    L19:
        return r7.a;
    L5:
        LinkedHashMap r4 = new LinkedHashMap();
        Pair r12 = UrlUtils.parseUrl(r10, r4);
        if (r12 != null) goto L8;
        r7.setResult(null);
        goto L19
    L8:
        String r0 = (String) r12.first;
        String r3 = (String) r12.second;
        INetworkApi r1 = (INetworkApi) RetrofitUtils.createSsService(r0, INetworkApi.class);
        LinkedList r5 = new LinkedList();
        if (r11 != null) goto L11;
    L16:
        if (r1 == null) goto L19;
        SsResponse r13 = r1.doGet(true, r9, r3, r4, r5, null).execute();
        r7.setResult((String) r13.body());
        r13.code();
        goto L19
    L11:
        if (r11.isEmpty() == true) goto L16;
        Iterator r14 = r11.iterator();
    L14:
        if (r14.hasNext() == false) goto L16;
        b r15 = (b) r14.next();
        r5.add(new Header(r15.getName(), r15.getValue()));
        goto L14
    }

    public static String b(int r9, String r10, byte[] r11, NetworkUtils.CompressType r12, String r13) throws Exception {
        if (StringUtils.isEmpty(r10) == false) goto L6;
        return null;
    L6:
        if (r11 != null) goto L9;
        new Pair(r11, null);
    L9:
        if (r11 != null) goto L56;
        int r3 = 0;
    L13:
        if (NetworkUtils.CompressType.GZIP != r12) goto L26;
        if (r3 <= 128) goto L26;
        ByteArrayOutputStream r14 = new ByteArrayOutputStream(8192);     // Catch: Throwable -> L34
        GZIPOutputStream r4 = new GZIPOutputStream(r14);     // Catch: Throwable -> L34
        r4.write(r11);     // Catch: Throwable -> L19
        r4.close();     // Catch: Throwable -> L34
        r11 = r14.toByteArray();     // Catch: Throwable -> L34
        String r15 = DownloadHelper.GZIP;
    L37:
        Pair r16 = new Pair(r11, r15);
    L38:
        byte[] r17 = (byte[]) r16.first;
        String r18 = (String) r16.second;
        ArrayList r8 = new ArrayList();
        if (r18 == null) goto L41;
        r8.add(new Header(DownloadHelper.CONTENT_ENCODING, r18));
    L41:
        if (r13 != null) goto L43;
    L45:
        LinkedHashMap r6 = new LinkedHashMap();
        Pair r19 = UrlUtils.parseUrl(r10, r6);
        if (r19 != null) goto L48;
        return null;
    L48:
        String r110 = (String) r19.first;
        String r5 = (String) r19.second;
        INetworkApi r7 = (INetworkApi) RetrofitUtils.createSsService(r110, INetworkApi.class);
        if (r7 != null) goto L51;
        return null;
    L51:
        return (String) r7.postBody(r9, r5, r6, new TypedByteArray(null, r17, new String[0]), r8).execute().body();
    L43:
        if (r13.length() <= 0) goto L45;
        r8.add(new Header(DownloadHelper.CONTENT_TYPE, r13));
        goto L45
    L19:
        th = move-exception;
        Logger.w("NetworkUtils", "compress with gzip exception: " + th);     // Catch: Throwable -> L22
        r16 = new Pair(r11, null);     // Catch: Throwable -> L22
        r4.close();     // Catch: Throwable -> L34
        goto L38
    L22:
        th = move-exception;
        r4.close();     // Catch: Throwable -> L34
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        th.printStackTrace();
    L36:
        r15 = null;
    L26:
        if (NetworkUtils.CompressType.DEFLATER != r12) goto L36;
        if (r3 <= 128) goto L36;
        ByteArrayOutputStream r111 = new ByteArrayOutputStream(8192);     // Catch: Throwable -> L34
        Deflater r0 = new Deflater();     // Catch: Throwable -> L34
        r0.setInput(r11);     // Catch: Throwable -> L34
        r0.finish();     // Catch: Throwable -> L34
        byte[] r20 = new byte[8192];     // Catch: Throwable -> L34
    L30:
        if (r0.finished() == true) goto L32;
        r111.write(r20, 0, r0.deflate(r20));     // Catch: Throwable -> L34
        goto L30
    L32:
        r0.end();     // Catch: Throwable -> L34
        r11 = r111.toByteArray();     // Catch: Throwable -> L34
        r15 = "deflate";
        goto L37
    L56:
        r3 = r11.length;     // Catch: Throwable -> L34
        goto L13
    }
}

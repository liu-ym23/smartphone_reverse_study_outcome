package ms.bd.c;

import android.text.TextUtils;
import com.bytedance.mobsec.metasec.ml.MSManager;
import com.bytedance.mobsec.metasec.ml.MSManagerUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.Utils;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class l2 extends f2 {
    public a a;
    public long b;

    public final class a implements Interceptor {
        public final h4 a;
        public final /* synthetic */ l2 b;

        public a(l2 r1) {
            this.b = r1;
            this.a = new h4();
        }

        public static String a(String r8) {
            String r9 = new URL(r8).getQuery();     // Catch: Exception -> L19
            HashMap r1 = new HashMap();     // Catch: Exception -> L19
            if (r9 == null) goto L12;
            String[] r10 = r9.split("&");     // Catch: Exception -> L19
            int r2 = r10.length;     // Catch: Exception -> L19
            int r4 = 0;
        L6:
            if (r4 >= r2) goto L12;
            String[] r5 = r10[r4].split("=");     // Catch: Exception -> L19
            if (r5.length != 2) goto L10;
            r1.put(r5[0], r5[1]);     // Catch: Exception -> L19
        L10:
            r4 = r4 + 1;     // Catch: Exception -> L19
        L12:
            if (r1.isEmpty() == false) goto L14;
            return "";
        L14:
            if (r1.containsKey(EffectConfiguration.KEY_APP_ID) == false) goto L25;
            return (String) r1.get(EffectConfiguration.KEY_APP_ID);
        L25:
            return "";
        L26:
            return "";
        }

        public final SsResponse intercept(Interceptor.Chain r28) {
            Request r0 = r28.request();
            long r5 = this.b.b;
            byte r10 = 4;
            if (r5 == (-1)) goto L118;
            Object r2 = p2.a(50331651, 0, r5, null, null);
            if (r2 == null) goto L118;
            s r3 = s.a(d2.b.a);
            String r4 = r0.getUrl();
            monitor-enter(r3);
            if (r4 != null) goto L214;
            monitor-exit(r3);
        L12:
            r r14 = null;
        L54:
            if (r14 == null) goto L118;
            if ("off".equals(r14.b) == true) goto L118;
            if ("async".equals(r14.b) == false) goto L62;
            p2.a(33554433, 0, ((Long) r2).longValue(), "report-async_" + (System.currentTimeMillis() / 1000), d2.b.a);
            goto L118
        L62:
            if ("sync".equals(r14.b) == false) goto L118;
            HashMap r6 = new HashMap();
            Long r7 = (Long) r2;
            String r8 = ((String) p2.a(33554444, 0, r7.longValue(), null, null)) + "&cdi=0.3&sh=report_sync";
            String r9 = "";
            Object r11 = p2.a(33554440, c2.COLLECT_MODE_DEFAULT, r7.longValue(), "report_sync", null);
            if (r11 != null) goto L66;
        L74:
            StringBuilder r12 = new StringBuilder();
            byte[] r13 = r8.getBytes();
            String r15 = q.a;
            String r16 = "";
            StringBuilder r17 = new StringBuilder();     // Catch: Throwable -> L201
            int r18 = r13.length % 3;     // Catch: Throwable -> L201
            if (r18 <= 0) goto L80;
            r13 = Arrays.copyOf(r13, (r13.length + 3) - r18);     // Catch: Throwable -> L201
            String r19 = "";
        L78:
            if (r18 >= 3) goto L81;
            r19 = r19 + q.b;     // Catch: Throwable -> L201
            r18 = r18 + 1;     // Catch: Throwable -> L201
        L81:
            int r20 = 0;
        L83:
            if (r20 >= r13.length) goto L85;
            byte r110 = r13[r20];     // Catch: Throwable -> L201
            byte r111 = r13[r20 + 1];     // Catch: Throwable -> L201
            byte r112 = r13[r20 + 2];     // Catch: Throwable -> L201
            int r21 = (r110 >> 2) & 63;     // Catch: Throwable -> L201
            int r113 = ((r110 << r10) | (r111 >> 4)) & 63;     // Catch: Throwable -> L201
            String r114 = q.a;     // Catch: Throwable -> L201
            r17.append(r114.charAt(r21));     // Catch: Throwable -> L201
            r17.append(r114.charAt(r113));     // Catch: Throwable -> L201
            r17.append(r114.charAt(((r111 << 2) | (r112 >> 6)) & 63));     // Catch: Throwable -> L201
            r17.append(r114.charAt(r112 & 63));     // Catch: Throwable -> L201
            r20 = r20 + 3;     // Catch: Throwable -> L201
            r10 = 4;
            goto L83
        L85:
            String r22 = r17.toString();     // Catch: Throwable -> L201
            r16 = r22.substring(0, r22.length() - r19.length()) + r19;     // Catch: Throwable -> L201
            goto L86
        L80:
            r19 = "";
        L86:
            r12.append(q.a(r16));
            r12.append(";;");
            r12.append(q.a(r9));
            r6.put("x-bdms-payload", r12.toString());
            int r23 = d4.a;
            if (r6.size() <= 0) goto L118;
            if (((String) p2.a(16777217, 0, 0, "5c8840", new byte[]{52, 110, 88, 88})).equalsIgnoreCase(r0.getMethod()) == false) goto L118;
            if (r0.getRequestBody() != null) goto L98;
            TypedOutput r24 = r0.getBody();     // Catch: Exception -> L203
            if (r24 != null) goto L212;
        L97:
            RequestBody r25 = null;
        L99:
            String r26 = r25.contentType().subtype();     // Catch: Exception -> L203
            long r27 = r0.getBody().length();     // Catch: Exception -> L203
            if (r26.contains((String) p2.a(16777217, 0, 0, "b3bf9c", new byte[]{121, 34, 30, 28})) == false) goto L111;
            JSONObject r29 = new JSONObject(d4.a(r25));     // Catch: Exception -> L108
            Iterator r30 = r6.keySet().iterator();     // Catch: Exception -> L108
        L104:
            if (r30.hasNext() == false) goto L106;
            String r31 = (String) r30.next();     // Catch: Exception -> L108
            r29.put(r31, (String) r6.get(r31));     // Catch: Exception -> L108
            goto L104
        L106:
            r25 = RequestBody.create(r25.contentType(), r29.toString());     // Catch: Exception -> L108
        L114:
            if (r25 == null) goto L118;
            if (r25.contentLength() < r27) goto L118;
            r0 = r0.newBuilder().post(Utils.convert(r25)).build();     // Catch: Exception -> L203
            goto L118
        L111:
            if (r26.contains((String) p2.a(16777217, 0, 0, "e81fb4", new byte[]{114, 53, 80, 31, 16, 54, 116, 21, 101, 56, 119, 53, 70, 23, 89})) == false) goto L113;
            r25 = d4.b(r25, r6);     // Catch: Exception -> L203
            goto L114
        L113:
            r25 = null;
            goto L114
        L212:
            ByteArrayOutputStream r32 = new ByteArrayOutputStream();     // Catch: Exception -> L202
            r24.writeTo(r32);     // Catch: Exception -> L202
            r25 = RequestBody.create(MediaType.parse(r24.mimeType()), new String(r32.toByteArray(), (String) p2.a(16777217, 0, 0, "789759", new byte[]{19, 14, 108, 14, 82})));     // Catch: Exception -> L202
        L98:
            r25 = r0.getRequestBody();     // Catch: Exception -> L203
            goto L99
        L66:
            if ((r11 instanceof Object[]) == false) goto L74;
            Object[] r33 = (Object[]) r11;
            if (r33.length < 2) goto L74;
            if (r33[0] == null) goto L74;
            Object r34 = r33[1];
            if (r34 == null) goto L74;
            r9 = r34.toString();
            goto L74
        L214:
            Object r35 = p2.a(33554445, 3, 0, null, null);     // Catch: Throwable -> L198
            if (r35 != null) goto L17;
        L20:
            boolean r36 = true;
        L21:
            Object r37 = p2.a(33554445, 2, 0, null, null);     // Catch: Throwable -> L198
            if (r37 != null) goto L24;
        L26:
            boolean r38 = false;
        L27:
            Object r39 = p2.a(33554445, 1, 0, null, null);     // Catch: Throwable -> L198
            if (r39 != null) goto L30;
        L32:
            boolean r40 = false;
        L33:
            Iterator r41 = r3.b.iterator();     // Catch: Throwable -> L198
        L34:
            if (r41.hasNext() == false) goto L52;
            r14 = (r) r41.next();     // Catch: Throwable -> L198
            if (r14.a.equals(s.e) == false) goto L41;
            if (r40 == false) goto L34;
        L41:
            if (r14.a.equals(s.d) == false) goto L45;
            if (r38 == false) goto L34;
        L45:
            if (r14.a.equals(s.c) == false) goto L49;
            if (r36 == false) goto L34;
        L49:
            if (Pattern.compile(r14.a).matcher(r4).find() == false) goto L34;
            monitor-exit(r3);
            goto L54
        L52:
            monitor-exit(r3);
            goto L12
        L30:
            if (((Integer) r39).intValue() != 1) goto L32;
            r40 = true;
            goto L33
        L24:
            if (((Integer) r37).intValue() != 1) goto L26;
            r38 = true;
            goto L27
        L17:
            if (((Integer) r35).intValue() != 0) goto L20;
            r36 = false;
        L198:
            th = move-exception;
            throw th;
        L118:
            SsResponse r42 = r28.proceed(r0);
            Iterator r43 = r42.headers().iterator();
        L120:
            if (r43.hasNext() == false) goto L197;
            Header r44 = (Header) r43.next();
            String r45 = r44.getName();
            String r46 = r44.getValue();
            if ("x-bdms-dy".equals(r45) == false) goto L149;
            if (r46 == null) goto L149;
            r0 r47 = r0.a();
            String r48 = r0.getPath();
            r47.getClass();
            AtomicBoolean r49 = r0.d;
            if (r49.compareAndSet(false, true) == false) goto L145;
            AtomicInteger r50 = r0.t;
            r50.incrementAndGet();
            if (r0.J.size() <= 0) goto L140;
            if (r48 == null) goto L140;
            if (r48.length() >= r0.m) goto L140;
            if (r50.incrementAndGet() < r0.e) goto L134;
            r50.decrementAndGet();
            goto L140
        L134:
            if (k0.a().b(i0.c, r48) == true) goto L140;
            if (r50.decrementAndGet() >= 0) goto L140;
            r50.set(0);
        L140:
            if (k0.a().b(i0.b, r46) == true) goto L145;
            if (r50.decrementAndGet() >= 0) goto L144;
            r50.set(0);
        L144:
            r49.set(false);
        L145:
            AtomicInteger r51 = r0.t;
            if (r51.get() <= r0.e) goto L120;
            k0.a().b(i0.d, null);
            r51.set(0);
            r49.set(false);
        L149:
            if ("x-bdms-dy-sw".equals(r45) == false) goto L156;
            if (r46 == null) goto L156;
            r0.a().getClass();
            CastIntegerProtector.parseInt(r46);     // Catch: Exception -> L154
        L156:
            if ("x-bdms-cj".equals(r45) == false) goto L174;
            if (r46 == null) goto L174;
            if (r0 == null) goto L174;
            if (CastIntegerProtector.parseInt(r46.trim()) != 1) goto L120;
            String r52 = r0.getPath();     // Catch: Exception -> L172
            String r53 = a(r0.getUrl());     // Catch: Exception -> L172
            if (TextUtils.isEmpty(r53) == true) goto L120;
            MSManager r54 = MSManagerUtils.get(r53);     // Catch: Exception -> L172
            if (r54 == null) goto L120;
            Iterator r55 = this.a.keySet().iterator();     // Catch: Exception -> L172
        L167:
            if (r55.hasNext() == false) goto L120;
            String r56 = (String) r55.next();     // Catch: Exception -> L172
            if (r52.contains(r56) == false) goto L167;
            r54.report((String) this.a.get(r56));     // Catch: Exception -> L172
        L174:
            if ("x-bdms-ctrl".equals(r45) == false) goto L120;
            if (r46 == null) goto L120;
            Object r57 = p2.a(33554445, 4, 0, null, null);
            if (r57 == null) goto L120;
            if (((Integer) r57).intValue() != 1) goto L120;
            d2 r58 = d2.b;
            if (r58.a == null) goto L120;
            String r59 = r44.getValue();
            String r60 = q.a;
            if (r59 == null) goto L196;
            if (r59.length() <= 0) goto L196;
            int r115 = 4 - (r59.length() % 4);
            String r61 = "";
            if (r115 != 1) goto L190;
            r61 = q.b;
        L194:
            r59 = r59.replaceAll((String) p2.a(16777217, 0, 0, "62a233", new byte[]{106}), (String) p2.a(16777217, 0, 0, "88fbbf", new byte[]{98})).replaceAll((String) p2.a(16777217, 0, 0, "3249ed", new byte[]{29}), (String) p2.a(16777217, 0, 0, "1e1ea1", new byte[]{111})) + r61;
            goto L196
        L190:
            if (r115 != 2) goto L194;
            r61 = (String) p2.a(16777217, 0, 0, "644ba8", new byte[]{122, 107});
        L196:
            s.a(r58.a).b(new String(q.b(r59)), true);
            goto L120
        L197:
            return r42;
        }
    }

    public l2() {
    }

    public final void finalize() {
        RetrofitUtils.removeInterceptor(this.a);
        super.finalize();
    }

    @Override // ms.bd.c.f2
    public final void a(long r1) {
        this.b = r1;
        a r2 = new a(this);
        this.a = r2;
        RetrofitUtils.addInterceptor(r2);
    }
}

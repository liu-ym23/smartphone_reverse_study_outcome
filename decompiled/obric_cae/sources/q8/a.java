package q8;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.k;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.bytedance.security.keymanager.KeyManager;
import com.bytedance.security.keymanager.KeyManagerResult;
import com.bytedance.security.secretdata.AddResult;
import com.bytedance.security.secretdata.QueryResult;
import com.bytedance.security.secretdata.SecretData;
import com.bytedance.security.secretdata.SecretDataManager;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.obric.cae.userAware.datacollection.NetworkClient;
import defpackage.c;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import n4.b;
import we.a0;
import we.c0;
import we.q;
import we.t;
import we.v;
import we.x;
import we.y;
import we.z;
import yd.l;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f10197a;

    public a() {
    }

    public static String a(Context r8) {
        if (r8 == null) goto L66;
        m8.a r10 = l6.a.f9154w;
        if (r10 == null) goto L7;
        String r11 = r10.onGetDeviceId();
    L8:
        if (r11 != null) goto L11;
        r11 = "";
    L11:
        if (r11.isEmpty() == false) goto L16;
        String r12 = "a";
        String r13 = "deviceId is empty!";
    L13:
        Log.e(r12, r13);
        return null;
    L16:
        if (d(r8, r11) == false) goto L23;
        String r14 = f(r8, r11);
        if (r14 != null) goto L20;
    L21:
        Log.e("a", "RPDID is already stored, but query failed!");
    L22:
        return r14;
    L20:
        if (r14.isEmpty() == false) goto L22;
    L23:
        String r15 = "ocean_location".intern();
        monitor-enter(r15);
    L63:
        th = move-exception;
        throw th;
    L26:
        if (d(r8, r11) == false) goto L34;
        String r16 = f(r8, r11);     // Catch: Throwable -> L63
        if (r16 != null) goto L30;
    L31:
        Log.e("a", "RPDID is already stored, but query failed!");     // Catch: Throwable -> L63
    L32:
        monitor-exit(r15);     // Catch: Throwable -> L63
        return r16;
    L30:
        if (r16.isEmpty() == false) goto L32;
    L34:
        Log.i("a", "need to get pseudoID from cloud");     // Catch: Throwable -> L63
        m8.a r17 = l6.a.f9154w;     // Catch: Throwable -> L63
        if (r17 == null) goto L37;
        boolean r18 = r17.onIsAccountLogin();     // Catch: Throwable -> L63
    L38:
        if (r18 == true) goto L40;
        Log.i("a", "Account is not login!!");     // Catch: Throwable -> L63
        String r19 = "";
    L51:
        int r20 = b(r8, r11, r19);     // Catch: Throwable -> L63
        if (r20 == 0) goto L56;
        Log.e("a", "get pseudoID from cloud failed, error: " + r20);     // Catch: Throwable -> L63
        monitor-exit(r15);     // Catch: Throwable -> L63
        return null;
    L56:
        String r21 = f(r8, r11);     // Catch: Throwable -> L63
        if (r21 != null) goto L59;
    L60:
        Log.e("a", "RPDID store success, but query failed!");     // Catch: Throwable -> L63
    L61:
        monitor-exit(r15);     // Catch: Throwable -> L63
        return r21;
    L59:
        if (r21.isEmpty() == false) goto L61;
    L40:
        Log.i("a", "Account is login!!");     // Catch: Throwable -> L63
        m8.a r22 = l6.a.f9154w;     // Catch: Throwable -> L63
        if (r22 == null) goto L43;
        r19 = r22.onGetUserId();     // Catch: Throwable -> L63
    L44:
        if (r19 != null) goto L47;
        r19 = "";
    L47:
        if (r19.isEmpty() == false) goto L51;
        Log.e("a", "Account is login, but userId is empty!");     // Catch: Throwable -> L63
        monitor-exit(r15);     // Catch: Throwable -> L63
        return null;
    L43:
        r19 = null;
        goto L44
    L37:
        r18 = false;
        goto L38
    L7:
        r11 = null;
        goto L8
    L66:
        r12 = "a";
        r13 = "Context or appId is null!!";
        goto L13
    }

    public static int b(Context r17, String r18, String r19) {
        if (r17 != null) goto L5;
        String r8 = "a";
        String r10 = "context or appID is null!!";
    L179:
        Log.e(r8, r10);
        return -2;
    L5:
        if (r18.isEmpty() == false) goto L7;
        r8 = "a";
        r10 = "deviceId cannot be empty!!";
        goto L179
    L7:
        r17.getPackageName();
        if (r19.isEmpty() == false) goto L10;
    L10:
        b r11 = new b();
        r11.f9430a = HttpMethodContrants.POST;
        v r12 = s8.a.f12048a;
        m8.b r13 = p8.b.a().f9950a;
        if (r13 == null) goto L13;
        boolean r14 = r13.onIsBoeEnv();
    L14:
        if (r14 == false) goto L16;
        String r15 = "https://ocean-secret-boe.bytedance.net/api/identity/pseudonymize";
    L17:
        r11.f9431b = r15;
        Bundle r16 = new Bundle();
        r16.putInt("key_algorithm", 2);
        r16.putInt("key_length", 256);
        r16.putInt("key_purpose", 64);
        o8.a.d().getClass();
        String r20 = p8.a.c();
        if (TextUtils.isEmpty(r20) == false) goto L20;
        Log.e("a", "Request challenge failed!!");
        List r21 = new ArrayList();
    L27:
        int r22 = -100;
        if (r21.isEmpty() == false) goto L182;
        String r23 = "a";
        String r24 = "Get attest cert chain failed!!";
    L171:
        Log.e(r23, r24);
    L176:
        o8.a.d().getClass();
        o8.a.a(r17, "ocean_location");
        Log.i("a", "requestPseudoID end, result:" + r22);
        return r22;
    L182:
        r11.f9432c = t8.a.a(r21);     // Catch: Exception -> L174
        if (s8.a.f12049b == null) goto L34;
    L43:
        s8.a.f12049b.getClass();
        z r25 = z.create(t.b(NetworkClient.UPLOAD_FILE_TYPE_JSON), "{}");
        Map<String, String> r110 = l.f14120a;
        m8.a r111 = l6.a.f9154w;
        if (r111 == null) goto L46;
        Map<String, String> r112 = r111.onGetXttTokenMap();
    L47:
        if (r112 == null) goto L50;
        r110 = r112;
    L50:
        Iterator<Map.Entry<String, String>> r113 = r110.entrySet().iterator();
    L52:
        if (r113.hasNext() == false) goto L54;
        Map.Entry<String, String> r114 = r113.next();
        String r115 = r114.getKey();
        String r116 = r114.getValue();
        goto L52
    L54:
        String[] r117 = new String[r110.size() * 2];
        Iterator<Map.Entry<String, String>> r118 = r110.entrySet().iterator();
        int r119 = 0;
    L56:
        if (r118.hasNext() == false) goto L64;
        Map.Entry<String, String> r120 = r118.next();
        if (r120.getKey() == null) goto L63;
        if (r120.getValue() == null) goto L63;
        String r121 = r120.getKey().trim();
        String r122 = r120.getValue().trim();
        q.b(r121);
        q.c(r122, r121);
        r117[r119] = r121;
        r117[r119 + 1] = r122;
        r119 = r119 + 2;
    L63:
        throw new IllegalArgumentException("Headers cannot be null");
    L64:
        q r26 = new q(r117);
        y.a r123 = new y.a();
        r123.e((String) r11.f9431b);
        r123.c(r25, (String) r11.f9430a);
        q.a r27 = r26.g();
        r123.f13347d = r27;
        r27.a("Content-Type", NetworkClient.UPLOAD_FILE_TYPE_JSON);
        r123.f13347d.a("x-att-certchain", (String) r11.f9432c);
        y r28 = r123.a();
        r28.toString();
        Objects.toString(r28.f13341e);
        int r124 = 1;
        e6.a r29 = new e6.a(400, "", null);
    L66:
        if (r124 > 3) goto L115;
        v r30 = s8.a.f12048a;     // Catch: Exception -> L97 IOException -> L100 ConnectException -> L103 SocketTimeoutException -> L106
        r30.getClass();     // Catch: Exception -> L97 IOException -> L100 ConnectException -> L103 SocketTimeoutException -> L106
        a0 r125 = x.f(r30, r28, false).d();     // Catch: Exception -> L97 IOException -> L100 ConnectException -> L103 SocketTimeoutException -> L106
        c0 r31 = r125.f13120q;     // Catch: Throwable -> L89
        int r126 = r125.f13116m;
        if (r31 == null) goto L72;
        String r32 = r31.n();     // Catch: Throwable -> L89
    L74:
        if (r125.r() == true) goto L75;
        Log.e("a", "PseudoID Attempt " + r124 + ": Response failed, code = " + r126);     // Catch: Throwable -> L89
        StringBuilder r127 = new StringBuilder();     // Catch: Throwable -> L89
        r127.append("PseudoID Response body:");     // Catch: Throwable -> L89
        r127.append(r32);     // Catch: Throwable -> L89
        Log.e("a", r127.toString());     // Catch: Throwable -> L89
        e6.a r128 = new e6.a(r126, r125.f13117n, null);     // Catch: Throwable -> L89
        r125.close();     // Catch: Exception -> L81 IOException -> L83 ConnectException -> L85 SocketTimeoutException -> L87
    L110:
        r29 = r128;
        if (r124 >= 3) goto L114;
        Thread.sleep(500);     // Catch: InterruptedException -> L181
    L114:
        r124 = r124 + 1;
        goto L66
    L85:
        e = e;
    L105:
        StringBuilder r33 = defpackage.b.f("Challenge Attempt ", r124, ": ConnectException (connect timeout): ");
        String r34 = e.getMessage();
    L109:
        r33.append(r34);
        Log.e("a", r33.toString());
    L87:
        e = e;
    L108:
        r33 = defpackage.b.f("Challenge Attempt ", r124, ": SocketTimeoutException (read/write timeout): ");
        r34 = e.getMessage();
    L83:
        e = e;
    L102:
        r33 = defpackage.b.f("Challenge Attempt ", r124, ": IOException: ");
        r34 = e.getMessage();
    L81:
        e = e;
    L99:
        r33 = defpackage.b.f("Challenge Attempt ", r124, ": Unexpected exception: ");
        r34 = e.getMessage();
        goto L109
    L75:
        r29 = s8.a.a(r32);     // Catch: Throwable -> L89
        r125.close();     // Catch: Exception -> L97 IOException -> L100 ConnectException -> L103 SocketTimeoutException -> L106
        goto L115
    L72:
        r32 = "";
    L89:
        th = move-exception;
        r125.close();     // Catch: Throwable -> L93
        throw th;     // Catch: Exception -> L97 IOException -> L100 ConnectException -> L103 SocketTimeoutException -> L106
    L93:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L97 IOException -> L100 ConnectException -> L103 SocketTimeoutException -> L106
        throw th;     // Catch: Exception -> L97 IOException -> L100 ConnectException -> L103 SocketTimeoutException -> L106
    L103:
        e = e;
        r128 = r29;
    L106:
        e = e;
        r128 = r29;
    L100:
        e = e;
        r128 = r29;
    L97:
        e = e;
        r128 = r29;
    L115:
        int r35 = r29.f7124a;
        if (r35 >= 200) goto L118;
    L173:
        Log.e("a", "Network request failed, error code:" + r29.f7124a);
        r22 = -21;
        goto L176
    L118:
        if (r35 >= 300) goto L173;
        if (((k) r29.f7126c) != null) goto L123;
        Log.e("a", "Network response pseudoID is null!");
        r22 = -8;
        goto L176
    L123:
        Object r36 = ((k) r29.f7126c).f1200a;
        Object r37 = ((k) r29.f7126c).f1201b;
        if (r18.isEmpty() == false) goto L126;
        int r38 = 0;
        int r39 = 0;
    L156:
        if (r19.isEmpty() == false) goto L158;
    L172:
        r22 = r38;
        goto L176
    L158:
        if (((String) ((k) r29.f7126c).f1201b).isEmpty() == false) goto L161;
        r23 = "a";
        r24 = "Network response RPUID is empty!!";
    L160:
        r22 = -22;
        goto L171
    L161:
        String r40 = (String) ((k) r29.f7126c).f1201b;
        if (e(r17, r19) == true) goto L168;
        SecretData r41 = new SecretData();
        r41.privateData = r40;
        r41.associate = "ocean_location";
        r41.alias = c.l0(c.u(r19, "_rpuid"));
        r41.dataType = "RPUID";
        AddResult r42 = SecretDataManager.getInstance().addData(r17, r41, new Bundle());
        if (r42 != null) goto L166;
    L167:
        Log.e("a", "Store RPUID failed!! result: " + r42.getResultCode());
        r22 = r42.getResultCode();
    L169:
        if (r22 == 0) goto L176;
        r23 = "a";
        r24 = defpackage.a.d("storePseudoUID failed!, result:", r22);
        goto L171
    L166:
        if (r42.getResultCode() != 0) goto L167;
    L168:
        r22 = r39;
        goto L169
    L126:
        if (((String) ((k) r29.f7126c).f1200a).isEmpty() == false) goto L128;
        r23 = "a";
        r24 = "Network response RPDID is empty!!";
        goto L160
    L128:
        String r43 = (String) ((k) r29.f7126c).f1200a;
        if (d(r17, r18) == true) goto L136;
        SecretData r44 = new SecretData();
        r44.privateData = r43;
        r44.associate = "ocean_location";
        r44.alias = c.l0(c.u(r18, "_rpdid"));
        r44.dataType = "RPDID";
        AddResult r45 = SecretDataManager.getInstance().addData(r17, r44, new Bundle());
        if (r45 != null) goto L134;
        int r46 = 0;
    L147:
        Log.e("a", "addResult is null, SecretDataManager service failed!!");
        r39 = r46;
        r38 = -14;
    L152:
        if (r38 == 0) goto L156;
        Log.e("a", "storePseudoDID failed!, result:" + r38);
        goto L172
    L134:
        if (r45.getResultCode() == 0) goto L136;
        Log.e("a", "Store RPDID failed!! result: " + r45.getResultCode());
        r38 = r45.getResultCode();
        r39 = 0;
    L136:
        Bundle r47 = new Bundle();
        r47.putInt("query_mode", 0);
        QueryResult r48 = SecretDataManager.getInstance().queryData(r17, c.l0(c.u(r43, "_did")), r47);
        if (r48 != null) goto L139;
    L142:
        boolean r49 = false;
    L143:
        if (r49 == true) goto L151;
        SecretData r50 = new SecretData();
        r50.privateData = r18;
        r50.associate = "ocean_location";
        r50.alias = c.l0(c.u(r43, "_did"));
        r50.dataType = "DID";
        AddResult r51 = SecretDataManager.getInstance().addData(r17, r50, new Bundle());
        if (r51 != null) goto L149;
        r46 = 0;
        goto L147
    L149:
        if (r51.getResultCode() == 0) goto L151;
        Log.e("a", "Store deviceID failed!! result: " + r51.getResultCode());
        r38 = r51.getResultCode();
        r39 = 0;
    L151:
        r38 = 0;
        r39 = 0;
        goto L152
    L139:
        if (r48.getResultCode() != 0) goto L142;
        r49 = true;
        goto L143
    L46:
        r112 = null;
        goto L47
    L34:
        monitor-enter(a.class);
    L40:
        th = move-exception;
        throw th;
    L36:
        if (s8.a.f12049b != null) goto L38;
        s8.a.f12049b = new s8.a();     // Catch: Throwable -> L40
    L38:
        monitor-exit(a.class);     // Catch: Throwable -> L40
    L174:
        e = move-exception;
        Log.e("a", "Set certificate chain failed!! error:" + e.getMessage());
        goto L176
    L20:
        int r52 = o8.a.b(r17, "ocean_location", r16);
        if (r52 == 0) goto L23;
        Log.e("a", "Generate attestation key pair failed! ret:" + r52);
        r21 = new ArrayList();
        goto L27
    L23:
        String r53 = r20 + BdimCategoryConstants.SEPARATOR_COLON + r18 + ":ocean_location";
        Bundle r54 = new Bundle();
        r54.putString("challenge", r53);
        KeyManagerResult r55 = KeyManager.getInstance().keyAttestation(r17, "ocean_location", r54);
        if (r55.getResultCode() == 0) goto L26;
        Log.e("a", "Attest key failed! ret:" + r55.getResultCode());
        r21 = new ArrayList();
        goto L27
    L26:
        r21 = r55.getCertChain();
        r21.size();
        goto L27
    L16:
        r15 = "https://ocean-secret.oceancloudapi.com/api/identity/pseudonymize";
        goto L17
    L13:
        r14 = false;
        goto L14
    }

    public static String c(Context r8) {
        if (r8 == null) goto L64;
        m8.a r10 = l6.a.f9154w;
        if (r10 == null) goto L7;
        boolean r11 = r10.onIsAccountLogin();
    L8:
        if (r11 == true) goto L12;
        String r12 = "a";
        String r13 = "Account is not login, no userId!!";
    L10:
        Log.e(r12, r13);
        return null;
    L12:
        m8.a r14 = l6.a.f9154w;
        if (r14 == null) goto L15;
        String r15 = r14.onGetUserId();
    L16:
        if (r15 != null) goto L19;
        r15 = "";
    L19:
        if (r15.isEmpty() == false) goto L22;
        r12 = "a";
        r13 = "Account is login, but userId is empty!";
        goto L10
    L22:
        if (e(r8, r15) == false) goto L29;
        String r16 = g(r8, r15);
        if (r16 != null) goto L26;
    L27:
        Log.e("a", "RPUID is already stored, but query failed!");
    L28:
        return r16;
    L26:
        if (r16.isEmpty() == false) goto L28;
    L29:
        Log.i("a", "need to get pseudoID from cloud");
        m8.a r17 = l6.a.f9154w;
        if (r17 == null) goto L32;
        String r18 = r17.onGetDeviceId();
    L33:
        if (r18 != null) goto L36;
        r18 = "";
    L36:
        if (r18.isEmpty() == false) goto L38;
        r12 = "a";
        r13 = "getPseudoUID, DID is empty!";
        goto L10
    L38:
        String r19 = "ocean_location".intern();
        monitor-enter(r19);
    L61:
        th = move-exception;
        throw th;
    L41:
        if (e(r8, r15) == false) goto L49;
        String r20 = g(r8, r15);     // Catch: Throwable -> L61
        if (r20 != null) goto L45;
    L46:
        Log.e("a", "RPUID is already stored, but query failed!");     // Catch: Throwable -> L61
    L47:
        monitor-exit(r19);     // Catch: Throwable -> L61
        return r20;
    L45:
        if (r20.isEmpty() == false) goto L47;
    L49:
        int r21 = b(r8, r18, r15);     // Catch: Throwable -> L61
        if (r21 == 0) goto L54;
        Log.e("a", "get pseudoID from cloud failed, error: " + r21);     // Catch: Throwable -> L61
        monitor-exit(r19);     // Catch: Throwable -> L61
        return null;
    L54:
        String r22 = g(r8, r15);     // Catch: Throwable -> L61
        if (r22 != null) goto L57;
    L58:
        Log.e("a", "RPUID store success, but query failed!");     // Catch: Throwable -> L61
    L59:
        monitor-exit(r19);     // Catch: Throwable -> L61
        return r22;
    L57:
        if (r22.isEmpty() == false) goto L59;
    L32:
        r18 = null;
        goto L33
    L15:
        r15 = null;
        goto L16
    L7:
        r11 = false;
        goto L8
    L64:
        r12 = "a";
        r13 = "Context or app Id is null!!";
        goto L10
    }

    public static boolean d(Context r8, String r10) {
        Bundle r11 = new Bundle();
        r11.putInt("query_mode", 0);
        QueryResult r12 = SecretDataManager.getInstance().queryData(r8, c.l0(c.u(r10, "_rpdid")), r11);
        if (r12 != null) goto L5;
    L9:
        return false;
    L5:
        if (r12.getResultCode() != 0) goto L9;
        return true;
    }

    public static boolean e(Context r8, String r10) {
        Bundle r11 = new Bundle();
        r11.putInt("query_mode", 0);
        QueryResult r12 = SecretDataManager.getInstance().queryData(r8, c.l0(c.u(r10, "_rpuid")), r11);
        if (r12 != null) goto L5;
    L9:
        return false;
    L5:
        if (r12.getResultCode() != 0) goto L9;
        return true;
    }

    public static String f(Context r8, String r10) {
        Bundle r11 = new Bundle();
        r11.putInt("query_mode", 2);
        QueryResult r12 = SecretDataManager.getInstance().queryData(r8, c.l0(c.u(r10, "_rpdid")), r11);
        if (r12 != null) goto L5;
    L17:
        String r13 = "Query RPDID failed!!";
    L15:
        Log.e("a", r13);
        return null;
    L5:
        if (r12.getResultCode() != 0) goto L17;
        SecretData r14 = (SecretData) r12.getDataList().get(0);
        String r15 = r14.privateData;
        if (r15 != null) goto L10;
    L14:
        r13 = "Query success, but RPDID is null!!";
        goto L15
    L10:
        if (r15.isEmpty() == true) goto L14;
        return r14.privateData;
    }

    public static String g(Context r8, String r10) {
        Bundle r11 = new Bundle();
        r11.putInt("query_mode", 2);
        QueryResult r12 = SecretDataManager.getInstance().queryData(r8, c.l0(c.u(r10, "_rpuid")), r11);
        if (r12 != null) goto L5;
    L17:
        String r13 = "Query RPUID failed!!";
    L15:
        Log.e("a", r13);
        return null;
    L5:
        if (r12.getResultCode() != 0) goto L17;
        SecretData r14 = (SecretData) r12.getDataList().get(0);
        String r15 = r14.privateData;
        if (r15 != null) goto L10;
    L14:
        r13 = "Query success, but RPUID is null!!";
        goto L15
    L10:
        if (r15.isEmpty() == true) goto L14;
        return r14.privateData;
    }
}

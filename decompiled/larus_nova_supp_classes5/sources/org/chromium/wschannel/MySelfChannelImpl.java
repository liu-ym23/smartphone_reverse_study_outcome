package org.chromium.wschannel;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import com.ttnet.org.chromium.net.impl.CronetFrontierClient;
import com.ttnet.org.chromium.net.impl.CronetFrontierClient$TransportMode;
import com.ttnet.org.chromium.net.impl.TTServiceInfo;
import com.ttnet.org.chromium.net.impl.UserAgent;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import ovc.a;
import ovc.b;
import ovc.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class MySelfChannelImpl implements IWsChannelClient, WeakHandler.IHandler {
    private static final String TAG = "MySelfChannelImpl";
    private static String WSCHANNEL_ACTION_BACK;
    private static String WSCHANNEL_ACTION_FORE;
    private static String sPackageName;
    private static volatile String sUserAgent;
    private Context mContext;
    private a mFrontierConnection;
    private IWsChannelClient mWsChannelClient;

    public MySelfChannelImpl() {
    }

    public void onNetworkStateChanged(int r1) {
    }

    public void destroy() {
        a r0 = this.mFrontierConnection;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    public boolean isConnected() {
        a r0 = this.mFrontierConnection;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.b.get() == false) goto L10;
        CronetFrontierClient r2 = r0.h;
        if (r2 == null) goto L10;
        return r2.isConnected();
    L10:
        if (r0.b.get() == true) goto L17;
        TTWebsocketConnection r1 = r0.l;
        if (r1 != null) goto L14;
        return false;
    L14:
        return r1.isConnected();
    L17:
        return false;
    }

    public boolean privateProtocolEnabled() {
        a r0 = this.mFrontierConnection;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.b.get();
    }

    public boolean privateProtocolProxyEnabled() {
        a r0 = this.mFrontierConnection;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.c.get();
    }

    public void stopConnection() {
        a r0 = this.mFrontierConnection;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    public static String getDefaultUserAgent() {
        return sUserAgent;
    }

    public void handleMsg(Message r3) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "handleMsg data:" + r3.toString());
        return;
    }

    public void onAppStateChanged(int r3) {
        Intent r0 = new Intent();
        if (r3 != 1) goto L9;
        r0.setAction(WSCHANNEL_ACTION_FORE);
        if (TextUtils.isEmpty(sPackageName) == true) goto L7;
        r0.setPackage(sPackageName);
    L7:
        this.mContext.sendBroadcast(r0);
        return;
    L9:
        if (r3 != 2) goto L16;
        r0.setAction(WSCHANNEL_ACTION_BACK);
        if (TextUtils.isEmpty(sPackageName) == true) goto L13;
        r0.setPackage(sPackageName);
    L13:
        this.mContext.sendBroadcast(r0);
        return;
    }

    public void onConnection(JSONObject r3) {
        if (this.mWsChannelClient == null) goto L12;
        r3.put("channel_type", 1);     // Catch: JSONException -> L6
    L8:
        this.mWsChannelClient.onConnection(r3);
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public void onMessage(WsChannelMsg r2) {
        IWsChannelClient r0 = this.mWsChannelClient;
        if (r0 == null) goto L6;
        r0.onMessage(r2);
        return;
    }

    public void registerService(int r1) {
        a r2 = this.mFrontierConnection;
        if (r2 == null) goto L6;
        r2.getClass();
        return;
    }

    public boolean sendMessage(WsChannelMsg r10) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "PP data:" + r10.toString());
    L5:
        a r0 = this.mFrontierConnection;
        boolean r1 = false;
        if (r0 != null) goto L8;
        return false;
    L8:
        r0.getClass();
        if (Logger.debug() == false) goto L12;
        Logger.d("CronetFrontierConnection", "PP sendMessage data:" + r10.toString());
    L12:
        if (r0.h == null) goto L62;
        if (r10 == null) goto L77;
        int r2 = r10.getService();
        if (r2 == 9000) goto L18;
    L41:
        ArrayList r4 = new ArrayList();
        r4.add("method_id");
        r4.add(String.valueOf(r10.getMethod()));
        if (TextUtils.isEmpty(r10.getPayloadType()) == true) goto L45;
        r4.add("payload_type");
        r4.add(r10.getPayloadType());
    L45:
        if (TextUtils.isEmpty(r10.getPayloadEncoding()) == true) goto L48;
        r4.add("payload_encoding");
        r4.add(r10.getPayloadEncoding());
    L48:
        if (r10.getMsgHeaders() != null) goto L50;
        String[] r3 = (String[]) r4.toArray(new String[0]);
    L59:
        ByteBuffer r5 = ByteBuffer.allocateDirect(r10.getPayload().length);
        r5.put(r10.getPayload());
        r0.h.sendMessage(r2, r3, r5);
        if (Logger.debug() == true) goto L61;
    L40:
        return true;
    L61:
        Logger.d("CronetFrontierConnection", "PP sendMessage serviceId:" + r2);
        goto L40
    L50:
        Iterator r6 = r10.getMsgHeaders().iterator();
    L52:
        if (r6.hasNext() == false) goto L58;
        WsChannelMsg.MsgHeader r7 = (WsChannelMsg.MsgHeader) r6.next();
        if (TextUtils.isEmpty(r7.getKey()) == true) goto L52;
        if (TextUtils.isEmpty(r7.getValue()) == true) goto L52;
        r4.add(r7.getKey());
        r4.add(r7.getValue());
        goto L52
    L58:
        r3 = (String[]) r4.toArray(new String[0]);
        goto L59
    L18:
        if (r10.getMethod() != 4) goto L41;
        Iterator r11 = r10.getMsgHeaders().iterator();
    L21:
        if (r11.hasNext() == false) goto L40;
        WsChannelMsg.MsgHeader r8 = (WsChannelMsg.MsgHeader) r11.next();
        if (r8 == null) goto L21;
        if ("IsBackground".equals(r8.getKey()) == false) goto L21;
        String r12 = r8.getValue();
        if (r12.equals("1") == false) goto L30;
        r0.j = 1;
    L33:
        if (r0.k == false) goto L40;
        if (r0.j == (-1)) goto L40;
        CronetFrontierClient r13 = r0.h;
        if (r0.j != 1) goto L39;
        r1 = true;
    L39:
        r13.reportAppStateChange(r1);
        goto L40
    L30:
        if (r12.equals("0") == false) goto L33;
        r0.j = 0;
        goto L33
    L77:
        return false;
    L62:
        return false;
    }

    public void unregisterService(int r1) {
        a r2 = this.mFrontierConnection;
        if (r2 == null) goto L6;
        r2.getClass();
        return;
    }

    public void onMessage(byte[] r2) {
        IWsChannelClient r0 = this.mWsChannelClient;
        if (r0 == null) goto L6;
        r0.onMessage(r2);
        return;
    }

    public boolean sendMessage(byte[] r7) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "WS sendMessage data:" + r7.toString());
    L5:
        a r0 = this.mFrontierConnection;
        if (r0 != null) goto L9;
        return false;
    L9:
        if (r0.b.get() == true) goto L11;
    L26:
        a r1 = this.mFrontierConnection;
        r1.getClass();
        if (Logger.debug() == false) goto L30;
        Logger.d("CronetFrontierConnection", "WS sendMessage data:" + r7);
    L30:
        if (r1.l == null) goto L36;
        ByteBuffer r2 = ByteBuffer.allocateDirect(r7.length);
        r2.put(r7);
        r1.l.asyncSendBinary(r2);
        return true;
    L36:
        return false;
    L11:
        if (this.mFrontierConnection.c.get() == false) goto L26;
        a r3 = this.mFrontierConnection;
        r3.getClass();
        if (Logger.debug() == false) goto L15;
        Logger.d("CronetFrontierConnection", "PP proxy sendMessage data:" + r7.toString());
    L15:
        CronetFrontierClient r4 = r3.h;
        if (r4 == null) goto L34;
        if (r7 != null) goto L20;
        return false;
    L20:
        if (r4.isServiceExisted(1) == false) goto L22;
    L24:
        ByteBuffer r5 = ByteBuffer.allocateDirect(r7.length);
        r5.put(r7);
        r3.h.sendMessage(1, null, r5);
        return true;
    L22:
        if (r3.h == null) goto L24;
        r3.h.registerService(new TTServiceInfo(1, new a.b(r3)), null, null);
        goto L24
    L34:
        return false;
    }

    public void init(Context r3, IWsChannelClient r4) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "MySelfChannelImpl init");
    L5:
        this.mContext = r3;
        sPackageName = r3.getPackageName();
        this.mWsChannelClient = r4;
        this.mFrontierConnection = new a(this);
        if (TextUtils.isEmpty(sUserAgent) == true) goto L11;
    L8:
        WSCHANNEL_ACTION_BACK = this.mContext.getPackageName() + ".wschannel.APP_BACKGROUND";
        WSCHANNEL_ACTION_FORE = this.mContext.getPackageName() + ".wschannel.APP_FOREGROUND";
        return;
    L11:
        sUserAgent = UserAgent.from(r3);     // Catch: Throwable -> L10
        goto L8
    }

    public void onParameterChange(Map<String, Object> r2, List<String> r3) {
        a r0 = this.mFrontierConnection;
        if (r0 == null) goto L5;
        r0.d();
    L5:
        openConnection(r2, r3);
    }

    public void openConnection(Map<String, Object> r27, List<String> r28) {
        a r9 = this.mFrontierConnection;
        if (r9 == null) goto L229;
        if (r28 == null) goto L228;
        if (r28.size() <= 0) goto L228;
        if (Logger.debug() == false) goto L10;
        Logger.d("CronetFrontierConnection", "openConnection url:" + ((String) ListProtector.get(r28, 0)));
    L10:
        if (r27 == null) goto L226;
        if (r27.isEmpty() == true) goto L226;
        r9.d();
        if (NetworkParams.isPrivateProtocolEnabled() == false) goto L22;
        if (r9.d.get() >= 3) goto L22;
        Object r1 = r27.get("private_protocol_enable");
        if (r1 == null) goto L24;
        boolean r2 = ((Boolean) r1).booleanValue();
    L26:
        if (r2 == true) goto L28;
        r9.n = new b(r27, true);
        r9.g(r27, r28);
        return;
    L28:
        String r3 = (String) r27.get("private_protocol_url");
        if (TextUtils.isEmpty(r3) == false) goto L32;
    L30:
        URI r4 = null;
    L31:
        URI r15 = r4;
        if (r15 != null) goto L43;
        r9.n = new b(r27, true);
        r9.g(r27, r28);
        return;
    L43:
        r9.n = new b(r27, false);
        Object r5 = r27.get("disable_fallback_websocket");
        if (r5 == null) goto L46;
        boolean r6 = ((Boolean) r5).booleanValue();
    L48:
        if (Logger.debug() == false) goto L51;
        Logger.d("CronetFrontierConnection", "DisableFallbackTask:false DisableFallbackWS:" + r6);
    L51:
        if (r6 == true) goto L94;
        b r7 = r9.n;
        if (b.e == true) goto L55;
        r7.getClass();
        boolean r8 = true;
    L56:
        if (r8 == false) goto L94;
        Map r10 = (Map) r27.get("custom_headers");
        if (r10 != null) goto L60;
    L71:
        long r11 = 10000;
    L72:
        long r12 = r11;
        if (Logger.debug() == false) goto L75;
        Logger.d("CronetFrontierConnection", "Fallback to websocket timeout:" + r12);
    L75:
        a.a r13 = new a.a(r9, r12, r27, r28);
        if (com.bytedance.frameworks.baselib.network.http.util.a.d == null) goto L78;
    L87:
        com.bytedance.frameworks.baselib.network.http.util.a r0 = com.bytedance.frameworks.baselib.network.http.util.a.d;
        r0.getClass();
        com.bytedance.frameworks.baselib.network.http.util.a.a r14 = new com.bytedance.frameworks.baselib.network.http.util.a.a(r0, r13);     // Catch: Throwable -> L90
        ScheduledFuture r16 = r0.a.schedule(r14, r12, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L90
        r0.c.put(r13, r14);     // Catch: Throwable -> L90
        r0.b.put(r13, r16);     // Catch: Throwable -> L90
    L92:
        r9.i.set(true);
    L90:
        th = move-exception;
        Logger.e(com.bytedance.frameworks.baselib.network.http.util.a.e, "sendTask failed.", th);
        goto L92
    L78:
        monitor-enter(com.bytedance.frameworks.baselib.network.http.util.a.class);
    L84:
        th = move-exception;
        throw th;
    L80:
        if (com.bytedance.frameworks.baselib.network.http.util.a.d != null) goto L82;
        com.bytedance.frameworks.baselib.network.http.util.a.d = new com.bytedance.frameworks.baselib.network.http.util.a();     // Catch: Throwable -> L84
    L82:
        monitor-exit(com.bytedance.frameworks.baselib.network.http.util.a.class);     // Catch: Throwable -> L84
        goto L87
    L60:
        if (r10.isEmpty() == true) goto L71;
        if (r10.containsKey("fallback_timeout_mills") == false) goto L71;
        String r17 = (String) r10.get("fallback_timeout_mills");
        if (TextUtils.isEmpty(r17) == true) goto L71;
        int r18 = CastIntegerProtector.valueOf(r17).intValue();     // Catch: Exception -> L232
        if (r18 <= 0) goto L71;
        r11 = r18;
        goto L72
    L55:
        r8 = r7.c;
    L94:
        r9.b.set(true);
        int r19 = r15.getPort();
        String r20 = r15.getPath();
        String r21 = r15.getQuery();
        if (r19 > 0) goto L97;
        int r22 = 443;
    L99:
        if (Logger.debug() == false) goto L101;
        Logger.d("CronetFrontierConnection", "PP connection host:" + r15.getHost() + ":" + r22 + r20 + "?" + r21);
    L101:
        int r23 = ((Integer) r27.get("transport_mode")).intValue();
        if (r23 == 3) goto L104;
        if (r23 == 4) goto L104;
    L106:
        if (r23 == 1) goto L110;
        if (r23 == 2) goto L110;
        if (r23 == 4) goto L110;
        CronetFrontierClient$TransportMode r24 = CronetFrontierClient$TransportMode.QUIC;
    L111:
        CronetFrontierClient$TransportMode r25 = r24;
        ArrayList r26 = new ArrayList();
        if (r9.c.get() == false) goto L114;
        r26.add(1);
    L127:
        HashMap r29 = new HashMap();
        String r110 = (String) r27.get(DBDefinition.EXTRA);
        if (TextUtils.isEmpty(r110) == true) goto L237;
        String[] r30 = r110.split("&");
        int r111 = r30.length;
        int r112 = 0;
    L131:
        if (r112 >= r111) goto L237;
        String r31 = r30[r112];
        String[] r210 = r30;
        if (TextUtils.isEmpty(r31) == false) goto L135;
        int r113 = r111;
    L152:
        r112 = r112 + 1;
        r30 = r210;
        r111 = r113;
        goto L131
    L135:
        String[] r32 = r31.split("=");
        r113 = r111;
        if (r32.length != 2) goto L152;
        if (TextUtils.isEmpty(r32[0]) == true) goto L152;
        if (TextUtils.isEmpty(r32[1]) == true) goto L152;
        if (r32[0].equals("ttnet_heartbeat_interval") == false) goto L146;
        r9.e = CastIntegerProtector.valueOf(r32[1]).intValue() * 1000;     // Catch: NumberFormatException -> L231
        goto L152
    L146:
        if (r32[0].equals("ttnet_timeout_millis") == false) goto L150;
        r9.f = CastIntegerProtector.valueOf(r32[1]).intValue();     // Catch: NumberFormatException -> L231
        goto L152
    L150:
        if (r9.c.get() == true) goto L152;
        r29.put(r32[0], r32[1]);
    L237:
        Map r33 = a.e();     // Catch: Throwable -> L174
        if (Logger.debug() == false) goto L156;
        Logger.d("CronetFrontierConnection", "PP client key: " + r33);     // Catch: Throwable -> L174
    L156:
        if (r33 != null) goto L158;
    L160:
        Map r34 = (Map) r27.get("custom_headers");     // Catch: Throwable -> L174
        if (r34 == null) goto L166;
        if (r34.isEmpty() == true) goto L166;
        r29.putAll(r34);     // Catch: Throwable -> L174
    L166:
        if (r9.c.get() == false) goto L176;
        String r35 = getDefaultUserAgent();     // Catch: Throwable -> L174
        if (TextUtils.isEmpty(r35) == true) goto L170;
        r29.put("user-agent", r35);     // Catch: Throwable -> L174
    L170:
        String r36 = a.f(r15);     // Catch: Throwable -> L174
        if (TextUtils.isEmpty(r36) == true) goto L176;
        r29.put("cookie", r36);     // Catch: Throwable -> L174
    L176:
        ((ConcurrentHashMap) r9.g).clear();
        b r37 = r9.n;
        if (r37 == null) goto L192;
        long r114 = 0;
        if (b.e == true) goto L181;
        long r38 = 0;
    L183:
        if (r38 <= 0) goto L193;
        b r39 = r9.n;
        if (b.e == true) goto L187;
        r39.getClass();
    L188:
        int r40 = (int) r114;
        if (Logger.debug() == false) goto L191;
        Logger.d("CronetFrontierConnection", "PP destroy timeout:" + r40);
    L191:
        r9.f = r40;
        goto L193
    L187:
        r114 = r39.b;
    L193:
        CronetFrontierClient.Builder r41 = CronetFrontierClient.Builder.create(((Integer) r27.get(EffectConfiguration.KEY_APP_ID)).intValue(), ((Integer) r27.get("fpid")).intValue(), r15.getHost(), r22, Integer.toString(((Integer) r27.get(EffectConfiguration.KEY_APP_VERSION)).intValue()), (String) r27.get(EffectConfiguration.KEY_DEVICE_ID), (String) r27.get("app_key")).pingInterval(r9.e).timeout(r9.f).transportMode(r25).headers(r29).callback(new c(r9.a, r9));
        if (r9.c.get() == false) goto L215;
        r41.proxy(true);
        Object r42 = r27.get("iid");
        StringBuilder r43 = new StringBuilder();
        if (TextUtils.isEmpty(r21) == true) goto L199;
        r43.append(r21);
    L199:
        if (TextUtils.isEmpty(r110) == false) goto L201;
    L243:
        long r44 = CastLongProtector.parseLong((String) r42);     // Catch: Exception -> L209
        if (r43.length() <= 0) goto L207;
        r43.append("&");     // Catch: Exception -> L209
    L207:
        r43.append("iid=" + r44);     // Catch: Exception -> L209
    L210:
        String r45 = r43.toString();
        if (Logger.debug() == false) goto L213;
        StringBuilder r46 = new StringBuilder("PP connection real query:");
        r46.append(r45);
        r46.append(" path:");
        String r47 = r20;
        r46.append(r47);
        Logger.d("CronetFrontierConnection", r46.toString());
    L214:
        r41.query(r45);
        r41.path(r47);
        goto L215
    L213:
        r47 = r20;
        goto L214
    L201:
        if (r43.length() <= 0) goto L203;
        r43.append("&");
    L203:
        r43.append(r110);
    L215:
        r41.uniqueServiceIdList(r26);
        r9.h = r41.build();
        if (Logger.debug() == false) goto L218;
        Logger.d("CronetFrontierConnection", "Register serviceIdList: " + r26 + " mode:" + r25);
    L218:
        Iterator r48 = r26.iterator();
    L220:
        if (r48.hasNext() == false) goto L265;
        Integer r49 = (Integer) r48.next();
        int r50 = r49.intValue();
        if (r9.h == null) goto L224;
        r9.h.registerService(new TTServiceInfo(r50, new a.b(r9)), null, null);
    L224:
        ((ConcurrentHashMap) r9.g).put(r49, Boolean.FALSE);
        goto L220
    L265:
        return;
    L181:
        r38 = r37.b;
        goto L183
    L192:
        r20 = r20;
        goto L193
    L158:
        if (r33.isEmpty() == true) goto L160;
        r29.putAll(r33);     // Catch: Throwable -> L174
    L174:
        th = move-exception;
        th.printStackTrace();
        goto L176
    L114:
        r26.add(9000);
        if (NetworkParams.isEnablePPForceUseSharedStream() == true) goto L127;
        ArrayList r51 = (ArrayList) r27.get("service_id_list");
        if (r51 == null) goto L127;
        if (r51.size() == 0) goto L127;
        Iterator r52 = r51.iterator();
    L123:
        if (r52.hasNext() == false) goto L127;
        int r53 = ((Integer) r52.next()).intValue();
        if (r26.contains(Integer.valueOf(r53)) == true) goto L123;
        r26.add(Integer.valueOf(r53));
    L110:
        r24 = CronetFrontierClient$TransportMode.TLS;
    L104:
        r9.c.set(true);
        goto L106
    L97:
        r22 = r19;
        goto L99
    L46:
        r6 = false;
        goto L48
    L32:
        a.p = r3;
        if (r3.startsWith("wss:") == false) goto L37;
        r3 = "https:" + r3.substring(4);     // Catch: Throwable -> L230
    L39:
        r4 = UrlUtils.safeCreateUri(r3);     // Catch: Throwable -> L230
    L37:
        if (r3.startsWith("ws:") == false) goto L39;
        r3 = "http:" + r3.substring(3);     // Catch: Throwable -> L230
    L24:
        r2 = false;
    L22:
        if (Logger.debug() == false) goto L24;
        Logger.d("CronetFrontierConnection", "Retry attempts:" + r9.d.get() + ",tnc enabled:" + NetworkParams.isPrivateProtocolEnabled());
    L226:
        throw new IllegalArgumentException("configMap is empty !!!");
    L228:
        throw new IllegalArgumentException("urls size <= 0 !!!");
    }

    public void onServiceConnectEvent(int r2, boolean r3, String r4) {
        IWsChannelClient r0 = this.mWsChannelClient;
        if (r0 == null) goto L6;
        r0.onServiceConnectEvent(r2, r3, r4);
        return;
    }
}

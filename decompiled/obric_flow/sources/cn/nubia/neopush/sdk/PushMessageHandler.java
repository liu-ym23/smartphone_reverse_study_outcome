package cn.nubia.neopush.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import cn.nubia.neopush.PushApplication;
import cn.nubia.neopush.SDKControllerMessageHandler;
import cn.nubia.neopush.commons.AppUtil;
import cn.nubia.neopush.commons.Constant;
import cn.nubia.neopush.commons.NeoLog;
import cn.nubia.neopush.service.aidl.IPushMessageHandler;
import com.lynx.jsbridge.LynxResourceModule;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PushMessageHandler extends Service {
    private static ConcurrentLinkedQueue<MessageHandleJob> mJobs;
    ServiceHandler handler;
    service_stub mbinder;
    ExecutorService singleTaskExecutorService;

    public static class MessageHandleJob {
        private Intent intent;
        private PushMessageReceiver receiver;

        public MessageHandleJob(PushMessageReceiver r5, Intent r10) {
            this.receiver = r5;
            this.intent = r10;
        }

        public PushMessageReceiver getHandleReceiver() {
            return this.receiver;
        }

        public Intent getIntent() {
            return this.intent;
        }
    }

    public static class ServiceHandler extends Handler {
        public final int STOP;
        WeakReference<PushMessageHandler> weakReference;

        public ServiceHandler(PushMessageHandler r5) {
            this.STOP = 1;
            this.weakReference = new WeakReference(r5);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r5) {
            super.handleMessage(r5);
            if (r5.what != 1) goto L8;
            PushMessageHandler r10 = this.weakReference.get();
            if (r10 == null) goto L9;
            NeoLog.i("luzhi", "MessageHandleService stop");
            r10.stopSelf();
            return;
        L9:
            return;
        }
    }

    public class service_stub extends IPushMessageHandler.Stub {
        final /* synthetic */ PushMessageHandler this$0;

        private service_stub(PushMessageHandler r5) {
            this.this$0 = r5;
        }

        @Override // cn.nubia.neopush.service.aidl.IPushMessageHandler
        public void getMessage(long r5, int r10, int r11, String r12, int r13, String r14, String r15) throws RemoteException {
            Intent r16 = new Intent(Constant.RECEIVE_MESSAGE_ACTION);
            Bundle r17 = new Bundle();
            r17.putLong("message_id", r5);
            r17.putInt(Constant.MESSAGE_TYPE, r10);
            r17.putInt(Constant.MESSAGE_SUB_TYPE, r11);
            r17.putString(Constant.PACKAGE_NAME, r12);
            r17.putInt("result_code", r13);
            r17.putString(Constant.TOPICS, r14);
            r17.putString("reason", r15);
            r16.putExtras(r17);
            NeoLog.i("PushMessageHandler getMessage onHandleIntent=" + this.this$0.getPackageName());     // Catch: Exception -> L10
            NeoLog.i("PushMessageHandler getMessage onHandleIntent reason=" + r15);     // Catch: Exception -> L10
            if (TextUtils.isEmpty(r15) == true) goto L13;
            if (r15.contains("&&new_sdk_version") == false) goto L13;
            if (r10 != 7) goto L13;
            return;
        L13:
            if (Constant.RECEIVE_MESSAGE_ACTION.equals(r16.getAction()) == false) goto L39;
            Intent r18 = new Intent(Constant.RECEIVE_MESSAGE_ACTION);     // Catch: Exception -> L10
            r18.setPackage(this.this$0.getPackageName());     // Catch: Exception -> L10
            r18.putExtras(r16);     // Catch: Exception -> L10
            List<ResolveInfo> r19 = this.this$0.getPackageManager().queryBroadcastReceivers(r18, 32);     // Catch: Exception -> L10
            if (r19 == null) goto L25;
            Iterator<ResolveInfo> r20 = r19.iterator();     // Catch: Exception -> L10
        L18:
            if (r20.hasNext() == false) goto L25;
            ResolveInfo r21 = r20.next();     // Catch: Exception -> L10
            NeoLog.i("resolve info " + r21.resolvePackageName + " ");     // Catch: Exception -> L10
            ActivityInfo r22 = r21.activityInfo;     // Catch: Exception -> L10
            if (r22 == null) goto L18;
            if (r22.packageName.equals(this.this$0.getPackageName()) == false) goto L18;
            NeoLog.i("PushMessageHandler hasActivityInfo");     // Catch: Exception -> L10
        L26:
            if (r22 == null) goto L40;
            this.this$0.addJob(new MessageHandleJob((PushMessageReceiver) Class.forName(r22.name).newInstance(), r16));     // Catch: Exception -> L10
            this.this$0.doHandleIntent(r16);     // Catch: Exception -> L10
            return;
        L40:
            return;
        L25:
            r22 = null;
            goto L26
        L39:
            return;
        L10:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // cn.nubia.neopush.service.aidl.IPushMessageHandler
        public int getSdkVersion() throws RemoteException {
            return Constant.SDK_VERSION;
        }

        public /* synthetic */ service_stub(PushMessageHandler r5, service_stub r10) {
            this(r5);
        }
    }

    static {
        mJobs = new ConcurrentLinkedQueue();
    }

    public PushMessageHandler() {
        this.singleTaskExecutorService = Executors.newSingleThreadExecutor();
        this.mbinder = new service_stub(this, null);
    }

    public static /* synthetic */ void access$0(PushMessageHandler r5) {
        r5.delayStopSelf();
    }

    public static /* synthetic */ void access$1(PushMessageHandler r5, Bundle r10) {
        r5.sendClickMessage(r10);
    }

    private void dealpackage(Context r5, String r10, String r11, String r12, String r13, String r14, Bundle r15) {
        if (TextUtils.isEmpty(r13) == true) goto L11;
        if (TextUtils.isEmpty(r12) == true) goto L11;
        if ("sendBroadcast".equals(r11) == true) goto L11;
        Intent r16 = new Intent(r12, Uri.parse(r13));     // Catch: Exception -> L50
    L18:
        if (TextUtils.isEmpty(r14) == true) goto L25;
        if ("sendBroadcast".equals(r11) == true) goto L25;
        if (r16 != null) goto L23;
        r16 = new Intent();     // Catch: Exception -> L50
    L23:
        r16.setClassName(r10, r14);     // Catch: Exception -> L50
    L25:
        if (TextUtils.isEmpty(r10) == false) goto L27;
    L31:
        if (r16 == null) goto L35;
        if (r15 == null) goto L35;
        r16.putExtras(r15);     // Catch: Exception -> L50
    L35:
        if ("startService".equals(r11) == false) goto L39;
        if (r16 == null) goto L39;
        r5.startService(r16);     // Catch: Exception -> L50
        return;
    L39:
        if ("startActivity".equals(r11) == false) goto L43;
        if (r16 == null) goto L43;
        r16.addFlags(268435456);     // Catch: Exception -> L50
        r5.startActivity(r16);     // Catch: Exception -> L50
        return;
    L43:
        if ("sendBroadcast".equals(r11) == false) goto L54;
        if (r16 != null) goto L46;
        return;
    L46:
        if (TextUtils.isEmpty(r13) == true) goto L48;
        r16.setData(Uri.parse(r13));     // Catch: Exception -> L50
    L48:
        r5.sendBroadcast(r16);     // Catch: Exception -> L50
        return;
    L54:
        return;
    L27:
        if ("sendBroadcast".equals(r11) == true) goto L31;
        if (r16 != null) goto L30;
        r16 = new Intent();     // Catch: Exception -> L50
    L30:
        r16.setPackage(r10);     // Catch: Exception -> L50
    L11:
        if (TextUtils.isEmpty(r12) == true) goto L16;
        r16 = new Intent();     // Catch: Exception -> L50
        if ("startService".equals(r11) == false) goto L15;
        r16 = new Intent(r12);     // Catch: Exception -> L50
        goto L18
    L15:
        r16.setAction(r12);     // Catch: Exception -> L50
        goto L18
    L16:
        r16 = null;
        goto L18
    }

    private void delayStopSelf() {
        ServiceHandler r5 = this.handler;
        if (r5 == null) goto L6;
        r5.removeCallbacksAndMessages(null);
        Message r10 = this.handler.obtainMessage();
        this.handler.getClass();
        r10.what = 1;
        this.handler.sendMessageDelayed(r10, 4000);
        return;
    }

    private void handleClickMessage(final MessageHandleJob r10) {
        NeoLog.i("MessageHandleService handleClickMessage");     // Catch: Exception -> L5
        final long r5 = r10.getIntent().getExtras().getLong("message_id");     // Catch: Exception -> L5
        NeoLog.i("MessageHandleService handleClickMessage messageId=" + r5);     // Catch: Exception -> L5
        Intent r11 = new Intent();     // Catch: Exception -> L5
        r11.setComponent(AppUtil.getPushServiceComponentName(getApplicationContext()));     // Catch: Exception -> L5
        ServiceConnection r12 = new AnonymousClass3(this, r5, r10);     // Catch: Exception -> L5
        NeoLog.e("123qwe", "conn:" + r12);     // Catch: Exception -> L5
        NeoLog.i("luzhi", "bing NeoPushService" + r11.getComponent().getClassName() + "        " + r11.getComponent().getPackageName());     // Catch: Exception -> L5
        boolean r13 = getApplicationContext().bindService(r11, r12, 1);     // Catch: Exception -> L5
        StringBuilder r14 = new StringBuilder("bind ");     // Catch: Exception -> L5
        r14.append(r13);     // Catch: Exception -> L5
        NeoLog.i("luzhi", r14.toString());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        NeoLog.i("zpy", "MessageHandleService handleClickMessage execption=" + e.getMessage());
        e.printStackTrace();
    }

    private void handlePassThroughMessage(final MessageHandleJob r5) {
        NeoLog.i("MessageHandleService handlePassThroughMessage");     // Catch: Exception -> L4
        Intent r10 = new Intent();     // Catch: Exception -> L4
        r10.setComponent(AppUtil.getPushServiceComponentName(getApplicationContext()));     // Catch: Exception -> L4
        bindService(r10, new AnonymousClass2(this, r5), 1);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        NeoLog.i("zpy", "MessageHandleService handlePassThroughMessage execption=" + e.getMessage());
        e.printStackTrace();
    }

    private void handlePassThroughMessageNew(MessageHandleJob r20) {
        String r10 = Constant.DESCRIPTION;
        String r11 = "content";
        String r12 = "zpy";
        NeoLog.i("MessageHandleService handlePassThroughMessageNew");     // Catch: Exception -> L78
        Bundle r13 = r20.getIntent().getExtras();     // Catch: Exception -> L78
        if (r13 == null) goto L102;
        NeoLog.i("zpy", "MessageHandleService handlePassThroughMessageNew=" + r13.toString());     // Catch: Exception -> L78
        String r14 = r13.getString("msg_list");     // Catch: Exception -> L78
        NeoLog.i("MessageHandleService handlePassThroughMessageNew msg_list：" + r14);     // Catch: Exception -> L78
        ArrayList r15 = new ArrayList();     // Catch: Exception -> L78
        if (TextUtils.isEmpty(r14) == false) goto L87;
    L10:
        String r17 = r12;
        if (r15.size() <= 0) goto L103;
        Iterator r5 = r15.iterator();     // Catch: Exception -> L18
    L60:
        if (r5.hasNext() == false) goto L62;
        NeoPushMessage r16 = (NeoPushMessage) r5.next();     // Catch: Exception -> L18
        String r18 = r17;
        NeoLog.i(r18, "MessageHandleService handlePassThroughMessageNew =" + r16.toString());     // Catch: Exception -> L76
        if (getPackageName() == null) goto L75;
        if (getPackageName().equals(Constant.CONTROL_APP_PACKAGES_NAME) == true) goto L75;
        String r19 = new JSONObject(r16.getContent()).getString("source");     // Catch: Exception -> L82
        if (r19 == null) goto L75;
        if (r19.equals("NubiaPush") == false) goto L75;
        SDKControllerMessageHandler.handlePassthroughMessage(r16.getContent(), getApplicationContext());     // Catch: Exception -> L82
        r15.remove(r16);     // Catch: Exception -> L82
    L75:
        r17 = r18;
    L76:
        e = e;
    L80:
        NeoLog.i(r18, "MessageHandleService handlePassThroughMessageNew execption=" + e.getMessage());
        e.printStackTrace();
        return;
    L62:
        if (r15.size() <= 0) goto L104;
        r20.getHandleReceiver().onReceivePassThroughMessage(r15);     // Catch: Exception -> L18
        return;
    L18:
        e = e;
    L19:
        r18 = r17;
        goto L80
    L104:
        return;
    L103:
        return;
    L87:
        JSONArray r110 = new JSONArray(r14);     // Catch: Exception -> L52
        NeoLog.i("MessageHandleService handlePassThroughMessageNew");     // Catch: Exception -> L52
        int r111 = 0;
    L9:
        if (r111 >= r110.length()) goto L10;
        JSONObject r112 = r110.optJSONObject(r111);     // Catch: Exception -> L52
        if (r112 == null) goto L54;
        r17 = r12;
        NeoLog.i("MessageHandleService handlePassThroughMessageNew js:" + r112.toString());     // Catch: Exception -> L18
        NeoPushMessage r113 = new NeoPushMessage();     // Catch: Exception -> L18
        if (r112.has(Constant.PACKAGE_NAME) == false) goto L21;
        r113.setPackageName(r112.getString(Constant.PACKAGE_NAME));     // Catch: Exception -> L18
    L21:
        if (r112.has(r11) == false) goto L24;
        r113.setContent(r112.getString(r11));     // Catch: Exception -> L18
    L24:
        if (r112.has(r10) == false) goto L27;
        r113.setDescription(r112.getString(r10));     // Catch: Exception -> L18
    L27:
        if (r112.has("message_id") == false) goto L31;
        r113.setMessageId(r112.getLong("message_id"));     // Catch: Exception -> L18
    L31:
        if (r112.has(Constant.ZTE_MESSAGE_ID) == false) goto L34;
        r113.setZteMessageId(r112.getString(Constant.ZTE_MESSAGE_ID));     // Catch: Exception -> L18
    L34:
        if (r112.has(Constant.MESSAGE_NUM) == false) goto L37;
        r113.setMessageNum(r112.getInt(Constant.MESSAGE_NUM));     // Catch: Exception -> L18
    L37:
        if (r112.has(Constant.NOTIFY_TYPE) == false) goto L40;
        r113.setNotifyType(r112.getInt(Constant.NOTIFY_TYPE));     // Catch: Exception -> L18
    L40:
        if (r112.has(Constant.NOTIFY_ID) == false) goto L43;
        r113.setNotifyId(r112.getInt(Constant.NOTIFY_ID));     // Catch: Exception -> L18
    L43:
        if (r112.has(Constant.TITLE) == false) goto L46;
        r113.setTitle(r112.getString(Constant.TITLE));     // Catch: Exception -> L18
    L46:
        if (r112.has(Constant.MESSAGE_TYPE) == false) goto L49;
        r113.setType(r112.getInt(Constant.MESSAGE_TYPE));     // Catch: Exception -> L18
    L49:
        if (r112.has("extra") == false) goto L51;
        r113.setExtra(AppUtil.parseExtra(r112.getString("extra")));     // Catch: Exception -> L18
    L51:
        r15.add(r113);     // Catch: Exception -> L18
    L55:
        r111 = r111 + 1;     // Catch: Exception -> L18
        r10 = r10;
        r110 = r110;
        r12 = r17;
        r11 = r11;
        goto L9
    L54:
        r11 = r11;
        r17 = r12;
        r10 = r10;
    L52:
        e = e;
        r17 = r12;
        goto L19
    L102:
        return;
    L78:
        e = e;
        r18 = "zpy";
        goto L80
    }

    private void onMessageClick(Bundle r14) {
        Map<String, String> r5 = AppUtil.parseExtra(r14.getString("extra"));
        int r10 = r14.getInt(Constant.MESSAGE_TYPE);
        NeoLog.i("onMessageClick messageType=" + r10);
        if (r10 != 3) goto L5;
        if (r5 != null) goto L76;
        return;
    L76:
        if (TextUtils.isEmpty(r5.get(Constant.EXTRA_WEB_URI)) == true) goto L104;
        Intent r11 = new Intent();
        r11.setAction("android.intent.action.VIEW");
        r11.setData(Uri.parse(r5.get(Constant.EXTRA_WEB_URI)));
        r11.setFlags(268435456);
        startActivity(r11);
        return;
    L104:
        return;
    L5:
        if (r10 != 4) goto L7;
        if (r5 != null) goto L72;
        return;
    L72:
        if (TextUtils.isEmpty(r5.get(Constant.EXTRA_DOWNLOAD_URI)) == true) goto L101;
        Intent r12 = new Intent();
        r12.setAction("android.intent.action.VIEW");
        r12.setData(Uri.parse(r5.get(Constant.EXTRA_DOWNLOAD_URI)));
        r12.setFlags(268435456);
        startActivity(r12);
        return;
    L101:
        return;
    L7:
        if (r10 != 5) goto L9;
        String r13 = r14.getString(Constant.PACKAGE_NAME);
        NeoLog.i("NOTIFICATION_LAUNCH_APP package=" + r13);
        if (Constant.CONTROL_APP_PACKAGES_NAME.equals(r13) == false) goto L30;
        return;
    L30:
        if ("com.zte.aliveupdate".equals(r13) == true) goto L93;
        String r15 = r14.getString("extra");
        int r16 = AppUtil.getPackageCode(getApplicationContext(), r13);
        JSONObject r17 = new JSONObject(r15);     // Catch: Exception -> L39
        String r18 = r17.getString("targetVersion");     // Catch: Exception -> L79
        boolean r19 = "true".equals(r17.getString("isOpen"));     // Catch: Exception -> L79
        if (r16 < Integer.valueOf(r18).intValue()) goto L38;
        if (r19 == false) goto L38;
        boolean r110 = true;
    L40:
        if (r110 == true) goto L82;
        startActivity(getApplicationContext().getPackageManager().getLaunchIntentForPackage(r13));
        return;
    L82:
        String r20 = r17.getString("action");     // Catch: Exception -> L56
        String r111 = r17.getString(LynxResourceModule.URI_KEY);     // Catch: Exception -> L56
        String r21 = r17.getString("className");     // Catch: Exception -> L56
        String r22 = r17.getString("type");     // Catch: Exception -> L56
        String[] r23 = r17.getString("extra").split("\\$\\$");     // Catch: Exception -> L44
    L46:
        if (r23 != null) goto L48;
    L64:
        Bundle r112 = null;
    L65:
        dealpackage(getApplicationContext(), r13, r22, r20, r111, r21, r112);     // Catch: Exception -> L56
        return;
    L48:
        if (r23.length <= 0) goto L64;
        Bundle r24 = new Bundle();     // Catch: Exception -> L56
        int r25 = 0;
    L51:
        if (r25 >= r23.length) goto L52;
        String r113 = r23[r25];     // Catch: Exception -> L56
        if (r113 == null) goto L58;
        String[] r114 = r113.split("\\$=");     // Catch: Exception -> L56
    L59:
        if (r114 == null) goto L63;
        if (r114.length != 2) goto L63;
        r24.putString(r114[0], r114[1]);     // Catch: Exception -> L56
    L63:
        r25 = r25 + 1;     // Catch: Exception -> L56
        goto L51
    L58:
        r114 = null;
        goto L59
    L52:
        r112 = r24;
        goto L65
    L44:
        e = move-exception;
        NeoLog.i("luzhi", "json错误" + e.getMessage());     // Catch: Exception -> L56
        r23 = null;
    L56:
        e = move-exception;
        e.printStackTrace();
        return;
    L38:
        r110 = false;
    L39:
        r17 = null;
        goto L38
    L93:
        return;
    L9:
        if (r10 != 6) goto L105;
        String r26 = r14.getString(Constant.PACKAGE_NAME);
        if (Constant.CONTROL_APP_PACKAGES_NAME.equals(r26) == false) goto L14;
        return;
    L14:
        if ("com.zte.aliveupdate".equals(r26) == true) goto L92;
        NeoLog.i("NOTIFICATION_LAUNCH_ACTIVITY package=" + r14.getString("extra"));
        if (r5 != null) goto L19;
        return;
    L19:
        if (TextUtils.isEmpty(r5.get(Constant.EXTRA_INTENT_URI)) == true) goto L95;
        Intent r27 = new Intent();
        r27.setPackage(r14.getString(Constant.PACKAGE_NAME));
        r27.setAction(r5.get(Constant.EXTRA_INTENT_URI));
        if (getPackageManager().resolveActivity(r27, 0) == null) goto L96;
        r27.setFlags(268435456);
        String r115 = r14.getString("content");
        if (TextUtils.isEmpty(r115) == true) goto L25;
        r27.putExtra("content", r115);
    L25:
        startActivity(r27);
        return;
    L96:
        return;
    L95:
        return;
    L92:
        return;
    }

    private void sendClickMessage(Bundle r10) {
        NeoLog.i("MessageHandleService sendClickMessage messageid=" + r10.getLong("message_id"));     // Catch: Exception -> L4
        Intent r5 = new Intent(Constant.SEND_COMMAND);     // Catch: Exception -> L4
        r5.setComponent(AppUtil.getPushServiceComponentName(getApplicationContext()));     // Catch: Exception -> L4
        Bundle r11 = new Bundle();     // Catch: Exception -> L4
        NeoLog.i("MessageHandleService sendClickMessage isControlClick=true");     // Catch: Exception -> L4
        r11.putString(Constant.COMMAND, Constant.ClientMessageType.SEND_CLECK);     // Catch: Exception -> L4
        r11.putBoolean(Constant.IS_CLICK, true);     // Catch: Exception -> L4
        r11.putAll(r10);     // Catch: Exception -> L4
        r5.putExtras(r11);     // Catch: Exception -> L4
        startService(r5);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void addJob(MessageHandleJob r5) {
        if (r5 == null) goto L5;
        mJobs.add(r5);
        return;
    }

    public void doHandleIntent(Intent r10) {
        NeoLog.i("MessageHandleService onHandleIntent");
        if (r10 == null) goto L61;
        MessageHandleJob r11 = mJobs.poll();
        if (r11 == null) goto L62;
        Bundle r5 = r11.getIntent().getExtras();
        if (r5 != null) goto L9;
        return;
    L9:
        int r12 = r5.getInt(Constant.MESSAGE_TYPE);
        NeoLog.i("MessageHandleService onHandleIntent messageType=" + r12);
        if (r12 != 7) goto L16;
        int r13 = r5.getInt(Constant.MESSAGE_SUB_TYPE);
        NeoLog.i("MessageHandleService onHandleIntent subMessageType=" + r13);
        switch(r13) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L14;
            case 4: goto L14;
            case 5: goto L14;
            case 6: goto L14;
            default: goto L65;
        };
    L14:
        handleClickMessage(r11);
        return;
    L15:
        handlePassThroughMessage(r11);
        return;
    L65:
        return;
    L16:
        int r14 = r5.getInt("result_code", -1);
        NeoPushCommandMessage r15 = new NeoPushCommandMessage();
        NeoLog.i("MessageHandleService command resultCode = " + r14);
        if (r14 != 0) goto L19;
        r15.setResult(true);
    L21:
        if (r12 == 13) goto L56;
        if (r12 != 15) goto L25;
        r15.setCommand("set_topic");
        r11.getHandleReceiver().onCommandResult(r15);
    L59:
        delayStopSelf();
        return;
    L25:
        if (r12 != 17) goto L27;
        r15.setCommand("unset_topic");
        r11.getHandleReceiver().onCommandResult(r15);
        goto L59
    L27:
        if (r12 != 19) goto L29;
        r15.setCommand("set_alias");
        r11.getHandleReceiver().onCommandResult(r15);
        goto L59
    L29:
        if (r12 == 21) goto L38;
        if (r12 != 23) goto L33;
        r15.setCommand("unregister_app");
        r11.getHandleReceiver().onCommandResult(r15);
        goto L59
    L33:
        if (r12 != 25) goto L59;
        r15.setCommand(Constant.ClientMessageType.ACTIVE);
        r11.getHandleReceiver().onCommandResult(r15);
        goto L59
    L38:
        if (r15.isResult() == false) goto L51;
        String r16 = SDKPrefEditor.getRegId(getApplicationContext());
        String r17 = SDKPrefEditor.getAppId(getApplicationContext());
        String r18 = SDKPrefEditor.getAppKey(getApplicationContext());
        if (r16 == null) goto L51;
        if (r16.equals("") == true) goto L51;
        SharedPreferences.Editor r19 = getSharedPreferences(Constant.SaveReg, 0).edit();
        r19.putString("RegID", r16);
        r19.putString("appID", r17);
        r19.putString(Constant.APPKEY, r18);
        if (Constant.CONTROL_APP_PACKAGES_NAME.equals(getPackageName()) == false) goto L50;
        String r20 = r11.getIntent().getStringExtra(Constant.DEST_PACKAGE);
        if (r20 == null) goto L50;
        if (PushApplication.isUnrealpackage(r20) == false) goto L50;
        r19.putString("RegID_".concat(r20), r16);
    L50:
        r19.commit();
        NeoLog.i("luzhi", "registe success save regid success");
    L51:
        r15.setCommand(Constant.ClientMessageType.REGISTER_APP);
        r11.getHandleReceiver().onReceiveRegisterResult(r15);
        goto L59
    L56:
        if (r14 != (-1000)) goto L58;
        r15.setCommand(Constant.ClientMessageType.GET_TOPICS);
        r11.getHandleReceiver().onCommandResult(r15);
        goto L59
    L58:
        r11.getHandleReceiver().onReceiveTopicsResult(SDKUtils.parseTopicJSONToList(r5.getString(Constant.TOPICS)));
        goto L59
    L19:
        r15.setResult(false);
        r15.setReason(r5.getString("reason"));
        goto L21
    L62:
        return;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r5) {
        NeoLog.i("luzhi", "PushMessageHandler onbind");
        if (r5 == null) goto L33;
        boolean r10 = r5.getBooleanExtra("isNotBind", false);
        NeoLog.i("luzhi", "PushMessageHandler onbind isNotBind:" + r10);
        if (r10 == false) goto L33;
        NeoLog.i("PushMessageHandler onBind=" + getPackageName());     // Catch: Exception -> L17
        Intent r11 = new Intent(Constant.RECEIVE_MESSAGE_ACTION);     // Catch: Exception -> L17
        r11.setPackage(getPackageName());     // Catch: Exception -> L17
        r11.putExtras(r5);     // Catch: Exception -> L17
        List<ResolveInfo> r12 = getPackageManager().queryBroadcastReceivers(r11, 32);     // Catch: Exception -> L17
        if (r12 == null) goto L19;
        Iterator<ResolveInfo> r13 = r12.iterator();     // Catch: Exception -> L17
    L10:
        if (r13.hasNext() == false) goto L19;
        ResolveInfo r14 = r13.next();     // Catch: Exception -> L17
        NeoLog.i("PushMessageHandler onBind resolve info " + r14.resolvePackageName + " ");     // Catch: Exception -> L17
        ActivityInfo r15 = r14.activityInfo;     // Catch: Exception -> L17
        if (r15 == null) goto L10;
        if (r15.packageName.equals(getPackageName()) == false) goto L10;
        NeoLog.i("PushMessageHandler onBind hasActivityInfo");     // Catch: Exception -> L17
    L20:
        if (r15 == null) goto L33;
        addJob(new MessageHandleJob((PushMessageReceiver) Class.forName(r15.name).newInstance(), r5));     // Catch: Exception -> L17
        MessageHandleJob r16 = mJobs.poll();     // Catch: Exception -> L17
        if (r16 == null) goto L33;
        Bundle r17 = r16.getIntent().getExtras();     // Catch: Exception -> L17
        if (r17 != null) goto L26;
        handlePassThroughMessageNew(r16);     // Catch: Exception -> L17
        goto L33
    L26:
        if (r17.getInt(Constant.MESSAGE_TYPE) != 7) goto L28;
        handlePassThroughMessageNew(r16);     // Catch: Exception -> L17
        goto L33
    L28:
        doHandleIntent(r5);     // Catch: Exception -> L17
    L19:
        r15 = null;
    L17:
        e = move-exception;
        e.printStackTrace();
    L33:
        return this.mbinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.handler = new ServiceHandler(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        NeoLog.i("luzhi", "intentservice  ondestroy");
        ServiceHandler r5 = this.handler;     // Catch: Exception -> L9
        if (r5 == null) goto L6;
        r5.removeCallbacksAndMessages(null);     // Catch: Exception -> L9
    L6:
        this.singleTaskExecutorService.shutdown();     // Catch: Exception -> L9
    L7:
        super.onDestroy();
    }

    public void onHandleIntent(Intent r10) {
        NeoLog.i("luzhi", "PushMessageHandler onHandleIntent=" + getPackageName());     // Catch: Exception -> L18
        if (r10 != null) goto L6;
        return;
    L6:
        if (Constant.RECEIVE_MESSAGE_ACTION.equals(r10.getAction()) == false) goto L35;
        Intent r5 = new Intent(Constant.RECEIVE_MESSAGE_ACTION);     // Catch: Exception -> L18
        r5.setPackage(getPackageName());     // Catch: Exception -> L18
        r5.putExtras(r10);     // Catch: Exception -> L18
        List<ResolveInfo> r11 = getPackageManager().queryBroadcastReceivers(r5, 32);     // Catch: Exception -> L18
        if (r11 == null) goto L20;
        Iterator<ResolveInfo> r12 = r11.iterator();     // Catch: Exception -> L18
    L11:
        if (r12.hasNext() == false) goto L20;
        ActivityInfo r13 = r12.next().activityInfo;     // Catch: Exception -> L18
        if (r13 == null) goto L11;
        if (r13.packageName.equals(getPackageName()) == false) goto L11;
        NeoLog.i("PushMessageHandler hasActivityInfo");     // Catch: Exception -> L18
    L21:
        if (r13 == null) goto L36;
        addJob(new MessageHandleJob((PushMessageReceiver) Class.forName(r13.name).newInstance(), r10));     // Catch: Exception -> L18
        doHandleIntent(r10);     // Catch: Exception -> L18
        return;
    L36:
        return;
    L20:
        r13 = null;
        goto L21
    L35:
        return;
    L18:
        e = move-exception;
        NeoLog.i("PushMessageHandler onHandleIntent=" + e.getMessage());
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        NeoLog.i("luzhi", "onLowMemory");
        ServiceHandler r5 = this.handler;
        if (r5 == null) goto L6;
        r5.removeCallbacksAndMessages(null);
        return;
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent r5, int r10, int r11) {
        ServiceHandler r12 = this.handler;
        if (r12 == null) goto L10;
        r12.removeCallbacksAndMessages(null);
    L10:
        this.singleTaskExecutorService.execute(new AnonymousClass1(this, r5));     // Catch: Exception -> L7
    L9:
        return super.onStartCommand(r5, r10, r11);
    L7:
        NeoLog.i("luzhi", "excutor reject 1");
        goto L9
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent r5) {
        super.onTaskRemoved(r5);
        NeoLog.i("luzhi", "onTaskRemoved");
        ServiceHandler r10 = this.handler;
        if (r10 == null) goto L6;
        r10.removeCallbacksAndMessages(null);
        return;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent r5) {
        NeoLog.i("luzhi", "intentservice  onUnbind");
        return super.onUnbind(r5);
    }
}

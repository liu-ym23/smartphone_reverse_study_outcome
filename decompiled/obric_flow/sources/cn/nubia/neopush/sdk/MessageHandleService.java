package cn.nubia.neopush.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.text.TextUtils;
import cn.nubia.neopush.PushApplication;
import cn.nubia.neopush.commons.AppUtil;
import cn.nubia.neopush.commons.Constant;
import cn.nubia.neopush.commons.NeoLog;
import com.lynx.jsbridge.LynxResourceModule;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MessageHandleService extends Service {
    private static ConcurrentLinkedQueue<MessageHandleJob> mJobs;
    int bindCount;
    ServiceHandler handler;
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
        WeakReference<MessageHandleService> weakReference;

        public ServiceHandler(MessageHandleService r5) {
            this.STOP = 1;
            this.weakReference = new WeakReference(r5);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r5) {
            super.handleMessage(r5);
            if (r5.what != 1) goto L8;
            MessageHandleService r10 = this.weakReference.get();
            if (r10 == null) goto L9;
            NeoLog.i("luzhi", "MessageHandleService stop");
            r10.stopSelf();
            return;
        L9:
            return;
        }
    }

    static {
        mJobs = new ConcurrentLinkedQueue();
    }

    public MessageHandleService() {
        this.singleTaskExecutorService = Executors.newSingleThreadExecutor();
        this.bindCount = 0;
    }

    public static /* synthetic */ void access$0(MessageHandleService r5) {
        r5.delayStopSelf();
    }

    public static /* synthetic */ void access$1(MessageHandleService r5, Bundle r10) {
        r5.onMessageClick(r10);
    }

    public static /* synthetic */ void access$2(MessageHandleService r5, Bundle r10) {
        r5.sendClickMessage(r10);
    }

    public static void addJob(MessageHandleJob r5) {
        if (r5 == null) goto L5;
        mJobs.add(r5);
        return;
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
        this.bindCount++;
        NeoLog.i("MessageHandleService handleClickMessage");     // Catch: Exception -> L5
        final long r5 = r10.getIntent().getExtras().getLong("message_id");     // Catch: Exception -> L5
        NeoLog.i("MessageHandleService handleClickMessage messageId=" + r5);     // Catch: Exception -> L5
        Intent r11 = new Intent();     // Catch: Exception -> L5
        r11.setComponent(AppUtil.getPushServiceComponentName(getApplicationContext()));     // Catch: Exception -> L5
        ServiceConnection r12 = new AnonymousClass1(this, r5, r10);     // Catch: Exception -> L5
        NeoLog.i("luzhi", "bing NeoPushService" + r11.getComponent().getClassName() + "        " + r11.getComponent().getPackageName());     // Catch: Exception -> L5
        boolean r13 = bindService(r11, r12, 1);     // Catch: Exception -> L5
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

    private void onMessageClick(Bundle r14) {
        Map<String, String> r5 = AppUtil.parseExtra(r14.getString("extra"));
        int r10 = r14.getInt(Constant.MESSAGE_TYPE);
        NeoLog.i("onMessageClick messageType=" + r10);
        if (r10 != 3) goto L5;
        if (r5 != null) goto L70;
        return;
    L70:
        if (TextUtils.isEmpty(r5.get(Constant.EXTRA_WEB_URI)) == true) goto L96;
        Intent r11 = new Intent();
        r11.setAction("android.intent.action.VIEW");
        r11.setData(Uri.parse(r5.get(Constant.EXTRA_WEB_URI)));
        r11.setFlags(268435456);
        startActivity(r11);
        return;
    L96:
        return;
    L5:
        if (r10 != 4) goto L7;
        if (r5 != null) goto L66;
        return;
    L66:
        if (TextUtils.isEmpty(r5.get(Constant.EXTRA_DOWNLOAD_URI)) == true) goto L93;
        Intent r12 = new Intent();
        r12.setAction("android.intent.action.VIEW");
        r12.setData(Uri.parse(r5.get(Constant.EXTRA_DOWNLOAD_URI)));
        r12.setFlags(268435456);
        startActivity(r12);
        return;
    L93:
        return;
    L7:
        if (r10 != 5) goto L9;
        String r13 = r14.getString(Constant.PACKAGE_NAME);
        NeoLog.i("NOTIFICATION_LAUNCH_APP package=" + r13);
        if (Constant.CONTROL_APP_PACKAGES_NAME.equals(r13) == false) goto L27;
        return;
    L27:
        String r15 = r14.getString("extra");
        int r16 = AppUtil.getPackageCode(getApplicationContext(), r13);
        JSONObject r17 = new JSONObject(r15);     // Catch: Exception -> L34
        String r18 = r17.getString("targetVersion");     // Catch: Exception -> L73
        boolean r19 = "true".equals(r17.getString("isOpen"));     // Catch: Exception -> L73
        if (r16 < Integer.valueOf(r18).intValue()) goto L33;
        if (r19 == false) goto L33;
        boolean r110 = true;
    L35:
        if (r110 == true) goto L76;
        startActivity(getApplicationContext().getPackageManager().getLaunchIntentForPackage(r13));
        return;
    L76:
        String r111 = r17.getString("action");     // Catch: Exception -> L51
        String r20 = r17.getString(LynxResourceModule.URI_KEY);     // Catch: Exception -> L51
        String r21 = r17.getString("className");     // Catch: Exception -> L51
        String r22 = r17.getString("type");     // Catch: Exception -> L51
        String[] r23 = r17.getString("extra").split("\\$\\$");     // Catch: Exception -> L39
    L41:
        if (r23 != null) goto L43;
    L59:
        Bundle r112 = null;
    L60:
        dealpackage(getApplicationContext(), r13, r22, r111, r20, r21, r112);     // Catch: Exception -> L51
        return;
    L43:
        if (r23.length <= 0) goto L59;
        Bundle r24 = new Bundle();     // Catch: Exception -> L51
        int r25 = 0;
    L46:
        if (r25 >= r23.length) goto L47;
        String r113 = r23[r25];     // Catch: Exception -> L51
        if (r113 == null) goto L53;
        String[] r114 = r113.split("\\$=");     // Catch: Exception -> L51
    L54:
        if (r114 == null) goto L58;
        if (r114.length != 2) goto L58;
        r24.putString(r114[0], r114[1]);     // Catch: Exception -> L51
    L58:
        r25 = r25 + 1;     // Catch: Exception -> L51
        goto L46
    L53:
        r114 = null;
        goto L54
    L47:
        r112 = r24;
        goto L60
    L39:
        e = move-exception;
        NeoLog.i("luzhi", "json错误" + e.getMessage());     // Catch: Exception -> L51
        r23 = null;
    L51:
        e = move-exception;
        e.printStackTrace();
        return;
    L33:
        r110 = false;
    L34:
        r17 = null;
        goto L33
    L9:
        if (r10 == 6) goto L12;
        return;
    L12:
        if (Constant.CONTROL_APP_PACKAGES_NAME.equals(r14.getString(Constant.PACKAGE_NAME)) == false) goto L14;
        return;
    L14:
        NeoLog.i("NOTIFICATION_LAUNCH_ACTIVITY package=" + r14.getString("extra"));
        if (r5 != null) goto L17;
        return;
    L17:
        if (TextUtils.isEmpty(r5.get(Constant.EXTRA_INTENT_URI)) == true) goto L87;
        Intent r26 = new Intent();
        r26.setPackage(r14.getString(Constant.PACKAGE_NAME));
        r26.setAction(r5.get(Constant.EXTRA_INTENT_URI));
        if (getPackageManager().resolveActivity(r26, 0) == null) goto L88;
        r26.setFlags(268435456);
        String r115 = r14.getString("content");
        if (TextUtils.isEmpty(r115) == true) goto L23;
        r26.putExtra("content", r115);
    L23:
        startActivity(r26);
        return;
    L88:
        return;
    }

    private void sendClickMessage(Bundle r5) {
        NeoLog.i("MessageHandleService sendClickMessage messageid=" + r5.getLong("message_id"));     // Catch: Exception -> L4
        Intent r10 = new Intent(Constant.SEND_COMMAND);     // Catch: Exception -> L4
        r10.setComponent(AppUtil.getPushServiceComponentName(getApplicationContext()));     // Catch: Exception -> L4
        Bundle r11 = new Bundle();     // Catch: Exception -> L4
        r11.putString(Constant.COMMAND, Constant.ClientMessageType.SEND_CLECK);     // Catch: Exception -> L4
        r11.putAll(r5);     // Catch: Exception -> L4
        r10.putExtras(r11);     // Catch: Exception -> L4
        startService(r10);     // Catch: Exception -> L4
        return;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r5) {
        return null;
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
        this.singleTaskExecutorService.execute(new AnonymousClass3(this, r5));     // Catch: Exception -> L7
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

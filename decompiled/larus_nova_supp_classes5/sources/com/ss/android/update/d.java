package com.ss.android.update;

import android.R;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.webkit.URLUtil;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import com.bytedance.common.utility.DeviceUtils;
import com.bytedance.common.utility.DigestUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.SignUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.common.utility.persistent.SharedPrefsEditorCompat;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.services.app.common.context.api.AppCommonContext;
import com.ss.android.common.app.permission.c;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.socialbase.appdownloader.AppDownloadUtils;
import com.ss.android.socialbase.appdownloader.AppDownloader;
import com.ss.android.socialbase.appdownloader.AppTaskBuilder;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import ita.k;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;
import yhc.b0;
import yhc.c0;
import yhc.f0;
import yhc.g0;
import yhc.h;
import yhc.i;
import yhc.i0;
import yhc.k0;
import yhc.l;
import yhc.l0;
import yhc.n;
import yhc.o;
import yhc.p;
import yhc.q;
import yhc.u;
import yhc.v;
import yhc.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d implements i {
    public static d B0;
    public String A;
    public long A0;
    public String B;
    public boolean C;
    public int D;
    public long E;
    public int F;
    public String G;
    public int H;
    public int I;
    public volatile boolean J;
    public final yhc.a K;
    public h L;
    public int M;
    public volatile boolean N;
    public final yhc.a O;
    public int P;
    public String Q;
    public int R;
    public int S;
    public int T;
    public String U;
    public String V;
    public volatile boolean W;
    public int X;
    public int Y;
    public String Z;
    public volatile boolean a;
    public int a0;
    public final NotificationManager b;
    public int b0;
    public NotificationCompat.Builder c;
    public int c0;
    public final Context d;
    public String d0;
    public final a e;
    public f e0;
    public final String f;
    public final g f0;
    public String g;
    public final List<OnUpdateStatusChangedListener> g0;
    public String h;
    public l h0;
    public String i;
    public h i0;
    public final String j;
    public String j0;
    public boolean k;
    public String k0;
    public String l;
    public String l0;
    public int m;
    public boolean m0;
    public int n;
    public final IUpdateConfig n0;
    public int o;
    public final b o0;
    public String p;
    public final v p0;
    public String q;
    public final ExecutorService q0;
    public String r;
    public volatile int r0;
    public long s;
    public final AppCommonContext s0;
    public String t;
    public e t0;
    public String u;
    public int u0;
    public boolean v;
    public u v0;
    public boolean w;
    public yhc.g w0;
    public boolean x;
    public l x0;
    public String y;
    public boolean y0;
    public String z;
    public String z0;

    public class a extends Handler {
        public final /* synthetic */ d a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v17 */
        /* JADX WARN: Type inference failed for: r6v18, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r6v19 */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.os.Handler
        public final void handleMessage(Message r17) {
            d r2 = this.a;
            r2.getClass();
            int r4 = 0;
            boolean r5 = false;
            char r6 = 0;
            r6 = 0;
            r6 = 0;
            int r11 = 1;
            h r9 = null;
            switch(r17.what) {
                case 1: goto L308;
                case 2: goto L306;
                case 3: goto L314;
                case 4: goto L310;
                case 5: goto L207;
                case 6: goto L122;
                case 7: goto L92;
                case 8: goto L38;
                case 9: goto L28;
                case 10: goto L25;
                case 11: goto L24;
                case 12: goto L23;
                case 13: goto L316;
                case 14: goto L342;
                case 15: goto L15;
                case 16: goto L13;
                case 17: goto L6;
                default: goto L342;
            };
        L15:
            ThreadPlus.submitRunnable(new b0(r2, r17.arg1, r17.arg2));
            return;
        L23:
            r2.b.cancel(2131387148);     // Catch: Exception -> L302
        L318:
            return;
        L24:
            r2.b.cancel(2131387151);     // Catch: Exception -> L302
            goto L318
        L25:
            r2.b.cancel(2131387149);     // Catch: Exception -> L302
            goto L318
        L38:
            Object r3 = r17.obj;
            if ((r3 instanceof b.a) == false) goto L41;
            b.a r7 = (b.a) r3;
        L43:
            if (r17.arg1 != 1) goto L45;
            ?? r8 = 1;
        L47:
            if (r17.arg2 != 1) goto L49;
            boolean r0 = true;
        L50:
            if (r7 != null) goto L52;
            r7 = new b.a();
        L52:
            JSONObject r10 = new JSONObject();
            if (r2.f() == true) goto L55;
            r9 = "canDownloadApk = false";
        L61:
            if (TextUtils.isEmpty(r9) == false) goto L84;
            b r12 = r2.o0;
            String r13 = r2.l;
            if (r8 == 0) goto L65;
            String r1 = "predownload.apk.part";
        L68:
            String r14 = r2.f + File.separator;
            int r15 = r2.o;
            r12.b = false;
            r12.d = new WeakReference(r2);
            r12.e = r7;
            AppTaskBuilder r16 = new AppTaskBuilder(r12.a, r13).saveName(r1).savePath(r14).taskKey(r13 + ":" + r14 + ":" + r1).needWifi(false).showNotification(false).needReuseFirstConnection(true).needDefaultHttpServiceBackUp(true).ignoreInterceptor(true).mainThreadListener(new com.ss.android.update.a(r12, r8, r13, r15));
            b.a r18 = r12.e;
            if (r18 != null) goto L71;
        L73:
            int r19 = AppDownloader.getInstance().addDownloadTask(r16);
            r12.c = r19;
            if (r19 != 0) goto L80;
            i r20 = r12.d.get();
            if (r20 == 0) goto L78;
            r20.a(false, r8);
        L78:
            c.e("does not support, mid == 0");
            c.d(r13, r15, r8, "unSupport", "mid == 0");
        L80:
            if (Logger.debug() == false) goto L82;
            Logger.d("UpdateDownloadHelper", "id " + r12.c);
        L82:
            if (r8 != 0) goto L351;
            r2.e.sendEmptyMessage(3);
            return;
        L351:
            return;
        L71:
            if (r18.a == false) goto L73;
            r16.retryCount(3);
            goto L73
        L65:
            if (r0 == false) goto L67;
            r1 = "update_alpha.apk.part";
            goto L68
        L67:
            r1 = "update.apk.part";
            goto L68
        L84:
            r2.J = false;
            if (r7.a == true) goto L88;
            l0.a(r10, "errorMsg", r9);
            l0.a(r10, "url", r2.l);
            l0.a(r10, "pre", Integer.valueOf(r8));
            l0.a(r10, "canceled", 0);
            l0.a(r10, "success", 0);
            yhc.b.a("app_update_download", r10);
            c.e(r9);
            c.d(r2.l, r2.o, r8, "fail", r9);
            return;
        L88:
            if (d.x().o0.e != null) goto L90;
            d.x().o0.e = r7;
        L90:
            c.d(r2.l, r2.o, r8, "fail", r9);
            return;
        L55:
            PolarisFileWrapper r21 = new PolarisFileWrapper(r2.f);
            if (r21.isDirectory() == true) goto L61;
            if (r21.mkdirs() == true) goto L61;
            r9 = "can not mkdir files dir: " + r2.f;
            Logger.e("UpdateHelper", r9);
            goto L61
        L49:
            r0 = false;
            goto L50
        L45:
            r8 = 0;
            goto L47
        L41:
            r7 = null;
            goto L43
        L207:
            int r22 = r17.arg1;
            if (r22 < 0) goto L212;
            r4 = r22;
        L212:
            if (r4 <= 99) goto L214;
            r4 = 99;
        L214:
            r2.b.notify(2131387150, r2.B(r4));
            return;
        L306:
            r2.b.cancel(2131387149);     // Catch: Exception -> L237
            r2.b.cancel(2131387148);     // Catch: Exception -> L237
        L239:
            if (r2.f() == false) goto L372;
            AppCommonContext r23 = r2.s0;
            if (r23 == null) goto L244;
            String r24 = r23.getStringAppName();
        L245:
            String r25 = String.format(r2.d.getString(2131914150), new Object[]{r24, r2.z()});
            String r26 = String.format(r2.d.getString(2131914149), new Object[]{r2.z()});
            Intent r27 = new Intent();
            if (TextUtils.isEmpty(null) == false) goto L248;
            r27.setClassName(r2.d, UpdateProgressActivity.class.getName());
        L252:
            r27.putExtra("from_update_avail", true);
            r27.addFlags(536870912);
            int r28 = Build.VERSION.SDK_INT;
            if (r28 < 23) goto L255;
            int r29 = 67108864;
        L256:
            h r30 = PendingIntent.getActivity(r2.d, 0, r27, r29);
            v r31 = r2.p0;
            if (r31 != null) goto L259;
        L261:
            r9 = r30;
        L262:
            NotificationCompat.Builder r32 = new NotificationCompat.Builder(r2.d);
            if (r28 < 26) goto L265;
            r32.setChannelId("update_channel_01");
            r32.setVibrate(new long[]{0});
        L265:
            v r33 = r2.p0;
            if (r33 == null) goto L268;
            int r34 = r33.a;
        L269:
            r32.setSmallIcon(r34).setTicker(r25).setWhen(System.currentTimeMillis()).setContentTitle(r24).setContentText(r26).setContentIntent(r9).setAutoCancel(true);
            r2.b.notify(2131387151, r32.build());
            return;
        L268:
            r34 = 2131248293;
            goto L269
        L259:
            if (r31.g == false) goto L261;
        L255:
            r29 = 0;
            goto L256
        L248:
            if (Logger.debug() == false) goto L250;
            Logger.d("UpdateHelper", "iUpdateActivity.getClass().getName() null");
        L250:
            r27.setClassName(r2.d, null);
            goto L252
        L244:
            r24 = "";
            goto L245
        L372:
            return;
        L308:
            r2.b.cancel(2131387150);     // Catch: Exception -> L272
            r2.b.cancel(2131387151);     // Catch: Exception -> L272
            r2.b.cancel(2131387148);     // Catch: Exception -> L272
        L273:
            PolarisFileWrapper r35 = new PolarisFileWrapper(r2.g);
            if (r35.exists() == true) goto L276;
        L294:
            c.d(r2.l, r2.o, false, "install_fail", "notifyDownloadReady");
        L296:
            if (r2.e0 != null) goto L298;
            return;
        L298:
            if (Logger.debug() == false) goto L300;
            Logger.d("UpdateHelper", "from MSG_UPDATE_READY");
        L300:
            r2.q();
            return;
        L276:
            if (r35.isFile() == false) goto L294;
            AppCommonContext r36 = r2.s0;
            if (r36 == null) goto L281;
            String r37 = r36.getStringAppName();
        L282:
            String r38 = String.format(r2.d.getString(2131914153), new Object[]{r37, r2.z()});
            String r39 = String.format(r2.d.getString(2131914152), new Object[]{r2.z()});
            Intent r40 = r2.y(r2.d, r35);
            int r41 = Build.VERSION.SDK_INT;
            if (r41 < 23) goto L285;
            int r110 = 67108864;
        L286:
            PendingIntent r42 = PendingIntent.getActivity(r2.d, 0, r40, r110);
            NotificationCompat.Builder r111 = new NotificationCompat.Builder(r2.d);
            if (r41 < 26) goto L289;
            r111.setChannelId("update_channel_01");
            r111.setVibrate(new long[]{0});
        L289:
            v r43 = r2.p0;
            if (r43 == null) goto L292;
            int r44 = r43.a;
        L293:
            r111.setSmallIcon(r44);
            r111.setTicker(r38);
            r111.setWhen(System.currentTimeMillis());
            r111.setContentTitle(r37).setContentText(r39);
            r111.setContentIntent(r42);
            r111.setAutoCancel(true);
            r2.b.notify(2131387149, r111.build());
            r2.L(r2.d, r35);
            goto L296
        L292:
            r44 = 2131248293;
            goto L293
        L285:
            r110 = 0;
            goto L286
        L281:
            r37 = "";
            goto L282
        L310:
            r2.b.cancel(2131387150);     // Catch: Exception -> L217
            r2.b.cancel(2131387149);     // Catch: Exception -> L217
            r2.b.cancel(2131387151);     // Catch: Exception -> L217
        L219:
            if (r2.f() == false) goto L371;
            AppCommonContext r45 = r2.s0;
            if (r45 == null) goto L224;
            String r46 = r45.getStringAppName();
        L225:
            String r47 = r2.d.getString(2131914148);
            int r48 = Build.VERSION.SDK_INT;
            if (r48 < 23) goto L228;
            int r112 = 67108864;
        L229:
            PendingIntent r49 = PendingIntent.getActivity(r2.d, 0, new Intent(), r112);
            NotificationCompat.Builder r50 = new NotificationCompat.Builder(r2.d);
            if (r48 < 26) goto L232;
            r50.setChannelId("update_channel_01");
            r50.setVibrate(new long[]{0});
        L232:
            r50.setSmallIcon(R.drawable.stat_notify_error).setChannelId("update_channel_01").setTicker(r47).setWhen(System.currentTimeMillis()).setContentTitle(r46).setContentText(r47).setContentIntent(r49).setAutoCancel(true);
            r2.b.notify(2131387148, r50.build());
            return;
        L228:
            r112 = 0;
            goto L229
        L224:
            r46 = "";
            goto L225
        L371:
            return;
        L314:
            r2.b.cancel(2131387150);     // Catch: Exception -> L303
            r2.b.cancel(2131387148);     // Catch: Exception -> L303
            r2.b.cancel(2131387149);     // Catch: Exception -> L303
            r2.b.cancel(2131387151);     // Catch: Exception -> L303
        L234:
            r2.b.notify(2131387150, r2.B(0));
            return;
        L316:
            r2.b.cancel(2131387150);     // Catch: Exception -> L18
        L20:
            if (Logger.debug() == false) goto L22;
            Logger.d("UpdateHelper", "from MSG_CANCEL_PROGRESS");
        L22:
            r2.q();
            return;
        L342:
            return;
        L6:
            if (r2.W == false) goto L8;
            c.a(6, "other dialog showing", null);
            return;
        L8:
            p r51 = p.b.a;
            if (r51.b(r2.o) == false) goto L11;
            c.a(6, "ignore version:" + r2.o, null);
            return;
        L11:
            r51.a();
            c.a(6, "condition not match2", null);
            return;
        L13:
            if (p.b.a.b(r2.o) == true) goto L346;
            ThreadPlus.submitRunnable(new c0(r2));
            return;
        L346:
            return;
        L28:
            if (r2.J == false) goto L30;
            r2.J = false;
        L30:
            JSONObject r52 = new JSONObject();
            l0.a(r52, "errorMsg", "has not get positive result from update checking");
            l0.a(r52, "url", r2.l);
            if (r17.arg1 != 1) goto L33;
            int r53 = 1;
        L34:
            l0.a(r52, "pre", Integer.valueOf(r53));
            l0.a(r52, "canceled", 0);
            l0.a(r52, "success", 0);
            yhc.b.a("app_update_download", r52);
            String r54 = r2.l;
            int r55 = r2.o;
            if (r17.arg1 != 1) goto L37;
            r5 = true;
        L37:
            c.d(r54, r55, r5, "fail", "has not get positive result from update checking");
            return;
        L33:
            r53 = 0;
            goto L34
        L92:
            if (Logger.debug() == false) goto L94;
            Logger.d("UpdateHelper", "from MSG_CHECK_UPDATE_FAIL");
        L94:
            r2.q();
            List<OnUpdateStatusChangedListener> r56 = r2.g0;
            monitor-enter(r56);
            Iterator r57 = ((ArrayList) r2.g0).iterator();     // Catch: Throwable -> L118
        L98:
            if (r57.hasNext() == false) goto L105;
            OnUpdateStatusChangedListener r58 = (OnUpdateStatusChangedListener) r57.next();     // Catch: Throwable -> L118
            if (r58 == null) goto L98;
            if (r2.Q() == true) goto L103;
            r58.c(-2);     // Catch: Throwable -> L118
            goto L98
        L103:
            r58.c(-1);     // Catch: Throwable -> L118
            goto L98
        L105:
            monitor-exit(r56);     // Catch: Throwable -> L118
            if (r2.r0 == 1) goto L109;
            return;
        L109:
            if (r2.t0 != null) goto L111;
            r2.t0 = new e();
        L111:
            e r59 = r2.t0;
            h r60 = r2.i0;
            if (r60 == null) goto L114;
            r9 = r60;
        L114:
            r59.getClass();
            r59.j = new WeakReference(r9);
            if (r2.Q() == false) goto L117;
            r2.t0.b(-1);
            return;
        L117:
            r2.t0.b(-2);
            return;
        L118:
            th = move-exception;
            throw th;
        L122:
            if (r17.arg1 != 1) goto L124;
            boolean r61 = true;
        L126:
            if (r2.r0 == (-2)) goto L138;
            if (r2.r0 == 2) goto L138;
            if (r2.r0 == (-1)) goto L135;
            if (r2.r0 == 1) goto L135;
        L140:
            if (r61 == true) goto L142;
        L144:
            if (r6 == 0) goto L158;
            List<OnUpdateStatusChangedListener> r62 = r2.g0;
            monitor-enter(r62);
            Iterator r63 = ((ArrayList) r2.g0).iterator();     // Catch: Throwable -> L155
        L149:
            if (r63.hasNext() == false) goto L153;
            OnUpdateStatusChangedListener r64 = (OnUpdateStatusChangedListener) r63.next();     // Catch: Throwable -> L155
            if (r64 == null) goto L149;
            r64.c(1);     // Catch: Throwable -> L155
            goto L149
        L153:
            monitor-exit(r62);     // Catch: Throwable -> L155
        L168:
            if (r2.t0 != null) goto L170;
            r2.t0 = new e();
        L170:
            e r65 = r2.t0;
            h r66 = r2.i0;
            if (r66 == null) goto L173;
            r9 = r66;
        L173:
            r65.getClass();
            r65.j = new WeakReference(r9);
            if (r2.r0 != 2) goto L198;
            e r67 = r2.t0;
            IUpdateConfig r68 = f0.a;
            r67.b = r68;
            i0 r69 = r68.getUpdateConfig().a();
            if (r69 == null) goto L367;
            yhc.d r70 = r67.b.getUpdateConfig().f;
            if (r70 == null) goto L196;
            WeakReference<Activity> r71 = r70.getCurrentActivity();
            if (r71 == null) goto L368;
            Activity r72 = r71.get();
            if (r72 != null) goto L186;
            return;
        L186:
            if (r72.isFinishing() == false) goto L189;
            return;
        L189:
            if (r67.a.isCurrentVersionOut() == true) goto L192;
            return;
        L192:
            if (Logger.debug() == false) goto L194;
            Logger.i("UpdateShowServiceImpl", "tryShowBigDialog");
        L194:
            r67.k.postDelayed(new g0(r67, r72, r69, r61), r67.a.getLatency() * 1000);
            return;
        L368:
            return;
        L196:
            throw new IllegalArgumentException("iCurrentActivityCallback can not null");
        L367:
            return;
        L198:
            if (r2.r0 != 1) goto L360;
            e r73 = r2.t0;
            if (r2.Q() == true) goto L203;
            r11 = -2;
        L203:
            r73.b(r11);
            return;
        L360:
            return;
        L155:
            th = move-exception;
            throw th;
        L158:
            List<OnUpdateStatusChangedListener> r74 = r2.g0;
            monitor-enter(r74);
            Iterator r75 = ((ArrayList) r2.g0).iterator();     // Catch: Throwable -> L204
        L162:
            if (r75.hasNext() == false) goto L166;
            OnUpdateStatusChangedListener r76 = (OnUpdateStatusChangedListener) r75.next();     // Catch: Throwable -> L204
            if (r76 == null) goto L162;
            r76.c(-2);     // Catch: Throwable -> L204
            goto L162
        L166:
            monitor-exit(r74);     // Catch: Throwable -> L204
        L204:
            th = move-exception;
            throw th;
        L142:
            if (r2.p0.h == false) goto L144;
            p.b.a.a();
        L135:
            if (r2.Q() == false) goto L140;
        L139:
            r6 = 1;
        L138:
            if (r2.O() == false) goto L140;
        L124:
            r61 = false;
        }

        public a(d r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public class g extends AbsDownloadListener {
        public boolean a;
        public final /* synthetic */ d b;

        public g(d r1) {
            this.b = r1;
            this.a = false;
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener
        public final void onFirstSuccess(DownloadInfo r1) {
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        L3:
            if (this.a == true) goto L12;
            this.a = true;     // Catch: Exception -> L7
            this.b.q();     // Catch: Exception -> L7
            return;
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener
        public final void onSuccessed(DownloadInfo r1) {
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        L3:
            if (this.a == true) goto L12;
            this.a = true;     // Catch: Exception -> L7
            this.b.q();     // Catch: Exception -> L7
            return;
        }
    }

    public final Intent A() {
    L11:
        e = move-exception;
        Logger.d("UpdateHelper", e.getMessage(), e);
        return null;
    L4:
        if (TextUtils.isEmpty(this.j0) == false) goto L7;
        return null;
    L7:
        if (TextUtils.isEmpty(this.k0) == false) goto L9;
        return null;
    L9:
        Intent r1 = new Intent();     // Catch: Exception -> L11
        r1.setPackage(this.j0);     // Catch: Exception -> L11
        r1.setData(UriProtector.parse(this.k0));     // Catch: Exception -> L11
        r1.addFlags(268435456);     // Catch: Exception -> L11
        return r1;
    }

    public final synchronized int C() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.k == true) goto L6;
        U();     // Catch: Throwable -> L9
        this.k = true;     // Catch: Throwable -> L9
    L6:
        int r0 = this.u0;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public final synchronized int D() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.k == true) goto L6;
        U();     // Catch: Throwable -> L9
        this.k = true;     // Catch: Throwable -> L9
    L6:
        int r0 = this.S;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public final synchronized int F() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.k == true) goto L6;
        U();     // Catch: Throwable -> L9
        this.k = true;     // Catch: Throwable -> L9
    L6:
        int r0 = this.X;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public final synchronized String G() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.k == true) goto L6;
        U();     // Catch: Throwable -> L9
        this.k = true;     // Catch: Throwable -> L9
    L6:
        String r0 = this.u;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public final synchronized String H() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.k == true) goto L6;
        U();     // Catch: Throwable -> L9
        this.k = true;     // Catch: Throwable -> L9
    L6:
        String r0 = this.U;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public final synchronized PolarisFileWrapper I() {
        monitor-enter(this);
        PolarisFileWrapper r0 = J(false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized String K() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.k == true) goto L6;
        U();     // Catch: Throwable -> L9
        this.k = true;     // Catch: Throwable -> L9
    L6:
        String r0 = this.r;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public final synchronized boolean N() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.k == true) goto L6;
        U();     // Catch: Throwable -> L13
        this.k = true;     // Catch: Throwable -> L13
    L6:
        if (this.P != 0) goto L11;
        monitor-exit(this);
        return false;
    L11:
        monitor-exit(this);
        return true;
    }

    public final synchronized boolean O() {
        monitor-enter(this);
        boolean r1 = true;
        if (this.k == true) goto L7;
        U();     // Catch: Throwable -> L16
        this.k = true;     // Catch: Throwable -> L16
    L7:
        if (this.T != 1) goto L10;
        monitor-exit(this);
        return true;
    L10:
        if (this.m < this.n) goto L14;
        r1 = false;
    L14:
        monitor-exit(this);
        return r1;
    L16:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean P() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.k == true) goto L6;
        U();     // Catch: Throwable -> L9
        this.k = true;     // Catch: Throwable -> L9
    L6:
        boolean r0 = this.v;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public final synchronized boolean Q() {
        monitor-enter(this);
        boolean r1 = true;
        if (this.k == true) goto L6;
        U();     // Catch: Throwable -> L11
        this.k = true;     // Catch: Throwable -> L11
    L6:
        if (this.m < this.o) goto L9;
        r1 = false;
    L9:
        monitor-exit(this);
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean R() {
        monitor-enter(this);
        boolean r1 = true;
        if (this.k == true) goto L8;
        U();     // Catch: Throwable -> L31
        this.k = true;     // Catch: Throwable -> L31
    L8:
        if (this.H == this.o) goto L11;
        monitor-exit(this);
        return false;
    L11:
        long r4 = System.currentTimeMillis();     // Catch: Throwable -> L31
        PolarisFileWrapper r0 = new PolarisFileWrapper(this.g);     // Catch: Throwable -> L31
        if (r0.exists() == true) goto L14;
    L20:
        PolarisFileWrapper r2 = new PolarisFileWrapper(this.i);     // Catch: Throwable -> L31
        if (r2.exists() == true) goto L23;
    L28:
        r1 = false;
    L29:
        monitor-exit(this);
        return r1;
    L23:
        if (r2.isFile() == false) goto L28;
        if ((r4 - r2.lastModified()) >= 604800000) goto L28;
    L14:
        if (r0.isFile() == false) goto L20;
        if ((r4 - r0.lastModified()) >= DownloadConstants.DAY) goto L20;
        monitor-exit(this);
        return false;
    L31:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean T() {
        monitor-enter(this);
        boolean r0 = this.J;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean V() {
        monitor-enter(this);
        boolean r1 = true;
        if (this.k == true) goto L7;
        U();     // Catch: Throwable -> L14
        this.k = true;     // Catch: Throwable -> L14
    L7:
        if (this.C == false) goto L11;
        if (this.p0.s == false) goto L11;
    L12:
        monitor-exit(this);
        return r1;
    L11:
        r1 = false;
    L14:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean f() {
        monitor-enter(this);
        boolean r1 = true;
        if (this.k == true) goto L6;
        U();     // Catch: Throwable -> L13
        this.k = true;     // Catch: Throwable -> L13
    L6:
        int r0 = this.m;     // Catch: Throwable -> L13
        if (r0 < this.o) goto L11;
        if (r0 < this.n) goto L11;
        r1 = false;
    L11:
        monitor-exit(this);
        return r1;
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void r() {
        monitor-enter(this);
        PolarisFileWrapper r0 = new PolarisFileWrapper(this.h);     // Catch: Throwable -> L10
        if (r0.exists() == false) goto L6;
        r0.delete();     // Catch: Throwable -> L10
    L6:
        PolarisFileWrapper r1 = new PolarisFileWrapper(this.g);     // Catch: Throwable -> L10
        if (r1.exists() == false) goto L12;
        r1.delete();     // Catch: Throwable -> L10
    L12:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public final synchronized void s() {
        monitor-enter(this);
        PolarisFileWrapper r0 = new PolarisFileWrapper(this.j);     // Catch: Throwable -> L10
        if (r0.exists() == false) goto L6;
        r0.delete();     // Catch: Throwable -> L10
    L6:
        PolarisFileWrapper r1 = new PolarisFileWrapper(this.i);     // Catch: Throwable -> L10
        if (r1.exists() == false) goto L12;
        r1.delete();     // Catch: Throwable -> L10
    L12:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public final synchronized String u() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.k == true) goto L6;
        U();     // Catch: Throwable -> L9
        this.k = true;     // Catch: Throwable -> L9
    L6:
        String r0 = this.t;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public final synchronized boolean v() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.k == true) goto L7;
        U();     // Catch: Throwable -> L14
        this.k = true;     // Catch: Throwable -> L14
    L7:
        if (k() == false) goto L11;
        monitor-exit(this);
        return false;
    L11:
        boolean r0 = this.w;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r0;
    }

    public final synchronized String w() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.k == true) goto L6;
        U();     // Catch: Throwable -> L9
        this.k = true;     // Catch: Throwable -> L9
    L6:
        String r0 = this.y;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public final synchronized String z() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.k == true) goto L7;
        U();     // Catch: Throwable -> L14
        this.k = true;     // Catch: Throwable -> L14
    L7:
        if (TextUtils.isEmpty(this.q) == true) goto L11;
        String r0 = this.q;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r0;
    L11:
        String r1 = this.p;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r1;
    }

    public static d x() {
        if (B0 != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (B0 != null) goto L9;
        B0 = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return B0;
    }

    public final void U() {
        AppCommonContext r0 = this.s0;
        if (r0 == null) goto L6;
        this.m = r0.getUpdateVersionCode();
    L6:
        if (this.m >= 1) goto L8;
        this.m = 1;
    L8:
        SharedPreferences r1 = this.d.getSharedPreferences("update_info", 0);
        this.n = r1.getInt("tip_version_code", 0);
        this.o = r1.getInt("real_version_code", 0);
        this.p = r1.getString("tip_version_name", "");
        this.q = r1.getString("real_version_name", "");
        this.r = r1.getString("whats_new", "");
        this.s = r1.getLong("last_check_time", 0);
        this.u = r1.getString(DBDefinition.TITLE, "");
        this.l = r1.getString("download_url", "");
        this.v = r1.getBoolean("force_update", false);
        this.t = r1.getString("already_download_tips", "");
        this.C = r1.getBoolean("pre_download", false);
        this.D = r1.getInt("interval_since_notify_update", 2);
        this.E = r1.getLong("pre_download_max_wait_seconds", -1);
        this.F = r1.getInt("latency", 0);
        this.u0 = r1.getInt("official", 0);
        this.G = r1.getString("download_etag", "");
        this.H = r1.getInt("download_version", 0);
        this.I = r1.getInt("download_size", -1);
        this.M = r1.getInt("pre_download_size", -1);
        this.w = r1.getBoolean("bind_download_data", false);
        this.x = r1.getBoolean("hint_checked", false);
        this.y = r1.getString("hint_text", "");
        this.z = r1.getString(DBDefinition.NAME, "");
        this.A = r1.getString("package", "");
        this.B = r1.getString("bind_app_download_url", "");
        this.l0 = r1.getString("market_update_intent_tips", "");
        this.k0 = r1.getString("market_update_intent_url", "");
        this.j0 = r1.getString("market_update_package", "");
        this.m0 = r1.getBoolean("market_update_enable", false);
        this.P = r1.getInt("enable_client_strategy", 0);
        this.Q = r1.getString("distribute_id", "");
        this.R = r1.getInt("artifact_id", 0);
        this.S = r1.getInt("package_type", 0);
        this.T = r1.getInt("popup_type", -1);
        this.U = r1.getString("update_button_text", "");
        this.V = r1.getString(DBDefinition.MD5, "");
        this.X = r1.getInt("release_rule_id", 0);
        this.Y = r1.getInt("strategy_id", 0);
        this.Z = r1.getString(EffectConfiguration.KEY_CHANNEL, "");
        this.A0 = r1.getLong("last_any_dialog_show_time", 0);
    }

    public final void W() {
        yhc.a r0 = this.K;
        monitor-enter(r0);
        h r1 = this.L;     // Catch: Throwable -> L13
        if (r1 == null) goto L7;
        r1.v = true;     // Catch: Throwable -> L13
    L7:
        b r2 = this.o0;     // Catch: Throwable -> L13
        if (r2 == null) goto L19;
        r2.b = true;     // Catch: Throwable -> L13
        r2.e = null;     // Catch: Throwable -> L13
        Downloader.getInstance(r2.a).cancel(r2.c);     // Catch: Throwable -> L13
    L19:
        this.b.cancel(2131387150);     // Catch: Exception -> L16 Throwable -> L13
        this.b.cancel(2131387148);     // Catch: Exception -> L16 Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void a0() {
        SharedPreferences.Editor r0 = this.d.getSharedPreferences("update_info", 0).edit();
        r0.putInt("tip_version_code", this.n);
        r0.putInt("real_version_code", this.o);
        r0.putString("tip_version_name", this.p);
        r0.putString("real_version_name", this.q);
        r0.putString(DBDefinition.TITLE, this.u);
        r0.putString("download_url", this.l);
        r0.putString("whats_new", this.r);
        r0.putLong("last_check_time", this.s);
        r0.putBoolean("force_update", this.v);
        r0.putString("already_download_tips", this.t);
        r0.putBoolean("pre_download", this.C);
        r0.putInt("interval_since_notify_update", this.D);
        r0.putLong("pre_download_max_wait_seconds", this.E);
        r0.putInt("latency", this.F);
        r0.putInt("official", this.u0);
        r0.putBoolean("bind_download_data", this.w);
        r0.putBoolean("hint_checked", this.x);
        r0.putString("hint_text", this.y);
        r0.putString(DBDefinition.NAME, this.z);
        r0.putString("package", this.A);
        r0.putString("bind_app_download_url", this.B);
        r0.putString("market_update_package", this.j0);
        r0.putString("market_update_intent_tips", this.l0);
        r0.putString("market_update_intent_url", this.k0);
        r0.putBoolean("market_update_enable", this.m0);
        r0.putInt("enable_client_strategy", this.P);
        r0.putString("distribute_id", this.Q);
        r0.putInt("artifact_id", this.R);
        r0.putInt("package_type", this.S);
        r0.putInt("popup_type", this.T);
        r0.putString("update_button_text", this.U);
        r0.putString(DBDefinition.MD5, this.V);
        r0.putInt("release_rule_id", this.X);
        r0.putInt("strategy_id", this.Y);
        r0.putString(EffectConfiguration.KEY_CHANNEL, this.Z);
        SharedPrefsEditorCompat.apply(r0);
    }

    public final void f0() {
        if (TextUtils.isEmpty(this.B) == true) goto L45;
        if (TextUtils.isEmpty(this.z) == true) goto L45;
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L8
        r0.put("label", "detail_ad");     // Catch: Exception -> L8
        r0.put("ext_json", null);     // Catch: Exception -> L8
    L11:
        if (com.ss.android.common.app.permission.d.b != null) goto L13;
        com.ss.android.common.app.permission.d.b = new com.ss.android.common.app.permission.d();
    L13:
        com.ss.android.common.app.permission.d r1 = com.ss.android.common.app.permission.d.b;
        Context r2 = this.d;
        monitor-enter(r1);
        if (r2 != null) goto L51;
        monitor-exit(r1);
        boolean r3 = false;
    L39:
        if (r3 == false) goto L52;
        int r4 = q.a;
        String r5 = this.B;
        String r6 = this.z;
        Context r7 = this.d;
        g r8 = this.f0;
        AppTaskBuilder r9 = new AppTaskBuilder(r7, r5).name(r6).showNotification(true).needWifi(false).mainThreadListener(r8);
        AppDownloader.getInstance().addDownloadTask(r9);
        return;
    L52:
        return;
    L51:
    L41:
        th = move-exception;
        throw th;
    L20:
        if (DeviceUtils.isMiui() == false) goto L32;
        if (com.ss.android.common.app.permission.b.a(r2) == true) goto L24;
    L28:
        r3 = false;
    L29:
        monitor-exit(r1);
        goto L39
    L24:
        if (c.a(r2) != 0) goto L26;
    L27:
        r3 = true;
        goto L29
    L26:
        if (((HashSet) r1.a).contains("android.permission.WRITE_EXTERNAL_STORAGE") == true) goto L28;
    L32:
        if (c.a(r2) != 0) goto L34;
    L37:
        r3 = true;
    L38:
        monitor-exit(r1);
        goto L39
    L34:
        if (((HashSet) r1.a).contains("android.permission.WRITE_EXTERNAL_STORAGE") == false) goto L37;
        r3 = false;
    L8:
        e = move-exception;
        e.printStackTrace();
    L45:
        if (Logger.debug() == false) goto L47;
        Logger.d("UpdateHelper", "from startBindAppDownload has no Permission");
    L47:
        q();
    }

    public final boolean g() {
        if (this.m0 == true) goto L6;
        return false;
    L6:
        if (this.v == false) goto L9;
        return false;
    L9:
        if (this.C == false) goto L12;
        return false;
    L12:
        if (v() == false) goto L14;
        return false;
    L14:
        Intent r0 = A();
        if (r0 == null) goto L30;
        List<ResolveInfo> r1 = this.d.getPackageManager().queryIntentActivities(r0, 65536);     // Catch: Throwable -> L22
        if (r1 == null) goto L27;
        if (r1.size() <= 0) goto L28;
        return true;
    L28:
        return false;
    L27:
        return false;
    L22:
        th = move-exception;
        Logger.d("UpdateHelper", th.getMessage(), th);
        return false;
    L30:
        return false;
    }

    public final void h() {
        yhc.a r0 = this.K;
        monitor-enter(r0);
        h r1 = this.L;     // Catch: Throwable -> L12
        if (r1 == null) goto L7;
        r1.v = true;     // Catch: Throwable -> L12
    L7:
        b r2 = this.o0;     // Catch: Throwable -> L12
        if (r2 == null) goto L10;
        r2.b = true;     // Catch: Throwable -> L12
        r2.e = null;     // Catch: Throwable -> L12
        Downloader.getInstance(r2.a).cancel(r2.c);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final void i() {
        this.e.sendEmptyMessage(11);
    }

    public final void j() {
        this.e.sendEmptyMessage(10);
    }

    public final boolean k() {
        int r0 = q.a;
        Context r1 = this.d;
        String r2 = this.B;
        DownloadInfo r3 = AppDownloader.getInstance().getAppDownloadInfo(r1, r2);
        if (r3 != null) goto L6;
    L4:
        boolean r4 = false;
    L20:
        if (StringUtils.isEmpty(this.A) == true) goto L25;
        if (k.h(this.d, this.A) == false) goto L25;
        return false;
    L25:
        return r4;
    L6:
        if (TextUtils.isEmpty(r3.getSavePath()) == true) goto L4;
        if (TextUtils.isEmpty(r3.getName()) == true) goto L4;
        if (AppDownloadUtils.isApkInstalled(r1, r3.getSavePath(), r3.getName()) == true) goto L4;
        PolarisFileWrapper r5 = new PolarisFileWrapper(r3.getSavePath(), r3.getName());
        if (r3.getStatus() != (-3)) goto L4;
        if (r5.exists() == false) goto L4;
        r4 = true;
        goto L20
    }

    public final boolean l() {
        File r0 = new PolarisFileWrapper(this.i);
        if (r0.isFile() == true) goto L5;
    L6:
        r0 = new PolarisFileWrapper(this.g);
        if (r0.isFile() == true) goto L9;
    L25:
        c.a(6, "downloaded file not exist", null);
        Logger.w("UpdateHelper", "checkBgDownloadApkValid: downloaded file not exist");
        return false;
    L9:
        if (r0.exists() == false) goto L25;
    L10:
        String r1 = DigestUtils.md5Hex(r0);
        if (TextUtils.isEmpty(r1) == false) goto L13;
    L23:
        c.a(6, "md5 not match", null);
        Logger.w("UpdateHelper", "checkBgDownloadApkValid: md5 not match");
        return false;
    L13:
        if (TextUtils.isEmpty(this.V) == true) goto L23;
        if (r1.equalsIgnoreCase(this.V) == false) goto L23;
        if (SignUtils.checkSignature(this.d, r0.getPath()) == true) goto L21;
        c.a(6, "signature not match", null);
        Logger.w("UpdateHelper", "checkBgDownloadApkValid: signature not match");
        return false;
    L21:
        return true;
    L5:
        if (r0.exists() == true) goto L10;
        goto L6
    }

    public final void q() {
        f r0 = this.e0;
        if (r0 == null) goto L11;
        CountDownLatch r1 = r0.a;
        if (r1 == null) goto L13;
        r1.countDown();
        if (Logger.debug() == false) goto L12;
        Logger.d("UpdateHelper", "countDown current count = " + r0.a.getCount());
        return;
    L12:
        return;
    L13:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v20, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v22, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v24, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r3v17, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v18, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x022d -> B:69:0x0244). Please report as a decompilation issue!!! */
    public d() {
        this.a = true;
        PolarisFileWrapper r0 = null;
        this.d = null;
        this.k = false;
        ?? r2 = "";
        this.l = "";
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = "";
        this.q = "";
        this.r = "";
        this.s = 0;
        this.t = "";
        this.u = "";
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = "";
        this.z = "";
        this.A = "";
        this.B = "";
        this.C = false;
        this.D = 2;
        this.E = -1;
        this.F = 0;
        this.G = "";
        this.H = 0;
        this.I = 0;
        this.J = false;
        this.L = null;
        this.M = 0;
        this.N = false;
        this.P = 0;
        this.Q = "";
        this.R = 0;
        this.S = 0;
        this.T = -1;
        this.U = "";
        this.V = "";
        this.W = false;
        this.X = 0;
        this.Y = 0;
        this.Z = "";
        this.a0 = 0;
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = "";
        this.e0 = null;
        this.f0 = new g(this);
        this.g0 = new ArrayList();
        this.j0 = "";
        this.k0 = "";
        this.l0 = "";
        this.m0 = false;
        this.r0 = 2;
        int r6 = 3;
        this.v0 = null;
        this.w0 = null;
        this.x0 = null;
        this.y0 = false;
        this.z0 = "";
        this.A0 = 0;
        IUpdateConfig r3 = f0.a;
        this.n0 = r3;
        AppCommonContext r4 = f0.c;
        this.s0 = r4;
        if (r3 == null) goto L5;
        v r5 = r3.getUpdateConfig();
        this.p0 = r5;
        r5.getClass();
    L5:
        this.p0.getClass();
        this.q0 = PThreadExecutorsUtils.newFixedThreadPool(2, new DefaultThreadFactory("/UpdateHelper"));
        if (r4 == null) goto L8;
        this.d = r4.getContext().getApplicationContext();
    L12:
        SharedPreferences r7 = this.d.getSharedPreferences("update_info", 0);
        this.a0 = r7.getInt("persistent_release_rule_id", 0);
        this.b0 = r7.getInt("persistent_strategy_id", 0);
        this.d0 = r7.getString("persistent_channel", "");
        this.c0 = r7.getInt("persistent_tip_version_code", 0);
        Context r8 = this.d;
        this.o0 = new b(r8);
        NotificationManager r9 = (NotificationManager) r8.getSystemService("notification");
        this.b = r9;
        if (Build.VERSION.SDK_INT < 26) goto L25;
        v r10 = this.p0;
        if (r10 != null) goto L17;
    L19:
        if (r10 != null) goto L21;
    L23:
        String r11 = "update_channel_name";
    L24:
        NotificationChannel r12 = new NotificationChannel("update_channel_01", r11, r6);
        r12.enableVibration(false);
        r12.setSound(null, null);
        r9.createNotificationChannel(r12);
        goto L25
    L21:
        if (TextUtils.isEmpty(null) == true) goto L23;
        this.p0.getClass();
        r11 = null;
        goto L24
    L17:
        if (r10.r == false) goto L19;
        r6 = 0;
    L25:
        this.e = new a(this, Looper.getMainLooper());
        ?? r13 = this.d;
        v r14 = this.p0;
        ?? r15 = r2;
        ?? r16 = r13;
        if (r14 == null) goto L83;
        r15 = r2;
        r16 = r13;
        if (TextUtils.isEmpty(r14.q) == true) goto L83;
        PolarisFileWrapper r17 = new PolarisFileWrapper(r14.q);     // Catch: Exception -> L38
        if (r17.exists() == true) goto L32;
    L34:
        r15 = r2;
        r16 = r13;
        if (r17.mkdirs() == false) goto L83;
        String r1 = r17.getAbsolutePath();     // Catch: Exception -> L38
    L69:
        this.f = r1;
        ?? r18 = new StringBuilder();
        r18.append(r1);
        r13 = File.separator;
        r18.append(r13);
        r18.append("update.apk");
        this.g = r18.toString();
        this.h = r1 + r13 + "update.apk.part";
        this.i = r1 + r13 + "predownload.apk";
        r2 = new StringBuilder();
        r2.append(r1);
        r2.append(r13);
        r2.append("predownload.apk.part");
        this.j = r2.toString();
        yhc.a r19 = new yhc.a();
        this.K = r19;
        r19.c = 0;
        r19.a = 0;
        r19.b = 0;
        r0 = new yhc.a();
        this.O = r0;
        r0.c = 0;
        r0.a = 0;
        r0.b = 0;
        this.b.cancel(2131387150);     // Catch: Exception -> L76
        return;
    L86:
        return;
    L32:
        if (r17.isDirectory() == false) goto L34;
        r1 = r17.getAbsolutePath();     // Catch: Exception -> L38
    L38:
        e = move-exception;
        e.printStackTrace();
        r15 = r2;
        r16 = r13;
    L83:
        r1 = Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + r16.getPackageName() + "/files";     // Catch: Exception -> L42
    L64:
        if (r1.isEmpty() == true) goto L69;
        PolarisFileWrapper r20 = new PolarisFileWrapper(r1, "update");
        if (r20.exists() == true) goto L68;
        r20.mkdirs();
    L68:
        r1 = r20.getPath();
        goto L69
    L85:
        r1 = r20.getPath();
    L42:
        e = move-exception;
        e.printStackTrace();
        ?? r21 = Environment.getExternalStorageState();     // Catch: Throwable -> L46
    L48:
        if ("mounted".equals(r21) == false) goto L55;
        PolarisFileWrapper r22 = new PolarisFileWrapper(new PolarisFileWrapper(new PolarisFileWrapper(new PolarisFileWrapper(Environment.getExternalStorageDirectory(), "Android"), "data"), r16.getPackageName()), "cache");
        if (r22.exists() == false) goto L52;
    L54:
        r0 = r22;
        goto L55
    L52:
        if (r22.mkdirs() == true) goto L54;
    L55:
        if (r0 != null) goto L57;
        r0 = r16.getCacheDir();
    L57:
        if (r0 != null) goto L60;
        r0 = new PolarisFileWrapper("/data/data/" + r16.getPackageName() + "/cache/");
    L60:
        if (r0.exists() == true) goto L62;
        r0.mkdirs();
    L62:
        r1 = r0.getPath();
    L46:
        r21 = r15;
        goto L48
    L8:
        AppCommonContext r23 = this.p0.b;
        if (r23 == null) goto L75;
        if (r23 == null) goto L73;
        this.s0 = r23;
        this.d = r23.getContext().getApplicationContext();
        goto L12
    L73:
        throw new IllegalArgumentException("appContext can not null");
    L75:
        throw new IllegalArgumentException("appContext can not null");
    }

    public static String X(String r4) {
        if (r4 != null) goto L4;
        return "";
    L4:
        if (r4.length() == 0) goto L14;
        String[] r5 = r4.split("\\\\n");
        StringBuilder r0 = new StringBuilder();
        int r1 = r5.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L10;
        r0.append(r5[r2].trim());
        r0.append("\n");
        r2 = r2 + 1;
        goto L7
    L10:
        return r0.toString();
    L14:
        return "";
    }

    public final Notification B(int r11) {
        AppCommonContext r0 = this.s0;
        if (r0 == null) goto L5;
        String r1 = r0.getStringAppName();
    L6:
        String r2 = String.format(this.d.getString(2131914151), new Object[]{r1, z()});
        String r3 = "" + r11 + "%";
        Intent r4 = new Intent();
        PendingIntent r5 = null;
        if (TextUtils.isEmpty(null) == false) goto L9;
        r4.setClassName(this.d, UpdateProgressActivity.class.getName());
    L13:
        r4.addFlags(536870912);
        if (Build.VERSION.SDK_INT < 23) goto L16;
        int r7 = 67108864;
    L17:
        PendingIntent r6 = PendingIntent.getActivity(this.d, 0, r4, r7);
        v r8 = this.p0;
        if (r8 != null) goto L20;
    L22:
        r5 = r6;
    L24:
        if (r11 == 0) goto L30;
        NotificationCompat.Builder r9 = this.c;
        if (r9 == null) goto L30;
        r9.setContentTitle(r2).setContentInfo(r3).setProgress(100, r11, false);
        return r9.build();
    L30:
        NotificationCompat.Builder r10 = new NotificationCompat.Builder(this.d);
        this.c = r10;
        r10.setChannelId("update_channel_01");
        NotificationCompat.Builder r12 = this.c;
        r12.setSmallIcon(R.drawable.stat_sys_download).setTicker(r1).setWhen(System.currentTimeMillis()).setOngoing(true).setContentIntent(r5);
        r12.setContentTitle(r2).setContentInfo(r3).setProgress(100, r11, false);
        return r12.build();
    L20:
        if (r8.g == false) goto L22;
    L16:
        r7 = 0;
        goto L17
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.d("UpdateHelper", "iUpdateActivity.getClass().getName() null");
    L11:
        r4.setClassName(this.d, null);
        goto L13
    L5:
        r1 = "";
        goto L6
    }

    public final void E(yhc.a r4) {
        yhc.a r0 = this.K;
        monitor-enter(r0);
        yhc.a r1 = this.K;     // Catch: Throwable -> L7
        r4.c = r1.c;     // Catch: Throwable -> L7
        r4.a = r1.a;     // Catch: Throwable -> L7
        r4.b = r1.b;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized PolarisFileWrapper J(boolean r13) {
        monitor-enter(this);
        d0(r13);     // Catch: Throwable -> L44
        if (this.k == true) goto L47;
        U();     // Catch: Throwable -> L44
        this.k = true;     // Catch: Throwable -> L44
    L47:
        long r4 = System.currentTimeMillis();     // Catch: Throwable -> L40
        SharedPreferences r6 = this.d.getSharedPreferences("update_info", 0);     // Catch: Throwable -> L40
        PolarisFileWrapper r7 = new PolarisFileWrapper(this.g);     // Catch: Throwable -> L40
        if (r7.exists() == false) goto L22;
        String r3 = r6.getString("md5_" + r7.getAbsolutePath(), null);     // Catch: Throwable -> L40
        Logger.i("UpdateHelper", "realVersion:" + this.q + ",downloadVersion:" + this.H + ",md5" + this.V + ",fileMd5:" + r3);     // Catch: Throwable -> L40
        if (TextUtils.isEmpty(r3) == false) goto L13;
    L21:
        r7.delete();     // Catch: Throwable -> L40
        goto L22
    L13:
        if (TextUtils.isEmpty(this.V) == true) goto L21;
        if (r3.equals(this.V) == false) goto L21;
        if (this.H != this.o) goto L21;
        if ((r4 - r7.lastModified()) >= DownloadConstants.DAY) goto L21;
    L23:
        PolarisFileWrapper r1 = new PolarisFileWrapper(this.i);     // Catch: Throwable -> L40
        if (r1.exists() == false) goto L38;
        String r2 = r6.getString("md5_" + r1.getAbsolutePath(), null);     // Catch: Throwable -> L40
        Logger.i("UpdateHelper", "realVersion:" + this.q + ",downloadVersion:" + this.H + ",md5" + this.V + ",preFileMd5:" + r2);     // Catch: Throwable -> L40
        if (TextUtils.isEmpty(r2) == false) goto L28;
    L37:
        r1.delete();     // Catch: Throwable -> L40
    L28:
        if (TextUtils.isEmpty(this.V) == true) goto L37;
        if (r2.equals(this.V) == false) goto L37;
        if (this.H != this.o) goto L37;
        if ((r4 - r1.lastModified()) >= 604800000) goto L37;
        if (r7 != null) goto L38;
        r7 = r1;
    L38:
        monitor-exit(this);
        return r7;
    L22:
        r7 = null;
    L40:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L44
        return null;
    L44:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public final boolean M(boolean r44) {
        if (this.p0.o == true) goto L5;
        return false;
    L5:
        JSONObject r5 = new JSONObject();
        p r7 = p.b.a;     // Catch: Throwable -> L27
        if (r7.f() == true) goto L13;
        c.d(this.l, this.o, false, "ping_fail", "ping_fail");     // Catch: Throwable -> L27
        this.y0 = false;     // Catch: Throwable -> L27
        if (this.d == null) goto L12;
        yhc.b.a("app_update_check", r5);
    L12:
        return false;
    L13:
        StringBuilder r8 = new StringBuilder("https://ichannel.snssdk.com/check_version/v7/");     // Catch: Throwable -> L27
        Context r9 = this.d;     // Catch: Throwable -> L27
        if (r9 != null) goto L16;
    L18:
        Context r10 = this.d;     // Catch: Throwable -> L27
        if (r10 == null) goto L29;
        v r11 = this.p0;     // Catch: Throwable -> L27
        if (r11 == null) goto L29;
        if (r11.m == false) goto L29;
        if (TextUtils.isEmpty(r10.getPackageName()) == true) goto L29;
        r8.append("&package_name=");     // Catch: Throwable -> L27
        r8.append(this.d.getPackageName());     // Catch: Throwable -> L27
    L29:
        v r12 = this.p0;     // Catch: Throwable -> L27
        String r13 = k0.b();     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r13) == true) goto L32;
        r8.append("&cpu_abi=");     // Catch: Throwable -> L27
        r8.append(r13);     // Catch: Throwable -> L27
    L32:
        r8.append("&app_extra=");     // Catch: Throwable -> L27
        r8.append(this.z0);     // Catch: Throwable -> L27
        if (r44 == false) goto L35;
        String r14 = "1";
    L36:
        r8.append("&call_type=");     // Catch: Throwable -> L27
        r8.append(r14);     // Catch: Throwable -> L27
        v r15 = this.p0;     // Catch: Throwable -> L27
        if (r15 != null) goto L39;
    L41:
        String r16 = "0";
    L42:
        r8.append("&package_type=");     // Catch: Throwable -> L27
        r8.append(r16);     // Catch: Throwable -> L27
        c.q(Integer.parseInt(r16));     // Catch: Throwable -> L27
        if (r7.e() == false) goto L45;
        String r17 = "1";
    L46:
        r8.append("&inhouse_network=");     // Catch: Throwable -> L27
        r8.append(r17);     // Catch: Throwable -> L27
        r7.getClass();     // Catch: Throwable -> L27
        String r18 = p.c();     // Catch: Throwable -> L27
        r8.append("&inhouse_network_attr=");     // Catch: Throwable -> L27
        r8.append(r18);     // Catch: Throwable -> L27
        r7.getClass();     // Catch: Throwable -> L27
        r8.append("&enable_intranet_guide=0&is_local_installed=");     // Catch: Throwable -> L27
        c.n(Integer.parseInt("0"));     // Catch: Throwable -> L27
        r7.getClass();     // Catch: Throwable -> L27
        if (p.d() == false) goto L49;
        String r0 = "1";
    L50:
        r8.append(r0);     // Catch: Throwable -> L27
        c.o(Integer.parseInt(r0));     // Catch: Throwable -> L27
        if (r7.e == false) goto L53;
        String r1 = "1";
    L54:
        r8.append("&enable_normal_popup=");     // Catch: Throwable -> L27
        r8.append(r1);     // Catch: Throwable -> L27
        c.p(Integer.parseInt(r1));     // Catch: Throwable -> L27
        String r2 = "";
        AppCommonContext r19 = this.s0;     // Catch: Throwable -> L27
        if (r19 == null) goto L57;
        this.m = r19.getUpdateVersionCode();     // Catch: Throwable -> L27
        r2 = this.s0.getChannel();     // Catch: Throwable -> L27
    L57:
        SharedPreferences r20 = this.d.getSharedPreferences("update_info", 0);     // Catch: Throwable -> L27
        int r21 = r20.getInt("tip_version_code", 0);     // Catch: Throwable -> L27
        this.n = r21;     // Catch: Throwable -> L27
        if (r21 != this.m) goto L61;
        this.a0 = r20.getInt("release_rule_id", 0);     // Catch: Throwable -> L27
        this.b0 = r20.getInt("strategy_id", 0);     // Catch: Throwable -> L27
        this.c0 = this.n;     // Catch: Throwable -> L27
        this.d0 = r20.getString(EffectConfiguration.KEY_CHANNEL, "");     // Catch: Throwable -> L27
        r20.edit().putInt("persistent_release_rule_id", this.a0).putInt("persistent_strategy_id", this.b0).putInt("persistent_tip_version_code", this.c0).putString("persistent_channel", this.d0).apply();     // Catch: Throwable -> L27
    L61:
        if (this.c0 == this.m) goto L63;
    L66:
        r8.append("&release_rule_id=0&strategy_id=0");     // Catch: Throwable -> L27
    L67:
        v r3 = this.p0;     // Catch: Throwable -> L27
        if (r3 != null) goto L70;
    L72:
        String r4 = r8.toString();     // Catch: Throwable -> L27
        l0.a(r5, "request", r4);     // Catch: Throwable -> L27
        Pair r6 = n.a();     // Catch: Throwable -> L27
        if (r6 == null) goto L75;
        ArrayList r22 = new ArrayList();     // Catch: Throwable -> L27
        r22.add(new eua.a((String) r6.first, (String) r6.second));     // Catch: Throwable -> L27
    L76:
        String r23 = ita.i.a(8192, r4, r22);     // Catch: Throwable -> L27
        if (StringUtils.isEmpty(r23) == false) goto L83;
        c.b(0);     // Catch: Throwable -> L27
        c.d(this.l, this.o, false, "check_fail", r5.toString());     // Catch: Throwable -> L27
        this.y0 = false;     // Catch: Throwable -> L27
        if (this.d == null) goto L82;
        yhc.b.a("app_update_check", r5);
    L82:
        return false;
    L83:
        l0.a(r5, "respone", r23);     // Catch: Throwable -> L27
        JSONObject r24 = new JSONObject(r23);     // Catch: Throwable -> L27
        if ("success".equals(r24.getString("message")) == true) goto L91;
        c.b(1);     // Catch: Throwable -> L27
        c.d(this.l, this.o, false, "check_fail", r5.toString());     // Catch: Throwable -> L27
        this.y0 = false;     // Catch: Throwable -> L27
        if (this.d == null) goto L89;
        yhc.b.a("app_update_check", r5);
    L89:
        return false;
    L91:
        c.b(-1);     // Catch: Throwable -> L27
        JSONObject r25 = r24.getJSONObject("data");     // Catch: Throwable -> L27
        int r26 = r25.optInt("tip_version_code", -1);     // Catch: Throwable -> L27
        String r27 = r25.optString("tip_version_name");     // Catch: Throwable -> L27
        String r110 = r25.optString("real_version_name");     // Catch: Throwable -> L27
        int r111 = r25.optInt("real_version_code", -1);     // Catch: Throwable -> L27
        String r112 = r25.optString("download_url");     // Catch: Throwable -> L27
        String r113 = r25.optString("whats_new", "");     // Catch: Throwable -> L27
        String r114 = r25.optString(DBDefinition.TITLE, "");     // Catch: Throwable -> L27
        if (r25.optInt("force_update", 0) != 1) goto L94;
        boolean r115 = true;
    L95:
        String r28 = r25.optString("already_download_tips", "");     // Catch: Throwable -> L27
        if (r25.optInt("pre_download", 0) != 1) goto L98;
        boolean r29 = true;
    L99:
        int r30 = r25.optInt("interval_since_notify_update", 2);     // Catch: Throwable -> L27
        boolean r116 = r29;
        long r31 = r25.optLong("pre_download_max_wait_seconds", -1);     // Catch: Throwable -> L27
        int r32 = r25.optInt("latency", 0);     // Catch: Throwable -> L27
        int r33 = r25.optInt("official", 0);     // Catch: Throwable -> L27
        int r34 = r25.optInt("enable_client_strategy", 0);     // Catch: Throwable -> L27
        String r35 = r25.optString("distribute_id", "");     // Catch: Throwable -> L27
        int r36 = r25.optInt("artifact_id", 0);     // Catch: Throwable -> L27
        int r37 = r25.optInt("package_type", 0);     // Catch: Throwable -> L27
        int r38 = r25.optInt("popup_type", -1);     // Catch: Throwable -> L27
        String r39 = r25.optString("update_button_text", "");     // Catch: Throwable -> L27
        String r40 = r25.optString(DBDefinition.MD5, "");     // Catch: Throwable -> L27
        int r41 = r25.optInt("release_rule_id", 0);     // Catch: Throwable -> L27
        int r42 = r25.optInt("strategy_id", 0);     // Catch: Throwable -> L27
        String r43 = r25.optString(EffectConfiguration.KEY_CHANNEL, "");     // Catch: Throwable -> L27
        String r310 = "";
        String r311 = "";
        String r312 = "";
        JSONObject r45 = r25.optJSONObject("market_update");     // Catch: Throwable -> L118
        String r313 = r43;
        int r314 = r42;
        if (r25.optInt("market_update_enable", 0) <= 0) goto L107;
        boolean r46 = true;
    L108:
        if (r45 != null) goto L198;
    L113:
        String r47 = r310;
        String r315 = r312;
        boolean r316 = r46;
        String r48 = r311;
    L122:
        String r317 = "";
        String r318 = "";
        String r319 = "";
        String r320 = "";
        boolean r321 = r25.has("bind_download_data");     // Catch: Throwable -> L27 Exception -> L147
        JSONObject r49 = r25.optJSONObject("bind_download_data");     // Catch: Throwable -> L27 Exception -> L145
        if (r49 != null) goto L127;
        String r410 = r48;
        String r50 = "";
        String r51 = "";
        String r322 = "";
        String r411 = "";
        boolean r52 = true;
    L144:
        String r323 = r47;
        boolean r53 = r321;
        if (r26 > 0) goto L154;
    L160:
        monitor-enter(this);     // Catch: Throwable -> L27
    L171:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L162:
        if (this.k == true) goto L164;
        U();     // Catch: Throwable -> L171
        this.k = true;     // Catch: Throwable -> L171
    L164:
        this.n = r26;     // Catch: Throwable -> L171
        this.o = r111;     // Catch: Throwable -> L171
        this.p = r27;     // Catch: Throwable -> L171
        this.q = r110;     // Catch: Throwable -> L171
        this.l = r112;     // Catch: Throwable -> L171
        this.r = r113;     // Catch: Throwable -> L171
        this.s = System.currentTimeMillis();     // Catch: Throwable -> L171
        this.u = r114;     // Catch: Throwable -> L171
        this.v = r115;     // Catch: Throwable -> L171
        this.t = r28;     // Catch: Throwable -> L171
        this.C = r116;     // Catch: Throwable -> L171
        this.D = r30;     // Catch: Throwable -> L171
        this.E = r31;     // Catch: Throwable -> L171
        this.F = r32;     // Catch: Throwable -> L171
        this.u0 = r33;     // Catch: Throwable -> L171
        this.w = r53;     // Catch: Throwable -> L171
        this.x = r52;     // Catch: Throwable -> L171
        this.y = r50;     // Catch: Throwable -> L171
        this.z = r51;     // Catch: Throwable -> L171
        this.A = r322;     // Catch: Throwable -> L171
        this.B = r411;     // Catch: Throwable -> L171
        this.j0 = r323;     // Catch: Throwable -> L171
        this.k0 = r410;     // Catch: Throwable -> L171
        this.l0 = r315;     // Catch: Throwable -> L171
        this.m0 = r316;     // Catch: Throwable -> L171
        this.P = r34;     // Catch: Throwable -> L171
        this.Q = r35;     // Catch: Throwable -> L171
        this.R = r36;     // Catch: Throwable -> L171
        this.S = r37;     // Catch: Throwable -> L171
        this.T = r38;     // Catch: Throwable -> L171
        this.U = r39;     // Catch: Throwable -> L171
        this.V = r40;     // Catch: Throwable -> L171
        this.X = r41;     // Catch: Throwable -> L171
        this.Y = r314;     // Catch: Throwable -> L171
        this.Z = r313;     // Catch: Throwable -> L171
        a0();     // Catch: Throwable -> L171
        monitor-exit(this);     // Catch: Throwable -> L171
        Logger.i("UpdateHelper", "update info: latest version " + this.n + " " + this.o + ", now " + this.m);     // Catch: Throwable -> L27
        boolean r54 = S(r44);     // Catch: Throwable -> L27
        if (this.d == null) goto L170;
        yhc.b.a("app_update_check", r5);
    L170:
        return r54;
    L154:
        if (URLUtil.isValidUrl(r112) == true) goto L160;
        l0.a(r5, "errorMsg", "url is not valid:" + r112);     // Catch: Throwable -> L27
        c.d(this.l, this.o, false, "check_fail", r5.toString());     // Catch: Throwable -> L27
        this.y0 = false;     // Catch: Throwable -> L27
        if (this.d == null) goto L159;
        yhc.b.a("app_update_check", r5);
    L159:
        return false;
    L127:
        r410 = r48;
        if (r49.optInt("hint_checked", 1) != 1) goto L131;
        boolean r55 = true;
    L133:
        boolean r412 = r55;
        r317 = r49.optString("hint_text", "");     // Catch: Throwable -> L27 Exception -> L136
        r318 = r49.optString(DBDefinition.NAME, "");     // Catch: Throwable -> L27 Exception -> L136
        r319 = r49.optString("package", "");     // Catch: Throwable -> L27 Exception -> L136
        r320 = r49.optString("bind_app_download_url");     // Catch: Throwable -> L27 Exception -> L136
    L151:
        r50 = r317;
        r51 = r318;
        r322 = r319;
        r411 = r320;
        r52 = r412;
    L136:
        e = e;
        boolean r56 = r412;
    L150:
        r412 = r56;
        Logger.d("UpdateHelper", e.getMessage(), e);     // Catch: Throwable -> L27
        goto L151
    L131:
        r55 = false;
    L141:
        e = e;
    L149:
        r56 = true;
    L145:
        e = e;
        r410 = r48;
    L147:
        e = e;
        r410 = r48;
        r321 = false;
        goto L149
    L198:
        r310 = r45.optString("market_update_package");     // Catch: Throwable -> L111
        r311 = r45.optString("market_update_intent_url");     // Catch: Throwable -> L111
        r312 = r45.optString("market_update_intent_tips");     // Catch: Throwable -> L111
    L111:
        th = th;
    L121:
        boolean r324 = r46;
        Logger.d("UpdateHelper", th.getMessage(), th);     // Catch: Throwable -> L27
        r47 = r310;
        r48 = r311;
        r315 = "";
        r316 = r324;
        goto L122
    L107:
        r46 = false;
    L114:
        th = th;
    L120:
        r46 = false;
    L118:
        th = th;
        r313 = r43;
        r314 = r42;
        goto L120
    L98:
        r29 = false;
        goto L99
    L94:
        r115 = false;
        goto L95
    L75:
        r22 = null;
        goto L76
    L70:
        if (StringUtils.isEmpty(r3.n) == true) goto L72;
        r8.append(this.p0.n);     // Catch: Throwable -> L27
        goto L72
    L63:
        if (r2.equals(this.d0) == false) goto L66;
        r8.append("&release_rule_id=");     // Catch: Throwable -> L27
        r8.append(this.a0);     // Catch: Throwable -> L27
        r8.append("&strategy_id=");     // Catch: Throwable -> L27
        r8.append(this.b0);     // Catch: Throwable -> L27
        goto L67
    L53:
        r1 = "0";
        goto L54
    L49:
        r0 = "0";
        goto L50
    L45:
        r17 = "0";
        goto L46
    L39:
        if (r15.h == false) goto L41;
        r16 = "1";
        goto L42
    L35:
        r14 = "0";
        goto L36
    L16:
        if (r9.getApplicationInfo() == null) goto L18;
        r8.append("?target_sdk_version=");     // Catch: Throwable -> L27
        r8.append(String.valueOf(this.d.getApplicationInfo().targetSdkVersion));     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Logger.w("UpdateHelper", "check update error: " + th);     // Catch: Throwable -> L184
        int r57 = q.a;     // Catch: Throwable -> L184
        int r58 = q.a(this.d, th);     // Catch: Throwable -> L184
        if (18 == r58) goto L177;
        l0.a(r5, "errorCode", Integer.valueOf(r58));     // Catch: Throwable -> L184
    L178:
        c.d(r5.optString("request"), this.o, false, "check_fail", r5.toString());     // Catch: Throwable -> L184
        if (this.d == null) goto L182;
        yhc.b.a("app_update_check", r5);
    L182:
        this.y0 = false;
        return false;
    L177:
        l0.a(r5, "errorMsg", th.getMessage());     // Catch: Throwable -> L184
    L184:
        th = move-exception;
        if (this.d == null) goto L188;
        yhc.b.a("app_update_check", r5);
    L188:
        throw th;
    }

    public final boolean S(boolean r10) {
        int r0 = this.T;
        if (r0 == 2) goto L6;
        if (r0 == 0) goto L6;
    L15:
        if (this.T == 1) goto L17;
    L22:
        int r1 = this.T;
        if (r1 == 0) goto L73;
        if (r1 == 1) goto L73;
        if (r1 != 2) goto L32;
        if (p.b.a.e == true) goto L32;
        c.k(UpdateService.REASON_NO_NORMAL_GUIDE);
        this.y0 = false;
        return false;
    L32:
        if (StringUtils.isEmpty(this.l) == false) goto L36;
        c.k("reason_no_updating_url_from_server");
        this.y0 = false;
        return false;
    L36:
        if (this.p0.h == false) goto L46;
        if (this.S == 1) goto L42;
        c.k("reason_local_package_should_not_upgrade_to_other_package");
        this.y0 = false;
        return false;
    L42:
        if (p.b.a.e() == true) goto L46;
        c.k("reason_local_package_should_not_work_out_of_house");
        this.y0 = false;
        return false;
    L46:
        if (this.k == true) goto L57;
        monitor-enter(this);
    L53:
        th = move-exception;
        throw th;
    L49:
        if (this.k == true) goto L51;
        U();     // Catch: Throwable -> L53
        this.k = true;     // Catch: Throwable -> L53
    L51:
        monitor-exit(this);     // Catch: Throwable -> L53
    L57:
        if (this.v == true) goto L63;
        if (r10 == false) goto L63;
        long r2 = System.currentTimeMillis();
        long r5 = this.p0.l;
        if ((r2 - this.A0) >= r5) goto L63;
        boolean r11 = true;
    L64:
        if (r11 == false) goto L68;
        c.k(UpdateService.REASON_LOCAL_LIMIT_BLOCK_DIALOG);
        this.y0 = false;
        return false;
    L68:
        if (O() == true) goto L71;
        c.k(UpdateService.REASON_CHECK_VERSION_CODE_FAIL);
        this.y0 = false;
        return false;
    L71:
        this.y0 = true;
        return true;
    L63:
        r11 = false;
    L73:
        p.b.a.getClass();
        c.k(UpdateService.REASON_NO_LOCAL_GUIDE);
        this.y0 = false;
        return false;
    L17:
        if (TextUtils.isEmpty(this.u) == false) goto L19;
    L20:
        c.k(UpdateService.REASON_LACK_INFORMATION_NORMAL);
        this.y0 = false;
        return false;
    L19:
        if (TextUtils.isEmpty(this.r) == false) goto L22;
    L6:
        if (TextUtils.isEmpty(this.u) == false) goto L8;
    L75:
        c.k(UpdateService.REASON_LACK_INFORMATION_NORMAL);
        this.y0 = false;
        return false;
    L8:
        if (this.o == (-1)) goto L75;
        if (this.n == (-1)) goto L75;
        if (TextUtils.isEmpty(this.r) == false) goto L15;
        goto L75
    }

    public final void Y(OnUpdateStatusChangedListener r3) {
        monitor-enter(this);
        List<OnUpdateStatusChangedListener> r0 = this.g0;     // Catch: Throwable -> L12
        monitor-enter(r0);     // Catch: Throwable -> L12
        ((ArrayList) this.g0).remove(r3);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // yhc.i
    public final void b(boolean r4) {
        List<OnUpdateStatusChangedListener> r0 = this.g0;
        monitor-enter(r0);
        Iterator r1 = ((ArrayList) this.g0).iterator();     // Catch: Throwable -> L13
    L6:
        if (r1.hasNext() == false) goto L10;
        OnUpdateStatusChangedListener r2 = (OnUpdateStatusChangedListener) r1.next();     // Catch: Throwable -> L13
        if (r2 == null) goto L6;
        r2.b(r4);     // Catch: Throwable -> L13
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L13
        h r5 = new h(this);
        this.L = r5;
        ThreadMethodProxy.start(r5);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void c0(boolean r4) {
        if (this.k == true) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.k == true) goto L8;
        U();     // Catch: Throwable -> L10
        this.k = true;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        if (this.v == true) goto L21;
        if (r4 == false) goto L22;
        this.A0 = System.currentTimeMillis();
        SharedPreferences.Editor r5 = this.d.getSharedPreferences("update_info", 0).edit();
        r5.putLong("last_any_dialog_show_time", this.A0);
        SharedPrefsEditorCompat.apply(r5);
        return;
    L22:
        return;
    }

    public final void d0(boolean r3) {
        if (r3 == false) goto L4;
        this.a = false;
        StringBuilder r4 = new StringBuilder();
        r4.append(this.f);
        String r0 = File.separator;
        r4.append(r0);
        r4.append("update_alpha.apk");
        this.g = r4.toString();
        this.h = this.f + r0 + "update_alpha.apk.part";
        return;
    L4:
        StringBuilder r5 = new StringBuilder();
        r5.append(this.f);
        String r1 = File.separator;
        r5.append(r1);
        r5.append("update.apk");
        this.g = r5.toString();
        this.h = this.f + r1 + "update.apk.part";
        if (this.a == true) goto L9;
        this.a = true;
        return;
    }

    public final void e0(boolean r3) {
        this.W = true;
        c.l(0);
        Z(1, r3);
    }

    public final void h0(boolean r5) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.k == true) goto L7;
        U();     // Catch: Throwable -> L17
        this.k = true;     // Catch: Throwable -> L17
    L7:
        if (this.J == false) goto L11;
        c.d(this.l, this.o, false, "start_download", "mUpdating");     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L11:
        d0(r5);     // Catch: Throwable -> L17
        yhc.a r0 = this.K;     // Catch: Throwable -> L17
        r0.c = 1;     // Catch: Throwable -> L17
        r0.a = 0;     // Catch: Throwable -> L17
        r0.b = 0;     // Catch: Throwable -> L17
        this.J = true;     // Catch: Throwable -> L17
        r();     // Catch: Throwable -> L17
        int r1 = this.H;     // Catch: Throwable -> L17
        int r2 = this.o;     // Catch: Throwable -> L17
        if (r1 == r2) goto L14;
        this.H = r2;     // Catch: Throwable -> L17
        b0(r2, false);     // Catch: Throwable -> L17
    L14:
        monitor-exit(this);     // Catch: Throwable -> L17
        new c(this, r5).start();
    }

    public final void i0(boolean r4) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.k == true) goto L7;
        U();     // Catch: Throwable -> L16
        this.k = true;     // Catch: Throwable -> L16
    L7:
        if (this.N == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L10:
        yhc.a r0 = this.O;     // Catch: Throwable -> L16
        r0.a = 0;     // Catch: Throwable -> L16
        r0.b = 0;     // Catch: Throwable -> L16
        this.N = true;     // Catch: Throwable -> L16
        s();     // Catch: Throwable -> L16
        int r1 = this.H;     // Catch: Throwable -> L16
        int r2 = this.o;     // Catch: Throwable -> L16
        if (r1 == r2) goto L13;
        this.H = r2;     // Catch: Throwable -> L16
        b0(r2, true);     // Catch: Throwable -> L16
    L13:
        monitor-exit(this);     // Catch: Throwable -> L16
        new d(this, r4).start();
    }

    public final void j0(Context r3) {
        if (r3 != null) goto L9;
        return;
    L9:
        r3.startActivity(A());     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        Logger.d("UpdateHelper", th.getMessage(), th);
    }

    public final void m(boolean r8) {
        Z(3, r8);
        p.b.a.getClass();
        if (p.d() == false) goto L5;
        int r5 = 4;
    L6:
        c.l(2);
        String r2 = this.l;
        int r3 = this.o;
        if (r8 == false) goto L9;
        String r9 = "auto";
    L10:
        c.m("test_invitation_popup_close", r2, r3, r9, r5, this.v);
        this.W = false;
        return;
    L9:
        r9 = "trigger";
        goto L10
    L5:
        r5 = 3;
        goto L6
    }

    public final void n(boolean r8) {
        Z(3, r8);
        c.l(2);
        String r2 = this.l;
        int r3 = this.o;
        if (r8 == false) goto L5;
        String r9 = "auto";
    L6:
        c.m("test_invitation_popup_close", r2, r3, r9, -1, this.v);
        this.W = false;
        return;
    L5:
        r9 = "trigger";
        goto L6
    }

    public final void o(boolean r8) {
        Z(2, r8);
        p.b.a.getClass();
        if (p.d() == false) goto L5;
        int r5 = 4;
    L6:
        c.l(1);
        String r2 = this.l;
        int r3 = this.o;
        if (r8 == false) goto L9;
        String r9 = "auto";
    L10:
        c.m("test_invitation_popup_click", r2, r3, r9, r5, this.v);
        this.W = false;
        return;
    L9:
        r9 = "trigger";
        goto L10
    L5:
        r5 = 3;
        goto L6
    }

    public final void p(boolean r8) {
        Z(2, r8);
        c.l(1);
        String r2 = this.l;
        int r3 = this.o;
        if (r8 == false) goto L5;
        String r9 = "auto";
    L6:
        c.m("test_invitation_popup_click", r2, r3, r9, -1, this.v);
        this.W = false;
        return;
    L5:
        r9 = "trigger";
        goto L6
    }

    public final void t(boolean r6) {
        if (M(r6) == false) goto L13;
        boolean r2 = false;
        if (this.T != 1) goto L12;
        p r0 = p.b.a;
        r0.getClass();
        if (p.d() == false) goto L9;
        r2 = r0.e();
    L9:
        if (r2 == false) goto L11;
        Message r1 = Message.obtain();
        r1.what = 14;
        r1.arg1 = r6 ? 1 : 0;
        this.e.sendMessageDelayed(r1, Math.max(this.F, 10));
    L15:
        if (c.j() == false) goto L26;
        JSONObject r7 = new JSONObject();
        r7.put("scene_id", 1);     // Catch: JSONException -> L20
        r7.put(AppLogNewUtils.EVENT_SIGN, 1);     // Catch: JSONException -> L20
        r7.put("is_local_app", c.g());     // Catch: JSONException -> L20
        r7.put("is_monkey", c.f());     // Catch: JSONException -> L20
    L22:
        yhc.b.a("local_test_before_check_update", r7);
        return;
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    L26:
        return;
    L11:
        c.k("reason_local_package_not_installed");
        goto L15
    L12:
        p r3 = p.b.a;
        r3.a();
        r3.d.b("show_alpha_dialog_bg_download_check", 0);
        r3.b(this.o);
        Message r4 = Message.obtain();
        r4.what = 6;
        r4.arg1 = r6 ? 1 : 0;
        this.e.sendMessage(r4);
        goto L15
    L13:
        this.e.sendEmptyMessage(7);
        goto L15
    }

    public final void L(Context r5, PolarisFileWrapper r6) {
        if (r5 != null) goto L31;
        c.d(this.l, this.o, false, "install_fail", "context == null || file == null");
        return;
    L31:
        yhc.g r2 = this.w0;     // Catch: Exception -> L15
        if ((r2 instanceof o) == true) goto L7;
        l r3 = this.x0;     // Catch: Exception -> L15
        if ((r3 instanceof y) == true) goto L12;
    L30:
    L33:
        v r4 = this.p0;     // Catch: Exception -> L25
        if (r4 == null) goto L22;
        yhc.c r7 = r4.p;     // Catch: Exception -> L25
        if (r7 == null) goto L22;
        r7.a(r6);     // Catch: Exception -> L25
    L23:
        c.i(1, null);     // Catch: Exception -> L25
        return;
    L22:
        r5.startActivity(y(r5, r6));     // Catch: Exception -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
        c.d(this.l, this.o, false, "install_fail", Log.getStackTraceString(e));
        c.i(2, Log.getStackTraceString(e));
        return;
    L12:
        if (r3.d() == false) goto L30;
        this.x0.h();     // Catch: Exception -> L15
        goto L30
    L7:
        if (r2.c() == false) goto L30;
        this.w0.h();     // Catch: Exception -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L33
    }

    public final void Z(int r3, boolean r4) {
        Message r0 = Message.obtain();
        r0.what = 15;
        r0.arg1 = r3;
        r0.arg2 = r4 ? 1 : 0;
        this.e.sendMessage(r0);
    }

    @Override // yhc.i
    public final void a(boolean r5, boolean r6) {
        Logger.e("UpdateHelper", "downloadResult isSuccess:" + r5 + ",pre:" + r6);
        b.a r0 = this.o0.e;
        if (r0 != null) goto L6;
        r0 = new b.a();
    L6:
        yhc.a r1 = this.K;
        monitor-enter(r1);
        if (r6 == false) goto L20;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L17
        this.q0.execute(new e(this, r5, r6, r0));
        return;
    L17:
        th = move-exception;
        throw th;
    L20:
        yhc.a r2 = this.K;     // Catch: Throwable -> L17
        if (r5 == false) goto L12;
        int r3 = 3;
    L13:
        r2.c = r3;     // Catch: Throwable -> L17
        goto L14
    L12:
        r3 = 2;
        goto L13
    }

    public final synchronized void b0(int r3, boolean r4) {
        monitor-enter(this);
        this.H = r3;     // Catch: Throwable -> L15
        if (r4 == false) goto L7;
        this.M = -1;     // Catch: Throwable -> L15
    L8:
        this.G = "";     // Catch: Throwable -> L15
        SharedPreferences.Editor r5 = this.d.getSharedPreferences("update_info", 0).edit();     // Catch: Throwable -> L15
        r5.putInt("download_version", this.H);     // Catch: Throwable -> L15
        if (r4 == false) goto L11;
        r5.putInt("pre_download_size", this.M);     // Catch: Throwable -> L15
    L12:
        r5.putString("download_etag", this.G);     // Catch: Throwable -> L15
        SharedPrefsEditorCompat.apply(r5);     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L11:
        r5.putInt("download_size", this.I);     // Catch: Throwable -> L15
        goto L12
    L7:
        this.I = -1;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    @Override // yhc.i
    public final synchronized void e(int r5, boolean r6) {
        monitor-enter(this);
        List<OnUpdateStatusChangedListener> r1 = this.g0;     // Catch: Throwable -> L26
        monitor-enter(r1);     // Catch: Throwable -> L26
        Iterator r2 = ((ArrayList) this.g0).iterator();     // Catch: Throwable -> L23
    L8:
        if (r2.hasNext() == false) goto L12;
        OnUpdateStatusChangedListener r3 = (OnUpdateStatusChangedListener) r2.next();     // Catch: Throwable -> L23
        if (r3 == null) goto L8;
        r3.e(r5, r6);     // Catch: Throwable -> L23
        goto L8
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L23
        if (r6 == false) goto L15;
        this.M = r5;     // Catch: Throwable -> L26
    L16:
        this.G = "";     // Catch: Throwable -> L26
        SharedPreferences.Editor r7 = this.d.getSharedPreferences("update_info", 0).edit();     // Catch: Throwable -> L26
        if (r6 == false) goto L19;
        r7.putInt("pre_download_size", this.M);     // Catch: Throwable -> L26
    L20:
        r7.putString("download_etag", this.G);     // Catch: Throwable -> L26
        SharedPrefsEditorCompat.apply(r7);     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L19:
        r7.putInt("download_size", this.I);     // Catch: Throwable -> L26
        goto L20
    L15:
        this.I = r5;     // Catch: Throwable -> L26
        goto L16
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    public final Intent y(Context r5, PolarisFileWrapper r6) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 24) goto L13;
        v r2 = this.p0;
        if (r2 != null) goto L7;
        String r3 = "com.ss.android.uri.key";
    L12:
        Uri r7 = FileProvider.getUriForFile(r5, r3, r6);
    L14:
        Intent r8 = new Intent("android.intent.action.VIEW");
        r8.setDataAndType(r7, "application/vnd.android.package-archive");
        if (r0 < 24) goto L17;
        int r9 = 268435457;
    L18:
        r8.addFlags(r9);
        return r8;
    L17:
        r9 = 268435456;
        goto L18
    L7:
        if (TextUtils.isEmpty(r2.c) == true) goto L10;
        r3 = r2.c;
        goto L12
    L10:
        throw new IllegalArgumentException("formalAuthority can not empty");
    L13:
        r7 = Uri.fromFile(r6);
        goto L14
    }

    @Override // yhc.i
    public final void d(int r5, int r6, boolean r7) {
        yhc.a r0 = this.K;
        monitor-enter(r0);
        if (r7 == false) goto L25;
    L6:
        List<OnUpdateStatusChangedListener> r1 = this.g0;     // Catch: Throwable -> L20
        monitor-enter(r1);     // Catch: Throwable -> L20
        Iterator r2 = ((ArrayList) this.g0).iterator();     // Catch: Throwable -> L17
    L10:
        if (r2.hasNext() == false) goto L14;
        OnUpdateStatusChangedListener r3 = (OnUpdateStatusChangedListener) r2.next();     // Catch: Throwable -> L17
        if (r3 == null) goto L10;
        r3.d(r5, r6, r7);     // Catch: Throwable -> L17
        goto L10
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    L25:
        yhc.a r4 = this.K;     // Catch: Throwable -> L20
        r4.a = r5;     // Catch: Throwable -> L20
        r4.b = r6;     // Catch: Throwable -> L20
        goto L6
    }

    public final void g0(int r1, int r2, OnUpdateStatusChangedListener r3, boolean r4) {
        monitor-enter(this);
        this.r0 = r1;     // Catch: Throwable -> L20
        List<OnUpdateStatusChangedListener> r5 = this.g0;     // Catch: Throwable -> L20
        monitor-enter(r5);     // Catch: Throwable -> L20
        ((ArrayList) this.g0).add(r3);     // Catch: Throwable -> L17
        monitor-exit(r5);     // Catch: Throwable -> L17
    L8:
        if (this.k == true) goto L11;
        U();     // Catch: Throwable -> L20
        this.k = true;     // Catch: Throwable -> L20
    L11:
        if (this.J == false) goto L14;
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L14:
        monitor-exit(this);     // Catch: Throwable -> L20
        new b(this, r4).c();
        return;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }
}

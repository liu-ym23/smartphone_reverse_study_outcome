package com.ss.android.lark.chat.service.impl;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Trace;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorLevel;
import com.ss.android.lark.appreciablelib.ErrorParams;
import com.ss.android.lark.appreciablelib.ErrorType;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.NetStatus;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.im.sdk.utils.ImSdkMessageUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.perf.ResourcePerfMonitor;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class MonitorMessageSendCallback implements com.ss.android.lark.im.sdk.service.o, m6b.p, u, n6b.a {
    public static final AtomicInteger q = null;
    public final okb.b a;
    public final z1b.a b;
    public String c;
    public Chat d;
    public ChatChatter e;
    public final Biz f;
    public Scene g;
    public int h;
    public boolean i;
    public volatile b j;
    public a k;
    public int l;
    public String m;
    public final Map<String, String> n;
    public final Map<String, c> o;
    public final List<n6b.c<o6b.b>> p;

    public @interface FromType {
        public static final int IMAGE = 1;
        public static final int MEDIA = 4;
        public static final int POST = 2;
        public static final int SHARE = 14;
        public static final int STICKER = 3;
        public static final int UNKNOWN = 0;
    }

    public @interface StateType {
        public static final int FAIL = 2;
        public static final int SENDING = 0;
        public static final int SUCCESS = 1;
    }

    public interface a {
    }

    public static class b implements okb.a.b, okb.a.a {
        public final WeakReference<MonitorMessageSendCallback> a;

        public final void a() {
            Log.i("MonitorMessageSendCallback", "onFrontToBackEvent");
            MonitorMessageSendCallback r0 = this.a.get();
            if (r0 == null) goto L5;
            r0.i = true;
        L5:
            ImSdkProxy.b().e(this);
        }

        public final void b() {
            MonitorMessageSendCallback r0 = this.a.get();
        }

        public b(MonitorMessageSendCallback r2) {
            this.a = new WeakReference(r2);
        }
    }

    public static class c {
        public float A;
        public String B;
        public long C;
        public long D;
        public long E;
        public long F;
        public int G;
        public Map<String, Object> H;
        public int I;
        public String a;
        public String b;
        public String c;
        public long d;
        public long e;
        public boolean f;
        public Message.Type g;
        public String h;
        public String i;
        public boolean j;
        public boolean k;
        public String l;
        public final String m;
        public final String n;
        public long o;
        public long p;
        public long q;
        public long r;
        public long s;
        public int t;
        public String u;
        public Chat.Type v;
        public int w;
        public boolean x;
        public long y;
        public long z;

        public final Map<String, Object> b() {
            HashMap r0 = new HashMap();
            r0.put("message_type", Integer.valueOf(this.g.getNumber()));
            r0.put("chat_type", Integer.valueOf(this.v.getNumber()));
            r0.put("is_crypto", Integer.valueOf(this.x ? 1 : 0));
            r0.put("image_type", this.l);
            r0.put("color_space", this.m);
            r0.put("color_type", this.n);
            r0.put("from_type", Integer.valueOf(this.I));
            r0.put("is_image_fallback_to_file", Boolean.valueOf(this.j));
            r0.put("media_is_origin_type", Boolean.valueOf(this.k));
            Message.Type r1 = this.g;
            if (r1 != Message.Type.IMAGE) goto L5;
        L10:
            boolean r2 = true;
        L11:
            if (r2 == false) goto L13;
            r0.put("resource_multiple_number", Integer.valueOf(this.t));
        L13:
            return r0;
        L5:
            if (r1 == Message.Type.FILE) goto L10;
            if (r1 == Message.Type.MEDIA) goto L10;
            r2 = false;
            goto L11
        }

        public final Map<String, Object> c() {
            HashMap r0 = new HashMap();
            r0.put("text_content_length", Long.valueOf(this.d));
            r0.put("resource_content_length", Long.valueOf(this.e));
            r0.put("file_size", Long.valueOf(this.e));
            r0.put("chatter_count", Integer.valueOf(this.w));
            String r1 = this.h;
            String r2 = BuildConfig.FLAVOR;
            if (r1 != null) goto L5;
            r1 = BuildConfig.FLAVOR;
        L5:
            r0.put("message_id", r1);
            String r3 = this.i;
            if (r3 == null) goto L9;
            r2 = r3;
        L9:
            r0.put("remote_message_id", r2);
            r0.put("resource_width", Long.valueOf(this.o));
            r0.put("resource_height", Long.valueOf(this.p));
            r0.put("resource_frames", 0L);
            r0.put("upload_content_length", Long.valueOf(this.q));
            r0.put("upload_content_width", Long.valueOf(this.r));
            r0.put("upload_content_height", Long.valueOf(this.s));
            if (TextUtils.isEmpty(this.B) == true) goto L12;
            r0.put("compress_algorithm", this.B);
            r0.put("compress_ratio", Float.valueOf(this.A));
        L12:
            r0.put("choose_image_source", this.u);
            return r0;
        }

        public c() {
            this.d = 0;
            this.e = 0;
            this.f = false;
            this.g = Message.Type.UNKNOWN;
            this.h = BuildConfig.FLAVOR;
            this.i = BuildConfig.FLAVOR;
            this.j = true;
            this.k = false;
            this.l = BuildConfig.FLAVOR;
            this.m = "SRGB";
            this.n = "RGBA_8888";
            this.o = 0;
            this.p = 0;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 1;
            this.u = "unknown";
            this.v = Chat.Type.P2P;
            this.A = 1.0f;
            this.G = 0;
            this.I = 1;
        }

        public final Map<String, Object> a(boolean r4) {
            HashMap r0 = new HashMap();
            if (r4 == false) goto L5;
            r0.put("send_state", Integer.valueOf(this.G));
            r0.put("on_screen_cost", Long.valueOf(this.E));
            r0.put("total_cost", Long.valueOf(this.F));
            r0.put("upload_cost", 0L);
        L5:
            String r5 = this.c;
            if (r5 != null) goto L8;
            r5 = BuildConfig.FLAVOR;
        L8:
            r0.put("context_id", r5);
            return r0;
        }

        public final Map<String, Object> d(boolean r4, boolean r5) {
            HashMap r0 = new HashMap();
            r0.put("sdk_create_msg_cost", Long.valueOf(this.y));
            r0.put("CreateQuasiMessageRequest", Long.valueOf(this.y));
            if (r4 == false) goto L5;
            r0.put("compress_cost", Long.valueOf(this.z));
            r0.put("sdk_send_msg_cost", Long.valueOf(this.C));
            r0.put("net_cost", Long.valueOf(this.D));
        L5:
            if (r5 == true) goto L7;
        L9:
            return r0;
        L7:
            if (CollectionUtils.isEmpty(this.H) == true) goto L9;
            r0.putAll(this.H);
            goto L9
        }
    }

    public final void i() {
        c r1 = q(null);
        if (r1 != null) goto L5;
        return;
    L5:
        r1.E = SystemClock.elapsedRealtime();
        PerfLog.start("quasi_message_on_screen_single", this.c, null);
    }

    @Override // m6b.p
    public void onBeginSendMessage(Message r1) {
    }

    @Override // com.ss.android.lark.chat.service.impl.u
    public void onUpdateMediaCompressProgress(Message r1) {
    }

    static {
        q = new AtomicInteger(NetStatus.EXCELLENT.getValue());
    }

    public final void f() {
        PerfLog.end("sync_create_local_message", this.c, null);
    }

    public final void j() {
        PerfLog.start("sync_create_local_message", this.c, null);
    }

    public MonitorMessageSendCallback() {
        this.a = ImSdkProxy.c();
        this.b = new z1b.a();
        this.c = com.ss.android.lark.sdk.a.a();
        this.d = null;
        this.e = null;
        this.f = Biz.Messenger;
        this.g = Scene.Chat;
        this.h = 1;
        this.i = false;
        this.j = null;
        this.k = null;
        this.l = 1;
        this.m = "unknown";
        this.n = new ConcurrentHashMap();
        this.o = new ConcurrentHashMap();
        this.p = new CopyOnWriteArrayList();
        this.j = new b(this);
        ImSdkProxy.b().d(this.j);
        ImSdkProxy.b().f(this.j);
        boolean r0 = ImSdkProxy.b().b();
        Log.d("MonitorMessageSendCallback", "isInForeground:" + r0);
        this.i = r0 ^ true;
    }

    public final String e() {
        return this.c;
    }

    @Override // n6b.a
    public final void b(long r2) {
        String r3 = FileUtils.h(r2);
        int r4 = t5c.a.a;
        Intrinsics.checkNotNullParameter(r3, "fileSize");
        Statistics.sendEvent("im_send_file_confirmed", new JSONObject().put("file_size", r3));
    }

    public final void c(String r4) {
        PerfLog.start("async_call_send_message", this.c, null);
        c r5 = q(r4);
        if (r5 != null) goto L5;
        return;
    L5:
        r5.C = SystemClock.elapsedRealtime();
    }

    public /* bridge */ /* synthetic */ void g(Object r1) {
        u((o6b.b) r1);
    }

    public /* bridge */ /* synthetic */ void h(MessageInfo r1) {
        s(r1);
    }

    public void l(String r6) {
        c r0 = q(r6);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.y = SystemClock.elapsedRealtime() - r0.y;
        PerfLog.end("sync_create_quasi_message", this.c, null);
        if (TextUtils.isEmpty(r6) == true) goto L11;
        String r1 = this.c;
        SystemClock.elapsedRealtime();
        CopyOnWriteArrayList r2 = mkb.d.a;
        Intrinsics.checkNotNullParameter(r1, "contextId");
        Intrinsics.checkNotNullParameter(r6, "cId");
        Iterator r3 = mkb.d.a.iterator();
    L9:
        if (r3.hasNext() == false) goto L13;
        ((mkb.a) r3.next()).e(r1, r6);
        goto L9
    L13:
        return;
    }

    public final void m(n6b.c<o6b.b> r2) {
        ((CopyOnWriteArrayList) this.p).remove(r2);
    }

    public final void o(String r10) {
        c r11 = q(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        r11.E = SystemClock.elapsedRealtime() - r11.E;
        PerfLog.end("quasi_message_on_screen_single", this.c, null);
        AppreciableKit r3 = AppreciableKit.getInstance();
        String r0 = r11.a;
        if (r0 != null) goto L8;
        r0 = BuildConfig.FLAVOR;
    L8:
        r3.end(r0, r11.d(false, false), r11.a(false), r11.c(), r11.b());
    }

    public final void p(n6b.c<o6b.b> r2) {
        if (((CopyOnWriteArrayList) this.p).contains(r2) == false) goto L5;
        return;
    L5:
        ((CopyOnWriteArrayList) this.p).add(r2);
    }

    public final c q(String r3) {
        String r1 = "default";
        if (TextUtils.isEmpty(r3) == true) goto L10;
        String r4 = (String) ((ConcurrentHashMap) this.n).get(r3);
        if (r4 == null) goto L10;
        r1 = r4;
    L10:
        return (c) ((ConcurrentHashMap) this.o).get(r1);
    }

    public final void r(dcb.b r7) {
        if (r7 != null) goto L4;
    L6:
        String r0 = "default";
    L7:
        c r1 = (c) ((ConcurrentHashMap) this.o).get(r0);
        if (r1 != null) goto L10;
        return;
    L10:
        r1.j = false;
        if (r7 == null) goto L22;
        int[] r2 = r7.c;
        int r3 = r2[0];
        int r4 = 80;
        if (r3 > 0) goto L15;
        r3 = 80;
    L15:
        r1.r = r3;
        int r5 = r2[1];
        if (r5 <= 0) goto L19;
        r4 = r5;
    L19:
        r1.s = r4;
        File r8 = r7.b;
        if (r8 == null) goto L22;
        String[] r6 = FileUtils.a;
        r1.q = r8.length();
    L22:
        PerfLog.end("get_image_data_single", this.c, null);
        return;
    L4:
        if (TextUtils.isEmpty(r7.a) == true) goto L6;
        r0 = r7.a;
        goto L7
    }

    public void s(MessageInfo r15) {
        Message r0 = r15.getMessage();
        Message.Type r1 = r0.getType();
        c r16 = q(r15.getcId());
        if (r16 != null) goto L5;
        return;
    L5:
        long r3 = 0;
        if (r1 != Message.Type.POST) goto L9;
        int r2 = ((PostContent) r0.getContent()).getText().length();
    L11:
        r3 = r2;
        long r5 = 0;
    L45:
        z1b.a r4 = this.b;
        String r7 = r1.toString();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r7, "messageType");
        r4.getDefaultParamsMap().put(r4.a, Long.valueOf(SystemClock.elapsedRealtime()));
        r4.getDefaultParamsMap().put(r4.e, r7);
        r4.getDefaultParamsMap().put(r4.f, Long.valueOf(r3));
        Chat r6 = this.d;
        if (r6 == null) goto L48;
        r16.v = r6.getType();
        r16.w = this.d.getMemberCount();
        r16.x = this.d.isSecret();
    L48:
        r16.g = r1;
        r16.d = r3;
        r16.e = r5;
        if (r0.getcId() == null) goto L51;
        String r8 = r0.getcId();
    L52:
        r16.h = r8;
        return;
    L51:
        r8 = BuildConfig.FLAVOR;
        goto L52
    L9:
        if (r1 != Message.Type.TEXT) goto L13;
        r2 = ImSdkMessageUtils.a(r0).length();
        goto L11
    L13:
        if (r1 != Message.Type.IMAGE) goto L25;
        ImageSet r9 = ((ImageContent) r0.getContent()).getImageSet();
        if (r9 != null) goto L17;
    L23:
        r5 = 0;
        goto L45
    L17:
        if (r9.getOrigin() == null) goto L23;
        if (CollectionUtils.isNotEmpty(r9.getOrigin().getUrls()) == false) goto L23;
        String r10 = (String) ListProtector.get(r9.getOrigin().getUrls(), 0);
        VFSFiles r11 = VFSFiles.b;
        r11.getClass();
        if (VFSFiles.b(true).i(r10).exists() == false) goto L23;
        r11.getClass();
        r5 = VFSFiles.b(true).i(r10).length();
        goto L45
    L25:
        if (r0.getType() != Message.Type.AUDIO) goto L30;
        AudioContent r12 = (AudioContent) r0.getContent();
        if (TextUtils.isEmpty(r12.getLocalFilePath()) == true) goto L35;
        VFSFiles.b.getClass();
        r5 = VFSFiles.b(true).i(r12.getLocalFilePath()).length();
    L36:
        Log.d("MonitorMessageSendCallback", "getContentSize:" + r0.getType() + "/" + r5);
        if (r0.getType() != Message.Type.MEDIA) goto L40;
        ((MediaContent) r0.getContent()).getMime();
    L43:
        if (r5 != 0) goto L45;
        r5 = r16.e;
        goto L45
    L40:
        if (r0.getType() != Message.Type.FILE) goto L43;
        ((FileContent) r0.getContent()).getMime();
    L35:
        r5 = 0;
        goto L36
    L30:
        if (r0.getType() != Message.Type.FILE) goto L33;
        r5 = ((FileContent) r0.getContent()).getSize();
        goto L36
    L33:
        if (r0.getType() != Message.Type.MEDIA) goto L35;
        r5 = ((MediaContent) r0.getContent()).getSize();
        goto L36
    }

    public void u(o6b.b r15) {
        z1b.a r0 = this.b;
        if (r0.getDefaultParamsMap().get(r0.a) == null) goto L6;
        r0.getDefaultParamsMap().put(r0.d, Integer.valueOf(r0.g));
        r0.a();
    L6:
        Iterator r1 = ((CopyOnWriteArrayList) this.p).iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((n6b.c) r1.next()).g(r15);
        goto L8
    L10:
        Message r2 = r15.a;
        if (TextUtils.isEmpty(r2.getParentId()) == true) goto L13;
        Message r3 = ImSdkService.f().za(r2.getParentId());
    L14:
        Chat r4 = this.d;
        ChatChatter r5 = this.e;
        Map r6 = com.ss.android.lark.im.sdk.statistics.b.a;
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new com.ss.android.lark.im.sdk.statistics.e(r4, r5, r2));
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new com.ss.android.lark.im.sdk.statistics.d(this.d, this.e, r2, r3));
        if (TextUtils.isEmpty(r2.getcId()) == false) goto L17;
    L22:
        c r7 = q(r2.getcId());
        if (r7 != null) goto L25;
        return;
    L25:
        r7.D = r15.c;
        HashMap r8 = new HashMap();
        Trace r9 = r15.d;
        if (r9 == null) goto L40;
        List r10 = r9.spans;
        if (r10 == null) goto L40;
        Iterator r11 = r10.iterator();
    L31:
        if (r11.hasNext() == false) goto L40;
        Trace.Span r12 = (Trace.Span) r11.next();
        if (TextUtils.isEmpty(r12.name) == true) goto L31;
        Long r13 = r12.duration_millis;
        if (r13 == null) goto L31;
        r8.put(r12.name, r13);
        if (CollectionUtils.isEmpty(r12.attributes) == true) goto L31;
        r8.putAll(r12.attributes);
    L40:
        r7.H = r8;
        r7.i = r15.b;
        t(r2.getType(), null, r2.getcId());
        if (r7.g != Message.Type.MEDIA) goto L69;
        String r14 = r7.h;
        if (r14 == null) goto L69;
        long r16 = r7.D;
        HashMap<String, MediaMessageReport> r17 = z0.a;
        monitor-enter(z0.class);
        Intrinsics.checkNotNullParameter(r14, "mgsId");     // Catch: Throwable -> L66
        HashMap<String, MediaMessageReport> r18 = z0.a;     // Catch: Throwable -> L66
        MediaMessageReport r19 = r18.get(r14);     // Catch: Throwable -> L66
        if (r19 == null) goto L63;
        r19.setResult(ChameleonOpenTracker.OpenResult.SUCCESS);     // Catch: Throwable -> L66
        r19.setSendDuration(r16);     // Catch: Throwable -> L66
        long r20 = 0;
        if (r19.isMergePreCompress() == 1) goto L51;
    L55:
        r19.setPreDuration(r20);     // Catch: Throwable -> L66
        if (r19.isCompressUpload() == 1) goto L58;
        r19.setUploadDuration((SystemClock.elapsedRealtime() - r19.getSendStart()) - r19.getSendDuration());     // Catch: Throwable -> L66
        r19.setTotalDuration(((r19.getPickDuration() + r19.getCompressDuration()) + r19.getUploadDuration()) + r19.getSendDuration());     // Catch: Throwable -> L66
    L62:
        r19.setCompressDuration(r19.getCompressDuration() + r19.getPreDuration());     // Catch: Throwable -> L66
        JSONObject r21 = z0.a(r19);     // Catch: Throwable -> L66
        Log.i("MediaMessageMonitor", "report media success msg: " + r21);     // Catch: Throwable -> L66
        Statistics.sendEvent("send_video_info_dev", r21);     // Catch: Throwable -> L66
        goto L63
    L58:
        if (r19.isCompressUploadSuccess() != 1) goto L60;
        r19.setTotalDuration(((r19.getPickDuration() + r19.getCompressUploadDuration()) + r19.getSendDuration()) - r19.getPreDuration());     // Catch: Throwable -> L66
        goto L62
    L60:
        r19.setUseCache(1);     // Catch: Throwable -> L66
        r19.setTotalDuration(r19.getPickDuration() + r19.getSendDuration());     // Catch: Throwable -> L66
        goto L62
    L51:
        if (r19.getPreStart() == 0) goto L55;
        if (r19.getPreMerged() <= r19.getPreStart()) goto L55;
        r20 = r19.getPreMerged() - r19.getPreStart();     // Catch: Throwable -> L66
    L63:
        r18.remove(r14);     // Catch: Throwable -> L66
        ResourcePerfMonitor.VIDEO_SEND.onEnd();     // Catch: Throwable -> L66
        monitor-exit(z0.class);
    L66:
        th = move-exception;
        throw th;
    L69:
        a r22 = this.k;
        if (r22 == null) goto L75;
        String r110 = r15.b;
        e2b.f r23 = (e2b.f) r22;
        ResourcePerfMonitor.IMAGE_SEND.onEnd();
        if (r110 != null) goto L74;
        r110 = BuildConfig.FLAVOR;
    L74:
        r23.a.onSuccess(new com.ss.android.lark.image.uploader.entity.c(r110));
    L75:
        w(r2.getcId());
        return;
    L17:
        if (TextUtils.isEmpty(r2.getId()) == true) goto L22;
        String r24 = r2.getcId();
        String r25 = r15.b;
        long r26 = SystemClock.elapsedRealtime();
        CopyOnWriteArrayList r27 = mkb.d.a;
        Intrinsics.checkNotNullParameter(r24, "cId");
        Intrinsics.checkNotNullParameter(r25, "serverId");
        Iterator r28 = mkb.d.a.iterator();
    L20:
        if (r28.hasNext() == false) goto L22;
        ((mkb.a) r28.next()).a(r24, r25, r26);
        goto L20
    L13:
        r3 = null;
        goto L14
    }

    public final void w(String r3) {
        String r1 = "default";
        if (TextUtils.isEmpty(r3) == true) goto L10;
        String r0 = (String) ((ConcurrentHashMap) this.n).get(r3);
        if (r0 == null) goto L10;
        r1 = r0;
    L10:
        if (TextUtils.isEmpty(r3) == true) goto L13;
        ((ConcurrentHashMap) this.n).remove(r3);
    L13:
        if (TextUtils.isEmpty(r1) == true) goto L16;
        ((ConcurrentHashMap) this.o).remove(r1);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v28, types: [com.ss.android.lark.chat.service.impl.k1, java.lang.Object] */
    public void a(ErrorResult r11, final Message r12) {
        Log.e("MonitorMessageSendCallback", "send message failed:" + r12.toString() + ", error code is " + r11.getCode() + ", ");
        Iterator r0 = ((CopyOnWriteArrayList) this.p).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((n6b.c) r0.next()).a(r11, r12);
        goto L4
    L6:
        String r1 = r12.getcId();
        Iterator r2 = mkb.d.a.iterator();
    L8:
        if (r2.hasNext() == false) goto L11;
        ((mkb.a) r2.next()).f(r1);
        goto L8
    L11:
        if (TextUtils.isEmpty(r11.getDebugMsg()) == true) goto L14;
        Log.e("MonitorMessageSendCallback", "send message failed, debug message is " + r11.getDebugMsg());
    L14:
        if (TextUtils.isEmpty(r11.getServerRequestId()) == true) goto L16;
        Log.e("MonitorMessageSendCallback", "send message failed, request id is " + r11.getServerRequestId());
    L16:
        z1b.a r3 = this.b;
        if (r3.getDefaultParamsMap().get(r3.a) == null) goto L20;
        r3.getDefaultParamsMap().put(r3.d, Integer.valueOf(r3.h));
        r3.a();
    L20:
        t(r12.getType(), r11, r12.getcId());
        int r4 = r11.getErrorCode();
        if (r4 != 507) goto L23;
    L74:
        Log.i("MonitorMessageSendCallback", "handleUIMessageSendFail called, errorCode:" + r4);
    L75:
        String r5 = r11.getMessage();
        if (TextUtils.isEmpty(r5) == false) goto L78;
        r5 = r11.getDebugMsg();
    L78:
        c r6 = q(r12.getcId());
        if (r6 != null) goto L82;
        return;
    L82:
        if (r6.g != Message.Type.MEDIA) goto L106;
        String r7 = r6.h;
        if (r7 == null) goto L106;
        Integer r8 = Integer.valueOf(r11.getErrorCode());
        int r9 = r11.getStatus();
        HashMap<String, MediaMessageReport> r10 = z0.a;
        monitor-enter(z0.class);
        Intrinsics.checkNotNullParameter(r7, "mgsId");     // Catch: Throwable -> L103
        HashMap<String, MediaMessageReport> r13 = z0.a;     // Catch: Throwable -> L103
        MediaMessageReport r14 = r13.get(r7);     // Catch: Throwable -> L103
        if (r14 == null) goto L100;
        r14.setResult(ChameleonOpenTracker.OpenResult.FAILED);     // Catch: Throwable -> L103
        r14.setErrorType("rust");     // Catch: Throwable -> L103
        if (r8 == null) goto L92;
        int r15 = r8.intValue();     // Catch: Throwable -> L103
    L93:
        r14.setErrorCode(r15);     // Catch: Throwable -> L103
        if (r5 != null) goto L96;
        r5 = BuildConfig.FLAVOR;
    L96:
        r14.setErrorMsg(r5);     // Catch: Throwable -> L103
        if (Intrinsics.areEqual("rust", "rust") == false) goto L99;
        r14.setErrorStatus(r9);     // Catch: Throwable -> L103
    L99:
        JSONObject r16 = z0.a(r14);     // Catch: Throwable -> L103
        Log.i("MediaMessageMonitor", "report media failed msg: " + r16);     // Catch: Throwable -> L103
        Statistics.sendEvent("send_video_info_dev", r16);     // Catch: Throwable -> L103
        goto L100
    L92:
        r15 = -1;
    L100:
        r13.remove(r7);     // Catch: Throwable -> L103
        ResourcePerfMonitor.VIDEO_SEND.onEnd();     // Catch: Throwable -> L103
        monitor-exit(z0.class);
    L103:
        th = move-exception;
        throw th;
    L106:
        a r17 = this.k;
        if (r17 == null) goto L109;
        ResourcePerfMonitor.IMAGE_SEND.onEnd();
        ((e2b.f) r17).a.onError(r11);
    L109:
        w(r12.getcId());
        return;
    L23:
        if (r4 == 5009) goto L74;
        if (r4 == 260008) goto L74;
        if (r4 == 260009) goto L74;
        if (r4 == 311120) goto L74;
        if (r4 != 260003) goto L38;
        c r18 = q(r12.getcId());
        if (r18 != null) goto L36;
    L37:
        Log.i("MonitorMessageSendCallback", "handleUIMessageSendFail called, errorCode:" + r4);
        goto L75
    L36:
        if (r18.f == false) goto L37;
    L38:
        boolean r19 = com.ss.android.lark.chat.utils.n0.a;
        boolean r20 = false;
        if (ImSdkProxy.c().isHitStorageQuotaLimit(r11.getErrorCode()) == true) goto L41;
        boolean r21 = false;
    L42:
        if (r21 == true) goto L75;
        if (r11.getErrorCode() == ImSdkProxy.c().getUnifiedStorageLimitErrorCode()) goto L47;
        boolean r22 = false;
    L48:
        if (r22 == true) goto L75;
        if (r11.getErrorCode() == 4029) goto L53;
        boolean r23 = false;
    L54:
        if (r23 == true) goto L75;
        if (com.ss.android.lark.chat.utils.n0.a(r11) == true) goto L75;
        Intrinsics.checkNotNullParameter(r11, "errorResult");
        switch(r11.getErrorCode()) {
            case 321000: goto L63;
            case 321001: goto L62;
            default: goto L65;
        };
    L62:
        Log.i("MessageUtils", "errorCode = " + r11.getErrorCode() + ", upload deny by file policy");
    L64:
        r20 = true;
        goto L65
    L63:
        UICallbackExecutor.execute(new com.ss.android.lark.chat.utils.m0(r11));
    L65:
        if (r20 == true) goto L75;
        if (r4 != 5664) goto L71;
        ?? r24 = new k1(this, r12);
        Intrinsics.checkNotNullParameter(r24, "reSendHandler");
        Log.i("MessageUtils", "handleMessageResourceHardLinkFailed");
        UICallbackExecutor.execute(new com.ss.android.lark.chat.utils.o0(r24));
        goto L75
    L71:
        if (ImSdkProxy.c().isInterceptSendCallback(r11.getErrorCode()) == true) goto L75;
        UICallbackExecutor.execute(new l1(r11));
        goto L75
    L53:
        UICallbackExecutor.execute(new com.ss.android.lark.chat.utils.p0(r11));
        r23 = true;
        goto L54
    L47:
        ImSdkProxy.c().showUnifiedStorageLimitCTADialog(ImSdkProxy.b().getTopActivity());
        r22 = true;
        goto L48
    L41:
        r21 = ImSdkProxy.c().showQuotaLimitDialog(ImSdkProxy.b().getTopActivity(), r11.getErrorCode());
        goto L42
    }

    public void d(String r11, MessageParams<?, ?> r12) {
        c r0 = q(r11);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.y = SystemClock.elapsedRealtime();
        r0.f = r12.m;
        String r2 = null;
        PerfLog.start("sync_create_quasi_message", this.c, null);
        if (TextUtils.isEmpty(r11) == false) goto L8;
        return;
    L8:
        if (r12.m == false) goto L10;
        r2 = r12.h;
    L10:
        String r13 = this.c;
        long r1 = SystemClock.elapsedRealtime();
        CopyOnWriteArrayList r3 = mkb.d.a;
        Intrinsics.checkNotNullParameter(r13, "contextId");
        Intrinsics.checkNotNullParameter(r11, "cId");
        Iterator r9 = mkb.d.a.iterator();
    L12:
        if (r9.hasNext() == false) goto L16;
        ((mkb.a) r9.next()).d(r13, r11, r2, r1);
        goto L12
    }

    public void k(jkb.e r3, Message r4) {
        Iterator r0 = ((CopyOnWriteArrayList) this.p).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((n6b.c) r0.next()).k(r3, r4);
        goto L4
    }

    @Override // n6b.a
    public final void n(long r2, long r4) {
        String r5 = UIHelper.mustacheFormat(com.ss.android.lark.chat.utils.t.a, "max_single_size", FileUtils.h(r4));
        LKUIToast.show(ImSdk.a.getContext(), r5);
        String r3 = FileUtils.h(r2);
        int r6 = t5c.a.a;
        Intrinsics.checkNotNullParameter(r3, "fileSize");
        Statistics.sendEvent("im_send_file_rejected", new JSONObject().put("file_size", r3));
    }

    public final void t(Message.Type r26, ErrorResult r27, String r28) {
        c r2 = q(r28);
        if (r2 != null) goto L5;
        return;
    L5:
        r2.C = SystemClock.elapsedRealtime() - r2.C;
        r2.F = SystemClock.elapsedRealtime() - r2.F;
        if (r27 != null) goto L8;
        int r4 = 1;
    L9:
        r2.G = r4;
        PerfLog.end("async_call_send_message", this.c, null);
        PerfLog.end("send_" + z1b.b.a(r26), this.c, null);
        Log.d("MessageSendPerf", "sendEnd:" + ThreadMethodProxy.currentThread());
        c r1 = q(r28);
        if (r1 == null) goto L16;
        CopyOnWriteArrayList r5 = mkb.c.a;
        Intrinsics.checkNotNullParameter(r1, "reportData");
        Iterator r3 = mkb.c.a.iterator();
    L13:
        if (r3.hasNext() == false) goto L16;
        ((mkb.b) r3.next()).a();
    L16:
        if (this.j == null) goto L22;
        Log.d("MonitorMessageSendCallback", "removeLifecycleListener");
        b r6 = this.j;
        if (r6 == null) goto L20;
        ImSdkProxy.b().e(r6);
    L20:
        this.j = null;
    L22:
        if (r27 != null) goto L27;
        AppreciableKit r7 = AppreciableKit.getInstance();
        String r8 = r2.b;
        if (r8 != null) goto L26;
        r8 = BuildConfig.FLAVOR;
    L26:
        r7.end(r8, r2.d(true, false), r2.a(false), r2.c(), r2.b());
    L28:
        HashMap r9 = new HashMap();
        r9.putAll(r2.d(true, true));
        r9.putAll(r2.b());
        r9.putAll(r2.c());
        r9.putAll(r2.a(true));
        r9.put("is_in_background", Boolean.valueOf(this.i));
        r9.put("net_status", Integer.valueOf(q.get()));
        if (r2.t > 1) goto L31;
    L56:
        Statistics.sendEvent("perf_send_msg_dev", new JSONObject(r9));
        return;
    L31:
        if (r2.g != Message.Type.IMAGE) goto L56;
        if (r9.containsKey("fully_upload_image_network_time_consumption") == false) goto L38;
        if ((r9.get("fully_upload_image_network_time_consumption") instanceof Long) == false) goto L38;
        long r10 = ((Long) r9.get("fully_upload_image_network_time_consumption")).longValue();
    L44:
        if (r9.containsKey("message_waiting_to_be_sent") == true) goto L46;
    L48:
        long r11 = 0;
    L50:
        if (r11 <= 0) goto L56;
        if (r11 <= r10) goto L56;
        long r12 = r11 - r10;
        if (r12 >= r2.F) goto L56;
        Log.d("MonitorMessageSendCallback", "upload multiple res, messageWaitTime:" + r11 + "， uploadTime:" + r10 + ", totalCost:" + r2.F);
        long r13 = r2.F - r12;
        r2.F = r13;
        r9.put("total_cost", Long.valueOf(r13));
        goto L56
    L46:
        if ((r9.get("message_waiting_to_be_sent") instanceof Long) == false) goto L48;
        r11 = ((Long) r9.get("message_waiting_to_be_sent")).longValue();
    L38:
        if (r9.containsKey("partial_upload_info") == true) goto L40;
    L42:
        r10 = 0;
        goto L44
    L40:
        if ((r9.get("partial_upload_info") instanceof Long) == false) goto L42;
        r10 = ((Long) r9.get("partial_upload_info")).longValue();
        goto L44
    L27:
        ErrorParams r14 = new ErrorParams(this.f, this.g, Event.message_send, ErrorType.Network, ErrorLevel.Fatal, r27.getErrorCode(), null, "chatWindow", r27.getDebugMsg(), Boolean.TRUE, r2.a(false), r2.c(), r2.b());
        r14.setErrorStatus(r27.getStatus());
        AppreciableKit.getInstance().error(r14);
        goto L28
    L8:
        r4 = 2;
        goto L9
    }

    public final void v(String r10, String r11, Message.Type r12) {
        String r2 = null;
        PerfLog.start("send_" + z1b.b.a(r12), this.c, null);
        Log.d("MessageSendPerf", "sendStart:" + ThreadMethodProxy.currentThread());
        if (TextUtils.isEmpty(r10) == true) goto L5;
        ((ConcurrentHashMap) this.n).put(r10, r11);
    L5:
        c r13 = new c();
        r13.c = this.c;
        r13.F = SystemClock.elapsedRealtime();
        Chat r0 = this.d;
        if (r0 != null) goto L8;
    L14:
        r13.g = r12;
        r13.a = AppreciableKit.getInstance().start(this.f, this.g, Event.message_on_screen, "chatWindow", false);
        r13.b = AppreciableKit.getInstance().start(this.f, this.g, Event.message_send, "chatWindow", true);
        r13.I = this.h;
        Chat r14 = this.d;
        if (r14 == null) goto L17;
        r14.getId();
    L17:
        r13.t = this.l;
        r13.u = this.m;
        if (TextUtils.isEmpty(r11) == false) goto L20;
        r11 = "default";
    L20:
        ((ConcurrentHashMap) this.o).put(r11, r13);
        CopyOnWriteArrayList r15 = mkb.c.a;
        Intrinsics.checkNotNullParameter(r13, "reportData");
        Iterator r16 = mkb.c.a.iterator();
    L22:
        if (r16.hasNext() == false) goto L24;
        ((mkb.b) r16.next()).b();
        goto L22
    L24:
        String r17 = this.c;
        Chat r18 = this.d;
        if (r18 == null) goto L27;
        r2 = r18.getId();
    L27:
        Chat r19 = this.d;
        if (r19 != null) goto L30;
    L32:
        int r110 = -1;
    L33:
        long r1 = SystemClock.elapsedRealtime();
        CopyOnWriteArrayList r111 = mkb.d.a;
        Intrinsics.checkNotNullParameter(r17, "contextId");
        Iterator r112 = mkb.d.a.iterator();
    L35:
        if (r112.hasNext() == false) goto L37;
        ((mkb.a) r112.next()).c(r17, r2, r110, r1);
        goto L35
    L37:
        return;
    L30:
        if (r19.getType() == null) goto L32;
        r110 = this.d.getType().getNumber();
        goto L33
    L8:
        if (r0.isSecret() == false) goto L11;
        this.g = Scene.SecretChat;
        goto L14
    L11:
        if (this.d.isThread() == false) goto L13;
        this.g = Scene.Thread;
        goto L14
    L13:
        this.g = Scene.Chat;
        goto L14
    }
}

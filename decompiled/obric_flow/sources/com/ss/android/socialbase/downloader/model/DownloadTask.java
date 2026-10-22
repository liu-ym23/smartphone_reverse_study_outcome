package com.ss.android.socialbase.downloader.model;

import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService;
import com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
import td.c;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DownloadInfo f15878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f15879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f15880c;
    public final ConcurrentHashMap d;
    public final ConcurrentHashMap e;
    public final ConcurrentHashMap f;
    public IDownloadNotificationEventListener g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public IDownloadInterceptor f15881h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public IDownloadDepend f15882i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public IDownloadMonitorDepend f15883j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final DownloadInfo.Builder f15884k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public IDownloadForbiddenHandler f15885l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public IDownloadDiskSpaceHandler f15886m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public INotificationClickCallback f15887n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f15888o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public IDownloadFileUriProvider f15889p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final CopyOnWriteArrayList f15890q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f15891r;
    public final DownloadTimingInfo s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final DownloadThreadInfo f15892t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public JSONObject f15893u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f15894v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f15895w;

    public DownloadTask() {
        this.f15879b = new ConcurrentHashMap();
        this.f15880c = new ConcurrentHashMap();
        this.f15888o = false;
        this.f15890q = new CopyOnWriteArrayList();
        this.f15891r = false;
        this.s = new DownloadTimingInfo();
        this.f15892t = new DownloadThreadInfo();
        this.f15895w = true;
        this.f15884k = new DownloadInfo.Builder();
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
        this.f = new ConcurrentHashMap();
    }

    public final DownloadTask a(int r5, IDownloadListener r10) {
        if (r10 == null) goto L18;
        ConcurrentHashMap r11 = this.d;
        monitor-enter(r11);
        this.d.put(Integer.valueOf(r5), r10);     // Catch: Throwable -> L15
        monitor-exit(r11);     // Catch: Throwable -> L15
        ConcurrentHashMap r12 = this.f15879b;
        ListenerType r13 = ListenerType.f15280a;
        r12.put(r13, r10);
        ConcurrentHashMap r14 = this.f15880c;
        monitor-enter(r14);
        this.f15880c.put(Integer.valueOf(r5), r13);     // Catch: Throwable -> L12
        monitor-exit(r14);     // Catch: Throwable -> L12
        return this;
    L12:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        throw th;
    L18:
        return this;
    }

    public final void b(int r5, IDownloadListener r10) {
        if (r10 == null) goto L18;
        ConcurrentHashMap r11 = this.f;
        monitor-enter(r11);
        this.f.put(Integer.valueOf(r5), r10);     // Catch: Throwable -> L15
        monitor-exit(r11);     // Catch: Throwable -> L15
        ConcurrentHashMap r12 = this.f15879b;
        ListenerType r13 = ListenerType.f15282c;
        r12.put(r13, r10);
        ConcurrentHashMap r14 = this.f15880c;
        monitor-enter(r14);
        this.f15880c.put(Integer.valueOf(r5), r13);     // Catch: Throwable -> L12
        monitor-exit(r14);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        throw th;
    }

    public final DownloadTask c(int r5, IDownloadListener r10) {
        if (r10 == null) goto L18;
        ConcurrentHashMap r11 = this.e;
        monitor-enter(r11);
        this.e.put(Integer.valueOf(r5), r10);     // Catch: Throwable -> L15
        monitor-exit(r11);     // Catch: Throwable -> L15
        ConcurrentHashMap r12 = this.f15879b;
        ListenerType r13 = ListenerType.f15281b;
        r12.put(r13, r10);
        ConcurrentHashMap r14 = this.f15880c;
        monitor-enter(r14);
        this.f15880c.put(Integer.valueOf(r5), r13);     // Catch: Throwable -> L12
        monitor-exit(r14);     // Catch: Throwable -> L12
        return this;
    L12:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        throw th;
    L18:
        return this;
    }

    public final int d() {
        if (DownloadSetting.f.a("fix_anr_remove_report_idle_status", 0) > 0) goto L12;
        long r5 = System.currentTimeMillis();
        f();
        DownloadInfo.Builder r10 = this.f15884k;
        r10.getClass();
        this.f15878a = new DownloadInfo(r10);
        DownloadTimingInfo r11 = this.s;
        r11.f15902a = r5;
        r11.f15903b = System.currentTimeMillis();
        IDownloadProcessDispatcherService r12 = (IDownloadProcessDispatcherService) DownloadServiceManager.a(IDownloadProcessDispatcherService.class);
        if (r12.a(this.f15878a.l()) != null) goto L7;
        ((IDownloadMonitorHelperService) DownloadServiceManager.a(IDownloadMonitorHelperService.class)).a(this);
    L7:
        r12.a(this);
        DownloadInfo r13 = this.f15878a;
        if (r13 != null) goto L11;
        return 0;
    L11:
        return r13.l();
    L12:
        long r14 = System.currentTimeMillis();
        f();
        DownloadInfo.Builder r15 = this.f15884k;
        r15.getClass();
        this.f15878a = new DownloadInfo(r15);
        DownloadTimingInfo r16 = this.s;
        r16.f15902a = r14;
        r16.f15903b = System.currentTimeMillis();
        int r17 = this.f15878a.l();
        ((IDownloadProcessDispatcherService) DownloadServiceManager.a(IDownloadProcessDispatcherService.class)).a(this);
        return r17;
    }

    public final int e() {
        DownloadInfo r5 = this.f15878a;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.l();
    }

    public final void f() {
    L22:
        th = move-exception;
        c.e("Error:", th, "DownloadTask", "beforeBuild");
        return;
    L4:
        if (TextUtils.isEmpty(this.f15884k.f15871z) == true) goto L117;
        JSONObject r5 = DownloadSetting.g;     // Catch: Throwable -> L22
        if (r5 == null) goto L118;
        JSONObject r10 = r5.optJSONObject(this.f15884k.f15871z);     // Catch: Throwable -> L22
        if (r10 == null) goto L119;
        JSONObject r11 = r10.optJSONObject("replace_download_task_param");     // Catch: Throwable -> L22
        this.f15893u = r11;     // Catch: Throwable -> L22
        if (r11 != null) goto L16;
        return;
    L16:
        if (r11.has("ignore_interceptor") == false) goto L25;
        DownloadInfo.Builder r12 = this.f15884k;     // Catch: Throwable -> L22
        if (this.f15893u.optInt("ignore_interceptor") <= 0) goto L20;
        boolean r13 = true;
    L21:
        r12.H = r13;     // Catch: Throwable -> L22
        goto L25
    L20:
        r13 = false;
    L25:
        if (this.f15893u.has("inner_save_path") == false) goto L34;
        DownloadInfo.Builder r14 = this.f15884k;     // Catch: Throwable -> L22
        String r15 = DownloadDirUtils.f16126b;     // Catch: Throwable -> L22
        Downloader.b(((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).e()).getClass();     // Catch: Throwable -> L22
        File r16 = null;
        if (TextUtils.isEmpty(null) == true) goto L32;
        File r17 = new File(null);     // Catch: Throwable -> L22
        if (DownloadDirUtils.b(r17) == false) goto L32;
        r16 = r17;
    L32:
        r14.d = DownloadDirUtils.a(r16);     // Catch: Throwable -> L22
    L34:
        if (this.f15893u.has("auto_remove_callback") == false) goto L41;
        if (this.f15893u.optInt("auto_remove_callback") <= 0) goto L38;
        boolean r18 = true;
    L39:
        this.f15891r = r18;     // Catch: Throwable -> L22
        goto L41
    L38:
        r18 = false;
    L41:
        if (this.f15893u.has("extra") == false) goto L44;
        DownloadInfo.Builder r19 = this.f15884k;     // Catch: Throwable -> L22
        r19.g = this.f15893u.optString("extra");     // Catch: Throwable -> L22
    L44:
        if (this.f15893u.has("only_wifi") == false) goto L51;
        DownloadInfo.Builder r20 = this.f15884k;     // Catch: Throwable -> L22
        if (this.f15893u.optInt("only_wifi") <= 0) goto L48;
        boolean r21 = true;
    L49:
        r20.f = r21;     // Catch: Throwable -> L22
        goto L51
    L48:
        r21 = false;
    L51:
        if (this.f15893u.has("extra_headers") == false) goto L60;
        JSONObject r22 = this.f15893u.optJSONObject("extra_headers");     // Catch: Throwable -> L22
        if (r22 == null) goto L60;
        ArrayList r23 = new ArrayList();     // Catch: Throwable -> L22
        Iterator<String> r110 = r22.keys();     // Catch: Throwable -> L22
    L56:
        if (r110.hasNext() == false) goto L58;
        String r111 = r110.next();     // Catch: Throwable -> L22
        r23.add(new HttpHeader(r111, r22.optString(r111)));     // Catch: Throwable -> L22
        goto L56
    L58:
        this.f15884k.f15854h = r23;     // Catch: Throwable -> L22
    L60:
        if (this.f15893u.has("max_bytes") == false) goto L63;
        DownloadInfo.Builder r24 = this.f15884k;     // Catch: Throwable -> L22
        r24.f15855i = this.f15893u.optInt("max_bytes");     // Catch: Throwable -> L22
    L63:
        if (this.f15893u.has("retry_count") == false) goto L66;
        DownloadInfo.Builder r25 = this.f15884k;     // Catch: Throwable -> L22
        r25.f15856j = this.f15893u.optInt("retry_count");     // Catch: Throwable -> L22
    L66:
        if (this.f15893u.has("force") == false) goto L73;
        DownloadInfo.Builder r26 = this.f15884k;     // Catch: Throwable -> L22
        if (this.f15893u.optInt("force") <= 0) goto L70;
        boolean r27 = true;
    L71:
        r26.f15858l = r27;     // Catch: Throwable -> L22
        goto L73
    L70:
        r27 = false;
    L73:
        if (this.f15893u.has("show_notification") == false) goto L80;
        DownloadInfo.Builder r28 = this.f15884k;     // Catch: Throwable -> L22
        if (this.f15893u.optInt("show_notification") <= 0) goto L77;
        boolean r29 = true;
    L78:
        r28.f15859m = r29;     // Catch: Throwable -> L22
        goto L80
    L77:
        r29 = false;
    L80:
        if (this.f15893u.has("show_notification_for_auto_resumed") == false) goto L87;
        DownloadInfo.Builder r30 = this.f15884k;     // Catch: Throwable -> L22
        if (this.f15893u.optInt("show_notification_for_auto_resumed") <= 0) goto L84;
        boolean r31 = true;
    L85:
        r30.f15863q = r31;     // Catch: Throwable -> L22
        goto L87
    L84:
        r31 = false;
    L87:
        if (this.f15893u.has("executor_group") == false) goto L90;
        DownloadInfo.Builder r32 = this.f15884k;     // Catch: Throwable -> L22
        r32.A = this.f15893u.optInt("executor_group");     // Catch: Throwable -> L22
    L90:
        if (this.f15893u.has("ttnet_protect_timeout") == false) goto L93;
        DownloadInfo.Builder r33 = this.f15884k;     // Catch: Throwable -> L22
        r33.E = this.f15893u.optLong("ttnet_protect_timeout");     // Catch: Throwable -> L22
    L93:
        if (this.f15893u.has("add_ttnet_common_param") == false) goto L100;
        DownloadInfo.Builder r34 = this.f15884k;     // Catch: Throwable -> L22
        if (this.f15893u.optInt("add_ttnet_common_param") <= 0) goto L97;
        boolean r35 = true;
    L98:
        r34.F = r35;     // Catch: Throwable -> L22
        goto L100
    L97:
        r35 = false;
    L100:
        if (this.f15893u.has("distinct_directory") == false) goto L107;
        DownloadInfo.Builder r36 = this.f15884k;     // Catch: Throwable -> L22
        if (this.f15893u.optInt("distinct_directory") <= 0) goto L104;
        boolean r37 = true;
    L105:
        r36.G = r37;     // Catch: Throwable -> L22
        goto L107
    L104:
        r37 = false;
    L107:
        if (this.f15893u.has("fast_download") == true) goto L109;
        return;
    L109:
        if (this.f15893u.optInt("fast_download") <= 0) goto L122;
        this.f15884k.J = true;     // Catch: Throwable -> L22
        return;
    L122:
        return;
    L119:
        return;
    L118:
        return;
    }

    public final void b() {
        ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).a(new AnonymousClass1(this));
    }

    public DownloadTask a(long r5) {
        this.f15884k.f15862p = r5;
        return this;
    }

    public final void b(int r5, IDownloadListener r10, ListenerType r11, boolean r12) {
        ConcurrentHashMap r13 = a(r11);
        if (r13 != null) goto L9;
        if (r12 == true) goto L6;
        return;
    L6:
        if (this.f15879b.containsKey(r11) == false) goto L46;
        this.f15879b.remove(r11);
        return;
    L46:
        return;
    L9:
        monitor-enter(r13);
        if (r12 == true) goto L12;
        r13.remove(Integer.valueOf(r5));     // Catch: Throwable -> L14
        ConcurrentHashMap r14 = this.f15880c;     // Catch: Throwable -> L14
        monitor-enter(r14);     // Catch: Throwable -> L14
        ListenerType r15 = (ListenerType) this.f15880c.get(Integer.valueOf(r5));     // Catch: Throwable -> L30
        if (r15 != null) goto L28;
    L32:
        monitor-exit(r14);     // Catch: Throwable -> L30
    L33:
        monitor-exit(r13);     // Catch: Throwable -> L14
        return;
    L28:
        if (this.f15879b.containsKey(r15) == false) goto L32;
        this.f15879b.remove(r15);     // Catch: Throwable -> L30
        this.f15880c.remove(Integer.valueOf(r5));     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L12:
        if (this.f15879b.containsKey(r11) == false) goto L16;
        r10 = (IDownloadListener) this.f15879b.get(r11);     // Catch: Throwable -> L14
        this.f15879b.remove(r11);     // Catch: Throwable -> L14
    L16:
        if (r10 == null) goto L33;
        Iterator r16 = r13.entrySet().iterator();     // Catch: Throwable -> L14
    L19:
        if (r16.hasNext() == false) goto L33;
        if (((Map.Entry) r16.next()).getValue() != r10) goto L19;
        r16.remove();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public final synchronized int c() {
        monitor-enter(this);
        ListenerType r5 = ListenerType.f15280a;     // Catch: Throwable -> L6
        IDownloadListener r10 = (IDownloadListener) this.f15879b.get(r5);     // Catch: Throwable -> L6
        if (r10 != null) goto L8;
        ListenerType r11 = ListenerType.f15281b;     // Catch: Throwable -> L6
        r10 = (IDownloadListener) this.f15879b.get(r11);     // Catch: Throwable -> L6
    L8:
        if (r10 == null) goto L10;
        this.f15894v = r10.hashCode();     // Catch: Throwable -> L6
    L10:
        int r12 = this.f15894v;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r12;
    L6:
        th = move-exception;
        throw th;
    }

    public final void a() {
        DownloadInfo r5 = this.f15878a;
        if (r5 != null) goto L5;
    L10:
        ListenerType r10 = ListenerType.f15280a;
        ConcurrentHashMap r11 = a(r10);
        if (r11 != null) goto L13;
        Logger.a("DownloadTask", e(), "addListenerToDownloadingSameTask", "ListenerType is null");
    L19:
        ListenerType r12 = ListenerType.f15281b;
        ConcurrentHashMap r13 = a(r12);
        if (r13 != null) goto L22;
        Logger.a("DownloadTask", e(), "addListenerToDownloadingSameTask", "ListenerType is null");
    L28:
        ((IDownloadMonitorHelperService) DownloadServiceManager.a(IDownloadMonitorHelperService.class)).a(this.f15883j, this.f15878a, new BaseException(PointerIconCompat.TYPE_HELP, "has another same task, add Listener to old task"));
        return;
    L22:
        Iterator r14 = r13.values().iterator();
    L24:
        if (r14.hasNext() == false) goto L28;
        IDownloadListener r15 = (IDownloadListener) r14.next();
        if (r15 == null) goto L24;
        ((IDownloadProcessDispatcherService) DownloadServiceManager.a(IDownloadProcessDispatcherService.class)).a(e(), r15, r12);
        goto L24
    L13:
        Iterator r16 = r11.values().iterator();
    L15:
        if (r16.hasNext() == false) goto L19;
        IDownloadListener r17 = (IDownloadListener) r16.next();
        if (r17 == null) goto L15;
        ((IDownloadProcessDispatcherService) DownloadServiceManager.a(IDownloadProcessDispatcherService.class)).a(e(), r17, r10);
        goto L15
    L5:
        if (Logger.a(r5) == false) goto L7;
        Logger.a("DownloadTask", this.f15878a, "addListenerToDownloadingSameTask", "Same task just tryDownloading, so add listener in last task instead of tryDownload");
    L7:
        DownloadInfo r18 = this.f15878a;
        if (r18.O0 == true) goto L10;
        r18.O0 = true;
        goto L10
    }

    public static void b(ConcurrentHashMap r5, ConcurrentHashMap r10) {
        r5.clear();
        Iterator r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Map.Entry r12 = (Map.Entry) r11.next();
        if (r12.getValue() == null) goto L4;
        r5.put(r12.getKey(), r12.getValue());
        goto L4
    }

    public final ConcurrentHashMap a(ListenerType r5) {
        if (r5 != ListenerType.f15280a) goto L7;
        return this.d;
    L7:
        if (r5 != ListenerType.f15281b) goto L11;
        return this.e;
    L11:
        if (r5 == ListenerType.f15282c) goto L13;
        return null;
    L13:
        return this.f;
    }

    public static int[] a(Set r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        if (r5.isEmpty() == true) goto L14;
        Object[] r10 = r5.toArray();
        int[] r11 = new int[r10.length];
        int r12 = 0;
    L8:
        if (r12 >= r10.length) goto L10;
        r11[r12] = ((Integer) r10[r12]).intValue();
        r12 = r12 + 1;
        goto L8
    L10:
        return r11;
    L14:
        return null;
    }

    public final void a(int r5, IDownloadListener r10, ListenerType r11, boolean r12) {
        if (r10 == null) goto L29;
        if (r12 == false) goto L15;
        ConcurrentHashMap r13 = this.f15879b;
        if (r13 == null) goto L15;
        r13.put(r11, r10);
        ConcurrentHashMap r14 = this.f15880c;
        monitor-enter(r14);
        this.f15880c.put(Integer.valueOf(r5), r11);     // Catch: Throwable -> L12
        monitor-exit(r14);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        ConcurrentHashMap r15 = a(r11);
        if (r15 != null) goto L18;
        return;
    L18:
        monitor-enter(r15);
        r15.put(Integer.valueOf(r5), r10);     // Catch: Throwable -> L22
        monitor-exit(r15);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public final void a(DownloadTask r5) {
        Iterator r10 = r5.f15879b.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L74;
        Map.Entry r11 = (Map.Entry) r10.next();
        if (r11 == null) goto L4;
        if (this.f15879b.containsKey(r11.getKey()) == true) goto L4;
        this.f15879b.put(r11.getKey(), r11.getValue());
        goto L4
    L74:
    L30:
        th = move-exception;
        th.printStackTrace();
        return;
    L12:
        if (r5.d.size() == 0) goto L33;
        ConcurrentHashMap r12 = this.d;     // Catch: Throwable -> L30
        monitor-enter(r12);     // Catch: Throwable -> L30
        ConcurrentHashMap r13 = this.d;     // Catch: Throwable -> L23
        ConcurrentHashMap r14 = r5.d;     // Catch: Throwable -> L23
        if (r13 == null) goto L25;
        if (r14 == null) goto L25;
        Iterator r15 = r14.entrySet().iterator();     // Catch: Throwable -> L23
    L21:
        if (r15.hasNext() == false) goto L25;
        r13.remove(((Map.Entry) r15.next()).getKey());     // Catch: Throwable -> L23
    L25:
        a(r5.d, this.d);     // Catch: Throwable -> L23
        monitor-exit(r12);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L33:
        if (r5.e.size() == 0) goto L52;
        ConcurrentHashMap r16 = this.e;     // Catch: Throwable -> L30
        monitor-enter(r16);     // Catch: Throwable -> L30
        ConcurrentHashMap r17 = this.e;     // Catch: Throwable -> L44
        ConcurrentHashMap r18 = r5.e;     // Catch: Throwable -> L44
        if (r17 == null) goto L46;
        if (r18 == null) goto L46;
        Iterator r19 = r18.entrySet().iterator();     // Catch: Throwable -> L44
    L42:
        if (r19.hasNext() == false) goto L46;
        r17.remove(((Map.Entry) r19.next()).getKey());     // Catch: Throwable -> L44
    L46:
        a(r5.e, this.e);     // Catch: Throwable -> L44
        monitor-exit(r16);     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L52:
        if (r5.f.size() == 0) goto L88;
        ConcurrentHashMap r20 = this.f;     // Catch: Throwable -> L30
        monitor-enter(r20);     // Catch: Throwable -> L30
        ConcurrentHashMap r21 = this.f;     // Catch: Throwable -> L63
        ConcurrentHashMap r22 = r5.f;     // Catch: Throwable -> L63
        if (r21 == null) goto L65;
        if (r22 == null) goto L65;
        Iterator r23 = r22.entrySet().iterator();     // Catch: Throwable -> L63
    L61:
        if (r23.hasNext() == false) goto L65;
        r21.remove(((Map.Entry) r23.next()).getKey());     // Catch: Throwable -> L63
    L65:
        a(r5.f, this.f);     // Catch: Throwable -> L63
        monitor-exit(r20);     // Catch: Throwable -> L63
        return;
    L63:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    }

    public static void a(ConcurrentHashMap r5, ConcurrentHashMap r10) {
        if (r5 == null) goto L9;
        if (r10 == null) goto L11;
        Iterator r11 = r5.entrySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L12;
        Map.Entry r12 = (Map.Entry) r11.next();
        r10.put(r12.getKey(), r12.getValue());
        goto L7
    L12:
        return;
    L11:
        return;
    }

    public final void a(ListenerType r5, IDownloadListener r10) {
        if (this.f15891r == true) goto L5;
        return;
    L5:
        if (r5 != ListenerType.d) goto L8;
        return;
    L8:
        if (Logger.a(this.f15878a) == false) goto L11;
        Logger.a("DownloadTask", this.f15878a, "removeCallback", "ListenerType:" + r5 + " listener:" + r10);
    L11:
        if (r10 != null) goto L13;
        int r11 = 0;
    L14:
        b(r11, r10, r5, false);
        return;
    L13:
        r11 = r10.hashCode();
        goto L14
    }
}

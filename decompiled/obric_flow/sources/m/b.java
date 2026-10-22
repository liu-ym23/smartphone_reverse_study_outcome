package m;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import androidx.core.app.NotificationCompat;
import androidx.core.math.MathUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.crash.n;
import com.lynx.tasm.LynxView;
import com.obric.oui.window.bean.WindowSizeClass;
import com.obric.oui.window.listener.NextLiveData;
import com.obric.oui.window.listener.WindowConfigChangeListener;
import com.obric.oui.window.listener.WindowConfigChangeListener$Companion$setConfigInternal$1;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Pattern;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import org.threeten.bp.LocalTime;
import org.threeten.bp.OffsetTime;
import org.threeten.bp.temporal.ChronoField;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements de.b, com.bytedance.sdk.xbridge.cn.protocol.f, e5.a, jn.e, com.obric.flow.cardlistpage.ui.k, org.threeten.bp.temporal.i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b f19858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Pattern f19859c;
    public static b d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19860a;

    class a extends HashMap<String, Integer> {
        public a() {
            put("订飞机票", 20);
            put("飞机票退票", 22);
            put("航班取消", 22);
            put("飞机票改期", 21);
            put("航班变动", 21);
            put("订火车票", 30);
            put("火车票改签", 31);
            put("火车票退票", 32);
            put("酒店订单确认", 40);
            put("酒店入住提醒", 40);
            put("酒店订单修改", 41);
            put("酒店订单取消", 42);
            put("会议日程", 50);
            put("设置日程", 5);
            put("查询地址", 6);
            put("快递", 80);
            put("还款短信", 81);
        }
    }

    public /* synthetic */ b(int r5) {
        this.f19860a = r5;
    }

    public static b e() {
        if (f19858b != null) goto L21;
        monitor-enter(b.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (f19858b != null) goto L16;
        b r5 = new b(0);     // Catch: Throwable -> L14
        f19859c = com.lynx.jsbridge.a.h();     // Catch: Exception -> L11 Throwable -> L14
    L13:
        f19858b = r5;     // Catch: Throwable -> L14
        goto L16
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
    L16:
        monitor-exit(b.class);     // Catch: Throwable -> L14
    L21:
        return f19858b;
    }

    public static void f(String r10) {
        if (n.f4062j.isEnsureEnable() == true) goto L6;
        return;
    L6:
        if (i(r10) == true) goto L9;
        return;
    L9:
        if (com.bytedance.crash.upload.n.f() == false) goto L11;
        return;
    L11:
        com.bytedance.crash.upload.b.j(null, null, Thread.currentThread().getStackTrace(), 5, r10, Thread.currentThread(), "EnsureNotReachHere");
    }

    public static void h(String r5, Throwable r10) {
        io.reactivex.exceptions.a.f(r10);
        if (n.f4057a != null) goto L6;
        return;
    L6:
        if (l9.n.f19580b != (-1)) goto L8;
        l9.n.f19580b = 5;
        JSONObject r11 = l9.c.e();
        l9.n.f19580b = mh.e.c(r11, 5, new String[]{"custom_event_settings", "npth_simple_setting", "crash_inner_limit"});
    L8:
        int r12 = l9.n.f19581c;
        if (r12 >= l9.n.f19580b) goto L12;
        l9.n.f19581c = r12 + 1;
        l9.n.a().reportCustomErr(r5, "INNER", r10);
        return;
    }

    public static boolean i(String r5) {
        if (n.f4074w == true) goto L5;
        return true;
    L5:
        if (com.bytedance.crash.p.f4081a == false) goto L21;
        n9.a r10 = l9.c.f19556c;
        TextUtils.isEmpty("core_exception_monitor");
        if (r10 == null) goto L15;
        if (r10.c("core_exception_monitor") == true) goto L12;
        return false;
    L12:
        if (r10.b(r5) == true) goto L15;
        return false;
    L15:
        if (l9.i.f19565i == false) goto L22;
        l9.i r11 = l9.i.a();
        if (r11.d("exception", r11.f19569c, false) == true) goto L23;
        return false;
    L23:
        return true;
    L22:
        return true;
    L21:
        return true;
    }

    public static NextLiveData j(LifecycleOwner r5) {
        Intrinsics.checkNotNullParameter(r5, "lifecycleOwner");
        if ((r5 instanceof Fragment) == false) goto L12;
        FragmentActivity r10 = ((Fragment) r5).getActivity();
        if (r10 == null) goto L20;
        Application r11 = r10.getApplication();
        if (r11 != null) goto L18;
        return null;
    L18:
        return ((WindowConfigChangeListener) new ViewModelProvider((ViewModelStoreOwner) r5, ViewModelProvider.AndroidViewModelFactory.getInstance(r11)).get(WindowConfigChangeListener.class)).f14903b;
    L20:
        return null;
    L12:
        if ((r5 instanceof FragmentActivity) == false) goto L19;
        Application r12 = ((FragmentActivity) r5).getApplication();
        if (r12 != null) goto L17;
        return null;
    L17:
        return ((WindowConfigChangeListener) new ViewModelProvider((ViewModelStoreOwner) r5, ViewModelProvider.AndroidViewModelFactory.getInstance(r12)).get(WindowConfigChangeListener.class)).f14903b;
    L19:
        return null;
    }

    public static void k(final FragmentActivity r10, Configuration r11, int r12, int r13) {
        int r5 = r10.hashCode();     // Catch: Exception -> L5
        ConcurrentHashMap r14 = WindowConfigChangeListener.f14902c;     // Catch: Exception -> L5
        if (r14.containsKey(Integer.valueOf(r5)) == true) goto L7;
        r10.getLifecycle().addObserver(new WindowConfigChangeListener$Companion$setConfigInternal$1(r10));     // Catch: Exception -> L5
    L7:
        r14.put(Integer.valueOf(r5), new Pair(r11, Integer.valueOf(r12)));     // Catch: Exception -> L5
    L10:
        WindowSizeClass r15 = us.a.f22451a;
        if (r10 == null) goto L67;
        float r16 = Resources.getSystem().getDisplayMetrics().density;
        float r17 = r12 / r16;
        float r18 = r13 / r16;
        Log.d("AdaptedWindowSize", "setCurrentWindowSize: widthDP = " + r17 + ",heightDp = " + r18);
        us.a.f22453c = new ss.a(r17, r18);
        WindowSizeClass r19 = WindowSizeClass.FLOATING_WINDOW;
        if (r17 >= r19.getDpSize()) goto L17;
        Log.e("AdaptedWindowSize", "error,can not be minus status!!");
        r19 = WindowSizeClass.MINUS_ERROR_SIZE;
    L53:
        if (us.a.f22451a == r19) goto L57;
        if (r19 == WindowSizeClass.MINUS_ERROR_SIZE) goto L57;
    L58:
        us.a.f22451a = r19;
        Resources r20 = r10.getResources();
        int r21 = 1;
        if (r20 == null) goto L65;
        Configuration r22 = r20.getConfiguration();
        if (r22 == null) goto L65;
        r21 = r22.orientation;
    L65:
        us.a.f22452b = r21;
        Log.d("AdaptedWindowSize", Intrinsics.stringPlus("windowMsg = ", "当前档位：" + us.a.f22451a.getBaseGridConfig().f22007a + "\n当前页面可用宽高：" + r17 + ',' + r18 + "\ndecorViewWidth：" + r12 + "，decorVideHeight: " + r13 + "\nmultiWindowMode = " + r10.isInMultiWindowMode() + '\n'));
    L57:
        if (us.a.f22452b == r10.getResources().getConfiguration().orientation) goto L67;
    L17:
        if (r17 >= r19.getDpSize()) goto L19;
    L21:
        r19 = WindowSizeClass.SMALL_SPLIT_SCREEN;
        if (r17 >= r19.getDpSize()) goto L24;
    L26:
        r19 = WindowSizeClass.SMALLER_ANDROID_SCREEN;
        if (r17 >= r19.getDpSize()) goto L29;
    L31:
        r19 = WindowSizeClass.SMALL;
        if (r17 >= r19.getDpSize()) goto L34;
    L36:
        r19 = WindowSizeClass.STANDARD;
        if (r17 >= r19.getDpSize()) goto L39;
    L41:
        r19 = WindowSizeClass.NORMAL;
        if (r17 >= r19.getDpSize()) goto L44;
    L46:
        r19 = WindowSizeClass.LARGE;
        if (r17 >= r19.getDpSize()) goto L49;
    L51:
        r19 = WindowSizeClass.OVERSIZE;
        goto L53
    L49:
        if (r17 >= WindowSizeClass.OVERSIZE.getDpSize()) goto L51;
    L44:
        if (r17 >= WindowSizeClass.LARGE.getDpSize()) goto L46;
    L39:
        if (r17 >= WindowSizeClass.NORMAL.getDpSize()) goto L41;
    L34:
        if (r17 >= WindowSizeClass.STANDARD.getDpSize()) goto L36;
    L29:
        if (r17 >= WindowSizeClass.SMALL.getDpSize()) goto L31;
    L24:
        if (r17 >= WindowSizeClass.SMALLER_ANDROID_SCREEN.getDpSize()) goto L26;
    L19:
        if (r17 >= WindowSizeClass.SMALL_SPLIT_SCREEN.getDpSize()) goto L21;
    L67:
        if (r10 == null) goto L69;
        FragmentActivity r23 = r10;
    L70:
        if (r23 == null) goto L88;
        Intrinsics.checkNotNullParameter(r23, "activity");
        LinkedHashSet r24 = us.a.d;
        if (r24.isEmpty() == false) goto L82;
        Object r25 = r23.getSystemService("window");
        if ((r25 instanceof WindowManager) == false) goto L78;
        WindowManager r26 = (WindowManager) r25;
    L79:
        if (r26 == null) goto L82;
        Point r27 = new Point();
        r26.getDefaultDisplay().getRealSize(r27);
        r24.add(Integer.valueOf(r27.x));
        r24.add(Integer.valueOf(r27.y));
        goto L82
    L78:
        r26 = null;
    L82:
        Intrinsics.checkNotNullParameter(r23, "activity");
        Resources r28 = r23.getResources();
        Pair r29 = new Pair(Integer.valueOf(r28.getDimensionPixelSize(r28.getIdentifier("status_bar_height", "dimen", "android"))), Integer.valueOf(r28.getDimensionPixelSize(r28.getIdentifier("navigation_bar_height", "dimen", "android"))));
        if (r23.isInMultiWindowMode() == false) goto L88;
        if (us.a.a(r24, r12, r29) == true) goto L88;
        us.a.a(r24, r13, r29);
    L88:
        Iterator r110 = us.a.e.iterator();
        if (r110.hasNext() == true) goto L109;
        ConcurrentHashMap r30 = WindowConfigChangeListener.f14902c;
        NextLiveData r31 = j(r10);
        if (r31 == null) goto L94;
        r31.postValue(new ss.c(us.a.f22451a, us.a.f22453c));
    L94:
        ConcurrentLinkedQueue r32 = (ConcurrentLinkedQueue) WindowConfigChangeListener.d.get(Integer.valueOf(r10.hashCode()));
        if (r32 == null) goto L107;
        Iterator r33 = r32.iterator();
    L99:
        if (r33.hasNext() == false) goto L123;
        Fragment r34 = (Fragment) ((WeakReference) r33.next()).get();
        if (r34 == null) goto L99;
        ConcurrentHashMap r111 = WindowConfigChangeListener.f14902c;
        NextLiveData r35 = j(r34);
        if (r35 == null) goto L99;
        r35.postValue(new ss.c(us.a.f22451a, us.a.f22453c));
        goto L99
    L123:
        return;
    L107:
        return;
    L109:
        if (r110.next() != null) goto L113;
        WindowSizeClass r36 = us.a.f22451a;
        ss.a r112 = us.a.f22453c;
        Intrinsics.checkNotNullParameter(r36, "windowSizeClass");
        Intrinsics.checkNotNullParameter(r112, "pageSize");
        throw null;
    L113:
        throw new ClassCastException();
    L69:
        r23 = null;
    L5:
        e = move-exception;
        Log.e("Window", Intrinsics.stringPlus("setToConfig error:", e.getMessage()));
        goto L10
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.f
    public void a(bj.a r5, cj.d r10) {
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        ki.a.d.getClass();
    }

    @Override // jn.e
    public void b(jn.f r5, View r10, boolean r11, int r12) {
        if (r5 == null) goto L13;
        int r13 = r5.getChildExpectSize();
        if (r13 == 0) goto L6;
        float r14 = r12 / r13;
    L7:
        float r15 = MathUtils.clamp(r14 * 9.0f, -9.0f, 9.0f);
        r10.setCameraDistance(1280.0f);
        if (r11 == false) goto L11;
        r10.setRotationX(r15);
        return;
    L11:
        r10.setRotationY(-r15);
        return;
    L6:
        r14 = 0.0f;
        goto L7
    }

    @Override // e5.a
    public void c(LynxView r5, float r10) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter("", "type");
        d5.b.c("Bullet", "onDetectResult() called with: view = [" + r5 + "], effectivePercentage = [" + r10 + ']');
    }

    @Override // org.threeten.bp.temporal.i
    public Object d(org.threeten.bp.temporal.d r5) {
        switch(this.f19860a) {
            case 14: goto L10;
            default: goto L4;
        };
    L4:
        ChronoField r10 = ChronoField.NANO_OF_DAY;
        if (r5.isSupported(r10) == true) goto L11;
        return null;
    L11:
        return LocalTime.ofNanoOfDay(r5.getLong(r10));
    L10:
        return OffsetTime.from(r5);
    }

    @Override // e5.a
    public void g(LynxView r5, long r10, long r11) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter("", "type");
        d5.b.c("Bullet", "onDetectCost() called with: view = [" + r5 + "], collectDuration = [" + r10 + "], calculateDuration = [" + r11 + ']');
    }

    public b(Movie r5) {
        this.f19860a = 1;
        r5.width();
        r5.height();
        new Canvas();
    }

    @Override // jn.e
    public void a(View r5) {
        if (r5 == null) goto L5;
        r5.setRotationX(0.0f);
        r5.setRotationY(0.0f);
        return;
    }
}

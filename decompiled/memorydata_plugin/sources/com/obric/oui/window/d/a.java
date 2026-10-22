package com.obric.oui.window.d;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.Log;
import android.view.WindowManager;
import com.obric.oui.window.bean.WindowSizeClass;
import com.obric.oui.window.bean.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001fJ\u001e\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004J\u0006\u0010)\u001a\u00020\u0010J\u000e\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020\u0013J\u0006\u0010.\u001a\u00020\u0015J\u001c\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004002\u0006\u0010%\u001a\u00020&H\u0007J\u0012\u00101\u001a\u00020\"2\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u0006\u00104\u001a\u00020\"J\u000e\u00105\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001fJ(\u00106\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020\nJ.\u0010:\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00040\u001c2\u0006\u0010;\u001a\u00020\u00042\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000400H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001e\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/obric/oui/window/model/AdaptedWindowSize;", "", "()V", "FULL_SCREEN", "", "MULTI_WINDOW", "NO_SUPPORT", "TAG", "", "<set-?>", "", "isHSplit", "()Z", "isInMultiWindowMode", "isVSplit", "mBaseGridColumnWidth", "", "mCurrentOrientation", "mCurrentPageSize", "Lcom/obric/oui/window/bean/AvailableWindowSize;", "mCurrentWindowSize", "Lcom/obric/oui/window/bean/WindowSizeClass;", "mLastPageSize", "mScreenMode", "getMScreenMode", "()I", "mWindowSizeInit", "sScreenSize", "", "windowConfigChangeListenersList", "Ljava/util/ArrayList;", "Lcom/obric/oui/window/interfaces/OnWindowConfigChangeListener;", "Lkotlin/collections/ArrayList;", "addListener", "", "listener", "changeScreenMode", "activity", "Landroid/app/Activity;", "width", "height", "getBaseColumnWidth", "getCurrentNestedColumnWidth", "nestedPageGridConfig", "Lcom/obric/oui/window/bean/PageGridConfig;", "getCurrentPageSize", "getCurrentWindowSizeClass", "getHeightPair", "Lkotlin/Pair;", "initScreenSize", "context", "Landroid/content/Context;", "onWindowConfigChange", "removeListener", "setCurrentWindowSize", "decorViewWidth", "decorViewHeight", "forceUseDecorSize", "contains", "key", "pair", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14897a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile WindowSizeClass f14898b;
    private static volatile int c;
    private static com.obric.oui.window.bean.a d;
    private static com.obric.oui.window.bean.a e;
    private static int f;
    private static boolean g;
    private static boolean h;
    private static Set<Integer> i;
    private static ArrayList<com.obric.oui.window.c.a> j;

    static {
        f14897a = new a();
        f14898b = WindowSizeClass.MINUS_ERROR_SIZE;
        c = 1;
        com.obric.oui.window.bean.a r0 = new com.obric.oui.window.bean.a(0.0f, 0.0f);
        d = r0;
        e = r0;
        f = -1;
        i = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        j = new ArrayList();
    }

    private a() {
    }

    private final void a(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(i, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L5;
        return;
    L5:
        WindowManager r4 = null;
        if (r2 != null) goto L8;
        Object r5 = null;
    L10:
        if (ZeusTransformUtils.instanceOf(r5, WindowManager.class) == false) goto L12;
        r4 = (WindowManager) ZeusTransformUtils.preCheckCast(r5, WindowManager.class, "com.obric.memorydata.plugin");
    L12:
        if (r4 == null) goto L16;
        Point r6 = new Point();
        r4.getDefaultDisplay().getRealSize(r6);
        i.add(Integer.valueOf(r6.x));
        i.add(Integer.valueOf(r6.y));
        return;
    L16:
        return;
    L8:
        r5 = r2.getSystemService("window");
        goto L10
    }

    private final boolean a(Set<Integer> r7, int r8, Pair<Integer, Integer> r9) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        if (r6.contains(Integer.valueOf(r8)) == true) goto L24;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L9;
        r1.add(Integer.valueOf((((Number) ZeusTransformUtils.preCheckCast(r11.next(), Number.class, "com.obric.memorydata.plugin")).intValue() - ((Number) ZeusTransformUtils.preCheckCast(r9.getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue()) - ((Number) ZeusTransformUtils.preCheckCast(r9.getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue()));
        goto L6
    L9:
        if (((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin")).contains(Integer.valueOf(r8)) == true) goto L24;
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r12.iterator();
    L12:
        if (r13.hasNext() == false) goto L15;
        r2.add(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r13.next(), Number.class, "com.obric.memorydata.plugin")).intValue() - ((Number) ZeusTransformUtils.preCheckCast(r9.getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue()));
        goto L12
    L15:
        if (((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin")).contains(Integer.valueOf(r8)) == true) goto L24;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r14.iterator();
    L18:
        if (r16.hasNext() == false) goto L21;
        r15.add(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r16.next(), Number.class, "com.obric.memorydata.plugin")).intValue() - ((Number) ZeusTransformUtils.preCheckCast(r9.getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue()));
        goto L18
    L21:
        if (((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin")).contains(Integer.valueOf(r8)) == true) goto L24;
        return false;
    L24:
        return true;
    }

    public final WindowSizeClass a(Activity r6, int r7, int r8, boolean r9) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L63;
        float r10 = Resources.getSystem().getDisplayMetrics().density;
        float r0 = r7 / r10;
        float r1 = r8 / r10;
        Log.d("AdaptedWindowSize", "setCurrentWindowSize: widthDP = " + r0 + ",heightDp = " + r1);
        d = new com.obric.oui.window.bean.a(r0, r1);
        if (r0 >= WindowSizeClass.FLOATING_WINDOW.getDpSize()) goto L9;
        Log.e("AdaptedWindowSize", "error,can not be minus status!!");
        WindowSizeClass r11 = WindowSizeClass.MINUS_ERROR_SIZE;
    L45:
        if (f14898b == r11) goto L49;
        if (r11 == WindowSizeClass.MINUS_ERROR_SIZE) goto L49;
    L50:
        f14898b = r11;
        Resources r12 = ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin");
        int r13 = 1;
        if (r12 == null) goto L57;
        Configuration r14 = r12.getConfiguration();
        if (r14 == null) goto L57;
        r13 = r14.orientation;
    L57:
        c = r13;
        StringBuilder r15 = new StringBuilder().append("当前档位：").append(f14898b.getBaseGridConfig().a()).append("\n当前页面可用宽高：").append(r0).append(',').append(r1).append("\ndecorViewWidth：").append(r7).append("，decorVideHeight: ").append(r8).append("\nmultiWindowMode = ");
        if (Build.VERSION.SDK_INT < 24) goto L60;
        boolean r16 = r5.isInMultiWindowMode();
    L61:
        Log.d("AdaptedWindowSize", Intrinsics.stringPlus("windowMsg = ", r15.append(r16).append('\n').toString()));
        goto L63
    L60:
        r16 = false;
    L49:
        if (c == ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getConfiguration().orientation) goto L63;
    L9:
        if (r0 < WindowSizeClass.FLOATING_WINDOW.getDpSize()) goto L14;
        if (r0 >= WindowSizeClass.SMALL_SPLIT_SCREEN.getDpSize()) goto L14;
        r11 = WindowSizeClass.FLOATING_WINDOW;
    L14:
        if (r0 < WindowSizeClass.SMALL_SPLIT_SCREEN.getDpSize()) goto L19;
        if (r0 >= WindowSizeClass.SMALLER_ANDROID_SCREEN.getDpSize()) goto L19;
        r11 = WindowSizeClass.SMALL_SPLIT_SCREEN;
    L19:
        if (r0 < WindowSizeClass.SMALLER_ANDROID_SCREEN.getDpSize()) goto L24;
        if (r0 >= WindowSizeClass.SMALL.getDpSize()) goto L24;
        r11 = WindowSizeClass.SMALLER_ANDROID_SCREEN;
    L24:
        if (r0 < WindowSizeClass.SMALL.getDpSize()) goto L29;
        if (r0 >= WindowSizeClass.STANDARD.getDpSize()) goto L29;
        r11 = WindowSizeClass.SMALL;
    L29:
        if (r0 < WindowSizeClass.STANDARD.getDpSize()) goto L34;
        if (r0 >= WindowSizeClass.NORMAL.getDpSize()) goto L34;
        r11 = WindowSizeClass.STANDARD;
    L34:
        if (r0 < WindowSizeClass.NORMAL.getDpSize()) goto L39;
        if (r0 >= WindowSizeClass.LARGE.getDpSize()) goto L39;
        r11 = WindowSizeClass.NORMAL;
    L39:
        if (r0 >= WindowSizeClass.LARGE.getDpSize()) goto L41;
    L43:
        r11 = WindowSizeClass.OVERSIZE;
        goto L45
    L41:
        if (r0 >= WindowSizeClass.OVERSIZE.getDpSize()) goto L43;
        r11 = WindowSizeClass.LARGE;
    L63:
        return f14898b;
    }

    public final Pair<Integer, Integer> a(Activity r6) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "activity");
        Resources r7 = ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin");
        return new Pair(Integer.valueOf(r7.getDimensionPixelSize(ZeusTransformUtils.getIdentifier(r7, "status_bar_height", "dimen", "android", "com.obric.memorydata.plugin"))), Integer.valueOf(r7.getDimensionPixelSize(ZeusTransformUtils.getIdentifier(r7, "navigation_bar_height", "dimen", "android", "com.obric.memorydata.plugin"))));
    }

    public final void a() {
        Iterator<com.obric.oui.window.c.a> r4 = j.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ((com.obric.oui.window.c.a) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.oui.window.c.a.class, "com.obric.memorydata.plugin")).a(new f(f14898b, d));
        goto L4
    }

    public final void a(Activity r5, int r6, int r7) {
        Activity r8 = (Activity) ZeusTransformUtils.wrapperContextForParams(r5, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "activity");
        a((Context) ZeusTransformUtils.preCheckCast(r8, Context.class, "com.obric.memorydata.plugin"));
        Pair<Integer, Integer> r0 = a(r8);
        int r2 = 0;
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        r2 = -1;
    L16:
        f = r2;
        return;
    L5:
        if (r8.isInMultiWindowMode() == true) goto L7;
        g = false;
        h = false;
        goto L16
    L7:
        if (a(i, r6, r0) == false) goto L10;
        g = true;
    L9:
        h = false;
    L13:
        r2 = 2;
        goto L16
    L10:
        boolean r4 = a(i, r7, r0);
        g = false;
        if (r4 == false) goto L9;
        h = true;
        goto L13
    }

    public final WindowSizeClass b() {
        return f14898b;
    }

    public final com.obric.oui.window.bean.a c() {
        return d;
    }
}

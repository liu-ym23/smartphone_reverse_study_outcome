package a;

import android.app.Activity;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.android.anniex.base.service.f;
import com.bytedance.crash.util.NativeTools;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$IntProperty;
import com.obric.oui.common.style.m;
import com.obric.oui.material.c;
import com.obric.oui.material.n;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import m.b;
import mh.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import z8.g;
import zm.p;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JSONObject f15a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f16b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f17c = 0;
    public static boolean d = false;
    public static int e = 0;
    public static ArrayList f = null;
    public static volatile long g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f18h = 100;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f19i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static long f20j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static long f21k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f22l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f23m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile String f24n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile boolean f25o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static int f26p = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile long f27q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static long f28r = -1;
    public static long s = -1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static int f29t = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static MessageQueue f30u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static Field f31v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static Field f32w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static boolean f33x;

    public static /* synthetic */ void A(View r5, c[] r10) {
        z(r5, r10, false, null);
    }

    public static final void B(int r10, View r11) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        ViewGroup.LayoutParams r5 = r11.getLayoutParams();
        ViewGroup.LayoutParams r12 = null;
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r5;
    L6:
        if (r13 == null) goto L25;
        ViewGroup.LayoutParams r14 = r11.getLayoutParams();
        int r15 = 0;
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        int r16 = MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) r14);
    L12:
        ViewGroup.LayoutParams r17 = r11.getLayoutParams();
        if ((r17 instanceof ViewGroup.MarginLayoutParams) == false) goto L16;
        r12 = r17;
    L16:
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r12;
        if (r18 == null) goto L19;
        int r19 = r18.topMargin;
    L20:
        ViewGroup.LayoutParams r20 = r11.getLayoutParams();
        if ((r20 instanceof ViewGroup.MarginLayoutParams) == false) goto L23;
        r15 = MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) r20);
    L23:
        r13.setMargins(r16, r19, r15, r10);
        r11.requestLayout();
        return;
    L19:
        r19 = 0;
        goto L20
    L11:
        r16 = 0;
        goto L12
    L25:
        return;
    L5:
        r13 = null;
        goto L6
    }

    public static final void C(View r5, c r10, boolean r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "material");
        k(r5, r10);
        if (n.j() == true) goto L6;
        return;
    L6:
        if (r11 == false) goto L8;
        r5.setBackgroundColor(0);
    L8:
        if (r5 == null) goto L23;
        if (r10 != null) goto L12;
        return;
    L12:
        if (r10.f13611c == null) goto L14;
    L21:
        n.q(r12, 1, r5);
        n.a(r5, r10);
        return;
    L14:
        if (r10.g != null) goto L21;
        if (r10.f13612h != null) goto L21;
        if (r10.f13614j != null) goto L21;
        n.q(0, 1, r5);
        return;
    }

    public static final void D(Object r5, String r10, View r11) {
        Intrinsics.checkNotNullParameter(r11, "$this$setPropertyValue");
        Intrinsics.checkNotNullParameter(r10, "propertyName");
        Intrinsics.checkNotNullParameter(r5, "value");
        if (Intrinsics.areEqual(r10, "x") == false) goto L8;
        if ((r5 instanceof Float) == false) goto L128;
        r11.setX(((Number) r5).floatValue());
        return;
    L128:
        return;
    L8:
        if (Intrinsics.areEqual(r10, "y") == false) goto L13;
        if ((r5 instanceof Float) == false) goto L130;
        r11.setY(((Number) r5).floatValue());
        return;
    L130:
        return;
    L13:
        if (Intrinsics.areEqual(r10, "alpha") == false) goto L18;
        if ((r5 instanceof Float) == false) goto L132;
        r11.setAlpha(((Number) r5).floatValue());
        return;
    L132:
        return;
    L18:
        if (Intrinsics.areEqual(r10, "rotation") == false) goto L23;
        if ((r5 instanceof Float) == false) goto L134;
        r11.setRotation(((Number) r5).floatValue());
        return;
    L134:
        return;
    L23:
        if (Intrinsics.areEqual(r10, "scaleX") == false) goto L28;
        if ((r5 instanceof Float) == false) goto L136;
        r11.setScaleX(((Number) r5).floatValue());
        return;
    L136:
        return;
    L28:
        if (Intrinsics.areEqual(r10, "scaleY") == false) goto L33;
        if ((r5 instanceof Float) == false) goto L138;
        r11.setScaleY(((Number) r5).floatValue());
        return;
    L138:
        return;
    L33:
        if (Intrinsics.areEqual(r10, "translationX") == false) goto L38;
        if ((r5 instanceof Float) == false) goto L140;
        r11.setTranslationX(((Number) r5).floatValue());
        return;
    L140:
        return;
    L38:
        if (Intrinsics.areEqual(r10, "translationY") == false) goto L43;
        if ((r5 instanceof Float) == false) goto L142;
        r11.setTranslationY(((Number) r5).floatValue());
        return;
    L142:
        return;
    L43:
        if (Intrinsics.areEqual(r10, "rotationX") == false) goto L48;
        if ((r5 instanceof Float) == false) goto L144;
        r11.setRotationX(((Number) r5).floatValue());
        return;
    L144:
        return;
    L48:
        if (Intrinsics.areEqual(r10, "rotationY") == false) goto L53;
        if ((r5 instanceof Float) == false) goto L146;
        r11.setRotationY(((Number) r5).floatValue());
        return;
    L146:
        return;
    L53:
        if (Intrinsics.areEqual(r10, "scale") == false) goto L58;
        if ((r5 instanceof Float) == false) goto L148;
        Number r12 = (Number) r5;
        r11.setScaleX(r12.floatValue());
        r11.setScaleY(r12.floatValue());
        return;
    L148:
        return;
    L58:
        if (Intrinsics.areEqual(r10, AnimationProperty$IntProperty.BACKGROUND_COLOR.getPropertyName()) == false) goto L63;
        if ((r5 instanceof Integer) == false) goto L150;
        r11.setBackgroundColor(((Number) r5).intValue());
        return;
    L150:
        return;
    L63:
        if (Intrinsics.areEqual(r10, AnimationProperty$IntProperty.TEXT_COLOR.getPropertyName()) == false) goto L70;
        if ((r11 instanceof TextView) == true) goto L67;
        return;
    L67:
        if ((r5 instanceof Integer) == false) goto L153;
        ((TextView) r11).setTextColor(((Number) r5).intValue());
        return;
    L153:
        return;
    L70:
        if (Intrinsics.areEqual(r10, AnimationProperty$IntProperty.STROKE_COLOR.getPropertyName()) == false) goto L79;
        if ((r5 instanceof Integer) == false) goto L155;
        Drawable r13 = r11.getBackground();
        if ((r13 instanceof ShapeDrawable) == false) goto L156;
        Paint r14 = ((ShapeDrawable) r13).getPaint();
        if (r14.getStyle() != Paint.Style.STROKE) goto L157;
        r14.setColor(((Number) r5).intValue());
        r11.invalidate();
        return;
    L157:
        return;
    L156:
        return;
    L155:
        return;
    L79:
        if (Intrinsics.areEqual(r10, AnimationProperty$IntProperty.FILL_COLOR.getPropertyName()) == true) goto L81;
        int r15 = 0;
        if (Intrinsics.areEqual(r10, AnimationProperty$IntProperty.WIDTH.getPropertyName()) == false) goto L98;
        if ((r5 instanceof Integer) == false) goto L163;
        ViewGroup.LayoutParams r16 = r11.getLayoutParams();
        if (r16 == null) goto L164;
        Number r17 = (Number) r5;
        if (r17.intValue() <= 0) goto L96;
        r15 = r17.intValue();
    L96:
        r16.width = r15;
        r11.setLayoutParams(r16);
        r11.requestLayout();
        return;
    L164:
        return;
    L163:
        return;
    L98:
        if (Intrinsics.areEqual(r10, AnimationProperty$IntProperty.HEIGHT.getPropertyName()) == true) goto L100;
        String r18 = o(r10);     // Catch: Exception -> L110 NoSuchMethodException -> L112
        if ((r5 instanceof Integer) == false) goto L115;
        Class<?> r19 = Integer.TYPE;     // Catch: Exception -> L110 NoSuchMethodException -> L112
    L121:
        r11.getClass().getMethod(r18, new Class[]{r19}).invoke(r11, new Object[]{r5});     // Catch: Exception -> L110 NoSuchMethodException -> L112
    L170:
        return;
    L115:
        if ((r5 instanceof Float) == false) goto L118;
        r19 = Float.TYPE;     // Catch: Exception -> L110 NoSuchMethodException -> L112
        goto L121
    L118:
        if ((r5 instanceof Boolean) == false) goto L120;
        r19 = Boolean.TYPE;     // Catch: Exception -> L110 NoSuchMethodException -> L112
        goto L121
    L120:
        r19 = r5.getClass();     // Catch: Exception -> L110 NoSuchMethodException -> L112
    L112:
        e = move-exception;
        e.printStackTrace();
        return;
    L110:
        e = move-exception;
        e.printStackTrace();
        return;
    L100:
        if ((r5 instanceof Integer) == false) goto L166;
        ViewGroup.LayoutParams r20 = r11.getLayoutParams();
        if (r20 == null) goto L167;
        Number r21 = (Number) r5;
        if (r21.intValue() <= 0) goto L106;
        r15 = r21.intValue();
    L106:
        r20.height = r15;
        r11.setLayoutParams(r20);
        r11.requestLayout();
        return;
    L167:
        return;
    L166:
        return;
    L81:
        if ((r5 instanceof Integer) == false) goto L159;
        Drawable r22 = r11.getBackground();
        if ((r22 instanceof ShapeDrawable) == false) goto L160;
        Paint r23 = ((ShapeDrawable) r22).getPaint();
        if (r23.getStyle() != Paint.Style.FILL) goto L161;
        r23.setColor(((Number) r5).intValue());
        r11.invalidate();
        return;
    L161:
        return;
    L160:
        return;
    }

    public static final void F(ViewGroup r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r10 == (-1)) goto L6;
        n.p(r10, r5);
        return;
    }

    public static Message a(MessageQueue r5) {
        Field r10 = f31v;
        if (r10 != null) goto L12;
        Field r11 = Class.forName("android.os.MessageQueue").getDeclaredField("mMessages");     // Catch: Exception -> L6
        f31v = r11;     // Catch: Exception -> L6
        r11.setAccessible(true);     // Catch: Exception -> L6
        return (Message) f31v.get(r5);
    L6:
        return null;
    L12:
        return (Message) r10.get(r5);
    L9:
        return null;
    }

    public static final String b(Uri r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        if (r5.isHierarchical() == true) goto L6;
        r5 = null;
    L6:
        if (r5 != null) goto L8;
        return null;
    L8:
        return r5.getQueryParameter(r10);
    }

    public static String c(String r5) {
        if (r5.startsWith("socket:") == false) goto L7;
        return "socket";
    L7:
        if (r5.startsWith("pipe:") == false) goto L11;
        return "pipe";
    L11:
        if (r5.equals("/dev/ashmem") == false) goto L15;
        return "dev-ashmem";
    L15:
        if (r5.startsWith("anon_inode:") == false) goto L45;
        if (r5.contains("eventpoll") == false) goto L21;
        return "anon_inode-eventpoll";
    L21:
        if (r5.contains("dmabuf") == false) goto L25;
        return "anon_inode-dmabuf";
    L25:
        if (r5.contains("eventfd") == false) goto L29;
        return "anon_inode-eventfd";
    L29:
        if (r5.contains("inotify") == false) goto L33;
        return "anon_inode-inotify";
    L33:
        if (r5.contains("sync_fence") == false) goto L37;
        return "anon_inode-sync_fence";
    L37:
        if (r5.contains("timerfd") == false) goto L41;
        return "anon_inode-timerfd";
    L41:
        if (r5.contains("malitl") == false) goto L45;
        return "anon_inode-malitl";
    L45:
        if (r5.contains("/mmkv/") == false) goto L49;
        return "mmkv";
    L49:
        if (r5.contains("/dataloader/") == false) goto L53;
        return "dataloader";
    L53:
        if (r5.contains("/app_indicators/") == false) goto L56;
        return "app_indicators";
    L56:
        String[] r10 = r5.split("/");
        if (r10.length <= 0) goto L67;
        String r11 = r10[r10.length - 1];
        if (r11.contains(".db") == false) goto L63;
        return "db";
    L63:
        if (r11.endsWith(".apk") == false) goto L67;
        return "apk";
    L67:
        if (r5.startsWith("/storage") == false) goto L70;
        return "storage";
    L70:
        return "unknown";
    }

    public static JSONArray d() {
        JSONArray r5 = new JSONArray();
        ArrayList r10 = m9.c.e().f;
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.size() <= 0) goto L51;
        LinkedList r11 = new LinkedList();
        Iterator r12 = r10.iterator();
    L9:
        if (r12.hasNext() == false) goto L20;
        Activity r13 = (Activity) ((WeakReference) r12.next()).get();
        if (r13 == null) goto L9;
        Window r14 = r13.getWindow();
        if (r14 == null) goto L9;
        View r15 = r14.peekDecorView();
        if (r15 == null) goto L9;
        JSONObject r16 = new JSONObject();
        r11.add(new Pair(r15, r16));
        r5.put(r16);
    L20:
        if (r11.isEmpty() == true) goto L29;
        Pair r17 = (Pair) r11.pop();
        View r18 = (View) r17.first;
        JSONObject r19 = (JSONObject) r17.second;
        e.g(String.valueOf(r18.getClass()), "cls", r19);
        if ((r18 instanceof ViewGroup) == false) goto L20;
        ViewGroup r20 = (ViewGroup) r18;
        int r21 = r20.getChildCount();
        JSONArray r22 = new JSONArray();
        e.g(r22, "children", r19);
        int r23 = 0;
    L24:
        if (r23 >= r21) goto L20;
        View r24 = r20.getChildAt(r23);     // Catch: Throwable -> L32
        if (r24 == null) goto L28;
        JSONObject r25 = new JSONObject();
        r22.put(r25);
        r11.push(new Pair(r24, r25));
    L28:
        r23 = r23 + 1;
        goto L24
    L29:
        return r5;
    L51:
        return null;
    }

    public static JSONArray e(long r10) {
        MessageQueue r5 = r();
        JSONArray r11 = new JSONArray();
        if (r5 != null) goto L38;
    L30:
        return r11;
    L38:
        monitor-enter(r5);     // Catch: Throwable -> L33
        Message r12 = a(r5);     // Catch: Throwable -> L10
        if (r12 != null) goto L12;
        monitor-exit(r5);     // Catch: Throwable -> L10
        return r11;
    L12:
        int r13 = 0;
        int r14 = 0;
    L13:
        if (r12 == null) goto L29;
        if (r13 >= 300) goto L29;
        r13 = r13 + 1;     // Catch: Throwable -> L10
        r14 = r14 + 1;     // Catch: Throwable -> L10
        JSONObject r15 = g(r12, r10);     // Catch: Throwable -> L10
        r15.put("id", r14);     // Catch: Throwable -> L10 JSONException -> L36
    L18:
        r11.put(r15);     // Catch: Throwable -> L10
        if ((r12.getWhen() - r10) > 0) goto L21;
    L23:
        Field r16 = f32w;     // Catch: Throwable -> L10
        if (r16 != null) goto L26;
        Field r17 = Class.forName("android.os.Message").getDeclaredField("next");     // Catch: Throwable -> L10 Exception -> L28
        f32w = r17;     // Catch: Throwable -> L10 Exception -> L28
        r17.setAccessible(true);     // Catch: Throwable -> L10 Exception -> L28
        r12 = (Message) f32w.get(r12);     // Catch: Throwable -> L10 Exception -> L28
    L28:
        r12 = null;
        goto L13
    L26:
        r12 = (Message) r16.get(r12);     // Catch: Throwable -> L10 Exception -> L28
        goto L13
    L21:
        if (r13 <= 100) goto L23;
    L29:
        monitor-exit(r5);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        b.h("NPTH_CATCH", th);
        return r11;
    }

    public static JSONObject f() {
        g r5 = new g();
        r5.f = f24n;
        long r10 = g - s;
        if (r10 > 0) goto L6;
        r10 = 1;
    L6:
        r5.d = r10 * f18h;
        r5.e = f27q - f20j;
        JSONObject r11 = r5.a();
        r11.put("message", r5.f);     // Catch: Throwable -> L9
        r11.put("currentMessageCost", r5.d);     // Catch: Throwable -> L9
        r11.put("currentMessageCpu", r5.e);     // Catch: Throwable -> L9
        r11.put("currentTick", g);     // Catch: Throwable -> L9
        return r11;
    L9:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        b.h("NPTH_CATCH", th);
        return r11;
    }

    public static JSONObject g(Message r5, long r10) {
        JSONObject r11 = new JSONObject();
        r11.put("when", r5.getWhen() - r10);     // Catch: JSONException -> L6
        if (r5.getCallback() == null) goto L8;
        r11.put("callback", String.valueOf(r5.getCallback()));     // Catch: JSONException -> L6
    L8:
        r11.put("what", r5.what);     // Catch: JSONException -> L6
        if (r5.getTarget() == null) goto L11;
        r11.put("target", String.valueOf(r5.getTarget()));     // Catch: JSONException -> L6
    L12:
        r11.put("arg1", r5.arg1);     // Catch: JSONException -> L6
        r11.put("arg2", r5.arg2);     // Catch: JSONException -> L6
        Object r12 = r5.obj;     // Catch: JSONException -> L6
        if (r12 == null) goto L17;
        r11.put("obj", r12);     // Catch: JSONException -> L6
        return r11;
    L17:
        return r11;
    L11:
        r11.put("barrier", r5.arg1);     // Catch: JSONException -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static void h(File r11) {
        File r5 = new File(r11, "maps.txt");     // Catch: Throwable -> L39
        String r10 = null;
        if (r5.exists() == true) goto L5;
        String r12 = r5.getAbsolutePath();     // Catch: Throwable -> L39
    L6:
        File r13 = new File(r11, "smaps.txt");     // Catch: Throwable -> L39
        if (r13.exists() == true) goto L9;
        String r14 = r13.getAbsolutePath();     // Catch: Throwable -> L39
    L10:
        File r15 = new File(r11, "meminfo.txt");     // Catch: Throwable -> L39
        if (r15.exists() == true) goto L13;
        String r16 = r15.getAbsolutePath();     // Catch: Throwable -> L39
    L14:
        File r17 = new File(r11, "fds.txt");     // Catch: Throwable -> L39
        if (r17.exists() == true) goto L17;
        String r18 = r17.getAbsolutePath();     // Catch: Throwable -> L39
    L18:
        File r19 = new File(r11, "threads.txt");     // Catch: Throwable -> L39
        if (r19.exists() == true) goto L21;
        r10 = r19.getAbsolutePath();     // Catch: Throwable -> L39
    L21:
        File r20 = new File(r11, "logcat.txt");     // Catch: Throwable -> L39
        File r21 = new File(r11, "logerr.txt");     // Catch: Throwable -> L39
        if (r20.exists() == true) goto L24;
    L26:
        r20.getParentFile().mkdirs();     // Catch: Throwable -> L39
        p.i(r20.getAbsolutePath(), r21.getAbsolutePath(), false);     // Catch: Throwable -> L39
    L27:
        NativeTools.k().getClass();     // Catch: Throwable -> L39
        NativeTools.f(r18, r12, r14, r10, r16);     // Catch: Throwable -> L39
        File r22 = new File(r11, "pthreads.txt");     // Catch: Throwable -> L39
        if (r22.exists() == true) goto L31;
        File r23 = new File(r11, "rountines.txt");     // Catch: Throwable -> L39
        r22.getParentFile().mkdirs();     // Catch: Throwable -> L39
        NativeTools.k().m(r22.getAbsolutePath(), r23.getAbsolutePath());     // Catch: Throwable -> L39
    L31:
        File r24 = new File(r11, "malloc.txt");     // Catch: Throwable -> L39
        if (r24.exists() == true) goto L35;
        r24.getParentFile().mkdirs();     // Catch: Throwable -> L39
        NativeTools.k().t(r24.getAbsolutePath());     // Catch: Throwable -> L39
    L35:
        q(r11);     // Catch: Throwable -> L39
        File r25 = new File(r11, "viewTree.txt");     // Catch: Throwable -> L39
        if (r25.exists() == true) goto L42;
        cl.a.p(r25, d());     // Catch: Throwable -> L39
        return;
    L42:
        return;
    L24:
        if (r20.length() <= 0) goto L26;
    L17:
        r18 = null;
        goto L18
    L13:
        r16 = null;
        goto L14
    L9:
        r14 = null;
        goto L10
    L5:
        r12 = null;
    }

    public static void i(File r10, HashMap r11) {
        if (r10.exists() == false) goto L74;
        HashMap r5 = new HashMap();
        int r12 = 0;
        String r13 = null;
        BufferedReader r14 = new BufferedReader(new InputStreamReader(new FileInputStream(r10)));     // Catch: Throwable -> L33
    L20:
        th = th;
    L35:
        com.bytedance.crash.c.f4025a.getClass();
        b.h("NPTH_CATCH", th);
    L36:
        f.h(r14);
        if (r5.isEmpty() == true) goto L73;
        Iterator r15 = r5.keySet().iterator();
    L41:
        if (r15.hasNext() == false) goto L45;
        String r16 = (String) r15.next();
        int r17 = ((Integer) r5.get(r16)).intValue();
        if (r12 >= r17) goto L41;
        r13 = r16;
        r12 = r17;
        goto L41
    L45:
        r11.put("fd_leak_reason", r13);
        return;
    L73:
        return;
    L8:
        if (r14.readLine() == null) goto L38;
    L10:
        String r18 = r14.readLine();     // Catch: Throwable -> L20
        if (r18 == null) goto L36;
        String[] r19 = r18.split("\\s++");     // Catch: Throwable -> L20
        if (r19.length == 0) goto L10;
        if (r19[0].length() == 0) goto L18;
        if (r19.length < 2) goto L10;
    L25:
        String r20 = r19[r19.length - 1];     // Catch: Throwable -> L20
        if (r20.startsWith("remote_addr:") == false) goto L28;
        r20 = r19[r19.length - 2];     // Catch: Throwable -> L20
    L28:
        String r21 = c(r20);     // Catch: Throwable -> L20
        Integer r22 = (Integer) r5.get(r21);     // Catch: Throwable -> L20
        if (r22 != null) goto L30;
        r5.put(r21, 1);     // Catch: Throwable -> L20
        goto L10
    L30:
        r5.put(r21, Integer.valueOf(r22.intValue() + 1));     // Catch: Throwable -> L20
        goto L10
    L18:
        if (r19.length >= 3) goto L25;
    L38:
        return;
    L33:
        th = th;
        r14 = null;
        goto L35
    }

    public static void j(String r5) {
        long r10 = SystemClock.uptimeMillis();
        JSONObject r11 = f15a;
        if (r11 != null) goto L9;
        f15a = new JSONObject();
        f17c = r10;
    L6:
        f16b = r10;
        return;
    L9:
        r11.put(r5, r10 - f16b);     // Catch: JSONException -> L8
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void k(View r5, c r10) {
        if ((r5 instanceof com.obric.oui.common.style.b) == false) goto L18;
        com.obric.oui.common.style.b r11 = (com.obric.oui.common.style.b) r5;
        if (r11.d() == false) goto L21;
        es.a[] r12 = r10.f13613i;
        if (r12 != null) goto L12;
        r11.f(null, null);
        return;
    L12:
        if (r12.length <= 1) goto L15;
        float r13 = r5.getResources().getDisplayMetrics().density;
        m r14 = m.f12515h;
        ((com.obric.oui.common.style.b) r5).f(com.obric.oui.common.style.n.a(r12[0], r13), com.obric.oui.common.style.n.a(r12[1], r13));
        return;
    L15:
        if (r12.length != 1) goto L20;
        float r15 = r5.getResources().getDisplayMetrics().density;
        m r16 = m.f12515h;
        ((com.obric.oui.common.style.b) r5).f(com.obric.oui.common.style.n.a(r12[0], r15), null);
        return;
    L20:
        return;
    L21:
        return;
    }

    public static File l(File r5) {
        File r10 = new File(r5, "anr_trace.txt");
        if (r10.exists() == true) goto L9;
        JSONObject r11 = l9.c.e();
        if (e.c(r11, -1, new String[]{"custom_event_settings", "npth_simple_setting", "anr_with_traces_txt"}) != 1) goto L11;
        File r12 = new File("/data/anr/traces.txt");
        if (r12.exists() == false) goto L9;
        cl.a.l(r12, r10, false, 1048576);
    L11:
        return r10;
    L9:
        return r10;
    }

    public static ArrayList m() {
        if (f != null) goto L6;
        return null;
    L6:
        f25o = true;
        ArrayList r5 = new ArrayList();
        if (f.size() != e) goto L16;
        int r10 = f29t;
    L10:
        if (r10 >= f.size()) goto L12;
        r5.add((g) f.get(r10));
        r10 = r10 + 1;
        goto L10
    L12:
        int r11 = 0;
    L14:
        if (r11 >= f29t) goto L17;
        r5.add((g) f.get(r11));
        r11 = r11 + 1;
    L17:
        f25o = false;
        return r5;
    L16:
        r5.addAll(f);
        goto L17
    }

    public static final String n(String r5) {
        if (r5.length() > 0) goto L5;
        return r5;
    L5:
        return "get" + Character.toUpperCase(r5.charAt(0)) + r5.substring(1);
    }

    public static final String o(String r5) {
        if (r5.length() > 0) goto L5;
        return r5;
    L5:
        return "set" + Character.toUpperCase(r5.charAt(0)) + r5.substring(1);
    }

    public static JSONArray p() {
        JSONArray r5 = new JSONArray();
        ArrayList r10 = m();     // Catch: Throwable -> L14
        if (r10 == null) goto L16;
        Iterator r11 = r10.iterator();     // Catch: Throwable -> L14
    L8:
        if (r11.hasNext() == false) goto L16;
        g r12 = (g) r11.next();     // Catch: Throwable -> L14
        if (r12 == null) goto L8;
        r5.put(r12.a());     // Catch: Throwable -> L14
    L16:
        return r5;
    L14:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        b.h("NPTH_CATCH", th);
        goto L16
    }

    public static void q(File r10) {
        FileOutputStream r5 = null;
        Class<?> r11 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L10
        Object r12 = r11.getDeclaredMethod("getInstance", null).invoke(null, null);     // Catch: Throwable -> L10
        Method r13 = r11.getDeclaredMethod("dumpGfxInfo", new Class[]{FileDescriptor.class, String[].class});     // Catch: Throwable -> L10
        r13.setAccessible(true);     // Catch: Throwable -> L10
        FileOutputStream r14 = new FileOutputStream(new File(r10, "gfxinfo.txt"));     // Catch: Throwable -> L10
        r13.invoke(r12, new Object[]{r14.getFD(), new String[0]});     // Catch: Throwable -> L7
        f.h(r14);
        return;
    L7:
        r5 = r14;
    L8:
        f.h(r5);
    }

    public static MessageQueue r() {
        if (f30u != null) goto L11;
        if (Looper.getMainLooper() == null) goto L11;
        Looper r5 = Looper.getMainLooper();
        if (r5 != Looper.myLooper()) goto L9;
        f30u = Looper.myQueue();
        goto L11
    L9:
        f30u = r5.getQueue();
    L11:
        return f30u;
    }

    public static g s() {
        int r5 = f.size();
        int r10 = e;
        if (r5 != r10) goto L6;
        int r11 = (f29t + 1) % r10;
        f29t = r11;
        return (g) f.get(r11);
    L6:
        g r12 = new g();
        f.add(r12);
        f29t++;
        return r12;
    }

    public static final Object t(View r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$getPropertyValue");
        Intrinsics.checkNotNullParameter(r11, "propertyName");
        AnimationProperty$FloatProperty[] r5 = AnimationProperty$FloatProperty.values();
        int r12 = r5.length;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L20;
        AnimationProperty$FloatProperty r15 = r5[r14];
        r14 = r14 + 1;
        if (Intrinsics.areEqual(r15.getPropertyName(), r11) == false) goto L3;
        switch(defpackage.a.f13a[r15.ordinal()]) {
            case 1: goto L19;
            case 2: goto L73;
            case 3: goto L72;
            case 4: goto L71;
            case 5: goto L70;
            case 6: goto L69;
            case 7: goto L68;
            case 8: goto L67;
            case 9: goto L66;
            case 10: goto L65;
            default: goto L64;
        };
    L64:
        return Unit.INSTANCE;
    L65:
        return Float.valueOf(r10.getAlpha());
    L66:
        return Float.valueOf(r10.getRotationY());
    L67:
        return Float.valueOf(r10.getRotationX());
    L68:
        return Float.valueOf(r10.getTranslationY());
    L69:
        return Float.valueOf(r10.getTranslationX());
    L70:
        return Float.valueOf(r10.getRotation());
    L71:
        return Float.valueOf(r10.getScaleY());
    L72:
        return Float.valueOf(r10.getScaleX());
    L73:
        return Float.valueOf(r10.getY());
    L19:
        return Float.valueOf(r10.getX());
    L20:
        AnimationProperty$IntProperty[] r16 = AnimationProperty$IntProperty.values();
        int r17 = r16.length;
    L22:
        if (r13 >= r17) goto L57;
        AnimationProperty$IntProperty r18 = r16[r13];
        r13 = r13 + 1;
        if (Intrinsics.areEqual(r18.getPropertyName(), r11) == false) goto L22;
        switch(defpackage.a.f14b[r18.ordinal()]) {
            case 1: goto L44;
            case 2: goto L42;
            case 3: goto L36;
            case 4: goto L31;
            case 5: goto L75;
            case 6: goto L74;
            default: goto L28;
        };
    L31:
        Drawable r19 = r10.getBackground();
        if ((r19 instanceof ShapeDrawable) == false) goto L76;
        Paint r20 = ((ShapeDrawable) r19).getPaint();
        if (r20.getStyle() == Paint.Style.FILL) goto L78;
        return null;
    L78:
        return Integer.valueOf(r20.getColor());
    L76:
        return null;
    L36:
        Drawable r21 = r10.getBackground();
        if ((r21 instanceof ShapeDrawable) == false) goto L79;
        Paint r22 = ((ShapeDrawable) r21).getPaint();
        if (r22.getStyle() == Paint.Style.STROKE) goto L81;
        return null;
    L81:
        return Integer.valueOf(r22.getColor());
    L79:
        return null;
    L44:
        Drawable r23 = r10.getBackground();
        if ((r23 instanceof ColorDrawable) == true) goto L47;
        return null;
    L47:
        return Integer.valueOf(((ColorDrawable) r23).getColor());
    L28:
        throw new NoWhenBranchMatchedException();
    L74:
        return Integer.valueOf(r10.getHeight());
    L75:
        return Integer.valueOf(r10.getWidth());
    L42:
        if ((r10 instanceof TextView) == true) goto L83;
        return null;
    L83:
        return Integer.valueOf(((TextView) r10).getTextColors().getDefaultColor());
    L57:
        return r10.getClass().getMethod(n(r11), null).invoke(r10, null);
    L52:
        e = move-exception;
        e.printStackTrace();
    L56:
        return null;
    L50:
        e = move-exception;
        e.printStackTrace();
        goto L56
    }

    public static final boolean v(View r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean w(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return n.i(r5.getContext());
    }

    public static final void x(View r5, c[] r10, boolean r11, int r12, Integer r13) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "materials");
        if (r13 == null) goto L5;
        C(r5, r10[r13.intValue() - 1], r11, r12);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        Log.e("OUIMaterial", "error!! View.materials: error level=" + r13 + ", " + e);
        return;
    L5:
        if (r10.length != 1) goto L8;
        c r14 = r10[0];
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r14, "material");
        C(r5, r14, r11, r12);
        return;
    L8:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "materials");
        if (r11 == false) goto L11;
        r5.setBackgroundColor(0);
    L11:
        n.t(r5, r12, r10);
        Intrinsics.checkNotNullParameter(r5, "<this>");
        k(r5, r10[Math.min(r10.length - 1, Math.max(0, Settings.Global.getInt(r5.getContext().getContentResolver(), "obric_current_effect_id", 2) - 1))]);
    }

    public static /* synthetic */ void y(View r5, c[] r10, boolean r11, int r12, int r13) {
        if ((r13 & 2) == 0) goto L6;
        r11 = false;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 2;
    L8:
        x(r5, r10, r11, r12, null);
    }

    public static final void z(View r5, c[] r10, boolean r11, Integer r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "materials");
        if (r12 == null) goto L5;
        c r13 = r10[r12.intValue() - 1];     // Catch: Exception -> L10
        Intrinsics.checkNotNullParameter(r5, "<this>");     // Catch: Exception -> L10
        Intrinsics.checkNotNullParameter(r13, "material");     // Catch: Exception -> L10
        C(r5, r13, r11, 3);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        Log.e("OUIMaterial", "error!! View.materialsFromWindow: error level=" + r12 + ", " + e);
        return;
    L5:
        if (r10.length != 0) goto L7;
        return;
    L7:
        y(r5, r10, r11, 3, 8);
    }

    public abstract void E(Object r5, float r10);

    public abstract float u(Object r5);
}

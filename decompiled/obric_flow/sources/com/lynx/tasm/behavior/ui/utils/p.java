package com.lynx.tasm.behavior.ui.utils;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.forest.Forest;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.model.t;
import com.bytedance.gkfs.storage.io.GkFSBlockBuffer;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.ui.image.f0;
import io.reactivex.internal.util.AtomicThrowable;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import mt.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p {
    public static void A(Object r5, boolean r10) {
        if ((r5 instanceof String) == false) goto L5;
        String r11 = (String) r5;
    L6:
        JSONObject r12 = new JSONObject();
        if (r10 == false) goto L9;
        String r13 = "page_show";
    L10:
        if (r10 == false) goto L12;
        ApmDelegate r14 = com.bytedance.apm.internal.b.f3886a;
        ApmDelegate.a();
    L12:
        f4.a.k(r13, r11, r12);
        return;
    L9:
        r13 = "page_hide";
        goto L10
    L5:
        r11 = r5.getClass().getName();
        goto L6
    }

    public static PointF a(View r10, View r11, PointF r12) {
        if (r10 == null) goto L21;
        if (r10 != r11) goto L6;
        return r12;
    L6:
        float[] r5 = {r12.x, r12.y};
        ArrayList r13 = new ArrayList();
    L7:
        if (r11 == null) goto L10;
        if (r11 == r10) goto L10;
        r13.add(r11);
        r11 = (View) r11.getParent();
    L10:
        Matrix r14 = new Matrix();
        int r15 = r13.size() - 1;
    L11:
        if (r15 < 0) goto L20;
        View r16 = (View) r13.get(r15);
        r5[0] = r5[0] + r10.getScrollX();
        r5[1] = r5[1] + r10.getScrollY();
        r5[0] = r5[0] - r16.getLeft();
        r5[1] = r5[1] - r16.getTop();
        if (r16.getMatrix().isIdentity() == true) goto L18;
        r14.reset();
        if (r16.getMatrix().invert(r14) == false) goto L17;
        float[] r17 = {r5[0], r5[1]};
        r14.mapPoints(r17);
        r5[0] = r17[0];
        r5[1] = r17[1];
        goto L18
    L17:
        r5[0] = Float.MAX_VALUE;
        r5[1] = Float.MAX_VALUE;
    L18:
        r15 = r15 - 1;
        r10 = r16;
        goto L11
    L20:
        return new PointF(r5[0], r5[1]);
    L21:
        LynxLog.b(4, "ViewHelper", "convertPointFromAncestorToDescendant failed since ancestor or descendant is null");
        return r12;
    }

    public static RectF b(View r5, View r10, RectF r11) {
        if (r5 == null) goto L7;
        if (r5 != r10) goto L5;
        return r11;
    L5:
        PointF r12 = new PointF(r11.left, r11.top);
        PointF r13 = new PointF(r11.right, r11.top);
        PointF r14 = new PointF(r11.left, r11.bottom);
        PointF r15 = new PointF(r11.right, r11.bottom);
        PointF r16 = a(r5, r10, r12);
        PointF r17 = a(r5, r10, r13);
        PointF r18 = a(r5, r10, r14);
        PointF r19 = a(r5, r10, r15);
        RectF r20 = new RectF();
        r20.left = Math.min(Math.min(r16.x, r17.x), Math.min(r18.x, r19.x));
        r20.top = Math.min(Math.min(r16.y, r17.y), Math.min(r18.y, r19.y));
        r20.right = Math.max(Math.max(r16.x, r17.x), Math.max(r18.x, r19.x));
        r20.bottom = Math.max(Math.max(r16.y, r17.y), Math.max(r18.y, r19.y));
        return r20;
    L7:
        LynxLog.b(4, "ViewHelper", "convertPointFromAncestorToDescendant failed since ancestor or descendant is null");
        return r11;
    }

    public static com.bytedance.forest.utils.a c(String r5, t r10, Forest r11) {
        String r12 = "";
        if (r10.G == false) goto L8;
        WebResourceRequest r13 = r10.f4425z;
        Object r14 = ((Map) r10.f4421v.getValue()).get("x-forest-injected-ua");
        if ((r14 instanceof String) == true) goto L7;
        r14 = null;
    L7:
        String r15 = g(r13, (String) r14);
    L10:
        if (StringsKt.isBlank(r5) == false) goto L25;
        String r16 = r10.f4406b;
        if (r16.length() != 0) goto L23;
        if (r11 == null) goto L21;
        com.bytedance.forest.model.k r17 = r11.getConfig();
        if (r17 == null) goto L21;
        com.bytedance.forest.model.l r18 = r17.f4382i;
        if (r18 == null) goto L21;
        String r19 = r18.f4386b;
        if (r19 == null) goto L21;
        r16 = r19;
    L21:
        r16 = "";
    L23:
        if (r16.length() != 0) goto L27;
        return null;
    L27:
        if (StringsKt.isBlank(r5) == false) goto L29;
        r5 = "https://gecko.offline.resource/" + r16 + '/' + r10.f4407c + '/' + r10.d;
    L29:
        Set r20 = r10.F;
        if (r15 == null) goto L33;
        r12 = r15;
    L33:
        return d(r5, r20, r12);
    L25:
        r16 = "";
        goto L27
    L8:
        r15 = "";
        goto L10
    }

    public static com.bytedance.forest.utils.a d(String r16, Set r17, String r18) {
        String r5 = r16;
        Integer r10 = null;
        if (StringsKt.isBlank(r16) == false) goto L66;
        return null;
    L66:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L7
        Object r12 = Result.m124constructorimpl(Uri.parse(r16));     // Catch: Throwable -> L7
    L10:
        if (Result.m130isFailureimpl(r12) == false) goto L12;
        r12 = null;
    L12:
        Uri r13 = (Uri) r12;
        if (r13 == null) goto L64;
        String r14 = "";
        if (r17 != null) goto L21;
        if (GeckoXAdapter.Companion.canParsed(r13) == false) goto L19;
    L18:
        String r15 = "";
    L52:
        int r19 = StringsKt.r("?", 0, 6, r5);
        Integer r20 = Integer.valueOf(r19);
        if (r19 == (-1)) goto L55;
        r10 = r20;
    L55:
        if (r10 == null) goto L59;
        String r21 = r5.substring(0, r10.intValue());
        if (r21 == null) goto L59;
        r5 = r21;
    L59:
        if (r15 == null) goto L63;
        r14 = r15;
    L63:
        return new com.bytedance.forest.utils.a(r5, r14, r18);
    L19:
        r15 = r13.getQuery();
        goto L52
    L21:
        if (r17.isEmpty() == false) goto L31;
        int r22 = StringsKt.r("?", 0, 6, r5);
        Integer r23 = Integer.valueOf(r22);
        if (r22 != (-1)) goto L26;
        r23 = null;
    L26:
        if (r23 == null) goto L30;
        r15 = r5.substring(0, r23.intValue());
        if (r15 != null) goto L52;
    L30:
        r15 = r5;
        goto L52
    L31:
        LinkedHashMap r24 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.h(r17)), 16));
        Iterator r25 = r17.iterator();
    L33:
        if (r25.hasNext() == false) goto L35;
        Object r110 = r25.next();
        r24.put(r110, com.lynx.tasm.utils.b.g(r13, (String) r110));
        goto L33
    L35:
        LinkedHashMap r26 = new LinkedHashMap();
        Iterator r27 = r24.entrySet().iterator();
    L37:
        if (r27.hasNext() == false) goto L42;
        Map.Entry r28 = (Map.Entry) r27.next();
        if (r28.getValue() == null) goto L37;
        r26.put(r28.getKey(), r28.getValue());
        goto L37
    L42:
        if (r26.isEmpty() == false) goto L45;
        r26 = null;
    L45:
        if (r26 == null) goto L18;
        ArrayList r29 = new ArrayList(r26.size());
        Iterator r30 = r26.entrySet().iterator();
    L48:
        if (r30.hasNext() == false) goto L50;
        Map.Entry r31 = (Map.Entry) r30.next();
        r29.add(((String) r31.getKey()) + '=' + ((String) r31.getValue()));
        goto L48
    L50:
        r15 = CollectionsKt.q(r29, "&", null, null, 0, null, null, 62);
        if (r15 == null) goto L18;
    L64:
        f0.g(116, "CacheIdentifier", "can not parse to uri from " + r5, null);
        return null;
    L7:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r12 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public static com.bytedance.gkfs.io.a e(File r5) {
        String r10 = r5.getName();
        int r11 = StringsKt.r(".", 0, 6, r10);
        if (r10 == null) goto L11;
        Integer r12 = StringsKt.toIntOrNull(r10.substring(0, r11));
        if (r12 == null) goto L9;
        return new com.bytedance.gkfs.io.a(r12.intValue());
    L9:
        return com.bytedance.gkfs.io.a.f4852b;
    L11:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public static GkFSBlockBuffer f(com.bytedance.gkfs.io.a r10) {
        ReentrantReadWriteLock r5 = GkFSBlockBuffer.f4943m;
        ReentrantReadWriteLock.ReadLock r11 = r5.readLock();
        int r12 = 0;
        if (r5.getWriteHoldCount() != 0) goto L5;
        int r13 = r5.getReadHoldCount();
    L6:
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L9;
        r11.unlock();
        r14 = r14 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r15 = r5.writeLock();
        r15.lock();
        com.bytedance.gkfs.io.a r16 = GkFSBlockBuffer.f4940j;     // Catch: Throwable -> L19
        File r17 = r(r10);     // Catch: Throwable -> L19
        if (r17 != null) goto L13;
    L31:
        if (r12 >= r13) goto L33;
        r11.lock();
        r12 = r12 + 1;
        goto L31
    L33:
        r15.unlock();
        return null;
    L13:
        if (r17.isFile() == true) goto L21;
        GkFSBlockBuffer.f4944n.remove(r10);     // Catch: Throwable -> L19
    L15:
        if (r12 >= r13) goto L17;
        r11.lock();
        r12 = r12 + 1;
        goto L15
    L17:
        r15.unlock();
        return null;
    L21:
        com.bytedance.android.monitorV2.k r18 = GkFSBlockBuffer.f4944n;     // Catch: Throwable -> L19
        db.c r19 = (db.c) r18.get(r10);     // Catch: Throwable -> L19
        if (r19 == null) goto L26;
        GkFSBlockBuffer r20 = r19.f16631b;     // Catch: Throwable -> L19
        if (r20 == null) goto L26;
    L27:
        if (r12 >= r13) goto L29;
        r11.lock();
        r12 = r12 + 1;
        goto L27
    L29:
        r15.unlock();
        return r20;
    L26:
        r20 = new GkFSBlockBuffer(r10, r17, r17.length());     // Catch: Throwable -> L19
        r18.put(r10, new db.c(r20));     // Catch: Throwable -> L19
    L19:
        th = move-exception;
    L35:
        if (r12 >= r13) goto L37;
        r11.lock();
        r12 = r12 + 1;
        goto L35
    L37:
        r15.unlock();
        throw th;
    L5:
        r13 = 0;
        goto L6
    }

    public static String g(Object r5, String r10) {
        if ((r5 instanceof WebResourceRequest) == true) goto L5;
        return r10;
    L5:
        if ((r5 instanceof WebResourceRequest) == true) goto L7;
        r5 = null;
    L7:
        WebResourceRequest r11 = (WebResourceRequest) r5;
        if (r11 == null) goto L13;
        Map<String, String> r12 = r11.getRequestHeaders();
        if (r12 == null) goto L13;
        return r12.get("user-agent");
    L13:
        return null;
    }

    public static String h(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return r5;
    L5:
        Uri r10 = Uri.parse(r5);
        String r11 = r10.getHost();
        String r12 = r10.getPath();
        String r13 = r10.getQuery();
        if (TextUtils.isEmpty(r11) == false) goto L19;
        if (TextUtils.isEmpty(r12) == true) goto L19;
        int r14 = 0;
    L11:
        if (r14 >= r12.length()) goto L16;
        if (r12.charAt(r14) != '/') goto L16;
        r14 = r14 + 1;
    L16:
        if (r14 >= r12.length()) goto L19;
        r12 = r12.substring(r14);
    L19:
        if (TextUtils.isEmpty(r12) == false) goto L22;
        r12 = "/";
    L24:
        StringBuilder r15 = new StringBuilder();
        r15.append(r10.getScheme());
        r15.append("://");
        r15.append(r10.getHost());
        r15.append(r12);
        if (TextUtils.isEmpty(r13) == false) goto L27;
        String r16 = "";
    L28:
        r15.append(r16);
        return r15.toString();
    L27:
        r16 = td.d.b("?", r13);
        goto L28
    L22:
        if (r12.charAt(r12.length() - 1) == '/') goto L24;
        r12 = r12.concat("/");
        goto L24
    }

    public static final String i(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        Intrinsics.checkNotNullParameter(r10, "prefix");
        String r11 = StringsKt.F(r5, ".", "_");
        StringCompanionObject r12 = StringCompanionObject.INSTANCE;
        return "com.bytedance.xbridge.cn.gen.".concat(String.format("%s_Creator_%s", Arrays.copyOf(new Object[]{r10, r11}, 2)));
    }

    public static void j(LynxView r5, StringBuilder r10, int r11) {
        r10.append(r5.toString());
        LynxLog.b(r11, "LynxView", r10.toString());
    }

    public static boolean k(View r5, View r10) {
        if ((r5 instanceof ViewGroup) == true) goto L6;
        return false;
    L6:
        if (r10.getParent() == null) goto L14;
        if (r10.getParent() == r5) goto L9;
        if ((r10.getParent() instanceof View) == false) goto L14;
        r10 = (View) r10.getParent();
        goto L6
    L9:
        return true;
    L14:
        return false;
    }

    public static com.bytedance.gkfs.io.a[] l() {
        com.bytedance.gkfs.io.a r5 = GkFSBlockBuffer.f4940j;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("maxBlockId");
    L5:
        IntProgression r10 = RangesKt.downTo(r5.f4853a, 0);
        ArrayList r11 = new ArrayList(CollectionsKt.h(r10));
        Iterator<Integer> r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        r11.add(new com.bytedance.gkfs.io.a(((IntIterator) r12).nextInt()));
        goto L7
    L9:
        ArrayList r13 = new ArrayList();
        Iterator r14 = r11.iterator();
    L11:
        if (r14.hasNext() == false) goto L17;
        Object r15 = r14.next();
        com.bytedance.gkfs.io.a r16 = GkFSBlockBuffer.f4940j;
        File r17 = r((com.bytedance.gkfs.io.a) r15);
        if (r17 == null) goto L11;
        if (r17.exists() != true) goto L11;
        r13.add(r15);
        goto L11
    L17:
        Object[] r18 = r13.toArray(new com.bytedance.gkfs.io.a[0]);
        if (r18 == null) goto L22;
        return (com.bytedance.gkfs.io.a[]) r18;
    L22:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static PointF m(View r10, View r11, PointF r12) {
        if (r11 == null) goto L19;
        if (r11 != r10) goto L6;
        return r12;
    L6:
        float[] r5 = {r12.x, r12.y};
        if (r10.getMatrix().isIdentity() == true) goto L9;
        r10.getMatrix().mapPoints(r5);
    L9:
        if (r10 == r11) goto L18;
        View r13 = (View) r10.getParent();
        if (r13 == null) goto L12;
        r5[0] = r5[0] + r10.getLeft();
        r5[1] = r5[1] + r10.getTop();
        r5[0] = r5[0] - r13.getScrollX();
        r5[1] = r5[1] - r13.getScrollY();
        if (r13.getMatrix().isIdentity() == true) goto L16;
        r13.getMatrix().mapPoints(r5);
    L16:
        r10 = r13;
        goto L9
    L12:
        LynxLog.b(4, "ViewHelper", "convertPointFromDescendantToAncestor failed, parent is null.");
    L18:
        return new PointF(r5[0], r5[1]);
    L19:
        LynxLog.b(4, "ViewHelper", "convertPointFromAncestorToDescendant failed since view or another is null");
        return r12;
    }

    public static RectF n(View r5, View r10, RectF r11) {
        if (r10 == null) goto L7;
        if (r10 != r5) goto L5;
        return r11;
    L5:
        PointF r12 = new PointF(r11.left, r11.top);
        PointF r13 = new PointF(r11.right, r11.top);
        PointF r14 = new PointF(r11.left, r11.bottom);
        PointF r15 = new PointF(r11.right, r11.bottom);
        PointF r16 = m(r5, r10, r12);
        PointF r17 = m(r5, r10, r13);
        PointF r18 = m(r5, r10, r14);
        PointF r19 = m(r5, r10, r15);
        RectF r20 = new RectF();
        r20.left = Math.min(Math.min(r16.x, r17.x), Math.min(r18.x, r19.x));
        r20.top = Math.min(Math.min(r16.y, r17.y), Math.min(r18.y, r19.y));
        r20.right = Math.max(Math.max(r16.x, r17.x), Math.max(r18.x, r19.x));
        r20.bottom = Math.max(Math.max(r16.y, r17.y), Math.max(r18.y, r19.y));
        return r20;
    L7:
        LynxLog.b(4, "ViewHelper", "convertPointFromAncestorToDescendant failed since ancestor or descendant is null");
        return r11;
    }

    public static GkFSBlockBuffer o(com.bytedance.gkfs.io.a r5) {
        ReentrantReadWriteLock r10 = GkFSBlockBuffer.f4943m;
        ReentrantReadWriteLock.ReadLock r11 = r10.readLock();
        int r12 = 0;
        if (r10.getWriteHoldCount() != 0) goto L5;
        int r13 = r10.getReadHoldCount();
    L6:
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L9;
        r11.unlock();
        r14 = r14 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r15 = r10.writeLock();
        r15.lock();
        db.c r16 = (db.c) GkFSBlockBuffer.f4944n.remove(r5);     // Catch: Throwable -> L14
        if (r16 == null) goto L16;
        GkFSBlockBuffer r17 = r16.f16631b;     // Catch: Throwable -> L14
    L17:
        if (r12 >= r13) goto L19;
        r11.lock();
        r12 = r12 + 1;
        goto L17
    L19:
        r15.unlock();
        return r17;
    L16:
        r17 = null;
    L14:
        th = move-exception;
    L21:
        if (r12 >= r13) goto L23;
        r11.lock();
        r12 = r12 + 1;
        goto L21
    L23:
        r15.unlock();
        throw th;
    L5:
        r13 = 0;
        goto L6
    }

    public static void p(Bundle r5, StringBuilder r10) {
        Iterator<String> r11 = r5.keySet().iterator();
        boolean r12 = true;
    L4:
        if (r11.hasNext() == false) goto L46;
        String r13 = r11.next();
        if (r12 == true) goto L8;
        r10.append(", ");
    L8:
        r10.append(r13);
        r10.append('=');
        Object r14 = r5.get(r13);
        if ((r14 instanceof int[]) == false) goto L12;
        r10.append(Arrays.toString((int[]) r14));
    L45:
        r12 = false;
        goto L4
    L12:
        if ((r14 instanceof byte[]) == false) goto L18;
        byte[] r15 = (byte[]) r14;
        if (r15.length >= 102400) goto L16;
        r10.append(Arrays.toString(r15));
        goto L45
    L16:
        r10.append("byte[] in Bundle is too long, limit for 100K");
        goto L45
    L18:
        if ((r14 instanceof boolean[]) == false) goto L21;
        r10.append(Arrays.toString((boolean[]) r14));
        goto L45
    L21:
        if ((r14 instanceof short[]) == false) goto L24;
        r10.append(Arrays.toString((short[]) r14));
        goto L45
    L24:
        if ((r14 instanceof long[]) == false) goto L27;
        r10.append(Arrays.toString((long[]) r14));
        goto L45
    L27:
        if ((r14 instanceof float[]) == false) goto L30;
        r10.append(Arrays.toString((float[]) r14));
        goto L45
    L30:
        if ((r14 instanceof double[]) == false) goto L33;
        r10.append(Arrays.toString((double[]) r14));
        goto L45
    L33:
        if ((r14 instanceof String[]) == false) goto L36;
        r10.append(Arrays.toString((String[]) r14));
        goto L45
    L36:
        if ((r14 instanceof CharSequence[]) == false) goto L39;
        r10.append(Arrays.toString((CharSequence[]) r14));
        goto L45
    L39:
        if ((r14 instanceof Parcelable[]) == false) goto L42;
        r10.append(Arrays.toString((Parcelable[]) r14));
        goto L45
    L42:
        if ((r14 instanceof Bundle) == false) goto L44;
        r10.append(q((Bundle) r14));
        goto L45
    L44:
        r10.append(r14);
        goto L45
    }

    public static String q(Bundle r5) {
        if (r5 != null) goto L5;
        return "null";
    L5:
        StringBuilder r10 = new StringBuilder(128);
        r10.append("Bundle[{");
        p(r5, r10);
        r10.append("}]");
        return r10.toString();
    }

    public static File r(com.bytedance.gkfs.io.a r5) {
        if (Intrinsics.areEqual(r5, com.bytedance.gkfs.io.a.f4852b) == false) goto L6;
        return null;
    L6:
        File r10 = GkFSBlockBuffer.f4942l;
        if (r10 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("rootDir");
    L10:
        return new File(r10, androidx.constraintlayout.motion.widget.a.s(new StringBuilder(), r5.f4853a, ".gkfsb"));
    }

    public static double s() {
        long r5 = System.currentTimeMillis();
        jg.k.m().getClass();
        long r10 = com.bytedance.apm.util.a.h();
        Thread.sleep(360);     // Catch: InterruptedException -> L6
    L4:
        jg.k.m().getClass();
        return (((com.bytedance.apm.util.a.h() - r10) * 1000.0d) / (System.currentTimeMillis() - r5)) / com.bytedance.apm.util.a.j();
    }

    public static void t(Intent r10, StringBuilder r11) {
        String r5 = r10.getAction();
        boolean r12 = false;
        if (r5 == null) goto L5;
        r11.append("act=");
        r11.append(r5);
        boolean r13 = false;
    L6:
        Set<String> r14 = r10.getCategories();
        if (r14 == null) goto L18;
        if (r13 == true) goto L10;
        r11.append(' ');
    L10:
        r11.append("cat=[");
        Iterator<String> r15 = r14.iterator();
        boolean r16 = true;
    L12:
        if (r15.hasNext() == false) goto L17;
        String r17 = r15.next();
        if (r16 == true) goto L16;
        r11.append(',');
    L16:
        r11.append(r17);
        r16 = false;
        goto L12
    L17:
        r11.append("]");
        r13 = false;
    L18:
        Uri r18 = r10.getData();
        if (r18 == null) goto L36;
        if (r13 == true) goto L22;
        r11.append(' ');
    L22:
        r11.append("dat=");
        Method r19 = Uri.class.getDeclaredMethod("toSafeString", null);     // Catch: IllegalAccessException -> L25 InvocationTargetException -> L27 NoSuchMethodException -> L29
        r19.setAccessible(true);     // Catch: IllegalAccessException -> L25 InvocationTargetException -> L27 NoSuchMethodException -> L29
        String r20 = (String) r19.invoke(r18, null);     // Catch: IllegalAccessException -> L25 InvocationTargetException -> L27 NoSuchMethodException -> L29
    L35:
        r11.append(r20);
        r13 = false;
        goto L36
    L25:
        e = move-exception;
        e.printStackTrace();
    L34:
        r20 = r18.toString();
    L29:
        e = move-exception;
        e.printStackTrace();
    L27:
        e = move-exception;
        e.printStackTrace();
    L36:
        String r21 = r10.getType();
        if (r21 == null) goto L41;
        if (r13 == true) goto L40;
        r11.append(' ');
    L40:
        r11.append("typ=");
        r11.append(r21);
        r13 = false;
    L41:
        int r22 = r10.getFlags();
        if (r22 == 0) goto L46;
        if (r13 == true) goto L45;
        r11.append(' ');
    L45:
        r11.append("flg=0x");
        r11.append(Integer.toHexString(r22));
        r13 = false;
    L46:
        String r23 = r10.getPackage();
        if (r23 == null) goto L51;
        if (r13 == true) goto L50;
        r11.append(' ');
    L50:
        r11.append("pkg=");
        r11.append(r23);
        r13 = false;
    L51:
        ComponentName r24 = r10.getComponent();
        if (r24 == null) goto L56;
        if (r13 == true) goto L55;
        r11.append(' ');
    L55:
        r11.append("cmp=");
        r11.append(r24.flattenToShortString());
        r13 = false;
    L56:
        Rect r25 = r10.getSourceBounds();
        if (r25 == null) goto L62;
        if (r13 == true) goto L60;
        r11.append(' ');
    L60:
        r11.append("bnds=");
        r11.append(r25.toShortString());
        r13 = false;
    L62:
        if (r10.getClipData() == null) goto L66;
        if (r13 == true) goto L65;
        r11.append(' ');
    L65:
        r11.append("(has clip)");
    L67:
        Bundle r26 = r10.getExtras();
        if (r26 == null) goto L72;
        if (r12 == true) goto L71;
        r11.append(' ');
    L71:
        r11.append("extras={");
        p(r26, r11);
        r11.append('}');
    L72:
        Intent r27 = r10.getSelector();
        if (r27 == null) goto L81;
        r11.append(" sel=");
        t(r27, r11);
        r11.append("}");
        return;
    L81:
        return;
    L66:
        r12 = r13;
        goto L67
    L5:
        r13 = true;
        goto L6
    }

    public static void u(u r5, AtomicInteger r10, AtomicThrowable r11) {
        if (r10.getAndIncrement() != 0) goto L9;
        Throwable r12 = r11.terminate();
        if (r12 == null) goto L7;
        r5.onError(r12);
        return;
    L7:
        r5.onComplete();
        return;
    }

    public static void v(zu.c r5, AtomicInteger r10, AtomicThrowable r11) {
        if (r10.getAndIncrement() != 0) goto L9;
        Throwable r12 = r11.terminate();
        if (r12 == null) goto L7;
        r5.onError(r12);
        return;
    L7:
        r5.onComplete();
        return;
    }

    public static void w(u r5, Throwable r10, AtomicInteger r11, AtomicThrowable r12) {
        if (r12.addThrowable(r10) == true) goto L5;
        wn.f.k(r10);
        return;
    L5:
        if (r11.getAndIncrement() != 0) goto L9;
        r5.onError(r12.terminate());
        return;
    }

    public static void x(zu.c r5, Throwable r10, AtomicInteger r11, AtomicThrowable r12) {
        if (r12.addThrowable(r10) == true) goto L5;
        wn.f.k(r10);
        return;
    L5:
        if (r11.getAndIncrement() != 0) goto L9;
        r5.onError(r12.terminate());
        return;
    }

    public static void y(u r5, Object r10, AtomicInteger r11, AtomicThrowable r12) {
        if (r11.get() == 0) goto L5;
        return;
    L5:
        if (r11.compareAndSet(0, 1) == false) goto L14;
        r5.onNext(r10);
        if (r11.decrementAndGet() == 0) goto L15;
        Throwable r13 = r12.terminate();
        if (r13 == null) goto L11;
        r5.onError(r13);
        return;
    L11:
        r5.onComplete();
        return;
    L15:
        return;
    }

    public static void z(zu.c r5, Object r10, AtomicInteger r11, AtomicThrowable r12) {
        if (r11.get() == 0) goto L5;
        return;
    L5:
        if (r11.compareAndSet(0, 1) == false) goto L14;
        r5.onNext(r10);
        if (r11.decrementAndGet() == 0) goto L15;
        Throwable r13 = r12.terminate();
        if (r13 == null) goto L11;
        r5.onError(r13);
        return;
    L11:
        r5.onComplete();
        return;
    L15:
        return;
    }
}

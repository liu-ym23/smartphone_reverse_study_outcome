package com.google.common.reflect;

import ai.j0;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.HandlerThread;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import androidx.room.jarjarred.org.antlr.runtime.debug.Profiler;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.bumptech.glide.load.engine.h0;
import com.bytedance.android.monitorV2.dataprocessor.TypedDataDispatcher$DataType;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.bullet.kit.web.WebLoadError;
import com.bytedance.ies.bullet.lynx.impl.LynxErrorCode;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.exception.ExceptionWithCode;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.google.common.collect.ImmutableList;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.resourceprovider.LynxResourceResponse$ResponseState;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.a0;
import com.obric.oui.orecyclerview.widget.x0;
import com.relax.RelaxView;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.SafeContinuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f9376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f9377c;
    public Object d;

    public /* synthetic */ w(int r5, boolean r10) {
        this.f9375a = r5;
    }

    public static w a(Object r5) {
        w r10 = new w(26, false);
        r10.f9377c = LynxResourceResponse$ResponseState.f10948b;
        r10.f9376b = r5;
        return r10;
    }

    public static w b(Throwable r5) {
        w r10 = new w(26, false);
        r10.f9377c = LynxResourceResponse$ResponseState.f10947a;
        r10.d = r5;
        return r10;
    }

    private final void y() {
    }

    public void A(hr.g r10) {
        ArrayList r11 = (ArrayList) this.f9377c;
        r11.clear();
        int r5 = r10.f17432u0.size();
        int r12 = 0;
    L4:
        if (r12 >= r5) goto L11;
        hr.f r13 = (hr.f) r10.f17432u0.get(r12);
        ConstraintWidget$DimensionBehaviour[] r14 = r13.U;
        ConstraintWidget$DimensionBehaviour r15 = r14[0];
        ConstraintWidget$DimensionBehaviour r16 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        if (r15 != r16) goto L8;
    L9:
        r11.add(r13);
    L10:
        r12 = r12 + 1;
        goto L4
    L8:
        if (r14[1] != r16) goto L10;
    L11:
        r10.f17434w0.f12567a = true;
    }

    public String c() {
    L2:
        int r5 = ((ck.b) this.f9377c).read();
        if (r5 < 0) goto L4;
        char r10 = (char) r5;
        com.bytedance.crash.upload.k r11 = (com.bytedance.crash.upload.k) this.d;
        int r12 = r11.f4136a;
        if (r12 == 1) goto L19;
        if (r12 == 2) goto L16;
        if (r12 != 3) goto L14;
        if (r10 != '\r') goto L12;
        r11.f4136a = 2;
    L21:
        int r13 = r11.f4136a;
        StringBuilder r14 = (StringBuilder) this.f9376b;
        if (r13 != 1) goto L23;
        r14.append(r10);
        goto L2
    L23:
        if (r13 != 3) goto L2;
        String r15 = r14.toString();
        r14.setLength(0);
        return r15;
    L12:
        r11.f4136a = 1;
        goto L21
    L14:
        throw new IllegalArgumentException("Unknown state: " + r11.f4136a);
    L16:
        if (r10 != '\n') goto L18;
        r11.f4136a = 3;
        goto L21
    L18:
        r11.f4136a = 1;
        goto L21
    L19:
        if (r10 != '\r') goto L21;
        r11.f4136a = 2;
        goto L21
    L4:
        return null;
    }

    public void d() {
        com.bytedance.iesgurd.request.c r5 = (com.bytedance.iesgurd.request.c) this.f9377c;
        if (r5 != null) goto L5;
    L15:
        com.bytedance.iesgurd.request.b r10 = (com.bytedance.iesgurd.request.b) this.d;
        if (r10 != null) goto L18;
    L26:
        h0 r11 = (h0) this.f9376b;
        if (r11 == null) goto L52;
        monitor-enter(r11);
        long r12 = 60000;
        if ((System.currentTimeMillis() - h0.d) <= r12) goto L35;
        h0.f1509c = 0;     // Catch: Throwable -> L32
    L35:
        if (h0.f1509c == 3) goto L37;
    L39:
        r11.f1510a = false;     // Catch: Throwable -> L32
    L41:
        if (r11.f1510a == true) goto L43;
    L47:
        r11.f1510a = false;     // Catch: Throwable -> L32
        monitor-exit(r11);     // Catch: Throwable -> L32
        return;
    L43:
        if ((System.currentTimeMillis() - h0.e) > r12) goto L47;
        throw new ExceptionWithCode(LynxErrorCode.LYNX_ERROR_EXCEPTION, "gecko update request failed more than 3 times");     // Catch: Throwable -> L32
    L37:
        if (((ReqType) r11.f1511b) != ReqType.NORMAL) goto L39;
        r11.f1510a = true;     // Catch: Throwable -> L32
        h0.e = System.currentTimeMillis();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    L52:
        return;
    L18:
        if (r10.f6666a.get() == true) goto L24;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L21
        Result.m124constructorimpl((Long) com.bytedance.iesgurd.request.b.e.remove(r10.d));     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L26
    L24:
        if (r10.f6666a.get() == false) goto L26;
        com.bytedance.iesgurd.request.b.e.remove(r10.d);
        goto L26
    L5:
        if (r5.f6670a == false) goto L15;
        ConcurrentHashMap r15 = com.bytedance.iesgurd.request.c.f6669c;
        Long r16 = (Long) r15.get(r5.f6671b);
        if (r16 != null) goto L10;
        r15.put(r5.f6671b, Long.valueOf(System.currentTimeMillis()));
        goto L15
    L10:
        if ((System.currentTimeMillis() - r16.longValue()) <= 600000) goto L13;
        r15.put(r5.f6671b, Long.valueOf(System.currentTimeMillis()));
        goto L15
    L13:
        throw new ExceptionWithCode(600, "repeat gecko update request in 600s");
    }

    public void e(bb.a r5, long r10, long r11) {
        if (((bb.b) this.f9377c) != null) goto L5;
    L6:
        HandlerThread r12 = new HandlerThread((String) this.f9376b, 3);
        this.d = r12;
        r12.start();
        this.f9377c = new bb.b(this, ((HandlerThread) this.d).getLooper(), 0);
    L7:
        int r13 = r5.b();
        r5.f891a = r11;
        Message r14 = ((bb.b) this.f9377c).obtainMessage(r13);
        r14.obj = r5;
        r14.what = r13;
        ((bb.b) this.f9377c).sendMessageDelayed(r14, r10);
        return;
    L5:
        if (((HandlerThread) this.d).getLooper() != null) goto L7;
        goto L6
    }

    public boolean equals(Object r10) {
        switch(this.f9375a) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        boolean r5 = u.f9373a;
        boolean r11 = true;
        GenericDeclaration r12 = (GenericDeclaration) this.f9377c;
        String r13 = (String) this.f9376b;
        if (r5 == false) goto L23;
        if (r10 != null) goto L10;
        return false;
    L10:
        if (Proxy.isProxyClass(r10.getClass()) == true) goto L12;
        return false;
    L12:
        if ((Proxy.getInvocationHandler(r10) instanceof x) == false) goto L31;
        w r14 = ((x) Proxy.getInvocationHandler(r10)).f9379a;
        if (r13.equals((String) r14.f9376b) == true) goto L16;
    L20:
        r11 = false;
    L32:
        return r11;
    L16:
        if (r12.equals((GenericDeclaration) r14.f9377c) == false) goto L20;
        if (((ImmutableList) this.d).equals((ImmutableList) r14.d) == false) goto L20;
    L31:
        return false;
    L23:
        if ((r10 instanceof TypeVariable) == false) goto L33;
        TypeVariable r15 = (TypeVariable) r10;
        if (r13.equals(r15.getName()) == false) goto L20;
        if (r12.equals(r15.getGenericDeclaration()) == false) goto L20;
    L33:
        return false;
    L5:
        return super.equals(r10);
    }

    public void f(com.bytedance.android.monitorV2.event.d r10) {
        String r5 = androidx.room.jarjarred.org.antlr.runtime.a.w(new StringBuilder("addBasicAttributes: naviBid is "), (String) this.f9376b, "RelaxEventReporter", "tag", "msg");
        a1.a.f43a.i("RelaxEventReporter", r5);
        LinkedHashMap r11 = r10.e;
        r11.put("config_bid", (String) this.f9376b);
        r11.put("jsb_bid", (String) this.f9376b);
        r10.g = (JSONObject) this.d;
        x4.h r12 = r10.f;
        WeakReference r13 = (WeakReference) this.f9377c;
        if (r13 == null) goto L8;
        RelaxView r14 = (RelaxView) r13.get();
        if (r14 == null) goto L8;
        String r15 = r14.getCurrentUrl();
        if (r15 == null) goto L8;
    L9:
        r12.f22973a = r15;
        r10.f.f22975c = "lynx";
        return;
    L8:
        r15 = "";
        goto L9
    }

    public void g(String r5, com.bytedance.ies.bullet.service.base.h r10, WebLoadError r11) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r10, "kitView");
        Intrinsics.checkNotNullParameter(r11, "reason");
        com.bytedance.ies.bullet.kit.web.impl.i r12 = ((com.bytedance.ies.bullet.kit.web.m) this.d).d;
        r12.getClass();
        boolean r13 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.e(r12.d().getSessionId(), "load failed", "XWebKit", LogLevel.d);
        ((com.bytedance.ies.bullet.ui.common.loader.b) this.f9377c).r((Uri) this.f9376b, r11);
    }

    public void h(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        String r5 = "reportCustomEvent: data = " + r10;
        Intrinsics.checkNotNullParameter("RelaxEventReporter", "tag");
        Intrinsics.checkNotNullParameter(r5, "msg");
        a1.a.f43a.i("RelaxEventReporter", r5);
        WeakReference r11 = (WeakReference) this.f9377c;
        if (r11 == null) goto L8;
        RelaxView r12 = (RelaxView) r11.get();
        if (r12 == null) goto L8;
        String r13 = r12.getCurrentUrl();
        if (r13 == null) goto L8;
    L9:
        com.bytedance.ies.web.jsbridge2.l r14 = new com.bytedance.ies.web.jsbridge2.l(r10.optString("eventName"), 1);
        r14.f6291c = r10.optString("bid");
        r14.f6290b = r13;
        r14.f6292h = r10.optJSONObject("category");
        r14.f6293i = r10.optJSONObject(LynxMonitorService.KEY_METRICS);
        r14.f6294j = r10.optJSONObject("extra");
        r14.f6295k = r10.optJSONObject("timing");
        int r15 = 2;
        int r16 = r10.optInt("level", 2);
        int r17 = r10.optInt("canSample", 1);
        boolean r18 = r10.optBoolean("canSample", true);
        if (r10.has("level") == false) goto L13;
        r15 = r16;
    L17:
        r14.b(r15);
        x4.c r19 = r14.a();
        Intrinsics.checkNotNull(r19);
        com.bytedance.android.monitorV2.event.b r20 = new com.bytedance.android.monitorV2.event.b(r19);
        f(r20);
        qo.a.e(3, WsConstants.KEY_PLATFORM, r20.f3553m.f22950h);
        com.bytedance.android.monitorV2.dataprocessor.b r21 = com.bytedance.android.monitorV2.c.f3517a;
        com.bytedance.android.monitorV2.c.d(r20, Boolean.TRUE);
        return;
    L13:
        if (r10.has("canSample") == false) goto L17;
        if (r17 == 0) goto L16;
        if (r18 == true) goto L17;
    L16:
        r15 = 0;
    L8:
        r13 = "";
        goto L9
    }

    public int hashCode() {
        switch(this.f9375a) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        int r5 = ((GenericDeclaration) this.f9377c).hashCode();
        return ((String) this.f9376b).hashCode() ^ r5;
    L5:
        return super.hashCode();
    }

    public void i(View r5, int r10, boolean r11) {
        RecyclerView r12 = (RecyclerView) ((com.obric.oui.orecyclerview.widget.y) this.f9377c).f13929a;
        if (r10 >= 0) goto L5;
        int r13 = r12.getChildCount();
    L6:
        ((com.bytedance.crash.upload.l) this.f9376b).f(r13, r11);
        if (r11 == false) goto L9;
        t(r5);
    L9:
        r12.addView(r5, r13);
        x0 r14 = RecyclerView.F(r5);
        a0 r15 = r12.f13742l;
        if (r15 == null) goto L14;
        if (r14 == null) goto L15;
        r15.onViewAttachedToWindow(r14);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r13 = q(r10);
        goto L6
    }

    public void j(View r5, int r10, ViewGroup.LayoutParams r11, boolean r12) {
        RecyclerView r13 = (RecyclerView) ((com.obric.oui.orecyclerview.widget.y) this.f9377c).f13929a;
        if (r10 >= 0) goto L5;
        int r14 = r13.getChildCount();
    L6:
        ((com.bytedance.crash.upload.l) this.f9376b).f(r14, r12);
        if (r12 == false) goto L9;
        t(r5);
    L9:
        x0 r15 = RecyclerView.F(r5);
        if (r15 == null) goto L23;
        if (r15.isTmpDetached() == true) goto L19;
        if (r15.shouldIgnore() == true) goto L19;
        StringBuilder r16 = new StringBuilder("Called attach on a child which is not detached: ");
        r16.append(r15);
        throw new IllegalArgumentException(androidx.room.jarjarred.org.antlr.runtime.a.n(r13, r16));
    L19:
        if (RecyclerView.f13724y0 == false) goto L21;
        Log.d("RecyclerView", "reAttach " + r15);
    L21:
        r15.clearTmpDetachFlag();
    L24:
        RecyclerView.a(r13, r5, r14, r11);
        return;
    L23:
        if (RecyclerView.f13723x0 == false) goto L24;
        StringBuilder r17 = new StringBuilder("No ViewHolder found for child: ");
        r17.append(r5);
        r17.append(", index: ");
        r17.append(r14);
        throw new IllegalArgumentException(androidx.room.jarjarred.org.antlr.runtime.a.n(r13, r17));
    L5:
        r14 = q(r10);
        goto L6
    }

    public void k(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        String r10 = "reportError: data = " + r5;
        Intrinsics.checkNotNullParameter("RelaxEventReporter", "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        a1.a.f43a.i("RelaxEventReporter", r10);
        g5.d r11 = new g5.d();
        r11.f17056b = "lynx_error_custom";
        r11.f17057c = 201;
        r11.d = r5.toString();
        Intrinsics.checkNotNullParameter("js_exception", "eventType");
        com.bytedance.android.monitorV2.event.a r12 = oo.j.c("js_exception", null, null);
        r12.f3550m = r11;
        f(r12);
        com.bytedance.android.monitorV2.dataprocessor.b r13 = com.bytedance.android.monitorV2.c.f3517a;
        com.bytedance.android.monitorV2.c.b(r12, Boolean.TRUE);
    }

    public Bitmap l(BitmapFactory.Options r5) {
        switch(this.f9375a) {
            case 5: goto L6;
            default: goto L5;
        };
    L6:
        com.bumptech.glide.load.resource.bitmap.s r10 = (com.bumptech.glide.load.resource.bitmap.s) ((com.bumptech.glide.load.data.i) this.f9377c).f1428b;
        r10.reset();
        return BitmapFactory.decodeStream(r10, null, r5);
    L5:
        return BitmapFactory.decodeFileDescriptor(((com.bumptech.glide.load.data.i) this.d).e().getFileDescriptor(), null, r5);
    }

    public void m(int r5) {
        int r10 = q(r5);
        ((com.bytedance.crash.upload.l) this.f9376b).g(r10);
        RecyclerView r11 = (RecyclerView) ((com.obric.oui.orecyclerview.widget.y) this.f9377c).f13929a;
        View r12 = r11.getChildAt(r10);
        if (r12 == null) goto L18;
        x0 r13 = RecyclerView.F(r12);
        if (r13 != null) goto L7;
    L19:
        RecyclerView.b(r11, r10);
        return;
    L7:
        if (r13.isTmpDetached() == false) goto L14;
        if (r13.shouldIgnore() == true) goto L14;
        StringBuilder r14 = new StringBuilder("called detach on an already detached child ");
        r14.append(r13);
        throw new IllegalArgumentException(androidx.room.jarjarred.org.antlr.runtime.a.n(r11, r14));
    L14:
        if (RecyclerView.f13724y0 == false) goto L16;
        Log.d("RecyclerView", "tmpDetach " + r13);
    L16:
        r13.addFlags(256);
        goto L19
    L18:
        if (RecyclerView.f13723x0 == false) goto L19;
        StringBuilder r15 = new StringBuilder("No view at offset ");
        r15.append(r10);
        throw new IllegalArgumentException(androidx.room.jarjarred.org.antlr.runtime.a.n(r11, r15));
    }

    public View n(int r5) {
        int r10 = q(r5);
        return ((RecyclerView) ((com.obric.oui.orecyclerview.widget.y) this.f9377c).f13929a).getChildAt(r10);
    }

    public int o() {
        return ((RecyclerView) ((com.obric.oui.orecyclerview.widget.y) this.f9377c).f13929a).getChildCount() - ((ArrayList) this.d).size();
    }

    public ImageHeaderParser$ImageType p() {
        switch(this.f9375a) {
            case 5: goto L23;
            default: goto L4;
        };
    L4:
        com.bumptech.glide.load.data.i r5 = (com.bumptech.glide.load.data.i) this.d;
        com.bumptech.glide.load.engine.bitmap_recycle.f r10 = (com.bumptech.glide.load.engine.bitmap_recycle.f) this.f9377c;
        ArrayList r11 = (ArrayList) this.f9376b;
        int r12 = r11.size();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L22;
        z.b r14 = (z.b) r11.get(r13);
        com.bumptech.glide.load.resource.bitmap.s r15 = null;
        com.bumptech.glide.load.resource.bitmap.s r16 = new com.bumptech.glide.load.resource.bitmap.s(new FileInputStream(r5.e().getFileDescriptor()), r10);     // Catch: Throwable -> L16
        ImageHeaderParser$ImageType r17 = r14.c(r16);     // Catch: Throwable -> L14
        r16.close();     // Catch: IOException -> L25
    L10:
        r5.e();
        if (r17 != ImageHeaderParser$ImageType.UNKNOWN) goto L37;
        r13 = r13 + 1;
        goto L5
    L37:
        return r17;
    L14:
        th = th;
        r15 = r16;
    L17:
        if (r15 != null) goto L33;
    L19:
        r5.e();
        throw th;
    L33:
        r15.close();     // Catch: IOException -> L26
    L16:
        th = th;
        goto L17
    L22:
        return ImageHeaderParser$ImageType.UNKNOWN;
    L23:
        com.bumptech.glide.load.resource.bitmap.s r18 = (com.bumptech.glide.load.resource.bitmap.s) ((com.bumptech.glide.load.data.i) this.f9377c).f1428b;
        r18.reset();
        ArrayList r19 = (ArrayList) this.d;
        return f4.b.j((com.bumptech.glide.load.engine.bitmap_recycle.f) this.f9376b, r18, r19);
    }

    public int q(int r10) {
        if (r10 >= 0) goto L5;
        return -1;
    L5:
        int r5 = ((RecyclerView) ((com.obric.oui.orecyclerview.widget.y) this.f9377c).f13929a).getChildCount();
        int r11 = r10;
    L6:
        if (r11 >= r5) goto L14;
        com.bytedance.crash.upload.l r12 = (com.bytedance.crash.upload.l) this.f9376b;
        int r13 = r10 - (r11 - r12.c(r11));
        if (r13 == 0) goto L10;
        r11 = r11 + r13;
    L10:
        if (r12.e(r11) == false) goto L12;
        r11 = r11 + 1;
        goto L10
    L12:
        return r11;
    L14:
        return -1;
    }

    public View r(int r5) {
        return ((RecyclerView) ((com.obric.oui.orecyclerview.widget.y) this.f9377c).f13929a).getChildAt(r5);
    }

    public int s() {
        return ((RecyclerView) ((com.obric.oui.orecyclerview.widget.y) this.f9377c).f13929a).getChildCount();
    }

    public void t(View r5) {
        ((ArrayList) this.d).add(r5);
        com.obric.oui.orecyclerview.widget.y r10 = (com.obric.oui.orecyclerview.widget.y) this.f9377c;
        x0 r11 = RecyclerView.F(r5);
        if (r11 == null) goto L6;
        r11.onEnteredHiddenState((RecyclerView) r10.f13929a);
        return;
    }

    public String toString() {
        switch(this.f9375a) {
            case 0: goto L30;
            case 20: goto L28;
            case 23: goto L25;
            case 29: goto L6;
            default: goto L5;
        };
    L6:
        StringBuilder r5 = new StringBuilder("scheme:snssdk143\nother schemes: ");
        String[] r10 = (String[]) this.f9377c;
        int r11 = 0;
        if (r10 != null) goto L9;
    L14:
        HashMap r12 = (HashMap) this.d;
        if (r12 == null) goto L17;
        r11 = r12.size();
    L17:
        r5.append("other supported routes: " + r11 + " routes\n");
        if (r11 <= 0) goto L24;
        Iterator r13 = ((HashMap) this.d).entrySet().iterator();
    L21:
        if (r13.hasNext() == false) goto L24;
        Map.Entry r14 = (Map.Entry) r13.next();
        r5.append(Profiler.DATA_SEP);
        r5.append((String) r14.getKey());
        r5.append(":");
        r5.append(((Class) r14.getValue()).getName());
        r5.append('\n');
    L24:
        return r5.toString();
    L9:
        if (r10.length <= 0) goto L14;
        int r15 = r10.length;
        int r16 = 0;
    L11:
        if (r16 >= r15) goto L13;
        r5.append(r10[r16]);
        r5.append(',');
        r16 = r16 + 1;
        goto L11
    L13:
        r5.append("\n");
        goto L14
    L25:
        StringCompanionObject r17 = StringCompanionObject.INSTANCE;
        return String.format("ViewInfo @%d view %s, name %s, monitor-name %s", Arrays.copyOf(new Object[]{Integer.valueOf(hashCode()), ((View) this.f9377c).getClass().getSimpleName(), (String) this.f9376b, (String) this.d}, 4));
    L5:
        return super.toString();
    L28:
        return ((com.bytedance.crash.upload.l) this.f9376b).toString() + ", hidden list:" + ((ArrayList) this.d).size();
    L30:
        return (String) this.f9376b;
    }

    public int u(View r5) {
        int r10 = ((RecyclerView) ((com.obric.oui.orecyclerview.widget.y) this.f9377c).f13929a).indexOfChild(r5);
        if (r10 != (-1)) goto L5;
        return -1;
    L5:
        com.bytedance.crash.upload.l r11 = (com.bytedance.crash.upload.l) this.f9376b;
        if (r11.e(r10) == false) goto L9;
        return -1;
    L9:
        return r10 - r11.c(r10);
    }

    public boolean v(int r10, com.obric.oui.constraintlayout.core.widgets.analyzer.c r11, hr.f r12) {
        ConstraintWidget$DimensionBehaviour[] r5 = r12.U;
        ConstraintWidget$DimensionBehaviour r13 = r5[0];
        com.obric.oui.constraintlayout.core.widgets.analyzer.b r14 = (com.obric.oui.constraintlayout.core.widgets.analyzer.b) this.f9376b;
        r14.f12559a = r13;
        r14.f12560b = r5[1];
        r14.f12561c = r12.r();
        r14.d = r12.l();
        r14.f12563i = false;
        r14.f12564j = r10;
        ConstraintWidget$DimensionBehaviour r15 = r14.f12559a;
        ConstraintWidget$DimensionBehaviour r16 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        if (r15 != r16) goto L5;
        boolean r17 = true;
    L7:
        if (r14.f12560b != r16) goto L9;
        boolean r18 = true;
    L11:
        if (r17 == true) goto L13;
    L15:
        boolean r19 = false;
    L16:
        if (r18 == true) goto L18;
    L20:
        boolean r20 = false;
    L21:
        int[] r21 = r12.f17424t;
        if (r19 == true) goto L24;
    L26:
        if (r20 == true) goto L28;
    L30:
        ((com.obric.oui.constraintlayout.widget.b) r11).b(r12, r14);
        r12.P(r14.e);
        r12.M(r14.f);
        r12.E = r14.f12562h;
        r12.J(r14.g);
        r14.f12564j = 0;
        return r14.f12563i;
    L28:
        if (r21[1] != 4) goto L30;
        r14.f12560b = ConstraintWidget$DimensionBehaviour.FIXED;
        goto L30
    L24:
        if (r21[0] != 4) goto L26;
        r14.f12559a = ConstraintWidget$DimensionBehaviour.FIXED;
        goto L26
    L18:
        if (r12.Y <= 0.0f) goto L20;
        r20 = true;
        goto L21
    L13:
        if (r12.Y <= 0.0f) goto L15;
        r19 = true;
        goto L16
    L9:
        r18 = false;
        goto L11
    L5:
        r17 = false;
        goto L7
    }

    public void w(hr.g r5, int r10, int r11, int r12) {
        r5.getClass();
        int r13 = r5.f17400d0;
        int r14 = r5.f17401e0;
        r5.f17400d0 = 0;
        r5.f17401e0 = 0;
        r5.P(r11);
        r5.M(r12);
        if (r13 >= 0) goto L5;
        r5.f17400d0 = 0;
    L6:
        if (r14 >= 0) goto L8;
        r5.f17401e0 = 0;
    L9:
        hr.g r15 = (hr.g) this.d;
        r15.f17435x0 = r10;
        r15.V();
        return;
    L8:
        r5.f17401e0 = r14;
        goto L9
    L5:
        r5.f17400d0 = r13;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [kotlin.jvm.functions.Function3, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r9v1, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
    public jp.d x() {
        Intrinsics.checkNotNullParameter("ValueAnimatable", "tag");
        Intrinsics.checkNotNullParameter("执行start ", "msg");
        if (rp.b.f21793a == null) goto L5;
        Intrinsics.checkNotNullParameter("ValueAnimatable", "tag");
        Intrinsics.checkNotNullParameter("执行start ", "msg");
        Log.d("OEA_SDK", "ValueAnimatable->执行start ");
    L5:
        RunMode r5 = RunMode.PARALLEL;
        RepeatMode r10 = RepeatMode.NORMAL;
        ArrayList r11 = new ArrayList();
        r11.add((hp.a) this.f9377c);
        Unit r12 = Unit.INSTANCE;
        return com.obric.common.oea.foundation.animation.parser.a.a(60.0f, null, r5, 1.0f, r10, r11, (Lambda) this.f9376b, (Lambda) this.d);
    }

    public void z(View r5) {
        if (((ArrayList) this.d).remove(r5) == false) goto L8;
        com.obric.oui.orecyclerview.widget.y r10 = (com.obric.oui.orecyclerview.widget.y) this.f9377c;
        x0 r11 = RecyclerView.F(r5);
        if (r11 == null) goto L9;
        r11.onLeftHiddenState((RecyclerView) r10.f13929a);
        return;
    L9:
        return;
    }

    public /* synthetic */ w(Object r5, int r10, Object r11, Object r12) {
        this.f9375a = r10;
        this.f9377c = r5;
        this.f9376b = r11;
        this.d = r12;
    }

    public w(int r10) {
        this.f9375a = r10;
        switch(r10) {
            case 15: goto L26;
            case 28: goto L6;
            default: goto L4;
        };
    L4:
        this.f9377c = new ArrayList();
        this.f9376b = new HashSet();
        this.d = new AtomicLong(0);
        return;
    L6:
        w r11 = new w(29, false);
        r11.d = null;
        HashMap r5 = new HashMap();
        r11.d = r5;
        r5.put("bt.service", ii.b.class);
        ((HashMap) r11.d).put("bt.broadcast", ii.a.class);
        String[] r12 = hi.c.f17334a;
        r11.f9377c = r12;
        HashSet r13 = (HashSet) r11.f9376b;
        if (r13 == null) goto L9;
        r13.clear();
    L10:
        ((HashSet) r11.f9376b).addAll(Arrays.asList(r12));
        if (TextUtils.isEmpty("bt.service") == false) goto L13;
        Log.w("SmartRouter", "RoutesConfig#withHostRoute() host or routeClass is null!!!");
    L18:
        if (TextUtils.isEmpty("bt.broadcast") == false) goto L20;
        Log.w("SmartRouter", "RoutesConfig#withHostRoute() host or routeClass is null!!!");
    L24:
        this.f9376b = r11;
        this.f9377c = new oo.l(1);
        this.d = new r9.c(10);
        return;
    L20:
        if (((HashMap) r11.d) != null) goto L22;
        r11.d = new HashMap();
    L22:
        ((HashMap) r11.d).put("bt.broadcast", ii.a.class);
        goto L24
    L13:
        if (((HashMap) r11.d) != null) goto L15;
        r11.d = new HashMap();
    L15:
        ((HashMap) r11.d).put("bt.service", ii.b.class);
        goto L18
    L9:
        r11.f9376b = new HashSet();
        goto L10
    L26:
        this.f9376b = new ArrayList();
        this.d = new ArrayList();
    }

    public w(View r5, String r10, String r11, String r12) {
        this.f9375a = 23;
        Intrinsics.checkNotNullParameter(r5, "mView");
        Intrinsics.checkNotNullParameter(r10, "mTagName");
        Intrinsics.checkNotNullParameter(r12, "url");
        this.f9377c = r5;
        this.f9376b = r10;
        this.d = r11;
    }

    public w(AccessibilityManager r5, com.lynx.tasm.behavior.ui.accessibility.d r10) {
        this.f9375a = 16;
        this.f9377c = null;
        this.f9376b = null;
        this.d = null;
        if (r5 == null) goto L13;
        if (r10 == null) goto L14;
        this.f9377c = r5;
        boolean r11 = r5.isEnabled();
        boolean r12 = r5.isTouchExplorationEnabled();
        r10.g = r11;
        boolean r13 = r10.f10415o;
        if (r13 == false) goto L8;
        r10.a();
    L8:
        r10.f10408h = r12;
        if (r13 == false) goto L11;
        r10.a();
    L11:
        com.lynx.tasm.behavior.ui.accessibility.a r14 = new com.lynx.tasm.behavior.ui.accessibility.a(r10);
        this.f9376b = r14;
        r5.addAccessibilityStateChangeListener(r14);
        com.lynx.tasm.behavior.ui.accessibility.b r15 = new com.lynx.tasm.behavior.ui.accessibility.b(r10);
        this.d = r15;
        r5.addTouchExplorationStateChangeListener(r15);
        return;
    L14:
        return;
    }

    public w(ck.b r5) {
        this.f9375a = 24;
        this.f9376b = new StringBuilder();
        com.bytedance.crash.upload.k r10 = new com.bytedance.crash.upload.k();
        r10.f4136a = 1;
        this.d = r10;
        this.f9377c = r5;
    }

    public w(com.bytedance.android.monitorV2.lynx.impl.e r5) {
        this.f9375a = 8;
        Intrinsics.checkNotNullParameter(r5, "mNavigation");
        this.f9377c = r5;
        com.bytedance.android.monitorV2.dataprocessor.b r10 = new com.bytedance.android.monitorV2.dataprocessor.b();
        this.f9376b = r10;
        TypedDataDispatcher$DataType r11 = TypedDataDispatcher$DataType.f3526b;
        this.d = r11;
        com.bytedance.android.monitorV2.lynx.impl.b r12 = new com.bytedance.android.monitorV2.lynx.impl.b(this);
        Intrinsics.checkNotNullParameter(r11, "dataType");
        Intrinsics.checkNotNullParameter(r12, "dataProcessor");
        r10.f3533b.put(r11, r12);
    }

    public w(RelaxView r5) {
        this.f9375a = 27;
        this.f9376b = "";
        this.d = new JSONObject();
        if (r5 == null) goto L5;
        WeakReference r10 = new WeakReference(r5);
    L6:
        this.f9377c = r10;
        return;
    L5:
        r10 = null;
        goto L6
    }

    public w(File r5, File r10, com.bytedance.gkfs.cdc.b r11) {
        this.f9375a = 9;
        this.f9376b = r5;
        this.d = r11;
        new com.bytedance.gkfs.d();
        this.f9377c = com.bytedance.gkfs.io.k.d;
    }

    public w(String r5, int r10) {
        this.f9375a = r10;
        switch(r10) {
            case 11: goto L10;
            default: goto L4;
        };
    L4:
        this.f9376b = r5;
        if (((bb.b) this.f9377c) != null) goto L7;
    L8:
        HandlerThread r11 = new HandlerThread(r5, 3);
        this.d = r11;
        r11.start();
        this.f9377c = new bb.b(this, ((HandlerThread) this.d).getLooper(), 0);
        return;
    L7:
        if (((HandlerThread) this.d).getLooper() == null) goto L8;
        return;
    L10:
        Intrinsics.checkNotNullParameter(r5, "containerName");
        this.f9376b = r5;
        this.f9377c = "bullet_custom_bid";
    }

    public w(String r5, String r10, SafeContinuation r11) {
        this.f9375a = 7;
        this.f9376b = r5;
        this.f9377c = r10;
        this.d = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public w(hp.a r5, Function3 r10, Function2 r11) {
        this.f9375a = 17;
        this.f9377c = r5;
        this.f9376b = (Lambda) r10;
        this.d = (Lambda) r11;
    }

    public w(com.bumptech.glide.load.engine.bitmap_recycle.f r5, InputStream r10, ArrayList r11) {
        this.f9375a = 5;
        io.reactivex.internal.observers.h.h(r5, "Argument must not be null");
        this.f9376b = r5;
        io.reactivex.internal.observers.h.h(r11, "Argument must not be null");
        this.d = r11;
        this.f9377c = new com.bumptech.glide.load.data.i(r10, r5);
    }

    public w(com.obric.oui.orecyclerview.widget.y r5) {
        this.f9375a = 20;
        this.f9377c = r5;
        this.f9376b = new com.bytedance.crash.upload.l(1);
        this.d = new ArrayList();
    }

    public w(hr.g r5) {
        this.f9375a = 19;
        this.f9377c = new ArrayList();
        this.f9376b = new com.obric.oui.constraintlayout.core.widgets.analyzer.b();
        this.d = r5;
    }

    public w(ParcelFileDescriptor r5, ArrayList r10, com.bumptech.glide.load.engine.bitmap_recycle.f r11) {
        this.f9375a = 6;
        io.reactivex.internal.observers.h.h(r11, "Argument must not be null");
        this.f9377c = r11;
        io.reactivex.internal.observers.h.h(r10, "Argument must not be null");
        this.f9376b = r10;
        this.d = new com.bumptech.glide.load.data.i(r5);
    }

    public w(GenericDeclaration r5, String r10, Type[] r11) {
        this.f9375a = 0;
        y.b(r11, "bound for type variable");
        r5.getClass();
        this.f9377c = r5;
        r10.getClass();
        this.f9376b = r10;
        this.d = ImmutableList.copyOf(r11);
    }

    public w(com.bumptech.glide.load.engine.s r5, com.bumptech.glide.request.d r10, com.bumptech.glide.load.engine.w r11) {
        this.f9375a = 4;
        this.d = r5;
        this.f9376b = r10;
        this.f9377c = r11;
    }

    public w(cv.b r17, String r18, int r19) {
        this.f9375a = r19;
        switch(r19) {
            case 22: goto L61;
            default: goto L4;
        };
    L4:
        this.d = r17;
        Pattern r5 = Pattern.compile("CONSTRAINT\\s*([A-Za-z_][A-Za-z\\d_]*)?\\s*FOREIGN\\s+KEY\\s*\\((.*?)\\)", 34);
        this.f9377c = new ArrayList();
        if (r18 == null) goto L60;
        if (r18.trim().length() == 0) goto L60;
        this.f9376b = r18;
        ArrayList r10 = new ArrayList();
        Statement r11 = r17.f1000a.createStatement();     // Catch: Throwable -> L52
        ResultSet r12 = r11.executeQuery("select sql from sqlite_master where lower(name) = lower('" + bv.a.a(r18) + "')");     // Catch: Throwable -> L50
    L18:
        th = th;
        ResultSet r13 = r12;
    L54:
        if (r13 != null) goto L147;
    L56:
        if (r11 == null) goto L168;
        r11.close();     // Catch: SQLException -> L113
        throw th;
    L169:
        throw th;
    L168:
        throw th;
    L147:
        r13.close();     // Catch: SQLException -> L112
        goto L56
    L12:
        if (r12.next() == false) goto L131;
        Matcher r14 = r5.matcher(r12.getString(1));     // Catch: Throwable -> L18
    L15:
        if (r14.find() == false) goto L131;
        r10.add(r14.group(1));     // Catch: Throwable -> L18
    L131:
        r12.close();     // Catch: SQLException -> L106
    L135:
        r11.close();     // Catch: SQLException -> L107
    L22:
        Collections.reverse(r10);
        Statement r15 = r17.f1000a.createStatement();     // Catch: Throwable -> L43
        ResultSet r16 = r15.executeQuery("pragma foreign_key_list('" + bv.a.a(((String) this.f9376b).toLowerCase()) + "')");     // Catch: Throwable -> L41
        int r20 = -1;
        int r21 = 0;
        cv.a r22 = null;
    L122:
        if (r16.next() == false) goto L149;
        int r23 = r16.getInt(1);     // Catch: Throwable -> L31
        r16.getInt(2);     // Catch: Throwable -> L31
        String r110 = r16.getString(3);     // Catch: Throwable -> L31
        String r111 = r16.getString(4);     // Catch: Throwable -> L31
        String r112 = r16.getString(5);     // Catch: Throwable -> L31
        String r113 = r16.getString(6);     // Catch: Throwable -> L31
        String r114 = r16.getString(7);     // Catch: Throwable -> L31
        r16.getString(8);     // Catch: Throwable -> L31
        if (r10.size() <= r21) goto L33;
        String r115 = (String) r10.get(r21);     // Catch: Throwable -> L31
    L34:
        if (r23 == r20) goto L36;
        String r24 = (String) this.f9376b;     // Catch: Throwable -> L31
        r22 = new cv.a();     // Catch: Throwable -> L31
        r22.d = new ArrayList();     // Catch: Throwable -> L31
        r22.e = new ArrayList();     // Catch: Throwable -> L31
        r22.f16507a = r115;     // Catch: Throwable -> L31
        r22.f16508b = r110;     // Catch: Throwable -> L31
        r22.f16509c = r24;     // Catch: Throwable -> L31
        r22.f = r113;     // Catch: Throwable -> L31
        r22.g = r114;     // Catch: Throwable -> L31
        ((ArrayList) this.f9377c).add(r22);     // Catch: Throwable -> L31
        r21 = r21 + 1;     // Catch: Throwable -> L31
        r20 = r23;
    L36:
        r22.d.add(r111);     // Catch: Throwable -> L31
        r22.e.add(r112);     // Catch: Throwable -> L31
        goto L122
    L33:
        r115 = null;
        goto L34
    L149:
        r16.close();     // Catch: Exception -> L108
    L120:
        r15.close();     // Catch: Exception -> L109
        return;
    L165:
        return;
    L31:
        th = th;
        ResultSet r25 = r16;
    L45:
        if (r25 != null) goto L126;
    L47:
        if (r15 == null) goto L166;
        r15.close();     // Catch: Exception -> L111
        throw th;
    L167:
        throw th;
    L166:
        throw th;
    L126:
        r25.close();     // Catch: Exception -> L110
    L41:
        th = th;
    L42:
        r25 = null;
    L43:
        th = th;
        r15 = null;
    L50:
        th = th;
        r13 = null;
    L52:
        th = th;
        r13 = null;
        r11 = null;
    L60:
        throw new SQLException(j0.k("Invalid table name: '", r18, "'"));
    L61:
        this.d = r17;
        ResultSet r26 = null;
        this.f9376b = null;
        this.f9377c = null;
        if (r18 == null) goto L105;
        if (r18.trim().length() == 0) goto L105;
        Statement r27 = r17.f1000a.createStatement();     // Catch: Throwable -> L97
        ResultSet r28 = r27.executeQuery("select sql from sqlite_master where lower(name) = lower('" + bv.a.a(r18) + "') and type in ('table', 'view')");     // Catch: Throwable -> L72
        if (r28.next() == false) goto L96;
        Matcher r29 = cv.b.f16516x.matcher(r28.getString(1));     // Catch: Throwable -> L72
        if (r29.find() == false) goto L74;
        this.f9376b = cv.b.d(bv.a.a(r29.group(1)));     // Catch: Throwable -> L72
        this.f9377c = r29.group(2).split(",");     // Catch: Throwable -> L72
    L78:
        if (((String[]) this.f9377c) != null) goto L86;
        r28 = r27.executeQuery("pragma table_info('" + bv.a.a(r18) + "');");     // Catch: Throwable -> L72
    L81:
        if (r28.next() == false) goto L86;
        if (r28.getBoolean(6) == false) goto L81;
        this.f9377c = new String[]{r28.getString(2)};     // Catch: Throwable -> L72
    L86:
        if (((String[]) this.f9377c) == null) goto L141;
        int r30 = 0;
    L88:
        String[] r31 = (String[]) this.f9377c;     // Catch: Throwable -> L72
        if (r30 >= r31.length) goto L141;
        r31[r30] = cv.b.d(r31[r30]);     // Catch: Throwable -> L72
        r30 = r30 + 1;
    L141:
        r28.close();     // Catch: Exception -> L114
    L133:
        r27.close();     // Catch: Exception -> L115
        return;
    L170:
        return;
    L74:
        Matcher r32 = cv.b.f16515w.matcher(r28.getString(1));     // Catch: Throwable -> L72
        if (r32.find() == false) goto L78;
        this.f9377c = r32.group(1).split(",");     // Catch: Throwable -> L72
        goto L78
    L96:
        throw new SQLException("Table not found: '" + r18 + "'");     // Catch: Throwable -> L72
    L72:
        th = th;
    L99:
        if (0 != 0) goto L139;
    L101:
        if (r27 == null) goto L171;
        r27.close();     // Catch: Exception -> L117
        throw th;
    L172:
        throw th;
    L171:
        throw th;
    L139:
        r26.close();     // Catch: Exception -> L116
    L97:
        th = th;
        r27 = null;
    L105:
        throw new SQLException(j0.k("Invalid table name: '", r18, "'"));
    }
}

package com.lynx.tasm;

import android.content.Context;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.JsonObject;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewNested;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.DiskLruCache;

/* JADX INFO: loaded from: classes2.dex */
public class t implements CacheRequest, s8.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f10963c;
    public Object d;
    public Object e;
    public Object f;

    public /* synthetic */ t() {
        this.f10961a = 0;
    }

    public static void i(LynxBaseUI r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.getChildren() == null) goto L16;
        int r10 = r5.getChildren().size();
        int r11 = 0;
    L7:
        if (r11 >= r10) goto L17;
        LynxBaseUI r12 = r5.getChildAt(r11);
        if ((r12 instanceof LynxUI) == false) goto L11;
        ViewCompat.setImportantForAccessibility(((LynxUI) r12).getView(), 2);
    L11:
        i(r12);
        r11 = r11 + 1;
        goto L7
    L17:
        return;
    }

    @Override // s8.e
    public void a() {
        switch(this.f10961a) {
            case 3: goto L7;
            default: goto L4;
        };
    L4:
        Context r5 = (Context) this.d;
        f();
        this.f = new j8.a(this, (WeakHandler) this.f10963c, 3);
        r5.getContentResolver().registerContentObserver(WsChannelMultiProcessSharedProvider.b(r5, WsConstants.KEY_FRONTIER_ENABLED, "boolean"), true, (j8.a) this.f);     // Catch: Throwable -> L13
        return;
    L17:
        return;
    L7:
        ym.o r10 = (ym.o) this.d;
        Iterator r11 = ((ConcurrentHashMap) r10.f23310b).entrySet().iterator();
    L9:
        if (r11.hasNext() == false) goto L11;
        ((ConcurrentHashMap) ((Map.Entry) r11.next()).getValue()).clear();
        goto L9
    L11:
        ((ConcurrentHashMap) r10.f23310b).clear();
    }

    @Override // okhttp3.internal.cache.CacheRequest
    public void abort() {
        okhttp3.g r5 = (okhttp3.g) this.f;
        monitor-enter(r5);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f10962b == false) goto L9;
        monitor-exit(r5);
        return;
    L9:
        this.f10962b = true;     // Catch: Throwable -> L14
        ((okhttp3.g) this.f).getClass();     // Catch: Throwable -> L14
        monitor-exit(r5);
        Util.closeQuietly((nu.a0) this.f10963c);
        ((DiskLruCache.Editor) this.e).abort();     // Catch: IOException -> L17
        return;
    }

    public String b(String r5, String r10) {
        Intrinsics.checkNotNullParameter("ai_storage_user", Constant.NUBIA_ACCOUNT_FIELD_USER_ID);
        StringBuilder r11 = androidx.constraintlayout.motion.widget.a.D(r5, "groupId", r10, "storageId", "ai_storage_user&");
        if (this.f10962b == false) goto L5;
        String r12 = "shared";
    L6:
        r11.append(r12);
        r11.append(Typography.amp);
        r11.append(r5);
        r11.append(Typography.amp);
        r11.append(r10);
        String r13 = r11.toString();
        String r14 = com.lynx.tasm.behavior.utils.d.c("mappingStorage=", r13, "AIStorageItem");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L9;
        r15.d("AIStorageItem", r14);
    L9:
        return r13;
    L5:
        r12 = "private";
        goto L6
    }

    @Override // okhttp3.internal.cache.CacheRequest
    public nu.a0 body() {
        return (okhttp3.f) this.d;
    }

    public String c(String r5, String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter("ai_storage_user", Constant.NUBIA_ACCOUNT_FIELD_USER_ID);
        Intrinsics.checkNotNullParameter(r5, "storageId");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        if (r12 == false) goto L5;
        m2.b r13 = (r9.c) this.e;
    L6:
        String r14 = r13.a(b((String) this.f10963c, r5), r10, r11);
        String r15 = com.lynx.tasm.utils.b.j("getStorageItem key ", r10, " value ", r14);
        Intrinsics.checkNotNullParameter("AIStorage", "tag");
        t0.d r16 = com.bytedance.ai.utils.c.f2846a;
        if (r16 == null) goto L9;
        r16.d("AIStorage", r15);
    L9:
        return r14;
    L5:
        r13 = (ym.o) this.d;
        goto L6
    }

    public void d(String r10, String r11, String r12, boolean r13, String r14) {
        Intrinsics.checkNotNullParameter("ai_storage_user", Constant.NUBIA_ACCOUNT_FIELD_USER_ID);
        Intrinsics.checkNotNullParameter(r10, "storageId");
        Intrinsics.checkNotNullParameter(r11, STGroup.DICT_KEY);
        String r5 = (String) this.f10963c;
        String r15 = b(r5, r10);
        String r16 = com.lynx.tasm.utils.b.j("updateStorageItem key ", r11, " value ", r12);
        Intrinsics.checkNotNullParameter("AIStorage", "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L5;
        r17.d("AIStorage", r16);
    L5:
        if (r13 == false) goto L7;
        m2.b r18 = (r9.c) this.e;
    L9:
        if (r18.a(r15, r11, null) != null) goto L11;
        String r19 = "onDataCreated";
    L12:
        r18.f(r15, r11, r12);
        CopyOnWriteArrayList r20 = (CopyOnWriteArrayList) ((ConcurrentHashMap) ((Lazy) this.f).getValue()).get(r15);
        if (r20 == null) goto L29;
        ArrayList r21 = new ArrayList();
        Iterator r22 = r20.iterator();
    L16:
        if (r22.hasNext() == false) goto L20;
        Object r23 = r22.next();
        if (Intrinsics.areEqual(((m2.c) r23).f19977b, r11) == false) goto L16;
        r21.add(r23);
        goto L16
    L20:
        Iterator r24 = r21.iterator();
    L22:
        if (r24.hasNext() == false) goto L40;
        m2.c r25 = (m2.c) r24.next();
        String r26 = "updateStorageItem notify  " + r25;
        Intrinsics.checkNotNullParameter("AIStorage", "tag");
        t0.d r27 = com.bytedance.ai.utils.c.f2846a;
        if (r27 == null) goto L26;
        r27.d("AIStorage", r26);
    L26:
        m2.a r28 = (m2.a) r25.d.get();
        if (r28 == null) goto L22;
        JsonObject r29 = new JsonObject();
        r29.addProperty("groupID", r5);
        r29.addProperty("storageID", r10);
        r29.addProperty("persistent", Boolean.valueOf(r13));
        r29.addProperty(STGroup.DICT_KEY, r11);
        r29.addProperty("value", r12);
        r29.addProperty("extra", r14);
        Unit r30 = Unit.INSTANCE;
        r28.onMessageToAIBridge(r19, r29);
        goto L22
    L40:
        return;
    L29:
        return;
    L11:
        r19 = "onDataUpdated";
        goto L12
    L7:
        r18 = (ym.o) this.d;
        goto L9
    }

    public boolean e(LynxBaseUI r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        int r5 = r10.getAccessibilityElementStatus();
        if (r5 != (-1)) goto L8;
        boolean r11 = this.f10962b;
    L11:
        WeakReference r12 = (WeakReference) this.f10963c;
        if (r12 == null) goto L14;
        UIGroup r13 = (UIGroup) r12.get();
    L15:
        if (r11 == false) goto L26;
        if (r13 == null) goto L26;
        HashMap r14 = (HashMap) this.f;
        if (r14.isEmpty() == true) goto L26;
    L19:
        if (r10 == null) goto L25;
        if (r10 == r13) goto L25;
        if (r14.containsKey(Integer.valueOf(r10.getSign())) == true) goto L23;
        r10 = r10.getParentBaseUI();
        goto L19
    L23:
        return true;
    L25:
        return false;
    L26:
        return r11;
    L14:
        r13 = null;
        goto L15
    L8:
        if (r5 != 1) goto L10;
        r11 = true;
        goto L11
    L10:
        r11 = false;
        goto L11
    }

    public void f() {
        boolean r5 = ((c5.a) g8.g.d((Context) this.d).f17073b).b(WsConstants.KEY_FRONTIER_ENABLED, true);     // Catch: Throwable -> L10
        if (Logger.debug() == false) goto L7;
        Logger.d("WsChannelService", "pushSdkEnabled = " + r5);     // Catch: Throwable -> L10
    L7:
        if (r5 == this.f10962b) goto L13;
        this.f10962b = r5;     // Catch: Throwable -> L10
        return;
    L13:
        return;
    }

    public void g(String r10, String r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter("ai_storage_user", Constant.NUBIA_ACCOUNT_FIELD_USER_ID);
        Intrinsics.checkNotNullParameter(r10, "storageId");
        Intrinsics.checkNotNullParameter(r11, STGroup.DICT_KEY);
        String r5 = (String) this.f10963c;
        String r14 = b(r5, r10);
        m2.b r15 = (ym.o) this.d;
        r9.c r16 = (r9.c) this.e;
        if (r13 == false) goto L5;
        m2.b r17 = r16;
    L6:
        String r18 = r17.a(r14, r11, null);
        if (r13 == false) goto L9;
        r15 = r16;
    L9:
        r15.a(r14, r11);
        String r19 = "removeStorageItem key ".concat(r14);
        Intrinsics.checkNotNullParameter("AIStorage", "tag");
        t0.d r20 = com.bytedance.ai.utils.c.f2846a;
        if (r20 == null) goto L12;
        r20.d("AIStorage", r19);
    L12:
        CopyOnWriteArrayList r21 = (CopyOnWriteArrayList) ((ConcurrentHashMap) ((Lazy) this.f).getValue()).get(r14);
        if (r21 == null) goto L29;
        ArrayList r22 = new ArrayList();
        Iterator r23 = r21.iterator();
    L16:
        if (r23.hasNext() == false) goto L20;
        Object r24 = r23.next();
        if (Intrinsics.areEqual(((m2.c) r24).f19977b, r11) == false) goto L16;
        r22.add(r24);
        goto L16
    L20:
        Iterator r25 = r22.iterator();
    L22:
        if (r25.hasNext() == false) goto L40;
        m2.c r26 = (m2.c) r25.next();
        String r27 = "removeStorageItem notify  " + r26;
        Intrinsics.checkNotNullParameter("AIStorage", "tag");
        t0.d r28 = com.bytedance.ai.utils.c.f2846a;
        if (r28 == null) goto L26;
        r28.d("AIStorage", r27);
    L26:
        m2.a r29 = (m2.a) r26.d.get();
        if (r29 == null) goto L22;
        JsonObject r30 = new JsonObject();
        r30.addProperty("groupID", r5);
        r30.addProperty("storageID", r10);
        r30.addProperty("persistent", Boolean.valueOf(r13));
        r30.addProperty(STGroup.DICT_KEY, r11);
        r30.addProperty("value", r18);
        r30.addProperty("extra", r12);
        Unit r31 = Unit.INSTANCE;
        r29.onMessageToAIBridge("onDataRemoved", r30);
        goto L22
    L40:
        return;
    L29:
        return;
    L5:
        r17 = r15;
        goto L6
    }

    public void h(LynxBaseUI r10) {
        WeakReference r11 = (WeakReference) this.f10963c;
        if (r11 != null) goto L5;
    L11:
        com.lynx.tasm.behavior.n0 r12 = null;
    L12:
        if (r10 == null) goto L45;
        if (r12 != null) goto L15;
        return;
    L15:
        if (r10.getAccessibilityElementsA11y() == null) goto L17;
    L19:
        i(r10);
        ArrayList<String> r5 = r10.getAccessibilityElementsA11y();
        int r13 = 0;
        if (r5 != null) goto L22;
        r5 = r10.getAccessibilityElements();
        boolean r14 = false;
    L23:
        ArrayList r15 = new ArrayList();
        Iterator<String> r16 = r5.iterator();
    L25:
        if (r16.hasNext() == false) goto L37;
        String r17 = r16.next();
        if (r17 == null) goto L25;
        if (r14 == false) goto L30;
        LynxBaseUI r18 = r12.w(r17);
    L32:
        if ((r18 instanceof LynxUI) == false) goto L25;
        LynxUI r19 = (LynxUI) r18;
        if (r19.getView() == null) goto L25;
        ViewCompat.setImportantForAccessibility(r19.getView(), 1);
        r15.add(r19);
        goto L25
    L30:
        r18 = r12.E(r17);
        goto L32
    L37:
        if (r15.isEmpty() == false) goto L39;
        return;
    L39:
        if (r15.size() == 1) goto L59;
        int r20 = r15.size();
    L43:
        if (r13 >= (r20 - 1)) goto L60;
        LynxUI r21 = (LynxUI) r15.get(r13);
        r13 = r13 + 1;
        LynxUI r22 = (LynxUI) r15.get(r13);
        View r23 = r21.getView();
        View r24 = r22.getView();
        r23.setId(r21.getSign());
        r24.setId(r22.getSign());
        r23.setAccessibilityTraversalBefore(r22.getSign());
        goto L43
    L60:
        return;
    L59:
        return;
    L22:
        r14 = true;
        goto L23
    L17:
        if (r10.getAccessibilityElements() != null) goto L19;
        return;
    L45:
        return;
    L5:
        if (r11.get() == null) goto L11;
        LynxBaseUI r25 = (LynxBaseUI) r11.get();
        if (r25 == null) goto L11;
        if (r25.getLynxContext() == null) goto L11;
        r12 = (com.lynx.tasm.behavior.n0) r25.getLynxContext().f10147o.get();
        goto L12
    }

    @Override // s8.e
    public boolean isEnable() {
        return this.f10962b;
    }

    public t(Context r5, WeakHandler r10) {
        this.f10961a = 5;
        this.f10963c = r10;
        this.d = r5;
    }

    public t(UIBody r5) {
        this.f10961a = 1;
        this.f10962b = false;
        this.d = null;
        this.e = null;
        this.f = null;
        if (r5.getView() != 0) goto L5;
        LynxLog.b(4, "LynxAccessibilityHelper", "Construct LynxAccessibilityHelper with null host ui or view");
        return;
    L5:
        this.f10963c = new WeakReference(r5);
        this.e = new ArrayList();
        this.d = new ArrayList();
        this.f = new HashMap();
    }

    @Override // s8.e
    public void a(s8.a r5) {
        this.e = r5;
    }

    public t(LynxBaseScrollViewNested r5) {
        this.f10961a = 2;
        this.e = r5;
    }

    public t(boolean r5, String r10) {
        this.f10961a = 3;
        Intrinsics.checkNotNullParameter(r10, "groupId");
        this.f10962b = r5;
        this.f10963c = r10;
        this.d = new ym.o(10);
        this.e = new r9.c(12);
        this.f = LazyKt.lazy(new a3.f(28));
    }

    public t(okhttp3.g r5, DiskLruCache.Editor r10) {
        this.f10961a = 4;
        Intrinsics.checkNotNullParameter(r10, "editor");
        this.f = r5;
        this.e = r10;
        nu.a0 r11 = r10.newSink(1);
        this.f10963c = r11;
        this.d = new okhttp3.f(this, r11);
    }
}

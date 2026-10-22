package com.ss.android.lark.larkconfig.export.handler;

import android.text.TextUtils;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appsetting.api.AppSettingApiModule;
import com.ss.android.lark.appsetting.api.InternalLocalDefaultConfigStorage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class AbstractBaseSettingHandler implements com.ss.android.lark.larkconfig.export.handler.a<String> {
    public final ExecutorService a;
    public String b;
    public String c;
    public final a d;
    public final a e;
    public a f;
    public boolean g;
    public boolean h;

    public static final class a {
        public final List<Function0<Boolean>> a;
        public final List<Function0<Boolean>> b;
        public final List<Function0<Boolean>> c;
        public final List<Function1<String, Unit>> d;
        public final List<Function3<String, Boolean, String, Unit>> e;
        public final List<Function0<Boolean>> f;
        public final List<Function0<Unit>> g;

        public a() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            return (((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
        }

        public final String toString() {
            return "Strategy(isProcessRemoteSettingStrategies=" + this.a + ", emptyMapStrategies=" + this.b + ", emptyRemoteSettingStrategies=" + this.c + ", processRemoteSetting=" + this.d + ", processRemoteSettingWithUserSyncUpdate=" + this.e + ", isProcessLocalSettingStrategies=" + this.f + ", processLocalSettingStrategies=" + this.g + ')';
        }

        public final a d() {
            return new a(new LinkedList(this.a), new LinkedList(this.b), new LinkedList(this.c), new LinkedList(this.d), new LinkedList(this.e), new LinkedList(this.f), new LinkedList(this.g));
        }

        public /* synthetic */ a(int r9) {
            this(new LinkedList(), new LinkedList(), new LinkedList(), new LinkedList(), new LinkedList(), new LinkedList(), new LinkedList());
        }

        public final void b(Function0 r2) {
            Intrinsics.checkNotNullParameter(r2, "strategy");
            a(this.c, r2);
        }

        public final void c(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "strategy");
            a(this.d, r2);
        }

        public final void a(List r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            r2.add(r3);
        }

        public a(List<Function0<Boolean>> r2, List<Function0<Boolean>> r3, List<Function0<Boolean>> r4, List<Function1<String, Unit>> r5, List<Function3<String, Boolean, String, Unit>> r6, List<Function0<Boolean>> r7, List<Function0<Unit>> r8) {
            Intrinsics.checkNotNullParameter(r2, "isProcessRemoteSettingStrategies");
            Intrinsics.checkNotNullParameter(r3, "emptyMapStrategies");
            Intrinsics.checkNotNullParameter(r4, "emptyRemoteSettingStrategies");
            Intrinsics.checkNotNullParameter(r5, "processRemoteSetting");
            Intrinsics.checkNotNullParameter(r6, "processRemoteSettingWithUserSyncUpdate");
            Intrinsics.checkNotNullParameter(r7, "isProcessLocalSettingStrategies");
            Intrinsics.checkNotNullParameter(r8, "processLocalSettingStrategies");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }
    }

    public static abstract class b extends AbstractBaseSettingHandler {
        @Override // com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler
        public final kpb.a.b c() {
            return ((kpb.a) ClaymoreServiceLoader.loadFirst(kpb.a.class)).getUserRepo();
        }

        public b() {
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ AbstractBaseSettingHandler b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ String d;

        public c(boolean r1, AbstractBaseSettingHandler r2, boolean r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            if (this.a == false) goto L18;
            boolean r0 = AppSettingApiModule.a().isLogin();
            Log.i(this.b.f(), "checkValue isLogin: " + r0);
            if (r0 == false) goto L13;
            if (this.c == false) goto L21;
            List<Function1<String, Unit>> r1 = this.b.f.d;
            String r2 = this.d;
            Iterator<T> r3 = r1.iterator();
        L10:
            if (r3.hasNext() == false) goto L23;
            ((Function1) r3.next()).invoke(r2);
            goto L10
        L23:
            return;
        L21:
            return;
        L13:
            if (this.c == true) goto L22;
            List<Function1<String, Unit>> r4 = this.b.f.d;
            String r5 = this.d;
            Iterator<T> r6 = r4.iterator();
        L16:
            if (r6.hasNext() == false) goto L24;
            ((Function1) r6.next()).invoke(r5);
            goto L16
        L24:
            return;
        L22:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ AbstractBaseSettingHandler b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public d(boolean r1, AbstractBaseSettingHandler r2, boolean r3, String r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void a() {
            if (this.a == false) goto L18;
            boolean r0 = AppSettingApiModule.a().isLogin();
            Log.i(this.b.f(), "checkValue isLogin: " + r0);
            if (r0 == false) goto L13;
            if (this.c == false) goto L18;
            List<Function1<String, Unit>> r1 = this.b.f.d;
            String r2 = this.d;
            Iterator<T> r3 = r1.iterator();
        L10:
            if (r3.hasNext() == false) goto L18;
            ((Function1) r3.next()).invoke(r2);
            goto L10
        L13:
            if (this.c == true) goto L18;
            List<Function1<String, Unit>> r4 = this.b.f.d;
            String r5 = this.d;
            Iterator<T> r6 = r4.iterator();
        L16:
            if (r6.hasNext() == false) goto L18;
            ((Function1) r6.next()).invoke(r5);
        L18:
            List<Function3<String, Boolean, String, Unit>> r7 = this.b.f.e;
            String r8 = this.d;
            boolean r9 = this.c;
            String r10 = this.e;
            Iterator<T> r11 = r7.iterator();
        L20:
            if (r11.hasNext() == false) goto L22;
            ((Function3) r11.next()).invoke(r8, Boolean.valueOf(r9), r10);
            goto L20
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public abstract String f();

    public kpb.a.b c() {
        return ((kpb.a) ClaymoreServiceLoader.loadFirst(kpb.a.class)).getLarkRepo();
    }

    public String d() {
        return f() + a();
    }

    public final String g() {
        String r0 = this.b;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.h == true) goto L20;
        if (this.c != null) goto L20;
        this.h = true;
        String r1 = e(this, d());
        String r2 = null;
        if ((true ^ TextUtils.isEmpty(r1)) == true) goto L13;
        r1 = null;
    L13:
        if (r1 != null) goto L17;
        String r3 = a();
        if (r3 == null) goto L18;
        r2 = ((InternalLocalDefaultConfigStorage) InternalLocalDefaultConfigStorage.g.getValue()).b(r3);
    L18:
        this.c = r2;
        goto L20
    L17:
        r2 = r1;
    L20:
        return this.c;
    }

    public AbstractBaseSettingHandler() {
        this.a = CoreThreadPool.getDefault().newSerialCpuDensityThreadPool("setting_blocking_update_service");
        a r0 = new a(0);
        Function0<Boolean> r1 = new AbstractBaseSettingHandler$softStrategy$1(this);
        Intrinsics.checkNotNullParameter(r1, "strategy");
        r0.a(r0.b, r1);
        r0.b(new AbstractBaseSettingHandler$softStrategy$2(this));
        Function0<Boolean> r2 = new AbstractBaseSettingHandler$softStrategy$3(this);
        Intrinsics.checkNotNullParameter(r2, "strategy");
        r0.a(r0.f, r2);
        this.d = r0;
        a r3 = r0.d();
        r3.c(new AbstractBaseSettingHandler$mixedStrategy$1(this));
        Function0<Unit> r4 = new AbstractBaseSettingHandler$mixedStrategy$2(this);
        Intrinsics.checkNotNullParameter(r4, "strategy");
        r3.a(r3.g, r4);
        this.e = r3;
        a r5 = r3.d();
        Function0<Boolean> r6 = new AbstractBaseSettingHandler$defaultStrategy$1(this);
        Intrinsics.checkNotNullParameter(r6, "strategy");
        r5.a(r5.b, r6);
        r5.b(new AbstractBaseSettingHandler$defaultStrategy$2(this));
        this.f = r5;
    }

    public static String e(AbstractBaseSettingHandler r2, String r3) {
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter("", "value");
        String r4 = r2.c().getString(r3, "");
        if (r4 != null) goto L6;
        return "";
    L6:
        return r4;
    }

    public static void h(AbstractBaseSettingHandler r2, String r3) {
        String r0 = r2.d();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r0, TabAppInfo.IMAGE_JSON_KEY);
        r2.c().putString(r0, r3);
    }

    public final void b(String r8, boolean r9, boolean r10, boolean r11, String r12) {
        if (TextUtils.isEmpty(r8) == false) goto L14;
        Iterator<Function0<Boolean>> r0 = this.f.c.iterator();
        boolean r2 = false;
    L6:
        if (r0.hasNext() == false) goto L11;
        if (((Boolean) r0.next().invoke()).booleanValue() == true) goto L6;
        r2 = true;
        goto L6
    L11:
        if (r2 == false) goto L14;
        Log.i(f(), "value is not valid");
        return;
    L14:
        if (r8 != null) goto L17;
        Log.i(f(), "value is null");
        return;
    L17:
        this.g = true;
        if (r11 == false) goto L23;
        this.a.execute(new c(r10, this, r9, r8));
        Iterator<T> r13 = this.f.e.iterator();
    L21:
        if (r13.hasNext() == false) goto L31;
        ((Function3) r13.next()).invoke(r8, Boolean.valueOf(r9), r12);
        goto L21
    L31:
        return;
    L23:
        this.a.execute(new d(r10, this, r9, r8, r12));
    }

    public final void i(Map<String, String> r7, boolean r8, boolean r9, boolean r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "uid");
        Log.d(f(), "setting handler start set setting from remote");
        Iterator<Function0<Boolean>> r0 = this.f.a.iterator();
        boolean r1 = false;
        boolean r2 = false;
    L3:
        boolean r4 = true;
        if (r0.hasNext() == false) goto L10;
        if (((Boolean) r0.next().invoke()).booleanValue() == true) goto L3;
        r2 = true;
        goto L3
    L10:
        if ((!r2) == true) goto L13;
        Log.d(f(), "setting from remote not allowed");
        return;
    L13:
        if (r7 != null) goto L22;
        Iterator<Function0<Boolean>> r3 = this.f.b.iterator();
    L16:
        if (r3.hasNext() == false) goto L21;
        if (((Boolean) r3.next().invoke()).booleanValue() == true) goto L16;
        r1 = true;
        goto L16
    L21:
        r4 = true ^ r1;
    L22:
        if (r4 == true) goto L25;
        Log.i(f(), "map is not valid");
        return;
    L25:
        if (r7 != null) goto L28;
        Log.i(f(), "value is null");
        return;
    L28:
        monitor-enter(this);
        if (r9 == true) goto L42;
    L36:
        b(r7.get(a()), r8, r9, r10, r11);     // Catch: Throwable -> L39
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L39
        monitor-exit(this);
        return;
    L39:
        th = move-exception;
        throw th;
    L42:
        boolean r5 = AppSettingApiModule.a().isLogin();     // Catch: Throwable -> L39
        Log.i(f(), "setSettingFromRemote, isLogin: " + r5 + ", isUserData: " + r8);     // Catch: Throwable -> L39
        if (r5 == false) goto L34;
        if (r8 == false) goto L36;
        this.b = r7.get(a());     // Catch: Throwable -> L39
        goto L36
    L34:
        if (r8 == true) goto L36;
        this.b = r7.get(a());     // Catch: Throwable -> L39
        goto L36
    }
}

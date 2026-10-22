package o0c;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.ss.android.lark.permission.rxPermission.RxPermissionsFragment;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public static final Object b = null;
    public static final List<PublishSubject<Boolean>> c = null;
    public final RxPermissionsFragment a;

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> implements ObservableTransformer<T, Boolean> {
        public final /* synthetic */ Token a;
        public final /* synthetic */ String[] b;
        public final /* synthetic */ c c;

        /* JADX INFO: renamed from: o0c.c$a$a, reason: collision with other inner class name */
        public class C0172a implements Function<List<n0c.a>, ObservableSource<Boolean>> {
            public C0172a() {
            }

            public final Object apply(Object r2) throws Exception {
                List r3 = (List) r2;
                if (r3.isEmpty() == true) goto L16;
                Iterator r4 = r3.iterator();
            L7:
                if (r4.hasNext() == false) goto L12;
                if (((n0c.a) r4.next()).b == true) goto L7;
                return Observable.just(Boolean.FALSE);
            L12:
                return Observable.just(Boolean.TRUE);
            L16:
                return Observable.empty();
            }
        }

        public final ObservableSource<Boolean> apply(Observable<T> r4) {
            return c.a(this.c, r4, this.a, this.b).buffer(this.b.length).flatMap(new C0172a());
        }

        public a(c r1, Token r2, String[] r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public class b {
        public final o0c.b.a a;
        public final List<String> b;

        public b(o0c.b.a r1, List r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        b = new Object();
        c = new ArrayList();
    }

    public c(Activity r6) {
        RxPermissionsFragment r0 = (RxPermissionsFragment) r6.getFragmentManager().findFragmentByTag("RxPermissions");
        if (r0 != null) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        r0 = new RxPermissionsFragment();
        Bundle r4 = new Bundle();
        r4.putBoolean("key_enable_patch", false);
        r0.setArguments(r4);
        FragmentManager r7 = r6.getFragmentManager();
        r7.beginTransaction().add(r0, "RxPermissions").commitAllowingStateLoss();
        r7.executePendingTransactions();
    L8:
        this.a = r0;
        return;
    L5:
        r3 = false;
        goto L6
    }

    public final boolean d(String r23) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L32;
        Activity r2 = this.a.getActivity();
        ArrayList r13 = new ArrayList();
        Object[] r14 = {r23};
        f06.b r15 = new f06.b("auto_cert_com_ss_android_lark_permission_rxPermission_RxPermissionsFragment_android_app_Activity_checkSelfPermission");
        g06.a r5 = (g06.a) ApiHookConfig.b.get(102608);
        if (r5 == null) goto L10;
        f06.a[] r6 = r5.i;
    L11:
        f06.a[] r12 = r6;
        int r11 = r12.length;
        int r10 = 0;
    L13:
        if (r10 >= r11) goto L20;
        f06.a r9 = r12[r10];
        int r19 = r10;
        int r20 = r11;
        f06.a[] r21 = r12;
        f06.d r7 = r9.preInvoke(102608, "android/app/Activity", "checkSelfPermission", r2, r14, "int", r15);     // Catch: Exception -> L34
        if (r7.a == true) goto L22;
        r13.add(r9);     // Catch: Exception -> L34
    L22:
        if (r7.a == false) goto L24;
        int r0 = ((Integer) r7.b).intValue();
    L25:
        if (r0 != 0) goto L27;
        boolean r3 = true;
    L28:
        if (r3 == true) goto L32;
        return false;
    L27:
        r3 = false;
        goto L28
    L24:
        r0 = r2.checkSelfPermission(r23);
    L19:
        r10 = r19 + 1;
        r11 = r20;
        r12 = r21;
        goto L13
    L20:
        r7 = new f06.d(false, null);
        goto L22
    L10:
        r6 = ApiHookConfig.d;
    L32:
        return true;
    L5:
        r1 = false;
        goto L6
    }

    public static List b(c r9, String[] r10) {
        r9.getClass();
        if (r10 == null) goto L27;
        if (r10.length == 0) goto L27;
        ArrayList r11 = new ArrayList();
        HashMap r0 = new HashMap();
        int r1 = r10.length;
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L21;
        String r4 = r10[r3];
        o0c.b.a r5 = (o0c.b.a) ((HashMap) o0c.b.a).get(r4);
        if (r5 == null) goto L14;
        b r6 = (b) r0.get(r5.a);
        if (r6 != null) goto L13;
        r6 = new b(r5, new ArrayList());
        r0.put(r5.a, r6);
    L13:
        r6.b.add(r4);
    L20:
        r3 = r3 + 1;
        goto L7
    L14:
        b r7 = (b) r0.get("unknown");
        if (r7 != null) goto L17;
        r7 = new b(new o0c.b.a("unknown", "", "", 0), new ArrayList());
        r0.put("unknown", r7);
    L17:
        r7.b.add(r4);
        if (TextUtils.equals("android.permission.POST_NOTIFICATIONS", r4) == true) goto L20;
        EnsureManager.ensureNotReachHere("request_permission_nopurpose:" + r4);
        goto L20
    L21:
        Iterator r12 = r0.keySet().iterator();
    L23:
        if (r12.hasNext() == false) goto L25;
        r11.add((b) r0.get((String) r12.next()));
        goto L23
    L25:
        return r11;
    L27:
        throw new IllegalArgumentException("RxPermissions.request/requestEach requires at least one input permission");
    }

    public final Observable<n0c.a> e(Token r3, String... r4) {
        Observable r0 = Observable.just(b);
        if (((o0c.a) ClaymoreServiceLoader.loadFirst(o0c.a.class)).enablePurposeDialog() == false) goto L5;
        ObservableTransformer r1 = new p(this, r4, r3);
    L7:
        return r0.compose(r1);
    L5:
        r1 = new k(this, r3, r4);
        goto L7
    }

    public final void f(Token r4, String[] r5) throws SensitiveAPIException {
        RxPermissionsFragment r0 = this.a;
        TextUtils.join(", ", r5);
        r0.getClass();
        if (r4 != null) goto L6;
        this.a.requestPermissions(r5);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 23) goto L8;
        vf7.b.a.requestPermissions(this.a, r5, RxPermissionsFragment.a(r5), r4);
        return;
    L8:
        vf7.b.a.c(this.a.getActivity(), r5, RxPermissionsFragment.a(r5), r4);
    }

    public final <T> ObservableTransformer<T, Boolean> c(Token r2, boolean r3, String... r4) {
        if (((o0c.a) ClaymoreServiceLoader.loadFirst(o0c.a.class)).enablePurposeDialog() == false) goto L7;
        return new j(this, r4, r3, r2);
    L7:
        return new a(this, r2, r4);
    }

    public static Observable a(c r5, Observable r6, Token r7, String[] r8) {
        r5.getClass();
        if (r8 == null) goto L20;
        if (r8.length == 0) goto L20;
        int r0 = r8.length;
        int r1 = 0;
    L7:
        Object r2 = b;
        if (r1 >= r0) goto L13;
        String r3 = r8[r1];
        if (((ConcurrentHashMap) r5.a.a).containsKey(r3) == false) goto L11;
        r1 = r1 + 1;
        goto L7
    L11:
        Observable r4 = Observable.empty();
    L14:
        if (r6 != null) goto L16;
        Observable r9 = Observable.just(r2);
    L18:
        return r9.flatMap(new q(r5, r7, r8));
    L16:
        r9 = Observable.merge(r6, r4);
        goto L18
    L13:
        r4 = Observable.just(r2);
    L20:
        throw new IllegalArgumentException("RxPermissions.request/requestEach requires at least one input permission");
    }
}

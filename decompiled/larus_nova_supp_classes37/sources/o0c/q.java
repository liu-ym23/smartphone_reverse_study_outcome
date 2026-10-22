package o0c;

import android.os.Build;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.permission.rxPermission.RxPermissionsFragment;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class q implements Function<Object, Observable<n0c.a>> {
    public final /* synthetic */ Token a;
    public final /* synthetic */ String[] b;
    public final /* synthetic */ c c;

    public final Object apply(Object r12) throws Exception {
        c r13 = this.c;
        Token r0 = this.a;
        String[] r1 = this.b;
        r13.getClass();
        ArrayList r2 = new ArrayList(r1.length);
        ArrayList r3 = new ArrayList();
        int r4 = r1.length;
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L31;
        String r7 = r1[r6];
        r13.a.getClass();
        boolean r9 = true;
        if (r13.d(r7) == false) goto L8;
        r2.add(Observable.just(new n0c.a(r7, true, false)));
    L29:
        r6 = r6 + 1;
        goto L3
    L8:
        if (Build.VERSION.SDK_INT < 23) goto L10;
        boolean r8 = true;
    L11:
        if (r8 == false) goto L15;
        RxPermissionsFragment r10 = r13.a;
        if (r10.getActivity().getPackageManager().isPermissionRevokedByPolicy(r7, r10.getActivity().getPackageName()) == false) goto L15;
    L16:
        if (r9 == false) goto L18;
        r2.add(Observable.just(new n0c.a(r7, false, false)));
        goto L29
    L18:
        PublishSubject r11 = (PublishSubject) ((ConcurrentHashMap) r13.a.a).get(r7);
        if (r11 != null) goto L28;
        r3.add(r7);
        r11 = PublishSubject.create();
        RxPermissionsFragment r14 = r13.a;
        Map<String, PublishSubject<n0c.a>> r15 = r14.a;
        monitor-enter(r15);
        PublishSubject r16 = (PublishSubject) ((ConcurrentHashMap) r14.a).put(r7, r11);     // Catch: Throwable -> L25
        monitor-exit(r15);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    L28:
        r2.add(r11);
    L15:
        r9 = false;
        goto L16
    L10:
        r8 = false;
        goto L11
    L31:
        if (r3.isEmpty() == true) goto L41;
        r13.f(r0, (String[]) r3.toArray(new String[r3.size()]));     // Catch: SensitiveAPIException -> L34
    L34:
        e = move-exception;
        int r5 = 0;
    L37:
        if (r5 >= r3.size()) goto L39;
        r2.add(Observable.just(new n0c.a((String) ListProtector.get(r3, r5), false, false)));
        r5 = r5 + 1;
        goto L37
    L39:
        Log.e("RxPermissions", "request permission failed, permissions:" + r3, e);
    L41:
        return Observable.concat(Observable.fromIterable(r2));
    }

    public q(c r1, Token r2, String[] r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}

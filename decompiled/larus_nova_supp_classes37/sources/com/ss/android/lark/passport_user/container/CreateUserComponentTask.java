package com.ss.android.lark.passport_user.container;

import android.content.Context;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.passportc.api.i;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.api.k;
import com.ss.android.lark.passportc.api.l;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserRequest;
import com.ss.android.lark.passportc.internal.r;
import com.ss.android.lark.picker.base.view.ItemViewType;
import f0c.g;
import f0c.h;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00182\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0018BO\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/passport_user/container/CreateUserComponentTask;", "Lcom/larksuite/framework/launch/task/AbstractLaunchTask;", "", "multiOnlineFG", "Ljavax/inject/Provider;", "Lcom/ss/android/lark/passportc/api/IMultiOnlineFG;", "passportStateManager", "Lcom/ss/android/lark/passportc/api/IPassportStateManager;", "passportStateManager2", "Lcom/ss/android/lark/passportc/api/IPassportStateManager2;", "passportGlobalService", "Lcom/ss/android/lark/passportc/api/IPassportGlobalService;", "larkUserListApi", "Lcom/ss/android/lark/passport_user/api/container/ILarkUserListApi;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "execute", "", "context", "Landroid/content/Context;", "isUserComponentCreated", "", "userId", "", "Companion", "lark-user_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class CreateUserComponentTask extends AbstractLaunchTask<Object> {
    public final Provider<i> c;
    public final Provider<l> d;
    public final Provider<k> e;
    public final Provider<j> f;
    public final Provider<yzb.b> g;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public static final b<T> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r3) {
            Log.e("CreateUserComponentTask", "create user component v2 doOnError: " + ((Throwable) r3).getCause() + ' ');
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r2) {
            j0c.d r3 = (j0c.d) r2;
            Log.i("CreateUserComponentTask", "create user component v2 doOnNext");
        }
    }

    public static final class d implements Action {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void run() {
            Log.i("CreateUserComponentTask", "create user component v2 doOnComplete");
        }
    }

    static {
    }

    public final void a(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        long r0 = System.currentTimeMillis();
        if (((yzb.b) this.g.get()).isLogin() == false) goto L52;
        Log.i("CreateUserComponentTask", "isLogin cost = " + (System.currentTimeMillis() - r0) + " ms ");
        User r10 = ((yzb.b) this.g.get()).getForegroundUser();
        boolean r1 = true;
        if (r10 == null) goto L41;
        String r3 = r10.userId;
        Iterator<T> r4 = ((j) this.f.get()).a().iterator();
    L7:
        Object r6 = null;
        if (r4.hasNext() == false) goto L17;
        Object r5 = r4.next();
        g r7 = ((f0c.b) r5).a();
        if (r7 == null) goto L15;
        User r8 = r7.a;
        if (r8 == null) goto L15;
        r6 = r8.userId;
    L15:
        if (Intrinsics.areEqual(r6, r3) == false) goto L7;
        r6 = r5;
    L17:
        f0c.b r11 = (f0c.b) r6;
        if (r11 == null) goto L23;
        h r12 = r11.b;
        if (r12 == null) goto L23;
        UserState r13 = r12.a;
        if (r13 == null) goto L23;
    L25:
        if (r13 != UserState.ONLINE) goto L27;
        boolean r14 = true;
    L28:
        if (r14 == true) goto L41;
    L36:
        th = move-exception;
        Log.e("CreateUserComponentTask", new Throwable("create user component error", th), true);
        if (DevEnvUtil.isDevelopPackage(com.larksuite.framework.utils.b.a) == false) goto L54;
        throw th;
    L54:
        return;
    L31:
        if (((i) this.c.get()).c() == false) goto L33;
        k r15 = (k) this.e.get();     // Catch: Throwable -> L36
        UpdateUserRequest.a r16 = new UpdateUserRequest.a();     // Catch: Throwable -> L36
        UserState r17 = UserState.OFFLINE;     // Catch: Throwable -> L36
        Intrinsics.checkNotNullParameter(r10, "targetUser");     // Catch: Throwable -> L36
        Intrinsics.checkNotNullParameter(r17, "targetState");     // Catch: Throwable -> L36
        r16.a = new com.ss.android.lark.passportc.impl.v2.entity.d(r10, r17, false);     // Catch: Throwable -> L36
        Observable<j0c.d> r18 = r15.c(r16.a(), com.ss.android.lark.passportc.api.d.a(com.ss.android.lark.passportc.api.d.g, Scene.CREATE_USER_COMPONENT), r.a);     // Catch: Throwable -> L36
    L34:
        j0c.d r19 = (j0c.d) r18.doOnError(b.a).doOnNext(c.a).doOnComplete(d.a).blockingFirst();     // Catch: Throwable -> L36
        return;
    L33:
        r18 = ((l) this.d.get()).b(new com.ss.android.lark.passportc.api.a(r10), com.ss.android.lark.passportc.api.d.g, r.a);     // Catch: Throwable -> L36
        goto L34
    L27:
        r14 = false;
    L23:
        r13 = UserState.ABSENT;
    L41:
        StringBuilder r20 = new StringBuilder("create user component v2 skipped, user is null = ");
        if (r10 == null) goto L45;
        r1 = false;
    L45:
        r20.append(r1);
        Log.e("CreateUserComponentTask", r20.toString());
        return;
    }

    @Inject
    public CreateUserComponentTask(Provider<i> r2, Provider<l> r3, Provider<k> r4, Provider<j> r5, Provider<yzb.b> r6) {
        Intrinsics.checkNotNullParameter(r2, "multiOnlineFG");
        Intrinsics.checkNotNullParameter(r3, "passportStateManager");
        Intrinsics.checkNotNullParameter(r4, "passportStateManager2");
        Intrinsics.checkNotNullParameter(r5, "passportGlobalService");
        Intrinsics.checkNotNullParameter(r6, "larkUserListApi");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
    }
}

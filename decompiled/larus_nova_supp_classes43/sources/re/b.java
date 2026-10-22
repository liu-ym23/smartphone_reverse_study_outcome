package re;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler;
import com.bytedance.android.livesdkapi.room.handler.observe.ConfigObserver;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements td.b {
    public final IBaseLiveRoomFunctionHandler a;

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r10) {
            Intrinsics.checkNotNullParameter((IBaseUser) r10, "it");
            return new ge.a();
        }
    }

    /* JADX INFO: renamed from: re.b$b, reason: collision with other inner class name */
    public static final class C0192b implements ConfigObserver<String, String> {
        public final /* synthetic */ ud.a a;

        public final Object getConfig() {
            return (String) this.a.getConfig();
        }

        public C0192b(ud.a r1) {
            this.a = r1;
        }

        public final void onChanged(Object r10) {
            ud.a r0 = this.a;
            r0.onChanged((String) r10);
        }
    }

    @Override // td.b
    public final void a() {
    }

    @Override // td.b
    public final void d() {
    }

    @Override // td.b
    public final void e() {
        this.a.startVBoost(0);
    }

    @Override // td.b
    public final void f() {
    }

    @Override // td.b
    public final void isLinkmic() {
    }

    @Override // td.b
    public final void onPurchasingIntentionAction() {
    }

    public b(IBaseLiveRoomFunctionHandler r10) {
        Intrinsics.checkNotNullParameter(r10, "realHandler");
        this.a = r10;
    }

    @Override // td.b
    public final void b(int r10) {
        this.a.fullDialogHoverStateChange(r10, false);
    }

    @Override // td.b
    public final void c(boolean r10) {
        this.a.onPermissionChange(0, r10);
    }

    @Override // td.b
    public final re.a getLogger(Class r10) {
        Intrinsics.checkNotNullParameter(r10, "loggerClass");
        if (Intrinsics.areEqual(r10, be.b.class) == false) goto L7;
        return new re.a(this);
    L7:
        throw new Exception("unknown logger class");
    }

    @Override // td.b
    public final void h(ud.a<String, String> r10) {
        Intrinsics.checkNotNullParameter(r10, "bitmapObserverEC");
        this.a.takeLiveRoomScreenshot(new C0192b(r10));
    }

    @Override // td.b
    public final Observable<ge.a> g(Context r10, ge.b r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "params");
        IBaseLiveRoomFunctionHandler r0 = this.a;
        l.a r1 = new l.a();
        r1.d = r11.d;
        r1.g = r11.f;
        r1.e = r11.e;
        r1.c = r11.c;
        r1.b = r11.b;
        r1.a = r11.a;
        return r0.loginIn(r10, new l(r1)).map(a.a);
    }

    @Override // td.b
    public final boolean insertLegalMessage(long r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "legalMessageText");
        return this.a.insertLegalMessage(r10, r11);
    }

    @Override // td.b
    public final void jetDanmaku(String r10, long r11, String r12, String r13) {
        IBaseLiveRoomFunctionHandler r0 = this.a;
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        if (r12 != null) goto L7;
        String r14 = "";
    L8:
        if (r13 != null) goto L10;
        String r15 = "";
    L11:
        r0.jetDanmaku(r10, r11, r14, r15);
        return;
    L10:
        r15 = r13;
        goto L11
    L7:
        r14 = r12;
        goto L8
    }

    @Override // td.b
    public final void onCouponMessage(int r10, long r11, String r12, int r13, long r14) {
        this.a.onCouponMessage(r10, r11, r12, r13, r14);
    }
}

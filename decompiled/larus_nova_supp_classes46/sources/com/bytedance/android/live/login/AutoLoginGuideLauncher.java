package com.bytedance.android.live.login;

import am2.x;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.arch.mvvm.d;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.q;
import com.bytedance.android.livesdk.config.f81;
import com.bytedance.android.livesdk.config.z81;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdk.user.h;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bmmt.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.keva.Keva;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010/\u001a\u0004\u0018\u00010.¢\u0006\u0004\b6\u00107J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010$R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010+\u001a\n **\u0004\u0018\u00010)0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b-\u0010\u001eR\u0019\u0010/\u001a\u0004\u0018\u00010.8\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0014\u00105\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u00068"}, d2 = {"Lcom/bytedance/android/live/login/AutoLoginGuideLauncher;", "Lcom/bytedance/live/datacontext/DataContext;", "Lq61/a;", "", "checkAndShowLoginGuide", "showLoginDialog", "Landroid/content/Context;", "context", "Landroidx/fragment/app/FragmentActivity;", "getFragmentActivity", "", "getLoginDesc", "", "interceptByInterval", "", "timestamp", "isTimestampToday", "saveGuideInfo", "startGuideTask", BuildConfig.BUILD_TYPE, "notifyHasJumpedLogin", "Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;", "_hasJumpedLogin", "Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;", "Lcom/bytedance/android/live/core/arch/mvvm/d;", "hasJumpedLogin", "Lcom/bytedance/android/live/core/arch/mvvm/d;", "getHasJumpedLogin", "()Lcom/bytedance/android/live/core/arch/mvvm/d;", "tag", "Ljava/lang/String;", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "", "delayTime", "I", "maxShowCounts", "", "loginDescs", "Ljava/util/List;", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "keva", "Lcom/bytedance/keva/Keva;", "autoLoginGuideKey", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getHasClickJumpLogin", "()Z", "hasClickJumpLogin", "<init>", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AutoLoginGuideLauncher extends DataContext implements q61.a {
    private final PropertyOwner<Boolean> _hasJumpedLogin;
    private final String autoLoginGuideKey;
    private final CompositeDisposable cd;
    private final DataCenter dataCenter;
    private final int delayTime;
    private final d<Boolean> hasJumpedLogin;
    private final Keva keva;
    private final List<String> loginDescs;
    private final int maxShowCounts;
    private final String tag;

    public static final class a implements Action {
        public final /* synthetic */ AutoLoginGuideLauncher a;

        public a(AutoLoginGuideLauncher r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.release();
        }
    }

    private final String getLoginDesc() {
        List<String> r0 = this.loginDescs;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return "登录后，优化你的直播推荐体验";
    L12:
        if (this.loginDescs.size() != 1) goto L15;
        return (String) ListProtector.get(this.loginDescs, 0);
    L15:
        return (String) ListProtector.get(this.loginDescs, new Random().nextInt(this.loginDescs.size()));
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    private final boolean interceptByInterval() {
        List r0 = StringsKt.split$default(this.keva.getString(this.autoLoginGuideKey, ",,"), new String[]{","}, false, 0, 6, null);
        boolean r2 = true;
        boolean r3 = false;
        if (r0.size() != 3) goto L5;
        boolean r1 = true;
    L6:
        ArrayList r5 = null;
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L34;
        ArrayList r4 = new ArrayList();
        Iterator r6 = r0.iterator();
    L13:
        if (r6.hasNext() == false) goto L18;
        Long r7 = StringsKt.toLongOrNull((String) r6.next());
        if (r7 == null) goto L13;
        r4.add(r7);
        goto L13
    L18:
        if (r4.size() != 3) goto L20;
        boolean r8 = true;
    L21:
        if (r8 == false) goto L23;
        r5 = r4;
    L23:
        if (r5 == null) goto L34;
        if (((Number) ListProtector.get(r5, 0)).longValue() < this.maxShowCounts) goto L28;
    L33:
        r3 = r2;
        goto L34
    L28:
        if (isTimestampToday(((Number) ListProtector.get(r5, 1)).longValue()) == true) goto L30;
    L32:
        r2 = false;
        goto L33
    L30:
        if (((Number) ListProtector.get(r5, 2)).longValue() < 1) goto L32;
    L20:
        r8 = false;
    L34:
        ALogger.i(this.tag, "interceptByInterval:" + r3);
        return r3;
    L5:
        r1 = false;
        goto L6
    }

    private final void saveGuideInfo() {
        List r0 = StringsKt.split$default(this.keva.getString(this.autoLoginGuideKey, ",,"), new String[]{","}, false, 0, 6, null);
        if (r0.size() != 3) goto L5;
        boolean r1 = true;
    L6:
        ArrayList r5 = null;
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L32;
        ArrayList r2 = new ArrayList();
        Iterator r3 = r0.iterator();
    L13:
        if (r3.hasNext() == false) goto L18;
        Long r6 = StringsKt.toLongOrNull((String) r3.next());
        if (r6 == null) goto L13;
        r2.add(r6);
        goto L13
    L18:
        if (r2.size() != 3) goto L20;
        boolean r4 = true;
    L21:
        if (r4 == false) goto L23;
        r5 = r2;
    L23:
        if (r5 == null) goto L32;
        List r7 = CollectionsKt.toMutableList(r5);
        if (r7 == null) goto L32;
        ListProtector.set(r7, 0, Long.valueOf(((Number) ListProtector.get(r7, 0)).longValue() + 1));
        if (isTimestampToday(((Number) ListProtector.get(r7, 1)).longValue()) == false) goto L29;
        ListProtector.set(r7, 2, Long.valueOf(((Number) ListProtector.get(r7, 2)).longValue() + 1));
    L30:
        ListProtector.set(r7, 1, Long.valueOf(System.currentTimeMillis()));
        String r8 = CollectionsKt.joinToString$default(r7, ",", null, null, 0, null, null, 62, null);
        ALogger.i(this.tag, r8);
        if (r8 == null) goto L32;
    L33:
        this.keva.storeString(this.autoLoginGuideKey, r8);
        return;
    L29:
        ListProtector.set(r7, 2, 1L);
        goto L30
    L20:
        r4 = false;
    L32:
        r8 = "1," + System.currentTimeMillis() + ",1";
        goto L33
    L5:
        r1 = false;
        goto L6
    }

    public void notifyHasJumpedLogin() {
        this._hasJumpedLogin.onNext(Boolean.TRUE);
    }

    public void release() {
        this.cd.clear();
    }

    public void startGuideTask() {
        ALogger.d(this.tag, "ban login guide task on saas");
    }

    private final void checkAndShowLoginGuide() {
        if (getHasClickJumpLogin() == false) goto L6;
        ALogger.i(this.tag, "don't show login guide dialog by hasClickJumpLogin");
        return;
    L6:
        IUserService r0 = k.f(IUserService.class);
        if (r0 == null) goto L17;
        f r1 = r0.user();
        if (r1 == null) goto L17;
        if (r1.isLogin() == true) goto L17;
        if (interceptByInterval() == true) goto L19;
        showLoginDialog();
        return;
    L19:
        return;
    L17:
        ALogger.i(this.tag, "don't show login guide dialog because cur user has logined");
    }

    private final boolean getHasClickJumpLogin() {
        return ((Boolean) getHasJumpedLogin().getValue()).booleanValue();
    }

    private final void showLoginDialog() {
        FragmentActivity r0 = getFragmentActivity(com.bytedance.android.live.core.utils.a.d());
        if (r0 != null) goto L6;
        ALogger.i(this.tag, "show login fail, activity is null");
        return;
    L6:
        saveGuideInfo();
        Bundle r1 = new Bundle();
        n0 r2 = u.l().c(x.class);
        if (r2 == null) goto L38;
        n0 r3 = r2;
        String r4 = (String) ((com.bytedance.android.livesdk.log.filter.a) r3).b.get("enter_from_merge");
        String r5 = (String) ((com.bytedance.android.livesdk.log.filter.a) r3).b.get("enter_method");
        String r6 = "";
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        String r7 = (String) ((com.bytedance.android.livesdk.log.filter.a) r3).b.get("action_type");
        if (r7 != null) goto L14;
        r7 = "";
    L14:
        Room r9 = null;
        RoomContext r8 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r8 == null) goto L19;
        m r10 = r8.getRoom();
        if (r10 == null) goto L19;
        r9 = (Room) r10.getValue();
    L19:
        Pair[] r11 = new Pair[5];
        r11[0] = TuplesKt.to("enter_method_live", r5);
        r11[1] = TuplesKt.to("action_type_live", r7);
        if (r9 == null) goto L23;
        String r12 = String.valueOf(r9.getRoomId());
        if (r12 == null) goto L23;
    L24:
        r11[2] = TuplesKt.to("room_id_live", r12);
        if (r9 == null) goto L30;
        String r13 = r9.getOwnerUserIdString();
        if (r13 == null) goto L30;
        r6 = r13;
    L30:
        r11[3] = TuplesKt.to("anchor_id_live", r6);
        if (r9 == null) goto L34;
        String r14 = r9.isEcomCart();
        if (r14 == null) goto L34;
    L35:
        r11[4] = TuplesKt.to("is_ecom_live", r14);
        Map r15 = MapsKt.mutableMapOf(r11);
        r1.putString("loginDesc", getLoginDesc());
        r1.putString("track_info", q.a(r15));
        r1.putBoolean("show_half_page", true);
        f r16 = k.n(IUserService.class).user();
        l.a r17 = new l.a();
        r17.e = r4;
        r17.h = r1;
        r16.login(r0, new l(r17)).subscribe(new h());
        return;
    L34:
        r14 = "0";
    L23:
        r12 = "";
        goto L24
    L38:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.log.filter.PageSourceFilter");
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public d<Boolean> getHasJumpedLogin() {
        return this.hasJumpedLogin;
    }

    public AutoLoginGuideLauncher(DataCenter r3) {
        this.dataCenter = r3;
        PropertyOwner<Boolean> r4 = new PropertyOwner(Boolean.FALSE);
        this._hasJumpedLogin = r4;
        this.hasJumpedLogin = r4;
        this.tag = "AutoLoginGuideLauncher";
        CompositeDisposable r5 = new CompositeDisposable();
        this.cd = r5;
        f81 r0 = f81.a;
        this.delayTime = ((z81) r0.getValue()).c();
        this.maxShowCounts = ((z81) r0.getValue()).b();
        this.loginDescs = ((z81) r0.getValue()).d();
        this.keva = Keva.getRepo("AutoLoginGuideSetting");
        this.autoLoginGuideKey = "AutoLoginGuideKey";
        RxUtilKt.c(getOnCleared().subscribe(new a(this)), r5);
        startGuideTask();
    }

    public static final /* synthetic */ void access$checkAndShowLoginGuide(AutoLoginGuideLauncher r0) {
        r0.checkAndShowLoginGuide();
    }

    private final FragmentActivity getFragmentActivity(Context r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if ((r3 instanceof Application) == false) goto L9;
        return null;
    L9:
        if ((r3 instanceof FragmentActivity) == false) goto L13;
        return (FragmentActivity) r3;
    L13:
        if ((r3 instanceof ContextWrapper) == true) goto L15;
        return null;
    L15:
        return getFragmentActivity(((ContextWrapper) r3).getBaseContext());
    }

    private final boolean isTimestampToday(long r4) {
        Calendar r0 = Calendar.getInstance();
        Calendar r1 = Calendar.getInstance();
        r1.setTimeInMillis(r4);
        if (r0.get(1) == r1.get(1)) goto L5;
    L9:
        return false;
    L5:
        if (r0.get(2) != r1.get(2)) goto L9;
        if (r0.get(5) != r1.get(5)) goto L9;
        return true;
    }
}

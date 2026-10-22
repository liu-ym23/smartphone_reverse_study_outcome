package com.bytedance.android.livesdk.followtool;

import android.content.Context;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.g2;
import com.bytedance.android.live.core.utils.z0;
import com.bytedance.android.live.customize.IInternalFollowTool;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.config.p8;
import com.bytedance.android.livesdk.followtool.api.RelationSyncSwitch;
import com.bytedance.android.livesdk.followtool.utils.XTFollowSyncPrefs;
import com.bytedance.android.livesdk.followtool.utils.XTFollowSyncUtils;
import com.bytedance.android.livesdk.followtool.utils.d;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdk.user.m;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import h80.c;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J4\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0016J4\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\bH\u0016J \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u001c\u0010\u0014\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0016J*\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\f2\u0006\u0010\u0019\u001a\u00020\u0016H\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/followtool/XTInternalFollowTool;", "Lcom/bytedance/android/live/customize/IInternalFollowTool;", "Lcom/bytedance/android/livesdk/user/f;", "getUserCenter", "Landroid/content/Context;", "context", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "Lkotlin/Function1;", "", "Lcom/bytedance/android/livesdk/user/b;", "paramBuilder", "Lio/reactivex/Observable;", "Lcom/bytedance/android/livesdkapi/depend/model/follow/FollowPair;", "makeFollowByRoom", "Lcom/bytedance/android/livesdk/user/m;", "makeUnFollowByRoom", "followPair", "", "showToastWithFollowStateSyncCheck", "shouldTreatAsFollowed", "", "", "logExtra", "showFollowSyncDialog", "openUserId", "getUnFollowDialogText", "<init>", "()V", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class XTInternalFollowTool implements IInternalFollowTool {

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r7) {
            c r8 = (c) r7;
            Intrinsics.checkNotNullParameter(r8, "it");
            RelationSyncSwitch r0 = (RelationSyncSwitch) z0.b(r8);
            if (r0 == null) goto L12;
            if (r0.getFollowedSync() != true) goto L12;
            RelationSyncSwitch r9 = (RelationSyncSwitch) z0.b(r8);
            if (r9 == null) goto L12;
            if (r9.getFollowerSync() != true) goto L12;
            return StringsKt.replace$default(((p8) LiveConfigSettingKeys.INTERNAL_FOLLOW_SYNC_CONTENT_CONFIG_SETTING_KEY.getValue()).e(), "{host}", puc.a.getApplicationName(LiveResUtil.getContext()), false, 4, null);
        L12:
            return LiveResUtil.getString(2131919781);
        }
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ XTInternalFollowTool a;
        public final /* synthetic */ Function1 b;

        public b(XTInternalFollowTool r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r3) {
            Boolean r4 = (Boolean) r3;
            Intrinsics.checkNotNullParameter(r4, "allow");
            return XTInternalFollowTool.access$getUserCenter(this.a).h((com.bytedance.android.livesdk.user.b) this.b.invoke(r4));
        }
    }

    private final f getUserCenter() {
        return k.n(IUserService.class).user();
    }

    public XTInternalFollowTool() {
        k.l(IInternalFollowTool.class, this);
    }

    public static final /* synthetic */ f access$getUserCenter(XTInternalFollowTool r0) {
        return r0.getUserCenter();
    }

    public Observable<String> getUnFollowDialogText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "openUserId");
        return XTFollowSyncUtils.a(r2).map(a.a);
    }

    public boolean shouldTreatAsFollowed(Room r1, FollowPair r2) {
        if (r2 != null) goto L4;
    L7:
        return true;
    L4:
        if (r2.followStatus != 0) goto L7;
        return false;
    }

    public Observable<Boolean> showFollowSyncDialog(Context r7, Map<String, String> r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "logExtra");
        Disposable r0 = XTFollowSyncUtils.a;
        StringBuilder r1 = new StringBuilder("canShowAnchorDialog today:");
        XTFollowSyncPrefs r2 = XTFollowSyncPrefs.m;
        r1.append(r2.b());
        r1.append(" total:");
        r1.append(r2.c());
        ALogger.d("XTFollowSyncUtils", r1.toString());
        boolean r3 = true;
        if (XTFollowSyncUtils.c() == false) goto L6;
    L11:
        if (r3 == false) goto L13;
        String r4 = r8.get("scene");
        if (r4 != null) goto L17;
        r4 = "watch";
    L17:
        String r9 = r8.get("auth");
        if (r9 != null) goto L20;
        r9 = "scope";
    L20:
        XTFollowSyncUtils.b(r7, r4, r9);
        return Observable.just(Boolean.TRUE);
    L13:
        return Observable.just(Boolean.FALSE);
    L6:
        if (r2.b() < 1) goto L8;
    L10:
        r3 = false;
        goto L11
    L8:
        if (r2.c() >= 3) goto L10;
        int r5 = r2.b() + 1;
        g2.c r6 = XTFollowSyncPrefs.e;
        KProperty[] r10 = XTFollowSyncPrefs.c;
        r6.c(r10[1], Integer.valueOf(r5));
        int r11 = r2.c() + 1;
        XTFollowSyncPrefs.f.c(r10[2], Integer.valueOf(r11));
        goto L11
    }

    public Observable<FollowPair> makeFollowByRoom(Context r6, Room r7, Function1<? super Boolean, ? extends com.bytedance.android.livesdk.user.b> r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r8, "paramBuilder");
        com.bytedance.android.livesdk.user.b r1 = (com.bytedance.android.livesdk.user.b) r8.invoke(Boolean.FALSE);
        String r2 = null;
        if (r7 == null) goto L7;
        User r3 = r7.getOwner();
        if (r3 == null) goto L7;
        String r4 = r3.getUserId();
    L9:
        if (mz.c.a(r4, ((com.bytedance.android.livesdk.user.a) r1).a) == false) goto L18;
        Disposable r5 = XTFollowSyncUtils.a;
        if (r7 == null) goto L14;
        r2 = r7.getOwnerUserIdString();
    L14:
        if (r2 != null) goto L16;
        r2 = "";
    L16:
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r2, "userOpenId");
        return XTFollowSyncUtils.a(r2).flatMap(new d(r6)).observeOn(AndroidSchedulers.mainThread()).flatMap(new b(this, r8));
    L18:
        return getUserCenter().h(r1);
    L7:
        r4 = null;
        goto L9
    }

    public Observable<FollowPair> makeUnFollowByRoom(Context r1, Room r2, Function1<? super Boolean, ? extends m> r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r3, "paramBuilder");
        m r4 = (m) r3.invoke(Boolean.FALSE);
        return getUserCenter().i(r4);
    }

    public void showToastWithFollowStateSyncCheck(Context r7, Room r8, FollowPair r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "room");
        Intrinsics.checkNotNullParameter(r9, "followPair");
        User r10 = r8.getOwner();
        if (r10 == null) goto L5;
        String r11 = r10.getUserId();
    L7:
        if ((!Intrinsics.areEqual(r11, r9.getUserIdString())) == false) goto L10;
        return;
    L10:
        if (r9.isSyncFollow() == true) goto L12;
        return;
    L12:
        if (shouldTreatAsFollowed(r8, r9) == false) goto L20;
        Disposable r12 = XTFollowSyncUtils.a;
        XTFollowSyncPrefs.m.getClass();
        g2.d r13 = XTFollowSyncPrefs.d;
        KProperty[] r14 = XTFollowSyncPrefs.c;
        if (((Number) r13.b(r14[0])).intValue() >= 3) goto L16;
    L17:
        r13.c(r14[0], Integer.valueOf(((Number) r13.b(r14[0])).intValue() + 1));
        f2.c(StringsKt.replace$default(((p8) LiveConfigSettingKeys.INTERNAL_FOLLOW_SYNC_CONTENT_CONFIG_SETTING_KEY.getValue()).d(), "{host}", puc.a.getApplicationName(LiveResUtil.getContext()), false, 4, null), 0);
        return;
    L16:
        if (XTFollowSyncUtils.c() == true) goto L17;
        return;
    L20:
        return;
    L5:
        r11 = null;
        goto L7
    }
}

package com.bytedance.android.livesdk.followtool.utils;

import android.content.Context;
import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.live.base.model.user.HostInfo;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.customize.IInternalFollowTool;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.followtool.api.UserSetting;
import com.bytedance.android.livesdk.followtool.api.UserSettingApi;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.followtool.utils.a$a, reason: collision with other inner class name */
    public static final class C0351a<T, R> implements Function {
        public final /* synthetic */ Context a;
        public final /* synthetic */ Map b;

        public C0351a(Context r1, Map r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r5) {
            Response r6 = (Response) r5;
            Intrinsics.checkNotNullParameter(r6, "it");
            UserSetting r0 = (UserSetting) ((BaseResponse) r6).data;
            if (((BaseResponse) r6).statusCode != 0) goto L10;
            if (r0 == null) goto L10;
            if (r0.allowFollowSyncToHost != 1) goto L12;
            return Observable.just(Boolean.TRUE);
        L12:
            return k.n(IInternalFollowTool.class).showFollowSyncDialog(this.a, this.b);
        L10:
            return k.n(IInternalFollowTool.class).showFollowSyncDialog(this.a, this.b);
        }
    }

    public static com.bytedance.android.livesdk.user.f d() {
        return k.n(IUserService.class).user();
    }

    public static String c() {
        String r0 = d().b().getNickName();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        StringBuilder r1 = new StringBuilder();
        r1.append(String.valueOf(StringsKt.first(r0)) + "*");
        r1.append(StringsKt.last(r0));
        return r1.toString();
    }

    static {
    }

    public static String b(Room r4) {
        Intrinsics.checkNotNullParameter(r4, "room");
        User r0 = r4.getOwner();
        String r1 = "y";
        if (r0 == null) goto L9;
        FollowInfo r2 = r0.getFollowInfo();
        if (r2 == null) goto L9;
        if (r2.isFollowing() != true) goto L9;
        String r3 = "y";
    L10:
        User r5 = r4.getOwner();
        if (r5 == null) goto L19;
        HostInfo r6 = r5.getHostInfo();
        if (r6 == null) goto L19;
        FollowInfo r7 = r6.get_followInfo();
        if (r7 == null) goto L19;
        if (r7.isFollowing() != true) goto L19;
    L21:
        return "douyin_" + r3 + "_suzhu_" + r1;
    L19:
        r1 = "n";
    L9:
        r3 = "n";
        goto L10
    }

    public static Observable a(Context r2, Map r3) {
        return ((UserSettingApi) com.bytedance.android.live.network.c.b().e(UserSettingApi.class)).getUserSetting("relation_sync_to_host").observeOn(AndroidSchedulers.mainThread()).flatMap(new C0351a(r2, r3));
    }
}

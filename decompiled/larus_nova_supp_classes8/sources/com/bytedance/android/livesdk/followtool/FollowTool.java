package com.bytedance.android.livesdk.followtool;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.followtool.api.UserSetting;
import com.bytedance.android.livesdk.followtool.api.UserSettingApi;
import com.bytedance.android.livesdkapi.customize.IFollowTool;
import com.bytedance.android.livesdkapi.service.ILiveCallback;
import io.reactivex.functions.Consumer;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bH\u0016R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/followtool/FollowTool;", "Lcom/bytedance/android/livesdkapi/customize/IFollowTool;", "()V", "userSettingApi", "Lcom/bytedance/android/livesdk/followtool/api/UserSettingApi;", "kotlin.jvm.PlatformType", "changeUserAllowFollowStateSync", "", "userAllow", "", "callback", "Lcom/bytedance/android/livesdkapi/service/ILiveCallback;", "isUserAllowFollowStateSync", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class FollowTool implements IFollowTool {
    private final UserSettingApi userSettingApi;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ILiveCallback a;

        public a(ILiveCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Response r6 = (Response) r5;
            if (((BaseResponse) r6).statusCode != 0) goto L7;
            ILiveCallback r7 = this.a;
            if (r7 == null) goto L11;
            r7.onSuccess(Boolean.TRUE);
            return;
        L11:
            return;
        L7:
            ILiveCallback r0 = this.a;
            if (r0 == null) goto L13;
            r0.onFailed(new IllegalStateException("error code:" + ((BaseResponse) r6).statusCode + " logId:" + ((BaseResponse) r6).logId));
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ILiveCallback a;

        public b(ILiveCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            ILiveCallback r0 = this.a;
            if (r0 == null) goto L6;
            r0.onFailed(r3);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ILiveCallback a;

        public c(ILiveCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            Response r7 = (Response) r6;
            UserSetting r0 = (UserSetting) ((BaseResponse) r7).data;
            if (((BaseResponse) r7).statusCode != 0) goto L12;
            if (r0 == null) goto L12;
            ILiveCallback r8 = this.a;
            if (r8 != null) goto L8;
            return;
        L8:
            if (r0.allowFollowSyncToHost != 1) goto L10;
            boolean r1 = true;
        L11:
            r8.onSuccess(Boolean.valueOf(r1));
            return;
        L10:
            r1 = false;
        L12:
            ILiveCallback r2 = this.a;
            if (r2 == null) goto L18;
            r2.onFailed(new IllegalStateException("error code:" + ((BaseResponse) r7).statusCode + " logId:" + ((BaseResponse) r7).logId));
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ ILiveCallback a;

        public d(ILiveCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            ILiveCallback r0 = this.a;
            if (r0 == null) goto L6;
            r0.onFailed(r3);
            return;
        }
    }

    public FollowTool() {
        k.l(IFollowTool.class, this);
        this.userSettingApi = (UserSettingApi) com.bytedance.android.live.network.c.b().e(UserSettingApi.class);
    }

    public void isUserAllowFollowStateSync(ILiveCallback<Boolean> r4) {
        this.userSettingApi.getUserSetting("relation_sync_to_host").subscribe(new c(r4), new d(r4));
    }

    public void changeUserAllowFollowStateSync(boolean r4, ILiveCallback<Boolean> r5) {
        UserSetting r0 = new UserSetting();
        if (r4 == false) goto L5;
        long r1 = 1;
    L6:
        r0.allowFollowSyncToHost = r1;
        Map<String, String> r6 = MapsKt.mapOf(TuplesKt.to("relation_sync_to_host", String.valueOf(r1)));
        this.userSettingApi.updateUserSetting(r6).subscribe(new a(r5), new b(r5));
        return;
    L5:
        r1 = 2;
        goto L6
    }
}

package yc2;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.ui.LiveProfileManageDialogV2;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "showProfileManageDialog")
public final class f extends com.bytedance.ies.web.jsbridge2.g<a, Object> {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lyc2/f$a;", BuildConfig.FLAVOR, "Lcom/bytedance/android/live/base/model/user/User;", "user", "Lcom/bytedance/android/live/base/model/user/User;", "a", "()Lcom/bytedance/android/live/base/model/user/User;", "setUser", "(Lcom/bytedance/android/live/base/model/user/User;)V", BuildConfig.FLAVOR, "vertical", "Z", "b", "()Z", "setVertical", "(Z)V", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("user")
        private User user;

        @SerializedName("vertical")
        private boolean vertical;

        public a() {
        }

        public final User a() {
            return this.user;
        }

        public final boolean b() {
            return this.vertical;
        }
    }

    public f() {
    }

    public final Object invoke(Object r17, CallContext r18) {
        a r0 = (a) r17;
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r18, "context");
        Context r1 = r18.getContext();
        int r3 = ita.i.a;
        if (NetworkUtils.isNetworkAvailable(r1) == true) goto L5;
        f2.b(2131916005, 0);
        terminate();
    L5:
        User r7 = r0.a();
        Room r6 = k.n(IRoomService.class).getCurrentRoom();
        IUser r2 = k.n(IUserService.class).user().b();
        Context r5 = r18.getContext();
        o0.a r4 = o0.a;
        String r8 = r2.getIdString();
        if (r7 == null) goto L8;
        String r9 = r7.getIdStr();
    L9:
        r4.getClass();
        LiveProfileManageDialogV2 r10 = new LiveProfileManageDialogV2(r5, r6, r7, o0.a.a(r8, r9), r0.b(), false, null, null, false, null, 992);
        if (DialogLancet.shouldBlockDialogShow(r10) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(r10);
    L15:
        return Unit.INSTANCE;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L13:
        DialogLancet.beforeDialogShow(r10);
        r10.show();
        DialogLancet.afterDialogShow(r10);
        goto L15
    L8:
        r9 = null;
        goto L9
    }
}

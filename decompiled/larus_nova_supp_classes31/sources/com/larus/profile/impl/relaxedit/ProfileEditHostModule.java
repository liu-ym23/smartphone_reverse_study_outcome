package com.larus.profile.impl.relaxedit;

import android.content.Context;
import android.view.View;
import com.larus.account.base.api.IAccountService;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.model.profile.AvatarInfo;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.profile.impl.viewmodel.ProfileEditViewModel;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.jsbridge.LynxModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.WritableMap;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J&\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J:\u0010\u0019\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J\b\u0010\u001c\u001a\u00020\u0012H\u0007J\b\u0010\u001d\u001a\u00020\u0012H\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/larus/profile/impl/relaxedit/ProfileEditHostModule;", "Lcom/lynx/jsbridge/LynxModule;", "context", "Landroid/content/Context;", "param", "", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "controller", "Lcom/larus/profile/impl/relaxedit/ProfileEditHostController;", "getController", "()Lcom/larus/profile/impl/relaxedit/ProfileEditHostController;", "getInitialState", "Lcom/lynx/react/bridge/WritableMap;", "requestClose", "dirty", "", "updateDirtyState", "", "checkUserName", "requestId", "", "userName", "callback", "Lcom/lynx/react/bridge/Callback;", "saveProfile", "nickName", "avatarUrl", "hideKeyboard", "showEnterpriseEditDisabledToast", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ProfileEditHostModule extends LynxModule {
    public static final a Companion = null;
    public static final String MODULE_NAME = "ProfileEditHostModule";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private final f getController() {
        Object r0 = ((LynxModule) this).mParam;
        if ((r0 instanceof f) == true) goto L7;
        return null;
    L7:
        return (f) r0;
    }

    @LynxMethod
    public final WritableMap getInitialState() {
        f r0 = getController();
        if (r0 == null) goto L21;
        r0.c();
        JavaOnlyMap r1 = new JavaOnlyMap();
        Iterator r2 = r1.entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L37;
        Map.Entry r3 = (Map.Entry) r2.next();
        String r4 = (String) r3.getKey();
        Object r5 = r3.getValue();
        if ((r5 instanceof Boolean) == true) goto L9;
        if ((r5 instanceof Integer) == true) goto L12;
        if ((r5 instanceof Double) == true) goto L15;
        if ((r5 instanceof String) == true) goto L18;
        r1.putString(r4, r5.toString());
        goto L6
    L18:
        r1.putString(r4, (String) r5);
        goto L6
    L15:
        r1.putDouble(r4, ((Number) r5).doubleValue());
        goto L6
    L12:
        r1.putInt(r4, ((Number) r5).intValue());
        goto L6
    L9:
        r1.putBoolean(r4, ((Boolean) r5).booleanValue());
        goto L6
    L37:
        return r1;
    L21:
        return new JavaOnlyMap();
    }

    @LynxMethod
    public final void hideKeyboard() {
        f r0 = getController();
        if (r0 == null) goto L8;
        View r1 = r0.a.getView();
        if (r1 == null) goto L9;
        ViewExtKt.g(r1);
        return;
    L9:
        return;
    }

    @LynxMethod
    public final void showEnterpriseEditDisabledToast() {
        f r0 = getController();
        if (r0 == null) goto L6;
        s.a.g(r0.b, 2131905505, false);
        return;
    }

    @LynxMethod
    public final WritableMap requestClose(boolean r2) {
        f r0 = getController();
        if (r0 == null) goto L6;
        return r0.e(r2);
    L6:
        return new JavaOnlyMap();
    }

    @LynxMethod
    public final void updateDirtyState(boolean r2) {
        f r0 = getController();
        if (r0 == null) goto L6;
        r0.o = r2;
        return;
    }

    public ProfileEditHostModule(Context r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    @LynxMethod
    public final void checkUserName(String r5, String r6, Callback r7) {
        f r0 = getController();
        if (r0 == null) goto L12;
        if (r5 != null) goto L6;
        r5 = "";
    L6:
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        Intrinsics.checkNotNullParameter(r5, "requestId");
        Intrinsics.checkNotNullParameter(r6, "userName");
        r0.h = r5;
        r0.i = r6;
        r0.j = r7;
        ProfileEditViewModel r8 = r0.c;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r8 = null;
    L11:
        r8.checkUserName(r6);
        return;
    L12:
        if (r7 == null) goto L21;
        Object[] r1 = new Object[1];
        if (r5 != null) goto L16;
        r5 = "";
    L16:
        if (r6 != null) goto L18;
        r6 = "";
    L18:
        r1[0] = g.c(r5, r6, false, "missing_controller", 16);
        r7.invoke(r1);
        return;
    }

    @LynxMethod
    public final void saveProfile(String r10, String r11, String r12, String r13, Callback r14) {
        f r0 = getController();
        String r3 = "";
        if (r0 == null) goto L39;
        if (r10 != null) goto L6;
        r10 = "";
    L6:
        if (r11 != null) goto L8;
        r11 = "";
    L8:
        if (r12 != null) goto L10;
        r12 = "";
    L10:
        if (r13 != null) goto L12;
        r13 = "";
    L12:
        Intrinsics.checkNotNullParameter(r10, "requestId");
        Intrinsics.checkNotNullParameter(r11, "userName");
        Intrinsics.checkNotNullParameter(r12, "nickName");
        Intrinsics.checkNotNullParameter(r13, "avatarUrl");
        if (ILoginService.a.getAccountInfo().g == false) goto L17;
        String r15 = r0.b.getString(2131905505);
        s.j(s.a, r0.b, r15, null, false, 28);
        if (r14 == null) goto L45;
        r14.invoke(new Object[]{g.a(r10, false, "enterprise_account", r15)});
        return;
    L45:
        return;
    L17:
        r0.k = r10;
        r0.l = r11;
        r0.m = r12;
        r0.n = r14;
        r38.b r16 = r0.e;
        if (r16 != null) goto L20;
        r16 = IAccountService.a.getUserInfo();
        r0.e = r16;
    L20:
        ProfileEditViewModel r17 = r0.c;
        ProfileEditViewModel r2 = null;
        if (r17 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r17 = null;
    L23:
        if (r16 == null) goto L27;
        AvatarInfo r18 = r16.a();
        if (r18 == null) goto L27;
        String r19 = r18.a();
    L28:
        if (r19 != null) goto L31;
        r19 = "";
    L31:
        if (Intrinsics.areEqual(r13, r19) == true) goto L34;
        r3 = r13;
    L34:
        r17.setUploadAvatarUrl(r3);
        ProfileEditViewModel r110 = r0.c;
        if (r110 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L38:
        r2.editUserInfo(r11, r12);
        return;
    L37:
        r2 = r110;
    L27:
        r19 = null;
        goto L28
    L39:
        if (r14 == null) goto L48;
        Object[] r111 = new Object[1];
        if (r10 != null) goto L43;
        r10 = "";
    L43:
        r111[0] = g.a(r10, false, "missing_controller", "");
        r14.invoke(r111);
        return;
    }
}

package com.larksuite.component.card.plugin;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.annotation.LKPluginFunction;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007¨\u0006\u000f"}, d2 = {"Lcom/larksuite/component/card/plugin/ShowProfilePlugin;", "Lcom/larksuite/component/card/plugin/OPPlugin;", "<init>", "()V", "showProfile", "", "lkEvent", "Lcom/larksuite/framework/apiplugin/LKEvent;", "request", "Lcom/larksuite/component/card/plugin/ShowProfilePlugin$ShowProfileRequest;", "invokeCallback", "Lcom/larksuite/framework/apiplugin/api/LKEventInvokeCallback;", "Lcom/larksuite/framework/apiplugin/common/LKBaseResponseModel;", "Companion", "ShowProfileRequest", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ShowProfilePlugin extends OPPlugin {
    public static final a Companion = null;
    public static final String TAG = "ShowProfilePlugin";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/larksuite/component/card/plugin/ShowProfilePlugin$ShowProfileRequest;", "Lcom/larksuite/framework/apiplugin/common/LKBaseRequestModel;", "<init>", "()V", "userID", "", "getUserID", "()Ljava/lang/String;", "setUserID", "(Ljava/lang/String;)V", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ShowProfileRequest extends LKBaseRequestModel {

        @JSONField(name = "userID")
        private String userID;

        public ShowProfileRequest() {
        }

        public final String getUserID() {
            return this.userID;
        }

        public final void setUserID(String r1) {
            this.userID = r1;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ShowProfilePlugin() {
    }

    @LKPluginFunction(async = true, eventName = {"universalCardShowProfile"})
    public final void showProfile(LKEvent r3, ShowProfileRequest r4, j18.f<LKBaseResponseModel> r5) {
        Intrinsics.checkNotNullParameter(r3, "lkEvent");
        Intrinsics.checkNotNullParameter(r4, "request");
        Intrinsics.checkNotNullParameter(r5, "invokeCallback");
        String r0 = r4.getUserID();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        UDToast.show(r3.getContext(), 2131890317);
        r5.callback(new LKBaseResponseModel());
        return;
    L12:
        r5.callback(new LKBaseResponseModel());
        Object r6 = r3.h;
        com.larksuite.component.card.cardcontainer.c r2 = null;
        if ((r6 instanceof ILynxBridgeContext) == false) goto L23;
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext");
        ILynxContainerContext r7 = ((ILynxBridgeContext) r6).getContainerContext();
        if (r7 == null) goto L19;
        Map r8 = r7.getBizExtra();
        if (r8 == null) goto L19;
        Object r9 = r8.get("card_share_data");
    L21:
        if ((r9 instanceof com.larksuite.component.card.cardcontainer.c) == false) goto L23;
        r2 = (com.larksuite.component.card.cardcontainer.c) r9;
    L19:
        r9 = null;
    L23:
        if (r2 != null) goto L25;
        return;
    L25:
        if (TextUtils.isEmpty(r4.getUserID()) == true) goto L31;
        String r10 = r4.getUserID();
        if (r10 == null) goto L32;
        r2.c.getDependency().openProfilePage(r3.getContext(), r10, "");
        return;
    L32:
        return;
    L31:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}

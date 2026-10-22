package com.ss.android.lark.flow.bottomsheet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.bottomsheet.BottomSheetContainerActivity;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.flow.replyinthread.FlowReplyInThreadActivity;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.LarkContext;
import java.util.LinkedHashSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class BottomSheetLauncher {
    public static final Lazy a = null;

    public static final class a {
        public Context a;
        public Bundle b;
        public String c;
        public UserSession d;

        public final void a() {
            Activity r0 = AppLifecycle.a.a.f();
            Unit r1 = null;
            if (r0 != null) goto L5;
        L17:
            Intent r2 = new Intent(this.a, BottomSheetContainerActivity.class);
            r2.putExtra("key_bottom_sheet_container_start", true);
            r2.putExtra("key_bottom_sheet_content_class", this.c);
            UserSession r3 = this.d;
            if (r3 == null) goto L23;
            Bundle r4 = this.b;
            if (r4 == null) goto L22;
            PassportcConvention.h(r4, r3);
            r1 = Unit.INSTANCE;
        L22:
            if (r1 == null) goto L23;
        L26:
            r2.putExtra("key_content_biz_bundle", this.b);
            if ((this.a instanceof Activity) == true) goto L29;
            r2.addFlags(268435456);
        L29:
            this.a.startActivity(r2);
            return;
        L23:
            Bundle r5 = this.b;
            if (r5 == null) goto L26;
            PassportcConvention.f(r5, LarkContext.getApplication());
            Unit r6 = Unit.INSTANCE;
            goto L26
        L5:
            if (Intrinsics.areEqual(r0, this.a) == true) goto L17;
            boolean r7 = false;
            if (StringsKt.contains$default(r0.getClass().getSimpleName(), "ByteRTCMeetingActivity", false, 2, null) != true) goto L9;
            r7 = true;
        L9:
            if (r7 == true) goto L13;
            if (ChatCoreModule.a().getVcDependency().a(r0.getTaskId()) == false) goto L17;
        L13:
            if (r0.isDestroyed() == true) goto L17;
            if (r0.isFinishing() == true) goto L17;
            this.a = r0;
            goto L17
        }

        public final Context getContext() {
            return this.a;
        }

        public a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.a = r2;
            this.c = "";
        }
    }

    static {
        a = LazyKt.lazy(BottomSheetLauncher$useForseti$2.INSTANCE);
        new LinkedHashSet();
    }

    public static boolean a(Context r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "params");
        if (r3.getBoolean("key_bottom_sheet_container_start") == true) goto L6;
    L7:
        return false;
    L6:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("messenger.inapppush.reply") == false) goto L7;
        a r0 = new a(r2);
        Intrinsics.checkNotNullParameter(FlowReplyInThreadActivity.class, "targetClazz");
        r0.c = FlowReplyInThreadActivity.class.getName();
        r0.d = null;
        r0.b = r3;
        r0.a();
        return true;
    }
}

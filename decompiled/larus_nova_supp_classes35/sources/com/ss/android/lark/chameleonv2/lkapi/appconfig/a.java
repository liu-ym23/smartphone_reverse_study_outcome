package com.ss.android.lark.chameleonv2.lkapi.appconfig;

import android.app.Application;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.settings.v1.GetSettingsRequest;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.LKAPIError;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import e0c.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends z0b.a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.chameleonv2.lkapi.appconfig.a$a, reason: collision with other inner class name */
    public static final class C0023a {
    }

    public final class b extends AbsChameleonHandler<IAppConfig$Internal$GetKeysOptions> {
        public final String a;
        public final /* synthetic */ a b;

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        public b(a r1) {
            this.b = r1;
            this.a = LKAPIModules.Internal.AppConfig.GetKeys.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(IAppConfig$Internal$GetKeysOptions r7, final Callback r8) {
            IAppConfig$Internal$GetKeysOptions r9 = r7;
            Intrinsics.checkNotNullParameter(r9, "req");
            Intrinsics.checkNotNullParameter(r8, "callback");
            Application r0 = LarkContext.getApplication();
            if (r0 == null) goto L9;
            q1b.a r1 = (q1b.a) k.a(r0, q1b.a.class);
            if (r1 == null) goto L9;
            m r2 = r1.r9();
            if (r2 == null) goto L9;
            User r3 = r2.getUser();
        L11:
            if (r3 != null) goto L13;
            r8.error(new LKAPIError(-1, "userComponent is null"));
            return;
        L13:
            final String r4 = r3.userId;
            if (Intrinsics.areEqual(r4, r9.getUserId()) == true) goto L16;
            r8.error(new LKAPIError(-1, "invalid userId"));
            return;
        L16:
            final HashMap r5 = new HashMap();
            ArrayList r6 = new ArrayList();
            Iterator<String> r10 = r9.getKeys().iterator();
        L18:
            if (r10.hasNext() == false) goto L26;
            String r11 = r10.next();
            String r12 = SettingManager.getInstance().getSettingConfig(r11, true);
            if (r12 != null) goto L22;
            r6.add(r11);
        L22:
            if (r12 != null) goto L24;
            r12 = BuildConfig.FLAVOR;
        L24:
            r5.put(r11, r12);
            goto L18
        L26:
            if (r6.isEmpty() == false) goto L28;
            r8.success(new IAppConfig$Internal$GetKeysResults(r5, r4));
            return;
        L28:
            a r13 = this.b;
            final Function1<HashMap<String, String>, Unit> r14 = new AppConfig$GetKeys$handle$1(r8, r4);
            int r15 = a.a;
            r13.getClass();
            SdkSender.asynSendRequestNonWrap(Command.GET_SETTINGS, new GetSettingsRequest.Builder().fields(r6), new AppConfig$getSettingFromRust$1(r14, r5), com.ss.android.lark.chameleonv2.lkapi.appconfig.b.a);
            return;
        L9:
            r3 = null;
            goto L11
        }
    }

    static {
    }

    @Override // z0b.a
    public final List<AbsChameleonHandler<?>> c() {
        return CollectionsKt.arrayListOf(new b[]{new b(this)});
    }

    public a() {
    }
}

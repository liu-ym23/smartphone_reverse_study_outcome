package i1b;

import android.app.Application;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.LKAPIError;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.chameleonv2.lkapi.passport.IPassport$CurrentUserInfo;
import com.ss.android.lark.chameleonv2.lkapi.passport.IPassport$TenantInfo;
import com.ss.android.lark.chameleonv2.lkapi.passport.IPassport$UserInfo;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.passport.signinsdk_api.account.I18Name;
import com.ss.android.lark.passport.signinsdk_api.account.Tenant;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import e0c.k;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends z0b.a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: i1b.a$a, reason: collision with other inner class name */
    public static final class C0234a {
    }

    public final class b extends AbsChameleonHandler<Unit> {
        public final String a;

        public b() {
            this.a = LKAPIModules.Passport.GetCurrentUserInfo.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(Callback r24) {
            Intrinsics.checkNotNullParameter(r24, "callback");
            Application r1 = LarkContext.getApplication();
            if (r1 == null) goto L9;
            q1b.a r2 = (q1b.a) k.a(r1, q1b.a.class);
            if (r2 == null) goto L9;
            m r3 = r2.r9();
            if (r3 == null) goto L9;
            User r4 = r3.getUser();
        L10:
            if (r4 != null) goto L13;
            r24.error(new LKAPIError(-1, "userComponent is null"));
            return;
        L13:
            HashMap r5 = new HashMap();
            Tenant r6 = r4.tenant;
            if (r6 == null) goto L19;
            I18Name r7 = r6.i18Name;
            if (r7 == null) goto L19;
            String r8 = r7.enUs;
            if (r8 == null) goto L19;
        L20:
            r5.put("en-US", r8);
            Tenant r9 = r4.tenant;
            if (r9 == null) goto L26;
            I18Name r10 = r9.i18Name;
            if (r10 == null) goto L26;
            String r11 = r10.zhCn;
            if (r11 == null) goto L26;
        L27:
            r5.put("zh-CN", r11);
            Tenant r12 = r4.tenant;
            if (r12 == null) goto L33;
            I18Name r13 = r12.i18Name;
            if (r13 == null) goto L33;
            String r14 = r13.jaJp;
            if (r14 == null) goto L33;
        L34:
            r5.put("ja-JP", r14);
            String r15 = r4.getTenantId();
            Tenant r16 = r4.tenant;
            if (r16 == null) goto L40;
            String r17 = r16.name;
            if (r17 == null) goto L40;
            String r18 = r17;
        L41:
            String r19 = r4.getTenantBrand();
            Tenant r20 = r4.tenant;
            if (r20 == null) goto L47;
            String r21 = r20.getTenantGeo();
            if (r21 == null) goto L47;
            String r22 = r21;
        L48:
            Tenant r23 = r4.tenant;
            if (r23 == null) goto L54;
            String r25 = r23.iconUrl;
            if (r25 == null) goto L54;
            String r110 = r25;
        L55:
            IPassport$TenantInfo r26 = new IPassport$TenantInfo(r5, r15, r18, r19, r22, r110);
            HashMap r27 = new HashMap();
            r27.put("en-US", r4.i18Name.enUs);
            r27.put("zh-CN", r4.i18Name.zhCn);
            r27.put("ja-JP", r4.i18Name.jaJp);
            IPassport$UserInfo r28 = new IPassport$UserInfo(r4.avatarKey, r4.avatarUrl, r4.userGeo, r27, r4.userId, r4.name, r26, r4.userUnit);
            j.a("LK_API_TAG_Passport", "get unit=" + r4.userUnit);
            r24.success(new IPassport$CurrentUserInfo(r28));
            return;
        L54:
            r110 = BuildConfig.FLAVOR;
        L47:
            r22 = BuildConfig.FLAVOR;
        L40:
            r18 = BuildConfig.FLAVOR;
        L33:
            r14 = BuildConfig.FLAVOR;
        L26:
            r11 = BuildConfig.FLAVOR;
        L19:
            r8 = BuildConfig.FLAVOR;
        L9:
            r4 = null;
            goto L10
        }
    }

    static {
    }

    @Override // z0b.a
    public final List<AbsChameleonHandler<?>> c() {
        return CollectionsKt.arrayListOf(new b[]{new b()});
    }

    public a() {
    }
}

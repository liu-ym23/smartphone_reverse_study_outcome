package a0c;

import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.signinsdk_api.account.Tenant;
import com.ss.android.lark.passport.signinsdk_api.account.TenantInfo;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$UNIT;
import com.ss.android.lark.passport.signinsdk_api.env.EnvironmentType;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@UserScope
public final class b implements yzb.a {
    public final String a;
    public final yzb.b b;
    public final kzb.b c;
    public final izb.a d;

    public static final class a {
    }

    static {
    }

    @Override // yzb.a
    public final kzb.a a() {
        User r0 = this.b.a(this.a);
        if (r0 != null) goto L5;
        r0 = new User();
        r0.userId = "absent_user";
    L5:
        String r1 = r0.userUnit;
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        String r3 = "";
        if (r2 == false) goto L23;
        String r4 = Reflection.getOrCreateKotlinClass(b.class).getSimpleName();
        if (r4 != null) goto L17;
        r4 = "";
    L17:
        String r5 = r0.userId;
        if (r5 == null) goto L21;
        r3 = r5;
    L21:
        PassportLog.b(r4, r3.concat(" hasn't unit (unit is null or blank)."));
        return this.c.a();
    L23:
        EnvironmentType r6 = this.c.a().getType();
        Tenant r7 = r0.tenant;
        if (r7 == null) goto L27;
        String r8 = r7.getTenantBrand();
        if (r8 == null) goto L27;
    L56:
        String r9 = r0.userGeo;
        if (r9 != null) goto L60;
        r9 = this.d.b(r1);
    L60:
        return new kzb.a(r8, r1, r9, r6);
    L27:
        String r10 = Reflection.getOrCreateKotlinClass(b.class).getSimpleName();
        if (r10 == null) goto L32;
        r3 = r10;
    L32:
        switch(r1.hashCode()) {
            case 93912099: goto L51;
            case 93912675: goto L47;
            case 96855691: goto L44;
            case 96855972: goto L41;
            case 878174793: goto L38;
            case 886218363: goto L35;
            default: goto L55;
        };
    L55:
        PassportLog.b(r3, "Can't convertUnitToBrand, Unknown unit " + r1 + '.');
        r8 = r1;
        goto L56
    L35:
        if (r1.equals("larksgaws") == false) goto L55;
    L49:
        String r11 = "lark";
    L54:
        r8 = r11;
        goto L56
    L38:
        if (r1.equals("larkjpaws") == true) goto L49;
    L41:
        if (r1.equals("eu_nc") == false) goto L55;
    L53:
        r11 = "feishu";
        goto L54
    L44:
        if (r1.equals("eu_ea") == true) goto L49;
    L47:
        if (r1.equals(EnvConst$UNIT.BOE_VA) == true) goto L49;
    L51:
        if (r1.equals(EnvConst$UNIT.BOE_CN) == true) goto L53;
    L8:
        if (StringsKt.isBlank(r1) == true) goto L11;
        r2 = false;
        goto L12
    }

    @Override // yzb.a
    public final TenantInfo getTenantInfo() {
        yzb.b r0 = this.b;
        User r1 = r0.a(this.a);
        if (r1 != null) goto L6;
        r1 = new User();
        r1.userId = "absent_user";
    L6:
        return r0.b(r1);
    }

    @Inject
    public b(String r2, yzb.b r3, kzb.b r4, izb.a r5) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        Intrinsics.checkNotNullParameter(r3, "larkUserListService");
        Intrinsics.checkNotNullParameter(r4, "globalEnvironmentService");
        Intrinsics.checkNotNullParameter(r5, "environmentDependency");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}

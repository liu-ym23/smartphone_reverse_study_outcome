package wt8;

import android.view.View;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.bmhome.view.title.ChatTitleTwoTabAdapt;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.kmp.chat.TemplateInfo;
import com.larus.platform.model.creation.DoSameQuickMenuType;
import com.larus.profile.api.bean.UserCreationModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a0 implements zp9.m {
    public final /* synthetic */ ChatTitleTwoTabAdapt a;

    public final boolean e() {
        return false;
    }

    public final boolean g() {
        return false;
    }

    public a0(ChatTitleTwoTabAdapt r1) {
        this.a = r1;
    }

    public final boolean b(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
        return false;
    }

    public final void c(TabItemInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "tabItemInfo");
    }

    public final void d(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
    }

    public final void i(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
    }

    public final void f(UserCreationModel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "userCreationModel");
    }

    public final void h(UserCreationModel r1, l0 r2, View r3) {
        zp9.m.a.b(r1, r2);
    }

    public final boolean a(UserCreation r21, int r22, String r23, String r24, @DoSameQuickMenuType String r25) {
        Intrinsics.checkNotNullParameter(r21, "userCreation");
        Function3<TemplateInfo.TemplateInfo, Integer, String, Unit> r14 = this.a.l;
        if (r14 == null) goto L23;
        String r0 = r21.a;
        if (r0 == null) goto L9;
        Long r1 = StringsKt.toLongOrNull(r0);
        if (r1 == null) goto L9;
        long r2 = r1.longValue();
    L10:
        long r3 = r2;
        UserCreationContent r4 = r21.e;
        if (r4 == null) goto L15;
        UserCreationImage r5 = r4.a;
        if (r5 == null) goto L15;
        String r6 = r5.c;
    L16:
        TemplateInfo.TemplateInfo r11 = new TemplateInfo.TemplateInfo(r3, r6, null, null, null, 0, 0, 0, r21, 506);
        Integer r7 = Integer.valueOf(r22);
        if (r23 != null) goto L19;
        String r8 = "";
    L20:
        r14.invoke(r11, r7, r8);
        return true;
    L19:
        r8 = r23;
    L15:
        r6 = null;
    L9:
        r2 = 0;
        goto L10
    L23:
        return true;
    }
}

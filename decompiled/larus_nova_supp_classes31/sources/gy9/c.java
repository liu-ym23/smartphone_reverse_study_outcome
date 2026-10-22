package gy9;

import android.view.View;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.api.creation.UserCreationUserAvatar;
import com.larus.platform.model.creation.DoSameQuickMenuType;
import com.larus.profile.api.bean.UserCreationModel;
import com.larus.uaigc.avatar.template.DigitalAvatarTemplateListDialogFragment;
import com.larus.uaigc.template.p;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tx9.u3;
import zp9.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c implements m {
    public final /* synthetic */ DigitalAvatarTemplateListDialogFragment a;

    @Override // zp9.m
    public final boolean e() {
        return true;
    }

    @Override // zp9.m
    public final boolean g() {
        return false;
    }

    public c(DigitalAvatarTemplateListDialogFragment r1) {
        this.a = r1;
    }

    @Override // zp9.m
    public final boolean b(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
        return false;
    }

    @Override // zp9.m
    public final void c(TabItemInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "tabItemInfo");
    }

    @Override // zp9.m
    public final void d(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
    }

    @Override // zp9.m
    public final void i(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
    }

    @Override // zp9.m
    public final void f(UserCreationModel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "userCreationModel");
    }

    @Override // zp9.m
    public final void h(UserCreationModel r1, l0 r2, View r3) {
        m.a.b(r1, r2);
    }

    @Override // zp9.m
    public final boolean a(UserCreation r52, int r53, String r54, String r55, @DoSameQuickMenuType String r56) {
        Intrinsics.checkNotNullParameter(r52, "userCreation");
        Function1<? super ab8.a, Unit> r10 = this.a.d;
        long r11 = 0;
        Integer r13 = null;
        if (r10 == null) goto L46;
        String r2 = r52.a;
        if (r2 == null) goto L9;
        Long r3 = StringsKt.toLongOrNull(r2);
        if (r3 == null) goto L9;
        long r4 = r3.longValue();
    L10:
        UserCreationContent r5 = r52.e;
        if (r5 == null) goto L15;
        UserCreationUserAvatar r6 = r5.c;
        if (r6 == null) goto L15;
        String r7 = r6.c;
    L16:
        if (r5 == null) goto L24;
        UserCreationUserAvatar r8 = r5.c;
        if (r8 == null) goto L24;
        ImageInfo r9 = r8.a;
        if (r9 == null) goto L24;
        Image r12 = r9.b;
        if (r12 == null) goto L24;
        g1 r14 = d.a(r12);
    L25:
        UserCreationContent r15 = r52.e;
        if (r15 == null) goto L34;
        UserCreationUserAvatar r16 = r15.c;
        if (r16 == null) goto L34;
        ImageInfo r17 = r16.a;
        if (r17 == null) goto L34;
        Image r18 = r17.a;
        if (r18 == null) goto L34;
        g1 r19 = d.a(r18);
    L35:
        UserCreationContent r20 = r52.e;
        if (r20 == null) goto L44;
        UserCreationUserAvatar r21 = r20.c;
        if (r21 == null) goto L44;
        ImageInfo r22 = r21.a;
        if (r22 == null) goto L44;
        Image r23 = r22.c;
        if (r23 == null) goto L44;
        g1 r24 = d.a(r23);
    L45:
        r10.invoke(new ab8.a(r4, r7, r14, r19, r24, r52));
    L44:
        r24 = null;
    L34:
        r19 = null;
    L24:
        r14 = null;
    L15:
        r7 = null;
    L9:
        r4 = 0;
    L46:
        String r25 = this.a.e;
        if (r25 != null) goto L49;
        String r110 = "";
    L51:
        if (r54 != null) goto L53;
        String r111 = null;
    L61:
        String r112 = String.valueOf(r52.a);
        String r26 = this.a.f;
        if (r26 != null) goto L64;
        String r113 = "";
    L65:
        String r114 = zp9.d.c(r52);
        AuthorInfo r27 = r52.g;
        if (r27 == null) goto L68;
        String r28 = r27.b;
    L69:
        String r29 = zp9.d.b(r52);
        int r30 = r53 + 1;
        UserCreationTrackParams r31 = r52.n;
        if (r31 == null) goto L72;
        Integer r210 = r31.b;
    L73:
        if (r31 == null) goto L75;
        String r211 = r31.a;
    L76:
        if (r31 == null) goto L78;
        String r212 = r31.d;
    L79:
        if (r31 == null) goto L81;
        String r213 = r31.e;
    L82:
        if (r31 == null) goto L84;
        String r214 = r31.f;
    L85:
        String r32 = r52.i;
        String r35 = zp9.d.c(r52);
        boolean r33 = r52.z();
        boolean r34 = r52.D();
        UserCreationRefContent r36 = r52.o;
        if (r36 == null) goto L90;
        List<ImageInfo> r37 = r36.a();
        if (r37 == null) goto L90;
        r13 = Integer.valueOf(r37.size());
    L90:
        u3.l(r110, r112, r111, r113, "replica", r114, r29, r28, Integer.valueOf(r30), r210, r211, 11, r212, r214, r213, "action_bar_template", null, null, null, null, r32, r35, Boolean.valueOf(r34), r13, Boolean.valueOf(r33), null, null, null, null, null, null, null, null, null, null, -130285184, 31);
        String r0 = r52.a;
        if (r0 == null) goto L95;
        Long r1 = StringsKt.toLongOrNull(r0);
        if (r1 == null) goto L95;
        r11 = r1.longValue();
    L95:
        p.a(r11);
        this.a.dismiss();     // Catch: Exception -> L98
    L102:
        return true;
    L98:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r38 = DialogFragmentLancet.sLastShowStack;
        if (r38 == null) goto L102;
        com.bytedance.crash.d.d(r38, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L102
    L84:
        r214 = null;
        goto L85
    L81:
        r213 = null;
        goto L82
    L78:
        r212 = null;
        goto L79
    L75:
        r211 = null;
        goto L76
    L72:
        r210 = null;
        goto L73
    L68:
        r28 = null;
        goto L69
    L64:
        r113 = r26;
        goto L65
    L53:
        if (r54.length() != 0) goto L55;
        boolean r39 = true;
    L56:
        if (r39 == false) goto L58;
        String r40 = "template_list";
    L59:
        r111 = r40;
        goto L61
    L58:
        r40 = r54;
        goto L59
    L55:
        r39 = false;
        goto L56
    L49:
        r110 = r25;
        goto L51
    }
}

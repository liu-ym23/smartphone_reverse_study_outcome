package opc;

import android.content.Context;
import android.text.format.Formatter;
import com.ss.android.lark.forwardv3.ExternalForwardSendMode;
import com.ss.android.lark.forwardv3.configuration.BasicDialogContentConfig;
import com.ss.android.lark.forwardv3.configuration.Forward$Source;
import com.ss.android.lark.forwardv3.configuration.ForwardAdditionNoteConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardCommonConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardConfirmDialogConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardSelectConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTargetConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$Tenant;
import com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem;
import com.ss.android.lark.forwardv3.configuration.targetconfig.GroupConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.IncludeConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.ThreadConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig;
import com.ss.android.lark.utils.a0;
import com.suite.lark.platform.feature.forward.doubao.file.DoubaoFileForwardContent;
import com.suite.lark.platform.feature.forward.doubao.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Context r21, npc.a r22) {
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r22, "request");
        if (r22.a() == true) goto L5;
        return false;
    L5:
        ForwardTemplateNew.a r2 = new ForwardTemplateNew.a();
        r2.g = 10;
        Forward$Source r4 = Forward$Source.DOUBAO;
        Intrinsics.checkNotNullParameter(r4, "source");
        r2.h = r4;
        r2.f = new DoubaoFileForwardContent(r22);
        ForwardCommonConfig.a r5 = new ForwardCommonConfig.a();
        r5.b = false;
        ForwardCommonConfig r6 = r5.a();
        Intrinsics.checkNotNullParameter(r6, "forwardCommonConfig");
        r2.c = r6;
        ForwardTargetConfig.a r7 = new ForwardTargetConfig.a();
        IncludeConfig.a r8 = new IncludeConfig.a();
        EntityItem.a r9 = new EntityItem.a();
        UserConfig.a r10 = new UserConfig.a();
        Condition$Tenant r11 = Condition$Tenant.NOT_CROSS_TENANT;
        r10.b(r11);
        r9.f(r10.a());
        r8.a(r9.c());
        EntityItem.a r12 = new EntityItem.a();
        GroupConfig.a r13 = new GroupConfig.a();
        r13.b(r11);
        r12.d(r13.a());
        r8.a(r12.c());
        EntityItem.a r14 = new EntityItem.a();
        ThreadConfig.a r15 = new ThreadConfig.a();
        Intrinsics.checkNotNullParameter(r11, "tenant");
        r15.a = r11;
        r14.e(r15.a());
        r8.a(r14.c());
        IncludeConfig r16 = r8.b();
        Intrinsics.checkNotNullParameter(r16, "includeConfig");
        r7.d = r16;
        r7.a = true;
        ForwardTargetConfig r17 = r7.a();
        Intrinsics.checkNotNullParameter(r17, "forwardTargetConfig");
        r2.a = r17;
        ForwardSelectConfig.a r18 = new ForwardSelectConfig.a();
        r18.b = false;
        r18.a = false;
        ForwardSelectConfig r19 = r18.a();
        Intrinsics.checkNotNullParameter(r19, "forwardSelectConfig");
        r2.b = r19;
        ForwardAdditionNoteConfig.a r20 = new ForwardAdditionNoteConfig.a();
        r20.a = true;
        r20.b = false;
        ForwardAdditionNoteConfig r23 = r20.a();
        Intrinsics.checkNotNullParameter(r23, "forwardAdditionNoteConfig");
        r2.d = r23;
        ForwardConfirmDialogConfig.a r24 = new ForwardConfirmDialogConfig.a();
        BasicDialogContentConfig.a r25 = new BasicDialogContentConfig.a();
        String r26 = r22.b;
        Intrinsics.checkNotNullParameter(r26, "title");
        r25.b = r26;
        String r27 = "";
        String r28 = StringsKt.substringAfterLast(r22.b, '.', "").toUpperCase(Locale.ROOT);
        Long r29 = Long.valueOf(r22.d);
        if (r29.longValue() <= 0) goto L8;
        boolean r110 = true;
    L10:
        if (r110 == true) goto L13;
        r29 = null;
    L13:
        if (r29 == null) goto L15;
        String r30 = Formatter.formatFileSize(r21, r29.longValue());
    L16:
        if (r30 == null) goto L19;
        r27 = r30;
    L19:
        List r31 = CollectionsKt.listOf(new String[]{r28, r27});
        ArrayList r111 = new ArrayList();
        Iterator r32 = r31.iterator();
    L21:
        if (r32.hasNext() == false) goto L25;
        Object r33 = r32.next();
        if ((!StringsKt.isBlank((String) r33)) == false) goto L21;
        r111.add(r33);
        goto L21
    L25:
        String r34 = CollectionsKt.joinToString$default(r111, "  ", null, null, 0, null, null, 62, null);
        Intrinsics.checkNotNullParameter(r34, "description");
        r25.d = r34;
        r25.f = a0.b(r22.e, r22.b, 1);
        r25.g = null;
        r25.h = null;
        r25.i = null;
        r24.d = r25.a();
        ForwardConfirmDialogConfig r1 = r24.a();
        Intrinsics.checkNotNullParameter(r1, "forwardConfirmDialogConfig");
        r2.e = r1;
        ForwardTemplateNew r3 = r2.a();
        int r35 = u.a;
        u.a(r21, r3, 0, ExternalForwardSendMode.MIXED_EXTERNAL_TARGET, 4);
        return true;
    L15:
        r30 = null;
        goto L16
    L8:
        r110 = false;
        goto L10
    }
}

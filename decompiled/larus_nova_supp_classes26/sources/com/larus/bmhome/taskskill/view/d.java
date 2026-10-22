package com.larus.bmhome.taskskill.view;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import androidx.appcompat.content.res.AppCompatResources;
import com.larus.bmhome.taskskill.l2;
import com.larus.bmhome.taskskill.m2;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dispatcher.api.AllDeviceResponse;
import com.larus.platform.service.o2;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public static final p b(b r17, CharSequence r18) {
        Intrinsics.checkNotNullParameter(r17, "<this>");
        Intrinsics.checkNotNullParameter(r18, "deviceName");
        if (Intrinsics.areEqual(r17, b.e.a) == false) goto L6;
        return new p(r18, AppHost.a.getApplication().getString(o2.a.b(2131901698)), null, null, !Intrinsics.areEqual(qa9.a.a().a(), "1"), false, 92);
    L6:
        if (Intrinsics.areEqual(r17, b.f.a) == false) goto L9;
        AppHost.Companion r1 = AppHost.a;
        return new p(r18, r1.getApplication().getString(2131902456), r1.getApplication().getString(2131901713), PcConnectionStatusAction.RequestAuthorizedPermission, false, false, 112);
    L9:
        if (Intrinsics.areEqual(r17, b.g.a) == false) goto L12;
        return new p(r18, AppHost.a.getApplication().getString(2131901734), null, null, false, false, 124);
    L12:
        if (Intrinsics.areEqual(r17, b.a.a) == false) goto L15;
        return new p(null, null, null, null, false, false, 95);
    L15:
        if (Intrinsics.areEqual(r17, b.c.a) == false) goto L18;
        return new p(r18, AppHost.a.getApplication().getString(2131901739), null, null, false, false, 124);
    L18:
        if (Intrinsics.areEqual(r17, b.C0038b.a) == false) goto L21;
        return new p(null, null, null, null, false, false, 95);
    L21:
        if (Intrinsics.areEqual(r17, b.d.a) == false) goto L29;
        Application r0 = AppHost.a.getApplication();
        String r2 = r18.toString();
        Drawable r3 = AppCompatResources.getDrawable(r0, 2131241518);
        String r4 = r0.getString(2131906883);
        String r5 = r0.getString(2131906861);
        SpannableStringBuilder r6 = new SpannableStringBuilder();
        r6.append(r4);
        if (r3 == null) goto L25;
        com.larus.bmhome.taskskill.f r7 = new com.larus.bmhome.taskskill.f(r3, i5.m(), i5.Y());
        int r8 = r6.length();
        r6.append(" ");
        r6.setSpan(r7, r8, r6.length(), 17);
    L26:
        r6.append(r2);
        r6.append(" ");
        r6.append(r5);
        return new p(null, new SpannedString(r6), null, null, !Intrinsics.areEqual(qa9.a.a().a(), "1"), true, 29);
    L25:
        r6.append(" ");
        goto L26
    L29:
        throw new NoWhenBranchMatchedException();
    }

    public static final b a(bs8.h r3, AllDeviceResponse r4, Function1<? super String, Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        PcDevice r1 = null;
        Object r2 = null;
        if (r3.a() == true) goto L5;
        return null;
    L5:
        bs8.a r6 = r3.b;
        if (r6 == null) goto L66;
        Integer r0 = r6.c;
        boolean r7 = true;
        if (r0 != null) goto L11;
    L13:
        String r8 = l2.d(r6, r4);
        if (r8 != null) goto L16;
    L19:
        if (r7 == false) goto L24;
        if (r5 == null) goto L23;
        r5.invoke("agentTaskParam is null or pcDeviceId is null");
    L23:
        return b.d.a;
    L24:
        if (r4 != null) goto L29;
        if (r5 == null) goto L28;
        r5.invoke("devicesInfo is null");
    L28:
        return b.C0038b.a;
    L29:
        List r9 = r4.getDevices();
        if (r9 == null) goto L42;
        Iterator r10 = r9.iterator();
    L33:
        if (r10.hasNext() == false) goto L41;
        Object r11 = r10.next();
        PcDevice r12 = (PcDevice) r11;
        if (r12 == null) goto L37;
        String r13 = r12.getDeviceId();
    L39:
        if (Intrinsics.areEqual(r13, r8) == false) goto L33;
        r2 = r11;
        goto L41
    L37:
        r13 = null;
    L41:
        r1 = (PcDevice) r2;
    L42:
        if (r5 == null) goto L44;
        r5.invoke("try find a matched device, matchedDeviceInfo=" + r1);
    L44:
        if (r1 == null) goto L70;
        Boolean r14 = r1.r();
        Boolean r15 = Boolean.TRUE;
        if (Intrinsics.areEqual(r14, r15) == true) goto L50;
        return b.e.a;
    L50:
        if (m2.a(r1) == false) goto L53;
        return b.c.a;
    L53:
        if (Intrinsics.areEqual(r1.g(), r15) == false) goto L58;
        if (Intrinsics.areEqual(r1.c(), r15) == false) goto L58;
        return b.a.a;
    L58:
        if (Intrinsics.areEqual(r1.g(), r15) == true) goto L61;
        return b.g.a;
    L61:
        if (Intrinsics.areEqual(r1.c(), r15) == true) goto L64;
        return b.f.a;
    L64:
        return b.C0038b.a;
    L70:
        return b.d.a;
    L16:
        if (r8.length() == 0) goto L19;
        r7 = false;
        goto L19
    L11:
        if (r0.intValue() != 1) goto L13;
    L66:
        return b.a.a;
    }
}

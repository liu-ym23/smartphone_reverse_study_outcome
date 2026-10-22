package ld;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.bytedance.android.anniex.container.ui.AnnieXDefaultActivity;
import com.ivy.ivykit.plugin.impl.utils.DefaultBulletActivity;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rc.d;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends tc.a implements d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f19599b;

    public /* synthetic */ b() {
        this.f19599b = 1;
    }

    @Override // rc.d
    public final boolean b(Context r18, Uri r19, ug.d r20) {
        switch(this.f19599b) {
            case 0: goto L32;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "schema");
        Intrinsics.checkNotNullParameter(r20, "config");
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L10
        Class<?> r10 = Class.forName("com.bytedance.android.anniex.container.AnnieXHostActivity");     // Catch: Throwable -> L10
        Object r11 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L14:
        if (Result.m131isSuccessimpl(r11) == false) goto L17;
        if (r10 != null) goto L18;
    L16:
        r10 = AnnieXDefaultActivity.class;
    L18:
        Intent r12 = new Intent();
        r12.setComponent(new ComponentName(r18, r10));
        r12.setData(r19);
        boolean r13 = r18 instanceof Activity;
        if (r13 == true) goto L21;
        r12.addFlags(268435456);
    L21:
        Integer r14 = (Integer) r20.f22357b;
        if (r14 == null) goto L24;
        r12.addFlags(r14.intValue());
    L24:
        ((Bundle) r20.e).putString("bundle_annie_x_bid", this.f22117a);
        r12.putExtras((Bundle) r20.e);
        if (r13 == false) goto L29;
        Integer r15 = (Integer) r20.f;
        if (r15 == null) goto L29;
        ((Activity) r18).startActivityForResult(r12, r15.intValue());
    L30:
        int r16 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r17 = MapsKt.mapOf(TuplesKt.to("url", r19.toString()));
        com.bytedance.ies.bullet.base.utils.logger.b r21 = new com.bytedance.ies.bullet.base.utils.logger.b();
        String r22 = (String) r20.f22358c;
        Intrinsics.checkNotNullParameter("session_id", "name");
        Intrinsics.checkNotNullParameter(r22, "sessionId");
        ArrayList r23 = r21.f5260a;
        androidx.room.jarjarred.org.antlr.runtime.a.B("session_id", r22, r23);
        String r24 = (String) r20.d;
        Intrinsics.checkNotNullParameter("callId", "name");
        Intrinsics.checkNotNullParameter(r24, "sessionId");
        androidx.room.jarjarred.org.antlr.runtime.a.B("callId", r24, r23);
        Unit r25 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("create page container successfully", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XRouter", "create page container successfully", r17, r21);
        return true;
    L29:
        r18.startActivity(r12);
        goto L30
    L17:
        int r26 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("XRouter", "get custom page container failed,use default container,url:" + r19, null, 12);
    L8:
        th = th;
    L12:
        Result.Companion r27 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L10:
        th = th;
        r10 = null;
        goto L12
    L32:
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "schema");
        Intrinsics.checkNotNullParameter(r20, "config");
        Intent r28 = new Intent();
        r28.setComponent(new ComponentName(r18, DefaultBulletActivity.class));
        r28.setData(r19);
        boolean r110 = r18 instanceof Activity;
        if (r110 == true) goto L35;
        r28.addFlags(268435456);
    L35:
        Integer r29 = (Integer) r20.f22357b;
        if (r29 == null) goto L72;
        r28.addFlags(r29.intValue());
    L72:
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L43
        String r31 = r19.getQueryParameter("url");     // Catch: Throwable -> L43
        if (r31 == null) goto L45;
        Uri r32 = Uri.parse(r31);     // Catch: Throwable -> L43
        if (r32 == null) goto L45;
        String r33 = r32.getQueryParameter("ug_campaign_launch_mode");     // Catch: Throwable -> L43
    L46:
        Object r34 = Result.m124constructorimpl(r33);     // Catch: Throwable -> L43
    L50:
        if (Result.m130isFailureimpl(r34) == false) goto L52;
        r34 = null;
    L52:
        String r35 = (String) r34;
        if (Intrinsics.areEqual(r35, "clear_top") == false) goto L55;
        Integer r36 = Integer.valueOf(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
    L58:
        if (r36 == null) goto L60;
        r28.addFlags(r36.intValue());
    L60:
        r28.putExtras((Bundle) r20.e);
        if (r110 == false) goto L65;
        Integer r37 = (Integer) r20.f;
        if (r37 == null) goto L65;
        ((Activity) r18).startActivityForResult(r28, r37.intValue());
    L66:
        int r38 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r39 = MapsKt.mapOf(TuplesKt.to("url", r19.toString()));
        com.bytedance.ies.bullet.base.utils.logger.b r40 = new com.bytedance.ies.bullet.base.utils.logger.b();
        String r41 = (String) r20.f22358c;
        Intrinsics.checkNotNullParameter("session_id", "name");
        Intrinsics.checkNotNullParameter(r41, "sessionId");
        ArrayList r42 = r40.f5260a;
        androidx.room.jarjarred.org.antlr.runtime.a.B("session_id", r41, r42);
        String r43 = (String) r20.d;
        Intrinsics.checkNotNullParameter("callId", "name");
        Intrinsics.checkNotNullParameter(r43, "sessionId");
        androidx.room.jarjarred.org.antlr.runtime.a.B("callId", r43, r42);
        Unit r44 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("create page container successfully", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XRouter", "create page container successfully", r39, r40);
        return true;
    L65:
        r18.startActivity(r28);
        goto L66
    L55:
        if (r35 == null) goto L57;
        r36 = StringsKt.toIntOrNull(r35);
        goto L58
    L57:
        r36 = null;
    L45:
        r33 = null;
    L43:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        r34 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L50
    }

    public b(a r5) {
        this.f19599b = 0;
        Intrinsics.checkNotNullParameter(r5, "pageConfig");
    }
}

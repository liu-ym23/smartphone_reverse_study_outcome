package com.bytedance.android.live.broadcastgame.opengame.debug;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.view.ViewGroup;
import android.widget.EditText;
import com.bytedance.android.live.broadcastgame.opengame.LiveBasePluginManager;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements DialogInterface.OnClickListener {
    public final /* synthetic */ EditText a;
    public final /* synthetic */ EditText b;
    public final /* synthetic */ d c;
    public final /* synthetic */ Context d;
    public final /* synthetic */ DataCenter e;
    public final /* synthetic */ ViewGroup f;
    public final /* synthetic */ com.bytedance.android.live.broadcastgame.api.openplatform.b g;

    public h(EditText r1, EditText r2, d r3, Context r4, DataCenter r5, ViewGroup r6, LiveBasePluginManager r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r13, int r14) {
        Editable r15 = this.a.getText();
        if (r15 != null) goto L5;
    L8:
        boolean r16 = true;
    L9:
        if (r16 == true) goto L37;
        String r17 = this.a.getText().toString();
        if (r17 == null) goto L36;
        String r18 = StringsKt.trim(r17).toString();
        Editable r3 = this.b.getText();
        if (r3 != null) goto L15;
    L18:
        boolean r4 = true;
    L19:
        if (r4 == false) goto L41;
    L26:
        long r2 = 0;
    L27:
        Map<String, ? extends Object> r11 = MapsKt.mapOf(new Pair[]{TuplesKt.to(OpenPlatformBaseDebugger.APP_ID, r18), TuplesKt.to("game_id", Long.valueOf(r2))});
        d r19 = this.c;
        Context r6 = this.d;
        DataCenter r7 = this.e;
        ViewGroup r8 = this.f;
        com.bytedance.android.live.broadcastgame.api.openplatform.b r9 = this.g;
        r19.getClass();
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "dataCenter");
        Intrinsics.checkNotNullParameter(r8, "containerView");
        Intrinsics.checkNotNullParameter(r9, "gameManager");
        Intrinsics.checkNotNullParameter(r11, "extraParams");
        if (v.a() == false) goto L34;
        OpenPlatformBaseDebugger r0 = r19.b;
        if (r0 == null) goto L33;
        r0.releaseDebug();
    L33:
        r19.b = null;
        r19.a = false;
        j r5 = new j();
        r19.b = r5;
        r5.initDebug(r6, r7, r8, r9, r11, new f(r19));
    L34:
        f2.c("已生效，请返回直播间查看", 0);
    L38:
        r13.dismiss();
        return;
    L41:
        String r12 = this.b.getText().toString();     // Catch: NumberFormatException -> L40
        if (r12 == null) goto L25;
        r2 = CastLongProtector.parseLong(StringsKt.trim(r12).toString());     // Catch: NumberFormatException -> L40
        goto L27
    L25:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");     // Catch: NumberFormatException -> L40
    L15:
        if (r3.length() == 0) goto L18;
        r4 = false;
        goto L19
    L36:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L37:
        f2.c("操作错误：appId 不能为空", 0);
        goto L38
    L5:
        if (r15.length() == 0) goto L8;
        r16 = false;
        goto L9
    }
}

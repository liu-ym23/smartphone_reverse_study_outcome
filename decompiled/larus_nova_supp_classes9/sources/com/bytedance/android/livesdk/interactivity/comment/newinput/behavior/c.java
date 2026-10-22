package com.bytedance.android.livesdk.interactivity.comment.newinput.behavior;

import am2.x;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputFunctionEnum;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputFunctionType;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class c implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a {
    public View a;
    public int b;
    public boolean c;
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.h d;
    public String e;
    public final InputFunctionEnum f;
    public final Context g;
    public final InputSectionType h;

    public static final class a {
    }

    static {
    }

    public int c() {
        return 0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public int o() {
        return 0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public void r(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2) {
        Intrinsics.checkNotNullParameter(r2, "bridge");
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public void s(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2) {
        Intrinsics.checkNotNullParameter(r2, "bridges");
    }

    public final InputFunctionType b() {
        return this.f.getType();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public boolean canShowRedDot() {
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.h r0 = this.d;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.a >= com.bytedance.android.livesdk.paas.c.b()) goto L9;
        return false;
    L9:
        if (((Number) new com.bytedance.android.livesdk.sharedpref.e(this.e, 0).getValue()).intValue() >= 3) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public View getView() {
        if (this.a != null) goto L10;
        if (c() <= 0) goto L10;
        View r0 = LayoutInflater.from(this.g).inflate(c(), null);
        this.a = r0;
        if (r0 == null) goto L10;
        r0.setTag(this.f);
    L10:
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final void j() {
        if (this.d == null) goto L6;
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e(this.e, 0), 3);
        u(false, true);
        return;
    }

    public final Context getContext() {
        return this.g;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final boolean i() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final InputSectionType l() {
        return this.h;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final int n() {
        return this.b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final InputFunctionEnum q() {
        return this.f;
    }

    public final void a(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.h r2) {
        Intrinsics.checkNotNullParameter(r2, "redDot");
        Unit r0 = Unit.INSTANCE;
        this.d = r2;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public void k(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2) {
        Intrinsics.checkNotNullParameter(r2, "bridges");
        r3.a(getView(), this.f.getDesc());
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final void m(int r1) {
        this.b = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public void p(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2) {
        Intrinsics.checkNotNullParameter(r2, "bridges");
        Intrinsics.checkNotNullParameter(r2, "bridges");
    }

    public static void d(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "icon");
        HashMap r0 = new HashMap();
        r0.put("click_icon", r3);
        r0.put("screen_type", "portrait");
        if (r4 == false) goto L5;
        String r5 = "on";
    L6:
        r0.put("extend_mode", r5);
        IInteractivityInjectService r6 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r6 == null) goto L9;
        r6.buildVsRoomLog(null, r0);
    L9:
        j0.l().sendLog("livesdk_comment_expansion_module_click", r0, new Object[]{IRoom.class, x.class});
        return;
    L5:
        r5 = "off";
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public void t(View r2, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "bridges");
        d(this.f.getLogValue(), r3.i());
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public void u(boolean r4, boolean r5) {
        View r1 = null;
        if (r4 == false) goto L11;
        View r2 = this.a;
        if (r2 == null) goto L7;
        r1 = r2.findViewById(2131384095);
    L7:
        if (r1 == null) goto L9;
        UtilityKotlinExtentionsKt.w(r1);
    L9:
        if (r5 == false) goto L16;
        com.bytedance.android.livesdk.sharedpref.e r6 = new com.bytedance.android.livesdk.sharedpref.e(this.e, 0);
        com.bytedance.android.livesdk.sharedpref.f.d(r6, Integer.valueOf(((Integer) r6.getValue()).intValue() + 1));
    L16:
        this.c = r4;
        return;
    L11:
        View r7 = this.a;
        if (r7 == null) goto L14;
        r1 = r7.findViewById(2131384095);
    L14:
        if (r1 == null) goto L16;
        UtilityKotlinExtentionsKt.t(r1);
        goto L16
    }

    public c(InputFunctionEnum r2, Context r3, InputSectionType r4) {
        Intrinsics.checkNotNullParameter(r2, "symbol");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.b = 1;
        this.e = "red_dot_" + r2.name();
    }
}

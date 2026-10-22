package com.bytedance.android.livesdk.interactivity.roomintro.v2;

import android.text.Editable;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.livesdk.config.gg1;
import com.bytedance.android.livesdk.interactivity.api.roomintro.api.IntroGuideButton;
import com.bytedance.android.livesdk.interactivity.api.roomintro.api.LabelGroup;
import com.bytedance.android.livesdk.q2;
import com.bytedance.android.livesdk.widget.TextCorrectionEditText;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.common.utility.UIUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class RoomIntroDataSource {
    public static final a x = null;
    public final Lazy a;
    public final Lazy b;
    public com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter.a c;
    public final PropertyOwner<sh6.b<Unit>> d;
    public final PropertyOwner<sh6.b<Integer>> e;
    public final PropertyOwner f;
    public final PropertyOwner g;
    public final PropertyOwner<Unit> h;
    public final PropertyOwner i;
    public final PropertyOwner j;
    public final PropertyOwner k;
    public final PropertyOwner l;
    public final PropertyOwner m;
    public final c n;
    public final com.bytedance.android.livesdk.interactivity.api.roomintro.api.b o;
    public final List<LabelGroup> p;
    public final List<RoomIntroLabel> q;
    public final List<IntroGuideButton> r;
    public final PropertyOwner<List<RoomIntroLabel>> s;
    public final PropertyOwner<Integer> t;
    public final PropertyOwner<Boolean> u;
    public final PropertyOwner<Boolean> v;
    public final PropertyOwner<gz.b> w;

    public static final class a {
        public a() {
        }

        public static boolean a() {
            return ((gg1) q2.a.getValue()).a();
        }
    }

    static {
        x = new a();
    }

    public final String a() {
        com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter.a r0 = this.c;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (UIUtils.isViewVisible(r0.c) == false) goto L11;
        TextCorrectionEditText r1 = r0.c;
        if (r1 == null) goto L15;
        Editable r2 = r1.getText();
        if (r2 == null) goto L16;
        String r3 = r2.toString();
    L13:
        return r3;
    L16:
        return null;
    L15:
        return null;
    L11:
        r3 = r0.a;
        goto L13
    }

    public RoomIntroDataSource(c r1, com.bytedance.android.livesdk.interactivity.api.roomintro.api.b r2, List r3, List r4, List r5, PropertyOwner r6, PropertyOwner r7, PropertyOwner r8, PropertyOwner r9, PropertyOwner r10) {
        this.n = r1;
        this.o = r2;
        this.p = r3;
        this.q = r4;
        this.r = r5;
        this.s = r6;
        this.t = r7;
        this.u = r8;
        this.v = r9;
        this.w = r10;
        this.a = LazyKt.lazy(RoomIntroDataSource$customConfig$2.INSTANCE);
        this.b = LazyKt.lazy(RoomIntroDataSource$appointmentConfig$2.INSTANCE);
        sh6.a r11 = sh6.a.a;
        this.d = new PropertyOwner(r11);
        PropertyOwner<sh6.b<Integer>> r13 = new PropertyOwner(r11);
        this.e = r13;
        this.f = r13;
        this.g = r6;
        PropertyOwner<Unit> r14 = new PropertyOwner(Unit.INSTANCE);
        this.h = r14;
        this.i = r14;
        this.j = r7;
        if (r8 != null) goto L6;
        r8 = null;
    L6:
        this.k = r8;
        if (r9 != null) goto L10;
        r9 = null;
    L10:
        this.l = r9;
        if (r10 != null) goto L14;
        r10 = null;
    L14:
        this.m = r10;
    }
}

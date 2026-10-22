package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.reddot.RedDotDelegate;
import java.util.Map;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0011\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/RedDotView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "visibility", "", "setVisibility", "Lcom/bytedance/android/livesdk/reddot/RedDotDelegate;", "a", "Lcom/bytedance/android/livesdk/reddot/RedDotDelegate;", "getRedDot", "()Lcom/bytedance/android/livesdk/reddot/RedDotDelegate;", "setRedDot", "(Lcom/bytedance/android/livesdk/reddot/RedDotDelegate;)V", "redDot", "", "b", "Z", "isShowing", "()Z", "setShowing", "(Z)V", "c", "isAnchor", "setAnchor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RedDotView extends AppCompatImageView {
    public static final /* synthetic */ int d = 0;
    public RedDotDelegate a;
    public boolean b;
    public boolean c;

    public RedDotView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RedDotView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final boolean j() {
        RedDotDelegate r0 = this.a;
        boolean r1 = false;
        if (r0 == null) goto L5;
        r1 = r0.a(false);
    L5:
        if (r1 == true) goto L13;
        RedDotDelegate r2 = this.a;
        if (r2 == null) goto L13;
        if (r2.d() == true) goto L13;
        RedDotDelegate r3 = this.a;
        if (r3 == null) goto L13;
        com.bytedance.android.livesdk.sharedpref.e r4 = r3.c();
        Boolean r5 = Boolean.TRUE;
        r4.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r4, r5);
    L13:
        return r1;
    }

    public final void l() {
        if (this.b == false) goto L31;
        RedDotDelegate r0 = this.a;
        if (r0 != null) goto L7;
    L9:
        RedDotDelegate r1 = this.a;
        if (r1 == null) goto L16;
        com.bytedance.android.livesdk.reddot.a r2 = r1.a;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("redDot");
    L14:
        String r3 = r2.a;
        if (r3 == null) goto L16;
    L17:
        Map r4 = MapsKt.mapOf(TuplesKt.to("spot_name", r3));
        if (this.c == false) goto L24;
        Pair[] r5 = new Pair[2];
        r5[0] = TuplesKt.to("spot_title", "礼物");
        if (this.c == false) goto L22;
        String r6 = SourceType.ANCHOR;
    L23:
        r5[1] = TuplesKt.to("user_type", r6);
        r4 = MapsKt.plus(r4, MapsKt.mapOf(r5));
        goto L24
    L22:
        r6 = "user";
    L24:
        qm0.b r7 = om0.c.g();
        if (r7 == null) goto L27;
        r7.sendLog("livesdk_room_spot_click", r4, new Object[]{am2.x.class, s80.a.a});
    L27:
        RedDotDelegate r8 = this.a;
        if (r8 == null) goto L32;
        com.bytedance.android.livesdk.sharedpref.e r9 = r8.c();
        Boolean r10 = Boolean.TRUE;
        r9.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r9, r10);
        return;
    L32:
        return;
    L16:
        r3 = "";
        goto L17
    L7:
        if (r0.d() != true) goto L9;
    }

    public final void o() {
        RedDotDelegate r0 = this.a;
        if (r0 == null) goto L8;
        com.bytedance.android.livesdk.sharedpref.e r1 = r0.c();
        Boolean r2 = Boolean.FALSE;
        r1.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r1, r2);
        com.bytedance.android.livesdk.sharedpref.e r3 = r0.e;
        if (r3 == null) goto L9;
        com.bytedance.android.livesdk.sharedpref.f.d(r3, 0);
        return;
    L9:
        return;
    }

    public final RedDotDelegate getRedDot() {
        return this.a;
    }

    public final void setAnchor(boolean r1) {
        this.c = r1;
    }

    public final void setRedDot(RedDotDelegate r1) {
        this.a = r1;
    }

    public final void setShowing(boolean r1) {
        this.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setVisibility(int r8) {
        if (r8 == 0) goto L5;
    L33:
        if (r8 == 0) goto L38;
        RedDotDelegate r1 = this.a;
        if (r1 == null) goto L37;
        r1.f = false;
    L37:
        this.b = false;
    L38:
        super/*android.widget.ImageView*/.setVisibility(r8);
        return;
    L5:
        if (getVisibility() == 0) goto L33;
        RedDotDelegate r2 = this.a;
        if (r2 != null) goto L9;
    L11:
        RedDotDelegate r3 = this.a;
        if (r3 == null) goto L18;
        com.bytedance.android.livesdk.reddot.a r4 = r3.a;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("redDot");
    L16:
        String r5 = r4.a;
        if (r5 == null) goto L18;
    L19:
        Map r6 = MapsKt.mapOf(TuplesKt.to("spot_name", r5));
        if (this.c == false) goto L26;
        Pair[] r7 = new Pair[2];
        r7[0] = TuplesKt.to("spot_title", "礼物");
        if (this.c == false) goto L24;
        String r9 = SourceType.ANCHOR;
    L25:
        r7[1] = TuplesKt.to("user_type", r9);
        r6 = MapsKt.plus(r6, MapsKt.mapOf(r7));
        goto L26
    L24:
        r9 = "user";
    L26:
        qm0.b r10 = om0.c.g();
        if (r10 == null) goto L29;
        r10.sendLog("livesdk_room_spot_show", r6, new Object[]{am2.x.class, s80.a.a});
    L29:
        RedDotDelegate r0 = this.a;
        if (r0 == null) goto L32;
        r0.e();
    L32:
        this.b = true;
    L18:
        r5 = "";
        goto L19
    L9:
        if (r2.d() != true) goto L11;
        goto L11
    }

    public final RedDotDelegate n(RedDotDelegate r2, Boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "dot");
        this.a = r2;
        boolean r0 = false;
        if (r2 == null) goto L5;
        r2.f = false;
    L5:
        if (r3 == null) goto L7;
        r0 = r3.booleanValue();
    L7:
        this.c = r0;
        return this.a;
    }

    public RedDotView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setBackgroundResource(2131251415);
    }

    public /* synthetic */ RedDotView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final RedDotDelegate m(com.bytedance.android.livesdk.reddot.a r2, TreeSet<RedDotDelegate> r3, Function0<Boolean> r4, Boolean r5) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (this.a != null) goto L11;
        RedDotDelegate r6 = com.bytedance.android.livesdk.reddot.b.b(r2, r4);
        this.a = r6;
        if (r3 == null) goto L11;
        Intrinsics.checkNotNull(r6);
        Intrinsics.checkNotNullParameter(r6, "redDotDelegate");
        Intrinsics.checkNotNullParameter(r3, "dotSet");
        r3.add(r6);
        r6.b = r3;
    L11:
        if (r5 == null) goto L13;
        boolean r7 = r5.booleanValue();
    L14:
        this.c = r7;
        RedDotDelegate r8 = this.a;
        if (r8 == null) goto L17;
        r8.f = false;
    L17:
        return r8;
    L13:
        r7 = false;
        goto L14
    }
}

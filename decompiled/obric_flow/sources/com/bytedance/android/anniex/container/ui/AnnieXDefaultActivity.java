package com.bytedance.android.anniex.container.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import com.obric.launcher.widget.R$id;
import com.obric.launcher.widget.R$layout;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import s3.d;
import xc.e;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/anniex/container/ui/AnnieXDefaultActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class AnnieXDefaultActivity extends AppCompatActivity {
    public final Lazy s;

    public AnnieXDefaultActivity() {
        this.s = LazyKt.lazy(AnnieXDefaultActivity$annieXPageHelper$2.f3179a);
    }

    @Override // android.app.Activity
    public final void finish() {
        super.finish();
        w3.a r5 = ((c) this.s.getValue()).f3196a;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("fragmentHolder");
        r5 = null;
    L5:
        ((d) r5.f22713c).finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        c r5 = (c) this.s.getValue();
        w3.a r10 = r5.f3196a;
        AnnieXDefaultActivity r11 = null;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("fragmentHolder");
        r10 = null;
    L6:
        if (((d) r10.f22713c).canBackPress() == false) goto L13;
        AnnieXDefaultActivity r12 = r5.f3197b;
        if (r12 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("annieXActivity");
    L11:
        r11.finish();
        return;
    L10:
        r11 = r12;
        goto L11
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r10) {
        super.onCreate(r10);
        setContentView(R$layout.activity_anniex_default);
        c r11 = (c) this.s.getValue();
        final Intent r5 = getIntent();
        int r12 = R$id.annie_x_container;
        r11.getClass();
        Intrinsics.checkNotNullParameter(this, "activity");
        Intrinsics.checkNotNullParameter(r5, "intent");
        final String r13 = r5.getStringExtra("bundle_annie_x_bid");
        if (r13 != null) goto L6;
        r13 = "default_bid";
    L6:
        if (jm.c.h(this, r13, "bullet_bid_AnnieXPageHelper") == true) goto L16;
        ConcurrentHashMap r14 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(e.class, "cls");
        e r15 = (e) yc.a.a(e.class, "default_bid");
        if (r15 == null) goto L12;
        xc.d r16 = (xc.d) r15.a(xc.d.class);
        if (r16 == null) goto L12;
        boolean r17 = Intrinsics.areEqual(r16.K0(), Boolean.TRUE);
    L13:
        if (r17 == false) goto L16;
        int r18 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("bullet_bid_AnnieXPageHelper", "tryInitAnnieXIfNeed failed, bid = ".concat(r13), null, 12);
        finish();
        return;
    L12:
        r17 = false;
    L16:
        Intrinsics.checkNotNullParameter(r13, "bid");
        Intrinsics.checkNotNullParameter(p3.e.class, "clazz");
        com.bytedance.android.anniex.base.service.c.a(p3.e.class, r13);
        xq.b.t();
        r11.f3197b = this;
        Function1<r3.b, Unit> r19 = new AnnieXPageHelper$onCreate$1(this, r13, r5);
        Intrinsics.checkNotNullParameter(r19, "block");
        r3.b r20 = new r3.b();
        r19.invoke(r20);
        w3.a r21 = new w3.a(r20);
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type com.bytedance.android.anniex.container.holder.AnnieXFragmentHolder");
        r11.f3196a = r21;
        FragmentTransaction r22 = getSupportFragmentManager().beginTransaction();
        w3.a r23 = r11.f3196a;
        if (r23 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("fragmentHolder");
        r23 = null;
    L20:
        if (((AnnieXFragment) r23.e) != null) goto L33;
        AnnieXFragment r24 = new AnnieXFragment((r3.b) r23.f22712b);
        r23.e = r24;
        d r25 = (d) r23.f22713c;
        Intrinsics.checkNotNullParameter(r25, "container");
        r24.f3185c = r25;
        if (r25 != null) goto L24;
    L28:
        com.bytedance.ies.bullet.service.base.c r26 = (com.bytedance.ies.bullet.service.base.c) r23.d;
        if (r26 == null) goto L33;
        AnnieXFragment r27 = (AnnieXFragment) r23.e;
        if (r27 == null) goto L33;
        Intrinsics.checkNotNullParameter(r26, "listener");
        r27.d = r26;
        goto L33
    L24:
        if (r24.f3186h.getValue() == null) goto L28;
        throw new ClassCastException();
    L33:
        AnnieXFragment r28 = (AnnieXFragment) r23.e;
        Intrinsics.checkNotNull(r28, "null cannot be cast to non-null type com.bytedance.android.anniex.container.ui.AnnieXFragment");
        r22.replace(r12, r28).commit();
        Uri r29 = r5.getData();
        if (r29 == null) goto L40;
        w3.a r30 = r11.f3196a;
        if (r30 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("fragmentHolder");
        r30 = null;
    L38:
        String r31 = r29.toString();
        r30.getClass();
        Intrinsics.checkNotNullParameter(r31, "schema");
        ((d) r30.f22713c).loadSchema(r31, null);
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        w3.a r5 = ((c) this.s.getValue()).f3196a;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("fragmentHolder");
        r5 = null;
    L5:
        ((d) r5.f22713c).release();
        r5.d = null;
    }
}

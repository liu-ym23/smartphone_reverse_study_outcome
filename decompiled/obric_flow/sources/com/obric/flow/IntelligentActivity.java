package com.obric.flow;

import ai.j0;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.view.WindowCompat;
import com.obric.flow.cardlistpage.R$id;
import com.obric.flow.cardlistpage.R$layout;
import com.obric.flow.cardlistpage.base.BaseActivity;
import com.obric.flow.cardlistpage.ui.CardFeedLayout;
import com.obric.flow.cardlistpage.ui.component.feedlist.s;
import com.obric.flow.cardlistpage.ui.l;
import ju.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.a;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/flow/IntelligentActivity;", "Lcom/obric/flow/cardlistpage/base/BaseActivity;", "<init>", "()V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class IntelligentActivity extends BaseActivity {
    public CardFeedLayout s;

    public IntelligentActivity() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r10, int r11, Intent r12) {
        super.onActivityResult(r10, r11, r12);
        StringBuilder r5 = j0.v("onActivityResult:", r10, r11, " resultCode:", " data:");
        r5.append(r12);
        String r13 = r5.toString();
        Intrinsics.checkNotNullParameter("TestActivity", "tag");
        Intrinsics.checkNotNullParameter(r13, "msg");
        a r14 = su.a.f22013b;
        if (r14 == null) goto L29;
        s r15 = null;
        ((b) r14.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(b.class), null)).i("TestActivity", r13);
        CardFeedLayout r16 = this.s;
        if (r16 == null) goto L30;
        l r17 = r16.E;
        if (r17 == null) goto L15;
        if (r10 != 1) goto L11;
    L13:
        r17.c(r11, r12);
        return;
    L11:
        if (r10 == 2) goto L13;
    L15:
        if (r10 == 3) goto L17;
        return;
    L17:
        if (r11 != (-1)) goto L33;
        if (r12 == null) goto L20;
        int r18 = r12.getIntExtra("appWidgetId", -1);
    L21:
        if (r18 == (-1)) goto L34;
        s r19 = r16.C;
        if (r19 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("feedListComponent");
    L26:
        r15.z(r18);
        return;
    L25:
        r15 = r19;
        goto L26
    L34:
        return;
    L20:
        r18 = -1;
        goto L21
    L33:
        return;
    L30:
        return;
    L29:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R$layout.feeds);
        this.s = (CardFeedLayout) findViewById(R$id.card_layout);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        CardFeedLayout r5 = this.s;
        if (r5 == null) goto L6;
        r5.o();
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        CardFeedLayout r5 = this.s;
        if (r5 == null) goto L6;
        r5.p();
        return;
    }
}

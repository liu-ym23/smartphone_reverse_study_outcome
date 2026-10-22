package com.obric.flow.cardlistpage.ui;

import android.R;
import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import com.obric.oui.window.permission.WebViewActivity;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/obric/flow/cardlistpage/ui/TransparentDialogActivity;", "Landroid/app/Activity;", "<init>", "()V", "u8/a", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TransparentDialogActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f11565a = 0;

    /* JADX INFO: renamed from: com.obric.flow.cardlistpage.ui.TransparentDialogActivity$onCreate$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(Object r10) {
            super(0, r10, TransparentDialogActivity.class, "finish", "finish()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((TransparentDialogActivity) this.receiver).finish();
        }
    }

    /* JADX INFO: renamed from: com.obric.flow.cardlistpage.ui.TransparentDialogActivity$onCreate$2, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass2(Object r10) {
            super(0, r10, TransparentDialogActivity.class, "finish", "finish()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((TransparentDialogActivity) this.receiver).finish();
        }
    }

    public TransparentDialogActivity() {
    }

    @Override // android.app.Activity
    public final void onActivityResult(int r5, int r10, Intent r11) {
        if (r5 == 3) goto L5;
    L12:
        finish();
        super.onActivityResult(r5, r10, r11);
        return;
    L5:
        if (r10 != (-1)) goto L12;
        if (r11 == null) goto L9;
        int r12 = r11.getIntExtra("appWidgetId", 0);
    L10:
        if (r12 == 0) goto L12;
        obric.flow.b.d(r12);
        goto L12
    L9:
        r12 = getIntent().getIntExtra("appWidgetId", 0);
        goto L10
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle r15) {
        super.onCreate(r15);
        Window r16 = getWindow();
        if (r16 == null) goto L5;
        r16.setBackgroundDrawableResource(R.color.transparent);
    L5:
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        String r17 = getIntent().getStringExtra("extra_action");
        if (r17 == null) goto L119;
        String r5 = "";
        switch(r17.hashCode()) {
            case -1160227487: goto L109;
            case -449856960: goto L66;
            case 285389865: goto L62;
            case 356894768: goto L38;
            case 1427905898: goto L28;
            case 1924841554: goto L11;
            default: goto L119;
        };
    L11:
        if (r17.equals("extra_action_go_privacy_policy_network_dialog") == false) goto L119;
        String r18 = getIntent().getStringExtra("extra_web_view_url");
        if (r18 != null) goto L16;
        r18 = "";
    L16:
        String r10 = getIntent().getStringExtra("extra_web_view_title");
        if (r10 != null) goto L19;
        r10 = "";
    L19:
        String r11 = getIntent().getStringExtra("extra_privacy_policy_source");
        if (r11 == null) goto L24;
        r5 = r11;
    L24:
        if (StringsKt.isBlank(r18) == false) goto L26;
        finish();
        return;
    L26:
        com.bytedance.ies.bullet.base.utils.b.t(this, r18, r10, r5, new AnonymousClass2(this));
        return;
    L28:
        if (r17.equals("extra_action_request_push_permission") == false) goto L119;
        if (Build.VERSION.SDK_INT >= 33) goto L34;
        finish();
        return;
    L34:
        if (ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") != 0) goto L36;
        finish();
        return;
    L36:
        requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, 1001);
        return;
    L38:
        if (r17.equals("extra_action_go_app_market_dialog") == false) goto L119;
        String r19 = getIntent().getStringExtra("extra_app_market_package_name");
        String r12 = getIntent().getStringExtra("extra_app_market_app_name");
        if (Build.VERSION.SDK_INT < 33) goto L43;
        Bitmap r13 = (Bitmap) androidx.activity.e.o(getIntent());
    L44:
        if (r19 != null) goto L46;
    L60:
        finish();
        return;
    L46:
        if (r19.length() == 0) goto L60;
        if (r12 == null) goto L60;
        if (r12.length() == 0) goto L60;
        Intrinsics.checkNotNull(r19);
        Intrinsics.checkNotNull(r12);
        AnonymousClass1 r14 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(this, "activity");
        Intrinsics.checkNotNullParameter(r19, "packageName");
        Intrinsics.checkNotNullParameter(r12, "appName");
        if (r13 == null) goto L55;
        Drawable r20 = new BitmapDrawable(getResources(), r13);
    L57:
        td.e.n(this, r19, r20, r12, r14);
        return;
    L55:
        r20 = ContextCompat.getDrawable(this, R.drawable.sym_def_app_icon);
        if (r20 != null) goto L57;
        throw new IllegalStateException("Default app icon is unavailable");
    L43:
        r13 = (Bitmap) getIntent().getParcelableExtra("extra_app_market_app_icon");
        goto L44
    L62:
        if (r17.equals("extra_action_go_search_page") == false) goto L119;
        Intent r110 = new Intent();
        r110.setComponent(new ComponentName("com.obric.quicksearch", "com.android.quicksearchbox.SearchActivity"));
        r110.setFlags(268468224);
        startActivity(r110);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
        return;
    L66:
        if (r17.equals("extra_action_go_widget_config") == false) goto L119;
        int r21 = getIntent().getIntExtra("request_code", 0);
        int r22 = getIntent().getIntExtra("appWidgetId", 0);
        if (r22 != 0) goto L74;
        Intrinsics.checkNotNullParameter("TransparentDialogActivity", "tag");
        Intrinsics.checkNotNullParameter("Invalid appWidgetId in intent", "msg");
        org.koin.core.a r23 = su.a.f22013b;
        if (r23 == null) goto L73;
        ((ju.b) r23.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).w("TransparentDialogActivity", "Invalid appWidgetId in intent");
        finish();
        return;
    L73:
        throw new IllegalStateException("KoinApplication has not been started");
    L74:
        AppWidgetProviderInfo r24 = AppWidgetManager.getInstance(this).getAppWidgetInfo(r22);
        if (r24 == null) goto L77;
        ComponentName r25 = r24.configure;
    L123:
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L81
        if (r25 == null) goto L84;
        Intent r111 = new Intent("android.appwidget.action.APPWIDGET_CONFIGURE");     // Catch: Throwable -> L81
        r111.setComponent(r25);     // Catch: Throwable -> L81
        r111.putExtra("appWidgetId", r22);     // Catch: Throwable -> L81
        r111.setFlags(343932928);     // Catch: Throwable -> L81
        startActivityForResult(r111, r21);     // Catch: Throwable -> L81
        return;
    L84:
        throw new IllegalStateException("Widget configure component is null: appWidgetId=" + r22);     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        Throwable r112 = Result.m127exceptionOrNullimpl(Result.m124constructorimpl(ResultKt.createFailure(th)));
        if (r112 == null) goto L121;
        String r113 = "Start widget config activity failed: appWidgetId=" + r22 + ", error=" + r112;
        Intrinsics.checkNotNullParameter("TransparentDialogActivity", "tag");
        Intrinsics.checkNotNullParameter(r113, "msg");
        org.koin.core.a r28 = su.a.f22013b;
        if (r28 == null) goto L91;
        ((ju.b) r28.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).w("TransparentDialogActivity", r113);
        goto L121
    L91:
        throw new IllegalStateException("KoinApplication has not been started");
    L121:
        gu.d r29 = obric.flow.b.f20428b;     // Catch: Throwable -> L95
        if (r29 == null) goto L97;
        r29.startAppWidgetConfigureActivityForResult(this, r22, 0, r21, null);     // Catch: Throwable -> L95
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L95
    L98:
        Object r115 = Result.m124constructorimpl(r114);     // Catch: Throwable -> L95
    L101:
        Throwable r116 = Result.m127exceptionOrNullimpl(r115);
        if (r116 == null) goto L134;
        String r117 = "startWidgetConfigActivity failed: appWidgetId=" + r22 + ", error=" + r116;
        Intrinsics.checkNotNullParameter("TransparentDialogActivity", "tag");
        Intrinsics.checkNotNullParameter(r117, "msg");
        org.koin.core.a r30 = su.a.f22013b;
        if (r30 == null) goto L107;
        ((ju.b) r30.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).w("TransparentDialogActivity", r117);
        finish();
        return;
    L107:
        throw new IllegalStateException("KoinApplication has not been started");
    L134:
        return;
    L97:
        r114 = null;
    L95:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r115 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L101
    L77:
        r25 = null;
        goto L123
    L109:
        if (r17.equals("extra_action_go_web_view_page") == false) goto L119;
        String r118 = getIntent().getStringExtra("extra_web_view_url");
        if (r118 == null) goto L115;
        r5 = r118;
    L115:
        String r119 = getIntent().getStringExtra("extra_web_view_title");
        if (r5.length() <= 0) goto L118;
        Intent r32 = new Intent(this, WebViewActivity.class);
        r32.putExtra("extra_url", r5);
        r32.putExtra("extra_title", r119);
        startActivity(r32);
        finish();
        return;
    L118:
        finish();
        return;
    L119:
        finish();
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int r5, String[] r10, int[] r11) {
        Intrinsics.checkNotNullParameter(r10, "permissions");
        Intrinsics.checkNotNullParameter(r11, "grantResults");
        if (r5 != 1001) goto L6;
        finish();
        return;
    L6:
        super.onRequestPermissionsResult(r5, r10, r11);
    }

    @Override // android.app.Activity
    public final void onStop() {
        super.onStop();
        if (Intrinsics.areEqual(getIntent().getStringExtra("extra_action"), "extra_action_request_push_permission") == true) goto L6;
        finish();
        return;
    }
}

package com.obric.assistant.privacyui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import ofa.a;
import ofa.c;
import t9a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\u008f\u0001\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132u\u0010\u0014\u001aq\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\f0\u0015H\u0016J\b\u0010\u001e\u001a\u00020\fH\u0016J\b\u0010\u001f\u001a\u00020\nH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020\u0005H\u0016R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/assistant/privacyui/ObricPrivacyAndPermissionUiServiceImpl;", "Lcom/obric/assistant/spi/security/privacypermission/IObricPrivacyAndPermissionUiService;", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "systemPermissionItemsController", "Lcom/obric/assistant/privacyui/ObricSystemPermissionItemsController;", "interceptGoToSettingsDialog", "", "setInterceptGoToSettingsDialog", "", "intercept", "shouldInterceptGoToSettingsDialog", "setupObricSystemPermissionItems", "host", "Landroidx/fragment/app/Fragment;", "itemsStub", "Landroid/view/ViewStub;", "onRequestGoSettings", "Lkotlin/Function5;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "permissionType", "title", "message", "confirmText", "releaseObricSystemPermissionItems", "isPermissionRequestUiCustomizeEnabled", "getPermissionRequestUiDialogTitle", "type", "getPermissionRequestUiDialogSubtitle", "getNotesDisplayName", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPrivacyAndPermissionUiServiceImpl implements IObricPrivacyAndPermissionUiService {
    public final String a;
    public final c b;
    public volatile boolean c;

    @Override // com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService
    public final void c() {
        this.c = true;
    }

    @Override // com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService
    public final boolean d() {
        FLogger.a.i(this.a, "shouldInterceptGoToSettingsDialog: " + this.c);
        boolean r0 = this.c;
        if (r0 == false) goto L5;
        this.c = false;
    L5:
        return r0;
    }

    @Override // com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService
    public final void e() {
        this.b.b();
    }

    public ObricPrivacyAndPermissionUiServiceImpl() {
        this.a = "ObricPrivacyAndPermissionUiServiceImpl";
        this.b = new c();
    }

    @Override // com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService
    public final String a() {
        if (b.a().b() == false) goto L5;
        String r0 = AppHost.a.getApplication().getString(2131912167);
        Intrinsics.checkNotNull(r0);
        return r0;
    L5:
        String r1 = AppHost.a.getApplication().getString(2131912169);
        Intrinsics.checkNotNull(r1);
        return r1;
    }

    @Override // com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService
    public final String f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        switch(r2.hashCode()) {
            case -2062386608: goto L56;
            case -1928411001: goto L52;
            case -1921431796: goto L48;
            case -1888586689: goto L44;
            case -1446288141: goto L40;
            case -798669607: goto L37;
            case -63024214: goto L34;
            case 175802396: goto L30;
            case 603653886: goto L26;
            case 710297143: goto L23;
            case 1166454870: goto L20;
            case 1831139720: goto L16;
            case 1977429404: goto L12;
            case 2024715147: goto L9;
            case 2062356686: goto L6;
            default: goto L59;
        };
    L59:
        return null;
    L6:
        if (r2.equals("android.permission.BLUETOOTH_SCAN") == false) goto L59;
    L65:
        return AppHost.a.getApplication().getString(2131912120);
    L9:
        if (r2.equals("android.permission.ACCESS_BACKGROUND_LOCATION") == false) goto L59;
    L67:
        return AppHost.a.getApplication().getString(2131912122);
    L12:
        if (r2.equals("android.permission.READ_CONTACTS") == false) goto L59;
        return AppHost.a.getApplication().getString(2131912135);
    L16:
        if (r2.equals("android.permission.RECORD_AUDIO") == false) goto L59;
        return AppHost.a.getApplication().getString(2131912143);
    L20:
        if (r2.equals("android.permission.BLUETOOTH_ADVERTISE") == true) goto L65;
    L23:
        if (r2.equals("android.permission.READ_MEDIA_VIDEO") == false) goto L59;
    L64:
        return AppHost.a.getApplication().getString(2131912130);
    L26:
        if (r2.equals("android.permission.WRITE_CALENDAR") == false) goto L59;
        return AppHost.a.getApplication().getString(2131912175);
    L30:
        if (r2.equals("android.permission.READ_MEDIA_IMAGES") == true) goto L64;
    L34:
        if (r2.equals("android.permission.ACCESS_COARSE_LOCATION") == true) goto L67;
    L37:
        if (r2.equals("android.permission.BLUETOOTH_CONNECT") == false) goto L59;
    L40:
        if (r2.equals("com.android.permission.GET_INSTALLED_APPS") == false) goto L59;
        return AppHost.a.getApplication().getString(2131912142);
    L44:
        if (r2.equals("android.permission.ACCESS_FINE_LOCATION") == true) goto L67;
    L48:
        if (r2.equals("android.permission.READ_CALL_LOG") == false) goto L59;
        return AppHost.a.getApplication().getString(2131912133);
    L52:
        if (r2.equals("android.permission.READ_CALENDAR") == false) goto L59;
        return AppHost.a.getApplication().getString(2131912144);
    L56:
        if (r2.equals("android.permission.READ_SMS") == false) goto L59;
        return AppHost.a.getApplication().getString(2131912138);
    }

    @Override // com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService
    public final String g(String r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        switch(r3.hashCode()) {
            case -2062386608: goto L56;
            case -1928411001: goto L52;
            case -1921431796: goto L48;
            case -1888586689: goto L44;
            case -1446288141: goto L40;
            case -798669607: goto L37;
            case -63024214: goto L34;
            case 175802396: goto L30;
            case 603653886: goto L26;
            case 710297143: goto L23;
            case 1166454870: goto L20;
            case 1831139720: goto L16;
            case 1977429404: goto L12;
            case 2024715147: goto L9;
            case 2062356686: goto L6;
            default: goto L59;
        };
    L59:
        return null;
    L6:
        if (r3.equals("android.permission.BLUETOOTH_SCAN") == false) goto L59;
    L65:
        return AppHost.a.getApplication().getString(2131911976);
    L9:
        if (r3.equals("android.permission.ACCESS_BACKGROUND_LOCATION") == false) goto L59;
    L67:
        return AppHost.a.getApplication().getString(2131912240);
    L12:
        if (r3.equals("android.permission.READ_CONTACTS") == false) goto L59;
        return AppHost.a.getApplication().getString(2131912052);
    L16:
        if (r3.equals("android.permission.RECORD_AUDIO") == false) goto L59;
        return AppHost.a.getApplication().getString(2131912268);
    L20:
        if (r3.equals("android.permission.BLUETOOTH_ADVERTISE") == true) goto L65;
    L23:
        if (r3.equals("android.permission.READ_MEDIA_VIDEO") == false) goto L59;
    L64:
        return AppHost.a.getApplication().getString(2131911954);
    L26:
        if (r3.equals("android.permission.WRITE_CALENDAR") == false) goto L59;
        return AppHost.a.getApplication().getString(2131911981);
    L30:
        if (r3.equals("android.permission.READ_MEDIA_IMAGES") == true) goto L64;
    L34:
        if (r3.equals("android.permission.ACCESS_COARSE_LOCATION") == true) goto L67;
    L37:
        if (r3.equals("android.permission.BLUETOOTH_CONNECT") == false) goto L59;
    L40:
        if (r3.equals("com.android.permission.GET_INSTALLED_APPS") == false) goto L59;
        return AppHost.a.getApplication().getString(2131911962);
    L44:
        if (r3.equals("android.permission.ACCESS_FINE_LOCATION") == true) goto L67;
    L48:
        if (r3.equals("android.permission.READ_CALL_LOG") == false) goto L59;
        return AppHost.a.getApplication().getString(2131911990);
    L52:
        if (r3.equals("android.permission.READ_CALENDAR") == false) goto L59;
        return AppHost.a.getApplication().getString(2131911981);
    L56:
        if (r3.equals("android.permission.READ_SMS") == false) goto L59;
        return AppHost.a.getApplication().getString(2131912610);
    }

    @Override // com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService
    public final void b(Fragment r9, ViewStub r10, Function5<? super View, ? super String, ? super String, ? super String, ? super String, Unit> r11) {
        Intrinsics.checkNotNullParameter(r9, "host");
        Intrinsics.checkNotNullParameter(r10, "itemsStub");
        Intrinsics.checkNotNullParameter(r11, "onRequestGoSettings");
        final c r3 = this.b;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r9, "host");
        Intrinsics.checkNotNullParameter(r10, "itemsStub");
        Intrinsics.checkNotNullParameter(r11, "onRequestGoSettings");
        r3.b();
        r10.setLayoutResource(2131564049);
        ViewParent r0 = r10.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L5;
        ViewGroup r1 = (ViewGroup) r0;
    L6:
        if (r1 == null) goto L33;
        int r2 = r1.indexOfChild(r10);
        if (r2 < 0) goto L34;
        r1.removeViewAt(r2);
        int r12 = r10.getLayoutResource();
        if (r12 == 0) goto L35;
        int r4 = r1.getChildCount();
        LayoutInflater.from(r1.getContext()).inflate(r12, r1, true);
        int r13 = r1.getChildCount() - r4;
        if (r13 <= 0) goto L28;
        if (r2 >= r4) goto L28;
        ArrayList r5 = new ArrayList(r13);
        int r6 = 0;
        int r7 = 0;
    L18:
        if (r7 >= r13) goto L20;
        r5.add(r1.getChildAt(r4 + r7));
        r7 = r7 + 1;
        goto L18
    L20:
        Iterator r14 = r5.iterator();
    L22:
        if (r14.hasNext() == false) goto L24;
        r1.removeView((View) r14.next());
        goto L22
    L24:
        Iterator r15 = r5.iterator();
    L26:
        if (r15.hasNext() == false) goto L28;
        int r8 = r6 + 1;
        r1.addView((View) r15.next(), r6 + r2);
        r6 = r8;
    L28:
        r3.a = r1.findViewById(2131381181);
        r3.b = r1.findViewById(2131381166);
        r3.c = r1.findViewById(2131381247);
        r3.d = r1.findViewById(2131381165);
        r3.e = r11;
        r3.a(r3.a, "contact");
        r3.a(r3.b, "call_log");
        r3.a(r3.c, "sms");
        r3.a(r3.d, "calendar");
        Lifecycle r16 = r9.getViewLifecycleOwner().getLifecycle();
        LifecycleObserver r17 = new a(r3);
        r16.addObserver(r17);
        r3.f = r16;
        r3.g = r17;
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L5:
        r1 = null;
        goto L6
    }
}

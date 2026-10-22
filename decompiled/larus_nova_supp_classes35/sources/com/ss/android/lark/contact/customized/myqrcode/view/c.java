package com.ss.android.lark.contact.customized.myqrcode.view;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.lifecycle.Observer;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.framework.utils.ICUUtils;
import com.ss.android.lark.biz.officesdk.im.share.IOfficeSDKShareScene;
import com.ss.android.lark.contact.customized.common.OfficeContactUtils;
import com.ss.android.lark.contact.customized.databinding.ContactDbActivityMyQrcodeBinding;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.service.capacity.IOfficeAppBaseInfo;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ OfficeMyQrCodeFragment a;

    public c(OfficeMyQrCodeFragment r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r3v9, types: [android.view.ViewGroup, com.ss.android.lark.contact.customized.myqrcode.view.OfficeInviteExternalCardView, java.lang.Object] */
    public final void onChanged(Object r13) {
        i9b.a r14 = (i9b.a) r13;
        ContactDbActivityMyQrcodeBinding r1 = null;
        if ((r14 instanceof i9b.a.b) == false) goto L17;
        OfficeMyQrCodeFragment r15 = this.a;
        int r0 = OfficeMyQrCodeFragment.h;
        f r2 = r15.f;
        if (r2 == null) goto L11;
        ContactDbActivityMyQrcodeBinding r3 = r15.d;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r3 = null;
    L10:
        r3.a.removeCallbacks(r2);
        r15.f = null;
    L11:
        r15.f = new f(r15);
        ContactDbActivityMyQrcodeBinding r4 = r15.d;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L15:
        r1.a.postDelayed(r15.f, 500);
        return;
    L14:
        r1 = r4;
        goto L15
    L17:
        if ((r14 instanceof i9b.a.c) == false) goto L69;
        OfficeMyQrCodeFragment.S90(this.a);
        final OfficeMyQrCodeFragment r5 = this.a;
        m9b.a r16 = (m9b.a) ((i9b.a.c) r14).a;
        r5.T90().invalidateCardCapture();
        ContactDbActivityMyQrcodeBinding r6 = r5.d;
        if (r6 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r6 = null;
    L21:
        r6.b.setVisibility(8);
        ContactDbActivityMyQrcodeBinding r7 = r5.d;
        if (r7 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r7 = null;
    L24:
        r7.c.setVisibility(8);
        ContactDbActivityMyQrcodeBinding r8 = r5.d;
        if (r8 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r8 = null;
    L27:
        r8.g.setVisibility(0);
        ContactDbActivityMyQrcodeBinding r9 = r5.d;
        if (r9 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r9 = null;
    L30:
        r9.f.removeAllViews();
        ContactDbActivityMyQrcodeBinding r10 = r5.d;
        if (r10 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r10 = null;
    L33:
        r10.e.setOnAvatarLoadListener(new OfficeMyQrCodeFragment$renderView$1(r5));
        ContactDbActivityMyQrcodeBinding r11 = r5.d;
        if (r11 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r11 = null;
    L36:
        ?? r12 = r11.e;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r16, "model");
        mpc.e r17 = OfficeSDKManager.getHostGlobalService(mpc.e.class);     // Catch: Exception -> L43
        if (r17 == null) goto L45;
        mpc.a r18 = r17.K0();     // Catch: Exception -> L43
        if (r18 == null) goto L45;
        Drawable r19 = r18.c;     // Catch: Exception -> L43
    L46:
        if (r19 == null) goto L48;
        r12.a.g.setImageDrawable(r19);
        a r20 = new a(r19.getCallback(), r12);
        r12.getClass();
        r19.setCallback(r20);
    L58:
        ICUUtils.FormatArgsBuilder r21 = new ICUUtils.FormatArgsBuilder();
        r21.b("brandName", UIHelper.getAppName());
        r12.a.h.setText(ICUUtils.icuFormat(UIHelper.getString(2131889981), r21.a));
        r12.a.e.setText(r16.a);
        r12.a.f.setText(r16.b);
        r12.a.c.setImageBitmap(r16.e);
        int r22 = UIHelper.dp2px(96.0f);
        ListenerParams.a r23 = new ListenerParams.a();
        r23.c(ListenerParams.FromType.AVATAR);
        r23.h = new b(r12);
        ListenerParams r24 = r23.b();
        Context r25 = r12.getContext();
        LKUIRoundedImageView2 r26 = r12.a.d;
        String r27 = r16.c;
        String r110 = r16.d;
        LoadParams r28 = new LoadParams();
        r28.a = r22;
        r28.b = r22;
        r28.l = r24;
        ImageModule.a(r25, r26, r27, r110, r28);
        uza.a r111 = (uza.a) r5.g.getValue();
        ContactDbActivityMyQrcodeBinding r29 = r5.d;
        if (r29 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r29 = null;
    L61:
        View r112 = r111.d0(new uza.b(r29.a.getContext(), IOfficeSDKShareScene.MY_QR_CODE, BuildConfig.FLAVOR, BuildConfig.FLAVOR, CollectionsKt.listOf(new OfficeMyQrCodeFragment$renderSharePanel$1(r5)), null, OfficeMyQrCodeFragment$renderSharePanel$2.INSTANCE));
        if (r112 == null) goto L104;
        ContactDbActivityMyQrcodeBinding r30 = r5.d;
        if (r30 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L67:
        r1.f.addView(r112);
        return;
    L66:
        r1 = r30;
        goto L67
    L104:
        return;
    L48:
        r12.getClass();
        LKUIRoundedImageView2 r31 = r12.a.g;
        Drawable r32 = ((IOfficeAppBaseInfo) LarkContext.spiByDwarf(IOfficeAppBaseInfo.class)).getDouBaoIcon(r12.getContext());
        if (r32 != null) goto L57;
        Lazy r33 = OfficeContactUtils.a;
        Context r34 = r12.getContext();
        Intrinsics.checkNotNullParameter(r34, "context");
        Drawable r35 = ((IOfficeAppBaseInfo) OfficeContactUtils.b.getValue()).getAppIcon(r34);     // Catch: PackageManager.NameNotFoundException -> L56
        if (r35 != null) goto L55;
        r32 = r34.getPackageManager().getApplicationIcon(r34.getPackageName());     // Catch: PackageManager.NameNotFoundException -> L56
        goto L57
    L55:
        r32 = r35;
    L56:
        r32 = null;
    L57:
        r31.setImageDrawable(r32);
    L45:
        r19 = null;
    L43:
        e = move-exception;
        Log.w("Contact_InviteCardView", "main bot avatar unavailable: ".concat(e.getClass().getSimpleName()));
        goto L45
    L69:
        if ((r14 instanceof i9b.a.C0235a) == false) goto L98;
        OfficeMyQrCodeFragment.S90(this.a);
        OfficeMyQrCodeFragment r36 = this.a;
        String r113 = ((i9b.a.C0235a) r14).a;
        ContactDbActivityMyQrcodeBinding r114 = r36.d;
        if (r114 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r114 = null;
    L73:
        r114.b.setEmptyIcon(2131233634);
        ContactDbActivityMyQrcodeBinding r115 = r36.d;
        if (r115 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r115 = null;
    L76:
        r115.b.setEmptyText(UIHelper.getString(2131889966));
        ContactDbActivityMyQrcodeBinding r116 = r36.d;
        if (r116 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r116 = null;
    L79:
        r116.b.setEmptyActionText(UIHelper.getString(2131889969));
        ContactDbActivityMyQrcodeBinding r117 = r36.d;
        if (r117 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r117 = null;
    L82:
        r117.b.setVisibility(0);
        ContactDbActivityMyQrcodeBinding r118 = r36.d;
        if (r118 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r118 = null;
    L85:
        r118.d.a();
        ContactDbActivityMyQrcodeBinding r119 = r36.d;
        if (r119 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r119 = null;
    L88:
        r119.c.setVisibility(8);
        ContactDbActivityMyQrcodeBinding r120 = r36.d;
        if (r120 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r120 = null;
    L91:
        r120.g.setVisibility(8);
        ContactDbActivityMyQrcodeBinding r121 = r36.d;
        if (r121 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L95:
        r1.b.setOnActionClickListener(new e(r36));
        return;
    L94:
        r1 = r121;
        goto L95
    L98:
        throw new NoWhenBranchMatchedException();
    }
}

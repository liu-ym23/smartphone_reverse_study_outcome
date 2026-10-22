package com.ss.android.lark.officesdk.contact.impl;

import android.content.Context;
import android.content.Intent;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.contact.customized.OfficeContactPageUtils;
import com.ss.android.lark.contact.customized.myqrcode.OfficeMyQrCodeActivity;
import com.ss.android.lark.contact.customized.newcontact.OfficeNewContactActivity;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ktb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@ClaymoreImpl(c.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/officesdk/contact/impl/InnerContactOfficeImpl;", "Lcom/ss/android/lark/officesdk/contact/api/IInnerContactOfficeApi;", "<init>", "()V", "openRepository", "Lcom/ss/android/lark/officesdk/contact/api/IContactOpenRepository;", "getOpenRepository", "()Lcom/ss/android/lark/officesdk/contact/api/IContactOpenRepository;", "openRepository$delegate", "Lkotlin/Lazy;", "getContactOpenRepository", "startNewContactActivity", "", "context", "Landroid/content/Context;", "from", "", "startOfficeQrcodePage", "contact-officesdk-impl_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class InnerContactOfficeImpl implements c {
    private final Lazy openRepository$delegate;

    private final ktb.b getOpenRepository() {
        return (ktb.b) this.openRepository$delegate.getValue();
    }

    public InnerContactOfficeImpl() {
        this.openRepository$delegate = LazyKt.lazy(InnerContactOfficeImpl$openRepository$2.INSTANCE);
    }

    @Override // ktb.c
    public ktb.b getContactOpenRepository() {
        return getOpenRepository();
    }

    @Override // ktb.c
    public void startNewContactActivity(Context r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "from");
        Lazy r2 = OfficeContactPageUtils.a;
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "from");
        Intent r0 = new Intent(r4, OfficeNewContactActivity.class);
        r0.putExtra("from", r5);
        OfficeContactPageUtils.b(r4, r0);
    }

    @Override // ktb.c
    public void startOfficeQrcodePage(Context r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "from");
        Lazy r2 = OfficeContactPageUtils.a;
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "from");
        int r0 = OfficeMyQrCodeActivity.a;
        OfficeMyQrCodeActivity.a.a(r4, r5);
    }
}

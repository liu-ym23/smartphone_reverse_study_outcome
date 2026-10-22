package com.ss.android.lark.contact.customized.common.view;

import android.content.Context;
import android.util.AttributeSet;
import com.github.ybq.android.spinkit.SpinKitView;
import com.larksuite.framework.utils.UIUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xu7.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0014J\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/contact/customized/common/view/ContactOfficeLoadingView;", "Lcom/github/ybq/android/spinkit/SpinKitView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "sprite", "Lcom/github/ybq/android/spinkit/style/Circle;", "onDetachedFromWindow", BuildConfig.FLAVOR, "startLoading", "stopLoading", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContactOfficeLoadingView extends SpinKitView {
    public final b c;

    public ContactOfficeLoadingView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ContactOfficeLoadingView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a() {
        this.c.stop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        this.c.stop();
        super/*android.widget.ProgressBar*/.onDetachedFromWindow();
    }

    public ContactOfficeLoadingView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        b r5 = new b();
        this.c = r5;
        setColor(UIUtils.getColor(r2, 2131102042));
        setIndeterminateDrawable(r5);
        r5.stop();
    }

    public /* synthetic */ ContactOfficeLoadingView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

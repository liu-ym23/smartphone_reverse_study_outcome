package com.ss.android.lark.contact.base.contact_search;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.contact.base.common_ui.InvBaseFragment;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.profile.dto.ProfileFinishResult;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u0007H\u0002J\"\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/contact/base/contact_search/InviteExternalSearchFragment;", "Lcom/ss/android/lark/contact/base/common_ui/InvBaseFragment;", "<init>", "()V", "mPresenter", "Lcom/ss/android/lark/contact/base/contact_search/InviteExternalSearchPresenter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", BuildConfig.FLAVOR, "view", "initMVP", "onActivityResult", "requestCode", BuildConfig.FLAVOR, "resultCode", Keys.API_RETURN_KEY_DATA, "Landroid/content/Intent;", "onDestroy", "Companion", "contact-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InviteExternalSearchFragment extends InvBaseFragment {
    public InviteExternalSearchPresenter d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.contact.base.common_ui.InvBaseFragment
    public final void onDestroy() {
        super.onDestroy();
        InviteExternalSearchPresenter r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
        r0 = null;
    L5:
        r0.destroy();
    }

    public InviteExternalSearchFragment() {
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        InviteExternalSearchPresenter r0 = new InviteExternalSearchPresenter(this, new c(), new b0(new g0(r3, this)));
        Bundle r5 = getArguments();
        String r6 = null;
        if (r5 == null) goto L5;
        String r7 = r5.getString("invite_msg");
    L6:
        r0.a = r7;
        Bundle r8 = getArguments();
        if (r8 == null) goto L9;
        r6 = r8.getString("unique_id");
    L9:
        r0.c = r6;
        r0.create();
        this.d = r0;
        return;
    L5:
        r7 = null;
        goto L6
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r3, r4, r5);
        InviteExternalSearchPresenter r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
        r0 = null;
    L5:
        r0.getClass();
        if (r4 != (-1)) goto L16;
        if (r5 != null) goto L10;
        return;
    L10:
        if (r3 != 273) goto L17;
        ProfileFinishResult r6 = r5.getSerializableExtra("params_key_profile");
        if ((r6 instanceof ProfileFinishResult) == false) goto L14;
        b r7 = (b) r0.getView();
        r7.O5(r6);
        return;
    L14:
        Log.d("InviteExternalSearchPresenter", "profile onActivityResult : result is not ProfileFinishResult");
        return;
    L17:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561565, r3, false);
    }
}

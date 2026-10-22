package com.ss.android.lark.profile_office;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.profile.utils.IProfileLauncherV2;
import com.ss.android.lark.profile_office.userprofile.OfficeProfileActivity;
import com.ss.android.lark.profile_office.userprofile.OfficeProfileFragment;
import com.ss.android.lark.utils.ContextsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@ClaymoreImpl(IProfileLauncherV2.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JY\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/profile_office/OfficeProfileLauncherV2;", "Lcom/ss/android/lark/profile/utils/IProfileLauncherV2;", "<init>", "()V", "openUserProfileV2", "", "context", "Landroid/content/Context;", "fragment", "Landroidx/fragment/app/Fragment;", "userId", "", AppbrandHostConstants.Schema_RESERVED_FIELD.TOKEN, "chatterType", "Lcom/bytedance/lark/pb/basic/v1/Chatter$Type;", "chatId", "contactSource", "Lcom/ss/android/lark/contact/export/ContactSource;", "requestCode", "", "(Landroid/content/Context;Landroidx/fragment/app/Fragment;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/lark/pb/basic/v1/Chatter$Type;Ljava/lang/String;Lcom/ss/android/lark/contact/export/ContactSource;Ljava/lang/Integer;)V", "newUserProfileFragmentV2", "bundle", "Landroid/os/Bundle;", "Companion", "profile-office_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class OfficeProfileLauncherV2 implements IProfileLauncherV2 {
    public static final int $stable = 0;
    public static final a Companion = null;
    private static final String TAG = "OfficeProfileLauncher";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public OfficeProfileLauncherV2() {
    }

    @Override // com.ss.android.lark.profile.utils.IProfileLauncherV2
    public Fragment newUserProfileFragmentV2(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "bundle");
        int r0 = OfficeProfileFragment.k;
        Intrinsics.checkNotNullParameter(r2, "args");
        OfficeProfileFragment r1 = new OfficeProfileFragment();
        r1.setArguments(r2);
        return r1;
    }

    @Override // com.ss.android.lark.profile.utils.IProfileLauncherV2
    public void openUserProfileV2(final Context r5, Fragment r6, String r7, String r8, Chatter.Type r9, String r10, ContactSource r11, Integer r12) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r11, "contactSource");
        boolean r0 = false;
        if (r7 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L19;
        if (r8 != null) goto L12;
    L15:
        boolean r3 = true;
    L16:
        if (r3 == false) goto L19;
        Log.e(TAG, "userId and token are null");
        return;
    L12:
        if (r8.length() == 0) goto L15;
        r3 = false;
    L19:
        Bundle r4 = BundleKt.bundleOf();
        if (r7 != null) goto L22;
    L27:
        boolean r13 = false;
    L28:
        if (r13 == false) goto L30;
        r4.putString("param_key_user_id", r7);
    L31:
        if (r10 != null) goto L33;
    L38:
        if (r0 == false) goto L40;
        r4.putString("param_key_chat_id", r10);
    L40:
        if (r9 == null) goto L42;
        r4.putSerializable("param_key_chatter_type", r9);
    L42:
        r4.putSerializable("param_key_source", r11);
        final Intent r14 = new Intent(r5, OfficeProfileActivity.class);
        r14.putExtras(r4);
        final Activity r15 = ContextsKt.findActivity(r5);
        Function0<Unit> r16 = new OfficeProfileLauncherV2$openUserProfileV2$startByContext$1(r15, r14, r5);
        if (r12 == null) goto L49;
        if (r6 == null) goto L46;
        r6.startActivityForResult(r14, r12.intValue());
        return;
    L46:
        if (r15 == null) goto L48;
        r15.startActivityForResult(r14, r12.intValue());
        return;
    L48:
        r16.invoke();
        return;
    L49:
        r16.invoke();
        return;
    L33:
        if (r10.length() <= 0) goto L35;
        boolean r17 = true;
    L36:
        if (r17 != true) goto L38;
        r0 = true;
        goto L38
    L35:
        r17 = false;
        goto L36
    L30:
        r4.putString("param_key_token", r8);
        goto L31
    L22:
        if (r7.length() <= 0) goto L24;
        boolean r18 = true;
    L25:
        if (r18 != true) goto L27;
        r13 = true;
        goto L28
    L24:
        r18 = false;
        goto L25
    L5:
        if (r7.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}

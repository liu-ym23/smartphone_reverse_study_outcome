package com.larus.profile.impl.view;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.common_ui.image.CustomPhotoViewerDialog;
import com.larus.common_ui.photoviewer.PhotoViewerDialog;
import com.larus.platform.api.IFlowProfileThemeConfigProvider;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.trace.tracknode.a$a;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0011\u001a\u00020\u0006H\u0016J\r\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\fH\u0002R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/profile/impl/view/ProfileAvatarViewerDialog;", "Lcom/larus/bmhome/common_ui/image/CustomPhotoViewerDialog;", "Lcom/larus/trace/tracknode/IFlowPageTrackNode;", "activity", "Landroidx/fragment/app/FragmentActivity;", "avatarUrl", "", "enterFrom", "canEditProfile", "", "editProfileClickListener", "Lkotlin/Function0;", "", "<init>", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "editProfileView", "Landroid/widget/TextView;", "getCurrentPageName", "getExtraViewLayout", "", "()Ljava/lang/Integer;", "show", "logEnterPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ProfileAvatarViewerDialog extends CustomPhotoViewerDialog implements com.larus.trace.tracknode.a {
    public static final /* synthetic */ int r = 0;
    public final String q;

    public static final class a {
    }

    static {
    }

    public ProfileAvatarViewerDialog() {
        throw null;
    }

    public final boolean et() {
        return false;
    }

    public final String k() {
        return "profile_photo_self";
    }

    public final by7.e parentTrackNode() {
        return null;
    }

    public final void te() {
    }

    public final Integer g() {
        return 2131562903;
    }

    public final by7.e referrerTrackNode() {
        return by7.e.a.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("page", "profile_photo");
        r1.put("enter_from", this.q);
        Unit r2 = Unit.INSTANCE;
        r0.reportEvent("enter_page", r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super/*android.app.Dialog*/.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void i(ProfileAvatarViewerDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final void fillTrackParams(TrackParams r1) {
        a$a.a(this, r1);
    }

    public ProfileAvatarViewerDialog(FragmentActivity r2, String r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "avatarUrl");
        Intrinsics.checkNotNullParameter(r4, "enterFrom");
        super(r2, CollectionsKt.listOf(new n1(r3)));
        this.q = r4;
        TextView r6 = (TextView) ((PhotoViewerDialog) this).c.findViewById(2131371455);
        if (r6 == null) goto L8;
        if (r5 == false) goto L6;
        int r7 = 0;
    L7:
        r6.setVisibility(r7);
        goto L8
    L6:
        r7 = 8;
    L8:
        if (r6 == null) goto L10;
        final Function0 r8 = null;
        e1.d(r6, new e(this, r8));
    L10:
        IFlowProfileThemeConfigProvider r9 = (IFlowProfileThemeConfigProvider) ServiceManager.get().getService(IFlowProfileThemeConfigProvider.class);
        if (r9 == null) goto L14;
        r9.b(r6, AdaptThemeFeatureKey.PROFILE_AVATAR_OVERVIEW_EDIT_INFO);
        return;
    }
}

package com.larus.bmhome.bot.dialog;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.common_ui.image.CustomPhotoViewerDialog;
import com.larus.common_ui.photoviewer.PhotoViewerDialog;
import com.larus.platform.service.o;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0001'BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u001f\u001a\u00020\fH\u0002J\u0016\u0010 \u001a\u00020\f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\r\u0010\"\u001a\u00020#H\u0016¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\fH\u0016J\b\u0010&\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/bmhome/bot/dialog/BotAvatarViewerDialog;", "Lcom/larus/bmhome/common_ui/image/CustomPhotoViewerDialog;", "activity", "Landroidx/fragment/app/FragmentActivity;", "avatarUrl", "", "canEditAvatar", "", "autoLogEnterPage", "from", "uploadPicClickListener", "Lkotlin/Function0;", "", "autoGenBtnClickListener", "<init>", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;ZZLjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getAvatarUrl", "()Ljava/lang/String;", "getCanEditAvatar", "()Z", "getAutoLogEnterPage", "getFrom", "getUploadPicClickListener", "()Lkotlin/jvm/functions/Function0;", "getAutoGenBtnClickListener", "changeAvatarBtn", "Landroid/widget/TextView;", "actionSheet", "Landroid/view/ViewGroup;", "autoGenBtn", "uploadPicBtn", "showAvatarPromptInput", "checkRecordPermission", "doNext", "getExtraViewLayout", "", "()Ljava/lang/Integer;", "show", "logEnterPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BotAvatarViewerDialog extends CustomPhotoViewerDialog {
    public static final /* synthetic */ int y = 0;
    public final FragmentActivity q;
    public final boolean r;
    public final String s;
    public final Function0<Unit> t;
    public final Function0<Unit> u;
    public final ViewGroup v;
    public final ViewGroup w;
    public final ViewGroup x;

    public static final class a {
    }

    static {
    }

    public final Integer g() {
        if (z2.a.createBotAutoFillEnable() == false) goto L5;
        int r0 = 2131562828;
    L7:
        return Integer.valueOf(r0);
    L5:
        r0 = 2131562748;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(this);
    L8:
        if (this.r == false) goto L17;
        o r0 = o.a;
        JSONObject r1 = new JSONObject();
        r1.put("page", "bot_photo");
        if (o0.d(this.s) == false) goto L12;
        r1.put("enter_from", this.s);
    L12:
        Unit r2 = Unit.INSTANCE;
        r0.reportEvent("enter_page", r1);
        return;
    L17:
        return;
    L15:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L6:
        DialogLancet.beforeDialogShow(this);
        super/*android.app.Dialog*/.show();
        DialogLancet.afterDialogShow(this);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void i(BotAvatarViewerDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public BotAvatarViewerDialog(FragmentActivity r3, String r4, boolean r5, boolean r6, String r7, Function0<Unit> r8, Function0<Unit> r9) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "avatarUrl");
        int r1 = 0;
        if (r4.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        List r10 = CollectionsKt.listOf(new n1(r4));
    L9:
        super(r3, r10);
        this.q = r3;
        this.r = r6;
        this.s = r7;
        this.t = r8;
        this.u = r9;
        if (z2.a.createBotAutoFillEnable() == false) goto L21;
        ViewGroup r11 = (ViewGroup) ((PhotoViewerDialog) this).c.findViewById(2131373617);
        this.v = r11;
        ViewGroup r12 = (ViewGroup) ((PhotoViewerDialog) this).c.findViewById(2131363601);
        this.w = r12;
        ViewGroup r13 = (ViewGroup) ((PhotoViewerDialog) this).c.findViewById(2131391933);
        this.x = r13;
        if (r11 == null) goto L17;
        if (r5 == true) goto L16;
        r1 = 8;
    L16:
        r11.setVisibility(r1);
    L17:
        if (r12 == null) goto L19;
        e1.d(r12, new b(this));
    L19:
        if (r13 == null) goto L29;
        e1.d(r13, new c(this));
    L29:
        if (r5 == true) goto L39;
        View r14 = ((CustomPhotoViewerDialog) this).p;
        if (r14 == null) goto L40;
        ((PhotoViewerDialog) this).c.removeView(r14);     // Catch: Exception -> L34
        return;
    L34:
        e = move-exception;
        FLogger.a.i("BotAvatarViewerDialog", "remove extraView error=" + e.getMessage());
        return;
    L40:
        return;
    L39:
        return;
    L21:
        TextView r15 = (TextView) ((PhotoViewerDialog) this).c.findViewById(2131391914);
        if (r15 == null) goto L24;
        r15.setOnClickListener(new d(this));
    L24:
        if (r15 == null) goto L29;
        if (r5 == true) goto L28;
        r1 = 8;
    L28:
        r15.setVisibility(r1);
        goto L29
    L8:
        r10 = CollectionsKt.listOf(new n1(new Uri.Builder().scheme("res").path(String.valueOf(2131240119)).build().toString()));
        goto L9
    L5:
        r0 = false;
        goto L6
    }
}

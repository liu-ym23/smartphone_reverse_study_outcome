package com.larus.bmhome.bot.dialog;

import android.net.Uri;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.bot.y1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.common_ui.image.CustomPhotoViewerDialog;
import com.larus.common_ui.photoviewer.PhotoViewerDialog;
import com.larus.platform.service.o;
import com.larus.utils.e1;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u0017\u001a\u00020\u0018H\u0016¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u000bH\u0016J\b\u0010\u001b\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/bot/dialog/BotAvatarViewerCanChangeIconDialog;", "Lcom/larus/bmhome/common_ui/image/CustomPhotoViewerDialog;", "activity", "Landroidx/fragment/app/FragmentActivity;", "avatarUrl", "", "autoLogEnterPage", "", "from", "gotoChangeAppIconPageListener", "Lkotlin/Function0;", "", "<init>", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;ZLjava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getAvatarUrl", "()Ljava/lang/String;", "getAutoLogEnterPage", "()Z", "getFrom", "getGotoChangeAppIconPageListener", "()Lkotlin/jvm/functions/Function0;", "setAppIconBtn", "Landroid/view/ViewGroup;", "getExtraViewLayout", "", "()Ljava/lang/Integer;", "show", "logEnterPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BotAvatarViewerCanChangeIconDialog extends CustomPhotoViewerDialog {
    public static final /* synthetic */ int u = 0;
    public final boolean q;
    public final String r;
    public final Function0<Unit> s;
    public final ViewGroup t;

    public static final class a {
    }

    static {
    }

    public final Integer g() {
        return 2131562885;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(this);
    L8:
        if (this.q == false) goto L17;
        o r0 = o.a;
        JSONObject r1 = new JSONObject();
        r1.put("page", "bot_photo");
        if (o0.d(this.r) == false) goto L12;
        r1.put("enter_from", this.r);
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

    public BotAvatarViewerCanChangeIconDialog(FragmentActivity r3, String r4, y1 r5) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "avatarUrl");
        if (r4.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        List r6 = CollectionsKt.listOf(new n1(r4));
    L9:
        super(r3, r6);
        this.q = true;
        this.r = "bot_setting";
        this.s = r5;
        ViewGroup r7 = (ViewGroup) ((PhotoViewerDialog) this).c.findViewById(2131373831);
        this.t = r7;
        if (r7 == null) goto L13;
        e1.d(r7, new com.larus.bmhome.bot.dialog.a(this));
        return;
    L13:
        return;
    L8:
        r6 = CollectionsKt.listOf(new n1(new Uri.Builder().scheme("res").path(String.valueOf(2131240119)).build().toString()));
        goto L9
    L5:
        r0 = false;
        goto L6
    }
}

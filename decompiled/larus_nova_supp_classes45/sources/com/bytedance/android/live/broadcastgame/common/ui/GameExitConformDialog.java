package com.bytedance.android.live.broadcastgame.common.ui;

import android.content.Context;
import com.bytedance.android.live.broadcastgame.api.interactgame.h;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.common.BottomConfirmAlertDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/common/ui/GameExitConformDialog;", "Lcom/bytedance/android/livesdk/common/BottomConfirmAlertDialog;", "Lcom/bytedance/android/live/broadcastgame/api/interactgame/h;", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameExitConformDialog extends BottomConfirmAlertDialog implements h {
    public final String d;

    public static final class a {
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565405;
    }

    public final void show() {
        ALogger.i("GameExitConformDialog", "show exit dialog from " + this.d);
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(this);
        super/*com.bytedance.android.livesdk.widget.CommonBottomDialog*/.show();
        DialogLancet.afterDialogShow(this);
    }

    public GameExitConformDialog(Context r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "from");
        super(r4, s1.B(2131916767), s1.B(2131916766), s1.B(2131916765));
        this.d = r5;
    }
}

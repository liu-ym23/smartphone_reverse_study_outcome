package ui8;

import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.second.SecondChatListFragment;
import com.larus.common.apphost.AppHost;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d extends ClickableSpan {
    public final /* synthetic */ SecondChatListFragment a;

    public d(SecondChatListFragment r1) {
        this.a = r1;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r4) {
        Intrinsics.checkNotNullParameter(r4, "widget");
        SecondChatListFragment r5 = this.a;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        Intent r1 = new Intent("android.intent.action.VIEW", UriProtector.parse(AppHost.a.d()));     // Catch: Throwable -> L9
        FragmentActivity r6 = r5.getActivity();     // Catch: Throwable -> L9
        if (r6 == null) goto L6;
        r6.startActivity(r1);     // Catch: Throwable -> L9
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.constructor-impl(r7);     // Catch: Throwable -> L9
        return;
    L6:
        r7 = null;
    L9:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r5) {
        Intrinsics.checkNotNullParameter(r5, "ds");
        super.updateDrawState(r5);
        r5.setUnderlineText(true);
        Context r0 = this.a.getContext();
        if (r0 != null) goto L5;
        r0 = AppHost.a.getApplication();
    L5:
        r5.setColor(ContextCompat.getColor(r0, v19.c.b(2130972079, this.a.getContext(), 2131103136)));
    }
}

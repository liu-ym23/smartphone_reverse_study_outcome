package fda;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.layout.widget.w0;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.component.skill.ObricUserTextCellInteractiveSpanComponent;
import com.obric.assistant.obric_action.IObricActionService;
import com.obric.assistant.obric_action.c;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b extends w0 {
    public final /* synthetic */ String c;
    public final /* synthetic */ ObricUserTextCellInteractiveSpanComponent d;
    public final /* synthetic */ String e;
    public final /* synthetic */ TextView f;

    /* JADX WARN: Type inference failed for: r3v1, types: [fda.a] */
    public final void onClick(View r7) {
        Intrinsics.checkNotNullParameter(r7, "widget");
        String r0 = this.c;
        if (r0 == null) goto L23;
        final ObricUserTextCellInteractiveSpanComponent r1 = this.d;
        String r2 = this.e;
        int r3 = ObricUserTextCellInteractiveSpanComponent.i;
        r1.getClass();
        ?? r4 = new a(r1);
        if ((!StringsKt.isBlank(r0)) == true) goto L21;
        r4.invoke();
        return;
    L21:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L14
        IObricActionService r6 = c.a();     // Catch: Throwable -> L14
        String r8 = null;
        if (r6 == null) goto L12;
        Context r9 = r7.getContext();     // Catch: Throwable -> L14
        IObricActionService r10 = c.a();     // Catch: Throwable -> L14
        if (r10 == null) goto L11;
        r8 = r10.c("obric_skill_detail", r2);     // Catch: Throwable -> L14
    L11:
        r6.d(r9, r0, r8);     // Catch: Throwable -> L14
        r8 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L12:
        Object r11 = Result.constructor-impl(r8);     // Catch: Throwable -> L14
    L16:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L24;
        r4.invoke();
        FLogger.a.w("ObricUserTextCellInteractiveSpanComponent", "openSkillPage by obric intent failed, routeUrl=".concat(r0), r12);
        return;
    L24:
        return;
    L14:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    public final void updateDrawState(TextPaint r3) {
        Intrinsics.checkNotNullParameter(r3, "ds");
        r3.setColor(ContextCompat.getColor(this.f.getContext(), 2131103298));
        r3.setUnderlineText(true);
    }

    public b(String r1, ObricUserTextCellInteractiveSpanComponent r2, String r3, CustomMarkdownTextView r4) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
        this.f = r4;
        super(null, null);
    }
}

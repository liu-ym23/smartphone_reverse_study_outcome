package l2b;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import h7b.n;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends n {
    public final /* synthetic */ Function1<Chatter, Unit> c;
    public final /* synthetic */ ChatChatter d;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        Function1<Chatter, Unit> r3 = this.c;
        if (r3 == null) goto L6;
        r3.invoke(this.d);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(int r1, Function1<? super Chatter, Unit> r2, ChatChatter r3, FragmentActivity r4) {
        this.c = r2;
        this.d = r3;
        super(r4, r1);
    }
}

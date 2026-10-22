package c3b;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.utils.k;
import com.ss.android.lark.dto.chat.ProfileSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements mcc.b {
    public final Chat a;
    public final Context b;

    public final boolean c(View r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "text");
        Intrinsics.checkNotNullParameter(r4, "userId");
        return false;
    }

    public final Context getContext() {
        return this.b;
    }

    public c(Chat r2, Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r2;
        this.b = r3;
    }

    public final void d(View r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "text");
        Intrinsics.checkNotNullParameter(r4, "userId");
        ProfileSource.a r5 = new ProfileSource.a();
        r5.e = r4;
        Chat r6 = this.a;
        if (r6 == null) goto L5;
        String r7 = r6.getId();
    L6:
        r5.d = r7;
        r5.b = 1;
        r5.c = k.a(this.a);
        ProfileSource r8 = r5.a();
        ChatCoreModule.a().getProfileDependency().e(this.b, r8);
        return;
    L5:
        r7 = null;
        goto L6
    }
}

package com.larus.bmhome.instruction.helper;

import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface f {

    public static final class a {
        public static /* synthetic */ void a(f r0, FragmentActivity r1, int r2) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            r0.a(r1, false, 0);
        }
    }

    void a(FragmentActivity r1, boolean r2, int r3);

    void b(Function1<? super Uri, Unit> r1);

    void c(Function1<? super List<? extends Uri>, Unit> r1);

    void onDestroy();
}

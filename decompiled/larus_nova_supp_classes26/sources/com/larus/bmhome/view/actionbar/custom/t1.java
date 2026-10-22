package com.larus.bmhome.view.actionbar.custom;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.bmhome.actionbar.model.ReplyOption;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface t1 {

    public static final class a {
        public static /* synthetic */ void a(t1 r7, com.larus.bmhome.actionbar.model.z0 r8, int r9, Boolean r10, View r11, boolean r12) {
            r7.b(r8, r9, r10, r11, r12, null);
        }
    }

    String a();

    void b(com.larus.bmhome.actionbar.model.z0 r1, int r2, Boolean r3, View r4, boolean r5, aq8.e r6);

    kotlinx.coroutines.flow.i1<Boolean> c(String r1);

    void d(View r1, ImageView r2, TextView r3, com.larus.bmhome.actionbar.model.z0 r4);

    LifecycleCoroutineScope e();

    int f();

    ReplyOption g(com.larus.bmhome.actionbar.model.z0 r1);
}

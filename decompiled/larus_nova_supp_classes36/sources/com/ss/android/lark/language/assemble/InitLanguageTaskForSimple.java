package com.ss.android.lark.language.assemble;

import android.app.Application;
import android.content.Context;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.larksuite.framework.utils.Reflect;
import com.ss.android.lark.language.service.impl.a;
import java.util.Locale;
import yob.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class InitLanguageTaskForSimple extends AbstractLaunchTask {
    public InitLanguageTaskForSimple() {
    }

    public final void a(Context r6) {
        if ((r6 instanceof Application) == false) goto L6;
        Application r7 = (Application) r6;
        e.a().getClass();
        int r0 = a.f;
        Context r1 = a.b.a.i(r7.getBaseContext(), new Locale("zh", "cn"));
        new Reflect(r7).i("mBase", r1);
        return;
    }
}
